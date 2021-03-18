package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.PackageDefinition;

public class PackageDefinitionMapper implements RowMapper<PackageDefinition>{

	@Override
	public PackageDefinition mapRow(ResultSet rs, int rowNum) throws SQLException {
		PackageDefinition packageDefinition = new PackageDefinition();
		packageDefinition.setPkgDefId(rs.getString("pkg_def_id")!=null?""+rs.getString("pkg_def_id")+"":"NULL");
		packageDefinition.setOrderCodeId(rs.getInt("order_code_id"));
		//packageDefinition.setOrderCode(rs.getString("order_code")!=null?rs.getString("order_code_id"):"NULL");
		packageDefinition.setPkgDef(rs.getString("pkg_def"));
		packageDefinition.setDescription(rs.getString("description"));
		packageDefinition.setnCalendarUnits(rs.getInt("n_calendar_units"));
		packageDefinition.setCalendarUnit((rs.getString("calendar_unit").equals(0)?"Day(s)":rs.getString("calendar_unit").equals(1)?"Week(s)":rs.getString("calendar_unit").equals(2)? "Month(s)":"Year(s)" ).toString());
		//packageDefinition.setCalendarUnit(rs.getString("calendar_unit"));
		packageDefinition.setDiscountClassId(rs.getString("discount_class_id")!=null?rs.getString("discount_class_id"):"NULL");
		packageDefinition.setPkgPriceMethod(rs.getInt("pkg_price"));
		packageDefinition.setRevenuePercentageOption(rs.getInt("revenue_percentage_option"));
		packageDefinition.setRenewvalCardId(rs.getString("renewal_card_id")!=null?rs.getString("renewal_card_id"):"");
		packageDefinition.setPkgPrice(rs.getString("pkg_price"));
		packageDefinition.setOcId(rs.getInt("oc_id"));
		packageDefinition.setSubscriberSiteAllowanceType((rs.getString("subscriber_site_allowance_type").equals(0)?"Disallow":rs.getString("subscriber_site_allowance_type").equals(1)?"Members Control": "Allow").toString());
		packageDefinition.setOrderCode(rs.getString("order_code"));
		return packageDefinition;
	}

	
}
