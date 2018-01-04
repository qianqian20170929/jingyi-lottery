package com.hackx.controller;

import com.hackx.entity.RequestMessageEntity;
import com.hackx.entity.ResponseMessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
@Controller
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseMessageEntity greetings(RequestMessageEntity requestMessage) throws Exception {
        Thread.sleep(1000); // simulated delay
        logger.info("request message:" + requestMessage.getRequestMessage());
        return new ResponseMessageEntity("welcome," + requestMessage.getRequestMessage() + " !");
    }
}
