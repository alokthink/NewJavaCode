package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.OrderItemAccountModel;
import com.mps.think.util.PropertyUtilityClass;

public class OrderItemAccountMapper implements RowMapper<OrderItemAccountModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemAccountMapper.class);
	private static final String ERROR = "Error"; 
	@Override
	public OrderItemAccountModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderItemAccountModel orderAccountInof=new OrderItemAccountModel();
		try {
			orderAccountInof.setAccntBreaktype((new PropertyUtilityClass().getConstantValue("acc_break_type_"+rs.getInt("acc_break_type"))));
			//orderAccountInof.setAccntBreakTypeDisp((new PropertyUtilityClass().getConstantValue("acc_break_type_"+rs.getInt("acc_break_type"))));
			orderAccountInof.setOrderItemSeq(rs.getInt("order_item_seq"));
			orderAccountInof.setAr(rs.getInt("ar"));
			orderAccountInof.setCash(rs.getInt("cash"));
			orderAccountInof.setLiability(rs.getInt("liability"));
			orderAccountInof.setOrderhdrId(rs.getInt("orderhdr_id"));
			orderAccountInof.setRevenue(rs.getInt("revenue"));
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return orderAccountInof;
	}
			
}		
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		