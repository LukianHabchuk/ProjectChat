package com.webchat.Chat.sevice;

import com.webchat.Chat.dao.ChatDao;
import com.webchat.Chat.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatDao chatDao;

    public List<Chat> getChatList(){
        List<Chat> messages = new ArrayList<>();
        this.chatDao.findAll().forEach(messages::add);
        return messages;
    }

    public Chat getChat(Long id){
        return this.chatDao.findById(id).get();
    }

    public void addChat(Chat chat){
        this.chatDao.save(chat);
    }

    public void updateChat(Chat chat, Model m){
        if(chat!=null){
            this.chatDao.save(chat);
            m.addAttribute("chat",chat);
        }
    }

    public void deleteChat(Long id){
        this.chatDao.deleteById(id);
    }

}
