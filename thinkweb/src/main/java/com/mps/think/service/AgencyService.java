package com.mps.think.service;

import java.sql.SQLException;
import java.util.List;

import com.mps.think.model.AgencyAttributeModel;

public interface AgencyService {
	
	public List<AgencyAttributeModel> getAgencyList()
			throws SQLException;
	public List<AgencyAttributeModel> getAgencySearch( AgencyAttributeModel agencyAttributeModel)
			throws SQLException;
	public String editAgency( AgencyAttributeModel agencyAttributeModel)
			throws SQLException;
}
