package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.setup.controller.OrderClassDetailsController;
import com.mps.think.setup.model.OrderClassModel;

public class OCMapper implements RowMapper<OrderClassModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderClassDetailsController.class);
	
	@Override
	public OrderClassModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderClassModel model = new OrderClassModel();
		try {
			 model.setOcId(rs.getLong("oc_id"));
			 model.setOc(rs.getString("oc"));
			 model.setOcType(rs.getInt("oc_type"));
			 model.setParentOcId(rs.getLong("parent_oc_id"));
			 model.setDescription(rs.getString("description"));
			 //model.setNewGroupMemberAction(new PropertyUtils().getConstantValue("new_group_member_action_"+rs.getInt("new_group_member_action")));
			
			 
		}catch (Exception e) {
			LOGGER.info("Exception in OrderClassMapper :"+e);
		}
		return model;
	}

}
