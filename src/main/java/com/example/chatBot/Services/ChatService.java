package com.example.chatBot.Services;

import org.springframework.stereotype.Service;

@Service
public class ChatService {


    public String generateResponse(String message) {
        if (message.contains("سلام")) {
            return "سلام و درود !";
        } if (message.contains("هوا")) {
            return "هواشناسی بلد نیستم. ";
        } if (message.contains("خوبی")) {
            return "ممنون شما چطوری ";
        } if (message.contains("چی بلدی ؟")) {
            return "هیچی فعلا ";
        }else if (message.contains("ماشین حساب")){
            return "فعلا همچین قابلیتی ندارم";
        } else return "پیامت شناسایی نشد !!";
    }




}
