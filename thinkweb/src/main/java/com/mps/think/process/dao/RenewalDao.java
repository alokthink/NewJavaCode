package com.mps.think.process.dao;

import java.util.List;
import java.util.Map;

import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;

public interface RenewalDao {

	List<RenewalModel> getRenewalDetails();

	List<RenewalModel> getSelectedRenewals(String renewal_def);

	List<Map<String, Object>> getselectedValue(String renewal_def);

	List<RenewalEffortModel> getEffortDetails(String renewal_def);

}
