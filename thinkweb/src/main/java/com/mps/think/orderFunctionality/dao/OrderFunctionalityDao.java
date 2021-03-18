package com.mps.think.orderFunctionality.dao;

import java.util.List;
import java.util.Map;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderItem;
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
import com.mps.think.setup.model.SubscriptionDef;

public interface OrderFunctionalityDao {

	public List<Map<String, Object>> getEditOrderHeader(long orderhdrId);

	public int updateEditOrderHeader(Orderhdr orderhdr);

	public List<SuspensionModel> getTemporarySuspension(long orderhdrId, int orderItemSeq);

	public EditSuspension getAddTempSuspension(long orderhdrId, int orderItemSeq);

	public int saveAddTempSuspension(SuspensionModel suspensionModel);

	public EditSuspension getEditSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq);

	public int updateEditSuspension(SuspensionModel suspensionModel);

	public EditSuspension getReinstateOrderItem(long orderhdrId, int orderItemSeq, int suspensionSeq);

	public List<Map<String, Object>> getExtendSubscription(long orderhdrId, int orderItemSeq);

	public int updateExtendSubscription(long orderhdrId, int orderItemSeq, int count);

	public int updateReinstateOrderItem(SuspensionModel suspensionModel);

	public Map<String, Object> getExtSubscripChange(long orderhdrId, int orderItemSeq, int count);

	public List<SuspensionModel> getBehavioralSuspension(long orderhdrId, int orderItemSeq);

	public EditSuspension getAddBehavioralSuspension(long orderhdrId, int orderItemSeq);

	public int saveAddBehavioralSuspension(SuspensionModel suspensionModel);

	public EditSuspension getEditBehavioralSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq);

	public EditSuspension getReinstateBehavioralSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq);

	public int savePayHoldSuspension(SuspensionModel suspensionModel);

	public int saveNonPaymentSuspension(SuspensionModel suspensionModel);

	public List<SuspensionModel> getPayHoldNonPaySuspension(long orderhdrId, int orderItemSeq);

	public List<SubscriptionDef> getUpgradeSubscription(int subscriptionDefId, int orderCodeId);

	public List<SubscriptionDef> getUpgradeSearch(UpDowngradeModel upDowngradeModel, int orderSubscriptionDefId);

	public List<SubscriptionDef> getDowngradeSubscription(int subscriptionDefId, int orderCodeId);

	public List<SubscriptionDef> getDowngradeSearch(UpDowngradeModel upDowngradeModel, int orderSubscriptionDefId);

	public List<OrderItemModel> getTransferOrder(long orderhdrId);

	public int saveTransferOrder(TransferOrderModel transferOrderModel);

	public int updateTransferOrder(TransferOrderModel transferOrderModel);

	public List<SubscriptionDef> getUpgradeItem(int subscriptionDefId);

	public List<DropdownModel> getAutoPayCreditCard(long orderhdrId, int orderItemSeq);

	public List<DropdownModel> getAutoPayDirectDebit(long orderhdrId, int orderItemSeq);

	public List<DropdownModel> getCancelReason();

	public List<Map<String, Object>> getRenewalOption(long orderhdrId, int orderItemSeq, int renewalStatus,
			String autoPayment);

	public int updateRenewalOption(OrderItem orderItem);

	public List<DropdownModel> getGroupGroup();

	public List<Map<String, Object>> getGroupMember(Long customerId);

	public List<GroupMemberModel> getGrpMbrSetUp();

	public List<DropdownModel> getAddress(int customerId);

	public List<DropdownModel> getAddress();

	public int saveGroupMember(TransferOrderModel transferOrderModel);

	public GroupMemberModel getEditGroupMemberSetUp(int customerId, int customerAddressSeq);

	public int updateEditGroupMember(TransferOrderModel transferOrderModel);

	public int deleteGroupMember(int customerId, int customerGroupcustomerId, int customerAddressSeq);

	public List<Map<String, Object>> getCustomerGroupMemberHistory(int custGrpCustomerId);

	public List<DropdownModel> getShipType();

	public List<DropdownModel> getNewGroupMemberAction();

	public List<DropdownModel> getBackIssueShipType();

	public CustomerGroupModel getGroup(int customerId, int customerAddressSeq);

	public List<Map<String, Object>> getGroupSearch(UpDowngradeModel upDowngradeModel);

	public int saveCustomerGroupEdit(CustomerGroupModel customerGroupModel);

	public String updateCustomerGroup(CustomerGroupModel customerGroupModel);

	public String deleteCustomerGroup(int customerId);

	public List<Map<String, Object>> getDemForm1(String demFormId, String ocId);

	public List<Map<String, Object>> getDemForm(String demFormId, String ocId);

	public List<DropdownModel> getDemographicForm(String demFormId, String ocId);

	public List<Map<String, Object>> getProspect(Long customerId);

	public ProspectModel getProspectSetup(Long customerId, int customerAddressSeq);

	public ProspectModel getEditProspectSetup(long customerId, int customerProspectSeq);

	public int deleteProspect(Long customerId, int customerProspectSeq);

	public int saveProspectSetup(ProspectModel prospectModel);

	public int updateProspectSetup(ProspectModel prospectModel);

	public List<Map<String, Object>> getGroupMemberOrderDetail(Long customerId);

	public List<DropdownModel> getAuditNameTitle(int ocId);

	public List<DropdownModel> getAuditQualSource(int ocId);

	public List<DropdownModel> getAuditSalesChannel(int ocId);

	public List<DropdownModel> getAuditSubscriptionType(int ocId);

	public ProspectModel getEditAuditInfo(Long orderHdrId, int orderItemSeq, int ocId);

	public int updateEditAuditInfo(OrderItem orderItem);

	public ProspectModel getAudit(int ocId);

	public ProspectModel getAddAuditInfo(Long orderHdrId, int orderItemSeq, int ocId);

	public int saveAuditInfo(OrderItem orderItem);

	public List<Map<String, Object>> getUpsellItem(int ocId);

	public String getUpgradeDowngrade(int subscription_def_id, String gridDefID, long orderhdrId, int orderItemSeq)
			throws Exception;

	public List<DropdownModel> getstartDate(String orderCode);

	public List<DropdownModel> getBackIssueDetails(String orderCode);

	public List<DropdownModel> getRateClassDetails(String rateClass);

	public List<DropdownModel> getCategoryDetails();

	public List<DropdownModel> getShippingDeliveryDetails();

	public List<DropdownModel> getDemographicDetails();

	public List<DropdownModel> getAddressDetails(int customerId);

	public List<Map<String, Object>> getUpsellOrder(int ocId, int orderCodeId, int sourceCodeId, int upsellId);

	public OrderItem getOrderItemEditDetails(int orderHdrId, int order_item_seq);

	public List<Map<String, Object>> getAudited(String ocId);

	public List<Map<String, Object>> getDealDetails(Long customerId);

	public List<DropdownModel> getDealType();

	public List<DropdownModel> getDealStatus();

	public String getStartEndDate1();

	public List<Map<String, Object>> getDealOrderCodeDetails(int dealId);

	public int saveDealDetails(GropDealModel deal);

	public int saveDealOrderCodeDetails(GropDealModel groupModel);

	public int updateDeals(GropDealModel groupdeal);

	public int saveSubgroupStructure(int pCustomerId, int cCustomerId);

	public int deleteStructures(int customerId);

	public String getGroupGroupDescription(int gcustomerId);

	public List<DropdownModel> getGroupMemberNames(int gcustomerId);

	public ProspectModel getAuditOrder(int ocId, String orderCodeId);

	public List<DropdownModel> getorderClassProspect();

	public List<Integer> getAllSubgroups(int gcustomerId);

	public int getDealId();

	public int saveDealOrderingCustomer(GropDealModel gropDealModel);

	public List<Map<String, Object>> getDealOrderingCustomer(int dealId);

	public List<Map<String, Object>> getGrpMbrActOrdHandling(int customerId);

	public int saveGrpMbrOrdHandling(TransferOrderModel transferOrderModel);

	public List<Map<String, Object>> getDemoDetails(int customerId);

	public List<DropdownModel> orderClassDetails();

	public List<DropdownModel> getDemographicForm1(int ocId);

	public int saveDemoDetails(DemographicsModel demographicsModel);

	public int updateDemoDetails(DemographicsModel demographicsModel);

	public int deleteDemoDetails(DemographicsModel demographicsModel);

	public List<DemographicChildModel> getDemographicChildList();

	public List<DropdownModel> getDemResponse(int demQuesId);

	public List<Map<String, Object>> addDemResponse(int ocId);

	public List<Map<String, Object>> getgroupDetails(int dealId);

	public List<Map<String, Object>> getGroupOrder(int customerId);

	public List<Map<String, Object>> getActiveOC(int customerId, int oId);

	public List<Map<String, Object>> getAddrStatus(int customerId);

	public List<Map<String, Object>> getGroupMemberEnable(int customerId);

	

}
