package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.dao.CustomerLoginDao;
import com.mps.think.model.CustomerLoginModel;
import com.mps.think.model.DistributionAttributeModel;
import com.mps.think.model.DistributionMethodModel;
import com.mps.think.model.DistributionValueModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.util.CustomerUtility;

@Repository
public class CustomerLoginDaoImpl implements CustomerLoginDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLoginDaoImpl.class);
//	private SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
//	private SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private CustomerUtility customerUtility;

	@Override
	public List<Map<String, Object>> getCustomerLoginDetails(int customerId) {

		LOGGER.info("Inside getCustomerLoginDetails");
		List<Map<String, Object>> loginData = null;

		try {
			loginData = jdbcTemplate
					.queryForList("select * from view_customer_login where customer_id = " + customerId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return loginData;
	}

	@Override
	public List<DropdownModel> getPassQuestionDetails() {
		LOGGER.info("Inside getCustomerLoginDetails");
		List<DropdownModel> passQuestion = new ArrayList<>();
		try {
			// Query edited to resolve THINKDEV-538
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select * from customer_login_question WHERE inactive=0;");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("customer_login_question_id").toString());
				model.setDisplay(row.get("question").toString());

				passQuestion.add(model);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return passQuestion;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addLogin(CustomerLoginModel customerLoginModel) {
		LOGGER.info("Inside addLogin");
		try {

			Long maxCustEventId = jdbcTemplate.queryForObject("select max(event_queue_id) from event_queue",
					Long.class);
			if (maxCustEventId == null)
				maxCustEventId = (long) 0;

			Long maxCustLoginId = jdbcTemplate.queryForObject("select max(customer_login_id) from customer_login",
					Long.class);
			if (maxCustLoginId == null)
				maxCustLoginId = (long) 0;

			Random rand = new Random();
			int salt = rand.nextInt(10000);

			String custAddQuery = "INSERT INTO customer_login "
					+ "(customer_login_id,customer_id,customer_login_question_id,login,password,creation_date,is_primary_login,salt,hint,locked_out,invalid_auth_attempts,response) VALUES "
					+ "(:customer_login_id, :customer_id, :customer_login_question_id, :login, :password, :creation_date, :is_primary_login, :salt, :hint, :locked_out, :invalid_auth_attempts, :response)";

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("customer_login_id", maxCustLoginId + 1);
			parameters.put("customer_id", customerLoginModel.getCustomerId());
			parameters.put("customer_login_question_id", customerLoginModel.getPassQuestionId());
			parameters.put("login", customerLoginModel.getLogin());
			parameters.put("password", customerUtility.encrypt(customerLoginModel.getPassword(), salt));
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			parameters.put("is_primary_login", customerLoginModel.getPrimaryLogin());
			parameters.put("salt", salt);
			parameters.put("hint", customerLoginModel.getHint());
			parameters.put("locked_out", customerLoginModel.getLockedOut());
			parameters.put("invalid_auth_attempts", customerLoginModel.getInvalidAttempts());
			parameters.put("response", customerLoginModel.getResponse());

			namedParameterJdbcTemplate.update(custAddQuery, parameters);
			parameters.clear();

			String custAddExtQuery = "INSERT INTO customer_login_ext (customer_login_id) VALUES(:customer_login_id)";

			parameters.put("customer_login_id", maxCustLoginId + 1);

			namedParameterJdbcTemplate.update(custAddExtQuery, parameters);
			parameters.clear();
			String date = jdbcTemplate.queryForObject("select  convert(varchar(10), GETDATE(), 120)", String.class);
			String firstEventQuery = "insert into event_queue (event_queue_id,customer_id,transaction_event,status,creation_date) "
					+ "values (:event_queue_id,:customer_id,:transaction_event,:status,:creation_date)";
			maxCustEventId = customerUtility.getMaxEventQueueId() + 1;
			parameters.put("event_queue_id", maxCustEventId);
			parameters.put("customer_id", customerLoginModel.getCustomerId());
			parameters.put("transaction_event", 31);
			parameters.put("status", 0);
			parameters.put("creation_date", date);
			namedParameterJdbcTemplate.update(firstEventQuery, parameters);
			parameters.clear();

			String eventQueueQuery = "INSERT INTO event_queue (event_queue_id,customer_id,customer_address_seq,customer_login_id,transaction_event,status,creation_date)"
					+ " VALUES(:event_queue_id,:customer_id,:customer_address_seq,:customer_login_id,:transaction_event,:status,:creation_date)";

			maxCustEventId = customerUtility.getMaxEventQueueId() + 2;
			parameters.put("event_queue_id", maxCustEventId);
			parameters.put("customer_id", customerLoginModel.getCustomerId());
			parameters.put("customer_address_seq", 1);
			parameters.put("customer_login_id", maxCustLoginId + 1);
			parameters.put("transaction_event", 31);
			parameters.put("status", 0);
			parameters.put("creation_date", date);

			namedParameterJdbcTemplate.update(eventQueueQuery, parameters);
			customerUtility.updateEventQueueId(maxCustEventId);
			return "Inserted";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String editLogin(CustomerLoginModel customerLoginModel) {
		LOGGER.info("Inside editLogin");
		try {

			// Long maxCustEventId = jdbcTemplate.queryForObject("select max(event_queue_id)
			// from event_queue", Long.class);
			Long maxCustEventId = new CustomerUtility().getMaxEventQueueId() + 1;
			String custEditQuery = "UPDATE customer_login set login=:login,is_primary_login=:is_primary_login,customer_login_question_id=:customer_login_question_id"
					+ ",response=:response,hint=:hint,locked_out=:locked_out,invalid_auth_attempts=:invalid_auth_attempts where customer_login_id="
					+ customerLoginModel.getCustLoginId() + " ";

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("login", customerLoginModel.getLogin());
			parameters.put("is_primary_login", customerLoginModel.getPrimaryLogin());
			parameters.put("customer_login_question_id", customerLoginModel.getPassQuestionId());
			parameters.put("response", customerLoginModel.getResponse());
			parameters.put("hint", customerLoginModel.getHint());
			parameters.put("locked_out", customerLoginModel.getLockedOut());
			parameters.put("invalid_auth_attempts", customerLoginModel.getInvalidAttempts());

			namedParameterJdbcTemplate.update(custEditQuery, parameters);
			parameters.clear();

			String eventQueueQuery = "INSERT INTO event_queue (event_queue_id,customer_id,transaction_event,status,creation_date)"
					+ " VALUES(:event_queue_id,:customer_id,:transaction_event,:status,:creation_date)";
			maxCustEventId = customerUtility.getMaxEventQueueId() + 1;
			parameters.put("event_queue_id", maxCustEventId);
			parameters.put("customer_id", customerLoginModel.getCustomerId());
			parameters.put("transaction_event", 30);
			parameters.put("status", 0);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));

			namedParameterJdbcTemplate.update(eventQueueQuery, parameters);
			customerUtility.updateEventQueueId(maxCustEventId);
			return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String deleteCustomerLogin(int customerId, int customerLoginId) {
		LOGGER.info("Inside editLogin");
		try {

			Long maxCustEventId = jdbcTemplate.queryForObject("select max(event_queue_id) from event_queue",
					Long.class);
			if (maxCustEventId == null)
				maxCustEventId = (long) 0;

			String custDeleteQuery = "delete from customer_login where customer_login_id=" + customerLoginId + " ";

			jdbcTemplate.update(custDeleteQuery);

			Map<String, Object> parameters = new HashMap<>();

			String eventQueueQuery = "INSERT INTO event_queue (event_queue_id,customer_id,transaction_event,status,creation_date)"
					+ " VALUES(:event_queue_id,:customer_id,:transaction_event,:status,:creation_date)";
			maxCustEventId = customerUtility.getMaxEventQueueId() + 1;
			parameters.put("event_queue_id", maxCustEventId);
			parameters.put("customer_id", customerId);
			parameters.put("transaction_event", 30);
			parameters.put("status", 0);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));

			namedParameterJdbcTemplate.update(eventQueueQuery, parameters);
			customerUtility.updateEventQueueId(maxCustEventId);
			return "Deleted";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

	}

	// Updated by Sohrab for THINKDEV-538
	@Override
	public String transferCustomerLogin(int customerId, int customerLoginId) {
		LOGGER.info("Inside editLogin");
		try {
			String transferCustQuery = "UPDATE customer_login SET customer_id=" + customerId
					+ " WHERE customer_login_id=" + customerLoginId + ";";
			jdbcTemplate.update(transferCustQuery);

			return "Transferred";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public String checkLoginAvailable(String login) {
		LOGGER.info("Inside editLogin");
		try {
			String result = null;
			Long isLoginPresent = jdbcTemplate.queryForObject(
					"select count(login) from customer_login where upper(login)=upper('" + login + "')", Long.class);
			if (isLoginPresent == 0) {
				result = "Available";
			} else {
				result = "Not Available";
			}

			return result;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public List<Map<String, Object>> getIpAddressDetails(int customerId) {

		LOGGER.info("Inside getIpAddressDetails");
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			result = jdbcTemplate.queryForList("select * from ip_address where customer_id =" + customerId
					+ " ORDER BY customer_id,low_ip,low_ipv6");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addIpAddress(int customerId, String lowIpAddress, String highIpAddress) {
		LOGGER.info("Inside addIpAddress");
		try {
			Map<String, Object> parameters = new HashMap<>();

			// jdbcTemplate.update("delete from ip_address where customer_id = " + customerId + "");

			int count = customerUtility.getcurrentDateStampCount();
			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}

			List<Object[]> list = new ArrayList<>();

			Long dateStamp = customerUtility.getmaxDateStamp();
			InetAddressValidator validator = InetAddressValidator.getInstance();
			if (Optional.ofNullable(lowIpAddress).isPresent() && Optional.ofNullable(highIpAddress).isPresent() && !"".equalsIgnoreCase(lowIpAddress.trim())  && !"".equalsIgnoreCase(highIpAddress.trim())) {
				if (validator.isValidInet4Address(lowIpAddress)) {
					if (validator.isValidInet4Address(highIpAddress)) {
						if (customerUtility.toLongIpNumber(lowIpAddress) <= customerUtility
								.toLongIpNumber(highIpAddress)) {
							Object[] objArr = { customerId, customerUtility.toLongIpNumber(lowIpAddress),
									customerUtility.toLongIpNumber(highIpAddress), lowIpAddress, highIpAddress,
									dateStamp };
							list.add(objArr);
						} else {
							throw new IllegalArgumentException(
									"Invalid : ip_address_data.low_ip_dotted/high_ip_dotted The Low IP Address can not be greater than the High IP Address.");
						}

					} else {
						throw new IllegalArgumentException("Invalid IP Address."
								+ " Please enter values between 0 and 255 for each segment for IPv4."
								+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
								+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");
					}
				} else if (validator.isValidInet6Address(lowIpAddress)) {
					if (validator.isValidInet6Address(highIpAddress)) {
						if (customerUtility.toLongIPV6Number(lowIpAddress) <= customerUtility
								.toLongIPV6Number(highIpAddress)) {
							Object[] objArr = { customerId, (int) customerUtility.toLongIPV6Number(lowIpAddress),
									(int) customerUtility.toLongIPV6Number(highIpAddress), lowIpAddress, highIpAddress,
									dateStamp };
							list.add(objArr);
						} else {
							throw new IllegalArgumentException(
									"Invalid : ip_address_data.low_ip_dotted/high_ip_dotted The Low IP Address can not be greater than the High IP Address.");
						}
					} else {
						throw new IllegalArgumentException("Invalid IP Address."
								+ " Please enter values between 0 and 255 for each segment for IPv4."
								+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
								+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");
					}
				} else {

					throw new IllegalArgumentException("Invalid IP Address."
							+ " Please enter values between 0 and 255 for each segment for IPv4."
							+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
							+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");

				}
			} else {
				if(lowIpAddress.equals("") && highIpAddress.equals("")) {
					throw new IllegalArgumentException("Both Low IP Address and High IP Address columns must be entered");
				}
				else {
					throw new IllegalArgumentException("Invalid IP Address."
							+ " Please enter values between 0 and 255 for each segment for IPv4."
							+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
							+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");
				}
				
			}
			String ipAddressQuery = "INSERT INTO ip_address "
					+ "(customer_id,low_ip,high_ip,low_ip_dotted,high_ip_dotted,date_stamp ) VALUES "
					+ "( ? , ? , ? , ? , ? , ? )";

			jdbcTemplate.batchUpdate(ipAddressQuery, list);

			String eventQueueQuery = "INSERT INTO event_queue (event_queue_id,customer_id,transaction_event,status,creation_date)"
					+ " VALUES(:event_queue_id,:customer_id,:transaction_event,:status,:creation_date)";
			Long maxCustEventId = customerUtility.getMaxEventQueueId() + 1;
			parameters.put("event_queue_id", maxCustEventId);
			parameters.put("customer_id", customerId);
			parameters.put("transaction_event", 30);
			parameters.put("status", 0);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));

			namedParameterJdbcTemplate.update(eventQueueQuery, parameters);
			customerUtility.updateEventQueueId(maxCustEventId);
			return "Inserted";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public List<Map<String, Object>> getCustLoginHistory(int customerLoginId) {
		LOGGER.info("Inside getCustomerLoginDetails");

		List<Map<String, Object>> data = null;

		try {
			data = jdbcTemplate
					.queryForList("select * from customer_login_history where customer_login_id = " + customerLoginId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return data;
	}

	@Override
	public List<Map<String, Object>> customerEditData(int customerLoginId) {
		LOGGER.info("Inside customerEditData");
		List<Map<String, Object>> data = new ArrayList<>();

		try {
			data = jdbcTemplate.queryForList(
					"select question,* from customer_login cl left join customer_login_question clq on cl.customer_login_question_id=clq.customer_login_question_id where customer_login_id="
							+ customerLoginId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return data;
	}
	
	
	
	@Override
	public List<DistributionMethodModel> retrieveDistributionMethodsFromDataSource() {
		LOGGER.info("Inside retrieveDistributionMethodsFromDataSource");
		String distributorMethodsQuery="select distribution_method,description from distribution_method;";
		return jdbcTemplate.query(distributorMethodsQuery,new ResultSetExtractor<List<DistributionMethodModel>>()
		{
			@Override
			public List<DistributionMethodModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DistributionMethodModel> distributorMethodsList=new ArrayList<DistributionMethodModel>();
				while(rs.next())
				{
					DistributionMethodModel distributionMethodModel=new DistributionMethodModel();
					distributionMethodModel.setDistribution_method(rs.getString("distribution_method"));
					distributionMethodModel.setDescription(rs.getString("description"));
					
					distributorMethodsList.add(distributionMethodModel);
			  }
			  return distributorMethodsList;
			}
		});
	}

	
	
	@Override
	public List<DistributionAttributeModel> retrieveDistributionAttributesFromDataSource() {
		LOGGER.info("Inside retrieveDistributionAttributesFromDataSource");
		String distributorAttributesQuery="select distribution_attribute,description from distribution_attribute;";
		return jdbcTemplate.query(distributorAttributesQuery,new ResultSetExtractor<List<DistributionAttributeModel>>()
		{
			@Override
			public List<DistributionAttributeModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DistributionAttributeModel> distributorAttributesList=new ArrayList<DistributionAttributeModel>();
				while(rs.next())
				{
					DistributionAttributeModel distributionAttributeModel=new DistributionAttributeModel();
					distributionAttributeModel.setDistribution_attribute(rs.getString("distribution_attribute"));
					distributionAttributeModel.setDescription(rs.getString("description"));
					
					distributorAttributesList.add(distributionAttributeModel);
			  }
			  return distributorAttributesList;
			}
		});
	}
	
	
	
	@Override
	public List<DistributionValueModel> retrieveDistributionValuesFromDataSource() {
		LOGGER.info("Inside retrieveDistributionValuesFromDataSource");
		String distributorValuesQuery="SELECT dist_attribute_value,region,state,city,begin_zip,end_zip FROM view_distribution_value;";
		return jdbcTemplate.query(distributorValuesQuery,new ResultSetExtractor<List<DistributionValueModel>>()
		{
			@Override
			public List<DistributionValueModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DistributionValueModel> distributorValuesList=new ArrayList<DistributionValueModel>();
				while(rs.next())
				{
					DistributionValueModel distributionValueModel=new DistributionValueModel();
					distributionValueModel.setValue(rs.getString("dist_attribute_value"));
					distributionValueModel.setRegion(rs.getString("region"));
					distributionValueModel.setCountry_or_state(rs.getString("state"));
					distributionValueModel.setCity(rs.getString("city"));
					distributionValueModel.setLow_range(rs.getString("begin_zip"));
					distributionValueModel.setHigh_range(rs.getString("end_zip"));
					
					distributorValuesList.add(distributionValueModel);
			  }
			  return distributorValuesList;
			}
		});
	}

}
