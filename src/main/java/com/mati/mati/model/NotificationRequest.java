package com.mati.mati.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Builder
public record NotificationRequest(@NotBlank @Size(min = 1) String clientId,
                                  @NotBlank String message,
                                  @NotBlank String phoneNumber,
                                  @NotBlank String email,
                                  @Valid @NotNull CommunicationPermissions communicationPermissions) {


    @Builder
    public record CommunicationPermissions(@NotNull Boolean phone, @NotNull Boolean sms,
                                           @NotNull Boolean email, @NotNull Boolean pushNotification) {

    }
}



