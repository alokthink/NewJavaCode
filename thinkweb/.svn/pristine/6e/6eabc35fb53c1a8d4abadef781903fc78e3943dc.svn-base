package com.mps.think.orderFunctionality.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mps.think.model.CustomerAddressModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderItem;
import com.mps.think.model.SourceCode;
import com.mps.think.orderFunctionality.model.CustomerGroupModel;
import com.mps.think.orderFunctionality.model.DemographicChildModel;
import com.mps.think.orderFunctionality.model.DemographicsModel;
import com.mps.think.orderFunctionality.model.EditSuspension;
import com.mps.think.orderFunctionality.model.GropDealModel;
import com.mps.think.orderFunctionality.model.GroupMainModel;
import com.mps.think.orderFunctionality.model.GroupMemberModel;
import com.mps.think.orderFunctionality.model.GroupStructureLeftPanel;
import com.mps.think.orderFunctionality.model.Orderhdr;
import com.mps.think.orderFunctionality.model.PagePanelDemographicsModel;
import com.mps.think.orderFunctionality.model.ProspectModel;
import com.mps.think.orderFunctionality.model.SuspensionModel;
import com.mps.think.orderFunctionality.model.TransferOrderModel;
import com.mps.think.orderFunctionality.model.OrderItemModel;
import com.mps.think.orderFunctionality.model.UpDowngradeModel;
import com.mps.think.orderFunctionality.service.OrderFunctionalityService;
import com.mps.think.service.CustomerOrderService;
import com.mps.think.service.CustomerSearchService;
import com.mps.think.service.OrderSourceOfferService;
import com.mps.think.setup.model.SubscriptionDef;
import com.mps.think.util.CustomerUtility;

