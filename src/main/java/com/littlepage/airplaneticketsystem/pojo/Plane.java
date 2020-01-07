package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;

/**
 * Entity Plane
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    private String PPID;
    private String type;
    private Integer seatNum;
    private Integer toriestNum;
    private Integer businessnum;
    private String place;
    private String cid;
}
