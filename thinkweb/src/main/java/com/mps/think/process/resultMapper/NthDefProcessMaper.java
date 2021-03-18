package com.mps.think.process.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.process.daoImpl.ProcessDetailsDaoImp;
import com.mps.think.process.model.NthModel;

public class NthDefProcessMaper implements RowMapper<NthModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessDetailsDaoImp.class);
	private static final String ERROR = "Error"; 
	@Override
	public NthModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		NthModel model = new NthModel();
		
	try {
	    model.setCode(rs.getString("nth_def"));
		model.setDescription(rs.getString("description"));
		model.setActive(rs.getInt("active"));
		model.setEveryNthRecord(rs.getInt("get_every"));
		model.setNthCount(rs.getString("nth_count"));
		model.setNthPercentage(rs.getString("nth_percent"));
		model.setStartingRecord(rs.getInt("start_with_record"));
		model.setProcessSort(rs.getString("process_sort") != null ? rs.getString("process_sort"): "");
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
		return model;
	}
}


