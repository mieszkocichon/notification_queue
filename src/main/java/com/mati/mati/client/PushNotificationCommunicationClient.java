package com.mati.mati.client;

import com.mati.mati.model.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PushNotificationCommunicationClient implements CommunicationClient {
    @Override
    public void send(String message) {
        log.info("Push notification with content { {} } was sent", message);
    }

    @Override
    public boolean isCommunicationChannelPossible(NotificationRequest.CommunicationPermissions permissions) {
        return permissions.pushNotification();
    }
}
