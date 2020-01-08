package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.pojo.Airline;
import com.littlepage.airplaneticketsystem.pojo.Company;
import com.littlepage.airplaneticketsystem.pojo.Plane;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public class AirlineRepository {
    public void addAirline(Airline airline){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"insert t_airline values('"+
                airline.getAlid()+"','"+
                airline.getStartPlace()+"','"+
                airline.getArrivePlace()+"','"+
                airline.getPPID()+"')");
    }

    public Airline getAirline(String startPlace,String arrivePlace){
        Airline airline = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt, "select * from t_airline where start_place = '" +
                        startPlace + "' and arrive_place='"+arrivePlace+"'");
        try{
            while (rs.next()){
                airline = new Airline();
                airline.setAlid(rs.getString("alid")).
                        setPPID(rs.getString("ppid")).
                        setStartPlace(rs.getString("start_place")).
                        setArrivePlace(rs.getString("arrive_place"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return airline;
    }

    public ArrayList<Airline> getAirline(String place){
        ArrayList<Airline> arr = new ArrayList<>();
        Airline airline = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt, "select * from t_airline where start_place = '" +
                place + "'");
        try{
            while (rs.next()){
                airline = new Airline();
                airline.setAlid(rs.getString("alid")).
                        setPPID(rs.getString("ppid")).
                        setStartPlace(rs.getString("start_place")).
                        setArrivePlace(rs.getString("arrive_place"));
                arr.add(airline);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs = DBUtils.executeQuery(stmt, "select * from t_airline where arrive_place = '" +
                place + "'");
        try{
            while (rs.next()){
                airline = new Airline();
                airline.setAlid(rs.getString("alid")).
                        setPPID(rs.getString("ppid")).
                        setStartPlace(rs.getString("start_place")).
                        setArrivePlace(rs.getString("arrive_place"));
                arr.add(airline);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }

}
