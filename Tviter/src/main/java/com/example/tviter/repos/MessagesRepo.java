package com.example.tviter.repos;

import com.example.tviter.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepo extends CrudRepository<Message, Integer> {

}
