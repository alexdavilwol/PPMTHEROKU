package com.alex.ppmtool.payload;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    //must match the attribute names in user object
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;

}
