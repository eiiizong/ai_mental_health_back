package com.example.aispringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    /**
     * `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
     * `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
     * `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
     * `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
     * `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
     * `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
     * `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像URL',
     * `gender` tinyint DEFAULT NULL COMMENT '性别 0:未知 1:男 2:女',
     * `birthday` date DEFAULT NULL COMMENT '生日',
     * `user_type` tinyint DEFAULT '1' COMMENT '用户类型 1:普通用户 2:管理员',
     * `status` tinyint DEFAULT '1' COMMENT '状态 0:禁用 1:正常',
     * `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
     * `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     */

    // 用户ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 用户名
    @NotBlank(message = "用户名不能为空")
    @Size(max = 50, min = 3, message = "用户名长度必须在3到50个字符之间")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "用户名只能包含字母、数字和下划线。")
    private String username;


    // 邮箱
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @Size(min = 7, max = 100, message = "邮箱长度必须在7到100个字符之间")
    private String email;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 255, message = "密码长度必须在6到255个字符之间")
    private String password;

    @Size(max = 255, message = "昵称长度不能超过255个字符")
    private String nickname;

    @Size(max = 255, message = "头像长度不能超过255个字符")
    private String avatar;

    private Integer gender;

    private LocalDate birthday;

    private Integer status;

    @TableField("user_type")
    private Integer userType;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @TableField("updated_at")
    private LocalDateTime updatedAt;


    /**
     * 判断当前用户是否为普通用户
     */
//    public boolean isUser() {
//        return false;
//    }
}
