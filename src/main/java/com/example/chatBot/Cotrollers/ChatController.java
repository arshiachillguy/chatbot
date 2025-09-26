package com.example.chatBot.Cotrollers;

import com.example.chatBot.Models.ChatRequest;
import com.example.chatBot.Models.ChatResponse;
import com.example.chatBot.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ChatController {

    @Autowired
    public ChatService chatService;

//    @Autowired
//    public ChatRequest chatRequest;
//
//    @Autowired
//    public ChatResponse chatResponse;


    @PostMapping("api/chat")
    public ChatResponse postRequest(ChatRequest request){
       String userMassage = request.getMessage();
       String responseBOT = chatService.generateResponse(userMassage);

       ChatResponse response = new ChatResponse();
       response.setResponse(responseBOT);
       response.setTimestamp(LocalDateTime.now().toString());
       return response;
    }

}
