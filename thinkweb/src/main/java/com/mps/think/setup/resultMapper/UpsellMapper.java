package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.setup.model.UpSellModel;
import com.mps.think.setup.util.PropertyUtils;

public class UpsellMapper implements RowMapper<UpSellModel>{

	@Override
	public UpSellModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UpSellModel upSellModel = new UpSellModel();
		try{
			upSellModel.setUpsellId(rs.getInt("upsell_id"));
			upSellModel.setOcId(rs.getInt("oc_id"));
			upSellModel.setUpsellSuggestionId(rs.getInt("upsell_suggestion_id"));
			upSellModel.setCalendarCampainId(rs.getInt("calendar_campaign_id"));
			upSellModel.setSourceCodeId(rs.getInt("source_code_id"));
			upSellModel.setOrderCodeId(rs.getInt("order_code_id"));
			upSellModel.setPackageId(rs.getInt("package_id"));
			upSellModel.setSouSourceCodeId(rs.getInt("sou_source_code_id"));
			upSellModel.setUpsellType(new PropertyUtils().getConstantValue("upsell_type_"+rs.getInt("upsell_type")));
			upSellModel.setUpsellCondition(new PropertyUtils().getConstantValue("upsell_condition_"+rs.getInt("upsell_condition")));
			upSellModel.setScriptText(rs.getString("script_text"));
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return upSellModel;
	}

}
