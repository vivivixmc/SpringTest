package com.example.tviter.repos;

import com.example.tviter.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagesRepo extends CrudRepository<Message, String> {
    List<Message> findByTag(String tag);
}
