package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.dao.CustomerSearchDao;
import com.mps.think.model.AttachmentAddAttributeModel;
import com.mps.think.model.Customer;
import com.mps.think.model.CustomerAddAttributeModel;
import com.mps.think.model.CustomerAddressModel;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.CustomerHistoryModel;
import com.mps.think.model.CustomerSearchAttributeModel;
import com.mps.think.model.DistributorAccountsModel;
import com.mps.think.model.DistributorAttributeSetUpModel;
import com.mps.think.model.DistributorChildModel;
import com.mps.think.model.DistributorReportModel;
import com.mps.think.model.DistributorReportOutputOptionsModel;
import com.mps.think.model.DistributorValue;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.NoteAddAttributeModel;
import com.mps.think.orderFunctionality.model.ProspectModel;
import com.mps.think.resultMapper.BillingEffortHistoryMapper;
import com.mps.think.resultMapper.CustomerAddressMapper;
import com.mps.think.resultMapper.CustomerAuxiliaryMapper;
import com.mps.think.resultMapper.CustomerHistoryMapper;
import com.mps.think.resultMapper.CustomerMapper;
import com.mps.think.resultMapper.ProductHistoryMapper;
import com.mps.think.resultMapper.PromotionEffortsMapper;
import com.mps.think.resultMapper.RenewalEffortHistoryMapper;
import com.mps.think.resultMapper.SingleIssueHistoryMapper;
import com.mps.think.resultMapper.SubscriptionHistoryMapper;
import com.mps.think.resultMapper.UnitsHistoryMapper;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.EmailAuthorizationUtility;
import com.mps.think.util.PropertyUtilityClass;

