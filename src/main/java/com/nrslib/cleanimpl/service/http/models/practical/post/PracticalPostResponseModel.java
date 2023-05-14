package com.nrslib.cleanimpl.service.http.models.practical.post;

import java.util.UUID;

public record PracticalPostResponseModel(
        UUID id,
        String data
) {}