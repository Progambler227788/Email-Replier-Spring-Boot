# ✉️ Email Reply Generator  

A **Spring Boot application** that generates professional email replies based on user-provided content and tone. Perfect for creating tailored and polished email responses effortlessly using the **Gemini API**.

---

## 🌟 Features  

- **Dynamic Reply Generation**: Craft professional replies in seconds.  
- **Customizable Tone**: Generate responses with a tone that matches your style (e.g., formal, polite, friendly).  
- **Gemini API Integration**: Powered by advanced AI text generation.  
- **RESTful API**: Easy-to-use `/generate` endpoint for seamless integration.  

---

## 🚀 Tech Stack  

- **Java**: Core language for implementation.  
- **Spring Boot**: Framework for building and managing the backend.  
- **WebClient**: For making HTTP requests to external APIs.  
- **Jackson**: For handling JSON data efficiently.  

---

## ⚙️ How It Works  

1. **User Input**:  
   - Provide the original email content and the desired tone.  
2. **Prompt Generation**:  
   - A custom prompt is dynamically created based on your input.  
3. **Gemini API Request**:  
   - The application sends the generated prompt to the Gemini API.  
4. **Response Parsing**:  
   - The response is processed to extract the generated email reply.  

---

## 🧑‍💻 Getting Started  

### 1. Clone the Repository  

```bash
git clone https://github.com/yourusername/email-reply-generator.git
cd email-reply-generator
```

### 2. Configure the Application  

Add your **Gemini API Key** and **API URL** in the `application.properties` file:

```properties
gemini.api.key=YOUR_GEMINI_API_KEY
gemini.api.url=YOUR_GEMINI_API_URL
```

### 3. Build and Run the Application  

```bash
./mvnw spring-boot:run
```

### 4. Use the `/generate` Endpoint  

#### Request:  
**URL**: `http://localhost:8080/api/email/generate`  
**Method**: `POST`  
**Body**:  

```json
{
  "emailContent": "Can we reschedule our meeting?",
  "tone": "polite"
}
```

#### Response:  
```json
{
  "reply": "Certainly! I appreciate your time and flexibility. Please let me know your availability, and I will do my best to accommodate."
}
```

---

## 🌟 Example  

### Input:  
- **Email Content**: *"Can you share the project status update by EOD?"*  
- **Tone**: *Formal*  

### Output:  
*"Thank you for your message. I will ensure the project status update is shared with you by the end of the day. Please let me know if there’s anything specific you’d like included."*

---

## 📂 Project Structure  

```
src
├── main
│   ├── java
│   │   ├── com.talha.emailreplier
│   │   │   ├── controllers
│   │   │   │   └── EmailGeneratorController.java
│   │   │   ├── entities
│   │   │   │   └── EmailRequest.java
│   │   │   ├── service
│   │   │   │   └── EmailGeneratorService.java
│   ├── resources
│   │   ├── application.properties
```

---

## 🌱 Future Enhancements  

- Add support for **multiple languages**.  
- Enhance the tone generation logic for more personalized replies.  
- Integrate with email providers (e.g., Gmail, Outlook) for end-to-end automation.  

---

## 💡 Contributing  

Contributions are welcome! To contribute:  

1. Fork the repository.  
2. Create a new branch: `git checkout -b feature-name`.  
3. Make your changes and commit: `git commit -m "Add some feature"`.  
4. Push to the branch: `git push origin feature-name`.  
5. Submit a pull request.  

---


## 💬 Feedback  

If you have any feedback, please feel free to open an issue or contact me at **[your-email@example.com](mailto:your-email@example.com)**.
