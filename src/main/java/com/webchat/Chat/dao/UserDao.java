package com.webchat.Chat.dao;

import com.webchat.Chat.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
