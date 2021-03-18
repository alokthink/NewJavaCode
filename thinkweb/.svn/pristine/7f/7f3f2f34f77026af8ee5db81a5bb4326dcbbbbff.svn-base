package com.mps.think.dao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import com.mps.think.model.BackIssuesModel;
import com.mps.think.model.BasicPackageItemModel;
import com.mps.think.model.CustomerAddressDistributionModel;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.CustomerDistributionValuesModel;
import com.mps.think.model.CustomerOrderModel;
import com.mps.think.model.DistributionAttributeModel;
import com.mps.think.model.DistributionMethodModel;
import com.mps.think.model.DistributionValueModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.IssueModel;
import com.mps.think.model.OrderClass;
import com.mps.think.model.OrderCode;
import com.mps.think.model.OrderItem;
import com.mps.think.model.PackageDefinition;
import com.mps.think.model.PaymentThresholdHandlingDataModel;
import com.mps.think.model.Product;
import com.mps.think.model.ProposedAddsKillsModel;
import com.mps.think.model.QuickOrderInProgressModel;
import com.mps.think.model.RateClassEffectiveModel;
import com.mps.think.model.RatecardModel;
import com.mps.think.model.ReviewAddsKillsModel;
import com.mps.think.model.ReviewOnsOffsModel;
import com.mps.think.model.ShippingModel;
import com.mps.think.model.ShippingPriceListModel;
import com.mps.think.model.SingleCopyOrder;
import com.mps.think.model.SubscriptionDefinition;

import Think.XmlWebServices.Item_already_subscribed_list_request;
import Think.XmlWebServices.Order_add_response;
import Think.XmlWebServices.Package_edit_response;


