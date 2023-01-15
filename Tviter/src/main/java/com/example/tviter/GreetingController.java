package com.example.tviter;

import com.example.tviter.domain.Message;
import com.example.tviter.repos.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
    public class GreetingController {

        @Autowired
        private MessagesRepo messagesRepo;

        @GetMapping(path = "/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
        String name, Map<String, Object> model) {
            model.put("name", name);
            return "greeting";
        }

        @GetMapping(path = "/")
        public String main(Map<String, Object> model) {
            Iterable<Message> messages = messagesRepo.findAll();
            model.put("messages", messages);
            return "main";
        }

        @PostMapping(path = "/")
        public String add(@RequestParam(required = true) String text, @RequestParam(required=false) String tag, Map<String, Object> model){
            Message message = new Message(text,tag);
            messagesRepo.save(message);
            return "main";
        }

        @PostMapping("filter")
        public String filter(@RequestParam(required=false) String filter, Map<String, Object> model){
            Iterable<Message> messages;
            if (filter != null && !filter.isEmpty()){
                messages = messagesRepo.findByTag(filter);
            } else {
                messages = messagesRepo.findAll();
            }
            model.put("messages", messages);

            return "main";
    }

    }
