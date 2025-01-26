package com.talha.emailreplier.controllers;


import com.talha.emailreplier.entities.EmailRequest;
import com.talha.emailreplier.service.EmailGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// url for hitting --> https://localhost:8080/api/email/generate
@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailGeneratorController {

    private final  EmailGeneratorService emailGeneratorService;



    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest reqObject){
        String response = emailGeneratorService.generateEmailReply(reqObject);
        return  ResponseEntity.ok(response);
    }
}
