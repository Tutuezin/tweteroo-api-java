package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetDTO(

        @NotNull @NotBlank String username,

        @NotNull @NotBlank String tweet,

        String avatar) {

}
