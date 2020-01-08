package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Entity Plane
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Plane {
    private String PPID;
    private String type;
    private Integer seatNum;
    private Integer touristNum;
    private Integer businessnum;
    private String place;
    private String cid;
}
