package com.example.chatBot.Controllers;

import com.example.chatBot.Models.ChatRequest;
import com.example.chatBot.Models.ChatResponse;
import com.example.chatBot.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@CrossOrigin(origins = "*") // برای Postman و تست وب
public class ChatController {

    @Autowired
    private ChatService chatService;

    // صفحه وب ساده برای تست
    @GetMapping("/v1")
    public String startweb(Model model) {
        model.addAttribute("chatRequestForm", new ChatRequest());
        model.addAttribute("response", ""); // پاسخ اولیه خالی
        return "page"; // اشاره به page.html
    }

    // API برای Postman (پاسخ JSON)
    @PostMapping(value = "/api/chat", consumes = "application/json")
    @ResponseBody
    public ChatResponse postRequest(@RequestBody ChatRequest request) {
        System.out.println("درخواست API دریافتی: " + request);
        System.out.println("پیام دریافتی: " + (request != null ? request.getMessage() : "null"));

        if (request == null || request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            ChatResponse errorResponse = new ChatResponse();
            errorResponse.setResponse("پیام خالی دریافت شد");
            errorResponse.setTimestamp(LocalDateTime.now().toString());
            return errorResponse;
        }

        String userMessage = request.getMessage();
        String responseBOT = chatService.generateResponse(userMessage);
        ChatResponse response = new ChatResponse();
        response.setResponse(responseBOT);
        response.setTimestamp(LocalDateTime.now().toString());
        return response;
    }

    // برای پردازش فرم وب
    @PostMapping(value = "/api/chat", consumes = "application/x-www-form-urlencoded")
    public String handleChatForm(@ModelAttribute("chatRequestForm") ChatRequest request, Model model) {
        System.out.println("درخواست فرم دریافتی: " + request);
        System.out.println("پیام فرم: " + (request != null ? request.getMessage() : "null"));

        if (request == null || request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            model.addAttribute("response", "پیام خالی دریافت شد");
        } else {
            String responseBOT = chatService.generateResponse(request.getMessage());
            model.addAttribute("response", responseBOT);
        }
        model.addAttribute("chatRequestForm", new ChatRequest()); // برای فرم بعدی
        return "page"; // اشاره به page.html
    }
}