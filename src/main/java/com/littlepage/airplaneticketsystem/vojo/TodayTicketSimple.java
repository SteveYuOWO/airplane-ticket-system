package com.littlepage.airplaneticketsystem.vojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * view today_ticket_simple
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TodayTicketSimple {
    private String afid;
    private String startPlace;
    private String arrivePlace;
    private Date startTime;
    private Date arriveTime;
}
