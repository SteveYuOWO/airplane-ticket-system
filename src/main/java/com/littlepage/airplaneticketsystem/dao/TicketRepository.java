package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.pojo.Ticket;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import com.littlepage.airplaneticketsystem.utils.DateUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ticket Repository
 */
@Repository
public class TicketRepository {
    /**
     * add ticket
     * @param ticket
     */
    public void addTicket(Ticket ticket){
        Connection conn = DBUtils.getConnection();
        String sql = "insert t_ticket values (?,?,?,?,?,?)";
        PreparedStatement ps =DBUtils.getPreparedStatement(conn,sql);
        try {
            ps.setString(1,ticket.getTID());
            ps.setObject(2, DateUtils.getString(ticket.getPurchaseTime()));
            ps.setInt(3,ticket.getSeatNum());
            ps.setString(4,ticket.getSeatType());
            ps.setString(5,ticket.getUid());
            ps.setString(6,ticket.getAfid());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * get ticket num
     * @param afid
     * @return
     */
    public Integer getTicketNum(String afid) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql ="select count(tid) from t_ticket where afid='"+afid+"'";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try{
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * get ticket by uid and Afid
     * @param uid
     * @param afid
     * @return
     */
    public Ticket searchTicketByUidAndAfid(String uid, String afid) {
        Ticket ticket = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql ="select * from t_ticket where t_ticket.uid='"+uid+"' and t_ticket.afid='"+afid+"'";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try{
            while (rs.next()){
                ticket = new Ticket();
                ticket.setTID(rs.getString("tid")).
                        setPurchaseTime(rs.getTime("purchase_time")).
                        setSeatNum(rs.getInt("seat_num")).setSeatType(rs.getString("seat_type")).
                        setUid(rs.getString("uid")).setAfid(rs.getString("afid"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ticket;
    }

    /**
     * get ticket
     * @param uid
     * @return
     */
    public List<Ticket> getTicketByUid(String uid) {
        List<Ticket> res = new ArrayList<>();
        Ticket ticket = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql ="select * from t_ticket where t_ticket.uid='"+uid+"'";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try{
            while (rs.next()){
                ticket = new Ticket();
                ticket.setTID(rs.getString("tid")).
                        setPurchaseTime(rs.getDate("purchase_time")).
                        setSeatNum(rs.getInt("seat_num")).setSeatType(rs.getString("seat_type")).
                        setUid(rs.getString("uid")).setAfid(rs.getString("afid"));
                res.add(ticket);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * get ticket by tid
     * @param tid
     * @return
     */
    public Ticket getTicketByTid(String tid) {
        Ticket ticket = null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql = "select * from t_ticket where t_ticket.tid='" + tid + "'";
        ResultSet rs = DBUtils.executeQuery(stmt, sql);
        try {
            while (rs.next()) {
                ticket = new Ticket();
                ticket.setTID(rs.getString("tid")).
                        setPurchaseTime(rs.getDate("purchase_time")).
                        setSeatNum(rs.getInt("seat_num")).setSeatType(rs.getString("seat_type")).
                        setUid(rs.getString("uid")).setAfid(rs.getString("afid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public void removeTicket(String tid) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        String sql = "delete from t_ticket where t_ticket.tid='" + tid + "'";
        DBUtils.execute(stmt,sql);
    }

}
