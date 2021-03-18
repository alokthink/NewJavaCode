package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.AgencyDao;
import com.mps.think.model.AgencyAttributeModel;
import com.mps.think.service.AgencyService;

@Service("AgencyService")
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	AgencyDao agencyDao;
	
	@Override
	public List<AgencyAttributeModel> getAgencyList() throws SQLException {
		return agencyDao.getAgencyList();
	}
	
	@Override
	public List<AgencyAttributeModel> getAgencySearch( AgencyAttributeModel agencyAttributeModel)
			throws SQLException{
		return agencyDao.getAgencySearch(agencyAttributeModel);
	}
	
	@Override
	public String editAgency( AgencyAttributeModel agencyAttributeModel)
			throws SQLException{
		return agencyDao.editAgency(agencyAttributeModel);
	}
}
