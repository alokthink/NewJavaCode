package com.mps.think.setup.tablesetup.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.model.DropdownModel;
import com.mps.think.setup.tablesetup.dao.TableSetupDao;
import com.mps.think.setup.tablesetup.model.AuditModel;
import com.mps.think.setup.tablesetup.model.DealModel;
import com.mps.think.setup.tablesetup.model.DefaultSettings;
import com.mps.think.setup.tablesetup.model.DemographicModel;
import com.mps.think.setup.tablesetup.model.InternationalModel;
import com.mps.think.setup.tablesetup.model.LabelModel;
import com.mps.think.setup.tablesetup.model.PaymentsModel;
import com.mps.think.setup.tablesetup.model.ServiceModel;
import com.mps.think.setup.tablesetup.model.ShippingDeliveryandDistributionModel;
import com.mps.think.setup.tablesetup.model.TableSetupModel;
import com.mps.think.setup.tablesetup.model.TableSetupOrderClassModel;
import com.mps.think.setup.tablesetup.model.TableSetupOrdersModel;
import com.mps.think.setup.tablesetup.model.TaxesModel;
import com.mps.think.setup.util.PropertyUtils;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.EmailAuthorizationUtility;
import com.mps.think.util.PropertyUtilityClass;

@Repository
public class TableSetupDaoImpl implements TableSetupDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TableSetupDaoImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int saveAddressStatus(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into address_status(address_status,address_undeliverable,description)");
		saveQuery.append("values (:address_status,:address_undeliverable,:description)");
		try {
			addParams.put("address_status", tableSetupModel.getAddressStatus());
			addParams.put("address_undeliverable", tableSetupModel.getAdressUndeliverable());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateAddressState(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update address_status set address_undeliverable=:address_undeliverable,description=:description where address_status='"
						+ tableSetupModel.getAddressStatus() + "'");
		try {
			LOGGER.info("addressStatus:{}", tableSetupModel.getAddressStatus());
			if (tableSetupModel.getAddressStatus() != null) {
				addParams.put("address_status", tableSetupModel.getAddressStatus());
			}
			if (tableSetupModel.getAdressUndeliverable() != null) {
				addParams.put("address_undeliverable", tableSetupModel.getAdressUndeliverable());

			}
			if (tableSetupModel.getDescription() != null) {
				addParams.put("description", tableSetupModel.getDescription());

			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteAddressState(String addressStatus) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete address_status from address_status A ");
		deleteQuery.append(" left join customer on A.address_status=customer.credit_status ");
		deleteQuery.append(" left join customer_address on A.address_status=customer_address.address_status ");
		deleteQuery.append(" left join config on A.address_status=config.address_status ");
		deleteQuery.append(" where A.address_status='" + addressStatus + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveAddressType(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into address_type(address_type,description) values(:address_type,:description)");
		try {
			addParams.put("address_type", tableSetupModel.getAddressType());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateAddressType(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update address_type set description=:description where address_type='"
						+ tableSetupModel.getAddressType() + "'");
		try {
			addParams.put("address_type", tableSetupModel.getAddressType());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public int saveAttachmentCatagorySave(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into attachment_category(attachment_category,description) values(:attachment_category,:description)");
		try {
			addParams.put("attachment_category", tableSetupModel.getAttachmentCatagory());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateAttachCategory(TableSetupModel tableSetupModel) {

		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update attachment_category set description=:description where attachment_category='"
						+ tableSetupModel.getAttachmentCatagory() + "'");
		try {
			addParams.put("attachment_category", tableSetupModel.getAttachmentCatagory());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteAttachCategory(String attachmentCatagory) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete attachment_category from attachment_category C ");
		deleteQuery.append(" left join attachment on C.attachment_category=attachment.attachment_category ");
		deleteQuery.append(" where C.attachment_category= '" + attachmentCatagory + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveAuxField(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into aux_field(column_name,table_name,column_title,column_datatype,default_value)");
		saveQuery.append("values (:column_name,:table_name,:column_title,:column_datatype,:default_value)");
		try {
			addParams.put("column_name", tableSetupModel.getColumnName());
			addParams.put("table_name", tableSetupModel.getTableName());
			addParams.put("column_title", tableSetupModel.getColumnTitle());
			addParams.put("column_datatype", tableSetupModel.getColumnDataType());

			if (("null".equals(tableSetupModel.getDafaultValue())) | ("".equals(tableSetupModel.getDafaultValue()))) {
				addParams.put("default_value", null);
			} else {
				addParams.put("default_value", tableSetupModel.getDafaultValue());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateAuxField(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update aux_field set column_title=:column_title,column_datatype=:column_datatype,default_value=:default_value where table_name='"
						+ tableSetupModel.getTableName() + "' and column_name='" + tableSetupModel.getColumnName()
						+ "'");
		try {
			addParams.put("table_name", tableSetupModel.getTableName());
			addParams.put("column_name", tableSetupModel.getColumnName());
			addParams.put("column_title", tableSetupModel.getColumnTitle());
			addParams.put("column_datatype", tableSetupModel.getColumnDataType());
			addParams.put("default_value", tableSetupModel.getDafaultValue());
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteAuxField(String tableName) {
		int status = 0;
		String deleteQuery = "delete from aux_field where table_name=?";
		try {
			status = jdbcTemplate.update(deleteQuery, String.valueOf(tableName));
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveCreditStatus(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder("insert into credit_status(credit_status,bad_credit,description)");
		saveQuery.append("values (:credit_status,:bad_credit,:description)");
		try {
			addParams.put("credit_status", tableSetupModel.getCreditStatus());
			addParams.put("bad_credit", tableSetupModel.getBadCredit());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateCreditStatus(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update credit_status set bad_credit=:bad_credit,description=:description where credit_status='"
						+ tableSetupModel.getCreditStatus() + "'");
		try {
			LOGGER.info("addressStatus:{}", tableSetupModel.getCreditStatus());
			if (tableSetupModel.getCreditStatus() != null) {
				addParams.put("credit_status", tableSetupModel.getCreditStatus());
			}
			if (tableSetupModel.getBadCredit() != null) {
				addParams.put("bad_credit", tableSetupModel.getBadCredit());

			}
			if (tableSetupModel.getDescription() != null) {
				addParams.put("description", tableSetupModel.getDescription());

			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveCustomerCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into customer_category(customer_category,active,description)");
		saveQuery.append("values (:customer_category,:active,:description)");
		try {
			addParams.put("customer_category", tableSetupModel.getCustomerCategory());
			addParams.put("active", tableSetupModel.getActive());
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateCustomerCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update customer_category set active=:active,description=:description where customer_category='"
						+ tableSetupModel.getCustomerCategory() + "'");
		try {

			addParams.put("customer_category", tableSetupModel.getCustomerCategory());

			if (String.valueOf(tableSetupModel.getActive()) != null) {
				addParams.put("active", tableSetupModel.getActive());

			}
			if (String.valueOf(tableSetupModel.getDescription()) != null) {
				addParams.put("description", tableSetupModel.getDescription());

			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveCustomerRentList(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into list_rental_category(list_rental_category,can_rent_name,can_rent_email_address,description)");
		saveQuery.append("values (:list_rental_category,:can_rent_name,:can_rent_email_address,:description)");
		try {
			addParams.put("list_rental_category", tableSetupModel.getListRentalCategory());
			LOGGER.info("list_rental_category:{}", tableSetupModel.getListRentalCategory());
			if (String.valueOf(tableSetupModel.getCanRentName()) != null) {
				addParams.put("can_rent_name", tableSetupModel.getCanRentName());

			}
			if (String.valueOf(tableSetupModel.getCanRentEmailAddr()) != null) {
				addParams.put("can_rent_email_address", tableSetupModel.getCanRentEmailAddr());

			}
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateCustomerRentList(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update list_rental_category set can_rent_name=:can_rent_name,can_rent_email_address=:can_rent_email_address,description=:description where list_rental_category='"
						+ tableSetupModel.getListRentalCategory() + "'");
		try {
			addParams.put("list_rental_category", tableSetupModel.getListRentalCategory());
			LOGGER.info("list_rental_category:{}", tableSetupModel.getListRentalCategory());
			if (String.valueOf(tableSetupModel.getCanRentName()) != null) {
				addParams.put("can_rent_name", tableSetupModel.getCanRentName());

			}
			if (String.valueOf(tableSetupModel.getCanRentEmailAddr()) != null) {
				addParams.put("can_rent_email_address", tableSetupModel.getCanRentEmailAddr());

			}
			if (("null".equals(tableSetupModel.getDescription())) | ("".equals(tableSetupModel.getDescription()))) {
				addParams.put("description", null);
			} else {
				addParams.put("description", tableSetupModel.getDescription());
			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveCustomerLoginQuestion(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		String maxId = null;
		StringBuilder saveQuery = new StringBuilder(
				"insert into customer_login_question(customer_login_question_id,question,inactive)");
		saveQuery.append("values (:customer_login_question_id,:question,:inactive)");

		try {
			maxId = jdbcTemplate.queryForObject("select max(customer_login_question_id) from customer_login_question ",
					String.class);
			if (maxId == null) {
				addParams.put("customer_login_question_id", null);
			} else {
				addParams.put("customer_login_question_id", Integer.parseInt(maxId) + 1);
			}
			addParams.put("question", tableSetupModel.getQuestion());
			LOGGER.info("list_rental_category:{}", tableSetupModel.getQuestion());
			if (String.valueOf(tableSetupModel.getInactive()) != null) {
				addParams.put("inactive", tableSetupModel.getInactive());

			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public int updateCustomerLoginQuetion(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update customer_login_question set question=:question,inactive=:inactive where customer_login_question_id="
						+ tableSetupModel.getCustomerLoginQuestionId());
		try {
			addParams.put("customer_login_question_id", tableSetupModel.getCustomerLoginQuestionId());
			addParams.put("question", tableSetupModel.getQuestion());
			LOGGER.info("list_rental_category:{}", tableSetupModel.getQuestion());
			if (String.valueOf(tableSetupModel.getInactive()) != null) {
				addParams.put("inactive", tableSetupModel.getInactive());

			}
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteCustomerLoginQuestion(int customerLoginQuestionId) {
		/*
		 * int status=0; StringBuilder deleteQuery=new
		 * StringBuilder("delete customer_login_question_id from customer_login_question "
		 * ); deleteQuery.
		 * append(" left join customer_login on customer_login_question.customer_login_question_id=customer_login.customer_login_question_id "
		 * ); deleteQuery.append(" where customer_login_question_id= ");
		 * deleteQuery.append(customerLoginQuestionId); try {
		 * status=jdbcTemplate.update(deleteQuery.toString());
		 * 
		 * }catch(Exception e) { LOGGER.error(ERROR + e); }
		 */
		int status = 0;
		String deleteQuery = "delete from customer_login_question where customer_login_question_id=?";
		try {
			status = jdbcTemplate.update(deleteQuery, Integer.valueOf(customerLoginQuestionId));
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateCustomerLookup(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update search_field_group set example_text=:example_text where search='" + tableSetupModel.getSearch()
						+ " ' ");
		try {
			addParams.put("search", tableSetupModel.getSearch());
			addParams.put("disp_context", tableSetupModel.getDispContext());
			if (tableSetupModel.getExampleText() != null) {
				addParams.put("example_text", tableSetupModel.getExampleText());
			}

			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public List<Map<String, Object>> getDefalutDetails(String search) {
		List<Map<String, Object>> dafaultDetails = new ArrayList<>();
		try {
			 if(search!=null) {
			dafaultDetails = jdbcTemplate.queryForList(
					"select search,description,target_column_name  from search where search='" + search + " ' ");
			 }else {
				 dafaultDetails = jdbcTemplate.queryForList(
							"select search,description,target_column_name  from search"); 
			 }
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
		}
		return dafaultDetails;
	}

	@Override
	public List<Map<String, Object>> getSerachFieldGroup(String search) {
		List<Map<String, Object>> searchFieldGroup = new ArrayList<>();
		try {
			 
			 if(search!=null) {
			searchFieldGroup = jdbcTemplate.queryForList(
					"select search_field_group_seq,disp_context,example_text from search_field_group where search='"
							+ search + " ' ");
			 
			
			 }else {
				 searchFieldGroup = jdbcTemplate.queryForList(
							"select search_field_group_seq,disp_context,example_text from search_field_group");
				 
			 }
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
		}
		return searchFieldGroup;
	}

	@Override
	public List<Map<String, Object>> getSearchResultDisplay(String search) {
		List<Map<String, Object>> searchResultDisplay = new ArrayList<>();
		try {
			 if(search!=null) {
			searchResultDisplay = jdbcTemplate.queryForList(
					"select search_result_display_seq,disp_context,search from search_result_display where search='"
							+ search + " ' ");
			 }else {
				 searchResultDisplay = jdbcTemplate.queryForList(
							"select search_result_display_seq,disp_context,search from search_result_display");
			 }
		} catch (Exception e) {
			LOGGER.info(ERROR + e);

		}
		return searchResultDisplay;
	}

	@Override
	public List<DropdownModel> getDispContext() {
		List<Map<String, Object>> dispContext = new ArrayList<>();
		List<DropdownModel> dispDataList = new ArrayList<>();
		try {
			dispContext = jdbcTemplate.queryForList("select disp_context,description,table_name from disp_context ");
			for (Map<String, Object> dp : dispContext) {
				DropdownModel model = new DropdownModel();
				model.setKey(dp.get("disp_context").toString());
				model.setDisplay(dp.get("description") != null ? (String) dp.get("description") : "");
				model.setDescription(dp.get("table_name").toString());
				dispDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return dispDataList;
	}

	@Override
	public int saveCustomerMatchcode(TableSetupModel tableSetupModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		String maxId = null;
		String maxId1 = null;
		StringBuilder saveQuery = new StringBuilder(
				"insert into customer_match_code(customer_match_code_id,description,active)");
		saveQuery.append("values (:customer_match_code_id,:description,:active)");

		try {
			maxId = jdbcTemplate.queryForObject("select max(id) from mru_customer_match_code_id ", String.class);
			if (maxId == null) {
				addParams.put("customer_match_code_id", null);
			} else {
				addParams.put("customer_match_code_id", Integer.parseInt(maxId) + 1);
			}
			LOGGER.info("customer_match_code_id:{}", maxId);
			addParams.put("description", tableSetupModel.getDescription());
			if (String.valueOf(tableSetupModel.getActive()) != null) {
				addParams.put("active", tableSetupModel.getActive());

			}
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
			StringBuilder saveQuery1 = new StringBuilder(
					"insert into cust_match_code_detail(customer_match_code_id,cust_match_code_detail_seq,use_characters,word,use_next_segment,column_name,after_char)");
			saveQuery1.append(
					"values (:customer_match_code_id,:cust_match_code_detail_seq,:use_characters,:word,:use_next_segment,:column_name,:after_char)");
			maxId1 = jdbcTemplate.queryForObject("select max(cust_match_code_detail_seq) from cust_match_code_detail ",
					String.class);
			if (maxId1 == null) {
				addParams.put("cust_match_code_detail_seq", null);
			} else {
				addParams.put("cust_match_code_detail_seq", Integer.parseInt(maxId1) + 1);
			}
			addParams.put("customer_match_code_id", tableSetupModel.getCustomerMatchCodeId());
			addParams.put("use_characters", tableSetupModel.getUseCharacters());
			addParams.put("word", tableSetupModel.getWord());
			addParams.put("use_next_segment", tableSetupModel.getUseNextSegment());
			addParams.put("column_name", tableSetupModel.getColumnName());
			addParams.put("after_char", tableSetupModel.getAfterChars());
			status = namedParameterJdbcTemplate.update(saveQuery1.toString(), addParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateCustomerMatchCode(TableSetupModel tableSetupModel) {
		int status = 1;
		Map<String, Object> updateMatchCodes = new LinkedHashMap<>();
		try {
			String updateQuery = "update customer_match_code set description=:description,active=:active where customer_match_code_id="
					+ tableSetupModel.getCustomerMatchCodeId();
			updateMatchCodes.put("description", tableSetupModel.getDescription());
			updateMatchCodes.put("active", tableSetupModel.getActive());
			namedParameterJdbcTemplate.update(updateQuery, updateMatchCodes);

			Map<String, Object> updateMatchCodeDetails = new LinkedHashMap<>();
			String updateMatchCodeDetailsQuery = "update cust_match_code_detail set customer_match_code_id=:customer_match_code_id, use_characters=:use_characters,word=:word,use_next_segment=:use_next_segment,column_name=:column_name,after_char=:after_char where cust_match_code_detail_seq="
					+ tableSetupModel.getCustMatchCodeDetailSeq();
			updateMatchCodeDetails.put("cust_match_code_detail_seq", tableSetupModel.getCustMatchCodeDetailSeq());
			updateMatchCodeDetails.put("customer_match_code_id", tableSetupModel.getCustomerMatchCodeId());
			updateMatchCodeDetails.put("use_characters", tableSetupModel.getUseCharacters());
			updateMatchCodeDetails.put("word", tableSetupModel.getWord());
			updateMatchCodeDetails.put("use_next_segment", tableSetupModel.getUseNextSegment());
			updateMatchCodeDetails.put("column_name", tableSetupModel.getColumnName());
			updateMatchCodeDetails.put("after_char", tableSetupModel.getAfterChars());
			namedParameterJdbcTemplate.update(updateMatchCodeDetailsQuery, updateMatchCodeDetails);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteCustomerMatchCode(int custMatchCodeDetailSeq, int customerMatchCodeId) {
		int status = 1;
		String deleteMatchCodeQuery = "delete from customer_match_code where customer_match_code_id=?";
		String deleteMatchCodeDetailsQuery = "delete from cust_match_code_detail where cust_match_code_detail_seq=?";
		try {
			jdbcTemplate.update(deleteMatchCodeQuery, Integer.valueOf(customerMatchCodeId));
			jdbcTemplate.update(deleteMatchCodeDetailsQuery, Integer.valueOf(custMatchCodeDetailSeq));

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getMatchCodeValues(int customerMatchCodeId) {
		List<Map<String, Object>> MatchCodeValue = new ArrayList<>();
		try {
			 if(customerMatchCodeId!=0) {
			MatchCodeValue = jdbcTemplate.queryForList(
					"select description,active,customer_match_code_id from customer_match_code where customer_match_code_id="
							+ customerMatchCodeId);
			 }else {
				 MatchCodeValue = jdbcTemplate.queryForList(
							"select description,active,customer_match_code_id from customer_match_code");
			 }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return MatchCodeValue;
	}

	@Override
	public List<Map<String, Object>> getMatchCodeDetails(int custMatchCodeDetailSeq) {
		List<Map<String, Object>> MatchCodeDetails = new ArrayList<>();
		try {
			 if(custMatchCodeDetailSeq!=0) {
			MatchCodeDetails = jdbcTemplate.queryForList(
					"select customer_match_code_id,cust_match_code_detail_seq,word,use_next_segment,column_name,after_char from cust_match_code_detail where cust_match_code_detail_seq="
							+ custMatchCodeDetailSeq);
			 }else
			 {
				 MatchCodeDetails = jdbcTemplate.queryForList(
							"select customer_match_code_id,cust_match_code_detail_seq,word,use_next_segment,column_name,after_char from cust_match_code_detail");
			 }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return MatchCodeDetails;
	}

	@Override
	public List<DropdownModel> getColumnName() {
		List<DropdownModel> columnName = new ArrayList<>();
		for (int i = 0; i <= 22; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("column_name" + i));
			columnName.add(model);

		}
		return columnName;
	}

	@Override
	public List<DropdownModel> getUseNextSegment() {
		List<DropdownModel> useNextSegment = new ArrayList<>();
		for (int i = 0; i <= 1; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("use_next_segment" + i));
			useNextSegment.add(model);
		}
		return useNextSegment;
	}

	@Override
	public int ProspectCategory(TableSetupModel tableSetupModel) {
		int status = 0;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder saveQuery = new StringBuilder(
				"insert into prospect_category(prospect_category,description) values(:prospect_category,:description)");
		try {
			addParams.put("prospect_category", tableSetupModel.getProspectCategory());
			addParams.put("description", tableSetupModel.getDescription());
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public int updateCustomerProspectCategory(TableSetupModel tableSetupModel) {
		int status = 0;
		Map<String, Object> updateParams = new LinkedHashMap<>();
		StringBuilder updateQuery = new StringBuilder(
				"update prospect_category set description=:description where prospect_category='"
						+ tableSetupModel.getProspectCategory() + "'");
		try {
			updateParams.put("prospect_category", tableSetupModel.getProspectCategory());
			updateParams.put("description", tableSetupModel.getDescription());
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public int saveSalesRepresatative(TableSetupModel tableSetupModel) {
		int status = 0;
		String maxId = null;
		Map<String, Object> addParams = new LinkedHashMap<>();
		StringBuilder saveQuery = new StringBuilder(
				"insert into sales_representative(sales_representative_id,sales_representative,inactive) values(:sales_representative_id,:sales_representative,:inactive)");
		try {
			maxId = jdbcTemplate.queryForObject("select max(id) from mru_sales_representative_id", String.class);
			if (maxId == null) {
				addParams.put("sales_representative_id", null);
			} else {
				addParams.put("sales_representative_id", Integer.parseInt(maxId) + 1);
			}
			addParams.put("sales_representative", tableSetupModel.getSalesRepresentative());
			addParams.put("inactive", tableSetupModel.getInactive());
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updatecustomerSalesRepresentative(TableSetupModel tableSetupModel) {
		int status = 0;
		Map<String, Object> updateParams = new LinkedHashMap<>();
		try {
			StringBuilder updateQuery = new StringBuilder(
					"update sales_representative set sales_representative=:sales_representative,inactive=:inactive where sales_representative_id="
							+ tableSetupModel.getSalesRepresentativeId());
			updateParams.put("sales_representative", tableSetupModel.getSalesRepresentative());
			updateParams.put("inactive", tableSetupModel.getInactive());
			updateParams.put("sales_representative_id", tableSetupModel.getSalesRepresentativeId());
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteCustomerSaleRep(int salesRepresentativeId) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete sales_representative from sales_representative L ");
		deleteQuery.append(" left join customer on L.sales_representative_id=customer.sales_representative_id ");
		deleteQuery.append("where L.sales_representative_id=");
		deleteQuery.append(salesRepresentativeId);

		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteCustomerProspectCategory(String prospectCategory) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete prospect_category from prospect_category P ");
		deleteQuery.append(" left join config on P.prospect_category=config.net_prospect_category ");
		deleteQuery.append(" left join customer_prospect on P.prospect_category=customer_prospect.prospect_category ");
		deleteQuery.append(
				" left join process_list_prospect_cat on P.prospect_category=process_list_prospect_cat.prospect_category ");
		deleteQuery.append(" where P.prospect_category='" + prospectCategory + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveprofitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel) {
		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into profit_center(profit_center,description)" + "values(:profit_center,:description)");

		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {

			LOGGER.info("save for tableSetupOrderClassModel", tableSetupOrderClassModel);
			addSourceParams.put("profit_center", tableSetupOrderClassModel.getProfitCenter());
			addSourceParams.put("description", tableSetupOrderClassModel.getDescription());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int updateProfitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel) {

		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder("update profit_center set description=:description"
				+ " where  profit_center= " + tableSetupOrderClassModel.getProfitCenter());

		try {
			LOGGER.info("Inside updateProfitCenterOrderClass");

			addSourceParams.put("profitCenter", tableSetupOrderClassModel.getProfitCenter());
			LOGGER.info("profitCenter", tableSetupOrderClassModel.getProfitCenter());
			addSourceParams.put("description", tableSetupOrderClassModel.getDescription());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int saveSourceCodeFormat(TableSetupOrderClassModel tableSetupOrderClassModel) {
		int status = 1;

		try {
			Map<String, Object> addSourceAttribute = new LinkedHashMap<>();
			String addSourceAttributeQuery = "insert into source_attribute(source_attribute,description,width)"
					+ "values(:source_attribute,:description,:width)";
			LOGGER.info("save for tableSetupOrderClassModel", tableSetupOrderClassModel);

			addSourceAttribute.put("source_attribute", tableSetupOrderClassModel.getSourceAttribute());
			addSourceAttribute.put("description", tableSetupOrderClassModel.getSourceAttributedescription());
			addSourceAttribute.put("width", tableSetupOrderClassModel.getWidth());
			namedParameterJdbcTemplate.update(addSourceAttributeQuery, addSourceAttribute);

			Map<String, Object> addSourceAttributeValue = new LinkedHashMap<>();
			String addSourceAttributeValueQuery = "insert into source_attribute_value(source_attribute,source_attribute_value,description,idx)"
					+ "values(:source_attribute,:source_attribute_value,:description,:idx)";

			addSourceAttributeValue.put("source_attribute", tableSetupOrderClassModel.getSourceAttribute());
			addSourceAttributeValue.put("source_attribute_value", tableSetupOrderClassModel.getSourceAttributeValue());
			addSourceAttributeValue.put("description", tableSetupOrderClassModel.getSourceAttributeValuedescription());
			addSourceAttributeValue.put("idx", tableSetupOrderClassModel.getIndex());
			namedParameterJdbcTemplate.update(addSourceAttributeValueQuery, addSourceAttributeValue);

			Map<String, Object> addSourceFormat = new LinkedHashMap<>();
			String addSourceFormatQuery = "insert into source_format(source_format,code_gen_type,description)"
					+ "values(:source_format,:code_gen_type,:description)";

			addSourceFormat.put("source_format", tableSetupOrderClassModel.getSourceFormat());
			addSourceFormat.put("code_gen_type", tableSetupOrderClassModel.getCodeGenType());
			addSourceFormat.put("description", tableSetupOrderClassModel.getSourceFormatdescription());

			namedParameterJdbcTemplate.update(addSourceFormatQuery, addSourceFormat);

			Map<String, Object> addSourceFormatSegment = new LinkedHashMap<>();
			String addSourceFormatSegmentQuery = "insert into source_format_segment(source_format,source_format_segment_seq,fixed_value,gen_func_parm,generation_function,generation_method,source_attribute)"
					+ "values(:source_format,:source_format_segment_seq,:fixed_value,:gen_func_parm,:generation_function,:generation_method,:source_attribute)";

			addSourceFormatSegment.put("source_format", tableSetupOrderClassModel.getSourceFormat());
			LOGGER.info("sourceFormat", tableSetupOrderClassModel.getSourceFormat());
			addSourceFormatSegment.put("source_format_segment_seq",
					tableSetupOrderClassModel.getSourceFormatSegmentSeq());
			LOGGER.info("SourceFormatSegmentSeq", tableSetupOrderClassModel.getSourceFormatSegmentSeq());
			addSourceFormatSegment.put("fixed_value", tableSetupOrderClassModel.getFixedValue());
			addSourceFormatSegment.put("gen_func_parm", tableSetupOrderClassModel.getGenFunParm());
			addSourceFormatSegment.put("generation_function", tableSetupOrderClassModel.getGenerationFunction());
			addSourceFormatSegment.put("generation_method", tableSetupOrderClassModel.getGenerationFunction());
			addSourceFormatSegment.put("source_attribute", tableSetupOrderClassModel.getSourceAttribute());
			namedParameterJdbcTemplate.update(addSourceFormatSegmentQuery, addSourceFormatSegment);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int updateSourceFormat(TableSetupOrderClassModel tableSetupOrderClassModel) {
		int status = 1;

		try {
			Map<String, Object> updateTableSetUp = new LinkedHashMap<>();
			String sourceAttributeValueQuery = "update source_attribute_value set description=:description,idx=:idx where"
					+ " source_attribute_value= '" + tableSetupOrderClassModel.getSourceAttributeValue()
					+ " ' and source_attribute='" + tableSetupOrderClassModel.getSourceAttribute() + "'";

			updateTableSetUp.put("source_attribute", tableSetupOrderClassModel.getSourceAttribute());
			LOGGER.info("sourceAttribute:{}", tableSetupOrderClassModel.getSourceAttribute());
			updateTableSetUp.put("source_attribute_value", tableSetupOrderClassModel.getSourceAttributeValue());
			LOGGER.info("sourceAttributeValue:{} ", tableSetupOrderClassModel.getSourceAttributeValue());

			updateTableSetUp.put("description", tableSetupOrderClassModel.getSourceAttributeValuedescription());
			LOGGER.info("sourceAttributeValuedescription:{}",
					tableSetupOrderClassModel.getSourceAttributeValuedescription());

			updateTableSetUp.put("idx", tableSetupOrderClassModel.getIndex());
			namedParameterJdbcTemplate.update(sourceAttributeValueQuery, updateTableSetUp);

			// Map<String, Object> updateSourceAttribute = new LinkedHashMap<>();
			String sourceAttributeQuery = "update source_attribute set description=:description,width=:width where source_attribute= '"
					+ tableSetupOrderClassModel.getSourceAttribute() + "'";

			updateTableSetUp.put("source_attribute", tableSetupOrderClassModel.getSourceAttribute());
			LOGGER.info("sourceAttribute:{}", tableSetupOrderClassModel.getSourceAttribute());

			updateTableSetUp.put("description", tableSetupOrderClassModel.getSourceAttributedescription());
			LOGGER.info("sourceAttributedescription:{}", tableSetupOrderClassModel.getSourceAttributedescription());
			updateTableSetUp.put("width", tableSetupOrderClassModel.getWidth());
			namedParameterJdbcTemplate.update(sourceAttributeQuery, updateTableSetUp);

			// Map<String, Object> updateSourceFormatSegment = new LinkedHashMap<>();
			String sourceFormatSegmentQuery = "update  source_format_segment set source_attribute=:source_attribute,fixed_value=:fixed_value,gen_func_parm=:gen_func_parm,generation_function=:generation_function,generation_method=:generation_method  where source_format_segment_seq= "
					+ tableSetupOrderClassModel.getSourceFormatSegmentSeq() + " and source_format= '"
					+ tableSetupOrderClassModel.getSourceFormat() + "'";

			updateTableSetUp.put("source_format", tableSetupOrderClassModel.getSourceFormat());
			LOGGER.info("sourceFormat:{}", tableSetupOrderClassModel.getSourceFormat());

			updateTableSetUp.put("source_format_segment_seq", tableSetupOrderClassModel.getSourceFormatSegmentSeq());
			LOGGER.info("sourceFormatSegmentSeq:{}", tableSetupOrderClassModel.getSourceFormatSegmentSeq());

			updateTableSetUp.put("fixed_value", tableSetupOrderClassModel.getFixedValue());
			LOGGER.info(" fixedValue:{}", tableSetupOrderClassModel.getFixedValue());

			updateTableSetUp.put("gen_func_parm", tableSetupOrderClassModel.getGenFunParm());
			LOGGER.info("genFunParm:{}", tableSetupOrderClassModel.getGenFunParm());

			updateTableSetUp.put("generation_function", tableSetupOrderClassModel.getGenerationFunction());
			LOGGER.info("generationFunction:{}", tableSetupOrderClassModel.getGenerationFunction());

			updateTableSetUp.put("generation_method", tableSetupOrderClassModel.getGenerationMethod());
			LOGGER.info("generationMethod:{}", tableSetupOrderClassModel.getGenerationMethod());

			updateTableSetUp.put("source_attribute", tableSetupOrderClassModel.getSourceAttribute());
			LOGGER.info("sourceAttribute:{}", tableSetupOrderClassModel.getSourceAttribute());

			namedParameterJdbcTemplate.update(sourceFormatSegmentQuery, updateTableSetUp);

			// Map<String, Object> updateSourceFormat = new LinkedHashMap<>();
			String sourceFormatQuery = "update source_format set code_gen_type=:code_gen_type,description=:description where source_format= '"
					+ tableSetupOrderClassModel.getSourceFormat() + "'";

			updateTableSetUp.put("source_format", tableSetupOrderClassModel.getSourceFormat());
			LOGGER.info("sourceFormat:{}", tableSetupOrderClassModel.getSourceFormat());
			updateTableSetUp.put("code_gen_type", tableSetupOrderClassModel.getCodeGenType());
			LOGGER.info("codeGenType:{}", tableSetupOrderClassModel.getCodeGenType());

			updateTableSetUp.put("description", tableSetupOrderClassModel.getSourceFormatdescription());
			// updateSourceFormat.put("mru_source_format_segment_seq",tableSetupOrderClassModel.getMruSourceFormatSegmentSeq());
			namedParameterJdbcTemplate.update(sourceFormatQuery, updateTableSetUp);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int saveTopic(TableSetupOrderClassModel tableSetupOrderClassModel) {

		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into topic(topic,description,image_url)" + "values(:topic,:description,:image_url)");

		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {

			LOGGER.info("save for tableSetupOrderClassModel", tableSetupOrderClassModel);
			addSourceParams.put("topic", tableSetupOrderClassModel.getTopic());
			addSourceParams.put("description", tableSetupOrderClassModel.getDescription());
			addSourceParams.put("image_url", tableSetupOrderClassModel.getImageUrl());
			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int updateTopic(TableSetupOrderClassModel tableSetupOrderClassModel) {
		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder("update topic set description=:description,image_url=:image_url "
				+ " where  topic= " + tableSetupOrderClassModel.getTopic());
		try {
			LOGGER.info("Inside updatetopic");

			addSourceParams.put("topic", tableSetupOrderClassModel.getTopic());
			LOGGER.info("topic:{}", tableSetupOrderClassModel.getTopic());
			addSourceParams.put("image_url", tableSetupOrderClassModel.getImageUrl());
			LOGGER.info("imageUrl:{}", tableSetupOrderClassModel.getImageUrl());
			addSourceParams.put("description", tableSetupOrderClassModel.getDescription());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel) {
		LOGGER.info("volume:{}", tableSetupOrderClassModel.getVolume());
		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			String query = "insert into volume_group(volume,volume_group_id)" + "values(:volume,:volume_group_id)";
			int MaxVolumeGroupId = jdbcTemplate.queryForObject("select max(volume_group_id) from volume_group",
					Integer.class);

			addSourceParams.put("volume", tableSetupOrderClassModel.getVolume());

			// addSourceParams.put("volume_group_id",tableSetupOrderClassModel.getVolumeGroupId());
			addSourceParams.put("volume_group_id", MaxVolumeGroupId + 1);
			// LOGGER.info("volumeGroupId:{}", tableSetupOrderClassModel.getVolumeGroupId()
			// );

			status = namedParameterJdbcTemplate.update(query, addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel) {

		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder("update volume_group  set volume=:volume " + " where volume_group_id= "
				+ tableSetupOrderClassModel.getVolumeGroupId());
		try {
			LOGGER.info("Inside updatevolume group");

			addSourceParams.put("volume", tableSetupOrderClassModel.getVolume());
			LOGGER.info("volume:{}", tableSetupOrderClassModel.getVolume());

			addSourceParams.put("volume_group_id", tableSetupOrderClassModel.getVolumeGroupId());
			LOGGER.info("volumeGroupId:{}", tableSetupOrderClassModel.getVolumeGroupId());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteAddressType(String addressType) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete address_type from address_type T ");
		deleteQuery.append(" left join customer_address on T.address_type=customer_address.address_type ");
		deleteQuery.append(" left join config on T.address_type=config.address_type ");
		deleteQuery.append(" where T.address_type='" + addressType + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteCrditStatus(String creditStatus) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete credit_status from credit_status C ");
		deleteQuery.append(" left join customer on C.credit_status=customer.credit_status ");
		deleteQuery.append(" left join config on C.credit_status=config.credit_status ");
		deleteQuery.append(" where C.credit_status= '" + creditStatus + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteCategory(String customerCategory) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete customer_category from customer_category C ");
		deleteQuery.append(" left join customer on C.customer_category=customer.customer_category ");
		deleteQuery.append(" left join discount_card on C.customer_category=discount_card.customer_category ");
		deleteQuery.append(" where C.customer_category= '" + customerCategory + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteRentList(String listRentalCategory) {
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder("delete list_rental_category from list_rental_category L ");
		deleteQuery.append(" left join customer on L.list_rental_category=customer.list_rental_category ");
		deleteQuery.append(" left join config on L.list_rental_category=config.list_rental_category ");
		deleteQuery.append(
				" left join process_list_rental_cat on L.list_rental_category=process_list_rental_cat.list_rental_category ");
		deleteQuery.append(" where L.list_rental_category= '" + listRentalCategory + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteTopic(String topic, int ocId) {
		int status = 0;
		try {

			String deleteOcTopicQuery = "delete from oc_topic where oc_id=" + ocId + " and topic='" + topic + " ' ";

			status = jdbcTemplate.update(deleteOcTopicQuery);

			String deleteTopicQuery = "delete from topic where topic= '" + topic + " ' ";
			status = jdbcTemplate.update(deleteTopicQuery);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;

	}

	@Override
	public int deleteVolumeGroup(int volumeGroupId) {
		int status = 0;
		try {

			String deleteGernalVolumeGroupQuery = "delete from journal_volume_group where volume_group_id='"
					+ volumeGroupId + "'";
			status = jdbcTemplate.update(deleteGernalVolumeGroupQuery);
			String deleteIssueQuery = "delete from issue where volume_group_id='" + volumeGroupId + "'";
			status = jdbcTemplate.update(deleteIssueQuery);
			String deleteProcessQuery = "delete from process where volume_group_id='" + volumeGroupId + "'";
			status = jdbcTemplate.update(deleteProcessQuery);
			String deleteStartDateQuery = "delete from start_date where volume_group_id='" + volumeGroupId + "'";
			status = jdbcTemplate.update(deleteStartDateQuery);
			String deleteJobQuery = "delete from job where volume_group_id='" + volumeGroupId + "'";
			status = jdbcTemplate.update(deleteJobQuery);
			String deleteVolumeGroupQuery = "delete from volume_group where volume_group_id='" + volumeGroupId + "'";
			status = jdbcTemplate.update(deleteVolumeGroupQuery);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	@Override
	public int deleteProfitCenter(String profitCenter) {
		int status = 0;
		try {

			String deleteOcQuery = "delete from oc where profit_center= '" + profitCenter + "'";
			status = jdbcTemplate.update(deleteOcQuery);

			String deleteProcessProfitCenterQuery = "delete from process_profit_center where profit_center='"
					+ profitCenter + "'";
			status = jdbcTemplate.update(deleteProcessProfitCenterQuery);

			String deleteProfitCenterCalenderQuery = "delete from profit_center_calendar where profit_center='"
					+ profitCenter + "'";
			status = jdbcTemplate.update(deleteProfitCenterCalenderQuery);

			String deleteProfitCenterQuery = "delete from profit_center where profit_center='" + profitCenter + "'";
			status = jdbcTemplate.update(deleteProfitCenterQuery);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;

	}

	
	@Override
	public int savePayments(PaymentsModel paymetsModel) {
		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into payment_threshold(payment_threshold,description,percent_under,percent_over,percent_refund,max_under_under,max_under_full,max_over_over,max_over_full,on_under_payment,under_payment_notify,on_over_payment,over_payment_notify)");
		query.append("values(:payment_threshold,:description,:percent_under,:percent_over,:percent_refund,:max_under_under,:max_under_full,:max_over_over,:max_over_full,:on_under_payment,:under_payment_notify,:on_over_payment,:over_payment_notify)");

		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {

			addSourceParams.put("payment_threshold",paymetsModel.getPaymentThreshold() );
			addSourceParams.put("description", paymetsModel.getDescription());
			addSourceParams.put("percent_under", paymetsModel.getPercentUnder());
			addSourceParams.put("percent_over", paymetsModel.getPercentOver());
			addSourceParams.put("percent_refund", paymetsModel.getPercentRefund());
			addSourceParams.put("max_under_under", paymetsModel.getMaxUnder());
			addSourceParams.put("max_under_full", paymetsModel.getMaxUnderFull());
			addSourceParams.put("max_over_over", paymetsModel.getMaxOver());
			addSourceParams.put("max_over_full", paymetsModel.getMaxOverFull());
			addSourceParams.put("on_under_payment", paymetsModel.getOnUnder());
			addSourceParams.put("under_payment_notify", paymetsModel.getUnderPaymentNotify());
			addSourceParams.put("on_over_payment", paymetsModel.getOnOverPayment());
			addSourceParams.put("over_payment_notify", paymetsModel.getOverPaymentNotify());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updatePayments(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder("update payment_threshold  set description=:description,percent_under=:percent_under,percent_over=:percent_over,percent_refund=:percent_refund,max_under_under=:max_under_under,max_under_full=:max_under_full,max_over_over=:max_over_over,"
			+"max_over_full=:max_over_full,on_under_payment=:on_under_payment,under_payment_notify=:under_payment_notify,on_over_payment=:on_over_payment,over_payment_notify=:over_payment_notify"	+ " where payment_threshold= '" + paymetsModel.getPaymentThreshold()+"'");
		try {
			addSourceParams.put("description", paymetsModel.getDescription());
			addSourceParams.put("percent_under", paymetsModel.getPercentUnder());
			addSourceParams.put("percent_over", paymetsModel.getPercentOver());
			addSourceParams.put("percent_refund", paymetsModel.getPercentRefund());
			addSourceParams.put("max_under_under", paymetsModel.getMaxUnder());
			addSourceParams.put("max_under_full", paymetsModel.getMaxUnderFull());
			addSourceParams.put("max_over_over", paymetsModel.getMaxOver());
			addSourceParams.put("max_over_full", paymetsModel.getMaxOverFull());
			addSourceParams.put("on_under_payment", paymetsModel.getOnUnder());
			addSourceParams.put("under_payment_notify", paymetsModel.getUnderPaymentNotify());
			addSourceParams.put("on_over_payment", paymetsModel.getOnOverPayment());
			addSourceParams.put("over_payment_notify", paymetsModel.getOverPaymentNotify());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deletePaymentThreshold(String paymentThreshold) {
		int status=0;
		StringBuilder deleteQuery=new StringBuilder("delete payment_threshold from payment_threshold T ");
		deleteQuery.append(" left join agency on T.payment_threshold=agency.payment_threshold ");
		deleteQuery.append(" left join config on T.payment_threshold=config.payment_threshold ");
		deleteQuery.append(" left join oc on T.payment_threshold=oc.payment_threshold ");
		deleteQuery.append(" where T.payment_threshold= '"+paymentThreshold+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int savePaymentType(PaymentsModel paymetsModel) {
		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into payment_type(payment_type,description,payment_form,realize_cash_when,use_as_default,card_verification_usage)" );
		query.append("values(:payment_type,:description,:payment_form,:realize_cash_when,:use_as_default,:card_verification_usage)");

		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			addSourceParams.put("payment_type", paymetsModel.getPaymentType());
			addSourceParams.put("description", paymetsModel.getDescription());
			addSourceParams.put("payment_form", paymetsModel.getPaymentForm());
			addSourceParams.put("realize_cash_when", paymetsModel.getRealizeCashWhen());
			addSourceParams.put("card_verification_usage", paymetsModel.getCardVerificationUsage());
			addSourceParams.put("use_as_default", paymetsModel.getUseAsDefault());
			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updatePaymentType(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder("update payment_type set description=:description,payment_form=:payment_form,realize_cash_when=:realize_cash_when");
		query.append(",use_as_default=:use_as_default,card_verification_usage=:card_verification_usage where payment_type='"+paymetsModel.getPaymentType()+"'");
		try {
			addSourceParams.put("payment_type", paymetsModel.getPaymentType());
			addSourceParams.put("description", paymetsModel.getDescription());
			addSourceParams.put("payment_form", paymetsModel.getPaymentForm());
			addSourceParams.put("realize_cash_when", paymetsModel.getRealizeCashWhen());
			addSourceParams.put("card_verification_usage", paymetsModel.getCardVerificationUsage());
			addSourceParams.put("use_as_default", paymetsModel.getUseAsDefault());
			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deletePaymentType(String paymentType) {
			int status=0;
			StringBuilder deleteQuery=new StringBuilder("delete payment_type from payment_type P ");
			deleteQuery.append(" left join bank_account_payment_type on P.payment_type=bank_account_payment_type.payment_type ");
			deleteQuery.append(" left join ics_bank_payment_type on P.payment_type=ics_bank_payment_type.payment_type ");
			deleteQuery.append(" left join process_pay_type_ccard C on P.payment_type=C.payment_type ");
			deleteQuery.append(" left join process_pay_type_ddebit D on P.payment_type=D.payment_type ");
			deleteQuery.append(" left join sub_iss_hist_audit on P.payment_type=sub_iss_hist_audit.payment_type ");
			deleteQuery.append(" left join config  F on P.payment_type=F.payment_type_compound_xaction ");
			deleteQuery.append(" left join payment  M on P.payment_type=M.payment_type ");
			deleteQuery.append(" where P.payment_type= '"+paymentType+"'");
			try {
				status=jdbcTemplate.update(deleteQuery.toString());
			
			}catch(Exception e) {
				LOGGER.error(ERROR + e); 
			}
		return status;
	}

	@Override
	public int saveTransactionReason(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into transaction_reason(transaction_reason,description,reason_type) values(:transaction_reason,:description,:reason_type)");
		try {
			addParams.put("transaction_reason",paymetsModel.getTransactionReason());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("reason_type",paymetsModel.getReasonType());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int updateTransactionReason(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"update transaction_reason set description=:description,reason_type=:reason_type where transaction_reason='"+paymetsModel.getTransactionReason()+"'");
		try {
			addParams.put("transaction_reason",paymetsModel.getTransactionReason());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("reason_type",paymetsModel.getReasonType());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteTransactionReason(String transactionReason) {
		int status=0;
		StringBuilder deleteQuery=new StringBuilder("delete transaction_reason from transaction_reason T ");
		deleteQuery.append(" left join payment on T.transaction_reason=payment.transaction_reason");
		deleteQuery.append(" where T.transaction_reason='"+transactionReason+"'"); 
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveInstallementplanDetails(PaymentsModel paymetsModel) {
		int status=0;
		String maxId=null;
		String maxId1=null;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query1=new StringBuilder("insert into installment_plan(installment_plan_id,report,description,auto_setup,allow_default_usage)"
				+ " values(:installment_plan_id,:report,:description,:auto_setup,:allow_default_usage)");
		try {
			maxId=jdbcTemplate.queryForObject("select max(id) from mru_installment_plan_id",String.class);
			if(maxId==null) {
				addParams.put("installment_plan_id",null);
			}else {
				addParams.put("installment_plan_id",Integer.parseInt(maxId)+1);
			}
			addParams.put("report",paymetsModel.getReport());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("auto_setup",paymetsModel.getAutoSetup());
			addParams.put("allow_default_usage",paymetsModel.getAllowDefaultUsage());
			status = namedParameterJdbcTemplate.update(query1.toString(), addParams);

		StringBuilder query=new StringBuilder("insert into install_plan_detail(installment_plan_id,install_plan_detail_seq,interval,unpaid_issues_new,unpaid_issues_renew,interval_type,payment_required) "
				+ "	values(:installment_plan_id,:install_plan_detail_seq,:interval,:unpaid_issues_new,:unpaid_issues_renew,:interval_type,:payment_required)");
		maxId1=jdbcTemplate.queryForObject("select max(install_plan_detail_seq) from install_plan_detail",String.class);
		if(maxId1==null) {
			addParams.put("install_plan_detail_seq",null);
		}else {
			addParams.put("install_plan_detail_seq",Integer.parseInt(maxId1)+1);
		}
		addParams.put("installment_plan_id",paymetsModel.getInstallmentPlanId());
		addParams.put("interval",paymetsModel.getInterval());
		addParams.put("unpaid_issues_new",paymetsModel.getUnpaidIssuesNew());
		addParams.put("unpaid_issues_renew",paymetsModel.getUnpaidIssuesRenewal());
		addParams.put("interval_type",paymetsModel.getIntervalType());
		addParams.put("payment_required",paymetsModel.getPaymentRequired());
		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveInstallementplan(PaymentsModel paymetsModel) {
		int status=0;
		String maxId=null;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("insert into installment_plan(installment_plan_id,report,description,auto_setup,allow_default_usage,nbr_installments,interval,unpaid_issues_new,unpaid_issues_renew,interval_type)"
				+ " values(:installment_plan_id,:report,:description,:auto_setup,:allow_default_usage,:nbr_installments,:interval,:unpaid_issues_new,:unpaid_issues_renew,:interval_type)");
		try {
			maxId=jdbcTemplate.queryForObject("select max(id) from mru_installment_plan_id",String.class);
			if(maxId==null) {
				addParams.put("installment_plan_id",null);
			}else {
				addParams.put("installment_plan_id",Integer.parseInt(maxId)+1);
			}
			addParams.put("report",paymetsModel.getReport());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("auto_setup",paymetsModel.getAutoSetup());
			addParams.put("allow_default_usage",paymetsModel.getAllowDefaultUsage());
			addParams.put("interval",paymetsModel.getInterval());
			addParams.put("unpaid_issues_new",paymetsModel.getUnpaidIssuesNew());
			addParams.put("unpaid_issues_renew",paymetsModel.getUnpaidIssuesRenewal());
			addParams.put("interval_type",paymetsModel.getIntervalType());
			addParams.put("payment_required",paymetsModel.getPaymentRequired());
			addParams.put("nbr_installments",paymetsModel.getNbrInstallment());

			status = namedParameterJdbcTemplate.update(query.toString(), addParams);

			}catch(Exception e) {
				LOGGER.error(ERROR + e); 
			}
		return status;
	}

	@Override
	public int deleteIntallmentPlan(int installmentPlanId) {
		int status=0;
		String deleteQuery="delete from installment_plan where installment_plan_id=? ";
		try {
			status=jdbcTemplate.update(deleteQuery,Integer.valueOf(installmentPlanId));
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int updateInstallmentPlan(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"update installment_plan set description=:description, interval=:interval,unpaid_issues_new=:unpaid_issues_new,unpaid_issues_renew=:unpaid_issues_renew,interval_type=:interval_type,"
				+ "nbr_installments=:nbr_installments where installment_plan_id="+paymetsModel.getInstallmentPlanId());
		try {
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("interval",paymetsModel.getInterval());
			addParams.put("unpaid_issues_new",paymetsModel.getUnpaidIssuesNew());
			addParams.put("unpaid_issues_renew",paymetsModel.getUnpaidIssuesRenewal());
			addParams.put("interval_type",paymetsModel.getIntervalType());
			addParams.put("auto_setup",paymetsModel.getAutoSetup());
			addParams.put("allow_default_usage",paymetsModel.getAllowDefaultUsage());
			LOGGER.info("allow_default_usage:{}",paymetsModel.getAllowDefaultUsage());
			addParams.put("nbr_installments",paymetsModel.getNbrInstallment());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveSettleRetryDef(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"insert into settle_retry_def(settle_retry_def,description,max_retries,n_days_between_retries,suspend_after_n_settle_retries,cancel_itm_after_last_retry) "
				+ "values(:settle_retry_def,:description,:max_retries,:n_days_between_retries,:suspend_after_n_settle_retries,:cancel_itm_after_last_retry)");
		try {
			addParams.put("settle_retry_def",paymetsModel.getSettleRetryDef());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("max_retries",paymetsModel.getMaxRetries());
			addParams.put("n_days_between_retries",paymetsModel.getNdaysBetweenRetries());
			addParams.put("suspend_after_n_settle_retries",paymetsModel.getSusupendAfternSettleRetries());
			addParams.put("cancel_itm_after_last_retry",paymetsModel.getCancelItemAfterLastRetry());

			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int updateSettleRetryDef(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"update settle_retry_def set description=:description,max_retries=:max_retries,n_days_between_retries=:n_days_between_retries,suspend_after_n_settle_retries=:suspend_after_n_settle_retries,"
				+ "cancel_itm_after_last_retry=:cancel_itm_after_last_retry where settle_retry_def='"+paymetsModel.getSettleRetryDef()+"'");
		try {
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("max_retries",paymetsModel.getMaxRetries());
			addParams.put("n_days_between_retries",paymetsModel.getNdaysBetweenRetries());
			addParams.put("suspend_after_n_settle_retries",paymetsModel.getSusupendAfternSettleRetries());
			addParams.put("cancel_itm_after_last_retry",paymetsModel.getCancelItemAfterLastRetry());

			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteSettleRetrydef(String settleRetryDef) {
		int status=0;
		StringBuilder deleteQuery=new StringBuilder("delete settle_retry_def from settle_retry_def S ");
		deleteQuery.append(" left join order_code on S.settle_retry_def=order_code.settle_retry_def");
		deleteQuery.append(" where S.settle_retry_def='"+settleRetryDef+"'"); 
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveQtyDiscountScheduleDtl(PaymentsModel paymetsModel) {
		int status=1;
		Integer maxId=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder(
				"insert into qty_discount_sched_dtl(qty_discount_schedule,from_qty,to_qty,amount,qty_discount_percent,qty_discount_sched_dtl_seq,from_amt,to_amt) "
				+ "values(:qty_discount_schedule,:from_qty,:to_qty,:amount,:qty_discount_percent,:qty_discount_sched_dtl_seq,:from_amt,:to_amt)");
		try {
			maxId=jdbcTemplate.queryForObject("select max(qty_discount_sched_dtl_seq) from qty_discount_sched_dtl where qty_discount_schedule='"+paymetsModel.getQtyDiscountSchedule()+"'",Integer.class);
			if(maxId==null) {
				addParams.put("qty_discount_sched_dtl_seq",1);
			}else {
				addParams.put("qty_discount_sched_dtl_seq",(maxId+1));
			}
			
			addParams.put("qty_discount_schedule",paymetsModel.getQtyDiscountSchedule());
			addParams.put("from_qty",paymetsModel.getFromqty());
			addParams.put("to_qty",paymetsModel.getToqty());
			addParams.put("amount",paymetsModel.getAmount());
			addParams.put("qty_discount_percent",paymetsModel.getQtyDiscount_percent());
			addParams.put("from_amt",paymetsModel.getFromamt());
			addParams.put("to_amt",paymetsModel.getToamt());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveQtyDiscountSchedule(PaymentsModel paymetsModel) {
		int status=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder(
				"insert into qty_discount_schedule(qty_discount_schedule,description,discount_amt_calc_type) values(:qty_discount_schedule,:description,:discount_amt_calc_type)");
		try {
			addParams.put("qty_discount_schedule",paymetsModel.getQtyDiscountSchedule());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("discount_amt_calc_type",paymetsModel.getDiscountAmtCalcType());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int updateQtyDiscountSchedule(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String,Object> updateParams=new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"update qty_discount_schedule set description=:description where qty_discount_schedule='"+paymetsModel.getQtyDiscountSchedule()+"'");
		try {
			updateParams.put("qty_discount_schedule",paymetsModel.getQtyDiscountSchedule());
			updateParams.put("description",paymetsModel.getDescription());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);
			
			StringBuilder query1 = new StringBuilder(
					" update qty_discount_sched_dtl set from_qty=:from_qty,to_qty=:to_qty,amount=:amount where qty_discount_schedule='"+paymetsModel.getQtyDiscountSchedule()+"' "
							+ "and qty_discount_sched_dtl_seq='"+paymetsModel.getQtyDiscountSchedDtlSeq()+"'");
			updateParams.put("from_qty",paymetsModel.getFromqty());
			updateParams.put("to_qty",paymetsModel.getToqty());
			updateParams.put("amount",paymetsModel.getAmount());
			status = namedParameterJdbcTemplate.update(query1.toString(), updateParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteQtyDiscountSchedule(String qtyDiscountSchedule, int qtyDiscountSchedDtlSeq) {
		int status=0;
		StringBuilder deleteQuery=new StringBuilder("delete from qty_discount_sched_dtl where qty_discount_sched_dtl_seq='"+qtyDiscountSchedDtlSeq+"' and qty_discount_schedule='"+qtyDiscountSchedule+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteQtyDiscountScheduleDtl(String qtyDiscountSchedule) {
		int status=0;
		StringBuilder deleteQuery1=new StringBuilder("delete qty_discount_schedule from qty_discount_schedule Q ");
		deleteQuery1.append("left join qty_discount_sched_dtl on Q.qty_discount_schedule=qty_discount_sched_dtl.qty_discount_schedule");
		deleteQuery1.append(" left join ratecard on Q.qty_discount_schedule=ratecard.qty_discount_schedule where Q.qty_discount_schedule='"+qtyDiscountSchedule+"'");
		try {
			status=jdbcTemplate.update(deleteQuery1.toString());

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveMultilinDiscountSchedule(PaymentsModel paymetsModel) {
		int status=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder(
				"insert into multiline_discount_schedule(multiline_discount_schedule,description,discount_calc_type)"
				+ "values(:multiline_discount_schedule,:description,:discount_calc_type) ");
		try {
			addParams.put("multiline_discount_schedule",paymetsModel.getMultilineDiscountSchedule());
			addParams.put("description",paymetsModel.getDescription());
			addParams.put("discount_calc_type",paymetsModel.getDiscountCalcType());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveMultilineDiscEff(PaymentsModel paymetsModel) {
		int status1=0;
		Integer maxId=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder(
				"insert into multiline_disc_eff(multiline_discount_schedule,effective_date,multiline_disc_eff_seq,description,renewal_expire_effective_date) "
				+ "values(:multiline_discount_schedule,:effective_date,:multiline_disc_eff_seq,:description,:renewal_expire_effective_date)");
		try {
			maxId=jdbcTemplate.queryForObject("select max(multiline_disc_eff_seq) from multiline_disc_eff where multiline_discount_schedule='"+paymetsModel.getMultilineDiscountSchedule()+"'",Integer.class);
			if(maxId==null) {
				addParams.put("multiline_disc_eff_seq",1);
			}else {
				addParams.put("multiline_disc_eff_seq",(maxId+1));
			}
			addParams.put("multiline_discount_schedule",paymetsModel.getMultilineDiscountSchedule());
			String effectiveDate=  paymetsModel.getEffectiveDate();
			SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
			Date invDate = outSDF.parse(effectiveDate);
			String invFinalDate = outSDF.format(invDate);
			addParams.put("effective_date", invFinalDate);
			addParams.put("description",paymetsModel.getDescription());
			String renExpireEffectiveDate=paymetsModel.getRenExpireEffectiveDate();
			Date invDate1 = outSDF.parse(renExpireEffectiveDate);
			String invFinalDate1 = outSDF.format(invDate1);
			LOGGER.info("renExpireEffectiveDate-->"+invFinalDate1);
			addParams.put("renewal_expire_effective_date",invFinalDate1);
			status1 = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status1;
	}

	@Override
	public int saveMultilineDiscSchedDtl(PaymentsModel paymetsModel) {
		int status2=0;
		Integer maxId=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("insert into multi_disc_sched_dtl(currency,from_qty,to_qty,from_amt,to_amt,amount,multiline_discount_percent,multiline_discount_schedule,multi_disc_sched_dtl_seq,multiline_disc_eff_seq) "
				+ "values(:currency,:from_qty,:to_qty,:from_amt,:to_amt,:amount,:multiline_discount_percent,:multiline_discount_schedule,:multi_disc_sched_dtl_seq,:multiline_disc_eff_seq)");
		try {
			maxId=jdbcTemplate.queryForObject("select max(multi_disc_sched_dtl_seq) from multi_disc_sched_dtl where multiline_discount_schedule='"+paymetsModel.getMultilineDiscountSchedule()+"'", Integer.class);
		if(maxId==null) {
			addParams.put("multi_disc_sched_dtl_seq",1);
		}else {
			addParams.put("multi_disc_sched_dtl_seq",maxId+1);
		}
		addParams.put("currency",paymetsModel.getCurrency());
		addParams.put("from_qty",paymetsModel.getFromqty());
		addParams.put("to_qty",paymetsModel.getToqty());
		addParams.put("from_amt",paymetsModel.getFromamt());
		addParams.put("to_amt",paymetsModel.getToamt());
		addParams.put("amount",paymetsModel.getAmount());
		addParams.put("multiline_discount_percent",paymetsModel.getMultilineDiscountPercent());
		addParams.put("multiline_discount_schedule",paymetsModel.getMultilineDiscountSchedule());
		addParams.put("multiline_disc_eff_seq",paymetsModel.getMultilineDiscEffSeq());
		status2 = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status2;
	}

	@Override
	public int updateMultilineDiscountSchedule(PaymentsModel paymetsModel) {
		int status=0;
		Map<String,Object> updateParams=new LinkedHashMap<>();
		StringBuilder query1=new StringBuilder(
				"update multiline_discount_schedule set description=:description,discount_calc_type=:discount_calc_type where multiline_discount_schedule='"+paymetsModel.getMultilineDiscountSchedule()+"'");
		try {
			updateParams.put("multiline_discount_schedule",paymetsModel.getMultilineDiscountSchedule());
			updateParams.put("description",paymetsModel.getDescription());
			updateParams.put("discount_calc_type",paymetsModel.getDiscountCalcType());
			status = namedParameterJdbcTemplate.update(query1.toString(), updateParams);

			StringBuilder query2=new StringBuilder(
					"update multiline_disc_eff set effective_date=:effective_date,description=:description,renewal_expire_effective_date=:renewal_expire_effective_date where  multiline_discount_schedule='"+paymetsModel.getMultilineDiscountSchedule()+"' and multiline_disc_eff_seq='"+paymetsModel.getMultilineDiscEffSeq()+"'");
			updateParams.put("multiline_discount_schedule",paymetsModel.getMultilineDiscountSchedule());
			updateParams.put("description",paymetsModel.getDescription());
			String effective=paymetsModel.getEffectiveDate();
			Date date1 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(effective);

			updateParams.put("effective_date",date1);
			String renewalEffective=paymetsModel.getRenExpireEffectiveDate();
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(renewalEffective);

			updateParams.put("renewal_expire_effective_date",date2);
			updateParams.put("multiline_disc_eff_seq",paymetsModel.getMultilineDiscEffSeq());

			status = namedParameterJdbcTemplate.update(query2.toString(), updateParams);
			
			StringBuilder query3=new StringBuilder(
					"update multi_disc_sched_dtl set currency=:currency,from_qty=:from_qty,to_qty=:to_qty,from_amt=:from_amt,amount=:amount"
					+ " where multiline_discount_schedule='"+paymetsModel.getMultilineDiscountSchedule()+"' and multi_disc_sched_dtl_seq="+paymetsModel.getMultiDiscScheddtlSeq());
			updateParams.put("multiline_discount_schedule",paymetsModel.getMultilineDiscountSchedule());
			updateParams.put("currency",paymetsModel.getCurrency());
			updateParams.put("from_qty",paymetsModel.getFromqty());
			updateParams.put("to_qty",paymetsModel.getToqty());
			updateParams.put("from_amt",paymetsModel.getFromamt());
			updateParams.put("amount",paymetsModel.getAmount());
			status = namedParameterJdbcTemplate.update(query3.toString(), updateParams);


		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteMultilineDiscountScheduleDetails(String multilineDiscountSchedule, Integer multilineDiscEffSeq,Integer multiDiscScheddtlSeq) {
			int status=0;
			try {
			StringBuilder deleteQuery1=new StringBuilder("delete from multi_disc_sched_dtl  where multiline_discount_schedule='"+multilineDiscountSchedule+"' and "
					+ "multi_disc_sched_dtl_seq='"+multiDiscScheddtlSeq+"'");
			status=jdbcTemplate.update(deleteQuery1.toString());

			StringBuilder deleteQuery2=new StringBuilder("delete from multiline_disc_eff where multiline_discount_schedule='"+multilineDiscountSchedule+"' and multiline_disc_eff_seq="+multilineDiscEffSeq); 
			
			status=jdbcTemplate.update(deleteQuery2.toString());

			StringBuilder deleteQuery3=new StringBuilder("delete multiline_discount_schedule from multiline_discount_schedule S ");
			deleteQuery3.append("left join multi_disc_sched_dtl on S.multiline_discount_schedule=multi_disc_sched_dtl.multiline_discount_schedule ");
			deleteQuery3.append("left join order_item on S.multiline_discount_schedule=order_item.multiline_discount_schedule ");
			deleteQuery3.append("left join promotion_hist_offer on S.multiline_discount_schedule=promotion_hist_offer.multiline_discount_schedule ");
			deleteQuery3.append("left join work_promotion_offer on S.multiline_discount_schedule=work_promotion_offer.multiline_discount_schedule ");
			deleteQuery3.append("left join work_renewal_offer on S.multiline_discount_schedule=work_renewal_offer.multiline_discount_schedule ");
			deleteQuery3.append("left join multiline_disc_eff on S.multiline_discount_schedule=multiline_disc_eff.multiline_discount_schedule ");
			deleteQuery3.append("left join pkg_def on S.multiline_discount_schedule=pkg_def.multiline_discount_schedule ");
			deleteQuery3.append("left join renewal_history_offer on S.multiline_discount_schedule=renewal_history_offer.multiline_discount_schedule where S.multiline_discount_schedule='"+multilineDiscountSchedule+"'");
			
			status=jdbcTemplate.update(deleteQuery3.toString());
			

			}catch(Exception e) {
				LOGGER.error(ERROR + e); 
			}
		return status;
	}

	@Override
	public int saveCancelReason(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> addCancelReason = new LinkedHashMap<>();
		try {
			String cancelReasonQuery = "insert into cancel_reason(cancel_reason,description,cancel_type,applies_to_any_oc,active)" + "values(:cancel_reason,:description,:cancel_type,:applies_to_any_oc,:active)";
			
			addCancelReason.put("cancel_reason", tableSetupOrdersModel.getCancelReason());
			LOGGER.info("cancelReason:{}", tableSetupOrdersModel.getCancelReason());
			addCancelReason.put("description", tableSetupOrdersModel.getCancelReasonDescription());
			addCancelReason.put("cancel_type", tableSetupOrdersModel.getCancelType());
			
			addCancelReason.put("applies_to_any_oc", tableSetupOrdersModel.isAppliesToAnyOc());
			addCancelReason.put("active", tableSetupOrdersModel.isActive());

			status = namedParameterJdbcTemplate.update(cancelReasonQuery,addCancelReason);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateCancelReason(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> updateCancelReason = new LinkedHashMap<>();
		String cancelReasonQuery = "update cancel_reason set description=:description,cancel_type=:cancel_type,applies_to_any_oc=:applies_to_any_oc,active=:active where cancel_reason= '"+ tableSetupOrdersModel.getCancelReason()+"'";
		
		
		try {
			
			//updateCancelReason.put("cancel_reason", tableSetupOrdersModel.getCancelReason());
			//LOGGER.info("cancelReason:{}", tableSetupOrdersModel.getCancelReason());
			updateCancelReason.put("description", tableSetupOrdersModel.getCancelReasonDescription());
			updateCancelReason.put("cancel_type", tableSetupOrdersModel.getCancelType());
			
			updateCancelReason.put("applies_to_any_oc", tableSetupOrdersModel.isAppliesToAnyOc());
			updateCancelReason.put("active", tableSetupOrdersModel.isActive());

			status = namedParameterJdbcTemplate.update(cancelReasonQuery,updateCancelReason);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteCancelReason(String cancelReason) {
		int status = 0;
		try {
            
			String  deleteCancelReason= "delete from cancel_reason where cancel_reason= '" + cancelReason + "'";
			status = jdbcTemplate.update( deleteCancelReason);
			String deleteOcCancelReason=" delete from oc_cancel_reason where cancel_reason='"+cancelReason+"'";
			status = jdbcTemplate.update(deleteOcCancelReason);
			String deleteOrderItem=" delete from order_item where cancel_reason='"+cancelReason+"'";
			status = jdbcTemplate.update(deleteOrderItem);
			String deleteProcess=" delete from process where cancel_reason='"+cancelReason+"'";
			status = jdbcTemplate.update( deleteProcess);
			String deleteSubscrip=" delete from subscrip where cancel_reason='"+cancelReason+"'";
			status = jdbcTemplate.update(deleteSubscrip);
			

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;

	
	}

	@Override
	public int saveCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel) {

		int status = 0;
		Map<String, Object> addCancelPolicy = new LinkedHashMap<>();
		try {
			String cancelPolicyQuery = "insert into cancel_policy(cancel_policy_id,description,range_type,penalty,mru_cancel_policy_detail_seq)" + "values(:cancel_policy_id,:description,:range_type,:penalty,:mru_cancel_policy_detail_seq)";
			
			int MaxCancelPolicyId = jdbcTemplate.queryForObject("select max(cancel_policy_id) from cancel_policy",Integer.class);
			
			//addCancelPolicy.put("cancel_policy_id", tableSetupOrdersModel.getCancelPolicyId());
			//LOGGER.info("cancelPolicyId:{}", tableSetupOrdersModel.getCancelPolicyId());
			
			 addCancelPolicy.put("cancel_policy_id",  MaxCancelPolicyId+1);
			 addCancelPolicy.put("description", tableSetupOrdersModel.getCancelPolicyDescription());
			 addCancelPolicy.put("range_type", tableSetupOrdersModel.getRangeType());
			
			 addCancelPolicy.put("penalty", tableSetupOrdersModel.getPenality());
			 addCancelPolicy.put("mru_cancel_policy_detail_seq", tableSetupOrdersModel.isActive());

			status = namedParameterJdbcTemplate.update(cancelPolicyQuery, addCancelPolicy);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		
		
	}

	@Override
	public int updateCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel) {

		int status = 0;
		Map<String, Object> updateCancelPolicy = new LinkedHashMap<>();
		String cancelPolicyQuery = "update cancel_policy set description=:description,range_type=:range_type,penalty=:penalty,mru_cancel_policy_detail_seq=:mru_cancel_policy_detail_seq where cancel_policy_id="+ tableSetupOrdersModel.getCancelPolicyId();
		
		
		try {
			
			 //updateCancelPolicy.put("cancel_policy_id",  MaxCancelPolicyId+1);
			 updateCancelPolicy.put("cancel_policy_id", tableSetupOrdersModel.getCancelPolicyId());
			 updateCancelPolicy.put("description", tableSetupOrdersModel.getCancelPolicyDescription());
			 updateCancelPolicy.put("range_type", tableSetupOrdersModel.getRangeType());
			
			 updateCancelPolicy.put("penalty", tableSetupOrdersModel.getPenality());
			 updateCancelPolicy.put("mru_cancel_policy_detail_seq", tableSetupOrdersModel.isActive());
			

			status = namedParameterJdbcTemplate.update(cancelPolicyQuery,updateCancelPolicy);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteCancelPolicy(int cancelPolicyId) {
		int status = 0;
		try {
			
			String  deleteCancelPolicy= "delete from cancel_policy where cancel_policy_id=" +cancelPolicyId;
			status = jdbcTemplate.update(deleteCancelPolicy);
			String  deleteCancelPolicyDetails= "delete from cancel_policy_detail where cancel_policy_id=" +cancelPolicyId;
			status = jdbcTemplate.update( deleteCancelPolicyDetails);
			String  deleteSubscripDef= "delete from subscription_def where cancel_policy_id=" +cancelPolicyId;
			status = jdbcTemplate.update(deleteSubscripDef);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	@Override
	public int saveListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> addListPremiumUsed = new LinkedHashMap<>();
		try {
			String  addListPremiumUsedQuery= "insert into view_premium_order_code(order_code_id,order_code,description,order_code_type,premium,active,allow_on_internet,controlled,auto_renewal,auto_replace,oc_id,user_code)" + "values(:order_code_id,:order_code,:description,:order_code_type,:premium,:active,:allow_on_internet,:controlled,:auto_renewal,:auto_replace,:oc_id,:user_code)";
			tableSetupOrdersModel.setUserCode("THK");
			addListPremiumUsed.put("order_code",tableSetupOrdersModel.getOrderCode());
			addListPremiumUsed.put("order_code_id",tableSetupOrdersModel.getOrderCodeId());
			addListPremiumUsed.put("description", tableSetupOrdersModel.getDescription());
			addListPremiumUsed.put("order_code_type", tableSetupOrdersModel.getOrderCodeType());
			
			addListPremiumUsed.put("premium", tableSetupOrdersModel.getPremium());
			addListPremiumUsed.put("active", tableSetupOrdersModel.isActive());
			addListPremiumUsed.put("allow_on_internet", tableSetupOrdersModel.getAllowOnInternet());
			addListPremiumUsed.put("active", tableSetupOrdersModel.isActive());
			addListPremiumUsed.put("controlled", tableSetupOrdersModel.getControlled());
			addListPremiumUsed.put("auto_renewal", tableSetupOrdersModel.getAutoRenew());
			addListPremiumUsed.put("auto_replace", tableSetupOrdersModel.getAutoReplace());
			addListPremiumUsed.put("oc_id", tableSetupOrdersModel.getOcId());
			addListPremiumUsed.put("user_code",tableSetupOrdersModel.getUserCode());

			status = namedParameterJdbcTemplate.update(addListPremiumUsedQuery,addListPremiumUsed);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public int updateListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel) {
		
		
		
		int status = 0;
		Map<String, Object> updateListPremiumUsed = new LinkedHashMap<>();
		String ListPremiumUsedQuery = "update view_premium_order_code set order_code_id=:order_code_id,description=:description,order_code_type=:order_code_type,premium=:premium,active=:active,allow_on_internet=:allow_on_internet,controlled=:controlled,auto_renewal=:auto_renewal,"
				+ "auto_replace=:auto_replace,user_code=:user_code where order_code= " + tableSetupOrdersModel.getOrderCode()+" and oc_id= "+ tableSetupOrdersModel.getOcId();
		try {
			
			tableSetupOrdersModel.setUserCode("THK");
			
			updateListPremiumUsed.put("order_code_id", tableSetupOrdersModel.getOrderCodeId());
	        //updateListPremiumUsed.put("order_code", tableSetupOrdersModel.getOrderCode());
			
			updateListPremiumUsed.put("description", tableSetupOrdersModel.getCancelPolicyDescription());
			updateListPremiumUsed.put("order_code_type", tableSetupOrdersModel.getOrderCodeType());
			
			updateListPremiumUsed.put("premium", tableSetupOrdersModel.getPremium());
			updateListPremiumUsed.put("active", tableSetupOrdersModel.isActive());
			updateListPremiumUsed.put("allow_on_internet", tableSetupOrdersModel.getAllowOnInternet());
			updateListPremiumUsed.put("controlled", tableSetupOrdersModel.getControlled());
			updateListPremiumUsed.put("auto_renewal", tableSetupOrdersModel.getAutoRenew());
			updateListPremiumUsed.put("auto_replace", tableSetupOrdersModel.getAutoReplace());
			updateListPremiumUsed.put("oc_id", tableSetupOrdersModel.getOcId());
			updateListPremiumUsed.put("user_code",tableSetupOrdersModel.getUserCode());

			status = namedParameterJdbcTemplate.update(ListPremiumUsedQuery,updateListPremiumUsed);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteListPremiumUsed(String orderCode, int ocId) {
		
		int status = 0;
		try {

			String  deleteListPremiumUsedQuery= "delete from  view_premium_order_code where order_code= " + orderCode+"  and oc_id= "+ocId;
			
			status = jdbcTemplate.update(deleteListPremiumUsedQuery);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}


	@Override
	public int saveOrders(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> addOrders = new LinkedHashMap<>();
		try {
			String searchFieldGroupQuery = "insert into search_field_group(search,search_field_group_seq,disp_context,example_text,search_result_display_seq)" + "values(:search,:search_field_group_seq,:disp_context,:example_text,:search_result_display_seq)";
			
			addOrders.put("search", tableSetupOrdersModel.getSearch());
			LOGGER.info("search:{}", tableSetupOrdersModel.getSearch());
			addOrders.put("search_field_group_seq", tableSetupOrdersModel.getSearchFieldGroupSeq());
		    addOrders.put("disp_context", tableSetupOrdersModel.getDisplayContext());
		    addOrders.put("example_text", tableSetupOrdersModel.getExampleText());
			addOrders.put("search_result_display_seq", tableSetupOrdersModel.getSearchResultDisplaySeq());
            status = namedParameterJdbcTemplate.update(searchFieldGroupQuery,addOrders);
			String searchResultDisplayQuery = "insert into search_result_display(search,disp_context,search_result_display_seq,application_result_action)" + "values(:search,:disp_context,:search_result_display_seq,:application_result_action)";
			addOrders.put("application_result_action", tableSetupOrdersModel.getApplicationResultAction());
			status = namedParameterJdbcTemplate.update(searchResultDisplayQuery,addOrders);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}
	

	@Override
	public int updateOrders(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> updateOrders  = new LinkedHashMap<>();
		//updateOrders.put("search", tableSetupOrdersModel.getSearch());
		//LOGGER.info("search:{}", tableSetupOrdersModel.getSearch());
		//updateOrders.put("search_field_group_seq", tableSetupOrdersModel.getSearchFieldGroupSeq());
		updateOrders.put("disp_context",tableSetupOrdersModel.getDisplayContext());
		updateOrders.put("example_text",tableSetupOrdersModel.getExampleText());
		updateOrders.put("search_result_display_seq",tableSetupOrdersModel.getSearchResultDisplaySeq());
		
		try {
		
		String searchFieldGroupQuery = "update search_field_group set disp_context=:disp_context,example_text=:example_text,search_result_display_seq=:search_result_display_seq "
				+ "where  search= '" +tableSetupOrdersModel.getSearch()+ "' and search_field_group_seq= "+ tableSetupOrdersModel.getSearchFieldGroupSeq();
		status = namedParameterJdbcTemplate.update(searchFieldGroupQuery,updateOrders);
		
		String searchResultDisplayQuery="update search_result_display set disp_context=:disp_context,application_result_action=:application_result_action where "
						+ "search= '" +tableSetupOrdersModel.getSearch()+ "' and search_result_display_seq= " +tableSetupOrdersModel.getSearchResultDisplaySeq();
			
		updateOrders.put("application_result_action", tableSetupOrdersModel.getApplicationResultAction());
			status = namedParameterJdbcTemplate.update(searchResultDisplayQuery,updateOrders);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteOrders(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
		
		int status = 0;
		try {

			String  deleteSearchFieldGroup= "delete from search_field_group where search='" +search+ "' and search_field_group_seq="+ searchFieldGroupSeq;
			status = jdbcTemplate.update(deleteSearchFieldGroup);
			
			String  deleteSearchReasultGroup= "delete from search_result_display where search='" +search+ "' and search_result_display_seq="+searchResultDisplaySeq;
			status = jdbcTemplate.update(deleteSearchReasultGroup);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
		}

	@Override
	public int saveOrderCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> addOrderCategory = new LinkedHashMap<>();
		try {
			String orderCategoryQuery = "insert into order_category(order_category,description)" + "values(:order_category,:description)";
			
			addOrderCategory.put("order_category", tableSetupOrdersModel.getOrderCategory());
			addOrderCategory.put("description", tableSetupOrdersModel.getDescription());
			
			status = namedParameterJdbcTemplate.update(orderCategoryQuery,addOrderCategory);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateOrderCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> updateOrderCategory = new LinkedHashMap<>();
		try {
		
		String searchOrderCategory = "update order_category set description=:description where order_category= '" +tableSetupOrdersModel.getOrderCategory()+"'";
		updateOrderCategory.put("description",tableSetupOrdersModel.getDescription());
				
		status = namedParameterJdbcTemplate.update(searchOrderCategory,updateOrderCategory);
		
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteOrderCategory(String orderCategory) {
		
		int status = 0;
		try {

			String  deleteOrderCategory= "delete from order_category where order_category=" + orderCategory;
			status = jdbcTemplate.update(deleteOrderCategory);
			String  deleteOrderItem= "delete from order_item where order_item=" + orderCategory;
			status = jdbcTemplate.update(deleteOrderItem);
			
	} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
		}

	@Override
	public int saveSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> addSubscriptionCategory = new LinkedHashMap<>();
		try {
			String subscriptionCategoryQuery = "insert into subscription_category(subscription_category_id,description)" + "values(:subscription_category_id,:description)";
			addSubscriptionCategory.put("subscription_category_id", tableSetupOrdersModel.getSubscriptionCategoryId());
			addSubscriptionCategory.put("description", tableSetupOrdersModel.getDescription());
			
			status = namedParameterJdbcTemplate.update(subscriptionCategoryQuery,addSubscriptionCategory);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> updateSubscriptionCategory = new LinkedHashMap<>();
		try {
		
		String subscriptionCategoryQuery = "update subscription_category set description=:description where subscription_category_id= " +tableSetupOrdersModel.getSubscriptionCategoryId();
		updateSubscriptionCategory.put("description",tableSetupOrdersModel.getDescription());
				
		status = namedParameterJdbcTemplate.update(subscriptionCategoryQuery,updateSubscriptionCategory);
		
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int deleteSubscriptionCategory(int subscriptionCategoryId) {
		
		int status = 0;
		try {

			String  deleteSubscriptionCategory= "delete from subscription_category  where subscription_category_id=" +subscriptionCategoryId ;
			status = jdbcTemplate.update(deleteSubscriptionCategory);
			//String  deleteOrderCode= "delete from order_code  where subscription_category_id=" +subscriptionCategoryId ;
			//status = jdbcTemplate.update(deleteOrderCode);
			//String  deleteSubscrip= "delete from subscription_def  where subscription_category_id=" +subscriptionCategoryId ;
			//status = jdbcTemplate.update(deleteSubscrip);
			//String  deleteVolGroupRegCatgory= "delete from vol_grp_regions_category  where subscription_category_id=" +subscriptionCategoryId ;
			//status = jdbcTemplate.update(deleteVolGroupRegCatgory);
			
			
      } catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
		}

	@Override
	public int saveTaxonomy(TableSetupOrdersModel tableSetupOrdersModel) {
	
		int status = 0;
		Map<String, Object> addTaxonomy = new LinkedHashMap<>();
		try {
			String addTaxonomyQuery = "insert into taxonomy(taxonomy,description)" + "values(:taxonomy,:description)";
			addTaxonomy.put("taxonomy",tableSetupOrdersModel.getTaxonomy());
			addTaxonomy.put("description",tableSetupOrdersModel.getDescription());
			
			status = namedParameterJdbcTemplate.update(addTaxonomyQuery,addTaxonomy);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateTaxonomy(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> updateTaxonomy = new LinkedHashMap<>();
		try {
		
		String updateTaxonomyQuery = "update taxonomy set description=:description where taxonomy= '" +tableSetupOrdersModel.getTaxonomy()+"'";
		updateTaxonomy.put("description",tableSetupOrdersModel.getDescription());
		status = namedParameterJdbcTemplate.update(updateTaxonomyQuery,updateTaxonomy);
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		}

	@Override
	public int deleteTaxonomy(String taxonomy) {
		
		int status = 0;
		try {

			String  deleteTaxonomy= "delete from taxonomy  where taxonomy= '" +taxonomy+"'";
			status = jdbcTemplate.update(deleteTaxonomy);
			String  deleteOrderCode= "delete from order_code  where taxonomy= '" +taxonomy+"'";
			status = jdbcTemplate.update(deleteOrderCode);
			String  deleteProduct= "delete from product  where taxonomy= '" +taxonomy+"'";
			status = jdbcTemplate.update(deleteProduct);
			String  deleteWorkTable= "delete work_table  where taxonomy= '" +taxonomy+"'";
			status = jdbcTemplate.update(deleteWorkTable);
			
			
			
	} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
    }

	@Override
	public int saveTerm(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> addTerm = new LinkedHashMap<>();
		try {
			String addTermQuery = "insert into term(term_id,term,description,n_calendar_units,calendar_unit,n_issues,number_volume_sets,disallow_install_billing,n_cal_units_per_seg,n_items_per_seg,"
					+ "max_check_out_amt,start_type)" + "values(:term_id,:term,:description,:n_calendar_units,:calendar_unit,:n_issues,:number_volume_sets,:disallow_install_billing,:n_cal_units_per_seg,:n_items_per_seg,"
							+ ":max_check_out_amt,:start_type)";
			int MaxTermId = jdbcTemplate.queryForObject("select max(term_id) from term",Integer.class);
			
			//addTerm.put("term_id",tableSetupOrdersModel.getTermId());
			addTerm.put("term_id", MaxTermId+1);
			addTerm.put("term",tableSetupOrdersModel.getTerm());
			addTerm.put("description",tableSetupOrdersModel.getDescription());
			addTerm.put("n_calendar_units",tableSetupOrdersModel.getnCalenderUnits());
			addTerm.put("calendar_unit",tableSetupOrdersModel.getCalenderUnit());
			addTerm.put("n_issues",tableSetupOrdersModel.getnIssues());
			addTerm.put("number_volume_sets",tableSetupOrdersModel.getNumVolumeSets());
			addTerm.put("disallow_install_billing",tableSetupOrdersModel.getDisallowInstallBilling());
			addTerm.put("n_cal_units_per_seg",tableSetupOrdersModel.getnCalenderUnitsPerSegmnt());
			addTerm.put("n_items_per_seg",tableSetupOrdersModel.getnItemsPerSegment());
			addTerm.put("max_check_out_amt",tableSetupOrdersModel.getMaxCheckAmount());
			addTerm.put("start_type",tableSetupOrdersModel.getStartType());
		    status = namedParameterJdbcTemplate.update(addTermQuery,addTerm);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateTerm(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> updateTerm = new LinkedHashMap<>();
		try {
		
		String updateTermQuery = "update term set term=:term,description=:description,n_calendar_units=:n_calendar_units,calendar_unit=:calendar_unit,n_issues=:n_issues,number_volume_sets=:number_volume_sets,disallow_install_billing=:disallow_install_billing,n_cal_units_per_seg=:n_cal_units_per_seg,"
			+ "n_items_per_seg=:n_items_per_seg,max_check_out_amt=:max_check_out_amt,start_type=:start_type  where term_id =" +tableSetupOrdersModel.getTermId();
		
		 //updateTerm.put("term_id",tableSetupOrdersModel.getTermId());
		 updateTerm.put("term",tableSetupOrdersModel.getTerm());
		 updateTerm.put("description",tableSetupOrdersModel.getDescription());
		 updateTerm.put("n_calendar_units",tableSetupOrdersModel.getnCalenderUnits());
		 updateTerm.put("calendar_unit",tableSetupOrdersModel.getCalenderUnit());
		 updateTerm.put("n_issues",tableSetupOrdersModel.getnIssues());
		 updateTerm.put("number_volume_sets",tableSetupOrdersModel.getNumVolumeSets());
		 updateTerm.put("disallow_install_billing",tableSetupOrdersModel.getDisallowInstallBilling());
		 updateTerm.put("n_cal_units_per_seg",tableSetupOrdersModel.getnCalenderUnitsPerSegmnt());
		 updateTerm.put("n_items_per_seg",tableSetupOrdersModel.getnItemsPerSegment());
		 updateTerm.put("max_check_out_amt",tableSetupOrdersModel.getMaxCheckAmount());
		 updateTerm.put("start_type",tableSetupOrdersModel.getStartType());
	    status = namedParameterJdbcTemplate.update(updateTermQuery, updateTerm);
		
     } catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		}

	
	@Override
	public int deleteTerm(int termId) {
		int status = 0;
		try {

			String  deleteTerm= "delete from term  where term_id= " +termId;
			status = jdbcTemplate.update(deleteTerm);
			String  deleteJobRenOfferDetail= "delete from job_ren_offer_detail  where term_id= " +termId;
			status = jdbcTemplate.update(deleteJobRenOfferDetail);

			String  deleteRenCardOrderCode= "delete from ren_card_order_code  where term_id= " +termId;
			status = jdbcTemplate.update(deleteRenCardOrderCode);

			String  deleteSubscripDef= "delete from subscription_def where term_id= " +termId;
			status = jdbcTemplate.update(deleteSubscripDef);
			
			String  deleteTermInstallPlan= "delete from term_install_plan where term_id= " +termId;
			status = jdbcTemplate.update(deleteTermInstallPlan);

			String deleteWorkPromOffer = "delete from work_promotion_offer where term_id= " +termId;
			status = jdbcTemplate.update(deleteWorkPromOffer);
			
			String  deleteOrderCode= "delete from order_code  where term_id= " +termId;
			status = jdbcTemplate.update(deleteOrderCode);
			
			
			
			
			
	} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
    }

	@Override
	public int saveUnitTypes(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> addUnitTypes= new LinkedHashMap<>();
		try {
			String addUnitTypesQuery = "insert into unit_type(unit_type_id,label,description)" + "values(:unit_type_id,:label,:description)";
			addUnitTypes.put("unit_type_id",tableSetupOrdersModel.getUnitTypeId());
			addUnitTypes.put("label",tableSetupOrdersModel.getLabel());
			addUnitTypes.put("description",tableSetupOrdersModel.getDescription());
			
			status = namedParameterJdbcTemplate.update(addUnitTypesQuery,addUnitTypes);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateUnitTypes(TableSetupOrdersModel tableSetupOrdersModel) {
		
		int status = 0;
		Map<String, Object> updateUnitTypes = new LinkedHashMap<>();
		try {
		
		String updateUnitTypesQuery = "update unit_type set label=:label,description=:description where unit_type= " +tableSetupOrdersModel.getUnitTypeId();
		updateUnitTypes.put("description",tableSetupOrdersModel.getDescription());
		updateUnitTypes.put("label",tableSetupOrdersModel.getLabel());
		status = namedParameterJdbcTemplate.update(updateUnitTypesQuery,updateUnitTypes);
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		}

	@Override
	public int deleteUnitTypes(int unitTypeId) {
		int status = 0;
		try {

			String  deleteUnitTypes= "delete from unit_type  where unit_type_id= " +unitTypeId;
			status = jdbcTemplate.update(deleteUnitTypes);

			String  deleteOrderCode= "delete from order_code  where unit_type_id= " +unitTypeId;
			status = jdbcTemplate.update(deleteOrderCode);
			
			String  deleteOrderItem= "delete from order_item  where unit_type_id= " +unitTypeId;
			status = jdbcTemplate.update(deleteOrderItem);
			
			String  deleteUnitHistory= "delete from unit_history where unit_type_id= " +unitTypeId;
			status = jdbcTemplate.update(deleteUnitHistory);
			
			
			
	} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	@Override
	public int saveUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> addUpsellSuggestion= new LinkedHashMap<>();
		try {
			String addUpsellSuggestionQuery = "insert into upsell_suggestion(upsell_suggestion_id,description)" + "values(:upsell_suggestion_id,:description)";
			int MaxUpsellSuggestionId = jdbcTemplate.queryForObject("select max(upsell_suggestion_id) from upsell_suggestion",Integer.class); 
			addUpsellSuggestion.put("upsell_suggestion_id",MaxUpsellSuggestionId+1);
			//addUpsellSuggestion.put("upsell_suggestion_id",tableSetupOrdersModel.getUpsellSuggestionId());
	        addUpsellSuggestion.put("description",tableSetupOrdersModel.getDescription());
			
			status = namedParameterJdbcTemplate.update(addUpsellSuggestionQuery,addUpsellSuggestion);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
  }

	@Override
	public int updateUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> updateUpsellSuggestion = new LinkedHashMap<>();
		try {
		
		String  updateUpsellSuggestionQuery= "update upsell_suggestion set upsell_suggestion_id=:upsell_suggestion_id,description=:description where upsell_suggestion_id = " +tableSetupOrdersModel.getUpsellSuggestionId();	
		
		//updateUpsellSuggestion.put("upsell_suggestion_id",tableSetupOrdersModel.getUpsellSuggestionId());
	
		updateUpsellSuggestion.put("description",tableSetupOrdersModel.getDescription());
		
		status = namedParameterJdbcTemplate.update(updateUpsellSuggestionQuery,updateUpsellSuggestion);
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		}

	@Override
	public int deleteUpsellSuggestion(int upsellSuggestionId) {
		int status = 0;
		try {

			String  deleteUpsellSuggestion= "delete from upsell_suggestion  where upsell_suggestion_id= " +upsellSuggestionId;
			status = jdbcTemplate.update(deleteUpsellSuggestion);
			
			String  deleteUpsell= "delete from upsell  where upsell_suggestion_id= " +upsellSuggestionId;
			status = jdbcTemplate.update(deleteUpsell);
			
	} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	@Override
	public int saveCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel) {
	

		int status = 0;
		Map<String, Object> addCalenderCampaign= new LinkedHashMap<>();
		try {
			String addCalenderCampaignQuery = "insert into calendar_campaign(calendar_campaign_id,begin_day,begin_month,campaign,end_day,end_month)" + "values(:calendar_campaign_id,:begin_day,:begin_month,:campaign,:end_day,:end_month)";
			int MaxCalenderCapaignIdId = jdbcTemplate.queryForObject("select max(calendar_campaign_id) from calendar_campaign",Integer.class); 
			
			//addCalenderCampaign.put("calendar_campaign_id",tableSetupOrdersModel.getCalenderCampaignId());
			addCalenderCampaign.put("calendar_campaign_id",MaxCalenderCapaignIdId+1);
			addCalenderCampaign.put("begin_day",tableSetupOrdersModel.getBeginDay());
			addCalenderCampaign.put("begin_month",tableSetupOrdersModel.getBeginmonth());
			addCalenderCampaign.put("campaign",tableSetupOrdersModel.getCampaign());
			addCalenderCampaign.put("end_day",tableSetupOrdersModel.getEndDay());
			addCalenderCampaign.put("end_month",tableSetupOrdersModel.getEndMonth());
			
			status = namedParameterJdbcTemplate.update(addCalenderCampaignQuery,addCalenderCampaign);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel) {
		int status = 0;
		Map<String, Object> updateCalenderCampaign = new LinkedHashMap<>();
		try {
		
		String  updateCalenderCampaignQuery= "update calendar_campaign set begin_day=:begin_day,begin_month=:begin_month,campaign=:campaign,end_day=:end_day,end_month=:end_month where calendar_campaign_id = " +tableSetupOrdersModel.getCalenderCampaignId();	
		//updateCalenderCampaign.put("calendar_campaign_id",tableSetupOrdersModel.getCalenderCampaignId());
		updateCalenderCampaign.put("begin_day",tableSetupOrdersModel.getBeginDay());
		updateCalenderCampaign.put("begin_month",tableSetupOrdersModel.getBeginmonth());
		updateCalenderCampaign.put("campaign",tableSetupOrdersModel.getCampaign());
		updateCalenderCampaign.put("end_day",tableSetupOrdersModel.getEndDay());
		updateCalenderCampaign.put("end_month",tableSetupOrdersModel.getEndMonth());
		
		status = namedParameterJdbcTemplate.update(updateCalenderCampaignQuery,updateCalenderCampaign);
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
		}

	@Override
	public int deleteCalenderCampaign(int calenderCampaignId) {
		int status = 0;
		try {

			String  deleteCalenderCampaign= "delete from calendar_campaign where calendar_campaign_id = " +calenderCampaignId;
			status = jdbcTemplate.update(deleteCalenderCampaign);
			
			String  deleteUpsell= "delete from upsell  where calendar_campaign_id= " +calenderCampaignId;
			status = jdbcTemplate.update(deleteUpsell);
			
			
	} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getOrderDetails(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
		
	List<Map<String, Object>> getOrderDetails = new ArrayList<>();
		try {
			 if(search!=null&searchFieldGroupSeq!=0&searchResultDisplaySeq!=0) {
			//getOrderDetails = jdbcTemplate.queryForList(
				//	"select F.search,F.search_field_group_seq,F.disp_context,F.disp_context,F.example_text,F.search_result_display_seq,R.application_result_action"
					//+ " from search_result_display R inner join search_field_group F on F.search_result_display_seq=R.search_result_display_seq");
			
			getOrderDetails=jdbcTemplate.queryForList("select search,search_field_group_seq,disp_context,example_text,search_result_display_seq  from search_field_group  where search= '" + search+"' and search_field_group_seq ="+searchFieldGroupSeq);
			getOrderDetails.addAll(jdbcTemplate.queryForList("select search,disp_context,search_result_display_seq,application_result_action from  search_result_display  where search= '" + search+"' and search_result_display_seq ="+searchResultDisplaySeq));
			 }else
			 {
				 getOrderDetails=jdbcTemplate.queryForList("select search,search_field_group_seq,disp_context,example_text,search_result_display_seq  from search_field_group");
					getOrderDetails.addAll(jdbcTemplate.queryForList("select search,disp_context,search_result_display_seq,application_result_action from  search_result_display"));
			 }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return getOrderDetails;
	

	
	}
	@Override
	public int saveServiceCause(ServiceModel serviceModel) {
		int status=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("insert into cause_code(cause_code,description,memo_required,report_item_id,email_report_url) "
				+ "values(:cause_code,:description,:memo_required,:report_item_id,:email_report_url)");
		try {
			addParams.put("cause_code",serviceModel.getCauseCode());
			addParams.put("description",serviceModel.getDescription());
			addParams.put("memo_required",serviceModel.getMemoRequired());
			addParams.put("report_item_id",serviceModel.getReportItemId());
			addParams.put("email_report_url",serviceModel.getEmailReportUrl());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		
		return status;
	}

	@Override
	public int updateServiceCause(ServiceModel serviceModel) {
		int status=0;
		Map<String,Object> updateParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("update cause_code set description=:description,memo_required=:memo_required,"
				+ "email_report_url=:email_report_url where cause_code='"+serviceModel.getCauseCode()+"' and report_item_id="+serviceModel.getReportItemId());
		try {
			updateParams.put("description",serviceModel.getDescription());
			updateParams.put("memo_required",serviceModel.getMemoRequired());
			updateParams.put("email_report_url",serviceModel.getEmailReportUrl());
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteServiceCause(String causeCode, int reportItemId) {
		int status=0;
		try {
		StringBuilder query=new StringBuilder("delete from complaint_code where cause_code='"+causeCode+"' and report_item_id="+reportItemId);
		status=jdbcTemplate.update(query.toString());
		
		StringBuilder query1=new StringBuilder("delete from service where cause_code='"+causeCode+"'");
		status=jdbcTemplate.update(query1.toString());
		
		StringBuilder query2=new StringBuilder("delete from cause_code where cause_code='"+causeCode+"' and cause_code.report_item_id="+reportItemId);
		status=jdbcTemplate.update(query2.toString());

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int saveServiceComplaint(ServiceModel serviceModel) {
		int status=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("insert into complaint_code(cause_code,description,memo_required,report_item_id,email_report_url,complaint_code,service_code,followup_required) "
				+ "values(:cause_code,:description,:memo_required,:report_item_id,:email_report_url,:complaint_code,:service_code,:followup_required)");
		try {
			addParams.put("cause_code",serviceModel.getCauseCode());
			addParams.put("description",serviceModel.getDescription());
			addParams.put("memo_required",serviceModel.getMemoRequired());
			addParams.put("report_item_id",serviceModel.getReportItemId());
			addParams.put("email_report_url",serviceModel.getEmailReportUrl());
			addParams.put("complaint_code",serviceModel.getComplaintCode());
			addParams.put("service_code",serviceModel.getServiceCode());
			addParams.put("followup_required",serviceModel.getFollowupRequired());
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int updateServiceComplaint(ServiceModel serviceModel) {
		int status=0;
		Map<String,Object> updateParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("update complaint_code set description=:description,memo_required=:memo_required,followup_required=:followup_required,"
				+ "email_report_url=:email_report_url where complaint_code='"+serviceModel.getComplaintCode()+"' and report_item_id="+serviceModel.getReportItemId());
		try {
			updateParams.put("description",serviceModel.getDescription());
			updateParams.put("memo_required",serviceModel.getMemoRequired());
			updateParams.put("email_report_url",serviceModel.getEmailReportUrl());
			updateParams.put("followup_required",serviceModel.getFollowupRequired());

			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteServiceComplaint(String complaintCode, String serviceCode) {
		int status=0;
		try {
			StringBuilder query1=new StringBuilder("delete from service where complaint_code='"+complaintCode+"' and service_code='"+serviceCode+"'");
			status=jdbcTemplate.update(query1.toString());

		StringBuilder query=new StringBuilder("delete from complaint_code where complaint_code='"+complaintCode+"' and service_code='"+serviceCode+"'");
		status=jdbcTemplate.update(query.toString());

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		
		return status;
	}

	@Override
	public int saveServiceResolution(ServiceModel serviceModel) {
		int status=0;
		Map<String,Object> addParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("insert into service_code(description,memo_required,report_item_id,email_report_url,close_complaint,service_code,auto_replace,use_carry_over,enforce_shipped_issues) "
				+ "values(:description,:memo_required,:report_item_id,:email_report_url,:close_complaint,:service_code,:auto_replace,:use_carry_over,:enforce_shipped_issues)");
		try {
			addParams.put("description",serviceModel.getDescription());
			addParams.put("memo_required",serviceModel.getMemoRequired());
			addParams.put("report_item_id",serviceModel.getReportItemId());
			addParams.put("email_report_url",serviceModel.getEmailReportUrl());
			addParams.put("close_complaint",serviceModel.getCloseComplaint());
			addParams.put("service_code",serviceModel.getServiceCode());
			addParams.put("auto_replace",serviceModel.getAutoReplace());
			addParams.put("use_carry_over",serviceModel.getUseCarryOver());
			addParams.put("enforce_shipped_issues",serviceModel.getEnforceShippedIssues());

			status = namedParameterJdbcTemplate.update(query.toString(), addParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int updateServiceResolution(ServiceModel serviceModel) {
		int status=0;
		Map<String,Object> updateParams=new LinkedHashMap<>();
		StringBuilder query=new StringBuilder("update service_code set description=:description,memo_required=:memo_required,close_complaint=:close_complaint,use_carry_over=:use_carry_over,"
				+ "enforce_shipped_issues=:enforce_shipped_issues,auto_replace=:auto_replace,email_report_url=:email_report_url where service_code='"+serviceModel.getServiceCode()+"' and report_item_id="+serviceModel.getReportItemId());
		try {
			updateParams.put("description",serviceModel.getDescription());
			updateParams.put("memo_required",serviceModel.getMemoRequired());
			updateParams.put("report_item_id",serviceModel.getReportItemId());
			updateParams.put("email_report_url",serviceModel.getEmailReportUrl());
			updateParams.put("close_complaint",serviceModel.getCloseComplaint());
			updateParams.put("auto_replace",serviceModel.getAutoReplace());
			updateParams.put("use_carry_over",serviceModel.getUseCarryOver());
			updateParams.put("enforce_shipped_issues",serviceModel.getEnforceShippedIssues());

			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		return status;
	}

	@Override
	public int deleteServiceResolution(String complaintCode, String serviceCode,int reportItemId) {
		int status=0;
		try {

			StringBuilder query=new StringBuilder("delete from complaint_code where complaint_code='"+complaintCode+"' and service_code='"+serviceCode+"'");
			status=jdbcTemplate.update(query.toString());
			
			StringBuilder query1=new StringBuilder("delete from service where complaint_code='"+complaintCode+"' and service_code='"+serviceCode+"'");
			status=jdbcTemplate.update(query1.toString());

		StringBuilder deleteQuery=new StringBuilder("delete from service_code where service_code='"+serviceCode+"' and report_item_id="+reportItemId);
		status=jdbcTemplate.update(deleteQuery.toString());

		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
		
		return status;
	}
	@Override
	public List<Map<String, Object>> getProfitCenter(String profitCenter) {
		List<Map<String, Object>> profitCenterDetails= new ArrayList<>();
		try {
			profitCenterDetails= jdbcTemplate.queryForList("select profit_center,description from profit_center  where profit_center= '"+profitCenter+"'");
		
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  profitCenterDetails;
	}
	@Override
	public List<Map<String, Object>> getSourceCodeFormats(TableSetupOrderClassModel tableSetupOrderClassModel ) {
		List<Map<String, Object>> sourceCodeFormatsDetails= new ArrayList<>();
		try {
			sourceCodeFormatsDetails= jdbcTemplate.queryForList("select source_attribute,description,width from source_attribute where source_attribute= '"+ tableSetupOrderClassModel.getSourceAttribute()+"'");
			sourceCodeFormatsDetails= jdbcTemplate.queryForList("select source_attribute,source_attribute_value,description,idx from source_attribute_value where"
				+ " source_attribute= '"+tableSetupOrderClassModel.getSourceAttribute()+ "' and source_attribute_value= '"+ tableSetupOrderClassModel.getSourceAttributeValue()+"'");
			sourceCodeFormatsDetails= jdbcTemplate.queryForList("select source_format,code_gen_type,description,mru_source_format_segment_seq from source_format where "
					+ "source_format='"+tableSetupOrderClassModel.getSourceFormat()+"'");
			sourceCodeFormatsDetails=jdbcTemplate.queryForList("select source_format,source_format_segment_seq,fixed_value,gen_func_parm,generation_function,generation_method,source_attribute from source_format_segment "
				+ "where source_format='" + tableSetupOrderClassModel.getSourceFormat()+"' and source_format_segment_seq= " + tableSetupOrderClassModel.getSourceFormatSegmentSeq());
		} catch (Exception e) {
			
			LOGGER.error(ERROR + e);
		}
		return sourceCodeFormatsDetails;
	}

	@Override
	public List<Map<String, Object>> getTopic(String topic) {
		
		
		List<Map<String, Object>> TopicDetails= new ArrayList<>();
		try {
			 if(topic!=null) {
			TopicDetails= jdbcTemplate.queryForList("select topic,description from topic  where topic= '"+topic+"'");
			 }else {
				 TopicDetails= jdbcTemplate.queryForList("select topic,description from topic"); 
			 }
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  TopicDetails;
		
		
	}
	
	@Override
	public List<Map<String, Object>> getVolumeGroup(int volumeGroupId) {
		List<Map<String, Object>> volumeGroupDetails= new ArrayList<>();
		try {
			 if(volumeGroupId!=0) {
			volumeGroupDetails= jdbcTemplate.queryForList("select  volume_group_id,volume from volume_group  where volume_group_id= "+volumeGroupId);
			 }else {
				 volumeGroupDetails= jdbcTemplate.queryForList("select  volume_group_id,volume from volume_group"); 
			 }
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  volumeGroupDetails;
	}
	
	@Override
	public List<Map<String, Object>> getCancelReason(String cancelReason) {
		List<Map<String, Object>> cancelReasonDetails= new ArrayList<>();
		try {
			 if(cancelReason!=null) {
			cancelReasonDetails = jdbcTemplate.queryForList("select  cancel_reason,description,cancel_type,applies_to_any_oc,active from cancel_reason  where cancel_reason='" + cancelReason+"'");
			 }else {
				 cancelReasonDetails = jdbcTemplate.queryForList("select  cancel_reason,description,cancel_type,applies_to_any_oc,active from cancel_reason"); 
			 }
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return cancelReasonDetails;

	}

	@Override
	public List<Map<String, Object>> getCancelPolicy() {
		List<Map<String, Object>> cancelPolicyDetails= new ArrayList<>();
		try {
			
			cancelPolicyDetails= jdbcTemplate.queryForList("select *from cancel_policy");
		
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return cancelPolicyDetails;
	}

	@Override
	public List<Map<String, Object>> getPremiumUsed() {
		
		List<Map<String, Object>> premiumUsedDetails= new ArrayList<>();
		try {
			premiumUsedDetails= jdbcTemplate.queryForList("select *from view_premium_order_code");
		
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return premiumUsedDetails;
}

	@Override
	public List<Map<String, Object>> getOrderCategory(String orderCategory) {
		List<Map<String, Object>> OrderCategoryDetails= new ArrayList<>();
		try {
			 if(orderCategory!=null) {
			OrderCategoryDetails= jdbcTemplate.queryForList("select description from  order_category where order_category= '"+orderCategory+"'");
			 }else {
				 OrderCategoryDetails= jdbcTemplate.queryForList("select description from  order_category"); 
			 }
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return OrderCategoryDetails;
	}

	@Override
	public List<Map<String, Object>> getSubscriptionCategory(int subscriptionCategoryId) {
		List<Map<String, Object>> subscriptionCategoryDetails= new ArrayList<>();
		try {
			 if(subscriptionCategoryId!=0) {
			subscriptionCategoryDetails= jdbcTemplate.queryForList("select description from subscription_category where subscription_category_id= "+subscriptionCategoryId);
		
			 }else {
				 subscriptionCategoryDetails= jdbcTemplate.queryForList("select description from subscription_category"); 
			 }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptionCategoryDetails;
	}

	@Override
	public List<Map<String, Object>> getTaxonomy(String taxonomy) {
		List<Map<String, Object>> taxonomyDetails= new ArrayList<>();
		try {
			 if(taxonomy!=null) {
			 taxonomyDetails= jdbcTemplate.queryForList("select description from taxonomy where taxonomy= '"+taxonomy+"'");
			 }else {
				 taxonomyDetails= jdbcTemplate.queryForList("select description from taxonomy"); 
			 }
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  taxonomyDetails;
	}

	@Override
	public List<Map<String, Object>> getTerm(int termId) {
		List<Map<String, Object>> termDetails= new ArrayList<>();
		try {
			 if(termId!=0) {
			 termDetails= jdbcTemplate.queryForList("select  term_id,term,description,n_calendar_units,calendar_unit,n_issues,number_volume_sets,disallow_install_billing,n_cal_units_per_seg,n_items_per_seg,max_check_out_amt,start_type from term  where term_id= "+termId);
		}else {
			termDetails= jdbcTemplate.queryForList("select  term_id,term,description,n_calendar_units,calendar_unit,n_issues,number_volume_sets,disallow_install_billing,n_cal_units_per_seg,n_items_per_seg,max_check_out_amt,start_type from term");
		}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  termDetails;
		
	}

	@Override
	public List<Map<String, Object>> getUnitType(int unitTypeId) {
		
		List<Map<String, Object>> unitTypeDetails= new ArrayList<>();
		try {
			if(unitTypeId!=0) {
			unitTypeDetails= jdbcTemplate.queryForList("select unit_type_id,label,description from unit_type where unit_type_id= "+unitTypeId);
		
			}else {
				unitTypeDetails= jdbcTemplate.queryForList("select unit_type_id,label,description from unit_type");	
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  unitTypeDetails;
	}

	@Override
	public List<Map<String, Object>> getUpsellSuggestion(int upsellSuggestionId) {
		List<Map<String, Object>> upsellSuggestionDetails= new ArrayList<>();
		try {
			if(upsellSuggestionId!=0) {
			upsellSuggestionDetails= jdbcTemplate.queryForList("select upsell_suggestion_id,description from upsell_suggestion  where upsell_suggestion_id= "+upsellSuggestionId);
			}else {
				upsellSuggestionDetails= jdbcTemplate.queryForList("select upsell_suggestion_id,description from upsell_suggestion");
			}
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  upsellSuggestionDetails;
	}

	@Override
	public List<Map<String, Object>> getCalenderCampaign(int calenderCampaignId) {
		List<Map<String, Object>> calenderCampaignDetails= new ArrayList<>();
		try {
			if(calenderCampaignId!=0) {
			 calenderCampaignDetails= jdbcTemplate.queryForList("select calendar_campaign_id,campaign,begin_day,begin_month,end_day,end_month  from calendar_campaign where calendar_campaign_id= "+calenderCampaignId);
			}else {
				 calenderCampaignDetails= jdbcTemplate.queryForList("select calendar_campaign_id,campaign,begin_day,begin_month,end_day,end_month  from calendar_campaign");
			}
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return   calenderCampaignDetails;
	}	

	
	
@Override
public int saveCommodityCode(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addCommodityCodes= new LinkedHashMap<>();
	try {
		String commodityCodeQuery = "insert into commodity_code(commodity_code,description)" + "values(:commodity_code,:description)";
		
		addCommodityCodes.put("commodity_code",taxesModel.getCommodityCode());
		addCommodityCodes.put("description",taxesModel.getDescription());
		
		status = namedParameterJdbcTemplate.update(commodityCodeQuery,addCommodityCodes);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateCommodityCode(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateCommodityCode= new LinkedHashMap<>();
	try {
	
	String commodityCodeQuery = "update commodity_code set commodity_code=:commodity_code,description=:description where commodity_code= " +taxesModel.getCommodityCode();
	
	updateCommodityCode.put("commodity_code",taxesModel.getCommodityCode());
	LOGGER.info("CommodityCode:{}",taxesModel.getCommodityCode());
	updateCommodityCode.put("description",taxesModel.getDescription());
			
	status = namedParameterJdbcTemplate.update(commodityCodeQuery,updateCommodityCode);
	
	
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteCommodityCode(int commodityCode) {
	int status = 0;
	try {

		String  deleteCommodityCode= "delete from commodity_code where commodity_code=" + commodityCode;
		status = jdbcTemplate.update(deleteCommodityCode);
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
	}

@Override
public List<Map<String, Object>> getCommodityCode(int commodityCode) {
	List<Map<String, Object>> commodityCodeDetails= new ArrayList<>();
	try {
		if(commodityCode!=0) {
		commodityCodeDetails= jdbcTemplate.queryForList("select description from  commodity_code where commodity_code= "+commodityCode);
	}else {
		commodityCodeDetails= jdbcTemplate.queryForList("select description from  commodity_code");
	}
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return commodityCodeDetails;
}

@Override
public int saveJurisdiction(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addJurisdiction = new LinkedHashMap<>();
	try {
		String jurisdictionQuery = "insert into jurisdiction(state,jurisdiction_seq,city,county,jurisdiction,postal_code)" + "values(:state,:jurisdiction_seq,:city,:county,:jurisdiction,:postal_code)";
		
		addJurisdiction.put("state",taxesModel.getState());
		LOGGER.info("state:{}",taxesModel.getState());
		addJurisdiction.put("jurisdiction_seq",taxesModel.getJurisdictionSeq());
		addJurisdiction.put("city",taxesModel.getCity());
		addJurisdiction.put("county",taxesModel.getCountry());
		addJurisdiction.put("jurisdiction",taxesModel.getJurisdiction());
		addJurisdiction.put("postal_code",taxesModel.getPostalCode());
		
		status = namedParameterJdbcTemplate.update(jurisdictionQuery,addJurisdiction);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateJurisdiction(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateJurisdiction= new LinkedHashMap<>();
	try {
	
	String JurisdictionQuery = "update jurisdiction set city=:city,county=:county,jurisdiction=:jurisdiction,postal_code=:postal_code where"
			+ " state= '" +taxesModel.getState()+"'" + " and jurisdiction_seq= " + taxesModel.getJurisdictionSeq();
	
	updateJurisdiction.put("state",taxesModel.getState());
	LOGGER.info("state:{}",taxesModel.getState());
    updateJurisdiction.put("jurisdiction_seq",taxesModel.getJurisdictionSeq());
    LOGGER.info("jurisdiction_seq:{}",taxesModel.getJurisdictionSeq()); 
    updateJurisdiction.put("city",taxesModel.getCity());
    LOGGER.info("city:{}",taxesModel.getCity());
    updateJurisdiction.put("county",taxesModel.getCountry());
    updateJurisdiction.put("jurisdiction",taxesModel.getJurisdiction());
    updateJurisdiction.put("postal_code",taxesModel.getPostalCode());
			
	status = namedParameterJdbcTemplate.update(JurisdictionQuery,updateJurisdiction);
	
	
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteJurisdiction(String state,int jurisdictionSeq) {
	int status = 0;
	try {

		String  deleteJurisdiction= "delete from jurisdiction where  state= '" +state+"' and + jurisdiction_seq="+jurisdictionSeq;
		status = jdbcTemplate.update(deleteJurisdiction);
		
	
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getJurisdiction(String state) {
	List<Map<String, Object>> jurisdictionDetails= new ArrayList<>();
	try {
		if(state!=null) {
		 jurisdictionDetails= jdbcTemplate.queryForList("select state,jurisdiction_seq,city,county,jurisdiction,postal_code from  jurisdiction where state= '"+state+"'");
	
		}else {
			 jurisdictionDetails= jdbcTemplate.queryForList("select state,jurisdiction_seq,city,county,jurisdiction,postal_code from  jurisdiction");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  jurisdictionDetails;
}

@Override
public List<DropdownModel> getStateCodeList(String state) {
	
	
	List<DropdownModel> stateCodeList=new ArrayList<>();
	try {
		List<Map<String,Object>> stateCodeDetails=jdbcTemplate.queryForList("select state,description,country from state where state='"+state+"'");
		for(Map<String,Object> stateCode:stateCodeDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(stateCode.get("state").toString());
			model.setDescription(stateCode.get("description").toString());
			model.setDisplay(stateCode.get("country").toString());
			stateCodeList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return stateCodeList;
}

@Override
public int saveSpecialTax(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addSpecialTax = new LinkedHashMap<>();
	try {
		String  specialTaxyQuery = "insert into special_tax_id(special_tax_id,exempt_status)" + "values(:special_tax_id,:exempt_status)";
		 addSpecialTax.put("special_tax_id", taxesModel.getSpecialTaxId());
		 addSpecialTax.put("exempt_status", taxesModel.getExemptStatus());
		
		status = namedParameterJdbcTemplate.update(specialTaxyQuery,addSpecialTax );
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateSpecialTax(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateSpecialTax= new LinkedHashMap<>();
	try {
	
	String specialTaxQuery = "update special_tax_id set special_tax_id=:special_tax_id,exempt_status=:exempt_status where special_tax_id= '" +taxesModel.getSpecialTaxId()+"'";
	
	updateSpecialTax.put("special_tax_id",taxesModel.getSpecialTaxId());
	updateSpecialTax.put("exempt_status",taxesModel.getExemptStatus());
			
	status = namedParameterJdbcTemplate.update(specialTaxQuery,updateSpecialTax);
	
	
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteSpecialTax(String specialTaxId) {
	int status = 0;
	try {

		String  deleteSpecialTax= "delete from special_tax_id where  special_tax_id= '" +specialTaxId+"'";
		status = jdbcTemplate.update(deleteSpecialTax);
		
	
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getSpecialTax(String specialTaxId) {
	List<Map<String, Object>> specialTaxDetails= new ArrayList<>();
	try {
		if(specialTaxId!=null) {
		specialTaxDetails= jdbcTemplate.queryForList("select special_tax_id,exempt_status from  special_tax_id  where special_tax_id= '"+specialTaxId+"'");
		}else {
			specialTaxDetails= jdbcTemplate.queryForList("select special_tax_id,exempt_status from  special_tax_id");
		}
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return specialTaxDetails;
}

@Override
public List<DropdownModel> getExemptStatus(String specialTaxId) {
	List<DropdownModel> exemptStatusList=new ArrayList<>();
	try {
		List<Map<String,Object>> exemptStatusDetails=jdbcTemplate.queryForList("select exempt_status from special_tax_id  where special_tax_id='"+specialTaxId+"'");
		for(Map<String,Object>exemptStatus:exemptStatusDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(exemptStatus.get("exempt_status").toString());
			//model.setDescription(stateCode.get("description").toString());
			//model.setDisplay(stateCode.get("country").toString());
			exemptStatusList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return exemptStatusList;
}

@Override
public int saveTaxHandling(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addTaxHandling= new LinkedHashMap<>();
	try {
		String  taxHandlingQuery = "insert into tax_handling(tax_handling,tax_based_on,tax_point,tax_delivery,conflicting_tax_handling,recip_print_location,description)" + "values(:tax_handling,"
				+ ":tax_based_on,:tax_point,:tax_delivery,:conflicting_tax_handling,:recip_print_location,:description)";
		addTaxHandling.put("tax_handling", taxesModel.getTaxHandling());
		addTaxHandling.put("tax_based_on", taxesModel.getTaxBasedOn());
		addTaxHandling.put("tax_delivery", taxesModel.getTaxDelivery());
		addTaxHandling.put("tax_point", taxesModel.getTaxPoint());
		addTaxHandling.put("conflicting_tax_handling", taxesModel.getConflictingTaxHandling());
		addTaxHandling.put("recip_print_location", taxesModel.getReciptPrintLocation());
		addTaxHandling.put("description", taxesModel.getDescription());
		
		status = namedParameterJdbcTemplate.update(taxHandlingQuery,addTaxHandling);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateTaxHandling(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateTaxHandling= new LinkedHashMap<>();
	try {
	
	String taxHandlingQuery = "update tax_handling set tax_based_on=:tax_based_on,tax_point=:tax_point,tax_delivery=:tax_delivery,conflicting_tax_handling=:conflicting_tax_handling,recip_print_location=:recip_print_location,description=:description  where tax_handling= '" +taxesModel.getTaxHandling()+"'";
	
	updateTaxHandling.put("tax_handling", taxesModel.getTaxHandling());
	updateTaxHandling.put("tax_based_on", taxesModel.getTaxBasedOn());
	updateTaxHandling.put("tax_delivery", taxesModel.getTaxDelivery());
	updateTaxHandling.put("tax_point", taxesModel.getTaxPoint());
	updateTaxHandling.put("conflicting_tax_handling", taxesModel.getConflictingTaxHandling());
	updateTaxHandling.put("recip_print_location", taxesModel.getReciptPrintLocation());
	updateTaxHandling.put("description", taxesModel.getDescription());
			
	status = namedParameterJdbcTemplate.update(taxHandlingQuery ,updateTaxHandling);
	
	
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteTaxHandling(String  taxHandling) {
	int status = 0;
	try {

		String  deleteTaxHandling= "delete from tax_handling where  tax_handling= '" + taxHandling+"'";
		status = jdbcTemplate.update(deleteTaxHandling);
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
   }

@Override
public List<Map<String, Object>> getTaxHandling(String taxHandling) {
	List<Map<String, Object>> taxHandlingDetails= new ArrayList<>();
	try {
		 if(taxHandling!=null) {
		taxHandlingDetails= jdbcTemplate.queryForList("select tax_handling,tax_based_on,tax_point,tax_delivery,conflicting_tax_handling,recip_print_location,description from"
				+ "  tax_handling where tax_handling= '"+taxHandling+"'");
		 }else {
			 taxHandlingDetails= jdbcTemplate.queryForList("select tax_handling,tax_based_on,tax_point,tax_delivery,conflicting_tax_handling,recip_print_location,description from tax_handling");
		 }
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  taxHandlingDetails;
}

@Override
public List<DropdownModel> getTaxHandlingList(String taxHandling) {
	List<DropdownModel> taxHandlingList=new ArrayList<>();
	try {
		List<Map<String,Object>> taxHandlingDetails=jdbcTemplate.queryForList("select tax_based_on,tax_point,tax_delivery,conflicting_tax_handling,recip_print_location from  tax_handling where tax_handling= '"+taxHandling+"'");
		for(Map<String,Object> taxHandlingLst:taxHandlingDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey( taxHandlingLst.get("tax_based_on").toString());
			model.setDescription( taxHandlingLst.get("tax_point").toString());
			model.setDisplay( taxHandlingLst.get("tax_delivery").toString());
			model.setExtra(taxHandlingLst.get("conflicting_tax_handling").toString());
			model.setExtraData(taxHandlingLst.get("recip_print_location").toString());
			taxHandlingList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return taxHandlingList;
}

@Override
public int saveTaxRatesbyCountryandState(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addTaxRatesbyCountryandState = new LinkedHashMap<>();
	try {
		String  taxRatesbyCountryandStateQuery = "insert into state(state,description,country,tax_id_prefix,tax_id_format)" + "values(:state,:description,:country,:tax_id_prefix,:tax_id_format)";
		addTaxRatesbyCountryandState.put("state", taxesModel.getState());
		addTaxRatesbyCountryandState.put("description", taxesModel.getDescription());
		addTaxRatesbyCountryandState.put("country", taxesModel.getCountry());
		addTaxRatesbyCountryandState.put("tax_id_prefix", taxesModel.getTaxIdPrefix());
		addTaxRatesbyCountryandState.put("tax_id_format", taxesModel.getTaxIdFormat());
		
		status = namedParameterJdbcTemplate.update(taxRatesbyCountryandStateQuery,addTaxRatesbyCountryandState);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateTaxRatesbyCountryandState(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateTaxRatesbyCountryandState= new LinkedHashMap<>();
	try {
	
	String stateQuery = "update state set description=:description,country=:country,tax_id_prefix=:tax_id_prefix,tax_id_format=:tax_id_format  where state= '" +taxesModel.getState()+"'";
	updateTaxRatesbyCountryandState.put("state", taxesModel.getState());
	updateTaxRatesbyCountryandState.put("description", taxesModel.getDescription());
	updateTaxRatesbyCountryandState.put("country", taxesModel.getCountry());
	updateTaxRatesbyCountryandState.put("tax_id_prefix", taxesModel.getTaxIdPrefix());
	updateTaxRatesbyCountryandState.put("tax_id_format", taxesModel.getTaxIdFormat());
			
	status = namedParameterJdbcTemplate.update(stateQuery,updateTaxRatesbyCountryandState);
	
	
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteTaxRatesbyCountryandState(String state) {
	int status = 0;
	try {

		//String  deleteState= "delete from state where  state= '" +state+"'";
		//status = jdbcTemplate.update(deleteState);
		
		//int status=0;
		StringBuilder deleteQuery=new StringBuilder("delete state from state S ");
		deleteQuery.append(" left join address on S.state= address.state");
		deleteQuery.append(" left join dist_method_default on S.state=dist_method_default.state");
		deleteQuery.append(" left join process_state  on  S.state=process_state.state");
		deleteQuery.append(" left join start_stop_address on S.state=start_stop_address.state");
		deleteQuery.append(" left join tax_rate_commodity on S.state=tax_rate_commodity.state");
		deleteQuery.append(" left join customer_address C on S.state=C.state ");
		deleteQuery.append(" left join dist_method_override  on S.state= dist_method_override.state");
		deleteQuery.append(" left join region_list_state  on S.state= region_list_state.state");
		deleteQuery.append(" left join sub_iss_hist_audit  on S.state= sub_iss_hist_audit.state");
		deleteQuery.append(" left join tax_rate_juris_commodity T  on S.state= T.state");
		deleteQuery.append(" left join dd_bank_def on S.state= dd_bank_def.state");
		deleteQuery.append(" left join jurisdiction on S.state= jurisdiction.state");
		deleteQuery.append(" left join  region_state on S.state=  region_state.state");
		deleteQuery.append(" left join tax_rate_basic on S.state= tax_rate_basic.state");
		deleteQuery.append(" left join vendor on S.state= vendor.state");
		deleteQuery.append(" left join del_method_default on S.state= del_method_default.state");
		deleteQuery.append(" left join order_item_amt_break on S.state= order_item_amt_break.state");
		deleteQuery.append(" left join  source_code_state on S.state=  source_code_state.state");
		
		deleteQuery.append(" where S.state= '"+ state+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
	return status;
		
	
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getTaxRatesbyCountryandState(String state) {
	
	List<Map<String, Object>> taxRatesbyCountryandStateDetails= new ArrayList<>();
	try {
		if(state!=null) {
		taxRatesbyCountryandStateDetails= jdbcTemplate.queryForList("select state,description,country,tax_id_prefix,tax_id_format from"
				+ " state where state= '"+state+"'");
	
		}else {
			taxRatesbyCountryandStateDetails= jdbcTemplate.queryForList("select state,description,country,tax_id_prefix,tax_id_format from state");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  taxRatesbyCountryandStateDetails;
}

@Override
public int saveTaxRateCategories(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addTaxRateCategories = new LinkedHashMap<>();
	try {
		String  taxRateCategoriesQuery = "insert into tax_rate_category(tax_rate_category,description) " + "values(:tax_rate_category,:description)";
		addTaxRateCategories.put("tax_rate_category", taxesModel.getTaxRateCategory());
		addTaxRateCategories.put("description", taxesModel.getDescription());
		
		
		status = namedParameterJdbcTemplate.update(taxRateCategoriesQuery,addTaxRateCategories);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateTaxRateCategories(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateTaxRateCategories= new LinkedHashMap<>();
	try {
	
	String taxRateCategoriesQuery = "update tax_rate_category set description=:description where tax_rate_category= '" + taxesModel.getTaxRateCategory()+"'";
	//updateTaxRateCategories.put("tax_rate_category",taxesModel.getTaxRateCategory());
	//LOGGER.info("taxRateCategory:{}",taxesModel.getTaxRateCategory());
	 updateTaxRateCategories.put("description",taxesModel.getDescription());
	//LOGGER.info("description:{}",taxesModel.getDescription());
    status = namedParameterJdbcTemplate.update(taxRateCategoriesQuery,updateTaxRateCategories);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteTaxRateCategories(String taxRateCategory) {
	int status = 0;
	try {

		StringBuilder deleteQuery=new StringBuilder("delete tax_rate_category from tax_rate_category T ");
		deleteQuery.append(" left join order_item_amt_break O on T.tax_rate_category= O.tax_rate_category");
		deleteQuery.append(" left join tax_rate_basic on T.tax_rate_category=tax_rate_basic.tax_rate_category");
		deleteQuery.append(" left join tax_rate_commodity  on  T.tax_rate_category=tax_rate_commodity.tax_rate_category");
		deleteQuery.append(" left join tax_rate_juris_commodity R  on T.tax_rate_category= R.tax_rate_category");
		deleteQuery.append(" left join tax_rate_jurisdiction  on T.tax_rate_category= tax_rate_jurisdiction.tax_rate_category");
		deleteQuery.append(" where T.tax_rate_category= '"+ taxRateCategory+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
	return status;
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getTaxRateCategories(String taxRateCategory) {
	List<Map<String, Object>> taxRateCategoriesDetails= new ArrayList<>();
	try {
		if(taxRateCategory!=null) {
		taxRateCategoriesDetails= jdbcTemplate.queryForList("select tax_rate_category,description from  tax_rate_category where tax_rate_category= '"+taxRateCategory+"'");
		}else {
			taxRateCategoriesDetails= jdbcTemplate.queryForList("select tax_rate_category,description from  tax_rate_category");
		}
	
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return taxRateCategoriesDetails;
}

@Override
public int saveTaxTypes(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> addTaxTypes = new LinkedHashMap<>();
	try {
		String  taxTypesQuery = "insert into tax_type(tax_type,description) " + "values(:tax_type,:description)";
		addTaxTypes.put("tax_type", taxesModel.getTaxType());
		addTaxTypes.put("description", taxesModel.getDescription());
		status = namedParameterJdbcTemplate.update(taxTypesQuery,addTaxTypes);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateTaxTypes(TaxesModel taxesModel) {
	int status = 0;
	Map<String, Object> updateTaxTypes= new LinkedHashMap<>();
	try {
	
	String taxTypeQuery = "update tax_type set description=:description where tax_type= '" + taxesModel.getTaxType()+"'";
	 updateTaxTypes.put("tax_type",taxesModel.getTaxType());
	updateTaxTypes.put("description",taxesModel.getDescription());
	
    status = namedParameterJdbcTemplate.update(taxTypeQuery,updateTaxTypes);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteTaxTypes(String taxType) {
	int status = 0;
	try {

		StringBuilder deleteQuery=new StringBuilder("delete tax_type from tax_type T ");
		deleteQuery.append(" left join order_item_amt_break O on T.tax_type= O.tax_type");
		deleteQuery.append(" left join tax_rate_basic on T.tax_type=tax_rate_basic.tax_type");
		deleteQuery.append(" left join tax_rate_commodity  on  T.tax_type=tax_rate_commodity.tax_type");
		deleteQuery.append(" left join tax_rate_juris_commodity R  on T.tax_type= R.tax_type");
		deleteQuery.append(" left join tax_rate_jurisdiction  on T.tax_type= tax_rate_jurisdiction.tax_type");
		deleteQuery.append(" where T.tax_type= '"+ taxType+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
	return status;
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getTaxTypes(String taxType) {
	List<Map<String, Object>> taxTypesDetails= new ArrayList<>();
	try {
		if(taxType!=null) {
		taxTypesDetails= jdbcTemplate.queryForList("select tax_type,description from  tax_type where tax_type= '"+taxType+"'");
		}else {
			taxTypesDetails= jdbcTemplate.queryForList("select tax_type,description from  tax_type");
		}
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return taxTypesDetails;
}
@Override
public int saveAddresses(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> addAddresses = new LinkedHashMap<>();
	try {
		String  addAddressQuery = "insert into address(address_id,address1,address2,address3,city,county,zip,state) " + "values(:address_id,:address1,:address2,:address3,:city,:county,:zip,:state)";
		
		int maxAddressId = jdbcTemplate.queryForObject("select max(address_id) from address", Integer.class);
		
		addAddresses.put("address_id", maxAddressId+1 );
		//addAddresses.put("address_id", internationalModel.getAddressId());
		addAddresses.put("address1", internationalModel.getAddress1());
		addAddresses.put("address2", internationalModel.getAddress2());
		addAddresses.put("address3", internationalModel.getAddress3());
		addAddresses.put("city", internationalModel.getCity());
		addAddresses.put("county", internationalModel.getCounty());
		addAddresses.put("zip", internationalModel.getZip());
		addAddresses.put("state", internationalModel.getState());
	   status = namedParameterJdbcTemplate.update(addAddressQuery,addAddresses);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateAddresses(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> updateAddresses= new LinkedHashMap<>();
	try {
	
	String addressesQuery = "update address set address1=:address1,address2=:address2,address3=:address3,city=:city,county=:county,zip=:zip,state=:state  where address_id= "+internationalModel.getAddressId();
	updateAddresses.put("address1",internationalModel.getAddress1());
	updateAddresses.put("address2",internationalModel.getAddress2());
	updateAddresses.put("address3",internationalModel.getAddress2());
	updateAddresses.put("city",internationalModel.getAddress2());
	updateAddresses.put("county",internationalModel.getAddress2());
	updateAddresses.put("zip",internationalModel.getAddress2());
	updateAddresses.put("state",internationalModel.getAddress2());
	status = namedParameterJdbcTemplate.update(addressesQuery,updateAddresses);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteAddresses(int addressId) {
	int status = 0;
	try {

		String  deleteAddresses= "delete from address where address_id= " +addressId;
		status = jdbcTemplate.update(deleteAddresses);
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getAddress(int addressId) {
	List<Map<String, Object>> getAddressDetails= new ArrayList<>();
	try {
		if(addressId!=0) {
		getAddressDetails= jdbcTemplate.queryForList("select address1,address2,address3,city,county,zip,state from  address  where address_id= "+addressId);
		}else {
			getAddressDetails= jdbcTemplate.queryForList("select address1,address2,address3,city,county,zip,state from  address");	
		}
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return getAddressDetails;
}

@Override
public List<DropdownModel> getStateList() {
List<DropdownModel> stateList=new ArrayList<>();
	try {
		List<Map<String,Object>> stateDetails=jdbcTemplate.queryForList("select state,description,country from  state");
		for(Map<String,Object> getstateList:stateDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getstateList.get("state").toString());
			model.setDescription(getstateList.get("description").toString());
			model.setDisplay(getstateList.get("country").toString());
			stateList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return stateList;
}

@Override
public int saveAddressCleaning(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> addAddressCleaning = new LinkedHashMap<>();
	try {
		String  iapDataSetDefQuery = "insert into iap_dataset_def(iap_dataset_def_id,iap_code,description,com_progid) " + "values(:iap_dataset_def_id,:iap_code,:description,:com_progid)";
		
    // int maxIapDataSetDefId = jdbcTemplate.queryForObject("select max(iap_dataset_def_id) from iap_dataset_def", Integer.class);
		
       // addAddressCleaning.put("address_id", maxIapDataSetDefId+1 );
		addAddressCleaning.put("iap_dataset_def_id", internationalModel.getIapDatasetDefId());
		addAddressCleaning.put("iap_code", internationalModel.getIapCode());
		addAddressCleaning.put("description", internationalModel.getDescription());
		addAddressCleaning.put("com_progid", internationalModel.getComprogId());
	    status = namedParameterJdbcTemplate.update(iapDataSetDefQuery,addAddressCleaning);
	    
	    String iapNameValueQuery= "insert into iap_name_value(iap_dataset_def_id,name,value,description)"+" values(:iap_dataset_def_id,:name,:value,:description)";
	    addAddressCleaning.put("name", internationalModel.getName());
		addAddressCleaning.put("value", internationalModel.getValue());
		addAddressCleaning.put("description", internationalModel.getDescription());
	    status = namedParameterJdbcTemplate.update(iapNameValueQuery,addAddressCleaning);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateAddressCleaning(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> updateAddressCleaning= new LinkedHashMap<>();
	try {
	
	String addressCleaningQuery = "update iap_dataset_def set iap_code=:iap_code,description=:description,com_progid=:com_progid  where iap_dataset_def_id= "+internationalModel.getIapDatasetDefId();
	updateAddressCleaning.put("iap_code",internationalModel.getIapCode());
	updateAddressCleaning.put("description",internationalModel.getDescription());
	updateAddressCleaning.put("com_progid",internationalModel.getComprogId());
    status = namedParameterJdbcTemplate.update(addressCleaningQuery,updateAddressCleaning);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteAddressCleaning(int iapDatasetDefId) {
	int status = 0;
	try {

		String  deleteAddressCleaning= "delete from  iap_dataset_def where iap_dataset_def_id= " +iapDatasetDefId;
		status = jdbcTemplate.update(deleteAddressCleaning);
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getAddressCleaning(int iapDatasetDefId) {
	List<Map<String, Object>> addressCleaningDetails= new ArrayList<>();
	try {
		if(iapDatasetDefId!=0) {
		addressCleaningDetails= jdbcTemplate.queryForList("select iap_code,description,com_progid from iap_dataset_def  where iap_dataset_def_id= "+iapDatasetDefId);
		}else {
			addressCleaningDetails= jdbcTemplate.queryForList("select iap_code,description,com_progid from iap_dataset_def");
		}
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return addressCleaningDetails;
}

@Override
public List<DropdownModel> getProgIdList() {
	List<DropdownModel> progIdList=new ArrayList<>();
	try {
		List<Map<String,Object>> progIdDetails=jdbcTemplate.queryForList("select com_progId,description  from com_progid");
		for(Map<String,Object> getProgIdList:progIdDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getProgIdList.get("com_progId").toString());
			model.setDisplay(getProgIdList.get("description").toString());
			progIdList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return progIdList;
     }

@Override
public List<Map<String, Object>> getIapNameValue(int iapDatasetDefId) {
	List<Map<String, Object>> iapNameValueDetails= new ArrayList<>();
	try {
		iapNameValueDetails= jdbcTemplate.queryForList("select name,value,description from iap_name_value  where iap_dataset_def_id= "+iapDatasetDefId);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return iapNameValueDetails;
}


@Override
public int saveCountryCode(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> addCountryCode = new LinkedHashMap<>();
	try {
		String  countryQuery = "insert into country(country_code2,country_code3,country_name,file_currency) " + " values(:country_code2,:country_code3,:country_name,:file_currency)";
		
		addCountryCode.put("country_code2",internationalModel.getCountryCode2());
	    LOGGER.info("countryCode2:{}",internationalModel.getCountryCode2());
		addCountryCode.put("country_code3", internationalModel.getCountryCode3());
		LOGGER.info("countryCode3:{}",internationalModel.getCountryCode3());
		addCountryCode.put("country_name",internationalModel.getCountryName());
		LOGGER.info("countryName:{}",internationalModel.getCountryName());
		addCountryCode.put("file_currency", internationalModel.getFileCurrency());
		LOGGER.info("fileCurrency:{}",internationalModel.getFileCurrency());
		status = namedParameterJdbcTemplate.update(countryQuery,addCountryCode);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateCountryCode(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> updateCountryCode= new LinkedHashMap<>();
	try {
	
	String countryCodeQuery = "update country set country_code3=:country_code3,country_name=:country_name,file_currency=:file_currency  where country_code2= '"+internationalModel.getCountryCode2()+"'";
	updateCountryCode.put("country_code2",internationalModel.getCountryCode2());
	updateCountryCode.put("country_code3",internationalModel.getCountryCode3());
	updateCountryCode.put("country_name",internationalModel.getCountryName());
	updateCountryCode.put("file_currency",internationalModel.getFileCurrency());
	
    status = namedParameterJdbcTemplate.update(countryCodeQuery,updateCountryCode);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteCountryCode(String countryCode2) {
	int status = 0;
	try {

		String  deleteCountryCode= "delete from country where country_code2= '" +countryCode2+"'";
		status = jdbcTemplate.update(deleteCountryCode);
		String  deleteStateQuery= "delete from state where country_code2= '" +countryCode2+"'";
		status = jdbcTemplate.update(deleteStateQuery);
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getCountryCode() {
	List<Map<String, Object>>  countryCodeDetails= new ArrayList<>();
	try {
		 countryCodeDetails= jdbcTemplate.queryForList("select country_code3,country_name,file_currency from country");
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  countryCodeDetails;
}

@Override
public List<DropdownModel> getFileCurrencyList() {
	List<DropdownModel> fileCurrencyList=new ArrayList<>();
	try {
		List<Map<String,Object>> fileCurrencyDetails=jdbcTemplate.queryForList("select currency,description,currency_symbol from currency");
		for(Map<String,Object> getFileCurrencyList:fileCurrencyDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getFileCurrencyList.get("currency").toString());
			model.setDescription(getFileCurrencyList.get("description").toString());
			model.setDisplay(getFileCurrencyList.get("currency_symbol").toString());
			fileCurrencyList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return fileCurrencyList;
     }

@Override
public int saveCountriesandStates(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> addCountriesandStates = new LinkedHashMap<>();
	try {
		
		String  countriesandStatesQuery = "insert into state(state,label_format,description,country,currency,country_code2,phonefmt,zipfmt,addr_prefix,suppress_issues,foreign_fld) " + "values(:state,:label_format,:description,:country,:currency,:country_code2,:phonefmt,:zipfmt,:addr_prefix,:suppress_issues,:foreign_fld)";
		addCountriesandStates.put("state",internationalModel.getState());
		addCountriesandStates.put("label_format",internationalModel.getLabelFormat());
		addCountriesandStates.put("description",internationalModel.getDescription());
		addCountriesandStates.put("country",internationalModel.getCounty());
		addCountriesandStates.put("currency",internationalModel.getCurrency());
		addCountriesandStates.put("country_code2",internationalModel.getCountryCode2());
		addCountriesandStates.put("phonefmt",internationalModel.getPhoneFormat());
		addCountriesandStates.put("zipfmt",internationalModel.getZipFormat());
		addCountriesandStates.put("addr_prefix",internationalModel.getAddressPrefix());
		addCountriesandStates.put("suppress_issues",internationalModel.getSuppressIssues());
		addCountriesandStates.put("foreign_fld",internationalModel.getForeignId());
		
	    status = namedParameterJdbcTemplate.update(countriesandStatesQuery,addCountriesandStates);
	    
	 
 } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateCountriesandStates(InternationalModel internationalModel) {
	
	int status = 0;
	Map<String, Object> updateCountriesandStates= new LinkedHashMap<>();
	try {
	
	String updateStateQuery = "update state set description=:description,country=:country,currency=:currency,country_code2=:country_code2,phonefmt=:phonefmt,zipfmt=:zipfmt,addr_prefix=:addr_prefix,suppress_issues=:suppress_issues,foreign_fld=:foreign_fld"
			+ "  where state = '" +internationalModel.getState()+"'";
	//updateCountriesandStates.put("label_format",internationalModel.getLabelFormat());
	updateCountriesandStates.put("description",internationalModel.getDescription());
	updateCountriesandStates.put("country",internationalModel.getCounty());
	updateCountriesandStates.put("currency",internationalModel.getCurrency());
	updateCountriesandStates.put("country_code2",internationalModel.getCountryCode2());
	updateCountriesandStates.put("phonefmt",internationalModel.getPhoneFormat());
	updateCountriesandStates.put("zipfmt",internationalModel.getZipFormat());
	updateCountriesandStates.put("addr_prefix",internationalModel.getAddressPrefix());
	updateCountriesandStates.put("suppress_issues",internationalModel.getSuppressIssues());
	updateCountriesandStates.put("foreign_fld",internationalModel.getForeignId());
    status = namedParameterJdbcTemplate.update(updateStateQuery,updateCountriesandStates);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteCountriesandStates(String state) {
	int status = 0;
	try {

		StringBuilder deleteQuery=new StringBuilder("delete state from state S ");
		deleteQuery.append(" left join address on S.state= address.state");
		deleteQuery.append(" left join dist_method_default on S.state=dist_method_default.state");
		deleteQuery.append(" left join process_state  on  S.state=process_state.state");
		deleteQuery.append(" left join start_stop_address on S.state=start_stop_address.state");
		deleteQuery.append(" left join tax_rate_commodity on S.state=tax_rate_commodity.state");
		deleteQuery.append(" left join customer_address C on S.state=C.state ");
		deleteQuery.append(" left join dist_method_override  on S.state= dist_method_override.state");
		deleteQuery.append(" left join region_list_state  on S.state= region_list_state.state");
		deleteQuery.append(" left join sub_iss_hist_audit  on S.state= sub_iss_hist_audit.state");
		deleteQuery.append(" left join tax_rate_juris_commodity T  on S.state= T.state");
		deleteQuery.append(" left join dd_bank_def on S.state= dd_bank_def.state");
		deleteQuery.append(" left join jurisdiction on S.state= jurisdiction.state");
		deleteQuery.append(" left join  region_state on S.state=  region_state.state");
		deleteQuery.append(" left join tax_rate_basic on S.state= tax_rate_basic.state");
		deleteQuery.append(" left join vendor on S.state= vendor.state");
		deleteQuery.append(" left join del_method_default on S.state= del_method_default.state");
		deleteQuery.append(" left join order_item_amt_break on S.state= order_item_amt_break.state");
		deleteQuery.append(" left join  source_code_state on S.state=source_code_state.state");
		deleteQuery.append(" where S.state= '"+ state+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
	return status;
		
	
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getCountriesandStates(String state) {
	List<Map<String, Object>>  countriesandStatesDetails= new ArrayList<>();
	try {
		if(state!=null) {
		countriesandStatesDetails= jdbcTemplate.queryForList("select state,label_format,description,country,currency,country_code2,phonefmt,zipfmt,addr_prefix,suppress_issues,foreign_fld  from state where state='"+state+"'");
		}else {
			countriesandStatesDetails= jdbcTemplate.queryForList("select state,label_format,description,country,currency,country_code2,phonefmt,zipfmt,addr_prefix,suppress_issues,foreign_fld  from state");
		}
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  countriesandStatesDetails;
}
@Override
public List<DropdownModel> getCurrencyList() {
	List<DropdownModel> currencyList=new ArrayList<>();
	try {
		List<Map<String,Object>> currencyDetails=jdbcTemplate.queryForList("select currency,description,currency_symbol from currency");
		for(Map<String,Object> getCurrencyList:currencyDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getCurrencyList.get("currency").toString());
			model.setDescription(getCurrencyList.get("description").toString());
			model.setDisplay(getCurrencyList.get("currency_symbol").toString());
			currencyList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return currencyList;
     }



@Override
public List<DropdownModel> getCountryCodeList() {
	List<DropdownModel> countryCodeList=new ArrayList<>();
	try {
		List<Map<String,Object>> countryCodeDetails=jdbcTemplate.queryForList("select country_code2,country_name from country");
		for(Map<String,Object> getCountryCodeList:countryCodeDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getCountryCodeList.get("country_code2").toString());
			model.setDisplay(getCountryCodeList.get("country_name").toString());
			countryCodeList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return countryCodeList;
     }

@Override
public List<DropdownModel> getLabelFormatList() {
	List<DropdownModel> labelFormatList=new ArrayList<>();
	try {
		List<Map<String,Object>> labelFormatDetails=jdbcTemplate.queryForList("select label_group,description from label_group");
		for(Map<String,Object> getLabelFormatList:labelFormatDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getLabelFormatList.get("label_group").toString());
			model.setDisplay(getLabelFormatList.get("description").toString());
			labelFormatList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelFormatList;
     }

@Override
public List<DropdownModel> getaddressCheckingList() {
	List<DropdownModel> addressCheckingList=new ArrayList<>();
	try {
		List<Map<String,Object>> addressCheckingDetails=jdbcTemplate.queryForList("select iap_code,description from iap_dataset_def");
		for(Map<String,Object> getAddressCheckingList:addressCheckingDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(getAddressCheckingList.get("iap_code").toString());
			//model.setDescription(getCountryCodeList.get("country_name").toString());
			model.setDisplay(getAddressCheckingList.get("description").toString());
			addressCheckingList.add(model);
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return addressCheckingList;
     }

@Override
public int saveCurrencies(InternationalModel internationalModel) {
	int status = 0;
	
	try {
		Map<String, Object> addCurrencies = new LinkedHashMap<>();
		String  currenciesQuery = "insert into currency(currency,currency_symbol,description,exchange_rate,n_decimal_places,html_symbol,iso4217_num_code,change_date,user_code) " + "values(:currency,:currency_symbol,:description,:exchange_rate,:n_decimal_places,:html_symbol,:iso4217_num_code,:change_date,:user_code)";
		addCurrencies.put("currency",internationalModel.getCurrency());
		addCurrencies.put("currency_symbol",internationalModel.getCurrencySymbol());
		addCurrencies.put("description",internationalModel.getDescription());
		addCurrencies.put("exchange_rate",internationalModel.getExchangeRate());
		addCurrencies.put("n_decimal_places",internationalModel.getnDecimalPlaces());
		addCurrencies.put("html_symbol",internationalModel.getHtmlSymbol());
		addCurrencies.put("iso4217_num_code",internationalModel.getIso4217NumCode());
		addCurrencies.put("change_date",internationalModel.getChangeDate());
		addCurrencies.put("user_code",internationalModel.getUserCode());
	    status = namedParameterJdbcTemplate.update(currenciesQuery,addCurrencies);
	   
	    Map<String, Object> addCurrencyRateBudget = new LinkedHashMap<>();
	    String  currencyRateBudgetQuery = "insert into currency_rate_budget(currency,from_date,exchange_rate)" + " values(:currency,:from_date,:exchange_rate)";
	    addCurrencyRateBudget.put("currency",internationalModel.getCurrency());
	    addCurrencyRateBudget.put("from_date",internationalModel.getFromDate());
	    addCurrencyRateBudget.put("exchange_rate",internationalModel.getExchangeRate());
	    
	    status = namedParameterJdbcTemplate.update(currencyRateBudgetQuery,addCurrencyRateBudget);
	    
	    
	    
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateCurrencies(InternationalModel internationalModel) {
	int status = 0;
	
	
	try {
	Map<String, Object> updateCurrencies= new LinkedHashMap<>();
	String updateCurrenciesQuery = "update currency set currency_symbol=:currency_symbol,description=:description,exchange_rate=:exchange_rate,n_decimal_places=:n_decimal_places,html_symbol=:html_symbol,iso4217_num_code=:iso4217_num_code,change_date=:change_date,user_code=:user_code  where currency = '" +internationalModel.getCurrency()+"'";
	//updateCurrencies.put("currency",internationalModel.getCurrency());
	updateCurrencies.put("currency_symbol",internationalModel.getCurrencySymbol());
	updateCurrencies.put("description",internationalModel.getDescription());
	updateCurrencies.put("exchange_rate",internationalModel.getExchangeRate());
	updateCurrencies.put("n_decimal_places",internationalModel.getnDecimalPlaces());
	updateCurrencies.put("html_symbol",internationalModel.getHtmlSymbol());
	updateCurrencies.put("iso4217_num_code",internationalModel.getIso4217NumCode());
	updateCurrencies.put("change_date",internationalModel.getChangeDate());
	updateCurrencies.put("user_code",internationalModel.getUserCode());
	
    status = namedParameterJdbcTemplate.update(updateCurrenciesQuery,updateCurrencies);
    Map<String, Object> updateCurrencyRateBudget= new LinkedHashMap<>();
    String updateCurrencyRateBudgetQuery = "update currency_rate_budget set from_date=:from_date,exchange_rate=:exchange_rate where currency= '"+internationalModel.getCurrency()+"'";
    updateCurrencyRateBudget.put("currency",internationalModel.getCurrency());
    updateCurrencyRateBudget.put("from_date",internationalModel.getFromDate());
    updateCurrencyRateBudget.put("exchange_rate",internationalModel.getExchangeRate());
    
    status = namedParameterJdbcTemplate.update(updateCurrencyRateBudgetQuery,updateCurrencyRateBudget);
    
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteCurrencies(String currency) {
	int status = 0;
	try {

		StringBuilder deleteQuery=new StringBuilder("delete currency from currency C ");
		deleteQuery.append(" left join bank_account on C.currency= bank_account.currency");
		deleteQuery.append(" left join discount_card on C.currency= discount_card.currency");
		deleteQuery.append(" left join order_item on C.currency= order_item.currency");
		deleteQuery.append(" left join  ratecard on C.currency= ratecard.currency");
		deleteQuery.append(" left join voucher on C.currency= voucher.currency");
		deleteQuery.append(" left join config on C.currency= config.currency");
		deleteQuery.append(" left join edit_trail on C.currency=edit_trail.currency");
		deleteQuery.append(" left join payment on C.currency= payment.currency");
		deleteQuery.append(" left join  renewal_history on C.currency=  renewal_history.currency");
		deleteQuery.append(" left join work_promotion_offer on C.currency= work_promotion_offer.currency");
		deleteQuery.append(" left join currency_history on C.currency=  currency_history.currency");
		deleteQuery.append(" left join ics_bank_def_currency on C.currency= ics_bank_def_currency.currency");
		deleteQuery.append(" left join  pending_xaction on C.currency=  pending_xaction.currency");
		deleteQuery.append(" left join  source_code on C.currency= source_code.currency");
		//deleteQuery.append(" left join  work_renewal_offer on C.currency=  work_renewal_offer.currency");
		deleteQuery.append(" left join  currency_rate_budget on C.currency=currency_rate_budget.currency");
		deleteQuery.append(" left join  ics_response on C.currency=ics_response.currency");
		deleteQuery.append(" left join  pending_xaction_header on C.currency=pending_xaction_header.currency");
		deleteQuery.append(" left join  state on C.currency=state.currency");
		deleteQuery.append(" left join  work_table_payment on C.currency= work_table_payment.currency");
		//deleteQuery.append("left join  delivery_method on C.currency=delivery_method.currency");
		deleteQuery.append(" left join  multi_disc_sched_dtl on C.currency=multi_disc_sched_dtl.currency");
		deleteQuery.append(" left join  process_currency_relator on C.currency=process_currency_relator.currency");
		deleteQuery.append(" left join  sub_iss_hist_audit on C.currency=sub_iss_hist_audit.currency");
		deleteQuery.append(" where C.currency = '"+currency+"'");
		
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
	return status;
		
	
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}


@Override
public List<Map<String, Object>> getCurrencies(String currency) {
	List<Map<String, Object>>  currenciesDetails= new ArrayList<>();

	try {
		if(currency!=null) {
		currenciesDetails= jdbcTemplate.queryForList("select currency,currency_symbol,description,exchange_rate,n_decimal_places,html_symbol,iso4217_num_code,change_date,user_code from currency where currency='"+currency+"'");
	    
		//currenciesDetails= jdbcTemplate.queryForList("select currency.currency,currency.description,currency.currency_symbol,currency.change_date,currency.n_decimal_places,currency.currency_symbol,currency.html_symbol,currency.user_code,currency_rate_budget.from_date "
			//	+ " from currency  inner join currency_rate_budget on currency.currency=currency_rate_budget.currency");
		}else {
			currenciesDetails= jdbcTemplate.queryForList("select currency,currency_symbol,description,exchange_rate,n_decimal_places,html_symbol,iso4217_num_code,change_date,user_code from currency ");
		}
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  currenciesDetails;
}

@Override
public int saveLanguageCodes(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> addLanguageCodes = new LinkedHashMap<>();
	try {
		
		String  languageCodesQuery = "insert into language_code(language_code,description) " + "values(:language_code,:description)";
		addLanguageCodes.put("language_code",internationalModel.getLanguageCode());
		addLanguageCodes.put("description",internationalModel.getDescription());
		
	    status = namedParameterJdbcTemplate.update(languageCodesQuery,addLanguageCodes);
	    
	 
 } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateLanguageCodes(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> updateLanguageCodes= new LinkedHashMap<>();
	try {
	
	String updateLanguageCodesQuery = "update language_code set description=:description where language_code = '" +internationalModel.getLanguageCode()+"'";
	updateLanguageCodes.put("description",internationalModel.getDescription());
	updateLanguageCodes.put("language_code",internationalModel.getLanguageCode());
	status = namedParameterJdbcTemplate.update(updateLanguageCodesQuery,updateLanguageCodes);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteLanguageCodes(String languageCode) {
	int status = 0;
	try {

		String  deleteLanguageCodes= "delete from language_code  where language_code= '" +languageCode+"'";
		status = jdbcTemplate.update(deleteLanguageCodes);
		
} catch (Exception e) {   
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getLanguageCodes(String languageCode) {
	List<Map<String, Object>>  LanguageCodesDetails= new ArrayList<>();
	try {
		if(languageCode!=null) {
		
		 LanguageCodesDetails= jdbcTemplate.queryForList("select language_code,description from language_code where language_code='"+languageCode+"'");
		}else {
			 LanguageCodesDetails= jdbcTemplate.queryForList("select language_code,description from language_code");
		}
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return   LanguageCodesDetails;
}

@Override
public int saveRegions(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> addRegions = new LinkedHashMap<>();
	try {
		
		String  regionListQuery = "insert into region_list(region_list,description) " + "values(:region_list,:description)";
		addRegions.put("region_list",internationalModel.getRegionList());
		addRegions.put("description",internationalModel.getDescription());
		status = namedParameterJdbcTemplate.update(regionListQuery,addRegions);
	    
	 
 } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateRegions(InternationalModel internationalModel) {
	int status = 0;
	Map<String, Object> updateRegions= new LinkedHashMap<>();
	try {
	
	String updateRegionsQuery = "update region_list set description=:description where region_list = '" +internationalModel.getRegionList()+"'";
	 updateRegions.put("description",internationalModel.getDescription());
	 updateRegions.put("language_code",internationalModel.getLanguageCode());
	status = namedParameterJdbcTemplate.update(updateRegionsQuery,updateRegions);
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteRegions(String regionList) {
	int status = 0;
	try {

		StringBuilder deleteQuery = new StringBuilder("delete region_list from region_list R ");
		//deleteQuery.append(" left join config on R.region_list=config.region_list");
		deleteQuery.append(" left join discount_class on R.region_list=discount_class.region_list");
		deleteQuery.append(" left join volume_group_regions V  on R.region_list=V.region_list");
		deleteQuery.append(" left join journal_volume_group J  on R.region_list=J.region_list");
		deleteQuery.append(" left join rate_class on R.region_list=rate_class.region_list");
		deleteQuery.append(" left join region_list_state  on R.region_list=region_list_state.region_list");
		deleteQuery.append(" left join delivery_method on R.region_list=delivery_method.region_list");
		deleteQuery.append(" left join distribution_method on R.region_list=distribution_method.region_list");
		deleteQuery.append(" left join pub on R.region_list=pub.region_list");
		deleteQuery.append(" left join region on R.region_list=region.region_list");
		deleteQuery.append(" where R.region_list= '"+ regionList+"'");
		try {
			status=jdbcTemplate.update(deleteQuery.toString());
		
		}catch(Exception e) {
			LOGGER.error(ERROR + e); 
		}
	return status;
		
} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getRegions(String regionList) {
	List<Map<String, Object>>  regionsDetails= new ArrayList<>();
	try {
		regionsDetails= jdbcTemplate.queryForList("select region_list,description from region_list where region_list='"+regionList+"'");
	
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  regionsDetails;
}





@Override
public List<Map<String, Object>> getAddressStatusDetails(String addressStatus) {
	List<Map<String,Object>> addressDetails=new ArrayList<>();
	try {
		 if(addressStatus!=null) {
		 addressDetails=jdbcTemplate.queryForList("select address_status,description,address_undeliverable from address_status where address_status='"+addressStatus+"'");
	}else {
		addressDetails=jdbcTemplate.queryForList("select address_status,description,address_undeliverable from address_status");
	}
	}
	catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	
	return addressDetails;
}

@Override
public List<Map<String, Object>> getAddressTypeDetails(String addressType) {
	List<Map<String,Object>> addressTypeDetails=new ArrayList<>();
	try {
		 if(addressType!=null) {
		addressTypeDetails=jdbcTemplate.queryForList("select address_type,description from address_type where address_type='"+addressType+"'");
		 }else {
			 addressTypeDetails=jdbcTemplate.queryForList("select address_type,description from address_type");
		 }

	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return addressTypeDetails;
}

@Override
public List<Map<String, Object>> getAttachmentCatagoryDetails(String attachmentCatagory) {
	List<Map<String,Object>> attachmentCatagoryDetails=new ArrayList<>();
	try {
		 if(attachmentCatagory!=null) {
		 	attachmentCatagoryDetails=jdbcTemplate.queryForList("select attachment_category,description from attachment_category where attachment_category='"+attachmentCatagory+"'");
		 }else {
			 attachmentCatagoryDetails=jdbcTemplate.queryForList("select attachment_category,description from attachment_category"); 
		 }

	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return attachmentCatagoryDetails;
}

@Override
public List<Map<String, Object>> getAuxFieldDetails(String tableName) {
	List<Map<String,Object>> auxFieldDetails=new ArrayList<>();
	try {
		 if(tableName!=null) {
		auxFieldDetails=jdbcTemplate.queryForList("select table_name,column_name,column_title,column_datatype,custsvc_edit_disposition from aux_field where table_name='"+tableName+"'");
		 }else {
			 auxFieldDetails=jdbcTemplate.queryForList("select table_name,column_name,column_title,column_datatype,custsvc_edit_disposition from aux_field"); 
		 }
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return auxFieldDetails;
}

@Override
public List<Map<String, Object>> getCreditStatusDetails(String creditStatus) {
	List<Map<String,Object>> creditStatusdDetails=new ArrayList<>();
	try {
		 if(creditStatus!=null) {
		creditStatusdDetails=jdbcTemplate.queryForList("select credit_status,description,bad_credit from credit_status where credit_status='"+creditStatus+"'");
		 }else {
			 creditStatusdDetails=jdbcTemplate.queryForList("select credit_status,description,bad_credit from credit_status"); 
		 }
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return creditStatusdDetails;
}

@Override
public List<Map<String, Object>> getRentalCategoryDetails(String listRentalCategory) {
	List<Map<String,Object>> rentalCategoryDetails=new ArrayList<>();
	try {
		if(listRentalCategory!=null) {
		rentalCategoryDetails=jdbcTemplate.queryForList("select list_rental_category,description,can_rent_name,can_rent_email_address from list_rental_category  where list_rental_category='"+listRentalCategory+"'");
		}else {
			rentalCategoryDetails=jdbcTemplate.queryForList("select list_rental_category,description,can_rent_name,can_rent_email_address from list_rental_category");	
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return rentalCategoryDetails;
}

@Override
public List<Map<String, Object>> getCustomerCategoryDetails(String customerCategory) {
	List<Map<String,Object>> customerCategoryDetails=new ArrayList<>();
	try {
		 if(customerCategory!=null) {
		customerCategoryDetails=jdbcTemplate.queryForList("select customer_category,description,active from customer_category  where customer_category='"+customerCategory+"'");
		 }else {
			 customerCategoryDetails=jdbcTemplate.queryForList("select customer_category,description,active from customer_category"); 
		 }
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return customerCategoryDetails;
}

@Override
public List<Map<String, Object>> getLoginQuestionDetails(int customerLoginQuestionId) {
	List<Map<String,Object>> loginQuestionDetails=new ArrayList<>();
	try { 
		if(customerLoginQuestionId!=0) {
		loginQuestionDetails=jdbcTemplate.queryForList("select customer_login_question_id,question,inactive from customer_login_question  where customer_login_question_id="+customerLoginQuestionId);
		}else {
		loginQuestionDetails=jdbcTemplate.queryForList("select customer_login_question_id,question,inactive from customer_login_question");
		}
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return loginQuestionDetails;
}

@Override
public List<Map<String, Object>> getProspectCategoryDetails(String prospectCategory) {
	List<Map<String,Object>> prospectCategoryDetails=new ArrayList<>();
	try {
		 if(prospectCategory!=null) {
		prospectCategoryDetails=jdbcTemplate.queryForList("select prospect_category,description from prospect_category  where prospect_category='"+prospectCategory+"'");
		 }else {
			 prospectCategoryDetails=jdbcTemplate.queryForList("select prospect_category,description from prospect_category"); 
		 }
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return prospectCategoryDetails;
}

@Override
public List<Map<String, Object>> getsalesRepresentativeDetails(int salesRepresentativeId) {
	List<Map<String,Object>> salesRepresentativeDetails=new ArrayList<>();
	try {
		 if(salesRepresentativeId!=0) {
		salesRepresentativeDetails=jdbcTemplate.queryForList("select sales_representative_id,sales_representative,inactive from sales_representative  where sales_representative_id="+salesRepresentativeId);
		 }else {
			 salesRepresentativeDetails=jdbcTemplate.queryForList("select sales_representative_id,sales_representative,inactive from sales_representative"); 
		 }
	}catch(Exception e) {
		LOGGER.error(ERROR + e); 
	}
	return salesRepresentativeDetails;
}

@Override
public List<DropdownModel> getDelivaryMethod() {
	List<Map<String, Object>> delivaryMethod = new ArrayList<>();
	List<DropdownModel> delivaryDataList = new ArrayList<>();
	try {
		delivaryMethod = jdbcTemplate.queryForList("select delivery_method,description from delivery_method ");
		for (Map<String, Object> dm : delivaryMethod) {
			DropdownModel model = new DropdownModel();
			model.setKey(dm.get("delivery_method").toString());
			model.setDisplay(dm.get("description") != null ? (String) dm.get("description") : "");
			delivaryDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return delivaryDataList;
}

@Override
public List<DropdownModel> getShippingPriceList() {
	List<Map<String, Object>> shippingPriceList = new ArrayList<>();
	List<DropdownModel> shippingPriceDataList = new ArrayList<>();
	try {
		shippingPriceList = jdbcTemplate.queryForList("select shipping_price_list,description from shipping_price_list ");
		for (Map<String, Object> sp: shippingPriceList) {
			DropdownModel model = new DropdownModel();
			model.setKey(sp.get("shipping_price_list").toString());
			model.setDisplay(sp.get("description") != null ? (String) sp.get("description") : "");
			shippingPriceDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return shippingPriceDataList;
}

@Override
public List<DropdownModel> getCancellationRenewal() {
	List<DropdownModel> cancellationRenewal = new ArrayList<>();
	try {
		for (int i = 0; i <= 1; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("do_cancel_credit_on_cancel" + i));
			cancellationRenewal.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return cancellationRenewal;
}

@Override
public List<DropdownModel> getAddressType() {
	List<Map<String, Object>> addressType = new ArrayList<>();
	List<DropdownModel> addressTypeDataList = new ArrayList<>();
	try {
		addressType = jdbcTemplate.queryForList("select address_type,description from address_type ");
		for (Map<String, Object> at: addressType) {
			DropdownModel model = new DropdownModel();
			model.setKey(at.get("address_type").toString());
			model.setDisplay(at.get("description") != null ? (String) at.get("description") : "");
			addressTypeDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return addressTypeDataList;
}

@Override
public List<DropdownModel> getAddressStatus() {
	List<Map<String, Object>> addressStatus = new ArrayList<>();
	List<DropdownModel> addressStatusDataList = new ArrayList<>();
	try {
		addressStatus = jdbcTemplate.queryForList("select address_status,description,address_undeliverable from address_status ");
		for (Map<String, Object> as: addressStatus) {
			DropdownModel model = new DropdownModel();
			model.setKey(as.get("address_status").toString());
			model.setDisplay(as.get("description") != null ? (String) as.get("description") : "");
			model.setDescription(as.get("address_undeliverable").toString());
			addressStatusDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return addressStatusDataList;
}

@Override
public List<DropdownModel> getCreditStatus() {
	List<Map<String, Object>> creditStatus = new ArrayList<>();
	List<DropdownModel> creditStatusDataList = new ArrayList<>();
	try {
		creditStatus = jdbcTemplate.queryForList("select credit_status,description,bad_credit from credit_status ");
		for (Map<String, Object> cs: creditStatus) {
			DropdownModel model = new DropdownModel();
			model.setKey(cs.get("credit_status").toString());
			model.setDisplay(cs.get("description") != null ? (String) cs.get("description") : "");
			model.setDescription(cs.get("bad_credit").toString());
			creditStatusDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return creditStatusDataList;
}

@Override
public List<DropdownModel> getRentalCategory() {
	List<Map<String, Object>> rentalCategory = new ArrayList<>();
	List<DropdownModel> rentalCategoryDataList = new ArrayList<>();
	try {
		rentalCategory = jdbcTemplate.queryForList("select list_rental_category,description from list_rental_category ");
		for (Map<String, Object> at: rentalCategory) {
			DropdownModel model = new DropdownModel();
			model.setKey(at.get("list_rental_category").toString());
			model.setDisplay(at.get("description") != null ? (String) at.get("description") : "");
			rentalCategoryDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return rentalCategoryDataList;
}

@Override
public List<DropdownModel> getOperatorDetails() {
	List<Map<String, Object>> operator = new ArrayList<>();
	List<DropdownModel> operatorDataList = new ArrayList<>();
	try {
		operator = jdbcTemplate.queryForList("select user_code,name from user_code ");
		for (Map<String, Object> op: operator) {
			DropdownModel model = new DropdownModel();
			model.setKey(op.get("user_code").toString());
			model.setDisplay(op.get("name") != null ? (String) op.get("description") : "");
			operatorDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return operatorDataList;
}

@Override
public List<DropdownModel> getbacthTemplateDetails() {
	List<Map<String, Object>> batchTemplate = new ArrayList<>();
	List<DropdownModel> batchTemplateDataList = new ArrayList<>();
	try {
		batchTemplate = jdbcTemplate.queryForList("select batch_template,description from batch_template ");
		for (Map<String, Object> bt: batchTemplate) {
			DropdownModel model = new DropdownModel();
			model.setKey(bt.get("batch_template").toString());
			model.setDisplay(bt.get("description") != null ? (String) bt.get("description") : "");
			batchTemplateDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return batchTemplateDataList;
}

@Override
public List<Map<String, Object>> getDocumentReferenceDetails() {
	List<Map<String, Object>> documentReferenceDetails = new ArrayList<>();
	try {
		documentReferenceDetails=jdbcTemplate.queryForList("select D.document_reference_id,D.description,D.type,P.pending_xaction_header_id,P.creator_user_code,P.creation_date,P.batch_template,P.assigned_to_user_code,P.xamt_pay,P.amt_pay from document_reference D "
				+ "inner join pending_xaction_header P on D.document_reference_id=P.document_reference_id ");
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return documentReferenceDetails;
}

@Override
public List<DropdownModel> getType() {
	List<DropdownModel> typeDetails=new ArrayList<>();
	for(int i=0;i<=4;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("type"+i));
		typeDetails.add(model);
	}
	return typeDetails;
}

@Override
public int saveDocumentReference(DefaultSettings defaultSettings) {
	
	int status=0;
	String maxId=null;
	Map<String,Object> addParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("insert into document_reference(document_reference_id,description,active,user_code,type) values(:document_reference_id,:description,:active,:user_code,:type)");
	try {
		maxId=jdbcTemplate.queryForObject("select max(id) from mru_document_reference_id", String.class);
		if(maxId==null) {
			addParams.put("document_reference_id",1);
		}else {
			addParams.put("document_reference_id",Integer.parseInt(maxId)+1);

		}
		addParams.put("description",defaultSettings.getDescription());
		addParams.put("type",0);
		addParams.put("active",defaultSettings.getActive());
		addParams.put("user_code",defaultSettings.getUserCode());
		addParams.put("bypass_doc_ref_dlg",defaultSettings.getBypassDocRefDlg());

		status=namedParameterJdbcTemplate.update(query.toString(), addParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateDocumentReference(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update document_reference set description=:description,active=:active,type=:type where document_reference_id="+defaultSettings.getDocumentReferenceId());
	try {
		updateParams.put("description",defaultSettings.getDescription());
		updateParams.put("active",defaultSettings.getActive());
		updateParams.put("type",0);

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int saveEditTrail(DefaultSettings defaultSettings) {

	int status=0;
	String maxId=null;
	Map<String,Object> addParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("insert into edit_trail(document_reference_id,edit_trail_id,customer_id,user_code,base_amount,xaction_name,creation_date,payment_seq,date_stamp) "
											+ "values(:document_reference_id,:edit_trail_id,:customer_id,:user_code,:base_amount,:xaction_name,:creation_date,:payment_seq,:date_stamp)");
	try {
		maxId=jdbcTemplate.queryForObject("select max(id) from mru_edit_trail_id", String.class);
		if(maxId==null) {
			addParams.put("edit_trail_id",1);
		}else {
			addParams.put("edit_trail_id",Integer.parseInt(maxId)+1);

		}
		addParams.put("document_reference_id",defaultSettings.getDocumentReferenceId());
		addParams.put("customer_id",defaultSettings.getCustomerId());
		addParams.put("base_amount",defaultSettings.getBaseAmount());
		addParams.put("user_code",defaultSettings.getUserCode());
		addParams.put("xaction_name",defaultSettings.getXactionName());
		String value1=defaultSettings.getCreationDate();
		Date outSDF = new SimpleDateFormat("yyyy-mm-dd").parse(value1);
		addParams.put("creation_date",outSDF);
		addParams.put("creation_date",outSDF);
		addParams.put("payment_seq",defaultSettings.getPaymentSeq());
		addParams.put("date_stamp",defaultSettings.getValueStamp());

		status=namedParameterJdbcTemplate.update(query.toString(), addParams);
		new CustomerUtility().updateMruEditTrailId(Long.valueOf(maxId));
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}return status;
}

@Override
public List<Map<String, Object>> getEditTrailDetails(int documentReferenceId) {
	List<Map<String, Object>> editTrailDetails = new ArrayList<>();
	try {
		editTrailDetails=jdbcTemplate.queryForList("select document_reference_id,edit_trail_id, customer_id,user_code,base_amount,xaction_name,creation_date,payment_seq,"
				+ "date_stamp from edit_trail where document_reference_id="+documentReferenceId);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return editTrailDetails;
}

@Override
public List<Map<String, Object>> getEditTrail(int documentReferenceId) {
	List<Map<String, Object>> editTrailDetails = new ArrayList<>();
	try {
		editTrailDetails=jdbcTemplate.queryForList("select document_reference_id,edit_trail_id, edited,user_code,table_enum,xaction_name,creation_date,column_name,"
				+ "before_change,after_change from view_edit_hist where document_reference_id="+documentReferenceId);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return editTrailDetails;
}

@Override
public List<Map<String, Object>> getPaymentBreakdown(int paymentSeq,int customerId) {
	List<Map<String, Object>> paytBreakDetails = new ArrayList<>();
	try {
		paytBreakDetails=jdbcTemplate.queryForList("select payment_seq,orderhdr_id, customer_id,paybreak_type,local_amount,ocurrency,pcurrency,bogus_commission,base_amount,"
				+ "pay_currency_amount from view_paybreak_oibreak where payment_seq="+paymentSeq+" and customer_id="+customerId);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return paytBreakDetails;
}

@Override
public List<DropdownModel> getShipType() {
	List<DropdownModel> shipeType=new ArrayList<>();
	for(int i=1;i<=5;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("ship_type"+i));
		shipeType.add(model);
	}
	return shipeType;
}

@Override
public List<DropdownModel> getBackIssueShipType() {
	List<DropdownModel> backIssueShiptype=new ArrayList<>();
		for(int i=0;i<=1;i++) {
			DropdownModel model=new DropdownModel();
			model.setKey(""+i);
			model.setDisplay(new PropertyUtils().getConstantValue("back_issue_ship_type"+i));
			backIssueShiptype.add(model);
		}
	return backIssueShiptype;
}

@Override
public List<DropdownModel> getNewmemberOptions() {
	List<DropdownModel> newMemberOptions=new ArrayList<>();
	for(int i=0;i<=3;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("new_group_member_action"+i));
		newMemberOptions.add(model);
	}
	return newMemberOptions;
}

@Override
public List<Map<String, Object>> getAccountingDetails(String currency) {
	List<Map<String,Object>> accountingDetails=new ArrayList<>();
	try {if(currency!=null) {
		accountingDetails=jdbcTemplate.queryForList("select F.currency,C.description,F.earn_by_issue_date,F.prod_si_rev_at_fulfillment,F.unit_electr_rev_at_fulfillment,F.earn_time_based_through_eom,"
				+ "F.bcp_sqlldr_timeout_min,F.dflt_do_cncl_cr_on_cncl from config F join currency C on F.currency=C.currency where F.currency='"+currency+"'");
	}else {
		accountingDetails=jdbcTemplate.queryForList("select F.currency,C.description,F.earn_by_issue_date,F.prod_si_rev_at_fulfillment,F.unit_electr_rev_at_fulfillment,F.earn_time_based_through_eom,"
				+ "F.bcp_sqlldr_timeout_min,F.dflt_do_cncl_cr_on_cncl from config join currency C");
	}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return accountingDetails;
}

@Override
public List<DropdownModel> getPaymentThreshold() {
	List<Map<String, Object>> paymentThreshold = new ArrayList<>();
	List<DropdownModel> paymentDataList = new ArrayList<>();
	try {
		paymentThreshold = jdbcTemplate.queryForList("select payment_threshold,description from payment_threshold ");
		for (Map<String, Object> pt: paymentThreshold) {
			DropdownModel model = new DropdownModel();
			model.setKey(pt.get("payment_threshold").toString());
			model.setDisplay(pt.get("description") != null ? (String) pt.get("description") : "");
			paymentDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return paymentDataList;
}

@Override
public List<DropdownModel> getDefaultPayType() {
	List<Map<String, Object>> defaultPaytype = new ArrayList<>();
	List<DropdownModel> defaultPaytypeDataList = new ArrayList<>();
	try {
		defaultPaytype = jdbcTemplate.queryForList("select payment_type,description from payment_type ");
		for (Map<String, Object> dp: defaultPaytype) {
			DropdownModel model = new DropdownModel();
			model.setKey(dp.get("payment_type").toString());
			model.setDisplay(dp.get("description") != null ? (String) dp.get("description") : "");
			defaultPaytypeDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}return defaultPaytypeDataList;
}

@Override
public List<DropdownModel> getRefundPaytype(String paymentType) {
	List<Map<String, Object>> refundPaytype = new ArrayList<>();
	List<DropdownModel> refundPaytypeDataList = new ArrayList<>();
	try {
		refundPaytype = jdbcTemplate.queryForList("select payment_type,description from payment_type where payment_type='"+paymentType+"'");
		for (Map<String, Object> ren: refundPaytype) {
			DropdownModel model = new DropdownModel();
			model.setKey(ren.get("payment_type").toString());
			model.setDisplay(ren.get("description") != null ? (String) ren.get("description") : "");
			refundPaytypeDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}return refundPaytypeDataList;
}

@Override
public List<DropdownModel> getHoldForPayment() {
	List<DropdownModel> holdForPayment=new ArrayList<>();
	for(int i=0;i<=3;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("payment_clear_status"+i));
		holdForPayment.add(model);
	}
	return holdForPayment;
}

@Override
public List<DropdownModel> getEncryptorCOM(String purposeCode) {
	List<Map<String, Object>> encryptorCom = new ArrayList<>();
	List<DropdownModel>encryptorComDataList = new ArrayList<>();
	try {
		encryptorCom = jdbcTemplate.queryForList("select com_progid,description from com_progid where purpose_code='"+purposeCode+"'");
		for (Map<String, Object> en: encryptorCom) {
			DropdownModel model = new DropdownModel();
			model.setKey(en.get("com_progid").toString());
			model.setDisplay(en.get("description") != null ? (String) en.get("description") : "");
			encryptorComDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return encryptorComDataList;
}

@Override
public List<Map<String, Object>> getVertexDetails() {
	List<Map<String,Object>> vertexLegalDetails=new ArrayList<>();
	try {
		vertexLegalDetails=jdbcTemplate.queryForList("select vrtx_legal_entity_id,description,entity_code,admin_origin_address_id,primary_shipping_address_id,trusted_id from vrtx_legal_entity ");
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return vertexLegalDetails;
	
}

@Override
public int legalEntitySave(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> addParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("insert into vrtx_tax_regions(ship_to_region,bill_to_region,vrtx_legal_entity_id,region_list)"
			+ "values(:ship_to_region,:bill_to_region,:vrtx_legal_entity_id,:region_list)");
	try {
		addParams.put("ship_to_region",defaultSettings.getShiptoRegion());
		addParams.put("bill_to_region",defaultSettings.getBilltoRegion());
		addParams.put("vrtx_legal_entity_id",defaultSettings.getVrtxLegalEntityId());
		addParams.put("region_list",defaultSettings.getRegionList());

		status=namedParameterJdbcTemplate.update(query.toString(), addParams);


	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getLegalEntityDetails() {
	List<Map<String,Object>> legalEntityDetails=new ArrayList<>();
	try {
		legalEntityDetails=jdbcTemplate.queryForList("select ship_to_region,bill_to_region,vrtx_legal_entity_id from vrtx_tax_regions");
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return legalEntityDetails;
}

@Override
public List<DropdownModel> getShiptoRegion() {
	List<DropdownModel> shipRegionDataList=new ArrayList<>();
	List<Map<String,Object>> shipRegion=new ArrayList<>();
	try {
		shipRegion=jdbcTemplate.queryForList("select region,description from region");
		for(Map<String,Object> sr:shipRegion) {
			DropdownModel model=new DropdownModel();
			model.setKey(sr.get("region").toString());
			model.setDisplay(sr.get("description") != null ? (String) sr.get("description") : "");
			shipRegionDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return shipRegionDataList;
}

@Override
public int saveLegalEntity(DefaultSettings defaultSettings) {
	int status=0;
	Integer maxId=null;
	Map<String,Object> addParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("insert into vrtx_legal_entity(vrtx_legal_entity_id,entity_code,description,admin_origin_address_id,primary_shipping_address_id,trusted_id)"
			+ "values(:vrtx_legal_entity_id,:entity_code,:description,:admin_origin_address_id,:primary_shipping_address_id,:trusted_id)");
	try {
		maxId=jdbcTemplate.queryForObject("select max(id) from mru_vrtx_legal_entity_id", Integer.class);
		if(maxId==null) {
			addParams.put("vrtx_legal_entity_id",1);
		}else {
			addParams.put("vrtx_legal_entity_id",maxId+1);

		}
		addParams.put("entity_code",defaultSettings.getEntityCode());
		addParams.put("description",defaultSettings.getDescription());
		addParams.put("admin_origin_address_id",defaultSettings.getAdminOriginAddressId());
		addParams.put("primary_shipping_address_id",defaultSettings.getPrimaryShippingAddressId());
		addParams.put("trusted_id",defaultSettings.getTrustedId());
		
		status=namedParameterJdbcTemplate.update(query.toString(), addParams);


	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getPaymentThresholdDetails(String paymentThreshold) {
	List<Map<String,Object>> paymentThresholdDetails=new ArrayList<>();
	try {
		if(paymentThreshold!=null) {
		paymentThresholdDetails=jdbcTemplate.queryForList("select payment_threshold,description,percent_under,percent_over,percent_refund,max_under_under,max_under_full,max_over_over,max_over_full,on_under_payment,under_payment_notify,on_over_payment,over_payment_notify from payment_threshold where payment_threshold='"+paymentThreshold+"'");
		}else {
			paymentThresholdDetails=jdbcTemplate.queryForList("select payment_threshold,description,percent_under,percent_over,percent_refund,max_under_under,max_under_full,max_over_over,max_over_full,on_under_payment,under_payment_notify,on_over_payment,over_payment_notify from payment_threshold");	
		}
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}

	return paymentThresholdDetails;
}

@Override
public List<Map<String, Object>> getPaymentTypeDetails(String paymentType) {
	List<Map<String,Object>> paymentTypeDetails=new ArrayList<>();
	try {
		if(paymentType!=null) {
		paymentTypeDetails=jdbcTemplate.queryForList("select payment_type,description,payment_form,realize_cash_when,use_as_default,card_verification_usage from payment_type where payment_type='"+paymentType+"'");
		}else {
			paymentTypeDetails=jdbcTemplate.queryForList("select payment_type,description,payment_form,realize_cash_when,use_as_default,card_verification_usage from payment_type");	
		}
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return paymentTypeDetails;
}

@Override
public List<DropdownModel> getPaymentForm() {
	List<DropdownModel> PaymentForm=new ArrayList<>();
	for(int i=0;i<=7;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("payment_form"+i));
		PaymentForm.add(model);
	}
	return PaymentForm;
}

@Override
public List<DropdownModel> getRealizeCashwhen() {
	List<DropdownModel> realizeCahwhen=new ArrayList<>();
	for(int i=0;i<=3;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("realize_cash_when"+i));
		realizeCahwhen.add(model);
	}
	return realizeCahwhen;
}

@Override
public List<DropdownModel> getCreditCardType() {
	List<DropdownModel> creditCardType=new ArrayList<>();
	for(int i=0;i<=8;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("credit_card_type"+i));
		creditCardType.add(model);
	}
	return creditCardType;
}

@Override
public List<DropdownModel> getCardVerificationusage() {
	List<DropdownModel> cardVerificationUsage=new ArrayList<>();
	for(int i=0;i<=2;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("card_verification_usage"+i));
		cardVerificationUsage.add(model);
	}
	return cardVerificationUsage;
}

@Override
public List<Map<String, Object>> getTransreasonDetails(String transactionReason) {
	List<Map<String,Object>> transactionreasonDetails=new ArrayList<>();
		try {
			transactionreasonDetails=jdbcTemplate.queryForList("select transaction_reason,description,reason_type from transaction_reason where transaction_reason='"+transactionReason+"'");
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	return transactionreasonDetails;
}

@Override
public List<DropdownModel> getTransreasonReasonType() {
	List<DropdownModel> transactionReasonType=new ArrayList<>();
	for(int i=0;i<=9;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("card_verification_usage"+i));
		transactionReasonType.add(model);
	}
	return transactionReasonType;
}

@Override
public int updateLegalEntity(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update vrtx_legal_entity set description=:description,entity_code=:entity_code,trusted_id=:trusted_id where vrtx_legal_entity_id="+defaultSettings.getVrtxLegalEntityId());
	try {
		updateParams.put("description",defaultSettings.getDescription());
		updateParams.put("entity_code",defaultSettings.getEntityCode());
		updateParams.put("trusted_id",defaultSettings.getTrustedId());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteLegalEntity(int vrtxLegalEntityId,String shiptoRegion) {

	int status=0;
	try {
		StringBuilder deleteQuery1=new StringBuilder("delete from vrtx_tax_regions where ship_to_region='"+shiptoRegion+"' and vrtx_legal_entity_id="+vrtxLegalEntityId);
		status = jdbcTemplate.update(deleteQuery1.toString());

		StringBuilder deleteQuery=new StringBuilder("delete from vrtx_legal_entity where vrtx_legal_entity_id="+vrtxLegalEntityId);
		status = jdbcTemplate.update(deleteQuery.toString());
		

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}return status;
	
}

@Override
public List<Map<String, Object>> getEntityDetails(int vrtxLegalEntityId) {
	List<Map<String,Object>> entityDetails=new ArrayList<>();
	try {
		entityDetails=jdbcTemplate.queryForList("select vrtx_legal_entity_id,entity_code,description,admin_origin_address_id,primary_shipping_address_id,trusted_id from vrtx_legal_entity where vrtx_legal_entity_id="+vrtxLegalEntityId);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
		
	return entityDetails;
}

@Override
public List<DropdownModel> getAdministrativeAddress() {
	List<DropdownModel> adminAddressDataList=new ArrayList<>();
	List<Map<String,Object>> adminAddressList=new ArrayList<>();
	try {
		adminAddressList=jdbcTemplate.queryForList("select address_id,CONCAT(address1,' ,',city,' ,',county,' ,',zip) as description from address");
		for(Map<String,Object> ad:adminAddressList) {
			DropdownModel model=new DropdownModel();
			model.setKey(ad.get("address_id").toString());
			model.setDisplay(ad.get("description") != null ? (String) ad.get("description") : "");
			adminAddressDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return adminAddressDataList;
}

@Override
public int updateTax(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set vrtx_invoice_free_orders=:vrtx_invoice_free_orders,vrtx_invoice_agent_orders=:vrtx_invoice_agent_orders,"
			+ "vrtx_invoice_custs_with_tax_id=:vrtx_invoice_custs_with_tax_id,enable_vrtx_tax_calculation=:enable_vrtx_tax_calculation where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("vrtx_invoice_free_orders",defaultSettings.getVrtxInvoiceFreeOrders());
		updateParams.put("vrtx_invoice_agent_orders",defaultSettings.getVrtxInvoiceAgentOrders());
		updateParams.put("vrtx_invoice_custs_with_tax_id",defaultSettings.getVrtxInvoiceCustswithTaxId());
		updateParams.put("enable_vrtx_tax_calculation",defaultSettings.getEnableVrtxTax());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateTaxDef(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set dflt_recalc_tax_on_xfer=:dflt_recalc_tax_on_xfer,recalc_tax_xfer_override=:recalc_tax_xfer_override,"
			+ "enable_vrtx_tax_calculation=:enable_vrtx_tax_calculation  where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("dflt_recalc_tax_on_xfer",defaultSettings.getDfltRecalcTaxonXfer());
		updateParams.put("recalc_tax_xfer_override",defaultSettings.getRecalcTaxXferOverride());
		updateParams.put("enable_vrtx_tax_calculation",defaultSettings.getEnableVrtxTax());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getCheckValues() {
	List<Map<String,Object>> checkValuesDetails=new ArrayList<>();
	try {
		checkValuesDetails=jdbcTemplate.queryForList("select vrtx_invoice_free_orders,vrtx_invoice_agent_orders,vrtx_invoice_custs_with_tax_id,dflt_recalc_tax_on_xfer,recalc_tax_xfer_override from config");
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
		
	return checkValuesDetails;
}

@Override
public int deleteTaxLegalEntity(String region) {

	int status=0;
	try {
		StringBuilder deleteQuery=new StringBuilder("delete from vrtx_tax_regions where bill_to_region='"+region+"'");
		status = jdbcTemplate.update(deleteQuery.toString());
		

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getCustomersDetails(String currency) {
	List<Map<String,Object>> customerDetails=new ArrayList<>();
	try {
		if(currency!=null) {
		customerDetails=jdbcTemplate.queryForList("select enable_upsell,filter_sc_search_in_ocsc_dlg,use_alt_ship_price_tax_del,auth_new_credit_card_info,ignore_avs,force_credit_card_email,suppress_avs_on_edit,phonefmt,zipfmt,"
				+ "tie_inactive_to_inputdone,skip_oip,skip_ocsc,always_send_backissues,generate_ons_offs,generate_starts_stops,use_custom_start_on_reinstate,ip_address_overlap_warnings,"
				+ " bypass_doc_ref_dlg,reset_xrate_on_prof_removal,send_backissues from config where currency='"+currency+"'");
		}else {
			customerDetails=jdbcTemplate.queryForList("select enable_upsell,filter_sc_search_in_ocsc_dlg,use_alt_ship_price_tax_del,auth_new_credit_card_info,ignore_avs,force_credit_card_email,suppress_avs_on_edit,phonefmt,zipfmt,"
					+ "tie_inactive_to_inputdone,skip_oip,skip_ocsc,always_send_backissues,generate_ons_offs,generate_starts_stops,use_custom_start_on_reinstate,ip_address_overlap_warnings,"
					+ " bypass_doc_ref_dlg,reset_xrate_on_prof_removal,send_backissues from config");
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return customerDetails;
}

@Override
public int updateDefaultCustomerUpdate(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set enable_upsell=:enable_upsell,filter_sc_search_in_ocsc_dlg=:filter_sc_search_in_ocsc_dlg,use_alt_ship_price_tax_del=:use_alt_ship_price_tax_del,auth_new_credit_card_info=:auth_new_credit_card_info,ignore_avs=:ignore_avs,"
			+ "force_credit_card_email=:force_credit_card_email,suppress_avs_on_edit=:suppress_avs_on_edit,phonefmt=:phonefmt,zipfmt=:zipfmt,tie_inactive_to_inputdone=:tie_inactive_to_inputdone,skip_oip=:skip_oip,skip_ocsc=:skip_ocsc,always_send_backissues=:always_send_backissues,"
			+ "generate_ons_offs=:generate_ons_offs,generate_starts_stops=:generate_starts_stops,use_custom_start_on_reinstate=:use_custom_start_on_reinstate,ip_address_overlap_warnings=:ip_address_overlap_warnings,reset_xrate_on_prof_removal=:reset_xrate_on_prof_removal,send_backissues=:send_backissues,"
			+ "bypass_doc_ref_dlg=:bypass_doc_ref_dlg  where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("enable_upsell",defaultSettings.getEnableUpsell());
		updateParams.put("filter_sc_search_in_ocsc_dlg",defaultSettings.getFilterScSearchInocscDlg());
		updateParams.put("use_alt_ship_price_tax_del",defaultSettings.getAltShipPriceTaxDel());
		updateParams.put("auth_new_credit_card_info",defaultSettings.getAuthNewCreditcardInfo());
		updateParams.put("ignore_avs",defaultSettings.getIgnoreAvs());
		updateParams.put("force_credit_card_email",defaultSettings.getForceCreditCardEmail());
		updateParams.put("suppress_avs_on_edit",defaultSettings.getSuppressAvsOnEdit());
		updateParams.put("phonefmt",defaultSettings.getPhonefmt());
		updateParams.put("zipfmt",defaultSettings.getZipfmt());
		updateParams.put("tie_inactive_to_inputdone",defaultSettings.getTieInactivetoInputdone());
		updateParams.put("skip_oip",defaultSettings.getSkipOip());
		updateParams.put("skip_ocsc",defaultSettings.getSkipOcsc());
		if(defaultSettings.getAlwaysSendBackissues().equals("0")) 
			updateParams.put("send_backissues",defaultSettings.getSendBackissues());

		updateParams.put("always_send_backissues",defaultSettings.getAlwaysSendBackissues());
		updateParams.put("generate_ons_offs",defaultSettings.getGenerateOnsOffs());
		updateParams.put("generate_starts_stops",defaultSettings.getGenerateStartsStops());
		updateParams.put("use_custom_start_on_reinstate",defaultSettings.getUseCustomStartonReinstate());
		updateParams.put("ip_address_overlap_warnings",defaultSettings.getIpAddressOverlapWarnings());
		updateParams.put("reset_xrate_on_prof_removal",defaultSettings.getResetXrateOnProfRemoval());
		updateParams.put("send_backissues",defaultSettings.getSendBackissues());
		updateParams.put("bypass_doc_ref_dlg",defaultSettings.getBypassDocRefDlg());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateAccounting(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set bcp_sqlldr_timeout_min=:bcp_sqlldr_timeout_min,dflt_do_cncl_cr_on_cncl=:dflt_do_cncl_cr_on_cncl,prod_si_rev_at_fulfillment=:prod_si_rev_at_fulfillment,"
			+ "earn_by_issue_date=:earn_by_issue_date,unit_electr_rev_at_fulfillment=:unit_electr_rev_at_fulfillment,earn_time_based_through_eom=:earn_time_based_through_eom where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("bcp_sqlldr_timeout_min",defaultSettings.getBcpsqldeTimeOutMin());
		updateParams.put("dflt_do_cncl_cr_on_cncl",defaultSettings.getDfltdoCnclcrOnCncl());
		updateParams.put("earn_by_issue_date",defaultSettings.getEarnByIssueDate());
		if(defaultSettings.getEarnByIssueDate().equals("1")) {
			LOGGER.info("Accounting period that currently includes the issue date");
		} else {
			LOGGER.info("OpenAccounting period");
			if(defaultSettings.getProdsiRevAtFullment().equals("1")) {
				LOGGER.info("Product and Single Issue At fullfillment");
			}else {
				LOGGER.info("Product and Single Issue At reconcilation");

			}
			}
		updateParams.put("prod_si_rev_at_fulfillment",defaultSettings.getProdsiRevAtFullment());
		
		if(defaultSettings.getProdsiRevAtFullment().equals("1")) {
			LOGGER.info("Product and Single Issue At fullfillment");
		}else {
			LOGGER.info("Product and Single Issue At reconcilation");

		}
		updateParams.put("unit_electr_rev_at_fulfillment",defaultSettings.getUnitElectrRevAtFulfillment());
		if(defaultSettings.getUnitElectrRevAtFulfillment().equals("1")) {
			LOGGER.info("Earn by Unit At usage");
		}else {
			LOGGER.info("Earn by Unit At reconcilation");

		}
		updateParams.put("earn_time_based_through_eom",defaultSettings.getEarnTimeBasedThroughEom());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getPaymentDetails(String currency) {
	List<Map<String,Object>> paymentDetails=new ArrayList<>(); 
	try {
		if(currency!=null) {
		paymentDetails=jdbcTemplate.queryForList("select credit_card_authorization,days_to_reauth,default_refund,use_deposit,bank_wizard_installed,pull_pay_start_for_cc,pull_payment_days,\r\n" + 
				"payment_start_interval,next_payment_interval,keep_id_nbr_last_four from config where currency='"+currency+"'");
		}else {
			paymentDetails=jdbcTemplate.queryForList("select credit_card_authorization,days_to_reauth,default_refund,use_deposit,bank_wizard_installed,pull_pay_start_for_cc,pull_payment_days,\r\n" + 
					"payment_start_interval,next_payment_interval,keep_id_nbr_last_four from config");	
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return paymentDetails;
}

@Override
public int updateDefaultPayment(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set credit_card_authorization=:credit_card_authorization,days_to_reauth=:days_to_reauth,default_refund=:default_refund,"
			+ "use_deposit=:use_deposit,bank_wizard_installed=:bank_wizard_installed,pull_pay_start_for_cc=:pull_pay_start_for_cc,pull_payment_days=:pull_payment_days,"
			+ "payment_start_interval=:payment_start_interval,next_payment_interval=:next_payment_interval,keep_id_nbr_last_four=:keep_id_nbr_last_four where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("credit_card_authorization",defaultSettings.getCreditCardAutherization());
		updateParams.put("days_to_reauth",defaultSettings.getDaystoReauth());
		updateParams.put("default_refund",defaultSettings.getDefaultrefund());
		if(defaultSettings.getDefaultrefund().equals("1")) {
			LOGGER.info("put Refund Into Deposit Account");
		}else {
			LOGGER.info("Refund to Customer");

		}
		updateParams.put("use_deposit",defaultSettings.getUseDeposit());
		if(defaultSettings.getUseDeposit().equals("1")) {
			LOGGER.info("Use deposit Account");
		}else {
			LOGGER.info("Make Payment Dialog");

		}
		updateParams.put("bank_wizard_installed",defaultSettings.getBankWizardInstalled());
		updateParams.put("pull_pay_start_for_cc",defaultSettings.getPullPayStartforCc());
		updateParams.put("pull_payment_days",defaultSettings.getPullPaymentDays());
		updateParams.put("payment_start_interval",defaultSettings.getPaymentStart());
		updateParams.put("next_payment_interval",defaultSettings.getNextPaymentInterval());
		updateParams.put("keep_id_nbr_last_four",defaultSettings.getKeepIdnbrLastFour());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	
}catch (Exception e) {
	LOGGER.error(ERROR + e);
}

	return status;

}

@Override
public List<Map<String, Object>> getInventoryDetails(String currency) {
	List<Map<String,Object>> inventoryDetails=new ArrayList<>();
	try {
		if(currency!=null) {
		inventoryDetails=jdbcTemplate.queryForList("select low_stock,low_sample_stock,enable_inventory_warnings,show_inventory_messages from config where currency='"+currency+"'");
		}else {
			inventoryDetails=jdbcTemplate.queryForList("select low_stock,low_sample_stock,enable_inventory_warnings,show_inventory_messages from config");	
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
		
	return inventoryDetails;
}

@Override
public int updateInventory(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set low_stock=:low_stock,low_sample_stock=:low_sample_stock,enable_inventory_warnings=:enable_inventory_warnings,"
			+ "show_inventory_messages=:show_inventory_messages  where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("low_stock",defaultSettings.getLowStock());
		updateParams.put("low_sample_stock",defaultSettings.getLowSampleStock());
		updateParams.put("enable_inventory_warnings",defaultSettings.getEnableInventoryWarnings());
		updateParams.put("show_inventory_messages",defaultSettings.getShowInventoryMessages());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getCustomFieldDetails(String currency) {
	List<Map<String,Object>> customFieldDetails=new ArrayList<>();;
	try {
		customFieldDetails=jdbcTemplate.queryForList("select custom_int1,custom_int2 from config where currency='"+currency+"'");
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return customFieldDetails;
}


@Override
public int updateCustomFields(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set custom_int1=:custom_int1,custom_int2=:custom_int2 where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("custom_int1",defaultSettings.getCustomInt1());
		updateParams.put("custom_int2",defaultSettings.getCustomInt2());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getLicenseCodeDetails(String lincenseCode) {
	List<Map<String,Object>> licenseCodeDetails=new ArrayList<>();;
	try {
		if(lincenseCode!=null) {
		licenseCodeDetails=jdbcTemplate.queryForList("select license_code,active_date,active,user_code from license_code where license_code='"+lincenseCode+"'");
		}else {
			licenseCodeDetails=jdbcTemplate.queryForList("select license_code,active_date,active,user_code from license_code");
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return licenseCodeDetails;
}

@Override
public List<Map<String, Object>> getInternetDetails(String currency) {
	List<Map<String, Object>> internetDetails=new ArrayList<>();
	try {
		if(currency!=null) {
		internetDetails=jdbcTemplate.queryForList("select net_auth_time_limit,net_suppress_required_demog,log_requests from config where currency='"+currency+"'");
		}else {
			internetDetails=jdbcTemplate.queryForList("select net_auth_time_limit,net_suppress_required_demog,log_requests from config");
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return internetDetails;
}

@Override
public int saveInternet(DefaultSettings defaultSettings) {
	int status=0;
	String maxId=null;
	Map<String,Object> addParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("insert into document_reference(document_reference_id,description,active,user_code,type) values(:document_reference_id,:description,:active,:user_code,:type)");
	try {
		maxId=jdbcTemplate.queryForObject("select max(id) from mru_document_reference_id", String.class);
		if(maxId==null) {
			addParams.put("document_reference_id",1);
		}else {
			addParams.put("document_reference_id",Integer.parseInt(maxId)+1);

		}
		addParams.put("description",defaultSettings.getDescription());
		addParams.put("type",4);
		addParams.put("active",defaultSettings.getActive());
		addParams.put("user_code",defaultSettings.getUserCode());
		addParams.put("bypass_doc_ref_dlg",defaultSettings.getBypassDocRefDlg());

		status=namedParameterJdbcTemplate.update(query.toString(), addParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}return status;
}

@Override
public int updateInternet(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update document_reference set description=:description,active=:active,type=:type where document_reference_id="+defaultSettings.getDocumentReferenceId());
	try {
		updateParams.put("description",defaultSettings.getDescription());
		updateParams.put("active",defaultSettings.getActive());
		updateParams.put("type",4);

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<DropdownModel> getMatchCode() {
	List<Map<String, Object>> matchCode = new ArrayList<>();
	List<DropdownModel> matchCodeDataList = new ArrayList<>();
	try {
		matchCode = jdbcTemplate.queryForList("select customer_match_code_id,description from customer_match_code");
		for (Map<String, Object> match: matchCode) {
			DropdownModel model = new DropdownModel();
			model.setKey(match.get("customer_match_code_id").toString());
			model.setDisplay(match.get("description") != null ? (String) match.get("description") : "");
			matchCodeDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	
}return matchCodeDataList;
}

@Override
public List<DropdownModel> getProspectCategory() {
	List<Map<String, Object>> prospectCategory = new ArrayList<>();
	List<DropdownModel> prospectCategoryDataList = new ArrayList<>();
	try {
		prospectCategory = jdbcTemplate.queryForList("select prospect_category,description from prospect_category");
		for (Map<String, Object> prospect: prospectCategory) {
			DropdownModel model = new DropdownModel();
			model.setKey(prospect.get("prospect_category").toString());
			model.setDisplay(prospect.get("description") != null ? (String) prospect.get("description") : "");
			prospectCategoryDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	
}
	return prospectCategoryDataList;
}

@Override
public int updateDefaultInternet(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set net_auth_time_limit=:net_auth_time_limit,net_suppress_required_demog=:net_suppress_required_demog,log_requests=:log_requests where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("net_auth_time_limit",defaultSettings.getNetAuthTimeLimit());
		updateParams.put("net_suppress_required_demog",defaultSettings.getNetSuppressRequireddemog());
		updateParams.put("log_requests",defaultSettings.getLogRequests());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<DropdownModel> getLableGroup() {
	List<DropdownModel> labelGroupDataList = new ArrayList<>();
	try {
		List<Map<String, Object>> labelGroup = jdbcTemplate.queryForList("select label_group,description from label_group");
		for (Map<String, Object> lablegroup: labelGroup) {
			DropdownModel model = new DropdownModel();
			model.setKey(lablegroup.get("label_group").toString());
			model.setDisplay(lablegroup.get("description") != null ? (String) lablegroup.get("description") : "");
			labelGroupDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	
}
	return labelGroupDataList;
}

@Override
public List<DropdownModel> getLableFormate() {

	List<DropdownModel> labelFormatDataList = new ArrayList<>();
	try {
		List<Map<String, Object>> lableFormate = jdbcTemplate.queryForList("select label_format,description from label_format");
		for (Map<String, Object> lableForm: lableFormate) {
			DropdownModel model = new DropdownModel();
			model.setKey(lableForm.get("label_format").toString());
			model.setDisplay(lableForm.get("description") != null ? (String) lableForm.get("description") : "");
			labelFormatDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	
}
	return labelFormatDataList;
}

@Override
public List<Map<String, Object>> getProcessingDetails(String currency) {
	List<Map<String,Object>> processingDetails=new ArrayList<>();
	try {
		if(currency!=null) {
		processingDetails=jdbcTemplate.queryForList("select default_renewal_status,seconds_per_yo_po_se_yo,job_log_path,billing_refund_to_deposit,srv_ext_end,email_event_prefix,http_header_apikey,"
				+ "auto_renew_pay_is_cc_recurring,from_email_address,job_completion_email_address,job_completion_email_url,event_notification_url from config where currency='"+currency+"'");
		}else {
			processingDetails=jdbcTemplate.queryForList("select default_renewal_status,seconds_per_yo_po_se_yo,job_log_path,billing_refund_to_deposit,srv_ext_end,email_event_prefix,http_header_apikey,"
					+ "auto_renew_pay_is_cc_recurring,from_email_address,job_completion_email_address,job_completion_email_url,event_notification_url from config");	
		}
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	
}
	return processingDetails;
}

@Override
public int updateProcessing(DefaultSettings defaultSettings) {
	int status=0;
	Map<String,Object> updateParams=new LinkedHashMap<>();
	StringBuilder query=new StringBuilder("update config set default_renewal_status=:default_renewal_status,seconds_per_yo_po_se_yo=:seconds_per_yo_po_se_yo,job_log_path=:job_log_path,billing_refund_to_deposit=:billing_refund_to_deposit,srv_ext_end=:srv_ext_end,"
			+ "email_event_prefix=:email_event_prefix,http_header_apikey=:http_header_apikey,auto_renew_pay_is_cc_recurring=:auto_renew_pay_is_cc_recurring,from_email_address=:from_email_address,job_completion_email_address=:job_completion_email_address,"
			+ "job_completion_email_url=:job_completion_email_url,event_notification_url=:event_notification_url where currency='"+defaultSettings.getCurrency()+"'");
	try {
		updateParams.put("default_renewal_status",defaultSettings.getDefaultRenewalStatus());
		updateParams.put("seconds_per_yo_po_se_yo",defaultSettings.getSecondsPeryoPoSeYo());
		updateParams.put("job_log_path",defaultSettings.getJobLogPath());
		updateParams.put("billing_refund_to_deposit",defaultSettings.getBillingRefundtoDeposit());
		updateParams.put("srv_ext_end",defaultSettings.getSrvExtEnd());
		updateParams.put("email_event_prefix",defaultSettings.getEmailEventPrefix());
		updateParams.put("http_header_apikey",defaultSettings.getLogRequests());
		updateParams.put("auto_renew_pay_is_cc_recurring",defaultSettings.getAutoRenewPayisccRecurring());
		updateParams.put("from_email_address",defaultSettings.getFromEmailAddress());
		updateParams.put("job_completion_email_address",defaultSettings.getJobCompletionEmailAddress());
		updateParams.put("job_completion_email_url",defaultSettings.getJobCompletionEmailUrl());
		updateParams.put("event_notification_url",defaultSettings.getEventNotificationUrl());

		status=namedParameterJdbcTemplate.update(query.toString(), updateParams);

	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int saveDeliveryMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	Map<String, Object> addDeliveryMethods = new LinkedHashMap<>();
	try {

		String deliverMethodsQuery = "insert into delivery_method(delivery_method,region_list,description,amount,distribution_method,mode_transport,mru_del_method_default_seq,mru_dist_method_override_seq,mru_del_method_override_seq,active) "
				+ "values(:delivery_method,:region_list,:description,:amount,:distribution_method,:mode_transport,:mru_del_method_default_seq,:mru_dist_method_override_seq,:mru_del_method_override_seq,:active)";
		addDeliveryMethods.put("delivery_method", shippingDeliveryandDistributionModel.getDeliveryMethod());
		addDeliveryMethods.put("region_list", shippingDeliveryandDistributionModel.getRegionList());
		addDeliveryMethods.put("description", shippingDeliveryandDistributionModel.getDescription());
		addDeliveryMethods.put("amount", shippingDeliveryandDistributionModel.getAmount());
		addDeliveryMethods.put("distribution_method", shippingDeliveryandDistributionModel.getDistributionMethod());
		addDeliveryMethods.put("mode_transport", shippingDeliveryandDistributionModel.getModeTransport());
		addDeliveryMethods.put("mru_del_method_default_seq",
				shippingDeliveryandDistributionModel.getMruDelMethodDefaultSeq());
		addDeliveryMethods.put("mru_dist_method_override_seq",
				shippingDeliveryandDistributionModel.getMruDistMethodOverrideSeq());
		addDeliveryMethods.put("mru_del_method_override_seq",
				shippingDeliveryandDistributionModel.getMruDelMethodOverrideSeq());
		addDeliveryMethods.put("active", shippingDeliveryandDistributionModel.getActive());
		status = namedParameterJdbcTemplate.update(deliverMethodsQuery, addDeliveryMethods);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateDeliveryMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	Map<String, Object> updateDeliveryMethods = new LinkedHashMap<>();
	try {

		String updateDeliveryMethodsQuery = "update delivery_method set region_list=:region_list,description=:description,amount=:amount,distribution_method=:distribution_method,mode_transport=:mode_transport,mru_del_method_default_seq=:mru_del_method_default_seq,mru_dist_method_override_seq=:mru_dist_method_override_seq,mru_del_method_override_seq=:mru_del_method_override_seq,active=:active  where delivery_method = '"
				+ shippingDeliveryandDistributionModel.getDeliveryMethod() + "'";
		updateDeliveryMethods.put("delivery_method", shippingDeliveryandDistributionModel.getDeliveryMethod());
		updateDeliveryMethods.put("region_list", shippingDeliveryandDistributionModel.getRegionList());
		updateDeliveryMethods.put("description", shippingDeliveryandDistributionModel.getDescription());
		updateDeliveryMethods.put("amount", shippingDeliveryandDistributionModel.getAmount());
		updateDeliveryMethods.put("distribution_method",
				shippingDeliveryandDistributionModel.getDistributionMethod());
		updateDeliveryMethods.put("mode_transport", shippingDeliveryandDistributionModel.getModeTransport());
		updateDeliveryMethods.put("mru_del_method_default_seq",
				shippingDeliveryandDistributionModel.getMruDelMethodDefaultSeq());
		updateDeliveryMethods.put("mru_dist_method_override_seq",
				shippingDeliveryandDistributionModel.getMruDistMethodOverrideSeq());
		updateDeliveryMethods.put("mru_del_method_override_seq",
				shippingDeliveryandDistributionModel.getMruDelMethodOverrideSeq());
		updateDeliveryMethods.put("active", shippingDeliveryandDistributionModel.getActive());
		status = namedParameterJdbcTemplate.update(updateDeliveryMethodsQuery, updateDeliveryMethods);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteDeliveryMethods(String deliveryMethod) {
	int status = 0;
	try {

		StringBuilder deleteQuery = new StringBuilder("delete delivery_method from delivery_method D ");

		deleteQuery.append(" left join  config on D.delivery_method=config.delivery_method");
		deleteQuery.append(
				" left join  del_method_override on D.delivery_method= del_method_override.delivery_method");
		deleteQuery.append(
				" left join  dist_method_override on D.delivery_method=dist_method_override.delivery_method");
		deleteQuery.append(" left join  order_item on D.delivery_method=order_item.delivery_method");
		deleteQuery
				.append(" left join  start_stop_address on D.delivery_method=start_stop_address.delivery_method");
		deleteQuery
				.append(" left join  del_method_default on D.delivery_method=del_method_default.delivery_method");
		deleteQuery.append(
				" left join  dist_attrib_value_del_method  on D.delivery_method=dist_attrib_value_del_method.delivery_method");
		deleteQuery.append(" where D.delivery_method= '" + deliveryMethod + "'");
		try {
			status = jdbcTemplate.update(deleteQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getDeliveryMethods(String deliveryMethod) {
	List<Map<String, Object>> deliveryMethodsDetails = new ArrayList<>();
	try {
		if(deliveryMethod!=null) {
		deliveryMethodsDetails = jdbcTemplate.queryForList(
				"select delivery_method,region_list,description,amount,distribution_method,mode_transport,mru_del_method_default_seq,mru_dist_method_override_seq,"
				+ "mru_del_method_override_seq,active from  delivery_method where delivery_method='"
					+ deliveryMethod + "'");
		}else {
			deliveryMethodsDetails = jdbcTemplate.queryForList(
					"select delivery_method,region_list,description,amount,distribution_method,mode_transport,mru_del_method_default_seq,mru_dist_method_override_seq,"
					+ "mru_del_method_override_seq,active from  delivery_method");
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return deliveryMethodsDetails;
}

@Override
public List<DropdownModel> getRegionList() {
	List<DropdownModel> regionList = new ArrayList<>();
	try {
		List<Map<String, Object>> regionDetails = jdbcTemplate.queryForList("select region from region");
		for (Map<String, Object> getRegionList : regionDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getRegionList.get("region").toString());
			regionList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return regionList;
}

@Override
public List<DropdownModel> getOrderClassList() {
	List<DropdownModel> orderClassList = new ArrayList<>();
	try {
		List<Map<String, Object>> orderClassDetails = jdbcTemplate.queryForList("select oc,description,oc_type from oc");
		for (Map<String, Object> getOrderClass : orderClassDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getOrderClass.get("oc").toString());
		    model.setDisplay(new PropertyUtilityClass().getConstantValue("oc_type_" +((Map<String,Object>) getOrderClass).get("oc_type")));
			model.setDescription(getOrderClass.get("description") != null ? (String) getOrderClass.get("description") :"");
			orderClassList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return orderClassList;
}
@Override
public int saveDistributionMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;

	try {
		Map<String, Object> addDistributionMethods = new LinkedHashMap<>();
		String distributionMethodsQuery = "insert into distribution_method(distribution_method,region_list,description,segment_delimiter,mru_dist_method_default_seq) "+ "values"
			+ "(:distribution_method,:region_list,:description,:segment_delimiter,:mru_dist_method_default_seq)";
		addDistributionMethods.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		LOGGER.info("distributionMethod:{}", shippingDeliveryandDistributionModel.getDistributionMethod());
		addDistributionMethods.put("region_list", shippingDeliveryandDistributionModel.getRegionList());
		addDistributionMethods.put("description", shippingDeliveryandDistributionModel.getDescription());
		addDistributionMethods.put("segment_delimiter", shippingDeliveryandDistributionModel.getSegmentDelimiter());
		addDistributionMethods.put("mru_dist_method_default_seq",shippingDeliveryandDistributionModel.getMruDistMethodDefaultSeq());
		status = namedParameterJdbcTemplate.update(distributionMethodsQuery, addDistributionMethods);
		Map<String, Object> addDistributionMethodSegment = new LinkedHashMap<>();
		String distributionMethodSegmentQuery = "insert into dist_method_segment(distribution_method,distribution_attribute,segment_order,required_for_delivery,suppress_printing)"+ " values"
				+ "(:distribution_method,:distribution_attribute,:segment_order,:required_for_delivery,:suppress_printing)";
		addDistributionMethodSegment.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		LOGGER.info("distributionMethod:{}", shippingDeliveryandDistributionModel.getDistributionMethod());
		addDistributionMethodSegment.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());
		addDistributionMethodSegment.put("segment_order", shippingDeliveryandDistributionModel.getSegmentOrder());
		addDistributionMethodSegment.put("required_for_delivery",shippingDeliveryandDistributionModel.getRequiredForDelivery());
		addDistributionMethodSegment.put("suppress_printing",shippingDeliveryandDistributionModel.getSuppressPrinting());
		status = namedParameterJdbcTemplate.update(distributionMethodSegmentQuery, addDistributionMethodSegment);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateDistributionMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;

	try {
		Map<String, Object> updateDistributionMethods = new LinkedHashMap<>();
		String updateDistributionMethodQuery = "update distribution_method set region_list=:region_list,description=:description,segment_delimiter=:segment_delimiter,mru_dist_method_default_seq=:mru_dist_method_default_seq  where  distribution_method='"
		    + shippingDeliveryandDistributionModel.getDistributionMethod() + "'";
		// updateDistributionMethods.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		// LOGGER.info("distributionMethod:{}",shippingDeliveryandDistributionModel.getDistributionMethod());
		
		updateDistributionMethods.put("region_list", shippingDeliveryandDistributionModel.getRegionList());
		updateDistributionMethods.put("description", shippingDeliveryandDistributionModel.getDescription());
		updateDistributionMethods.put("segment_delimiter",shippingDeliveryandDistributionModel.getSegmentDelimiter());
		updateDistributionMethods.put("mru_dist_method_default_seq",shippingDeliveryandDistributionModel.getMruDistMethodDefaultSeq());
		status = namedParameterJdbcTemplate.update(updateDistributionMethodQuery, updateDistributionMethods);
		Map<String, Object> updateDistributionMethodSegment = new LinkedHashMap<>();
		String distributionMethodSegmentQuery = "update dist_method_segment set segment_order=:segment_order,required_for_delivery=:required_for_delivery,suppress_printing=:suppress_printing where distribution_attribute= '"
				+ shippingDeliveryandDistributionModel.getDistributionAttribute() + "' and   distribution_method='"+ shippingDeliveryandDistributionModel.getDistributionMethod() + "'";
		// updateDistributionMethodSegment.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		// LOGGER.info("distributionMethod:{}",shippingDeliveryandDistributionModel.getDistributionMethod());
		// updateDistributionMethodSegment.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());
		updateDistributionMethodSegment.put("segment_order",shippingDeliveryandDistributionModel.getSegmentOrder());
		updateDistributionMethodSegment.put("required_for_delivery",shippingDeliveryandDistributionModel.getRequiredForDelivery());
		updateDistributionMethodSegment.put("suppress_printing",shippingDeliveryandDistributionModel.getSuppressPrinting());
		status = namedParameterJdbcTemplate.update(distributionMethodSegmentQuery, updateDistributionMethodSegment);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteDistributionMethods(String distributionMethod, String distributionAttribute) {
	int status = 0;
	try {

		//String deleteDistMethodSegment = "delete from  dist_method_segment  where distribution_method= '" + distributionMethod + "' and distribution_attribute= '" + distributionAttribute + "'";
		//status = jdbcTemplate.update(deleteDistMethodSegment);

		StringBuilder deleteDistributionMethodQuery = new StringBuilder("delete distribution_method  from distribution_method  D ");
		deleteDistributionMethodQuery.append(" left join config on D.distribution_method=config.distribution_method");
		deleteDistributionMethodQuery.append(" left join dist_attribute_oc on D.distribution_method=dist_attribute_oc.distribution_method");
		deleteDistributionMethodQuery.append(" left join dist_method_override on D.distribution_method=dist_method_override.distribution_method");
		deleteDistributionMethodQuery.append(" left join distributor_dist_value on D.distribution_method=distributor_dist_value.distribution_method");
		deleteDistributionMethodQuery.append(" left join order_item on D.distribution_method=order_item.distribution_method");
		deleteDistributionMethodQuery.append(" left join delivery_method on D.distribution_method=delivery_method.distribution_method");
		deleteDistributionMethodQuery.append(" left join dist_method_default on D.distribution_method=dist_method_default.distribution_method");
		deleteDistributionMethodQuery.append(" left join dist_method_segment on D.distribution_method=dist_method_segment.distribution_method");
		deleteDistributionMethodQuery.append(" where D.distribution_method= '" + distributionMethod + "'");
		try {
			status = jdbcTemplate.update(deleteDistributionMethodQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getDistributionMethods(String distributionMethod, String distributionAttribute) {

	List<Map<String, Object>> distributionMethodDetails = new ArrayList<>();
	try {
		if(distributionMethod!=null&distributionAttribute!=null) {
		distributionMethodDetails = jdbcTemplate.queryForList("select distribution_method,region_list,description,segment_delimiter,mru_dist_method_default_seq from  "
				+ "distribution_method where distribution_method='"+distributionMethod+ "'");

		//distributionMethodDetails = jdbcTemplate.queryForList("select distribution_method,distribution_attribute,segment_order,required_for_delivery,suppress_printing from "
			//	+ "dist_method_segment where  distribution_attribute='" + distributionAttribute + "' and   distribution_method='" +distributionMethod+"'");
		distributionMethodDetails.addAll(jdbcTemplate.queryForList("select distribution_method,distribution_attribute,segment_order,required_for_delivery,suppress_printing from "
			+ "dist_method_segment where  distribution_attribute='" + distributionAttribute + "' and   distribution_method='" +distributionMethod+"'"));
		
		}else {
			distributionMethodDetails = jdbcTemplate.queryForList("select distribution_method,region_list,description,segment_delimiter,mru_dist_method_default_seq from distribution_method");
			distributionMethodDetails.addAll(jdbcTemplate.queryForList("select distribution_method,distribution_attribute,segment_order,required_for_delivery,suppress_printing from dist_method_segment"));
		}
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return distributionMethodDetails;
}

@Override
public List<DropdownModel> getDistAttributeList() {
	List<DropdownModel> distAttributeList = new ArrayList<>();
	try {
		List<Map<String, Object>> distAttributeDetails = jdbcTemplate.queryForList("select distribution_attribute,description  from distribution_attribute");
		for (Map<String, Object> getDistAttributeList :distAttributeDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getDistAttributeList.get("distribution_attribute").toString());
			model.setDisplay(getDistAttributeList.get("description").toString());
			distAttributeList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return distAttributeList;
}

@Override
public List<DropdownModel> getDistRegionList() {
	List<DropdownModel> distRegionList = new ArrayList<>();
	try {
		List<Map<String, Object>> distRegionDetails = jdbcTemplate.queryForList("select region_list,description  from region_list");
		for (Map<String, Object> getDistRegionList :distRegionDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getDistRegionList.get("region_list").toString());
			model.setDisplay(getDistRegionList.get("description").toString());
			distRegionList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return distRegionList;
}

//@Override
//public List<Map<String, Object>> setupDefaltDeliveryMethodsDetails() {
//	return null;
//}

@Override
public List<DropdownModel> getDeliveryMethodList() {
	List<DropdownModel> deliveryMethodList = new ArrayList<>();
	try {
		List<Map<String, Object>> deliveryMethodDetails = jdbcTemplate.queryForList("select delivery_method,description  from delivery_method");
		for (Map<String, Object> getdeliveryMethodList :deliveryMethodDetails ) {
			DropdownModel model = new DropdownModel();
			model.setKey(getdeliveryMethodList.get("delivery_method").toString());
			model.setDisplay(getdeliveryMethodList.get("description").toString());
			deliveryMethodList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return deliveryMethodList;
}


@Override
public int saveAssignDistributionCriteria(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	
	try {
		
		
		
		Map<String, Object> addDistributionMethodDefault = new LinkedHashMap<>();
		String distributionMethodDefalutQuery = "insert into dist_method_default(distribution_method,dist_method_default_seq,region_list,region,state,city,begin_zip,end_zip) " + "values(:distribution_method,:dist_method_default_seq,:region_list,:region,:state,:city,:begin_zip,:end_zip)";
		addDistributionMethodDefault.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		addDistributionMethodDefault.put("dist_method_default_seq",shippingDeliveryandDistributionModel.getDisMethodDefaultSeq());
		addDistributionMethodDefault.put("region_list",shippingDeliveryandDistributionModel.getRegionList());
		addDistributionMethodDefault.put("region",shippingDeliveryandDistributionModel.getRegion());
		addDistributionMethodDefault.put("state",shippingDeliveryandDistributionModel.getState());
		addDistributionMethodDefault.put("city",shippingDeliveryandDistributionModel.getCity());
		addDistributionMethodDefault.put("begin_zip",shippingDeliveryandDistributionModel.getBeginPostalRange());
		addDistributionMethodDefault.put("end_zip",shippingDeliveryandDistributionModel.getEndPostalRange());
		status = namedParameterJdbcTemplate.update(distributionMethodDefalutQuery,addDistributionMethodDefault);
		
        Map<String, Object> addDistributionValue = new LinkedHashMap<>();
		
		String  distributionValueQuery = "insert into distribution_value(distribution_method,dist_method_default_seq,distribution_attribute,dist_attribute_value)"+ "values(:distribution_method,:dist_method_default_seq,:distribution_attribute,:dist_attribute_value)";
		addDistributionValue.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		addDistributionValue.put("dist_method_default_seq",shippingDeliveryandDistributionModel.getDisMethodDefaultSeq());	
		addDistributionValue.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());	
		addDistributionValue.put("dist_attribute_value",shippingDeliveryandDistributionModel.getDistAttributeValue());	
		status = namedParameterJdbcTemplate.update(distributionValueQuery,addDistributionValue);
		

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateAssignDistributionCriteria(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	
	try {
		Map<String, Object> updateDistMethodDefault = new LinkedHashMap<>();
		String distMethodDefaultQuery = "update dist_method_default set region_list=:region_list,region=:region,state=:state,city=:city,begin_zip=:begin_zip,end_zip=:end_zip where distribution_method= '" +shippingDeliveryandDistributionModel.getDistributionMethod()+"' and "
				+ "dist_method_default_seq="+shippingDeliveryandDistributionModel.getDisMethodDefaultSeq();
		updateDistMethodDefault.put("region_list",shippingDeliveryandDistributionModel.getRegionList());
		updateDistMethodDefault.put("region",shippingDeliveryandDistributionModel.getRegion());
		updateDistMethodDefault.put("state",shippingDeliveryandDistributionModel.getState());
		LOGGER.info("state:{}",shippingDeliveryandDistributionModel.getState());
		updateDistMethodDefault.put("city", shippingDeliveryandDistributionModel.getCity());
		updateDistMethodDefault.put("begin_zip", shippingDeliveryandDistributionModel.getBeginPostalRange());
		updateDistMethodDefault.put("end_zip", shippingDeliveryandDistributionModel.getEndPostalRange());
		status = namedParameterJdbcTemplate.update(distMethodDefaultQuery,updateDistMethodDefault);
		
		Map<String, Object> updateDistValue = new LinkedHashMap<>();
		String distValueQuery = "update distribution_value set distribution_attribute=:distribution_attribute,dist_attribute_value=:dist_attribute_value where distribution_method= '" +shippingDeliveryandDistributionModel.getDistributionMethod()+"' and  dist_method_default_seq="+shippingDeliveryandDistributionModel.getDisMethodDefaultSeq();
		// updateDistValue.put("distribution_method",shippingDeliveryandDistributionModel.getDistributionMethod());
		// updateDistValue.put("dist_method_default_seq",shippingDeliveryandDistributionModel.getDisMethodDefaultSeq());	
		 updateDistValue.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());	
		 updateDistValue.put("dist_attribute_value",shippingDeliveryandDistributionModel.getDistAttributeValue());	
		status = namedParameterJdbcTemplate.update(distValueQuery,updateDistValue);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteAssignDistributionCriteria(String distributionMethod, int distMethodDefaultSeq) {
	int status = 0;
	try {

		String deleteDistMethodDefault= "delete from  dist_method_default where distribution_method='"+distributionMethod+"' and dist_method_default_seq="+distMethodDefaultSeq;
		status = jdbcTemplate.update(deleteDistMethodDefault);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getAssignDistributionCriteria(String distributionMethod,int distMethodDefaultSeq) {
	List<Map<String, Object>>  distMethodDefaultDetails=new ArrayList<>();
	try {
		if(distributionMethod!=null& distMethodDefaultSeq!=0) {
		distMethodDefaultDetails = jdbcTemplate.queryForList(
				"select distribution_method,dist_method_default_seq,region_list,region,state,city,begin_zip,end_zip  from dist_method_default where distribution_method='"+distributionMethod+ "' and dist_method_default_seq="+distMethodDefaultSeq);
		}else {
			distMethodDefaultDetails = jdbcTemplate.queryForList(
					"select distribution_method,dist_method_default_seq,region_list,region,state,city,begin_zip,end_zip  from dist_method_default");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return distMethodDefaultDetails;
}

@Override
public List<DropdownModel> regionList() {
	List<DropdownModel> regionList = new ArrayList<>();
	try {
		List<Map<String, Object>> regionDetails = jdbcTemplate.queryForList("select region from region");
		for (Map<String, Object> getRegion :regionDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getRegion.get("region").toString());
			regionList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return regionList;
}

@Override
public List<DropdownModel> attributeList() {
	List<DropdownModel> attributeList = new ArrayList<>();
	try {
		List<Map<String, Object>>  attributeDetails = jdbcTemplate.queryForList("select distribution_attribute,description  from distribution_attribute");
		for (Map<String, Object> getAttribute :attributeDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getAttribute.get("distribution_attribute").toString());
			model.setDisplay(getAttribute.get("description").toString());
			attributeList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return attributeList;
}

@Override
public List<DropdownModel> attributeValue() {
	List<DropdownModel> attributeValue = new ArrayList<>();
	try {
		List<Map<String, Object>> attributeValueDetails = jdbcTemplate.queryForList("select dist_attribute_value from distribution_value");
		for (Map<String, Object> getAttributeValue :attributeValueDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey( getAttributeValue.get("dist_attribute_value").toString());
			attributeValue.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return attributeValue;
}
@Override
public int saveSetUpDistributionAttributes(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
  int status = 0;
	
	try {
		
		Map<String, Object> addDistributionAttribute = new LinkedHashMap<>();
		String distributionAttributeQuery = "insert into distribution_attribute(distribution_attribute,description,required_for_delivery,validate_values) " + "values(:distribution_attribute,:description,:required_for_delivery,:validate_values)";
		addDistributionAttribute.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());
		addDistributionAttribute.put("description",shippingDeliveryandDistributionModel.getDescription());
		addDistributionAttribute.put("required_for_delivery",shippingDeliveryandDistributionModel.getRequiredForDelivery());
		addDistributionAttribute.put("validate_values",shippingDeliveryandDistributionModel.getValidateValues());
		status = namedParameterJdbcTemplate.update(distributionAttributeQuery,addDistributionAttribute);
		
        Map<String, Object> addDistAttributeValue = new LinkedHashMap<>();
		
		String  distAttributeValueQuery = "insert into dist_attribute_value(distribution_attribute,dist_attribute_value,not_deliverable,allowed_del_method)"+ "values(:distribution_attribute,:dist_attribute_value,:not_deliverable,:allowed_del_method)";
		addDistAttributeValue.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());
		addDistAttributeValue.put("dist_attribute_value",shippingDeliveryandDistributionModel.getDistAttributeValue());	
		addDistAttributeValue.put("not_deliverable",shippingDeliveryandDistributionModel.getNotDelivarable());	
		addDistAttributeValue.put("allowed_del_method",shippingDeliveryandDistributionModel.getAllowedDelMethod());	
		status = namedParameterJdbcTemplate.update(distAttributeValueQuery,addDistAttributeValue);
		

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateSetUpDistributionAttributes(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
int status = 0;
	
	try {
		Map<String, Object> updateDistributionAttribute = new LinkedHashMap<>();
		String distributionAttributeQuery = "update distribution_attribute set description=:description,required_for_delivery=:required_for_delivery,validate_values=:validate_values  where distribution_attribute= '" +shippingDeliveryandDistributionModel.getDistributionAttribute()+"'";
		
		//updateDistributionAttribute.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());		
		updateDistributionAttribute.put("description",shippingDeliveryandDistributionModel.getDescription());
		updateDistributionAttribute.put("required_for_delivery",shippingDeliveryandDistributionModel.getRequiredForDelivery());
		updateDistributionAttribute.put("validate_values",shippingDeliveryandDistributionModel.getValidateValues());
		status = namedParameterJdbcTemplate.update(distributionAttributeQuery,updateDistributionAttribute);
		
		Map<String, Object> updateDistAttributeValue = new LinkedHashMap<>();
		String distAttributeValueQuery = "update dist_attribute_value set not_deliverable=:not_deliverable,allowed_del_method=:allowed_del_method  where distribution_attribute= '" +shippingDeliveryandDistributionModel.getDistributionAttribute()+"' and  dist_attribute_value='"+shippingDeliveryandDistributionModel.getDistAttributeValue()+"'";
		//updateDistAttributeValue.put("distribution_attribute",shippingDeliveryandDistributionModel.getDistributionAttribute());
		//updateDistAttributeValue.put("dist_attribute_value",shippingDeliveryandDistributionModel.getDistAttributeValue());	
		updateDistAttributeValue.put("not_deliverable",shippingDeliveryandDistributionModel.getNotDelivarable());	
		updateDistAttributeValue.put("allowed_del_method",shippingDeliveryandDistributionModel.getAllowedDelMethod());	
		status = namedParameterJdbcTemplate.update(distAttributeValueQuery,updateDistAttributeValue);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteSetUpDistributionAttributes(String distributionAttribute, String distAttributeValue) {
	int status = 0;
	try {
		//String deleteDistAttributeValue="delete from  dist_attribute_value where distribution_attribute='"+distributionAttribute+"' and dist_attribute_value='"+distAttributeValue+"'";
        //status = jdbcTemplate.update(deleteDistAttributeValue);
        String deleteDistributionAttribute= "delete from distribution_attribute where distribution_attribute='"+distributionAttribute+"'";
		status = jdbcTemplate.update(deleteDistributionAttribute);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getSetUpDistributionAttributes(String distributionAttribute,String distAttributeValue) {
	List<Map<String, Object>>  setUpDistributionAttributeDetails = new ArrayList<>();
	try {
		if(distributionAttribute!=null&distAttributeValue!=null) {
		setUpDistributionAttributeDetails= jdbcTemplate.queryForList("select distribution_attribute,description,required_for_delivery,validate_values from  distribution_attribute  where  where distribution_attribute= '" +distributionAttribute+"'");
		setUpDistributionAttributeDetails.addAll(jdbcTemplate.queryForList("select distribution_attribute,dist_attribute_value,not_deliverable,allowed_del_method  from  dist_attribute_value where  distribution_attribute= '" +distributionAttribute+"' and  dist_attribute_value='"+distAttributeValue+"'"));
		}else {
			setUpDistributionAttributeDetails= jdbcTemplate.queryForList("select distribution_attribute,description,required_for_delivery,validate_values from  distribution_attribute");
			setUpDistributionAttributeDetails.addAll(jdbcTemplate.queryForList("select distribution_attribute,dist_attribute_value,not_deliverable,allowed_del_method  from  dist_attribute_value"));
		}
		} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return setUpDistributionAttributeDetails;
}
@Override
public int saveShippingandHandlingMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	Map<String, Object> addShippingandHandlingMethods = new LinkedHashMap<>();
	try {

		String shippingMethodsQuery = "insert into shipping_method(shipping_method,description) " + "values(:shipping_method,:description)";
		addShippingandHandlingMethods.put("shipping_method",shippingDeliveryandDistributionModel.getShippingMethod());
		addShippingandHandlingMethods.put("description",shippingDeliveryandDistributionModel.getDescription());
		status = namedParameterJdbcTemplate.update(shippingMethodsQuery,addShippingandHandlingMethods);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateShippingandHandlingMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	Map<String, Object> updateShippingMethods = new LinkedHashMap<>();
	try {

		String updateShippingQuery = "update shipping_method  set description=:description where shipping_method = '"
				+ shippingDeliveryandDistributionModel.getShippingMethod() + "'";
		updateShippingMethods.put("description", shippingDeliveryandDistributionModel.getDescription());
		//updateShippingMethods.put("shipping_method", shippingDeliveryandDistributionModel.getShippingMethod());
		status = namedParameterJdbcTemplate.update(updateShippingQuery,updateShippingMethods);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteShippingandHandlingMethods(String shippingMethod) {
	int status = 0;
	try {

		String deleteShippingMethod = "delete from shipping_method  where shipping_method = '" +shippingMethod + "'";
		status = jdbcTemplate.update(deleteShippingMethod);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getShippingandHandlingMethods(String shippingMethod) {
	List<Map<String, Object>>  shippingandHandlingMethodDetails = new ArrayList<>();
	try {
		if(shippingMethod!=null) {
		shippingandHandlingMethodDetails = jdbcTemplate.queryForList(
				"select shipping_method,description from shipping_method where shipping_method='"+shippingMethod+ "'");
		}else {
			shippingandHandlingMethodDetails = jdbcTemplate.queryForList(
					"select shipping_method,description from shipping_method");
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return shippingandHandlingMethodDetails;
}

@Override
public int saveShippingPriceList(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	try {
		Map<String, Object> addShippingPriceList = new LinkedHashMap<>();
		String shippingPriceListQuery = "insert into shipping_price_list(shipping_price_list,description,shipping_method,region_list,tax_on_shipping,incl_order_items_tax,"
				+ "charge_subs,charge_single_copies,charge_products,charge_pkgs) " + "values(:shipping_price_list,:description,:shipping_method,:region_list,:tax_on_shipping,"
				+ ":incl_order_items_tax,:charge_subs,:charge_single_copies,:charge_products,:charge_pkgs)";
		addShippingPriceList.put("shipping_price_list",shippingDeliveryandDistributionModel.getShippingPriceList());
		addShippingPriceList.put("description",shippingDeliveryandDistributionModel.getDescription());
		addShippingPriceList.put("shipping_method",shippingDeliveryandDistributionModel.getShippingMethod());
		addShippingPriceList.put("region_list",shippingDeliveryandDistributionModel.getRegionList());
		LOGGER.info("regionList:{}",shippingDeliveryandDistributionModel.getRegionList());
		addShippingPriceList.put("tax_on_shipping",shippingDeliveryandDistributionModel.getTaxOnShipping());
		addShippingPriceList.put("incl_order_items_tax",shippingDeliveryandDistributionModel.getInclOrderItemTax());
		addShippingPriceList.put("charge_subs",shippingDeliveryandDistributionModel.getChargeSubscriptions());
		addShippingPriceList.put("charge_single_copies",shippingDeliveryandDistributionModel.getChargeIssues());
		addShippingPriceList.put("charge_products",shippingDeliveryandDistributionModel.getChargeProducts());
		addShippingPriceList.put("charge_pkgs",shippingDeliveryandDistributionModel.getChargePackages());
		status = namedParameterJdbcTemplate.update(shippingPriceListQuery,addShippingPriceList);
		
		Map<String, Object> addShippingPriceListDetails = new LinkedHashMap<>();
		String shippingPriceListDetailsQuery = "insert into ship_price_lst_dtl(shipping_price_list,ship_price_lst_dtl_seq,region,currency,from_qty,to_qty,from_amt,to_amt,"
				+ "shipping_charge,shipping_percent)" + " values(:shipping_price_list,:ship_price_lst_dtl_seq,:region,:currency,:from_qty,:to_qty,:from_amt,:to_amt,"
				+ ":shipping_charge,:shipping_percent)";
		addShippingPriceListDetails.put("shipping_price_list",shippingDeliveryandDistributionModel.getShippingPriceList());
		addShippingPriceListDetails.put("ship_price_lst_dtl_seq",shippingDeliveryandDistributionModel.getShippingPriceLstDtlSeq());
		addShippingPriceListDetails.put("region",shippingDeliveryandDistributionModel.getRegion());
		addShippingPriceListDetails.put("currency",shippingDeliveryandDistributionModel.getCurrency());
		addShippingPriceListDetails.put("from_qty",shippingDeliveryandDistributionModel.getFromQty());
		addShippingPriceListDetails.put("to_qty",shippingDeliveryandDistributionModel.getToQty());
		addShippingPriceListDetails.put("from_amt",shippingDeliveryandDistributionModel.getFromAmount());
		addShippingPriceListDetails.put("to_amt",shippingDeliveryandDistributionModel.getToAmount());
		addShippingPriceListDetails.put("shipping_charge",shippingDeliveryandDistributionModel.getShippingCharge());
		addShippingPriceListDetails.put("shipping_percent",shippingDeliveryandDistributionModel.getShippingPercent());
		status = namedParameterJdbcTemplate.update(shippingPriceListDetailsQuery,addShippingPriceListDetails);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateShippingPriceList(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	
	try {
		Map<String, Object> updateShippingPriceList = new LinkedHashMap<>();
		String shippingPriceQuery = "update shipping_price_list  set description=:description,shipping_method=:shipping_method,region_list=:region_list,tax_on_shipping=:tax_on_shipping,"
				+ "incl_order_items_tax=:incl_order_items_tax,charge_subs=:charge_subs,charge_single_copies=:charge_single_copies,charge_products=:charge_products,charge_pkgs=:charge_pkgs  where shipping_price_list = '"+ shippingDeliveryandDistributionModel.getShippingPriceList()+ "'";
		//updateShippingPriceList.put("shipping_price_list",shippingDeliveryandDistributionModel.getShippingPriceList());
		updateShippingPriceList.put("description",shippingDeliveryandDistributionModel.getDescription());
		updateShippingPriceList.put("shipping_method",shippingDeliveryandDistributionModel.getShippingMethod());
		updateShippingPriceList.put("region_list",shippingDeliveryandDistributionModel.getRegionList());
		LOGGER.info("regionList:{}",shippingDeliveryandDistributionModel.getRegionList());
		updateShippingPriceList.put("tax_on_shipping",shippingDeliveryandDistributionModel.getTaxOnShipping());
		updateShippingPriceList.put("incl_order_items_tax",shippingDeliveryandDistributionModel.getInclOrderItemTax());
		updateShippingPriceList.put("charge_subs",shippingDeliveryandDistributionModel.getChargeSubscriptions());
		updateShippingPriceList.put("charge_single_copies",shippingDeliveryandDistributionModel.getChargeIssues());
		updateShippingPriceList.put("charge_products",shippingDeliveryandDistributionModel.getChargeProducts());
		updateShippingPriceList.put("charge_pkgs",shippingDeliveryandDistributionModel.getChargePackages());
		
		status = namedParameterJdbcTemplate.update(shippingPriceQuery,updateShippingPriceList);
		
		Map<String, Object> updateShippingPriceListDetails = new LinkedHashMap<>();
		
		String  shippingPriceListDetailsQuery = "update ship_price_lst_dtl set  ship_price_lst_dtl_seq=:ship_price_lst_dtl_seq,region=:region,currency=:currency,from_qty=:from_qty,to_qty=:to_qty,from_amt=:from_amt,to_amt=:to_amt,shipping_charge=:shipping_charge,shipping_percent=:shipping_percent  where "
				+ " shipping_price_list = '"+ shippingDeliveryandDistributionModel.getShippingPriceList()+ "'";
		//updateShippingPriceListDetails.put("shipping_price_list",shippingDeliveryandDistributionModel.getShippingPriceList());
		updateShippingPriceListDetails.put("ship_price_lst_dtl_seq",shippingDeliveryandDistributionModel.getShippingPriceLstDtlSeq());
		updateShippingPriceListDetails.put("region",shippingDeliveryandDistributionModel.getRegion());
		updateShippingPriceListDetails.put("currency",shippingDeliveryandDistributionModel.getCurrency());
		updateShippingPriceListDetails.put("from_qty",shippingDeliveryandDistributionModel.getFromQty());
		updateShippingPriceListDetails.put("to_qty",shippingDeliveryandDistributionModel.getToQty());
		updateShippingPriceListDetails.put("from_amt",shippingDeliveryandDistributionModel.getFromAmount());
		updateShippingPriceListDetails.put("to_amt",shippingDeliveryandDistributionModel.getToAmount());
		updateShippingPriceListDetails.put("shipping_charge",shippingDeliveryandDistributionModel.getShippingCharge());
		updateShippingPriceListDetails.put("shipping_percent",shippingDeliveryandDistributionModel.getShippingPercent());
		
		status = namedParameterJdbcTemplate.update(shippingPriceListDetailsQuery,updateShippingPriceListDetails);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteShippingPriceList(String shippingPriceList) {
	int status = 0;
	try {

		//String deleteShippingPriceListDetails = "delete from ship_price_lst_dtl  where shipping_price_list = '" +shippingPriceList + "'";
		//status = jdbcTemplate.update(deleteShippingPriceListDetails);
		
		StringBuilder deleteShippingPriceListQuery = new StringBuilder("delete shipping_price_list  from shipping_price_list S");
		
		deleteShippingPriceListQuery.append(" left join config on S.shipping_price_list=config.shipping_price_list");
		deleteShippingPriceListQuery.append(" left join order_item on S.shipping_price_list=order_item.shipping_price_list");
		deleteShippingPriceListQuery.append(" left join ship_price_lst_dtl on S.shipping_price_list=ship_price_lst_dtl.shipping_price_list");
		deleteShippingPriceListQuery.append(" left join source_code on S.shipping_price_list=source_code.shipping_price_list");
		
		deleteShippingPriceListQuery.append(" where S.shipping_price_list= '" + shippingPriceList+ "'");
		try {
			status = jdbcTemplate.update(deleteShippingPriceListQuery.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getShippingPriceList(String shippingPriceList) {
	List<Map<String, Object>>  shippingPriceListDetails = new ArrayList<>();
	try {
		if(shippingPriceList!=null) {
		shippingPriceListDetails = jdbcTemplate.queryForList("select shipping_price_list,description,tax_on_shipping,incl_order_items_tax,charge_subs,charge_single_copies,charge_products,charge_pkgs  from shipping_price_list where shipping_price_list='"+shippingPriceList+ "'");
		shippingPriceListDetails.addAll(jdbcTemplate.queryForList("select shipping_price_list,ship_price_lst_dtl_seq,from_qty,to_qty,from_amt,to_amt,shipping_charge,shipping_percent from ship_price_lst_dtl where  shipping_price_list='"+shippingPriceList+ "'"));
		}else {
			shippingPriceListDetails = jdbcTemplate.queryForList("select shipping_price_list,description,tax_on_shipping,incl_order_items_tax,charge_subs,charge_single_copies,charge_products,charge_pkgs  from shipping_price_list");
			shippingPriceListDetails.addAll(jdbcTemplate.queryForList("select shipping_price_list,ship_price_lst_dtl_seq,from_qty,to_qty,from_amt,to_amt,shipping_charge,shipping_percent from ship_price_lst_dtl"));
		}
		
		} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return shippingPriceListDetails;
}

@Override
public List<DropdownModel> getShippingMethodList() {
	List<DropdownModel> shippingMethodList = new ArrayList<>();
	try {
		List<Map<String, Object>> shippingMethodDetails = jdbcTemplate.queryForList("select shipping_method,description  from shipping_method");
		for (Map<String, Object> getShippingMethod :shippingMethodDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey( getShippingMethod.get("shipping_method").toString());
			model.setDisplay( getShippingMethod.get("description").toString());
			shippingMethodList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return shippingMethodList;
}

@Override
public List<DropdownModel> getRegion() {
	List<DropdownModel> regionList = new ArrayList<>();
	try {
		List<Map<String, Object>> regionDetails = jdbcTemplate.queryForList("select region,description  from region");
		for (Map<String, Object> getRegion :regionDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getRegion.get("region").toString());
			model.setDisplay(getRegion.get("description").toString());
			regionList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return regionList;
}

@Override
public int saveMailingEntryPoint(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	
	try {
		Map<String, Object> addMailingEntryPoint = new LinkedHashMap<>();
		String mailingEntryPointQuery = "insert into mailing_entry_point(mailing_entry_point,description,entry_point_type) " + "values(:mailing_entry_point,:description,:entry_point_type)";
		addMailingEntryPoint.put("mailing_entry_point",shippingDeliveryandDistributionModel.getMailingEntryPoint());
		addMailingEntryPoint.put("description", shippingDeliveryandDistributionModel.getDescription());
		addMailingEntryPoint.put("entry_point_type", shippingDeliveryandDistributionModel.getEntryPointType());
		status = namedParameterJdbcTemplate.update( mailingEntryPointQuery,addMailingEntryPoint);
		
		Map<String, Object> addMailingEntryPointPrefix = new LinkedHashMap<>();
		String mailingEntryPointPrefixQuery = "insert into  mailing_entry_point_prefix(mailing_entry_point,from_prefix,to_prefix,zone) " + "values(:mailing_entry_point,:from_prefix,:to_prefix,:zone)";
		addMailingEntryPointPrefix.put("mailing_entry_point",shippingDeliveryandDistributionModel.getMailingEntryPoint());
		addMailingEntryPointPrefix.put("from_prefix",shippingDeliveryandDistributionModel.getFromPrefix());
		addMailingEntryPointPrefix.put("to_prefix",shippingDeliveryandDistributionModel.getToPrefix());
		addMailingEntryPointPrefix.put("zone",shippingDeliveryandDistributionModel.getZone());
		status = namedParameterJdbcTemplate.update(mailingEntryPointPrefixQuery,addMailingEntryPointPrefix );
		
		} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateMailingEntryPoint(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	
	try {
		Map<String, Object> updateMailingEntryPoint = new LinkedHashMap<>();
		String  mailingEntryPointQuery = "update mailing_entry_point  set description=:description,entry_point_type=:entry_point_type  where mailing_entry_point= '"
				+ shippingDeliveryandDistributionModel.getMailingEntryPoint()+"'";
		//updateMailingEntryPoint.put("mailing_entry_point", shippingDeliveryandDistributionModel.getMailingEntryPoint());
		updateMailingEntryPoint.put("description", shippingDeliveryandDistributionModel.getDescription());
		updateMailingEntryPoint.put("entry_point_type", shippingDeliveryandDistributionModel.getEntryPointType());
        status = namedParameterJdbcTemplate.update(mailingEntryPointQuery,updateMailingEntryPoint);
		
        Map<String, Object> updateMailingEntryPointPrefix = new LinkedHashMap<>();
		String  mailingEntryPointPrefixQuery = "update  mailing_entry_point_prefix set  from_prefix=:from_prefix,to_prefix=:to_prefix,zone=:zone  where mailing_entry_point='" 
		            +shippingDeliveryandDistributionModel.getMailingEntryPoint()+"'";
		
		//updateMailingEntryPointPrefix.put("mailing_entry_point",shippingDeliveryandDistributionModel.getMailingEntryPoint());
		updateMailingEntryPointPrefix.put("from_prefix",shippingDeliveryandDistributionModel.getFromPrefix());
		updateMailingEntryPointPrefix.put("to_prefix",shippingDeliveryandDistributionModel.getToPrefix());
		updateMailingEntryPointPrefix.put("zone",shippingDeliveryandDistributionModel.getZone());
		status = namedParameterJdbcTemplate.update(mailingEntryPointPrefixQuery,updateMailingEntryPointPrefix);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteMailingEntryPoint(String mailingEntryPoint) {
	int status = 0;
	try {

		StringBuilder deleteMailingEntryPointQuery = new StringBuilder("delete mailing_entry_point  from mailing_entry_point M ");
		deleteMailingEntryPointQuery.append(" left join mailing_entry_point_prefix on M.mailing_entry_point=mailing_entry_point_prefix.mailing_entry_point");
		deleteMailingEntryPointQuery.append(" where  M.mailing_entry_point= '" +mailingEntryPoint+ "'");
		try {
			status = jdbcTemplate.update(deleteMailingEntryPointQuery.toString());
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getMailingEntryPoint(String mailingEntryPoint) {
	List<Map<String, Object>>  mailingEntryPointDetails = new ArrayList<>();
	try {
		if(mailingEntryPoint!=null) {
		mailingEntryPointDetails = jdbcTemplate.queryForList("select mailing_entry_point,description,entry_point_type  from  mailing_entry_point  where  mailing_entry_point='"+mailingEntryPoint+ "'");
		mailingEntryPointDetails.addAll(jdbcTemplate.queryForList("select mailing_entry_point,from_prefix,to_prefix,zone  from  mailing_entry_point_prefix  where  mailing_entry_point='"+mailingEntryPoint+ "'"));
		}else {
			mailingEntryPointDetails = jdbcTemplate.queryForList("select mailing_entry_point,description,entry_point_type  from  mailing_entry_point");
			mailingEntryPointDetails.addAll(jdbcTemplate.queryForList("select mailing_entry_point,from_prefix,to_prefix,zone  from  mailing_entry_point_prefix"));
		}
		
		} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return mailingEntryPointDetails;
}

@Override
public int saveTransportMode(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
	int status = 0;
	Map<String, Object> addTransportMode = new LinkedHashMap<>();
	try {

		String modeTransportQuery = "insert into mode_transport(mode_transport) " + "values(:mode_transport)";
		 addTransportMode.put("mode_transport",shippingDeliveryandDistributionModel.getTransportMode());
		status = namedParameterJdbcTemplate.update(modeTransportQuery,addTransportMode);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteTransportMode(String transportMode) {
	int status = 0;
	try {

		StringBuilder transportModeQuery = new StringBuilder("delete mode_transport  from mode_transport M ");
		transportModeQuery.append(" left join delivery_method  on M.mode_transport=delivery_method.mode_transport");
		transportModeQuery.append(" where  M.mode_transport= '" +transportMode+ "'");
		try {
			status = jdbcTemplate.update(transportModeQuery.toString());
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getTransportMode(String transportMode) {
	List<Map<String, Object>>  transportModeDetails = new ArrayList<>();
	try {
		 if(transportMode!=null) {
		 transportModeDetails= jdbcTemplate.queryForList("select  mode_transport  from mode_transport where  mode_transport= '"+ transportMode+"'");
		 }else {
			 transportModeDetails= jdbcTemplate.queryForList("select  mode_transport  from mode_transport");
		 }
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  transportModeDetails;
}

@Override
public int saveEmailFormater(DefaultSettings defaultSettings) {
	int status = 0;
	Map<String, Object> saveParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into oc_transaction_event(filename,transaction_event,oc_id)values(:filename,:transaction_event,:oc_id)");
	try {
		saveParams.put("filename", defaultSettings.getFilename());
		LOGGER.info("value:" + defaultSettings.getFilename());

		saveParams.put("oc_id", defaultSettings.getOcId());
		saveParams.put("transaction_event", defaultSettings.getTransactionEvent());
		status = namedParameterJdbcTemplate.update(query.toString(), saveParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateEmailFormater(DefaultSettings defaultSettings) {

	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"update oc_transaction_event set filename=:filename,oc_id=:oc_id where transaction_event="
					+ defaultSettings.getTransactionEvent());
	try {
		updateParams.put("filename", defaultSettings.getFilename());
		updateParams.put("oc_id", defaultSettings.getOcId());

		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteEmailFormater(int transactionEvent) {
	int status = 0;
	StringBuilder deleteQuery = new StringBuilder("delete  from oc_transaction_event ");
	deleteQuery.append(" where transaction_event=" + transactionEvent);
	try {
		status = jdbcTemplate.update(deleteQuery.toString());

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<DropdownModel> getTransactionEvent() {
	List<DropdownModel> transactionEvent = new ArrayList<>();
	for (int i = 0; i <= 36; i++) {

		DropdownModel model = new DropdownModel();
		model.setKey("" + i);
		model.setDisplay(new PropertyUtils().getConstantValue("transaction_event" + i));

		transactionEvent.add(model);
	}
	return transactionEvent;
}

@Override
public List<DropdownModel> getOrderClass() {
	List<DropdownModel> orderClass = new ArrayList<>();
	try {
		List<Map<String, Object>> orderClassDetails = jdbcTemplate
				.queryForList("select oc,description,oc_type from oc");

		for (Map<String, Object> ocdetails : orderClassDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(ocdetails.get("oc").toString());
			model.setDisplay(ocdetails.get("description") != null ? (String) ocdetails.get("description") : "");
			model.setDescription(new PropertyUtilityClass()
					.getConstantValue("oc_type_" + ((Map<String, Object>) ocdetails).get("oc_type")));
			orderClass.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return orderClass;
}

@Override
public List<DropdownModel> getrovider() {
	List<DropdownModel> provider = new ArrayList<>();
	try {
		List<Map<String, Object>> providerDetails = jdbcTemplate
				.queryForList("select tp_provider_id,tp_provider_name from tp_providers");
		for (Map<String, Object> provide : providerDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(provide.get("tp_provider_id").toString());
			model.setDisplay(
					provide.get("tp_provider_name") != null ? (String) provide.get("tp_provider_name") : "");
			provider.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return provider;
}

@Override
public int tpProviderUpdate(DefaultSettings defaultSettings) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"update tp_notifications_config set event_notification_url=:event_notification_url,user_name=:user_name,api_key=:api_key where tp_provider_id="
					+ defaultSettings.getTpProviderId());
	try {
		updateParams.put("event_notification_url", defaultSettings.getEventNotificationUrl());
		updateParams.put("user_name", defaultSettings.getUserName());
		updateParams.put("api_key", defaultSettings.getApiKey());

		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getrProviderDetails(int tpProviderId) {
	List<Map<String, Object>> providerDetails = new ArrayList<>();
	try {
		if(tpProviderId!=0) {
		providerDetails = jdbcTemplate.queryForList(
				"select event_notification_url,user_name,api_key from  tp_notifications_config where tp_provider_id="
						+ tpProviderId);
		}else {
			providerDetails = jdbcTemplate.queryForList(
					"select event_notification_url,user_name,api_key from  tp_notifications_config");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return providerDetails;
}

@Override
public List<Map<String, Object>> getEmailFormatorDetails(int transactionEvent) {
	List<Map<String, Object>> emailFormatorDetails = new ArrayList<>();
	try {
		emailFormatorDetails = jdbcTemplate
				.queryForList("select filename,transaction_event from oc_transaction_event where transaction_event="
						+ transactionEvent);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}

	return emailFormatorDetails;
}

@Override
public String defaultEmailAuthorizationInfo(String Currency) {
	LOGGER.info("Inside defaultEmailAuthorizationInfo");
	String email_authorization = null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	List<Character> codeList3 = null;
	List<Character> codeList4 = null;
	List<Character> codeList5 = null;
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select email_authorization from config where currency=?";

			email_authorization = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { Currency },
					String.class);
			LOGGER.info("======>" + email_authorization.length());
			if (null != email_authorization) {

				if ((email_authorization).length() > 12) {
					email_authorization = email_authorization.substring(0, 12);

				}
			}
			if (email_authorization == null || "FEF7FFFF0700".equals(email_authorization)) {
				email_authorization = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37";
			} else {
				email_authorization = email_authorization.substring(0, email_authorization.length());

				if (email_authorization.length() == 2) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
				} else if (email_authorization.length() == 4) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
				} else if (email_authorization.length() == 6) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					codeList3 = new ArrayList<Character>();
					String binaryNumber3 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(4, 6));
					for (int i = binaryNumber3.length() - 1; i > 0; i--) {
						codeList3.add(binaryNumber3.charAt(i));

					}

				} else if (email_authorization.length() == 8) {

					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					codeList3 = new ArrayList<Character>();
					String binaryNumber3 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(4, 6));
					for (int i = binaryNumber3.length() - 1; i > 0; i--) {
						codeList3.add(binaryNumber3.charAt(i));

					}
					codeList4 = new ArrayList<Character>();
					String binaryNumber4 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(6, 8));
					for (int i = binaryNumber4.length() - 1; i > 0; i--) {
						codeList4.add(binaryNumber4.charAt(i));

					}
				} else if (email_authorization.length() == 10) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i >= 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					codeList3 = new ArrayList<Character>();
					String binaryNumber3 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(4, 6));
					for (int i = binaryNumber3.length() - 1; i >= 0; i--) {
						codeList3.add(binaryNumber3.charAt(i));
					}
					codeList4 = new ArrayList<Character>();
					String binaryNumber4 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(6, 8));
					for (int i = binaryNumber4.length() - 1; i >= 0; i--) {
						codeList4.add(binaryNumber4.charAt(i));
					}
					codeList5 = new ArrayList<Character>();
					String binaryNumber5 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(email_authorization.substring(8, 10));
					for (int i = binaryNumber5.length() - 1; i >= 0; i--) {
						codeList5.add(binaryNumber5.charAt(i));
					}
				}
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {

						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 8;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
					}
				}
				if (null != codeList3) {
					int process = 16;
					for (int i = 0; i < codeList3.size(); i++) {
						processCodeMap.put(process, codeList3.get(i));
						process++;
					}
				}
				if (null != codeList4) {
					int process = 24;
					for (int i = 0; i < codeList4.size(); i++) {
						processCodeMap.put(process, codeList4.get(i));
						process++;
					}
				}
				if (null != codeList5) {
					int process = 32;
					for (int i = 0; i < codeList5.size(); i++) {
						processCodeMap.put(process, codeList5.get(i));
						process++;

					}
				}
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						LOGGER.info("Value1:" + selectedBusinessProcess.length());

					}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					email_authorization = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);

				}

			}
		} else {
			email_authorization = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		email_authorization = ERROR;
		return email_authorization;
	}
	return email_authorization;

}

@Override
public List<Map<String, Object>> getCheckdetails(String Currency) {
	List<Map<String, Object>> checkDetails = new ArrayList<>();
	try {
		checkDetails = jdbcTemplate
				.queryForList("select suppress_email_notification,notify_old_and_new from config where currency='"
						+ Currency + "'");
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return checkDetails;
}

@Override
public String updateDefaultEmailAuthorization(String currency, String business_processes) {
	LOGGER.info("Inside updateDefaultEmailAuthorization");
	String status = null;
	try {
		String updateQuery = null;
		String sum1 = null, sum2 = null, sum3 = null, sum4 = null, sum5 = null;
		String finalHexadecimalResult = null;
		List<String> binaryEquivalentArrayList1 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList2 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList3 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList4 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList5 = new ArrayList<String>();
		if (null != business_processes && !"".equals(business_processes)
				&& !"0".equalsIgnoreCase(business_processes) && !"null".equals(business_processes)) {
			String[] business_processes_array = business_processes.split(",");
			if (business_processes_array.length == 1) {
				String business_process = new PropertyUtilityClass().getConstantValue(business_processes_array[0]);
				if (business_process != null && !"".equals(business_process)) {
					updateQuery = "UPDATE config set email_authorization=convert(VARBINARY(10)," + business_process
							+ ") where currency='" + currency + "'";
					LOGGER.info("email_authorization:" + updateQuery);
				}
			} else if (business_processes_array.length > 1) {
				for (int i = 0; i < business_processes_array.length; i++) {
					int business_processInt = Integer.parseInt(business_processes_array[i]);
					if (business_processInt >= 0 && business_processInt <= 7) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList1.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 8 && business_processInt <= 15) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList2.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 16 && business_processInt <= 23) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList3.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 24 && business_processInt <= 31) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList4.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 32 && business_processInt <= 39) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList5.add(Integer.toBinaryString(valueBasedOnLogic));
					}
				}
				if (binaryEquivalentArrayList1.size() > 0) {
					sum1 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList1);
					sum1 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum1);
					if (sum1.length() == 1) {
						sum1 = "0" + sum1;
					}
				}
				if (binaryEquivalentArrayList2.size() > 0) {
					sum2 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList2);
					sum2 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum2);
					if (sum2.length() == 1) {
						sum2 = "0" + sum2;
					}
				}
				if (binaryEquivalentArrayList3.size() > 0) {
					sum3 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList3);
					sum3 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum3);
					if (sum3.length() == 1) {
						sum3 = "0" + sum3;
					}
				}
				if (binaryEquivalentArrayList4.size() > 0) {
					sum4 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList4);
					sum4 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum4);
					if (sum4.length() == 1) {
						sum4 = "0" + sum4;
					}
				}
				if (binaryEquivalentArrayList5.size() > 0) {
					sum5 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList5);
					sum5 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum5);
					if (sum5.length() == 1) {
						sum5 = "0" + sum5;
					}
				}
				if (null != sum1) {
					finalHexadecimalResult = "0x" + sum1;
				} else {
					finalHexadecimalResult = "0x" + "00";
				}
				if (null != sum2) {
					finalHexadecimalResult = finalHexadecimalResult + sum2;
				} else if (null != sum3 || null != sum4 || null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + "00";
				}
				if (null != sum3) {
					finalHexadecimalResult = finalHexadecimalResult + sum3;
				} else if (null != sum4 || null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + "00";
				}
				if (null != sum4) {
					finalHexadecimalResult = finalHexadecimalResult + sum4;
				} else if (null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + "00";
				}
				if (null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + sum5;
				}
				finalHexadecimalResult = finalHexadecimalResult + "00";
				updateQuery = "UPDATE config set email_authorization=convert(VARBINARY(10),"
						+ finalHexadecimalResult + ") where currency='" + currency + "'";
			}
		} else {
			updateQuery = "UPDATE config set email_authorization=convert(VARBINARY(10),NULL) where currency='"
					+ currency + "'";
		}
		jdbcTemplate.update(updateQuery);
		status = "Email Authorization saved successfully.";
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		status = ERROR;
	}
	return status;
}

@Override
public String defaultEmailNotificationInfo(String currency) {
	LOGGER.info("Inside defaultEmailAuthorizationInfo");
	String event_notification_bits = null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	List<Character> codeList3 = null;
	List<Character> codeList4 = null;
	List<Character> codeList5 = null;
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String event_notification_bits_query = " select event_notification_bits from config where currency=?";
			event_notification_bits = jdbcTemplate.queryForObject(event_notification_bits_query,
					new Object[] { currency }, String.class);

			if (null != event_notification_bits) {

				if (event_notification_bits.length() > 12) {
					event_notification_bits = event_notification_bits.substring(0, 12);

				}
			}
			if (event_notification_bits == null || "FEF7FFFF0700".equals(event_notification_bits)) {
				event_notification_bits = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38";
			} else {
				event_notification_bits = event_notification_bits.substring(0, event_notification_bits.length());

				if (event_notification_bits.length() == 2) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
				} else if (event_notification_bits.length() == 4) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
				} else if (event_notification_bits.length() == 6) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					codeList3 = new ArrayList<Character>();
					String binaryNumber3 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(4, 6));
					for (int i = binaryNumber3.length() - 1; i > 0; i--) {
						codeList3.add(binaryNumber3.charAt(i));

					}

				} else if (event_notification_bits.length() == 8) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					codeList3 = new ArrayList<Character>();
					String binaryNumber3 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(4, 6));
					for (int i = binaryNumber3.length() - 1; i > 0; i--) {
						codeList3.add(binaryNumber3.charAt(i));

					}
					codeList4 = new ArrayList<Character>();
					String binaryNumber4 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(6, 8));
					for (int i = binaryNumber4.length() - 1; i > 0; i--) {
						codeList4.add(binaryNumber4.charAt(i));

					}
				} else if (event_notification_bits.length() == 10) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(0, 2));
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(2, 4));
					for (int i = binaryNumber2.length() - 1; i >= 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					codeList3 = new ArrayList<Character>();
					String binaryNumber3 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(4, 6));
					for (int i = binaryNumber3.length() - 1; i >= 0; i--) {
						codeList3.add(binaryNumber3.charAt(i));
					}
					codeList4 = new ArrayList<Character>();
					String binaryNumber4 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(6, 8));
					for (int i = binaryNumber4.length() - 1; i >= 0; i--) {
						codeList4.add(binaryNumber4.charAt(i));
					}
					codeList5 = new ArrayList<Character>();
					String binaryNumber5 = EmailAuthorizationUtility
							.convertHexadecimalToBinary(event_notification_bits.substring(8, 10));
					for (int i = binaryNumber5.length() - 1; i >= 0; i--) {
						codeList5.add(binaryNumber5.charAt(i));
					}
				}
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {

						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 8;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
					}
				}
				if (null != codeList3) {
					int process = 16;
					for (int i = 0; i < codeList3.size(); i++) {
						processCodeMap.put(process, codeList3.get(i));
						process++;
					}
				}
				if (null != codeList4) {
					int process = 24;
					for (int i = 0; i < codeList4.size(); i++) {
						processCodeMap.put(process, codeList4.get(i));
						process++;
					}
				}
				if (null != codeList5) {
					int process = 32;
					for (int i = 0; i < codeList5.size(); i++) {
						processCodeMap.put(process, codeList5.get(i));
						process++;

					}
				}
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						LOGGER.info("Value1:" + selectedBusinessProcess.length());

					}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					event_notification_bits = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);

				}

			}
		} else {
			event_notification_bits = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		event_notification_bits = ERROR;
		return event_notification_bits;
	}
	return event_notification_bits;
}

@Override
public int updateCheckDetails(String currency, String suppressEmailNotification, String notifyOldAndNew) {
	Map<String, Object> updateParams = new LinkedHashMap<>();
	int status = 0;
	try {
		String query = "update config set suppress_email_notification=:suppress_email_notification,notify_old_and_new=:notify_old_and_new where currency='"
				+ currency + "'";
		updateParams.put("suppress_email_notification", suppressEmailNotification);
		updateParams.put("notify_old_and_new", notifyOldAndNew);

		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public String updateDefaultEmailNotificationSwitches(String currency, String business_processes) {
	LOGGER.info("Inside updateDefaultEmailAuthorization");
	String status = null;
	try {
		String updateQuery = null;
		String sum1 = null, sum2 = null, sum3 = null, sum4 = null, sum5 = null;
		String finalHexadecimalResult = null;
		List<String> binaryEquivalentArrayList1 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList2 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList3 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList4 = new ArrayList<String>();
		List<String> binaryEquivalentArrayList5 = new ArrayList<String>();
		if (null != business_processes && !"".equals(business_processes)
				&& !"0".equalsIgnoreCase(business_processes) && !"null".equals(business_processes)) {
			String[] business_processes_array = business_processes.split(",");
			if (business_processes_array.length == 1) {
				String business_process = new PropertyUtilityClass().getConstantValue(business_processes_array[0]);
				if (business_process != null && !"".equals(business_process)) {
					updateQuery = "UPDATE config set event_notification_bits=convert(VARBINARY(10),"
							+ business_process + ") where currency='" + currency + "'";
				}
			} else if (business_processes_array.length > 1) {
				for (int i = 0; i < business_processes_array.length; i++) {
					int business_processInt = Integer.parseInt(business_processes_array[i]);
					if (business_processInt >= 0 && business_processInt <= 7) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList1.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 8 && business_processInt <= 15) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList2.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 16 && business_processInt <= 23) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList3.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 24 && business_processInt <= 31) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList4.add(Integer.toBinaryString(valueBasedOnLogic));
					} else if (business_processInt >= 32 && business_processInt <= 39) {
						int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
						binaryEquivalentArrayList5.add(Integer.toBinaryString(valueBasedOnLogic));
					}
				}
				if (binaryEquivalentArrayList1.size() > 0) {
					sum1 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList1);
					sum1 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum1);
					if (sum1.length() == 1) {
						sum1 = "0" + sum1;
					}
				}
				if (binaryEquivalentArrayList2.size() > 0) {
					sum2 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList2);
					sum2 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum2);
					if (sum2.length() == 1) {
						sum2 = "0" + sum2;
					}
				}
				if (binaryEquivalentArrayList3.size() > 0) {
					sum3 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList3);
					sum3 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum3);
					if (sum3.length() == 1) {
						sum3 = "0" + sum3;
					}
				}
				if (binaryEquivalentArrayList4.size() > 0) {
					sum4 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList4);
					sum4 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum4);
					if (sum4.length() == 1) {
						sum4 = "0" + sum4;
					}
				}
				if (binaryEquivalentArrayList5.size() > 0) {
					sum5 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList5);
					sum5 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum5);
					if (sum5.length() == 1) {
						sum5 = "0" + sum5;
					}
				}
				if (null != sum1) {
					finalHexadecimalResult = "0x" + sum1;
				} else {
					finalHexadecimalResult = "0x" + "00";
				}
				if (null != sum2) {
					finalHexadecimalResult = finalHexadecimalResult + sum2;
				} else if (null != sum3 || null != sum4 || null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + "00";
				}
				if (null != sum3) {
					finalHexadecimalResult = finalHexadecimalResult + sum3;
				} else if (null != sum4 || null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + "00";
				}
				if (null != sum4) {
					finalHexadecimalResult = finalHexadecimalResult + sum4;
				} else if (null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + "00";
				}
				if (null != sum5) {
					finalHexadecimalResult = finalHexadecimalResult + sum5;
				}
				finalHexadecimalResult = finalHexadecimalResult + "00";
				updateQuery = "UPDATE config set event_notification_bits=convert(VARBINARY(10),"
						+ finalHexadecimalResult + ") where currency='" + currency + "'";
			}
		} else {
			updateQuery = "UPDATE config set event_notification_bits=convert(VARBINARY(10),NULL) where currency='"
					+ currency + "'";
		}
		jdbcTemplate.update(updateQuery);
		status = "Email Notification Bits saved successfully.";
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		status = ERROR;
	}
	return status;
}






@Override
public int saveDealType(DealModel dealModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into deal_type(deal_type,description)values(:deal_type,:description)");
	try {
		addParams.put("deal_type", dealModel.getDealType());
		addParams.put("description", dealModel.getDescription());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateDealType(DealModel dealModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"update deal_type set description=:description where deal_type='" + dealModel.getDealType() + "'");
	try {
		updateParams.put("description", dealModel.getDescription());
		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteDealType(String dealType) {
	int status = 0;
	try {
		String query1 = "delete from deal where deal_id=deal_id and deal_type='" + dealType + "'";
		status = jdbcTemplate.update(query1);

		String query2 = "delete from deal_type where  deal_type='" + dealType + "'";
		status = jdbcTemplate.update(query2);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getDealTypeDetails(String dealType) {
	List<Map<String, Object>> dealTypeInfo = new ArrayList<>();
	try {
		 if(dealType!=null) {
		dealTypeInfo = jdbcTemplate
				.queryForList("select deal_type,description from deal_type where deal_type='" + dealType + "'");
		 }else {
			 dealTypeInfo = jdbcTemplate
						.queryForList("select deal_type,description from deal_type");
		 }

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return dealTypeInfo;
}

@Override
public int saveDealStatus(DealModel dealModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into deal_status(deal_status,description)values(:deal_status,:description)");
	try {
		addParams.put("deal_status", dealModel.getDealStatus());
		addParams.put("description", dealModel.getDescription());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateDealStatus(DealModel dealModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query1 = new StringBuilder("update deal_status set description=:description where deal_status='"
			+ dealModel.getDealStatus() + "'");
	try {
		updateParams.put("description", dealModel.getDescription());
		status = namedParameterJdbcTemplate.update(query1.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getDealStatusDetails(String dealStatus) {
	List<Map<String, Object>> dealStatusDetails = new ArrayList<>();
	try {
		if(dealStatus!=null) {
		dealStatusDetails = jdbcTemplate.queryForList(
				"select deal_status,description from deal_status where deal_status='" + dealStatus + "'");
		}else {
			dealStatusDetails = jdbcTemplate.queryForList(
					"select deal_status,description from deal_status");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return dealStatusDetails;
}

@Override
public int deleteDealStatus(String dealStatus) {
	int status = 0;
	try {
		String query1 = "delete from deal where deal_id=deal_id and deal_status='" + dealStatus + "'";
		status = jdbcTemplate.update(query1);

		String query2 = "delete from deal_status where  deal_status='" + dealStatus + "'";
		status = jdbcTemplate.update(query2);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int saveDemograpic(DemographicModel demographicModel) {
	int status = 0;
	Integer maxId = null;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into dem_question(dem_question_id,respcond_question_id,respcond_response_seq,descr_q_default,multiple_response,response_format,response_required,global_question,misc_text1,misc_text2)"
					+ "values(:dem_question_id,:respcond_question_id,:respcond_response_seq,:descr_q_default,:multiple_response,:response_format,:response_required,:global_question,:misc_text1,:misc_text2)");
	try {
		maxId = jdbcTemplate.queryForObject("select max(id) from mru_dem_question_id", Integer.class);
		if (maxId == null) {
			addParams.put("dem_question_id", 1);

		} else {
			addParams.put("dem_question_id", maxId + 1);
		}

		addParams.put("respcond_question_id", demographicModel.getRespcond_questionId());
		addParams.put("respcond_response_seq", demographicModel.getRespcondResponseSeq());
		addParams.put("descr_q_default", demographicModel.getDescrqDefault());
		addParams.put("multiple_response", demographicModel.getMultipleResponse());
		addParams.put("response_format", demographicModel.getResponseFormate());
		addParams.put("response_required", demographicModel.getResponseRequired());
		addParams.put("global_question", demographicModel.getGlobalQuestion());
		addParams.put("misc_text1", demographicModel.getMiscText1());
		addParams.put("misc_text2", demographicModel.getMiscText2());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int saveDemResponse(DemographicModel demographicModel) {
	int status = 0;
	Integer maxId = null;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into dem_response(dem_question_id,dem_response_seq,respcond_response_seq,respcond_question_id,free_form_input,qualified,active,descr_r_default,label_r_default)"
					+ "values(:dem_question_id,:dem_response_seq,:respcond_response_seq,:respcond_question_id,:free_form_input,:qualified,:active,:descr_r_default,:label_r_default)");
	try {
		maxId = jdbcTemplate.queryForObject("select max(dem_response_seq) from dem_response where dem_question_id="
				+ demographicModel.getDemQuestionId(), Integer.class);
		if (maxId == null) {
			addParams.put("dem_response_seq", 1);
		} else {
			addParams.put("dem_response_seq", maxId + 1);

		}
		addParams.put("dem_question_id", demographicModel.getDemQuestionId());

		addParams.put("respcond_question_id", demographicModel.getRespcond_questionId());
		addParams.put("respcond_response_seq", demographicModel.getRespcondResponseSeq());
		addParams.put("respcond_question_id", demographicModel.getRespcond_questionId());
		addParams.put("free_form_input", demographicModel.getFreeFormInput());
		addParams.put("qualified", demographicModel.getQualified());
		addParams.put("active", demographicModel.getActive());
		addParams.put("descr_r_default", demographicModel.getDescrDefault());
		addParams.put("label_r_default", demographicModel.getLabelrDefault());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateDemQuestion(DemographicModel demographicModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query1 = new StringBuilder(
			"update dem_question set respcond_question_id=:respcond_question_id, respcond_response_seq=:respcond_response_seq,descr_q_default=:descr_q_default,multiple_response=:multiple_response,"
					+ "response_format=:response_format,response_required=:response_required,global_question=:global_question where  dem_question_id="
					+ demographicModel.getDemQuestionId());
	try {

		updateParams.put("respcond_question_id", demographicModel.getRespcond_questionId());
		updateParams.put("respcond_response_seq", demographicModel.getRespcondResponseSeq());
		updateParams.put("descr_q_default", demographicModel.getDescrqDefault());
		updateParams.put("multiple_response", demographicModel.getMultipleResponse());
		updateParams.put("response_format", demographicModel.getResponseFormate());
		updateParams.put("response_required", demographicModel.getResponseRequired());
		updateParams.put("global_question", demographicModel.getGlobalQuestion());

		status = namedParameterJdbcTemplate.update(query1.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}

	return status;
}

@Override
public int updateDemresponse(DemographicModel demographicModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query1 = new StringBuilder(
			"update dem_response set respcond_response_seq=:respcond_response_seq,respcond_question_id=:respcond_question_id,free_form_input=:free_form_input,"
					+ "qualified=:qualified,active=:active,descr_r_default=:descr_r_default,label_r_default=:label_r_default where  dem_response_seq="
					+ demographicModel.getDemResponseSeq() + " and dem_question_id="
					+ demographicModel.getDemQuestionId());
	try {
		updateParams.put("respcond_question_id", demographicModel.getRespcond_questionId());
		updateParams.put("respcond_response_seq", demographicModel.getRespcondResponseSeq());
		updateParams.put("respcond_question_id", demographicModel.getRespcond_questionId());
		updateParams.put("free_form_input", demographicModel.getFreeFormInput());
		updateParams.put("qualified", demographicModel.getQualified());
		updateParams.put("active", demographicModel.getActive());
		updateParams.put("descr_r_default", demographicModel.getDescrDefault());
		updateParams.put("label_r_default", demographicModel.getLabelrDefault());

		status = namedParameterJdbcTemplate.update(query1.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public int deleteDemQuestion(int demQuestionId) {
	int status = 0;
	try {
		String query1 = "delete from dem_question where dem_question_id=" + demQuestionId;
		status = jdbcTemplate.update(query1);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteDemresponse(int demresponseSeq, int demQuestionId) {
	int status = 0;
	try {
		String query1 = "delete from dem_response where dem_question_id=" + demQuestionId + " and dem_response_seq="
				+ demresponseSeq;
		status = jdbcTemplate.update(query1);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getDemographicInfo(int demQuestionId, int demresponseSeq) {
	List<Map<String, Object>> demographicInfo = new ArrayList<>();
	{
		 
		demographicInfo = jdbcTemplate.queryForList(
				"select dem_question_id,dem_response_seq,respcond_response_seq,respcond_question_id,free_form_input,qualified,active,descr_r_default,label_r_default from dem_response where dem_question_id="
						+ demQuestionId + " and dem_response_seq=" + demresponseSeq);
		 
	}
	return demographicInfo;
}

@Override
public List<Map<String, Object>> getDemQuestionDetails(int demQuestionId) {
	List<Map<String, Object>> demQuestionDetails = new ArrayList<>();
	{
	
		demQuestionDetails = jdbcTemplate.queryForList(
				"select dem_question_id,respcond_question_id,respcond_response_seq,descr_q_default,multiple_response,response_format,response_required,global_question,misc_text1,misc_text2 from dem_question where dem_question_id="
						+ demQuestionId);
		
	}

	return demQuestionDetails;
}

@Override
public List<DropdownModel> getQualified() {
	List<DropdownModel> qualifiedDetails = new ArrayList<>();
	for (int i = 0; i <= 2; i++) {
		DropdownModel model = new DropdownModel();
		model.setKey("" + i);
		model.setDisplay(new PropertyUtils().getConstantValue("qualified" + i));

		qualifiedDetails.add(model);
	}
	return qualifiedDetails;
}

@Override
public List<DropdownModel> getFreeFormInput() {

	List<DropdownModel> freeFormInput = new ArrayList<>();
	for (int i = 0; i <= 3; i++) {
		DropdownModel model = new DropdownModel();
		model.setKey("" + i);
		model.setDisplay(new PropertyUtils().getConstantValue("free_form_input" + i));

		freeFormInput.add(model);
	}
	return freeFormInput;
}

@Override
public int saveDisplayctxRedirection(DemographicModel demographicModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into disp_context_redirect(disp_context,disp_context_to_load)values(:disp_context,:disp_context_to_load)");
	try {
		addParams.put("disp_context", demographicModel.getDispContext());
		addParams.put("disp_context_to_load", demographicModel.getDispContextoLoad());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateDisplayctxRedirection(DemographicModel demographicModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"update disp_context_redirect set disp_context=:disp_context,disp_context_to_load=:disp_context_to_load where disp_context='"
					+ demographicModel.getDispContext() + "'");
	try {
		updateParams.put("disp_context", demographicModel.getDispContext1());
		updateParams.put("disp_context_to_load", demographicModel.getDispContextoLoad());

		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteDisplayctxRedirection(String dispContext) {
	int status = 0;
	try {
		String query1 = "delete from disp_context_redirect where disp_context='" + dispContext + "'";
		status = jdbcTemplate.update(query1);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getDisplayctxRedirection(String dispContext) {
	List<Map<String, Object>> displayCtxRedirectionInfo = new ArrayList<>();
	try {
		if(dispContext!=null) {
		displayCtxRedirectionInfo = jdbcTemplate.queryForList(
				"select disp_context,disp_context_to_load from disp_context_redirect where disp_context='"
						+ dispContext + "'");
		}else {
			displayCtxRedirectionInfo = jdbcTemplate.queryForList(
					"select disp_context,disp_context_to_load from disp_context_redirect");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return displayCtxRedirectionInfo;
}

@Override
public List<DropdownModel> getDispCntx() {
	List<Map<String, Object>> dispCntxDetail = new ArrayList<>();
	List<DropdownModel> dispCntxDetailDataList = new ArrayList<>();
	try {
		dispCntxDetail = jdbcTemplate
				.queryForList("select disp_context,description,table_name from disp_context_think");
		for (Map<String, Object> dc : dispCntxDetail) {
			DropdownModel model = new DropdownModel();
			model.setKey(dc.get("disp_context").toString());
			model.setDisplay(dc.get("table_name").toString());
			model.setDescription(dc.get("description") != null ? (String) dc.get("description") : "");

			dispCntxDetailDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return dispCntxDetailDataList;
}

@Override
public List<DropdownModel> getDispContexttoLead() {
	List<Map<String, Object>> dispCntxLead = new ArrayList<>();
	List<DropdownModel> dispCntxLeadDataList = new ArrayList<>();
	try {
		dispCntxLead = jdbcTemplate
				.queryForList("select disp_context,description,table_name from disp_context_tenant");
		for (Map<String, Object> dl : dispCntxLead) {
			DropdownModel model = new DropdownModel();
			model.setKey(dl.get("disp_context").toString());
			model.setDisplay(dl.get("table_name").toString());
			model.setDescription(dl.get("description") != null ? (String) dl.get("description") : "");

			dispCntxLeadDataList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return dispCntxLeadDataList;
}

@Override
public int savelabelFormat(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into label_format(label_format,description)values(:label_format,:description)");
	try {
		addParams.put("label_format", labelModel.getLabelFormat());
		addParams.put("description", labelModel.getDescription());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateLabelFormat(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("update label_format set description=:description where label_format='"
			+ labelModel.getLabelFormat() + "'");
	try {
		updateParams.put("description", labelModel.getDescription());

		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteLabelFormat(String labeFormat, String labelGroup) {
	int status = 0;
	try {
		String query1 = "delete from label_group_format where label_format='" + labeFormat + "' and label_group='"
				+ labelGroup + "'";
		status = jdbcTemplate.update(query1);

		String query2 = "delete from state where  label_format='" + labeFormat + "'";
		status = jdbcTemplate.update(query2);

		String query3 = "delete from label_format where  label_format='" + labeFormat + "'";
		status = jdbcTemplate.update(query3);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getLabelFormateDetails(String labeFormat) {
	List<Map<String, Object>> labelFormatInfo = new ArrayList<>();
	try {
		if(labeFormat!=null) {
		labelFormatInfo = jdbcTemplate.queryForList(
				"select label_format,description from label_format where label_format='" + labeFormat + "'");
		}else {
			labelFormatInfo = jdbcTemplate.queryForList(
					"select label_format,description from label_format");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelFormatInfo;
}

@Override
public List<Map<String, Object>> getlabelGroupDetails(String labelGroup) {
	List<Map<String, Object>> labelGroupInfo = new ArrayList<>();
	try {
		if(labelGroup!=null) {
		labelGroupInfo = jdbcTemplate.queryForList(
				"select label_group,description from label_group where label_group='" + labelGroup + "'");
		}else {
			labelGroupInfo = jdbcTemplate.queryForList(
					"select label_group,description from label_group");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelGroupInfo;
}

@Override
public int savelabelGroup(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder(
			"insert into label_group(label_group,description)values(:label_group,:description)");
	try {
		addParams.put("label_group", labelModel.getLabelGroup());
		addParams.put("description", labelModel.getDescription());

		status = namedParameterJdbcTemplate.update(query.toString(), addParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateLabelGroup(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("update label_group set description=:description where label_group='"+ labelModel.getLabelGroup() + "'");
	try {
		updateParams.put("description", labelModel.getDescription());

		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteLabelGroup(String labelGroup) {

	int status = 0;
	try {

		StringBuilder query = new StringBuilder("delete label_group from label_group L");
		query.append(" left join config C on L.label_group=C.label_group ");
		query.append(" left join job J on L.label_group=J.label_group ");
		query.append(" left join process P on L.label_group=P.label_group ");
		query.append(" where L.label_group='" + labelGroup + "'");

		status = jdbcTemplate.update(query.toString());

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int savelabelKeyline(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("insert into label_keyline(label_keyline,description,suppress_flag,truncate_flag)values(:label_keyline,:description,:suppress_flag,:truncate_flag)");
	
	try {
		addParams.put("label_keyline", labelModel.getLabelKeyline());
		addParams.put("description", labelModel.getDescription());
		addParams.put("suppress_flag", labelModel.getSuppressFlag());
		addParams.put("truncate_flag", labelModel.getTruncateFlag());
		status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int saveLbelKeylineDetails(LabelModel labelModel) {
	int status=0;
	Integer maxId=null;
	Map<String,Object> addParams1=new LinkedHashMap<>();
	StringBuilder query1 = new StringBuilder("insert into label_keyline_detail(label_keyline,label_line_nbr,label_segment_nbr,label_literal,label_segment_type,label_special_type,truncate_priority,table_name,column_name)"
			+ "values(:label_keyline,:label_line_nbr,:label_segment_nbr,:label_literal,:label_segment_type,:label_special_type,:truncate_priority,:table_name,:column_name)");
	try {
		maxId=jdbcTemplate.queryForObject("select max(label_line_nbr) from label_keyline_detail where label_keyline='"+labelModel.getLabelKeyline()+"'", Integer.class);
		if(maxId==null) {
			addParams1.put("label_line_nbr",1);
		}else {
			addParams1.put("label_line_nbr",maxId+1);

		}
		addParams1.put("label_keyline", labelModel.getLabelKeyline());
		addParams1.put("label_segment_nbr",labelModel.getLabelSegmentnbr());
		addParams1.put("column_name",labelModel.getColumnName());
		addParams1.put("table_name",labelModel.getTableName());

		addParams1.put("label_segment_type",labelModel.getLabelSegmentType());
		addParams1.put("label_special_type",labelModel.getLabelSpecialType());

		if(labelModel.getLabelSegmentType()==1) {
		addParams1.put("label_literal",labelModel.getLabelLiteral()); }
		else {
			addParams1.put("label_literal",null);
		}

		  if(labelModel.getLabelSegmentType()==2) {
			LOGGER.info("Special Type");

			if(labelModel.getLabelSpecialType()==0) 
				LOGGER.info("DATE");
			else if(labelModel.getLabelSpecialType()==1) 
				LOGGER.info("TIME");
			else if(labelModel.getLabelSpecialType()==2) {
				LOGGER.info("Issue Info");
				addParams1.put("table_name","issue");

			}
			
		}
			
		addParams1.put("truncate_priority",labelModel.getTruncatePriority());
		status = namedParameterJdbcTemplate.update(query1.toString(), addParams1);


	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return status;
}

@Override
public List<DropdownModel> getTablename() {
	List<DropdownModel> tableName=new ArrayList<>();
	try {
		List<Map<String, Object>> tableNameDetails = jdbcTemplate
				.queryForList("select table_name,description from disp_context WHERE (disp_context) IN ( ('lbl_fmt_customer'), ('lbl_fmt_customer_address'),('lbl_fmt_oc'),('lbl_fmt_order_code'),('lbl_fmt_order_item'), ('lbl_fmt_orderhdr'), ('lbl_fmt_state') )");
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
public List<DropdownModel> getColumnname() {
	List<DropdownModel> columnName=new ArrayList<>();
	for(int i=1;i<=9;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("column_name" + i));
		columnName.add(model);
	}
	return columnName;
}

@Override
public List<DropdownModel> getDemQuestion() {
	List<DropdownModel> demQuestion=new ArrayList<>();
	try {
		List<Map<String,Object>> demQuestionDetails=jdbcTemplate.queryForList("select descr_q_default from dem_question");
		for (Map<String, Object> dq : demQuestionDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(dq.get("descr_q_default").toString());

			demQuestion.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return demQuestion;
}

@Override
public int updatelabelKeyline(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("update label_keyline set description=:description,suppress_flag=:suppress_flag,truncate_flag=:truncate_flag where label_keyline='"+ labelModel.getLabelKeyline() + "'");
	try {
		updateParams.put("description", labelModel.getDescription());
		updateParams.put("suppress_flag", labelModel.getSuppressFlag());
		updateParams.put("truncate_flag", labelModel.getTruncateFlag());


		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;

}

@Override
public int updateLabelKeylineDetail(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("update label_keyline_detail set label_segment_nbr=:label_segment_nbr,label_literal=:label_literal,label_segment_type=:label_segment_type,label_special_type=:label_special_type,truncate_priority=:truncate_priority,table_name=:table_name,column_name=:column_name"
			+ " where label_keyline='"+ labelModel.getLabelKeyline() + "'and label_line_nbr="+labelModel.getLabelLinenbr());
	try {
		updateParams.put("label_segment_nbr",labelModel.getLabelSegmentnbr());
		updateParams.put("column_name",labelModel.getColumnName());
		updateParams.put("table_name",labelModel.getTableName());

		updateParams.put("label_segment_type",labelModel.getLabelSegmentType());
		updateParams.put("label_special_type",labelModel.getLabelSpecialType());

		if(labelModel.getLabelSegmentType()==1) {
			updateParams.put("label_literal",labelModel.getLabelLiteral()); }
		else {
			updateParams.put("label_literal",null);
		}

		  if(labelModel.getLabelSegmentType()==2) {
			LOGGER.info("Special Type");

			if(labelModel.getLabelSpecialType()==0) 
				LOGGER.info("DATE");
			else if(labelModel.getLabelSpecialType()==1) 
				LOGGER.info("TIME");
			else if(labelModel.getLabelSpecialType()==2) {
				LOGGER.info("Issue Info");
				updateParams.put("table_name","issue");

			}
			
		}
		  updateParams.put("truncate_priority",labelModel.getTruncatePriority());
		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);


}catch (Exception e) {
	LOGGER.error(ERROR + e);
}

return status;

}

@Override
public List<DropdownModel> getColumnnameInfo() {
	List<DropdownModel> columnName=new ArrayList<>();
	for(int i=1;i<=38;i++) {
		DropdownModel model=new DropdownModel();
		model.setKey(""+i);
		model.setDisplay(new PropertyUtils().getConstantValue("column_name" + i));
		columnName.add(model);
	}
	return columnName;
}

@Override
public List<Map<String, Object>> labelKeylineDetails(String labelKeyline) {
	List<Map<String,Object>> labelkeylinevalues=new ArrayList<>();
	try {
		if(labelKeyline!=null) {
		labelkeylinevalues=jdbcTemplate.queryForList("select label_keyline,description,suppress_flag,truncate_flag from label_keyline where label_keyline='"+labelKeyline+"'");
		}else {
			labelkeylinevalues=jdbcTemplate.queryForList("select label_keyline,description,suppress_flag,truncate_flag from label_keyline");
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelkeylinevalues;
}

@Override
public List<Map<String, Object>> labelKeylineInfo(String labelKeyline, int labelLinenbr) {
	List<Map<String,Object>> labelkeylineDetailInfo=new ArrayList<>();
	try {
		labelkeylineDetailInfo=jdbcTemplate.queryForList("select label_segment_nbr,label_literal,label_segment_type,label_special_type,truncate_priority,table_name,column_name from label_keyline_detail where label_keyline='"+labelKeyline+"'and label_line_nbr="+labelLinenbr);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelkeylineDetailInfo;
}

@Override
public int deletelabelKeylineDetail(String labelKeyline, int labelLinenbr) {
	int status = 0;
	try {
		String query1 = "delete from label_keyline_detail where label_keyline='" + labelKeyline + "' and label_line_nbr="+ labelLinenbr ;
		status = jdbcTemplate.update(query1);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteLabelkeyline(String labelKeyline) {
	int status = 0;
	try {
		String query1 = "delete from label_keyline where label_keyline='" + labelKeyline + "'";
				
		status = jdbcTemplate.update(query1);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> getLabelgroupFormatDetails(String labelGroup) {
	List<Map<String,Object>> labelGroupFormat=new ArrayList<>();
	try {
		labelGroupFormat=jdbcTemplate.queryForList("select suppress_flag,truncate_flag,label_group,label_format from label_group_format where label_group='"+labelGroup+"'");
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelGroupFormat;
}

@Override
public List<DropdownModel> getlabelGroupInfo() {
	List<DropdownModel> labelGroup=new ArrayList<>();
	try {
		List<Map<String,Object>> labelGroupInfo=jdbcTemplate.queryForList("select label_group,description from label_group");
		for (Map<String, Object> lead : labelGroupInfo) {
			DropdownModel model = new DropdownModel();
			model.setKey(lead.get("label_group").toString());
			model.setDisplay(lead.get("description").toString());
			labelGroup.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return labelGroup;
}

@Override
public List<DropdownModel> getLabelFormat() {
	List<DropdownModel> labelFormat=new ArrayList<>();
	try {
		List<Map<String,Object>> labelFormatDetail=jdbcTemplate.queryForList("select label_format,description from label_format");
		for (Map<String, Object> format : labelFormatDetail) {
			DropdownModel model = new DropdownModel();
			model.setKey(format.get("label_format").toString());
			model.setDisplay(format.get("description").toString());
			labelFormat.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return labelFormat;
}

@Override
public List<Map<String, Object>> getFinalLabel(String labelGroup, int labelLinenbr) {
	List<Map<String,Object>> labelkeylineDetailInfo=new ArrayList<>();
	try {
		labelkeylineDetailInfo=jdbcTemplate.queryForList("select label_segment_nbr,label_literal,label_segment_type,label_special_type,truncate_priority,table_name,column_name from label_format_detail where label_group='"+labelGroup+"'and label_line_nbr="+labelLinenbr);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return labelkeylineDetailInfo;
}

@Override
public int saveLabel(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> addParams = new LinkedHashMap<>();
	StringBuilder query1 = new StringBuilder("insert into label_group_format(label_group,label_format,suppress_flag,truncate_flag)values(:label_group,:label_format,:suppress_flag,:truncate_flag)");
	
	try {
		addParams.put("label_group", labelModel.getLabelGroup());
		addParams.put("label_format", labelModel.getLabelFormat());
		addParams.put("suppress_flag", labelModel.getSuppressFlag());
		addParams.put("truncate_flag", labelModel.getTruncateFlag());
		status = namedParameterJdbcTemplate.update(query1.toString(), addParams);
		

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int updateLabel(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("update label_group_format set suppress_flag=:suppress_flag,truncate_flag=:truncate_flag where label_format='"+ labelModel.getLabelFormat() + "'");
	try {
		updateParams.put("suppress_flag", labelModel.getSuppressFlag());
		updateParams.put("truncate_flag", labelModel.getTruncateFlag());


		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int saveLabelFormatDetail(LabelModel labelModel) {
	int status=0;
	Integer maxId=null;
	Map<String,Object> addParams1=new LinkedHashMap<>();
	StringBuilder query1 = new StringBuilder("insert into label_format_detail(label_group,label_format,label_line_nbr,label_segment_nbr,label_literal,label_segment_type,label_special_type,truncate_priority,table_name,column_name)"
			+ "values(:label_group,:label_format,:label_line_nbr,:label_segment_nbr,:label_literal,:label_segment_type,:label_special_type,:truncate_priority,:table_name,:column_name)");
	try {
		maxId=jdbcTemplate.queryForObject("select max(label_line_nbr) from label_format_detail where label_format='"+labelModel.getLabelFormat()+"'", Integer.class);
		if(maxId==null) {
			addParams1.put("label_line_nbr",1);
		}else {
			addParams1.put("label_line_nbr",maxId+1);

		}
		addParams1.put("label_group", labelModel.getLabelGroup());
		addParams1.put("label_format", labelModel.getLabelFormat());

		addParams1.put("label_segment_nbr",labelModel.getLabelSegmentnbr());
		addParams1.put("column_name",labelModel.getColumnName());
		addParams1.put("table_name",labelModel.getTableName());

		addParams1.put("label_segment_type",labelModel.getLabelSegmentType());
		addParams1.put("label_special_type",labelModel.getLabelSpecialType());

		if(labelModel.getLabelSegmentType()==1) {
		addParams1.put("label_literal",labelModel.getLabelLiteral()); }
		else {
			addParams1.put("label_literal",null);
		}

		  if(labelModel.getLabelSegmentType()==2) {
			LOGGER.info("Special Type");

			if(labelModel.getLabelSpecialType()==0) 
				LOGGER.info("DATE");
			else if(labelModel.getLabelSpecialType()==1) 
				LOGGER.info("TIME");
			else if(labelModel.getLabelSpecialType()==2) {
				LOGGER.info("Issue Info");
				addParams1.put("table_name","issue");

			}
			
		}
			
		addParams1.put("truncate_priority",labelModel.getTruncatePriority());
		status = namedParameterJdbcTemplate.update(query1.toString(), addParams1);


	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return status;
}

@Override
public int updateLabelFormatDetail(LabelModel labelModel) {
	int status = 0;
	Map<String, Object> updateParams = new LinkedHashMap<>();
	StringBuilder query = new StringBuilder("update label_format_detail set label_segment_nbr=:label_segment_nbr,label_literal=:label_literal,label_segment_type=:label_segment_type,label_special_type=:label_special_type,truncate_priority=:truncate_priority,table_name=:table_name,column_name=:column_name"
			+ " where label_format='"+ labelModel.getLabelFormat() + "'and label_line_nbr="+labelModel.getLabelLinenbr());
	try {
		updateParams.put("label_segment_nbr",labelModel.getLabelSegmentnbr());
		updateParams.put("column_name",labelModel.getColumnName());
		updateParams.put("table_name",labelModel.getTableName());

		updateParams.put("label_segment_type",labelModel.getLabelSegmentType());
		updateParams.put("label_special_type",labelModel.getLabelSpecialType());

		if(labelModel.getLabelSegmentType()==1) {
			updateParams.put("label_literal",labelModel.getLabelLiteral()); }
		else {
			updateParams.put("label_literal",null);
		}

		  if(labelModel.getLabelSegmentType()==2) {
			LOGGER.info("Special Type");

			if(labelModel.getLabelSpecialType()==0) 
				LOGGER.info("DATE");
			else if(labelModel.getLabelSpecialType()==1) 
				LOGGER.info("TIME");
			else if(labelModel.getLabelSpecialType()==2) {
				LOGGER.info("Issue Info");
				updateParams.put("table_name","issue");

			}
			
		}
		  updateParams.put("truncate_priority",labelModel.getTruncatePriority());
		status = namedParameterJdbcTemplate.update(query.toString(), updateParams);


}catch (Exception e) {
	LOGGER.error(ERROR + e);
}
	return status;
}

@Override
public int deleteLabelDetails(String labelFormat, int labelLinenbr) {
	int status = 0;
	try {
		String query1 = "delete from label_format_detail where label_format='" + labelFormat + "' and label_line_nbr="+labelLinenbr;
		status = jdbcTemplate.update(query1);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public int deleteLabel(String labelFormat) {
	int status = 0;
	try {
		String query = "delete from label_group_format where label_format='" + labelFormat + "'";
		status = jdbcTemplate.update(query);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

@Override
public List<Map<String, Object>> installmentPlanDetails(int installmentPlanId) {
	List<Map<String,Object>> installmentPlanDetails=new ArrayList<>();
	try {
		installmentPlanDetails=jdbcTemplate.queryForList("select installment_plan_id,report,description,auto_setup,allow_default_usage,nbr_installments,interval,unpaid_issues_new,unpaid_issues_renew,interval_type from installment_plan where installment_plan_id="+installmentPlanId);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return installmentPlanDetails;
}

@Override
public List<Map<String, Object>> installPlanInfo(int installmentPlanId, int installPlanDetailSeq) {
	List<Map<String,Object>> installPlanInfo=new ArrayList<>();
	try {
		installPlanInfo=jdbcTemplate.queryForList("select installment_plan_id,install_plan_detail_seq,interval,unpaid_issues_new,unpaid_issues_renew,interval_type,payment_required from install_plan_detail where installment_plan_id="+installmentPlanId+" and install_plan_detail_seq="+installPlanDetailSeq);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return installPlanInfo;
}

@Override
public List<DropdownModel> getOutput() {
List<DropdownModel> output=new ArrayList<>();
List<Map<String,Object>> outputDetails=new ArrayList<>();
try {
	outputDetails=jdbcTemplate.queryForList("select report,description from report");
	for(Map<String,Object> outputInfo:outputDetails) {
		DropdownModel model=new DropdownModel();
		model.setKey(outputInfo.get("report").toString());
		model.setDisplay(outputInfo.get("description").toString());
		output.add(model);
	}
}catch (Exception e) {
	LOGGER.error(ERROR + e);
}
	return output;
}

@Override
public List<Map<String, Object>> settleRetryDefInfo(String settleRetryDef) {
	List<Map<String,Object>> settleRetryDetail=new ArrayList<>();
	try {
		settleRetryDetail=jdbcTemplate.queryForList("select settle_retry_def,description,max_retries,n_days_between_retries,suspend_after_n_settle_retries,cancel_itm_after_last_retry from settle_retry_def where settle_retry_def='"+settleRetryDef+"'");
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return settleRetryDetail;
}

@Override
public List<Map<String, Object>> getQtyDiscountSchedule(String qtyDiscountSchedule) {
	List<Map<String,Object>> qtyDiscountSched=new ArrayList<>();
	try {
		if(qtyDiscountSchedule!=null) {
		qtyDiscountSched=jdbcTemplate.queryForList("select qty_discount_schedule,description,discount_amt_calc_type from qty_discount_schedule where qty_discount_schedule='"+qtyDiscountSchedule+"'");
		}else
		{
			qtyDiscountSched=jdbcTemplate.queryForList("select qty_discount_schedule,description,discount_amt_calc_type from qty_discount_schedule");
		}
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return qtyDiscountSched;
}

@Override
public List<Map<String, Object>> getQtyDiscountSchedDtl(String qtyDiscountSchedule) {

	List<Map<String,Object>> qtyDiscountSchedDtl=new ArrayList<>();
	try {
		if(qtyDiscountSchedule!=null) {
		qtyDiscountSchedDtl=jdbcTemplate.queryForList("select qty_discount_schedule,from_qty,to_qty,amount,qty_discount_percent,qty_discount_sched_dtl_seq,from_amt,to_amt from qty_discount_sched_dtl where qty_discount_schedule='"+qtyDiscountSchedule+"'");
		}else {
			qtyDiscountSchedDtl=jdbcTemplate.queryForList("select qty_discount_schedule,from_qty,to_qty,amount,qty_discount_percent,qty_discount_sched_dtl_seq,from_amt,to_amt from qty_discount_sched_dtl");
		}
		
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}return qtyDiscountSchedDtl;
}

@Override
public List<DropdownModel> getDiscountamtCalcType() {
	List<DropdownModel> discountamtCalcType=new ArrayList<>();
		for(int i=0;i<=2;i++) {
			DropdownModel model=new DropdownModel();
			model.setKey(""+i);
			model.setDisplay(new PropertyUtils().getConstantValue("discount_amt_calc_type"+i));
			discountamtCalcType.add(model);
		}
	
	return discountamtCalcType;
}

@Override
public List<Map<String, Object>> getMultilineDiscountSchedule(String multilineDiscountSchedule) {
	List<Map<String,Object>> mutilineDiscountSchedule=new ArrayList<>();
	try {
		if(multilineDiscountSchedule!=null) {
		mutilineDiscountSchedule=jdbcTemplate.queryForList("select multiline_discount_schedule,description,discount_calc_type from multiline_discount_schedule where multiline_discount_schedule='"+multilineDiscountSchedule+"'");
		}else {
			mutilineDiscountSchedule=jdbcTemplate.queryForList("select multiline_discount_schedule,description,discount_calc_type from multiline_discount_schedule");
		}
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return mutilineDiscountSchedule;
}

@Override
public List<Map<String, Object>> getMultilineDiscEffective(String multilineDiscountSchedule,int multilineDiscEffSeq) {
	List<Map<String,Object>> multilineDiscEff=new ArrayList<>();
	try {
		multilineDiscEff=jdbcTemplate.queryForList("select multiline_discount_schedule,effective_date,multiline_disc_eff_seq,description,renewal_expire_effective_date from multiline_disc_eff where multiline_discount_schedule='"+multilineDiscountSchedule+"' and multiline_disc_eff_seq="+multilineDiscEffSeq);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return multilineDiscEff;
}

@Override
public List<Map<String, Object>> getMultiDiscSchedDtl(String multilineDiscountSchedule,int multiDiscScheddtlSeq) {
	List<Map<String,Object>> multiDiscScheddtl=new ArrayList<>();
	try {
		multiDiscScheddtl=jdbcTemplate.queryForList("select currency,from_qty,to_qty,from_amt,to_amt,amount,multiline_discount_percent,multiline_discount_schedule,multi_disc_sched_dtl_seq,multiline_disc_eff_seq from multi_disc_sched_dtl where multiline_discount_schedule='"+multilineDiscountSchedule+"' and multi_disc_sched_dtl_seq="+multiDiscScheddtlSeq);
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return multiDiscScheddtl;
}

@Override
public List<DropdownModel> getReportitemId() {
	List<DropdownModel> reportItem=new ArrayList<>();
	List<Map<String,Object>> reportitemDetails=new ArrayList<>();
	try {
		reportitemDetails=jdbcTemplate.queryForList("select report_item_id,description,name,title from report_item where report_item_id IN (101,102,103,104,105,110,112,120,177,178,179,180,181,182,183,184,1000)");
		for(Map<String,Object> reportInfo:reportitemDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(reportInfo.get("report_item_id").toString());
			model.setDisplay(reportInfo.get("description").toString());
			model.setDescription(reportInfo.get("name").toString());
			model.setExtra(reportInfo.get("title").toString());
			reportItem.add(model);
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return reportItem;
}

@Override
public List<Map<String, Object>> getServiceCause(String causeCode) {
List<Map<String,Object>> serviceCause=new ArrayList<>();
try {
	if(causeCode!=null) {
	serviceCause=jdbcTemplate.queryForList("select cause_code,description,memo_required,report_item_id,email_report_url from cause_code where cause_code='"+causeCode+"'");
	}else {
		serviceCause=jdbcTemplate.queryForList("select cause_code,description,memo_required,report_item_id,email_report_url from cause_code");
	}
}catch (Exception e) {
	LOGGER.error(ERROR + e);
}
	return serviceCause;
}

@Override
public List<DropdownModel> getCauseCode() {
List<DropdownModel> causeCode=new ArrayList<>();
List<Map<String,Object>> causeCodeDetails=new ArrayList<>();
try {
	causeCodeDetails=jdbcTemplate.queryForList("select cause_code,description from cause_code");
	for(Map<String,Object>cause:causeCodeDetails) {
		DropdownModel model=new DropdownModel();
		model.setKey(cause.get("cause_code").toString());
		model.setDisplay(cause.get("description").toString());
		causeCode.add(model);
	}
}catch (Exception e) {
	LOGGER.error(ERROR + e);
}
	return causeCode;
}

@Override
public List<DropdownModel> getServicetoPerform() {
	List<DropdownModel> servicetoPerform=new ArrayList<>();
	List<Map<String,Object>> servicePerformDetails=new ArrayList<>();
	try {
		servicePerformDetails=jdbcTemplate.queryForList("select service_code,description from service_code");
		for(Map<String,Object>cause:servicePerformDetails) {
			DropdownModel model=new DropdownModel();
			model.setKey(cause.get("service_code").toString());
			model.setDisplay(cause.get("description").toString());
			servicetoPerform.add(model);
		}
	}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return servicetoPerform;
}

@Override
public List<Map<String, Object>> getServiceComplaints(String complaintCode) {

	List<Map<String,Object>> serviceComplainteDetail=new ArrayList<>();
	try {
		if(complaintCode!=null) {
		serviceComplainteDetail=jdbcTemplate.queryForList("select cause_code,description,memo_required,report_item_id,email_report_url,complaint_code,service_code,followup_required from complaint_code WHERE complaint_code='"+complaintCode+"'");
		}else {
			serviceComplainteDetail=jdbcTemplate.queryForList("select cause_code,description,memo_required,report_item_id,email_report_url,complaint_code,service_code,followup_required from complaint_code");	
		}
		}catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return serviceComplainteDetail;
}

@Override
public List<Map<String, Object>> getServiceResolution(String serviceCode) {
List<Map<String,Object>> serviceResolution=new ArrayList<>();
try {
	if(serviceCode!=null) {
	serviceResolution=jdbcTemplate.queryForList("select description,memo_required,report_item_id,email_report_url,close_complaint,service_code,auto_replace,use_carry_over,enforce_shipped_issues from service_code where service_code='"+serviceCode+"'");
	}else {
		serviceResolution=jdbcTemplate.queryForList("select description,memo_required,report_item_id,email_report_url,close_complaint,service_code,auto_replace,use_carry_over,enforce_shipped_issues from service_code");
	}
	}catch (Exception e) {
	LOGGER.error(ERROR + e);
}
	return serviceResolution;
}

@Override
public int saveBasicPrice(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addBasicPrice = new LinkedHashMap<>();
	try {

		String  basicPriceQuery = "insert into audit_basic_price(audit_basic_price_id,low_percent,high_percent,audit_pub_group,description) " + "values(:audit_basic_price_id,:low_percent,:high_percent,:audit_pub_group,:description)";
		
		int maxAuditBasicPriceId= jdbcTemplate.queryForObject("select  max(audit_basic_price_id) from audit_basic_price",Integer.class);
		
		//addBasicPrice.put("audit_basic_price_id",auditModel.getAuditBasicPriceId());
		addBasicPrice.put("audit_basic_price_id",maxAuditBasicPriceId+1);
		addBasicPrice.put("low_percent",auditModel.getLowPercent());
		addBasicPrice.put("high_percent",auditModel.getHighPercent());
		addBasicPrice.put("audit_pub_group",auditModel.getAuditPubGroup());
		addBasicPrice.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(basicPriceQuery,addBasicPrice);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateBasicPrice(AuditModel auditModel) {
   int status = 0;
	
	try {
		Map<String, Object> updateBasicPrice = new LinkedHashMap<>();
		String  auditBasicPriceQuery = "update audit_basic_price set low_percent=:low_percent,high_percent=:high_percent,audit_pub_group=:audit_pub_group,description=:description    where audit_basic_price_id= '"
				+auditModel.getAuditBasicPriceId()+"'";
		updateBasicPrice.put("low_percent",auditModel.getLowPercent());
		updateBasicPrice.put("high_percent",auditModel.getHighPercent());
		updateBasicPrice.put("audit_pub_group",auditModel.getAuditPubGroup());
		updateBasicPrice.put("description",auditModel.getDescription());
        status = namedParameterJdbcTemplate.update(auditBasicPriceQuery,updateBasicPrice);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteBasicPrice(int auditBasicPriceId) {
	int status = 0;
	try {

		String deleteAuditBasicPrice = "delete from audit_basic_price where audit_basic_price_id = " +auditBasicPriceId;
		status = jdbcTemplate.update(deleteAuditBasicPrice);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getBasicPrice(int auditBasicPriceId) {
	List<Map<String, Object>>  auditBasicPriceDetails = new ArrayList<>();
	try {
		if(auditBasicPriceId != 0) {
		 auditBasicPriceDetails= jdbcTemplate.queryForList("select audit_basic_price_id,low_percent,high_percent,audit_pub_group,description  from audit_basic_price  where audit_basic_price_id= "+auditBasicPriceId);
		}else {
			 auditBasicPriceDetails= jdbcTemplate.queryForList("select audit_basic_price_id,low_percent,high_percent,audit_pub_group,description from audit_basic_price");
		}                                                                                                                                                                                    
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  auditBasicPriceDetails;
}

@Override
public List<DropdownModel> getPubGroupList() {
	List<DropdownModel>  pubGroupList = new ArrayList<>();
	try {
		List<Map<String, Object>> pubGroupDetails = jdbcTemplate.queryForList("select audit_pub_group,description from  audit_pub_group");
		for (Map<String, Object> getPubGroup :pubGroupDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getPubGroup.get("audit_pub_group").toString());
			model.setDisplay(getPubGroup.get("description").toString());
			
			pubGroupList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return pubGroupList;
}

@Override
public int saveAuditDuration(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addAuditDuration = new LinkedHashMap<>();
	try {

		String auditDurationQuery = "insert into audit_duration(audit_duration_id,low_n_months,high_n_months,audit_pub_group,description) " + "values(:audit_duration_id,:low_n_months,:high_n_months,:audit_pub_group,:description)";
		
		int maxAuditDurationId= jdbcTemplate.queryForObject("select  max(audit_duration_id) from audit_duration",Integer.class);
		//addAuditDuration.put("audit_duration_id",auditModel.getAuditDurationId());
		addAuditDuration.put("audit_duration_id",maxAuditDurationId+1);
		addAuditDuration.put("low_n_months",auditModel.getLowNumMonths());
		addAuditDuration.put("high_n_months",auditModel.getHighNumMonths());
		addAuditDuration.put("audit_pub_group",auditModel.getAuditPubGroup());
		addAuditDuration.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(auditDurationQuery,addAuditDuration);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateAuditDuration(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateAuditDuration = new LinkedHashMap<>();
		String  auditDurationQuery = "update audit_duration set low_n_months=:low_n_months,high_n_months=:high_n_months,audit_pub_group=:audit_pub_group,description=:description where audit_duration_id="
				+auditModel.getAuditDurationId();
		   updateAuditDuration.put("audit_duration_id",auditModel.getAuditDurationId());
		   updateAuditDuration.put("low_n_months",auditModel.getLowNumMonths());
		   updateAuditDuration.put("high_n_months",auditModel.getHighNumMonths());
		   updateAuditDuration.put("audit_pub_group",auditModel.getAuditPubGroup());
		   updateAuditDuration.put("description",auditModel.getDescription());

        status = namedParameterJdbcTemplate.update(auditDurationQuery,updateAuditDuration);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteAuditDuration(int auditDurationId) {
	int status = 0;
	try {

		String deleteAuditDuration = "delete from audit_duration where audit_duration_id = " +auditDurationId;
		status = jdbcTemplate.update(deleteAuditDuration);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
}

@Override
public List<Map<String, Object>> getAuditDuration(int auditDurationId) {
	List<Map<String, Object>>  auditDurationDetails = new ArrayList<>();
	try {
		if(auditDurationId!=0)
		{
		auditDurationDetails= jdbcTemplate.queryForList("select audit_duration_id,low_n_months,high_n_months,audit_pub_group,description  from audit_duration where audit_duration_id= "+auditDurationId);
		}else {
			auditDurationDetails= jdbcTemplate.queryForList("select audit_duration_id,low_n_months,high_n_months,audit_pub_group,description  from audit_duration");
		}
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  auditDurationDetails ;
}

@Override
public int saveMailingAddressName(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addAuditNameTitle = new LinkedHashMap<>();
	try {

		String  auditNameTitleQuery = "insert into audit_name_title(audit_name_title_id,audit_name_title,audit_pub_group,qp,qf,nqp,nqf,description) " + "values(:audit_name_title_id,:audit_name_title,:audit_pub_group,:qp,:qf,:nqp,:nqf,:description)";
		int maxAuditNameTitleId= jdbcTemplate.queryForObject("select  max(audit_name_title_id) from audit_name_title",Integer.class);
		//addAuditNameTitle.put("audit_name_title_id",auditModel.getAuditNameTitleId());
		addAuditNameTitle.put("audit_name_title_id",maxAuditNameTitleId+1);
		addAuditNameTitle.put("audit_name_title",auditModel.getAuditNameTitle());
		addAuditNameTitle.put("qp",auditModel.isQp());
		addAuditNameTitle.put("qf",auditModel.isQf());
		addAuditNameTitle.put("nqp",auditModel.isNqp());
		addAuditNameTitle.put("nqf",auditModel.isNqf());
		addAuditNameTitle.put("audit_pub_group",auditModel.getAuditPubGroup());
		addAuditNameTitle.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(auditNameTitleQuery,addAuditNameTitle);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateMailingAddressName(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateAuditNameTitle= new LinkedHashMap<>();
		String  auditNameTitleQuery = "update audit_name_title set audit_name_title=:audit_name_title,audit_pub_group=:audit_pub_group,qp=:qp,qf=:qf,nqp=:nqp,nqf=:nqf,description=:description where audit_name_title_id="
				+auditModel.getAuditNameTitleId();
		        
		        //updateAuditNameTitle.put("audit_name_title_id",auditModel.getAuditNameTitleId());
				updateAuditNameTitle.put("audit_name_title",auditModel.getAuditNameTitle());
				updateAuditNameTitle.put("qp",auditModel.isQp());
				updateAuditNameTitle.put("qf",auditModel.isQf());
				updateAuditNameTitle.put("nqp",auditModel.isNqp());
				updateAuditNameTitle.put("nqf",auditModel.isNqf());
				updateAuditNameTitle.put("audit_pub_group",auditModel.getAuditPubGroup());
				updateAuditNameTitle.put("description",auditModel.getDescription());

        status = namedParameterJdbcTemplate.update(auditNameTitleQuery,updateAuditNameTitle);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteMailingAddressName(int auditNameTitleId) {
	int status = 0;
	try {
		String deleteMailingAddressName = "delete from audit_name_title where audit_name_title_id =" +auditNameTitleId;
		status = jdbcTemplate.update(deleteMailingAddressName);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
	return status;
}

@Override
public List<Map<String, Object>> getMailingAddressName(int auditNameTitleId) {
	List<Map<String, Object>>  mailingAddressNameDetails = new ArrayList<>();
	try {
		if(auditNameTitleId!=0)
		{
		mailingAddressNameDetails= jdbcTemplate.queryForList("select audit_name_title_id,audit_name_title,audit_pub_group,qp,qf,nqp,nqf,description from audit_name_title where audit_name_title_id= "+auditNameTitleId);
		}else {
			mailingAddressNameDetails= jdbcTemplate.queryForList("select audit_name_title_id,audit_name_title,audit_pub_group,qp,qf,nqp,nqf,description from audit_name_title");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  mailingAddressNameDetails;
}

@Override
public int savePublicationGroup(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addPubGroup = new LinkedHashMap<>();
	try {

		String  pubGroupQuery = "insert into audit_pub_group(audit_pub_group,description) " + "values(:audit_pub_group,:description)";
		addPubGroup.put("audit_pub_group",auditModel.getAuditPubGroup());
		addPubGroup.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(pubGroupQuery,addPubGroup);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updatePublicationGroup(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updatePubGroup = new LinkedHashMap<>();
		String  pubGroupQuery = "update audit_pub_group set description=:description where audit_pub_group='"
				+auditModel.getAuditPubGroup()+"'";
		   
		//updatePubGroup.put("audit_pub_group",auditModel.getAuditPubGroup());
		updatePubGroup.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(pubGroupQuery,updatePubGroup);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deletePublicationGroup(String auditPubGroup) {
	int status = 0;
	try {
		String deletePubGroup = "delete from audit_pub_group where audit_pub_group='" +auditPubGroup+"'";
		status = jdbcTemplate.update(deletePubGroup);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
	return status;
}

@Override
public List<Map<String, Object>> getPublicationGroup(String auditPubGroup) {
	List<Map<String, Object>>  pubGroupDetails = new ArrayList<>();
	try {
		if(auditPubGroup!=null)
		{
		 pubGroupDetails= jdbcTemplate.queryForList("select audit_pub_group,description from audit_pub_group where audit_pub_group= '"+auditPubGroup+"'");
		}else {
			 pubGroupDetails= jdbcTemplate.queryForList("select audit_pub_group,description from audit_pub_group");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  pubGroupDetails;
}

@Override
public int saveQualificationSource(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addQualificationSource = new LinkedHashMap<>();
	try {

		String  qualificationSourceQuery = "insert into audit_qual_source(audit_qual_source_id,audit_qual_source,audit_pub_group,qp,qf,nqp,nqf,description) " + "values(:audit_qual_source_id,:audit_qual_source,:audit_pub_group,:qp,:qf,:nqp,:nqf,:description)";
		int maxAuditQualSourceId= jdbcTemplate.queryForObject("select  max(audit_qual_source_id) from audit_qual_source",Integer.class);
		
		//addQualificationSource.put("audit_qual_source_id",auditModel.getAuditQualSourceId());
		addQualificationSource.put("audit_qual_source_id",maxAuditQualSourceId+1);
		addQualificationSource.put("audit_qual_source",auditModel.getAuditQualSource());
		addQualificationSource.put("qp",auditModel.isQp());
		addQualificationSource.put("qf",auditModel.isQf());
		addQualificationSource.put("nqp",auditModel.isNqp());
		addQualificationSource.put("nqf",auditModel.isNqf());
		addQualificationSource.put("audit_pub_group",auditModel.getAuditPubGroup());
		addQualificationSource.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(qualificationSourceQuery,addQualificationSource);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateQualificationSource(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateQualificationSource= new LinkedHashMap<>();
		String  auditQualSourceQuery = "update audit_qual_source  set audit_qual_source=:audit_qual_source,audit_pub_group=:audit_pub_group,qp=:qp,qf=:qf,nqp=:nqp,nqf=:nqf,description=:description where audit_qual_source_id="
				+auditModel.getAuditQualSourceId();
		        
		updateQualificationSource.put("audit_qual_source_id",auditModel.getAuditQualSourceId());
		updateQualificationSource.put("audit_qual_source",auditModel.getAuditQualSource());
		updateQualificationSource.put("qp",auditModel.isQp());
		updateQualificationSource.put("qf",auditModel.isQf());
		updateQualificationSource.put("nqp",auditModel.isNqp());
		updateQualificationSource.put("nqf",auditModel.isNqf());
		updateQualificationSource.put("audit_pub_group",auditModel.getAuditPubGroup());
		updateQualificationSource.put("description",auditModel.getDescription());

        status = namedParameterJdbcTemplate.update(auditQualSourceQuery,updateQualificationSource);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteQualificationSource(int auditQualSourceId) {
	int status = 0;
	try {
		String deleteAuditQualSource = "delete from audit_qual_source where audit_qual_source_id=" +auditQualSourceId;
		status = jdbcTemplate.update(deleteAuditQualSource);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
	return status;
}

@Override
public List<Map<String, Object>> getQualificationSource(int auditQualSourceId) {
	List<Map<String, Object>>  qualSourceDetails = new ArrayList<>();
	try {
		if(auditQualSourceId!=0) {
		qualSourceDetails= jdbcTemplate.queryForList("select audit_qual_source_id,audit_qual_source,audit_pub_group,qp,qf,nqp,nqf,description from audit_qual_source where audit_qual_source_id= "+auditQualSourceId);
		}else {
			qualSourceDetails= jdbcTemplate.queryForList("select audit_qual_source_id,audit_qual_source,audit_pub_group,qp,qf,nqp,nqf,description from audit_qual_source");	
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  qualSourceDetails;
}

@Override
public int saveDemoGraphicCrossTab(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addAuditReport = new LinkedHashMap<>();
	try {

		String   auditReportQuery = "insert into audit_report(audit_report_id,audit_report,dem_question_id1,dem_question_id2,audit_pub_group,description) " + "values(:audit_report_id,:audit_report,:dem_question_id1,:dem_question_id2,:audit_pub_group,:description)";
		int maxAuditReportId= jdbcTemplate.queryForObject("select  max(audit_report_id) from audit_report",Integer.class);
		
		//addAuditReport.put("audit_report_id",auditModel.getAuditReportId());
		addAuditReport.put("audit_report_id",maxAuditReportId+1);
		addAuditReport.put("audit_report",auditModel.getAuditReport());
		addAuditReport.put("dem_question_id1",auditModel.getDemQuestionId1());
		addAuditReport.put("dem_question_id2",auditModel.getDemQuestionId2());
		//addAuditReport.put("report_type",auditModel.getReportType());
		addAuditReport.put("audit_pub_group",auditModel.getAuditPubGroup());
		addAuditReport.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(auditReportQuery,addAuditReport);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateDemographicCrossTab(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateAuditReport= new LinkedHashMap<>();
		String  auditReportQuery = "update audit_report set audit_report=audit_report,dem_question_id1=:dem_question_id1,dem_question_id2=:dem_question_id2,"
				+ "audit_pub_group=:audit_pub_group,description=:description where audit_report_id="+auditModel.getAuditReportId();
		       // updateAuditReport.put("audit_report_id",auditModel.getAuditReportId());
				updateAuditReport.put("audit_report",auditModel.getAuditReport());
				updateAuditReport.put("dem_question_id1",auditModel.getDemQuestionId1());
				updateAuditReport.put("dem_question_id2",auditModel.getDemQuestionId2());
				updateAuditReport.put("audit_pub_group",auditModel.getAuditPubGroup());
				updateAuditReport.put("description",auditModel.getDescription());
				status = namedParameterJdbcTemplate.update(auditReportQuery,updateAuditReport);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteDemographicCrossTab(int auditReportId) {
	int status = 0;
	try {
		String deleteAuditReport = "delete from audit_report where audit_report_id=" +auditReportId;
		status = jdbcTemplate.update(deleteAuditReport);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
	return status;
}

@Override
public List<Map<String, Object>> getDemographicCrossTab(int auditReportId) {
	List<Map<String, Object>>  demoGraphicCrossTabDetails = new ArrayList<>();
	try {
		if(auditReportId!=0) {
		demoGraphicCrossTabDetails= jdbcTemplate.queryForList("select audit_report_id,audit_report,dem_question_id1,dem_question_id2,audit_pub_group,description from  audit_report where audit_report_id= "+auditReportId);
		}else {
			demoGraphicCrossTabDetails= jdbcTemplate.queryForList("select audit_report_id,audit_report,dem_question_id1,dem_question_id2,audit_pub_group,description from audit_report");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  demoGraphicCrossTabDetails;
    }


@Override
public List<DropdownModel> getQuestionList() {
	List<DropdownModel>  questionList = new ArrayList<>();
	try {
		List<Map<String, Object>> questionDetails = jdbcTemplate.queryForList("select descr_q_default from  dem_question");
		for (Map<String, Object> getQuestion :questionDetails) {
			DropdownModel model = new DropdownModel();
			model.setKey(getQuestion.get("descr_q_default")  != null ? (String) getQuestion.get("descr_q_default") :"");
			questionList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return questionList;

}

@Override
public int saveSalesChannel(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addAuditSalesChannel = new LinkedHashMap<>();
	try {

		String  auditSalesChannelQuery = "insert into  audit_sales_channel(audit_sales_channel_id,audit_sales_channel,audit_pub_group,qp,qf,nqp,nqf,description) " + "values(:audit_sales_channel_id,:audit_sales_channel,:audit_pub_group,:qp,:qf,:nqp,:nqf,:description)";
		int maxAuditSalesChannelId= jdbcTemplate.queryForObject("select  max(audit_sales_channel_id) from  audit_sales_channel",Integer.class);
		
		//addAuditSalesChannel.put("audit_sales_channel_id",auditModel.getAuditSalesChannelId());
		addAuditSalesChannel.put("audit_sales_channel_id",maxAuditSalesChannelId+1);
		addAuditSalesChannel.put("audit_sales_channel",auditModel.getAuditSalesChannel());
		addAuditSalesChannel.put("qp",auditModel.isQp());
		addAuditSalesChannel.put("qf",auditModel.isQf());
		addAuditSalesChannel.put("nqp",auditModel.isNqp());
		addAuditSalesChannel.put("nqf",auditModel.isNqf());
		addAuditSalesChannel.put("audit_pub_group",auditModel.getAuditPubGroup());
		addAuditSalesChannel.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(auditSalesChannelQuery,addAuditSalesChannel);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateSalesChannel(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateAuditSalesChannel= new LinkedHashMap<>();
		String  auditSalesChannelQuery = "update  audit_sales_channel  set  audit_sales_channel=:audit_sales_channel,audit_pub_group=:audit_pub_group,qp=:qp,qf=:qf,nqp=:nqp,nqf=:nqf,description=:description where audit_sales_channel_id="
				+auditModel.getAuditSalesChannelId();
		//updateAuditSalesChannel.put("audit_sales_channel_id",auditModel.getAuditSalesChannelId());
		updateAuditSalesChannel.put("audit_sales_channel",auditModel.getAuditSalesChannel());
		updateAuditSalesChannel.put("qp",auditModel.isQp());
		updateAuditSalesChannel.put("qf",auditModel.isQf());
		updateAuditSalesChannel.put("nqp",auditModel.isNqp());
		updateAuditSalesChannel.put("nqf",auditModel.isNqf());
		updateAuditSalesChannel.put("audit_pub_group",auditModel.getAuditPubGroup());
		updateAuditSalesChannel.put("description",auditModel.getDescription());
	    status = namedParameterJdbcTemplate.update(auditSalesChannelQuery,updateAuditSalesChannel);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteSalesChannel(int auditSalesChannelId) {
	int status = 0;
	try {
		String deleteAuditSalesChannel = "delete from audit_sales_channel where audit_sales_channel_id=" +auditSalesChannelId;
		status = jdbcTemplate.update(deleteAuditSalesChannel);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
	return status;
}

@Override
public List<Map<String, Object>> getSalesChannel(int auditSalesChannelId) {
	List<Map<String, Object>>  salesChannelDetails = new ArrayList<>();
	try {
		if(auditSalesChannelId!=0)
		{
		salesChannelDetails = jdbcTemplate.queryForList("select audit_sales_channel_id,audit_sales_channel,audit_pub_group,qp,qf,nqp,nqf,description from  audit_sales_channel where audit_sales_channel_id= "+auditSalesChannelId);
		}else {
			salesChannelDetails = jdbcTemplate.queryForList("select audit_sales_channel_id,audit_sales_channel,audit_pub_group,qp,qf,nqp,nqf,description from  audit_sales_channel");
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  salesChannelDetails;
    }

@Override
public int saveSubscriptionType(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addAuditSubscriptType = new LinkedHashMap<>();
	try {

		String  auditSubscriptTypeQuery = "insert into  audit_subscription_type(audit_subscription_type_id,audit_subscription_type,audit_pub_group,qp,qf,nqp,nqf,description) " + "values(:audit_subscription_type_id,:audit_subscription_type,:audit_pub_group,:qp,:qf,:nqp,:nqf,:description)";
		int maxAuditSubscriptTypeId= jdbcTemplate.queryForObject("select  max(audit_subscription_type_id) from  audit_subscription_type",Integer.class);
		
		//addAuditSubscriptType.put("audit_subscription_type_id",auditModel.getAuditSubscriptTypeId());
		addAuditSubscriptType.put("audit_subscription_type_id",maxAuditSubscriptTypeId+1);
		addAuditSubscriptType.put("audit_subscription_type",auditModel.getAuditSubscriptType());
		addAuditSubscriptType.put("qp",auditModel.isQp());
		addAuditSubscriptType.put("qf",auditModel.isQf());
		addAuditSubscriptType.put("nqp",auditModel.isNqp());
		addAuditSubscriptType.put("nqf",auditModel.isNqf());
		addAuditSubscriptType.put("audit_pub_group",auditModel.getAuditPubGroup());
		addAuditSubscriptType.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(auditSubscriptTypeQuery,addAuditSubscriptType);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateSubscriptionType(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateAuditSubscriptType = new LinkedHashMap<>();
		String  auditSubscriptTypeQuery = "update  audit_subscription_type  set  audit_subscription_type=:audit_subscription_type,audit_pub_group=:audit_pub_group,qp=:qp,qf=:qf,nqp=:nqp,nqf=:nqf,description=:description where audit_subscription_type_id="
				+auditModel.getAuditSubscriptTypeId();
		
		updateAuditSubscriptType.put("audit_subscription_type_id",auditModel.getAuditSubscriptTypeId());
		updateAuditSubscriptType.put("audit_subscription_type",auditModel.getAuditSubscriptType());
		updateAuditSubscriptType.put("qp",auditModel.isQp());
		updateAuditSubscriptType.put("qf",auditModel.isQf());
		updateAuditSubscriptType.put("nqp",auditModel.isNqp());
		updateAuditSubscriptType.put("nqf",auditModel.isNqf());
		updateAuditSubscriptType.put("audit_pub_group",auditModel.getAuditPubGroup());
		updateAuditSubscriptType.put("description",auditModel.getDescription());
	    status = namedParameterJdbcTemplate.update(auditSubscriptTypeQuery,updateAuditSubscriptType);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public List<Map<String, Object>> getSubscriptionType(int auditSubscriptTypeId) {
	List<Map<String, Object>>  salesChannelDetails = new ArrayList<>();
	try {
		 if(auditSubscriptTypeId!=0)
		 {
		salesChannelDetails = jdbcTemplate.queryForList("select audit_subscription_type_id,audit_subscription_type,audit_pub_group,qp,qf,nqp,nqf,description from audit_subscription_type  where audit_subscription_type_id= "+auditSubscriptTypeId);
		 }else {
			salesChannelDetails = jdbcTemplate.queryForList("select audit_subscription_type_id,audit_subscription_type,audit_pub_group,qp,qf,nqp,nqf,description from audit_subscription_type");	
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  salesChannelDetails;
    }

@Override
public int saveLookupForAuditGalleyIssue(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addLookupAuditGalleyIssue = new LinkedHashMap<>();
	try {
		String searchFieldGroupQuery = "insert into search_field_group(search,search_field_group_seq,disp_context,example_text,search_result_display_seq)" + "values(:search,:search_field_group_seq,:disp_context,:example_text,:search_result_display_seq)";
		
		addLookupAuditGalleyIssue.put("search", auditModel.getSearch());
		LOGGER.info("search:{}", auditModel.getSearch());
		addLookupAuditGalleyIssue.put("search_field_group_seq", auditModel.getSearchFieldGroupSeq());
		addLookupAuditGalleyIssue.put("disp_context", auditModel.getDisplayContext());
		addLookupAuditGalleyIssue.put("example_text", auditModel.getExampleText());
		addLookupAuditGalleyIssue.put("search_result_display_seq", auditModel.getSearchResultDisplaySeq());
        status = namedParameterJdbcTemplate.update(searchFieldGroupQuery,addLookupAuditGalleyIssue);
		String searchResultDisplayQuery = "insert into search_result_display(search,disp_context,search_result_display_seq,application_result_action)" + "values(:search,:disp_context,:search_result_display_seq,:application_result_action)";
		addLookupAuditGalleyIssue.put("application_result_action",auditModel.getApplicationResultAction());
		status = namedParameterJdbcTemplate.update(searchResultDisplayQuery,addLookupAuditGalleyIssue);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int updateLookupForAuditGalleyIssue(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> updateLookupAuditGallyIssue  = new LinkedHashMap<>();
	//updateLookupAuditGallyIssue.put("search", auditModel.getSearch());
	//LOGGER.info("search:{}", auditModel.getSearch());
	//updateLookupAuditGallyIssue.put("search_field_group_seq",auditModel.getSearchFieldGroupSeq());
	updateLookupAuditGallyIssue.put("disp_context",auditModel.getDisplayContext());
	updateLookupAuditGallyIssue.put("example_text",auditModel.getExampleText());
	updateLookupAuditGallyIssue.put("search_result_display_seq",auditModel.getSearchResultDisplaySeq());
	try {
	String searchFieldGroupQuery = "update search_field_group set disp_context=:disp_context,example_text=:example_text,search_result_display_seq=:search_result_display_seq "
			+ "where  search= '" +auditModel.getSearch()+ "' and search_field_group_seq= "+ auditModel.getSearchFieldGroupSeq();
	status = namedParameterJdbcTemplate.update(searchFieldGroupQuery,updateLookupAuditGallyIssue);
	
	String searchResultDisplayQuery="update search_result_display set disp_context=:disp_context,application_result_action=:application_result_action where "
					+ "search= '" +auditModel.getSearch()+ "' and search_result_display_seq= " +auditModel.getSearchResultDisplaySeq();
	updateLookupAuditGallyIssue.put("application_result_action", auditModel.getApplicationResultAction());
		status = namedParameterJdbcTemplate.update(searchResultDisplayQuery,updateLookupAuditGallyIssue);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
	int status = 0;
	try {

		String  deleteSearchFieldGroup= "delete from search_field_group where search='" +search+ "' and search_field_group_seq="+ searchFieldGroupSeq;
		status = jdbcTemplate.update(deleteSearchFieldGroup);
		
		String  deleteSearchReasultGroup= "delete from search_result_display where search='" +search+ "' and search_result_display_seq="+searchResultDisplaySeq;
		status = jdbcTemplate.update(deleteSearchReasultGroup);
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);

	}
	return status;
	}

@Override
public List<Map<String, Object>> getLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq,int searchResultDisplaySeq) {
	List<Map<String, Object>>  lookupForAuditGalleyIssueDetails = new ArrayList<>();
	try {
		if(search!=null&&searchFieldGroupSeq!=0&&searchResultDisplaySeq!=0)
		{
		lookupForAuditGalleyIssueDetails = jdbcTemplate.queryForList("select search,search_field_group_seq,disp_context,example_text,search_result_display_seq  from search_field_group  where search= '" + search+"' and search_field_group_seq ="+searchFieldGroupSeq);
		lookupForAuditGalleyIssueDetails.addAll(jdbcTemplate.queryForList("select search,disp_context,search_result_display_seq,application_result_action from  search_result_display  where search= '" + search+"' and search_result_display_seq ="+searchResultDisplaySeq));
		}else
		{
			lookupForAuditGalleyIssueDetails = jdbcTemplate.queryForList("select search,search_field_group_seq,disp_context,example_text,search_result_display_seq  from search_field_group");
			lookupForAuditGalleyIssueDetails.addAll(jdbcTemplate.queryForList("select search,disp_context,search_result_display_seq,application_result_action from  search_result_display"));
		}
		
		} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  lookupForAuditGalleyIssueDetails;
    }

@Override
public int saveParagraphReports(AuditModel auditModel) {
	int status = 0;
	Map<String, Object> addParagraphReport = new LinkedHashMap<>();
	try {

		String  auditReportQuery = "insert into  audit_report(audit_report_id,audit_report,audit_paragraph_axis1,audit_paragraph_axis2,description) " + "values(:audit_report_id,:audit_report,:audit_paragraph_axis1,:audit_paragraph_axis2,:description)";
		int maxAuditReportId= jdbcTemplate.queryForObject("select  max(audit_report_id) from audit_report",Integer.class);
		
		//addParagraphReport.put("audit_report_id",auditModel.getAuditReportId());
		addParagraphReport.put("audit_report_id",maxAuditReportId+1);
		addParagraphReport.put("audit_report",auditModel.getAuditReport());
	    addParagraphReport.put("audit_paragraph_axis1",auditModel.getParagraphSelectionCode());
	    addParagraphReport.put("audit_paragraph_axis2",auditModel.getParagraphSelection().equals("age")?9:0);
	    addParagraphReport.put("description",auditModel.getDescription());
		status = namedParameterJdbcTemplate.update(auditReportQuery,addParagraphReport);

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
	}

@Override
public int updateParagraphReports(AuditModel auditModel) {
int status = 0;
	
	try {
		Map<String, Object> updateParagraphReport= new LinkedHashMap<>();
		String  auditReportQuery = "update  audit_report set audit_report=:audit_report,audit_paragraph_axis1=:audit_paragraph_axis1,audit_paragraph_axis2=:audit_paragraph_axis2,description=:description where audit_report_id="
				+auditModel.getAuditReportId();
		//updateParagraphReport.put("audit_report_id",auditModel.getAuditReportId());
		updateParagraphReport.put("audit_report",auditModel.getAuditReport());
		updateParagraphReport.put("audit_paragraph_axis1",auditModel.getParagraphSelectionCode());
		updateParagraphReport.put("audit_paragraph_axis2",auditModel.getParagraphSelection().equals("age")?9:0);
		updateParagraphReport.put("description",auditModel.getDescription());
	    status = namedParameterJdbcTemplate.update(auditReportQuery,updateParagraphReport);
		
    } catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
	}
	return status;
}

@Override
public int deleteParagraphReports(int auditReportId) {
	int status = 0;
	try {
		String deleteParagraphReport = "delete from audit_report where audit_report_id="+auditReportId;
		status = jdbcTemplate.update(deleteParagraphReport);
} catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
	return status;
}

@Override
public List<Map<String, Object>> getParagraphReports() {
	List<Map<String, Object>>  paragraphReportDetails = new ArrayList<>();
	try {
		paragraphReportDetails =jdbcTemplate.queryForList("select audit_report_id,audit_report,audit_paragraph_axis1,audit_paragraph_axis2,description from audit_report");
		
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  paragraphReportDetails;
    }

@Override
public List<DropdownModel> getParagraphSelectionList() {
	
	List<DropdownModel>  paragraphSelectionList = new ArrayList<>();
	for(int i=0;i<=10;i++)
	{
		DropdownModel model= new DropdownModel();
		model.setKey(""+i);
		if(i==0||i==9)
		{
			model.setDisplay(new PropertyUtils().getConstantValue("audit_paragraph_axis2"+i));
		}
		model.setDisplay(new PropertyUtils().getConstantValue("audit_paragraph_axis1"+i));
		paragraphSelectionList.add(model);
	}
	
	return paragraphSelectionList;
}


@Override
public String getPsRenewalLabel(String currency) {
		LOGGER.info(" Inside psRenewal");
		String ps_renewal = null;
		String ps=null;
		List<Character> codeList1 = null;
		List<Character> codeList2 = null;
		Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
		try {
			int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
			if (Currency_info > 0) {
				String email_authorization_query = " select ps_renewal from config where currency=?";
				Integer renewal1=jdbcTemplate.queryForObject(" select ps_renewal from config where currency='"+currency+"'",Integer.class);

				ps_renewal = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
						String.class);
				if (ps_renewal == null || "FEF7FFFF0700".equals(ps_renewal)) {
					ps_renewal = "Select Any One From The Option";
				} else {

					if (ps_renewal.length() == 1) {
						codeList1 = new ArrayList<Character>();
						String binaryNumber1=Integer.toBinaryString(renewal1);
						for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
							codeList1.add(binaryNumber1.charAt(i));
						}
						
					} 
					ps_renewal = ps_renewal.substring(0, ps_renewal.length()-1);

					if (ps_renewal.length() == 1) {
						codeList1 = new ArrayList<Character>();
						String binaryNumber1=Integer.toBinaryString(renewal1);
						for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
							codeList1.add(binaryNumber1.charAt(i));
						}
						
					} else if (ps_renewal.length() == 2) {

						codeList1 = new ArrayList<Character>();
						String binaryNumber1=Integer.toBinaryString(renewal1);

						for (int i = binaryNumber1.length()-1; i > 0; i--) {
							codeList1.add(binaryNumber1.charAt(i));
						}
						codeList2 = new ArrayList<Character>();

						String binaryNumber2=Integer.toBinaryString(renewal1);
						for (int i = binaryNumber2.length() - 1; i > 0; i--) {
							codeList2.add(binaryNumber2.charAt(i));
						}
					} 
					if (null != codeList1) {
						int process = 0;
						for (int i = 0; i < codeList1.size(); i++) {
							processCodeMap.put(process, codeList1.get(i));
							process++;
						}
					}
					if (null != codeList2) {
						int process = 2;
						for (int i = 0; i < codeList2.size(); i++) {
							processCodeMap.put(process, codeList2.get(i));
							process++;
						}
					}
					 ps=Integer.toString(renewal1);
					String selectedBusinessProcess = "";
					Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
					Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
					while (itr.hasNext()) {
						Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
						if (entry.getValue() == '1') {
							selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";

						}
					}
					if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
						ps = selectedBusinessProcess.substring(0,
								selectedBusinessProcess.length() - 1);

					}

				}
			} else {
				ps = "Currency does not exist in database";
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			ps = ERROR;
			return ps;
		}
		return ps;

}

@Override
public String getPsBilling(String currency) {
	LOGGER.info("Inside psBilling");
	String ps_billing = null;
	String ps=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select ps_billing from config where currency=?";
			Integer billing1=jdbcTemplate.queryForObject(" select ps_billing from config where currency='"+currency+"'",Integer.class);

			ps_billing = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			if (ps_billing == null || "FEF7FFFF0700".equals(ps_billing)) {
				ps_billing = "Select Any One From The Option";
			} else {

				if (ps_billing.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(billing1);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				ps_billing = ps_billing.substring(0, ps_billing.length()-1);

				if (ps_billing.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(billing1);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} else if (ps_billing.length() == 2) {

					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(billing1);

					for (int i = binaryNumber1.length()-1; i > 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();

					String binaryNumber2=Integer.toBinaryString(billing1);
					for (int i = binaryNumber2.length() - 1; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
				} 
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 2;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
					}
				}
				 ps=Integer.toString(billing1);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";

					}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					ps = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);

				}

			}
		} else {
			ps = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		ps = ERROR;
		return ps;
	}
	return ps;
}

@Override
public String getOsLabel(String currency) {

	LOGGER.info("Inside osLabel");
	String os_labelling = null;
	String result=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select os_label from config where currency=?";
			Integer label=jdbcTemplate.queryForObject(" select os_label from config where currency='"+currency+"'",Integer.class);

			os_labelling = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			
			if (null != os_labelling) {

				if ((os_labelling).length() > 12) {
					os_labelling = os_labelling.substring(0, 12);

				}
			}
			
			if (os_labelling == null || "FEF7FFFF0700".equals(os_labelling)) {
				os_labelling = "Select Any One From The Option";
			} else {

				if (os_labelling.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(label);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				
				os_labelling = os_labelling.substring(0, os_labelling.length()-1);
						
				if (os_labelling.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(label);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				if (os_labelling.length() == 2) {
							
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(label);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(label);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_labelling.length() == 3) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(label);
					
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(label);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_labelling.length() == 4) {
										
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(label);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(label);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_labelling.length() == 5) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(label);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(label);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
					
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 1;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
						
					}
				}
					
				result=Integer.toString(label);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					result = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);
					} 

			}
		} else {
			result = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		result = ERROR;
		return result;
	}
	return result;
}

@Override
public String getOsBackLabel(String currency) {
	
	LOGGER.info("Inside osBackLabel");
	String os_backLabelling = null;
	String result=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select os_backlabel from config where currency=?";
			Integer backLabel=jdbcTemplate.queryForObject(" select os_backlabel from config where currency='"+currency+"'",Integer.class);

			os_backLabelling = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			
			if (null != os_backLabelling) {

				if ((os_backLabelling).length() > 12) {
					os_backLabelling = os_backLabelling.substring(0, 12);

				}
			}
			
			if (os_backLabelling == null || "FEF7FFFF0700".equals(os_backLabelling)) {
				os_backLabelling = "Select Any One From The Option";
			} else {

				if (os_backLabelling.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				
				os_backLabelling = os_backLabelling.substring(0, os_backLabelling.length()-1);
						
				if (os_backLabelling.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				if (os_backLabelling.length() == 2) {
							
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_backLabelling.length() == 3) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_backLabelling.length() == 4) {
										
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_backLabelling.length() == 5) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
					
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 1;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
						
					}
				}
					
				result=Integer.toString(backLabel);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					result = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);
					} 

			}
		} else {
			result = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		result = ERROR;
		return result;
	}
	return result;
	
}

@Override
public String getOsRenewal(String currency) {

	LOGGER.info("Inside osRenewal");
	String os_renewal = null;
	String result=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select os_renewal from config where currency=?";
			Integer backLabel=jdbcTemplate.queryForObject(" select os_renewal from config where currency='"+currency+"'",Integer.class);

			os_renewal = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			
			if (null != os_renewal) {

				if ((os_renewal).length() > 12) {
					os_renewal = os_renewal.substring(0, 12);

				}
			}
			
			if (os_renewal == null || "FEF7FFFF0700".equals(os_renewal)) {
				os_renewal = "Select Any One From The Option";
			} else {

				if (os_renewal.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				
				os_renewal = os_renewal.substring(0, os_renewal.length()-1);
						
				if (os_renewal.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				if (os_renewal.length() == 2) {
							
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_renewal.length() == 3) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_renewal.length() == 4) {
										
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_renewal.length() == 5) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(backLabel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
					
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 1;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
						
					}
				}
					
				result=Integer.toString(backLabel);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					result = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);
					} 

			}
		} else {
			result = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		result = ERROR;
		return result;
	}
	return result;
	

}

@Override
public String getOsBilling(String currency) {

	LOGGER.info("Inside osRenewal");
	String os_billing = null;
	String result=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select os_billing from config where currency=?";
			Integer osBill=jdbcTemplate.queryForObject(" select os_billing from config where currency='"+currency+"'",Integer.class);

			os_billing = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			
			if (null != os_billing) {

				if ((os_billing).length() > 12) {
					os_billing = os_billing.substring(0, 12);

				}
			}
			
			if (os_billing == null || "FEF7FFFF0700".equals(os_billing)) {
				os_billing = "Select Any One From The Option";
			} else {

				if (os_billing.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osBill);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				
				os_billing = os_billing.substring(0, os_billing.length()-1);
						
				if (os_billing.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osBill);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				if (os_billing.length() == 2) {
							
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osBill);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osBill);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_billing.length() == 3) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osBill);
					
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osBill);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_billing.length() == 4) {
										
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osBill);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osBill);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_billing.length() == 5) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osBill);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osBill);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
					
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 1;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
						
					}
				}
					
				result=Integer.toString(osBill);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					result = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);
					} 

			}
		} else {
			result = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		result = ERROR;
		return result;
	}
	return result;
	
}

@Override
public String getOsCancellation(String currency) {
	LOGGER.info("Inside osCancellation");
	String os_cancellation = null;
	String result=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select os_cancellation from config where currency=?";
			Integer osCancel=jdbcTemplate.queryForObject(" select os_cancellation from config where currency='"+currency+"'",Integer.class);

			os_cancellation = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			
			if (null != os_cancellation) {

				if ((os_cancellation).length() > 12) {
					os_cancellation = os_cancellation.substring(0, 12);

				}
			}
			
			if (os_cancellation == null || "FEF7FFFF0700".equals(osCancel)) {
				os_cancellation = "Select Any One From The Option";
			} else {

				if (os_cancellation.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				
				os_cancellation = os_cancellation.substring(0, os_cancellation.length()-1);
						
				if (os_cancellation.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				if (os_cancellation.length() == 2) {
							
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_cancellation.length() == 3) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osCancel);
					
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_cancellation.length() == 4) {
										
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_cancellation.length() == 5) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osCancel);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
					
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 1;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
						
					}
				}
					
				result=Integer.toString(osCancel);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					result = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);
					} 

			}
		} else {
			result = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		result = ERROR;
		return result;
	}
	return result;
	
}

@Override
public String getOsSuspension(String currency) {
	LOGGER.info("Inside osSuspension");
	String os_suspension = null;
	String result=null;
	List<Character> codeList1 = null;
	List<Character> codeList2 = null;
	
	Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
	try {
		int Currency_info = jdbcTemplate.queryForObject("select count(*) AS count from config", Integer.class);
		if (Currency_info > 0) {
			String email_authorization_query = " select os_suspension from config where currency=?";
			Integer osDetail=jdbcTemplate.queryForObject(" select os_suspension from config where currency='"+currency+"'",Integer.class);

			os_suspension = jdbcTemplate.queryForObject(email_authorization_query, new Object[] { currency },
					String.class);
			
			if (null != os_suspension) {

				if ((os_suspension).length() > 12) {
					os_suspension = os_suspension.substring(0, 12);

				}
			}
			
			if (os_suspension == null || "FEF7FFFF0700".equals(os_suspension)) {
				os_suspension = "Select Any One From The Option";
			} else {

				if (os_suspension.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				
				os_suspension = os_suspension.substring(0, os_suspension.length()-1);
						
				if (os_suspension.length() == 1) {
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					
				} 
				if (os_suspension.length() == 2) {
							
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_suspension.length() == 3) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osDetail);
					
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_suspension.length() == 4) {
										
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
				if (os_suspension.length() == 5) {
						
					codeList1 = new ArrayList<Character>();
					String binaryNumber1=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber1.length() - 1; i >= 0; i--) {
						codeList1.add(binaryNumber1.charAt(i));
					}
					codeList2 = new ArrayList<Character>();
					String binaryNumber2=Integer.toBinaryString(osDetail);
					for (int i = binaryNumber2.length() - 2; i > 0; i--) {
						codeList2.add(binaryNumber2.charAt(i));
					}
					
				}
					
				if (null != codeList1) {
					int process = 0;
					for (int i = 0; i < codeList1.size(); i++) {
						processCodeMap.put(process, codeList1.get(i));
						process++;
					}
				}
				if (null != codeList2) {
					int process = 1;
					for (int i = 0; i < codeList2.size(); i++) {
						processCodeMap.put(process, codeList2.get(i));
						process++;
						
					}
				}
					
				result=Integer.toString(osDetail);
				String selectedBusinessProcess = "";
				Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
				Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
				while (itr.hasNext()) {
					Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
					if (entry.getValue() == '1') {
						selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
						}
				}
				if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) {
					result = selectedBusinessProcess.substring(0,
							selectedBusinessProcess.length() - 1);
					} 

			}
		} else {
			result = "Currency does not exist in database";
		}

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		e.printStackTrace();
		result = ERROR;
		return result;
	}
	return result;
	}

@Override
public List<Map<String, Object>> getGroupDetails(int customerId) {
List<Map<String,Object>> groupInfo=new ArrayList<>();
try {
	if(customerId!=0) {
	groupInfo=jdbcTemplate.queryForList("select ship_type,back_issue_ship_type,new_group_member_action from customer_group where customer_id="+customerId);
	}else {
		groupInfo=jdbcTemplate.queryForList("select ship_type,back_issue_ship_type,new_group_member_action from customer_group");
	}
}catch(Exception e) {
	LOGGER.info("getGroupDetails",e);
}
	return groupInfo;
}


@Override
public String Renewal(String currency, int... business_processes) {
	String status=null;
	String updateQuery = null;
	int total = 0;

	for (int i = 0; i < business_processes.length; i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total = total + total1;
	}
	updateQuery = "UPDATE config set ps_renewal="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status = "ps_renewal saved successfully.";
	return status;
}

@Override
public String PsBillingUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total=total+total1;
	}
	String updateQuery="UPDATE config set ps_billing="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="ps_billing Saved Succesfully";
	return status;
}

@Override
public String osLabelUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total=total+total1;
	}
	String updateQuery="UPDATE config set os_label="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="os_label Saved Successively";
		return status;
	}

@Override
public String osBackLabelUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total=total+total1;
	}
	String updateQuery="UPDATE config set os_backlabel="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="os_label Saved Successively";
		return status;
}

@Override
public String osRenewalUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
	total=total+total1;
	}
	String updateQuery="UPDATE config set os_renewal="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="os_renewal Saved SuccessFully";
	return status;
}

@Override
public String osBillingUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total=total+total1;
	}
	String updateQuery="UPDATE config set os_billing="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="os_billing Saved SuccessFully";
	return status;
}

@Override
public String osCancellationUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total=total+total1;
	}
	String updateQuery="UPDATE config set os_cancellation="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="os_cancellation Saved SuccessFully";
	return status;
}

@Override
public String osSuspensionUpdate(String currency, int... business_processes) {
	String status=null;
	int total=0;
	for(int i=0;i<business_processes.length;i++) {
		int total1=(int) Math.pow(2, business_processes[i]);
		total=total+total1;
	}
	String updateQuery="UPDATE config set os_suspension="+ total + " where currency='" + currency + "'";
	jdbcTemplate.update(updateQuery);
	status="os_suspension Saved Successively";
	return status;
}


}

