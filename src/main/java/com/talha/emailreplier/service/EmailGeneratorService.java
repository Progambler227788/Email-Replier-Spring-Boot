package com.talha.emailreplier.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talha.emailreplier.entities.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;


    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    private final WebClient webClient;

    public EmailGeneratorService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public  String generateEmailReply(EmailRequest emailRequest){
        // build a prompt, craft request, doing request and getting response and
        // build a prompt
        String prompt = generatePrompt(emailRequest);
        // craft a request

        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {

                Map.of("parts", new Object[]
                        {
                Map.of("text", prompt)
                      })

} );

        // doing request and get response
        String response = webClient.post().uri(geminiApiUrl+geminiApiKey).
                header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // then displaying the response back to user
   return getResponse(response);

    }

    private String getResponse(String response) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            // it will return json as a tree and then we can navigate from json
            JsonNode rootNode = mapper.readTree(response);


            // candidates --> array first item content then inside it there is parts as a key
            // then fetch the value of parts and first value of it and then text
            return rootNode.path("candidates").get(0)
                    .path("content").path("parts").get(0)
                    .path("text").asText();

        }
        catch(Exception e){
            return  "Error processing request: " + e.getMessage();

        }
    }

    private String generatePrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("Generate a professional email for the following response. Don't generate a subject line");
        if (emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()){

            prompt.append("Use this tone for reply " + emailRequest.getTone());

        }

        prompt.append("\nOriginal Email Content: \n").append(emailRequest.getEmailContent());

        return  prompt.toString();


    }
}
