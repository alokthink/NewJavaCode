package com.mps.think.process.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.process.dao.RenewalDao;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.resultMapper.RenewalEffortMapper;
import com.mps.think.process.resultMapper.RenewalMapper;

@Repository
public class RenewalDaoImpl implements RenewalDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(RenewalDaoImpl.class);
	private static final String ERROR = "Error"; 
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<RenewalModel> getRenewalDetails() {

		LOGGER.info("Inside getRenewalDetails");
		List<RenewalModel> result = null;
		try {
				  StringBuilder querys = new StringBuilder("select * from renewal_def");
				   result = (List<RenewalModel>) jdbcTemplate.query(querys.toString(), new RenewalMapper());
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	
	}

	@Override
	public List<RenewalModel> getSelectedRenewals(String renewal_def) {

		LOGGER.info("Inside getSelectedRenewals");
		List<RenewalModel> result = null;
		try {
				  StringBuilder querys = new StringBuilder("select * from renewal_def where renewal_def='" + renewal_def + "'");
				   result = jdbcTemplate.query(querys.toString(), new RenewalMapper());
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	
	}

	@Override
	public List<Map<String, Object>> getselectedValue(String renewal_def) {
	
		LOGGER.info("Inside getselectedValue");
		List<Map<String, Object>> result=new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from renewal_def_oc where renewal_def='" + renewal_def + "'");
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

}

	@Override
	public List<RenewalEffortModel> getEffortDetails(String renewal_def) {
	
		LOGGER.info("Inside getEffortDetails");
		List<RenewalEffortModel> result = null;
		try {
			StringBuilder query = new StringBuilder("select * from renewal_def_effort where renewal_def='" + renewal_def + "'");
			result = jdbcTemplate.query(query.toString(),new RenewalEffortMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

}

}
