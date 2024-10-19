package com.mati.mati.service;

import com.mati.mati.model.NotificationRequest;
import com.mati.mati.queue.NotificationQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationQueuingService {

    private final NotificationQueue notificationQueue;

    public void queueNotification(NotificationRequest request) {
        notificationQueue.queueNotification(request);
    }
}
