package com.webchat.Chat.dao;

import com.webchat.Chat.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageDao extends CrudRepository<Message, Long> {
}
