package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.model.ReviewOnsOffsModel;
import com.mps.think.util.PropertyUtilityClass;


public class ReviewOnsOffsMapper implements RowMapper<ReviewOnsOffsModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewOnsOffsMapper.class);
	
	@Override
	public ReviewOnsOffsModel mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		ReviewOnsOffsModel reviewOnsOffsModel=new ReviewOnsOffsModel();
		try
		{
			reviewOnsOffsModel.setIssue(rs.getInt("issue_id"));
			reviewOnsOffsModel.setOn(rs.getInt("sub_on"));
			reviewOnsOffsModel.setOn_copies(rs.getInt("n_addition_copies"));
			if(rs.getString("sub_on_reason")==null)
			{
				reviewOnsOffsModel.setReason_for_on(rs.getString("sub_on_reason"));
			}else
			{
				reviewOnsOffsModel.setReason_for_on(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_on_reason")));
			}
			reviewOnsOffsModel.setOff(rs.getInt("sub_off"));
			reviewOnsOffsModel.setOff_copies(rs.getInt("n_deletion_copies"));
			if(rs.getString("sub_off_reason")==null)
			{
				reviewOnsOffsModel.setReason_for_off(rs.getString("sub_off_reason"));
			}else
			{
				reviewOnsOffsModel.setReason_for_off(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_off_reason")));
			}
			reviewOnsOffsModel.setOrder_item_seq(rs.getInt("order_item_seq"));
			if(rs.getString("sub_kill_reason")==null)
			{
				reviewOnsOffsModel.setSub_kill_reason(rs.getString("sub_kill_reason"));
			}else
			{
				reviewOnsOffsModel.setSub_kill_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_kill_reason")));
			}
			reviewOnsOffsModel.setAdditions_deletions_seq(rs.getInt("additions_deletions_seq"));
			reviewOnsOffsModel.setSubscriber_id(rs.getInt("subscrip_id"));
			reviewOnsOffsModel.setBundle_qty(rs.getInt("bundle_qty"));
			if(rs.getString("sub_start_reason")==null)
			{
				reviewOnsOffsModel.setSub_start_reason(rs.getString("sub_start_reason"));
			}else
			{
				reviewOnsOffsModel.setSub_start_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_start_reason")));
			}
			reviewOnsOffsModel.setNew_audit_qual_category(rs.getString("new_audit_qual_category"));
			reviewOnsOffsModel.setOrderhdr_id(rs.getInt("orderhdr_id"));
			//FIXED THINKDEV-565 BY SOHRAB 
			String creation_date=rs.getString("creation_date");
			DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			DateFormat outputFormat=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
			String creationDateInDesiredFormat = PropertyUtilityClass.getDateInDesiredFormat(creation_date, inputFormat, outputFormat);
			reviewOnsOffsModel.setCreation_date(creationDateInDesiredFormat);
			if(rs.getString("sub_add_reason")==null)
			{
				reviewOnsOffsModel.setSub_add_reason(rs.getString("sub_add_reason"));
			}else
			{
				reviewOnsOffsModel.setSub_add_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_add_reason")));
			}
			if(rs.getString("sub_kill")!=null)
			{
				if(rs.getString("sub_kill").equals("0"))
				{
					reviewOnsOffsModel.setSub_kill("False");
				}
				else if(rs.getString("sub_kill").equals("1"))
				{
					reviewOnsOffsModel.setSub_kill("True");
				}
			}
			if(rs.getString("sub_start")!=null)
			{
				if(rs.getString("sub_start").equals("0"))
				{
					reviewOnsOffsModel.setSub_start("False");
				}
				else if(rs.getString("sub_start").equals("1"))
				{
					reviewOnsOffsModel.setSub_start("True");
				}
			}
			if(rs.getString("sub_add")!=null)
			{
				if(rs.getString("sub_add").equals("0"))
				{
					reviewOnsOffsModel.setSub_add("False");
				}
				else if(rs.getString("sub_add").equals("1"))
				{
					reviewOnsOffsModel.setSub_add("True");
				}
			}
			if(rs.getString("add_kill_status")!=null)
			{
				if(rs.getInt("add_kill_status")==0)
				{
					reviewOnsOffsModel.setAdd_kill_status(new PropertyUtilityClass().getConstantValue("add_kill_status_"+rs.getInt("add_kill_status")));
				}
				else if(rs.getInt("add_kill_status")==1)
				{
					reviewOnsOffsModel.setAdd_kill_status(new PropertyUtilityClass().getConstantValue("add_kill_status_"+rs.getInt("add_kill_status")));
				}
			}
			if(rs.getString("sub_stop_reason")==null)
			{
				reviewOnsOffsModel.setSub_stop_reason(rs.getString("sub_stop_reason"));
			}else
			{
				reviewOnsOffsModel.setSub_stop_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_stop_reason")));
			}
			reviewOnsOffsModel.setJob_id(rs.getString("job_id"));
			if(rs.getString("sub_stop")!=null)
			{
				if(rs.getString("sub_stop").equals("0"))
				{
					reviewOnsOffsModel.setSub_stop("False");
				}
				else if(rs.getString("sub_stop").equals("1"))
				{
					reviewOnsOffsModel.setSub_stop("True");
				}
			}
			reviewOnsOffsModel.setOld_audit_qual_category(rs.getString("old_audit_qual_category"));
		}
		catch(Exception e)
		{
			LOGGER.info("reviewOnsOffsModel : "+e);
			e.printStackTrace();
		}
		return reviewOnsOffsModel;
	}
}
