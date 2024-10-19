package com.mati.mati.client;

import com.mati.mati.model.NotificationRequest;

public interface CommunicationClient {
    void send(String message);
    boolean isCommunicationChannelPossible(NotificationRequest.CommunicationPermissions permissions);
}
