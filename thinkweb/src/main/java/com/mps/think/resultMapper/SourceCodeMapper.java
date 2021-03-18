package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.SourceCode;
import com.mps.think.util.PropertyUtilityClass;

public class SourceCodeMapper implements RowMapper<SourceCode>{

	private static final Logger LOGGER = LoggerFactory.getLogger(SourceCodeMapper.class);
	@Override
	public SourceCode mapRow(ResultSet rs, int rowNum) throws SQLException {
		SourceCode sourceCode=new SourceCode();
		try{
			sourceCode.setSourceCodeId(rs.getInt("source_code_id"));
			sourceCode.setSourceCode(rs.getString("source_code"));
			sourceCode.setDescription(rs.getString("description"));
			sourceCode.setOrderClass(rs.getString("oc"));
			sourceCode.setSourceCodeType(new PropertyUtilityClass().getConstantValue("source_code.source_code_type_"+rs.getInt("source_code_type")));
			sourceCode.setGenerated(rs.getInt("generated"));
			sourceCode.setOffer(rs.getString("offer"));
			sourceCode.setList(rs.getString("list"));
			sourceCode.setGenericAgency(rs.getInt("generic_agency"));
		}catch(Exception e){
			LOGGER.info(""+e);
		}
		return sourceCode;
	}

}
