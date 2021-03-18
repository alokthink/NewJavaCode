package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Customer customer = new Customer();
		customer.setDefaultRenewToCustomerId(rs.getLong("default_renew_to_customer_id"));
		customer.setDefaultCustAddrSeq(rs.getLong("customer_address_seq"));
		customer.setCurrency(rs.getString("currency"));
        return customer;
    }
}
