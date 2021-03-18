package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.PaymentAccountModel;
import com.mps.think.process.util.PropertyUtility;
import com.mps.think.service.CancelOrderService;
import com.mps.think.service.CustomerSearchService;
import com.mps.think.service.PaymentAccountService;
import com.mps.think.util.CustomerUtility;

@RestController
@Scope("request")
public class PaymentAccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentAccountController.class);

	@Autowired
	PaymentAccountService paymentAccountService;
	@Autowired
	CancelOrderService cancelOrderService;

	@Autowired
	CustomerSearchService customerSearchService;
	@Autowired
	JdbcTemplate jdbcTemplate;

	// *******************************************************
	@PostConstruct
	public void init() {
		try {
			CustomerUtility customerUtility = new CustomerUtility();
			customerUtility.runTruncate(jdbcTemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// *******************************************************

	@RequestMapping(path = "/paymentAccountList", method = RequestMethod.POST)
	public Map<String, Object> paymentAccountList(@RequestParam("customerId") Long customerId) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> paymentAccountList = paymentAccountService.getpaymentAccountList(customerId);
			responseObject.put("paymentAccountList", paymentAccountList);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/addAccountType", method = RequestMethod.POST)
	public Map<String, Object> addAccountType() {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Map<String, String> paymentAccountTypeList = new HashMap<String, String>();
			paymentAccountTypeList.put("CreditCard", "Credit Card");
			paymentAccountTypeList.put("DirectDebit", "Direct Debit");
			paymentAccountTypeList.put("Token", " Secure 'token' for creditcard (an existing token from your gateway)");
			responseObject.put("paymentAccountTypeList", paymentAccountTypeList);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/addAccountDetail", method = RequestMethod.POST)
	public Map<String, Object> addAccountDetail(@RequestParam("customerId") Long customerId,
			@RequestParam("paymentAccountType") String paymentAccountType) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			PaymentAccountModel paymentAccountModel = new PaymentAccountModel();
			paymentAccountModel.setCustomerId(customerId);
			if ("DirectDebit".equals(paymentAccountType)) {
				List<DropdownModel> paymentTypeList = new ArrayList<>();
				paymentTypeList.add(new DropdownModel("DD", "Direct Debit", null, null, null, null));
				paymentAccountModel.setPaymentTypeList(paymentTypeList);
				paymentAccountModel.setBankSateList(customerSearchService.getStateList());

			} else {
				paymentAccountModel.setCardHolder(cancelOrderService.getCustomerName(customerId));
				paymentAccountModel.setCardNameId(customerId);
				paymentAccountModel.setPaymentTypeList(paymentAccountService.getpaymentTypeList());
				paymentAccountService.getCardAddress(customerId, paymentAccountModel);
				paymentAccountModel.setAddressList(paymentAccountService.getaddressList(customerId));

			}

			responseObject.put("paymentAccountModel", paymentAccountModel);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/getAddressList", method = RequestMethod.POST)
	public Map<String, Object> searchCardHolder(@RequestParam("customerId") Long customerId) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> addressList = paymentAccountService.getaddressList(customerId);
			responseObject.put("addressList", addressList);
			PaymentAccountModel paymentAccountModel = new PaymentAccountModel();
			paymentAccountService.getCardAddress(customerId, paymentAccountModel);
			responseObject.put("defaultAddressSeq", paymentAccountModel.getDefaultAddressSeq());
			// responseObject.put("cardAddress", paymentAccountModel.getCardAddress());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/savePaymentAccount", method = RequestMethod.POST)
	public Map<String, Object> savePaymentAccount(PaymentAccountModel paymentAccountModel) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String addStatus = paymentAccountService.addPaymentAccount(paymentAccountModel);
			if ("added".equals(addStatus))
				responseObject.put(STATUS, SUCCESS);
			else {
				responseObject.put(STATUS, addStatus);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getPaymentAccountDetails", method = RequestMethod.POST)

	public Map<String, Object> getPaymentAccountDetails(@RequestParam("customerId") Long customerId,
			@RequestParam("payment_account_seq") int payment_account_seq, String paymentAccountType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			PaymentAccountModel paymentAccountModel = paymentAccountService.getPaymentAccountDetails(customerId,
					payment_account_seq);

			if (paymentAccountModel.getPaymentType().equals("DirectDebit")
					|| paymentAccountModel.getPaymentType().equals("DD")) {

				LOGGER.info("updating direct debit");
				List<DropdownModel> paymentTypeList = new ArrayList<>();
				paymentTypeList.add(new DropdownModel("DD", "Direct Debit", null, null, null, null));

				paymentAccountModel.setPaymentTypeList(paymentTypeList);
				paymentAccountModel.setBankSateList(customerSearchService.getStateList());
				// paymentAccountModel.setAddressList(paymentAccountService.getaddressList(customerId));

				// responseObject.put("bankstateList", customerSearchService.getStateList());

			} else {

				paymentAccountModel.setPaymentTypeList(paymentAccountService.getpaymentTypeList());
				// paymentAccountModel.setBankSateList(customerSearchService.getStateList());
				paymentAccountModel.setAddressList(paymentAccountService.getaddressList(customerId));

			}
			responseObject.put("paymentAccountModel", paymentAccountModel);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updatePaymentAccountDetails", method = RequestMethod.POST)

	public Map<String, Object> updatePaymentAccountDetails(PaymentAccountModel paymentAccountModel,
			int paymentAccountSeq) {
		LOGGER.info("updating payment seq:{}", paymentAccountSeq);
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = paymentAccountService.updatePaymentAccountDetails(paymentAccountModel, paymentAccountSeq);

			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(value = "/clearPaymentAccount", method = RequestMethod.POST)

	public @ResponseBody Map<String, Object> clearPaymentAccount(@RequestParam("customerId") Long customerId,
			@RequestParam("payment_account_seq") int paymentAccountSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String clearPaymentAccount = paymentAccountService.clearPaymentAccount(customerId, paymentAccountSeq);
			if (clearPaymentAccount.equals("accountcleared")) {
				responseObject.put("clearPaymentAccount", clearPaymentAccount);
				responseObject.put(STATUS, SUCCESS);
			} else {
				responseObject.put("clearPaymentAccount", clearPaymentAccount);
				responseObject.put(STATUS, false);

			}

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/creditCardToggleEnableddisabled", method = RequestMethod.POST)
	public Map<String, Object> creditCardToggleEnableddisabled() {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Integer creditCardToggleValue = paymentAccountService.getCreditToggleValue();
			responseObject.put("creditCardToggleValue", creditCardToggleValue);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/bankWizardToggleEnableddisabled", method = RequestMethod.POST)
	public Map<String, Object> bankWizardToggleEnableddisabled() {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Integer bankWizardToggleValue = paymentAccountService.getBankWizardToggleValue();
			responseObject.put("bankWizardToggleValue", bankWizardToggleValue);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/paymentAccountDropdown", method = RequestMethod.POST)
	public Map<String, Object> getPaymentAccountDropdownList(Long customerId, Integer active, String action) {
		Map<String, Object> responseObject = new HashMap<>();
		try {
			switch (action.toLowerCase()) {
			case "credit":
				responseObject.put("creditAccount", paymentAccountService.getCreditAccountList(customerId, active));
				break;
			case "debit":
				responseObject.put("debitAccount", paymentAccountService.getDebitAccountList(customerId, active));
				break;
			default:
				break;
			}
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	
	@RequestMapping(path = "/creditCardValidations", method = RequestMethod.POST)
	public Map<String, Object> creditCardValidations(String CardNumber) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Map<String, Object> creditCardType = new HashMap<>();
			String cardNumber = CardNumber.replaceAll("\\s+", "");

			if ((cardNumber.startsWith("34") || cardNumber.startsWith("37"))) {

				if (PropertyUtility.validateCreditCardNumber(cardNumber) && cardNumber.length() == 15) {
					responseObject.put("creditCardType", PropertyUtility.PAY_CCTYPE.PAY_CCTYPE_AMEX.ordinal());
					responseObject.put(STATUS, true );

				} else {
					responseObject.put(STATUS, false);
					responseObject.put("MSG","Invalid , error cfff00fd: credit_card_type.3 The credit card type specified does not match with the credit card number given.");
				}
			}

			else if (cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53")
					|| cardNumber.startsWith("54") || CardNumber.startsWith("55")) {

				if (PropertyUtility.validateCreditCardNumber(cardNumber) && cardNumber.length() == 16) {
					responseObject.put("creditCardType", PropertyUtility.PAY_CCTYPE.PAY_CCTYPE_MASTERCARD.ordinal());
					responseObject.put(STATUS, true );

				} else {
					responseObject.put(STATUS, false);
					responseObject.put("MSG","Invalid , error cfff00fd: credit_card_type.2 The credit card type specified does not match with the credit card number given.");
				}
			}

			else if (cardNumber.startsWith("644") || cardNumber.startsWith("645") || cardNumber.startsWith("646")
					|| CardNumber.startsWith("647") || cardNumber.startsWith("648") || CardNumber.startsWith("649")
					|| cardNumber.startsWith("650")) {

				if (PropertyUtility.validateCreditCardNumber(cardNumber) && cardNumber.length() == 16) {
					responseObject.put("creditCardType", PropertyUtility.PAY_CCTYPE.PAY_CCTYPE_DISCOVER.ordinal());
					responseObject.put(STATUS, true );

				} else {
					responseObject.put(STATUS, false);
					responseObject.put("MSG",
							"Invalid , error cfff00fd: credit_card_type.4 The credit card type specified does not match with the credit card number given.");
					// responseObject.put(STATUS, false );
				}

			} else if (cardNumber.startsWith("4")) {
				if (PropertyUtility.validateCreditCardNumber(cardNumber) && cardNumber.length() == 16) {
					responseObject.put(STATUS, true);
					responseObject.put("creditCardType", PropertyUtility.PAY_CCTYPE.PAY_CCTYPE_VISA.ordinal());

				} else {
					responseObject.put(STATUS, false);
					responseObject.put("MSG",
							"Invalid , error cfff00fd: credit_card_type.1 The credit card type specified does not match with the credit card number given.");
					// responseObject.put(STATUS, false );
				}
			}
			return responseObject;
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
}