package com.littlepage.airplaneticketsystem.dao;

import com.littlepage.airplaneticketsystem.pojo.Ticket;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import com.littlepage.airplaneticketsystem.utils.DateUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
