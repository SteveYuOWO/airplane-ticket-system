package com.littlepage.airplaneticketsystem.dao;


import com.littlepage.airplaneticketsystem.pojo.Company;
import com.littlepage.airplaneticketsystem.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Statement;
import java.util.UUID;

/**
 * CompanyRepository
 */
public class CompanyRepository {
    public void addCompany(Company company){
        Connection connection = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(connection);
        DBUtils.execute(stmt,"insert t_company values ('"
                + company.getCCID() +"','"
                +company.getName()+"','"
                +company.getDescription()+"','"
                +company.getAddress()+"');");
    }
}