@Repository
public class CustomerSearchDaoImpl implements CustomerSearchDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerSearchDaoImpl.class);
	private SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String STATE = "state";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomerUtility customerUtility;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<CustomerAddressModel> getCustomerSearch(CustomerSearchAttributeModel customerSearchAttributeModel)
			throws SQLException {
		LOGGER.info("Inside getCustomerSearch");
		List<CustomerAddressModel> result = null;

		try {

			StringBuilder query = new StringBuilder("");

			if ("Name".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, (select top 100 customer_address.customer_id"
						+ " from customer, customer_address"
						+ " where (customer.inactive = 0 OR customer.inactive is NULL)");
				if ("*".equals(customerSearchAttributeModel.getfName()))
					query.append(" AND customer.fname LIKE '%'");
				else if (customerSearchAttributeModel.getfName() != null
						&& !"".equals(customerSearchAttributeModel.getfName()))
					query.append(" AND customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "'");

				if ("*".equals(customerSearchAttributeModel.getlName()))
					query.append(" AND customer.lname  LIKE '%'");
				else if (customerSearchAttributeModel.getlName() != null
						&& !"".equals(customerSearchAttributeModel.getlName()))
					if (customerSearchAttributeModel.getlName().contains("*")) {
						query.append(" AND customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "%'");
					} else {
						query.append(" AND customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");
					}

				if ("*".equals(customerSearchAttributeModel.getInitial()))
					query.append(" AND customer.initial_name  LIKE '%'");
				else if (customerSearchAttributeModel.getInitial() != null
						&& !"".equals(customerSearchAttributeModel.getInitial()))
					query.append(" AND customer.initial_name LIKE '" + customerSearchAttributeModel.getInitial() + "'");

				query.append(" AND customer.customer_id = customer_address.customer_id) as customer"
						+ " WHERE customer.customer_id = customer_address.customer_id ORDER BY customer_address.customer_id asc");

			} else if ("CustomerID".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer"
						+ " WHERE (customer.customer_id = customer_address.customer_id) and"
						+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

				if (customerSearchAttributeModel.getCustomerId() != null)
					query.append("  AND customer.customer_id=" + customerSearchAttributeModel.getCustomerId());

				query.append(")");

				query.append(" ORDER BY customer_address.customer_id asc");

			} else if ("phoneNo".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer"
						+ " WHERE (customer.customer_id = customer_address.customer_id) and"
						+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

				if ("*".equals(customerSearchAttributeModel.getPhoneNumber()))
					query.append(" AND customer_address.phone LIKE '%'");
				else if (customerSearchAttributeModel.getPhoneNumber() != null
						&& !"".equals(customerSearchAttributeModel.getPhoneNumber()))
					query.append(" AND customer_address.phone LIKE '" + customerSearchAttributeModel.getPhoneNumber()
							+ "%'");

				if ("*".equals(customerSearchAttributeModel.geteMail()))
					query.append(" AND customer_address.email LIKE '%'");
				else if (customerSearchAttributeModel.geteMail() != null
						&& !"".equals(customerSearchAttributeModel.geteMail()))
					query.append(" AND customer_address.email LIKE '" + customerSearchAttributeModel.geteMail() + "%'");

				query.append(") ORDER BY customer_address.customer_id asc");

			} else if ("ZipCode".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer"
						+ " WHERE (customer.customer_id = customer_address.customer_id) and"
						+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

				if ("*".equals(customerSearchAttributeModel.getlName()))
					query.append(" AND customer.lname  LIKE '%'");
				else if (customerSearchAttributeModel.getlName() != null
						&& !"".equals(customerSearchAttributeModel.getlName()))
					query.append(" AND customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

				if (customerSearchAttributeModel.getCountry() != null
						&& !"".equals(customerSearchAttributeModel.getCountry()))
					query.append("  AND customer_address.state='" + customerSearchAttributeModel.getCountry() + "'");

				if ("*".equals(customerSearchAttributeModel.getPostalCode()))
					query.append(" AND customer_address.zip LIKE '%'");
				else if (customerSearchAttributeModel.getPostalCode() != null
						&& !"".equals(customerSearchAttributeModel.getPostalCode()))
					query.append(
							"  AND customer_address.zip LIKE '" + customerSearchAttributeModel.getPostalCode() + "%'");

				query.append(" AND customer_address.zip is not null)");

				query.append(" ORDER BY customer_address.customer_id asc");

			} else if ("Company".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer"
						+ " WHERE (customer.customer_id = customer_address.customer_id) and"
						+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

				if ("*".equals(customerSearchAttributeModel.getCompanyName()))
					query.append(" AND customer_address.company LIKE '%'");
				else if (customerSearchAttributeModel.getCompanyName() != null
						&& !"".equals(customerSearchAttributeModel.getCompanyName()))
					query.append("  AND customer_address.company LIKE '" + customerSearchAttributeModel.getCompanyName()
							+ "%'");

				if ("*".equals(customerSearchAttributeModel.getfName()))
					query.append(" AND customer.fname LIKE '%'");
				else if (customerSearchAttributeModel.getfName() != null
						&& !"".equals(customerSearchAttributeModel.getfName()))
					query.append(" AND customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "'");

				if ("*".equals(customerSearchAttributeModel.getlName()))
					query.append(" AND customer.lname  LIKE '%'");
				else if (customerSearchAttributeModel.getlName() != null
						&& !"".equals(customerSearchAttributeModel.getlName()))
					query.append(" AND customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

				query.append(" AND customer_address.company is not null)");

				query.append(" ORDER BY customer_address.customer_id asc");

			} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())
					&& customerSearchAttributeModel.getFourDigitCard().equals(null)) {

				query.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer,payment WHERE"
						+ " (customer.customer_id = customer_address.customer_id) and (customer.customer_id = payment.customer_id)"
						+ " and ((customer.inactive = 0 OR customer.inactive is NULL)");

				if ("*".equals(customerSearchAttributeModel.getCheque()))
					query.append(" AND payment.check_number is not null");
				else if (customerSearchAttributeModel.getCheque() != null
						&& !"".equals(customerSearchAttributeModel.getCheque()))
					query.append(" AND payment.check_number like '" + customerSearchAttributeModel.getCheque() + "%'");

				query.append(")");

				query.append(" ORDER BY customer_address.customer_id asc");

			} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("( SELECT  TOP " + customerSearchAttributeModel.getLimit()
						+ " p.customer_id as pay_customer_id, p.payment_seq, p.currency, p.creation_date, p.id_nbr,"
						+ " p.id_nbr_last_four, p.exp_date, p.ref_nbr, p.auth_code, p.auth_date, p.clear_date, p.payment_clear_status,"
						+ " p.payment_type, p.base_amount, p.pay_currency_amount, p.transaction_reason, p.transaction_type, p.check_number"
						+ "  ,address1,address2,city,state,lname,company,department,zip,phone,"
						+ "email,fname,county,audit_county,oi.orderhdr_id, oi.order_item_seq, oi.customer_id  from payment p,"
						+ " paybreak pb, customer_address ca, order_item oi  where p.customer_id = pb.customer_id  and"
						+ "  p.payment_seq = pb.payment_seq  and pb.order_item_amt_break_seq = 1  and p.customer_id = ca.customer_id  and "
						+ "  pb.customer_id = ca.customer_id  and oi.orderhdr_id = pb.orderhdr_id  and oi.order_item_seq = pb.order_item_seq ");

				if ("*".equals(customerSearchAttributeModel.getFourDigitCard())) {
					query.append("and  and p.id_nbr_last_four LIKE '%' ");
				}
				if (!"".equals(customerSearchAttributeModel.getFourDigitCard())) {
					query.append(" and p.id_nbr_last_four = " + customerSearchAttributeModel.getFourDigitCard() + " ");
				}

				query.append(")");

			} else if ("Subscriptions".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer,subscrip WHERE"
						+ " (customer.customer_id = customer_address.customer_id) and (customer.customer_id = subscrip.customer_id)"
						+ " and ((customer.inactive = 0 OR customer.inactive is NULL)");

				if (customerSearchAttributeModel.getSubscriptionNumber() != null
						&& !"".equals(customerSearchAttributeModel.getSubscriptionNumber()))
					query.append(" AND subscrip.subscrip_id=" + customerSearchAttributeModel.getSubscriptionNumber());

				query.append(")");

				query.append(" ORDER BY customer_address.customer_id asc");

			} else if ("OrderNumber".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address, customer,order_item WHERE"
						+ " (customer.customer_id = customer_address.customer_id) and (customer.customer_id = order_item.customer_id)"
						+ " and ((customer.inactive = 0 OR customer.inactive is NULL)");

				if (customerSearchAttributeModel.getOrderNumber() != null
						&& !"".equals(customerSearchAttributeModel.getOrderNumber()))
					query.append(" AND order_item.orderhdr_id=" + customerSearchAttributeModel.getOrderNumber());

				query.append(")");

				query.append(" ORDER BY customer_address.customer_id asc");

			} else if ("ReferenceNumber".equals(customerSearchAttributeModel.getSearchBy())) {

				query.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
						+ " customer_address.* FROM customer_address"
						+ " left join customer on customer.customer_id = customer_address.customer_id"
						+ " left join order_item on customer.customer_id = order_item.customer_id"
						+ " left join orderhdr on order_item.orderhdr_id = orderhdr.orderhdr_id"
						+ " left join order_item_note on order_item.orderhdr_id = order_item_note.orderhdr_id WHERE"
						+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

				if ("*".equals(customerSearchAttributeModel.getAgentReference()))
					query.append(" AND  order_item.agent_ref_nbr  LIKE '%'");
				else if (customerSearchAttributeModel.getAgentReference() != null
						&& !"".equals(customerSearchAttributeModel.getAgentReference()))
					query.append(" AND order_item.agent_ref_nbr like '"
							+ customerSearchAttributeModel.getAgentReference() + "%'");

				if (customerSearchAttributeModel.getSalesInvoice() != null
						&& !"".equals(customerSearchAttributeModel.getSalesInvoice()))
					query.append(" AND order_item.invoice_id=" + customerSearchAttributeModel.getSalesInvoice());

				if ("*".equals(customerSearchAttributeModel.getPoNumber()))
					query.append(" AND  orderhdr.po_number  LIKE '%'");
				else if (customerSearchAttributeModel.getPoNumber() != null
						&& !"".equals(customerSearchAttributeModel.getPoNumber()))
					query.append(" AND orderhdr.po_number like '" + customerSearchAttributeModel.getPoNumber() + "%'");

				if ("*".equals(customerSearchAttributeModel.getCreditNote()))
					query.append(" AND  order_item_note.note_field  LIKE '%'");
				else if (customerSearchAttributeModel.getCreditNote() != null
						&& !"".equals(customerSearchAttributeModel.getCreditNote()))
					query.append(" AND order_item_note.note_field like '%"
							+ customerSearchAttributeModel.getCreditNote() + "%'");

				query.append(")");

				query.append(" ORDER BY customer_address.customer_id asc");

			}

			result = jdbcTemplate.query(query.toString(), new CustomerAddressMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return result;
	}

	@Override
	public List<Map<String, Object>> getCustomerSearchByAddress(
			CustomerSearchAttributeModel customerSearchAttributeModel) throws SQLException {
		LOGGER.info("Inside getCustomerSearchByAddress");

		StringBuilder customerquery = new StringBuilder("");
		if ("Name".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, " + "(select DISTINCT TOP "
					+ customerSearchAttributeModel.getLimit() + " customer_address.customer_id"
					+ " from customer, customer_address"
					+ " where (customer.inactive = 0 OR customer.inactive is NULL)");
			if ("*".equals(customerSearchAttributeModel.getfName()))
				customerquery.append(" AND customer.fname LIKE '%'");
			else if (customerSearchAttributeModel.getfName() != null
					&& !"".equals(customerSearchAttributeModel.getfName()))
				if (customerSearchAttributeModel.getfName().contains("*")) {
					String fName = customerSearchAttributeModel.getfName().replace("*", "");
					customerquery.append(" AND (customer.fname LIKE '" + fName + "%'"
							+ " OR customer_address.fname LIKE '" + fName + "%')");
				} else {
					customerquery.append(" AND (customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "'"
							+ " OR customer_address.fname LIKE '" + customerSearchAttributeModel.getfName() + "')");
				}

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND customer.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				if (customerSearchAttributeModel.getlName().contains("*")) {
					String lName = customerSearchAttributeModel.getlName().replace("*", "");
					customerquery.append(" AND (customer.lname LIKE '" + lName + "%'"
							+ " OR customer_address.lname LIKE '" + lName + "%')");
				} else {
					customerquery.append(" AND (customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'"
							+ " OR customer_address.lname LIKE '" + customerSearchAttributeModel.getlName() + "')");
				}

			if ("*".equals(customerSearchAttributeModel.getInitial()))
				customerquery.append(" AND customer.initial_name  LIKE '%'");
			else if (customerSearchAttributeModel.getInitial() != null
					&& !"".equals(customerSearchAttributeModel.getInitial()))
				if (customerSearchAttributeModel.getlName().contains("*")) {
					String initialName = customerSearchAttributeModel.getInitial().replace("*", "");
					customerquery.append(" AND (customer.initial_name LIKE '" + initialName + "%'"
							+ " OR customer_address.initial_name LIKE '" + initialName + "%')");
				} else {
					customerquery
							.append(" AND (customer.initial_name LIKE '" + customerSearchAttributeModel.getInitial()
									+ "'" + " OR customer_address.initial_name LIKE '"
									+ customerSearchAttributeModel.getInitial() + "')");
				}

			customerquery.append(" AND customer.customer_id = customer_address.customer_id) as customer"
					+ " WHERE replace_customer_address_seq IS NULL and customer.customer_id = customer_address.customer_id ORDER BY customer_address.customer_id asc");

		} else if ("CustomerID".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer"
					+ " WHERE replace_customer_address_seq IS NULL and (customer.customer_id = customer_address.customer_id) and"
					+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

			if (customerSearchAttributeModel.getCustomerId() != null
					&& !"".equals(customerSearchAttributeModel.getCustomerId()))
				if (customerSearchAttributeModel.getCustomerId().contains("-")) {
					String custId[] = customerSearchAttributeModel.getCustomerId().split("-");
					customerquery.append("  AND customer.customer_id BETWEEN " + custId[0] + " AND " + custId[1]);
				} else {
					customerquery.append("  AND customer.customer_id=" + customerSearchAttributeModel.getCustomerId());
				}

			customerquery.append(")");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("phoneNo".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer"
					+ " WHERE (customer.customer_id = customer_address.customer_id) and"
					+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getPhoneNumber()))
				customerquery.append(" AND customer_address.phone LIKE '%'");
			else if (customerSearchAttributeModel.getPhoneNumber() != null
					&& !"".equals(customerSearchAttributeModel.getPhoneNumber()))
				if (customerSearchAttributeModel.getPhoneNumber().contains("*")) {
					String phnNum = customerSearchAttributeModel.getPhoneNumber().replace("*", "");
					customerquery.append(" AND customer_address.phone LIKE '" + phnNum + "%'");
				} else {
					customerquery.append(" AND customer_address.phone LIKE '"
							+ customerSearchAttributeModel.getPhoneNumber() + "'");
				}

			if ("*".equals(customerSearchAttributeModel.geteMail()))
				customerquery.append(" AND customer_address.email LIKE '%'");
			else if (customerSearchAttributeModel.geteMail() != null
					&& !"".equals(customerSearchAttributeModel.geteMail()))
				if (customerSearchAttributeModel.geteMail().contains("*")) {
					String email = customerSearchAttributeModel.geteMail().replace("*", "");
					customerquery.append(" AND customer_address.email LIKE '" + email + "%'");

				} else {
					customerquery.append(
							" AND customer_address.email LIKE '" + customerSearchAttributeModel.geteMail() + "%'");
				}

			customerquery.append(") ORDER BY customer_address.customer_id asc");

		} else if ("ZipCode".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer"
					+ " WHERE (customer.customer_id = customer_address.customer_id) and"
					+ " (customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND customer.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				if (customerSearchAttributeModel.getlName().contains("*")) {
					String lName = customerSearchAttributeModel.getlName().replace("*", "");
					customerquery.append(" AND (customer.lname LIKE '" + lName + "%'"
							+ " OR customer_address.lname LIKE '" + lName + "%')");
				} else {
					customerquery.append(" AND (customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'"
							+ " OR customer_address.lname LIKE '" + customerSearchAttributeModel.getlName() + "')");
				}

			if (customerSearchAttributeModel.getCountry() != null
					&& !"".equals(customerSearchAttributeModel.getCountry()))
				customerquery
						.append("  AND customer_address.state='" + customerSearchAttributeModel.getCountry() + "'");

			if ("*".equals(customerSearchAttributeModel.getPostalCode()))
				customerquery.append(" AND customer_address.zip LIKE '%'");
			else if (customerSearchAttributeModel.getPostalCode() != null
					&& !"".equals(customerSearchAttributeModel.getPostalCode()))
				if (customerSearchAttributeModel.getPostalCode().contains("*")) {
					String zipCode = customerSearchAttributeModel.getPostalCode().replace("*", "");
					customerquery.append("  AND customer_address.zip LIKE '" + zipCode + "%'");
				} else {
					customerquery.append(
							"  AND customer_address.zip LIKE '" + customerSearchAttributeModel.getPostalCode() + "'");
				}

//							customerquery.append(" AND customer_address.zip is not null)");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("Company".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer"
					+ " WHERE (customer.customer_id = customer_address.customer_id) and"
					+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getCompanyName()))
				customerquery.append(" AND customer.company LIKE '%'");
			else if (customerSearchAttributeModel.getCompanyName() != null
					&& !"".equals(customerSearchAttributeModel.getCompanyName()))
				if (customerSearchAttributeModel.getCompanyName().contains("*")) {
					String company = customerSearchAttributeModel.getCompanyName().replace("*", "");
					customerquery.append(" AND customer.company LIKE '" + company + "%'"
							+ " OR customer_address.company LIKE '" + company + "%'");
				} else {
					customerquery.append(
							" AND customer.company LIKE '" + customerSearchAttributeModel.getCompanyName() + "'");
				}

			if ("*".equals(customerSearchAttributeModel.getfName()))
				customerquery.append(" AND customer.fname LIKE '%'");
			else if (customerSearchAttributeModel.getfName() != null
					&& !"".equals(customerSearchAttributeModel.getfName()))
				if (customerSearchAttributeModel.getfName().contains("*")) {
					String fName = customerSearchAttributeModel.getfName().replace("*", "");
					customerquery.append(" AND (customer.fname LIKE '" + fName + "%'"
							+ " OR customer_address.fname LIKE '" + fName + "%')");
				} else {
					customerquery.append(" AND (customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "'"
							+ " OR customer_address.fname LIKE '" + customerSearchAttributeModel.getfName() + "')");
				}

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND customer.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				if (customerSearchAttributeModel.getlName().contains("*")) {
					String lName = customerSearchAttributeModel.getlName().replace("*", "");
					customerquery.append(" AND (customer.lname LIKE '" + lName + "%'"
							+ " OR customer_address.lname LIKE '" + lName + "%')");
				} else {
					customerquery.append(" AND (customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'"
							+ " OR customer_address.lname LIKE '" + customerSearchAttributeModel.getlName() + "')");
				}

			customerquery.append(" AND customer.company is not null)");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())
				&& customerSearchAttributeModel.getFourDigitCard().equals(null)) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer,payment WHERE"
					+ " (customer.customer_id = customer_address.customer_id) and (customer.customer_id = payment.customer_id)"
					+ " and ((customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getCheque()))
				customerquery.append(" AND payment.check_number is not null");
			else if (customerSearchAttributeModel.getCheque() != null
					&& !"".equals(customerSearchAttributeModel.getCheque()))
				if (customerSearchAttributeModel.getCheque().contains("*")) {
					String cheque = customerSearchAttributeModel.getCheque().replace("*", "");
					customerquery.append(" AND payment.check_number like '" + cheque + "%'");
				} else {
					customerquery.append(
							" AND payment.check_number like '" + customerSearchAttributeModel.getCheque() + "'");
				}

			customerquery.append(")");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("Subscriptions".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer,subscrip WHERE"
					+ " (customer.customer_id = customer_address.customer_id) and (customer.customer_id = subscrip.customer_id)"
					+ " and ((customer.inactive = 0 OR customer.inactive is NULL)");

			if (customerSearchAttributeModel.getSubscriptionNumber() != null
					&& !"".equals(customerSearchAttributeModel.getSubscriptionNumber()))
				if (customerSearchAttributeModel.getSubscriptionNumber().contains("-")) {
					String subscripNum[] = customerSearchAttributeModel.getSubscriptionNumber().split("-");
					customerquery
							.append(" AND subscrip.subscrip_id BETWEEN " + subscripNum[0] + " AND " + subscripNum[1]);
				} else {
					customerquery.append(
							" AND subscrip.subscrip_id=" + customerSearchAttributeModel.getSubscriptionNumber());
				}

			customerquery.append(")");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("OrderNumber".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT DISTINCT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address, customer,order_item WHERE"
					+ " (customer.customer_id = customer_address.customer_id) and (customer.customer_id = order_item.customer_id)"
					+ " and ((customer.inactive = 0 OR customer.inactive is NULL)");

			if (customerSearchAttributeModel.getOrderNumber() != null
					&& !"".equals(customerSearchAttributeModel.getOrderNumber()))
				if (customerSearchAttributeModel.getOrderNumber().contains("*")) {
					String ordNum[] = customerSearchAttributeModel.getOrderNumber().split("-");
					customerquery.append(" AND order_item.orderhdr_id BETWEEN " + ordNum[0] + " AND " + ordNum[1]);
				} else {
					customerquery
							.append(" AND order_item.orderhdr_id=" + customerSearchAttributeModel.getOrderNumber());
				}

			customerquery.append(")");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("ReferenceNumber".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " customer_address.* FROM customer_address"
					+ " left join customer on customer.customer_id = customer_address.customer_id"
					+ " left join order_item on customer.customer_id = order_item.customer_id"
					+ " left join orderhdr on order_item.orderhdr_id = orderhdr.orderhdr_id"
					+ " left join order_item_note on order_item.orderhdr_id = order_item_note.orderhdr_id WHERE"
					+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getAgentReference()))
				customerquery.append(" AND  order_item.agent_ref_nbr  LIKE '%'");
			else if (customerSearchAttributeModel.getAgentReference() != null
					&& !"".equals(customerSearchAttributeModel.getAgentReference()))
				customerquery.append(" AND order_item.agent_ref_nbr like '"
						+ customerSearchAttributeModel.getAgentReference() + "%'");

			if (customerSearchAttributeModel.getSalesInvoice() != null
					&& !"".equals(customerSearchAttributeModel.getSalesInvoice()))
				customerquery.append(" AND order_item.invoice_id=" + customerSearchAttributeModel.getSalesInvoice());

			if ("*".equals(customerSearchAttributeModel.getPoNumber()))
				customerquery.append(" AND  orderhdr.po_number  LIKE '%'");
			else if (customerSearchAttributeModel.getPoNumber() != null
					&& !"".equals(customerSearchAttributeModel.getPoNumber()))
				customerquery
						.append(" AND orderhdr.po_number like '" + customerSearchAttributeModel.getPoNumber() + "%'");

			if ("*".equals(customerSearchAttributeModel.getCreditNote()))
				customerquery.append(" AND  order_item_note.note_field  LIKE '%'");
			else if (customerSearchAttributeModel.getCreditNote() != null
					&& !"".equals(customerSearchAttributeModel.getCreditNote()))
				customerquery.append(" AND order_item_note.note_field like '%"
						+ customerSearchAttributeModel.getCreditNote() + "%'");

			customerquery.append(")");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("( SELECT  TOP " + customerSearchAttributeModel.getLimit()
					+ " p.customer_id as pay_customer_id, p.payment_seq, p.currency, p.creation_date, p.id_nbr,"
					+ " p.id_nbr_last_four, p.exp_date, p.ref_nbr, p.auth_code, p.auth_date, p.clear_date, p.payment_clear_status,"
					+ " p.payment_type, p.base_amount, p.pay_currency_amount, p.transaction_reason, p.transaction_type, p.check_number"
					+ "  ,address1,address2,city,state,lname,company,department,zip,phone,"
					+ "email,fname,county,audit_county,oi.orderhdr_id, oi.order_item_seq, oi.customer_id  from payment p,"
					+ " paybreak pb, customer_address ca, order_item oi  where p.customer_id = pb.customer_id  and"
					+ "  p.payment_seq = pb.payment_seq  and pb.order_item_amt_break_seq = 1  and p.customer_id = ca.customer_id  and "
					+ "  pb.customer_id = ca.customer_id  and oi.orderhdr_id = pb.orderhdr_id  and oi.order_item_seq = pb.order_item_seq ");

			if ("*".equals(customerSearchAttributeModel.getFourDigitCard())) {
				customerquery.append("and  and p.id_nbr_last_four LIKE '%' ");
			}
			if (!"".equals(customerSearchAttributeModel.getFourDigitCard())) {
				customerquery
						.append(" and p.id_nbr_last_four = " + customerSearchAttributeModel.getFourDigitCard() + " ");
			}

			customerquery.append(")");

		}

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(customerquery.toString());

		for (Map<String, Object> row : rows)
			if (row.get("phone") != null && !"".equals(row.get("phone"))) {
				String stateCode = (String) row.get("state");
				List<String> abc = jdbcTemplate
						.queryForList("select phonefmt from state where state='" + stateCode + "'", String.class);
				if (abc.get(0) != null) {
					String[] phn = abc.get(0).split(" ");
					String phone1 = phn[0] + " " + row.get("phone");
					row.put("phone", phone1);
				}

			}

		return rows;
	}

	@Override
	public List<Map<String, Object>> getCustomerSearchByOrder(CustomerSearchAttributeModel customerSearchAttributeModel)
			throws SQLException {
		LOGGER.info("Inside getCustomerSearchByOrder");

		StringBuilder customerquery = new StringBuilder("");
		if ("Name".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all, customer"
					+ " WHERE (view_order_tab_list_all.customer_id = customer.customer_id) and (1=1 ");
			if ("*".equals(customerSearchAttributeModel.getfName()))
				customerquery.append("AND customer.fname LIKE '%'");
			else if (customerSearchAttributeModel.getfName() != null
					&& !"".equals(customerSearchAttributeModel.getfName()))
				if ("*".contains(customerSearchAttributeModel.getfName())) {
					customerquery.append(" AND customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "%'");
				} else {
					customerquery.append(" AND customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "'");
				}

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND customer.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				if ("*".contains(customerSearchAttributeModel.getfName())) {
					customerquery.append(" AND customer.fname LIKE '" + customerSearchAttributeModel.getfName() + "%'");
				} else {
					customerquery.append(" AND customer.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");
				}

			if ("*".equals(customerSearchAttributeModel.getInitial()))
				customerquery.append(" AND customer.initial_name  LIKE '%'");
			else if (customerSearchAttributeModel.getInitial() != null
					&& !"".equals(customerSearchAttributeModel.getInitial()))
				customerquery
						.append(" AND customer.initial_name LIKE '" + customerSearchAttributeModel.getInitial() + "'");

			customerquery.append("AND (customer.inactive = 0 OR customer.inactive is NULL))");

		} else if ("CustomerID".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all, customer WHERE (customer.customer_id = view_order_tab_list_all.customer_id) "
					+ " and (");

			if (customerSearchAttributeModel.getCustomerId() != null)
				customerquery.append("  customer.customer_id=" + customerSearchAttributeModel.getCustomerId());

			customerquery.append(" AND (customer.inactive = 0 OR customer.inactive is NULL))");

		} else if ("phoneNo".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all, customer_address "
					+ "WHERE (view_order_tab_list_all.customer_id = customer_address.customer_id) ");

			if ("*".equals(customerSearchAttributeModel.getPhoneNumber()))
				customerquery.append(" AND customer_address.phone LIKE '%'");
			else if (customerSearchAttributeModel.getPhoneNumber() != null
					&& !"".equals(customerSearchAttributeModel.getPhoneNumber()))
				customerquery.append(
						" AND customer_address.phone LIKE '" + customerSearchAttributeModel.getPhoneNumber() + "%'");

			if ("*".equals(customerSearchAttributeModel.geteMail()))
				customerquery.append(" AND customer_address.email LIKE '%'");
			else if (customerSearchAttributeModel.geteMail() != null
					&& !"".equals(customerSearchAttributeModel.geteMail()))
				customerquery
						.append(" AND customer_address.email LIKE '" + customerSearchAttributeModel.geteMail() + "%'");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("ZipCode".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ "  view_order_tab_list_all.* FROM view_order_tab_list_all, customer_address "
					+ "  WHERE (view_order_tab_list_all.customer_id = customer_address.customer_id) ");

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND customer_address.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				customerquery
						.append(" AND customer_address.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

			if (customerSearchAttributeModel.getCountry() != null
					&& !"".equals(customerSearchAttributeModel.getCountry()))
				customerquery
						.append("  AND customer_address.state='" + customerSearchAttributeModel.getCountry() + "'");

			if ("*".equals(customerSearchAttributeModel.getPostalCode()))
				customerquery.append(" AND customer_address.zip LIKE '%'");
			else if (customerSearchAttributeModel.getPostalCode() != null
					&& !"".equals(customerSearchAttributeModel.getPostalCode()))
				customerquery.append(
						"  AND customer_address.zip LIKE '" + customerSearchAttributeModel.getPostalCode() + "%'");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("Company".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ "  view_order_tab_list_all.* FROM view_order_tab_list_all, customer_address "
					+ "  WHERE (view_order_tab_list_all.customer_id = customer_address.customer_id) ");

			if ("*".equals(customerSearchAttributeModel.getCompanyName()))
				customerquery.append(" AND customer_address.company LIKE '%'");
			else if (customerSearchAttributeModel.getCompanyName() != null
					&& !"".equals(customerSearchAttributeModel.getCompanyName()))
				customerquery.append(
						"  AND customer_address.company LIKE '" + customerSearchAttributeModel.getCompanyName() + "'");

			if ("*".equals(customerSearchAttributeModel.getfName()))
				customerquery.append("AND customer_address.fname LIKE '%'");
			else if (customerSearchAttributeModel.getfName() != null
					&& !"".equals(customerSearchAttributeModel.getfName()))
				customerquery
						.append(" AND customer_address.fname LIKE '" + customerSearchAttributeModel.getfName() + "'");

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND customer_address.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				customerquery
						.append(" AND customer_address.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

			customerquery.append(" ORDER BY customer_address.customer_id asc");

		} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())
				&& customerSearchAttributeModel.getFourDigitCard().equals(null)) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all, payment "
					+ "WHERE (view_order_tab_list_all.customer_id = payment.customer_id) ");

			if ("*".equals(customerSearchAttributeModel.getCheque()))
				customerquery.append(" AND payment.check_number is not null");
			else if (customerSearchAttributeModel.getCheque() != null
					&& !"".equals(customerSearchAttributeModel.getCheque()))
				customerquery
						.append(" AND payment.check_number like '" + customerSearchAttributeModel.getCheque() + "%'");

			customerquery.append(" ORDER BY payment.customer_id asc");

		} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("( SELECT  TOP " + customerSearchAttributeModel.getLimit()
					+ " p.customer_id as pay_customer_id, p.payment_seq, p.currency, p.creation_date, p.id_nbr,"
					+ " p.id_nbr_last_four, p.exp_date, p.ref_nbr, p.auth_code, p.auth_date, p.clear_date, p.payment_clear_status,"
					+ " p.payment_type, p.base_amount, p.pay_currency_amount, p.transaction_reason, p.transaction_type, p.check_number"
					+ "  ,address1,address2,city,state,lname,company,department,zip,phone,"
					+ "email,fname,county,audit_county,oi.orderhdr_id, oi.order_item_seq, oi.customer_id  from payment p,"
					+ " paybreak pb, customer_address ca, order_item oi  where p.customer_id = pb.customer_id  and"
					+ "  p.payment_seq = pb.payment_seq  and pb.order_item_amt_break_seq = 1  and p.customer_id = ca.customer_id  and "
					+ "  pb.customer_id = ca.customer_id  and oi.orderhdr_id = pb.orderhdr_id  and oi.order_item_seq = pb.order_item_seq ");

			if ("*".equals(customerSearchAttributeModel.getFourDigitCard())) {
				customerquery.append("and  and p.id_nbr_last_four LIKE '%' ");
			}
			if (!"".equals(customerSearchAttributeModel.getFourDigitCard())) {
				customerquery
						.append(" and p.id_nbr_last_four = " + customerSearchAttributeModel.getFourDigitCard() + " ");
			}

			customerquery.append(")");

		} else if ("Subscriptions".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all ");

			if (customerSearchAttributeModel.getSubscriptionNumber() != null
					&& !"".equals(customerSearchAttributeModel.getSubscriptionNumber()))
				customerquery.append(" WHERE view_order_tab_list_all.subscrip_id="
						+ customerSearchAttributeModel.getSubscriptionNumber());

		} else if ("OrderNumber".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all ");

			if (customerSearchAttributeModel.getOrderNumber() != null
					&& !"".equals(customerSearchAttributeModel.getOrderNumber()))
				customerquery.append(
						" where view_order_tab_list_all.orderhdr_id=" + customerSearchAttributeModel.getOrderNumber());

		} else if ("RefrenceNumber".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_order_tab_list_all.* FROM view_order_tab_list_all"
					+ " left join customer on customer.customer_id = view_order_tab_list_all.customer_id"
					+ " left join order_item on customer.customer_id = order_item.customer_id"
					+ " left join orderhdr on order_item.orderhdr_id = orderhdr.orderhdr_id"
					+ " left join order_item_note on order_item.orderhdr_id = order_item_note.orderhdr_id WHERE"
					+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getAgentReference()))
				customerquery.append(" AND  order_item.agent_ref_nbr  LIKE '%'");
			else if (customerSearchAttributeModel.getAgentReference() != null
					&& !"".equals(customerSearchAttributeModel.getAgentReference()))
				customerquery.append(" AND order_item.agent_ref_nbr like '"
						+ customerSearchAttributeModel.getAgentReference() + "%'");

			if (customerSearchAttributeModel.getSalesInvoice() != null
					&& !"".equals(customerSearchAttributeModel.getSalesInvoice()))
				customerquery.append(" AND order_item.invoice_id=" + customerSearchAttributeModel.getSalesInvoice());

			if ("*".equals(customerSearchAttributeModel.getPoNumber()))
				customerquery.append(" AND  orderhdr.po_number  LIKE '%'");
			else if (customerSearchAttributeModel.getPoNumber() != null
					&& !"".equals(customerSearchAttributeModel.getPoNumber()))
				customerquery
						.append(" AND orderhdr.po_number like '" + customerSearchAttributeModel.getPoNumber() + "%'");

			if ("*".equals(customerSearchAttributeModel.getCreditNote()))
				customerquery.append(" AND  order_item_note.note_field  LIKE '%'");
			else if (customerSearchAttributeModel.getCreditNote() != null
					&& !"".equals(customerSearchAttributeModel.getCreditNote()))
				customerquery.append(" AND order_item_note.note_field like '%"
						+ customerSearchAttributeModel.getCreditNote() + "%'");

			customerquery.append(")");

			customerquery.append(" ORDER BY customer.customer_id asc");

		}

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(customerquery.toString());

		for (Map<String, Object> row : rows)

			if (row.get("phone") != null && !"".equals(row.get("phone"))) {
				String stateCode = (String) row.get("state");
				List<String> abc = jdbcTemplate
						.queryForList("select phonefmt from state where state='" + stateCode + "'", String.class);
				String[] phn = abc.get(0).split(" ");
				String phone1 = phn[0] + " " + row.get("phone");
				row.put("phone", phone1);
			}
		return rows;
	}

	@Override
	public List<Map<String, Object>> getCustomerSearchByPayment(
			CustomerSearchAttributeModel customerSearchAttributeModel) throws SQLException {
		LOGGER.info("Inside getCustomerSearchByPayment");

		StringBuilder customerquery = new StringBuilder("");
		if ("Name".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid, customer WHERE (view_payment_orderid.customer_id = customer.customer_id) and ( 1=1 ");

			if ("*".equals(customerSearchAttributeModel.getfName()))
				customerquery.append(" AND view_payment_orderid.fname LIKE '%'");
			else if (customerSearchAttributeModel.getfName() != null
					&& !"".equals(customerSearchAttributeModel.getfName()))
				customerquery.append(
						" AND view_payment_orderid.fname LIKE '" + customerSearchAttributeModel.getfName() + "'");

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND view_payment_orderid.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(
						" AND view_payment_orderid.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

			if ("*".equals(customerSearchAttributeModel.getInitial()))
				customerquery.append(" AND customer.initial_name  LIKE '%'");
			else if (customerSearchAttributeModel.getInitial() != null
					&& !"".equals(customerSearchAttributeModel.getInitial()))
				customerquery
						.append(" AND customer.initial_name LIKE '" + customerSearchAttributeModel.getInitial() + "'");

			customerquery.append(" AND (customer.inactive = 0 OR customer.inactive is NULL))");

		} else if ("CustomerID".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid, customer WHERE (customer.customer_id = view_payment_orderid.customer_id) "
					+ "and (");

			if (customerSearchAttributeModel.getCustomerId() != null)
				customerquery.append("  customer.customer_id=" + customerSearchAttributeModel.getCustomerId());

			customerquery.append(" AND (customer.inactive = 0 OR customer.inactive is NULL))");

		} else if ("phoneNo".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid,customer WHERE (customer.customer_id = view_payment_orderid.customer_id) and (customer.inactive = 0 OR customer.inactive is NULL) ");

			if ("*".equals(customerSearchAttributeModel.getPhoneNumber()))
				customerquery.append(" AND view_payment_orderid.phone LIKE '%'");
			else if (customerSearchAttributeModel.getPhoneNumber() != null
					&& !"".equals(customerSearchAttributeModel.getPhoneNumber()))
				customerquery.append(" AND view_payment_orderid.phone LIKE '"
						+ customerSearchAttributeModel.getPhoneNumber() + "%'");

			if ("*".equals(customerSearchAttributeModel.geteMail()))
				customerquery.append(" AND customer.email LIKE '%'");
			else if (customerSearchAttributeModel.geteMail() != null
					&& !"".equals(customerSearchAttributeModel.geteMail()))
				customerquery.append(" AND customer.email LIKE '" + customerSearchAttributeModel.geteMail() + "%'");

			customerquery.append(" ORDER BY customer.customer_id asc");

		} else if ("ZipCode".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid,customer WHERE (customer.customer_id = view_payment_orderid.customer_id) and (customer.inactive = 0 OR customer.inactive is NULL) ");

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND view_payment_orderid.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(
						" AND view_payment_orderid.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

			if (customerSearchAttributeModel.getCountry() != null
					&& !"".equals(customerSearchAttributeModel.getCountry()))
				customerquery
						.append("  AND view_payment_orderid.state='" + customerSearchAttributeModel.getCountry() + "'");

			if ("*".equals(customerSearchAttributeModel.getPostalCode()))
				customerquery.append(" AND view_payment_orderid.zip LIKE '%'");
			else if (customerSearchAttributeModel.getPostalCode() != null
					&& !"".equals(customerSearchAttributeModel.getPostalCode()))
				customerquery.append(
						"  AND view_payment_orderid.zip LIKE '" + customerSearchAttributeModel.getPostalCode() + "%'");

			customerquery.append(" ORDER BY view_payment_orderid.customer_id asc");

		} else if ("Company".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid,customer WHERE (customer.customer_id = view_payment_orderid.customer_id) and (customer.inactive = 0 OR customer.inactive is NULL) ");

			if ("*".equals(customerSearchAttributeModel.getCompanyName()))
				customerquery.append(" AND view_payment_orderid.company LIKE '%'");
			else if (customerSearchAttributeModel.getCompanyName() != null
					&& !"".equals(customerSearchAttributeModel.getCompanyName()))
				customerquery.append("  AND view_payment_orderid.company LIKE '"
						+ customerSearchAttributeModel.getCompanyName() + "'");

			if ("*".equals(customerSearchAttributeModel.getfName()))
				customerquery.append(" AND view_payment_orderid.fname LIKE '%'");
			else if (customerSearchAttributeModel.getfName() != null
					&& !"".equals(customerSearchAttributeModel.getfName()))
				customerquery.append(
						" AND view_payment_orderid.fname LIKE '" + customerSearchAttributeModel.getfName() + "'");

			if ("*".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(" AND view_payment_orderid.lname  LIKE '%'");
			else if (customerSearchAttributeModel.getlName() != null
					&& !"".equals(customerSearchAttributeModel.getlName()))
				customerquery.append(
						" AND view_payment_orderid.lname LIKE '" + customerSearchAttributeModel.getlName() + "'");

			customerquery.append(" ORDER BY view_payment_orderid.customer_id asc");

		} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())
				&& customerSearchAttributeModel.getFourDigitCard().equals(null)) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid WHERE ");

			if ("*".equals(customerSearchAttributeModel.getCheque()))
				customerquery.append(" view_payment_orderid.check_number is not null");
			else if (customerSearchAttributeModel.getCheque() != null
					&& !"".equals(customerSearchAttributeModel.getCheque()))
				customerquery.append(
						"view_payment_orderid.check_number like '" + customerSearchAttributeModel.getCheque() + "%'");

			customerquery.append(" ORDER BY view_payment_orderid.customer_id asc");

		} else if ("Payment".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("( SELECT  TOP " + customerSearchAttributeModel.getLimit()
					+ " p.customer_id as pay_customer_id, p.payment_seq, p.currency, p.creation_date, p.id_nbr,"
					+ " p.id_nbr_last_four, p.exp_date, p.ref_nbr, p.auth_code, p.auth_date, p.clear_date, p.payment_clear_status,"
					+ " p.payment_type, p.base_amount, p.pay_currency_amount, p.transaction_reason, p.transaction_type, p.check_number"
					+ "  ,address1,address2,city,state,lname,company,department,zip,phone,"
					+ "email,fname,county,audit_county,oi.orderhdr_id, oi.order_item_seq, oi.customer_id  from payment p,"
					+ " paybreak pb, customer_address ca, order_item oi  where p.customer_id = pb.customer_id  and"
					+ "  p.payment_seq = pb.payment_seq  and pb.order_item_amt_break_seq = 1  and p.customer_id = ca.customer_id  and "
					+ "  pb.customer_id = ca.customer_id  and oi.orderhdr_id = pb.orderhdr_id  and oi.order_item_seq = pb.order_item_seq ");

			if ("*".equals(customerSearchAttributeModel.getFourDigitCard())) {
				customerquery.append("and  and p.id_nbr_last_four LIKE '%' ");
			}
			if (!"".equals(customerSearchAttributeModel.getFourDigitCard())) {
				customerquery
						.append(" and p.id_nbr_last_four = " + customerSearchAttributeModel.getFourDigitCard() + " ");
			}

			customerquery.append(")");

		} else if ("Subscriptions".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid, subscrip WHERE (view_payment_orderid.customer_id = subscrip.customer_id) ");

			if (customerSearchAttributeModel.getSubscriptionNumber() != null
					&& !"".equals(customerSearchAttributeModel.getSubscriptionNumber()))
				customerquery
						.append(" AND subscrip.subscrip_id=" + customerSearchAttributeModel.getSubscriptionNumber());

		} else if ("OrderNumber".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid ");

			if (customerSearchAttributeModel.getOrderNumber() != null
					&& !"".equals(customerSearchAttributeModel.getOrderNumber()))
				customerquery.append(
						" WHERE view_payment_orderid.orderhdr_id=" + customerSearchAttributeModel.getOrderNumber());

		} else if ("RefrenceNumber".equals(customerSearchAttributeModel.getSearchBy())) {

			customerquery.append("SELECT TOP " + customerSearchAttributeModel.getLimit()
					+ " view_payment_orderid.* FROM view_payment_orderid"
					+ " left join customer on customer.customer_id = view_payment_orderid.customer_id"
					+ " left join order_item on customer.customer_id = order_item.customer_id"
					+ " left join orderhdr on order_item.orderhdr_id = orderhdr.orderhdr_id"
					+ " left join order_item_note on order_item.orderhdr_id = order_item_note.orderhdr_id WHERE"
					+ " ((customer.inactive = 0 OR customer.inactive is NULL)");

			if ("*".equals(customerSearchAttributeModel.getAgentReference()))
				customerquery.append(" AND  order_item.agent_ref_nbr  LIKE '%'");
			else if (customerSearchAttributeModel.getAgentReference() != null
					&& !"".equals(customerSearchAttributeModel.getAgentReference()))
				customerquery.append(" AND order_item.agent_ref_nbr like '"
						+ customerSearchAttributeModel.getAgentReference() + "%'");

			if (customerSearchAttributeModel.getSalesInvoice() != null
					&& !"".equals(customerSearchAttributeModel.getSalesInvoice()))
				customerquery.append(" AND order_item.invoice_id=" + customerSearchAttributeModel.getSalesInvoice());

			if ("*".equals(customerSearchAttributeModel.getPoNumber()))
				customerquery.append(" AND  orderhdr.po_number  LIKE '%'");
			else if (customerSearchAttributeModel.getPoNumber() != null
					&& !"".equals(customerSearchAttributeModel.getPoNumber()))
				customerquery
						.append(" AND orderhdr.po_number like '" + customerSearchAttributeModel.getPoNumber() + "%'");

			if ("*".equals(customerSearchAttributeModel.getCreditNote()))
				customerquery.append(" AND  order_item_note.note_field  LIKE '%'");
			else if (customerSearchAttributeModel.getCreditNote() != null
					&& !"".equals(customerSearchAttributeModel.getCreditNote()))
				customerquery.append(" AND order_item_note.note_field like '%"
						+ customerSearchAttributeModel.getCreditNote() + "%'");

			customerquery.append(")");

			customerquery.append(" ORDER BY customer.customer_id asc");

		}

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(customerquery.toString());
		for (Map<String, Object> row : rows)

			if (row.get("phone") != null && !"".equals(row.get("phone"))) {
				String stateCode = (String) row.get("state");
				List<String> abc = jdbcTemplate
						.queryForList("select phonefmt from state where state='" + stateCode + "'", String.class);
				if (abc.get(0) != null) {
					String[] phn = abc.get(0).split(" ");
					String phone1 = phn[0] + " " + row.get("phone");
					row.put("phone", phone1);
				}

			}

		return rows;
	}

	@Override
	public List<DropdownModel> getStateList() throws SQLException {
		LOGGER.info("Inside getStateList");
		List<DropdownModel> stateList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select state,description,country_code2,country from state order by state asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get(STATE));
				model.setDisplay(row.get("description")!=null?row.get("description").toString():"");
				model.setDescription(row.get("country")!=null?row.get("country").toString():"");
				model.setExtra(row.get("country_code2")!=null?row.get("country_code2").toString():"");
				stateList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return stateList;

	}

	@Override
	public List<DropdownModel> getaddressType() throws SQLException {
		LOGGER.info("Inside getaddressType");
		List<DropdownModel> addressType = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select address_type,description from address_type order by address_type asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get("address_type"));
				model.setDisplay(row.get("description").toString());
				addressType.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return addressType;

	}

	@Override
	public List<DropdownModel> getlistRental() throws SQLException {
		LOGGER.info("Inside getlistRental");
		List<DropdownModel> listRental = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select list_rental_category,description from list_rental_category order by list_rental_category asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get("list_rental_category"));
				model.setDisplay((String) row.get("description"));
				listRental.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return listRental;

	}

	@Override
	public List<DropdownModel> getcustomerCategory() throws SQLException {
		LOGGER.info("Inside getcustomerCategory");
		List<DropdownModel> customerCategory = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select customer_category,description from customer_category where active=1 order by customer_category asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey((String) row.get("customer_category"));
				model.setDisplay((String) row.get("description"));
				customerCategory.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return customerCategory;

	}

	@Override
	public List<DropdownModel> getsalesRepresentative() throws SQLException {
		LOGGER.info("Inside getsalesRepresentative");
		List<DropdownModel> salesRepresentative = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select sales_representative_id,sales_representative from sales_representative where inactive=0 order by sales_representative_id asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("sales_representative_id").toString());
				model.setDisplay((String) row.get("sales_representative"));
				salesRepresentative.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return salesRepresentative;

	}

	@Override
	public List<DropdownModel> getaddressStatus() throws SQLException {
		LOGGER.info("Inside getaddressStatus");
		List<DropdownModel> addressStatus = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select address_status,description,address_undeliverable from address_status order by address_status asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("address_status").toString());
				model.setDisplay((String) row.get("description"));
				model.setDescription(String.valueOf(row.get("address_undeliverable")));
				addressStatus.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return addressStatus;

	}

	@Override
	public List<DropdownModel> getcreditStatus() throws SQLException {
		LOGGER.info("Inside getcreditStatus");
		List<DropdownModel> creditStatus = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select credit_status,description,bad_credit from credit_status order by credit_status asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("credit_status").toString());
				model.setDisplay((String) row.get("description"));
				model.setDescription(String.valueOf(row.get("bad_credit")));
				creditStatus.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return creditStatus;

	}

	@Override
	public List<DropdownModel> gettaxFilter() throws SQLException {
		LOGGER.info("Inside gettaxFilter");
		List<DropdownModel> taxFilter = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select special_tax_id,exempt_status from special_tax_id order by special_tax_id asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("exempt_status").toString());
				model.setDisplay((String) row.get("special_tax_id"));
				taxFilter.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return taxFilter;

	}

	@Override
	public List<String> getCountry(String stateCode) throws SQLException {
		LOGGER.info("Inside getCountry");
		List<String> country = new ArrayList<String>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select distinct state,c.country_code2,country_code3,country_name,phonefmt from country c inner join state s on c.country_code2=s.country_code2 where s.state = '"
							+ stateCode + "'");
			for (Map<String, Object> row : rows) {
				country.add(row.get("country_code2") + "( " + row.get("country_name").toString().toUpperCase() + ") ");

				if (row.get("phonefmt") != null)
					country.add(row.get("phonefmt").toString());
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return country;

	}

	/* OPTIMIZED BY SOHRAB on 25-Oct-2019 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addCustomer(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		LOGGER.info("Inside addCustomer");
		try {
			Long maxCustomerId = jdbcTemplate.queryForObject("select max(customer_id) from customer;", Long.class);
			if (maxCustomerId == null) {
				maxCustomerId = (long) 0;
			}
			String customer_category = customerUtility
					.getStringValue(customerAddAttributeModel.getCustomerCategory()) != null
							? "'" + customerUtility.getStringValue(customerAddAttributeModel.getCustomerCategory())
									+ "'"
							: null;
			String user_code = customerUtility.getStringValue(customerAddAttributeModel.getUserCode()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getUserCode()) + "'"
					: null;
			String creation_date = formatYYYYMMDDHHMMSS.format(new Date()) != null
					? "'" + formatYYYYMMDDHHMMSS.format(new Date()) + "'"
					: null;
			String lname = customerUtility.getStringValue(customerAddAttributeModel.getlName()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getlName()) + "'"
					: null;
			String initial_name = customerUtility.getStringValue(customerAddAttributeModel.getInitial()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getInitial()) + "'"
					: null;
			String fname = customerUtility.getStringValue(customerAddAttributeModel.getfName()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getfName()) + "'"
					: null;
			String salutation = customerUtility.getStringValue(customerAddAttributeModel.getSalutation()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getSalutation()) + "'"
					: null;
			String suffix = customerUtility.getStringValue(customerAddAttributeModel.getSuffix()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getSuffix()) + "'"
					: null;
			String title = customerUtility.getStringValue(customerAddAttributeModel.getTitle()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getTitle()) + "'"
					: null;
			String email = customerUtility.getStringValue(customerAddAttributeModel.getEmail()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getEmail()) + "'"
					: null;
			String credit_status = customerUtility.getStringValue(customerAddAttributeModel.getCreditStatus()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getCreditStatus()) + "'"
					: null;
			String list_rental_category = customerUtility
					.getStringValue(customerAddAttributeModel.getListRental()) != null
							? "'" + customerUtility.getStringValue(customerAddAttributeModel.getListRental()) + "'"
							: null;
			String sales_representative_id = customerUtility
					.getStringValue(customerAddAttributeModel.getSales()) != null
							? "'" + customerUtility.getStringValue(customerAddAttributeModel.getSales()) + "'"
							: null;
			String institutional_identifier = customerUtility
					.getStringValue(customerAddAttributeModel.getInstitutionalIdentifier()) != null ? "'"
							+ customerUtility.getStringValue(customerAddAttributeModel.getInstitutionalIdentifier())
							+ "'" : null;
			String company = customerUtility.getStringValue(customerAddAttributeModel.getCompany()) != null
					? "'" + customerAddAttributeModel.getCompany() + "'"
					: null;
			String parent_inst_identifier = customerUtility
					.getStringValue(customerAddAttributeModel.getParentInstitutionalIdentifier()) != null
							? "'" + customerUtility
									.getStringValue(customerAddAttributeModel.getParentInstitutionalIdentifier()) + "'"
							: null;
			String customerQuery = null;
			//Added by Sohrab for prospect_only added below
			int prospect_only=0;
			if(null!=customerAddAttributeModel.getIsProspect() && !"".equals(customerAddAttributeModel.getIsProspect()))
			{
				if ("true".equals(customerAddAttributeModel.getIsProspect())) 
				{
					if(null!=customerAddAttributeModel.getProspectCategory() && !"".equals(customerAddAttributeModel.getProspectCategory())) 
					{
						prospect_only=1;
					}
				}
			}
			// CODE IS FOR EMAIL AUTHORIZATION BUTTON ON ADD CUSTOMER PAGE.
			 String business_processes = customerAddAttributeModel.getBusiness_processes();
			if (null != business_processes && !"".equals(business_processes)&& !"0".equalsIgnoreCase(business_processes) && !"null".equals(business_processes)) 
			{
				customerQuery = "INSERT INTO CUSTOMER "
						+ "(customer_id,customer_category,user_code,oc_id,creation_date,lname,initial_name,fname,salutation,suffix,title,email,credit_status,list_rental_category,mru_customer_address_seq,inactive,prospect_only,mru_payment_account_seq,sales_representative_id,institutional_identifier,company,parent_inst_identifier) VALUES "
						+ "(" + (maxCustomerId + 1) + ", " + customer_category + ", " + user_code + ",null, "
						+ creation_date + ", " + lname + "," + initial_name + "," + fname + "," + salutation + ","
						+ suffix + "," + title + "," + email + "," + credit_status + "," + list_rental_category
						+ ",1,0,"+prospect_only+",0," + sales_representative_id + "," + institutional_identifier + "," + company
						+ "," + parent_inst_identifier + ");";
			} else 
			{
				customerQuery = "INSERT INTO CUSTOMER "
						+ "(customer_id,customer_category,user_code,oc_id,creation_date,lname,initial_name,fname,salutation,suffix,title,email,credit_status,list_rental_category,mru_customer_address_seq,inactive,prospect_only,mru_payment_account_seq,sales_representative_id,institutional_identifier,company,parent_inst_identifier,email_authorization) VALUES "
						+ "(" + (maxCustomerId + 1) + ", " + customer_category + ", " + user_code + ",null, "
						+ creation_date + ", " + lname + "," + initial_name + "," + fname + "," + salutation + ","
						+ suffix + "," + title + "," + email + "," + credit_status + "," + list_rental_category
						+ ", 1, 0, ";
				if ("true".equals(customerAddAttributeModel.getIsProspect())) 
				{
					if(customerAddAttributeModel.getProspectCategory().equals(null) || customerAddAttributeModel.getProspectCategory().equals("") || customerAddAttributeModel.getProspectCategory().isEmpty()) 
					{
						customerQuery= customerQuery+"0";
					}else 
					{
						customerQuery= customerQuery+"1";
					}
				}else 
				{
					customerQuery= customerQuery+"0";
				}
				//THINKDEV-1010: Default value of email_authorization will be saved
				String email_authorization_query = "SELECT email_authorization FROM config;";
				String default_email_authorization = jdbcTemplate.queryForObject(email_authorization_query,String.class);
				if(null!=default_email_authorization)
				{
					default_email_authorization="0x" +default_email_authorization+"00";
					customerQuery= customerQuery+", 0," + sales_representative_id + "," + institutional_identifier + "," + company
							+ "," + parent_inst_identifier + ",convert(VARBINARY(10),"+default_email_authorization+"));";
				}else
				{
					customerQuery= customerQuery+", 0," + sales_representative_id + "," + institutional_identifier + "," + company
							+ "," + parent_inst_identifier + ",convert(VARBINARY(10),NULL));";
				}
			}
			jdbcTemplate.update(customerQuery);

			String state = customerUtility.getStringValue(customerAddAttributeModel.getState()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getState()) + "'"
					: null;
			String city = customerUtility.getStringValue(customerAddAttributeModel.getCity()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getCity()) + "'"
					: null;
			String county = customerUtility.getStringValue(customerAddAttributeModel.getCounty()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getCounty()) + "'"
					: null;
			String zip = customerUtility.getStringValue(customerAddAttributeModel.getZip()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getZip()) + "'"
					: null;
			String tax_id_number = customerUtility.getStringValue(customerAddAttributeModel.getTaxID()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getTaxID()) + "'"
					: null;
			String phone = customerUtility.getStringValue(customerAddAttributeModel.getPhone1()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getPhone1()) + "'"
					: null;
			String faxnbr = customerUtility.getStringValue(customerAddAttributeModel.getFax()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getFax()) + "'"
					: null;
			String eighthundred = customerUtility.getStringValue(customerAddAttributeModel.getPhone2()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getPhone2()) + "'"
					: null;
			String address_status = customerUtility.getStringValue(customerAddAttributeModel.getAddressStatus()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAddressStatus()) + "'"
					: null;
			String department = customerUtility.getStringValue(customerAddAttributeModel.getDepartment()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getDepartment()) + "'"
					: null;
			String address1 = customerUtility.getStringValue(customerAddAttributeModel.getAddress1()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAddress1()) + "'"
					: null;
			String address2 = customerUtility.getStringValue(customerAddAttributeModel.getAddress2()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAddress2()) + "'"
					: null;
			String address3 = customerUtility.getStringValue(customerAddAttributeModel.getAddress3()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAddress3()) + "'"
					: null;
			int special_tax_id = 0;
			if (null == customerUtility.getStringValue(customerAddAttributeModel.getSpecialTaxId())) {
				special_tax_id = 0;
			} else {
				special_tax_id = 1;
			}
			String address_type = customerUtility.getStringValue(customerAddAttributeModel.getAddressType()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAddressType()) + "'"
					: null;

			String customerAddressQuery = "INSERT INTO customer_address "
					+ "(customer_id,customer_address_seq,state,city,county,zip,tax_id_number,email,phone,faxnbr,eighthundred,fname,initial_name,lname,salutation,suffix,title,address_status,company,department,audit_name_change,audit_title_change,supp_clean,address1,address2,address3,special_tax_id,institutional_identifier,address_type,ignored_clean) VALUES "
					+ "(" + (maxCustomerId + 1) + ",1," + state + "," + city + "," + county + "," + zip + ","
					+ tax_id_number + "," + email + "," + phone + "," + faxnbr + "," + eighthundred + "," + fname + ","
					+ initial_name + "," + lname + "," + salutation + "," + suffix + "," + title + "," + address_status
					+ "," + company + "," + department + ",0,0,0," + address1 + "," + address2 + "," + address3 + ","
					+ special_tax_id + "," + institutional_identifier + "," + address_type + ",0);";

			jdbcTemplate.update(customerAddressQuery);

			String payment_threshold = customerUtility
					.getStringValue(customerAddAttributeModel.getPaymentThershold()) != null
							? "'" + customerUtility.getStringValue(customerAddAttributeModel.getPaymentThershold())
									+ "'"
							: null;
			String agency_code = customerUtility.getStringValue(customerAddAttributeModel.getAgencyCode()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAgencyCode()) + "'"
					: null;
			int remit = customerAddAttributeModel.getRemits();
			int discounts = "1".equals(customerAddAttributeModel.getBundleDiscount()) ? 1 : 0;
			int agency_pays_tax = "1".equals(customerAddAttributeModel.getAgencyPayTax()) ? 1 : 0;
			int tax_based_on_gross = customerAddAttributeModel.getTaxPayedOnGross();
			int agency_bill_to = "1".equals(customerAddAttributeModel.getIsBillTo()) ? 1 : 0;
			int agency_renew_to = "1".equals(customerAddAttributeModel.getIsRenewTo()) ? 1 : 0;
			double ren_commission = null == customerAddAttributeModel.getRenewalCommission() ? 0
					: customerAddAttributeModel.getRenewalCommission();
			double new_commission = null == customerAddAttributeModel.getNewOrderCommission() ? 0
					: customerAddAttributeModel.getNewOrderCommission();
			String agency_name = customerUtility.getStringValue(customerAddAttributeModel.getAgencyName()) != null
					? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAgencyName()) + "'"
					: null;
			if ("true".equals(customerAddAttributeModel.getIsAgency())) {
				String agencyQuery = "INSERT INTO agency "
						+ "(customer_id,payment_threshold,agency_code,remit,discounts,accept_ord,agency_pays_tax,tax_based_on_gross,agency_bill_to,agency_renew_to,ren_commission,new_commission,company) VALUES "
						+ "(" + (maxCustomerId + 1) + "," + payment_threshold + "," + agency_code + "," + remit + ","
						+ discounts + ",0," + agency_pays_tax + "," + tax_based_on_gross + "," + agency_bill_to + ","
						+ agency_renew_to + "," + ren_commission + "," + new_commission + "," + agency_name + ");";

				jdbcTemplate.update(agencyQuery);
			}
			StringBuilder matchcode;
			matchcode = customerUtility.getmatchCode(customerAddAttributeModel);
			String matchcodeString = null;
			if (null != matchcode) {
				matchcodeString = "'" + "".toString() + "'";
			}
			String customerMatchCodeQuery = "Insert INTO customer_address_match_code "
					+ "(customer_id,customer_address_seq,customer_match_code_id,match_code) VALUES " + "("
					+ (maxCustomerId + 1) + ",1,2," + matchcodeString + ");";

			jdbcTemplate.update(customerMatchCodeQuery);

			int count = customerUtility.getcurrentDateStampCount();
			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}
			String customer_group_customer_id = customerAddAttributeModel.getCustomerGroupCustomerId();
			String n_copies = customerAddAttributeModel.getnCopies() != null
					? "'" + customerAddAttributeModel.getnCopies() + "'"
					: null;
			int active = "1".equals(customerAddAttributeModel.getActive()) ? 1 : 0;
			int authorized = "1".equals(customerAddAttributeModel.getAuthorized()) ? 1 : 0;
			if ("true".equals(customerAddAttributeModel.getSetGroupMember())) {
				String groupMember = "insert into group_member (customer_group_customer_id,customer_id,customer_address_seq,n_copies,creation_date,active,authorized) values "
						+ "(" + customer_group_customer_id + "," + (maxCustomerId + 1) + ",1," + n_copies + ","
						+ creation_date + "," + active + "," + authorized + ");";

				jdbcTemplate.update(groupMember);

				String maxCustGrpMbrHistSeq = jdbcTemplate
						.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist;", String.class);
				int cust_grp_mbr_hist_seq = 0;
				if (maxCustGrpMbrHistSeq == null) {
					cust_grp_mbr_hist_seq = 1;
				} else {
					cust_grp_mbr_hist_seq = Integer.parseInt(maxCustGrpMbrHistSeq) + 1;
				}
				String custGrpMbrHist = "insert into cust_grp_mbr_hist (customer_group_customer_id,cust_grp_mbr_hist_seq,user_code,creation_date,mbr_action,customer_id,customer_address_seq,n_copies,active,authorized) values"
						+ "(" + customer_group_customer_id + "," + cust_grp_mbr_hist_seq + "," + user_code + ","
						+ creation_date + ",1," + (maxCustomerId + 1) + ",1," + n_copies + "," + active + ","
						+ authorized + ");";

				jdbcTemplate.update(custGrpMbrHist);

				String mruCustGrpMbrHistSeq = jdbcTemplate.queryForObject(
						"select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist where customer_group_customer_id=230;",
						String.class);
				mruCustGrpMbrHistSeq = mruCustGrpMbrHistSeq != null ? "'" + mruCustGrpMbrHistSeq + "'" : null;
				String customer = "update customer set mru_cust_grp_mbr_hist_seq=" + mruCustGrpMbrHistSeq
						+ " where customer_id=" + (maxCustomerId + 1) + ";";

				jdbcTemplate.update(customer);
			}
			if ("true".equals(customerAddAttributeModel.getIsProspect())) {
				Map<String, Object> parameters = new HashMap<String, Object>();
				String isProspect = "insert into customer_prospect (customer_id,customer_prospect_seq,source_code_id,referred_by_customer_id,creation_date,active_prospect,audit_qual_category,oc_id,prospect_category,audit_qual_source_id,audit_subscription_type_id,qual_date,audit_name_title_id,audit_sales_channel_id,customer_address_seq) "
						+ " values (:customer_id,:customer_prospect_seq,:source_code_id,:referred_by_customer_id,:creation_date,:active_prospect,:audit_qual_category,:oc_id,:prospect_category,:audit_qual_source_id,:audit_subscription_type_id,:qual_date,:audit_name_title_id,:audit_sales_channel_id,:customer_address_seq);";
				parameters.put("customer_id", maxCustomerId + 1);
				parameters.put("customer_address_seq", 1);
				parameters.put("customer_prospect_seq", 1);
				if ((" ".equals(customerAddAttributeModel.getSourceCode()))
						|| ("".equals(customerAddAttributeModel.getSourceCode()))) {
				parameters.put("source_code_id", null);
				}else {
					parameters.put("source_code_id", customerAddAttributeModel.getSourceCode());
				}
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("active_prospect", "1".equals(customerAddAttributeModel.getActive()) ? 1 : 0);
				parameters.put("prospect_category", customerAddAttributeModel.getProspectCategory());
				parameters.put("qual_date", customerAddAttributeModel.getQualDate());
				if (("null".equals(customerAddAttributeModel.getReferredBY()))
						|| ("".equals(customerAddAttributeModel.getReferredBY()))) {
					parameters.put("referred_by_customer_id", null);
				} else {
					parameters.put("referred_by_customer_id", customerAddAttributeModel.getReferredBY());
				}
				if ((" ".equals(customerAddAttributeModel.getOcId()))
						|| ("".equals(customerAddAttributeModel.getOcId()))) {
					parameters.put("oc_id", null);
					parameters.put("audit_qual_category", null);
					parameters.put("audit_qual_source_id", null);
					parameters.put("audit_subscription_type_id", null);
					parameters.put("audit_name_title_id", null);
					parameters.put("audit_sales_channel_id", null);
				} else {
					parameters.put("oc_id", customerAddAttributeModel.getOcId());
					List<String> audited = jdbcTemplate.queryForList(
							" select audited from pub where oc_id=" + customerAddAttributeModel.getOcId(),String.class);
					if (audited.isEmpty()) {
						parameters.put("audit_qual_category", null);
						parameters.put("audit_qual_source_id", null);
						parameters.put("audit_subscription_type_id", null);
						parameters.put("audit_name_title_id", null);
						parameters.put("audit_sales_channel_id", null);
					} else {
						parameters.put("audit_qual_category", customerAddAttributeModel.getAuditQualCategory());
						parameters.put("audit_qual_source_id", customerAddAttributeModel.getAuditSourceId());
						parameters.put("audit_subscription_type_id",
								customerAddAttributeModel.getAuditSubscriptionTypeId());
						parameters.put("audit_name_title_id", customerAddAttributeModel.getAuditNameTitleId());
						parameters.put("audit_sales_channel_id", customerAddAttributeModel.getAuditSalesChannelId());
					}
				}
				namedParameterJdbcTemplate.update(isProspect, parameters);
			}
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId();

			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (" + (editTrailId + 1) + "," + (maxCustomerId + 1) + "," + user_code + ",0,0,"
					+ customerAddAttributeModel.getDocumentReferenceId() + "," + dateStamp + "," + creation_date
					+ ",'customer_add_request');";

			jdbcTemplate.update(editTrailCodeQuery);

			String editTrailAddressQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name,customer_address_seq) "
					+ "values (" + (editTrailId + 2) + "," + (maxCustomerId + 1) + "," + user_code + ",0,1,"
					+ customerAddAttributeModel.getDocumentReferenceId() + "," + dateStamp + "," + creation_date
					+ ",'customer_add_request',1);";

			jdbcTemplate.update(editTrailAddressQuery);

			customerUtility.updateMruEditTrailId(editTrailId + 2);
			String maxEventQueueId = jdbcTemplate.queryForObject("select id from mru_event_queue_id;",String.class);
			int event_queue_id = 0;
			if (maxEventQueueId == null) {
				event_queue_id = 1;
			} else {
				event_queue_id = Integer.parseInt(maxEventQueueId) + 1;
			}
			//CODE IS FOR EMAIL AUTHORIZATION BUTTON ON ADD CUSTOMER PAGE.
			 if (null != business_processes && !"".equals(business_processes)&& !"0".equalsIgnoreCase(business_processes) && !"null".equals(business_processes)) 
			{
				String status = updateEmailAuthorizationIntoDataSource(maxCustomerId + 1, business_processes);
				if (status.contains("success")) {
					LOGGER.info("Email Authorization also saved successfully.");
				}
			} else {
				String eventQueue = "insert into event_queue (event_queue_id,customer_id,customer_address_seq,transaction_event,status,creation_date) values"
						+ " (" + event_queue_id + "," + (maxCustomerId + 1) + ",1,29,0," + creation_date + ");";
				jdbcTemplate.update(eventQueue);
				customerUtility.updateEventQueueId(Long.valueOf(event_queue_id));
			}
			// Added by Sohrab for adding a new distributor
			if ("true".equalsIgnoreCase(customerAddAttributeModel.getIsDistributor())) {
				String distributor = customerUtility.getStringValue(customerAddAttributeModel.getDistributor()) != null
						? "'" + customerUtility.getStringValue(customerAddAttributeModel.getDistributor()) + "'"
						: null;
				String distributorURL = customerUtility
						.getStringValue(customerAddAttributeModel.getDistributorURL()) != null
								? "'" + customerUtility.getStringValue(customerAddAttributeModel.getDistributorURL())
										+ "'"
								: null;
				String reportPrefix = customerUtility
						.getStringValue(customerAddAttributeModel.getReportPrefix()) != null
								? "'" + customerUtility.getStringValue(customerAddAttributeModel.getReportPrefix())
										+ "'"
								: null;
				Long parent = customerAddAttributeModel.getParent();
				String distributorQuery = "";
				if (parent == 0) {
					distributorQuery = "INSERT INTO distributor(customer_id,url,distributor_report_prefix,parent_distributor_id,company) VALUES "
							+ "(" + (maxCustomerId + 1) + "," + distributorURL + "," + reportPrefix + "," + null + ","
							+ distributor + ");";

				} else {
					distributorQuery = "INSERT INTO distributor(customer_id,url,distributor_report_prefix,parent_distributor_id,company) VALUES "
							+ "(" + (maxCustomerId + 1) + "," + distributorURL + "," + reportPrefix + "," + parent + ","
							+ distributor + ");";
				}
				jdbcTemplate.update(distributorQuery);
			}
			return "" + (maxCustomerId + 1);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public void getCustomerDetail(CustomerAddAttributeModel customerAddAttributeModel, Long customerId)
			throws SQLException {
		LOGGER.info("Inside getCustomerDetail");
		try {
			Customer customer = jdbcTemplate.queryForObject("select * from customer where customer_id=" + customerId,
					new CustomerMapper());
			customerAddAttributeModel.setSalutation(customer.getSalutation());
			customerAddAttributeModel.setfName(customer.getFname());
			customerAddAttributeModel.setInitial(customer.getInitialName());
			customerAddAttributeModel.setlName(customer.getLname());
			customerAddAttributeModel.setSuffix(customer.getSuffix());
			customerAddAttributeModel.setCompany(customer.getCompany());
			customerAddAttributeModel.setCustomerId(customer.getCustomerId());
			customerAddAttributeModel.setOldCustomerId(customer.getOldCustomerId());
			customerAddAttributeModel.setCreationDate(customer.getCreationDate());
			customerAddAttributeModel.setEmail(customer.getEmail());
			customerAddAttributeModel.setOldEmail(customer.getOldEmail());
			customerAddAttributeModel.setTitle(customer.getTitle());
			customerAddAttributeModel.setCustomerCategory(customer.getCustomerCategory());
			customerAddAttributeModel.setSales(customer.getSalesRepresentativeId());
			customerAddAttributeModel.setListRental(customer.getListRentalCategory());
			customerAddAttributeModel.setCreditStatus(customer.getCreditStatus());
			customerAddAttributeModel.setInstitutionalIdentifier(customer.getInstitutionalIdentifier());
			customerAddAttributeModel.setParentInstitutionalIdentifier(customer.getParentInstIdentifier());
			customerAddAttributeModel.setProspectOnly(customer.getProspectOnly());
			customerAddAttributeModel.setListRentalList(getlistRental());
			customerAddAttributeModel.setCustomerCategoryList(getcustomerCategory());
			customerAddAttributeModel.setSalesRepresentativeList(getsalesRepresentative());
			customerAddAttributeModel.setCreditStatusList(getcreditStatus());
			customerAddAttributeModel.setDefaultAddressList(getDefaultAddressList(customerId));
			

			CustomerAddressModel customerAddressModel3 = jdbcTemplate.queryForObject("select customer_address.* "
					+ "from customer_address, customer where customer.customer_id = customer_address.customer_id "
					+ "and customer_address.customer_address_seq =1 and customer.customer_id = " + customerId,
					new CustomerAddressMapper());
			customerAddAttributeModel.setAddress1(customerAddressModel3.getAddress1());
			customerAddAttributeModel.setCity(customerAddressModel3.getCity());
			customerAddAttributeModel.setState(customerAddressModel3.getState());
			customerAddAttributeModel.setZip(customerAddressModel3.getZip());

			CustomerAddressModel customerAddressModel1 = jdbcTemplate.queryForObject("select customer_address.* "
					+ "from customer_address, customer where customer_address.customer_id = customer.default_bill_to_customer_id "
					+ "and customer_address.customer_address_seq =  customer.def_bill_to_cust_addr_seq   and customer.customer_id ="
					+ customerId, new CustomerAddressMapper());
			customerAddAttributeModel.setBillTo(
					customerAddressModel1.getCustomerId() + "-" + customerAddressModel1.getCustomerAddressSeq() + "-"
							+ customerUtility.getString(customerAddressModel1.getFname()) + " "
							+ customerUtility.getString(customerAddressModel1.getLname()) + "("
							+ customerUtility.getString(customerAddressModel1.getAddress1()) + ","
							+ customerUtility.getString(customerAddressModel1.getPhone()) + ")");

			CustomerAddressModel customerAddressModel2 = jdbcTemplate.queryForObject("select customer_address.* "
					+ "from customer_address, customer where customer_address.customer_id = customer.default_renew_to_customer_id "
					+ "and customer_address.customer_address_seq =  customer.def_renew_to_cust_addr_seq   and customer.customer_id ="
					+ customerId, new CustomerAddressMapper());
			customerAddAttributeModel.setRenewTo(
					customerAddressModel2.getCustomerId() + "-" + customerAddressModel2.getCustomerAddressSeq() + "-"
							+ customerUtility.getString(customerAddressModel2.getFname()) + " "
							+ customerUtility.getString(customerAddressModel2.getLname()) + "("
							+ customerUtility.getString(customerAddressModel2.getAddress1()) + ","
							+ customerUtility.getString(customerAddressModel2.getPhone()) + ")");

			int count = jdbcTemplate.queryForObject(
					"select count(*) from customer_address, customer where customer.customer_id = customer_address.customer_id "
							+ "and customer.default_cust_addr_seq = customer_address.customer_address_seq and customer.customer_id = "
							+ customerId,
					Integer.class);
			if (count > 0) {
				CustomerAddressModel customerAddressModel = jdbcTemplate.queryForObject("select customer_address.* "
						+ "from customer_address, customer where customer.customer_id = customer_address.customer_id "
						+ "and customer.default_cust_addr_seq = customer_address.customer_address_seq and customer.customer_id = "
						+ customerId, new CustomerAddressMapper());
				customerAddAttributeModel.setDefaultAddress(
						customerAddressModel.getCustomerId() + "-" + customerAddressModel.getCustomerAddressSeq() + "-"
								+ customerUtility.getString(customerAddressModel.getFname()) + " "
								+ customerUtility.getString(customerAddressModel.getLname()) + "("
								+ customerUtility.getString(customerAddressModel.getAddress1()) + ","
								+ customerUtility.getString(customerAddressModel.getPhone()) + ")");
			} else {
				CustomerAddressModel customerAddressModel = jdbcTemplate.queryForObject("select customer_address.* "
						+ "from customer_address, customer where customer.customer_id = customer_address.customer_id "
						+ "and customer_address.customer_address_seq = 1 and customer.customer_id = " + customerId,
						new CustomerAddressMapper());
				customerAddAttributeModel.setDefaultAddress(customerAddressModel.getCustomerId() + "-"
						+ customerAddressModel.getCustomerAddressSeq() + "-"
						+ (customerAddressModel.getFname() == null ? "" : customerAddressModel.getFname()) + " "
						+ (customerAddressModel.getLname() == null ? "" : customerAddressModel.getLname()) + "("
						+ (customerAddressModel.getAddress1() == null ? "" : customerAddressModel.getAddress1()) + ","
						+ (customerAddressModel.getPhone() == null ? "" : customerAddressModel.getPhone()) + ")");
			}
			customerAddAttributeModel.setCustomerGroup(jdbcTemplate.queryForObject(
					" select concat(customer_group , '{' , '#'  , (select customer_group_customer_id from group_member where customer_id="
							+ customerId
							+ ") , ':' ,  ' } ' ,  description) as customer_group from customer_group where customer_id=(select customer_group_customer_id from group_member where customer_id="
							+ customerId + ")",
					String.class));
			customerAddAttributeModel.setAudited(jdbcTemplate.queryForObject(
					"select audited from pub where oc_id =(select oc_id from customer where customer_id=" + customerId
							+ ")",
					Integer.class));

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}

	@Override
	public List<CustomerAddressModel> getaddressDetail(Long customerId, String type) throws SQLException {
		LOGGER.info("Inside getaddressDetail");
		List<CustomerAddressModel> result = null;

		try {
			StringBuilder query = new StringBuilder("");
			Map<String, Object> parameters = new HashMap<String, Object>();
			if ("default".equals(type)) {
				query.append("SELECT * FROM customer_address "
						+ "WHERE customer_id= :customer_id and replace_customer_address_seq is NULL ORDER BY customer_address_seq asc");
				parameters.put("customer_id", customerId);
			}
			if ("future".equals(type)) {
				query.append("SELECT * FROM customer_address "
						+ "WHERE customer_id= :customer_id and replace_customer_address_seq = :replace_customer_address_seq ORDER BY effective_date");
				parameters.put("customer_id", customerId);
				parameters.put("replace_customer_address_seq", 1);
			}

			result = namedParameterJdbcTemplate.query(query.toString(), parameters, new CustomerAddressMapper());

			for (CustomerAddressModel row : result) {
				if (row.getPhone() != null && !"".equals(row.getPhone())) {
					String stateCode = row.getState();
					List<String> abc = jdbcTemplate
							.queryForList("select phonefmt from state where state='" + stateCode + "'", String.class);
					if (abc.get(0) != null) {
						String[] phn = abc.get(0).split(" ");
						String cCode = phn[0];
//		                    String phone2 =  phn[0] + " "+row.getEighthundred();
//		                    String faxnbr =  phn[0] + " "+row.getFaxnbr();
						row.setCountryCode(cCode);

					}

				}
				if (row.getState() != null && !"".equals(row.getState())) {

					List<Map<String, Object>> rows = jdbcTemplate.queryForList(
							"select distinct state,c.country_code2,country_code3,country_name,phonefmt from country c inner join state s on c.country_code2=s.country_code2 where s.state = '"
									+ row.getState() + "'");
					row.setCountry((String) rows.get(0).get("country_code2") + "( "
							+ rows.get(0).get("country_name").toString().toUpperCase() + ")");

				}

			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String editCustomer(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		LOGGER.info("Inside editCustomer");
		try {

			Customer customerPreviousData = jdbcTemplate.queryForObject(
					"select * from customer where customer_id=" + customerAddAttributeModel.getCustomerId(),
					new CustomerMapper());

			String defaultAddress[] = customerAddAttributeModel.getDefaultAddress().split("-");
			String billTo[] = customerAddAttributeModel.getBillTo().split("-");
			String renewTo[] = customerAddAttributeModel.getRenewTo().split("-");
			String customerQuery = "UPDATE CUSTOMER set "
					+ "customer_category = :customer_category,old_customer_id=:old_customer_id,lname = :lname,initial_name = :initial_name,fname = :fname,salutation = :salutation,suffix = :suffix,title = :title,"
					+ "email = :email,old_email = :old_email,credit_status = :credit_status,list_rental_category = :list_rental_category,sales_representative_id = :sales_representative_id,institutional_identifier = :institutional_identifier,"
					+ "company = :company,parent_inst_identifier = :parent_inst_identifier,default_cust_addr_seq = :default_cust_addr_seq,default_bill_to_customer_id = :default_bill_to_customer_id,"
					+ "def_bill_to_cust_addr_seq = :def_bill_to_cust_addr_seq,default_renew_to_customer_id = :default_renew_to_customer_id,def_renew_to_cust_addr_seq = :def_renew_to_cust_addr_seq "
					+ "where customer_id=" + customerAddAttributeModel.getCustomerId();

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("customer_category",
					customerUtility.getStringValue(customerAddAttributeModel.getCustomerCategory()));
			parameters.put("old_customer_id",
					customerUtility.getStringValue(customerAddAttributeModel.getOldCustomerId()));
			parameters.put("lname", customerUtility.getStringValue(customerAddAttributeModel.getlName()));
			parameters.put("initial_name", customerUtility.getStringValue(customerAddAttributeModel.getInitial()));
			parameters.put("fname", customerUtility.getStringValue(customerAddAttributeModel.getfName()));
			parameters.put("salutation", customerUtility.getStringValue(customerAddAttributeModel.getSalutation()));
			parameters.put("suffix", customerUtility.getStringValue(customerAddAttributeModel.getSuffix()));
			parameters.put("title", customerUtility.getStringValue(customerAddAttributeModel.getTitle()));
			parameters.put("email", customerUtility.getStringValue(customerAddAttributeModel.getEmail()));
			parameters.put("old_email", customerUtility.getStringValue(customerAddAttributeModel.getOldEmail()));
			parameters.put("credit_status",
					customerUtility.getStringValue(customerAddAttributeModel.getCreditStatus()));
			parameters.put("list_rental_category",
					customerUtility.getStringValue(customerAddAttributeModel.getListRental()));
			parameters.put("sales_representative_id",
					customerUtility.getStringValue(customerAddAttributeModel.getSales()));
			parameters.put("institutional_identifier",
					customerUtility.getStringValue(customerAddAttributeModel.getInstitutionalIdentifier()));
			parameters.put("company", customerUtility.getStringValue(customerAddAttributeModel.getCompany()));
			parameters.put("parent_inst_identifier",
					customerUtility.getStringValue(customerAddAttributeModel.getParentInstitutionalIdentifier()));
			parameters.put("default_cust_addr_seq", defaultAddress[1]);
			parameters.put("default_bill_to_customer_id", billTo[0]);
			parameters.put("def_bill_to_cust_addr_seq", billTo[1]);
			parameters.put("default_renew_to_customer_id", renewTo[0]);
			parameters.put("def_renew_to_cust_addr_seq", renewTo[1]);
			namedParameterJdbcTemplate.update(customerQuery, parameters);

			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}

			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;

			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("user_code", customerUtility.getStringValue(customerAddAttributeModel.getUserCode()));
			parameters.put("edited", 1);
			parameters.put("table_enum", 0);
			parameters.put("document_reference_id", customerAddAttributeModel.getDocumentReferenceId());
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			parameters.put("xaction_name", "customer_edit_request");
			namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
			customerUtility.updateMruEditTrailId(editTrailId);
			boolean updateFlag = false;

			if (!customerUtility.getString(customerPreviousData.getCustomerCategory())
					.equals(customerAddAttributeModel.getCustomerCategory())) {
				customerUtility.insertEditTrailDelta(editTrailId, "customer_category",
						customerPreviousData.getCustomerCategory(), customerAddAttributeModel.getCustomerCategory());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getOldCustomerId())
					.equals(customerAddAttributeModel.getOldCustomerId())) {
				customerUtility.insertEditTrailDelta(editTrailId, "old_customer_id",
						customerPreviousData.getOldCustomerId(), customerAddAttributeModel.getOldCustomerId());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getLname())
					.equals(customerAddAttributeModel.getlName())) {
				customerUtility.insertEditTrailDelta(editTrailId, "lname", customerPreviousData.getLname(),
						customerAddAttributeModel.getlName());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getInitialName())
					.equals(customerAddAttributeModel.getInitial())) {
				customerUtility.insertEditTrailDelta(editTrailId, "initial_name", customerPreviousData.getInitialName(),
						customerAddAttributeModel.getInitial());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getFname())
					.equals(customerAddAttributeModel.getfName())) {
				customerUtility.insertEditTrailDelta(editTrailId, "fname", customerPreviousData.getFname(),
						customerAddAttributeModel.getfName());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getSalutation())
					.equals(customerAddAttributeModel.getSalutation())) {
				customerUtility.insertEditTrailDelta(editTrailId, "salutation", customerPreviousData.getSalutation(),
						customerAddAttributeModel.getSalutation());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getSuffix())
					.equals(customerAddAttributeModel.getSuffix())) {
				customerUtility.insertEditTrailDelta(editTrailId, "suffix", customerPreviousData.getSuffix(),
						customerAddAttributeModel.getSuffix());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getTitle())
					.equals(customerAddAttributeModel.getTitle())) {
				customerUtility.insertEditTrailDelta(editTrailId, "title", customerPreviousData.getTitle(),
						customerAddAttributeModel.getTitle());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getEmail())
					.equals(customerAddAttributeModel.getEmail())) {
				customerUtility.insertEditTrailDelta(editTrailId, "email", customerPreviousData.getEmail(),
						customerAddAttributeModel.getEmail());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getCreditStatus())
					.equals(customerAddAttributeModel.getCreditStatus())) {
				customerUtility.insertEditTrailDelta(editTrailId, "credit_status",
						customerPreviousData.getCreditStatus(), customerAddAttributeModel.getCreditStatus());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getListRentalCategory())
					.equals(customerAddAttributeModel.getListRental())) {
				customerUtility.insertEditTrailDelta(editTrailId, "list_rental_category",
						customerPreviousData.getListRentalCategory(), customerAddAttributeModel.getListRental());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getSalesRepresentativeId())
					.equals(customerAddAttributeModel.getSales())) {
				customerUtility.insertEditTrailDelta(editTrailId, "sale_representative_id",
						customerPreviousData.getSalesRepresentativeId(), customerAddAttributeModel.getSales());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getInstitutionalIdentifier())
					.equals(customerAddAttributeModel.getInstitutionalIdentifier())) {
				customerUtility.insertEditTrailDelta(editTrailId, "institutional_identifier",
						customerPreviousData.getInstitutionalIdentifier(),
						customerAddAttributeModel.getInstitutionalIdentifier());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getCompany())
					.equals(customerAddAttributeModel.getCompany())) {
				customerUtility.insertEditTrailDelta(editTrailId, "company", customerPreviousData.getCompany(),
						customerAddAttributeModel.getCompany());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerPreviousData.getParentInstIdentifier())
					.equals(customerAddAttributeModel.getParentInstitutionalIdentifier())) {
				customerUtility.insertEditTrailDelta(editTrailId, "parent_inst_identifier",
						customerPreviousData.getParentInstIdentifier(),
						customerAddAttributeModel.getParentInstitutionalIdentifier());
				updateFlag = true;
			}
			if (customerPreviousData.getDefaultCustAddrSeq() != (Long.parseLong(defaultAddress[1]))) {
				customerUtility.insertEditTrailDelta(editTrailId, "default_cust_addr_seq",
						customerPreviousData.getDefaultCustAddrSeq(), defaultAddress[1]);
				updateFlag = true;
			}
			if (customerPreviousData.getDefaultBillToCustomerId() != (Long.parseLong(billTo[0]))) {
				customerUtility.insertEditTrailDelta(editTrailId, "default_bill_to_customer_id",
						customerPreviousData.getDefaultBillToCustomerId(), billTo[0]);
				updateFlag = true;
			}
			if (customerPreviousData.getDefBillToCustAddrSeq() != (Long.parseLong(billTo[1]))) {
				customerUtility.insertEditTrailDelta(editTrailId, "def_bill_to_cust_addr_seq",
						customerPreviousData.getDefBillToCustAddrSeq(), billTo[1]);
				updateFlag = true;
			}
			if (customerPreviousData.getDefaultRenewToCustomerId() != (Long.parseLong(renewTo[0]))) {
				customerUtility.insertEditTrailDelta(editTrailId, "default_renew_to_customer_id",
						customerPreviousData.getDefaultRenewToCustomerId(), renewTo[0]);
				updateFlag = true;
			}
			if (customerPreviousData.getDefRenewToCustAddrSeq() != Long.parseLong(renewTo[1])) {
				customerUtility.insertEditTrailDelta(editTrailId, "def_renew_to_cust_addr_seq",
						customerPreviousData.getDefRenewToCustAddrSeq(), renewTo[1]);
				updateFlag = true;
			}

			if (updateFlag == false) {
				parameters.clear();
				String deleteEditTrailQuery = "delete from edit_trail where edit_trail_id = :edit_trail_id";
				parameters.put("edit_trail_id", editTrailId);
				namedParameterJdbcTemplate.update(deleteEditTrailQuery, parameters);
			} else {
				customerUtility.updateMruEditTrailId(editTrailId);
			}
			return "Updated";

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public List<Object> getSearchCustomerBillTo(String billto) throws SQLException {
		LOGGER.info("Inside getSearchCustomerBillTo");
		List<Object> SearchCustomerBillTo = new ArrayList<Object>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select customer_address.customer_id,customer_address_seq,customer_address.fname,customer_address.lname, customer_address.address1,customer_address.phone "
							+ " from customer_address, customer where "
							+ "(customer.customer_id = customer_address.customer_id) and((customer.inactive = 0 OR customer.inactive is NULL)) "
							+ "and (customer.customer_id like '%" + billto + "%' OR customer.fname LIKE '%" + billto
							+ "%')");
			for (Map<String, Object> row : rows) {
				SearchCustomerBillTo.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return SearchCustomerBillTo;

	}

	@Override
	public List<DropdownModel> getDefaultAddressList(Long customerId) throws SQLException {
		LOGGER.info("Inside getDefaultAddressList");
		List<DropdownModel> defaultAddressList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select customer_address.customer_id,customer_address_seq,customer_address.fname,customer_address.lname, customer_address.address1,customer_address.phone "
							+ "from customer_address where customer_address.customer_id =" + customerId);
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("customer_id") + "-" + row.get("customer_address_seq") + "-"
						+ (row.get("fname") == null ? "" : row.get("fname")) + " "
						+ (row.get("lname") == null ? "" : row.get("lname")) + "("
						+ (row.get("address1") == null ? "" : row.get("address1")) + ","
						+ (row.get("phone") == null ? "" : row.get("phone")) + ")");
				model.setDisplay(row.get("customer_id") + "-" + row.get("customer_address_seq") + "-"
						+ (row.get("fname") == null ? "" : row.get("fname")) + " "
						+ (row.get("lname") == null ? "" : row.get("lname")) + "("
						+ (row.get("address1") == null ? "" : row.get("address1")) + ","
						+ (row.get("phone") == null ? "" : row.get("phone")) + ")");
				defaultAddressList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultAddressList;

	}

	@Override
	public List<Object> getAddressHistory(Long customerId, int addrSeq) throws SQLException {
		LOGGER.info("Inside getAddressHistory");
		List<Object> addressHistory = new ArrayList<Object>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from view_edit_hist where customer_id="
					+ customerId + " and customer_address_seq=" + addrSeq + " and table_enum=1 order by creation_date");
			for (Map<String, Object> row : rows) {
				if (row.get("column_name") != null && row.get("column_name").equals("order_status")) {
					row.put("before_change", new PropertyUtilityClass()
							.getConstantValue("order_item.order_status_" + row.get("before_change")));
					row.put("after_change", new PropertyUtilityClass()
							.getConstantValue("order_item.order_status_" + row.get("after_change")));
				} else if (row.get("column_name") != null && row.get("column_name").equals("renewal_status")) {
					row.put("before_change", new PropertyUtilityClass()
							.getConstantValue("order_item.renewal_status_" + row.get("before_change")));
					row.put("after_change", new PropertyUtilityClass()
							.getConstantValue("order_item.renewal_status_" + row.get("after_change")));
				} else if (row.get("column_name") != null && row.get("column_name").equals("payment_status")) {
					row.put("before_change", new PropertyUtilityClass()
							.getConstantValue("order_item.pay_status_" + row.get("before_change")));
					row.put("after_change", new PropertyUtilityClass()
							.getConstantValue("order_item.pay_status_" + row.get("after_change")));
				} else if (row.get("column_name") != null && row.get("column_name").equals("order_date")) {
					row.put("before_change",
							row.get("before_change") != null
									? new PropertyUtilityClass().getDateFormatter((String) row.get("before_change"))
									: "");
					row.put("after_change",
							row.get("after_change") != null
									? new PropertyUtilityClass().getDateFormatter((String) row.get("after_change"))
									: "");
				} else {
					row.put("before_change", row.get("before_change"));
					row.put("after_change", row.get("after_change"));
				}
				addressHistory.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return addressHistory;

	}

	@Override
	public String updateAddress(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		LOGGER.info("Inside updateAddress");
		try {
			CustomerAddressModel customerAddressPreviousData = jdbcTemplate.queryForObject(
					"select * from customer_address where customer_id =" + customerAddAttributeModel.getCustomerId()
							+ " and customer_address_seq=" + customerAddAttributeModel.getCustomerAddressSeq(),
					new CustomerAddressMapper());

			Map<String, Object> parameters = new HashMap<String, Object>();

			String customerAddressQuery;
			String customerQuery = null;
			if (customerAddAttributeModel.getFutureOrTemp() != null) {
				customerAddressQuery = "update customer_address set "
						+ "state=:state,city=:city,county=:county,zip=:zip,tax_id_number=:tax_id_number,email=:email,old_email=:old_email,phone=:phone,faxnbr=:faxnbr,eighthundred=:eighthundred,"
						+ "fname=:fname,initial_name=:initial_name,lname=:lname,salutation=:salutation,suffix=:suffix,title=:title,address_status=:address_status,company=:company,"
						+ "department=:department,audit_name_change=:audit_name_change,audit_title_change=:audit_title_change,supp_clean=:supp_clean,address1=:address1,"
						+ "address2=:address2,address3=:address3,special_tax_id=:special_tax_id,institutional_identifier=:institutional_identifier,address_type=:address_type,ignored_clean=:ignored_clean, "
						+ "effective_date=:effective_date,reverse_date=:reverse_date,replace_customer_address_seq=:replace_customer_address_seq,change_type=:change_type "
						+ "where customer_id=:customer_id and customer_address_seq=:customer_address_seq";
				parameters.put("effective_date",
						customerUtility.getStringValue(customerAddAttributeModel.getFrom()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getFrom())));
				parameters.put("reverse_date",
						customerUtility.getStringValue(customerAddAttributeModel.getTo()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getTo())));
				parameters.put("replace_customer_address_seq", customerAddAttributeModel.getChangeAddress());
				parameters.put("change_type", customerAddAttributeModel.getFutureOrTemp());

			} else {
				customerAddressQuery = "update customer_address set "
						+ "state=:state,city=:city,county=:county,zip=:zip,tax_id_number=:tax_id_number,email=:email,old_email=:old_email,phone=:phone,faxnbr=:faxnbr,eighthundred=:eighthundred,"
						+ "fname=:fname,initial_name=:initial_name,lname=:lname,salutation=:salutation,suffix=:suffix,title=:title,address_status=:address_status,company=:company,"
						+ "department=:department,audit_name_change=:audit_name_change,audit_title_change=:audit_title_change,supp_clean=:supp_clean,address1=:address1,"
						+ "address2=:address2,address3=:address3,special_tax_id=:special_tax_id,institutional_identifier=:institutional_identifier,address_type=:address_type,ignored_clean=:ignored_clean "
						+ "where customer_id=:customer_id and customer_address_seq=:customer_address_seq";

				if (customerAddAttributeModel.getCustomerAddressSeq() == 1)
					customerQuery = "update customer set "
							+ "email=:email,old_email=:old_email,fname=:fname,initial_name=:initial_name,lname=:lname,salutation=:salutation,suffix=:suffix,title=:title,company=:company "
							+ "where customer_id=:customer_id";
			}

			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("customer_address_seq", customerAddAttributeModel.getCustomerAddressSeq());
			parameters.put(STATE, customerUtility.getStringValue(customerAddAttributeModel.getState()));
			parameters.put("city", customerUtility.getStringValue(customerAddAttributeModel.getCity()));
			parameters.put("county", customerUtility.getStringValue(customerAddAttributeModel.getCounty()));
			parameters.put("zip", customerUtility.getStringValue(customerAddAttributeModel.getZip()));
			parameters.put("tax_id_number", customerUtility.getStringValue(customerAddAttributeModel.getTaxID()));
			parameters.put("email", customerUtility.getStringValue(customerAddAttributeModel.getEmail()));
			parameters.put("old_email", customerUtility.getStringValue(customerAddAttributeModel.getOldEmail()));
			parameters.put("phone", customerUtility.getStringValue(customerAddAttributeModel.getPhone1()));
			parameters.put("faxnbr", customerUtility.getStringValue(customerAddAttributeModel.getFax()));
			parameters.put("eighthundred", customerUtility.getStringValue(customerAddAttributeModel.getPhone2()));
			parameters.put("fname", customerUtility.getStringValue(customerAddAttributeModel.getfName()));
			parameters.put("initial_name", customerUtility.getStringValue(customerAddAttributeModel.getInitial()));
			parameters.put("lname", customerUtility.getStringValue(customerAddAttributeModel.getlName()));
			parameters.put("salutation", customerUtility.getStringValue(customerAddAttributeModel.getSalutation()));
			parameters.put("suffix", customerUtility.getStringValue(customerAddAttributeModel.getSuffix()));
			parameters.put("title", customerUtility.getStringValue(customerAddAttributeModel.getTitle()));
			parameters.put("address_status",
					customerUtility.getStringValue(customerAddAttributeModel.getAddressStatus()));
			parameters.put("company", customerUtility.getStringValue(customerAddAttributeModel.getCompany()));
			parameters.put("department", customerUtility.getStringValue(customerAddAttributeModel.getDepartment()));
			parameters.put("audit_name_change", 0);
			parameters.put("audit_title_change", 0);
			parameters.put("supp_clean", 0);
			parameters.put("address1", customerUtility.getStringValue(customerAddAttributeModel.getAddress1()));
			parameters.put("address2", customerUtility.getStringValue(customerAddAttributeModel.getAddress2()));
			parameters.put("address3", customerUtility.getStringValue(customerAddAttributeModel.getAddress3()));
			if (null == customerUtility.getStringValue(customerAddAttributeModel.getSpecialTaxId()))
				customerAddAttributeModel.setSpecialTaxId("0");
			else
				customerAddAttributeModel.setSpecialTaxId("1");
			parameters.put("special_tax_id",
					customerUtility.getStringValue(customerAddAttributeModel.getSpecialTaxId()));
			parameters.put("institutional_identifier",
					customerUtility.getStringValue(customerAddAttributeModel.getInstitutionalIdentifier()));
			parameters.put("address_type", customerUtility.getStringValue(customerAddAttributeModel.getAddressType()));
			parameters.put("ignored_clean", 0);

			namedParameterJdbcTemplate.update(customerAddressQuery, parameters);

			if (customerAddAttributeModel.getCustomerAddressSeq() == 1)
				namedParameterJdbcTemplate.update(customerQuery, parameters);
			// **************************
			// update order_item and suspension table
			// fetching order_item details according to customer_id
			// SELECT address_status,* FROM customer_address WHERE customer_id=396 ORDER BY
			// customer_id,customer_address_seq
			String addressStatus = customerUtility.getStringValue(customerAddAttributeModel.getAddressStatus());
			Integer orderStatus = null;
			switch (addressStatus) {
			case "OPEN":
				orderStatus = 0;
				break;
			case "DUPE":
				orderStatus = 11;
				break;
			case "CLEARED":
				orderStatus = 11;
				break;
			case "UNDEL":
				orderStatus = 11;
				break;
			}
			List<Map<String, Object>> orderItemDetails = jdbcTemplate.queryForList(
					"select order_status,mru_suspension_seq,orderhdr_id,order_item_seq,* from order_item where customer_id ="
							+ customerAddAttributeModel.getCustomerId());
			for (Map<String, Object> item : orderItemDetails) {
				// Integer orderStatus = (Integer) item.get("order_status");
				ArrayList<Object> al = new ArrayList<>();
				// Integer mruSuspensionSeq = (Integer) item.get("mru_suspension_seq");
				Integer orderhdrId = (Integer) item.get("orderhdr_id");
				al.add(orderhdrId);
				Integer orderItemSeq = (Integer) item.get("order_item_seq");
				al.add(orderItemSeq);
				// select max(suspension_seq) from suspension where orderhdr_id=4182383 and
				// order_item_seq=1
				Integer mruSuspensionSeq = jdbcTemplate
						.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + orderhdrId
								+ " and order_item_seq=" + orderItemSeq, Integer.class);
				al.add(mruSuspensionSeq);
				StringBuilder query = new StringBuilder("update order_item set order_status=").append(orderStatus)
						.append(",mru_suspension_seq=").append(mruSuspensionSeq).append(" where orderhdr_id=")
						.append(orderhdrId).append(" and order_item_seq=").append(orderItemSeq);

				jdbcTemplate.update(query.toString());
			}
			// *********************
			StringBuilder matchcode = customerUtility.getmatchCode(customerAddAttributeModel);

			List<Map<String, Object>> customerMatchCodeId = jdbcTemplate
					.queryForList("select customer_match_code_id from customer_address_match_code where "
							+ "customer_id =" + customerAddAttributeModel.getCustomerId()
							+ " and customer_address_seq =" + customerAddAttributeModel.getCustomerAddressSeq() + "");

			parameters.clear();

			if (customerMatchCodeId.size() > 0) {

				String customerMatchCodeQuery = "update customer_address_match_code set "
						+ " match_code=:match_code where "
						+ "customer_id=:customer_id and customer_address_seq=:customer_address_seq and customer_match_code_id=:customer_match_code_id";
				parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
				parameters.put("customer_address_seq", customerAddAttributeModel.getCustomerAddressSeq());
				parameters.put("match_code", matchcode);
				parameters.put("customer_match_code_id", 2);

				namedParameterJdbcTemplate.update(customerMatchCodeQuery, parameters);
			}

			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {

				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}

			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;

			parameters.clear();
			String editTrailAddressQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name,customer_address_seq) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name,:customer_address_seq)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("user_code", customerAddAttributeModel.getUserCode());
			parameters.put("edited", 1);
			parameters.put("table_enum", 1);
			parameters.put("document_reference_id", customerAddAttributeModel.getDocumentReferenceId());
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			parameters.put("xaction_name", "customer_address_edit_request");
			parameters.put("customer_address_seq", customerAddAttributeModel.getCustomerAddressSeq());
			namedParameterJdbcTemplate.update(editTrailAddressQuery, parameters);
			customerUtility.updateMruEditTrailId(editTrailId);
			parameters.clear();
			boolean updateFlag = false;

			if (!customerUtility.getString(customerAddressPreviousData.getState())
					.equals(customerAddAttributeModel.getState())) {
				customerUtility.insertEditTrailDelta(editTrailId, STATE, customerAddressPreviousData.getState(),
						customerAddAttributeModel.getState());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getCity())
					.equals(customerAddAttributeModel.getCity())) {
				customerUtility.insertEditTrailDelta(editTrailId, "city", customerAddressPreviousData.getCity(),
						customerAddAttributeModel.getCity());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getCounty())
					.equals(customerAddAttributeModel.getCounty())) {
				customerUtility.insertEditTrailDelta(editTrailId, "county", customerAddressPreviousData.getCounty(),
						customerAddAttributeModel.getCounty());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getZip())
					.equals(customerAddAttributeModel.getZip())) {
				customerUtility.insertEditTrailDelta(editTrailId, "zip", customerAddressPreviousData.getZip(),
						customerAddAttributeModel.getZip());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getTaxIdNumber())
					.equals(customerAddAttributeModel.getTaxID())) {
				customerUtility.insertEditTrailDelta(editTrailId, "tax_id_number",
						customerAddressPreviousData.getTaxIdNumber(), customerAddAttributeModel.getTaxID());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getEmail())
					.equals(customerAddAttributeModel.getEmail())) {
				customerUtility.insertEditTrailDelta(editTrailId, "email", customerAddressPreviousData.getEmail(),
						customerAddAttributeModel.getEmail());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getPhone())
					.equals(customerAddAttributeModel.getPhone1())) {
				customerUtility.insertEditTrailDelta(editTrailId, "phone", customerAddressPreviousData.getPhone(),
						customerAddAttributeModel.getPhone1());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getFaxnbr())
					.equals(customerAddAttributeModel.getFax())) {
				customerUtility.insertEditTrailDelta(editTrailId, "faxnbr", customerAddressPreviousData.getFaxnbr(),
						customerAddAttributeModel.getFax());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getEighthundred())
					.equals(customerAddAttributeModel.getPhone2())) {
				customerUtility.insertEditTrailDelta(editTrailId, "eighthundred",
						customerAddressPreviousData.getEighthundred(), customerAddAttributeModel.getPhone2());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getLname())
					.equals(customerAddAttributeModel.getlName())) {
				customerUtility.insertEditTrailDelta(editTrailId, "lname", customerAddressPreviousData.getLname(),
						customerAddAttributeModel.getlName());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getInitialName())
					.equals(customerAddAttributeModel.getInitial())) {
				customerUtility.insertEditTrailDelta(editTrailId, "initial_name",
						customerAddressPreviousData.getInitialName(), customerAddAttributeModel.getInitial());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getFname())
					.equals(customerAddAttributeModel.getfName())) {
				customerUtility.insertEditTrailDelta(editTrailId, "fname", customerAddressPreviousData.getFname(),
						customerAddAttributeModel.getfName());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getSalutation())
					.equals(customerAddAttributeModel.getSalutation())) {
				customerUtility.insertEditTrailDelta(editTrailId, "salutation",
						customerAddressPreviousData.getSalutation(), customerAddAttributeModel.getSalutation());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getSuffix())
					.equals(customerAddAttributeModel.getSuffix())) {
				customerUtility.insertEditTrailDelta(editTrailId, "suffix", customerAddressPreviousData.getSuffix(),
						customerAddAttributeModel.getSuffix());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getTitle())
					.equals(customerAddAttributeModel.getTitle())) {
				customerUtility.insertEditTrailDelta(editTrailId, "title", customerAddressPreviousData.getTitle(),
						customerAddAttributeModel.getTitle());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getAddressStatus())
					.equals(customerUtility.getStringValue(customerAddAttributeModel.getAddressStatus()))) {
				customerUtility.insertEditTrailDelta(editTrailId, "address_status",
						customerAddressPreviousData.getAddressStatus(), customerAddAttributeModel.getAddressStatus());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getCompany())
					.equals(customerAddAttributeModel.getCompany())) {
				customerUtility.insertEditTrailDelta(editTrailId, "company", customerAddressPreviousData.getCompany(),
						customerAddAttributeModel.getCompany());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getDepartment())
					.equals(customerAddAttributeModel.getDepartment())) {
				customerUtility.insertEditTrailDelta(editTrailId, "department",
						customerAddressPreviousData.getDepartment(), customerAddAttributeModel.getDepartment());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getAddress1())
					.equals(customerAddAttributeModel.getAddress1())) {
				customerUtility.insertEditTrailDelta(editTrailId, "address1", customerAddressPreviousData.getAddress1(),
						customerAddAttributeModel.getAddress1());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getAddress2())
					.equals(customerAddAttributeModel.getAddress2())) {
				customerUtility.insertEditTrailDelta(editTrailId, "address2", customerAddressPreviousData.getAddress2(),
						customerAddAttributeModel.getAddress2());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getAddress3())
					.equals(customerAddAttributeModel.getAddress3())) {
				customerUtility.insertEditTrailDelta(editTrailId, "address3", customerAddressPreviousData.getAddress3(),
						customerAddAttributeModel.getAddress3());
				updateFlag = true;
			}
			if (!Integer.toString(customerAddressPreviousData.getSpecialTaxId())
					.equals(customerAddAttributeModel.getSpecialTaxId())) {
				customerUtility.insertEditTrailDelta(editTrailId, "special_tax_id",
						customerAddressPreviousData.getSpecialTaxId(), customerAddAttributeModel.getSpecialTaxId());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getInstitutionalIdentifier())
					.equals(customerAddAttributeModel.getInstitutionalIdentifier())) {
				customerUtility.insertEditTrailDelta(editTrailId, "institutional_identifier",
						customerAddressPreviousData.getInstitutionalIdentifier(),
						customerAddAttributeModel.getInstitutionalIdentifier());
				updateFlag = true;
			}
			if (!customerUtility.getString(customerAddressPreviousData.getAddressType())
					.equals(customerAddAttributeModel.getAddressType())) {
				customerUtility.insertEditTrailDelta(editTrailId, "address_type",
						customerAddressPreviousData.getAddressType(), customerAddAttributeModel.getAddressType());
				updateFlag = true;
			}
			if (customerAddAttributeModel.getFutureOrTemp() != null) {
				if (!customerAddressPreviousData.getChangeType().equals(customerAddAttributeModel.getFutureOrTemp())) {
					customerUtility.insertEditTrailDelta(editTrailId, "change_type",
							customerAddressPreviousData.getChangeType(), customerAddAttributeModel.getFutureOrTemp());
					updateFlag = true;
				}
				if (customerAddressPreviousData.getReplaceCustomerAddressSeq() != customerAddAttributeModel
						.getChangeAddress()) {
					customerUtility.insertEditTrailDelta(editTrailId, "address_type",
							customerAddressPreviousData.getAddressType(), customerAddAttributeModel.getAddressType());
					updateFlag = true;
				}
				if (!(formatDDMMYYYY.format(formatYYYYMMDDHHMMSS.parse(customerAddressPreviousData.getEffectiveDate())))
						.equals(customerAddAttributeModel.getFrom())) {
					customerUtility.insertEditTrailDelta(editTrailId, "effective_date",
							customerAddressPreviousData.getEffectiveDate(),
							formatYYYYMMDDHHMMSS.format(formatDDMMYYYY.parse(customerAddAttributeModel.getFrom())));
					updateFlag = true;
				}
				String prevDate = customerAddressPreviousData.getReverseDate() == null ? null
						: formatDDMMYYYY
								.format(formatYYYYMMDDHHMMSS.parse(customerAddressPreviousData.getReverseDate()));
				// String currentDate= customerAddAttributeModel.getTo()==null ?null:
				// formatYYYYMMDDHHMMSS.format(formatDDMMYYYY.parse(customerAddAttributeModel.getTo()));
				String currentDate = customerUtility.getStringValue(customerAddAttributeModel.getTo()) == null ? null
						: formatYYYYMMDDHHMMSS.format(formatDDMMYYYY.parse(customerAddAttributeModel.getTo()));
				if (prevDate != null || currentDate != null) {
					if (!prevDate.equals(currentDate)) {
						customerUtility.insertEditTrailDelta(editTrailId, "reverse_date",
								customerAddressPreviousData.getReverseDate(), currentDate);
						updateFlag = true;
					}
				}

				String customerAddressTicklerQuery = "update customer_address_tickler set "
						+ "effective_date=:effective_date,replace_customer_address_seq=:replace_customer_address_seq,reverse_date=:reverse_date where "
						+ "customer_id=:customer_id and customer_address_seq=:customer_address_seq";
				parameters.put("effective_date",
						customerUtility.getStringValue(customerAddAttributeModel.getFrom()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getFrom())));
				parameters.put("reverse_date",
						customerUtility.getStringValue(customerAddAttributeModel.getTo()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getTo())));
				parameters.put("replace_customer_address_seq", customerAddAttributeModel.getChangeAddress());
				parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
				parameters.put("customer_address_seq", customerAddAttributeModel.getCustomerAddressSeq());
				namedParameterJdbcTemplate.update(customerAddressTicklerQuery, parameters);
			}

			if (!updateFlag) {
				parameters.clear();
				String deleteEditTrailQuery = "delete from edit_trail where edit_trail_id = :edit_trail_id";
				parameters.put("edit_trail_id", editTrailId);
				namedParameterJdbcTemplate.update(deleteEditTrailQuery, parameters);
			} else {
				customerUtility.updateMruEditTrailId(editTrailId);
			}

			return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String addAddress(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		LOGGER.info("Inside addAddress");
		try {
			Long maxAddressSeqId = jdbcTemplate
					.queryForObject("select max(customer_address_seq) from customer_address where customer_id="
							+ customerAddAttributeModel.getCustomerId(), Long.class);
			if (maxAddressSeqId == null)
				maxAddressSeqId = (long) 0;
			Map<String, Object> parameters = new HashMap<String, Object>();
			String customerAddressQuery;
			if (customerAddAttributeModel.getFutureOrTemp() != null) {
				customerAddressQuery = "INSERT INTO customer_address "
						+ "(customer_id,customer_address_seq,state,city,county,zip,tax_id_number,email,phone,faxnbr,eighthundred,fname,initial_name,lname,salutation,suffix,title,address_status,company,department,effective_date,reverse_date,replace_customer_address_seq,audit_name_change,audit_title_change,supp_clean,address1,address2,address3,special_tax_id,institutional_identifier,change_type,address_type,ignored_clean) VALUES "
						+ "(:customer_id,:customer_address_seq,:state,:city,:county,:zip,:tax_id_number,:email,:phone,:faxnbr,:eighthundred,:fname,:initial_name,:lname,:salutation,:suffix,:title,:address_status,:company,:department,:effective_date,:reverse_date,:replace_customer_address_seq,:audit_name_change,:audit_title_change,:supp_clean,:address1,:address2,:address3,:special_tax_id,:institutional_identifier,:change_type,:address_type,:ignored_clean)";
				parameters.put("effective_date",
						customerUtility.getStringValue(customerAddAttributeModel.getFrom()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getFrom())));
				parameters.put("reverse_date",
						customerUtility.getStringValue(customerAddAttributeModel.getTo()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getTo())));
				parameters.put("replace_customer_address_seq", customerAddAttributeModel.getChangeAddress());
				parameters.put("change_type", customerAddAttributeModel.getFutureOrTemp());

			} else {
				customerAddressQuery = "INSERT INTO customer_address "
						+ "(customer_id,customer_address_seq,state,city,county,zip,tax_id_number,email,phone,faxnbr,eighthundred,fname,initial_name,lname,salutation,suffix,title,address_status,company,department,audit_name_change,audit_title_change,supp_clean,address1,address2,address3,special_tax_id,institutional_identifier,address_type,ignored_clean) VALUES "
						+ "(:customer_id,:customer_address_seq,:state,:city,:county,:zip,:tax_id_number,:email,:phone,:faxnbr,:eighthundred,:fname,:initial_name,:lname,:salutation,:suffix,:title,:address_status,:company,:department,:audit_name_change,:audit_title_change,:supp_clean,:address1,:address2,:address3,:special_tax_id,:institutional_identifier,:address_type,:ignored_clean)";
			}

			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("customer_address_seq", maxAddressSeqId + 1);
			parameters.put(STATE, customerUtility.getStringValue(customerAddAttributeModel.getState()));
			parameters.put("city", customerUtility.getStringValue(customerAddAttributeModel.getCity()));
			parameters.put("county", customerUtility.getStringValue(customerAddAttributeModel.getCounty()));
			parameters.put("zip", customerUtility.getStringValue(customerAddAttributeModel.getZip()));
			parameters.put("tax_id_number", customerUtility.getStringValue(customerAddAttributeModel.getTaxID()));
			parameters.put("email", customerUtility.getStringValue(customerAddAttributeModel.getEmail()));
			parameters.put("phone", customerUtility.getStringValue(customerAddAttributeModel.getPhone1()));
			parameters.put("faxnbr", customerUtility.getStringValue(customerAddAttributeModel.getFax()));
			parameters.put("eighthundred", customerUtility.getStringValue(customerAddAttributeModel.getPhone2()));
			parameters.put("fname", customerUtility.getStringValue(customerAddAttributeModel.getfName()));
			parameters.put("initial_name", customerUtility.getStringValue(customerAddAttributeModel.getInitial()));
			parameters.put("lname", customerUtility.getStringValue(customerAddAttributeModel.getlName()));
			parameters.put("salutation", customerUtility.getStringValue(customerAddAttributeModel.getSalutation()));
			parameters.put("suffix", customerUtility.getStringValue(customerAddAttributeModel.getSuffix()));
			parameters.put("title", customerUtility.getStringValue(customerAddAttributeModel.getTitle()));
			parameters.put("address_status", customerAddAttributeModel.getAddressStatus());
			parameters.put("company", customerUtility.getStringValue(customerAddAttributeModel.getCompany()));
			parameters.put("department", customerUtility.getStringValue(customerAddAttributeModel.getDepartment()));
			parameters.put("audit_name_change", 0);
			parameters.put("audit_title_change", 0);
			parameters.put("supp_clean", 0);
			parameters.put("address1", customerUtility.getStringValue(customerAddAttributeModel.getAddress1()));
			parameters.put("address2", customerUtility.getStringValue(customerAddAttributeModel.getAddress2()));
			parameters.put("address3", customerUtility.getStringValue(customerAddAttributeModel.getAddress3()));
			if (customerUtility.getStringValue(customerAddAttributeModel.getSpecialTaxId()) == null)
				parameters.put("special_tax_id", 0);
			else
				parameters.put("special_tax_id", 1);
			parameters.put("institutional_identifier",
					customerUtility.getStringValue(customerAddAttributeModel.getInstitutionalIdentifier()));
			parameters.put("address_type", customerUtility.getStringValue(customerAddAttributeModel.getAddressType()));
			parameters.put("ignored_clean", 0);
			namedParameterJdbcTemplate.update(customerAddressQuery, parameters);

			parameters.clear();
			if (customerAddAttributeModel.getFutureOrTemp() != null
					&& !"".equals(customerAddAttributeModel.getFutureOrTemp())) {
				String customerAddressTickler = "insert into customer_address_tickler "
						+ "(customer_id,customer_address_seq,effective_date,replace_customer_address_seq,reverse_date) values "
						+ "(:customer_id,:customer_address_seq,:effective_date,:replace_customer_address_seq,:reverse_date)";
				parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
				parameters.put("customer_address_seq", maxAddressSeqId + 1);
				parameters.put("effective_date",
						customerUtility.getStringValue(customerAddAttributeModel.getFrom()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getFrom())));
				parameters.put("reverse_date",
						customerUtility.getStringValue(customerAddAttributeModel.getTo()) == null ? null
								: formatYYYYMMDD.format(formatDDMMYYYY.parse(customerAddAttributeModel.getTo())));
				parameters.put("replace_customer_address_seq", customerAddAttributeModel.getChangeAddress());
				namedParameterJdbcTemplate.update(customerAddressTickler, parameters);
			}

			StringBuilder matchcode = customerUtility.getmatchCode(customerAddAttributeModel);

			Long custmatchCodeId = jdbcTemplate.queryForObject(
					"select max(customer_match_code_id) from customer_address_match_code where customer_id="
							+ customerAddAttributeModel.getCustomerId() + " and customer_address_seq ="
							+ (maxAddressSeqId + 1) + " ",
					Long.class);

			parameters.clear();
			if (custmatchCodeId == null)
				custmatchCodeId = (long) 1;
			String customerMatchCodeQuery = "Insert INTO customer_address_match_code "
					+ "(customer_id,customer_address_seq,customer_match_code_id,match_code) VALUES "
					+ "(:customer_id,:customer_address_seq,:customer_match_code_id,:match_code)";
			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("customer_address_seq", maxAddressSeqId + 1);
			parameters.put("customer_match_code_id", custmatchCodeId + 1);
			parameters.put("match_code", matchcode);
			namedParameterJdbcTemplate.update(customerMatchCodeQuery, parameters);

			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {

				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}

			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;

			parameters.clear();
			String editTrailAddressQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name,customer_address_seq) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name,:customer_address_seq)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("user_code", customerAddAttributeModel.getUserCode());
			parameters.put("edited", 0);
			parameters.put("table_enum", 1);
			parameters.put("document_reference_id", customerAddAttributeModel.getDocumentReferenceId());
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			parameters.put("xaction_name", "customer_address_add_request");
			parameters.put("customer_address_seq", maxAddressSeqId + 1);
			namedParameterJdbcTemplate.update(editTrailAddressQuery, parameters);

			customerUtility.updateMruEditTrailId(editTrailId);

			parameters.clear();
			String customerMruAddressSeqUpdate = "update customer set mru_customer_address_seq = :mru_customer_address_seq where customer_id =:customer_id";
			parameters.put("customer_id", customerAddAttributeModel.getCustomerId());
			parameters.put("mru_customer_address_seq", maxAddressSeqId + 1);
			namedParameterJdbcTemplate.update(customerMruAddressSeqUpdate, parameters);

			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public void getCustomerAddressDetailBySeqID(CustomerAddAttributeModel customerAddAttributeModel, Long customerId,
			int addressSeq) throws SQLException {
		LOGGER.info("Inside getCustomerAddressDetailBySeqID");

		try {
			CustomerAddressModel customerAddressModel = jdbcTemplate
					.queryForObject("select * " + "from customer_address where customer_id =" + customerId
							+ " and customer_address_seq=" + addressSeq, new CustomerAddressMapper());

			customerAddAttributeModel.setCustomerId(customerId);
			customerAddAttributeModel.setCustomerAddressSeq(addressSeq);
			customerAddAttributeModel.setfName(customerAddressModel.getFname());
			customerAddAttributeModel.setSalutation(customerAddressModel.getSalutation());
			customerAddAttributeModel.setlName(customerAddressModel.getLname());
			customerAddAttributeModel.setInitial(customerAddressModel.getInitialName());
			customerAddAttributeModel.setSuffix(customerAddressModel.getSuffix());
			customerAddAttributeModel.setTitle(customerAddressModel.getTitle());
			customerAddAttributeModel.setCompany(customerAddressModel.getCompany());
			customerAddAttributeModel.setDepartment(customerAddressModel.getDepartment());
			customerAddAttributeModel.setAddress1(customerAddressModel.getAddress1());
			customerAddAttributeModel.setAddress2(customerAddressModel.getAddress2());
			customerAddAttributeModel.setAddress3(customerAddressModel.getAddress3());
			customerAddAttributeModel.setCountry(getCountry(customerAddressModel.getState()).get(0));
			customerAddAttributeModel.setCounty(customerAddressModel.getCounty());
			customerAddAttributeModel.setPhone1(customerAddressModel.getPhone());
			customerAddAttributeModel.setPhone2(customerAddressModel.getEighthundred());
			customerAddAttributeModel.setFax(customerAddressModel.getFaxnbr());
			customerAddAttributeModel.setEmail(customerAddressModel.getEmail());
			customerAddAttributeModel.setTaxID(customerAddressModel.getTaxIdNumber());
			customerAddAttributeModel.setInstitutionalIdentifier(customerAddressModel.getInstitutionalIdentifier());
			customerAddAttributeModel.setAddressType(customerAddressModel.getAddressType());
			customerAddAttributeModel.setAddressStatus(customerAddressModel.getAddressStatus());
			customerAddAttributeModel.setCity(customerAddressModel.getCity());
			customerAddAttributeModel.setState(customerAddressModel.getState());
			customerAddAttributeModel.setZip(customerAddressModel.getZip());
			customerAddAttributeModel.setSpecialTaxId(
					customerAddressModel.getSpecialTaxId() == 0 ? null : customerAddressModel.getTaxIdNumber());
			customerAddAttributeModel.setFrom(customerAddressModel.getEffectiveDate() == null ? null
					: formatDDMMYYYY.format(formatYYYYMMDDHHMMSS.parse(customerAddressModel.getEffectiveDate())));
			customerAddAttributeModel.setTo(customerAddressModel.getReverseDate() == null ? null
					: formatDDMMYYYY.format(formatYYYYMMDDHHMMSS.parse(customerAddressModel.getReverseDate())));
			customerAddAttributeModel.setFutureOrTemp("" + customerAddressModel.getChangeType());
			customerAddAttributeModel.setChangeAddress(customerAddressModel.getReplaceCustomerAddressSeq());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}

	@Override
	public List<Object> getAttachment(Long customerId, int attachmentFilter) throws SQLException {
		LOGGER.info("Inside getAttachment");
		List<Object> attachment = new ArrayList<Object>();
		try {
			StringBuilder query = new StringBuilder(
					"SELECT attachment_id,orderhdr_id,order_item_seq,payment_seq,attachment_category,file_name,attachment_url,"
							+ "note_field,user_code,customer_id,CONVERT(VARCHAR(10), creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), creation_date, 22), 11)) as creation_date,(case when attachment_type=0 then 'Customer' when attachment_type=1 then 'Order Items' when attachment_type=2 then 'Payments' end)"
							+ " as attachment_type FROM attachment WHERE customer_id = " + customerId);

			if (attachmentFilter == 1) {
				query.append("  AND orderhdr_id IS NULL AND payment_seq IS NULL");
			}
			if (attachmentFilter == 2) {
				query.append(" AND orderhdr_id IS NOT NULL");
			}
			if (attachmentFilter == 3) {
				query.append(" AND payment_seq IS NOT NULL");
			}
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> row : rows) {
				attachment.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return attachment;

	}

	@Override
	public List<CustomerHistoryModel> getCustomerHistory(Long customerId, int historyFilter) throws SQLException {
		LOGGER.info("Inside getCustomerHistory");
		List<CustomerHistoryModel> customerHistory = null;
		StringBuilder query = new StringBuilder();
		try {

			if (historyFilter == 100 || historyFilter <= 11) {
				query = new StringBuilder("SELECT et.creation_date, et.xaction_name,"
						+ " et.edited, et.table_enum, et.user_code, etd.before_change,etd.after_change, etd.column_name, et.orderhdr_id, et.order_item_seq,"
						+ " et.customer_address_seq, et.payment_seq, et.payment_account_seq,et.service_seq, dr.document_reference_id, dr.description,"
						+ " et.document_reference_seq, pxh.pending_xaction_header_id, vc.voucher_id,vc.voucher_nbr FROM edit_trail et LEFT OUTER JOIN edit_trail_delta etd"
						+ " ON et.edit_trail_id = etd.edit_trail_id LEFT OUTER JOIN document_reference dr ON et.document_reference_id = dr.document_reference_id"
						+ " LEFT OUTER JOIN pending_xaction_header pxh ON dr.document_reference_id = pxh.document_reference_id"
						+ " LEFT OUTER JOIN voucher vc ON pxh.voucher_id = vc.voucher_id where customer_id = "
						+ customerId);
				if (historyFilter != 100)
					query.append(" and table_enum = " + historyFilter);

				query.append(" order by creation_date desc");

				customerHistory = jdbcTemplate.query(query.toString(), new CustomerHistoryMapper());

			} else if (historyFilter == 12) {
				query = new StringBuilder("select * from view_subscrip_hist where customer_id = " + customerId);
//				query.append(" and subscrip_id = ");
				customerHistory = jdbcTemplate.query(query.toString(), new SubscriptionHistoryMapper());
			} else if (historyFilter == 13) {
				query = new StringBuilder("select * from view_singleiss_hist where customer_id = " + customerId);
				customerHistory = jdbcTemplate.query(query.toString(), new SingleIssueHistoryMapper());
			} else if (historyFilter == 14) {
				query = new StringBuilder("select * from view_product_hist where customer_id = " + customerId);
				customerHistory = jdbcTemplate.query(query.toString(), new ProductHistoryMapper());
			} else if (historyFilter == 15) {
				query = new StringBuilder("select * from view_renewal_efforts_hist where customer_id = " + customerId);
				customerHistory = jdbcTemplate.query(query.toString(), new RenewalEffortHistoryMapper());
			} else if (historyFilter == 16) {
				query = new StringBuilder("select * from view_billing_efforts_hist where customer_id = " + customerId);
				customerHistory = jdbcTemplate.query(query.toString(), new BillingEffortHistoryMapper());
			} else if (historyFilter == 17) {
				query = new StringBuilder(
						"select * from view_promotion_efforts_hist where customer_id = " + customerId);
				customerHistory = jdbcTemplate.query(query.toString(), new PromotionEffortsMapper());
			} else {
				query = new StringBuilder("select * from view_unit_hist");
				customerHistory = jdbcTemplate.query(query.toString(), new UnitsHistoryMapper());
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return customerHistory;

	}

	@Override
	public List<DropdownModel> getAttachmentFilterList(Long customerId) throws SQLException {
		LOGGER.info("Inside getAttachmentFilterList");
		List<DropdownModel> attachmentFilterList = new ArrayList<>();
		try {
			attachmentFilterList.add(new DropdownModel("0", "ALL", null, null, null, null));
			attachmentFilterList.add(new DropdownModel("1", "Customer", null, null, null, null));

			int count = jdbcTemplate.queryForObject("select count(*) from order_item where customer_id=" + customerId,
					Integer.class);
			if (count > 0)
				attachmentFilterList.add(new DropdownModel("2", "Order Items", null, null, null, null));

			count = jdbcTemplate.queryForObject("select count(*) from payment where customer_id=" + customerId,
					Integer.class);
			if (count > 0)
				attachmentFilterList.add(new DropdownModel("3", "Payments", null, null, null, null));

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return attachmentFilterList;

	}

	@Override
	public List<DropdownModel> getNoteFilterList(Long customerId) throws SQLException {
		LOGGER.info("Inside getNoteFilterList");
		List<DropdownModel> notetFilterList = new ArrayList<>();
		try {
			notetFilterList.add(new DropdownModel("0", "ALL", null, null, null, null));

			notetFilterList.add(new DropdownModel("1", "Customer", null, null, null, null));

			int count = jdbcTemplate.queryForObject("select count(*) from subscrip where customer_id=" + customerId,
					Integer.class);
			if (count > 0)
				notetFilterList.add(new DropdownModel("2", "Subscriptions", null, null, null, null));

			count = jdbcTemplate.queryForObject("select count(*) from order_item where customer_id=" + customerId,
					Integer.class);
			if (count > 0)
				notetFilterList.add(new DropdownModel("3", "Order Items", null, null, null, null));

			count = jdbcTemplate.queryForObject("select count(*) from payment where customer_id=" + customerId,
					Integer.class);
			if (count > 0)
				notetFilterList.add(new DropdownModel("4", "Payments", null, null, null, null));

			count = jdbcTemplate.queryForObject(
					"select count(*) from order_item oi, suspension sus where oi.customer_id =" + customerId
							+ " AND oi.orderhdr_id = sus.orderhdr_id AND oi.order_item_seq = sus.order_item_seq",
					Integer.class);
			if (count > 0)
				notetFilterList.add(new DropdownModel("5", "Suspension", null, null, null, null));

			count = jdbcTemplate.queryForObject("select count(*) from service where customer_id=" + customerId,
					Integer.class);
	
			notetFilterList.add(new DropdownModel("6", "Customer Services", null, null, null, null));

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return notetFilterList;

	}

	@Override
	public List<Object> getNote(Long customerId, int noteFilter, Optional<Integer> paymentSeq,
			Optional<Long> orderhdrId, Optional<Integer> orderItemSeq) throws SQLException {
		LOGGER.info("Inside getNote");
		List<Object> note = new ArrayList<Object>();
		try {
			StringBuilder query = new StringBuilder("");

			switch (noteFilter) {
			case 0:
				query.append("SELECT * FROM view_note_tab_all WHERE customer_id =" + customerId
						+ "ORDER BY creation_date desc");
				break;
			case 1:
				query.append(
						"SELECT creation_date,user_code,note_field,customer_note_seq FROM customer_note WHERE customer_id ="
								+ customerId + " ORDER BY creation_date desc");
				break;
			case 2:
				query.append(
						"SELECT subscrip_note.creation_date,subscrip_note.subscrip_id,subscrip_note.user_code,subscrip_note.note_field,subscrip_note.subscrip_note_seq FROM subscrip_note, subscrip s WHERE subscrip_note.subscrip_id = s.subscrip_id and s.customer_id ="
								+ customerId + " ORDER BY subscrip_note.creation_date desc ");
				break;
			case 3:
				if (orderhdrId.isPresent() && orderItemSeq.isPresent()) {
					query.append(
							"SELECT order_item_note.creation_date,order_item_note.orderhdr_id,order_item_note.order_item_seq,order_item_note.user_code,order_item_note.note_field,order_item_note.order_item_note_seq FROM order_item_note, order_item oi WHERE order_item_note.orderhdr_id = oi.orderhdr_id and order_item_note.order_item_seq = oi.order_item_seq and customer_id ="
									+ customerId + " and oi.orderhdr_id =" + orderhdrId.get().toString()
									+ " and oi.order_item_seq = " + orderItemSeq.get().toString()
									+ " ORDER BY order_item_note.creation_date desc ");
				} else {
					query.append(
							"SELECT order_item_note.creation_date,order_item_note.orderhdr_id,order_item_note.order_item_seq,order_item_note.user_code,order_item_note.note_field,order_item_note.order_item_note_seq FROM order_item_note, order_item oi WHERE order_item_note.orderhdr_id = oi.orderhdr_id and order_item_note.order_item_seq = oi.order_item_seq and customer_id ="
									+ customerId + " ORDER BY order_item_note.creation_date desc ");
				}
				break;
			case 4:
				if (paymentSeq.isPresent()) {
					query.append(
							"SELECT creation_date,payment_seq,user_code,note_field,payment_note_seq FROM payment_note WHERE customer_id ="
									+ customerId + " and payment_seq = " + paymentSeq.get().toString()
									+ " ORDER BY creation_date desc");
				} else {
					query.append(
							"SELECT creation_date,payment_seq,user_code,note_field,payment_note_seq FROM payment_note WHERE customer_id ="
									+ customerId + " ORDER BY creation_date desc");
				}
				break;
			case 5:
				query.append(
						"SELECT suspension_note.creation_date,suspension_note.suspension_seq,suspension_note.user_code,suspension_note.note_field,suspension_note.orderhdr_id,suspension_note.order_item_seq,suspension_note.suspension_note_seq FROM suspension_note, order_item oi WHERE suspension_note.orderhdr_id = oi.orderhdr_id and suspension_note.order_item_seq = oi.order_item_seq and customer_id ="
								+ customerId + " ORDER BY suspension_note.creation_date desc ");
				break;
			case 6:
				query.append(
						"SELECT creation_date,service_seq,user_code,note_field,service_note_seq FROM service_note WHERE customer_id ="
								+ customerId + " ORDER BY creation_date desc");
				break;
			}

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> row : rows) {
				if (noteFilter == 0) {
					switch (row.get("note_type").toString()) {
					case "0":
						row.put("note_type_Description", "Customer");
						break;
					case "1":
						row.put("note_type_Description", "Subscriptions");
						break;
					case "2":
						row.put("note_type_Description", "Order Items");
						break;
					case "3":
						row.put("note_type_Description", "Payments");
						break;
					case "4":
						row.put("note_type_Description", "Suspension");
						break;
					case "5":
						row.put("note_type_Description", "Customer Services");
						break;
					}
				}
				note.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return note;

	}

	@Override
	public List<DropdownModel> getNoteRecordList(Long customerId, String noteFilter) throws SQLException {
		LOGGER.info("Inside getNoteRecordList");
		List<DropdownModel> noteRecordList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows;
			switch (noteFilter) {
			case "Subscriptions":
				rows = jdbcTemplate.queryForList(
						"select s.subscrip_id as subscrip_id,s.oc_id as oc_id,s.source_code_id as source_code_id,oc from subscrip as s inner join oc on s.oc_id=oc.oc_id where s.customer_id="
								+ customerId);
				for (Map<String, Object> row : rows) {
					DropdownModel model = new DropdownModel();
					model.setKey(row.get("subscrip_id").toString());
					model.setDisplay(row.get("oc_id").toString());
					model.setDescription(row.get("source_code_id").toString());
					model.setExtra((String) row.get("oc"));
//										model.setExtraData((String)row.get("source_code_id"));
					noteRecordList.add(model);
				}
				break;
			case "Order Items":
				rows = jdbcTemplate.queryForList(
						"Select orderhdr_id,order_item_seq,convert(varchar,order_date,101) as order_date,order_code from order_item oi inner join"
								+ " order_code oc on oi.order_code_id = oc.order_code_id where customer_id= "
								+ customerId);
				for (Map<String, Object> row : rows) {
					DropdownModel model = new DropdownModel();
					model.setKey(row.get("orderhdr_id") + "-" + row.get("order_item_seq"));
					model.setDisplay(String.valueOf(row.get("orderhdr_id")));
					model.setDescription(row.get("order_item_seq").toString());
					model.setExtra((String) row.get("order_date"));
					model.setExtraData((String) row.get("order_code"));
					noteRecordList.add(model);
				}
				break;
			case "Payments":
				rows = jdbcTemplate.queryForList(
						"select payment_seq,payment_type,currency,base_amount,pay_currency_amount,CONVERT(VARCHAR(10), creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), creation_date, 22), 11)) as creation_date from payment where customer_id="
								+ customerId);
				for (Map<String, Object> row : rows) {
					DropdownModel model = new DropdownModel();
					model.setKey(row.get("payment_seq").toString());
					model.setDisplay((String) row.get("payment_type"));
					model.setDescription((String) row.get("currency"));
					model.setExtra(String.format("%.2f", row.get("pay_currency_amount")));
					model.setExtraData(String.valueOf(row.get("creation_date")));
					noteRecordList.add(model);
				}
				break;
			case "Suspension":
				rows = jdbcTemplate.queryForList(
						"select suspension.orderhdr_id,suspension.order_item_seq,suspension.suspension_seq,suspension.creation_date from suspension,order_item where suspension.orderhdr_id=order_item.orderhdr_id and order_item.customer_id="
								+ customerId);
				for (Map<String, Object> row : rows) {
					DropdownModel model = new DropdownModel();
					model.setKey(
							row.get("orderhdr_id") + "-" + row.get("order_item_seq") + "-" + row.get("suspension_seq"));
					model.setDisplay("Order: " + row.get("orderhdr_id") + " (Order Item Line: "
							+ row.get("order_item_seq") + " - Suspension Line: " + row.get("suspension_seq")
							+ " - Date: " + row.get("creation_date") + ")");
									noteRecordList.add(model);
				}
				break;
			case "Customer Services":
				rows = jdbcTemplate.queryForList(
						"select service_seq,service_code,service_date from service where customer_id=" + customerId);
				for (Map<String, Object> row : rows) {
					DropdownModel model = new DropdownModel();
					model.setKey(row.get("service_seq").toString());
					model.setDisplay("Service Seq: " + row.get("service_seq") + " (Service Code: "
							+ row.get("service_code") + " - Creation Date: " + row.get("service_date") + ")");
//											noteRecordList.add(model);
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return noteRecordList;

	}

	@Override
	public String addNote(NoteAddAttributeModel noteAddAttributeModel) throws SQLException {
		LOGGER.info("Inside addNote");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			if ("Customer".equals(noteAddAttributeModel.getNoteType())) {
				Long maxNoteSeq = jdbcTemplate
						.queryForObject("select max(customer_note_seq) from customer_note where customer_id="
								+ noteAddAttributeModel.getCustomerId(), Long.class);
				if (maxNoteSeq == null)
					maxNoteSeq = (long) 0;
				String query = "insert into customer_note (customer_id,customer_note_seq,user_code,creation_date,note_field) values ("
						+ ":customer_id,:customer_note_seq,:user_code,:creation_date,:note_field)";
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("customer_note_seq", maxNoteSeq + 1);
				parameters.put("user_code", noteAddAttributeModel.getUserCode());
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				namedParameterJdbcTemplate.update(query, parameters);
				parameters.clear();

				String updatequery = "update customer set mru_customer_note_seq=:mru_customer_note_seq where customer_id=:customer_id";
				parameters.put("mru_customer_note_seq", maxNoteSeq + 1);
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Subscriptions".equals(noteAddAttributeModel.getNoteType())) {

				Long maxNoteSeq = jdbcTemplate
						.queryForObject("select max(subscrip_note_seq) from subscrip_note where subscrip_id="
								+ noteAddAttributeModel.getRecord(), Long.class);
				if (maxNoteSeq == null)
					maxNoteSeq = (long) 0;
				String query = "insert into subscrip_note (subscrip_id,subscrip_note_seq,user_code,creation_date,note_field) values ("
						+ ":subscrip_id,:subscrip_note_seq,:user_code,:creation_date,:note_field)";
				parameters.put("subscrip_id", noteAddAttributeModel.getRecord());
				parameters.put("subscrip_note_seq", maxNoteSeq + 1);
				parameters.put("user_code", noteAddAttributeModel.getUserCode());
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				namedParameterJdbcTemplate.update(query, parameters);
				parameters.clear();

				String updatequery = "update subscrip set mru_subscrip_note_seq=:mru_subscrip_note_seq where subscrip_id=:subscrip_id";
				parameters.put("mru_subscrip_note_seq", maxNoteSeq + 1);
				parameters.put("subscrip_id", noteAddAttributeModel.getRecord());
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Order Items".equals(noteAddAttributeModel.getNoteType())) {
				String record[] = noteAddAttributeModel.getRecord().split("-");
				Long maxNoteSeq = jdbcTemplate
						.queryForObject("select max(order_item_note_seq) from order_item_note where orderhdr_id="
								+ record[0] + " and order_item_seq=" + record[1], Long.class);
				if (maxNoteSeq == null)
					maxNoteSeq = (long) 0;
				String query = "insert into order_item_note (orderhdr_id,order_item_seq,order_item_note_seq,user_code,creation_date,note_field) values ("
						+ ":orderhdr_id,:order_item_seq,:order_item_note_seq,:user_code,:creation_date,:note_field)";
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("order_item_note_seq", maxNoteSeq + 1);
				parameters.put("user_code", noteAddAttributeModel.getUserCode());
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				namedParameterJdbcTemplate.update(query, parameters);
				parameters.clear();

				String updatequery = "update order_item set mru_order_item_note_seq=:mru_order_item_note_seq ,note_exist=:note_exist where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq ";
				parameters.put("mru_order_item_note_seq", maxNoteSeq + 1);
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("note_exist", 1);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Payments".equals(noteAddAttributeModel.getNoteType())) {

				Long maxNoteSeq = jdbcTemplate
						.queryForObject("select max(payment_note_seq) from payment_note where customer_id="
								+ noteAddAttributeModel.getCustomerId() + " and payment_seq="
								+ noteAddAttributeModel.getRecord(), Long.class);
				if (maxNoteSeq == null)
					maxNoteSeq = (long) 0;
				String query = "insert into payment_note (customer_id,payment_seq,payment_note_seq,user_code,creation_date,note_field) values ("
						+ ":customer_id,:payment_seq,:payment_note_seq,:user_code,:creation_date,:note_field)";
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("payment_seq", noteAddAttributeModel.getRecord());
				parameters.put("payment_note_seq", maxNoteSeq + 1);
				parameters.put("user_code", noteAddAttributeModel.getUserCode());
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				namedParameterJdbcTemplate.update(query, parameters);
				parameters.clear();

				String updatequery = "update payment set mru_payment_note_seq=:mru_payment_note_seq where customer_id=:customer_id and payment_seq=:payment_seq";
				parameters.put("mru_payment_note_seq", maxNoteSeq + 1);
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("payment_seq", noteAddAttributeModel.getRecord());
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Suspension".equals(noteAddAttributeModel.getNoteType())) {
				String record[] = noteAddAttributeModel.getRecord().split("-");
				Long maxNoteSeq = jdbcTemplate
						.queryForObject(
								"select max(suspension_note_seq) from suspension_note where orderhdr_id=" + record[0]
										+ " and order_item_seq=" + record[1] + " and suspension_seq=" + record[2],
								Long.class);
				if (maxNoteSeq == null)
					maxNoteSeq = (long) 0;
				String query = "insert into suspension_note (orderhdr_id,order_item_seq,suspension_seq,suspension_note_seq,user_code,creation_date,note_field) values ("
						+ ":orderhdr_id,:order_item_seq,:suspension_seq,:suspension_note_seq,:user_code,:creation_date,:note_field)";
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("suspension_seq", record[2]);
				parameters.put("suspension_note_seq", maxNoteSeq + 1);
				parameters.put("user_code", noteAddAttributeModel.getUserCode());
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				namedParameterJdbcTemplate.update(query, parameters);
				parameters.clear();

				String updatequery = "update suspension set mru_suspension_note_seq=:mru_suspension_note_seq where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and suspension_seq=:suspension_seq";
				parameters.put("mru_suspension_note_seq", maxNoteSeq + 1);
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("suspension_seq", record[2]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Customer Services".equals(noteAddAttributeModel.getNoteType())) {
				Long maxNoteSeq = jdbcTemplate
						.queryForObject("select max(service_note_seq) from service_note where customer_id="
								+ noteAddAttributeModel.getCustomerId() + " and service_seq="
								+ noteAddAttributeModel.getRecord(), Long.class);
				if (maxNoteSeq == null)
					maxNoteSeq = (long) 0;
				String query = "insert into service_note (customer_id,service_seq,service_note_seq,user_code,creation_date,note_field) values ("
						+ ":customer_id,:service_seq,:service_note_seq,:user_code,:creation_date,:note_field)";
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("service_seq", noteAddAttributeModel.getRecord());
				parameters.put("service_note_seq", maxNoteSeq + 1);
				parameters.put("user_code", noteAddAttributeModel.getUserCode());
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				namedParameterJdbcTemplate.update(query, parameters);
				parameters.clear();

				String updatequery = "update service set mru_service_note_seq=:mru_service_note_seq where customer_id=:customer_id and service_seq=:service_seq";
				parameters.put("mru_service_note_seq", maxNoteSeq + 1);
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("service_seq", noteAddAttributeModel.getRecord());
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}

			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String editNote(NoteAddAttributeModel noteAddAttributeModel) throws SQLException {
		LOGGER.info("Inside editNote");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String record[] = noteAddAttributeModel.getRecord().split("-");
			if ("Customer".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "update customer_note set note_field=:note_field where customer_id=:customer_id and customer_note_seq=:customer_note_seq";
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("customer_note_seq", record[0]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Subscriptions".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "update subscrip_note set note_field=:note_field where subscrip_id=:subscrip_id and subscrip_note_seq=:subscrip_note_seq";
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				parameters.put("subscrip_id", record[0]);
				parameters.put("subscrip_note_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Order Items".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "update order_item_note set note_field=:note_field where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and order_item_note_seq=:order_item_note_seq";
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("order_item_note_seq", record[2]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Payments".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "update payment_note set note_field=:note_field where customer_id=:customer_id and payment_seq=:payment_seq and payment_note_seq=:payment_note_seq";
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("payment_seq", record[0]);
				parameters.put("payment_note_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Suspension".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "update suspension_note set note_field=:note_field where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and suspension_seq=:suspension_seq and suspension_note_seq=:suspension_note_seq";
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("suspension_seq", record[2]);
				parameters.put("suspension_note_seq", record[3]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Customer Service".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "update service_note set note_field=:note_field where customer_id=:customer_id and service_seq=:service_seq and service_note_seq=:service_note_seq";
				parameters.put("note_field", customerUtility.getStringValue(noteAddAttributeModel.getNote()));
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("service_seq", record[0]);
				parameters.put("service_note_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}

			return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String deleteNote(NoteAddAttributeModel noteAddAttributeModel) throws SQLException {
		LOGGER.info("Inside deleteNote");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String record[] = noteAddAttributeModel.getRecord().split("-");
			if ("Customer".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "delete from customer_note where customer_id=:customer_id and customer_note_seq=:customer_note_seq";
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("customer_note_seq", record[0]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Subscriptions".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "delete from subscrip_note where subscrip_id=:subscrip_id and subscrip_note_seq=:subscrip_note_seq";
				parameters.put("subscrip_id", record[0]);
				parameters.put("subscrip_note_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Order Items".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "delete from order_item_note where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and order_item_note_seq=:order_item_note_seq";
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("order_item_note_seq", record[2]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Payments".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "delete from payment_note where customer_id=:customer_id and payment_seq=:payment_seq and payment_note_seq=:payment_note_seq";
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("payment_seq", record[0]);
				parameters.put("payment_note_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Suspension".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "delete from  suspension_note where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and suspension_seq=:suspension_seq and suspension_note_seq=:suspension_note_seq";
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				parameters.put("suspension_seq", record[2]);
				parameters.put("suspension_note_seq", record[3]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}
			if ("Customer Service".equals(noteAddAttributeModel.getNoteType())) {
				String updatequery = "delete from service_note where customer_id=:customer_id and service_seq=:service_seq and service_note_seq=:service_note_seq";
				parameters.put("customer_id", noteAddAttributeModel.getCustomerId());
				parameters.put("service_seq", record[0]);
				parameters.put("service_note_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			}

			return "Deleted";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public List<DropdownModel> getAttachmentCategoryList() throws SQLException {
		LOGGER.info("Inside getAttachmentCategoryList");
		List<DropdownModel> attachmentCategoryList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select attachment_category,description from attachment_category order by attachment_category asc");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("attachment_category").toString());
				model.setDisplay(row.get("description").toString());
				attachmentCategoryList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return attachmentCategoryList;

	}

	@Override
	public String addAttachment(AttachmentAddAttributeModel attachmentAddAttributeModel) throws SQLException {
		LOGGER.info("Inside addAttachment");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			Long maxAttachmentId = jdbcTemplate.queryForObject("select max(attachment_id) from attachment", Long.class);
			if (maxAttachmentId == null)
				maxAttachmentId = (long) 0;

			if (attachmentAddAttributeModel.getAttachment() != null
					&& !"".equals(attachmentAddAttributeModel.getAttachment().getOriginalFilename())) {
				File file = new File(new PropertyUtilityClass().getConstantValue("attachmentLocation"));
				if (!file.exists())
					file.mkdir();
				byte[] bytes = attachmentAddAttributeModel.getAttachment().getBytes();
				Path path = Paths
						.get(new PropertyUtilityClass().getConstantValue("attachmentLocation") + (maxAttachmentId + 1)
								+ "_" + attachmentAddAttributeModel.getAttachment().getOriginalFilename());
				Files.write(path, bytes);
			}

			String query = "insert into attachment (attachment_id,attachment_type,user_code,note_field,creation_date,attachment_category,file_name,customer_id,attachment_url,payment_seq,orderhdr_id,order_item_seq) values("
					+ ":attachment_id,:attachment_type,:user_code,:note_field,:creation_date,:attachment_category,:file_name,:customer_id,:attachment_url,:payment_seq,:orderhdr_id,:order_item_seq)";
			parameters.put("attachment_id", maxAttachmentId + 1);
			if (attachmentAddAttributeModel.getAttachmentType().equals("Customer"))
				parameters.put("attachment_type", 0);
			else if (attachmentAddAttributeModel.getAttachmentType().equals("Order Items"))
				parameters.put("attachment_type", 1);
			else if (attachmentAddAttributeModel.getAttachmentType().equals("Payments"))
				parameters.put("attachment_type", 2);

			parameters.put("user_code", attachmentAddAttributeModel.getUserCode());
			parameters.put("note_field",
					customerUtility.getStringValue(attachmentAddAttributeModel.getAttachmentnote()));
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			if ("".equals(attachmentAddAttributeModel.getAttachmentCategory()))
				parameters.put("attachment_category", null);
			else
				parameters.put("attachment_category", attachmentAddAttributeModel.getAttachmentCategory());

			String file[] = attachmentAddAttributeModel.getURL().split("//");
			
			if (!"".equals(attachmentAddAttributeModel.getURL())) {
				parameters.put("file_name", file[1]);
				parameters.put("attachment_url", attachmentAddAttributeModel.getURL());
			} else {
				parameters.put("file_name",attachmentAddAttributeModel.getAttachment().getOriginalFilename());
				parameters.put("attachment_url", attachmentAddAttributeModel.getURL());
			}
			parameters.put("customer_id", attachmentAddAttributeModel.getCustomerId());
			if ("Payments".equals(attachmentAddAttributeModel.getAttachmentType()))
				parameters.put("payment_seq", attachmentAddAttributeModel.getRecord());
			else
				parameters.put("payment_seq", null);
			if ("Order Items".equals(attachmentAddAttributeModel.getAttachmentType())) {
				String record[] = attachmentAddAttributeModel.getRecord().split("-");
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);

				String updatequery = "update order_item set attach_exist=:attach_exist where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq ";
				parameters.put("attach_exist", 1);
				parameters.put("orderhdr_id", record[0]);
				parameters.put("order_item_seq", record[1]);
				namedParameterJdbcTemplate.update(updatequery, parameters);
			} else {
				parameters.put("orderhdr_id", null);
				parameters.put("order_item_seq", null);
			}

			namedParameterJdbcTemplate.update(query, parameters);

			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public LinkedHashMap<String, byte[]> getAttachmentFile(String attachmentId) throws SQLException {
		LOGGER.info("Inside getAttachmentFile");
		LinkedHashMap<String, byte[]> attachmentFile = new LinkedHashMap<String, byte[]>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select attachment_content,file_name from attachment where attachment_id=" + attachmentId);
			for (Map<String, Object> row : rows) {
				attachmentFile.put(row.get("file_name").toString(), (byte[]) row.get("attachment_content"));
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return attachmentFile;
	}

	@Override
	public String deleteAttachment(String attachmentId) throws SQLException {
		LOGGER.info("Inside deleteAttachment");
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			String filename = jdbcTemplate.queryForObject(
					"select file_name from attachment where attachment_id=" + attachmentId, String.class);
			if (filename != null) {
				File file = new File(new PropertyUtilityClass().getConstantValue("attachmentLocation") + filename);
				if (!file.delete())
					LOGGER.info("File not found");
			}
			
			List<String> orderhdrId = jdbcTemplate.queryForList("select orderhdr_id from attachment where attachment_id="+attachmentId, String.class);
			String orderId = null;
			if(orderhdrId.size() != 0)
				orderId = orderhdrId.get(0);
			if(orderId != null) {
				List<Map<String, Object>> order = null;
				StringBuilder query = new StringBuilder("select * from order_item where orderhdr_id=(select orderhdr_id from attachment where attachment_id=" + attachmentId + ") and order_item_seq=(select order_item_seq from attachment where attachment_id=" + attachmentId + ") and order_status in (0,5,7,8,9,10,11,12,13)");
				order = jdbcTemplate.queryForList(query.toString());
				
				Long dateStamp = customerUtility.getmaxDateStamp();
				Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
				String editTrail = "insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)";
				parameters.put("edit_trail_id", editTrailId);
				parameters.put("customer_id", order.get(0).get("customer_id"));
				parameters.put("customer_address_seq", order.get(0).get("customer_address_seq"));
				parameters.put("user_code", order.get(0).get("user_code"));
				parameters.put("subscrip_id", order.get(0).get("subscrip_id"));
				parameters.put("orderhdr_id", order.get(0).get("orderhdr_id"));
				parameters.put("order_item_seq", order.get(0).get("order_item_seq"));
				parameters.put("edited", 1);
				parameters.put("currency", order.get(0).get("currency"));
				parameters.put("table_enum", 3);
				parameters.put("document_reference_id", 1);
				parameters.put("local_amount", order.get(0).get("gross_local_amount"));
				parameters.put("base_amount", order.get(0).get("gross_base_amount"));
				parameters.put("date_stamp", dateStamp);
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				parameters.put("xaction_name", "attachment_delete_request");
				namedParameterJdbcTemplate.update(editTrail, parameters);
				
				String orderItem = "update order_item set attach_exist=0 where orderhdr_id=(select orderhdr_id from attachment where attachment_id=" + attachmentId + ") and order_item_seq=(select order_item_seq from attachment where attachment_id=" + attachmentId + ") ";
				jdbcTemplate.update(orderItem);
			}
			
			String updatequery = "delete from attachment where attachment_id=" + attachmentId;
			jdbcTemplate.update(updatequery);
			
			return "Deleted";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String editAttachment(AttachmentAddAttributeModel attachmentAddAttributeModel) throws SQLException {
		LOGGER.info("Inside editAttachment");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String updatequery = "update attachment set note_field=:note_field,attachment_category=:attachment_category   where attachment_id=:attachment_id";
			parameters.put("attachment_category", attachmentAddAttributeModel.getAttachmentCategory() == "" ? null
					: attachmentAddAttributeModel.getAttachmentCategory());
			parameters.put("note_field",
					customerUtility.getStringValue(attachmentAddAttributeModel.getAttachmentnote()));
			parameters.put("attachment_id", attachmentAddAttributeModel.getAttachmentId());
			namedParameterJdbcTemplate.update(updatequery, parameters);

			return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public List<CustomerAuxiliaryModel> getCustomerAuxiliaryFormField() throws SQLException {
		LOGGER.info("Inside getCustomerAuxiliaryFormField");
		List<CustomerAuxiliaryModel> result = null;
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "customer");
			parameters.put("custsvc_edit_disposition", 0);
			result = namedParameterJdbcTemplate.query(
					"SELECT * FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name",
					parameters, new CustomerAuxiliaryMapper());
			for (CustomerAuxiliaryModel customerAuxiliaryModel : result) {
				customerAuxiliaryModel.setColumnDatatype(new PropertyUtilityClass()
						.getConstantValue("column_datatype_" + customerAuxiliaryModel.getColumnDatatype()));
				if (customerAuxiliaryModel.getLookupTableName() != null) {
					LinkedHashMap<String, String> values = new LinkedHashMap<String, String>();
					List<Map<String, Object>> rows = jdbcTemplate
							.queryForList("select " + customerAuxiliaryModel.getLookupDisplayColumnName() + ","
									+ customerAuxiliaryModel.getLookupValueColumnName() + " from "
									+ customerAuxiliaryModel.getLookupTableName());
					for (Map<String, Object> row : rows) {
						values.put(row.get(customerAuxiliaryModel.getLookupDisplayColumnName()).toString(),
								row.get(customerAuxiliaryModel.getLookupValueColumnName()).toString());
					}
					customerAuxiliaryModel.setValues(values);
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return result;
	}

	@Override
	public LinkedHashMap<String, String> setCustomerAuxiliaryDetailByID(Long customerId) throws SQLException {
		LOGGER.info("Inside setCustomerAuxiliaryDetailByID");
		LinkedHashMap<String, String> customerDetail = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> customerDetail2 = new LinkedHashMap<String, String>();
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			Map<String, Object> parameters2 = new HashMap<String, Object>();
			parameters.put("customer_id", customerId);
			parameters2.put("table_name", "customer");
			parameters2.put("custsvc_edit_disposition", 0);
			int count = namedParameterJdbcTemplate.queryForObject(
					"select count(*) from customer_ext where customer_id= :customer_id", parameters, Integer.class);
			if (count > 0) {
				List<String> fields = namedParameterJdbcTemplate.queryForList(
						"SELECT column_name FROM aux_field WHERE table_name = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition",
						parameters2, String.class);
				Map<String, Object> rows = namedParameterJdbcTemplate
						.queryForMap("select * from customer_ext where customer_id= :customer_id", parameters);

				for (Map.Entry<String, Object> entry : rows.entrySet())
					for (int i = 0; i < fields.size(); i++) {
						if (fields.contains(entry.getKey())) {
							customerDetail.put(fields.get(i),
									rows.get(fields.get(i)) == null ? null : rows.get(fields.get(i)).toString());
						}
					}
				Set<Entry<String, String>> entries = customerDetail.entrySet();
				for (Entry<String, String> entry : entries) {
					if (entry.getKey().contains("date") && entry.getValue() != null) {
						String value = entry.getValue();
						String date = value.substring(0, value.indexOf(' '));
						customerDetail2.put(entry.getKey(), date);
					} else {
						customerDetail2.put(entry.getKey(), entry.getValue());
					}
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return customerDetail2;
	}

	@Override
	public String saveCustomerAuxiliary(HttpServletRequest request) throws SQLException {
		LOGGER.info("Inside saveCustomerAuxiliary");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "customer");
			parameters.put("custsvc_edit_disposition", 0);
			List<String> columnName = namedParameterJdbcTemplate.queryForList(
					"SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name",
					parameters, String.class);

			parameters.clear();
			parameters.put("customer_id", request.getParameter("customerId"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject(
					"select count(*) from customer_ext where customer_id= :customer_id", parameters, Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData = null;
			if (auxiliaryCount > 0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate
						.queryForMap("select * from customer_ext where customer_id= :customer_id", parameters);

			parameters.clear();
			StringBuilder query = new StringBuilder("");

			if (!"true".equals(request.getParameter("updateFlag"))) {
				query.append("Insert into customer_ext (customer_id,");

				for (String column : columnName)
					query.append(column + ",");
				query.setLength(query.length() - 1);

				query.append(") VALUES(:customer_id,");

				for (String column : columnName) {
					query.append(":" + column + ",");
					parameters.put(column,
							"".equals(request.getParameter(column)) ? null : request.getParameter(column));
				}
				query.setLength(query.length() - 1);

				query.append(")");
			} else {
				query.append("UPDATE customer_ext set ");

				for (String column : columnName) {
					query.append(column + "=:" + column + ",");
					parameters.put(column,
							"".equals(request.getParameter(column)) ? null : request.getParameter(column));
				}
				query.setLength(query.length() - 1);

				query.append(" where customer_id=:customer_id");

			}

			parameters.put("customer_id", request.getParameter("customerId"));

			namedParameterJdbcTemplate.update(query.toString(), parameters);

			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}

			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;

			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", request.getParameter("customerId"));
			parameters.put("user_code", request.getParameter("userCode"));
			parameters.put("edited", 1);
			parameters.put("table_enum", 0);
			parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			if (!"true".equals(request.getParameter("updateFlag"))) {
				parameters.put("xaction_name", "customer_add_request");
			} else {
				parameters.put("xaction_name", "customer_edit_request");
			}
			namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);

			customerUtility.updateMruEditTrailId(editTrailId);

			for (String column : columnName) {
				if (auxiliaryCount > 0) {
					if (!(customerAuxiliaryPreviousData.get(column) == null ? ""
							: customerAuxiliaryPreviousData.get(column).toString())
									.equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column,
								customerAuxiliaryPreviousData.get(column),
								"".equals(request.getParameter(column)) ? null : request.getParameter(column));
				} else {
					if (!"".equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, null,
								"".equals(request.getParameter(column)) ? null : request.getParameter(column));
				}
			}

			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR + " due to wrong data type in input fields.";
		}
	}

	@Override
	public List<String> getEffevtiveReverseDate(Long customerId) throws SQLException {
		LOGGER.info("Inside getEffevtiveReverseDate");
		List<String> effectivereverseDate = new ArrayList<String>();
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("customer_id", customerId);
			parameters.put("replace_customer_address_seq", 1);
			List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(
					"SELECT CONVERT(VARCHAR(10), effective_date,103) as effective_date,CONVERT(VARCHAR(10), reverse_date,103) as reverse_date,change_type FROM customer_address "
							+ "WHERE customer_id= :customer_id and replace_customer_address_seq = :replace_customer_address_seq ORDER BY effective_date",
					parameters);
			for (Map<String, Object> row : rows) {
				effectivereverseDate
						.add(row.get("effective_date") + "-" + row.get("reverse_date") + "-" + row.get("change_type"));
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return effectivereverseDate;
	}

	@Override
	public String deleteAddress(Long customerId , String customerAddress_Seq) throws SQLException {
		LOGGER.info("Inside deleteAddress");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			int customerAddressSeq = Integer.valueOf(customerAddress_Seq);
			parameters.put("customer_id", customerId);
			parameters.put("customer_address_seq", customerAddressSeq);
			parameters.put("table_enum", 1);
			parameters.put("customer_match_code_id", 2);
			String deleteEventQueue = "delete from event_queue where customer_id = :customer_id and customer_address_seq = :customer_address_seq";
			String deleteEditTrialDelta = "delete from edit_trail_delta where edit_trail_id in (select distinct edit_trail_id from edit_trail where customer_id = :customer_id and customer_address_seq = :customer_address_seq and table_enum = :table_enum)";
			String deleteEditTrail = "delete from edit_trail where customer_id = :customer_id and customer_address_seq = :customer_address_seq and table_enum = :table_enum";
			String deletecustomerAddressTickler = "delete from customer_address_tickler where customer_id = :customer_id and customer_address_seq = :customer_address_seq";
			String deleteMatchCode = "delete from customer_address_match_code where customer_id= :customer_id and customer_address_seq= :customer_address_seq and customer_match_code_id = :customer_match_code_id";
			String deleteCustomerAddress = "delete from customer_address where customer_id = :customer_id and customer_address_seq = :customer_address_seq";

			namedParameterJdbcTemplate.update(deleteEventQueue, parameters);
			namedParameterJdbcTemplate.update(deleteEditTrialDelta, parameters);
			namedParameterJdbcTemplate.update(deleteEditTrail, parameters);
			namedParameterJdbcTemplate.update(deletecustomerAddressTickler, parameters);
			namedParameterJdbcTemplate.update(deleteMatchCode, parameters);
			namedParameterJdbcTemplate.update(deleteCustomerAddress, parameters);

			return "Deleted";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public List<String> getEditEffevtiveReverseDate(Long customerId, int addressSeq) throws SQLException {
		LOGGER.info("Inside getEditEffevtiveReverseDate");
		List<String> effectivereverseDate = new ArrayList<String>();
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("customer_id", customerId);
			parameters.put("replace_customer_address_seq", 1);
			parameters.put("customer_address_seq", addressSeq);
			List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(
					"SELECT CONVERT(VARCHAR(10), effective_date,103) as effective_date,CONVERT(VARCHAR(10), reverse_date,103) as reverse_date,change_type FROM customer_address "
							+ "WHERE customer_id= :customer_id and replace_customer_address_seq = :replace_customer_address_seq and customer_address_seq != :customer_address_seq ORDER BY effective_date",
					parameters);

			for (Map<String, Object> row : rows) {
				effectivereverseDate
						.add(row.get("effective_date") + "-" + row.get("reverse_date") + "-" + row.get("change_type"));
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return effectivereverseDate;
	}

	@Override
	public String getdefaultAddressType() throws SQLException {
		String defaultAddressType = jdbcTemplate.queryForObject("select address_type from config", String.class);
		return defaultAddressType;
	}

	@Override
	public String getdefaultListRental() throws SQLException {
		String defaultListRental = jdbcTemplate.queryForObject("select list_rental_category from config", String.class);
		return defaultListRental;
	}

	@Override
	public String getdefaultAddressStatus() throws SQLException {
		String defaultAddressStatus = jdbcTemplate.queryForObject("select address_status from config", String.class);
		return defaultAddressStatus;
	}

	@Override
	public String getdefaultCreditStatus() throws SQLException {
		String defaultCreditStatus = jdbcTemplate.queryForObject("select credit_status from config", String.class);
		return defaultCreditStatus;
	}

	@Override
	public List<Object> getDuplicateRecord(CustomerAddAttributeModel customerAddAttributeModel) {

		LOGGER.info("Inside getDuplicateRecord");
		List<Object> duplicateRecords = new ArrayList<Object>();
		try {
			StringBuilder matchcode = customerUtility.getmatchCode(customerAddAttributeModel);
			StringBuilder query = new StringBuilder(
					"SELECT cd.customer_id,cd.fname,cd.lname,cd.company,cd.department,cd.address1,cd.city,cd.state,cd.zip FROM customer_match_code mc, customer_address_match_code ca , customer_address cd "
							+ "WHERE mc.customer_match_code_id = ca.customer_match_code_id and ca.customer_id=cd.customer_id and cd.customer_address_seq = 1 "
							+ "AND ((ca.customer_match_code_id = 2 and match_code ='" + matchcode + "'))"
							+ " ORDER BY customer_id,cd.customer_address_seq");
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> row : rows) {
				duplicateRecords.add(row);
			}
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return duplicateRecords;

	}

	@Override
	public List<DropdownModel> getpaymentThresholdList() throws SQLException {
		LOGGER.info("Inside getpaymentThresholdList");
		List<DropdownModel> paymentThresholdList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select payment_threshold,description from payment_threshold");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_threshold").toString());
				model.setDisplay(row.get("description").toString());
				paymentThresholdList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return paymentThresholdList;

	}

	@Override
	public List<Map<String, Object>> getDocumentReferenceDetailList(Long documentReferenceId) throws SQLException {
		LOGGER.info("Inside getDocumentReferenceDetailList");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("documentReferenceId", documentReferenceId);
		parameters.put("paymentSeq", 0);
		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(
				"SELECT * FROM view_edit_trail_batch WHERE document_reference_id = :documentReferenceId and payment_seq > :paymentSeq",
				parameters);
		return rows;
	}

	@Override
	public List<Map<String, Object>> getEditTrialList(Long editTrialId) throws SQLException {
		LOGGER.info("Inside getEditTrialList");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("editTrialId", editTrialId);
		List<Map<String, Object>> rows = namedParameterJdbcTemplate
				.queryForList("SELECT * FROM view_cs_edit_trail WHERE edit_trail_id = :editTrialId ", parameters);
		return rows;
	}

	@Override
	public Map<String, String> getTableHeaders(String tableName) throws SQLException {

		LOGGER.info("Inside getTableHeaders");
		Map<String, String> headers = new LinkedHashMap<String, String>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tableName", tableName);
		List<String> rows = namedParameterJdbcTemplate.queryForList(
				"SELECT name FROM sys.columns WHERE object_id = OBJECT_ID(:tableName) ", parameters, String.class);
		for (String row : rows) {
			headers.put(row.replace("_", " ").toUpperCase(), row);
		}
		return headers;
	}

	@Override
	public String clearAddInfo(Long customerId) throws SQLException {
		LOGGER.info("Inside clearAddInfo");
		String status = null;
		try {
			// Map<String, Object> parameters = new HashMap<String, Object>();

			Long orderCheck = jdbcTemplate.queryForObject(
					"select count(*) from order_item where order_status not in (1,2,3,4,6,14) and customer_id="
							+ customerId,
					Long.class);
			if (orderCheck == 0) {
				String updatequery = "update customer_address set state='CLEARED',city='CLEARED',zip = null,email = null,"
						+ "fname = null,lname = null,title=null,address_status='CLEARED',phone=null,"
						+ "company='CLEARED',address1='CLEARED',address2='CLEARED',address3='CLEARED' where"
						+ " customer_id=" + customerId;

				String updatequeryCust = "update customer set email = null,fname = null,lname = null,title=null,company='CLEARED',"
						+ "salutation= null,suffix=null,initial_name=null where customer_id=" + customerId;

				jdbcTemplate.update(updatequeryCust);
				jdbcTemplate.update(updatequery);

				status = "Cleared";
			} else {
				status = "Not Cleared";
			}

			// return "Updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			// return ERROR;
		}
		return status;
	}

	@Override
	public List<ProspectModel> getIsProspect() {
		List<ProspectModel> prospect = new ArrayList<>();
		ProspectModel prospectModel = new ProspectModel();
		try {
			prospectModel.setCustomerId("0");

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh.mm.ss aa");
			String formattedDate = dateFormat.format(new Date()).toString();

			prospectModel.setCreationDate(formattedDate);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			String formattedDate1 = dateFormat1.format(new Date()).toString();
			prospectModel.setQualDate(formattedDate1);
			prospectModel.setActiveProspect("1");

			prospect.add(prospectModel);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return prospect;
	}

	@Override
	public List<DropdownModel> getProspectCategory() {
		List<DropdownModel> prospectCategory = new ArrayList<>();
		try {
			List<Map<String, Object>> prospectCat = jdbcTemplate
					.queryForList(" select prospect_category,description from prospect_category ");
			for (Map<String, Object> prospect : prospectCat) {
				DropdownModel model = new DropdownModel();
				model.setKey(prospect.get("prospect_category").toString());
				model.setDisplay(prospect.get("description") != null ? prospect.get("description").toString() : "");
				prospectCategory.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return prospectCategory;
	}

	@Override
	public List<DropdownModel> getsetAsGroupMbr() {
		List<DropdownModel> grpMbr = new ArrayList<>();
		try {
			List<Map<String, Object>> grpMbr1 = jdbcTemplate
					.queryForList(" select customer_id,customer_group, description from customer_group ");
			for (Map<String, Object> grp : grpMbr1) {
				DropdownModel model = new DropdownModel();
				model.setKey(grp.get("customer_id").toString());
				model.setDisplay(grp.get("customer_group") != null ? grp.get("customer_group").toString() : "");
				model.setDescription(grp.get("description") != null ? grp.get("description").toString() : "");
				grpMbr.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return grpMbr;
	}
	
	
	
	public String convertEmailAuthorizationToBussinessProcessIntegerValues(String email_authorization)
	{
		List<Character> codeList1 = null;
		List<Character> codeList2 = null;
		List<Character> codeList3 = null;
		List<Character> codeList4 = null;
		List<Character> codeList5 = null;
		Map<Integer, Character> processCodeMap = new HashMap<Integer, Character>();
		if (null!=email_authorization) 
		{
			if (email_authorization.length() > 12) 
			{
				email_authorization = email_authorization.substring(0, 12);
			}
			email_authorization = email_authorization.substring(0, email_authorization.length() - 2);
			if (email_authorization.length() == 2) 
			{
				codeList1 = new ArrayList<Character>();
				String binaryNumber1 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization);
				for (int i = binaryNumber1.length() - 1; i >= 0; i--) 
				{
					codeList1.add(binaryNumber1.charAt(i));
				}
			} else if (email_authorization.length() == 4) 
			{
				codeList1 = new ArrayList<Character>();
				String binaryNumber1 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(0, 2));
				for (int i = binaryNumber1.length() - 1; i >= 0; i--) 
				{
					codeList1.add(binaryNumber1.charAt(i));
				}
				codeList2 = new ArrayList<Character>();
				String binaryNumber2 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(2, 4));
				for (int i = binaryNumber2.length() - 1; i >= 0; i--) 
				{
					codeList2.add(binaryNumber2.charAt(i));
				}
			} else if (email_authorization.length() == 6) 
			{
				codeList1 = new ArrayList<Character>();
				String binaryNumber1 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(0, 2));
				for (int i = binaryNumber1.length() - 1; i >= 0; i--) 
				{
					codeList1.add(binaryNumber1.charAt(i));
				}
				codeList2 = new ArrayList<Character>();
				String binaryNumber2 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(2, 4));
				for (int i = binaryNumber2.length() - 1; i >= 0; i--) 
				{
					codeList2.add(binaryNumber2.charAt(i));
				}
				codeList3 = new ArrayList<Character>();
				String binaryNumber3 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(4, 6));
				for (int i = binaryNumber3.length() - 1; i >= 0; i--) 
				{
					codeList3.add(binaryNumber3.charAt(i));
				}
			} else if (email_authorization.length() == 8) 
			{
				codeList1 = new ArrayList<Character>();
				String binaryNumber1 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(0, 2));
				for (int i = binaryNumber1.length() - 1; i >= 0; i--) 
				{
					codeList1.add(binaryNumber1.charAt(i));
				}
				codeList2 = new ArrayList<Character>();
				String binaryNumber2 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(2, 4));
				for (int i = binaryNumber2.length() - 1; i >= 0; i--) 
				{
					codeList2.add(binaryNumber2.charAt(i));
				}
				codeList3 = new ArrayList<Character>();
				String binaryNumber3 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(4, 6));
				for (int i = binaryNumber3.length() - 1; i >= 0; i--) 
				{
					codeList3.add(binaryNumber3.charAt(i));
				}
				codeList4 = new ArrayList<Character>();
				String binaryNumber4 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(6, 8));
				for (int i = binaryNumber4.length() - 1; i >= 0; i--) 
				{
					codeList4.add(binaryNumber4.charAt(i));
				}
			} else if (email_authorization.length() == 10) 
			{
				codeList1 = new ArrayList<Character>();
				String binaryNumber1 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(0, 2));
				for (int i = binaryNumber1.length() - 1; i >= 0; i--) 
				{
					codeList1.add(binaryNumber1.charAt(i));
				}
				codeList2 = new ArrayList<Character>();
				String binaryNumber2 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(2, 4));
				for (int i = binaryNumber2.length() - 1; i >= 0; i--) 
				{
					codeList2.add(binaryNumber2.charAt(i));
				}
				codeList3 = new ArrayList<Character>();
				String binaryNumber3 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(4, 6));
				for (int i = binaryNumber3.length() - 1; i >= 0; i--) 
				{
					codeList3.add(binaryNumber3.charAt(i));
				}
				codeList4 = new ArrayList<Character>();
				String binaryNumber4 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(6, 8));
				for (int i = binaryNumber4.length() - 1; i >= 0; i--) 
				{
					codeList4.add(binaryNumber4.charAt(i));
				}
				codeList5 = new ArrayList<Character>();
				String binaryNumber5 = EmailAuthorizationUtility.convertHexadecimalToBinary(email_authorization.substring(8, 10));
				for (int i = binaryNumber5.length() - 1; i >= 0; i--) 
				{
					codeList5.add(binaryNumber5.charAt(i));
				}
			}
			if (null != codeList1) 
			{
				int process = 0;
				for (int i = 0; i < codeList1.size(); i++) 
				{
					processCodeMap.put(process, codeList1.get(i));
					process++;
				}
			}
			if (null != codeList2) 
			{
				int process = 8;
				for (int i = 0; i < codeList2.size(); i++) 
				{
					processCodeMap.put(process, codeList2.get(i));
					process++;
				}
			}
			if (null != codeList3) 
			{
				int process = 16;
				for (int i = 0; i < codeList3.size(); i++) 
				{
					processCodeMap.put(process, codeList3.get(i));
					process++;
				}
			}
			if (null != codeList4) 
			{
				int process = 24;
				for (int i = 0; i < codeList4.size(); i++) 
				{
					processCodeMap.put(process, codeList4.get(i));
					process++;
				}
			}
			if (null != codeList5) 
			{
				int process = 32;
				for (int i = 0; i < codeList5.size(); i++) 
				{
					processCodeMap.put(process, codeList5.get(i));
					process++;
				}
			}
			String selectedBusinessProcess = "";
			Set<Entry<Integer, Character>> setOfprocessCodes = processCodeMap.entrySet();
			Iterator<Entry<Integer, Character>> itr = setOfprocessCodes.iterator();
			while (itr.hasNext()) 
			{
				Map.Entry<Integer, Character> entry = (Entry<Integer, Character>) itr.next();
				if (entry.getValue() == '1') 
				{
					selectedBusinessProcess = selectedBusinessProcess + entry.getKey() + ",";
				}
			}
			if (null != selectedBusinessProcess && !"".equals(selectedBusinessProcess)) 
			{
				email_authorization = selectedBusinessProcess.substring(0,selectedBusinessProcess.length() - 1);
			}
		}
		return email_authorization;
	}
	
	
		
	@Override
	public String retrieveEmailAuthorizationFromDataSource(Long customerId) 
	{
		LOGGER.info("Inside retrieveEmailAuthorizationFromDataSource");
		String email_authorization = null;
		try 
		{
			int customerId_count = jdbcTemplate.queryForObject("SELECT count(*) FROM customer WHERE customer_id=" + customerId + ";", Integer.class);
			if (customerId_count > 0) 
			{
				String email_authorization_query = "SELECT email_authorization FROM customer WHERE customer_id=?";
				email_authorization = jdbcTemplate.queryForObject(email_authorization_query,new Object[]{customerId}, String.class);
				if(email_authorization==null)
				{
					email_authorization=retrieveDefaultEmailAuthorizationFromDataSource();
				}else
				{
					email_authorization=convertEmailAuthorizationToBussinessProcessIntegerValues(email_authorization);
				}
			}else 
			{
				email_authorization = "Customer Id does not exist in database.";
			}
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			email_authorization = ERROR;
		}
		return email_authorization;
	}
	
	
	
	
	@Override
	public String retrieveDefaultEmailAuthorizationFromDataSource() 
	{
		LOGGER.info("Inside retrieveDefaultEmailAuthorizationFromDataSource");
		String default_email_authorization = null;
		try 
		{
				String email_authorization_query = "SELECT email_authorization FROM config;";
				default_email_authorization = jdbcTemplate.queryForObject(email_authorization_query,String.class);
				if(default_email_authorization==null)
				{
					default_email_authorization="No value selected by default.";
				}else
				{
					default_email_authorization=default_email_authorization+"00";
					default_email_authorization=convertEmailAuthorizationToBussinessProcessIntegerValues(default_email_authorization);
				}
		} catch (Exception e) 
		{
			e.printStackTrace();
			default_email_authorization = ERROR;
		}
		return default_email_authorization;
	}
	
	
	
	
	@Override
	public String updateEmailAuthorizationIntoDataSource(Long customerId, String business_processes) {
		LOGGER.info("Inside updateEmailAuthorizationIntoDataSource");
		String status = null;
		try 
		{
			String updateQuery = null;
			String sum1 = null, sum2 = null, sum3 = null, sum4 = null, sum5 = null;
			String finalHexadecimalResult = null;
			List<String> binaryEquivalentArrayList1 = new ArrayList<String>();
			List<String> binaryEquivalentArrayList2 = new ArrayList<String>();
			List<String> binaryEquivalentArrayList3 = new ArrayList<String>();
			List<String> binaryEquivalentArrayList4 = new ArrayList<String>();
			List<String> binaryEquivalentArrayList5 = new ArrayList<String>();
			if (null != business_processes && !"".equals(business_processes)&& !"0".equalsIgnoreCase(business_processes) && !"null".equals(business_processes)) 
			{
				String[] business_processes_array = business_processes.split(",");
				if (business_processes_array.length == 1) 
				{
					String business_process = new PropertyUtilityClass().getConstantValue(business_processes_array[0]);
					if (business_process != null && !"".equals(business_process)) 
					{
						updateQuery = "UPDATE customer set email_authorization=convert(VARBINARY(10),"+ business_process + ") where customer_id=" + customerId;
					}
				} else if (business_processes_array.length > 1) 
				{
					for (int i = 0; i < business_processes_array.length; i++) 
					{
						int business_processInt = Integer.parseInt(business_processes_array[i]);
						if (business_processInt >= 0 && business_processInt <= 7) 
						{
							int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
							binaryEquivalentArrayList1.add(Integer.toBinaryString(valueBasedOnLogic));
						} else if (business_processInt >= 8 && business_processInt <= 15) 
						{
							int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
							binaryEquivalentArrayList2.add(Integer.toBinaryString(valueBasedOnLogic));
						} else if (business_processInt >= 16 && business_processInt <= 23) 
						{
							int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
							binaryEquivalentArrayList3.add(Integer.toBinaryString(valueBasedOnLogic));
						} else if (business_processInt >= 24 && business_processInt <= 31) 
						{
							int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
							binaryEquivalentArrayList4.add(Integer.toBinaryString(valueBasedOnLogic));
						} else if (business_processInt >= 32 && business_processInt <= 39) 
						{
							int valueBasedOnLogic = EmailAuthorizationUtility.getValueBasedOnLogic(business_processInt);
							binaryEquivalentArrayList5.add(Integer.toBinaryString(valueBasedOnLogic));
						}
					}
					if (binaryEquivalentArrayList1.size() > 0) 
					{
						sum1 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList1);
						sum1 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum1);
						if (sum1.length() == 1) 
						{
							sum1 = "0" + sum1;
						}
					}
					if (binaryEquivalentArrayList2.size() > 0) 
					{
						sum2 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList2);
						sum2 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum2);
						if (sum2.length() == 1) 
						{
							sum2 = "0" + sum2;
						}
					}
					if (binaryEquivalentArrayList3.size() > 0) 
					{
						sum3 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList3);
						sum3 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum3);
						if (sum3.length() == 1) 
						{
							sum3 = "0" + sum3;
						}
					}
					if (binaryEquivalentArrayList4.size() > 0) 
					{
						sum4 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList4);
						sum4 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum4);
						if (sum4.length() == 1) 
						{
							sum4 = "0" + sum4;
						}
					}
					if (binaryEquivalentArrayList5.size() > 0) 
					{
						sum5 = "0" + EmailAuthorizationUtility.addBinaryNumbers(binaryEquivalentArrayList5);
						sum5 = EmailAuthorizationUtility.convertBinaryToHexadecimal(sum5);
						if (sum5.length() == 1) 
						{
							sum5 = "0" + sum5;
						}
					}
					if (null != sum1) 
					{
						finalHexadecimalResult = "0x" + sum1;
					} else 
					{
						finalHexadecimalResult = "0x" + "00";
					}
					if (null != sum2) {
						finalHexadecimalResult = finalHexadecimalResult + sum2;
					} else if (null != sum3 || null != sum4 || null != sum5) 
					{
						finalHexadecimalResult = finalHexadecimalResult + "00";
					}
					if (null != sum3) 
					{
						finalHexadecimalResult = finalHexadecimalResult + sum3;
					} else if (null != sum4 || null != sum5) 
					{
						finalHexadecimalResult = finalHexadecimalResult + "00";
					}
					if (null != sum4) 
					{
						finalHexadecimalResult = finalHexadecimalResult + sum4;
					} else if (null != sum5) 
					{
						finalHexadecimalResult = finalHexadecimalResult + "00";
					}
					if (null != sum5) 
					{
						finalHexadecimalResult = finalHexadecimalResult + sum5;
					}
					finalHexadecimalResult = finalHexadecimalResult + "00";
					updateQuery = "UPDATE customer set email_authorization=convert(VARBINARY(10),"+ finalHexadecimalResult + ") where customer_id=" + customerId;
				}
			} else 
			{
				updateQuery = "UPDATE customer set email_authorization=convert(VARBINARY(10),NULL) where customer_id="+customerId;
			}
			jdbcTemplate.update(updateQuery);
			status = "Email Authorization saved successfully.";
			long event_queue_id = customerUtility.getMaxEventQueueId() + 1;
			int eventQueueCount=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM event_queue WHERE event_queue_id="+event_queue_id+" AND customer_id="+customerId+" AND transaction_event=30 AND status=0;", Integer.class);
			if(eventQueueCount==0)
			{
				String creation_date = formatYYYYMMDDHHMMSS.format(new Date()) != null? "'" + formatYYYYMMDDHHMMSS.format(new Date()) + "'":"";
				String eventQueue = "INSERT INTO event_queue(event_queue_id,customer_id,transaction_event,status,creation_date)VALUES("+event_queue_id+","+customerId+",30,0,"+creation_date+");";
				jdbcTemplate.update(eventQueue);
				customerUtility.updateEventQueueId(event_queue_id);
			}
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	
	
	@Override
	public List<DistributorAccountsModel> retrieveDistributorAccountsListFromDataSource() {
		LOGGER.info("Inside retrieveDistributorAccountsListFromDataSource");
		String distributorsQuery = "SELECT * FROM distributor order by parent_distributor_id,company;";
		return jdbcTemplate.query(distributorsQuery, new ResultSetExtractor<List<DistributorAccountsModel>>() {
			@Override
			public List<DistributorAccountsModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<DistributorAccountsModel> distributorAccountsList = new ArrayList<DistributorAccountsModel>();
				while (rs.next()) {
					if (rs.getString("parent_distributor_id") == null) {

						DistributorAccountsModel distributorAccountsModel = new DistributorAccountsModel();
						distributorAccountsModel.setCustomer_id(rs.getLong("customer_id"));
						distributorAccountsModel.setUrl(rs.getString("url"));
						distributorAccountsModel
								.setDistributor_report_prefix(rs.getString("distributor_report_prefix"));
						distributorAccountsModel.setParent_distributor_id(rs.getString("parent_distributor_id"));
						distributorAccountsModel.setCompany(rs.getString("company"));
						// distributorAccountsModel.setTitle(rs.getString("company"));

						distributorAccountsList.add(distributorAccountsModel);
					}
				}
				return distributorAccountsList;
			}
		});
	}

	@Override
	public String updateDistributorInfoIntoDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside updateDistributorInfoIntoDataSource");
		String distributor = customerUtility.getStringValue(customerAddAttributeModel.getDistributor()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getDistributor()) + "'"
				: null;
		String distributorURL = customerUtility.getStringValue(customerAddAttributeModel.getDistributorURL()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getDistributorURL()) + "'"
				: null;
		String reportPrefix = customerUtility.getStringValue(customerAddAttributeModel.getReportPrefix()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getReportPrefix()) + "'"
				: null;
		String status = null;
		try {
			String updateQuery = "UPDATE distributor SET url=" + distributorURL + ",distributor_report_prefix="
					+ reportPrefix + ",company=" + distributor + " where customer_id="
					+ customerAddAttributeModel.getCustomerId();
			int updatestatus = jdbcTemplate.update(updateQuery);
			if (updatestatus > 0) {
				status = "Distributor Info saved successfully.";
			} else {
				status = "Customer Id does not exist.";
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public String addDistributorReportIntoDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside addDistributorReportIntoDataSource");
		Long customer_id = customerAddAttributeModel.getCustomerId();
		int distributor_report_type = customerAddAttributeModel.getReportType();
		int report_format = customerAddAttributeModel.getFormat();
		int file_type = customerAddAttributeModel.getFileType();
		int transmission_mode = customerAddAttributeModel.getTransmitBy();
		String report = customerUtility.getStringValue(customerAddAttributeModel.getOutput()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getOutput()) + "'"
				: null;
		String file_prefix = customerUtility.getStringValue(customerAddAttributeModel.getFilePrefix()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getFilePrefix()) + "'"
				: null;
		String file_name = customerUtility.getStringValue(customerAddAttributeModel.getFileName()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getFileName()) + "'"
				: null;
		String status = null;
		try {
			int distributor_report_type_count = jdbcTemplate
					.queryForObject("SELECT count(*) from distributor_report WHERE customer_id=" + customer_id
							+ " AND distributor_report_type=" + distributor_report_type + ";", Integer.class);
			if (distributor_report_type_count == 0) {
				String addDistributorQuery = "INSERT INTO distributor_report(customer_id,distributor_report_type,report_format,file_type,file_prefix,file_name,transmission_mode,report)VALUES"
						+ "(" + customer_id + "," + distributor_report_type + "," + report_format + "," + file_type
						+ "," + file_prefix + "," + file_name + "," + transmission_mode + "," + report + ")";
				int insertstatus = jdbcTemplate.update(addDistributorQuery);
				if (insertstatus > 0) {
					status = "Distributor Report added successfully.";
				}
			} else {
				status = "Duplicate Distributor Report Type (reportType) cannot be added.";
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public String deleteDistributorReportFromDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside deleteDistributorReportFromDataSource");
		Long customer_id = customerAddAttributeModel.getCustomerId();
		int distributor_report_type = customerAddAttributeModel.getReportType();
		String status = null;
		try {
			int distributor_report_type_count = jdbcTemplate
					.queryForObject("SELECT count(*) from distributor_report WHERE customer_id=" + customer_id
							+ " AND distributor_report_type=" + distributor_report_type + ";", Integer.class);
			if (distributor_report_type_count > 0) {
				String deleteDistributorQuery = "Delete from distributor_report WHERE customer_id=" + customer_id
						+ " AND distributor_report_type=" + distributor_report_type + ";";
				int deletestatus = jdbcTemplate.update(deleteDistributorQuery);
				if (deletestatus > 0) {
					status = "Distributor Report deleted successfully.";
				}
			} else {
				status = "Distributor Report Type (reportType) does not exist.";
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public List<DistributorReportModel> retrieveDistributorReportsListFromDataSource(Long customer_id) {
		LOGGER.info("Inside retrieveDistributorReportsListFromDataSource");
		String distributorReportsQuery = "SELECT customer_id,distributor_report_type,report_format,file_type,file_prefix,file_name,transmission_mode,report"
				+ " FROM distributor_report where customer_id=" + customer_id + ";";
		return jdbcTemplate.query(distributorReportsQuery, new ResultSetExtractor<List<DistributorReportModel>>() {
			@Override
			public List<DistributorReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<DistributorReportModel> distributorReportsList = new ArrayList<DistributorReportModel>();
				while (rs.next()) {
					DistributorReportModel distributorReportModel = new DistributorReportModel();
					distributorReportModel.setCustomer_id(rs.getLong("customer_id"));
					distributorReportModel.setReportType(new PropertyUtilityClass()
							.getConstantValue("distributor_report_type_" + rs.getInt("distributor_report_type")));
					distributorReportModel.setFormat(
							new PropertyUtilityClass().getConstantValue("report_format_" + rs.getInt("report_format")));
					distributorReportModel.setFileType(
							new PropertyUtilityClass().getConstantValue("file_type_" + rs.getInt("file_type")));
					distributorReportModel.setTransmitBy(new PropertyUtilityClass()
							.getConstantValue("transmission_mode_" + rs.getInt("transmission_mode")));
					distributorReportModel.setFilePrefix(rs.getString("file_prefix"));
					distributorReportModel.setFileName(rs.getString("file_name"));
					distributorReportModel.setOutput(rs.getString("report"));

					distributorReportsList.add(distributorReportModel);
				}
				return distributorReportsList;
			}
		});
	}

	@Override
	public String updateDistributorReportInDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside updateDistributorReportInDataSource");
		Long customer_id = customerAddAttributeModel.getCustomerId();
		int report_type_new = customerAddAttributeModel.getReportType();
		int report_format = customerAddAttributeModel.getFormat();
		int file_type = customerAddAttributeModel.getFileType();
		int transmission_mode = customerAddAttributeModel.getTransmitBy();
		String report = customerUtility.getStringValue(customerAddAttributeModel.getOutput()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getOutput()) + "'"
				: null;
		String file_prefix = customerUtility.getStringValue(customerAddAttributeModel.getFilePrefix()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getFilePrefix()) + "'"
				: null;
		String file_name = customerUtility.getStringValue(customerAddAttributeModel.getFileName()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getFileName()) + "'"
				: null;
		int report_type_old = customerAddAttributeModel.getReportTypeOld();
		String status = null;
		try {
			int old_distributor_report_type_count = jdbcTemplate
					.queryForObject("SELECT count(*) from distributor_report WHERE customer_id=" + customer_id
							+ " AND distributor_report_type=" + report_type_old + ";", Integer.class);
			if (report_type_new != report_type_old) {
				if (old_distributor_report_type_count == 0) {
					status = "Old Distributor Report Type (reportTypeOld) does not exist.";
				} else {
					int new_distributor_report_type_count = jdbcTemplate
							.queryForObject("SELECT count(*) from distributor_report WHERE customer_id=" + customer_id
									+ " AND distributor_report_type=" + report_type_new + ";", Integer.class);
					if (new_distributor_report_type_count == 0) {
						String updateDistributorQuery = "UPDATE distributor_report SET distributor_report_type="
								+ report_type_new + ",report_format=" + report_format + ",file_type=" + file_type + ","
								+ "file_prefix=" + file_prefix + ",file_name=" + file_name + ",transmission_mode="
								+ transmission_mode + ",report=" + report + "" + " WHERE customer_id=" + customer_id
								+ " AND distributor_report_type=" + report_type_old + ";";
						int updatestatus = jdbcTemplate.update(updateDistributorQuery);
						if (updatestatus > 0) {
							status = "Distributor Report updated successfully.";
						}
					} else {
						status = "Duplicate Distributor Report Type (reportType) is not allowed.";
					}
				}
			} else {
				if (old_distributor_report_type_count == 0) {
					status = "Old Distributor Report Type (reportTypeOld) does not exist.";
				} else {
					String updateDistributorQuery = "UPDATE distributor_report SET distributor_report_type="
							+ report_type_new + ",report_format=" + report_format + ",file_type=" + file_type + ","
							+ "file_prefix=" + file_prefix + ",file_name=" + file_name + ",transmission_mode="
							+ transmission_mode + ",report=" + report + "" + " WHERE customer_id=" + customer_id
							+ " AND distributor_report_type=" + report_type_old + ";";
					int updatestatus = jdbcTemplate.update(updateDistributorQuery);
					if (updatestatus > 0) {
						status = "Distributor Report updated successfully.";
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public List<DistributorAttributeSetUpModel> retrieveDistributorAttributeSetUpDataFromDataSource() {
		LOGGER.info("Inside retrieveDistributorAttributeSetUpDataFromDataSource");
		String distributorAttributeQuery = "SELECT distribution_method,distribution_attribute FROM dist_method_segment ORDER BY distribution_method;";
		return jdbcTemplate.query(distributorAttributeQuery,
				new ResultSetExtractor<List<DistributorAttributeSetUpModel>>() {
					@Override
					public List<DistributorAttributeSetUpModel> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<DistributorAttributeSetUpModel> distributorAttributeSetUpDataList = new ArrayList<DistributorAttributeSetUpModel>();
						int count = 0;
						while (rs.next()) {
							DistributorAttributeSetUpModel distributorAttributeSetUpModel = new DistributorAttributeSetUpModel();
							distributorAttributeSetUpModel.setKey(count);
							distributorAttributeSetUpModel.setMethod(rs.getString("distribution_method"));
							distributorAttributeSetUpModel.setAttribute(rs.getString("distribution_attribute"));
							String valuesQuery = "SELECT dist_attribute_value FROM dist_attribute_value"
									+ " WHERE distribution_attribute='" + rs.getString("distribution_attribute") + "';";
							List<String> distributorValuesList = jdbcTemplate.queryForList(valuesQuery, String.class);
							List<DistributorValue> distributorValuesFinalList = new ArrayList<DistributorValue>();
							for (int i = 0; i < distributorValuesList.size(); i++) {
								DistributorValue distributorValue = new DistributorValue();
								distributorValue.setDistributorValue(distributorValuesList.get(i));
								distributorValuesFinalList.add(distributorValue);
							}
							distributorAttributeSetUpModel.setDistributorValue(distributorValuesFinalList);
							distributorAttributeSetUpDataList.add(distributorAttributeSetUpModel);
							count++;
						}
						return distributorAttributeSetUpDataList;
					}
				});
	}

	@Override
	public List<DistributorAttributeSetUpModel> retrieveDistributorAttributeFromDataSource(Long customer_id) {
		LOGGER.info("Inside retrieveDistributorAttributeFromDataSource");
		String distributorAttributeQuery = "SELECT distribution_method,distribution_attribute"
				+ " FROM distributor_dist_attribute where customer_id=" + customer_id
				+ " ORDER BY distribution_method;";
		return jdbcTemplate.query(distributorAttributeQuery,
				new ResultSetExtractor<List<DistributorAttributeSetUpModel>>() {
					@Override
					public List<DistributorAttributeSetUpModel> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<DistributorAttributeSetUpModel> distributorAttributeSetUpDataList = new ArrayList<DistributorAttributeSetUpModel>();
						int count = 0;
						while (rs.next()) {
							DistributorAttributeSetUpModel distributorAttributeSetUpModel = new DistributorAttributeSetUpModel();
							distributorAttributeSetUpModel.setKey(count);
							distributorAttributeSetUpModel.setMethod(rs.getString("distribution_method"));
							distributorAttributeSetUpModel.setAttribute(rs.getString("distribution_attribute"));

							String valuesQuery = "SELECT dist_attribute_value FROM dist_attribute_value"
									+ " WHERE distribution_attribute='" + rs.getString("distribution_attribute") + "';";

							List<String> distributorValuesList = jdbcTemplate.queryForList(valuesQuery, String.class);
							List<DistributorValue> distributorValuesFinalList = new ArrayList<DistributorValue>();
							for (int i = 0; i < distributorValuesList.size(); i++) {
								DistributorValue distributorValue = new DistributorValue();
								distributorValue.setDistributorValue(distributorValuesList.get(i));
								distributorValuesFinalList.add(distributorValue);
							}
							distributorAttributeSetUpModel.setDistributorValue(distributorValuesFinalList);
							distributorAttributeSetUpDataList.add(distributorAttributeSetUpModel);
							count++;
						}
						return distributorAttributeSetUpDataList;
					}
				});
	}

	@Override
	public String deleteDistributorAttributeFromDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside deleteDistributorAttributeFromDataSource");
		Long customer_id = customerAddAttributeModel.getCustomerId();
		String method = customerUtility.getStringValue(customerAddAttributeModel.getMethod()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getMethod()) + "'"
				: null;
		String attribute = customerUtility.getStringValue(customerAddAttributeModel.getAttribute()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAttribute()) + "'"
				: null;
		String status = null;
		try {
			int distributor_attribute_count = jdbcTemplate.queryForObject(
					"SELECT count(*) from distributor_dist_attribute WHERE customer_id=" + customer_id
							+ " AND distribution_method=" + method + " AND distribution_attribute=" + attribute + ";",
					Integer.class);
			if (distributor_attribute_count > 0) {
				String deleteDistributorQuery = "Delete from distributor_dist_attribute WHERE customer_id="
						+ customer_id + " AND distribution_method=" + method + " AND distribution_attribute="
						+ attribute + ";";
				int deletestatus = jdbcTemplate.update(deleteDistributorQuery);
				if (deletestatus > 0) {
					status = "Distributor Attribute deleted successfully.";
				}
			} else {
				status = "Distributor Attribute (combination of method & attribute) does not exist.";
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public String addDistributorAttributeIntoDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside addDistributorAttributeIntoDataSource");
		Long customer_id = customerAddAttributeModel.getCustomerId();
		String method = customerUtility.getStringValue(customerAddAttributeModel.getMethod()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getMethod()) + "'"
				: null;
		String attribute = customerUtility.getStringValue(customerAddAttributeModel.getAttribute()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAttribute()) + "'"
				: null;
		String status = null;
		try {
			int distributor_attribute_count = jdbcTemplate.queryForObject(
					"SELECT count(*) from distributor_dist_attribute WHERE customer_id=" + customer_id
							+ " AND distribution_method=" + method + " AND distribution_attribute=" + attribute + ";",
					Integer.class);
			if (distributor_attribute_count == 0) {
				String addAttributeQuery = "INSERT INTO distributor_dist_attribute(customer_id,distribution_method,distribution_attribute)VALUES"
						+ "(" + customer_id + "," + method + "," + attribute + ")";
				int insertstatus = jdbcTemplate.update(addAttributeQuery);
				if (insertstatus > 0) {
					status = "Distributor Attribute added successfully.";
				}
			} else {
				status = "Duplicate Distributor Attribute (combination of method & attribute) cannot be added.";
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public String updateDistributorAttributeInDataSource(CustomerAddAttributeModel customerAddAttributeModel) {
		LOGGER.info("Inside updateDistributorAttributeInDataSource");
		Long customer_id = customerAddAttributeModel.getCustomerId();
		String method_new = customerUtility.getStringValue(customerAddAttributeModel.getMethod()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getMethod()) + "'"
				: null;
		String attribute_new = customerUtility.getStringValue(customerAddAttributeModel.getAttribute()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getAttribute()) + "'"
				: null;
		String old_method = customerUtility.getStringValue(customerAddAttributeModel.getOld_method()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getOld_method()) + "'"
				: null;
		String old_attribute = customerUtility.getStringValue(customerAddAttributeModel.getOld_attribute()) != null
				? "'" + customerUtility.getStringValue(customerAddAttributeModel.getOld_attribute()) + "'"
				: null;
		String status = null;
		String new_values_included = null;
		String old_values_included = null;
		try {
			if (null != method_new && null != attribute_new) {
				new_values_included = customerAddAttributeModel.getMethod().trim() + " & "
						+ customerAddAttributeModel.getAttribute().trim();
			}
			if (null != old_method && null != old_attribute) {
				old_values_included = customerAddAttributeModel.getOld_method().trim() + " & "
						+ customerAddAttributeModel.getOld_attribute().trim();
			}
			int old_distributor_attribute_count = jdbcTemplate
					.queryForObject("SELECT count(*) from distributor_dist_attribute WHERE customer_id=" + customer_id
							+ " AND distribution_method=" + old_method + " AND distribution_attribute=" + old_attribute
							+ ";", Integer.class);
			if (old_distributor_attribute_count == 0) {
				status = "Combination of old Distributor Method & Attribute (old_method & old_attribute) does not exist.";
			} else {
				if (!new_values_included.equalsIgnoreCase(old_values_included)) {
					int distributor_attribute_count = jdbcTemplate
							.queryForObject("SELECT count(*) from distributor_dist_attribute WHERE customer_id="
									+ customer_id + " AND distribution_method=" + method_new
									+ " AND distribution_attribute=" + attribute_new + ";", Integer.class);
					if (distributor_attribute_count == 0) {
						String updateDistributorQuery = "UPDATE distributor_dist_attribute"
								+ " SET distribution_method=" + method_new + ",distribution_attribute=" + attribute_new
								+ "" + " WHERE customer_id=" + customer_id + " AND distribution_method=" + old_method
								+ "" + " AND distribution_attribute=" + old_attribute + ";";
						int updatestatus = jdbcTemplate.update(updateDistributorQuery);
						if (updatestatus > 0) {
							status = "Distributor Attribute updated successfully.";
						}
					} else {
						status = "Combination of duplicate distributor method & attribute is not allowed.";
					}
				} else {
					if (old_distributor_attribute_count == 0) {
						status = "Combination of old Distributor Method & Attribute (old_method & old_attribute) does not exist.";
					} else {
						String updateDistributorQuery = "UPDATE distributor_dist_attribute"
								+ " SET distribution_method=" + method_new + ",distribution_attribute=" + attribute_new
								+ "" + " WHERE customer_id=" + customer_id + " AND distribution_method=" + old_method
								+ "" + " AND distribution_attribute=" + old_attribute + ";";
						int updatestatus = jdbcTemplate.update(updateDistributorQuery);
						if (updatestatus > 0) {
							status = "Distributor Attribute updated successfully.";
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	@Override
	public List<DistributorChildModel> getDistributorAccount(String customerId) {

		String distributorAccountQuery = "select *from distributor where parent_distributor_id=" + customerId;

		return jdbcTemplate.query(distributorAccountQuery, new ResultSetExtractor<List<DistributorChildModel>>() {
			@Override
			public List<DistributorChildModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<DistributorChildModel> distributorAccChildList = new ArrayList<DistributorChildModel>();
				int i = 1;
				while (rs.next()) {

					DistributorChildModel distributorAccChildModel = new DistributorChildModel();
					distributorAccChildModel.setId(i++);
					distributorAccChildModel.setTitle(rs.getString("company"));

					distributorAccChildModel.setCustomerId(rs.getLong("customer_id"));
					DistributorAccountsModel distributorAccountsModel = new DistributorAccountsModel();
					distributorAccountsModel.setCustomer_id(rs.getLong("customer_id"));
					distributorAccountsModel.setUrl(rs.getString("url"));
					distributorAccountsModel.setDistributor_report_prefix(rs.getString("distributor_report_prefix"));
					distributorAccountsModel.setParent_distributor_id(rs.getString("parent_distributor_id"));
					distributorAccountsModel.setCompany(rs.getString("company"));

					distributorAccChildModel.setData(distributorAccountsModel);
					distributorAccChildModel
							.setHasChild(hasChild(distributorAccountsModel.getCustomer_id().toString()));
					if (distributorAccChildModel.isHasChild()) {

						// distributorAccChildModel.setNodes(distributorAccChildList);
						distributorAccChildModel
								.setNodes(getDistributorAccount(distributorAccountsModel.getCustomer_id().toString()));
					}
					distributorAccChildList.add(distributorAccChildModel);
				}

				return distributorAccChildList;
			}
		});
		/*
		 * return jdbcTemplate.query( distributorAccountQuery,new
		 * ResultSetExtractor<List< DistributorChildModel>>() {
		 * 
		 * @Override public List<DistributorAccountsModel> extractData(ResultSet rs)
		 * throws SQLException,DataAccessException { List<DistributorAccountsModel>
		 * distributorAccountsList=new ArrayList<DistributorAccountsModel>();
		 * while(rs.next()) {
		 * 
		 * DistributorAccountsModel distributorAccountsModel=new
		 * DistributorAccountsModel();
		 * distributorAccountsModel.setCustomer_id(rs.getLong("customer_id"));
		 * distributorAccountsModel.setUrl(rs.getString("url"));
		 * distributorAccountsModel.setDistributor_report_prefix(rs.getString(
		 * "distributor_report_prefix"));
		 * distributorAccountsModel.setParent_distributor_id(rs.getString(
		 * "parent_distributor_id"));
		 * distributorAccountsModel.setCompany(rs.getString("company"));
		 * //distributorAccountsModel.setTitle(rs.getString("company"));
		 * distributorAccountsList.add(distributorAccountsModel);
		 * 
		 * } return distributorAccountsList; } });
		 */
	}

	@Override
	public List<DistributorChildModel> getDistributorAccChildList() {

		LOGGER.info("Inside retrieveDistributorAccountsListFromDataSource");
		String distributorsQuery = "SELECT * FROM distributor order by parent_distributor_id,company;";

		return jdbcTemplate.query(distributorsQuery, new ResultSetExtractor<List<DistributorChildModel>>() {
			@Override
			public List<DistributorChildModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<DistributorChildModel> distributorAccChildList = new ArrayList<DistributorChildModel>();
				int i = 1;
				while (rs.next()) {
					if (rs.getString("parent_distributor_id") == null) {

						DistributorChildModel distributorAccChildModel = new DistributorChildModel();
						distributorAccChildModel.setId(i++);
						distributorAccChildModel.setTitle(rs.getString("company"));
						distributorAccChildModel.setCustomerId(rs.getLong("customer_id"));

						DistributorAccountsModel distributorAccountsModel = new DistributorAccountsModel();
						distributorAccountsModel.setCustomer_id(rs.getLong("customer_id"));
						distributorAccountsModel.setUrl(rs.getString("url"));
						distributorAccountsModel
								.setDistributor_report_prefix(rs.getString("distributor_report_prefix"));
						distributorAccountsModel.setParent_distributor_id(rs.getString("parent_distributor_id"));
						distributorAccountsModel.setCompany(rs.getString("company"));

						distributorAccChildModel.setData(distributorAccountsModel);
						distributorAccChildModel
								.setHasChild(hasChild(distributorAccountsModel.getCustomer_id().toString()));
						if (distributorAccChildModel.isHasChild()) {

							// distributorAccChildModel.setNodes(distributorAccChildList);
							distributorAccChildModel.setNodes(
									getDistributorAccount(distributorAccountsModel.getCustomer_id().toString()));
						}
						distributorAccChildList.add(distributorAccChildModel);
					}

				}
				return distributorAccChildList;
			}
		});

	}

	public boolean hasChild(String customerId) {
		boolean flag = false;
		String Query = "select count(*) from  distributor where parent_distributor_id=" + customerId;
		int count = jdbcTemplate.queryForObject(Query, Integer.class);
		if (count > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Map<String, Object>> getDistAccountDetails(String customerId) {

		List<Map<String, Object>> DistAccDetails = new ArrayList<>();
		try {

			// DistAccDetails= jdbcTemplate.queryForList("select *from distributor where
			// customer_id="+customerId);
			DistAccDetails = jdbcTemplate.queryForList("select d.customer_id," + "d.url,"
					+ "d.distributor_report_prefix," + "d.parent_distributor_id," + "d.company as distributorname,"
					+ "d.row_version,"
					+ "d1.company as parentname from distributor d left outer JOIN distributor d1 on d.parent_distributor_id =d1.customer_id  where d.customer_id="
					+ customerId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return DistAccDetails;

	}

	@Override
	public List<DistributorReportOutputOptionsModel> retrieveDistributorReportGridOutputOptionsDataFromDataSource() {
		LOGGER.info("Inside retrieveDistributorReportGridOutputOptionsDataFromDataSource");
		String distributorReportOutputOptionsQuery = "SELECT report,description FROM report;";
		return jdbcTemplate.query(distributorReportOutputOptionsQuery,
				new ResultSetExtractor<List<DistributorReportOutputOptionsModel>>() {
					@Override
					public List<DistributorReportOutputOptionsModel> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<DistributorReportOutputOptionsModel> distributorReportOutputOptionsList = new ArrayList<DistributorReportOutputOptionsModel>();
						while (rs.next()) {
							DistributorReportOutputOptionsModel distributorReportOutputOptionsModel = new DistributorReportOutputOptionsModel();
							distributorReportOutputOptionsModel.setOutput(rs.getString("report"));
							distributorReportOutputOptionsModel.setDescription(rs.getString("description"));
							distributorReportOutputOptionsList.add(distributorReportOutputOptionsModel);
						}
						return distributorReportOutputOptionsList;
					}
				});
	}
	
	@Override
	public List<Map<String, Object>> getMatchCodes(int customerId, int customerAddressSeq){
		List<Map<String, Object>> matchCodesDetail = null;
		try {
			StringBuilder query = new StringBuilder(" select match_code,description,customer_address_seq,camc.customer_match_code_id,customer_id,'' as row_version,'0' as blpc_valid from customer_address_match_code camc left join customer_match_code cmc on cmc.customer_match_code_id = camc.customer_match_code_id WHERE customer_id="+ customerId +" and customer_address_seq="+ customerAddressSeq +" ORDER BY customer_id,customer_address_seq,customer_match_code_id ");
			matchCodesDetail = jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return matchCodesDetail;
	}

	@Override
	public List<Map<String, Object>> getfuterTempAddress(Long customerId) {
		List<Map<String,Object>> futureTempAddress=new ArrayList<>();
		try {
			futureTempAddress=jdbcTemplate.queryForList("select customer_address_seq,effective_date,(CASE WHEN (change_type IS NULL) THEN 'Temporary' when change_type=0 THEN 'Temporary' when change_type=1 THEN 'Future' END) as change_type  from customer_address  where customer_id="+customerId);
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return futureTempAddress;
	}
	
}