package com.mati.mati.queue;

import com.mati.mati.model.NotificationRequest;

public interface NotificationQueue {
    boolean queueNotification(NotificationRequest notification);
    NotificationRequest getNotification();
    boolean isNewNotification();
}
