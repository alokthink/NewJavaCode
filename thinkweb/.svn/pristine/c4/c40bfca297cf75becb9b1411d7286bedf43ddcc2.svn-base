package com.mps.think.orderFunctionality.serviceImp;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderItem;
import com.mps.think.orderFunctionality.dao.OrderFunctionalityDao;
import com.mps.think.orderFunctionality.model.BehavioralSuspension;
import com.mps.think.orderFunctionality.model.CustomerGroupModel;
import com.mps.think.orderFunctionality.model.DemographicChildModel;
import com.mps.think.orderFunctionality.model.DemographicsModel;
import com.mps.think.orderFunctionality.model.EditSuspension;
import com.mps.think.orderFunctionality.model.GropDealModel;
import com.mps.think.orderFunctionality.model.GroupMemberModel;
import com.mps.think.orderFunctionality.model.Orderhdr;
import com.mps.think.orderFunctionality.model.ProspectModel;
import com.mps.think.orderFunctionality.model.SuspensionModel;
import com.mps.think.orderFunctionality.model.TransferOrderModel;
import com.mps.think.orderFunctionality.model.OrderItemModel;
import com.mps.think.orderFunctionality.model.UpDowngradeModel;
import com.mps.think.orderFunctionality.service.OrderFunctionalityService;
import com.mps.think.setup.model.SubscriptionDef;

@Service("OrderFunctionalityService")
public class OrderFunctionalityServiceImp implements OrderFunctionalityService {

	@Autowired
	OrderFunctionalityDao orderFunctionalityDao;

	@Override
	public List<Map<String, Object>> getEditOrderHeader(long orderhdrId) {
		return orderFunctionalityDao.getEditOrderHeader(orderhdrId);
	}

	@Override
	public int updateEditOrderHeader(Orderhdr orderhdr) {
		return orderFunctionalityDao.updateEditOrderHeader(orderhdr);
	}

	@Override
	public List<SuspensionModel> getTemporarySuspension(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getTemporarySuspension(orderhdrId, orderItemSeq);
	}

	@Override
	public EditSuspension getAddTempSuspension(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getAddTempSuspension(orderhdrId, orderItemSeq);
	}

	@Override
	public int saveAddTempSuspension(SuspensionModel suspensionModel) {
		return orderFunctionalityDao.saveAddTempSuspension(suspensionModel);
	}

