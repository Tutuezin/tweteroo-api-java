package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AuthDTO(

        @NotNull @NotBlank @Size(min = 1, max = 25) String username,

        @NotNull @NotBlank String avatar) {

}
