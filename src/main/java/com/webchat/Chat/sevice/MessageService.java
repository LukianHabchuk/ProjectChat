package com.webchat.Chat.sevice;

import com.webchat.Chat.dao.MessageDao;
import com.webchat.Chat.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public List<Message> getMessageList(){
        List<Message> messages = new ArrayList<>();
        this.messageDao.findAll().forEach(messages::add);
        return messages;
    }

    public Message getMessage(Long id){
        return this.messageDao.findById(id).get();
    }

    public void addMessage(Message message){
        this.messageDao.save(message);
    }

    public void updateMessage(Message message, Model m){
        if(message!=null){
            this.messageDao.save(message);
            m.addAttribute("message",message);
        }
    }

    public void deleteMessage(Long id){
        this.messageDao.deleteById(id);
    }

}
