package com.mps.think.process.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mps.think.process.dao.RenewalDao;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.service.RenewalService;

@Service("RenewalService")
public class RenewalServiceImpl implements RenewalService {
	@Autowired
	RenewalDao renewalDao;  
	
	@Override
	public List<RenewalModel> getRenewalDetails() {
		return renewalDao.getRenewalDetails();
	}

	@Override
	public List<RenewalModel> getSelectedRenewals(String renewal_def) {
		// TODO Auto-generated method stub
		return renewalDao.getSelectedRenewals(renewal_def);
	}

	@Override
	public List<Map<String, Object>> getselectedValue(String renewal_def) {
		// TODO Auto-generated method stub
		return renewalDao.getselectedValue(renewal_def);
	}

	@Override
	public List<RenewalEffortModel> getEffortDetails(String renewal_def) {
		// TODO Auto-generated method stub
		return renewalDao.getEffortDetails(renewal_def);
	}

}
