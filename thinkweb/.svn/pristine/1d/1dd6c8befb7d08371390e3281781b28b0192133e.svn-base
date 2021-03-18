package com.mps.think.setup.reports.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.reports.dao.ReportsDao;
import com.mps.think.setup.reports.service.ReportsService;

@Service("reportsService")
public class ReportsServiceImpl implements ReportsService{
	@Autowired
	ReportsDao reportsDao;

	@Override
	public List<Map<String, Object>> getSubscriptionOcs() {
		return reportsDao.getSubscriptionOcs();
	}

	@Override
	public int deleteSubscriptionOc(int ocId) {
		return reportsDao.deleteSubscriptionOc(ocId);
	}

	@Override
	public List<Map<String, Object>> getProductOcsInfo() {
		return reportsDao.getProductOcsInfo();
	}

	@Override
	public int deleteProductOc(int ocId) {
		return reportsDao.deleteProductOc(ocId);
	}

	@Override
	public List<Map<String, Object>> getRateDetails() {
		return reportsDao.getRateDetails();
	}

	@Override
	public int deleteRate(int rateClassId) {
		return reportsDao.deleteRate(rateClassId);
	}

	@Override
	public List<Map<String, Object>> getDiscountInfo() {
		return reportsDao.getDiscountInfo();
	}

	@Override
	public int deleteDiscountRow(int discountClassId) {
		return reportsDao.deleteDiscountRow(discountClassId);
	}

	@Override
	public List<Map<String, Object>> getSource() {
		return reportsDao.getSource();
	}

	@Override
	public int deleteSourceRow(int sourceCodeId) {
		return reportsDao.deleteSourceRow(sourceCodeId);
	}

	@Override
	public List<Map<String, Object>> getOrderCode() {
		return reportsDao.getOrderCode();
	}

	@Override
	public int deleteOrderCode(int orderCodeId) {
		return reportsDao.deleteOrderCode(orderCodeId);
	}

	@Override
	public List<Map<String, Object>> getTranslations() {
		return reportsDao.getTranslations();
	}

	@Override
	public int deleteTranslations(int keyPart1) {
		return reportsDao.deleteTranslations(keyPart1);
	}
	

}
