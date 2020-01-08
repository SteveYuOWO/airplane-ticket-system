package com.littlepage.airplaneticketsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * encapsulate the page data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Page {

    /**
     * the maximum of the all the page count
     */
    private int pageNumber;

    /**
     * the rows of one page
     */
    private int pageSize;

    /**
     * index represent you want to get the index
     */
    private int index;

    /**
     * the top number of
     * @return
     */
    public int getNotInTopNumber() {
        return this.pageSize*this.index;
    }
}
