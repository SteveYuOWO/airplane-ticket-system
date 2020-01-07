package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;


/**
 * Entity User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String username;
    private Boolean sex;
    private Integer age;
    private String identityNum;
    private Integer level;
    private Long score;
    private String address;
    private String mobileNum;
    private String password;
}
