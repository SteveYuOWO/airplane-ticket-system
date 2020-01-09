package com.littlepage.airplaneticketsystem.dao;


import com.littlepage.airplaneticketsystem.pojo.User;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import org.springframework.stereotype.Repository;
import java.sql.*;

/**
 * User Repository
 */
@Repository
public class UserRepository {
    /**
     * find user by username and password
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password){
        Connection connection = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(connection);
        try {
            ResultSet rs = stmt.executeQuery("select * from t_user where username='"
                    +username+"' and password='"+password+"'");
            if(rs.next()){
                return new User(rs.getString("uid"),
                        rs.getString("username"),
                        rs.getString("sex").charAt(0),
                        rs.getInt("age"),
                        rs.getString("identity_num"),
                        rs.getInt("level"),
                        rs.getDouble("consume_money"),
                        rs.getString("address"),
                        rs.getString("mobile_num"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find user by username and password
     * @param username
     * @return
     */
    public User findByUsername(String username){
        Connection connection = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(connection);
        try {
            ResultSet rs = stmt.executeQuery("select * from t_user where username='"
                    +username+"'");
            if(rs.next()){
                return new User(rs.getString("uid"),
                        rs.getString("username"),
                        rs.getString("sex").charAt(0),
                        rs.getInt("age"),
                        rs.getString("identity_num"),
                        rs.getInt("level"),
                        rs.getDouble("consume_money"),
                        rs.getString("address"),
                        rs.getString("mobile_num"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * add a new User
     * @param uid
     * @param username
     * @param password
     */
    public void addUser(String uid, String username, String password){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"insert t_user(username,password,uid) values('"+username+"','"+password+"','"+uid+"')");
    }
}
