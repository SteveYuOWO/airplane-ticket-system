package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Entity Company
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Company {
    private String CCID;
    private String name;
    private String description;
    private String address;
}

