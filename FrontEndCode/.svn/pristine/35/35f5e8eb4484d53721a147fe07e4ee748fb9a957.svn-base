package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.dao.AgencyDao;
import com.mps.think.model.AgencyAttributeModel;
import com.mps.think.resultMapper.AgencyMapper;
import com.mps.think.util.CustomerUtility;

@Repository
public class AgencyDaoImpl implements AgencyDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AgencyDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private CustomerUtility customerUtility;

	@Override
	public List<AgencyAttributeModel> getAgencyList() throws SQLException {
		LOGGER.info("Inside getAgencyList");
		List<AgencyAttributeModel> result = null;
		try {
			StringBuilder query = new StringBuilder("select * from agency order by company");

			result = jdbcTemplate.query(query.toString(), new AgencyMapper());
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}
	
	@Override
	public List<AgencyAttributeModel> getAgencySearch( AgencyAttributeModel agencyAttributeModel){
		LOGGER.info("Inside getAgencySearch");
		List<AgencyAttributeModel> searchresult = null;
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			StringBuilder query = new StringBuilder("select * from agency where 1=1");
			
			if("*".equals(agencyAttributeModel.getAgencyCode()))
				query.append(" AND agency_code LIKE '%'");
			else if(agencyAttributeModel.getAgencyCode()!=null && !"".equals(agencyAttributeModel.getAgencyCode())) {
				query.append(" and agency_code like :agency_code");
				parameters.put("agency_code", "%"+agencyAttributeModel.getAgencyCode()+"%");
			}
			
			if("*".equals(agencyAttributeModel.getCompany()))
				query.append(" AND company LIKE '%'");
			else if(agencyAttributeModel.getCompany()!=null && !"".equals(agencyAttributeModel.getCompany())) {
				query.append(" and company like :company");
				parameters.put("company", "%"+agencyAttributeModel.getCompany()+"%");
			}
			
			if(agencyAttributeModel.getCustomerId()!=null) {
				query.append(" and customer_id=:customer_id");
				parameters.put("customer_id", agencyAttributeModel.getCustomerId());
			}
			
			query.append(" order by company");

			searchresult = namedParameterJdbcTemplate.query(query.toString(),parameters, new AgencyMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return searchresult;
	}
	
	@Override
	public String editAgency( AgencyAttributeModel agencyAttributeModel){
		LOGGER.info("Inside editAgency");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String updateQuery ="update agency set "
					+"agency_code=:agency_code,company=:company,payment_threshold=:payment_threshold,discounts=:discounts,agency_bill_to=:agency_bill_to,agency_renew_to=:agency_renew_to,"+
					"agency_pays_tax=:agency_pays_tax,tax_based_on_gross=:tax_based_on_gross,new_commission=:new_commission,ren_commission=:ren_commission,remit=:remit where customer_id=:customer_id";
			parameters.put("customer_id", agencyAttributeModel.getCustomerId());
			parameters.put("agency_code",  customerUtility.getStringValue(agencyAttributeModel.getAgencyCode()));
			parameters.put("company",customerUtility.getStringValue(agencyAttributeModel.getCompany()));
			parameters.put("payment_threshold", customerUtility.getStringValue(agencyAttributeModel.getPaymentThershold()));
			parameters.put("discounts", "1".equals(agencyAttributeModel.getBundleDiscount()) ? 1 : 0);
			parameters.put("agency_bill_to", "1".equals(agencyAttributeModel.getIsBillTo()) ? 1 : 0);
			parameters.put("agency_renew_to", "1".equals(agencyAttributeModel.getIsRenewTo()) ? 1 : 0);
			parameters.put("agency_pays_tax", "1".equals(agencyAttributeModel.getAgencyPayTax()) ? 1 : 0);
			parameters.put("tax_based_on_gross", agencyAttributeModel.getTaxPayedOnGross());
			parameters.put("ren_commission", null == agencyAttributeModel.getRenewalCommission() ? 0
					: agencyAttributeModel.getRenewalCommission());
			parameters.put("new_commission", null == agencyAttributeModel.getNewOrderCommission() ? 0
					: agencyAttributeModel.getNewOrderCommission());
			parameters.put("remit", agencyAttributeModel.getRemits());
			namedParameterJdbcTemplate.update(updateQuery, parameters);
			return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}
}
