package com.topic.exchange.consumertwo.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageConsumerTwo implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumerTwo.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message) {

        try {
            String msgTwo = objectMapper.readValue(message.getBody(), String.class);
            LOGGER.info("consumer Two msg:::{}", msgTwo);

        } catch (IOException e) {
            LOGGER.error("method=onMessage message=dataOrApplicationError", e);
        }

    }
}
