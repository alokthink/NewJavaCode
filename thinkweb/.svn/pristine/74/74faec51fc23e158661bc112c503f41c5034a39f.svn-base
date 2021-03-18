package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.model.ProposedAddsKillsModel;
import com.mps.think.util.PropertyUtilityClass;


public class ProposedAddsKillsMapper implements RowMapper<ProposedAddsKillsModel>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProposedAddsKillsMapper.class);
	
	@Override
	public ProposedAddsKillsModel mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		ProposedAddsKillsModel proposedAddsKillsModel=new ProposedAddsKillsModel();
		try
		{
			proposedAddsKillsModel.setAdd(rs.getInt("sub_add"));
			if(rs.getString("sub_add_reason")==null)
			{
				proposedAddsKillsModel.setAdd_reason(rs.getString("sub_add_reason"));
			}else
			{
				proposedAddsKillsModel.setAdd_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_add_reason")));
			}
			proposedAddsKillsModel.setKill(rs.getInt("sub_kill"));
			if(rs.getString("sub_kill_reason")==null)
			{
				proposedAddsKillsModel.setKill_reason(rs.getString("sub_kill_reason"));
			}else
			{
				proposedAddsKillsModel.setKill_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_kill_reason")));
			}
			proposedAddsKillsModel.setSubscriber_id(rs.getInt("subscrip_id"));
			if(rs.getString("sub_on_reason")==null)
			{
				proposedAddsKillsModel.setSub_on_reason(rs.getString("sub_on_reason"));
			}else
			{
				proposedAddsKillsModel.setSub_on_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_on_reason")));
			}
			if(rs.getString("sub_off")!=null)
			{
				if(rs.getString("sub_off").equals("0"))
				{
					proposedAddsKillsModel.setSub_off("False");
				}
				else if(rs.getString("sub_off").equals("1"))
				{
					proposedAddsKillsModel.setSub_off("True");
				}
			}
			if(rs.getString("sub_off_reason")==null)
			{
				proposedAddsKillsModel.setSub_off_reason(rs.getString("sub_off_reason"));
			}else
			{
				proposedAddsKillsModel.setSub_off_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_off_reason")));
			}
			proposedAddsKillsModel.setAdditions_deletions_seq(rs.getInt("additions_deletions_seq"));
			if(rs.getString("sub_start")!=null)
			{
				if(rs.getString("sub_start").equals("0"))
				{
					proposedAddsKillsModel.setSub_start("False");
				}
				else if(rs.getString("sub_start").equals("1"))
				{
					proposedAddsKillsModel.setSub_start("True");
				}
			}
			if(rs.getString("sub_start_reason")==null)
			{
				proposedAddsKillsModel.setSub_start_reason(rs.getString("sub_start_reason"));
			}else
			{
				proposedAddsKillsModel.setSub_start_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_start_reason")));
			}
			if(rs.getString("sub_stop_reason")==null)
			{
				proposedAddsKillsModel.setSub_stop_reason(rs.getString("sub_stop_reason"));
			}else
			{
				proposedAddsKillsModel.setSub_stop_reason(new PropertyUtilityClass().getConstantValue("reason_"+rs.getInt("sub_stop_reason")));
			}
			if(rs.getString("sub_stop")!=null)
			{
				if(rs.getString("sub_stop").equals("0"))
				{
					proposedAddsKillsModel.setSub_stop("False");
				}
				else if(rs.getString("sub_stop").equals("1"))
				{
					proposedAddsKillsModel.setSub_stop("True");
				}
			}
			if(rs.getString("sub_on")!=null)
			{
				if(rs.getString("sub_on").equals("0"))
				{
					proposedAddsKillsModel.setSub_on("False");
				}
				else if(rs.getString("sub_on").equals("1"))
				{
					proposedAddsKillsModel.setSub_on("True");
				}
			}
			proposedAddsKillsModel.setJob_id(rs.getString("job_id"));
		}
		catch(Exception e)
		{
			LOGGER.info("proposedAddsKillsModel : "+e);
			e.printStackTrace();
		}
		return proposedAddsKillsModel;
	}
}