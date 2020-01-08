package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.utils.DBUtils;
import com.littlepage.airplaneticketsystem.utils.DateUtils;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * ticketDetail Repository
 */
@Repository
public class TicketDetailsRepository {
    /**
     * get ticket detail by afid
     * @param AfId
     * @return
     */
    public TicketDetails getTicketDetailByAfId(String AfId){
        TicketDetails ticketDetails = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt,
                "select afid,t_airline.alid,start_time,arrive_time,\n" +
                        "       tourist_price,first_price,business_price,start_place,arrive_place from\n" +
                        "(select * from t_airflight where afid = '" + AfId + "') info,t_airline\n" +
                        "where info.alid=t_airline.alid");
        try{
            while (rs.next()){
                ticketDetails = new TicketDetails();
                ticketDetails.setAfid(rs.getString("afid")).
                        setAlid(rs.getString("alid")).
                        setStartTime(rs.getString("start_time").substring(0,16)).
                        setArriveTime(rs.getString("arrive_time").substring(0,16)).
                        setTouristPrice(rs.getDouble("tourist_price")).
                        setFirstPrice(rs.getDouble("first_price")).
                        setBusinessPrice(rs.getDouble("business_price")).
                        setStartPlace(rs.getString("start_place")).
                        setArrivePlace(rs.getString("arrive_place"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ticketDetails;
    }

    /**
     * get ticket count
     * @param seatType
     * @param afid
     * @return
     */
    public int getTicketCount(String seatType,String afid){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt, "select count(tid) from t_ticket where seat_type='"+
                seatType+"' and afid='"+
                afid+"'");
        try{
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
