package com.mati.mati.processor;

import com.mati.mati.client.CommunicationClient;
import com.mati.mati.model.NotificationRequest;
import com.mati.mati.queue.NotificationQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class SchedulerBasedNotificationProcessor implements NotificationProcessor {

    private final NotificationQueue notificationQueue;
    private final List<CommunicationClient> communicationClients;


    @Scheduled(fixedRate = 500)
    public void process() {
        if (notificationQueue.isNewNotification()) {
            var notification = notificationQueue.getNotification();
            communicationClients.stream().filter(c -> c.isCommunicationChannelPossible(notification.communicationPermissions())).forEach(c -> c.send(notification.message()));
            log.info("Notifications successfully processed for client {}", notification.clientId());
        }
    }
}