public interface CustomerOrderDao 
{
	public List<CustomerOrderModel> getCustomerOrder(Long customerId, String inActive, String paid, String controlled, String complimentary, String orderType,String billToCustNotOwner, String pkg, String limitToOc);
	public List<OrderItem> getOrderinProgressData(int orderCodeType,String orderCode,String sourceCode);
	public boolean saveOrder(OrderItem orderItem);
	public OrderItem customerOrderEdit(long orderhdrId,int orderItemType, int orderCodeId, long customerId, int orderItemSeq,int isrenewd);
	public List<Map<String, Object>> getDeliveryMethodList();
	public String orderUpdate(OrderItem orderItem);
	public List<Map<String, Object>> customerAddressDetail(long customerId);
	public List<Map<String,Object>> getCustomerDetails(String customerId);
	public List<IssueModel> getSubscriptionStartDate(int ocId);
	public List<PackageDefinition> getPackageDefinitionList(int orderCodeId);
	public List<SubscriptionDefinition> getSubscriptionPackageDefList(int customerId, int orderCodeId,int sourceCodeId, int subscriptionDefId,int orderCodeType,String agencyID);
	public List<SubscriptionDefinition> getSubscriptionDefList(int customerId, int orderCodeId, int subscriptionDefId, int orderCodeType);
	public List<BasicPackageItemModel> getBasicPackageDefList(int customerId, int orderCodeId,int sourceCodeId,int subscriptionDefId, int orderCodeType, String subscriptionIdList,Optional<Integer> docRefId);
	public List<BasicPackageItemModel> onPkgDefChange(int customerId, int orderCodeId, int subscriptionDefId, int orderCodeType);
	public long getPackageTaxRate(long customerId,  String commodityCode);
	public long getTaxRate(long customerId,  int orderCodeId);
	public long getPackageTax(long customerId,  int orderCodeId);
	public List<RateClassEffectiveModel> getRateClassEffectiveList(String agencyID,int rateClassId,String orderCodeId, long customerId, long orderhdrId,int orderItemSeq, int subscription_def_id);
	public List<RatecardModel> getCustomerOrderPriceTax(int rateClassId,int rateClassEffectiveSeq,String ratecardSeq,String state,String commodityCode);
	public List<Map<String, Object>> getAgencyChangeData(long customerId, String agencyID);
	public List<DropdownModel> getOrderCategory();
	public List<DropdownModel> getorderClass();
	public List<DropdownModel> getOrderCode();
	public List<OrderCode> getOrderCodeData(String orderCode,String orderClass, String orderCodeType, String term);
	public List<DropdownModel> getOrderTerm();
	public List<Map<String, Object>> getRateCardChange(int rateClassId, int rateClassEffectiveSeq, long customerId, String orderhdrId);
    public List<DropdownModel> getviewOrderTypeList();
    public List<DropdownModel> getOrderStatus();
    public List<DropdownModel> getpaymentStatus();
	public List<Object> getDuplicateOrder(OrderItem orderItem);
	public List<Object> getRenewalOrder(int orderItem);
	public List<Map<String, Object>> getAddressDetails(String customerId, int orderCodeId,int orderItemType);
	public boolean addBasicPackage(OrderItem orderItem);
	public List<SingleCopyOrder> getSingleCopyOrder(int customerId, int parseInt, String sourceCodeId, int subscriptionId,int orderCodeType);
	public String getOrderAdd(OrderItem orderItem, int itemCount,String subscriptionIdList, Optional<Integer> changeAmount) throws Exception;
	public String saveOrderWithPaymentIntoDataSource(OrderItem orderItem, int itemCount,String subscriptionIdList) throws Exception;
	public List<OrderItem> customerOrderPackageEdit(long orderhdrId, int orderItemType, int orderCodeId,long customerId, int orderItemSeq, Integer showInactive);
	public List<CustomerAuxiliaryModel> getCustomerAuxiliaryFormField() throws SQLException;
	public String saveOrderAuxiliary(HttpServletRequest request) throws SQLException;
	public LinkedHashMap<String, String> setOrderAuxiliaryDetailByID(Long orderhdrId, int orderItemSeq) throws SQLException;
	public List<Product> getProductDefinitionList(int orderCodeId);
	public List<Product> getProductRate(int customerId, int orderCodeId,int sourceCodeId, int subscriptionId, int orderCodeType);
	public Map<String, Object> getSaveAmountForNoOfIssue(long issueId, int numberOfIssue, float toOrderItemPrice);
	public Map<String, Object> getBundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,int orderLineNumber,
			float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,long orderId);
	public Map<String, Object> clickOnBundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,
			int orderLineNumber, float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,
			long orderId, float baseAmount,int option,long startIssueId, float baseNetAmount, float baseGrossAmount, float localNetAmount, float localGrossAmount, float localCommission, float baseCommission, float totalTaxLocalAmount, float totalTaxBaseAmount, float toCastPerIssue, String startDate );
	public Map<String, Object> getExpirationDate(int issueId, int numIssue, int ocId, String subscripId);
	public List<BackIssuesModel> getBackIssueList(int numIssue, int currIssueId, String subscripId);
	public List<Map<String, Object>> getOnSubscriptionChange(int subscription_def_id, Integer issueId,long orderhdrId, int orderItemSeq);
	public Object getChangeAmountByRateCard(long numberOfIssue, long customerId, int rateClassId,
			int rateClassEffectiveSeq);
	public List<Map<String, Object>> getsourceCodeChange(int sourceCodeId, String agencyID);
	public Map<String, Object> getAdjustQuatity(long preQty, long adjQty, long additionalQty,double localAmount,double baseAmount);
	public Map<String, Object> getadjustAdditionalQty(long preAdditional, long adjustAdditional, long total);
	public List<Object> getOrderHistory(Long orderHdrId, int ordItemSeq) throws SQLException;
	public String getCreditStatus(Long customerId);
	public String getCetDefDetails(long orderhdrId, int orderItemSeq);
	public Map<String, Object> getAmountForNoOfIssue(int orderhdrId, int orderItemSeq, int quantity,
			String defaultPricing, long customerId, int rateClassId, int rateClassEffectiveSeq, int priceMethodOption,
			float localAmount, float baseAmount, int preQuantity, int customerAddressSeq);
    public List<OrderClass> getorderClassLookUp(String orderCode, String ocID, String profitCenter, String description);
	public List<Map<String, Object>> getInstallmentPlan();
	public List<Map<String, Object>> getOrderItemInstallmentDetails(Long orderHdrId, int ordItemSeq);
	public String getInstallmentPlanType(Integer installmentId);
	public List<Map<String, Object>> getCalculatedOrderItemInstallmentAmount(Long orderhdrId, Integer orderItemSeq,Integer installmentIdNew,Integer customerId,Integer subscriptionId,String sourceCodeId,String state,String currency, String orderCodeId,String orderCodeType);
	public List<Map<String, Object>> getDefaultOrderItemInstallmentDetails(Long orderHdrId, Integer ordItemSeq);	
	public String getTypeDetails(int orderCodeId, int type);
	public int getDisallowInstallment(int orderCodeId);
	public int getInstallmentOnly(int orderCodeId);
	public List<DropdownModel> getPaymentDropdwonList(int customerId, int isActive, String paymentType);
	public List<Map<String, Object>> getCreditCardDetails(int accountPaymentSeq, int idNbrLastFour);
	public List<Map<String, Object>> getDebitCardDetails(Long orderHdrId, int customerId,int accountPaymentSeq);
	public int saveBillingOptions(OrderItem billingOption);
	public List<Map<String, Object>>getPullDayData(Integer pullDay,Integer autoPayment);
	public String getUseUnitValue(long orderHdrId, int orderItemSeq);
	public boolean getUnitSave(OrderItem orderItem);
	public Map<String, Object> getOptionData(int oldNoOfCopy, int newNoOfCopy, long orderhdrId, int orderItemSeq, String orderClass,
			String orderCode, int orderLineNumber, float orderPrice, float fromNoOfDays);
	public Map<String, Object> saveNoOfCopyChange(float price ,int numberOfCopy, int option);
	public List<DropdownModel> getBillingTypeList();
	public List<DropdownModel> getAutoPaymentList();
	public List<Map<String, Object>>getGenericPromoCodeDetails(String promoCode);
	public List<ReviewAddsKillsModel> getVerifiedAddsKillsFromDataSource(int customer_id,int subscrip_id);
	public List<ReviewAddsKillsModel> getNonVerifiedAddsKillsFromDataSource(int customer_id,int subscrip_id);
	public List<ProposedAddsKillsModel> getProposedAddsKillsFromDataSource(int subscrip_id);
	public List<ReviewOnsOffsModel> getReviewOnsOffsFromDataSource(int customer_id,int subscrip_id);
	public int getMru_account_reference_id();
	public int isBank_wizard_installed();
	public List<Map<String, Object>> shippingOrderPercentList();
	public List<Map<String, Object>> getShippingOrderList(Integer orderhdrId);
	public int getOrderItemSeq(Integer orderhdrId);
	List<DropdownModel> getShippingMethod();
	public int cancelDirectDebit(Integer orderhdrId, Integer orderItemSeq);
	public String shippingPriceUpdate(ShippingPriceListModel shippingPriceListModel);
	public List<QuickOrderInProgressModel> getQuickOrdersInProgressFromDataSource(int customerId, int orderCodeId,int sourceCodeId,int orderItemType);
	public List<DropdownModel> getPackageDropDownList(int orderCodeId);
	public int deleteBillingOptions(long orderhdrId,int orderItemSeq);
	public List<ShippingModel> getShipOrderDetail(int customerId, int orderCodeId, int sourceCodeId, int orderCodeType);
	public List<PackageDefinition> getBasicPackageList(int ocId);
	public List<PackageDefinition> getAdhocPackageList(int orderCodeId);
	public List<PackageDefinition> getPooledPackageList(int orderCodeId);
	public CustomerDistributionValuesModel retrieveCustomerInformationFromDataSource(long customer_id);
	public List<SubscriptionDefinition> getSubscription(int orderCodeId);
	public List<DistributionMethodModel> retrieveDistributionMethodsFromDataSource();
	public List<DistributionAttributeModel> retrieveDistributionAttributesFromDataSource();
	public List<DistributionValueModel> retrieveDistributionValuesFromDataSource();
	public List<Map<String, Object>> getQuickOrderList(int orderCodeId);
	public List<CustomerAddressDistributionModel> retrieveCustomerAddressDistributionFromDataSource(long customer_id);
	public OrderItem customerOrderPkgEdit(int customerId, String orderCodeId, String sourceCodeId,int orderCodeType, String productId,String agencyID);
	public Map<String,Object>getOrderDropdownData(int orderCodeId,int ocId, int orderCodeType, int customerId);
	public List<Product> getProductDefinition(int ocId);
	public List<Map<String, Object>> getPoolMemeberDetails(int orderCodeId);
	public List<Map<String, Object>> getSubscriptionDetails(int ocId, int orderCodeId);
	public List<Map<String, Object>> getSubscriptionDetailsByOrderCodeId(int orderCodeId);
	public List<Map<String, Object>> getQuickOrderData(String orderCodeId,String sourceCodeId,int orderCodeType,int customerId,String subscriptionIdList,String agencyID,Optional<Integer> orderhdrId , Optional<String> shippingPrice,Optional<Integer> docRefId);
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, String required,int customerId,Integer pkgDefId);
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, String required);
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, Integer pkgDefId);
	public List<DropdownModel> getCurrencyDropdown();
	public List<Map<String,Object>> getPkgMember(String orderCodeId, String sourceCodeId, int orderCodeType,
			int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,
			Optional<String> shippingPrice,Integer pkgDefId,Optional<Integer> docRefId);
	public List<DropdownModel> getPkgDef(String orderCodeId);
	public float covertedAmountByCurrency(float amount, String currency);
	public List<Map<String,Object>>getConfigTableDetails();
	public int getPromoStatus(String promoCode);
	public Date getPromoFutureDate(String promoCode);
	public Integer getSourceCodeId(String promoCode);
	public PaymentThresholdHandlingDataModel retrievePaymentThresholdHandlingDataFromDataSource(String orderCodeId,int orderCodeType,String sourceCodeId,Integer subscriptionId,String subscriptionIdList,Double totalPaid,int customerId,int oc_type,int start_type,int revenue_method,double amount_of_order_in_progress);
	public Integer getRenew(int subscripId);
	public List<BasicPackageItemModel> getAdhocPackageData(int customerId, int orderCodeId, int sourceCodeId,
			Integer subscriptionId, int orderCodeType, String subscriptionIdList, String grossLocalAmt,
			String grossBaseAmt);
	public Map<String,Object>retrieveAgencyDataFromDataSource(int cancelled_order_code_type,int cancelled_order_id,int customerId);
	public List<Map<String, Object>> getcheckIssueBeyond(OrderItem orderItem);
	public String getalreadySubscribed(int customerId,int orderCodeType,
			String orderCodeID, Optional<Integer> sourceCode,
			Optional<Integer> packageDefId, int i);
	public OrderItem orderProgressAdd(OrderItem orderItem, Integer subscriptionId, int itemCount,
			Optional<String> subscriptionIdList);
	public Map<String, Object> getListDataForPkg(Integer orderhdrId);
	public String editPackage(OrderItem orderItem);
	public List<CustomerOrderModel> getCustomerOrder(long customerId,Integer orderhdrId, Integer showInactive);
	Map<String, Object> orderAuxiliary(HttpServletRequest request) throws SQLException;
	public List<RateClassEffectiveModel> getRateClassEffectiveListInEditItem(int rateClassId, int customerId, String currency,String orderCodeID);
	public List<Map<String, Object>> onChangeInEditItem(OrderItem orderItem, Integer subscriptionId, int itemCount,
			Optional<String> subscriptionIdList);
	public List<DropdownModel> getRateClassEffective(int rateClassId);
	public List<Package_edit_response> getOnEditCodeChange(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			Integer sourceCodeId,BigDecimal localAmount);
	List<Map<String, Object>> changeDateInEditItem(OrderItem orderItem, Integer subscriptionId, int itemCount,
			Optional<String> subscriptionIdList);
	public List<OrderItem> packageMembersEditITem(OrderItem orderItem, Integer subscriptionId, int i,
			Optional<String> subscriptionIdList);
	public List<Map<String, Object>> getExistingOrderItemData(Long orderhdrId, Integer orderItemSeq);
	public List<Map<String, Object>> getExistingOrderItemBreakData(Long orderhdrId, Integer orderItemSeq);
	public List<Map<String, Object>> onOrderCodeSelection(OrderItem orderItem, int subscriptionId, int i,
			Optional<String> subscriptionIdList);
	public List<Map<String, Object>> getpkgMemberListForReq(int orderCodeId);
	public List<Map<String, Object>> getSubscripDetails(int subscrip_id);
	public List<Package_edit_response> getIncludeTax(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			int yesNo);
	public List<Map<String, Object>> selectionOfRateClass(OrderItem orderItem, Integer subscriptionId, int i,
			Optional<String> subscriptionIdList);
	public int getmemberListCount(long orderhdrId);
	
}
