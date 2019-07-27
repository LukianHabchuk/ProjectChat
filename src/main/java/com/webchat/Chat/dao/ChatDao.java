package com.webchat.Chat.dao;

import com.webchat.Chat.entity.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatDao extends CrudRepository<Chat, Long> {
}
