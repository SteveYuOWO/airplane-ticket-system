package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;

/**
 * Entity Company
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String CCID;
    private String name;
    private String description;
    private String address;
}

