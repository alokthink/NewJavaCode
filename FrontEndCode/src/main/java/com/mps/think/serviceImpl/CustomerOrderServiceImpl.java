package com.mps.think.serviceImpl;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mps.think.dao.CustomerOrderDao;
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
import com.mps.think.service.CustomerOrderService;
import com.mps.think.model.BackIssuesModel;
import com.mps.think.model.BasicPackageItemModel;
import com.mps.think.model.CustomerAddressDistributionModel;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.CustomerDistributionValuesModel;



@Service("customerOrderService")
public class CustomerOrderServiceImpl implements CustomerOrderService{
	
	@Autowired
	CustomerOrderDao customerOrderDao;
	
	@Override
	public List<CustomerOrderModel> getCustomerOrder(Long customerId, String inActive, String paid, String controlled, String complimentary, String orderType,String billToCustNotOwner,String pkg,String limitToOc){
		
		return customerOrderDao.getCustomerOrder(customerId,inActive,paid,controlled,complimentary,orderType,billToCustNotOwner,pkg,limitToOc);
	}

	@Override
	public List<OrderItem> getOrderinProgressData(int orderCodeType, String orderCode, String sourceCode) {		
		return customerOrderDao.getOrderinProgressData(orderCodeType, orderCode, sourceCode);
	}

	@Override
	public boolean saveOrder(OrderItem orderItem) {		
		if(orderItem.getOrderCodeType() == "4"){
			return customerOrderDao.addBasicPackage(orderItem);
		}else{
		return customerOrderDao.saveOrder(orderItem);
			}
	}

	@Override
	public OrderItem customerOrderEdit(long orderhdrId,int orderItemType,int orderCodeId, long customerId,int orderItemSeq,int isrenewd) {
		return customerOrderDao.customerOrderEdit(orderhdrId,orderItemType,orderCodeId,customerId,orderItemSeq,isrenewd);
	}

	@Override
	public  List<Map<String, Object>> getDeliveryMethodList() {		
		return customerOrderDao.getDeliveryMethodList();
	}

	@Override
	public String orderUpdate(OrderItem orderItem) {		
		return customerOrderDao.orderUpdate(orderItem);
	}

	@Override
	public List<Map<String, Object>> customerAddressDetail(long customerId) {		
		return customerOrderDao.customerAddressDetail(customerId);
	}

	@Override
	public List<Map<String, Object>> getCustomerDetails(String customerId) {
		return customerOrderDao.getCustomerDetails(customerId);
	}

	@Override
	public List<IssueModel> getSubscriptionStartDate(int ocId) {		
		return customerOrderDao.getSubscriptionStartDate(ocId);
	}

	@Override
	public List<PackageDefinition> getPackageDefinitionList(int orderCodeId) {		
		return customerOrderDao.getPackageDefinitionList(orderCodeId);
	}

	

	@Override
	public List<SubscriptionDefinition> getSubscriptionPackageDefList(int customerId, int orderCodeId,int sourceCodeId, int subscriptionDefId, int orderCodeType,String agencyID) {		
		return customerOrderDao.getSubscriptionPackageDefList(customerId, orderCodeId,sourceCodeId, subscriptionDefId,orderCodeType,agencyID);
	}
	@Override
	public List<SubscriptionDefinition> getSubscriptionDefList(int customerId, int orderCodeId, int subscriptionDefId, int orderCodeType) {		
		return customerOrderDao.getSubscriptionDefList(customerId, orderCodeId, subscriptionDefId, orderCodeType);
	}

	@Override
	public List<BasicPackageItemModel> getBasicPackageDefList(int customerId, int orderCodeId,int sourceCodeId, int packageDefId, int orderCodeType,String subscriptionIdList) {
		return customerOrderDao.getBasicPackageDefList(customerId, orderCodeId,sourceCodeId, packageDefId, orderCodeType,subscriptionIdList);
	}
	@Override
	public List<BasicPackageItemModel> onPkgDefChange(int customerId, int orderCodeId, int packageDefId, int orderCodeType) {
		return customerOrderDao.onPkgDefChange(customerId, orderCodeId, packageDefId, orderCodeType);
	}

