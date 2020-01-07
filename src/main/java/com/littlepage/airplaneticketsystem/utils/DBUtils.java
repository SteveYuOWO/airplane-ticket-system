package com.littlepage.airplaneticketsystem.utils;

import java.sql.*;

/**
 * Because this assignment must use SQL statements, I
 *      use the DBUtils replace the Spring Data JPA To Connect sql
 */
public class DBUtils {
    /**
     *connect to the database
     * @return:Connection
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=airplane-ticket-system","sa","Root123..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }

    /**
     * get a statement
     * @param:Connection conn
     * @return:Statement
     */
    public static Statement getStatement(Connection conn){
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     * release a connection
     * @param:Connection conn
     * @return:void
     */
    public static void releaseConnection(Connection conn){
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * release a Statement
     * @param:Statement stmt
     * @return:void
     */
    public static void releaseStatement(Statement stmt){
        try{
            if(stmt!=null) {
                stmt.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * add, delete or change an instance for the table
     * @param: Statement stmt,String sql
     * @return:void
     */
    public static void execute(Statement stmt,String sql){
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * search an instance for the table
     * @param:Statement stmt,String sql
     * @return:ResultSet rs
     */
    public static ResultSet executeQuery(Statement stmt,String sql){
        ResultSet rs=null;
        try{
            rs=stmt.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    /**
     * release a ResultSet
     * @param:ResultSet rs
     * @return:void
     */
    public static void releaseResultSet(ResultSet rs){
        try{
            if(rs!=null) {
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * preparedStatement
     * @param:Connection conn,String sql
     * @return:PreparedStatement
     */
    public static PreparedStatement getPreparedStatement(Connection conn,String sql){
        PreparedStatement ps=null;
        try{
            ps=conn.prepareStatement(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ps;
    }
    /**
     * releasePreparedStatement
     * @param:PreparedStatement ps
     * @return:void
     */
    public static void releasePreparedStatement(PreparedStatement ps){
        try{
            if(ps!=null) {
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * setStringPreparedStatement
     * @param:PreparedStatement ps
     * @return:void
     */
    public static void setStringPreparedStatement(PreparedStatement ps,int parameterIndex,String str){
        try {
            ps.setString(parameterIndex, str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * executePreparedStatement
     * @prarm:PreparedStatement ps
     * @return:void
     */
    public static void executePreparedStatement(PreparedStatement ps){
        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * setPreparedStatementNum
     * @param:PreparedStatement ps,int index,int Num
     */
    public static void setIntPreParedStatement(PreparedStatement ps,int index,int num){
        try {
            ps.setInt(index, num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * setPreparedStatementNum
     * @param:PreparedStatement ps,int index,String str
     */
    public static void setStringPreParedStatement(PreparedStatement ps,int index,String str){
        try {
            ps.setString(index, str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * UpdateQuickly
     * @param:String sql
     * @return:void
     * @Annoation:use Statement update data
     */
    public static void UpdateQuickly(String sql){
        Connection conn=DBUtils.getConnection();
        Statement stmt=DBUtils.getStatement(conn);
        DBUtils.execute(stmt, sql);
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }
}