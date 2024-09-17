package th.co.priorsolution.project.wonderlandconsumer.component.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import th.co.priorsolution.project.wonderlandconsumer.service.UserService;

@Slf4j
@Component
public class KafkaConsumerComponent {

    private UserService userService;

    public KafkaConsumerComponent(UserService userService) {
        this.userService = userService;
    }

    @KafkaListener(topics = "${kafka.topics.regist}", groupId = "${kafka.groupid.regist}")
    public void consumeMessage(@Payload String message) throws Exception {
        log.info("factory got message got {}", message);

        this.userService.createUserByNativeSql(message);
    }

}
