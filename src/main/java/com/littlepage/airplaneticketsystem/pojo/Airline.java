package com.littlepage.airplaneticketsystem.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Entity Airline
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Airline {
    private String alid;
    private String startPlace;
    private String arrivePlace;
    private String PPID;
}
