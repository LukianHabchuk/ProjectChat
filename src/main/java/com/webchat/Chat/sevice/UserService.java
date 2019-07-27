package com.webchat.Chat.sevice;

import com.webchat.Chat.dao.UserDao;
import com.webchat.Chat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        this.userDao.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id){
        return this.userDao.findById(id).get();
    }

    public void addUser(User user){
        this.userDao.save(user);
    }

    public void updateUser(Long id, String name, String surName, String login, String password, String icon, Model model){
        User user = userDao.findById(id).get();
        if(!name.isEmpty()) user.setName(name);
        if(!surName.isEmpty()) user.setSurname(surName);
        if(!login.isEmpty()) user.setLogin(login);
        if(!password.isEmpty()) user.setPassword(password);
        if(!icon.isEmpty()) user.setIcon(icon);
        this.userDao.save(user);
        model.addAttribute("user",user);
    }

    public void updatePassword(Long id, String password){
        User user = this.userDao.findById(id).get();
        user.setPassword(password);
        this.userDao.save(user);
    }

    public void deleteUser(Long id){
        this.userDao.deleteById(id);
    }

}
