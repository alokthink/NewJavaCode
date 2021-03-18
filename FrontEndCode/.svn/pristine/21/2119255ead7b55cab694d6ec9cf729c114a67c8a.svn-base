package com.mps.think.process.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.util.PropertyUtility;

public class RenewalMapper implements RowMapper<RenewalModel> {
	
	
	public RenewalModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		RenewalModel renewalModel = new RenewalModel();
		renewalModel.setRenewalDef(rs.getString("renewal_def"));
		renewalModel.setActiveTesting(rs.getInt("active_testing"));
		renewalModel.setDescription(rs.getString("description"));
		renewalModel.setExtract(rs.getString("extract") != null ? rs.getString("extract") : "");
		renewalModel.setRenewalDefSeq(rs.getInt("mru_renewal_def_test_seq"));
		renewalModel.setRenewalType(new PropertyUtility().getConstantValue("renewal_type_"+rs.getInt("renewal_type")));

		return renewalModel;
	}

	




}
