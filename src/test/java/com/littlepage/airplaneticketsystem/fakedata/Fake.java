package com.littlepage.airplaneticketsystem.fakedata;

import com.littlepage.airplaneticketsystem.dao.AirlineRepository;
import com.littlepage.airplaneticketsystem.dao.CompanyRepository;
import com.littlepage.airplaneticketsystem.dao.PlaneRepository;
import com.littlepage.airplaneticketsystem.pojo.Airline;
import com.littlepage.airplaneticketsystem.pojo.Company;
import com.littlepage.airplaneticketsystem.pojo.Plane;
import org.junit.jupiter.api.Test;

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
        Company com = new CompanyRepository().getCompanyByName("南方航空");
        Company com1 = new CompanyRepository().getCompanyByName("东方航空");
//        Plane plane = new Plane(UUID.randomUUID().toString(),
//                "播音777",
//                300,
//                100,
//                100,
//                "浦东机场",
//                com.getCCID());
//        Plane plane1 = new Plane(UUID.randomUUID().toString(),
//                "空客310",
//                210,
//                80,
//                70,
//                "虹桥机场",
//                com1.getCCID());
        Plane plane3 = new Plane(UUID.randomUUID().toString(),
                "播音777",
                300,
                100,
                100,
                "北京机场",
                com.getCCID());
        Plane plane4 = new Plane(UUID.randomUUID().toString(),
                "空客310",
                210,
                80,
                70,
                "哈尔滨机场",
                com1.getCCID());
        new PlaneRepository().addPlane(plane3);
        new PlaneRepository().addPlane(plane4);
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
    public void fakeAirline(){
//        Airline airline = new Airline();
//        airline.setAlid(UUID.randomUUID().toString()).
//                setStartPlace("上海").setArrivePlace("北京").
//                setPPID(new PlaneRepository().getPlane("浦东机场").getPPID());
//
//        Airline airline1 = new Airline();
//        airline1.setAlid(UUID.randomUUID().toString()).
//                setStartPlace("上海").setArrivePlace("哈尔滨").
//                setPPID(new PlaneRepository().getPlane("浦东机场").getPPID());

        Airline airline2 = new Airline();
        airline2.setAlid(UUID.randomUUID().toString()).
                setStartPlace("北京").setArrivePlace("上海").
                setPPID(new PlaneRepository().getPlane("北京机场").getPPID());

        Airline airline3 = new Airline();
        airline3.setAlid(UUID.randomUUID().toString()).
                setStartPlace("哈尔滨").setArrivePlace("上海").
                setPPID(new PlaneRepository().getPlane("哈尔滨机场").getPPID());
        new AirlineRepository().addAirline(airline2);
        new AirlineRepository().addAirline(airline3);
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


}
