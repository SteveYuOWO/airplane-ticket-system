package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.pojo.Plane;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * the plane repository
 */
@Repository
public class PlaneRepository {
    /**
     * add plane
     * @param plane
     */
    public void addPlane(Plane plane){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"insert t_plane values('"+plane.getPPID()+"'," +
                "'"+plane.getType()+"',"+plane.getSeatNum()+"," +
                plane.getTouristNum()+","+
                plane.getBusinessnum()+",'"+
                plane.getPlace()+"','"+
                plane.getCid()+"')");
    }

    /**
     * get plane
     * @param place
     * @return
     */
    public Plane getPlane(String place){
        Plane plane = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt, "select * from t_plane where place = '" + place + "'");
        try{
            while (rs.next()){
                plane = new Plane();
                plane.setPPID(rs.getString("ppid")).
                        setType(rs.getString("type")).
                        setSeatNum(rs.getInt("seat_num")).
                        setTouristNum(rs.getInt("tourist_num")).
                        setBusinessnum(rs.getInt("business_num")).
                        setPlace(rs.getString("place")).
                        setCid(rs.getString("cid"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return plane;
    }

    /**
     * get plane by air flight
     * @param afid
     * @return
     */
    public Plane getPlaneByAfid(String afid){
        Plane plane = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt, "select * from (\n" +
                "     select ppid\n" +
                "     from (\n" +
                "              select alid\n" +
                "              from t_airflight\n" +
                "              where afid = '"+
                afid+"'\n" +
                "          ) A,\n" +
                "          t_airline\n" +
                "     where t_airline.alid = A.alid\n" +
                " ) B,t_plane where B.ppid=t_plane.ppid");
        try{
            while (rs.next()){
                plane = new Plane();
                plane.setPPID(rs.getString("ppid")).
                        setType(rs.getString("type")).
                        setSeatNum(rs.getInt("seat_num")).
                        setTouristNum(rs.getInt("tourist_num")).
                        setBusinessnum(rs.getInt("business_num")).
                        setPlace(rs.getString("place")).
                        setCid(rs.getString("cid"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return plane;
    }
}
