package com.mps.think.setup.reports.service;

import java.util.List;
import java.util.Map;

public interface ReportsService {

	List<Map<String, Object>> getSubscriptionOcs();

	int deleteSubscriptionOc(int ocId);

	List<Map<String, Object>> getProductOcsInfo();

	int deleteProductOc(int ocId);

	List<Map<String, Object>> getRateDetails();

	int deleteRate(int rateClassId);

	List<Map<String, Object>> getDiscountInfo();

	int deleteDiscountRow(int discountClassId);

	List<Map<String, Object>> getSource();

	int deleteSourceRow(int sourceCodeId);

	List<Map<String, Object>> getOrderCode();

	int deleteOrderCode(int orderCodeId);

	List<Map<String, Object>> getTranslations();

	int deleteTranslations(int keyPart1);

}