	@Override
	public long getTaxRate(long customerId, int orderCodeId) {		
		return customerOrderDao.getTaxRate(customerId, orderCodeId);
	}	
	@Override
	public long getPackageTax(long customerId, int orderCodeId) {		
		return customerOrderDao.getPackageTax(customerId, orderCodeId);
	}
	@Override
	public List<Map<String, Object>> getAgencyChangeData(long customerId,String agencyID) {		
		return customerOrderDao.getAgencyChangeData(customerId,agencyID);
	}	
	
	@Override
	public List<DropdownModel> getorderClass() {		
		return customerOrderDao.getorderClass();
	}
	
	@Override
	public List<DropdownModel> getOrderCode() {		
		return customerOrderDao.getOrderCode();
	}
	@Override
	public List<DropdownModel> getOrderCategory() {		
		return customerOrderDao.getOrderCategory();
	}
	
	@Override
	public List<RateClassEffectiveModel> getRateClassEffectiveList(String agencyID,int rateClassId,String orderCodeId,long customerId,long orderhdrId,int orderItemSeq,int subscription_def_id) {		
		return customerOrderDao.getRateClassEffectiveList(agencyID,rateClassId, orderCodeId, customerId, orderhdrId, orderItemSeq,subscription_def_id);
	}

	@Override
	public List<RatecardModel> getCustomerOrderPriceTax(int rateClassId, int rateClassEffectiveSeq, String ratecardSeq,
			String state, String commodityCode) {		
		return customerOrderDao.getCustomerOrderPriceTax(rateClassId, rateClassEffectiveSeq, ratecardSeq, state, commodityCode);
	}

	@Override
	public List<Map<String, Object>> getRateCardChange(int rateClassId, int rateClassEffectiveSeq,long customerId,String orderhdrId) {
		return customerOrderDao.getRateCardChange(rateClassId, rateClassEffectiveSeq, customerId, orderhdrId);	}

	@Override
	public List<OrderCode> getOrderCodeData(String orderCode,String orderClass, String orderCodeType,String term) {
		return customerOrderDao.getOrderCodeData(orderCode,orderClass,orderCodeType,term);
	}

	@Override
	public List<DropdownModel> getOrderTerm() {
		return customerOrderDao.getOrderTerm();
	}

	@Override
	public List<DropdownModel> getviewOrderTypeList() {	
		return customerOrderDao.getviewOrderTypeList();
	}

	@Override
	public List<DropdownModel> getOrderStatus() {
		return customerOrderDao.getOrderStatus();
	}

	@Override
	public List<DropdownModel> getpaymentStatus() {
		return customerOrderDao.getpaymentStatus();
	}

	@Override
	public List<Object> getDuplicateOrder(OrderItem orderItem) {
		return customerOrderDao.getDuplicateOrder(orderItem);
	}

	@Override
	public List<Object> getRenewalOrder(int subscripId) {
		return customerOrderDao.getRenewalOrder(subscripId);
	}

	@Override
	public List<Map<String, Object>> getAddressDetails(String customerId, int orderCodeId, int orderItemType) {
		return customerOrderDao.getAddressDetails(customerId, orderCodeId,orderItemType);
	}

	@Override
	public List<SingleCopyOrder> getSingleCopyOrder(int customerId, int parseInt,String sourceCodeId, int subscriptionId,int orderCodeType) {
		return customerOrderDao.getSingleCopyOrder(customerId, parseInt,sourceCodeId,subscriptionId,orderCodeType);
	}

	@Override
	public String getOrderAdd(OrderItem orderItem, int itemCount,String subscriptionIdList) throws Exception  {
		return customerOrderDao.getOrderAdd(orderItem,itemCount,subscriptionIdList);
	}

	@Override
	public String saveOrderWithPayment(OrderItem orderItem, int itemCount,String subscriptionIdList) throws Exception  {
		return customerOrderDao.saveOrderWithPaymentIntoDataSource(orderItem,itemCount,subscriptionIdList);
	}
	
