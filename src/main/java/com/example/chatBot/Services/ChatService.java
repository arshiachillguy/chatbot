package com.example.chatBot.Services;

import org.springframework.stereotype.Service;

@Service
public class ChatService {


    public String generateResponse(String message) {
        if (message == null || message.trim().isEmpty()) {
            return "پیام خالی دریافت شد";
        }
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
        }else if (message.contains("قیمت دلار")){
            return "نمیدونم";
        }else if (message.contains("قیمت طلا")){
            return "نمیدونم";
        }else if (message.contains("بازی")) {
            return "ندارم که";
        }else if (message.contains("پس به چه دردی میخوری")){
            return "هیچی حقیقتا ";
        }
        else return "پیامت شناسایی نشد !!!!";
    }




}
