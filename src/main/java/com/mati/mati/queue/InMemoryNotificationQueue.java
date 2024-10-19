package com.mati.mati.queue;

import com.mati.mati.model.NotificationRequest;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class InMemoryNotificationQueue implements NotificationQueue{

    private LinkedList<NotificationRequest> notificationQueue;

    public InMemoryNotificationQueue() {
        notificationQueue = new LinkedList<>();
    }

    @Override
    public boolean queueNotification(NotificationRequest notification) {
        return notificationQueue.offerFirst(notification)
    }

    @Override
    public NotificationRequest getNotification() {
        return notificationQueue.poll()
    }

    @Override
    public boolean isNewNotification() {
        return false;
    }
}
