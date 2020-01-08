package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Entity Ticket
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Ticket {
    private String tID;
    private Date purchaseTime;
    private Integer seatNum;
    private String uid;//FK user ID
    private String afid;//FK airline ID
    private String seatType;
}
