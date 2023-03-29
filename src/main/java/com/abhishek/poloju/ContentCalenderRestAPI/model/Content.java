package com.abhishek.poloju.ContentCalenderRestAPI.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Content(
        Integer id,
        @NotBlank
        String title,
        String desc,
        Status status,
        @NotNull
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {

}
