package com.mps.think.setup.dao;


import com.mps.think.setup.model.DiscountClassModel;
import com.mps.think.setup.model.OrderClassModel;
import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.model.ProfitCenterModel;
import com.mps.think.setup.model.RateCardModel;
import com.mps.think.setup.model.RateClassModel;

public interface ParentOrderDao  {
	
	public int addSourceCode(ParentOrderClassModel parentOrderClassModel);
	
	public int addOrderClass(OrderClassModel orderClassModel);
	
    public int addProfitCenter(ProfitCenterModel profitCenterModel);
    
    public int addRateClass(RateClassModel rateClassModel);
    
    public int updateRateClassRecords(RateClassModel rateClassModel);
    
    public int addRateCard(RateCardModel rateCardModel);
    
    public int  discountClassSave(DiscountClassModel discountClassModel);
    
    public int  getDiscountId();
    
    public Integer getDisc_class_effective_Seq();
    
    public int  getRateClassId();
    
	public int addOrderClassSave(OrderClassModel orderClassModel);
	
	public int  getOcId();
	
	public int updateSourceCode(ParentOrderClassModel parentOrderClassModel);

	public String deleteSourceCodeDetails(Integer sourceCodeId);

	public int getSourceCodeId();

	public int addState(String sourceCodeId, String flag , String stateParam);

	public int addAttribute(String sourceCodeId, String flag, String attributeParam);

	public int deleteState(String sourceCodeId, String state);

}
