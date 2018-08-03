package com.example.demo.DTO;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    @Email(message = "{message.sign-up.invalid.email}")
    @NotNull(message = "{message.sign-up.email-null}")
    private String email;

    @NotNull(message = "{message.sign-up.password-null}")
    @Size(min = 8, message = "{message.sign-up.password-size}")
    private String password;

}
