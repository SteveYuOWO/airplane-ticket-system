package com.littlepage.airplaneticketsystem.fakedata;

import com.littlepage.airplaneticketsystem.dao.AirflightRepository;
import com.littlepage.airplaneticketsystem.dao.AirlineRepository;
import com.littlepage.airplaneticketsystem.dao.CompanyRepository;
import com.littlepage.airplaneticketsystem.dao.PlaneRepository;
import com.littlepage.airplaneticketsystem.pojo.Airflight;
import com.littlepage.airplaneticketsystem.pojo.Airline;
import com.littlepage.airplaneticketsystem.pojo.Company;
import com.littlepage.airplaneticketsystem.pojo.Plane;
import com.littlepage.airplaneticketsystem.utils.AirflightUUID;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import com.littlepage.airplaneticketsystem.utils.DateUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

/**
 * Fake Data
 */
public class Fake {
    /**
     * Company Fake Data
     */
    @Test
    public void fakeCompany() {
        new CompanyRepository().addCompany(new Company(UUID.randomUUID().toString(),"鸿运航空","有好事发生","北京西城区"));
        new CompanyRepository().addCompany(new Company(UUID.randomUUID().toString(),"东方航空","最大的航空中心","上海浦东"));
        new CompanyRepository().addCompany(new Company(UUID.randomUUID().toString(),"南方航空","普通航空中心","浙江杭州"));
        System.out.println("success");
    }

    /**
     * Test Query Company
     */
    @Test
    public void getCompany(){
        System.out.println(new CompanyRepository().getCompanyByName("南方航空"));
    }

    /**
     * Plane Fake Data
     */
    @Test
    public void fakePlane(){
        PlaneRepository planeR = new PlaneRepository();
        Company com = new CompanyRepository().getCompanyByName("南方航空");
        Company com1 = new CompanyRepository().getCompanyByName("东方航空");
        for (String prince : princes) {
            Plane plane = new Plane(UUID.randomUUID().toString(),
                    "播音777",
                    300,
                    100,
                    100,
                    prince+"机场",
                    com.getCCID());
            planeR.addPlane(plane);
        }

    }

    /**
     * Test Query Plane
     */
    @Test
    public void getPlane(){
        System.out.println(new PlaneRepository().getPlane("浦东机场"));
    }

    /**
     * Fake Airline
     */
    @Test
    public void fakeAirline() throws SQLException {

        HashSet<String> hashSet = new HashSet<>();
        AirlineRepository air = new AirlineRepository();
        PlaneRepository plane = new PlaneRepository();
        Airline airline = new Airline();
        Connection conn = DBUtils.getConnection();
        conn.setAutoCommit(false);
        Statement stmt = DBUtils.getStatement(conn);
        for (int j=0;j<princes.length;j++) {
            for (int i=0;i<princes2.length;i++) {
                String str=UUID.randomUUID().toString().substring(0,36);
                while(hashSet.contains(str)){
                    str=UUID.randomUUID().toString().substring(0,36);
                }
                hashSet.add(str);
                if(!princes[j].equals(princes2[i])){
                    airline.setAlid(str).
                            setStartPlace(princes[j]).setArrivePlace(princes2[i]).
                            setPPID(plane.getPlane(princes[j]+"机场").getPPID());
                    air.addAirline(airline);
                    String sql = "insert t_airline values('"+
                            airline.getAlid()+"','"+
                            airline.getStartPlace()+"','"+
                            airline.getArrivePlace()+"','"+
                            airline.getPPID()+"')";
                    stmt.addBatch(sql);
                }
            }
        }
        stmt.executeBatch();
        conn.setAutoCommit(true);
        stmt.close();
        conn.close();
    }


    /**
     * Test Query Airline start & arrive
     */
    @Test
    public void getAirline(){
        System.out.println(new AirlineRepository().getAirline("上海","北京"));
    }

    /**
     * Test Query Airline one place
     */
    @Test
    public void getAirlineOnePlace(){
        new AirlineRepository().getAirline("上海").forEach((x)->{
            System.out.println(x);
        });
    }

    /**
     * add Airflight
     */
    @Test
    public void airflightfake() throws SQLException {
        Airflight af = new Airflight();
        AirflightRepository afr = new AirflightRepository();
        Random r = new Random();
        Connection conn= DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = stmt.executeQuery("select * from t_airline");
        while (rs.next()){
            int starthour = r.nextInt(24);
            af.setAfId(AirflightUUID.getAirflightUUID()).
                    setStartTime(DateUtils.getDate("2020-1-10 "+starthour+":"+r.nextInt(60)+"")).
                    setArriveTime(DateUtils.getDate("2020-1-10 "+(starthour+2)+":"+r.nextInt(60)+"")).
                    setTouristPrice((r.nextInt(100)+300)*1.0).
                    setFirstPrice((r.nextInt(100)+700)*1.0).
                    setBusinessPrice((r.nextInt(100)+500)*1.0).
                    setAlid(rs.getString("alid"));
            afr.addAirflight(af);
        }
    }

    static String[] princes ={"陕西省","甘肃省","青海省","宁夏","新疆",
            "北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省",
            "黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省",
            "湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","台湾省",
            "内蒙古","广西","西藏","香港","澳门"};
    static String[] princes2 ={"陕西省","甘肃省","青海省","宁夏","新疆",
            "北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省",
            "黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省",
            "湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","台湾省",
            "内蒙古","广西","西藏","香港","澳门"};
}
