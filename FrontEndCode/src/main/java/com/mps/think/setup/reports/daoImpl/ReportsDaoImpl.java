package com.mps.think.setup.reports.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.reports.dao.ReportsDao;
import com.mps.think.setup.tablesetup.daoImpl.TableSetupDaoImpl;
@Repository
public class ReportsDaoImpl implements ReportsDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(TableSetupDaoImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Override
	public List<Map<String, Object>> getSubscriptionOcs() {
		List<Map<String,Object>> subscriptionOcs=new ArrayList<>();
		try {
			subscriptionOcs=jdbcTemplate.queryForList("select oc,description,billing_code_format,payment_threshold,source_format,profit_center,track_inven,issn,inherited_from,converted_to,start_type,qp_backissues_on_reinst,qp_name_title_required,qp_max_backissues_on_reinst,qp_max_backstarts_on_new,qp_qual_source_required,qp_sales_channel_required,qp_sub_type_required,qf_max_backissues_on_reinst"
					+ ",qf_max_backstarts_on_new,qf_qual_source_required,qf_sales_channel_required,qf_sub_type_required,nqp_backissues_on_reinst,nqp_name_title_required,nqp_max_backissues_on_reinst,nqp_max_backstarts_on_new,nqp_qual_source_required,nqp_sales_channel_required,nqp_sub_type_required,nqf_backissues_on_reinst,nqf_name_title_required,nqf_max_backissues_on_reinst,nqf_max_backstarts_on_new,nqf_qual_source_required,nqf_sales_channel_required,nqf_sub_type_required,start_date_type_anytime,start_date_type_volume_group from view_oc_pub");

		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptionOcs;
	}
	@Override
	public int deleteSubscriptionOc(int ocId) {
		int status=0;
		try {
			StringBuilder deleteQuery=new StringBuilder("delete from view_oc_pub where oc_id="+ocId);
			status=jdbcTemplate.update(deleteQuery.toString());

		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public List<Map<String, Object>> getProductOcsInfo() {
		List<Map<String,Object>> productInfo=new ArrayList<>();
		try {
			productInfo=jdbcTemplate.queryForList("select oc,description,billing_code_format,payment_threshold,source_format,profit_center,track_inven,can_be_personalized,oc_id,oc_type,parent_oc_id from view_oc_product_class");
		}catch(Exception e) {
			LOGGER.error(ERROR+ e);
		}
		return productInfo;
	}
	@Override
	public int deleteProductOc(int ocId) {
		int status=0;
		try {
			StringBuilder query=new StringBuilder("delete from view_oc_product_class where oc_id="+ocId);
			status=jdbcTemplate.update(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return status;
	}
	@Override
	public List<Map<String, Object>> getRateDetails() {
		List<Map<String,Object>> rateDetail=new ArrayList<>();
		try {
			rateDetail=jdbcTemplate.queryForList("select rate_class,description,convert(varchar(15),effective_date,106)as effectivedate,from_qty,to_qty,charge_new,remit_new,percent_new,basic,lookup_currency,region,currency,baseline_qty,charge_ren,remit_ren,percent_ren,qty_discount_schedule,oc_id,"
					+ "rate_class_id,renewal_card_id,rate_class_effective_seq,rate_class_region_list,rate_class_description,convert(varchar(15),renewal_expire_effective_date,106)as renexpireEffiveDtae,ratecard_seq,region_list from view_rate_class");
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return rateDetail;
	}
	@Override
	public int deleteRate(int rateClassId) {
		int status=0;
		try {
			StringBuilder query=new StringBuilder("delete from view_rate_class where rate_class_id="+rateClassId);
			status=jdbcTemplate.update(query.toString());
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
		}
		return status;
	}
	@Override
	public List<Map<String, Object>> getDiscountInfo() {
		List<Map<String,Object>> discountdetail=new ArrayList<>();
		try {
			discountdetail=jdbcTemplate.queryForList("select discount_class,discount_class_description,convert(varchar(15),effective_date,106)as eefectiveDate,from_qty,to_qty,discount_percent,currency,region,oc_id,discount_class_id,discount_class_region_list,"
					+ "disc_class_effective_seq,description,convert(varchar(15),renewal_expire_effective_date,106)as renExpireEffDate,discount_card_seq,region_list from view_discount_class;");
		}catch(Exception e) {
			LOGGER.error(ERROR+ e);
		}
		return discountdetail;
	}
	@Override
	public int deleteDiscountRow(int discountClassId) {
	int status=0;
	try {
		String query="delete from view_discount_class where discount_class_id="+discountClassId;
		status=jdbcTemplate.update(query);
	}catch(Exception e) {
		LOGGER.error(ERROR+e);
	}
		return status;
	}
	@Override
	public List<Map<String, Object>> getSource() {
List<Map<String,Object>> source=new ArrayList<>();
try {
	source=jdbcTemplate.queryForList("select source_code,source_code_id,description,convert(varchar(15),from_date,106) as fromdate,convert(varchar(15),to_date,106)as todate,source_format,active,oc_id,source_code_type,generic_agency,generated,premium_order_code_id,agency_customer_id,list from view_source_code");
}catch(Exception e) {
	LOGGER.error(ERROR+e);
}
		return source;
	}
	@Override
	public int deleteSourceRow(int sourceCodeId) {
		int status=0;
		try {
			String query="delete from view_source_code where source_code_id="+sourceCodeId;
			status=jdbcTemplate.update(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return status;
	}
	@Override
	public List<Map<String, Object>> getOrderCode() {
		List<Map<String,Object>> orderCode=new ArrayList<>();
		try {
			orderCode=jdbcTemplate.queryForList("select oc_id,order_code_id,description,qty,price,extfree_qty_limit,order_code_type,grace_qty,ship_weight,discount_class_id,audit_subscription_type_id,term_id,active,newsub_rate_class_id,prepayment_req,user_code,pub_rotation_id,new_renewal_card_id,audit_qual_category,"
					+ "			audit_qual_source_id,audit_name_title_id,issue_id,audit_sales_channel_id,taxable,commodity_code,item_type,start_type,perpetual_order from view_order_code");
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return orderCode;
	}
	@Override
	public int deleteOrderCode(int orderCodeId) {
		int status=0;
		try {
			String query="delete from view_order_code where order_code_id="+orderCodeId;
			status=jdbcTemplate.update(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return status;
	}
	@Override
	public List<Map<String, Object>> getTranslations() {
		List<Map<String,Object>> translations=new ArrayList<>();
		try {
			translations=jdbcTemplate.queryForList("select * from alternate_content");
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return translations;
	}
	@Override
	public int deleteTranslations(int keyPart1) {
		int status=0;
		try {
			String query="delete from alternate_content where key_part1="+keyPart1;
			status=jdbcTemplate.update(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
		}
		return status;
	}


}
