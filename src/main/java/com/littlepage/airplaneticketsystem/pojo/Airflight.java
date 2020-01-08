package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Entity Airflight
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Airflight {
    private String afId;
    private Date startTime;
    private Date arriveTime;
    private Double touristPrice;
    private Double firstPrice;
    private Double businessPrice;
    private String alid;
}
