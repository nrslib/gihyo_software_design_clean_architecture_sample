package com.nrslib.cleanimpl.service.http.models.typical.post;

import java.util.UUID;

public record TypicalPostResponseModel(
        UUID id,
        String data
) {}