	@Override
	public List<OrderItem> customerOrderPackageEdit(long orderhdrId, int orderItemType, int orderCodeId,long customerId, int orderItemSeq) {
		return customerOrderDao.customerOrderPackageEdit(orderhdrId,orderItemType,orderCodeId,customerId,orderItemSeq);
	}

	@Override
	public List<CustomerAuxiliaryModel> getCustomerAuxiliaryFormField() throws SQLException {
		return customerOrderDao.getCustomerAuxiliaryFormField();
	}

	@Override
	public String saveOrderAuxiliary(HttpServletRequest request) throws SQLException {
		return customerOrderDao.saveOrderAuxiliary(request);
	}

	@Override
	public LinkedHashMap<String, String> setOrderAuxiliaryDetailByID(long orderhdrId, int orderItemSeq) throws SQLException {
		return customerOrderDao.setOrderAuxiliaryDetailByID(orderhdrId,orderItemSeq);
	}
	
	@Override
	public List<Product> getProductDefinitionList(int orderCodeId)  {
		return customerOrderDao.getProductDefinitionList(orderCodeId);
	}

	@Override
	public List<Product> getProductRate(int customerId, int orderCodeId,int sourceCodeId, int subscriptionId, int orderCodeType) {
	   return customerOrderDao.getProductRate(customerId, orderCodeId,sourceCodeId,subscriptionId, orderCodeType);
	}
	
	@Override
	public Map<String, Object> getSaveAmountForNoOfIssue(long issueId, int numberOfIssue, float toOrderItemPrice) {
		return customerOrderDao.getSaveAmountForNoOfIssue(issueId,numberOfIssue,toOrderItemPrice);
	}

