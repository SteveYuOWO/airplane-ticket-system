package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;
import lombok.experimental.Accessors;


/**
 * Entity User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private String uid;
    private String username;
    private Character sex;
    private Integer age;
    private String identityNum;
    private Integer level;
    private Double consumeMoney;
    private String address;
    private String mobileNum;
    private String password;
}
