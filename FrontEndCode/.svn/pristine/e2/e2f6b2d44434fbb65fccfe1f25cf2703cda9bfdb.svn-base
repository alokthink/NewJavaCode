package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.model.ReviewAddsKillsModel;
import com.mps.think.util.PropertyUtilityClass;


public class ReviewAddsKillsMapper implements RowMapper<ReviewAddsKillsModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewAddsKillsMapper.class);
	
	@Override
	public ReviewAddsKillsModel mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		ReviewAddsKillsModel reviewAddsKillsModel=new ReviewAddsKillsModel();
		try
		{
			reviewAddsKillsModel.setIssue(rs.getInt("issue_id"));
			reviewAddsKillsModel.setAdd(rs.getInt("sub_add"));
			reviewAddsKillsModel.setAdd_copies(rs.getInt("n_addition_copies"));
			if(rs.getString("sub_add_reason")==null)
			{
				reviewAddsKillsModel.setAdd_reason(rs.getString("sub_add_reason"));
			}else
			{
				reviewAddsKillsModel.setAdd_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_add_reason")));
			}
			reviewAddsKillsModel.setKill(rs.getInt("sub_kill"));
			reviewAddsKillsModel.setKill_copies(rs.getInt("n_deletion_copies"));
			if(rs.getString("sub_kill_reason")==null)
			{
				reviewAddsKillsModel.setKill_reason(rs.getString("sub_kill_reason"));
			}else
			{
				reviewAddsKillsModel.setKill_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_kill_reason")));
			}
			reviewAddsKillsModel.setAdditions_deletions_seq(rs.getInt("additions_deletions_seq"));
			reviewAddsKillsModel.setBundle_qty(rs.getInt("bundle_qty"));
			if(rs.getString("sub_start_reason")==null)
			{
				reviewAddsKillsModel.setSub_start_reason(rs.getString("sub_start_reason"));
			}else
			{
				reviewAddsKillsModel.setSub_start_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_start_reason")));
			}
			reviewAddsKillsModel.setSubscriber_id(rs.getInt("subscrip_id"));
			reviewAddsKillsModel.setOrder_item_seq(rs.getInt("order_item_seq"));
			if(rs.getString("sub_on_reason")==null)
			{
				reviewAddsKillsModel.setSub_on_reason(rs.getString("sub_on_reason"));
			}else
			{
				reviewAddsKillsModel.setSub_on_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_on_reason")));
			}
			reviewAddsKillsModel.setNew_audit_qual_category(rs.getString("new_audit_qual_category"));
			if(rs.getString("sub_off")!=null)
			{
				if(rs.getString("sub_off").equals("0"))
				{
					reviewAddsKillsModel.setSub_off("False");
				}
				else if(rs.getString("sub_off").equals("1"))
				{
					reviewAddsKillsModel.setSub_off("True");
				}
			}
			//FIXED THINKDEV-561 BY SOHRAB
			String creation_date=rs.getString("creation_date");
			DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			DateFormat outputFormat=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
			String creationDateInDesiredFormat = PropertyUtilityClass.getDateInDesiredFormat(creation_date, inputFormat, outputFormat);
			reviewAddsKillsModel.setCreation_date(creationDateInDesiredFormat);
			if(rs.getString("sub_off_reason")==null)
			{
				reviewAddsKillsModel.setSub_off_reason(rs.getString("sub_off_reason"));
			}else
			{
				reviewAddsKillsModel.setSub_off_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_off_reason")));
			}
			reviewAddsKillsModel.setOrderhdr_id(rs.getInt("orderhdr_id"));
			if(rs.getString("sub_start")!=null)
			{
				if(rs.getString("sub_start").equals("0"))
				{
					reviewAddsKillsModel.setSub_start("False");
				}
				else if(rs.getString("sub_start").equals("1"))
				{
					reviewAddsKillsModel.setSub_start("True");
				}
			}
			if(rs.getInt("add_kill_status")==0)
			{
				reviewAddsKillsModel.setAdd_kill_status(new PropertyUtilityClass().getConstantValue("add_kill_status_"+rs.getInt("add_kill_status")));
			}
			else if(rs.getInt("add_kill_status")==1)
			{
				reviewAddsKillsModel.setAdd_kill_status(new PropertyUtilityClass().getConstantValue("add_kill_status_"+rs.getInt("add_kill_status")));
			}
			reviewAddsKillsModel.setOld_audit_qual_category(rs.getString("old_audit_qual_category"));
			if(rs.getString("sub_stop_reason")==null)
			{
				reviewAddsKillsModel.setSub_stop_reason(rs.getString("sub_stop_reason"));
			}else
			{
				reviewAddsKillsModel.setSub_stop_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_stop_reason")));
			}
			reviewAddsKillsModel.setJob_id(rs.getString("job_id"));
			if(rs.getString("sub_stop")!=null)
			{
				if(rs.getString("sub_stop").equals("0"))
				{
					reviewAddsKillsModel.setSub_stop("False");
				}
				else if(rs.getString("sub_stop").equals("1"))
				{
					reviewAddsKillsModel.setSub_stop("True");
				}
			}
			if(rs.getString("sub_on")!=null)
			{
				if(rs.getString("sub_on").equals("0"))
				{
					reviewAddsKillsModel.setSub_on("False");
				}
				else if(rs.getString("sub_on").equals("1"))
				{
					reviewAddsKillsModel.setSub_on("True");
				}
			}
		}
		catch(Exception e)
		{
			LOGGER.info("reviewAddsKillsModel : "+e);
			e.printStackTrace();
		}
		return reviewAddsKillsModel;
	}
}
