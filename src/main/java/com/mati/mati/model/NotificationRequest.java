package com.mati.mati.model;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Builder
public record NotificationRequest(String clientId,
                                  String message,
                                  String phoneNumber,
                                  String email,
                                  CommunicationPermissions communicationPermissions) {


}


@Builder
record CommunicationPermissions(Boolean phone, Boolean sms,
                                Boolean email, Boolean pushNotification) {

}