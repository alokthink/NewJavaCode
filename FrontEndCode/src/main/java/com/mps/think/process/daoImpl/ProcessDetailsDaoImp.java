package com.mps.think.process.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.model.DropdownModel;
import com.mps.think.process.dao.ProcessDetailsDao;
import com.mps.think.process.model.AccountingPeriod;
import com.mps.think.process.model.EffortModel;
import com.mps.think.process.model.ExtractFilterChildTemplateModel;
import com.mps.think.process.model.ExtractFilterParentTemplateModel;
import com.mps.think.process.model.ExtractGroupBreakModel;
import com.mps.think.process.model.ExtractGroupModel;
import com.mps.think.process.model.ExtractModel;
import com.mps.think.process.model.InsertsModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.process.model.JobOutputModel;
import com.mps.think.process.model.NthModel;
import com.mps.think.process.model.OutputModel;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.model.ProfitCenter;
import com.mps.think.process.model.PromotionModel;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.SortModel;
import com.mps.think.process.model.SplitDetailModel;
import com.mps.think.process.model.SubmitJobModel;
import com.mps.think.process.resultMapper.EffortMapper;
import com.mps.think.process.resultMapper.JobQueueMapper;
import com.mps.think.process.resultMapper.NthDefProcessMaper;
import com.mps.think.process.resultMapper.OutputMapper;
import com.mps.think.process.resultMapper.ProcessMapper;
import com.mps.think.process.resultMapper.RenewalEffortMapper;
import com.mps.think.process.util.PropertyUtility;
import com.mps.think.setup.util.PropertyUtils;
import com.mps.think.util.PropertyUtilityClass;

