package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.dao.DocumentReferenceDao;
import com.mps.think.model.DocumentReferenceAttributeModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.util.CustomerUtility;

@Repository
public class DocumentReferenceDaoImpl implements DocumentReferenceDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentReferenceDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	CustomerUtility customerUtility;

	@Override
	public List<Object> getDocumentReferenceList(String type,String limit) throws SQLException {

		LOGGER.info("Inside getDocumentReferenceList");
		List<Object> documentReferenceList = new ArrayList<Object>();
		try {
			String query="";
			if("all".equals(type))
				query = "SELECT DISTINCT TOP "+limit+" view_document_reference_batch.*, concat(user_code.user_code,' - ', name) as name FROM view_document_reference_batch left join user_code on user_code.user_code = view_document_reference_batch.user_code WHERE type IN (0, 1, 2, 4) ORDER BY document_reference_id DESC";
			else
				query="SELECT DISTINCT TOP 100 view_document_reference_batch.*, concat(user_code.user_code,' - ', name) as name FROM view_document_reference_batch left join user_code on user_code.user_code = view_document_reference_batch.user_code WHERE type in (0,2) and active = 1 ORDER BY document_reference_id DESC";
			
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
			for (Map<String, Object> row : rows) {
				documentReferenceList.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return documentReferenceList;	
	}
	
	@Override
	public List<DropdownModel> getOperatorList() throws SQLException {
		LOGGER.info("Inside getOperatorList");
		List<DropdownModel> operatorList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select user_code,name from user_code where user_group is not null");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get("user_code"));
				model.setDisplay(row.get("user_code") + "-" + row.get("name"));
				operatorList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return operatorList;

	}
	
	@Override
	public List<DropdownModel> getAssignedToList() throws SQLException {
		LOGGER.info("Inside getAssignedToList");
		List<DropdownModel> assignedToList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select user_code,name from user_code where user_group is not null");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get("user_code"));
				model.setDisplay(row.get("user_code") + "-" + row.get("name"));
				assignedToList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return assignedToList;

	}
	
	@Override
	public List<DropdownModel> getBatchTemplateList() throws SQLException {
		LOGGER.info("Inside getBatchTemplateList");
		List<DropdownModel> batchTemplateList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select batch_template,description from batch_template order by batch_template asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get("batch_template"));
				model.setDisplay(row.get("batch_template") + "-" + row.get("description"));
				batchTemplateList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return batchTemplateList;
	}
	
	@Override
	public List<Object> getSearchDocumentReferenceList(DocumentReferenceAttributeModel documentReferenceAttributeModel) throws SQLException {

		LOGGER.info("Inside getSearchDocumentReferenceList");
		List<Object> documentReferenceList = new ArrayList<Object>();
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			StringBuilder query = new StringBuilder("SELECT DISTINCT TOP " + documentReferenceAttributeModel.getLimit()+
					" view_document_reference_batch.*, concat(user_code.user_code,' - ', name) as name FROM view_document_reference_batch left join user_code on user_code.user_code = view_document_reference_batch.user_code where type IN (");
			if(!"true".equals(documentReferenceAttributeModel.getCustomerService()) && !"true".equals(documentReferenceAttributeModel.getBatch()) &&
					!"true".equals(documentReferenceAttributeModel.getImport()) && !"true".equals(documentReferenceAttributeModel.getInternet())) {
				query.append(":customerservice,:batch,");
				parameters.put("customerservice", 0);
				parameters.put("batch", 2);
			}
			else {
				if("true".equals(documentReferenceAttributeModel.getCustomerService())) {
					query.append(":customerservice,");
					parameters.put("customerservice", 0);
				}
				if("true".equals(documentReferenceAttributeModel.getBatch())) {
					query.append(":batch,");
					parameters.put("batch", 2);
				}
				if("true".equals(documentReferenceAttributeModel.getImport())) {
					query.append(":import,");
					parameters.put("import", 1);
				}
				if("true".equals(documentReferenceAttributeModel.getInternet())) {
					query.append(":internet,");
					parameters.put("internet", 4);
				}
			}
			
			query.setLength(query.length() - 1);
			query.append(")");
			
			if(customerUtility.getStringValue(documentReferenceAttributeModel.getOperator())!=null) {
				query.append(" and user_code = :user_code");
				parameters.put("user_code", documentReferenceAttributeModel.getOperator());
			}
			
			if( customerUtility.getStringValue(documentReferenceAttributeModel.getAssignedTo())!=null) {
				query.append(" and assigned_to_user_code = :assigned_to_user_code");
				parameters.put("assigned_to_user_code", documentReferenceAttributeModel.getAssignedTo());
			}
			
			if(customerUtility.getStringValue(documentReferenceAttributeModel.getBatchTemplate())!=null) {
				query.append(" and batch_template = :batch_template");
				parameters.put("batch_template", documentReferenceAttributeModel.getBatchTemplate());
			}
			
			if( customerUtility.getStringValue(documentReferenceAttributeModel.getDescription())!=null) {
				query.append(" and description like :description");
				parameters.put("description", "%"+documentReferenceAttributeModel.getDescription()+"%");
			}
			
			if(!("true".equals(documentReferenceAttributeModel.getActive()) && "true".equals(documentReferenceAttributeModel.getClosed()))) {
				if("true".equals(documentReferenceAttributeModel.getActive())) {
					query.append(" and active = :active");
					parameters.put("active", 1);
				}
				if("true".equals(documentReferenceAttributeModel.getClosed())) {
					query.append(" and active = :active");
					parameters.put("active", 0);
				}
			}
			
			query.append(" ORDER BY document_reference_id DESC");
			System.out.println(query);
			List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(query.toString(), parameters);
			for (Map<String, Object> row : rows) {
				documentReferenceList.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return documentReferenceList;	
	}

	@Override
	public String editDocument(DocumentReferenceAttributeModel documentReferenceAttributeModel) throws SQLException {

		LOGGER.info("Inside editDocument");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String updatequery ="update document_reference set description=:description,active=:active where document_reference_id=:document_reference_id";
			parameters.put("description", customerUtility.getStringValue(documentReferenceAttributeModel.getDescription()));
			if("true".equals(documentReferenceAttributeModel.getActive()))
				parameters.put("active", 1);
			else
				parameters.put("active", 0);
			parameters.put("document_reference_id", documentReferenceAttributeModel.getReferenceId());
			namedParameterJdbcTemplate.update(updatequery, parameters);
		
			return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	
	}

	@Override
	public String addDocument(DocumentReferenceAttributeModel documentReferenceAttributeModel) throws SQLException {

		LOGGER.info("Inside addDocument");
		try {
			
			Long mruDocumentReferenceId = jdbcTemplate.queryForObject("select id from mru_document_reference_id", Long.class);
			Map<String, Object> parameters = new HashMap<String, Object>();
			String savequery ="insert into document_reference (document_reference_id,description,user_code,type,active) values ("
					+ ":document_reference_id,:description,:user_code,:type,:active)";
			parameters.put("document_reference_id", mruDocumentReferenceId+1);
			parameters.put("description", customerUtility.getStringValue(documentReferenceAttributeModel.getDescription()));
			parameters.put("user_code", customerUtility.getStringValue(documentReferenceAttributeModel.getOperator()));
			parameters.put("type", 0);
			if("true".equals(documentReferenceAttributeModel.getActive()))
				parameters.put("active", 1);
			else
				parameters.put("active", 0);
			namedParameterJdbcTemplate.update(savequery, parameters);
			
			parameters.clear();
			String  query="update mru_document_reference_id set id = :id";
			parameters.put("id", mruDocumentReferenceId+1);
			namedParameterJdbcTemplate.update(query, parameters);
		
			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	
	}

	@Override
	public int getDescriptionCount(String description) throws SQLException {
		LOGGER.info("Inside getDescriptionCount");
		
		int count=0;
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String query = "select count(*) from document_reference where description LIKE :description ";
			parameters.put("description", "%"+description+"%");
			count =  namedParameterJdbcTemplate.queryForObject(query, parameters,int.class);
		}
		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return count;
	}
}
