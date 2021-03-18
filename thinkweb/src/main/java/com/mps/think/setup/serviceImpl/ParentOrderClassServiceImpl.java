package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.dao.ParentOrderDao;
import com.mps.think.setup.model.DiscountClassModel;
import com.mps.think.setup.model.OrderClassModel;
import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.model.ProfitCenterModel;
import com.mps.think.setup.model.RateCardModel;
import com.mps.think.setup.model.RateClassModel;
import com.mps.think.setup.service.ParentOrderService;
@Service("ParentOrderService")
public class ParentOrderClassServiceImpl implements ParentOrderService{
	@Autowired
	ParentOrderDao parentOrderDao;
	
@Override	

public int addSourceCode(ParentOrderClassModel parentOrderClassModel){
	return parentOrderDao.addSourceCode(parentOrderClassModel);
	}

@Override	
public int addOrderClass(OrderClassModel orderClassModel){
	return parentOrderDao.addOrderClass( orderClassModel);
	}

@Override	
public int addProfitCenter(ProfitCenterModel profitCenterModel){
	return parentOrderDao.addProfitCenter( profitCenterModel);
	}

@Override	
public int addRateClass(RateClassModel rateClassModel){
	return parentOrderDao.addRateClass(rateClassModel);
	}

@Override
public int updateRateClassRecords(RateClassModel rateClassModel){
	return parentOrderDao.updateRateClassRecords(rateClassModel);
}

@Override	
public int addRateCard(RateCardModel rateCardModel){
	return parentOrderDao.addRateCard(rateCardModel);
	}

@Override	
public int discountClassSave(DiscountClassModel discountClassModel){
	return parentOrderDao.discountClassSave(discountClassModel);
	}

@Override	
public int addOrderClassSave(OrderClassModel orderClassModel){
	return parentOrderDao.addOrderClassSave(orderClassModel);
	}

@Override
public int getDiscountId() {
	return parentOrderDao.getDiscountId();
}

@Override
public int getRateClassId() {
	return parentOrderDao.getRateClassId();
}

@Override
public Integer getDisc_class_effective_Seq() {
	return parentOrderDao.getDisc_class_effective_Seq();
}

@Override
public int getOcId() {
	return parentOrderDao.getOcId();
}

@Override
public int updateSourceCode(ParentOrderClassModel parentOrderClassModel) {
	return parentOrderDao.updateSourceCode(parentOrderClassModel);
}

@Override
public String deleteSourceCodeDetails(Integer sourceCodeId) {
	return parentOrderDao.deleteSourceCodeDetails(sourceCodeId);
}

@Override
public int getSourceCodeId() {
	return parentOrderDao.getSourceCodeId();
}

@Override
public int addState(String sourceCodeId,String flag, String stateParam) {
	return parentOrderDao.addState(sourceCodeId, flag ,stateParam);
}

@Override
public int addAttribute(String sourceCodeId, String flag, String attributeParam) {
	return parentOrderDao.addAttribute(sourceCodeId, flag, attributeParam);
}

@Override
public int deleteState(String sourceCodeId, String state) {
	return parentOrderDao.deleteState(sourceCodeId, state);
}

}
