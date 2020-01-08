package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.pojo.Airflight;
import com.littlepage.airplaneticketsystem.utils.AirflightUUID;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import com.littlepage.airplaneticketsystem.utils.DateUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AirflightRepository {
    /**
     * Add Airflight
     * @param airflight
     */
    public void addAirflight(Airflight airflight){
        Connection conn = DBUtils.getConnection();
        String sql = "insert t_airflight values(?,?,?,?,?,?,?)";
        PreparedStatement prep = DBUtils.getPreparedStatement(conn,sql);
        try {
            prep.setString(1,airflight.getAfId());
            prep.setObject(2,airflight.getStartTime());
            prep.setObject(3,airflight.getArriveTime());
            prep.setDouble(4,airflight.getTouristPrice());
            prep.setDouble(5,airflight.getFirstPrice());
            prep.setDouble(6,airflight.getBusinessPrice());
            prep.setString(7,airflight.getAlid());
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * count the airflight for the unique algorithm
     * @param afid
     * @return
     */
    public int countAirflight(String afid){
        Connection conn = DBUtils.getConnection();
        String sql = "select count(afid) from t_airflight where afid = '" + afid +"'";
        int count = 0;
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * caculate intraday count of airflight
     * @return
     */
    public int countAirflight(){
        Connection conn = DBUtils.getConnection();
        String sql = "select count(afid) from t_airflight where DATEDIFF(dd, start_time, GETDATE())=0";
        int count = 0;
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Not Test
     * @param args
     */
    public static void main(String[] args) {
        Airflight af = new Airflight();
        af.setAfId(AirflightUUID.getAirflightUUID()).
                setStartTime(DateUtils.getDate("2020-1-8 15:00")).
                setArriveTime(DateUtils.getDate("2020-1-8 16:00")).
                setTouristPrice(300.0).
                setFirstPrice(800.0).
                setBusinessPrice(400.0).
                setAlid(new AirlineRepository().getAirline("上海","哈尔滨").getAlid());
        new AirflightRepository().addAirflight(af);
    }
}
