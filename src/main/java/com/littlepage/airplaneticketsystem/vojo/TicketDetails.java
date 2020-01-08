package com.littlepage.airplaneticketsystem.vojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * view ticket details
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TicketDetails {
    private String afid;
    private String alid;
    private String startTime;
    private String arriveTime;
    private Double touristPrice;
    private Double firstPrice;
    private Double businessPrice;
    private String startPlace;
    private String arrivePlace;
    private int touristRelease;
    private int firstRelease;
    private int businessRelease;
}