@Repository
public class ProcessDetailsDaoImp implements ProcessDetailsDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessDetailsDaoImp.class);
	private static final String ERROR = "Error";

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ProcessModel> getProcessDetails(String active, String inactive) {
		LOGGER.info("Inside getProcessDetail");
		List<ProcessModel> result = null;
		StringBuilder query = new StringBuilder("select * from process where active ");
		try {
			if (!("true").equals(active) && !("true").equals(inactive)) {
				query.append("not in(0,1)");
				result = jdbcTemplate.query(query.toString(), new ProcessMapper());
			} else if (("true").equals(active) && ("true").equals(inactive)) {
				query.append("in(0,1)");
				result = jdbcTemplate.query(query.toString(), new ProcessMapper());
			} else if (!("").equals(active) && ("true").equals(active)) {
				query.append("in(1)");
				result = jdbcTemplate.query(query.toString(), new ProcessMapper());
			} else if (!("").equals(inactive) && ("true").equals(inactive)) {
				query.append("in(0)");
				result = jdbcTemplate.query(query.toString(), new ProcessMapper());
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<DropdownModel> getbankDefDetails() {
		LOGGER.info("Inside getbankDefDetails");
		List<DropdownModel> bankDefList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select description, ics_bank_def_id , bank_code from view_ics_bank_def where show_all_cc=0");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("ics_bank_def_id").toString());
				model.setDisplay((String) row.get("bank_code"));
				model.setDescription(row.get("description").toString());
				bankDefList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return bankDefList;
	}

	@Override
	public List<Map<String, Object>> getselectedValue(int processId) {

		LOGGER.info("Inside getSelectedValue");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from process_oc where process_id=" + processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public Object getOrderDetails(int processId, int processOcType) {

		LOGGER.info("Inside OrderDetails");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			if (processOcType == 1) {
				result = jdbcTemplate.queryForList(
						"select distinct oc.oc_id,oc.oc,oc.description,oc.oc_type,(case when process_oc.process_id="
								+ processId + " then 1 else 0 end)"
								+ " as Active from oc left join process_oc on process_oc.oc_id=oc.oc_id and process_oc.process_id="
								+ processId + " where oc_type in (1)");
			} else if (processOcType == 3) {
				result = jdbcTemplate.queryForList(
						"select distinct oc.oc_id,oc.oc,oc.description,oc.oc_type,(case when process_oc.process_id="
								+ processId + " then 1 else 0 end)"
								+ " as Active from oc left join process_oc on process_oc.oc_id=oc.oc_id and process_oc.process_id="
								+ processId + " where oc_type in (2)");
			} else if (processOcType == 2) {
				result = jdbcTemplate.queryForList(
						"select distinct oc.oc_id,oc.oc,oc.description,oc.oc_type,(case when process_oc.process_id="
								+ processId + " then 1 else 0 end)"
								+ " as Active from oc left join process_oc on process_oc.oc_id=oc.oc_id and process_oc.process_id="
								+ processId + " where oc.oc_type in (1,3,4,5)");
			} else {
				result = jdbcTemplate.queryForList(
						"select distinct oc.oc_id,oc.oc,oc.description,oc.oc_type,(case when process_oc.process_id="
								+ processId + " then 1 else 0 end)"
								+ " as Active from oc left join process_oc on process_oc.oc_id=oc.oc_id and process_oc.process_id="
								+ processId);
			}
			;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public ProcessModel getDefaultProcessDetails(int processId) {

		LOGGER.info("Inside getDefaultProcessDetails");
		ProcessModel result = null;
		try {
			StringBuilder query = new StringBuilder("select * from process where process_id=" + processId);
			result = jdbcTemplate.queryForObject(query.toString(), new ProcessMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public List<DropdownModel> getQueueDetails() {
		LOGGER.info("Inside getQueueDetails");
		List<DropdownModel> queueDetailsList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from queue");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("queue").toString());
				model.setDisplay((String) row.get("description"));
				queueDetailsList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return queueDetailsList;

	}

	@Override
	public List<DropdownModel> getGroupDetails() {
		LOGGER.info("Inside getGroupDetails");
		List<DropdownModel> groupDetailsList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from label_group");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("label_group").toString());
				model.setDisplay(row.get("description").toString());
				groupDetailsList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return groupDetailsList;

	}

	@Override
	public List<DropdownModel> getKeylineDetails() {
		LOGGER.info("Inside getKeylineDetails");
		List<DropdownModel> keylineDetailsList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select label_keyline,description from label_keyline");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("label_keyline").toString());
				model.setDisplay(row.get("description") != null ? (String) row.get("description") : "");

				keylineDetailsList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return keylineDetailsList;

	}

	@Override
	public List<DropdownModel> getOutputSortDetails() {
		LOGGER.info("Inside getOutputSortDetails");
		List<DropdownModel> keylineDetailsList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from process_sort");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("process_sort").toString());
				model.setDisplay(row.get("description").toString());
				keylineDetailsList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return keylineDetailsList;

	}

	@Override
	public List<Map<String, Object>> getselectedPCValue(int processId) {

		LOGGER.info("Inside getselectedPCValue");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from process_profit_center where process_id=" + processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getPCDetails(int processId) {

		LOGGER.info("Inside getPCDetails");

		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList(
					"select distinct profit_center.profit_center,profit_center.description,(case when process_profit_center.process_id="
							+ processId + "then 1 else 0 end)"
							+ " as Active from profit_center left join process_profit_center on process_profit_center.profit_center=profit_center.profit_center and process_profit_center.process_id="
							+ processId + "");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getbacsSelectionCurrency() {

		LOGGER.info("Inside getPCDetails");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select currency,description,currency_symbol from currency");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public List<Map<String, Object>> getselectedCurrency(int processId) {

		LOGGER.info("Inside getselectedCurrency");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from process_currency_relator where process_id=" + processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getCleanupDefinitionDetails() {
		LOGGER.info("Inside Cleanup details");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("Select cleanup_def,description from cleanup_def");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getselectedCleanupValue(int processId) {
		LOGGER.info("Inside getselectedCleanupValue");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from process_cleanup_def where process_id=" + processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getLabelFormateList() {
		return null;
	}

	@Override
	public List<Map<String, Object>> getselectedReports(int processId) {

		LOGGER.info("Inside getselectedReports");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from process_audit_report where process_id=" + processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getauditReports() {

		LOGGER.info("Inside getauditReports");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("Select audit_report_id,audit_report,description from audit_report");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public List<DropdownModel> getOrderClass() {
		LOGGER.info("Inside getOrderClass");
		List<DropdownModel> orderList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select oc_id,oc,description,oc_type from oc where oc_type=1");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("oc_id").toString());
				model.setDisplay((String) row.get("oc"));
				model.setDescription(row.get("description") != null ? (String) row.get("description") : "");
				orderList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderList;

	}

	@Override
	public String deleteProcessDetails(int processId) {
		LOGGER.info("Inside deleteProcessDetails");
		try {
			List<Map<String, Object>> query = jdbcTemplate
					.queryForList("select process_id from process_oc where process_id =" + processId);
			List<Map<String, Object>> query1 = jdbcTemplate
					.queryForList("select process_id from job where process_id =" + processId);
//			for (Map<String, Object> row : query) {

			if (query.size() == 0 && query1.size() == 0) {
				Map<String, Object> parameters = new HashMap<String, Object>();
				String result = "delete from process where process_id = :process_id";
				parameters.put("process_id", processId);
				namedParameterJdbcTemplate.update(result, parameters);
				return "Deleted";
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

	}

	@Override
	public String getDefaultDropdown(int processId) throws SQLException {
		String result = jdbcTemplate.queryForObject("select process_type from process where process_id=" + processId,
				String.class);
		return result;
	}

	@Override
	public String addNewProcess(int processType) {
		LOGGER.info("Inside addNewProcess");
		try {
			String addProcessQuery = "insert into process (process_id,active,process_type,job_completion_email_address) values "
					+ " (:process_id,:active,:process_type,:job_completion_email_address)";

			Map<String, Object> addProcessParams = new HashMap<String, Object>();

			String procesIdsresult = jdbcTemplate.queryForObject(
					"select MAX(process_id) from process where process_id not like'2100000%'", String.class);

			addProcessParams.put("process_id", Integer.parseInt(procesIdsresult) + 1);
			addProcessParams.put("active", 1);
			addProcessParams.put("process_type", processType);
			addProcessParams.put("job_completion_email_address", "rwalgren@thinksubscription.com");

			namedParameterJdbcTemplate.update(addProcessQuery, addProcessParams);
			return "Added" + "-" + (Integer.parseInt(procesIdsresult) + 1);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

	}

	@Override
	public List<DropdownModel> getExtractDetails() {
		LOGGER.info("Inside getExtractDetails");
		List<DropdownModel> extractList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select extract,description from extract");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("extract").toString());
				model.setDisplay(row.get("description") != null ? row.get("description").toString() : "");
				extractList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return extractList;

	}

	@Override
	public List<ProcessModel> getPaymentDetails(int processId) {

		LOGGER.info("Inside PaymentDetails");
		List<ProcessModel> result = null;
		try {
			StringBuilder query = new StringBuilder("select * from process where process_id=" + processId);
			result = jdbcTemplate.query(query.toString(), new ProcessMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public List<Map<String, Object>> getSelectedValue(int processId) {

		LOGGER.info("Inside getSelectedValue");
		List<Map<String, Object>> result = new ArrayList<>();
		try {

			result = jdbcTemplate.queryForList("select * from process_oc where process_id=" + processId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getAuditOrderDetails(int processId) {

		LOGGER.info("Inside getAuditOrderDetails");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate
					.queryForList("select distinct oc.oc,oc.oc_id,description,oc_type,(case when process_oc.process_id="
							+ processId + " then 1 else 0 end) as Active "
							+ " from pub,oc left join process_oc on process_oc.oc_id=oc.oc_id and process_oc.process_id="
							+ processId + " where oc.oc_id=pub.oc_id " + " AND oc.oc_type=1 AND pub.audited=1");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getRenewalDefDetails(int processId, int requal) {

		LOGGER.info("Inside getRenewalDefDetails");
		List<Map<String, Object>> results = new ArrayList<>();
		try {
			if (requal == 0)
				results = jdbcTemplate.queryForList(
						"select distinct renewal_def.renewal_def,renewal_def.description,renewal_def.renewal_type,renewal_def.mru_renewal_def_test_seq,"
								+ "renewal_def.extract,(case when process_renewal_effort.process_id=" + processId
								+ "then 1 else 0 end) as Active from"
								+ " renewal_def left join process_renewal_effort on process_renewal_effort.renewal_def=renewal_def.renewal_def and process_renewal_effort.process_id="
								+ processId);

			else if (requal == 1)
				results = jdbcTemplate.queryForList(
						"select distinct renewal_def.renewal_def,renewal_def.description,renewal_def.renewal_type,renewal_def.mru_renewal_def_test_seq,"
								+ "(case when process_renewal_effort.process_id=" + processId
								+ " then 1 else 0 end) as Active from "
								+ " renewal_def left join process_renewal_effort on process_renewal_effort.renewal_def=renewal_def.renewal_def and process_renewal_effort.process_id="
								+ processId + " where renewal_type = 2");
			for (Map<String, Object> result : results)
				if (result.get("extract") == null) {
					result.put("extract", "");
				}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return results;

	}

	@Override
	public List<DropdownModel> getrenewalCardDetails(String ocId, String renewalDef) {
		LOGGER.info("Inside getrenewalCardDetails");
		List<DropdownModel> renCardList = new ArrayList<>();
		try {
			Integer result = jdbcTemplate.queryForObject(
					"select COUNT(*) from renewal_def_oc where renewal_def='" + renewalDef + "'", Integer.class);
			if (result > 0) {
				List<Map<String, Object>> rows = jdbcTemplate
						.queryForList("select * from renewal_card where oc_id IN(" + ocId + ")");
				for (Map<String, Object> row : rows) {
					DropdownModel model = new DropdownModel();
					model.setKey(row.get("renewal_card_id").toString());
					model.setDisplay(row.get("renewal_card").toString() + " - " + row.get("oc_id"));
					model.setDescription((String) row.get("description"));
					renCardList.add(model);
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renCardList;

	}

	@Override
	public List<DropdownModel> getVolumeGroupDetails() {
		LOGGER.info("Inside getVolumeGroupDetails");
		List<DropdownModel> volumeGroupList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select volume_group_id,volume from volume_group");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("volume_group_id").toString());
				model.setDisplay(row.get("volume").toString());
				volumeGroupList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return volumeGroupList;

	}

	@Override
	public Object getRenewalDefByDefault() {

		LOGGER.info("Inside getRenewalDefByDefault");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate
					.queryForList("select renewal_def,description,(case when renewal_type = 0 then 'By Issue/Unit' "
							+ " when renewal_type = 1 then 'By Volume Group' else 'Requal' end) as renewal_type,mru_renewal_def_test_seq from renewal_def");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getRenewalEffortDetails(int processId) {

		LOGGER.info("Inside getRenewalEffortDetails");
		List<RenewalEffortModel> result = null;
		try {
			StringBuilder query = new StringBuilder("select distinct renewal_def_effort.*,"
					+ "(case when renewal_def_effort.effort_number IN(select effort_number from process_renewal_effort where process_id="
					+ processId + ") "
					+ "and renewal_def_effort.renewal_def IN(select renewal_def from process_renewal_effort where process_id="
					+ processId + ") then 1 else 0 end) " + " as Active from "
					+ " renewal_def_effort left join process_renewal_effort on"
					+ " renewal_def_effort.renewal_def=process_renewal_effort.renewal_def and process_renewal_effort.process_id="
					+ processId);

			result = jdbcTemplate.query(query.toString(), new RenewalEffortMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public Object getOrderDetailsTypeAll() {

		LOGGER.info("Inside getOrderDetailsTypeAll");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate
					.queryForList("select distinct oc.oc_id,oc.description,oc.oc,renewal_def_oc.renewal_def,"
							+ "(case when renewal_def_oc.oc_id in (select oc_id from renewal_def_oc) then 1 else 0 end) as Active"
							+ " from oc left join renewal_def_oc on oc.oc_id=renewal_def_oc.oc_id where oc_type IN(1,2,3) ");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public List<Map<String, Object>> getBillingDef() {
		LOGGER.info("Inside getBilingDefinition");
		List<Map<String, Object>> result = new ArrayList<>();
		try {

			result = jdbcTemplate.queryForList("select billing_def, description  from billing_def ");
			/*
			 * List<Map<String, Object>> rows = jdbcTemplate
			 * .queryForList("select billing_def,description from billing_def"); for
			 * (Map<String, Object> row : rows) { DropdownModel model = new DropdownModel();
			 * model.setKey(row.get("billing_def").toString());
			 * model.setDisplay(row.get("billing_def").toString() + "-" +(String)
			 * row.get("description")); billingDefList.add(model);
			 */
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	public List<Map<String, Object>> getBillDefinintion(int processId) {
		LOGGER.info("Inside getBillDefinition");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(
					"select distinct billing_def.billing_def,isnull(billing_def.description,'')as description,isnull(billing_def.extract,'')as extract,"
							+ "(case when process_billing_effort.process_id=" + processId
							+ " then 1 else 0 end) as Active from "
							+ "billing_def left join process_billing_effort on process_billing_effort.billing_def=billing_def.billing_def and process_billing_effort.process_id="
							+ processId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<EffortModel> getBillingEffort(int processId) {
		LOGGER.info("Inside Get Billing Effort");
		List<EffortModel> result = null;
		try {
			StringBuilder query = new StringBuilder("select distinct billing_def_effort.*,"
					+ "(case when billing_def_effort.effort_number IN(select effort_number from process_billing_effort where process_id="
					+ processId + ")"
					+ "and billing_def_effort.billing_def IN(select billing_def from process_billing_effort where process_id="
					+ processId + ") then 1 else 0 end)" + " as Active from"
					+ " billing_def_effort left join process_billing_effort on"
					+ " billing_def_effort.billing_def=process_billing_effort.billing_def and process_billing_effort.process_id="
					+ processId + " ");

			result = jdbcTemplate.query(query.toString(), new EffortMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getBillOrderClass() {
		LOGGER.info("Inside Get Bill Order Class");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate
					.queryForList("select distinct oc.oc_id,oc.description,oc.oc,billing_def_oc.billing_def,"
							+ "(case when billing_def_oc.oc_id in (select oc_id from billing_def_oc) then 1 else 0 end) as Active"
							+ " from oc left join billing_def_oc on oc.oc_id=billing_def_oc.oc_id where oc_type IN(1,2,3) ");
			// "select distinct oc.oc_id,isnull(oc.description,'') as
			// description,oc.oc,(case when billing_def_oc.oc_id in (select oc_id from
			// billing_def_oc) then 1 else 0 end) as Active from oc left join billing_def_oc
			// on oc.oc_id=billing_def_oc.oc_id where oc_type IN(1,2,3)"
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getBilltesting(String billingDef) {
		LOGGER.info("Inside Get Bill Testing");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(
					"select bdt.description,isnull(bdt.nth_def,'') as nth_def,billing_def_test_seq as billingDefTestSeq,bd.billing_def from billing_def_test bdt join billing_def bd on bdt.billing_def=bd.billing_def and bd.active_testing=1 where bd.billing_def='"
							+ billingDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getInstallmentDetails(int processId) {

		List<Map<String, Object>> displayDetails = new ArrayList<>();
		try {
			displayDetails = jdbcTemplate.queryForList(
					"select distinct installment_plan.installment_plan_id,installment_plan.description,(case when process_installment_plan.process_id="
							+ processId + " then 1 else 0 end)" + " AS Active from installment_plan "
							+ "LEFT JOIN process_installment_plan on installment_plan.installment_plan_id=process_installment_plan.installment_plan_id and  process_installment_plan.process_id="
							+ processId + "");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return displayDetails;
	}

	@Override
	public List<DropdownModel> getOutputType() {
		LOGGER.info("Inside getOutputType");
		List<DropdownModel> viewOutputTypeList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"SELECT X.* FROM (VALUES ('0','Label'),('1', 'Renewal'),('2', 'Billing'),('3', 'Refund'),('4', 'List Extract'),"
							+ "('5', 'Product Fulfillment'),('6', 'Pick List'),('7', 'Payment'),('8', 'Report'),"
							+ "('9', 'Accounting Reconciliation'),('10', 'Installment Plan'),('11', 'Audit Reports'),('12', 'Start/Stop'),"
							+ "('13', 'Unused'),('14', 'Installment Notice'),('15', 'Promotion'),('16', 'Repeating Job'),"
							+ "('17', 'Auddis')) AS X (output, description)");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("output").toString());
				model.setDisplay(row.get("description").toString());
				viewOutputTypeList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error("Error: " + e);
		}
		return viewOutputTypeList;

	}

	@Override
	public List<DropdownModel> getOutput() {
		List<Map<String, Object>> displayOutput = new ArrayList<>();
		List<DropdownModel> outputList = new ArrayList<>();
		try {
			displayOutput = jdbcTemplate.queryForList(
					"select report as output,report.description as outputDescription,output_filename,output_mode,cof.description from report left join crystal_output_format cof on report.crystal_output_format_id=cof.crystal_output_format_id");
			for (Map<String, Object> row : displayOutput) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("output").toString());
				model.setDisplay(row.get("output").toString());
				model.setDescription(
						row.get("outputDescription") != null ? row.get("outputDescription").toString() : "");
				outputList.add(model);
			}

		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return outputList;

	}

	@Override
	public List<DropdownModel> getOutputFileFormat() {
		List<Map<String, Object>> displayOutputFileFormat = new ArrayList<>();
		List<DropdownModel> outputFileFormat = new ArrayList<>();
		try {
			displayOutputFileFormat = jdbcTemplate
					.queryForList("select crystal_output_format_id ,description from crystal_output_format");
			for (Map<String, Object> row : displayOutputFileFormat) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("crystal_output_format_id").toString());
				model.setDisplay(row.get("description").toString());
				outputFileFormat.add(model);
			}

		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return outputFileFormat;

	}

	@Override
	public List<DropdownModel> getOc() {
		List<DropdownModel> ocList = new ArrayList<>();
		List<Map<String, Object>> displayDetails = new ArrayList<>();
		try {
			displayDetails = jdbcTemplate.queryForList(
					"select distinct oc.oc_id,oc,oc_type,oc.description from oc oc left join order_code ord on ord.oc_id=oc.oc_id "
							+ "AND  (active = 1 and ord.order_code_type != 3 and ord.order_code_type != 8 and premium != 2) "
							+ " ORDER BY oc.oc");

			for (Map<String, Object> row : displayDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("oc_id").toString());
				model.setDisplay(row.get("oc").toString());
				model.setDescription(row.get("description") != null ? row.get("description").toString() : "");
				model.setExtra(new PropertyUtility().getConstantValue("oc_type_" + row.get("oc_type").toString()));
				ocList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return ocList;
	}

	@Override
	public List<DropdownModel> getAuditReport() {
		List<DropdownModel> audutReportList = new ArrayList<>();
		List<Map<String, Object>> displayauditReportList = new ArrayList<>();
		try {
			displayauditReportList = jdbcTemplate
					.queryForList("select audit_report_id,audit_report,description from audit_report");

			for (Map<String, Object> row : displayauditReportList) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("audit_report_id").toString());
				model.setDisplay(row.get("audit_report").toString());
				model.setDescription(row.get("description") != null ? row.get("description").toString() : "");
				audutReportList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return audutReportList;
	}

	@Override
	public ProcessModel getsubmitjobData(int processId) {
		LOGGER.info("Inside Get Submit Job Data");
		ProcessModel result = null;
		try {
			StringBuilder query = new StringBuilder(
					"SELECT process_id,extract,label_keyline,label_group,description,active,process_type,all_oc,renewals,bills,splits,inserts,promotions,label_length,default_job_priority,process_oc_type,installment_bills,all_installment_plans,all_direct_debits,all_credit_cards,unpaid_resubmit,nth_def,customer_type,all_prospect_categories,multiple_per_customer,oc_id,incl_audit_paragraph_reports,audit_type,validate_adds,batch_template,cancel_reason,grace_new,grace_current,output_sort,pick_list,co_mail,priority_sort,queue,bundle_threshold,all_list_rental_categories,volume_group_id,auto_renewals,"
							+ "schedule_payment_days,bill_grp_bill_to,bill_grp_oclass,bill_grp_order,bill_grp_currency,bill_grp_def,ren_grp_ren_to,ren_grp_oclass,ren_grp_order,ren_grp_currency,ren_grp_def,sql_script,bank_def_id,run_icverify,requal,inv_serve_label,days_before_end,notice_type,resend_notice,"
							+ "includes_proformas,process_deposit_payment,write_recon_dtl,recon_work_dir,ics_bank_def_id,row_version,upd_recon_tables,items_per_request,repeating_type,interval_unit,n_interval_units,job_completion_email_address,driver_type,days_passed_for_pulls,skip_manual_pay_response,auddis_type,generate_renew_offers,"
							+ "do_mass_kill,mass_kill_interval,do_mass_suspend,mass_suspend_interval,audit_paragraph_ignore_back_is,ccard_expire_days,from_email_address,manual_review_fulfillment,auto_renew_expire_days,on_hold_email,output_ready_email,review_ready_email,"
							+ "job_done_email,warning_email,fatal_email,no_connect_email,notification_bits,cleanup_events,leave_dd_account_number_plain,"
							+ "incl_pkg_members FROM process WHERE process_id =" + processId);
			result = jdbcTemplate.queryForObject(query.toString(), new ProcessMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<NthModel> getNthDef() {
		LOGGER.info("inside nth definition");
		List<NthModel> result = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder("select * From nth_def ");
			result = jdbcTemplate.query(query.toString(), new NthDefProcessMaper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getbillingDisplay(int processId) {
		LOGGER.info("Inside getbillingDisplay");
		List<Map<String, Object>> billingDisplay = new ArrayList<>();
		try {
			billingDisplay = jdbcTemplate.queryForList(
					"select includes_proformas,bill_grp_bill_to,bill_grp_currency,bill_grp_def,bill_grp_oclass,bill_grp_order from process where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return billingDisplay;
	}

	@Override
	public List<Map<String, Object>> getRenewalTesting(String renewalDef) {
		LOGGER.info("Inside Get Renewal Testing");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList(
					"select rdt.renewal_def,rdt.renewal_def_test_seq as renewalDefTestSeq,isnull(rdt.description,'') as description,isnull(rdt.nth_def,'') as nth_def from renewal_def_test rdt"
							+ " join renewal_def rd on rdt.renewal_def=rd.renewal_def and rd.active_testing=1 where rd.renewal_def='"
							+ renewalDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getDefaultRenewalDetails(int processId) {
		LOGGER.info("Inside getDefaultRenewalDetails");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList(
					"select ren_grp_ren_to as renGrpRenTo,ren_grp_oclass as renGrpOclass,ren_grp_order as renGrpOrder,"
							+ "ren_grp_currency as renGroupCurrency,ren_grp_def as renGrpDef,nth_def as nthDef,requal,generate_renew_offers as generateRenewOffers,"
							+ "volume_group_id as volumeGroupId,incl_pkg_members as inclPkgMembers from process where process_id="
							+ processId + "");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getrenewalDisplay(int processId) {
		List<Map<String, Object>> renewalDisplay = new ArrayList<>();
		try {
			renewalDisplay = jdbcTemplate
					.queryForList("select distinct rde.suppress_email,pre.* from process_renewal_effort pre left join "
							+ " renewal_def_effort rde on pre.renewal_def=rde.renewal_def and pre.effort_number=rde.effort_number where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renewalDisplay;
	}

	@Override
	public List<Map<String, Object>> getBillDisplayData(int processId) {
		List<Map<String, Object>> billDisplay = new ArrayList<>();
		try {
			billDisplay = jdbcTemplate
					.queryForList("select distinct bde.suppress_email, pbe.* from process_billing_effort pbe left join"
							+ " billing_def_effort bde on pbe.billing_def=bde.billing_def and pbe.effort_number=bde.effort_number where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return billDisplay;
	}

	@Override
	public List<DropdownModel> getInstallmentDropDown() {
		LOGGER.info("inside getInstallmentDropDown");
		List<DropdownModel> result = new ArrayList<>();
		try {
			List<Map<String, Object>> query = jdbcTemplate.queryForList(
					"select description, allow_default_usage,auto_setup ,installment_plan_id from installment_plan ");
			for (Map<String, Object> value : query) {
				DropdownModel model = new DropdownModel();
				model.setKey(value.get("installment_plan_id").toString());
				model.setDisplay("Description:" + value.get("description").toString() + " - AllowDefoultUsage:"
						+ value.get("allow_default_usage") + " - AutoSetup:" + value.get("auto_setup")
						+ " - InstallmentPlanId:" + value.get("installment_plan_id"));
				result.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public Object getAllCurrency(int processId) {

		LOGGER.info("Inside getAllCurrency");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("SELECT c.currency,c.user_code,c.description,(case when pcr.process_id="
					+ processId + " then 1 else 0 end) as Active "
					+ "  FROM currency c left join process_currency_relator pcr on c.currency=pcr.currency and process_id="
					+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public Object getPaymentType(int processId) {

		LOGGER.info("Inside getPaymentType");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate
					.queryForList("SELECT pt.payment_type,pt.description,pt.payment_form,(case when pptc.process_id="
							+ processId + " then 1 else 0 end) as Active"
							+ " FROM payment_type pt left join process_pay_type_ccard pptc on pt.payment_type=pptc.payment_type"
							+ "  WHERE payment_form = 1  or payment_form = 2"
							+ "  or payment_form = 3 or payment_form = 4 or payment_form = 6 or payment_form = 7 and process_id="
							+ processId + " ORDER BY payment_type ");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<OutputModel> getOutputData(int processId) {

		LOGGER.info("Inside getOutputData");
		List<OutputModel> result = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"select output_type,oc.oc,process_output.report,output_mode,output_filename,append_job_id,cof.description as output_format,installment_plan,def,test_seq,effort_number,audit_report_id,param_values "
							+ "from process_output left join crystal_output_format cof on cof.crystal_output_format_id=process_output.crystal_output_format_id left join oc on oc.oc_id=process_output.oc_id where process_id="
							+ processId);
			result = jdbcTemplate.query(query.toString(), new OutputMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> displayOutput() {
		LOGGER.info("Inside displayOutput");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(
					"select report,report.description,filename,output_filename as outputFileName,(case when output_mode=0 then 'Print' when output_mode=1 then 'File' when output_mode=2 then 'Window' when output_mode=3 "
							+ " then 'Unused' end )as outputMode,cof.description  as outputFormat  from report left join crystal_output_format cof on report.crystal_output_format_id=cof.crystal_output_format_id ");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getbillingDef() {
		LOGGER.info("Inside getbillingDef");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(
					"select billing_def,isnull(description,'')  as description, isnull(extract,'')as extract from billing_def");
			for (Map<String, Object> row : result)
				if (row.get("description") == null)
					row.put("description", "");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> queueDisplay() {
		LOGGER.info("Inside queueDisplay");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList("select  queue ,description from queue");
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
		}
		return result;
	}

	@Override
	public List<DropdownModel> getJobQueue() {
		LOGGER.info("Inside getJobQueue");
		List<DropdownModel> defoultJobQueue = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select queue,description from queue ");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("queue").toString());
				model.setDisplay(row.get("queue").toString() + "-" + row.get("description"));
				model.setDescription(row.get("description").toString());
				defoultJobQueue.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defoultJobQueue;
	}

	@Override
	public List<Map<String, Object>> billDefinitionTab(String billingDef) {
		LOGGER.info("Inside billDefinitionTab");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(
					"select billing_def,billing_def.extract,billing_def.description,active_testing,extract.description as extractDesc from billing_def "
							+ "left join extract on billing_def.extract=extract.extract where billing_def='"
							+ billingDef + "'");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<EffortModel> getEfforts(String billingDef) {
		LOGGER.info("Inside getEfforts");
		List<EffortModel> result = null;
		try {
			result = jdbcTemplate.query(
					"select *,0 as active from billing_def_effort where billing_def='" + billingDef + "'",
					new EffortMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> renewalDefinitionTab(String renewalDef) {
		LOGGER.info("Inside renewalDefinitionTab");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate
					.queryForList("select renewal_def,ISNULL(extract,'') as extract,renewal_type,description,"
							+ "active_testing from renewal_def where renewal_def='" + renewalDef + "'");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<EffortModel> getRenewalEfforts(String renewalDef) {
		LOGGER.info("Inside getRenewalEfforts");
		List<EffortModel> result = null;
		try {
			result = jdbcTemplate.query(
					"select *,0 as active from renewal_def_effort where renewal_def='" + renewalDef + "'",
					new EffortMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<JobModel> getJobQueueDisp(String queue, String onHold, String ready, String running, String dayEnd) {
		LOGGER.info("Inside getJobQueueDisp");
		List<JobModel> result = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"select job_id,description,note,status,step_name,job_priority,start_date_time,n_candidate_records,n_selected_records,"
							+ " n_updated_records,has_errors,process_id,drop_date,cutoff_date,label_group,label_keyline,creation_date,grace_new,purpose,nth_def,grace_current,list_company"
							+ " from job where");
			if (!"".equals(queue)) {
				query.append("  queue IN(");
				String[] str = queue.split(",");
				for (String queue1 : str) {
					query.append("'" + queue1 + "'" + ",");
				}
				query.setLength(query.length() - 1);
				query.append(")");
			}
			query.append("and status < 4 and (process_id in (2100000001,2100000002,2100000006,2100000007,"
					+ " 2100000008,2100000009) OR  status IN (");
			if (!("true").equals(onHold) && !("true").equals(ready) && !("true").equals(running)
					&& !("true").equals(dayEnd)) {
				query.setLength(query.length() - 117);
				query.append(" 1=2 ");
			} else {

				if ("true".equals(ready)) {
					query.append("0,");
				}
				if ("true".equals(onHold)) {
					query.append("1,");
				}
				if ("true".equals(running)) {
					query.append("2,");
				}
				if ("true".equals(dayEnd)) {
					query.append("3,");
				}
				query.setLength(query.length() - 1);
				query.append("))");
			}
			query.append(" ORDER BY job_priority,start_date_time");
			result = jdbcTemplate.query(query.toString(), new JobQueueMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getJobQueueList() {
		LOGGER.info("Inside getJobQueueList");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select queue,description from queue");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<NthModel> getNthDefDetails() {
		LOGGER.info("inside nth_def Details");
		List<NthModel> result = null;
		try {
			StringBuilder query = new StringBuilder("select * from nth_def");
			result = jdbcTemplate.query(query.toString(), new NthDefProcessMaper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getSelectMethod(int selectMethod) {
		LOGGER.info("inside Get Select method");
		List<Map<String, Object>> result = new ArrayList<>();
		String query = null;
		try {
			switch (selectMethod) {
			case 0:
				query = "select nth_count from  nth_def";
				break;
			case 1:
				query = "select nth_percent from nth_def";
				break;
			case 2:
				query = "select start_with_record,get_every from nth_def ";
				break;
			default:
				break;
			}
			result = jdbcTemplate.queryForList(query);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<JobModel> getDefaultJobQueueDisp() {
		LOGGER.info("inside getDefaultJobQueueDisp() method");
		List<JobModel> result = new ArrayList<>();
		try {
			String query = "select job_id,description,note,status,step_name,job_priority,start_date_time,n_candidate_records,n_selected_records, n_updated_records,"
					+ " has_errors,process_id,drop_date,cutoff_date,label_group,label_keyline,creation_date,grace_new,purpose,nth_def,grace_current,list_company from "
					+ " job where  queue IN(select queue from queue)and status < 4 and (process_id in (2100000001,2100000002,2100000006,2100000007, 2100000008,2100000009)"
					+ " OR  status IN (0,1,2,3)) ORDER BY job_priority,start_date_time";
			result = jdbcTemplate.query(query.toString(), new JobQueueMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Object> getReviewJobHistory(long processId, int status) {
		LOGGER.info("inside getReviewJobHistory");
		List<Object> result = new ArrayList<>();
		try {
			String query = "select FORMAT(creation_date,'MM/dd/yyyy hh:mm:s tt') as creation_date,description,isNull(note,'')as note,FORMAT(cutoff_date,'MM/dd/yyyy hh:mm:s tt') as cutoff_date,FORMAT(drop_date,'MM/dd/yyyy hh:mm:s tt') as drop_date,n_selected_records,n_updated_records,"
					+ "job_id,status,has_errors,grace_current,isNull(list_company,'') as list_company,process_id,grace_new,isNull(label_keyline,'') as"
					+ "label_keyline,isNull(nth_def,'') as nth_def,end_select_date_stamp,isNull(purpose,'') as purpose,label_group FROM job WHERE "
					+ "process_id =" + processId + " and status = 4 ORDER BY end_job_datetime desc, job_id desc";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> row : rows) {
				result.add(row);
			}
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
		}
		return result;
	}

	@Override
	public List<Object> getViewJobLog(long jobId) {
		LOGGER.info("inside getViewJobLog");
		List<Object> result = new ArrayList<>();
		try {
			String query = "select * from job_log where job_id=" + jobId;
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> row : rows) {
				result.add(row);
			}
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
		}
		return result;
	}

	@Override
	public boolean deleteJobQueue(long jobId) {
		LOGGER.info("inside delete Job Queue");
		try {
			Map<String, Object> param = new HashMap<>();
			StringBuilder query = new StringBuilder();
			query.append("delete job_renewal_effort_oc where job_id =:job_id");
			query.append(" delete job_renewal_effort where job_id=:job_id");
			query.append(" delete job_billing_effort_oc where job_id=:job_id");
			query.append(" delete job_billing_effort where job_id=:job_id");
			query.append(" delete job_installment_plan where job_id=:job_id");
			query.append(" delete job_promotion_effort_oc where job_id=:job_id");
			query.append(" delete job_promotion_effort where job_id =:job_id");
			query.append(" delete job_output where job_id =:job_id");
			query.append(" delete job_pub_oc where job_id =:job_id");
			query.append(" delete job_prod_oc where job_id =:job_id");
			query.append(" delete job_profit_center_calendar where job_id =:job_id");
			query.append(" delete job_log where job_id =:job_id");
			query.append(" delete job where job_id =:job_id");
			param.put("job_id", jobId);
			namedParameterJdbcTemplate.update(query.toString(), param);
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public Object getResetDate(long jobId) {
		LOGGER.info("Inside get reset date");
		List<Map<String, Object>> responseObject = new ArrayList<>();
		try {
			responseObject = jdbcTemplate.queryForList(
					"select description,case when status=0 then 'ready' when status=1 then 'on hold' when status=2 then 'running' when status=3 then 'paused' when status=4 then 'done' when status=5 then 'deleting' when status=6 then 'died' when status=7 then 'killed' end status,start_date_time,drop_date,cutoff_date,job_priority from job where job_id="
							+ jobId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		return responseObject;
	}

	@Override
	public boolean getHoldClear(long jobId) {
		LOGGER.info("Inside get Hold Clear");
		boolean responseObject = false;
		try {
			String query = "select count(*) from job";
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			return false;
		}
		return responseObject;

	}

	@Override
	public List<DropdownModel> getProcess() {
		LOGGER.info("Inside get process List method");
		List<DropdownModel> processList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select process_id,active,description,process_type from process ");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("process_id").toString() + "-" + row.get("active"));
				model.setDisplay(row.get("description").toString());
				model.setDescription(row.get("process_type").toString());
				processList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return processList;
	}

	@Override
	public List<Map<String, Object>> getSplit(Integer processId) {
		List<Map<String, Object>> splitList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"select process_id,split_value,description,extract from split_detail where process_id=" + processId);
		try {
			splitList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return splitList;
	}

	@Override
	public int saveSplit(SplitDetailModel splitDetailModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into split_detail( process_id, split_value, description, extract ) values( :process_id, :split_value, :description, :extract )");
		try {
			saveParams.put("process_id", splitDetailModel.getProcessId());
			saveParams.put("split_value", splitDetailModel.getSplitValue());
			if (("null".equals(splitDetailModel.getDescription())) | "".equals(splitDetailModel.getDescription())) {
				saveParams.put("description", null);
			} else {
				saveParams.put("description", splitDetailModel.getDescription());
			}
			saveParams.put("extract", splitDetailModel.getExtract());
			namedParameterJdbcTemplate.update(saveQuery.toString(), saveParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateSplit(SplitDetailModel splitDetailModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update split_detail set split_value=:split_value, description=:description, extract=:extract where process_id=:process_id ");
		try {
			updateParams.put("process_id", splitDetailModel.getProcessId());
			updateParams.put("split_value", splitDetailModel.getSplitValue());
			if (("null".equals(splitDetailModel.getDescription())) | "".equals(splitDetailModel.getDescription())) {
				updateParams.put("description", null);
			} else {
				updateParams.put("description", splitDetailModel.getDescription());
			}
			updateParams.put("extract", splitDetailModel.getExtract());
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<DropdownModel> getExtract() {
		List<DropdownModel> extract = new ArrayList<>();
		try {
			List<Map<String, Object>> Extract = jdbcTemplate.queryForList("select extract,description from extract");
			for (Map<String, Object> extract1 : Extract) {
				DropdownModel model = new DropdownModel();
				model.setKey(extract1.get("extract").toString());
				model.setDisplay(extract1.get("description").toString());
				extract.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return extract;
	}

	@Override
	public int deleteSplit(Integer processId) {
		int status = 0;
		String query = ("delete from split_detail where process_id=" + processId);
		try {
			status = jdbcTemplate.update(query);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getInsertsDetail(int processId) {
		List<Map<String, Object>> insertsDetailList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				" select process_id, bit_position, description, extract from insert_detail where process_id="
						+ processId);
		try {
			insertsDetailList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return insertsDetailList;
	}

	@Override
	public int saveInsertsDetails(InsertsModel insertsModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into insert_detail (process_id, bit_position, description, extract) values (:process_id, :bit_position, :description, :extract)");
		try {
			addParams.put("process_id", insertsModel.getProcessId());
			addParams.put("bit_position", insertsModel.getBitPosition());
			addParams.put("description", insertsModel.getDescription());
			addParams.put("extract", insertsModel.getExtract());
			namedParameterJdbcTemplate.update(query.toString(), addParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateInsertsDetail(InsertsModel insertsModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder query = new StringBuilder(
				"update insert_detail set description =:description, extract =:extract where process_id =:process_id and bit_position =:bit_position ");
		try {
			updateParams.put("process_id", insertsModel.getProcessId());
			updateParams.put("bit_position", insertsModel.getBitPosition());
			updateParams.put("description", insertsModel.getDescription());
			updateParams.put("extract", insertsModel.getExtract());
			namedParameterJdbcTemplate.update(query.toString(), updateParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteInsertsDetail(int processId, int bitPosition) {
		int status = 0;
		try {
			String query = ("delete from insert_detail where process_id = " + processId + " and bit_position = "
					+ bitPosition);
			status = jdbcTemplate.update(query);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public Map<String, Object> getDescritionList(int processId) {
		Map<String, Object> response = new LinkedHashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			list = jdbcTemplate.queryForList("select queue,extract from process where process_id=" + processId);
			String queue = (list.get(0).get("queue")) != null ? (list.get(0).get("queue").toString()) : "";
			String extract = (list.get(0).get("extract")) != null ? (list.get(0).get("extract").toString()) : "";

			if (queue.isEmpty()) {
				response.put("queueDesc", "");
			} else {
				String queueDesc = jdbcTemplate.queryForObject(
						"select description from queue where queue = " + "'" + queue + "'", String.class);
				response.put("queueDesc", queueDesc);
			}
			if (extract.isEmpty()) {
				response.put("extractDesc", "");
			} else {
				String extractDesc = jdbcTemplate.queryForObject(
						"select description from extract where extract = " + "'" + extract + "'", String.class);
				response.put("extractDesc", extractDesc);

			}
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return response;
	}

	@Override
	public int saveSort(SortModel sortModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int maxId = 0;
		int status = 0;
		try {
			if (!(sortModel.getProcessSort().equals(null)) && (!sortModel.getProcessSort().equals(""))) {
				StringBuilder query1 = new StringBuilder(
						"insert into process_sort_field(process_sort_field_seq,process_sort,table_name,column_name,direction)values(:process_sort_field_seq,:process_sort,:table_name,:column_name,:direction)");
				maxId = jdbcTemplate.queryForObject("select max(process_sort_field_seq) from process_sort_field",
						Integer.class);
				if (maxId == 0) {
					addParams.put("process_sort_field_seq", 1);
				} else {
					addParams.put("process_sort_field_seq", maxId + 1);

				}
				addParams.put("process_sort", sortModel.getProcessSort());
				addParams.put("table_name", sortModel.getTableName());
				addParams.put("column_name", sortModel.getColumnName());
				addParams.put("direction", sortModel.getDirection());
				status = namedParameterJdbcTemplate.update(query1.toString(), addParams);

			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveSortDetails(SortModel sortModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder query = new StringBuilder(
					"insert into process_sort(process_sort,description,mru_process_sort_field_seq)values(:process_sort,:description,:mru_process_sort_field_seq)");
			addParams.put("process_sort", sortModel.getProcessSort());
			addParams.put("description", sortModel.getDescription());
			addParams.put("mru_process_sort_field_seq", sortModel.getMruProcessSortFieldSeq());

			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateSort(SortModel sortModel) {
		int status = 0;
		Map<String, Object> updateParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder("update process_sort set description=:description where process_sort='"
				+ sortModel.getProcessSort() + "'");
		try {
			updateParams.put("description", sortModel.getDescription());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

			StringBuilder query1 = new StringBuilder(
					"update process_sort_field set table_name=:table_name,column_name=:column_name,direction=:direction where process_sort='"
							+ sortModel.getProcessSort() + "' and process_sort_field_seq="
							+ sortModel.getProcessSortFieldSeq());
			updateParams.put("table_name", sortModel.getTableName());
			updateParams.put("column_name", sortModel.getColumnName());
			updateParams.put("direction", sortModel.getDirection());
			status = namedParameterJdbcTemplate.update(query1.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteSort(int processSortFieldSeq, String processSort) {
		int status = 0;
		try {
			String query = "delete from process_sort_field where process_sort='" + processSort
					+ "' and process_sort_field_seq=" + processSortFieldSeq;
			status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteSortDetails(String processSort) {
		int status = 0;
		try {
			String query = "delete from process_sort where process_sort='" + processSort + "'";
			status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<SortModel> getProcessSortFieldDetails(int processSortFieldSeq, String processSort) {
		LOGGER.info("Inside getprocessSortField");
		String processSortFieldQuery = "select Process.process_sort,Process.description,Field.process_sort_field_seq,Field.table_name,Field.column_name,Field.direction from process_sort as Process inner join process_sort_field as Field on Process.process_sort='"
				+ processSort + "' and Field.process_sort_field_seq=" + processSortFieldSeq;
		return jdbcTemplate.query(processSortFieldQuery, new ResultSetExtractor<List<SortModel>>() {
			@Override
			public List<SortModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<SortModel> processFieldDetails = new ArrayList<SortModel>();
				while (rs.next()) {
					SortModel sortModel = new SortModel();
					sortModel.setProcessSort(rs.getString("process_sort"));
					sortModel.setDescription(rs.getString("description"));
					sortModel.setProcessSortFieldSeq(rs.getInt("process_sort_field_seq"));
					sortModel.setTableName(rs.getString("table_name"));
					sortModel.setColumnName(rs.getString("column_name"));
					sortModel.setDirection(
							new PropertyUtilityClass().getConstantValue("direction_" + rs.getString("direction")));
					processFieldDetails.add(sortModel);
				}
				return processFieldDetails;

			}
		});

	}

	@Override
	public List<DropdownModel> getTablenameInfo() {
		List<DropdownModel> tableName = new ArrayList<>();
		try {
			List<Map<String, Object>> tableNameDetails = jdbcTemplate.queryForList(
					"select table_name,description from disp_context WHERE (disp_context) IN (('audit_galley_sort_columns'), ('customer_label_columns'), ('customer_address'),('lbl_fmt_order_item'), ('lbl_fmt_state'),('cust_srchfor_subscrip') )");
			for (Map<String, Object> tn : tableNameDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(tn.get("table_name").toString());
				model.setDisplay(tn.get("description").toString());

				tableName.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return tableName;
	}

	@Override
	public int savePromotion(PromotionModel promotionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into promotion_def(promotion_def,extract,description,active_testing,mru_promotion_def_test_seq) values(:promotion_def,:extract,:description,:active_testing,:mru_promotion_def_test_seq)");
		try {
			addParams.put("promotion_def", promotionModel.getPromotionDef());
			addParams.put("extract", promotionModel.getExtract());
			addParams.put("description", promotionModel.getDescription());

			addParams.put("active_testing", 0);
			addParams.put("mru_promotion_def_test_seq", 1);

			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int savePromotionDefTest(PromotionModel promotionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		Integer maxId = null;
		try {
			String value = promotionModel.getActiveTesting();
			if (promotionModel.getActiveTesting().equals("1")) {
				StringBuilder query = new StringBuilder(
						"insert into promotion_def_test(promotion_def_test_seq,description,nth_def,promotion_def)values(:promotion_def_test_seq,:description,:nth_def,:promotion_def)");
				maxId = jdbcTemplate.queryForObject(
						"select max(promotion_def_test_seq) from promotion_def_test where promotion_def='"
								+ promotionModel.getPromotionDef() + "'",
						Integer.class);
				if (maxId == 1) {
					addParams.put("promotion_def_test_seq", 1);
				} else {
					addParams.put("promotion_def_test_seq", maxId + 1);

				}
				String desc = jdbcTemplate
						.queryForObject("select description from promotion_def_test where promotion_def='"
								+ promotionModel.getPromotionDef() + "'", String.class);
				if (!desc.equals("null")) {
					addParams.put("description", desc);

				}
				addParams.put("description", promotionModel.getDescription());

				addParams.put("nth_def", promotionModel.getNthDef());
				addParams.put("promotion_def", promotionModel.getPromotionDef());

				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int savePromtionDefEffort(PromotionModel promotionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		Integer maxId = 0;
		StringBuilder query = new StringBuilder(
				"insert into promotion_def_effort(effort_number,promotion_def,promotion_def_test_seq,attachment_code,message_string,process_method,report,days_from_first_effort)values(:effort_number,:promotion_def,:promotion_def_test_seq,:attachment_code,:message_string,:process_method,:report,:days_from_first_effort)");
		try {
			maxId = jdbcTemplate
					.queryForObject("select max(effort_number)from promotion_def_effort where promotion_def='"
							+ promotionModel.getPromotionDef() + "'", Integer.class);
			if (maxId == null) {
				addParams.put("effort_number", 1);
			} else {
				addParams.put("effort_number", maxId + 1);
			}
			addParams.put("promotion_def", promotionModel.getPromotionDef());
			addParams.put("promotion_def_test_seq", promotionModel.getPromotionDefTestSeq());
			addParams.put("attachment_code", promotionModel.getAttachmentCode());
			addParams.put("message_string", promotionModel.getMessageString());
			addParams.put("process_method", promotionModel.getProcessMethod());
			addParams.put("report", promotionModel.getReport());
			addParams.put("days_from_first_effort", promotionModel.getDaysFromFirstEffort());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getOrderDetailsList(String promotionDef, int ocId) {
		List<Map<String, Object>> processInfo = new ArrayList<>();
		try {

			processInfo = jdbcTemplate.queryForList("SELECT P.oc_id,O.oc,O.description,(case when P.oc_id=" + ocId
					+ " then 1 else 1 end)as Active FROM promotion_def_oc P inner join oc O on P.oc_id=O.oc_id WHERE promotion_def = '"
					+ promotionDef + "'");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return processInfo;
	}

	@Override
	public List<Map<String, Object>> getProcessInfo(int processOcType) {
		List<Map<String, Object>> processDetails = new ArrayList<>();

		try {

			if (processOcType == 1) {
				processDetails = jdbcTemplate
						.queryForList("select process_id,description,active from process where process_type in (1)");
			}
			if (processOcType == 0) {
				processDetails = jdbcTemplate
						.queryForList("select description,process_id, active from  process WHERE process_type in (0) ");

			} else if (processOcType == 4) {
				processDetails = jdbcTemplate
						.queryForList("select description,process_id, active from  process WHERE process_type in (4) ");

			}

			// processDetails=jdbcTemplate.queryForList("select
			// description,process_id,active from process WHERE process_type in (0,1,4) ");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return processDetails;
	}

	@Override
	public List<Map<String, Object>> getAllOrderDetails(int ocId) {
		List<Map<String, Object>> allOrderDetails = new ArrayList<>();
		try {
			allOrderDetails = jdbcTemplate.queryForList("select oc_id,oc,description,(case when oc.oc_id= " + ocId
					+ " then 1 else 0 end)as Active  from oc where oc_type in (1,2,3,4,5) ORDER BY oc");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return allOrderDetails;
	}

	@Override
	public List<Map<String, Object>> getPromotionDefDetail(String promotionDef) {
		List<Map<String, Object>> promotionDefDetails = new ArrayList<>();
		try {
			promotionDefDetails = jdbcTemplate
					.queryForList("select promotion_def,extract,description from promotion_def where promotion_def='"
							+ promotionDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return promotionDefDetails;
	}

	@Override
	public List<Map<String, Object>> getPromotionDefTest(String promotionDef, int promotionDefTestSeq) {
		List<Map<String, Object>> promotionDefTest = new ArrayList<>();
		try {
			promotionDefTest = jdbcTemplate.queryForList(
					"select promotion_def,promotion_def_test_seq,nth_def,description from promotion_def_test where promotion_def='"
							+ promotionDef + "' and promotion_def_test_seq=" + promotionDefTestSeq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return promotionDefTest;
	}

	@Override
	public List<Map<String, Object>> getPromotionDefEffortDetails(int effortNumber, String promotionDef) {

		LOGGER.info("Inside getPromotionEffortDetails");
		List<Map<String, Object>> query = new ArrayList<>();
		try {
			query = jdbcTemplate.queryForList(
					"select promotion_def,promotion_def_test_seq,effort_number,attachment_code,message_string,(case when process_method=0 then 'Any' when process_method=1 then 'Proc. Only' when process_method=2 then 'Web Only' end) as ProcessMethod ,report,days_from_first_effort from promotion_def_effort where promotion_def='"
							+ promotionDef + "' and effort_number=" + effortNumber);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return query;
	}

	@Override
	public List<DropdownModel> getNthDefDetail() {
		List<DropdownModel> nthDefDetails = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select nth_def,description from nth_def");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("nth_def").toString());
				model.setDisplay(row.get("description").toString());
				nthDefDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return nthDefDetails;
	}

	@Override
	public List<DropdownModel> getProcessMethod() {
		List<DropdownModel> processMethodDetails = new ArrayList<>();
		try {
			for (int i = 0; i <= 2; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("process_method" + i));
				processMethodDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return processMethodDetails;
	}

	@Override
	public List<DropdownModel> getPromCardDetails(int promotionCradId) {
		List<DropdownModel> promCardDetails = new ArrayList<>();
		try {
			List<Map<String, Object>> query = jdbcTemplate.queryForList(
					"select promotion_card,description from promotion_card where promotion_card_id=" + promotionCradId);
			for (Map<String, Object> promCard : query) {
				DropdownModel model = new DropdownModel();
				model.setKey(promCard.get("promotion_card").toString());
				model.setDisplay(promCard.get("description").toString());
				promCardDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return promCardDetails;
	}

	@Override
	public int updatePromotionDef(PromotionModel promotionModel) {
		int status = 0;
		StringBuilder query1 = null;
		Map<String, Object> addParams = new LinkedHashMap<>();
		try {
			StringBuilder query = new StringBuilder(
					"update promotion_def set description=:description,extract=:extract,active_testing=:active_testing where promotion_def='"
							+ promotionModel.getPromotionDef() + "'");
			addParams.put("description", promotionModel.getDescription());
			addParams.put("extract", promotionModel.getExtract());
			addParams.put("active_testing", promotionModel.getActiveTesting());
			System.out.println(promotionModel.getActiveTesting());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);

			if (promotionModel.getActiveTesting().equals("1")) {
				query1 = new StringBuilder(
						"update promotion_def_test set description=:description,nth_def=:nth_def where promotion_def='"
								+ promotionModel.getPromotionDef() + "' and promotion_def_test_seq="
								+ promotionModel.getPromotionDefTestSeq());
				addParams.put("description", promotionModel.getDescr());
				addParams.put("nth_def", promotionModel.getNthDef());
			}
			status = namedParameterJdbcTemplate.update(query1.toString(), addParams);
			StringBuilder query2 = new StringBuilder(
					"update promotion_def_oc set generate_source_code=:generate_source_code where oc_id="
							+ promotionModel.getOcId());
			addParams.put("generate_source_code", promotionModel.getGenerateSourceCode());
			status = namedParameterJdbcTemplate.update(query2.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updatePromotionDefTest(PromotionModel promotionModel) {
		int status = 0;
		Map<String, Object> updateParams = new LinkedHashMap<>();
		try {
			StringBuilder query = new StringBuilder(
					"update promotion_def_test set description=:description,nth_def=:nthDef where promotion_def='"
							+ promotionModel.getPromotionDef() + "' and promotion_def_test_seq="
							+ promotionModel.getPromotionDefTestSeq());
			updateParams.put("description", promotionModel.getDescr());
			updateParams.put("nth_def", promotionModel.getNthDef());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updatePromotiondefEffort(PromotionModel promotionModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder query = new StringBuilder(
					"update promotion_def_effort set attachMent_code=:attachMent_code,message_string=:message_string,process_method=:process_method,days_from_first_effort=:days_from_first_effort where promotion_def='"
							+ promotionModel.getPromotionDef() + "'and effort_number="
							+ promotionModel.getEffortNumber());
			updateParams.put("attachMent_code", promotionModel.getAttachmentCode());
			updateParams.put("message_string", promotionModel.getMessageString());
			updateParams.put("process_method", promotionModel.getProcessMethod());
			updateParams.put("days_from_first_effort", promotionModel.getDaysFromFirstEffort());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deletePromotionDefEffort(int effortNumber, String promotionDef) {
		int status = 0;
		try {
			String query1 = "delete from process_promotion_effort where promotion_def='" + promotionDef
					+ "' and effort_number=" + effortNumber;
			status = jdbcTemplate.update(query1.toString());
			String query = "delete from promotion_def_effort where promotion_def='" + promotionDef
					+ "' and effort_number=" + effortNumber;
			status = jdbcTemplate.update(query.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deletePromotionDefTest(String promotionDef, int promotionDefTestSeq) {
		int status = 0;
		try {
			String query = "delete from promotion_def_test where promotion_def='" + promotionDef
					+ "' and promotion_def_test_seq=" + promotionDefTestSeq;
			status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deletePromotionDef(String promotionDef) {
		int status = 0;
		try {
			String query1 = "delete from promotion_def_oc where promotion_def='" + promotionDef + "'";
			status = jdbcTemplate.update(query1.toString());

			String query = "delete from promotion_def where promotion_def='" + promotionDef + "'";
			status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public String addProcesstypePromotion(ProcessModel processModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int maxId = 0;
		StringBuilder query = new StringBuilder(
				"insert into process(process_id,description,process_type,active,label_length,default_job_priority,sql_script,repeating_type)values(:process_id,:description,:process_type,:active,:label_length,:default_job_priority,:sql_script,:repeating_type)");
		try {
			maxId = jdbcTemplate.queryForObject("select max(id) from mru_process_id", Integer.class);
			if (maxId == 0) {
				addParams.put("process_id", 1);
			} else {
				addParams.put("process_id", maxId + 1);
			}
			addParams.put("process_type", processModel.getProcessType());
			addParams.put("description", processModel.getDescription());
			addParams.put("active", processModel.getActive());
			addParams.put("label_length", processModel.getLabelLength());
			addParams.put("default_job_priority", processModel.getDefaultPriority());
			addParams.put("sql_script", processModel.getSqlScript());
			addParams.put("repeating_type", processModel.getRepeatingType());

			namedParameterJdbcTemplate.update(query.toString(), addParams);
			return "Promotion Added Successfully";

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "Promotion Added UnSuccessfully";

		}
	}

	@Override
	public int editProcessTypePromotion(ProcessModel processModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder query = new StringBuilder(
				"update process set description=:description,active=:active,label_length=:label_length,default_job_priority=:default_job_priority,sql_script=:sql_script,repeating_type=:repeating_type where process_id="
						+ processModel.getProcessId());
		try {
			updateParams.put("description", processModel.getDescription());
			updateParams.put("active", processModel.getActive());
			updateParams.put("label_length", processModel.getLabelLength());
			updateParams.put("default_job_priority", processModel.getDefaultPriority());
			updateParams.put("sql_script", processModel.getSqlScript());
			updateParams.put("repeating_type", processModel.getRepeatingType());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int editRepeatingType(ProcessModel processModel) {
		int status = 0;
		Map<String, Object> updateParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"update process set interval_unit=:interval_unit,n_interval_units=:n_interval_units where process_id="
						+ processModel.getProcessId());

		try {
			updateParams.put("interval_unit", processModel.getIntervalUnit());
			updateParams.put("n_interval_units", processModel.getnIntervalUnits());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteProcessPromotion(int processId) {

		int status = 0;
		try {
			String query = "delete from process where process_id=" + processId;
			status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getAudReport() {
		List<Map<String, Object>> auditReport = new ArrayList<>();
		try {
			auditReport = jdbcTemplate.queryForList("select audit_report,description from audit_report");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return auditReport;
	}

	@Override
	public int deleteOutputPromotion(int processOutputSeq, int procesId) {
		int status = 0;
		try {
			String query = "delete from process_output where process_output_seq=" + processOutputSeq
					+ " and process_id=" + procesId;
			status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public boolean generateDefaultOutput(int processId) {
		LOGGER.info("Inside output");
		try {
			String promotionQuery, installQuery = null;
			List<Map<String, Object>> promotionEffortList = null;
			List<Map<String, Object>> installmentPlanList = null;
			Map<String, Object> promotionParams = new HashMap<>();
			jdbcTemplate.update("delete from process_output where process_id = '" + processId + "'");
			promotionQuery = "insert into process_output (process_id,process_output_seq,report,output_type,output_mode,output_step,def,test_seq,effort_number) "
					+ " values (:process_id,:process_output_seq,:report,:output_type,:output_mode,:output_step,:def,:test_seq,:effort_number)";

			promotionEffortList = jdbcTemplate.queryForList(
					"select * from process_promotion_effort left join promotion_def_effort on process_promotion_effort.promotion_def=promotion_def_effort.promotion_def \r\n"
							+ " and process_promotion_effort.effort_number=promotion_def_effort.effort_number where process_id=?",
					new Object[] { processId });
			for (Map<String, Object> map : promotionEffortList) {
				System.out.println("ok");
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				promotionParams.put("process_id", map.get("process_id").toString());
				promotionParams.put("process_output_seq", seq);
				promotionParams.put("report", map.get("report") != "" ? (String) map.get("report") : null);
				promotionParams.put("output_type", 15);
				promotionParams.put("output_mode", 0);
				promotionParams.put("output_step", 1);
				promotionParams.put("def", map.get("promotion_def") != "" ? (String) map.get("promotion_def") : null);
				promotionParams.put("test_seq",
						map.get("promotion_def_test_seq") != "" ? map.get("promotion_def_test_seq") : null);
				promotionParams.put("effort_number", map.get("effort_number") != "" ? map.get("effort_number") : null);
				namedParameterJdbcTemplate.update(promotionQuery, promotionParams);
			}
			installQuery = "insert into process_output (process_id,process_output_seq,output_type,output_mode,output_step,installment_plan) "
					+ " values (:process_id,:process_output_seq,:output_type,:output_mode,:output_step,:installment_plan)";

			installmentPlanList = jdbcTemplate.queryForList(
					"select * from process_installment_plan left join installment_plan on process_installment_plan.installment_plan_id=installment_plan.installment_plan_id "
							+ " where process_id=?",
					new Object[] { processId });
			for (Map<String, Object> map : installmentPlanList) {
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				promotionParams.put("process_id", map.get("process_id").toString());
				promotionParams.put("process_output_seq", seq);
				promotionParams.put("output_type", 15);
				promotionParams.put("output_mode", 0);
				promotionParams.put("output_step", 1);
				promotionParams.put("installment_plan", map.get("description").toString());
				namedParameterJdbcTemplate.update(installQuery, promotionParams);
			}
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean generateDefaultProductOutput(int processId) {

		try {
			String promotionQuery, installQuery = null;

			List<Map<String, Object>> labelList = null;
			List<Map<String, Object>> installmentPlanList = null;
			Map<String, Object> labelParams = new HashMap<>();
			promotionQuery = "insert into process_output (process_id,process_output_seq,report,output_type,output_mode,output_step,def,test_seq,effort_number,oc_id) "
					+ " values (:process_id,:process_output_seq,:report,:output_type,:output_mode,:output_step,:def,:test_seq,:effort_number,:oc_id)";

			labelList = jdbcTemplate.queryForList("select * from process_output where process_id=?",
					new Object[] { processId });
			jdbcTemplate.update("delete from process_output where process_id = '" + processId + "'");

			for (Map<String, Object> map : labelList) {
				System.out.println("ok");
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				labelParams.put("process_id", map.get("process_id").toString());
				labelParams.put("process_output_seq", seq);
				labelParams.put("report", map.get("report").toString());
				labelParams.put("output_type", 5);
				labelParams.put("output_mode", 0);
				labelParams.put("output_step", 1);
				labelParams.put("def", null);
				labelParams.put("test_seq", null);
				labelParams.put("effort_number", null);
				labelParams.put("oc_id", map.get("oc_id").toString());

				namedParameterJdbcTemplate.update(promotionQuery, labelParams);
			}
			installQuery = "insert into process_output (process_id,process_output_seq,output_type,output_mode,output_step,installment_plan) "
					+ " values (:process_id,:process_output_seq,:output_type,:output_mode,:output_step,:installment_plan)";

			installmentPlanList = jdbcTemplate.queryForList(
					"select * from process_installment_plan left join installment_plan on process_installment_plan.installment_plan_id=installment_plan.installment_plan_id "
							+ " where process_id=?",
					new Object[] { processId });
			for (Map<String, Object> map : installmentPlanList) {
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				labelParams.put("process_id", map.get("process_id").toString());
				labelParams.put("process_output_seq", seq);
				labelParams.put("output_type", 5);
				labelParams.put("output_mode", 0);
				labelParams.put("output_step", 1);
				labelParams.put("installment_plan", map.get("description").toString());
				namedParameterJdbcTemplate.update(installQuery, labelParams);
			}
			return true;

		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}

	}

	@Override
	public boolean generateDefaultLabelOutput(int processId) {

		try {
			String promotionQuery, installQuery = null;

			List<Map<String, Object>> labelList = null;
			List<Map<String, Object>> installmentPlanList = null;
			Map<String, Object> labelParams = new HashMap<>();
			promotionQuery = "insert into process_output (process_id,process_output_seq,report,output_type,output_mode,output_step,def,test_seq,effort_number,oc_id) "
					+ " values (:process_id,:process_output_seq,:report,:output_type,:output_mode,:output_step,:def,:test_seq,:effort_number,:oc_id)";

			labelList = jdbcTemplate.queryForList("select * from process_output where process_id=?",
					new Object[] { processId });
			jdbcTemplate.update("delete from process_output where process_id = '" + processId + "'");

			for (Map<String, Object> map : labelList) {
				System.out.println("ok");
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				labelParams.put("process_id", map.get("process_id").toString());
				labelParams.put("process_output_seq", seq);
				labelParams.put("report", map.get("report").toString());
				labelParams.put("output_type", 0);
				labelParams.put("output_mode", 0);
				labelParams.put("output_step", 1);
				labelParams.put("def", null);
				labelParams.put("test_seq", null);
				labelParams.put("effort_number", null);
				labelParams.put("oc_id", map.get("oc_id").toString());

				namedParameterJdbcTemplate.update(promotionQuery, labelParams);
			}
			installQuery = "insert into process_output (process_id,process_output_seq,output_type,output_mode,output_step,installment_plan) "
					+ " values (:process_id,:process_output_seq,:output_type,:output_mode,:output_step,:installment_plan)";

			installmentPlanList = jdbcTemplate.queryForList(
					"select * from process_installment_plan left join installment_plan on process_installment_plan.installment_plan_id=installment_plan.installment_plan_id "
							+ " where process_id=?",
					new Object[] { processId });
			for (Map<String, Object> map : installmentPlanList) {
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				labelParams.put("process_id", map.get("process_id").toString());
				labelParams.put("process_output_seq", seq);
				labelParams.put("output_type", 0);
				labelParams.put("output_mode", 0);
				labelParams.put("output_step", 1);
				labelParams.put("installment_plan", map.get("description").toString());
				namedParameterJdbcTemplate.update(installQuery, labelParams);
			}
			return true;

		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}

	}

	@Override
	public boolean generateStartrStopDefaultOutput(int processId) {
		try {
			String startrStopQuery, installQuery = null;

			List<Map<String, Object>> startStopList = null;
			List<Map<String, Object>> installmentPlanList = null;
			Map<String, Object> startStopParams = new HashMap<>();
			startrStopQuery = "insert into process_output (process_id,process_output_seq,report,output_type,output_mode,output_step,def,test_seq,effort_number,oc_id) "
					+ " values (:process_id,:process_output_seq,:report,:output_type,:output_mode,:output_step,:def,:test_seq,:effort_number,:oc_id)";

			startStopList = jdbcTemplate.queryForList("select * from process_output where process_id=?",
					new Object[] { processId });
			jdbcTemplate.update("delete from process_output where process_id = '" + processId + "'");

			for (Map<String, Object> map : startStopList) {
				System.out.println("ok");
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				startStopParams.put("process_id", map.get("process_id").toString());
				startStopParams.put("process_output_seq", seq);
				startStopParams.put("report", map.get("report").toString());
				startStopParams.put("output_type", 12);
				startStopParams.put("output_mode", 0);
				startStopParams.put("output_step", 1);
				startStopParams.put("def", null);
				startStopParams.put("test_seq", null);
				startStopParams.put("effort_number", null);
				startStopParams.put("oc_id", map.get("oc_id").toString());

				namedParameterJdbcTemplate.update(startrStopQuery, startStopParams);
			}
			installQuery = "insert into process_output (process_id,process_output_seq,output_type,output_mode,output_step,installment_plan) "
					+ " values (:process_id,:process_output_seq,:output_type,:output_mode,:output_step,:installment_plan)";

			installmentPlanList = jdbcTemplate.queryForList(
					"select * from process_installment_plan left join installment_plan on process_installment_plan.installment_plan_id=installment_plan.installment_plan_id "
							+ " where process_id=?",
					new Object[] { processId });
			for (Map<String, Object> map : installmentPlanList) {
				jdbcTemplate.update(
						"update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"
								+ processId + "'");
				int seq = jdbcTemplate.queryForObject(
						"select mru_process_output_seq from process where process_id = '" + processId + "'",
						Integer.class);

				startStopParams.put("process_id", map.get("process_id").toString());
				startStopParams.put("process_output_seq", seq);
				startStopParams.put("output_type", 12);
				startStopParams.put("output_mode", 0);
				startStopParams.put("output_step", 1);
				startStopParams.put("installment_plan", map.get("description").toString());
				namedParameterJdbcTemplate.update(installQuery, startStopParams);
			}
			return true;

		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public int reprint(JobModel jobModel) {
		int status = 0;
		try {
			Integer repeatingType = jdbcTemplate.queryForObject(
					"select repeating_type from job where job_id=" + jobModel.getJobId(), Integer.class);
			if (repeatingType == 0) {

				Map<String, Object> updateResetStartDateTimeDetails = new LinkedHashMap<>();
				String updateJobQuery = "update job set job_id=:job_id,description=:description,note=:note,status=:status,step_name=:step_name,job_priority=:job_priority,n_candidate_records=:n_candidate_records,"
						+ "n_selected_records=:n_selected_records,n_updated_records=:n_updated_records,has_errors=:has_errors,process_id=:process_id,drop_date=:drop_date,cutoff_date=:cutoff_date "
						+ "where job_id=" + jobModel.getJobId();

				updateResetStartDateTimeDetails.put("job_id", jobModel.getJobId());
				updateResetStartDateTimeDetails.put("description", jobModel.getDescription());
				updateResetStartDateTimeDetails.put("note", jobModel.getNote());
				updateResetStartDateTimeDetails.put("status", jobModel.getStatus());
				updateResetStartDateTimeDetails.put("step_name", jobModel.getStepName());
				updateResetStartDateTimeDetails.put("job_priority", jobModel.getJobPriority());
				updateResetStartDateTimeDetails.put("n_candidate_records", jobModel.getCandidates());
				updateResetStartDateTimeDetails.put("n_selected_records", jobModel.getSelected());
				updateResetStartDateTimeDetails.put("n_updated_records", jobModel.getUpdated());
				updateResetStartDateTimeDetails.put("has_errors", jobModel.getHasError());
				updateResetStartDateTimeDetails.put("process_id", jobModel.getProcessId());
				updateResetStartDateTimeDetails.put("drop_date", jobModel.getDropDate());
				updateResetStartDateTimeDetails.put("cutoff_date", jobModel.getCutOffDate());
				updateResetStartDateTimeDetails.put("start_date_time", jobModel.getStartDateTime());
				status = namedParameterJdbcTemplate.update(updateJobQuery, updateResetStartDateTimeDetails);
			} else {
				return 0;
			}
		} catch (Exception e) {

			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getviewLabelDetail(int jobId) {
		LOGGER.info("Inside viewEffortDetail");
		List<Map<String, Object>> query = new ArrayList<>();
		try {
			query = jdbcTemplate.queryForList(
					" select job.job_id,job.description,view_label_hist_dtl.oc,view_label_hist_dtl.issue_id,"
							+ "view_label_hist_dtl.issue_date,view_label_hist_dtl.n_reg_single_copies,view_label_hist_dtl.n_reg_bundled_copies,"
							+ "view_label_hist_dtl.n_grace_single_copies,view_label_hist_dtl.n_grace_bundled_copies,view_label_hist_dtl.n_undel_single_copies,"
							+ "view_label_hist_dtl.n_undel_bundled_copies,view_label_hist_dtl.n_subscriptions,view_label_hist_dtl.total_copies"
							+ " from view_label_hist_dtl inner join job on job.job_id=view_label_hist_dtl.job_id where job.job_id="
							+ jobId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return query;

	}

	@Override
	public Map<String, Object> getviewEffortDetail(int jobId, String action) {
		LOGGER.info("Inside getviewEffortDetail");
		List<Map<String, Object>> jobDetails = new ArrayList<>();
		List<Map<String, Object>> renewalEffortOc = new ArrayList<>();
		List<Map<String, Object>> renewalEffortByEffort = new ArrayList<>();
		List<Map<String, Object>> renewalEffortByExpire = new ArrayList<>();
		Map<String, Object> responseObject = new HashMap();

		try {
			String actionValue = action.toLowerCase();
			System.out.println("Contoller actionValue---->" + actionValue);

			switch (actionValue) {
			case "billinghistory":

				responseObject.put("backstart", responseObject);
				break;

			case "efforthistory":

				jobDetails = jdbcTemplate.queryForList("select job_id,description from job where job_id=" + jobId);
				renewalEffortOc = jdbcTemplate.queryForList(
						"select oc, totaleffort,oc_id,job_id from view_renewal_effort_by_oc where job_id=" + jobId);
				renewalEffortByEffort = jdbcTemplate.queryForList(
						"  select renewal_def,renewal_def_test_seq,effort_number,criterion,totaleffort,job_id from view_renewal_effort_by_effort where job_id="
								+ jobId);
				renewalEffortByExpire = jdbcTemplate.queryForList(
						" select renewal_def,job_id,oc_id,renewal_def_test_seq,effort_number,criterion,totaleffort from view_renewal_effort_by_expire where job_id="
								+ jobId);
				responseObject.put("renewalEffortOc", renewalEffortOc);
				responseObject.put("renewalEffortByEffort", renewalEffortByEffort);
				responseObject.put("renewalEffortByExpire", renewalEffortByExpire);
				responseObject.put("jobDetails", jobDetails);
				break;
			default:
				System.out.println("invalid input");

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return responseObject;

	}

	@Override
	public String restartUpdate(JobModel jobModel) {
		int status = 0;
		try {
			Map<String, Object> restartUpdate = new LinkedHashMap<>();

			Integer holdBits = jdbcTemplate
					.queryForObject("select hold_bits from job where job_id=" + jobModel.getJobId(), Integer.class);
			if (holdBits == 4) {
				String updateJobQuery = "update job set job_id=:job_id,description=:description,note=:note,status=:status,step_name=:step_name,job_priority=:job_priority,n_candidate_records=:n_candidate_records,"
						+ "n_selected_records=:n_selected_records,n_updated_records=:n_updated_records,has_errors=:has_errors,process_id=:process_id,drop_date=:drop_date,cutoff_date=:cutoff_date "
						+ "where job_id=" + jobModel.getJobId();

				restartUpdate.put("job_id", jobModel.getJobId());
				restartUpdate.put("description", jobModel.getDescription());
				restartUpdate.put("note", jobModel.getNote());
				restartUpdate.put("status", jobModel.getStatus());
				restartUpdate.put("step_name", jobModel.getStepName());
				restartUpdate.put("job_priority", jobModel.getJobPriority());
				restartUpdate.put("n_candidate_records", jobModel.getCandidates());
				restartUpdate.put("n_selected_records", jobModel.getSelected());
				restartUpdate.put("n_updated_records", jobModel.getUpdated());
				restartUpdate.put("has_errors", jobModel.getHasError());
				restartUpdate.put("process_id", jobModel.getProcessId());
				restartUpdate.put("drop_date", jobModel.getDropDate());
				restartUpdate.put("cutoff_date", jobModel.getCutOffDate());
				restartUpdate.put("start_date_time", jobModel.getStartDateTime());
				status = namedParameterJdbcTemplate.update(updateJobQuery, restartUpdate);
				if (status == 1) {
					return "row updated";
				}
			} else if (holdBits == 0) {
				return "restart update should be disabled,this type of job has not been set up to restart the update step";
			}

			else if (holdBits > 0) {
				return "restart update should be disabled,this type of job has not been set up to restart the update step";
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return "row updated";
	}

	@Override
	public List<Map<String, Object>> generateAuditGalleyDefaultOutput() {

		List<Map<String, Object>> auditGalley = new ArrayList<>();
		try {
			auditGalley = jdbcTemplate
					.queryForList("SELECT * FROM process_output WHERE 1 = 2 ORDER BY def,test_seq,effort_number,oc_id");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return auditGalley;
	}

	@Override
	public List<Map<String, Object>> getJobLogDetails(int jobId) {
		List<Map<String, Object>> JobLogDetails = new ArrayList<>();
		try {
			JobLogDetails = jdbcTemplate.queryForList(
					"select  job_id,job_log_seq,is_error,message_string,log_time from job_log where job_id=" + jobId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return JobLogDetails;
	}

	@Override
	public int deleteJobLogDetails(int jobId, int jobLogSeq) {
		int status = 0;
		try {

			String deleteJobLogDetails = "delete from job_log  where   job_id=" + jobId + " and  job_log_seq="
					+ jobLogSeq;
			status = jdbcTemplate.update(deleteJobLogDetails);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;

	}

	@Override
	public List<Map<String, Object>> getWorkTableErrorDetails() {
		List<Map<String, Object>> WorkTableErrorDetails = new ArrayList<>();
		try {
			WorkTableErrorDetails = jdbcTemplate.queryForList(
					"select  job_id,work_table_seq,log_time,customer_id,orderhdr_id,message_string,product_id  from  view_work_table_error_log");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return WorkTableErrorDetails;
	}

	@Override
	public int deleteWorkTableError(int jobId, int workTableSeq) {
		int status = 0;
		try {

			String deleteWorkTableError = "delete from view_work_table_error_log where   job_id=" + jobId
					+ " and  work_table_seq=" + workTableSeq;
			status = jdbcTemplate.update(deleteWorkTableError);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;

	}

	@Override
	public int updateResetStartDateTime(JobModel jobModel) {
		int status = 0;
		try {

			Map<String, Object> updateResetStartDateTimeDetails = new LinkedHashMap<>();
			String updateJobQuery = "update job set  job_id=:job_id,description=:description,status=:status,step_name=:step_name,job_priority=:job_priority,drop_date=:drop_date,cutoff_date=:cutoff_date,start_date_time=:start_date_time "
					+ "where job_id=" + jobModel.getJobId();

			updateResetStartDateTimeDetails.put("job_id", jobModel.getJobId());
			updateResetStartDateTimeDetails.put("description", jobModel.getDescription());
			updateResetStartDateTimeDetails.put("status", jobModel.getStatus());
			updateResetStartDateTimeDetails.put("step_name", jobModel.getStepName());
			updateResetStartDateTimeDetails.put("job_priority", jobModel.getJobPriority());
			updateResetStartDateTimeDetails.put("drop_date", jobModel.getDropDate());
			updateResetStartDateTimeDetails.put("cutoff_date", jobModel.getCutOffDate());
			updateResetStartDateTimeDetails.put("start_date_time", jobModel.getStartDateTime());

			status = namedParameterJdbcTemplate.update(updateJobQuery, updateResetStartDateTimeDetails);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getManualSelectionDetails(int jobid, int customerId, int ocId) {
		List<Map<String, Object>> manualSelectionDetails = new ArrayList<>();
		try {
			// manualSelectionDetails=jdbcTemplate.queryForList("select
			// job_id,selected,work_table_seq,issue_date,product_id,product_size,product_style,product_color,quantity,customer_id,orderhdr_id,order_item_seq,label1
			// from work_table where job_id="+jobid);
			manualSelectionDetails = jdbcTemplate.queryForList(
					"select job_id,selected,work_table_seq,issue_date,product_id,product_size,product_style,product_color,quantity,W.customer_id,order_date,orderhdr_id,order_item_seq,lname,O.oc_id  from work_table W inner join oc O  on O.oc_id=w.oc_id inner join customer c on c.customer_id=W.customer_id"
							+ "	where c.customer_id=" + customerId + " and  W.oc_id=" + ocId + " and job_id=" + jobid);

			manualSelectionDetails.addAll(jdbcTemplate.queryForList(
					"select description,case when status=0 then 'ready' when status=1 then 'on hold' when status=2 then 'running' when status=3 then 'paused' when status=4 then 'done' when status=5 then 'deleting' when status=6 then 'died' when status=7 then 'killed' end status,start_date_time,drop_date,cutoff_date,job_priority from job where job_id="
							+ jobid));

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return manualSelectionDetails;
	}

	@Override
	public int updateManualSelection(JobModel jobModel) {
		int status = 0;
		try {
			Map<String, Object> updateManualSelectionDetails = new LinkedHashMap<>();
			String updateJobQuery = "update job set  job_id=:job_id,description=:description,status=:status,step_name=:step_name,job_priority=:job_priority,drop_date=:drop_date,cutoff_date=:cutoff_date,start_date_time=:start_date_time "
					+ "where job_id=" + jobModel.getJobId();

			updateManualSelectionDetails.put("job_id", jobModel.getJobId());
			updateManualSelectionDetails.put("description", jobModel.getDescription());
			updateManualSelectionDetails.put("status", jobModel.getStatus());
			updateManualSelectionDetails.put("step_name", jobModel.getStepName());
			updateManualSelectionDetails.put("job_priority", jobModel.getJobPriority());
			updateManualSelectionDetails.put("drop_date", jobModel.getDropDate());
			updateManualSelectionDetails.put("cutoff_date", jobModel.getCutOffDate());
			updateManualSelectionDetails.put("start_date_time", jobModel.getStartDateTime());

			status = namedParameterJdbcTemplate.update(updateJobQuery, updateManualSelectionDetails);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Map<String, Object> getExtractFilterTemplateData() {

		List<Map<String, Object>> extractTemplate = jdbcTemplate.queryForList(
				"SELECT u.disp_context,description FROM disp_context_usage u, disp_context d WHERE usage = 1 and u.disp_context = d.disp_context ORDER BY description");

		Map<String, Object> parentMap = new TreeMap<String, Object>();
		List<ExtractFilterParentTemplateModel> customerList = new ArrayList<ExtractFilterParentTemplateModel>();

		for (Map<String, Object> template : extractTemplate) {

			ExtractFilterParentTemplateModel customer = new ExtractFilterParentTemplateModel();
			List<Map<String, Object>> childValue = jdbcTemplate
					.queryForList("select * from disp_context_column_think where disp_context=" + "'"
							+ template.get("disp_context").toString() + "'");

			System.out.println("template.get(\"disp_context\") " + template.get("disp_context"));

			List<ExtractFilterChildTemplateModel> childList = new ArrayList<ExtractFilterChildTemplateModel>();

			for (Map<String, Object> child : childValue) {
				ExtractFilterChildTemplateModel childModel = new ExtractFilterChildTemplateModel();
				childModel.setTitle(child.get("column_name").toString());
				childList.add(childModel);
			}

			// For sorting the child nodes value
			Collections.sort(childList, new Comparator<ExtractFilterChildTemplateModel>() {
				@Override
				public int compare(final ExtractFilterChildTemplateModel object2,
						final ExtractFilterChildTemplateModel object1) {
					return object2.getTitle().compareTo(object1.getTitle());
				}
			});

			customer.setNodes(childList);
			customer.setTitle(template.get("description").toString());
			customerList.add(customer);
		}

		parentMap.put("node", customerList);
		parentMap.put("All of", "& All of");
		parentMap.put("Any Of", "OR Any Of");

		return parentMap;

	}

	@Override
	public boolean createExtractFilter(ExtractModel extractFilterModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		boolean status = false;
		boolean template = false;
		StringBuilder extractSave = new StringBuilder(
				"insert into extract (extract, description,is_template) values (:extract,:description,:is_template)");
		try {

			if (("false".equals(extractFilterModel.getTemplate())) || ("".equals(extractFilterModel.getTemplate()))) {
				template = false;
			} else {
				template = true;
			}
			addParams.put("extract", extractFilterModel.getExtract());
			addParams.put("description", extractFilterModel.getDescription());
			addParams.put("is_template", template);
			namedParameterJdbcTemplate.update(extractSave.toString(), addParams);
			status = true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		if (status && template) {
			status = false;
			int extract_group_seq = 1, mru_extract_group_break_seq = 1;

			StringBuilder extractGroupSave = new StringBuilder(
					"insert into extract_group (extract,extract_group_seq,description,mru_extract_group_break_seq) values (:extract,:extract_group_seq,:description,:mru_extract_group_break_seq)");
			try {
				for (ExtractGroupModel extractGroupModel : extractFilterModel.getExtractGroup()) {
					addParams.put("extract", extractFilterModel.getExtract());
					addParams.put("description", extractGroupModel.getDescription());
					addParams.put("extract_group_seq", extract_group_seq);
					addParams.put("mru_extract_group_break_seq", mru_extract_group_break_seq);

					namedParameterJdbcTemplate.update(extractGroupSave.toString(), addParams);

					int extract_group_break_seq = 1;
					for (ExtractGroupBreakModel extractGroupBreakModel : extractGroupModel
							.getExtractGroupBreakModel()) {
						StringBuilder extractGroupBreakSave = new StringBuilder(
								"insert into extract_group_break (extract,extract_group_seq,extract_group_break_seq,table_name,column_name,value_list,operator,description) values (:extract,:extract_group_seq,:extract_group_break_seq,:table_name,:column_name,:value_list,:operator,:description) ");

						addParams.put("extract", extractFilterModel.getExtract());
						addParams.put("extract_group_seq", extract_group_seq);
						addParams.put("extract_group_break_seq", extract_group_break_seq);
						addParams.put("table_name", extractGroupBreakModel.getTableName());
						addParams.put("column_name", extractGroupBreakModel.getColumnName());
						addParams.put("value_list", extractGroupBreakModel.getValue());

						if (extractGroupBreakModel.getOperator().equals("=")) {
							addParams.put("operator", 0);
						}
						addParams.put("description", extractGroupBreakModel.getDescription());

						namedParameterJdbcTemplate.update(extractGroupBreakSave.toString(), addParams);

						extract_group_break_seq++;
					}

					extract_group_seq++;
					mru_extract_group_break_seq++;
				}
				status = true;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
			}

			if (status) {
				StringBuilder updateQuery = new StringBuilder(
						"update extract set mru_extract_group_seq=:mru_extract_group_break_seq where extract=:extract");
				namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
				status = true;
			}

		}

		return status;

	}

	@Override
	public boolean updateExtractFilter(ExtractModel extractFilterModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		boolean status = false;

		try {

			Integer extractData = jdbcTemplate.queryForObject("SELECT mru_extract_group_seq from extract where extract="
					+ "'" + extractFilterModel.getExtract() + "'", Integer.class);

			StringBuilder extractupdateQuery = new StringBuilder(
					"update extract set description=:description, mru_extract_group_seq=:mru_extract_group_seq where extract=:extract");

			if (("null".equals(extractFilterModel.getDescription()))
					|| ("".equals(extractFilterModel.getDescription()))) {
				updateParams.put("description", null);
			} else {
				updateParams.put("description", extractFilterModel.getDescription());
			}

			if (("null".equals(extractFilterModel.getExtract())) || ("".equals(extractFilterModel.getExtract()))) {
				updateParams.put("extract", null);
			} else {
				updateParams.put("extract", extractFilterModel.getExtract());
			}

			if (extractData != null) {
				updateParams.put("mru_extract_group_seq", extractData);
			}

			namedParameterJdbcTemplate.update(extractupdateQuery.toString(), updateParams);

			for (ExtractGroupModel extractGroupModel : extractFilterModel.getExtractGroup()) {

				StringBuilder extractGroupupdateQuery = new StringBuilder(
						"update extract_group set description=:description where extract=:extract");

				if (("null".equals(extractGroupModel.getDescription()))
						|| ("".equals(extractGroupModel.getDescription()))) {
					updateParams.put("description", null);
				} else {
					updateParams.put("description", extractGroupModel.getDescription());
				}

				if (("null".equals(extractFilterModel.getExtract())) || ("".equals(extractFilterModel.getExtract()))) {
					updateParams.put("extract", null);
				} else {
					updateParams.put("extract", extractFilterModel.getExtract());
				}

				namedParameterJdbcTemplate.update(extractGroupupdateQuery.toString(), updateParams);

				for (ExtractGroupBreakModel extractGroupBreakModel : extractGroupModel.getExtractGroupBreakModel()) {

					System.out.println("extractGroupBreakModel---->" + extractGroupBreakModel.getColumnName());

					StringBuilder extractGroupBreakUpdate = new StringBuilder(
							"update extract_group_break set table_name=:table_name,column_name=:column_name,value_list=:value_list,operator=:operator,description=:description where extract=:extract");

					if (("null".equals(extractFilterModel.getExtract()))
							|| ("".equals(extractFilterModel.getExtract()))) {
						updateParams.put("extract", null);
					} else {
						updateParams.put("extract", extractFilterModel.getExtract());
					}

					if (("null".equals(extractGroupBreakModel.getTableName()))
							|| ("".equals(extractGroupBreakModel.getTableName()))) {
						updateParams.put("table_name", null);
					} else {
						updateParams.put("table_name", extractGroupBreakModel.getTableName());
					}

					if (("null".equals(extractGroupBreakModel.getColumnName()))
							|| ("".equals(extractGroupBreakModel.getColumnName()))) {
						updateParams.put("column_name", null);
					} else {
						updateParams.put("column_name", extractGroupBreakModel.getColumnName());
					}

					if (("null".equals(extractGroupBreakModel.getColumnName()))
							|| ("".equals(extractGroupBreakModel.getColumnName()))) {
						updateParams.put("value_list", null);
					} else {
						updateParams.put("value_list", extractGroupBreakModel.getColumnName());
					}

					if (extractGroupBreakModel.getOperator().equals("=")) {
						updateParams.put("operator", 0);
					}
					updateParams.put("description", extractGroupBreakModel.getDescription());

					namedParameterJdbcTemplate.update(extractGroupBreakUpdate.toString(), updateParams);

				}

			}

			status = true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public boolean deleteExtractFilter(ExtractModel extractFilterModel) {

		Map<String, Object> addParams = new LinkedHashMap<>();
		boolean status = false;
		try {

			StringBuilder extractGroupBreakDelete = new StringBuilder(
					"delete from extract_group_break where extract=:extract");
			StringBuilder extractGroupDelete = new StringBuilder("delete from extract_group where extract=:extract");
			StringBuilder extractDelete = new StringBuilder("delete from extract where extract=:extract");

			addParams.put("extract", extractFilterModel.getExtract());

			namedParameterJdbcTemplate.update(extractGroupBreakDelete.toString(), addParams);
			namedParameterJdbcTemplate.update(extractGroupDelete.toString(), addParams);
			namedParameterJdbcTemplate.update(extractDelete.toString(), addParams);

			status = true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getAccountingReconciliation() {

		List<Map<String, Object>> accountingReconciliationResponse = new ArrayList<>();
		try {
			accountingReconciliationResponse = jdbcTemplate
					.queryForList("select profit_center,description from profit_center");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return accountingReconciliationResponse;
	}

	@Override
	public List<Map<String, Object>> getReportFile() {

		List<Map<String, Object>> reportFileResponse = new ArrayList<>();
		try {
			reportFileResponse = jdbcTemplate
					.queryForList("SELECT name, description FROM report_item WHERE report_item_type = 2");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return reportFileResponse;

	}

	@Override
	public List<Map<String, Object>> getCloseAccountPeriod() {

		List<Map<String, Object>> getCloseAccountResponse = new ArrayList<>();

		String closeAccountPeriodQuery = "SELECT profit_center,profit_center_calendar_seq,description,begin_date,begin_date_stamp,end_date,end_date_stamp,(case when period_status=0 then 'Future' when period_status=1 then 'Open' when period_status=2 then 'Closed' when period_status=3 then 'Reconcile Submitted' when period_status=4 then 'Reconciling' when period_status=5 then 'Reconciled' when period_status=6 then 'Rollback' end) as period_status,auto_close,auto_close_date_time FROM profit_center_calendar WHERE period_status = 1 ORDER BY profit_center";

		getCloseAccountResponse = jdbcTemplate.queryForList(closeAccountPeriodQuery);

		return getCloseAccountResponse;
	}

	@Override
	public int updateAccountPeriod(AccountingPeriod accountPeriod) {
		int updateStatus = 0;
		Map<String, Object> updateAccountPeriods = new LinkedHashMap<>();
		try {

			String updateAccountPeriod = "update profit_center_calendar set description=:description where profit_center = '"
					+ accountPeriod.getProfit_center() + "' AND profit_center_calendar_seq="
					+ accountPeriod.getProfit_center_calendar_seq();
			updateAccountPeriods.put("description", accountPeriod.getDescription());

			updateStatus = namedParameterJdbcTemplate.update(updateAccountPeriod, updateAccountPeriods);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return updateStatus;
	}

	@Override
	public int closeAccountPeriod(String... profit_center) {
		int closeAccountPeriodStatus = 0;
		Map<String, Object> closeAccountPeriods = new LinkedHashMap<>();
		try {
			for (String profitCenter : profit_center) {
				Integer periodStatusIsClosed = 2;
				Integer periodStatusIsOpen = 1;
				String closeAccountPeriod = "update profit_center_calendar set period_status=:period_status where profit_center = '"
						+ profitCenter + "' and period_status=" + periodStatusIsOpen;
				closeAccountPeriods.put("period_status", periodStatusIsClosed);

				closeAccountPeriodStatus = namedParameterJdbcTemplate.update(closeAccountPeriod, closeAccountPeriods);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}

		return closeAccountPeriodStatus;
	}

	@Override
	public int deleteAccountPeriod(AccountingPeriod accountingPeriod, Integer... profitCenterCalendarSeq) {

		int deleteStatus = 0;
		Map<String, Object> deleteAccountPeriod = new LinkedHashMap<>();

		try {
			for (Integer profit_center_calendar_seq : profitCenterCalendarSeq) {
				String updateAccountPeriod = "delete profit_center_calendar where profit_center = '"
						+ accountingPeriod.getProfit_center() + "' AND profit_center_calendar_seq="
						+ profit_center_calendar_seq;
				Integer everyFirstAccountPeriodStatusShouldBeOpen = 1;
				deleteStatus = namedParameterJdbcTemplate.update(updateAccountPeriod, deleteAccountPeriod);
				String getMinquery = "select min(profit_center_calendar_seq) from profit_center_calendar where profit_center='"
						+ accountingPeriod.getProfit_center() + "' and period_status=" + 0;
				Integer minProfitCenterCalenderSeqId = jdbcTemplate.queryForObject(getMinquery, Integer.class);
				String updatePeriodStatus = "update profit_center_calendar set period_status=:period_status where profit_center='"
						+ accountingPeriod.getProfit_center() + "' AND profit_center_calendar_seq="
						+ minProfitCenterCalenderSeqId;
				Map<String, Object> updateAccountPeriods = new LinkedHashMap<>();
				updateAccountPeriods.put("period_status", everyFirstAccountPeriodStatusShouldBeOpen);
				namedParameterJdbcTemplate.update(updatePeriodStatus, updateAccountPeriods);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return deleteStatus;
	}

	@Override
	public int createAccountPeriod(AccountingPeriod accountingPeriod, String[] endDateFromRequest,
			String... profit_center) {
		int maxId = 0;
		Map<String, Object> createAccountPeriods = new LinkedHashMap<>();
		int createStatus = 0;

		boolean profitCenterExistedInDBStatus = true;
		for (String profitCenter : profit_center) {
			try {
				jdbcTemplate.queryForObject(
						"select profit_center from profit_center where profit_center='" + profitCenter + "'",
						String.class);
			} catch (Exception e) {
				profitCenterExistedInDBStatus = false;
			}
		}
		if (profitCenterExistedInDBStatus) {
			try {

				for (String profitCenter : profit_center) {
					for (String uniqueEndDate : endDateFromRequest) {
						String createAccountPeriodQuery = "insert into profit_center_calendar(profit_center,profit_center_calendar_seq,description,begin_date,begin_date_stamp,end_date,end_date_stamp,period_status,auto_close,auto_close_date_time) values(:profit_center,:profit_center_calendar_seq,:description,:begin_date,:begin_date_stamp,:end_date,:end_date_stamp,:period_status,:auto_close,:auto_close_date_time)";

						createAccountPeriods.put("profit_center", profitCenter);
						try {
							maxId = jdbcTemplate.queryForObject(
									"select max(profit_center_calendar_seq) from profit_center_calendar where profit_center='"
											+ profitCenter + "'",
									Integer.class);
						} catch (Exception e) {
							maxId = 0;
						}

						if (maxId == 0) {
							createAccountPeriods.put("profit_center_calendar_seq", 1);
							createAccountPeriods.put("period_status", 1);

							String parseBeginDate = uniqueEndDate;
							LocalDateTime rawDateFromLocalTimeDate = LocalDateTime
									.parse(parseBeginDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
									.minusYears(1);

							String beginDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH)
									.format(rawDateFromLocalTimeDate);

							createAccountPeriods.put("begin_date", beginDate);
						} else {

							String date = jdbcTemplate.queryForObject(
									"select begin_date from profit_center_calendar where profit_center_calendar_seq="
											+ maxId + " and profit_center='" + profitCenter + "'",
									String.class);
							createAccountPeriods.put("profit_center_calendar_seq", maxId + 1);
							createAccountPeriods.put("period_status", 0);
							LocalDateTime rawDateFromLocalTimeDate = LocalDateTime
									.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")).plusDays(1);

							String beginDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH)
									.format(rawDateFromLocalTimeDate);
							createAccountPeriods.put("begin_date", beginDate);

						}
						createAccountPeriods.put("description", accountingPeriod.getDescription());

						String parseEndDate = uniqueEndDate;

						Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(parseEndDate);

						createAccountPeriods.put("begin_date_stamp", accountingPeriod.getBegin_date_stamp());

						createAccountPeriods.put("end_date", endDate);

						createAccountPeriods.put("end_date_stamp", accountingPeriod.getEnd_date_stamp());

						createAccountPeriods.put("auto_close", accountingPeriod.getAuto_close());
						createAccountPeriods.put("auto_close_date_time", accountingPeriod.getAuto_close_date_time());

						createStatus = namedParameterJdbcTemplate.update(createAccountPeriodQuery,
								createAccountPeriods);
					}
				}

			}

			catch (Exception e) {
				LOGGER.error(ERROR + e);
				e.printStackTrace();
			}
		} else {
			LOGGER.error("Profit center not found in DB");
		}

		return createStatus;
	}

	@Override
	public int createProfitCenter(ProfitCenter profitCenter) {

		Map<String, Object> createProfitCenters = new LinkedHashMap<>();
		int createProfitCenterStatus = 0;

		try {

			String createProfitCenterQuery = "update profit_center set incl_tax_liab=:incl_tax_liab,incl_del_liab=:incl_del_liab,incl_com_liab=:incl_com_liab,incl_tax_ar=:incl_tax_ar,incl_del_ar=:incl_del_ar,incl_com_ar=:incl_com_ar,mru_profit_center_calendar_seq=:mru_profit_center_calendar_seq where profit_center="
					+ profitCenter.getProfitCenter();
			createProfitCenters.put("incl_tax_liab", profitCenter.getInclTaxLiab());

			createProfitCenters.put("incl_del_liab", profitCenter.getInclDelLiab());

			createProfitCenters.put("incl_com_liab", profitCenter.getInclComLiab());

			createProfitCenters.put("incl_tax_ar", profitCenter.getInclTaxAr());

			createProfitCenters.put("incl_del_ar", profitCenter.getInclDelAr());

			createProfitCenters.put("incl_com_ar", profitCenter.getInclComAr());

			createProfitCenters.put("mru_profit_center_calendar_seq", profitCenter.getMruProfitCenterCalendarSeq());

			createProfitCenterStatus = namedParameterJdbcTemplate.update(createProfitCenterQuery, createProfitCenters);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return createProfitCenterStatus;
	}

	@Override
	public int createSchedular(JobModel job) {
		int maxId = 0;
		Map<String, Object> createSchedulars = new LinkedHashMap<>();
		int schedularStatus = 0;

		try {

			String createSchedularQuery = "insert into view_jobs_queueable(job_id,status,job_priority,step_number,has_errors,manual_review_fulfillment,process_id,step_name,start_date_time,queue,n_candidate_records) values(:job_id,:status,:job_priority,:step_number,:has_errors,:manual_review_fulfillment,:process_id,:step_name,:start_date_time,:queue,:n_candidate_records)";
			maxId = jdbcTemplate.queryForObject("select max(job_id) from view_jobs_queueable", Integer.class);
			if (maxId == 0) {
				createSchedulars.put("job_id", 1);
			} else {
				createSchedulars.put("job_id", maxId + 1);

			}

			String parseSelectStartDate = job.getStartDateTime();

			Date SelectStartDate = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss.SSS").parse(parseSelectStartDate);

			createSchedulars.put("job_priority", job.getJobPriority());
			createSchedulars.put("status", job.getStatus());
			createSchedulars.put("step_number", job.getStepNumber());
			createSchedulars.put("has_errors", job.getHasError());
			createSchedulars.put("manual_review_fulfillment", job.getManualReviewFulfillment());
			createSchedulars.put("process_id", job.getProcessId());

			createSchedulars.put("step_name", job.getStepName());

			createSchedulars.put("start_date_time", SelectStartDate);
			createSchedulars.put("n_candidate_records", job.getCandidates());

			createSchedulars.put("queue", job.getQueue());

			schedularStatus = namedParameterJdbcTemplate.update(createSchedularQuery, createSchedulars);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return schedularStatus;
	}

	@Override
	public List<Map<String, Object>> getProfitCenter(AccountingPeriod accountPeriod) {

		List<Map<String, Object>> profitCenterResponse = new ArrayList<>();

		try {
			profitCenterResponse = jdbcTemplate
					.queryForList("SELECT profit_center, description from profit_center where profit_center='"
							+ accountPeriod.getProfit_center() + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return profitCenterResponse;
	}

	@Override
	public List<Map<String, Object>> getOderClass(AccountingPeriod accountPeriod) {
		List<Map<String, Object>> profitCenterResponse = new ArrayList<>();

		try {
			profitCenterResponse = jdbcTemplate.queryForList("SELECT oc,oc_id,description from oc where profit_center='"
					+ accountPeriod.getProfit_center() + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return profitCenterResponse;
	}

	@Override
	public List<Map<String, Object>> getOrderClassForAccounting(AccountingPeriod accountPeriod) {
		List<Map<String, Object>> profitCenterResponse = new ArrayList<>();

		try {

			profitCenterResponse = jdbcTemplate.queryForList(
					"SELECT oc_id,oc,description,promotion_source_format,report,track_inven,payment_threshold,billing_code_format,source_format,parent_oc_id,profit_center,renewal_source_format,oc_type from oc where oc.profit_center='"
							+ accountPeriod.getProfit_center() + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return profitCenterResponse;
	}

	@Override
	public List<Map<String, Object>> profitCenterAccountingPeriod(AccountingPeriod accountPeriod) {
		List<Map<String, Object>> profitCenterResponse = new ArrayList<>();

		try {
			profitCenterResponse = jdbcTemplate.queryForList(
					"SELECT pc,pccs,(case when period_status=0 then 'Future' when period_status=1 then 'Open' when period_status=2 then 'Closed' when period_status=3 then 'Reconcile Submitted' when period_status=4 then 'Reconciling' when period_status=5 then 'Reconciled' when period_status=6 then 'Rollback' end) as period_status,end_date,cash_liability,credit_liability,total_liability,ar from view_account_summary where view_account_summary.pc='"
							+ accountPeriod.getProfit_center() + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return profitCenterResponse;
	}

	@Override
	public List<Map<String, Object>> getProfitCenterForAccountingPeriod(AccountingPeriod accountPeriod) {
		List<Map<String, Object>> profitCenterResponse = new ArrayList<>();

		try {
			profitCenterResponse = jdbcTemplate.queryForList(
					"SELECT profit_center,description,profit_center_calendar_seq,begin_date,begin_date_stamp,auto_close,(case when period_status=0 then 'Future' when period_status=1 then 'Open' when period_status=2 then 'Closed' when period_status=3 then 'Reconcile Submitted' when period_status=4 then 'Reconciling' when period_status=5 then 'Reconciled' when period_status=6 then 'Rollback' end) as period_status,end_date,end_date_stamp,auto_close_date_time from profit_center_calendar where profit_center='"
							+ accountPeriod.getProfit_center() + "' AND profit_center_calendar_seq="
							+ accountPeriod.getProfit_center_calendar_seq());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return profitCenterResponse;
	}

	@Override
	public List<Map<String, Object>> getOrderClassAccountingPeriod(AccountingPeriod accountPeriod) {
		List<Map<String, Object>> profitCenterResponse = new ArrayList<>();

		try {
			String getOrderClassAccountingPeriodQuery = "SELECT oc_id, pc as profit_center, pccs as profit_center_calendar_seq,(case when period_status=0 then 'Future' when period_status=1 then 'Open' when period_status=2 then 'Closed' when period_status=3 then 'Reconcile Submitted' when period_status=4 then 'Reconciling' when period_status=5 then 'Reconciled' when period_status=6 then 'Rollback' end) as period_status, begin_date, end_date, pc, pccs, sum(cash_liability) as cash_liability, sum(credit_liability) as credit_liability, sum(cash_liability + credit_liability) as total_liability, sum(ar) as ar FROM view_account_summary WHERE  (acc_break_type IN (0) or acc_break_type is null) and pc = '"
					+ accountPeriod.getProfit_center() + "' AND oc_id =" + accountPeriod.getOcId()
					+ " group by oc_id, pc, pccs,begin_date, end_date, period_status ORDER BY end_date";
			profitCenterResponse = jdbcTemplate.queryForList(getOrderClassAccountingPeriodQuery);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return profitCenterResponse;
	}

	@Override
	public List<Map<String, Object>> getAccountSummaryBreak(AccountingPeriod accountPeriod) {

		List<Map<String, Object>> getAccountSummaryBreakResponse = new ArrayList<>();

		try {

			getAccountSummaryBreakResponse = jdbcTemplate.queryForList(
					"select profit_center,profit_center_calendar_seq,oc_id,acc_break_type,adj_credit,adj_credit_prorate,credit_memo_xfr_credit,decline_payxfr_credit,new_credit,pay_over_credit,pay_under_credit,pay_xfr_credit,refund_cancel_credit,refund_over_credit, reverse_payxfr_credit,reverse_refund_credit,begin_ar,subscriber_credit_ar,new_cash,cancel_credit_on_cancel from account_summary_break where profit_center='"
							+ accountPeriod.getProfit_center() + "'" + "AND profit_center_calendar_seq="
							+ accountPeriod.getProfit_center_calendar_seq());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return getAccountSummaryBreakResponse;
	}

	@Override
	public List<Map<String, Object>> getProfitCenterCalender(AccountingPeriod accountPeriod) {

		List<Map<String, Object>> getProfitCenterCalenderResponse = new ArrayList<>();

		try {

			getProfitCenterCalenderResponse = jdbcTemplate.queryForList(
					"select begin_date,end_date,end_date_stamp,begin_date_stamp,description,profit_center,profit_center_calendar_seq from profit_center_calendar where profit_center ='"
							+ accountPeriod.getProfit_center() + "'" + "AND profit_center_calendar_seq="
							+ accountPeriod.getProfit_center_calendar_seq());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return getProfitCenterCalenderResponse;
	}

	@Override
	public List<Map<String, Object>> getProfitCenterDetails(AccountingPeriod accountPeriod) {

		List<Map<String, Object>> getProfitCenterDetails = new ArrayList<>();

		try {

			getProfitCenterDetails = jdbcTemplate.queryForList(
					"select description,profit_center,incl_tax_liab,incl_del_liab,incl_com_liab from profit_center where profit_center='"
							+ accountPeriod.getProfit_center() + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return getProfitCenterDetails;
	}

	@Override
	public List<Map<String, Object>> getAccountSummaryWithCalenderSeq(AccountingPeriod accountPeriod) {
		List<Map<String, Object>> AccountSummaryWithCalenderSeqResponse = new ArrayList<>();

		try {

			AccountSummaryWithCalenderSeqResponse = jdbcTemplate.queryForList(
					"select oc_id,job_id,deferred_qty,new_earned_qty,new_grace_earned_qty,new_ordered_qty,n_selected_records,new_earned_at_fulfillment_qty from account_summary where profit_center='"
							+ accountPeriod.getProfit_center() + "'" + "AND profit_center_calendar_seq="
							+ accountPeriod.getProfit_center_calendar_seq());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return AccountSummaryWithCalenderSeqResponse;
	}

	@Override
	public List<Map<String, Object>> getInsertDayEndJobs() {
		List<Map<String, Object>> insertsDetailList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				" select p.process_id,p.description,isnull(j.start_date_time,GETDATE()) as start_date_time ,ISNULL(j.job_priority,p.default_job_priority) as job_priority ,"
						+ "isnull(j.n_interval_units,p.n_interval_units) as n_interval_units    from process p "
						+ "left outer JOIN job j on j.process_id =p.process_id "
						+ " where p.process_id in (2100000001,2100000002,2100000006,2100000007,2100000008,2100000009)"
						+ " and j.status <>4");
		try {
			insertsDetailList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return insertsDetailList;
	}

	@Override
	public boolean updateInsertDayEndJobs(JobModel jobModel) {
		LOGGER.info("Inside InsertDayEndJobs");
		Map<String, Object> updateParams = new LinkedHashMap<>();
		String renOutput = null;
		try {
			List<Map<String, Object>> effDetails = jdbcTemplate.queryForList(
					"select p.process_id,isnull(j.Job_id,0) Job_Id ,p.description,isnull(j.start_date_time,GETDATE()) as start_date_time ,ISNULL(j.job_priority,p.default_job_priority) as job_priority,"
							+ "isnull(j.n_interval_units,p.n_interval_units) as n_interval_units    from process p "
							+ "left outer JOIN job j on j.process_id =p.process_id "
							+ " where p.process_id in (2100000001,2100000002,2100000006,2100000007,2100000008,2100000009) "
							+ " and j.status <>4");
			Map<String, Object> result = new HashMap<String, Object>();
			for (Map<String, Object> map : effDetails) {
				if (jobModel.getJobId() == 0) {
					// insert query
					renOutput = "insert into job(job_id,start_date_time,description,n_interval_units,process_id)values(:job_id,:start_date_time,:description,:n_interval_units,:process_id)";
					Integer jobIdsresult = jdbcTemplate.queryForObject("select MAX(job_id) from job ", Integer.class);

					if (jobIdsresult == 0) {
						updateParams.put("job_id", 1);
					} else {
						updateParams.put("job_id", jobIdsresult + 1);
					}
					String value = jobModel.getStartDateTime();
					Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(value);
					updateParams.put("start_date_time", map.get("start_date_time"));
					updateParams.put("description", map.get("description"));
					updateParams.put("job_priority", map.get("job_priority"));
					updateParams.put("n_interval_units", map.get("n_interval_units"));
					updateParams.put("process_id", map.get("process_id"));
					namedParameterJdbcTemplate.update(renOutput, updateParams);

				} else {
					int jobId = (int) map.get("job_id");
					// update Query
					renOutput = "update job set start_date_time=:start_date_time, job_priority=:job_priority, n_interval_units=:n_interval_units where job_id = "
							+ jobId;
					String value = jobModel.getStartDateTime();
					Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(value);
					updateParams.put("start_date_time", date1);
					updateParams.put("job_priority", jobModel.getJobPriority());
					updateParams.put("n_interval_units", jobModel.getnIntervalUnits());
					namedParameterJdbcTemplate.update(renOutput, updateParams);

				}

			}
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public String getFirstProfitCenterForAccounting(Map<String, Object> profitCenterFromDB) {
		Optional<Entry<String, Object>> firstEntryFromProfitCenter = profitCenterFromDB.entrySet().stream().findFirst();
		String rawProfitCenterFromDB = firstEntryFromProfitCenter.toString();
		String[] splitprofitCenterMap = rawProfitCenterFromDB.split("=");
		String[] profitCenterArray = null;
		for (String splitProfitCenter : splitprofitCenterMap) {
			profitCenterArray = splitProfitCenter.split("]");
		}

		String trimmedProfitCenter = profitCenterArray[0];
		return trimmedProfitCenter;
	}

	@Override
	public List<Map<String, Object>> getBillDeftesting(String billingDef) {
		List<Map<String, Object>> BillingDef = new ArrayList<>();
		try {
			BillingDef = jdbcTemplate.queryForList(
					"select bdt.description,isnull(bdt.nth_def,'') as nth_def,billing_def_test_seq as billingDefTestSeq,bd.billing_def from billing_def_test bdt join billing_def bd on bdt.billing_def=bd.billing_def where bd.billing_def='"
							+ billingDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return BillingDef;

	}

	@Override
	public List<Map<String, Object>> process(int effortNumber, String billingDef) {
		List<Map<String, Object>> processDetails = new ArrayList<>();
		try {

			processDetails = jdbcTemplate.queryForList(
					"select distinct process.process_id,description,(case when process_billing_effort.effort_number="
							+ effortNumber
							+ " then 1 else 0 end)as active from process inner join process_billing_effort on process.process_id=process_billing_effort.process_id where process.process_type in(1,0,3) and process_billing_effort.effort_number="
							+ effortNumber + " and process_billing_effort.billing_def='" + billingDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return processDetails;

	}

	@Override
	public boolean insertSubmitAuditGalley(JobModel jobModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		try {
			StringBuilder query = new StringBuilder(
					"insert into job(job_id,note,start_date_time,job_priority,description,log_option,hold_bits,status,process_id,job_completion_email_address,repeating_type,interval_unit,n_interval_units,creation_date ) "
							+ "values(:job_id,:note,:start_date_time,:job_priority,:description,:log_option,:hold_bits,:status,:process_id,:job_completion_email_address,:repeating_type,:interval_unit,:n_interval_units,:creation_date )");
			int processId = jobModel.getProcessId();
			String jobQueue = jobModel.getQueue();
			int areYouDead = jdbcTemplate.queryForObject(
					"select are_you_dead from job_running where description='" + jobQueue + "'", Integer.class);
			if (areYouDead == 0) {
				jdbcTemplate.update("update job_running set are_you_dead=1 where description='" + jobQueue + "'");
			}
			int jobId = jdbcTemplate.queryForObject("select max(job_id) from job ", Integer.class);

			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select description,job_completion_email_address,repeating_type,interval_unit,n_interval_units from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();
				int jobHold = jobModel.getHoldJob();
				int holdbit = holdUpdate + holdOutput + jobHold;
				addParams.put("job_id", jobId + 1);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time", new SimpleDateFormat("yyyy-mm-dd").parse(jobModel.getStartDateTime()));
				addParams.put("job_priority", jobModel.getJobPriority());
				addParams.put("description", jobModel.getDescription());
				addParams.put("log_option", jobModel.getLogOption());
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("interval_unit", result.get("interval_unit"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("job_completion_email_address", result.get("job_completion_email_address"));
				addParams.put("process_id", processId);
				addParams.put("creation_date", jobModel.getCreationDate());

				if (holdbit != 0) {
					addParams.put("status", 1);
				} else {
					addParams.put("status", 0);
				}
			}
			namedParameterJdbcTemplate.update(query.toString(), addParams);
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}

	}

	@Override
	public List<Map<String, Object>> getOrderIssueDetails(int processId) {
		List<Map<String, Object>> orderIssueDetails = new ArrayList<>();
		try {
			orderIssueDetails = jdbcTemplate.queryForList(
					"SELECT distinct issue_id,issue_date,analyzed,oc.oc,frozen,audit_begin_date,audit_end_date FROM issue inner join process_oc on issue.oc_id=process_oc.oc_id inner join oc on process_oc.oc_id=oc.oc_id "
							+ " where  process_oc.process_id=" + processId
							+ " and issue_date = (select min(issue_date) from issue where oc_id=(select oc_id from process_oc where process_id="
							+ processId + "))");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderIssueDetails;
	}

	@Override
	public List<Map<String, Object>> getAuditData(int processId) {
		List<Map<String, Object>> jobOutput = new ArrayList<>();
		try {
			jobOutput = jdbcTemplate.queryForList("select * from view_siha_job_process where process_id=" + processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return jobOutput;
	}

	@Override
	public List<Map<String, Object>> getJobOutputDetail(int processId) {
		List<Map<String, Object>> jobOutputDetails = new ArrayList<>();
		try {
			jobOutputDetails = jdbcTemplate.queryForList(
					"select job_output.job_id,job_output_seq,param_values,(case when output_type=0 then 'Label ' when output_type=1 then 'Renewal' when output_type=2 then 'Billing' when output_type=3 then 'Refund' when output_type=4 then 'List Extract' when output_type=5 then 'Product Fulfillment' when output_type=6 then 'Pick List' when output_type=7 then 'Payment' when output_type=8 then 'Report' when output_type=9 then 'Account Reconcilation' when output_type=10 then 'installment Plan' when output_type=11 then 'Audit Reports' when output_type=12 then 'Start/Stop' when output_type=13 then 'Unused' when output_type=14 then 'Installment Notice' when output_type=15 then 'Promotion' when output_type=16 then 'Repeating Job' when output_type=17 then 'Auddis' end)as output_type,"
							+ "(case when output_mode=0 then 'Print' when output_mode=1 then 'File' when output_mode=2 then 'Window' when output_mode=3 then 'Unused' end)as output_mode ,output_filename,def,test_seq,effort_number,append_job_id,oc.oc  from job_output inner   join oc on job_output.oc_id=oc.oc_id inner join job on job.job_id=job_output.job_id where job.process_id="
							+ processId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobOutputDetails;
	}

	@Override
	public boolean insertJobOutput(JobOutputModel jobOutputModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		try {
			StringBuilder query = new StringBuilder(
					"insert into job_output(job_id,job_output_seq,param_values,output_type,output_mode,output_filename,def,test_seq,effort_number,oc_id,append_job_id,installment_plan)"
							+ "values(:job_id,:job_output_seq,:param_values,:output_type,:output_mode,:output_filename,:def,:test_seq,:effort_number,:oc_id,:append_job_id,:installment_plan)");

			int jobId = jdbcTemplate.queryForObject("select max(job_id) from job ", Integer.class);
			addParams.put("job_id", jobOutputModel.getJobId());

			int id = jdbcTemplate.queryForObject(
					"select max(job_output_seq) from job_output where job_id=" + jobOutputModel.getJobId(),
					Integer.class);
			if (id == 0) {
				addParams.put("job_output_seq", 1);
			} else {
				addParams.put("job_output_seq", id + 1);
			}
			addParams.put("param_values", jobOutputModel.getParamValues());
			addParams.put("output_type", jobOutputModel.getOutputType());
			addParams.put("output_mode", jobOutputModel.getOutputMode());
			addParams.put("output_filename", jobOutputModel.getOutputFileName());
			addParams.put("def", jobOutputModel.getDef());
			addParams.put("test_seq", jobOutputModel.getTestSeq());
			addParams.put("effort_number", jobOutputModel.getEffortNumber());
			addParams.put("oc_id", jobOutputModel.getOcId());
			addParams.put("append_job_id", jobOutputModel.getAppendJob());
			addParams.put("installment_plan", jobOutputModel.getInstallmentPlan());

			namedParameterJdbcTemplate.update(query.toString(), addParams);
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean insertBackLabelJob(JobModel jobModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,label_keyline,label_group,process_id,drop_date,note,start_date_time,grace_new,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,job_completion_email_address,manual_review_fulfillment)"
						+ "values(:job_id,:label_keyline,:label_group,:process_id,:drop_date,:note,:start_date_time,:grace_new,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:job_completion_email_address,:manual_review_fulfillment)");
		int processId = jobModel.getProcessId();
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select description,job_completion_email_address,repeating_type,interval_unit,n_interval_units from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();
				int jobHold = jobModel.getHoldJob();
				int holdbit = holdUpdate + holdOutput + jobHold;
				addParams.put("process_id", processId);
				addParams.put("label_keyline", jobModel.getLabelKeyline());
				addParams.put("label_group", jobModel.getLabelGroup());
				addParams.put("drop_date", new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getDropDate()));
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));
				addParams.put("grace_new", jobModel.getGraceNew());
				addParams.put("description", result.get("description"));
				addParams.put("job_priority", jobModel.getJobPriority());
				addParams.put("queue", jobModel.getQueue());
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("job_completion_email_address", result.get("job_completion_email_address"));
				addParams.put("manual_review_fulfillment", jobModel.getManualReviewFulfillment());
			}
			namedParameterJdbcTemplate.update(query.toString(), addParams);
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;

		}

	}

	@Override
	public boolean insertLabelJob(JobModel jobModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,label_keyline,label_group,process_id,drop_date,note,start_date_time,grace_new,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,job_completion_email_address,manual_review_fulfillment,nth_def,grace_current,force_repeat,cutoff_date,schedule_payment_date,volume_group_id)"
						+ "values(:job_id,:label_keyline,:label_group,:process_id,:drop_date,:note,:start_date_time,:grace_new,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:job_completion_email_address,:manual_review_fulfillment,:nth_def,:grace_current,:force_repeat,:cutoff_date,:schedule_payment_date,:volume_group_id)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);
		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			String includeProforma = "update process set includes_proformas=" + jobModel.getIncludeProforma()
					+ " where processId=" + processId;
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();
				int jobHold = jobModel.getHoldJob();
				int holdbit = holdUpdate + holdOutput + jobHold;

				addParams.put("includes_proformas", includeProforma);
				addParams.put("process_id", processId);
				addParams.put("label_keyline", result.get("label_keyline"));
				addParams.put("label_group", jobModel.getLabelGroup());
				addParams.put("drop_date", new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getDropDate()));
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));
				addParams.put("grace_new", jobModel.getGraceNew());
				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", jobModel.getQueue());
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("job_completion_email_address", result.get("job_completion_email_address"));
				addParams.put("manual_review_fulfillment", jobModel.getManualReviewFulfillment());
				addParams.put("nth_def", result.get("nth_def"));
				addParams.put("grace_current", jobModel.getGraceCurrent());
				addParams.put("force_repeat", jobModel.getForceRepeat());
				addParams.put("cutoff_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getCutOffDate()));
				addParams.put("schedule_payment_date",
						new SimpleDateFormat("yyyy-mm-dd").parse(jobModel.getSchedulePaymentDate()));
				addParams.put("volume_group_id", jobModel.getVolumeGroupId());
			}
			namedParameterJdbcTemplate.update(query.toString(), addParams);
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;

		}
	}

	@Override
	public int getJobId() {
		int value = 0;
		try {
			value = jdbcTemplate.queryForObject("select max(job_id)from job", Integer.class);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			;
		}
		return value;
	}

	@Override
	public List<Map<String, Object>> getLabelDetails(int processId) {
		List<Map<String, Object>> labelDetails = new ArrayList<>();
		try {
			labelDetails = jdbcTemplate.queryForList(
					"select job_id,process.label_keyline,process.label_group,process.process_id,drop_date,note,start_date_time,job.grace_new,process.description,process.default_job_priority,process.queue,process.n_interval_units,log_option,status,hold_bits,process.repeating_type,process.job_completion_email_address,"
							+ "job.manual_review_fulfillment,process.nth_def,job.grace_current,force_repeat,cutoff_date,schedule_payment_date,process.volume_group_id from job inner join process on job.process_id=process.process_id where job.job_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return labelDetails;
	}

	@Override
	public List<Map<String, Object>> getLabelJobPubOcDetail(int ocId) {
		List<Map<String, Object>> jobPubOcDetails = new ArrayList<>();
		try {
			jobPubOcDetails = jdbcTemplate.queryForList(
					"select oc.oc,issue.issue_date,issue.issue_id,close_issue,issue.audit_begin_date,issue.audit_end_date,n_undel_single_copies,n_grace_bundled_copies,job_id,n_reg_bundled_copies,n_reg_single_copies,profit_center_calendar_seq from job_pub_oc inner join oc on job_pub_oc.oc_id=oc.oc_id inner join issue on issue.oc_id=oc.oc_id and oc.oc_id ="
							+ ocId + " and issue.issue_date = (select min(issue_date) from issue where oc.oc_id ="
							+ ocId + ")");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobPubOcDetails;
	}

	@Override
	public List<Map<String, Object>> getJobRenewalEffort(int jobId) {
		List<Map<String, Object>> jobRenewalEffort = new ArrayList<>();
		try {
			jobRenewalEffort = jdbcTemplate.queryForList(
					"select  suppress_output,suppress_email,renewal_def,renewal_def_test_seq,volume_group_month_day,job_id,(case when effort_type=0 then 'N/A' when effort_type=1 then 'Issues/Units Left' when effort_type=2 then 'Issues/Units Left with Expires' when effort_type=3 then 'At Birth' when effort_type=4 then 'By Package Expire Date' when effort_type=5 then 'from Long Qual' when effort_type=6 then 'from Short Qual' when effort_type=7 then 'By Subscription Expire Date' when effort_type=8 then 'Exact Issues/Units Left' end)as effort_type,(case when renewal_type=0 then 'by issue/Unit' when renewal_type=1 then 'By Volume Group' when renewal_type=2 then 'Requal' end)as renewal_type,effort_number,number_of_units from job_renewal_effort where job_id="
							+ jobId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobRenewalEffort;
	}

	@Override
	public List<Map<String, Object>> getJobBillingDetails(int jobId) {
		List<Map<String, Object>> jobBilling = new ArrayList<>();
		try {
			jobBilling = jdbcTemplate.queryForList(
					"select job_id,billing_def,billing_def_test_seq,effort_number,action,interval,send_bill,suppress_output,suppress_email from job_billing_effort  where job_billing_effort.job_id="
							+ jobId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobBilling;
	}

	@Override
	public int getOcId() {
		int ocId = 0;
		try {
			ocId = jdbcTemplate.queryForObject("select oc_id from job_pub_oc", Integer.class);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return ocId;
	}

	@Override
	public String insertJobRenewalEffort(SubmitJobModel submitJobModel) {
		Map<String, Object> addParams = new HashMap<>();

		try {
			for (int i = 0; i <= 11; i++) {
				StringBuilder query = new StringBuilder(
						"insert into job_renewal_effort(suppress_output,suppress_email,renewal_def,renewal_def_test_seq,effort_number,job_id,renewal_type,effort_type,number_of_units,volume_group_month_day) "
								+ "values(:suppress_output,:suppress_email,:renewal_def,:renewal_def_test_seq,:effort_number,:job_id,:renewal_type,:effort_type,:number_of_units,:volume_group_month_day)");
				int processId = submitJobModel.getProcessId();
				int maxId = jdbcTemplate.queryForObject("select max(job_id) from job ", Integer.class);
				addParams.put("job_id", maxId);
				addParams.put("suppress_output", submitJobModel.getSuppressOutput());

				addParams.put("suppress_email", submitJobModel.getSuppressEmail());
				addParams.put("renewal_type", submitJobModel.getRenewalType());
				addParams.put("renewal_def_test_seq", 1);
				Integer effortNumber = jdbcTemplate.queryForObject(
						"select max(effort_number) from job_renewal_effort where job_id=" + maxId, Integer.class);
				if (effortNumber == null) {
					addParams.put("effort_number", 1);
				} else {
					addParams.put("effort_number", effortNumber + 1);
				}
				Integer numberOfUnits = jdbcTemplate.queryForObject(
						"select min(number_of_units) from job_renewal_effort where job_id=" + maxId, Integer.class);
				if (numberOfUnits == null) {

					addParams.put("number_of_units", 12);
				} else {

					addParams.put("number_of_units", numberOfUnits - 1);
				}
				System.out.println(numberOfUnits);
				addParams.put("effort_type", submitJobModel.getEffortType());
				addParams.put("renewal_def", submitJobModel.getRenewalDef());

				addParams.put("volume_group_month_day", submitJobModel.getVolumeGroupMonthDay());
				namedParameterJdbcTemplate.update(query.toString(), addParams);
			}

			return "Rows Inserted SuccessFully";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "Rows Insertion UnSuccessFull";
		}

	}

	@Override
	public List<Map<String, Object>> getIssueDetails(String issueId, String issueDate, String enumeration,
			String volumeGroupId, String description) {
		List<Map<String, Object>> issueDetails = new ArrayList<>();
		try {
			StringBuilder issueQuery = new StringBuilder();
			issueQuery.append(
					"select issue_id,oc_id,inventory_id,user_code,FORMAT(issue_date,'yyyy-MM-dd HH:mm:ss.sss') as issue_date,enumeration,enum_volume_nbr,enum_issue_nbr,issue_close_date,sub_out_bit_pos,CAST(volume_group_id as varchar(10))as volume_group_id from issue where oc_id=6");
			if ("*".equals(issueId)) {
				issueQuery.append(" and issue_id like '%'");
			} else if (issueId.contains("*")) {
				issueQuery.append(" and issue_id like '" + issueId.replace('*', '%') + "'");
			} else if (!issueId.equals("")) {
				issueQuery.append(" and issue_id='" + issueId + "'");
			}
			if ("*".equals(issueDate)) {
				issueQuery.append(" and issue_date like '%'");
			} else if (issueDate.contains("*")) {

				issueQuery.append(" and issue_date like '" + issueDate.replace('*', '%') + "'");
			} else if (!issueDate.equals("")) {
				issueQuery.append(" and issue_date='" + issueDate + "'");
			}
			if ("*".equals(enumeration)) {
				issueQuery.append(" and enumeration like '%'");
			} else if (enumeration.contains("*")) {
				issueQuery.append(" and enumeration like '" + enumeration.replace('*', '%') + "'");
			} else if (!enumeration.equals("")) {
				issueQuery.append(" and enumeration='" + enumeration + "'");
			}
			if ("*".equals(volumeGroupId)) {
				issueQuery.append(" and volume_group_id like '%'");
			} else if (volumeGroupId.contains("*")) {

				issueQuery.append(" and volume_group_id like '" + volumeGroupId.replace('*', '%') + "'");
			} else if (!volumeGroupId.equals("")) {
				issueQuery.append(" and volume_group_id='" + volumeGroupId + "'");
			}
			issueQuery.append(" ORDER BY issue_date");
			issueDetails = jdbcTemplate.queryForList(issueQuery.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return issueDetails;
	}

	@Override
	public List<Map<String, Object>> getAddressDetails() {
		List<Map<String, Object>> addressDetails = new ArrayList<>();
		try {
			addressDetails = jdbcTemplate.queryForList(
					"select address_id,address1 as street1,address2 as street2,address3 as street3,city,county,zip,state FROM address");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return addressDetails;
	}

	@Override
	public String insertBillingJobEffort(SubmitJobModel submitJobModel, int jobId) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job_billing_effort(job_id,billing_def,billing_def_test_seq,effort_number,action,interval,send_bill,suppress_output,suppress_email)"
						+ "values(:job_id,:billing_def,:billing_def_test_seq,:effort_number,:action,:interval,:send_bill,:suppress_output,:suppress_email)");
		try {
			addParams.put("job_id", jobId);
			addParams.put("billing_def", submitJobModel.getBillingDef());
			addParams.put("billing_def_test_seq", 1);
			addParams.put("effort_number", 1);
			addParams.put("interval", submitJobModel.getInterval());
			addParams.put("send_bill", submitJobModel.getSendBill());
			addParams.put("action", submitJobModel.getAction());
			addParams.put("suppress_output", submitJobModel.getSuppressOutput());
			addParams.put("suppress_email", submitJobModel.getSuppressEmail());
			namedParameterJdbcTemplate.update(query.toString(), addParams);

			return "Row Inserted SuccessFully";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "Row Insertion UnSuccessFull";

		}
	}

	@Override
	public List<Map<String, Object>> getJobRenewalEffortDetails() {
		List<Map<String, Object>> jobRewalEffort = new ArrayList<>();
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job_renewal_effort", Integer.class);
			jobRewalEffort = jdbcTemplate.queryForList(
					"select  suppress_output,suppress_email,renewal_def,renewal_def_test_seq,volume_group_month_day,job_id,(case when effort_type=0 then 'N/A' when effort_type=1 then 'Issues/Units Left' when effort_type=2 then 'Issues/Units Left with Expires' when effort_type=3 then 'At Birth' when effort_type=4 then 'By Package Expire Date' when effort_type=5 then 'from Long Qual' when effort_type=6 then 'from Short Qual' when effort_type=7 then 'By Subscription Expire Date' when effort_type=8 then 'Exact Issues/Units Left' end)as effort_type,(case when renewal_type=0 then 'by issue/Unit' when renewal_type=1 then 'By Volume Group' when renewal_type=2 then 'Requal' end)as renewal_type,effort_number,number_of_units from job_renewal_effort where job_id="
							+ maxId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobRewalEffort;
	}

	@Override
	public List<Map<String, Object>> billingDetails(String billingDef) {
		List<Map<String, Object>> billingDetail = new ArrayList<>();
		try {
			billingDetail = jdbcTemplate.queryForList(
					"select job_id,billing_def,billing_def_test_seq,effort_number,action,interval,send_bill,suppress_output,suppress_email from job_billing_effort  where  billing_def='"
							+ billingDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return billingDetail;
	}

	@Override
	public String insertProductSubmitJob(JobModel jobModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,label_keyline,label_group,process_id,drop_date,note,start_date_time,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,job_completion_email_address,manual_review_fulfillment,cutoff_date,inv_serve_label)"
						+ "values(:job_id,:label_keyline,:label_group,:process_id,:drop_date,:note,:start_date_time,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:job_completion_email_address,:manual_review_fulfillment,:cutoff_date,:inv_serve_label)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);
		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();
				int jobHold = jobModel.getHoldJob();
				int holdbit = holdUpdate + holdOutput + jobHold;

				addParams.put("process_id", processId);
				addParams.put("label_keyline", result.get("label_keyline"));
				addParams.put("label_group", result.get("label_group"));
				addParams.put("drop_date", new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getDropDate()));
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));
				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("job_completion_email_address", result.get("job_completion_email_address"));
				addParams.put("manual_review_fulfillment", jobModel.getManualReviewFulfillment());
				addParams.put("cutoff_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getCutOffDate()));
				addParams.put("inv_serve_label", jobModel.getInvServeLabel());
			}
			namedParameterJdbcTemplate.update(query.toString(), addParams);
			return "Row Inserted SuccessFully";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "Row Inserted UnSuccessFully";

		}
	}

	@Override
	public List<Map<String, Object>> getProductSubmitJob(int jobId) {
		List<Map<String, Object>> productSubmitJobDetail = new ArrayList<>();
		try {
			productSubmitJobDetail = jdbcTemplate.queryForList(
					"select job_id,label_keyline,label_group,process_id,drop_date,note,start_date_time,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,job_completion_email_address,manual_review_fulfillment,cutoff_date,inv_serve_label from job where job_id="
							+ jobId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return productSubmitJobDetail;
	}

	@Override
	public String addJobOutput(String paramValues, String ouputFilename) {
		Map<String, Object> addParams = new HashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job_output(job_id,job_output_seq,param_values,output_type,output_mode,output_filename,oc_id,report)values(:job_id,:job_output_seq,:param_values,:output_type,:output_mode,:output_filename,:oc_id,:report)");
		int status = 0;
		try {
			Integer jobId = jdbcTemplate.queryForObject("select max(job_id) from job ", Integer.class);
			addParams.put("job_id", jobId);
			addParams.put("job_output_seq", 1);
			addParams.put("param_values", paramValues);
			addParams.put("output_type", 5);
			addParams.put("output_mode", 0);
			addParams.put("output_filename", ouputFilename);
			addParams.put("oc_id", 24);
			addParams.put("report", null);
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			if (status != 0) {
				for (int i = 1; i < 4; i++) {
					StringBuilder query1 = new StringBuilder(
							"insert into job_prod_oc(job_id,oc_id,product_id,profit_center,profit_center_calendar_seq,n_customers,n_orders,n_quantity)values(:job_id,:oc_id,:product_id,:profit_center,:profit_center_calendar_seq,:n_customers,:n_orders,:n_quantity)");
					List<Map<String, Object>> orderDetails = jdbcTemplate.queryForList(
							"select  distinct oc.oc_id,oc.profit_center from oc inner join job_output on oc.oc_id=job_output.oc_id ");
					for (Map<String, Object> result : orderDetails) {
						addParams.put("job_id", jobId);
						addParams.put("oc_id", result.get("oc_id"));
						Integer productId = jdbcTemplate.queryForObject(
								"select max(product_id) from job_prod_oc where job_id=" + jobId, Integer.class);
						if (productId == null) {
							addParams.put("product_id", 2);
						} else {
							addParams.put("product_id", productId + 1);
						}
						addParams.put("profit_center", result.get("profit_center"));
						addParams.put("profit_center_calendar_seq", 1);
						addParams.put("n_customers", 0);
						addParams.put("n_orders", 0);
						addParams.put("n_quantity", 0);
						namedParameterJdbcTemplate.update(query1.toString(), addParams);
					}

				}

			}
			return "true";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "false";
		}

	}

	@Override
	public List<Map<String, Object>> getProductJobOutput(int ocId) {
		List<Map<String, Object>> productJobOutput = new ArrayList<>();
		try {
			productJobOutput = jdbcTemplate.queryForList(
					"select oc.oc,(case when oc.oc_type=2  then 'Product' end) as Type,job_output.param_values,job_output.output_filename,job_output.report,job_output.output_mode from  job_output inner join oc on job_output.oc_id=oc.oc_id  where job_output.oc_id="
							+ ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return productJobOutput;
	}

	@Override
	public int insertInstallmentNotices(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,select_start_date,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,job_completion_email_address,select_end_date,schedule_payment_date)"
						+ "values(:job_id,:process_id,:note,:select_start_date,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:job_completion_email_address,:select_end_date,:schedule_payment_date)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();
				int jobHold = jobModel.getHoldJob();
				int holdbit = holdUpdate + holdOutput + jobHold;

				addParams.put("process_id", processId);
				addParams.put("select_end_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSelectEndDate()));
				addParams.put("note", jobModel.getNote());
				addParams.put("select_start_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSelectStartDate()));
				addParams.put("schedule_payment_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSchedulePaymentDate()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("job_completion_email_address", result.get("job_completion_email_address"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public List<Map<String, Object>> installNoticeSubmitJobDetails(int processId) {
		List<Map<String, Object>> installNoticeSumitJob = new ArrayList<>();
		try {
			installNoticeSumitJob = jdbcTemplate.queryForList(
					"select job_id,process.process_id,note,select_start_date,process.description,job_priority,job.queue,job.n_interval_units,log_option,status,hold_bits,select_end_date,schedule_payment_date from job inner join process on job.process_id=process.process_id where process.process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return installNoticeSumitJob;
	}

	@Override
	public List<Map<String, Object>> getCleanupSubmitJobDetails(int processId) {
		List<Map<String, Object>> cleanupSubmitJobDetails = new ArrayList<>();
		try {
			cleanupSubmitJobDetails = jdbcTemplate.queryForList(
					"select job_id,job.process_id,note,start_date_time,job.description,job_priority,job.queue,job.n_interval_units,log_option,status,hold_bits,job.repeating_type,job.job_completion_email_address,n_days_to_next_run from job inner join process on job.process_id=process.process_id where process.process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return cleanupSubmitJobDetails;
	}

	@Override
	public int insertCleanupSubmitJob(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,start_date_time,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,job_completion_email_address,n_days_to_next_run)"
						+ "values(:job_id,:process_id,:note,:start_date_time,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:job_completion_email_address,:n_days_to_next_run)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();
				int jobHold = jobModel.getHoldJob();
				int holdbit = holdUpdate + holdOutput + jobHold;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("job_completion_email_address", result.get("job_completion_email_address"));
				addParams.put("n_days_to_next_run", jobModel.getnDaysToNextRun());
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public List<Map<String, Object>> getRefundSubmitJob(int processId) {
		List<Map<String, Object>> refundSubmitJob = new ArrayList<>();
		try {
			refundSubmitJob = jdbcTemplate.queryForList(
					"select job_id,job.process_id,note,job.description,job_priority,job.queue,job.n_interval_units,log_option,status,hold_bits,job.repeating_type,back_issues_on_reinstated,select_start_date,select_end_date,(case when hold_bits=1 OR hold_bits=11 OR hold_bits=3 then 1 else 0 end) as holdJob,(case when hold_bits=8 OR hold_bits=11 OR hold_bits=10 then 1 else 0 end)as holdUpdate,(case when hold_bits=2 OR hold_bits=10 OR hold_bits=11 OR hold_bits=3 then 1 else 0 end) as holdOutput from job inner join process on job.process_id=process.process_id where process.process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return refundSubmitJob;
	}

	@Override
	public int insertRefundSubmitJob(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,back_issues_on_reinstated,select_start_date,select_end_date)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:back_issues_on_reinstated,:select_start_date,:select_end_date)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = 2;
				int holdUpdate = jobModel.getHoldUpdate();// 10 value in table
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdUpdate + holdOutput + holdJob;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				// addParams.put("start_date_time", new SimpleDateFormat("yyyy-mm-dd
				// HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				addParams.put("back_issues_on_reinstated", jobModel.getBackIssuesOnReinstated());

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				addParams.put("select_start_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSelectStartDate()));
				addParams.put("select_end_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSelectEndDate()));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;

	}

	@Override
	public int insertStartStopSubmitJob(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				// int holdUpdate=jobModel.getHoldUpdate();//10 value in table
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdOutput + holdJob;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				// addParams.put("back_issues_on_reinstated",
				// jobModel.getBackIssuesOnReinstated());

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				// addParams.put("select_start_date", new SimpleDateFormat("yyyy-mm-dd
				// HH:MM:ss").parse(jobModel.getSelectStartDate()));
				// addParams.put("select_end_date", new SimpleDateFormat("yyyy-mm-dd
				// HH:MM:ss").parse(jobModel.getSelectEndDate()));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int insertJobPubOc(int ocId) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job_pub_oc(job_id,oc_id,issue_id,n_reg_single_copies,n_reg_bundled_copies,n_grace_single_copies,n_grace_bundled_copies,n_undel_single_copies,n_undel_bundled_copies,close_issue,n_subscriptions,profit_center,profit_center_calendar_seq,audit_begin_date,audit_end_date)"
						+ " values(:job_id,:oc_id,:issue_id,:n_reg_single_copies,:n_reg_bundled_copies,:n_grace_single_copies,:n_grace_bundled_copies,:n_undel_single_copies,:n_undel_bundled_copies,:close_issue,:n_subscriptions,:profit_center,:profit_center_calendar_seq,:audit_begin_date,:audit_end_date)");
		try {
			int jobId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			List<Map<String, Object>> issueDetails = jdbcTemplate.queryForList(
					"SELECT issue_id,issue_date,frozen,audit_begin_date,audit_end_date FROM issue WHERE oc_id =" + ocId
							+ " and issue_date = (select min(issue_date) from issue where oc_id =" + ocId
							+ " and issue_close_date is null)");
			for (Map<String, Object> row : issueDetails) {
				addParams.put("job_id", jobId);
				addParams.put("oc_id", ocId);
				addParams.put("issue_id", row.get("issue_id"));
				addParams.put("n_reg_single_copies", 0);
				addParams.put("n_reg_bundled_copies", 0);
				addParams.put("n_grace_single_copies", 0);
				addParams.put("n_grace_bundled_copies", 0);
				addParams.put("n_undel_single_copies", 0);
				addParams.put("n_undel_bundled_copies", 0);
				addParams.put("close_issue", 0);
				addParams.put("n_subscriptions", 0);
				addParams.put("profit_center", null);
				addParams.put("profit_center_calendar_seq", 1);
				addParams.put("audit_begin_date", row.get("audit_bigin_date"));
				addParams.put("audit_end_date", row.get("audit_end_date"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> allProcess(int effortNumber) {
		List<Map<String, Object>> processDetails = new ArrayList<>();
		try {

			processDetails = jdbcTemplate.queryForList(
					"select distinct process.process_id,description,(case when process_billing_effort.effort_number="
							+ effortNumber
							+ " then 1 else 0 end)as active from process inner join process_billing_effort on process.process_id=process_billing_effort.process_id where process.process_type in(1,0,3)");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return processDetails;
	}

	@Override
	public List<Map<String, Object>> allOrder(String billingDef) {
		List<Map<String, Object>> processDetails = new ArrayList<>();
		try {
			processDetails = jdbcTemplate
					.queryForList("SELECT distinct oc.oc_id,oc.oc,(case when billing_def_oc.billing_def='" + billingDef
							+ "' then 1 else 0 end) as incl FROM billing_def_oc inner join oc on oc.oc_id=billing_def_oc.oc_id WHERE oc.oc_type in(1,2,3,4,5) and billing_def='"
							+ billingDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return processDetails;

	}

	@Override
	public List<DropdownModel> getOutputDetails() {
		List<Map<String, Object>> displayOutput = new ArrayList<>();
		List<DropdownModel> outputList = new ArrayList<>();
		try {
			displayOutput = jdbcTemplate.queryForList("select report as OutPut,description from report");
			for (Map<String, Object> row : displayOutput) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("OutPut").toString());
				model.setDisplay(row.get("description") != null ? row.get("description").toString() : "");
				outputList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return outputList;
	}

	@Override
	public List<Map<String, Object>> getStartStopSubmitJob(int processId) {
		List<Map<String, Object>> startStopSubmitJobDetail = new ArrayList<>();
		try {
			startStopSubmitJobDetail = jdbcTemplate.queryForList(
					"select job_id,job.process_id,note,job.description,job_priority,job.queue,job.n_interval_units,log_option,status,hold_bits,job.repeating_type,start_date_time,(case when hold_bits=1 OR hold_bits=3  then 1 else 0 end) as holdJob,(case when hold_bits=2 OR hold_bits=3 then 1 else 0 end) as holdOutput from job inner join process on job.process_id=process.process_id where process.process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return startStopSubmitJobDetail;
	}

	@Override
	public List<Map<String, Object>> getjobPubOcDetail() {
		List<Map<String, Object>> jobPubOcDetail = new ArrayList<>();
		try {
			jobPubOcDetail = jdbcTemplate.queryForList(
					"select job_id,oc.oc,job_pub_oc.oc_id,issue_id,n_reg_single_copies,n_reg_bundled_copies,n_grace_single_copies,n_grace_bundled_copies,n_undel_single_copies,n_undel_bundled_copies,close_issue,n_subscriptions,oc.profit_center,profit_center_calendar_seq,job_pub_oc.audit_begin_date,job_pub_oc.audit_end_date from job_pub_oc inner join oc on oc.oc_id=job_pub_oc.oc_id");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobPubOcDetail;
	}

	@Override
	public boolean insertJobPromotionEffort() {
		Map<String, Object> addParams = new HashMap<>();
		Integer effortNumber = null;
		StringBuilder query = new StringBuilder(
				"insert into job_promotion_effort(job_id,promotion_def,promotion_def_test_seq,effort_number,suppress_output,days_from_first_effort,process_method)"
						+ "values(:job_id,:promotion_def,:promotion_def_test_seq,:effort_number,:suppress_output,:days_from_first_effort,:process_method)");
		try {
			for (int i = 1; i <= 4; i++) {
				int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
				addParams.put("job_id", maxId);
				addParams.put("promotion_def", "PDef1");
				addParams.put("promotion_def_test_seq", 1);
				addParams.put("suppress_output", 0);
				effortNumber = jdbcTemplate.queryForObject(
						"select max(effort_number) from job_promotion_effort where job_id=" + maxId, Integer.class);
				if (effortNumber == null) {
					addParams.put("effort_number", 1);
				} else {
					addParams.put("effort_number", effortNumber + 1);
				}
				Integer numberOfDays = jdbcTemplate.queryForObject(
						"select max(days_from_first_effort) from job_promotion_effort where job_id=" + maxId,
						Integer.class);
				if (numberOfDays == null) {
					addParams.put("days_from_first_effort", 0);
				} else {
					addParams.put("days_from_first_effort", numberOfDays + 10);
				}
				addParams.put("process_method", 0);
				namedParameterJdbcTemplate.update(query.toString(), addParams);
			}
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}

	}

	@Override
	public List<Map<String, Object>> getJobPromotionDetails(int jobId) {
		List<Map<String, Object>> jobPromotionDetails = new ArrayList<>();
		try {
			jobPromotionDetails = jdbcTemplate.queryForList(
					"select promotion_def,promotion_def_test_seq,effort_number,job_id,suppress_output from job_promotion_effort");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobPromotionDetails;
	}

	@Override
	public boolean insertOnoff(JobModel jobModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdJob;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				namedParameterJdbcTemplate.update(query.toString(), addParams);

			}
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}

	}

	@Override
	public boolean insertOnOffJobPubOc(int issueId) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job_pub_oc(profit_center_calendar_seq,oc_id,job_id,issue_id,second_issue_id,issue_date,second_issue_date)values(:profit_center_calendar_seq,:oc_id,:job_id,:issue_id,:second_issue_id,:issue_date,:second_issue_date)");
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			List<Map<String, Object>> details = jdbcTemplate
					.queryForList("select oc_id,issue_id,issue_date from issue where issue_id=" + issueId);
			for (Map<String, Object> result : details) {
				addParams.put("job_id", maxId);
				addParams.put("issue_id", result.get("issue_id"));
				addParams.put("second_issue_id", result.get("issue_id"));
				addParams.put("issue_date", null);
				addParams.put("second_issue_date", result.get("issue_date"));
				addParams.put("oc_id", result.get("oc_id"));
				addParams.put("profit_center_calendar_seq", 1);
				namedParameterJdbcTemplate.update(query.toString(), addParams);

			}
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> getOnOffjobPubOcDetail() {
		List<Map<String, Object>> jobPubocDetails = new ArrayList<>();
		try {
			jobPubocDetails = jdbcTemplate.queryForList(
					"select job_id,oc.oc,job_pub_oc.oc_id,issue_id,issue_date,second_issue_id,second_issue_date from job_pub_oc inner join oc on oc.oc_id=job_pub_oc.oc_id");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return jobPubocDetails;
	}

	@Override
	public int insertMassKillJob(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getHoldUpdate();// 10 value in table
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdOutput + holdJob + holdUpdate;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
				int jobId = jobModel.getJobId();
				System.out.println(jobId);
				if (status != 0) {
					StringBuilder query1 = new StringBuilder(
							"insert into job_mass_kill(job_id,do_mass_kill,do_mass_suspend,mass_kill_date,mass_suspend_date)values (:job_id,:do_mass_kill,:do_mass_suspend,:mass_kill_date,:mass_suspend_date)");
					int maxId1 = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
					addParams.put("job_id", maxId1);
					addParams.put("do_mass_kill", 0);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					addParams.put("mass_kill_date", dtf.format(now));
					DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime now1 = LocalDateTime.now();
					addParams.put("mass_suspend_date", dtf1.format(now1));
					addParams.put("do_mass_suspend", 0);

					status = namedParameterJdbcTemplate.update(query1.toString(), addParams);
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getMassKill(int processId) {
		List<Map<String, Object>> massKillSubmitJobDetails = new ArrayList<>();
		try {
			massKillSubmitJobDetails = jdbcTemplate.queryForList(
					"select process_id,note,description,job_priority,queue,n_interval_units,log_option,status,(case when hold_bits=1 OR hold_bits=7 OR hold_bits=3 OR hold_bits=5 then 1 else 0 end)as holdJob, (case when hold_bits=2 OR hold_bits=7 Or hold_bits=6 Or hold_bits=3 then 1 else 0 end ) as holdOutput,(case when hold_bits=4 OR hold_bits=7 OR hold_bits=6 OR hold_bits=5 then 1 else 0 end)as holdUpdate ,start_date_time,job_mass_kill.do_mass_kill,job_mass_kill.do_mass_suspend,job_mass_kill.mass_kill_date from job inner join job_mass_kill on job.job_id=job_mass_kill.job_id where job.process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return massKillSubmitJobDetails;
	}

	@Override
	public List<Map<String, Object>> getBillTesting(String billingDef) {
		List<Map<String, Object>> billTesting = new ArrayList<>();
		try {
			billTesting = jdbcTemplate.queryForList(
					"select billing_def,description,billing_def_test_seq,nth_def from billing_def_test where billing_def='"
							+ billingDef + "'");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return billTesting;
	}

	@Override
	public Object getBillingDefEffort(int processId) {
		LOGGER.info("Inside Get Billing Effort");
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(
					"select distinct (case when billing_def_effort.action=0 then 'Bill' when billing_def_effort.action=1 then 'Suspend' when billing_def_effort.action=2 then 'Cancel' end)as action,(case when process_method=0 then 'Direct' when process_method=1 then 'W/Mag' end) as process_method,billing_def_effort.report,(case when billing_def_effort.send_bill=0 then 'false' when billing_def_effort.send_bill=1 then 'true' end)as senBill,(case when billing_def_effort.send_to=0 then 'Donor' when billing_def_effort.send_to=1 then 'Reciepient' end)as sendTo,(case when billing_def_effort.suppress_email=0 then 'False' when billing_def_effort.suppress_email=1 then 'True' end)as suppressEmail "
							+ ",billing_def_effort.effort_number,billing_def_effort.billing_def,billing_def_effort.billing_def_test_seq,billing_def_effort.attachment_code,billing_def_effort.interval,billing_def_effort.message_string,(case when billing_def_effort.effort_number IN(select effort_number from process_billing_effort where process_id="
							+ processId + ")"
							+ "and billing_def_effort.billing_def IN(select billing_def from process_billing_effort where process_id="
							+ processId + ") then 1 else 0 end)" + " as Active from"
							+ " billing_def_effort left join process_billing_effort on"
							+ " billing_def_effort.billing_def=process_billing_effort.billing_def and process_billing_effort.process_id="
							+ processId + " ");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public int insertListExtract(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time,label_group,list_company,purpose,nth_def)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time,:label_group,:list_company,:purpose,:nth_def)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select nth_def,label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdOutput + holdJob;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				addParams.put("list_company", jobModel.getListCompany());
				addParams.put("purpose", jobModel.getPurpose());
				addParams.put("nth_def", result.get("nth_def"));
				addParams.put("label_group", result.get("label_group"));

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getListExtract(int processId) {
		List<Map<String, Object>> lisExtract = new ArrayList<>();
		try {
			lisExtract = jdbcTemplate.queryForList(
					"select job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,(case when hold_bits=1 Or hold_bits=3 then 1 else 0 end)as holdJob,(case when hold_bits=2 OR hold_bits=3 then 1 else 0 end)as holdOutput,repeating_type,start_date_time,label_group,list_company,purpose,nth_def from job where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return lisExtract;
	}

	@Override
	public int insertIcsBatchListe(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select nth_def,label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {
				int holdOutput = jobModel.getHoldOutput();
				int holdUpdate = jobModel.getUpdated();
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdJob + holdOutput + holdUpdate;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public List<Map<String, Object>> getIcsBatchListener(int processId) {
		List<Map<String, Object>> icsBatchListener = new ArrayList<>();
		try {
			icsBatchListener = jdbcTemplate.queryForList(
					"select job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,(case when hold_bits=1 then 1 else 0 end)as holdJob,repeating_type,start_date_time,label_group from job where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return icsBatchListener;
	}

	@Override
	public List<Map<String, Object>> getCreditTokenRefresh(int processId) {
		List<Map<String, Object>> icsBatchListener = new ArrayList<>();
		try {
			icsBatchListener = jdbcTemplate.queryForList(
					"select job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,(case when hold_bits=1 OR hold_bits=7 OR hold_bits=3 OR hold_bits=5 then 1 else 0 end)as holdJob, (case when hold_bits=2 OR hold_bits=7 Or hold_bits=6 Or hold_bits=3 then 1 else 0 end ) as holdOutput,(case when hold_bits=4 OR hold_bits=7 OR hold_bits=6 OR hold_bits=5 then 1 else 0 end)as holdUpdate,repeating_type,start_date_time,label_group from job where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return icsBatchListener;

	}

	@Override
	public int insertBacsBilling(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time,label_group,cutoff_date,drop_date,run_payment_after_bill,label_keyline)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time,:label_group,:cutoff_date,:drop_date,:run_payment_after_bill,:label_keyline)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select nth_def,label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdOutput + holdJob;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));
				addParams.put("cutoff_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getCutOffDate()));
				addParams.put("drop_date", new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getDropDate()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				addParams.put("run_payment_after_bill", jobModel.getRunPaymentAfter());
				addParams.put("label_keyline", result.get("label_keyline"));
				addParams.put("label_group", result.get("label_group"));

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
				if (status != 0) {
					StringBuilder query1 = new StringBuilder(
							"insert into job_installment_plan(job_id,installment_plan_id,nbr_installments,interval,interval_type)values(:job_id,:installment_plan_id,:nbr_installments,:interval,:interval_type)");
					addParams.put("job_id", maxId);
					addParams.put("installment_plan_id", 1);
					addParams.put("nbr_installments", 1);
					addParams.put("interval", 0);
					addParams.put("interval_type", 0);

					status = namedParameterJdbcTemplate.update(query1.toString(), addParams);

				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getBacsBilling(int processId) {
		List<Map<String, Object>> details = new ArrayList<>();
		try {
			details = jdbcTemplate.queryForList(
					"select job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,(case when hold_bits=1 OR hold_bits=7 OR hold_bits=3 OR hold_bits=5 then 1 else 0 end)as holdJob, (case when hold_bits=2 OR hold_bits=7 Or hold_bits=6 Or hold_bits=3 then 1 else 0 end ) as holdOutput,(case when hold_bits=4 OR hold_bits=7 OR hold_bits=6 OR hold_bits=5 then 1 else 0 end)as holdUpdate ,repeating_type,start_date_time,label_group,cutoff_date,drop_date,run_payment_after_bill,label_keyline from job where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return details;
	}

	@Override
	public int insertBacsDD(JobModel jobModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into job(job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,hold_bits,repeating_type,start_date_time,label_group,select_start_date,select_end_date,back_issues_on_reinstated)"
						+ "values(:job_id,:process_id,:note,:description,:job_priority,:queue,:n_interval_units,:log_option,:status,:hold_bits,:repeating_type,:start_date_time,:label_group,:select_start_date,:select_end_date,:back_issues_on_reinstated)");
		int processId = jobModel.getProcessId();
		String jobQueue = jobModel.getQueue();

		int areYouDead = jdbcTemplate.queryForObject(
				"SELECT are_you_dead FROM job_running WHERE description = " + "'" + jobQueue + "'", Integer.class);

		if (areYouDead == 0) {
			jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='" + jobQueue + "'");
		}
		try {
			int maxId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			if (maxId == 0) {
				addParams.put("job_id", 1);
			} else {
				addParams.put("job_id", maxId + 1);
			}
			List<Map<String, Object>> processQuery = jdbcTemplate.queryForList(
					"select nth_def,label_group,label_keyline,queue,description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,nth_def,default_job_priority,label_keyline from process where process_id="
							+ processId);
			for (Map<String, Object> result : processQuery) {

				int holdOutput = jobModel.getHoldOutput();
				int holdJob = jobModel.getHoldJob();// 1 value in table
				int holdbit = holdOutput + holdJob;

				addParams.put("process_id", processId);
				addParams.put("note", jobModel.getNote());
				addParams.put("start_date_time",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getStartDateTime()));
				addParams.put("select_start_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSelectStartDate()));
				addParams.put("select_end_date",
						new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(jobModel.getSelectEndDate()));

				addParams.put("description", result.get("description"));
				addParams.put("job_priority", result.get("default_job_priority"));
				addParams.put("queue", result.get("queue"));
				addParams.put("n_interval_units", result.get("n_interval_units"));
				addParams.put("log_option", jobModel.getLogOption());
				// addParams.put("bacs_step", jobModel.getBac);
				addParams.put("back_issues_on_reinstated", jobModel.getBackIssuesOnReinstated());

				addParams.put("label_keyline", result.get("label_keyline"));
				addParams.put("label_group", result.get("label_group"));

				if (holdbit != 0) {
					addParams.put("status", 1);

				} else {
					addParams.put("status", 0);

				}
				addParams.put("hold_bits", holdbit);
				addParams.put("repeating_type", result.get("repeating_type"));
				status = namedParameterJdbcTemplate.update(query.toString(), addParams);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getBascDD(int processId) {
		List<Map<String, Object>> bacsDD = new ArrayList<>();
		try {
			bacsDD = jdbcTemplate.queryForList(
					"select job_id,process_id,note,description,job_priority,queue,n_interval_units,log_option,status,(case when hold_bits=1 OR hold_bits=7 OR hold_bits=3 OR hold_bits=5 then 1 else 0 end)as holdJob, (case when hold_bits=2 OR hold_bits=7 Or hold_bits=6 Or hold_bits=3 then 1 else 0 end ) as holdOutput,(case when hold_bits=4 OR hold_bits=7 OR hold_bits=6 OR hold_bits=5 then 1 else 0 end)as holdUpdate,repeating_type,start_date_time,label_group,select_start_date,select_end_date,back_issues_on_reinstated from job where process_id="
							+ processId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return bacsDD;
	}

}
