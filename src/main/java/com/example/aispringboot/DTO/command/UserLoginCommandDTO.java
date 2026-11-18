package com.example.aispringboot.DTO.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginCommondDTO {
    @NotBlank(message = "用户名或邮箱不能为空！")
    @Size(max = 100, message = "用户名或邮箱不能为空")
    private String username;
    @NotBlank(message = "密码不能为空！")
    @Size(max = 100, min = 6, message = "密码长度必须在6到50个字符之间")
    private String password;
}
