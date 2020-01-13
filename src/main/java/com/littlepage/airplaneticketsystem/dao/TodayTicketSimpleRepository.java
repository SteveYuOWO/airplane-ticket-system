package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.utils.DBUtils;
import com.littlepage.airplaneticketsystem.utils.DateUtils;
import com.littlepage.airplaneticketsystem.utils.Page;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * show today ticket simple view
 */
@Repository
public class TodayTicketSimpleRepository {

    /**
     * Page Plugin
     * caculate page algorithm
     * @param page
     */
    public ArrayList<TodayTicketSimple> showAllData(Page page){
        ArrayList<TodayTicketSimple> arr = new ArrayList<>();
        TodayTicketSimple todayTicketSimple;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql = "select top " + page.getPageSize() + " * from today_ticket_simple\n" +
                "where afid not in (\n" +
                "select top " + page.getNotInTopNumber() + " afid from today_ticket_simple\n" +
                ")";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try{
            while (rs.next()){
                todayTicketSimple = new TodayTicketSimple(rs.getString("afid"),
                        rs.getString("start_place"),
                        rs.getString("arrive_place"),
                        DateUtils.getDate(rs.getString("start_time")),
                        DateUtils.getDate(rs.getString("arrive_time")));
                arr.add(todayTicketSimple);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * get ticket by start place and arrive place
     * @param startPlace
     * @param arrivePlace
     * @return
     */
    public ArrayList<TodayTicketSimple> getTicketByStartPlaceAndArrivePlace(String startPlace,String arrivePlace){
        ArrayList<TodayTicketSimple> arr = new ArrayList<>();
        TodayTicketSimple todayTicketSimple;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql = "select * from today_ticket_simple where start_place='"+
                startPlace+"' and arrive_place='"+arrivePlace+"'";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try{
            while (rs.next()){
                todayTicketSimple = new TodayTicketSimple(rs.getString("afid"),
                        rs.getString("start_place"),
                        rs.getString("arrive_place"),
                        DateUtils.getDate(rs.getString("start_time")),
                        DateUtils.getDate(rs.getString("arrive_time")));
                arr.add(todayTicketSimple);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * get ticket by start place and arrive place and date
     * @param startPlace
     * @param arrivePlace
     * @param date
     * @return
     */
    public ArrayList<TodayTicketSimple> getTicketByStartPlaceAndArrivePlaceAndDate(String startPlace,String arrivePlace,String date){
        ArrayList<TodayTicketSimple> arr = new ArrayList<>();
        TodayTicketSimple todayTicketSimple;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql = "select * from today_ticket_simple where start_place='"+startPlace
                +"' and arrive_place='"+arrivePlace+"' and DATEDIFF(dd, start_time, '"+date+"')=0";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try{
            while (rs.next()){
                todayTicketSimple = new TodayTicketSimple(rs.getString("afid"),
                        rs.getString("start_place"),
                        rs.getString("arrive_place"),
                        DateUtils.getDate(rs.getString("start_time")),
                        DateUtils.getDate(rs.getString("arrive_time")));
                arr.add(todayTicketSimple);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }
}
