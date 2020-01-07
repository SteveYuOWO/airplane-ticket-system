package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;

/**
 * Entity Airline
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline {
    private String alid;
    private String startPlace;
    private String arrivePlace;
    private String PPID;
}
