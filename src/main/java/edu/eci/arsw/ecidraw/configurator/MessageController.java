package edu.eci.arsw.ecidraw.configurator;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(final Message message) {
        return null;
    }
}
