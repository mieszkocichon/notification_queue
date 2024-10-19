package com.mati.mati.queue;

import com.mati.mati.model.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Objects;

@Slf4j
@Component
public class InMemoryNotificationQueue implements NotificationQueue{

    private final LinkedList<NotificationRequest> notificationQueue;

    public InMemoryNotificationQueue() {
        notificationQueue = new LinkedList<>();
    }

    @Override
    public boolean queueNotification(NotificationRequest notification) {
        log.info("notificaton added to queue {}", notification.toString());
        return notificationQueue.offerLast(notification);
    }

    @Override
    public NotificationRequest getNotification() {
        return notificationQueue.pollFirst();
    }

    @Override
    public boolean isNewNotification() {
        return Objects.nonNull(notificationQueue.peekFirst());
    }
}