	@Override
	public EditSuspension getEditSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		return orderFunctionalityDao.getEditSuspension(orderhdrId, orderItemSeq, suspensionSeq);
	}

	@Override
	public int updateEditSuspension(SuspensionModel suspensionModel) {
		return orderFunctionalityDao.updateEditSuspension(suspensionModel);
	}

	@Override
	public EditSuspension getReinstateOrderItem(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		return orderFunctionalityDao.getReinstateOrderItem(orderhdrId, orderItemSeq, suspensionSeq);
	}

	@Override
	public int updateReinstateOrderItem(SuspensionModel suspensionModel) {
		return orderFunctionalityDao.updateReinstateOrderItem(suspensionModel);
	}

	@Override
	public List<Map<String, Object>> getExtendSubscription(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getExtendSubscription(orderhdrId, orderItemSeq);
	}

	@Override
	public int updateExtendSubscription(long orderhdrId, int orderItemSeq, int count) {
		return orderFunctionalityDao.updateExtendSubscription(orderhdrId, orderItemSeq, count);
	}

	@Override
	public Map<String, Object> getExtSubscripChange(long orderhdrId, int orderItemSeq, int count) {
		return orderFunctionalityDao.getExtSubscripChange(orderhdrId, orderItemSeq, count);
	}

	@Override
	public List<SuspensionModel> getBehavioralSuspension(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getBehavioralSuspension(orderhdrId, orderItemSeq);
	}

	@Override
	public EditSuspension getAddBehavioralSuspension(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getAddBehavioralSuspension(orderhdrId, orderItemSeq);
	}

	@Override
	public int saveAddBehavioralSuspension(SuspensionModel suspensionModel) {
		return orderFunctionalityDao.saveAddBehavioralSuspension(suspensionModel);
	}

	@Override
	public EditSuspension getEditBehavioralSuspension(long orderhdrId, int orderItemSeq,
			int suspensionSeq) {
		return orderFunctionalityDao.getEditBehavioralSuspension(orderhdrId, orderItemSeq, suspensionSeq);
	}

	@Override
	public EditSuspension getReinstateBehavioralSuspension(long orderhdrId, int orderItemSeq,
			int suspensionSeq) {
		return orderFunctionalityDao.getReinstateBehavioralSuspension(orderhdrId, orderItemSeq, suspensionSeq);
	}

	@Override
	public int savePayHoldSuspension(SuspensionModel suspensionModel) {
		return orderFunctionalityDao.savePayHoldSuspension(suspensionModel);
	}

	@Override
	public int saveNonPaymentSuspension(SuspensionModel suspensionModel) {
		return orderFunctionalityDao.saveNonPaymentSuspension(suspensionModel);
	}

	@Override
	public List<SuspensionModel> getPayHoldNonPaySuspension(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
	}

	@Override
	public List<SubscriptionDef> getUpgradeSubscription(int subscriptionDefId, int orderCodeId) {
		return orderFunctionalityDao.getUpgradeSubscription(subscriptionDefId, orderCodeId);
	}

	@Override
	public List<SubscriptionDef> getUpgradeSearch(UpDowngradeModel upDowngradeModel,int orderSubscriptionDefId) {
		return orderFunctionalityDao.getUpgradeSearch(upDowngradeModel, orderSubscriptionDefId);
	}

	@Override
	public List<SubscriptionDef> getDowngradeSubscription(int subscriptionDefId, int orderCodeId) {
		return orderFunctionalityDao.getDowngradeSubscription(subscriptionDefId, orderCodeId);
	}

	@Override
	public List<SubscriptionDef> getDowngradeSearch(UpDowngradeModel upDowngradeModel,int orderSubscriptionDefId) {
		return orderFunctionalityDao.getDowngradeSearch(upDowngradeModel,orderSubscriptionDefId);
	}

	@Override
	public List<OrderItemModel> getTransferOrder(long orderhdrId) {
		return orderFunctionalityDao.getTransferOrder(orderhdrId);
	}

	@Override
	public int saveTransferOrder(TransferOrderModel transferOrderModel) {
		return orderFunctionalityDao.saveTransferOrder(transferOrderModel);
	}

	@Override
	public int updateTransferOrder(TransferOrderModel transferOrderModel) {
		return orderFunctionalityDao.updateTransferOrder(transferOrderModel);
	}

	@Override
	public List<SubscriptionDef> getUpgradeItem(int subscriptionDefId) {
		return orderFunctionalityDao.getUpgradeItem(subscriptionDefId);
	}

	@Override
	public List<Map<String, Object>> getRenewalOption(long orderhdrId, int orderItemSeq, int renewalStatus,
			String autoPayment) {
		return orderFunctionalityDao.getRenewalOption(orderhdrId, orderItemSeq, renewalStatus, autoPayment);
	}

	@Override
	public List<DropdownModel> getAutoPayCreditCard(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getAutoPayCreditCard(orderhdrId, orderItemSeq);
	}

	@Override
	public List<DropdownModel> getAutoPayDirectDebit(long orderhdrId, int orderItemSeq) {
		return orderFunctionalityDao.getAutoPayDirectDebit(orderhdrId, orderItemSeq);
	}

	@Override
	public List<DropdownModel> getCancelReason() {
		return orderFunctionalityDao.getCancelReason();
	}

	@Override
	public int updateRenewalOption(OrderItem orderItem) {
		return orderFunctionalityDao.updateRenewalOption(orderItem);
	}

	@Override
	public List<Map<String, Object>> getGroupMember(Long customerId) {
		return orderFunctionalityDao.getGroupMember(customerId);
	}

	@Override
	public List<GroupMemberModel> getGrpMbrSetUp() {
		return orderFunctionalityDao.getGrpMbrSetUp();
	}

	@Override
	public List<DropdownModel> getAddress(int customerId) {
		return orderFunctionalityDao.getAddress(customerId);
	}

	@Override
	public List<DropdownModel> getAddress() {
		return orderFunctionalityDao.getAddress();
	}

	@Override
	public int saveGroupMember(TransferOrderModel transferOrderModel) {
		return orderFunctionalityDao.saveGroupMember(transferOrderModel);
	}

	@Override
	public GroupMemberModel getEditGroupMemberSetUp(int customerId, int customerAddressSeq) {
		return orderFunctionalityDao.getEditGroupMemberSetUp(customerId, customerAddressSeq);
	}

	@Override
	public int updateEditGroupMember(TransferOrderModel transferOrderModel) {
		return orderFunctionalityDao.updateEditGroupMember(transferOrderModel);
	}

	@Override
	public int deleteGroupMember(int customerId, int customerGroupcustomerId, int customerAddressSeq) {
		return orderFunctionalityDao.deleteGroupMember(customerId, customerGroupcustomerId, customerAddressSeq);
	}

	@Override
	public List<Map<String, Object>> getCustomerGroupMemberHistory(int custGrpCustomerId) {
		return orderFunctionalityDao.getCustomerGroupMemberHistory(custGrpCustomerId);
	}

	@Override
	public int saveCustomerGroupEdit(CustomerGroupModel customerGroupModel) {
		return orderFunctionalityDao.saveCustomerGroupEdit(customerGroupModel);
	}

	@Override
	public CustomerGroupModel getGroup(int customerId, int customerAddressSeq) {
		return orderFunctionalityDao.getGroup(customerId, customerAddressSeq);
	}

	@Override
	public List<Map<String, Object>> getGroupSearch(UpDowngradeModel upDowngradeModel) {
		return orderFunctionalityDao.getGroupSearch(upDowngradeModel);
	}

	@Override
	public String updateCustomerGroup(CustomerGroupModel customerGroupModel) {
		return orderFunctionalityDao.updateCustomerGroup(customerGroupModel);
	}

	@Override
	public String deleteCustomerGroup(int customerId) {
		return orderFunctionalityDao.deleteCustomerGroup(customerId);
	}

	@Override
	public List<Map<String, Object>> getDemForm(String demFormId, String ocId) {
		return orderFunctionalityDao.getDemForm(demFormId, ocId);
	}

	@Override
	public List<DropdownModel> getDemographicForm(String demFormId, String ocId) {
		return orderFunctionalityDao.getDemographicForm(demFormId, ocId);
	}

	@Override
	public List<Map<String, Object>> getDemForm1(String demFormId, String ocId) {
		return orderFunctionalityDao.getDemForm1(demFormId, ocId);
	}

	@Override
	public List<Map<String, Object>> getProspect(Long customerId) {
		return orderFunctionalityDao.getProspect(customerId);
	}
	
	@Override
	public ProspectModel getProspectSetup(Long customerId, int customerAddressSeq) {
		return orderFunctionalityDao.getProspectSetup(customerId, customerAddressSeq);
	}

	@Override
	public ProspectModel getEditProspectSetup(Long customerId, int customerProspectSeq) {
		return orderFunctionalityDao.getEditProspectSetup(customerId, customerProspectSeq);
	}

	@Override
	public int deleteProspect(Long customerId, int customerProspectSeq) {
		return orderFunctionalityDao.deleteProspect(customerId, customerProspectSeq);
	}

	@Override
	public int saveProspectSetup(ProspectModel prospectModel) {
		return orderFunctionalityDao.saveProspectSetup(prospectModel);
	}

	@Override
	public int UpdateProspectSetup(ProspectModel prospectModel) {
		return orderFunctionalityDao.updateProspectSetup(prospectModel);
	}

	@Override
	public List<Map<String, Object>> getGroupMemberOrderDetail(Long customerId) {
		return orderFunctionalityDao.getGroupMemberOrderDetail(customerId);
	}

	@Override
	public ProspectModel getEditAuditInfo(Long orderHdrId, int orderItemSeq, int ocId) {
		return orderFunctionalityDao.getEditAuditInfo(orderHdrId, orderItemSeq, ocId);
	}

	@Override
	public List<DropdownModel> getAuditNameTitle(int ocId) {
		return orderFunctionalityDao.getAuditNameTitle(ocId);
	}

	@Override
	public List<DropdownModel> getAuditQualSource(int ocId) {
		return orderFunctionalityDao.getAuditQualSource(ocId);
	}

	@Override
	public List<DropdownModel> getAuditSalesChannel(int ocId) {
		return orderFunctionalityDao.getAuditSalesChannel(ocId);
	}

	@Override
	public List<DropdownModel> getAuditSubscriptionType(int ocId) {
		return orderFunctionalityDao.getAuditSubscriptionType(ocId);
	}

	@Override
	public int updateEditAuditInfo(OrderItem orderItem) {
		return orderFunctionalityDao.updateEditAuditInfo(orderItem);
	}

	@Override
	public ProspectModel getAudit(int ocId) {
		return orderFunctionalityDao.getAudit(ocId);
	}

	@Override
	public ProspectModel getAddAuditInfo(Long orderHdrId, int orderItemSeq, int ocId) {
		return orderFunctionalityDao.getAddAuditInfo(orderHdrId, orderItemSeq, ocId);
	}

	@Override
	public List<DropdownModel> getShipType() {
		return orderFunctionalityDao.getShipType();
	}

	@Override
	public List<DropdownModel> getNewGroupMemberAction() {
		return orderFunctionalityDao.getNewGroupMemberAction();
	}

	@Override
	public List<DropdownModel> getBackIssueShipType() {
		return orderFunctionalityDao.getBackIssueShipType();
	}

	@Override
	public List<Map<String, Object>> getUpsellItem(int ocId) {
		return orderFunctionalityDao.getUpsellItem(ocId);
	}

	@Override
	public String getUpgradeDowngrade(int subscription_def_id, String gridDefID, long orderhdrId, int orderItemSeq)
			throws Exception {
		return orderFunctionalityDao.getUpgradeDowngrade(subscription_def_id, gridDefID, orderhdrId, orderItemSeq);
	}
	
	@Override
	public List<DropdownModel> getStartDate(String orderCode) {
		return orderFunctionalityDao.getstartDate(orderCode);
	}

	@Override
	public List<DropdownModel> getBackIssueDetails(String orderCode) {
		return  orderFunctionalityDao.getBackIssueDetails(orderCode);
	}

	@Override
	public List<DropdownModel> getRateBackDetails(String orderCode) {
		return  orderFunctionalityDao.getRateClassDetails(orderCode);
	}

	@Override
	public List<DropdownModel> getCategoryDetails() {
		return  orderFunctionalityDao.getCategoryDetails();
	}

	@Override
	public List<DropdownModel> getShippingDeliveryDetails() {
		return  orderFunctionalityDao.getShippingDeliveryDetails();
	}

	@Override
	public List<DropdownModel> getDemographicDetails() {
		return  orderFunctionalityDao.getDemographicDetails();
	}
	@Override
	public List<DropdownModel> getAddressDetails(int customerId) {
		return orderFunctionalityDao.getAddressDetails(customerId);
	}

	@Override
	public List<Map<String, Object>> getUpsellOrder(int ocId, int orderCodeId, int sourceCodeId,int upsellId) {
		return orderFunctionalityDao.getUpsellOrder(ocId, orderCodeId, sourceCodeId,upsellId);
	}

	@Override
	public OrderItem getOrderItemEditDetails(int orderHdrId, int order_item_seq) {
		return orderFunctionalityDao.getOrderItemEditDetails(orderHdrId,order_item_seq);
	}

	@Override
	public List<Map<String, Object>> getAudited(String ocId) {
		return orderFunctionalityDao.getAudited(ocId);
	}
	

	@Override
	public List<Map<String, Object>> getDealDetails(Long customerId) {
		return orderFunctionalityDao.getDealDetails(customerId);
	}

	@Override
	public List<DropdownModel> getDealType() {
	
		return orderFunctionalityDao.getDealType();
	}

	@Override
	public List<DropdownModel> getDealStatus() {
		return orderFunctionalityDao.getDealStatus();
	}

	@Override
	public String getStartEndDate1() {
		return orderFunctionalityDao.getStartEndDate1();
	}

	@Override
	public List<Map<String, Object>> getDealOrderCodeDetails(int dealId) {
		return orderFunctionalityDao.getDealOrderCodeDetails(dealId);
	}

	@Override
	public int saveDealDetails(GropDealModel deal) {
		return orderFunctionalityDao.saveDealDetails(deal);
	}

	@Override
	public int saveDealOrderCodeDetails(GropDealModel groupModel) {
		return orderFunctionalityDao.saveDealOrderCodeDetails(groupModel);
	}

	@Override
	public int updateDeals(GropDealModel groupdeal) {
		return orderFunctionalityDao.updateDeals(groupdeal);
	}
	
	@Override
	public int saveSubgroupStructure(int pCustomerId,int cCustomerId) {
		return orderFunctionalityDao.saveSubgroupStructure(pCustomerId,cCustomerId);
	}

	@Override
	public int deleteStructures(int customerId) {
		return orderFunctionalityDao.deleteStructures(customerId);
	}

	@Override
	public String getGroupGroupDescription(int gcustomerId) {
		return orderFunctionalityDao.getGroupGroupDescription(gcustomerId);
		
	}

	@Override
	public List<DropdownModel> getGroupMemberNames(int gcustomerId) {
		return orderFunctionalityDao.getGroupMemberNames(gcustomerId);
	}

	@Override
	public ProspectModel getAuditOrder(int ocId, String orderCodeId) {
		return orderFunctionalityDao.getAuditOrder(ocId, orderCodeId);
	}

	
	

	@Override
	public List<DropdownModel> getorderClassProspect() {
		return orderFunctionalityDao.getorderClassProspect();
	}
	
	
	@Override
	public List<Integer> getAllSubgroups(int gcustomerId) {
		return  orderFunctionalityDao.getAllSubgroups(gcustomerId);
		
	}

	@Override
	public int getDealId() {
		return  orderFunctionalityDao.getDealId();
	}

	@Override
	public int saveDealOrderingCustomer(GropDealModel gropDealModel) {
		return  orderFunctionalityDao.saveDealOrderingCustomer(gropDealModel);
	}

	@Override
	public List<Map<String, Object>> getDealOrderingCustomer(int dealId) {
		return  orderFunctionalityDao.getDealOrderingCustomer(dealId);
	}

	@Override
	public List<Map<String, Object>> getGrpMbrActOrdHandling(int customerId) {
		return orderFunctionalityDao.getGrpMbrActOrdHandling(customerId);
	}

	@Override
	public int saveGrpMbrOrdHandling(TransferOrderModel transferOrderModel) {
		return orderFunctionalityDao.saveGrpMbrOrdHandling(transferOrderModel);
	}
	
	@Override
	public List<Map<String, Object>> getDemoDetails(int customerId) {
		return  orderFunctionalityDao.getDemoDetails(customerId);
	}

	@Override
	public List<DropdownModel> orderClassDetails() {
		return  orderFunctionalityDao.orderClassDetails();
	}

	@Override
	public  List<DropdownModel> getDemographicForm1(int ocId) {
		return  orderFunctionalityDao.getDemographicForm1(ocId);
	}

	

	@Override
	public int saveDemoDetails(DemographicsModel demographicsModel) {
		return  orderFunctionalityDao.saveDemoDetails(demographicsModel);
	}

	@Override
	public int updateDemoDetails(DemographicsModel demographicsModel) {
		return  orderFunctionalityDao.updateDemoDetails(demographicsModel);
	}

	@Override
	public int deleteDemoDetails(DemographicsModel demographicsModel) {
		return  orderFunctionalityDao.deleteDemoDetails(demographicsModel);
	}


	

	@Override
	public List<DemographicChildModel> getDemographicChildList() {
		return  orderFunctionalityDao.getDemographicChildList();
	}

	@Override
	public List<DropdownModel> getDemResponse(int demQuesId) {
		return  orderFunctionalityDao.getDemResponse(demQuesId);
	}

	@Override
	public List<Map<String, Object>> addDemResponse(int ocId) {
		return orderFunctionalityDao.addDemResponse(ocId);
	}

	@Override
	public List<Map<String, Object>> getgroupDetails(int dealId) {
		return orderFunctionalityDao.getgroupDetails(dealId);
	}

	@Override
	public List<Map<String, Object>> getGroupOrder(int customerId) {
		return orderFunctionalityDao.getGroupOrder(customerId);
	}

	@Override
	public List<Map<String, Object>> getActiveOC(int customerId, int ocId) {
		return orderFunctionalityDao.getActiveOC(customerId, ocId);
	}

	@Override
	public String getAddrStatus(int customerId) {
		return orderFunctionalityDao.getAddrStatus(customerId);
	}
                           	
}