@RestController
@Scope("request")
public class OrderFunctionalityController {

	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderFunctionalityController.class);

	@Autowired
	OrderFunctionalityService orderFunctionalityService;
	
	@Autowired
	CustomerOrderService customerOrderService;
	
	@Autowired
	CustomerSearchService customerSearchService;
	
	@Autowired
	OrderSourceOfferService orderSourceOfferService;
	//*******************************************************
	@PostConstruct
	public void init() {
		 try {
			 CustomerUtility customerUtility = new CustomerUtility();
			 customerUtility.runTruncate(jdbcTemplate);
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
  //*******************************************************

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(path = "/selectEditOrderHeader", method = RequestMethod.POST)
	public Map<String, Object> getEditOrderHeader(long orderhdrId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> editOrderHeader = new ArrayList<>();
		try {
			editOrderHeader = orderFunctionalityService.getEditOrderHeader(orderhdrId);
			responseObject.put("editOrderHeader", editOrderHeader);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getEditOrderHeader() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateEditOrderHeader", method = RequestMethod.POST)
	public Map<String, Object> updateEditOrderHeader(Orderhdr orderhdr) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.updateEditOrderHeader(orderhdr);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateEditOrderHeader() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectTemporarySuspension", method = RequestMethod.POST)
	public Map<String, Object> getTemporarySuspension(long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SuspensionModel> temporarySuspension = new ArrayList<>();
		String customer,description;
		try {
			temporarySuspension = orderFunctionalityService.getTemporarySuspension(orderhdrId, orderItemSeq);
			String orderId = temporarySuspension.get(0).getOrderhdrId();
			String orderSeq = temporarySuspension.get(0).getOrderItemSeq();
			customer = temporarySuspension.get(0).getCustomer();
			description = temporarySuspension.get(0).getDescription();
			responseObject.put("customer", customer);
			responseObject.put("description", description);
				if(orderId.isEmpty() && orderSeq.isEmpty()) {
					temporarySuspension.clear();
					responseObject.put("temporarySuspension", temporarySuspension);
				}else {
					responseObject.put("temporarySuspension", temporarySuspension);
				}
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getTemporarySuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectAddTempSuspension", method = RequestMethod.POST)
	public Map<String, Object> getAddTempSuspension(long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		EditSuspension addTempSuspension = null;
		try {
			addTempSuspension = orderFunctionalityService.getAddTempSuspension(orderhdrId, orderItemSeq);
			responseObject.put("addTempSuspension", addTempSuspension);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getAddTempSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveAddTempSuspension", method = RequestMethod.POST)
	public Map<String, Object> addTempSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		String suspensionStatus = null;
		String msg ="Business logic exception detected: cfff0083: New suspension overlaps with existing suspension";
		try {
			int orderStatus = jdbcTemplate.queryForObject("SELECT order_status FROM order_item WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(), Integer.class);
			if(orderStatus != 1 && orderStatus != 2 && orderStatus != 3 && orderStatus != 4) {
				int paymentStatus = jdbcTemplate.queryForObject("SELECT payment_status FROM order_item WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(), Integer.class);
				if (paymentStatus == 0 || paymentStatus == 5 || paymentStatus == 1) {
					
					String from = suspensionModel.getSuspendFromDate();
					String to = suspensionModel.getSuspendToDate();
					//squal>qual or squal=qual
					if(!to.equals(from) || to.equals("")) {
						if(to.compareTo(from)>0 || to.equals("")) {
							List<String> suspensionStatusList = jdbcTemplate.queryForList("select top 1 suspension_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", String.class);
							if(suspensionStatusList.size() != 0)
								suspensionStatus = suspensionStatusList.get(0);
							if(suspensionStatus == null) {
								status = orderFunctionalityService.saveAddTempSuspension(suspensionModel);
								if (status != 0) {
									responseObject.put(STATUS, true);
								} else {
									responseObject.put(STATUS, false);
								}
							}else if(suspensionStatus.equals("1")){
								int suspended = jdbcTemplate.queryForObject("SELECT top 1 suspended_order_status FROM suspension WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
								if(suspended == 8 || suspended ==10 ) {
									status = orderFunctionalityService.saveAddTempSuspension(suspensionModel);
									if (status != 0) {
										responseObject.put(STATUS, true);
									} else {
										responseObject.put(STATUS, false);
									}
								}else {
									responseObject.put(STATUS, msg);
								}
							}else if(suspensionStatus.equals("2") || suspensionStatus.equals("3")){ 
								int suspended = jdbcTemplate.queryForObject("SELECT top 1 suspended_order_status FROM suspension WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
								if(suspended == 8 || suspended == 9 || suspended ==10 || suspended == 16) {
									status = orderFunctionalityService.saveAddTempSuspension(suspensionModel);
									if (status != 0) {
										responseObject.put(STATUS, true);
									} else {
										responseObject.put(STATUS, false);
									}
								}else {
									responseObject.put(STATUS, msg);
								}
							}else {
								responseObject.put(STATUS, msg);
							}
						}else {
							responseObject.put(STATUS, "Business logic exception detected: cfff0089: Cannot modify the end date of an active suspension to a date prior to the current issue date.");
						}
					}else {
						responseObject.put(STATUS, "Business logic exception detected: cfff0089: Cannot modify the end date of an active suspension to a date prior to the current issue date.");
					}
				}
			}else {
				responseObject.put(STATUS, "Business logic exception detected: cfff0084: Cannot place a 'Suspended - Temporary' suspension on a 'Complete' order (orderhdr_id "+ suspensionModel.getOrderhdrId() + " and order_item_seq "+suspensionModel.getOrderItemSeq() +" ");
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in addTemporarySuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectEditSuspension", method = RequestMethod.POST)
	public Map<String, Object> getEditSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		EditSuspension editSuspension = null;
		try {
			int status = jdbcTemplate.queryForObject(" select suspension_status from suspension where orderhdr_id = " + orderhdrId + " and order_item_seq=" + orderItemSeq + " and suspension_seq= " + suspensionSeq,Integer.class);
			if (status == 1) {
			editSuspension = orderFunctionalityService.getEditSuspension(orderhdrId, orderItemSeq, suspensionSeq);
			responseObject.put("editSuspension", editSuspension);
			responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getEditSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateEditSuspension", method = RequestMethod.POST)
	public Map<String, Object> updateEditSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			int suspend = jdbcTemplate.queryForObject("select suspended_order_status from suspension where orderhdr_id = " + suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+ " and suspension_seq=" + suspensionModel.getSuspensionSeq(), Integer.class);
			if(suspend == 9) {
				String from = jdbcTemplate.queryForObject("select FORMAT (suspend_from_date, 'dd/MM/yyyy ') as date from suspension where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq()+" and suspension_seq="+suspensionModel.getSuspensionSeq(), String.class);
				String to = suspensionModel.getSuspendToDate();
				Date start = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
	                    .parse(from);
				if(to.equals("")) {
					status = orderFunctionalityService.updateEditSuspension(suspensionModel);
					if (status != 0) {
						responseObject.put(STATUS, true);  
					} else {
						responseObject.put(STATUS, false);
					}
				}else {
					Date end = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
		                    .parse(to);
					 //start is before end
		            if (start.compareTo(end) < 0 || start.compareTo(end) == 0 || to.equals("")) {
		            	status = orderFunctionalityService.updateEditSuspension(suspensionModel);
						if (status != 0) {
							responseObject.put(STATUS, true);  
						} else {
							responseObject.put(STATUS, false);
						}
		            } else if (start.compareTo(end) == 0) {
		            	status = orderFunctionalityService.updateEditSuspension(suspensionModel);
						if (status != 0) {
							responseObject.put(STATUS, true);  
						} else {
							responseObject.put(STATUS, false);
						}
		            } else {
		            	responseObject.put(STATUS, "Business logic exception detected: cfff0085: The suspension end date must be after the start date.");
		            }
				}
			}else if(suspend == 16) {
				String from = jdbcTemplate.queryForObject("select FORMAT (suspend_from_date, 'MM/dd/yyyy') as date from suspension where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq()+" and suspension_seq="+suspensionModel.getSuspensionSeq(), String.class);
				String to = suspensionModel.getSuspendToDate();
				Date start = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
	                    .parse(from);
				if(to.equals("")) {
					status = orderFunctionalityService.updateEditSuspension(suspensionModel);
					if (status != 0) {
						responseObject.put(STATUS, true);  
					} else {
						responseObject.put(STATUS, false);
					}
				}else {
					Date end = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
		                    .parse(to);
					 //start is before end
		            if (start.compareTo(end) < 0 || start.compareTo(end) == 0 || to.equals("")) {
		            	status = orderFunctionalityService.updateEditSuspension(suspensionModel);
						if (status != 0) {
							responseObject.put(STATUS, true);  
						} else {
							responseObject.put(STATUS, false);
						}
		            } else if (start.compareTo(end) == 0) {
		            	status = orderFunctionalityService.updateEditSuspension(suspensionModel);
						if (status != 0) {
							responseObject.put(STATUS, true);  
						} else {
							responseObject.put(STATUS, false);
						}
		            } else {
		            	responseObject.put(STATUS, "Business logic exception detected: cfff0085: The suspension end date must be after the start date.");
		            }
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateEditSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectReinstateOrderItem", method = RequestMethod.POST)
	public Map<String, Object> getReinstateOrderItem(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		EditSuspension reinstateOrderItem = null;
		try {
			int proforma = jdbcTemplate.queryForObject("select is_proforma from order_item where orderhdr_id = " + orderhdrId+ " and order_item_seq=" + orderItemSeq , Integer.class);
			if(proforma == 0) {
				int status = jdbcTemplate.queryForObject("select suspension_status from suspension where orderhdr_id = " + orderhdrId+ " and order_item_seq=" + orderItemSeq + " and suspension_seq= " + suspensionSeq,Integer.class);
				if (status == 1) {
				reinstateOrderItem = orderFunctionalityService.getReinstateOrderItem(orderhdrId, orderItemSeq,suspensionSeq);
				responseObject.put("reinstateOrderItem", reinstateOrderItem);
				responseObject.put(STATUS, SUCCESS);
				}
			}else {
				responseObject.put("msg", "Business logic exception detected: cfff008b: You cannot manually reinstate a suspension on a proforma order.  Either make a payment against the proforma order to reinstate the suspension or uncheck the proforma checkbox and then manually reinstate it.");
			}
			return responseObject; 
		} catch (Exception e) {
			LOGGER.info("Error in getReinstateOrderItem : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateReinstateOrderItem", method = RequestMethod.POST)
	public Map<String, Object> updateReinstateOrderItem(SuspensionModel suspensionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.updateReinstateOrderItem(suspensionModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateReinstateOrderItem() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectExtendSubscription", method = RequestMethod.POST)
	public Map<String, Object> getExtendSubscription(long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> extendSubscription = new ArrayList<>();
		try {
			extendSubscription = orderFunctionalityService.getExtendSubscription(orderhdrId, orderItemSeq);
			responseObject.put("extendSubscription", extendSubscription);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getExtendSubscription : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/ExtSubChange", method = RequestMethod.POST)
	public Map<String, Object> getExtSubscripChange(long orderhdrId, int orderItemSeq, int count) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		Map<String, Object> extSubscripChange = new LinkedHashMap<>();
		try {
			extSubscripChange = orderFunctionalityService.getExtSubscripChange(orderhdrId, orderItemSeq, count);
			if(extSubscripChange.isEmpty()) {
				responseObject.put("msg", " Business logic exception detected: cfff0055: Attempt to order a subscription that goes beyond the end of issues defined. ");
			}else {
				responseObject.put("extSubscripChange", extSubscripChange);
				responseObject.put(STATUS, SUCCESS);
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getExtSubscripChange : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateExtendSubscription", method = RequestMethod.POST)
	public Map<String, Object> updateExtendSubscription(long orderhdrId, int orderItemSeq, int count) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.updateExtendSubscription(orderhdrId, orderItemSeq, count);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateExtendSubscription() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectBehavioralSuspension", method = RequestMethod.POST)
	public Map<String, Object> getBehavioralSuspension(long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SuspensionModel> behavioralSuspension = new ArrayList<>();
		try {
			behavioralSuspension = orderFunctionalityService.getBehavioralSuspension(orderhdrId, orderItemSeq);
			String orderId = behavioralSuspension.get(0).getOrderhdrId();
			String orderSeq = behavioralSuspension.get(0).getOrderItemSeq();
			String customer = behavioralSuspension.get(0).getCustomer();
			String description = behavioralSuspension.get(0).getDescription();
			responseObject.put("customer", customer);
			responseObject.put("description", description);
				if(orderId.isEmpty() && orderSeq.isEmpty()) {
					behavioralSuspension.clear();
					responseObject.put("behavioralSuspension", behavioralSuspension);
				}else {					
					responseObject.put("behavioralSuspension", behavioralSuspension);
				}
				responseObject.put(STATUS, SUCCESS);
				return responseObject;
			
		} catch (Exception e) {
			LOGGER.info("Error in getBehavioralSuspension : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectAddBehavioralSuspension", method = RequestMethod.POST)
	public Map<String, Object> getAddBehavioralSuspension(long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		EditSuspension addBehavioralSuspension = null;
		try {
			addBehavioralSuspension = orderFunctionalityService.getAddBehavioralSuspension(orderhdrId, orderItemSeq);
			responseObject.put("addBehavioralSuspension", addBehavioralSuspension);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getAddBehavioralSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveAddBehavioralSuspension", method = RequestMethod.POST)
	public Map<String, Object> saveAddBehavioralSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		String suspensionStatus = null;
		String msg ="Business logic exception detected: cfff0083: New suspension overlaps with existing suspension";
		try {
			int orderStatus = jdbcTemplate.queryForObject("SELECT order_status FROM order_item WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(), Integer.class);
			if(orderStatus != 1 && orderStatus != 2 && orderStatus != 3 && orderStatus != 4) {
				String from = suspensionModel.getSuspendFromDate();
				String to = suspensionModel.getSuspendToDate();
				//squal>qual or squal=qual
				if(!to.equals(from) || to.equals("")) {
					if(to.compareTo(from)>0 || to.equals("")) {
						List<String> suspensionStatusList = jdbcTemplate.queryForList("select top 1 suspension_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", String.class);
						if(suspensionStatusList.size()!=0)
							suspensionStatus = suspensionStatusList.get(0);
						if(suspensionStatus == null) {
							status = orderFunctionalityService.saveAddBehavioralSuspension(suspensionModel);
							if (status != 0) {
								responseObject.put(STATUS, true);
							} else {
								responseObject.put(STATUS, false);
							}
						}else if(suspensionStatus.equals("1")) {
							int suspended = jdbcTemplate.queryForObject("SELECT top 1 suspended_order_status FROM suspension WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
							if(suspended == 8 || suspended == 9 || suspended ==10) {
								status = orderFunctionalityService.saveAddBehavioralSuspension(suspensionModel);
								if (status != 0) {
									responseObject.put(STATUS, true);
								} else {
									responseObject.put(STATUS, false);
								}
							}else {
								responseObject.put(STATUS, msg);
							}
						}else if(suspensionStatus.equals("2") || suspensionStatus.equals("3")) {
							int suspended = jdbcTemplate.queryForObject("SELECT top 1 suspended_order_status FROM suspension WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
							if(suspended == 8 || suspended == 9 || suspended ==10 || suspended == 16) {
								status = orderFunctionalityService.saveAddBehavioralSuspension(suspensionModel);
								if (status != 0) {
									responseObject.put(STATUS, true);
								} else {
									responseObject.put(STATUS, false);
								}
							}else {
								responseObject.put(STATUS, msg);
							}
						}else {	
							responseObject.put(STATUS, msg);
						}
					}else {
						responseObject.put(STATUS, "Business logic exception detected: cfff0089: Cannot modify the end date of an active suspension to a date prior to the current issue date.");
					}
				}else {
					responseObject.put(STATUS, "Business logic exception detected: cfff0089: Cannot modify the end date of an active suspension to a date prior to the current issue date.");
				}
			}else {
				responseObject.put(STATUS, "Business logic exception detected: cfff0084: Cannot place a 'Suspended - Behavior' suspension on a 'Complete' order (orderhdr_id "+ suspensionModel.getOrderhdrId() + " and order_item_seq "+suspensionModel.getOrderItemSeq()+" ");
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveAddBehavioralSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectEditBehavioralSuspension", method = RequestMethod.POST)
	public Map<String, Object> getEditBehavioralSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		EditSuspension editBehavioralSuspension = null;
		try {
			editBehavioralSuspension = orderFunctionalityService.getEditBehavioralSuspension(orderhdrId, orderItemSeq,suspensionSeq);
			responseObject.put("editBehavioralSuspension", editBehavioralSuspension);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getEditBehavioralSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectReinstateBehavioralSuspension", method = RequestMethod.POST)
	public Map<String, Object> getReinstateBehavioralSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		EditSuspension reinstateBehavioralSuspension = null;
		try {
			int proforma = jdbcTemplate.queryForObject("select is_proforma from order_item where orderhdr_id = " + orderhdrId+ " and order_item_seq=" + orderItemSeq, Integer.class);
			if(proforma == 0) {
				reinstateBehavioralSuspension = orderFunctionalityService.getReinstateBehavioralSuspension(orderhdrId,orderItemSeq, suspensionSeq);
				responseObject.put("reinstateBehavioralSuspension", reinstateBehavioralSuspension);
				responseObject.put(STATUS, SUCCESS);
			}else {
				responseObject.put("msg", "Business logic exception detected: cfff008b: You cannot manually reinstate a suspension on a proforma order.  Either make a payment against the proforma order to reinstate the suspension or uncheck the proforma checkbox and then manually reinstate it.");
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getReinstateBehavioralSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/savePayHoldSuspension", method = RequestMethod.POST)
	public Map<String, Object> addPayHoldSuspension(SuspensionModel suspensionModel, long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		String suspensionStatus = null;
		String msg ="Business logic exception detected: cfff0083: Order item already suspended for non-payment or payment hold.";
		String msg1 ="Business logic exception detected: cfff0082: Cannot put a paid order on payment hold suspension.";
		String msg2 ="Business logic exception detected: cfff0084: Cannot place a 'Hold For Payment' suspension on a 'canceled - Customer Request' order (orderhdr_id "+ suspensionModel.getOrderhdrId() + " and order_item_seq "+suspensionModel.getOrderItemSeq()+")";
		try {
			int orderStatus = jdbcTemplate.queryForObject("SELECT order_status FROM order_item WHERE orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
			if(orderStatus != 1 && orderStatus != 2 && orderStatus != 3 && orderStatus != 4) {
				int paymentStatus = jdbcTemplate.queryForObject("SELECT payment_status FROM order_item WHERE orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
				if (paymentStatus == 0 || paymentStatus == 5 ) {
					List<String> suspensionStatusList = jdbcTemplate.queryForList("select top 1 suspension_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", String.class);
					if(suspensionStatusList.size() != 0)
						suspensionStatus = suspensionStatusList.get(0);
					if(suspensionStatus == null) {
						status = orderFunctionalityService.savePayHoldSuspension(suspensionModel);
						if (status != 0) {
							responseObject.put(STATUS, true);
							List<SuspensionModel> payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
							responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
						} else {
							responseObject.put(STATUS, false);
						}
					}else if(suspensionStatus.equals("1")) {
						int suspended = jdbcTemplate.queryForObject("SELECT top 1 suspended_order_status FROM suspension WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
							if(suspended == 9 || suspended == 16) {
								status = orderFunctionalityService.savePayHoldSuspension(suspensionModel);
								if (status != 0) {
									responseObject.put(STATUS, true);
									List<SuspensionModel> payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
									responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
								} else {
									responseObject.put(STATUS, false);
								}
							}else {
								responseObject.put(STATUS, msg);
							}
					 }else if(suspensionStatus.equals("3") || suspensionStatus.equals("2")) {
						int suspended = jdbcTemplate.queryForObject("SELECT top 1 suspended_order_status FROM suspension WHERE orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
							if(suspended == 8 || suspended == 9 || suspended == 10 || suspended == 16) {
								status = orderFunctionalityService.savePayHoldSuspension(suspensionModel);
								if (status != 0) {
									responseObject.put(STATUS, true);
									List<SuspensionModel> payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
									responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
								} else {
									responseObject.put(STATUS, false);
								}
							}else {
								responseObject.put(STATUS, msg);
							}
					}else {
						responseObject.put(STATUS, msg);
					}
					
				}else if(paymentStatus == 1) {
					responseObject.put(STATUS, msg1);
				}
			}else {
				responseObject.put(STATUS, msg2);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in addPayHoldSuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveNonPaymentSuspension", method = RequestMethod.POST)
	public Map<String, Object> addNonPaymentSuspension(SuspensionModel suspensionModel, long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		String suspensionStatus = null;
		String msg ="Business logic exception detected: cfff0083: Order item already suspended for non-payment or payment hold.";
		String msg1 ="Business logic exception detected: cfff0082: Cannot put a paid order on payment hold suspension.";
		String msg2 ="Business logic exception detected: cfff0084: Cannot place a 'Hold For Payment' suspension on a 'canceled - Customer Request' order (orderhdr_id "+ suspensionModel.getOrderhdrId() + " and order_item_seq "+suspensionModel.getOrderItemSeq()+")";
		try {
			int orderStatus = jdbcTemplate.queryForObject("SELECT order_status FROM order_item WHERE orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
			if(orderStatus != 1 && orderStatus != 2 && orderStatus != 3 && orderStatus != 4) {
				int paymentStatus = jdbcTemplate.queryForObject("SELECT payment_status FROM order_item WHERE orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
				if (paymentStatus == 0 || paymentStatus == 5 ) {
					List<String> suspensionStatusList = jdbcTemplate.queryForList("select top 1 suspension_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", String.class);
					if(suspensionStatusList.size() != 0)
						suspensionStatus = suspensionStatusList.get(0);
					if(suspensionStatus == null) {
						status = orderFunctionalityService.saveNonPaymentSuspension(suspensionModel);
						if (status != 0) {
							responseObject.put(STATUS, true);
							List<SuspensionModel> payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
							responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
						} else {
							responseObject.put(STATUS, false);
						}
					}else if(suspensionStatus.equals("1")){
						int suspensionOrder = jdbcTemplate.queryForObject("select top 1 suspended_order_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
						if(suspensionOrder == 9 || suspensionOrder == 10 || suspensionOrder == 16) {
							status = orderFunctionalityService.saveNonPaymentSuspension(suspensionModel);
							if (status != 0) {
								responseObject.put(STATUS, true);
								List<SuspensionModel> payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
								responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
							} else {
								responseObject.put(STATUS, false);
							}
						}else {
							responseObject.put(STATUS, msg);
						}
					}else if(suspensionStatus.equals("3") || suspensionStatus.equals("2")){
						int suspensionOrder = jdbcTemplate.queryForObject("select top 1 suspended_order_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc", Integer.class);
						if(suspensionOrder == 8 || suspensionOrder == 9 || suspensionOrder == 10 || suspensionOrder == 16) {
							status = orderFunctionalityService.saveNonPaymentSuspension(suspensionModel);
							if (status != 0) {
								responseObject.put(STATUS, true);
								List<SuspensionModel> payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
								responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
							} else {
								responseObject.put(STATUS, false);
							}
						}else {
							responseObject.put(STATUS, msg);
						}
					}else {	
						responseObject.put(STATUS, msg);
					}
				}else if(paymentStatus == 1) {
					responseObject.put(STATUS, msg1);
				}
			}else {
				responseObject.put(STATUS, msg2);
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in addNonPaySuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/payHoldNonPaySuspension", method = RequestMethod.POST)
	public Map<String, Object> getPayHoldNonPaySuspension(long orderhdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SuspensionModel> payHoldNonPaySuspension = new ArrayList<>();
		String customer,description;
		try {
			payHoldNonPaySuspension = orderFunctionalityService.getPayHoldNonPaySuspension(orderhdrId, orderItemSeq);
			String orderId = payHoldNonPaySuspension.get(0).getOrderhdrId();
			String orderSeq = payHoldNonPaySuspension.get(0).getOrderItemSeq();
			customer = payHoldNonPaySuspension.get(0).getCustomer();
			description = payHoldNonPaySuspension.get(0).getDescription();
			responseObject.put("customer", customer);
			responseObject.put("description", description);
				if(orderId.isEmpty() && orderSeq.isEmpty()) {
					payHoldNonPaySuspension.clear();
					responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
				}else {					
					responseObject.put("payHoldNonPaySuspension", payHoldNonPaySuspension);
				}
			
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getPayHoldNonPaySuspension() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/upgradeSubscription", method = RequestMethod.POST)
	public Map<String, Object> getUpgradeSubscription(int subscriptionDefId, int orderCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SubscriptionDef> upgradeSubscription = new ArrayList<>();
		try {
			upgradeSubscription = orderFunctionalityService.getUpgradeSubscription(subscriptionDefId, orderCodeId);
			responseObject.put("upgradeSubscription", upgradeSubscription);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getUpgradeSubscription() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/upgradeSearch", method = RequestMethod.POST)
	public Map<String, Object> getUpgradeSearch(UpDowngradeModel upDowngradeModel,int orderSubscriptionDefId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SubscriptionDef> upgradeSearch = new ArrayList<>();
		try {
			upgradeSearch = orderFunctionalityService.getUpgradeSearch(upDowngradeModel,orderSubscriptionDefId);
			responseObject.put("upgradeSearch", upgradeSearch);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getUpgradeSearch() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/upgradeItem", method = RequestMethod.POST)
	public Map<String, Object> getUpgradeItem(int subscriptionDefId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SubscriptionDef> upgradeItem = new ArrayList<>();
		try {
			upgradeItem = orderFunctionalityService.getUpgradeItem(subscriptionDefId);
			responseObject.put("upgradeItem", upgradeItem);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getUpgradeItem() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/downgradeSubscription", method = RequestMethod.POST)
	public Map<String, Object> getDowngradeSubscription(int subscriptionDefId, int orderCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SubscriptionDef> downgradeSubscription = new ArrayList<>();
		try {
			downgradeSubscription = orderFunctionalityService.getDowngradeSubscription(subscriptionDefId, orderCodeId);
			responseObject.put("downgradeSubscription", downgradeSubscription);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDowngradeSubscription() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/downgradeSearch", method = RequestMethod.POST)
	public Map<String, Object> getdowngradeSearch(UpDowngradeModel upDowngradeModel,int orderSubscriptionDefId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SubscriptionDef> downgradeSearch = new ArrayList<>();
		try {
			downgradeSearch = orderFunctionalityService.getDowngradeSearch(upDowngradeModel, orderSubscriptionDefId);
			responseObject.put("downgradeSearch", downgradeSearch);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDowngradeSearch() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/transferOrder", method = RequestMethod.POST)
	public Map<String, Object> getTransferOrder(long orderhdrId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<OrderItemModel> transferOrder = new ArrayList<>();
		try {
			transferOrder = orderFunctionalityService.getTransferOrder(orderhdrId);
			responseObject.put("transferOrder", transferOrder);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getTransferOrder() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveTransferOrder", method = RequestMethod.POST)
	public Map<String, Object> saveTransferOrder(TransferOrderModel transferOrderModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.saveTransferOrder(transferOrderModel);
			status = orderFunctionalityService.updateTransferOrder(transferOrderModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveTransferOrder() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/renewalOption", method = RequestMethod.POST)
	public Map<String, Object> getRenewalOption(long orderhdrId, int orderItemSeq, int renewalStatus, String autoPayment) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> renewalOption = new ArrayList<>();
		try {
			renewalOption = orderFunctionalityService.getRenewalOption(orderhdrId, orderItemSeq, renewalStatus,autoPayment);
			responseObject.put("renewalOptionr", renewalOption);
			List<DropdownModel> cancelReason = orderFunctionalityService.getCancelReason();
			responseObject.put("cancelReason", cancelReason);
			List<DropdownModel> autoPayCreditCard = orderFunctionalityService.getAutoPayCreditCard(orderhdrId, orderItemSeq);
			responseObject.put("autoPayCreditCard", autoPayCreditCard);
			List<DropdownModel> autoPayDirectDebit = orderFunctionalityService.getAutoPayDirectDebit(orderhdrId, orderItemSeq);
			responseObject.put("autoPayDirectDebit", autoPayDirectDebit);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getRenewalOption() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

//	@RequestMapping(path = "/saveRenewalOption", method = RequestMethod.POST)
//	public Map<String, Object> saveRenewalOption(TransferOrderModel transferOrderModel) {
//		Map<String, Object> responseObject = new LinkedHashMap<>();
//		int status = 0;
//		try {
//			status = orderFunctionalityService.updateRenewalOption(transferOrderModel);
//			if (status != 0) {
//				responseObject.put(STATUS, true);
//			} else {
//				responseObject.put(STATUS, false);
//			}
//			return responseObject;
//		} catch (Exception e) {
//			LOGGER.info("Error in updateRenewalOption() : " + e);
//			responseObject.put(STATUS, ERROR + e);
//			return responseObject;
//		}
//	}

	@RequestMapping(path = "/groupMember", method = RequestMethod.POST)
	public Map<String, Object> getGroupMember(Long customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> groupMember = new ArrayList<>();
		try {
			groupMember = orderFunctionalityService.getGroupMember(customerId);
			responseObject.put("groupMember", groupMember);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getGroupMember() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/groupMemberSetUp", method = RequestMethod.POST)
	public Map<String, Object> getGrpMbrSetUp() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<GroupMemberModel> groupMemberSetUp = orderFunctionalityService.getGrpMbrSetUp();
			responseObject.put("groupMemberSetUp", groupMemberSetUp);
			List<DropdownModel> address = orderFunctionalityService.getAddress();
			responseObject.put("address", address);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getGroupMemberSetUp() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/editGrpMbrSetUp", method = RequestMethod.POST)
	public Map<String, Object> getEditGroupMemberSetUp(int customerId, int customerAddressSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			GroupMemberModel editGroupMemberSetUp1 = orderFunctionalityService.getEditGroupMemberSetUp(customerId,customerAddressSeq);
			responseObject.put("editGroupMemberSetUp1", editGroupMemberSetUp1);
			List<DropdownModel> address = orderFunctionalityService.getAddress(customerId);
			responseObject.put("address", address);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getGroupMemberSetUp() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveGroupMember", method = RequestMethod.POST)
	public Map<String, Object> saveGroupMember(TransferOrderModel transferOrderModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			List<String> group = jdbcTemplate.queryForList("select customer_id from customer_group where customer_id="+transferOrderModel.getCustomerId(), String.class);
			if(group.isEmpty()) {
				List<String> member = jdbcTemplate.queryForList("select customer_id from group_member where customer_group_customer_id="+transferOrderModel.getCustomerGroupCustomerId()+" and customer_id="+transferOrderModel.getCustomerId(), String.class);
				if(member.isEmpty()) {
					status = orderFunctionalityService.saveGroupMember(transferOrderModel);
					if (status != 0) {
						responseObject.put(STATUS, true);
					} else {
						responseObject.put(STATUS, false);
					}
					
				}else {
					responseObject.put("msg", " This member already exist in the group.");
				}
				
			}else {
				responseObject.put("msg", " A group may not contain another group as a member.");
			}
			//status = orderFunctionalityService.saveGrpMbrOrdHandling(transferOrderModel);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveGroupMember() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateEditGroupMember", method = RequestMethod.POST)
	public Map<String, Object> updateEditGroupMember(TransferOrderModel transferOrderModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.updateEditGroupMember(transferOrderModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in editGroupMember() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteGroupMember", method = RequestMethod.POST)
	public Map<String, Object> deleteGroupMember(int customerId, int customerGroupcustomerId, int customerAddressSeq) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.deleteGroupMember(customerId, customerGroupcustomerId,
					customerAddressSeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteGroupOrder : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/custGrpMbrHistory", method = RequestMethod.POST)
	public Map<String, Object> getCustomerGroupMemberHistory(int custGrpCustomerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> customerGroupMemberHistory = new ArrayList<>();
		try {
			customerGroupMemberHistory = orderFunctionalityService.getCustomerGroupMemberHistory(custGrpCustomerId);
			responseObject.put("customerGroupMemberHistory", customerGroupMemberHistory);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getGroupMemberSetUp() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveCustomerGroup", method = RequestMethod.POST)
	public Map<String, Object> saveCustomerGroupEdit(CustomerGroupModel customerGroupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		int status = 0;
		try {
			if(!customerGroupModel.getCustomerGroup().equals("") || !customerGroupModel.getCustomerGroup().equals("null") || !customerGroupModel.getCustomerGroup().isEmpty()) {
				status = orderFunctionalityService.saveCustomerGroupEdit(customerGroupModel);
				if (status != 0) {
					responseObject.put(STATUS, true);
					int customerId = customerGroupModel.getCustomerId();
					int customerAddressSeq = customerGroupModel.getCustomerAddressSeq();
					CustomerGroupModel customerGroup = orderFunctionalityService.getGroup(customerId, customerAddressSeq);
					responseObject.put("customerGroup", customerGroup);
					List<DropdownModel> shipType = orderFunctionalityService.getShipType();
					List<DropdownModel> newGroupMemberAction = orderFunctionalityService.getNewGroupMemberAction();
					List<DropdownModel> backIssueShipType = orderFunctionalityService.getBackIssueShipType();
					responseObject.put("shipType", shipType);
					responseObject.put("newGroupMemberAction", newGroupMemberAction);
					responseObject.put("backIssueShipType", backIssueShipType);
				} else {
					responseObject.put(STATUS, false);
				}
			}else {
				responseObject.put("msg", " Missing: customer_group.customer_group. ");
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveCustomerGroupEdit() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/customerGroup", method = RequestMethod.POST)
	public Map<String, Object> getGroup(int customerId, int customerAddressSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			CustomerGroupModel customerGroup = orderFunctionalityService.getGroup(customerId, customerAddressSeq);
			responseObject.put("customerGroup", customerGroup);
			List<DropdownModel> shipType = orderFunctionalityService.getShipType();
			List<DropdownModel> newGroupMemberAction = orderFunctionalityService.getNewGroupMemberAction();
			List<DropdownModel> backIssueShipType = orderFunctionalityService.getBackIssueShipType();
			responseObject.put("shipType", shipType);
			responseObject.put("newGroupMemberAction", newGroupMemberAction);
			responseObject.put("backIssueShipType", backIssueShipType);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(value = "/groupSearch", method = RequestMethod.POST)
	public Map<String, Object> getGroupSearch(UpDowngradeModel upDowngradeModel) {
		Map<String, Object> responsedObject = new LinkedHashMap<>();
		List<Map<String, Object>> groupSearch = new ArrayList<>();
		try {
			groupSearch = orderFunctionalityService.getGroupSearch(upDowngradeModel);
			responsedObject.put("groupSearch", groupSearch);
			responsedObject.put(STATUS, SUCCESS);
			return responsedObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responsedObject.put(STATUS, ERROR);
			return responsedObject;
		}
	}

	@RequestMapping(path = "/updateCustomerGroup", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerGroup(CustomerGroupModel customerGroupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		String status = "";
		try {
			if(!customerGroupModel.getCustomerGroup().equals("") || !customerGroupModel.getCustomerGroup().equals("null") || !customerGroupModel.getCustomerGroup().isEmpty()) {
				status = orderFunctionalityService.updateCustomerGroup(customerGroupModel);
				if (ERROR.equals(status)) {
					responseObject.put(STATUS, ERROR);
				} else {
					responseObject.put(STATUS, SUCCESS);
					responseObject.put("CustomerId", status);
					int customerId = customerGroupModel.getCustomerId();
					int customerAddressSeq = customerGroupModel.getCustomerAddressSeq();
					CustomerGroupModel customerGroup = orderFunctionalityService.getGroup(customerId, customerAddressSeq);
					responseObject.put("customerGroup", customerGroup);
					List<DropdownModel> shipType = orderFunctionalityService.getShipType();
					List<DropdownModel> newGroupMemberAction = orderFunctionalityService.getNewGroupMemberAction();
					List<DropdownModel> backIssueShipType = orderFunctionalityService.getBackIssueShipType();
					responseObject.put("shipType", shipType);
					responseObject.put("newGroupMemberAction", newGroupMemberAction);
					responseObject.put("backIssueShipType", backIssueShipType);
				}
			}else {
				responseObject.put("msg", " Missing: customer_group.customer_group. ");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateCustomerGroup() : " + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/demoteToGroup", method = RequestMethod.POST)
	public Map<String, Object> deleteCustomerGroup(int customerId) {
		Map<String, Object> responseObject = new HashMap<>();
		String status = "";
		try {
			List<String> group = jdbcTemplate.queryForList("select distinct group_order from order_item where group_order = 1 and order_status in (0,5,7,8,9,10,11,12,13) and customer_id="+customerId, String.class);
			if(group.isEmpty()) {
				List<String> cancelGroup = jdbcTemplate.queryForList("select distinct group_order from order_item where group_order = 1 and order_status in (1,2,3,4) and customer_id="+customerId, String.class);
				if(cancelGroup.isEmpty()) {
					status = orderFunctionalityService.deleteCustomerGroup(customerId);
					if (status.equals("1")) {
						responseObject.put(STATUS, true);
						responseObject.put("status", "deleted successfully");
					} else {
						responseObject.put(STATUS, false);
					}
				}else {
					responseObject.put("msg", "A general system error has occurred.  Use Copy to Clipboard to copy the details to the clipboard and forward the results to Support for assistance.");
				}
			}else {
				responseObject.put("msg", "You cannot remove group status from this customer because there are existing group orders for this customer.");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in deleteCustomerGroup() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/demForm", method = RequestMethod.POST)
	public Map<String, Object> getDemForm(String demFormId, String ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> demForm = new ArrayList<>();
		try {
			demForm = orderFunctionalityService.getDemForm(demFormId, ocId);
			responseObject.put("demForm", demForm);

			List<DropdownModel> demographicForm = orderFunctionalityService.getDemographicForm(demFormId, ocId);
			responseObject.put("demographicForm", demographicForm);
			
			List<Map<String, Object>> demForm1 = orderFunctionalityService.getDemForm1(demFormId, ocId);
			responseObject.put("demForm1", demForm1);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDemForm() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/prospect", method = RequestMethod.POST)
	public Map<String, Object> getProspect(Long customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> prospect = new ArrayList<>();
		try {
			prospect = orderFunctionalityService.getProspect(customerId);
			responseObject.put("prospect", prospect);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/prospectSetup", method = RequestMethod.POST)
	public Map<String, Object> getProspectSetup(Long customerId, int customerAddressSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		ProspectModel prospectSetup = null;
		try {
			prospectSetup = orderFunctionalityService.getProspectSetup(customerId, customerAddressSeq);
			responseObject.put("prospectSetup", prospectSetup);
			List<DropdownModel> orderClass = customerOrderService.getorderClass();
			responseObject.put("orderClass", orderClass);
			List<DropdownModel> prospectCategory = customerSearchService.getProspectCategory();
			responseObject.put("prospectCategory", prospectCategory);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/editProspectSetup", method = RequestMethod.POST)
	public Map<String, Object> getEditProspectSetup(Long customerId, int customerProspectSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		ProspectModel editProspectSetup = null;
		try {
			editProspectSetup = orderFunctionalityService.getEditProspectSetup(customerId,customerProspectSeq);
			responseObject.put("editProspectSetup", editProspectSetup);
			String ocId = editProspectSetup.getOcId();
			List<DropdownModel> orderClassProspect = orderFunctionalityService.getorderClassProspect();
			responseObject.put("orderClassProspect", orderClassProspect);
			List<DropdownModel> prospectCategory = customerSearchService.getProspectCategory();
			responseObject.put("prospectCategory", prospectCategory);
			List<SourceCode> sourceCodeList = orderSourceOfferService.getSourceCode(ocId);
			responseObject.put("sourceCodeList", sourceCodeList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/deleteProspect", method = RequestMethod.POST)
	public Map<String, Object> deleteProspect(Long customerId, int customerProspectSeq) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.deleteProspect(customerId, customerProspectSeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteProspect : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/saveProspectSetup", method = RequestMethod.POST)
	public Map<String, Object> saveProspectSetup(ProspectModel prospectModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		String msg = "A general system error has occurred, Use Copy to Clipboard to copy the detail to the clipboard and forward the results to Support for assistance";
		try {
			status = orderFunctionalityService.saveProspectSetup(prospectModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			}else {
				if(prospectModel.getProspectCategory().equals(null) || prospectModel.getProspectCategory().equals("") || prospectModel.getProspectCategory().isEmpty()) {
					responseObject.put("message", "You must choose a prospect category.");
					responseObject.put(STATUS, false);
				}else {
				responseObject.put("msg", msg);
			   }
		   }
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveProspectSetup() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateProspectSetup", method = RequestMethod.POST)
	public Map<String, Object> UpdateProspectSetup(ProspectModel prospectModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.UpdateProspectSetup(prospectModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in UpdateProspectSetup() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/grpMbrOrdDetail", method = RequestMethod.POST)
	public Map<String, Object> getGroupMemberOrderDetail(Long customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> groupMemberOrder = orderFunctionalityService.getGroupMemberOrderDetail(customerId);
			responseObject.put("groupMemberOrder", groupMemberOrder);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/editAuditInfo", method = RequestMethod.POST)
	public Map<String, Object> getEditAuditInfo(Long orderHdrId, int orderItemSeq,int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			int audited = jdbcTemplate.queryForObject("select audited from pub where oc_id="+ocId, Integer.class);
			if(audited == 1) {
				int qp = jdbcTemplate.queryForObject("select qp from pub where oc_id="+ocId, Integer.class);
				int qf = jdbcTemplate.queryForObject("select qf from pub where oc_id="+ocId, Integer.class);
				int nqp = jdbcTemplate.queryForObject("select nqp from pub where oc_id="+ocId, Integer.class);
				int nqf = jdbcTemplate.queryForObject("select nqf from pub where oc_id="+ocId, Integer.class);
				if(qp == 1 || qf == 1 || nqp == 1 || nqf == 1 ) {
					ProspectModel editAuditInfo = orderFunctionalityService.getEditAuditInfo(orderHdrId, orderItemSeq, ocId);
					responseObject.put("editAuditInfo", editAuditInfo);
					
					String salesChannel = jdbcTemplate.queryForObject("select sales_channel_pub_group from pub where oc_id="+ocId, String.class);
					if(salesChannel != null) {
					List<DropdownModel> auditNameTitle  = orderFunctionalityService.getAuditNameTitle(ocId);
					responseObject.put("auditNameTitle", auditNameTitle);
					}
					String nameTitle = jdbcTemplate.queryForObject("select name_title_pub_group from pub where oc_id="+ocId, String.class);
					if(nameTitle != null) {
					List<DropdownModel> auditQualSource  = orderFunctionalityService.getAuditQualSource(ocId);
					responseObject.put("auditQualSource", auditQualSource);
					}
					String qualSource = jdbcTemplate.queryForObject("select qual_source_pub_group from pub where oc_id="+ocId, String.class);
					if(qualSource != null) {
					List<DropdownModel> auditSalesChannel  = orderFunctionalityService.getAuditSalesChannel(ocId);
					responseObject.put("auditSalesChannel", auditSalesChannel);
					}
					String subType = jdbcTemplate.queryForObject("select sub_type_pub_group from pub where oc_id="+ocId, String.class);
					if(subType != null) {
					List<DropdownModel> auditSubscriptionType  = orderFunctionalityService.getAuditSubscriptionType(ocId);
					responseObject.put("auditSubscriptionType", auditSubscriptionType);
					}
				}
			}
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/updateEditAuditInfo", method = RequestMethod.POST)
	public Map<String, Object> updateEditAuditInfo(OrderItem orderItem) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		String msg = " The short qualification date must be the same as the long qualification date or a date later than the long qualification date.";
		String msg1 = " Business logic exception detected: cfff0186: Invalid Qualification dates.  The long and short qualification dates cannot be after today's date.";
		try {
			String qual = orderItem.getQualDate();
			String squal = orderItem.getSqualDate();
			String date = jdbcTemplate.queryForObject("select convert(nvarchar, getdate(), 101) as date", String.class);
			//squal>qual or squal=qual
			if(qual.compareTo(squal)<0  || qual.equals(squal)) {
				// squal = date or squal<date
				if(squal.equals(date) || squal.compareTo(date)<0) {
					status = orderFunctionalityService.updateEditAuditInfo(orderItem);
					if (status != 0) {
						responseObject.put(STATUS, "Successfully Updated");
					} else {
						responseObject.put(STATUS, "Unsuccessful");
					}
				}else {
					responseObject.put("msg1", msg1);
				}
			}else {
				responseObject.put("msg", msg);
			}
			
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateEditAuditInfo() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/auditCustomer", method = RequestMethod.POST)
	public Map<String, Object> getAudit(int ocId, String orderCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();		
		try {
			int audited = jdbcTemplate.queryForObject("select audited from pub where oc_id="+ocId, Integer.class);
			if(audited == 1) {
				int qp = jdbcTemplate.queryForObject("select qp from pub where oc_id="+ocId, Integer.class);
				int qf = jdbcTemplate.queryForObject("select qf from pub where oc_id="+ocId, Integer.class);
				int nqp = jdbcTemplate.queryForObject("select nqp from pub where oc_id="+ocId, Integer.class);
				int nqf = jdbcTemplate.queryForObject("select nqf from pub where oc_id="+ocId, Integer.class);
				if(qp == 1 || qf == 1 || nqp == 1 || nqf == 1 ) {
					if(orderCodeId.equals(null) || orderCodeId.equals("") || orderCodeId.isEmpty()) {
						ProspectModel auditCustomer = orderFunctionalityService.getAudit(ocId);
						responseObject.put("auditCustomer", auditCustomer);
					}else {
						ProspectModel auditCustomer = orderFunctionalityService.getAuditOrder(ocId,orderCodeId);
						responseObject.put("auditCustomer", auditCustomer);
					}
					String salesChannel = jdbcTemplate.queryForObject("select sales_channel_pub_group from pub where oc_id="+ocId, String.class);
					if(salesChannel != null) {
					List<DropdownModel> auditNameTitle  = orderFunctionalityService.getAuditNameTitle(ocId);
					responseObject.put("auditNameTitle", auditNameTitle);
					}
					String nameTitle = jdbcTemplate.queryForObject("select name_title_pub_group from pub where oc_id="+ocId, String.class);
					if(nameTitle != null) {
					List<DropdownModel> auditQualSource  = orderFunctionalityService.getAuditQualSource(ocId);
					responseObject.put("auditQualSource", auditQualSource);
					}
					String qualSource = jdbcTemplate.queryForObject("select qual_source_pub_group from pub where oc_id="+ocId, String.class);
					if(qualSource != null) {
					List<DropdownModel> auditSalesChannel  = orderFunctionalityService.getAuditSalesChannel(ocId);
					responseObject.put("auditSalesChannel", auditSalesChannel);
					}
					String subType = jdbcTemplate.queryForObject("select sub_type_pub_group from pub where oc_id="+ocId, String.class);
					if(subType != null) {
					List<DropdownModel> auditSubscriptionType  = orderFunctionalityService.getAuditSubscriptionType(ocId);
					responseObject.put("auditSubscriptionType", auditSubscriptionType);
					}
				}else {
					responseObject.put(STATUS, " Setup for this publication does not allow any qualification categories ");
				}
				responseObject.put(STATUS, SUCCESS);
			}else {
				responseObject.put(STATUS, " Setup for this publication does not allow any qualification categories ");
			}
			//responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addAuditInfo", method = RequestMethod.POST)
	public Map<String, Object> getAddAuditInfo(Long orderHdrId, int orderItemSeq, int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();		
		try {
			int qp = jdbcTemplate.queryForObject("select qp from pub where oc_id="+ocId, Integer.class);
			int qf = jdbcTemplate.queryForObject("select qf from pub where oc_id="+ocId, Integer.class);
			int nqp = jdbcTemplate.queryForObject("select nqp from pub where oc_id="+ocId, Integer.class);
			int nqf = jdbcTemplate.queryForObject("select nqf from pub where oc_id="+ocId, Integer.class);
			if(qp == 1 || qf == 1 || nqp == 1 || nqf == 1 ) {
				ProspectModel auditCustomer = orderFunctionalityService.getAddAuditInfo(orderHdrId, orderItemSeq, ocId);
				responseObject.put("auditCustomer", auditCustomer);	
					
				String salesChannel = jdbcTemplate.queryForObject("select sales_channel_pub_group from pub where oc_id="+ocId, String.class);
				if(salesChannel != null) {
					List<DropdownModel> auditNameTitle  = orderFunctionalityService.getAuditNameTitle(ocId);
					responseObject.put("auditNameTitle", auditNameTitle);
				}
				String nameTitle = jdbcTemplate.queryForObject("select name_title_pub_group from pub where oc_id="+ocId, String.class);
				if(nameTitle != null) {
					List<DropdownModel> auditQualSource  = orderFunctionalityService.getAuditQualSource(ocId);
					responseObject.put("auditQualSource", auditQualSource);
				}
				String qualSource = jdbcTemplate.queryForObject("select qual_source_pub_group from pub where oc_id="+ocId, String.class);
				if(qualSource != null) {
					List<DropdownModel> auditSalesChannel  = orderFunctionalityService.getAuditSalesChannel(ocId);
					responseObject.put("auditSalesChannel", auditSalesChannel);
				}
				String subType = jdbcTemplate.queryForObject("select sub_type_pub_group from pub where oc_id="+ocId, String.class);
				if(subType != null) {
					List<DropdownModel> auditSubscriptionType  = orderFunctionalityService.getAuditSubscriptionType(ocId);
					responseObject.put("auditSubscriptionType", auditSubscriptionType);
				}
				responseObject.put(STATUS, SUCCESS);
			}else {
				responseObject.put(STATUS, " Setup for this publication does not allow any qualification categories ");
			}
			//responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/upsellItem", method = RequestMethod.POST)
	public Map<String, Object> getUpsellItem(int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		String msg = "Upsell is not enabled for this order class.";
		try {
			List<Map<String, Object>> upsellItemList = orderFunctionalityService.getUpsellItem(ocId);
			int upsellOn = jdbcTemplate.queryForObject("select upsell_on from oc where oc_id = (select parent_oc_id from oc where oc_id = "+ocId+")", Integer.class);
			if(upsellOn == 1) {
				responseObject.put("upsellItemList", upsellItemList);
				responseObject.put(STATUS, SUCCESS);
			}else {
				responseObject.put("msg", msg);
			}
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
		
		@RequestMapping(path = "/upgradeDowngradeSubscription", method = RequestMethod.POST)
		public  Map<String, Object> upgradeDowngradeSubscription(int subscription_def_id,String gridDefID,long orderhdrId, int orderItemSeq) 
	 {
			Map<String, Object> responseObject = new LinkedHashMap<>();
			String orderstatus = "false";
			try {
				 orderstatus = orderFunctionalityService.getUpgradeDowngrade(subscription_def_id, gridDefID, orderhdrId, orderItemSeq);
				 responseObject.put(STATUS, orderstatus);
				 return responseObject;				 			
			} 
			catch (Exception e) {
				LOGGER.info("Error in updateEditAuditInfo() : " + e);
				responseObject.put(STATUS, ERROR + e);
				return responseObject;
			}
}
	
	@RequestMapping(path = "/getGroupAddress", method = RequestMethod.POST)
	public Map<String, Object> getGroupAddress(Long customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<CustomerAddressModel> groupAddress = customerSearchService.getaddressDetail(customerId,"default");
			responseObject.put("groupAddress", groupAddress);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	 
 	@RequestMapping(path = "/getOrderAddDetails", method = RequestMethod.POST)
public  Map<String, Object> getOrderAddDetails(@RequestParam("oc_id")int oc_id,@RequestParam("CustomerId") int CustomerId,@RequestParam("orderCode") String orderCode,@RequestParam("orderHdrId")int orderHdrId,@RequestParam("order_item_seq")int order_item_seq)
{
	Map<String, Object> responseObject = new LinkedHashMap<>();
	
	try {
						
		 OrderItem  orderAddResponse=orderFunctionalityService.getOrderItemEditDetails(orderHdrId,order_item_seq);
				responseObject.put("orderEditResponse",orderAddResponse );
		
		List<DropdownModel> start_date=orderFunctionalityService.getStartDate(orderAddResponse.getOrderCode());
		 responseObject.put("start_date",start_date );
			
		 List<DropdownModel> backIsuues=orderFunctionalityService.getBackIssueDetails(orderAddResponse.getOrderCode());
		 responseObject.put("backIsuues",backIsuues );
		 
		 List<DropdownModel> rateCard=orderFunctionalityService.getRateBackDetails(orderAddResponse.getOrderCode());
		 responseObject.put("rateCardDescription",rateCard );
		 
		 List<DropdownModel> category=orderFunctionalityService.getCategoryDetails();
		 responseObject.put("category",category );
		 
		 List<DropdownModel> ShippingDeliveryDetails=orderFunctionalityService.getShippingDeliveryDetails();
		 responseObject.put("ShippingDeliveryDetails",ShippingDeliveryDetails );
		 
		 List<DropdownModel> DemographicDetails=orderFunctionalityService.getDemographicDetails();
		 responseObject.put("DemographicDetails",DemographicDetails );
		
		 List<DropdownModel> addressDetails=orderFunctionalityService.getAddressDetails(CustomerId);
		 responseObject.put("addressDetails",addressDetails );
		 return responseObject;
		 
		
	} 
	catch (Exception e) {
		LOGGER.info("Error in getOrderAddDetails() : " + e);
		responseObject.put(STATUS, ERROR + e);
		return responseObject;
	}
}
	
	@RequestMapping(path = "/upsellOrder", method = RequestMethod.POST)
	public Map<String, Object> getUpsellOrder(int ocId,int orderCodeId, int sourceCodeId,int upsellId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> upsellOrder = orderFunctionalityService.getUpsellOrder(ocId,orderCodeId,sourceCodeId,upsellId);
			responseObject.put("upsellOrder", upsellOrder);
			responseObject.put(STATUS, SUCCESS);	
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/audited", method = RequestMethod.POST)
	public Map<String, Object> getAudited(String ocId){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> audited = orderFunctionalityService.getAudited(ocId);
			responseObject.put("audited", audited);
			responseObject.put(STATUS, SUCCESS);	
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}


	
	@RequestMapping(path = "/getDealDetails", method = RequestMethod.POST)
	public Map<String, Object> getDealsDetails(Long customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> dealDetails = new ArrayList<>();
		List<DropdownModel> dealStatus = new ArrayList<>();
		List<DropdownModel> dealType = new ArrayList<>();
		GropDealModel groupDeal = new GropDealModel();

		try {
			dealDetails = orderFunctionalityService.getDealDetails(customerId);
			dealType = orderFunctionalityService.getDealType();
			dealStatus = orderFunctionalityService.getDealStatus();
			responseObject.put("dealDetails", dealDetails);
			responseObject.put("dealStatus", dealStatus);
			responseObject.put("dealType", dealType);
			List<DropdownModel> orderType = new ArrayList<>();
			orderType.add(new DropdownModel("0", "Orderable", null, null, null, null));
			orderType.add(new DropdownModel("1", "DDP", null, null, null, null));
			orderType.add(new DropdownModel("2", "DoNotCancel", null, null, null, null));
			responseObject.put("dealOrderCodeType", orderType);
		responseObject.put("defaultDate", orderFunctionalityService.getStartEndDate1());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsDetails() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/getDealOrderCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> getDealOrderDetails(int dealId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> dealDetails = new ArrayList<>();
		List<DropdownModel> dealStatus = new ArrayList<>();
		List<DropdownModel> dealType = new ArrayList<>();
		try {
			dealDetails = orderFunctionalityService.getDealOrderCodeDetails(dealId);
			responseObject.put("dealDetails1", dealDetails);
			dealType = orderFunctionalityService.getDealType();
			dealStatus = orderFunctionalityService.getDealStatus();
			responseObject.put("dealStatus", dealStatus);
			List<DropdownModel> orderType = new ArrayList<>();
			orderType.add(new DropdownModel("0", "Orderable", null, null, null, null));
			orderType.add(new DropdownModel("1", "DDP", null, null, null, null));
			orderType.add(new DropdownModel("2", "DoNotCancel", null, null, null, null));
			responseObject.put("dealOrderCodeType", orderType);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealOrderDetails() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/getDealOrderingCustomer", method = RequestMethod.POST)
	public Map<String, Object> getDealOrderingCustomer(int dealId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> dealOrderingCustomer = new ArrayList<>();
		List<DropdownModel> dealStatus = new ArrayList<>();
		List<DropdownModel> dealType = new ArrayList<>();
		try {
			dealOrderingCustomer = orderFunctionalityService.getDealOrderingCustomer(dealId);
			responseObject.put("DealOrderingCustomer", dealOrderingCustomer);
			dealType = orderFunctionalityService.getDealType();
			dealStatus = orderFunctionalityService.getDealStatus();
			List<Map<String,Object>> groupDetails=orderFunctionalityService.getgroupDetails(dealId);
			responseObject.put("groupDetails", groupDetails);
			responseObject.put("dealStatus", dealStatus);
			List<DropdownModel> orderType = new ArrayList<>();
			orderType.add(new DropdownModel("0", "Orderable", null, null, null, null));
			orderType.add(new DropdownModel("1", "DDP", null, null, null, null));
			orderType.add(new DropdownModel("2", "DoNotCancel", null, null, null, null));
			responseObject.put("dealOrderCodeType", orderType);
			
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealOrderDetails() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveDealsDetails", method = RequestMethod.POST)
	public Map<String, Object> saveDealsDetails( GropDealModel gropDealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		
		try {

			status = orderFunctionalityService.saveDealDetails(gropDealModel);
			int dealId=orderFunctionalityService.getDealId();
			if (status != 0 ) {
				responseObject.put(STATUS, "table are inseted successfully");
				responseObject.put("dealId", dealId);
			} else {
				responseObject.put(STATUS, "failed to insert/duplicate entry into table");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDealsDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/saveDealOrderCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> saveDealOrderCodeDetails( GropDealModel gropDealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		
		try {

			status = orderFunctionalityService.saveDealOrderCodeDetails(gropDealModel);
			int dealId=orderFunctionalityService.getDealId();
			if (status != 0 ) {
				responseObject.put(STATUS, "tables are inseted successfully");
				responseObject.put("dealId", dealId);
			} else {
				responseObject.put(STATUS, "failed to insert into table");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDealOrderCodeDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/saveDealOrderingCustomer", method = RequestMethod.POST)
	public Map<String, Object> saveDealOrderingCustomer( GropDealModel gropDealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		
		try {
			status = orderFunctionalityService.saveDealOrderingCustomer(gropDealModel);
			
			int dealId=orderFunctionalityService.getDealId();
			if (status != 0 ) {
				
				responseObject.put(STATUS, "table are inseted successfully");
				responseObject.put("dealId", dealId);
			} else {
				responseObject.put(STATUS, "failed to insert into table");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDealOrderingCustomer() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	
	@RequestMapping(path = "/editDeals", method = RequestMethod.POST)
	public Map<String, Object> updateDeals(@RequestParam int dealId,GropDealModel groupdeal) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		
		try {
			
			List<Map<String,Object>> dealOrderCodeDetails=orderFunctionalityService.getDealOrderCodeDetails(dealId);
			List<Map<String,Object>> dealOrderingCustomerDetails=orderFunctionalityService.getDealOrderingCustomer(dealId);
			List<Map<String,Object>> groupDetails=orderFunctionalityService.getgroupDetails(dealId);
			status = orderFunctionalityService.updateDeals(groupdeal);
			responseObject.put("groupDetails", groupDetails);
			responseObject.put("dealOrderCodeDetails", dealOrderCodeDetails);
			responseObject.put("dealOrderingCustomerDetails", dealOrderingCustomerDetails);
				if (status != 0) {
						
				responseObject.put(STATUS, "Successfully Updated");
			} else {
				responseObject.put(STATUS, "Unsuccessful");
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateDeals() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	
	@RequestMapping(path = "/getSubgroupsDetails", method = RequestMethod.POST)
	public Map<String, Object> getSubgroupsDetails(int gcustomerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		//List<Map<String, Object>> details = new ArrayList<>();
		
		try {
			GroupMainModel Model = new GroupMainModel();
			Model.setId(0);
			String title=orderFunctionalityService.getGroupGroupDescription(gcustomerId);
			Model.setGroup(title);
			
			List<GroupStructureLeftPanel> groupList = new ArrayList<>();
			GroupStructureLeftPanel groupModel = new GroupStructureLeftPanel();
			groupModel.setId(1);
			groupModel.setTitle("Members");
			
		
			List<DropdownModel> members=orderFunctionalityService.getGroupMemberNames(gcustomerId);
			List<Map<String ,Object>> tValue=new ArrayList<>();

			int id=1;
			for (DropdownModel dropdownModel : members) {
				Map<String ,Object> value=new LinkedHashMap<>();
				value.put("id", id);
				value.put("title", dropdownModel.getKey());
				tValue.add(value);
				id++;
			}
			groupModel.setNodes(tValue);
			
			groupList.add(groupModel);
			
			List<GroupStructureLeftPanel> childList = new ArrayList<>();
			GroupStructureLeftPanel subgroupModel = new GroupStructureLeftPanel();
			subgroupModel.setId(2);
			subgroupModel.setTitle("Subgroup");
			groupList.add(subgroupModel);
			
			childList.add(groupModel);
			childList.add(subgroupModel);
			Model.setNodes(childList);
			
			List<GroupMainModel> leftPanel=new ArrayList<>();
			leftPanel.add(Model);

			responseObject.put("StructuresData", leftPanel);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getSubgroupsDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
		}
		return responseObject;

	}
	
	
	@RequestMapping(path = "/getAllSubgroups", method = RequestMethod.POST)
	public Map<String, Object> getAllSubgroupsDetails(int gcustomerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Integer> childId = orderFunctionalityService.getAllSubgroups(gcustomerId);
			System.out.println("chiold"+childId);
			List<GroupMainModel> leftPanel=new ArrayList<>();
			
			for(Integer childIds:childId) {
				
				GroupMainModel model = new GroupMainModel();
				model.setId(0);
				String title=orderFunctionalityService.getGroupGroupDescription(childIds);
				System.out.println(childIds);
				model.setGroup(title);
				
				List<GroupStructureLeftPanel> childList = new ArrayList<>();
				List<GroupStructureLeftPanel> groupList = new ArrayList<>();
				
				GroupStructureLeftPanel groupModel = new GroupStructureLeftPanel();
				groupModel.setId(1);
				groupModel.setTitle("Members");
				
				GroupStructureLeftPanel subgroupModel = new GroupStructureLeftPanel();
				subgroupModel.setId(2);
				subgroupModel.setTitle("Subgroup");
			
				List<DropdownModel> members=orderFunctionalityService.getGroupMemberNames(childIds);
				List<Map<String ,Object>> tValue=new ArrayList<>();

				int id=1;
				for (DropdownModel dropdownModel : members) {
					Map<String ,Object> value=new LinkedHashMap<>();
					value.put("id", id);
					value.put("title", dropdownModel.getKey());
					tValue.add(value);
					id++;
				}
				groupModel.setNodes(tValue);
				
				
				childList.add(groupModel);
				childList.add(subgroupModel);
				
				groupList.add(groupModel);
				groupList.add(subgroupModel);
				
				model.setNodes(childList);
			
				
				leftPanel.add(model);
			}
			
			responseObject.put("StructuresData", leftPanel);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getSubgroupsDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
		}
		return responseObject;

	}

	
	@RequestMapping(path = "/getSubgroups", method = RequestMethod.POST)
	public Map<String, Object> getSubgroups(int gcustomerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<GroupMainModel> leftPanel1 = new ArrayList<>();

		try {
			GroupMainModel Model = new GroupMainModel();
			
			String title = orderFunctionalityService.getGroupGroupDescription(gcustomerId);

			List<GroupStructureLeftPanel> groupList = new ArrayList<>();
			GroupStructureLeftPanel groupModel = new GroupStructureLeftPanel();
			groupModel.setId(1);
			groupModel.setTitle("Members");

			List<DropdownModel> members = orderFunctionalityService.getGroupMemberNames(gcustomerId);
			List<Map<String, Object>> tValue = new ArrayList<>();

			int id = 1;
			for (DropdownModel dropdownModel : members) {
				Map<String, Object> value = new LinkedHashMap<>();
				value.put("id", id);
				value.put("title", dropdownModel.getKey());
				tValue.add(value);
				id++;
			}
			List<GroupStructureLeftPanel> childList = new ArrayList<>();
			GroupStructureLeftPanel childGroup = new GroupStructureLeftPanel();
			childGroup.setId(2);
			childGroup.setTitle("Subgroups");

			Model.setId(0);
			Model.setGroup(title);
			groupModel.setNodes(tValue);
			groupList.add(groupModel);
			groupList.add(childGroup);
			childList.add(groupModel);
			childList.add(childGroup);
			Model.setNodes(childList);

			leftPanel1.add(Model);

			List<Integer> childId = orderFunctionalityService.getAllSubgroups(gcustomerId);

			System.out.println("list"+childId);

			for (Integer childIds : childId) {
				
				GroupMainModel Model1 = new GroupMainModel();
				System.out.println("first loop===="+childIds);
				String childtitle = orderFunctionalityService.getGroupGroupDescription(childIds);
				List<GroupStructureLeftPanel> groupList1 = new ArrayList<>();
				GroupStructureLeftPanel groupModel1 = new GroupStructureLeftPanel();
				groupModel1.setId(1);
				groupModel1.setTitle("Members");

				List<DropdownModel> members1 = orderFunctionalityService.getGroupMemberNames(childIds);
				List<Map<String, Object>> tValue2 = new ArrayList<>();

				int id1= 1;
				for (DropdownModel dropdownModel : members1) {
					Map<String, Object> value = new LinkedHashMap<>();
					value.put("id", id);
					value.put("title", dropdownModel.getKey());
					tValue2.add(value);
					id1++;
				}
				List<GroupStructureLeftPanel> childList1 = new ArrayList<>();
				GroupStructureLeftPanel childGroup1 = new GroupStructureLeftPanel();
				childGroup1.setId(2);
				childGroup1.setTitle("Subgroups");

				Model1.setId(0);
				Model1.setGroup(childtitle);
				groupModel1.setNodes(tValue2);
				groupList1.add(groupModel1);
				groupList1.add(childGroup1);
				childList1.add(groupModel1);
				childList1.add(childGroup1);
				Model1.setNodes(childList1);
				leftPanel1.add(Model1);
				
			}

			responseObject.put("StructuresData", leftPanel1);

			responseObject.put(STATUS, SUCCESS);
		
			return responseObject;
		}
		 catch (Exception e) {
			LOGGER.info("Error in getSubgroupsDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
		}
		return responseObject;
	}

	
	@RequestMapping(path = "/saveSubgroupStructure", method = RequestMethod.POST)
	public Map<String, Object> saveSubgroupStructure(@RequestParam int pCustomerId, @RequestParam int cCustomerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {

			status = orderFunctionalityService.saveSubgroupStructure(pCustomerId, cCustomerId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, "duplicate entry ");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveSubgroupStructure() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/deleteStructures", method = RequestMethod.POST)
	public Map<String, Object> deleteStructures(int customerId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderFunctionalityService.deleteStructures(customerId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteStructures : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/demoDetails", method = RequestMethod.POST)
	public Map<String, Object> getDemoDetails(int customerId,int ocId,int demQuesId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> demoDetails= new ArrayList<>();
		try {
		
			//List<DropdownModel> orderClassDetails = orderFunctionalityService.orderClassDetails();
			//responseObject.put("orderClassDetails",orderClassDetails);
			List<DropdownModel> DemographicForm = orderFunctionalityService.getDemographicForm1(ocId);
			responseObject.put("DemographicFormDetails",DemographicForm);
			demoDetails = orderFunctionalityService.getDemoDetails(customerId);
		    responseObject.put("demoDetails",demoDetails);
		    
		    List<DropdownModel> DemResponse = orderFunctionalityService.getDemResponse(demQuesId);
			responseObject.put("DemographicResponse",DemResponse);
		   
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDemoDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addDemoDetails", method = RequestMethod.POST)
	public Map<String, Object>  addDemoDetails() {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
		
			List<DropdownModel> orderClassDetails = orderFunctionalityService.orderClassDetails();
			responseObject.put("orderClassDetails",orderClassDetails);
			
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in addDemoDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addDemResponseDetails", method = RequestMethod.POST)
	public Map<String, Object>  addDemResponseDetails(int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> addDemResp= new ArrayList<>();

		try {
		
			 addDemResp=orderFunctionalityService.addDemResponse(ocId);
			 responseObject.put("DemResponse", addDemResp);
			
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in addDemoDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/saveDemoDetails", method = RequestMethod.POST)
	public Map<String, Object> saveDemoDetails(DemographicsModel  demographicsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status= 0;
		try {

			status = orderFunctionalityService.saveDemoDetails(demographicsModel);
			if (status!=0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDemoDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/updateDemoDetails", method = RequestMethod.POST)

   public Map<String, Object> updateDemoDetails(DemographicsModel  demographicsModel) {
		
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = orderFunctionalityService.updateDemoDetails(demographicsModel);

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
	
	
	@RequestMapping(path = "/deleteDemoDetails", method = RequestMethod.POST)
	public Map<String, Object> deleteDemoDetails(DemographicsModel demographicsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status =  orderFunctionalityService.deleteDemoDetails(demographicsModel);
			if(status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteDemoDetails: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
		@RequestMapping(path = "/pagePanelDemographics", method = RequestMethod.POST)
		public Map<String, Object> getPagePanelDemographics() {
		   Map<String, Object> responseObject = new HashMap<>();
	         try {
					 PagePanelDemographicsModel Model = new PagePanelDemographicsModel();
					 //Model.setRootName();
					 
					 Model.setData(orderFunctionalityService.getDemographicChildList());
					 responseObject.put("PagePanelMenuData",Model);
					 responseObject.put(STATUS, SUCCESS);
					return responseObject;
				} catch (Exception e) {
					LOGGER.info("Error in getPagePanelDemographics(): " + e);
					responseObject.put(STATUS, ERROR + e);
					return responseObject;
				}
			}
		
	    @RequestMapping(value = "/getPagePanelDemoDetails", method = RequestMethod.POST)
		public Map<String, Object>   getPagePanelDemoDetails(int ocId) {
			Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			try {
				
				List<DemographicChildModel> getDemographicChildList =orderFunctionalityService.getDemographicChildList();
				responseObject.put("DemographicChildList ", getDemographicChildList);
				responseObject.put(STATUS, SUCCESS);
				return responseObject;

			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS, ERROR);
				return responseObject;
			}

		}
		
   @RequestMapping(path = "/grpMbrActOrdHandling", method = RequestMethod.POST)
	public Map<String, Object> getGrpMbrActOrdHandling(int customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> grpMbrActOrdHandling = new ArrayList<>();
		String group = "";
		try {
			int newMember = jdbcTemplate.queryForObject("select new_group_member_action from customer_group where customer_id="+customerId, Integer.class);
			List<String> groupOrder = jdbcTemplate.queryForList("select distinct group_order from order_item where order_status in (0,5,7,8,9,10,11,12,13) and group_order = 1 and customer_id="+customerId, String.class);
			grpMbrActOrdHandling = orderFunctionalityService.getGrpMbrActOrdHandling(customerId);
			if(groupOrder.size() != 0)
				group = groupOrder.get(0);
			if(newMember == 3 && group.equals("1")) {
				responseObject.put("grpMbrActOrdHandling", grpMbrActOrdHandling);
				responseObject.put(STATUS, SUCCESS);
			}else {
				grpMbrActOrdHandling.clear();
				responseObject.put("grpMbrActOrdHandling", grpMbrActOrdHandling);
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getGrpMbrActOrdHandling() :" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/saveGrpMbrOrdHandling", method = RequestMethod.POST)
	public Map<String, Object> saveGrpMbrOrdHandling(TransferOrderModel transferOrderModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			switch(transferOrderModel.getAction()) {
			case "1":
					responseObject.put(STATUS, true);
			case "2":
				status = orderFunctionalityService.saveGrpMbrOrdHandling(transferOrderModel);
				if (status != 0) {
					responseObject.put(STATUS, true);
				} else {
					responseObject.put(STATUS, false);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveGrpMbrOrdHandling() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	  @RequestMapping(path = "/groupOrder", method = RequestMethod.POST)
	   public Map<String,Object> getGroupOrder(int customerId) {
		   Map<String,Object> responseObject = new LinkedHashMap<>();
		   try {
			   List<Map<String, Object>>groupOrder = orderFunctionalityService.getGroupOrder(customerId);
			   if(!groupOrder.isEmpty() ) {
				   responseObject.put("groupOrder", "1");   
			   }else {
				   responseObject.put("groupOrder", "0");
			   }
			   return responseObject;
		   }catch(Exception e) {
			   LOGGER.info("error in getGroupOrder(): " + e);
				responseObject.put(STATUS, ERROR + e);
				return responseObject;
		   }
	  }
			
		   @RequestMapping(path = "/activeOrderClass", method = RequestMethod.POST)
		   public Map<String,Object> getActiveOC(int customerId, int ocId) {
			   Map<String,Object> responseObject = new LinkedHashMap<>();
			   try {
				   List<Map<String, Object>>activeOC = orderFunctionalityService.getActiveOC(customerId, ocId);
				   if(!activeOC.isEmpty() ) {
					   responseObject.put("activeOC", "1");   
				   }else {
					   responseObject.put("activeOC", "0");
				   }
				   return responseObject;
			   }catch(Exception e) {
				   LOGGER.info("error in getActiveOC(): " + e);
					responseObject.put(STATUS, ERROR + e);
					return responseObject;
			   }
				  
		}

		   @RequestMapping(path = "/addrStatus", method = RequestMethod.POST)
		   public Map<String,Object> getAddrStatus(int customerId) {
			   Map<String,Object> responseObject = new LinkedHashMap<>();
			   try {
				   List<Map<String, Object>> addressStatus = orderFunctionalityService.getAddrStatus(customerId);
				   
				   if(addressStatus.isEmpty()) {
					   responseObject.put("Status", "true");   
				   }else {
					   responseObject.put("Status", "false");   
				   }
				   
				   return responseObject;
			   }catch(Exception e) {
				   LOGGER.info("error in getAddrStatus(): " + e);
					responseObject.put(STATUS, ERROR + e);
					return responseObject;
			   }
		}
		
		   @RequestMapping(path = "/groupMemberDetail", method = RequestMethod.POST)
		   public Map<String,Object> getGroupMemberEnable(int customerId) {
			   Map<String,Object> responseObject = new LinkedHashMap<>();
			   try {
				   List<Map<String, Object>> grpMdrEnable = orderFunctionalityService.getGroupMemberEnable(customerId);
				   
				   if(grpMdrEnable.isEmpty()) {
					   responseObject.put("Status", "true");   
				   }else {
					   responseObject.put("Status", "false");   
				   }
				   
				   return responseObject;
			   }catch(Exception e) {
				   LOGGER.info("error in getGroupMemberEnable(): " + e);
					responseObject.put(STATUS, ERROR + e);
					return responseObject;
			   }
		}
		   
}


	

