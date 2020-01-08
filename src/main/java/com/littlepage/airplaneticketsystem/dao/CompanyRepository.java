package com.littlepage.airplaneticketsystem.dao;


import com.littlepage.airplaneticketsystem.pojo.Company;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

/**
 * CompanyRepository
 */
@Repository
public class CompanyRepository {
    public void addCompany(Company company){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"insert t_company values ('"
                + company.getCCID() +"','"
                +company.getName()+"','"
                +company.getDescription()+"','"
                +company.getAddress()+"');");
    }

    public Company getCompanyByName(String name){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        Company company = null;
        ResultSet rs = DBUtils.executeQuery(stmt, "select * from t_company where name = '" + name + "'");
        try{
            while (rs.next()){
                company = new Company(rs.getString("ccid"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return company;
    }
}
