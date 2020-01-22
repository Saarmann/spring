package com.knits.spring.common.com.kaspar.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    @Getter
    @Setter
    private DataSource dataSource; //from bean

    @Override
    public List <Customer> myCustomerList () {

        Connection conn = null;
        Customer found = null;
        List <Customer> customerList = new ArrayList<>();

        try{

            conn = dataSource.getConnection();

            System.out.println ("Connected to Database...");

            Statement cmd = conn.createStatement();
            String sql = "SELECT * FROM customer";

            ResultSet res = cmd.executeQuery(sql);

            while (res.next()) {

                found = new Customer();
                found.setId(res.getInt("id"));
                found.setCustomerName(res.getString("customer_name"));
                found.setRegistrationCode(res.getString("registration_code"));
                found.setVatNo(res.getString("vat_no"));
                found.setCountry(res.getString("country"));
                found.setAddress(res.getString("address"));
                found.setCity(res.getString("city"));
                found.setState(res.getString("state"));
                found.setZip(res.getString("zip"));
                found.setCustomerEmail(res.getString("customer_email"));
                found.setContact(res.getString("contact"));
                found.setPaymentTerm(res.getInt("payment_term"));

                customerList.add(found);
            }

        }

        catch (Exception e) {

            System.err.println("Impossible to connect to Database");
            e.printStackTrace();

        } finally {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("connection closed");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
        return customerList;
    }
}
