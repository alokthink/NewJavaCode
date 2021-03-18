package Think.XmlWebServices;

public class ThinkSoapProxy implements Think.XmlWebServices.ThinkSoap {
  private String _endpoint = null;
  private Think.XmlWebServices.ThinkSoap thinkSoap = null;
  
  public ThinkSoapProxy() {
    _initThinkSoapProxy();
  }
  
  public ThinkSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initThinkSoapProxy();
  }
  
  private void _initThinkSoapProxy() {
    try {
      thinkSoap = (new Think.XmlWebServices.ThinkWSLocator()).getThinkSoap();
      if (thinkSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)thinkSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)thinkSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (thinkSoap != null)
      ((javax.xml.rpc.Stub)thinkSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Think.XmlWebServices.ThinkSoap getThinkSoap() {
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap;
  }
  
  public Think.XmlWebServices.Px_header_select_response pxHeaderSelect(Think.XmlWebServices.Px_header_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pxHeaderSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_type_select_responsePayment_type[] paymentTypeSelect(Think.XmlWebServices.Payment_type_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentTypeSelect(parameters);
  }
  
  public Think.XmlWebServices.Oc_list_by_topic_select_responseOc_list_by_topic[] ocListByTopicSelect(Think.XmlWebServices.Oc_list_by_topic_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocListByTopicSelect(parameters);
  }
  
  public Think.XmlWebServices.Oc_descr_select_response ocDescrSelect(Think.XmlWebServices.Oc_descr_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocDescrSelect(parameters);
  }
  
  public Think.XmlWebServices.Oc_for_prospect_select_response ocForProspectSelect(Think.XmlWebServices.Oc_for_prospect_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocForProspectSelect(parameters);
  }
  
  public Think.XmlWebServices.Special_offers_select_response specialOffersSelect(Think.XmlWebServices.Special_offers_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.specialOffersSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_payment_select_response orderPaymentSelect(Think.XmlWebServices.Order_payment_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderPaymentSelect(parameters);
  }
  
  public Think.XmlWebServices.Base_currency_select_response baseCurrencySelect(Think.XmlWebServices.Base_currency_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.baseCurrencySelect(parameters);
  }
  
  public Think.XmlWebServices.Config_select_response configSelect(Think.XmlWebServices.Config_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.configSelect(parameters);
  }
  
  public Think.XmlWebServices.Currency_select_responseCurrency[] currencySelect(Think.XmlWebServices.Currency_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.currencySelect(parameters);
  }
  
  public Think.XmlWebServices.State_select_responseState[] stateSelect(Think.XmlWebServices.State_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.stateSelect(parameters);
  }
  
  public Think.XmlWebServices.State_nonsuppressed_select_responseState[] stateNonsuppressedSelect(Think.XmlWebServices.State_nonsuppressed_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.stateNonsuppressedSelect(parameters);
  }
  
  public Think.XmlWebServices.Pub_list_select_responsePub[] pubListSelect(Think.XmlWebServices.Pub_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pubListSelect(parameters);
  }
  
  public Think.XmlWebServices.Pub_select_responsePub[] pubSelect(Think.XmlWebServices.Pub_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pubSelect(parameters);
  }
  
  public Think.XmlWebServices.Product_list_select_responseOc[] productListSelect(Think.XmlWebServices.Product_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.productListSelect(parameters);
  }
  
  public Think.XmlWebServices.Package_list_select_responseOrder_code_with_pkg_def[] packageListSelect(Think.XmlWebServices.Package_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.packageListSelect(parameters);
  }
  
  public Think.XmlWebServices.Package_descr_select_response packageDescrSelect(Think.XmlWebServices.Package_descr_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.packageDescrSelect(parameters);
  }
  
  public Think.XmlWebServices.Package_content_select_responseView_pkg_def_content[] packageContentSelect(Think.XmlWebServices.Package_content_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.packageContentSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer_info_select_response customerInfoSelect(Think.XmlWebServices.Customer_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_info_select_response paymentAccountInfoSelect(Think.XmlWebServices.Payment_account_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Address_info_select_response addressInfoSelect(Think.XmlWebServices.Address_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.addressInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Subscrip_list_select_response subscripListSelect(Think.XmlWebServices.Subscrip_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subscripListSelect(parameters);
  }
  
  public Think.XmlWebServices.Package_order_list_select_response packageOrderListSelect(Think.XmlWebServices.Package_order_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.packageOrderListSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_clear_status_descr_select_response paymentClearStatusDescrSelect(Think.XmlWebServices.Payment_clear_status_descr_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentClearStatusDescrSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_list_select_response paymentListSelect(Think.XmlWebServices.Payment_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentListSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_amount_info_select_responsePayment[] paymentAmountInfoSelect(Think.XmlWebServices.Payment_amount_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAmountInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Product_order_list_select_response productOrderListSelect(Think.XmlWebServices.Product_order_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.productOrderListSelect(parameters);
  }
  
  public Think.XmlWebServices.Current_issue_select_response currentIssueSelect(Think.XmlWebServices.Current_issue_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.currentIssueSelect(parameters);
  }
  
  public Think.XmlWebServices.Source_code_select_response sourceCodeSelect(Think.XmlWebServices.Source_code_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.sourceCodeSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_addresses_select_responseOrder_item[] orderAddressesSelect(Think.XmlWebServices.Order_addresses_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderAddressesSelect(parameters);
  }
  
  public Think.XmlWebServices.Issue_list_select_responseIssue[] issueListSelect(Think.XmlWebServices.Issue_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.issueListSelect(parameters);
  }
  
  public Think.XmlWebServices.Issue_select_response issueSelect(Think.XmlWebServices.Issue_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.issueSelect(parameters);
  }
  
  public Think.XmlWebServices.Prospect_select_response prospectSelect(Think.XmlWebServices.Prospect_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.prospectSelect(parameters);
  }
  
  public Think.XmlWebServices.Promotion_history_offer_list_select_response promotionHistoryOfferListSelect(Think.XmlWebServices.Promotion_history_offer_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.promotionHistoryOfferListSelect(parameters);
  }
  
  public Think.XmlWebServices.Renewal_history_offer_list_select_responseRenewal_history_offer[] renewalHistoryOfferListSelect(Think.XmlWebServices.Renewal_history_offer_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.renewalHistoryOfferListSelect(parameters);
  }
  
  public Think.XmlWebServices.Source_code_lookup_select_responseSource_code[] sourceCodeLookupSelect(Think.XmlWebServices.Source_code_lookup_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.sourceCodeLookupSelect(parameters);
  }
  
  public Think.XmlWebServices.Items_by_orderhdr_select_responseOrder_item[] itemsByOrderhdrSelect(Think.XmlWebServices.Items_by_orderhdr_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemsByOrderhdrSelect(parameters);
  }
  
  public Think.XmlWebServices.Active_orders_for_group_select_response activeOrdersForGroupSelect(Think.XmlWebServices.Active_orders_for_group_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.activeOrdersForGroupSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer_group_info_select_response customerGroupInfoSelect(Think.XmlWebServices.Customer_group_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerGroupInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Replacement_order_code_list_select_responseOrder_code[] replacementOrderCodeListSelect(Think.XmlWebServices.Replacement_order_code_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.replacementOrderCodeListSelect(parameters);
  }
  
  public Think.XmlWebServices.Service_note_select_response serviceNoteSelect(Think.XmlWebServices.Service_note_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.serviceNoteSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_item_note_select_responseOrder_item_note[] orderItemNoteSelect(Think.XmlWebServices.Order_item_note_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemNoteSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_note_select_responsePayment_note[] paymentNoteSelect(Think.XmlWebServices.Payment_note_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentNoteSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_code_install_plan_select_responseOrder_code_install_plan[] orderCodeInstallPlanSelect(Think.XmlWebServices.Order_code_install_plan_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderCodeInstallPlanSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer_login_info_select_response customerLoginInfoSelect(Think.XmlWebServices.Customer_login_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerLoginInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Password_info_select_response passwordInfoSelect(Think.XmlWebServices.Password_info_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.passwordInfoSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer_login_question_list_select_responseCustomer_login_question[] customerLoginQuestionListSelect(Think.XmlWebServices.Customer_login_question_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerLoginQuestionListSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_code_select_responseOrder_code[] orderCodeSelect(Think.XmlWebServices.Order_code_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderCodeSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_code_list_select_responseOrder_code[] orderCodeListSelect(Think.XmlWebServices.Order_code_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderCodeListSelect(parameters);
  }
  
  public Think.XmlWebServices.Items_needing_distribution_select_response itemsNeedingDistributionSelect(Think.XmlWebServices.Items_needing_distribution_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemsNeedingDistributionSelect(parameters);
  }
  
  public Think.XmlWebServices.User_authority_select_response userAuthoritySelect(Think.XmlWebServices.User_authority_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userAuthoritySelect(parameters);
  }
  
  public Think.XmlWebServices.User_group_rights_select_responseUser_group_rights[] userGroupRightsSelect(Think.XmlWebServices.User_group_rights_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userGroupRightsSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer_credit_status_select_response customerCreditStatusSelect(Think.XmlWebServices.Customer_credit_status_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerCreditStatusSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_order_item_select_response paymentAccountOrderItemSelect(Think.XmlWebServices.Payment_account_order_item_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountOrderItemSelect(parameters);
  }
  
  public Think.XmlWebServices.Renewal_chain_select_responseOrder_item[] renewalChainSelect(Think.XmlWebServices.Renewal_chain_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.renewalChainSelect(parameters);
  }
  
  public Think.XmlWebServices.Job_process_running_select_responseJob_process_running[] jobProcessRunningSelect(Think.XmlWebServices.Job_process_running_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobProcessRunningSelect(parameters);
  }
  
  public Think.XmlWebServices.Journal_select_responseJournal[] journalSelect(Think.XmlWebServices.Journal_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.journalSelect(parameters);
  }
  
  public Think.XmlWebServices.Checked_out_unit_list_select_response checkedOutUnitListSelect(Think.XmlWebServices.Checked_out_unit_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.checkedOutUnitListSelect(parameters);
  }
  
  public Think.XmlWebServices.Address_list_select_response addressListSelect(Think.XmlWebServices.Address_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.addressListSelect(parameters);
  }
  
  public Think.XmlWebServices.Company_list_select_response companyListSelect(Think.XmlWebServices.Company_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.companyListSelect(parameters);
  }
  
  public Think.XmlWebServices.Sales_representative_list_select_responseSales_representative[] salesRepresentativeListSelect(Think.XmlWebServices.Sales_representative_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.salesRepresentativeListSelect(parameters);
  }
  
  public Think.XmlWebServices.Review_payments_list_select_responseView_payment_review[] reviewPaymentsListSelect(Think.XmlWebServices.Review_payments_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.reviewPaymentsListSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_item_account_select_responseOrder_item_account[] orderItemAccountSelect(Think.XmlWebServices.Order_item_account_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemAccountSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_item_acc_break_select_responseOrder_item_acc_break[] orderItemAccBreakSelect(Think.XmlWebServices.Order_item_acc_break_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemAccBreakSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_item_select_responseOrder_item[] orderItemSelect(Think.XmlWebServices.Order_item_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemSelect(parameters);
  }
  
  public Think.XmlWebServices.Suspension_list_select_responseSuspension[] suspensionListSelect(Think.XmlWebServices.Suspension_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.suspensionListSelect(parameters);
  }
  
  public Think.XmlWebServices.Back_issue_list_select_responseBack_issue[] backIssueListSelect(Think.XmlWebServices.Back_issue_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.backIssueListSelect(parameters);
  }
  
  public Think.XmlWebServices.Back_issue_full_list_select_responseBack_issue[] backIssueFullListSelect(Think.XmlWebServices.Back_issue_full_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.backIssueFullListSelect(parameters);
  }
  
  public Think.XmlWebServices.Missed_issues_list_select_responseMissed_issues[] missedIssuesListSelect(Think.XmlWebServices.Missed_issues_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.missedIssuesListSelect(parameters);
  }
  
  public Think.XmlWebServices.Request_log_select_responseRequest_log[] requestLogSelect(Think.XmlWebServices.Request_log_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.requestLogSelect(parameters);
  }
  
  public Think.XmlWebServices.Service_with_notes_select_responseService_item[] serviceWithNotesSelect(Think.XmlWebServices.Service_with_notes_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.serviceWithNotesSelect(parameters);
  }
  
  public Think.XmlWebServices.Last_edit_date_select_response lastEditDateSelect(Think.XmlWebServices.Last_edit_date_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.lastEditDateSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer_service_items_by_user_select_responseService[] customerServiceItemsByUserSelect(Think.XmlWebServices.Customer_service_items_by_user_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerServiceItemsByUserSelect(parameters);
  }
  
  public Think.XmlWebServices.Oc_full_list_select_responseOc[] ocFullListSelect(Think.XmlWebServices.Oc_full_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocFullListSelect(parameters);
  }
  
  public Think.XmlWebServices.Order_code_full_list_select_responseOrder_code[] orderCodeFullListSelect(Think.XmlWebServices.Order_code_full_list_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderCodeFullListSelect(parameters);
  }
  
  public Think.XmlWebServices.Jqs_config_select_responseJqs_config[] jqsConfigSelect(Think.XmlWebServices.Jqs_config_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsConfigSelect(parameters);
  }
  
  public Think.XmlWebServices.Jqs_machine_by_name_select_responseJqs_machine[] jqsMachineByNameSelect(Think.XmlWebServices.Jqs_machine_by_name_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsMachineByNameSelect(parameters);
  }
  
  public Think.XmlWebServices.Jqs_machine_select_responseJqs_machine[] jqsMachineSelect(Think.XmlWebServices.Jqs_machine_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsMachineSelect(parameters);
  }
  
  public Think.XmlWebServices.Jqs_queue_by_machine_select_responseJqs_queue[] jqsQueueByMachineSelect(Think.XmlWebServices.Jqs_queue_by_machine_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsQueueByMachineSelect(parameters);
  }
  
  public Think.XmlWebServices.Jobs_ready_by_queue_select_responseJob[] jobsReadyByQueueSelect(Think.XmlWebServices.Jobs_ready_by_queue_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobsReadyByQueueSelect(parameters);
  }
  
  public Think.XmlWebServices.Queue_select_responseQueue[] queueSelect(Think.XmlWebServices.Queue_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.queueSelect(parameters);
  }
  
  public Think.XmlWebServices.Jqs_alert_select_responseJqs_alert[] jqsAlertSelect(Think.XmlWebServices.Jqs_alert_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsAlertSelect(parameters);
  }
  
  public Think.XmlWebServices.Jobs_queueable_select_responseJob[] jobsQueueableSelect(Think.XmlWebServices.Jobs_queueable_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobsQueueableSelect(parameters);
  }
  
  public Think.XmlWebServices.Job_log_select_responseJob_log[] jobLogSelect(Think.XmlWebServices.Job_log_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobLogSelect(parameters);
  }
  
  public Think.XmlWebServices.Jqs_work_table_error_log_select_responseJqs_work_table_error_log[] jqsWorkTableErrorLogSelect(Think.XmlWebServices.Jqs_work_table_error_log_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsWorkTableErrorLogSelect(parameters);
  }
  
  public Think.XmlWebServices.Domain_value_descr_select_response domainValueDescrSelect(Think.XmlWebServices.Domain_value_descr_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.domainValueDescrSelect(parameters);
  }
  
  public Think.XmlWebServices.Process_select_responseProcess[] processSelect(Think.XmlWebServices.Process_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.processSelect(parameters);
  }
  
  public Think.XmlWebServices.Jobs_done_by_process_select_responseJob[] jobsDoneByProcessSelect(Think.XmlWebServices.Jobs_done_by_process_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobsDoneByProcessSelect(parameters);
  }
  
  public Think.XmlWebServices.Job_select_responseJob[] jobSelect(Think.XmlWebServices.Job_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobSelect(parameters);
  }
  
  public Think.XmlWebServices.Job_renewal_effort_select_responseJob_renewal_effort[] jobRenewalEffortSelect(Think.XmlWebServices.Job_renewal_effort_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobRenewalEffortSelect(parameters);
  }
  
  public Think.XmlWebServices.Job_billing_effort_select_responseJob_billing_effort[] jobBillingEffortSelect(Think.XmlWebServices.Job_billing_effort_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobBillingEffortSelect(parameters);
  }
  
  public Think.XmlWebServices.View_label_hist_dtl_select_responseView_label_hist_dtl[] viewLabelHistDtlSelect(Think.XmlWebServices.View_label_hist_dtl_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewLabelHistDtlSelect(parameters);
  }
  
  public Think.XmlWebServices.View_renewal_effort_by_oc_select_responseView_renewal_effort_by_oc[] viewRenewalEffortByOcSelect(Think.XmlWebServices.View_renewal_effort_by_oc_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewRenewalEffortByOcSelect(parameters);
  }
  
  public Think.XmlWebServices.View_renewal_effort_by_effort_select_responseView_renewal_effort_by_effort[] viewRenewalEffortByEffortSelect(Think.XmlWebServices.View_renewal_effort_by_effort_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewRenewalEffortByEffortSelect(parameters);
  }
  
  public Think.XmlWebServices.View_renewal_effort_by_expire_select_responseView_renewal_effort_by_expire[] viewRenewalEffortByExpireSelect(Think.XmlWebServices.View_renewal_effort_by_expire_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewRenewalEffortByExpireSelect(parameters);
  }
  
  public Think.XmlWebServices.View_billing_effort_by_oc_select_responseView_billing_effort_by_oc[] viewBillingEffortByOcSelect(Think.XmlWebServices.View_billing_effort_by_oc_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewBillingEffortByOcSelect(parameters);
  }
  
  public Think.XmlWebServices.View_billing_effort_by_effort_select_responseView_billing_effort_by_effort[] viewBillingEffortByEffortSelect(Think.XmlWebServices.View_billing_effort_by_effort_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewBillingEffortByEffortSelect(parameters);
  }
  
  public Think.XmlWebServices.View_billing_effort_by_expire_select_responseView_billing_effort_by_expire[] viewBillingEffortByExpireSelect(Think.XmlWebServices.View_billing_effort_by_expire_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.viewBillingEffortByExpireSelect(parameters);
  }
  
  public Think.XmlWebServices.Work_table_select_responseWork_table[] workTableSelect(Think.XmlWebServices.Work_table_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.workTableSelect(parameters);
  }
  
  public Think.XmlWebServices.Work_table_payment_select_responseWork_table_payment[] workTablePaymentSelect(Think.XmlWebServices.Work_table_payment_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.workTablePaymentSelect(parameters);
  }
  
  public Think.XmlWebServices.Renewal_history_select_response renewalHistorySelect(Think.XmlWebServices.Renewal_history_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.renewalHistorySelect(parameters);
  }
  
  public Think.XmlWebServices.Catalog_content_select_responseCatalog_content[] catalogContentSelect(Think.XmlWebServices.Catalog_content_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.catalogContentSelect(parameters);
  }
  
  public Think.XmlWebServices.Tenant_select_responseTenant[] tenantSelect(Think.XmlWebServices.Tenant_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.tenantSelect(parameters);
  }
  
  public Think.XmlWebServices.Aux_field_select_responseAux_field[] auxFieldSelect(Think.XmlWebServices.Aux_field_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.auxFieldSelect(parameters);
  }
  
  public Think.XmlWebServices.Attachment_select_responseAttachment[] attachmentSelect(Think.XmlWebServices.Attachment_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.attachmentSelect(parameters);
  }
  
  public Think.XmlWebServices.Gpc_lookup_select_response gpcLookupSelect(Think.XmlWebServices.Gpc_lookup_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.gpcLookupSelect(parameters);
  }
  
  public Think.XmlWebServices.Paybreak_by_item_break_select_responsePaybreak[] paybreakByItemBreakSelect(Think.XmlWebServices.Paybreak_by_item_break_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paybreakByItemBreakSelect(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_with_pending_payments_select_responsePayment_account[] paymentAccountWithPendingPaymentsSelect(Think.XmlWebServices.Payment_account_with_pending_payments_select_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountWithPendingPaymentsSelect(parameters);
  }
  
  public Think.XmlWebServices.Customer[] ipOverlapList(Think.XmlWebServices.Ip_overlap_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ipOverlapList(parameters);
  }
  
  public Think.XmlWebServices.Customer[] customerListByIpAddress(Think.XmlWebServices.Customer_list_by_ip_address_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerListByIpAddress(parameters);
  }
  
  public Think.XmlWebServices.ThresholdOption[][] thresholdOptionList(Think.XmlWebServices.Threshold_option_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.thresholdOptionList(parameters);
  }
  
  public Think.XmlWebServices.User_authenticate_response userAuthenticate(Think.XmlWebServices.User_authenticate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userAuthenticate(parameters);
  }
  
  public java.lang.Object userPasswordChange(Think.XmlWebServices.User_password_change_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userPasswordChange(parameters);
  }
  
  public java.lang.Object userPasswordInvalidate(Think.XmlWebServices.User_password_invalidate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userPasswordInvalidate(parameters);
  }
  
  public java.lang.Object userPasswordReset(Think.XmlWebServices.User_password_reset_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userPasswordReset(parameters);
  }
  
  public Think.XmlWebServices.Login_authenticate_response loginAuthenticate(Think.XmlWebServices.Login_authenticate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.loginAuthenticate(parameters);
  }
  
  public Think.XmlWebServices.Ip_authenticate_response ipAuthenticate(Think.XmlWebServices.Ip_authenticate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ipAuthenticate(parameters);
  }
  
  public java.lang.Object userCodeActivityAdd(Think.XmlWebServices.User_code_activity_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.userCodeActivityAdd(parameters);
  }
  
  public Think.XmlWebServices.Order_item_information_response orderItemInformation(Think.XmlWebServices.Order_item_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemInformation(parameters);
  }
  
  public Think.XmlWebServices.Order_add_response orderAdd(Think.XmlWebServices.Order_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderAdd(parameters);
  }
  
  public Think.XmlWebServices.Affected_item[] orderAddEffectList(Think.XmlWebServices.Order_add_effect_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderAddEffectList(parameters);
  }
  
  public Think.XmlWebServices.Affected_item[] orderAddPaymentAddEffectList(Think.XmlWebServices.Order_add_payment_add_effect_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderAddPaymentAddEffectList(parameters);
  }
  
  public Think.XmlWebServices.Orderhdr_edit_response orderhdrEdit(Think.XmlWebServices.Orderhdr_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderhdrEdit(parameters);
  }
  
  public Think.XmlWebServices.Order_item_edit_response orderItemEdit(Think.XmlWebServices.Order_item_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemEdit(parameters);
  }
  
  public Think.XmlWebServices.Renewable_order_item_edit_response renewableOrderItemEdit(Think.XmlWebServices.Renewable_order_item_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.renewableOrderItemEdit(parameters);
  }
  
  public Think.XmlWebServices.Order_add_payment_add_response orderAddPaymentAdd(Think.XmlWebServices.Order_add_payment_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderAddPaymentAdd(parameters);
  }
  
  public Think.XmlWebServices.Order_add_deposit_use_response orderAddDepositUse(Think.XmlWebServices.Order_add_deposit_use_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderAddDepositUse(parameters);
  }
  
  public Think.XmlWebServices.Deposit_use_response depositUse(Think.XmlWebServices.Deposit_use_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.depositUse(parameters);
  }
  
  public Think.XmlWebServices.Affected_item[] depositUseEffectList(Think.XmlWebServices.Deposit_use_effect_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.depositUseEffectList(parameters);
  }
  
  public Think.XmlWebServices.Deposit_refund_response depositRefund(Think.XmlWebServices.Deposit_refund_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.depositRefund(parameters);
  }
  
  public Think.XmlWebServices.Customer_add_order_add_response customerAddOrderAdd(Think.XmlWebServices.Customer_add_order_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddOrderAdd(parameters);
  }
  
  public Think.XmlWebServices.Customer_add_order_add_payment_add_response customerAddOrderAddPaymentAdd(Think.XmlWebServices.Customer_add_order_add_payment_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddOrderAddPaymentAdd(parameters);
  }
  
  public Think.XmlWebServices.Customer_add_payment_add_response customerAddPaymentAdd(Think.XmlWebServices.Customer_add_payment_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddPaymentAdd(parameters);
  }
  
  public Think.XmlWebServices.Subgroup_add_response subgroupAdd(Think.XmlWebServices.Subgroup_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subgroupAdd(parameters);
  }
  
  public Think.XmlWebServices.Subgroup_delete_response subgroupDelete(Think.XmlWebServices.Subgroup_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subgroupDelete(parameters);
  }
  
  public Think.XmlWebServices.Subgroup_move_response subgroupMove(Think.XmlWebServices.Subgroup_move_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subgroupMove(parameters);
  }
  
  public Think.XmlWebServices.Order_transfer_information_response orderTransferInformation(Think.XmlWebServices.Order_transfer_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderTransferInformation(parameters);
  }
  
  public Think.XmlWebServices.Order_transfer_response orderTransfer(Think.XmlWebServices.Order_transfer_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderTransfer(parameters);
  }
  
  public Think.XmlWebServices.Customer_edit_response customerEdit(Think.XmlWebServices.Customer_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerEdit(parameters);
  }
  
  public Think.XmlWebServices.Credit_card_payment_clear_response creditCardPaymentClear(Think.XmlWebServices.Credit_card_payment_clear_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.creditCardPaymentClear(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_add_response paymentAccountAdd(Think.XmlWebServices.Payment_account_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountAdd(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_edit_response paymentAccountEdit(Think.XmlWebServices.Payment_account_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountEdit(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_edit_ex_response paymentAccountEditEx(Think.XmlWebServices.Payment_account_edit_ex_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountEditEx(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_clear_response paymentAccountClear(Think.XmlWebServices.Payment_account_clear_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountClear(parameters);
  }
  
  public Think.XmlWebServices.Payment_account_clear_ex_response paymentAccountClearEx(Think.XmlWebServices.Payment_account_clear_ex_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAccountClearEx(parameters);
  }
  
  public Think.XmlWebServices.Customer_address_add_response customerAddressAdd(Think.XmlWebServices.Customer_address_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddressAdd(parameters);
  }
  
  public Think.XmlWebServices.Customer_address_edit_response customerAddressEdit(Think.XmlWebServices.Customer_address_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddressEdit(parameters);
  }
  
  public Think.XmlWebServices.Customer_address_edit_from_future_temp_response customerAddressEditFromFutureTemp(Think.XmlWebServices.Customer_address_edit_from_future_temp_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddressEditFromFutureTemp(parameters);
  }
  
  public Think.XmlWebServices.Customer_address_delete_future_temp_response customerAddressDeleteFutureTemp(Think.XmlWebServices.Customer_address_delete_future_temp_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddressDeleteFutureTemp(parameters);
  }
  
  public Think.XmlWebServices.Affected_item[] customerAddressEditEffectList(Think.XmlWebServices.Customer_address_edit_effect_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddressEditEffectList(parameters);
  }
  
  public Think.XmlWebServices.Customer_login_claim_response customerLoginClaim(Think.XmlWebServices.Customer_login_claim_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerLoginClaim(parameters);
  }
  
  public Think.XmlWebServices.Login_claim_response loginClaim(Think.XmlWebServices.Login_claim_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.loginClaim(parameters);
  }
  
  public Think.XmlWebServices.Subscription_is_duplicate_response subscriptionIsDuplicate(Think.XmlWebServices.Subscription_is_duplicate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subscriptionIsDuplicate(parameters);
  }
  
  public Think.XmlWebServices.Demog_form_response demogForm(Think.XmlWebServices.Demog_form_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.demogForm(parameters);
  }
  
  public Think.XmlWebServices.Demographic_check_response demographicCheck(Think.XmlWebServices.Demographic_check_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.demographicCheck(parameters);
  }
  
  public Think.XmlWebServices.Demographic_update_response demographicUpdate(Think.XmlWebServices.Demographic_update_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.demographicUpdate(parameters);
  }
  
  public Think.XmlWebServices.Demographic_delete_response demographicDelete(Think.XmlWebServices.Demographic_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.demographicDelete(parameters);
  }
  
  public Think.XmlWebServices.Inventory_check_response inventoryCheck(Think.XmlWebServices.Inventory_check_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.inventoryCheck(parameters);
  }
  
  public Think.XmlWebServices.Inventory_sufficient_for_sample_response inventorySufficientForSample(Think.XmlWebServices.Inventory_sufficient_for_sample_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.inventorySufficientForSample(parameters);
  }
  
  public Think.XmlWebServices.Amount_struct[] amountConversion(Think.XmlWebServices.Amount_conversion_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.amountConversion(parameters);
  }
  
  public Think.XmlWebServices.Payment_add_response paymentAdd(Think.XmlWebServices.Payment_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentAdd(parameters);
  }
  
  public Think.XmlWebServices.Payment_edit_response paymentEdit(Think.XmlWebServices.Payment_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentEdit(parameters);
  }
  
  public Think.XmlWebServices.Payment_information_response paymentInformation(Think.XmlWebServices.Payment_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentInformation(parameters);
  }
  
  public Think.XmlWebServices.Affected_item[] paymentEffectList(Think.XmlWebServices.Payment_effect_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentEffectList(parameters);
  }
  
  public Think.XmlWebServices.View_payment_deposit[] depositPaymentInformation(Think.XmlWebServices.Deposit_payment_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.depositPaymentInformation(parameters);
  }
  
  public Think.XmlWebServices.Paybreak_information_response paybreakInformation(Think.XmlWebServices.Paybreak_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paybreakInformation(parameters);
  }
  
  public Think.XmlWebServices.Order_item[] orderCancelList(Think.XmlWebServices.Order_cancel_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderCancelList(parameters);
  }
  
  public Think.XmlWebServices.Order_cancel_response orderCancel(Think.XmlWebServices.Order_cancel_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderCancel(parameters);
  }
  
  public Think.XmlWebServices.Supplemental_refund_add_response supplementalRefundAdd(Think.XmlWebServices.Supplemental_refund_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.supplementalRefundAdd(parameters);
  }
  
  public Think.XmlWebServices.Order_item[] itemsRenewableList(Think.XmlWebServices.Items_renewable_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemsRenewableList(parameters);
  }
  
  public Think.XmlWebServices.Refund_calculate_response refundCalculate(Think.XmlWebServices.Refund_calculate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.refundCalculate(parameters);
  }
  
  public Think.XmlWebServices.Unit_item_information_response unitItemInformation(Think.XmlWebServices.Unit_item_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitItemInformation(parameters);
  }
  
  public Think.XmlWebServices.Unit_item_list_information_response unitItemListInformation(Think.XmlWebServices.Unit_item_list_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitItemListInformation(parameters);
  }
  
  public Think.XmlWebServices.Unit_excess_price_response unitExcessPrice(Think.XmlWebServices.Unit_excess_price_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitExcessPrice(parameters);
  }
  
  public Think.XmlWebServices.Unit_use_payment_add_response unitUsePaymentAdd(Think.XmlWebServices.Unit_use_payment_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitUsePaymentAdd(parameters);
  }
  
  public Think.XmlWebServices.Unit_use_response unitUse(Think.XmlWebServices.Unit_use_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitUse(parameters);
  }
  
  public Think.XmlWebServices.Unit_check_out_response unitCheckOut(Think.XmlWebServices.Unit_check_out_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitCheckOut(parameters);
  }
  
  public Think.XmlWebServices.Unit_check_in_response unitCheckIn(Think.XmlWebServices.Unit_check_in_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.unitCheckIn(parameters);
  }
  
  public Think.XmlWebServices.Prospect_add_response prospectAdd(Think.XmlWebServices.Prospect_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.prospectAdd(parameters);
  }
  
  public Think.XmlWebServices.Prospect_delete_response prospectDelete(Think.XmlWebServices.Prospect_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.prospectDelete(parameters);
  }
  
  public Think.XmlWebServices.Customer_add_response customerAdd(Think.XmlWebServices.Customer_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAdd(parameters);
  }
  
  public Think.XmlWebServices.Disambiguation_list[] disambiguationList(Think.XmlWebServices.Disambiguation_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.disambiguationList(parameters);
  }
  
  public Think.XmlWebServices.Item_list_response itemList(Think.XmlWebServices.Item_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemList(parameters);
  }
  
  public Think.XmlWebServices.Order_data[] itemAlreadySubscribedList(Think.XmlWebServices.Item_already_subscribed_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemAlreadySubscribedList(parameters);
  }
  
  public Think.XmlWebServices.Item_renewal_list_response itemRenewalList(Think.XmlWebServices.Item_renewal_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemRenewalList(parameters);
  }
  
  public Think.XmlWebServices.Item_renewable_list_response itemRenewableList(Think.XmlWebServices.Item_renewable_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemRenewableList(parameters);
  }
  
  public Think.XmlWebServices.Renewal_card_offer_list_response renewalCardOfferList(Think.XmlWebServices.Renewal_card_offer_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.renewalCardOfferList(parameters);
  }
  
  public Think.XmlWebServices.Promotion_card_offer_list_response promotionCardOfferList(Think.XmlWebServices.Promotion_card_offer_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.promotionCardOfferList(parameters);
  }
  
  public Think.XmlWebServices.Password_email_send_response passwordEmailSend(Think.XmlWebServices.Password_email_send_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.passwordEmailSend(parameters);
  }
  
  public Think.XmlWebServices.Event_queue_add_response eventQueueAdd(Think.XmlWebServices.Event_queue_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.eventQueueAdd(parameters);
  }
  
  public Think.XmlWebServices.ZZEventQueue[] eventQueueDelete(Think.XmlWebServices.Event_queue_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.eventQueueDelete(parameters);
  }
  
  public Think.XmlWebServices.Payment_cancel_response paymentCancel(Think.XmlWebServices.Payment_cancel_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentCancel(parameters);
  }
  
  public Think.XmlWebServices.Order_item_for_payment[] paymentItemsList(Think.XmlWebServices.Payment_items_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentItemsList(parameters);
  }
  
  public Think.XmlWebServices.Order_code_for_price_list[][] priceList(Think.XmlWebServices.Price_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.priceList(parameters);
  }
  
  public Think.XmlWebServices.Order_code_for_price_list[][] subscriptionUpgradeDowngradePriceList(Think.XmlWebServices.Subscription_upgrade_downgrade_price_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subscriptionUpgradeDowngradePriceList(parameters);
  }
  
  public Think.XmlWebServices.Payment_transfer_response paymentTransfer(Think.XmlWebServices.Payment_transfer_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentTransfer(parameters);
  }
  
  public Think.XmlWebServices.Prorate_values[] itemProrateValues(Think.XmlWebServices.Item_prorate_values_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.itemProrateValues(parameters);
  }
  
  public Think.XmlWebServices.Bundle_quantity_option_calculate_response bundleQuantityOptionCalculate(Think.XmlWebServices.Bundle_quantity_option_calculate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.bundleQuantityOptionCalculate(parameters);
  }
  
  public Think.XmlWebServices.Bundle_quantity_date_option_calculate_response bundleQuantityDateOptionCalculate(Think.XmlWebServices.Bundle_quantity_date_option_calculate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.bundleQuantityDateOptionCalculate(parameters);
  }
  
  public Think.XmlWebServices.Order_quantity_option_calculate_response orderQuantityOptionCalculate(Think.XmlWebServices.Order_quantity_option_calculate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderQuantityOptionCalculate(parameters);
  }
  
  public Think.XmlWebServices.Order_date_option_calculate_response orderDateOptionCalculate(Think.XmlWebServices.Order_date_option_calculate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderDateOptionCalculate(parameters);
  }
  
  public Think.XmlWebServices.Suspension_add_response suspensionAdd(Think.XmlWebServices.Suspension_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.suspensionAdd(parameters);
  }
  
  public Think.XmlWebServices.Suspension_edit_response suspensionEdit(Think.XmlWebServices.Suspension_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.suspensionEdit(parameters);
  }
  
  public Think.XmlWebServices.Product_return_response productReturn(Think.XmlWebServices.Product_return_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.productReturn(parameters);
  }
  
  public java.lang.Object auditCheck(Think.XmlWebServices.Audit_check_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.auditCheck(parameters);
  }
  
  public Think.XmlWebServices.Customer_address[] duplicateAddressList(Think.XmlWebServices.Duplicate_address_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.duplicateAddressList(parameters);
  }
  
  public Think.XmlWebServices.Address_clean_response addressClean(Think.XmlWebServices.Address_clean_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.addressClean(parameters);
  }
  
  public Think.XmlWebServices.Note_add_response noteAdd(Think.XmlWebServices.Note_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.noteAdd(parameters);
  }
  
  public Think.XmlWebServices.Note_edit_response noteEdit(Think.XmlWebServices.Note_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.noteEdit(parameters);
  }
  
  public Think.XmlWebServices.Note_delete_response noteDelete(Think.XmlWebServices.Note_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.noteDelete(parameters);
  }
  
  public Think.XmlWebServices.Px_add_response pxAdd(Think.XmlWebServices.Px_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pxAdd(parameters);
  }
  
  public Think.XmlWebServices.Px_update_response pxUpdate(Think.XmlWebServices.Px_update_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pxUpdate(parameters);
  }
  
  public Think.XmlWebServices.Px_delete_response pxDelete(Think.XmlWebServices.Px_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pxDelete(parameters);
  }
  
  public Think.XmlWebServices.Px_replace_response pxReplace(Think.XmlWebServices.Px_replace_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pxReplace(parameters);
  }
  
  public Think.XmlWebServices.Oc_default[] ocNetDefaultSourceCode(Think.XmlWebServices.Oc_net_default_source_code_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocNetDefaultSourceCode(parameters);
  }
  
  public Think.XmlWebServices.Group_action_item_identifier[] groupOrderAdjustmentList(Think.XmlWebServices.Group_order_adjustment_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.groupOrderAdjustmentList(parameters);
  }
  
  public Think.XmlWebServices.Group_member_change_effect_list_response groupMemberChangeEffectList(Think.XmlWebServices.Group_member_change_effect_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.groupMemberChangeEffectList(parameters);
  }
  
  public Think.XmlWebServices.Direct_debit_verify_response directDebitVerify(Think.XmlWebServices.Direct_debit_verify_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.directDebitVerify(parameters);
  }
  
  public Think.XmlWebServices.Credit_card_verify_response creditCardVerify(Think.XmlWebServices.Credit_card_verify_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.creditCardVerify(parameters);
  }
  
  public Think.XmlWebServices.Credit_card_validate_response creditCardValidate(Think.XmlWebServices.Credit_card_validate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.creditCardValidate(parameters);
  }
  
  public Think.XmlWebServices.Reference_cache_record_response referenceCacheRecord(Think.XmlWebServices.Reference_cache_record_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.referenceCacheRecord(parameters);
  }
  
  public Think.XmlWebServices.Reference_cache_list_response referenceCacheList(Think.XmlWebServices.Reference_cache_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.referenceCacheList(parameters);
  }
  
  public Think.XmlWebServices.Reference_cache_tableinfo_response referenceCacheTableinfo(Think.XmlWebServices.Reference_cache_tableinfo_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.referenceCacheTableinfo(parameters);
  }
  
  public Think.XmlWebServices.Reference_cache_change_count_responseTable[] referenceCacheChangeCount(Think.XmlWebServices.Reference_cache_change_count_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.referenceCacheChangeCount(parameters);
  }
  
  public int[] ocAncestorList(Think.XmlWebServices.Oc_ancestor_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocAncestorList(parameters);
  }
  
  public int[] ocDescendantList(Think.XmlWebServices.Oc_descendant_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocDescendantList(parameters);
  }
  
  public int[] ocCommonAncestorList(Think.XmlWebServices.Oc_common_ancestor_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.ocCommonAncestorList(parameters);
  }
  
  public Think.XmlWebServices.Payment_waiting_auth_or_post_response paymentWaitingAuthOrPost(Think.XmlWebServices.Payment_waiting_auth_or_post_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.paymentWaitingAuthOrPost(parameters);
  }
  
  public Think.XmlWebServices.Order_item_can_pay_response orderItemCanPay(Think.XmlWebServices.Order_item_can_pay_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemCanPay(parameters);
  }
  
  public Think.XmlWebServices.Order_item_needs_payment_settled_response orderItemNeedsPaymentSettled(Think.XmlWebServices.Order_item_needs_payment_settled_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemNeedsPaymentSettled(parameters);
  }
  
  public Think.XmlWebServices.Px_check_counts_and_amounts_response pxCheckCountsAndAmounts(Think.XmlWebServices.Px_check_counts_and_amounts_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.pxCheckCountsAndAmounts(parameters);
  }
  
  public Think.XmlWebServices.Order_item_minimum_active_date_list_response orderItemMinimumActiveDateList(Think.XmlWebServices.Order_item_minimum_active_date_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderItemMinimumActiveDateList(parameters);
  }
  
  public Think.XmlWebServices.Service_add_response serviceAdd(Think.XmlWebServices.Service_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.serviceAdd(parameters);
  }
  
  public Think.XmlWebServices.Service_edit_response serviceEdit(Think.XmlWebServices.Service_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.serviceEdit(parameters);
  }
  
  public Think.XmlWebServices.Customer_clear_response customerClear(Think.XmlWebServices.Customer_clear_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerClear(parameters);
  }
  
  public Think.XmlWebServices.Customer_address[] customerAddressClear(Think.XmlWebServices.Customer_address_clear_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAddressClear(parameters);
  }
  
  public Think.XmlWebServices.Customer_name_diff_from_address_info_response customerNameDiffFromAddressInfo(Think.XmlWebServices.Customer_name_diff_from_address_info_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerNameDiffFromAddressInfo(parameters);
  }
  
  public Think.XmlWebServices.Order_upsell_information_response orderUpsellInformation(Think.XmlWebServices.Order_upsell_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.orderUpsellInformation(parameters);
  }
  
  public Think.XmlWebServices.Aux_field_value[][] auxFieldValuesList(Think.XmlWebServices.Aux_field_values_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.auxFieldValuesList(parameters);
  }
  
  public Think.XmlWebServices.Package_edit_response packageEdit(Think.XmlWebServices.Package_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.packageEdit(parameters);
  }
  
  public Think.XmlWebServices.Group_delete_response groupDelete(Think.XmlWebServices.Group_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.groupDelete(parameters);
  }
  
  public Think.XmlWebServices.Deal_information[] consortiumOrderCheck(Think.XmlWebServices.Consortium_order_check_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.consortiumOrderCheck(parameters);
  }
  
  public Think.XmlWebServices.Deal_add_response dealAdd(Think.XmlWebServices.Deal_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.dealAdd(parameters);
  }
  
  public Think.XmlWebServices.Deal_edit_response dealEdit(Think.XmlWebServices.Deal_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.dealEdit(parameters);
  }
  
  public Think.XmlWebServices.Customer_information_response customerInformation(Think.XmlWebServices.Customer_information_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerInformation(parameters);
  }
  
  public Think.XmlWebServices.Customer_information_ex_response customerInformationEx(Think.XmlWebServices.Customer_information_ex_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerInformationEx(parameters);
  }
  
  public Think.XmlWebServices.Disp_context_populate_response dispContextPopulate(Think.XmlWebServices.Disp_context_populate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.dispContextPopulate(parameters);
  }
  
  public Think.XmlWebServices.Doc_ref_batch[] docRefBatchList(Think.XmlWebServices.Doc_ref_batch_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.docRefBatchList(parameters);
  }
  
  public Think.XmlWebServices.Document_reference_add_response documentReferenceAdd(Think.XmlWebServices.Document_reference_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.documentReferenceAdd(parameters);
  }
  
  public Think.XmlWebServices.Document_reference_edit_response documentReferenceEdit(Think.XmlWebServices.Document_reference_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.documentReferenceEdit(parameters);
  }
  
  public Think.XmlWebServices.Customer_orders_list_response customerOrdersList(Think.XmlWebServices.Customer_orders_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerOrdersList(parameters);
  }
  
  public Think.XmlWebServices.Also_ordered_list_response alsoOrderedList(Think.XmlWebServices.Also_ordered_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.alsoOrderedList(parameters);
  }
  
  public Think.XmlWebServices.Installment_plan_list_responseInstallment_plan[] installmentPlanList(Think.XmlWebServices.Installment_plan_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.installmentPlanList(parameters);
  }
  
  public Think.XmlWebServices.Server_datetime_list_response serverDatetimeList(Think.XmlWebServices.Server_datetime_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.serverDatetimeList(parameters);
  }
  
  public Think.XmlWebServices.Request_log_edit_response requestLogEdit(Think.XmlWebServices.Request_log_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.requestLogEdit(parameters);
  }
  
  public Think.XmlWebServices.Request_log_delete_response requestLogDelete(Think.XmlWebServices.Request_log_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.requestLogDelete(parameters);
  }
  
  public Think.XmlWebServices.ZZTransactionData transactionData(Think.XmlWebServices.Transaction_data_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.transactionData(parameters);
  }
  
  public Think.XmlWebServices.Jqs_alert_add_response jqsAlertAdd(Think.XmlWebServices.Jqs_alert_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsAlertAdd(parameters);
  }
  
  public Think.XmlWebServices.Jqs_alert_edit_response jqsAlertEdit(Think.XmlWebServices.Jqs_alert_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsAlertEdit(parameters);
  }
  
  public Think.XmlWebServices.Jqs_alert_delete_response jqsAlertDelete(Think.XmlWebServices.Jqs_alert_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsAlertDelete(parameters);
  }
  
  public Think.XmlWebServices.Jqs_client_add_response jqsClientAdd(Think.XmlWebServices.Jqs_client_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsClientAdd(parameters);
  }
  
  public Think.XmlWebServices.Jqs_client_edit_response jqsClientEdit(Think.XmlWebServices.Jqs_client_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsClientEdit(parameters);
  }
  
  public Think.XmlWebServices.Jqs_client_delete_response jqsClientDelete(Think.XmlWebServices.Jqs_client_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsClientDelete(parameters);
  }
  
  public Think.XmlWebServices.Jqs_client_list_responseJqs_client[] jqsClientList(Think.XmlWebServices.Jqs_client_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsClientList(parameters);
  }
  
  public Think.XmlWebServices.Jqs_machine_add_response jqsMachineAdd(Think.XmlWebServices.Jqs_machine_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsMachineAdd(parameters);
  }
  
  public Think.XmlWebServices.Jqs_machine_edit_response jqsMachineEdit(Think.XmlWebServices.Jqs_machine_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsMachineEdit(parameters);
  }
  
  public Think.XmlWebServices.Jqs_machine_delete_response jqsMachineDelete(Think.XmlWebServices.Jqs_machine_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsMachineDelete(parameters);
  }
  
  public Think.XmlWebServices.Jqs_queue_add_response jqsQueueAdd(Think.XmlWebServices.Jqs_queue_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsQueueAdd(parameters);
  }
  
  public Think.XmlWebServices.Jqs_queue_edit_response jqsQueueEdit(Think.XmlWebServices.Jqs_queue_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsQueueEdit(parameters);
  }
  
  public Think.XmlWebServices.Jqs_queue_delete_response jqsQueueDelete(Think.XmlWebServices.Jqs_queue_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsQueueDelete(parameters);
  }
  
  public Think.XmlWebServices.Jqs_queue_list_responseJqs_queue[] jqsQueueList(Think.XmlWebServices.Jqs_queue_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsQueueList(parameters);
  }
  
  public Think.XmlWebServices.Jqs_config_edit_response jqsConfigEdit(Think.XmlWebServices.Jqs_config_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jqsConfigEdit(parameters);
  }
  
  public Think.XmlWebServices.Job_edit_response jobEdit(Think.XmlWebServices.Job_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobEdit(parameters);
  }
  
  public Think.XmlWebServices.Job_delete_response jobDelete(Think.XmlWebServices.Job_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.jobDelete(parameters);
  }
  
  public Think.XmlWebServices.Proc_type_info_list_response procTypeInfoList(Think.XmlWebServices.Proc_type_info_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.procTypeInfoList(parameters);
  }
  
  public java.lang.Object workTableSelectionUpdate(Think.XmlWebServices.Work_table_selection_update_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.workTableSelectionUpdate(parameters);
  }
  
  public Think.XmlWebServices.Work_table_payment_edit_response workTablePaymentEdit(Think.XmlWebServices.Work_table_payment_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.workTablePaymentEdit(parameters);
  }
  
  public Think.XmlWebServices.Process_edit_response processEdit(Think.XmlWebServices.Process_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.processEdit(parameters);
  }
  
  public Think.XmlWebServices.Subscrip_edit_response subscripEdit(Think.XmlWebServices.Subscrip_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subscripEdit(parameters);
  }
  
  public Think.XmlWebServices.Attachment_add_response attachmentAdd(Think.XmlWebServices.Attachment_add_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.attachmentAdd(parameters);
  }
  
  public Think.XmlWebServices.Attachment_edit_response attachmentEdit(Think.XmlWebServices.Attachment_edit_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.attachmentEdit(parameters);
  }
  
  public Think.XmlWebServices.Attachment_view_response attachmentView(Think.XmlWebServices.Attachment_view_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.attachmentView(parameters);
  }
  
  public Think.XmlWebServices.Attachment_delete_response attachmentDelete(Think.XmlWebServices.Attachment_delete_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.attachmentDelete(parameters);
  }
  
  public Think.XmlWebServices.Subscription_prorate_calculate_response subscriptionProrateCalculate(Think.XmlWebServices.Subscription_prorate_calculate_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.subscriptionProrateCalculate(parameters);
  }
  
  public java.lang.Object registrationEmailSend(Think.XmlWebServices.Registration_email_send_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.registrationEmailSend(parameters);
  }
  
  public java.lang.Object loginEmailSend(Think.XmlWebServices.Login_email_send_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.loginEmailSend(parameters);
  }
  
  public Think.XmlWebServices.History_list_response historyList(Think.XmlWebServices.History_list_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.historyList(parameters);
  }
  
  public Think.XmlWebServices.Edit_trail[] editTrail(Think.XmlWebServices.Edit_trail_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.editTrail(parameters);
  }
  
  public Think.XmlWebServices.Security_check_response securityCheck(Think.XmlWebServices.Security_check_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.securityCheck(parameters);
  }
  
  public Think.XmlWebServices.Customer_auth_response customerAuth(Think.XmlWebServices.Customer_auth_request parameters) throws java.rmi.RemoteException{
    if (thinkSoap == null)
      _initThinkSoapProxy();
    return thinkSoap.customerAuth(parameters);
  }
  
  
}