	@Override
	public Map<String, Object> getBundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,int orderLineNumber,
			float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,long orderId) {
		return customerOrderDao.getBundleQuantityChangeOption(orderClass,orderCode,orderNumber,orderLineNumber,localAmount,numberOfIssue,copyPerIssue,preCopyPerIssue,orderId);
	}

	@Override
	public Map<String, Object> clickOnBundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,
			int orderLineNumber, float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,
			long orderId, float baseAmount,int option,long startIssueId ,float baseNetAmount, float baseGrossAmount, float localNetAmount, float localGrossAmount,
			float localCommission,float baseCommission,float totalTaxLocalAmount,float totalTaxBaseAmount,float toCastPerIssue) {
		return  customerOrderDao.clickOnBundleQuantityChangeOption(orderClass, orderCode,orderNumber,
			 orderLineNumber,localAmount,numberOfIssue, copyPerIssue,  preCopyPerIssue,
				 orderId,baseAmount,option,startIssueId ,baseNetAmount,baseGrossAmount, localNetAmount,localGrossAmount,
				 localCommission, baseCommission, totalTaxLocalAmount, totalTaxBaseAmount,toCastPerIssue);
	}

	@Override
	public Map<String, Object> getExpirationDate(int issueId,int numIssue,int ocId,String subscripId) {
		return customerOrderDao.getExpirationDate(issueId,numIssue,ocId,subscripId);
	}

	@Override
	public List<BackIssuesModel> getBackIssueList(int numIssue, int currIssueId, String subscripId) {
		return customerOrderDao.getBackIssueList(numIssue,currIssueId,subscripId);
	}

	@Override
	public Object getChangeAmountByRateCard(long numberOfIssue, long customerId, int rateClassId,
			int rateClassEffectiveSeq) {
		return customerOrderDao.getChangeAmountByRateCard(numberOfIssue,customerId,rateClassId, rateClassEffectiveSeq);
	}
	@Override
	public List<Map<String, Object>> getOnSubscriptionChange(int subscription_def_id, Integer issueId) {
		return customerOrderDao.getOnSubscriptionChange(subscription_def_id,issueId);
	}

	@Override
	public List<Map<String, Object>> getsourceCodeChange(int sourceCodeId,String agencyID) {
		return customerOrderDao.getsourceCodeChange(sourceCodeId, agencyID);
	}

	@Override
	public Map<String,Object>  getAdjustQuatity(long preQty, long adjQty, long additionalQty,double localAmount,double baseAmount) {
		return customerOrderDao.getAdjustQuatity(preQty,adjQty,additionalQty,localAmount,baseAmount);
	}

	@Override
	public Map<String, Object> getadjustAdditionalQty(long preAdditional, long adjustAdditional, long total) {
		return customerOrderDao.getadjustAdditionalQty(preAdditional, adjustAdditional,total);
	}

	@Override
	public List<Object> getOrderHistory(Long orderHdrId, int ordItemSeq) throws SQLException {
		return customerOrderDao.getOrderHistory(orderHdrId,ordItemSeq);
	}

	@Override
	public String getCreditStatus(Long customerId) {
		return customerOrderDao.getCreditStatus(customerId);
	}
	
	public String getCetDefDetails(long orderhdrId,int orderItemSeq){
		return customerOrderDao.getCetDefDetails(orderhdrId,orderItemSeq);
	}

	@Override
	public Map<String, Object> getAmountForNoOfIssue(int orderhdrId, int orderItemSeq, int quantity,
			String defaultPricing, long customerId, int rateClassId, int rateClassEffectiveSeq, int priceMethodOption,
			float localAmount, float baseAmount, int preQuantity, int customerAddressSeq) {
		
		return customerOrderDao.getAmountForNoOfIssue( orderhdrId,  orderItemSeq,  quantity,
				 defaultPricing,  customerId,  rateClassId,  rateClassEffectiveSeq,  priceMethodOption,
				 localAmount,  baseAmount,  preQuantity,  customerAddressSeq);
	}

	@Override
	public List<OrderClass> getorderClassLookUp(String orderCode, String ocID, String profitCenter, String description) {
		return customerOrderDao.getorderClassLookUp(orderCode,ocID,profitCenter,description);
	}

	@Override
	public List<Map<String, Object>> getInstallmentPlan() {
		return customerOrderDao.getInstallmentPlan();
	}

	@Override
	public List<Map<String, Object>> getOrderItemInstallmentDetails(Long orderHdrId, int ordItemSeq) {
		return customerOrderDao.getOrderItemInstallmentDetails(orderHdrId, ordItemSeq);
	}

	@Override
	public String getInstallmentPlanType(Integer installmentId) {
		return customerOrderDao.getInstallmentPlanType(installmentId);
	}

	@Override
	public List<Map<String, Object>> getCalculatedOrderItemInstallmentAmount(Long orderhdrId, Integer orderItemSeq,Integer installmentIdNew,Integer customerId,Integer subscriptionId,String sourceCodeId,String state,String currency, String orderCodeId,String orderCodeType) {
		return customerOrderDao.getCalculatedOrderItemInstallmentAmount(orderhdrId, orderItemSeq, installmentIdNew, customerId, subscriptionId, sourceCodeId, state, currency, orderCodeId, orderCodeType);
	}

	@Override
	public List<Map<String, Object>> getDefaultOrderItemInstallmentDetails(Long orderHdrId, Integer ordItemSeq) {
		return customerOrderDao.getDefaultOrderItemInstallmentDetails(orderHdrId, ordItemSeq);
	}

	@Override
	public String getTypeDetails(int orderCodeId, int type) {
		return customerOrderDao.getTypeDetails(orderCodeId, type);
	}

	@Override
	public int getDisallowInstallment(int orderCodeId) {
		return customerOrderDao.getDisallowInstallment(orderCodeId);
	}

	@Override
	public int getInstallmentOnly(int orderCodeId) {
		return customerOrderDao.getInstallmentOnly(orderCodeId);
	}

	@Override
	public List<DropdownModel> getPaymentDropdwonList(int customerId, int isActive, String paymentType) {
		return customerOrderDao.getPaymentDropdwonList(customerId, isActive, paymentType);
	}

	@Override
	public List<Map<String, Object>> getCreditCardDetails(int accountPaymentSeq, int idNbrLastFour) {
		return customerOrderDao.getCreditCardDetails(accountPaymentSeq, idNbrLastFour);
	}

	@Override
	public List<Map<String, Object>> getDebitCardDetails(Long orderHdrId, int customerId,int accountPaymentSeq) {
		return customerOrderDao.getDebitCardDetails(orderHdrId, customerId,accountPaymentSeq);
	}

	@Override
	public int saveBillingOptions(OrderItem billingOption) {
		return customerOrderDao.saveBillingOptions(billingOption);
	}

	@Override
	public List<Map<String, Object>> getPullDayData(Integer pullDay,Integer autoPayment) {
		return customerOrderDao.getPullDayData(pullDay,autoPayment);
	}

	@Override
	public String getUseUnitValue(long orderHdrId, int orderItemSeq) {
		return customerOrderDao.getUseUnitValue(orderHdrId,orderItemSeq);
	}

	@Override
	public boolean getUnitSave(OrderItem orderItem) {
		return customerOrderDao.getUnitSave(orderItem);
	}

	@Override
	public Map<String,Object> getOptionData(int oldNoOfCopy, int newNoOfCopy, long orderhdrId, int orderItemSeq, String orderClass,
			String orderCode, int orderLineNumber, float orderPrice,float fromNoOfDays) {
		return customerOrderDao.getOptionData(oldNoOfCopy,newNoOfCopy,orderhdrId,orderItemSeq,orderClass,
				 orderCode,orderLineNumber, orderPrice,fromNoOfDays);
	}

	@Override
	public Map<String,Object> saveNoOfCopyChange(float price ,int numberOfCopy, int option) {
		return customerOrderDao.saveNoOfCopyChange(price ,numberOfCopy,option);
	}

	@Override
	public List<DropdownModel> getBillingTypeList() {
		return customerOrderDao.getBillingTypeList();
	}

	@Override
	public List<DropdownModel> getAutoPaymentList() {
		return customerOrderDao.getAutoPaymentList();
	}

	@Override
	public List<Map<String, Object>> getGenericPromoCodeDetails(String promoCode) {
		return customerOrderDao.getGenericPromoCodeDetails(promoCode);
	}
	@Override
	public List<ReviewAddsKillsModel> getVerifiedAddsKills(int customer_id,int subscrip_id) {
		return customerOrderDao.getVerifiedAddsKillsFromDataSource(customer_id,subscrip_id);
	}

	@Override
	public List<ReviewAddsKillsModel> getNonVerifiedAddsKills(int customer_id,int subscrip_id) {
		return customerOrderDao.getNonVerifiedAddsKillsFromDataSource(customer_id,subscrip_id);
	}

	@Override
	public List<ProposedAddsKillsModel> getProposedAddsKills(int subscrip_id) {
		return customerOrderDao.getProposedAddsKillsFromDataSource(subscrip_id);
	}
	
	@Override
	public List<ReviewOnsOffsModel> getReviewOnsOffs(int customer_id,int subscrip_id) {
		return customerOrderDao.getReviewOnsOffsFromDataSource(customer_id,subscrip_id);
	}

	@Override
	public int getMru_account_reference_id() {
		return customerOrderDao.getMru_account_reference_id();
	}

	@Override
	public int isBank_wizard_installed() {
		return customerOrderDao.isBank_wizard_installed();
	}

	@Override
	public List<Map<String, Object>> shippingOrderPercentList() {
		return customerOrderDao.shippingOrderPercentList();
	}

	@Override
	public List<Map<String, Object>> getShippingOrderList(Integer orderhdrId) {
		return customerOrderDao.getShippingOrderList(orderhdrId);
	}

	@Override
	public int getOrderItemSeq(Integer orderhdrId) {
		return customerOrderDao.getOrderItemSeq(orderhdrId);
	}


	@Override
	public List<DropdownModel> getShippingMethod() {
		return customerOrderDao.getShippingMethod();
	}

	@Override
	public int cancelDirectDebit(Integer orderhdrId, Integer orderItemSeq) {
		return customerOrderDao.cancelDirectDebit(orderhdrId, orderItemSeq);
	}

	@Override
	public String shippingPriceUpdate(ShippingPriceListModel shippingPriceListModel) {
		return customerOrderDao.shippingPriceUpdate(shippingPriceListModel);
		
	}

	@Override
	public List<DropdownModel> getPackageDropDownList(int orderCodeId) {
		return  customerOrderDao.getPackageDropDownList(orderCodeId);
	}
	
	@Override
	public List<QuickOrderInProgressModel> getQuickOrdersInProgress(int customerId, int orderCodeId,int sourceCodeId,int orderItemType) {
		return customerOrderDao.getQuickOrdersInProgressFromDataSource(customerId,orderCodeId,sourceCodeId,orderItemType);
	}
	
	@Override
	public int deleteBillingOptions(long orderhdrId, int orderItemSeq) {
		return customerOrderDao.deleteBillingOptions(orderhdrId, orderItemSeq);
	}

	@Override
	public List<ShippingModel> getShipOrderDetail(int customerId, int orderCodeId,int sourceCodeId, int orderCodeType) {
		return customerOrderDao.getShipOrderDetail(customerId,orderCodeId,sourceCodeId,orderCodeType);
	}
	
	@Override
	public List<SubscriptionDefinition> getSubscription(int orderCodeId) {
		return customerOrderDao.getSubscription(orderCodeId);
	}
	
	@Override
	public List<PackageDefinition> getAdhocPackageList(int orderCodeId) {
		return customerOrderDao.getAdhocPackageList(orderCodeId);
	}

	@Override
	public List<PackageDefinition> getPooledPackageList(int orderCodeId) {
		return customerOrderDao.getPooledPackageList(orderCodeId);
	}

	
	@Override
	public CustomerDistributionValuesModel retrieveCustomerInformation(long customer_id)
	{
		return customerOrderDao.retrieveCustomerInformationFromDataSource(customer_id);
	}

	@Override
	public List<DistributionMethodModel> retrieveDistributionMethods()
	{
		return customerOrderDao.retrieveDistributionMethodsFromDataSource();
	}
	
	@Override
	public List<DistributionAttributeModel> retrieveDistributionAttributes()
	{
		return customerOrderDao.retrieveDistributionAttributesFromDataSource();
	}
	
	@Override
	public List<DistributionValueModel> retrieveDistributionValues()
	{
		return customerOrderDao.retrieveDistributionValuesFromDataSource();
	}

	@Override
	public List<Map<String, Object>> getQuickOrderList(int orderCodeId) {
		return customerOrderDao.getQuickOrderList(orderCodeId);
	}

	@Override
	public List<PackageDefinition> getBasicPackageList(int ocId) {
		return customerOrderDao.getBasicPackageList(ocId);
	}
	
	@Override
	public List<CustomerAddressDistributionModel> retrieveCustomerAddressDistribution(long customer_id)
	{
		return customerOrderDao.retrieveCustomerAddressDistributionFromDataSource(customer_id);
	}

	@Override
	public OrderItem customerOrderPkgEdit(int customerId, String orderCodeId, String sourceCodeId,int orderCodeType,String productId,String agencyID) {
		return customerOrderDao.customerOrderPkgEdit(customerId,orderCodeId,sourceCodeId,orderCodeType,productId,agencyID);
	}

	@Override
	public Map<String, Object> getOrderDropdownData(int orderCodeId,int ocId, int orderCodeType,int customerId) {
		return customerOrderDao.getOrderDropdownData(orderCodeId, ocId, orderCodeType,customerId);
	}

	@Override
	public List<Product> getProductDefinition(int ocId) {
		return customerOrderDao.getProductDefinition(ocId);
	}
	
	@Override
	public List<Map<String, Object>> getPoolMemeberDetails(int orderCodeId) {
		return customerOrderDao.getPoolMemeberDetails(orderCodeId);
	}

	@Override
	public List<Map<String, Object>> getSubscriptionDetails(int ocId, int orderCodeId) {
		return customerOrderDao.getSubscriptionDetails(ocId, orderCodeId);
	}

	@Override
	public List<Map<String, Object>> getQuickOrderData(String orderCodeId, String sourceCodeId, int orderCodeType,int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,Optional<String> shippingPrice) {
		return customerOrderDao.getQuickOrderData(orderCodeId, sourceCodeId, orderCodeType, customerId, subscriptionIdList,agencyID, orderhdrId, shippingPrice);
	}

	@Override
	public List<Map<String, Object>> getSubscriptionDetailsByOrderCodeId(int orderCodeId) {
		return customerOrderDao.getSubscriptionDetailsByOrderCodeId(orderCodeId);
	}

	@Override
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, String required,int customerId,Integer pkgDefId) {
		return customerOrderDao.getPkgDefContentList(orderCodeId,required,customerId,pkgDefId);
	}
	@Override
	public List<DropdownModel> getCurrencyDropdown() {
		return customerOrderDao.getCurrencyDropdown();
	}
	@Override
	public List<Map<String,Object>> getPkgMember(String orderCodeId, String sourceCodeId, int orderCodeType,
			int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,
			Optional<String> shippingPrice,Integer pkgDefId) {
		return customerOrderDao.getPkgMember(orderCodeId,sourceCodeId,orderCodeType,
				customerId,subscriptionIdList,agencyID,orderhdrId,
				shippingPrice,pkgDefId);
	}

	@Override
	public List<DropdownModel> getPkgDef(String orderCodeId) {
		return customerOrderDao.getPkgDef(orderCodeId);
	}

	@Override
	public float covertedAmountByCurrency(float amount, String currency) {
		return customerOrderDao.covertedAmountByCurrency(amount,currency);
	}

	@Override
	public List<Map<String, Object>> getConfigTableDetails() {
		return customerOrderDao.getConfigTableDetails();
	}

	@Override
	public int getPromoStatus(String promoCode) {
		return customerOrderDao.getPromoStatus(promoCode);
	}

	@Override
	public Date getPromoFutureDate(String promoCode) {
		return customerOrderDao.getPromoFutureDate(promoCode);
	}

	@Override
	public Integer getSourceCodeId(String promoCode) {
		return customerOrderDao.getSourceCodeId(promoCode);
	}
	
	@Override
	public PaymentThresholdHandlingDataModel retrievePaymentThresholdHandlingData(String orderCodeId,int orderCodeType, String sourceCodeId, Integer subscriptionId,String subscriptionIdList,Double totalPaid, int customerId,int oc_type,int start_type,int revenue_method,double amount_of_order_in_progress) 
	{
		return customerOrderDao.retrievePaymentThresholdHandlingDataFromDataSource(orderCodeId, orderCodeType, sourceCodeId, subscriptionId,subscriptionIdList,totalPaid, customerId,oc_type,start_type,revenue_method,amount_of_order_in_progress);
	}
	
	@Override
	public int getRenew(int subscripId) {
		return customerOrderDao.getRenew(subscripId);
	}

	@Override
	public List<BasicPackageItemModel> getAdhocPackageData(int customerId, int orderCodeId, int sourceCodeId,
			Integer subscriptionId, int orderCodeType, String subscriptionIdList, String grossLocalAmt,
			String grossBaseAmt) {
		return customerOrderDao.getAdhocPackageData(customerId, orderCodeId,sourceCodeId,
				 subscriptionId,  orderCodeType,  subscriptionIdList,  grossLocalAmt,
				 grossBaseAmt);
	}

	@Override
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, String required) {
		return customerOrderDao.getPkgDefContentList(orderCodeId, required);
	}

	@Override
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, Integer pkgDefId) {
		return customerOrderDao.getPkgDefContentList(orderCodeId, pkgDefId);
	}
	@Override
	public Map<String,Object>retrieveAgencyData(int cancelled_order_code_type,int cancelled_order_id,int customerId)
	{
		return customerOrderDao.retrieveAgencyDataFromDataSource(cancelled_order_code_type,cancelled_order_id,customerId);
	}
}