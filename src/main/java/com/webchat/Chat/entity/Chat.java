package com.webchat.Chat.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<Message> messageList;
    private List<User> userList;

    public Chat() {
    }

    public Chat(List<Message> messageList, List<User> userList) {
        this.messageList = messageList;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
