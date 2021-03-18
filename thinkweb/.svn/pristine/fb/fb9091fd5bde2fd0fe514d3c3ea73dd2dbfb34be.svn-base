package com.mps.think.setup.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.DropdownModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.setup.dao.OrderClassDetailsDao;
import com.mps.think.setup.model.AlternateContent;
import com.mps.think.setup.model.AuditTrackingModel;
import com.mps.think.setup.model.CalendarCampaignModel;
import com.mps.think.setup.model.DashboardLeftPanelModel;
import com.mps.think.setup.model.DemographicForms;
import com.mps.think.setup.model.DiscClassEffective;
import com.mps.think.setup.model.DiscountCard;
import com.mps.think.setup.model.DiscountClassModel;
import com.mps.think.setup.model.Issue;
import com.mps.think.setup.model.OrderClassModel;
import com.mps.think.setup.model.OrderCodeModel;
import com.mps.think.setup.model.PackageContentModel;
import com.mps.think.setup.model.PackageDefinationModel;
import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.model.ProductModel;
import com.mps.think.setup.model.PromotionCard;
import com.mps.think.setup.model.PromotionCardEffort;
import com.mps.think.setup.model.PromotionCardOffer;
import com.mps.think.setup.model.Pub;
import com.mps.think.setup.model.PubRotation;
import com.mps.think.setup.model.QuickOrderCodeModel;
import com.mps.think.setup.model.RateClassModel;
import com.mps.think.setup.model.RenewalCard;
import com.mps.think.setup.model.SubscriptionDef;
import com.mps.think.setup.model.SubscriptionStart;
import com.mps.think.setup.model.UpSellModel;
import com.mps.think.setup.model.VolumeGroup;
import com.mps.think.setup.resultMapper.CalendarCompaignMapper;
import com.mps.think.setup.resultMapper.OrderCodeMapper;
import com.mps.think.setup.resultMapper.PubRotationMapper;
import com.mps.think.setup.resultMapper.SourceCodeMapper;
import com.mps.think.setup.resultMapper.SubscriptionDefMapper;
import com.mps.think.setup.resultMapper.UpsellMapper;
import com.mps.think.setup.resultMapper.pubMapper;
import com.mps.think.setup.util.PropertyUtils;

@Repository
public class OrderClassDaoImpl implements OrderClassDetailsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Map<String, Object>> getOrderClassID1(String OcId) {
		List<Map<String, Object>> OcName = new ArrayList<>();
		try {
			if ("".equals(OcId) | "null".equals(OcId) | "undefined".equals(OcId)) {
				Long OrderClassId = jdbcTemplate.queryForObject("select max(oc_id) from oc", Long.class);
				// OcName = jdbcTemplate.queryForList("select
				// oc_id,oc,description,parent_oc_id,oc_type from oc where oc_id ="+
				// OrderClassId);
				OcName = jdbcTemplate.queryForList("select * from oc where oc_id =" + OrderClassId);
			} else {
				// OcName = jdbcTemplate.queryForList("select
				// oc_id,oc,description,parent_oc_id,oc_type from oc where oc_id ="+ OcId );
				OcName = jdbcTemplate.queryForList("select * from oc where oc_id =" + OcId);
			}

			for (Map<String, Object> ocName : OcName) {
				if (ocName.get("description") == null) {
					ocName.put("description", "");
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return OcName;
	}

	@Override
	public List<DropdownModel> getDefaultSourceCode(String ocId) {
		List<Map<String, Object>> SourceCode = new ArrayList<>();
		List<DropdownModel> sourceCodeList = new ArrayList<>();
		try {
			SourceCode = jdbcTemplate.queryForList(
					"select source_code_id,source_code,description from source_code where oc_id =" + ocId);
			for (Map<String, Object> sourceCode : SourceCode) {
				DropdownModel model = new DropdownModel();
				model.setKey(sourceCode.get("source_code_id").toString());
				model.setDisplay(sourceCode.get("source_code").toString() + ":"
						+ (sourceCode.get("description") != null ? (String) sourceCode.get("description") : ""));
				sourceCodeList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeList;
	}

	@Override
	public List<DropdownModel> getSourceCodeFormat() {
		List<Map<String, Object>> SourceCodeFormat = new ArrayList<>();
		List<DropdownModel> SourceCodeFormatList = new ArrayList<>();
		try {
			SourceCodeFormat = jdbcTemplate.queryForList("select source_format,description from source_format");
			for (Map<String, Object> sourceCodeFormat : SourceCodeFormat) {
				DropdownModel model = new DropdownModel();
				model.setKey(sourceCodeFormat.get("source_format").toString());
				model.setDisplay(
						sourceCodeFormat.get("description") != null ? sourceCodeFormat.get("description").toString()
								: "");
				SourceCodeFormatList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return SourceCodeFormatList;

	}

	@Override
	public List<DropdownModel> getPaymentThresholdData() {
		List<Map<String, Object>> paymentThresholdData = new ArrayList<>();
		List<DropdownModel> paymentThresholdDataList = new ArrayList<>();
		try {
			paymentThresholdData = jdbcTemplate
					.queryForList("select payment_threshold,description from payment_threshold");
			for (Map<String, Object> PaymentThresholdData : paymentThresholdData) {
				DropdownModel model = new DropdownModel();
				model.setKey(PaymentThresholdData.get("payment_threshold").toString());
				model.setDisplay(PaymentThresholdData.get("description") != null
						? PaymentThresholdData.get("description").toString()
						: "");
				paymentThresholdDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return paymentThresholdDataList;
	}

	@Override
	public List<DropdownModel> getProfitCenter() {
		List<Map<String, Object>> profitCenter = new ArrayList<>();
		List<DropdownModel> profitCenterList = new ArrayList<>();
		try {
			profitCenter = jdbcTemplate.queryForList("select profit_center,description from profit_center");
			profitCenter.forEach(profit -> {
				DropdownModel model = new DropdownModel();
				model.setKey(profit.get("profit_center").toString());
				model.setDisplay(profit.get("description") != null ? profit.get("description").toString() : "");
				profitCenterList.add(model);
			});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return profitCenterList;
	}

	@Override
	public List<DropdownModel> getLabelOutputData() {
		List<Map<String, Object>> LableOutputData = new ArrayList<>();
		List<DropdownModel> lableOutputDataList = new ArrayList<>();
		try {
			LableOutputData = jdbcTemplate.queryForList("select report,description from report");
			for (Map<String, Object> lableOutputData : LableOutputData) {

				DropdownModel model = new DropdownModel();
				model.setKey(lableOutputData.get("report").toString());
				model.setDisplay(
						lableOutputData.get("description") != null ? (String) lableOutputData.get("description") : "");
				lableOutputDataList.add(model);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return lableOutputDataList;
	}

	@Override
	public List<Map<String, Object>> getTopicTableData(Long showId) {
		List<Map<String, Object>> TopicData = new ArrayList<>();
		try {
			if (showId == 1) {
				TopicData = jdbcTemplate.queryForList(
						"select distinct topic.topic,topic.description,(case when oc_topic.topic=topic.topic then 1 else 0 end)"
								+ " as active from topic left join oc_topic on oc_topic.topic=topic.topic");
			} else {

				TopicData = new ArrayList<>();
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return TopicData;
	}

	@Override
	public List<Map<String, Object>> getDropDownDefaultData(String ocId) {
		List<Map<String, Object>> defaultDropDownValues = new ArrayList<>();
		try {
			defaultDropDownValues = jdbcTemplate.queryForList(
					"select report,renewal_source_format,promotion_source_format,upsell_on,payment_threshold,source_format from oc where oc_id="
							+ ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultDropDownValues;
	}

	@Override
	public List<DropdownModel> getNewGroupMemberActionList() {
		List<DropdownModel> newGroupMemberActionList = new ArrayList<>();
		try {
			for (int i = 0; i <= 5; i++) {
				if (i == 1)
					continue;
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("new_group_member_action_" + i));
				newGroupMemberActionList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return newGroupMemberActionList;
	}

	@Override
	public List<DropdownModel> getInventoryList(String ocId) {
		List<Map<String, Object>> inventoryTableData = new ArrayList<>();
		List<DropdownModel> inventoryList = new ArrayList<>();
		try {
			inventoryTableData = jdbcTemplate.queryForList(
					"select low_stock,low_sample_stock,sample_issue_selection from oc where oc_id=" + ocId);
			for (Map<String, Object> inventry : inventoryTableData) {
				DropdownModel model = new DropdownModel();
				/*
				 * model.setKey("low_stock-"+inventry.get("low_stock").toString());
				 * model.setDisplay("low_sample_stock-"+inventry.get("low_sample_stock").
				 * toString()); model.setDescription("sample_issue_selection-"+new
				 * PropertyUtils().getConstantValue("sample_issue_selection_"+inventry.get(
				 * "sample_issue_selection")));
				 * model.setExtra("sample_issue_selection-"+inventry.get(
				 * "sample_issue_selection").toString());
				 */
				model.setKey(inventry.get("low_stock").toString());
				model.setDisplay(inventry.get("low_sample_stock").toString());
				model.setDescription(new PropertyUtils()
						.getConstantValue("sample_issue_selection_" + inventry.get("sample_issue_selection")));
				model.setExtra(inventry.get("sample_issue_selection").toString());
				inventoryList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return inventoryList;
	}

	@Override
	public List<Map<String, Object>> getVGTargetSalesLevels(Long ocId) {
		List<Map<String, Object>> volumeGroupsTargetSalesLevels = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append(
				"select distinct oc.oc,volume_group.volume,volume_group_regions.region_list,journal_volume_group.sales_target,journal_volume_group.oc_id,journal_volume_group.volume_group_id from journal_volume_group ");
		query.append("inner join oc on oc.oc_id=journal_volume_group.oc_id ");
		query.append("inner join volume_group on volume_group.volume_group_id=journal_volume_group.volume_group_id ");
		query.append(
				"inner join volume_group_regions on volume_group_regions.oc_id=journal_volume_group.oc_id where journal_volume_group.oc_id="
						+ ocId);
		try {
			volumeGroupsTargetSalesLevels = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return volumeGroupsTargetSalesLevels;
	}

	@Override
	public List<Map<String, Object>> getTargetSalesLevels(Long ocId, Long volumeGroupId) {
		List<Map<String, Object>> targetSalesLevels = new ArrayList<>();
		try {
			targetSalesLevels = jdbcTemplate.queryForList(
					"select oc_id,volume_group_id,region,sales_target from volume_group_regions where oc_id=" + ocId
							+ " and volume_group_regions.volume_group_id=" + volumeGroupId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return targetSalesLevels;
	}

	@Override
	public List<DropdownModel> getVolumeGroupList() {
		List<Map<String, Object>> volumeGroupData = new ArrayList<>();
		List<DropdownModel> volumeGroupList = new ArrayList<>();
		try {
			volumeGroupData = jdbcTemplate.queryForList("select volume_group_id,volume from volume_group");
			for (Map<String, Object> volume : volumeGroupData) {
				DropdownModel model = new DropdownModel();
				model.setKey(volume.get("volume_group_id").toString());
				model.setDisplay(volume.get("volume").toString());
				volumeGroupList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return volumeGroupList;
	}

	@Override
	public List<DropdownModel> getSubscriptionCategory() {
		List<Map<String, Object>> subscriptionCategoryData = new ArrayList<>();
		List<DropdownModel> subscriptionCategory = new ArrayList<>();
		try {
			subscriptionCategoryData = jdbcTemplate
					.queryForList("select subscription_category_id,description from subscription_category");
			for (Map<String, Object> volume : subscriptionCategoryData) {
				DropdownModel model = new DropdownModel();
				model.setKey(volume.get("subscription_category_id").toString());
				model.setDisplay(volume.get("description").toString());
				subscriptionCategory.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptionCategory;
	}

	@Override
	public String saveTargetSalesLevels(VolumeGroup volumeGroup) {
		Map<String, Object> addSourceParams = new HashMap<>();
		StringBuilder status = new StringBuilder();
		try {
			// insert into journal_volume_group table
			if (volumeGroup.getRegionList() != null && volumeGroup.getRegion() == null) {
				// duplicate volume group id is not allowed in journal_volume_group table
				int isDuplicateVolumeId = jdbcTemplate.queryForObject(
						"select count(volume_group_id) from journal_volume_group where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId(),
						Integer.class);
				if (isDuplicateVolumeId == 0) {
					String saveQuery = "insert into journal_volume_group(volume_group_id,oc_id,region_list,sales_target) values(:volume_group_id,:oc_id,:region_list,:sales_target)";
					addSourceParams.put("volume_group_id", volumeGroup.getVolumeGroupId());
					addSourceParams.put("oc_id", volumeGroup.getOcId());
					addSourceParams.put("region_list", volumeGroup.getRegionList());
					addSourceParams.put("sales_target",
							volumeGroup.getSalesTarget() != null ? volumeGroup.getSalesTarget() : null);
					namedParameterJdbcTemplate.update(saveQuery, addSourceParams);
					status.append("TargetSalesSave");
				} else {
					status.append("The duplicate key value is (" + volumeGroup.getVolumeGroupId() + ","
							+ volumeGroup.getOcId() + ")");

				}
				// insert into volume_group_regions table
			} else if (volumeGroup.getRegionList() != null
					&& (volumeGroup.getRegion() != null && volumeGroup.getSubscriptionCategoryId() == 0)) {
				// duplicate volume group id is not allowed in journal_volume_group table
				int isDuplicateVolumeIdInJVG = jdbcTemplate.queryForObject(
						"select count(*) from journal_volume_group where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId(),
						Integer.class);
				int isDuplicateVolumeIdInJVR = jdbcTemplate.queryForObject(
						"select count(*) from volume_group_regions where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId(),
						Integer.class);
				if (isDuplicateVolumeIdInJVG != 0 && isDuplicateVolumeIdInJVR == 0) {
					String saveQuery = "insert into volume_group_regions(volume_group_id,oc_id,region_list,region,sales_target) values(:volume_group_id,:oc_id,:region_list,:region,:sales_target)";
					addSourceParams.put("volume_group_id", volumeGroup.getVolumeGroupId());
					addSourceParams.put("oc_id", volumeGroup.getOcId());
					addSourceParams.put("region_list", volumeGroup.getRegionList());
					addSourceParams.put("region", volumeGroup.getRegion());
					addSourceParams.put("sales_target",
							volumeGroup.getSalesTarget() != null ? volumeGroup.getSalesTarget() : null);
					namedParameterJdbcTemplate.update(saveQuery, addSourceParams);
					status.append("TargetSalesSave");
				} else {
					status.append("The duplicate key value is (" + volumeGroup.getVolumeGroupId() + ","
							+ volumeGroup.getOcId() + "," + volumeGroup.getRegionList() + "," + volumeGroup.getRegion()
							+ ")");

				}
			} else { // insert into vol_grp_regions_category table
				// duplicate record is not allowed in vol_grp_regions_category table
				int isAvailableRecordInVGR = jdbcTemplate
						.queryForObject("select count(*) from  volume_group_regions t1 where  t1.volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and   t1.oc_id = " + volumeGroup.getOcId()
								+ " and   t1.region_list = '" + volumeGroup.getRegionList() + "' and   t1.region = '"
								+ volumeGroup.getRegion() + "'", Integer.class);
				// !0 means record is available in volume_group_regions table
				// --if count != 0 then next query will fire.
				int isNotAvailableRecordInVGRC = jdbcTemplate
						.queryForObject("select count(*) from  vol_grp_regions_category t1 where  t1.volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and   t1.oc_id = " + volumeGroup.getOcId()
								+ " and   t1.region_list = '" + volumeGroup.getRegionList() + "' and   t1.region = '"
								+ volumeGroup.getRegion() + "'", Integer.class);
				// 0 means record is not available in vol_grp_regions_category table
				// if count == 0 then insert query will fire.
				if (isAvailableRecordInVGR != 0 && isNotAvailableRecordInVGRC == 0) {
					String saveQuery = "insert into vol_grp_regions_category(volume_group_id,oc_id,region_list,region,subscription_category_id,sales_target) values(:volume_group_id,:oc_id,:region_list,:region,:subscription_category_id,:sales_target)";
					addSourceParams.put("volume_group_id", volumeGroup.getVolumeGroupId());
					addSourceParams.put("oc_id", volumeGroup.getOcId());
					addSourceParams.put("region_list", volumeGroup.getRegionList());
					addSourceParams.put("region", volumeGroup.getRegion());
					addSourceParams.put("subscription_category_id", volumeGroup.getSubscriptionCategoryId());
					addSourceParams.put("sales_target",
							volumeGroup.getSalesTarget() != null ? volumeGroup.getSalesTarget() : null);
					namedParameterJdbcTemplate.update(saveQuery, addSourceParams);
					status.append("TargetSalesSave");
				} else {
					status.append("The value (" + volumeGroup.getVolumeGroupId() + "," + volumeGroup.getOcId() + ","
							+ volumeGroup.getRegionList() + "," + volumeGroup.getRegion() + ","
							+ volumeGroup.getSubscriptionCategoryId() + ") is not in 'volume_group_regions' table");

				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status.toString();
	}

	@Override
	public String updateTargetSalesLevels(VolumeGroup volumeGroup) {
		StringBuilder status = new StringBuilder();
		try {
			// update into journal_volume_group table
			if ((volumeGroup.getVolumeGroupId() != null && volumeGroup.getOcId() != null)
					&& "".equals(volumeGroup.getRegion())) {
				int isNotAvailableRecordInJVG = jdbcTemplate
						.queryForObject("select count(*) from journal_volume_group where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId()
								+ " and region_list='" + volumeGroup.getRegionList() + "'", Integer.class);
				int isNotAvailableRecordInVGR = jdbcTemplate
						.queryForObject("select count(*) from volume_group_regions where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId()
								+ " and region_list='" + volumeGroup.getRegionList() + "'", Integer.class);
				if (isNotAvailableRecordInJVG == 0 && isNotAvailableRecordInVGR == 0) {
					String saveQuery = "update journal_volume_group set volume_group_id="
							+ volumeGroup.getVolumeGroupId2() + ",region_list='" + volumeGroup.getRegionList()
							+ "', sales_target=" + volumeGroup.getSalesTarget() + " where volume_group_id="
							+ volumeGroup.getVolumeGroupId() + " and oc_id=" + volumeGroup.getOcId()
							+ " and region_list='" + volumeGroup.getRegionList() + "'";
					jdbcTemplate.update(saveQuery);
					status.append("TargetSalesUpdated");
				} else if (volumeGroup.getSalesTarget() != null) {
					String saveQuery = "update journal_volume_group set sales_target=" + volumeGroup.getSalesTarget()
							+ " where volume_group_id=" + volumeGroup.getVolumeGroupId() + " and oc_id="
							+ volumeGroup.getOcId() + " and region_list='" + volumeGroup.getRegionList() + "'";
					jdbcTemplate.update(saveQuery);
					status.append("TargetSalesUpdated");
				} else {
					status.append(
							"The duplicate key value is(" + volumeGroup.getVolumeGroupId() + "," + volumeGroup.getOcId()
									+ "," + volumeGroup.getRegionList() + ") in 'journal_volume_group' table");

				}
				// update into volume_group_regions table
			} else if (volumeGroup.getRegionList() != null
					&& (volumeGroup.getRegion() != null && volumeGroup.getSubscriptionCategoryId() == null)) {
				// duplicate volume group id is not allowed in journal_volume_group table
				// int isAvailableRecordInJVG = jdbcTemplate.queryForObject("select count(*)
				// from journal_volume_group where volume_group_id =
				// "+volumeGroup.getVolumeGroupId()+" and oc_id = "+volumeGroup.getOcId()+" and
				// region_list='"+volumeGroup.getRegionList()+"'",Integer.class);
				// int isNotAvailableRecordInVGR = jdbcTemplate.queryForObject("select count(*)
				// from volume_group_regions where volume_group_id =
				// "+volumeGroup.getVolumeGroupId()+" and oc_id = "+volumeGroup.getOcId()+" and
				// region_list='"+volumeGroup.getRegionList()+"' and
				// region='"+volumeGroup.getRegionList()+"'",Integer.class);
				int isNotAvailableRecordInVGR = jdbcTemplate
						.queryForObject("select count(*) from volume_group_regions where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId()
								+ " and region_list='" + volumeGroup.getRegionList() + "' and region='"
								+ volumeGroup.getRegionList() + "'", Integer.class);
				int isNotAvailableRecordInVGRC = jdbcTemplate
						.queryForObject("select count(*) from vol_grp_regions_category where volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and oc_id = " + volumeGroup.getOcId()
								+ " and region_list='" + volumeGroup.getRegionList() + "'", Integer.class);
				if (isNotAvailableRecordInVGR == 0 && isNotAvailableRecordInVGRC == 0) {
					String saveQuery = "update volume_group_regions set region='" + volumeGroup.getRegion2()
							+ "', sales_target=" + volumeGroup.getSalesTarget() + " where volume_group_id="
							+ volumeGroup.getVolumeGroupId() + " and oc_id=" + volumeGroup.getOcId()
							+ " and region_list='" + volumeGroup.getRegionList() + "'" + " and region='"
							+ volumeGroup.getRegionList() + "'";
					jdbcTemplate.update(saveQuery);
					status.append("TargetSalesUpdated");
				} else if (volumeGroup.getSalesTarget() != null) {
					String saveQuery = "update volume_group_regions set sales_target=" + volumeGroup.getSalesTarget()
							+ " where volume_group_id=" + volumeGroup.getVolumeGroupId() + " and oc_id="
							+ volumeGroup.getOcId() + " and region_list='" + volumeGroup.getRegionList() + "'"
							+ " and region='" + volumeGroup.getRegionList() + "'";
					jdbcTemplate.update(saveQuery);
					status.append("TargetSalesUpdated");

				} else {
					status.append("The duplicate key value is (" + volumeGroup.getVolumeGroupId() + ","
							+ volumeGroup.getOcId() + "," + volumeGroup.getRegionList()
							+ ")in 'volume_group_regions' table");

				}
			} else { // update into vol_grp_regions_category table
				// update vol_grp_regions_category set
				// subscription_category_id=3,sales_target=250 where volume_group_id=1 and
				// oc_id=35 and region_list='Audit' and region='Pacific' and
				// subscription_category_id=1 ;
				// duplicate record is not allowed in vol_grp_regions_category table
				int isAvailableRecordInVGR = jdbcTemplate
						.queryForObject("select count(*) from  volume_group_regions t1 where  t1.volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and   t1.oc_id = " + volumeGroup.getOcId()
								+ " and   t1.region_list = '" + volumeGroup.getRegionList() + "' and   t1.region = '"
								+ volumeGroup.getRegion() + "'", Integer.class);
				// !0 means record is available in volume_group_regions table
				// --if count != 0 then next query will fire.
				int isNotAvailableRecordInVGRC = jdbcTemplate
						.queryForObject("select count(*) from  vol_grp_regions_category t1 where  t1.volume_group_id = "
								+ volumeGroup.getVolumeGroupId() + " and   t1.oc_id = " + volumeGroup.getOcId()
								+ " and   t1.region_list = '" + volumeGroup.getRegionList() + "' and   t1.region = '"
								+ volumeGroup.getRegion() + "'", Integer.class);
				// !0 means record is available in vol_grp_regions_category table
				// if count == 0 then insert query will fire.
				if (isAvailableRecordInVGR != 0 && isNotAvailableRecordInVGRC != 0) {
					String saveQuery = "update vol_grp_regions_category set subscription_category_id="
							+ volumeGroup.getSubscriptionCategoryId2() + ", sales_target="
							+ volumeGroup.getSalesTarget() + " where volume_group_id=" + volumeGroup.getVolumeGroupId()
							+ " and oc_id=" + volumeGroup.getOcId() + " and region_list='" + volumeGroup.getRegionList()
							+ "' and region='" + volumeGroup.getRegion() + "' and subscription_category_id="
							+ volumeGroup.getSubscriptionCategoryId();
					jdbcTemplate.update(saveQuery);
					status.append("TargetSalesUpdated");
				} else if (volumeGroup.getSalesTarget() != null) {
					String saveQuery = "update vol_grp_regions_category set sales_target="
							+ volumeGroup.getSalesTarget() + " where volume_group_id=" + volumeGroup.getVolumeGroupId()
							+ " and oc_id=" + volumeGroup.getOcId() + " and region_list='" + volumeGroup.getRegionList()
							+ "' and region='" + volumeGroup.getRegion() + "' and subscription_category_id="
							+ volumeGroup.getSubscriptionCategoryId();
					jdbcTemplate.update(saveQuery);
					status.append("TargetSalesUpdated");
				} else {
					status.append("The duplicate key value is (" + volumeGroup.getVolumeGroupId() + ","
							+ volumeGroup.getOcId() + "," + volumeGroup.getRegionList() + "," + volumeGroup.getRegion()
							+ "," + volumeGroup.getSubscriptionCategoryId() + ")in 'volume_group_regions' table");

				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status.toString();
	}

	@Override
	public List<Map<String, Object>> getSubscriptionCategory(Long ocId, Long volumeGroupId) {
		List<Map<String, Object>> subscriptionCategoryData = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"select subscription_category.description,vol_grp_regions_category.sales_target from vol_grp_regions_category ");
		query.append(
				"inner join subscription_category on subscription_category.subscription_category_id = vol_grp_regions_category.subscription_category_id ");
		query.append("where vol_grp_regions_category.oc_id=" + ocId + " and vol_grp_regions_category.volume_group_id="
				+ volumeGroupId);
		try {
			subscriptionCategoryData = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptionCategoryData;
	}

	@Override
	public List<Map<String, Object>> getDiscountRates(int discClassId) {
		List<Map<String, Object>> DiscountRates = new ArrayList<>();
		try {
			DiscountRates = jdbcTemplate.queryForList(
					"select discount_class_id,discount_class,description,isNULL(region_list, '')region_list,oc_id,mru_disc_class_effective_seq,use_on_renewal,is_package from discount_class where discount_class_id="
							+ discClassId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return DiscountRates;
	}

	@Override
	public List<Map<String, Object>> getDiscountRatesDetails() {
		List<Map<String, Object>> DiscountRates = new ArrayList<>();
		try {
			DiscountRates = jdbcTemplate.queryForList(
					"select discount_class_id,discount_class,description,region_list,oc_id,mru_disc_class_effective_seq,use_on_renewal,is_package from discount_class");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return DiscountRates;
	}

	@Override
	public int getDiscountId() {
		int discountId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(discount_class_id) from discount_class",
					String.class);
			if (maxId == null) {
				discountId = 0;
			} else {
				discountId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return discountId;
	}

	@Override
	public List<Map<String, Object>> getDiscountClass(Long ocId) {
		List<Map<String, Object>> discountRates = new ArrayList<>();
		try {
			discountRates = jdbcTemplate.queryForList(
					"select discount_class_id,discount_class,description,region_list,oc_id,mru_disc_class_effective_seq,use_on_renewal,is_package from discount_class where oc_id="
							+ ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountRates;
	}

	@Override
	public int deleteDiscountRecords(int ocId, int discountId) {
		int Status = 0;
		try {
			String discountCard = "delete from discount_card where discount_class_id=" + discountId;
			Status = jdbcTemplate.update(discountCard);
			Status = 0;
			String discountClassEffective = "delete from disc_class_effective where discount_class_id=" + discountId;
			Status = jdbcTemplate.update(discountClassEffective);
			Status = 0;
			String DiscountRates = "delete from discount_class where oc_id=" + ocId + " and discount_class_id="
					+ discountId;
			Status = jdbcTemplate.update(DiscountRates);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return Status;
	}

	@Override
	public int updateRateDiscountRecords(DiscountClassModel discountClassModel) {

		String discountClass = "update discount_class set discount_class=:discount_class,description=:description where discount_class_id="
				+ discountClassModel.getDiscountClassId() + "and oc_id=" + discountClassModel.getOcId();
//      String discountClassEffective ="update disc_class_effective set disc_class_effective_seq=:disc_class_effective_seq,"
//		+ "description=:eff_description,effective_date=:effective_date,"
//		+ "renewal_expire_effective_date=:renewal_expire_effective_date where discount_class_id="+discountClassModel.getDiscountClassId(); 
		try {
			Map<String, Object> addOrderClassParams = new HashMap<>();
			addOrderClassParams.put("discount_class", discountClassModel.getDiscountClass());
			addOrderClassParams.put("description", discountClassModel.getDescription());
//			addOrderClassParams.put("disc_class_effective_seq", discountClassModel.getDiscClassEffectiveSeq());
//			addOrderClassParams.put("eff_description", discountClassModel.getEffDescription());
//			addOrderClassParams.put("effective_date", discountClassModel.getEffectiveDate());
//			addOrderClassParams.put("is_package", discountClassModel.getIsPackage());
//			addOrderClassParams.put("renewal_expire_effective_date", discountClassModel.getRenewalExpireEffectiveDate());

			namedParameterJdbcTemplate.update(discountClass, addOrderClassParams);
//			 namedParameterJdbcTemplate.update(discountClassEffective, addOrderClassParams);
			return 1;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return 0;

		}
	}

	@Override
	public int updateDiscountClassRecords(DiscountClassModel discountClassModel) {
		int status = 0;
		try {
			String addDiscountClassQuery = "update discount_class set discount_class_id =:discount_class_id,discount_class =:discount_class,description =:description,region_list =:region_list,use_on_renewal =:use_on_renewal,is_package =:is_package where discount_class_id="
					+ discountClassModel.getDiscountClassId();
			Map<String, Object> discountClassParams = new HashMap<>();
			discountClassParams.put("discount_class_id", discountClassModel.getDiscountClassId());
			discountClassParams.put("discount_class", discountClassModel.getDiscountClass());
			discountClassParams.put("description",
					discountClassModel.getDescription().isEmpty() ? null : discountClassModel.getDescription());
			discountClassParams.put("region_list",
					discountClassModel.getRegionList().isEmpty() ? null : discountClassModel.getRegionList());
			// discountClassParams.put("oc_id", discountClassModel.getOcId());
			// discountClassParams.put("mru_disc_class_effective_seq",
			// discountClassModel.getMruDiscClassEffectiveSeq()==0?null:discountClassModel.getMruDiscClassEffectiveSeq());
			discountClassParams.put("use_on_renewal",
					discountClassModel.getUseOnRenewal() == 0 ? 0 : discountClassModel.getUseOnRenewal());
			discountClassParams.put("is_package",
					discountClassModel.getIsPackage() == 0 ? 0 : discountClassModel.getIsPackage());

			status = namedParameterJdbcTemplate.update(addDiscountClassQuery, discountClassParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getDiscountClassEffectiveDateDetails(int discountId) {
		List<Map<String, Object>> discountClassEffectiveDetails = new ArrayList<>();
		try {
			discountClassEffectiveDetails = jdbcTemplate.queryForList(
					"select discount_class_id,disc_class_effective_seq,description,effective_date,renewal_expire_effective_date,mru_discount_card_seq from disc_class_effective where discount_class_id="
							+ discountId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountClassEffectiveDetails;
	}

	@Override
	public List<Map<String, Object>> getDiscountClassEffectiveDateTableData() {
		List<Map<String, Object>> discountClassEffectiveDetails = new ArrayList<>();
		try {
			discountClassEffectiveDetails = jdbcTemplate.queryForList("select * from disc_class_effective");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountClassEffectiveDetails;
	}

	@Override
	public int saveEffectiveDateDiscountRecords(DiscClassEffective discClassEffective) {

		StringBuilder discountClassEffective = new StringBuilder(
				"insert into disc_class_effective(discount_class_id,disc_class_effective_seq,description,effective_date,renewal_expire_effective_date,mru_discount_card_seq) values(:discount_class_id,:disc_class_effective_seq,:description,:effective_date,:renewal_expire_effective_date,:mru_discount_card_seq)");
		int status = 0;
		Integer discountClassId = discClassEffective.getDiscountClassId();
		Map<String, Object> addEffectiveDateDiscountParams = new HashMap<>();
		try {
			addEffectiveDateDiscountParams.put("discount_class_id", discClassEffective.getDiscountClassId());
			String maxSeq = jdbcTemplate.queryForObject(
					"select max(disc_class_effective_seq) from disc_class_effective where discount_class_id="
							+ discClassEffective.getDiscountClassId(),
					String.class);
			if (maxSeq == null) {
				addEffectiveDateDiscountParams.put("disc_class_effective_seq", 1);
				updateDiscountClassRecords(discountClassId);
			} else {
				addEffectiveDateDiscountParams.put("disc_class_effective_seq", Integer.parseInt(maxSeq) + 1);
				updateDiscountClassRecords(discountClassId);
			}
			addEffectiveDateDiscountParams.put("description",
					discClassEffective.getDescription().isEmpty() ? null : discClassEffective.getDescription());
			addEffectiveDateDiscountParams.put("effective_date",
					discClassEffective.getEffectiveDate().isEmpty() ? null : discClassEffective.getEffectiveDate());
			addEffectiveDateDiscountParams.put("renewal_expire_effective_date",
					discClassEffective.getRenewalExpireEffectiveDate().isEmpty() ? null
							: discClassEffective.getRenewalExpireEffectiveDate());
			// addEffectiveDateDiscountParams.put("mru_discount_card_seq",
			// discClassEffective.getMruDiscountCardSeq()==0?null:discClassEffective.getMruDiscountCardSeq());
			addEffectiveDateDiscountParams.put("mru_discount_card_seq",
					discClassEffective.getMruDiscountCardSeq() == 0 ? null : null);
			status = namedParameterJdbcTemplate.update(discountClassEffective.toString(),
					addEffectiveDateDiscountParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	public void updateDiscountClassRecords(Integer discountId) {
		String updateDiscountClass = "update discount_class set mru_disc_class_effective_seq=:mru_disc_class_effective_seq where discount_class_id="
				+ discountId;
		try {
			Map<String, Object> addOrderClassParams = new HashMap<>();
			String mru_disc_class_effective_seq = jdbcTemplate.queryForObject(
					"select max(mru_disc_class_effective_seq) from discount_class where discount_class_id="
							+ discountId,
					String.class);
			addOrderClassParams.put("mru_disc_class_effective_seq",
					mru_disc_class_effective_seq != null ? Integer.valueOf(mru_disc_class_effective_seq) + 1 : 1);
			addOrderClassParams.put("discount_class_id", discountId);
			namedParameterJdbcTemplate.update(updateDiscountClass, addOrderClassParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public Integer getDisc_class_effective_Seq(Integer discountId) {
		int disc_class_effective_Seq = 0;
		try {
			// String disc_class_effective_seq = jdbcTemplate.queryForObject("select
			// MAX(disc_class_effective_seq) from disc_class_effective where
			// discount_class_id =(select MAX(discount_class_id) from disc_class_effective
			// )", String.class);
			String disc_class_effective_seq = jdbcTemplate.queryForObject(
					"select MAX(disc_class_effective_seq) from disc_class_effective where discount_class_id ="
							+ discountId,
					String.class);
			if (disc_class_effective_seq == null) {
				disc_class_effective_Seq = 0;
			} else {
				disc_class_effective_Seq = Integer.valueOf(disc_class_effective_seq);
			}
		} catch (Exception e) {
		}

		return disc_class_effective_Seq;
	}

	@Override
	public Integer getRateClassEffectiveSeq(Integer rateClassId) {
		int disc_class_effective_Seq = 0;
		try {
			String disc_class_effective_seq = jdbcTemplate.queryForObject(
					"select MAX(rate_class_effective_seq) from rate_class_effective where rate_class_id ="
							+ rateClassId,
					String.class);
			if (disc_class_effective_seq == null) {
				disc_class_effective_Seq = 0;
			} else {
				disc_class_effective_Seq = Integer.valueOf(disc_class_effective_seq);
			}
		} catch (Exception e) {
		}

		return disc_class_effective_Seq;
	}

	@Override
	public int updateEffectiveDateDiscountRecords(DiscClassEffective discClassEffective) {
		int status = 0;
		Map<String, Object> addOrderClassParams = new HashMap<>();
		String discountClassEffective = "update disc_class_effective set description=:description,effective_date=:effective_date,renewal_expire_effective_date=:renewal_expire_effective_date where disc_class_effective_seq="
				+ discClassEffective.getDiscClassEffectiveSeq() + " and discount_class_id="
				+ discClassEffective.getDiscountClassId();
		try {
			addOrderClassParams.put("discount_class_id", discClassEffective.getDiscountClassId());
			addOrderClassParams.put("disc_class_effective_seq", discClassEffective.getDiscClassEffectiveSeq());
			addOrderClassParams.put("description",
					discClassEffective.getDescription().isEmpty() ? null : discClassEffective.getDescription());
			addOrderClassParams.put("effective_date", discClassEffective.getEffectiveDate());
			addOrderClassParams.put("renewal_expire_effective_date",
					discClassEffective.getRenewalExpireEffectiveDate().isEmpty() ? null
							: discClassEffective.getRenewalExpireEffectiveDate());
			// addOrderClassParams.put("mru_discount_card_seq",
			// discClassEffective.getMruDiscountCardSeq()==0?null:discClassEffective.getMruDiscountCardSeq());
			status = namedParameterJdbcTemplate.update(discountClassEffective, addOrderClassParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveRateClassEffective(RateClassModel model) {

		StringBuilder rateClassEffective = new StringBuilder(
				"insert into rate_class_effective(rate_class_id,rate_class_effective_seq,description,effective_date,renewal_expire_effective_date,default_price_per_issue,cost_per_day,default_pkg_price) values(:rate_class_id,:rate_class_effective_seq,:description,:effective_date,:renewal_expire_effective_date,:default_price_per_issue,:cost_per_day,:default_pkg_price)");
		int status = 0;
		Map<String, Object> addEffectiveDateRateParams = new HashMap<>();
		Integer rateClassId = model.getRateClassId();
		Integer rateClassEffectiveSeq = model.getRateClassEffectiveSeq();
		try {
			addEffectiveDateRateParams.put("rate_class_id", model.getRateClassId());
			String maxSeq = jdbcTemplate.queryForObject(
					"select max(rate_class_effective_seq) from rate_class_effective where rate_class_id="
							+ model.getRateClassId(),
					String.class);
			if (maxSeq == null) {
				addEffectiveDateRateParams.put("rate_class_effective_seq", 1);
				updateRateClassMruRateClassEffectiveSeqColumn(rateClassId);
			} else {
				addEffectiveDateRateParams.put("rate_class_effective_seq", Integer.parseInt(maxSeq) + 1);
				updateRateClassMruRateClassEffectiveSeqColumn(rateClassId);
			}
			addEffectiveDateRateParams.put("description",
					model.getDescription().isEmpty() ? null : model.getDescription());
			addEffectiveDateRateParams.put("effective_date", model.getEffectiveDate());
			addEffectiveDateRateParams.put("renewal_expire_effective_date",
					model.getRenewalExpireEffectiveDate().isEmpty() ? null : model.getRenewalExpireEffectiveDate());
			addEffectiveDateRateParams.put("default_price_per_issue", model.getDefaultPricePerIssue());
			// addEffectiveDateRateParams.put("mru_rate_card_seq",
			// model.getMruRateCardSeq()==0?null:model.getMruRateCardSeq());
			// addEffectiveDateRateParams.put("mru_rate_card_seq",
			// model.getMruRateCardSeq()==0?null:null);
			addEffectiveDateRateParams.put("cost_per_day", model.getCostPerDay());
			addEffectiveDateRateParams.put("default_pkg_price", model.getDefaultPkgPrice());
			status = namedParameterJdbcTemplate.update(rateClassEffective.toString(), addEffectiveDateRateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	public void updateRateClassMruRateClassEffectiveSeqColumn(Integer rateClassId) {
		String updateDiscountClass = "update rate_class set mru_rate_class_effective_seq=:mru_rate_class_effective_seq where rate_class_id="
				+ rateClassId;
		try {
			Map<String, Object> addOrderClassParams = new HashMap<>();
			String mru_rate_class_effective_seq = jdbcTemplate.queryForObject(
					"select max(mru_rate_class_effective_seq) from rate_class where rate_class_id=" + rateClassId,
					String.class);
			addOrderClassParams.put("mru_rate_class_effective_seq",
					mru_rate_class_effective_seq != null ? Integer.valueOf(mru_rate_class_effective_seq) + 1 : 1);
			addOrderClassParams.put("rate_class_id", rateClassId);
			namedParameterJdbcTemplate.update(updateDiscountClass, addOrderClassParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int updateRateClassEffective(RateClassModel rateClassModel) {
		int status = 0;
		Map<String, Object> addEffectiveDateRateParams = new HashMap<>();
		String discountClassEffective = "update rate_class_effective set description=:description,effective_date=:effective_date,renewal_expire_effective_date=:renewal_expire_effective_date,default_price_per_issue=:default_price_per_issue,cost_per_day=:cost_per_day,default_pkg_price=:default_pkg_price where rate_class_effective_seq="
				+ rateClassModel.getRateClassEffectiveSeq() + " and rate_class_id=" + rateClassModel.getRateClassId();
		try {
			addEffectiveDateRateParams.put("rate_class_id", rateClassModel.getRateClassId());
			addEffectiveDateRateParams.put("rate_class_effective_seq", rateClassModel.getRateClassEffectiveSeq());
			addEffectiveDateRateParams.put("description",
					rateClassModel.getDescription().isEmpty() ? null : rateClassModel.getDescription());
			addEffectiveDateRateParams.put("effective_date", rateClassModel.getEffectiveDate());
			addEffectiveDateRateParams.put("renewal_expire_effective_date",
					rateClassModel.getRenewalExpireEffectiveDate().isEmpty() ? null
							: rateClassModel.getRenewalExpireEffectiveDate());
			addEffectiveDateRateParams.put("default_price_per_issue", rateClassModel.getDefaultPricePerIssue());
			// addEffectiveDateRateParams.put("mru_rate_card_seq",
			// rateClassModel.getMruRateCardSeq()==0?null:rateClassModel.getMruRateCardSeq());
			addEffectiveDateRateParams.put("cost_per_day", rateClassModel.getCostPerDay());
			addEffectiveDateRateParams.put("default_pkg_price", rateClassModel.getDefaultPkgPrice());
			status = namedParameterJdbcTemplate.update(discountClassEffective, addEffectiveDateRateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getDiscountCardRecords(int discountId) {

		List<Map<String, Object>> discountCardDetails = new ArrayList<>();
		try {
			discountCardDetails = jdbcTemplate
					.queryForList("select * from discount_card where discount_class_id=" + discountId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountCardDetails;
	}

	@Override
	public List<Map<String, Object>> getDiscountCardRecords(int discountId, int disc_class_effective_Seq) {
		List<Map<String, Object>> discountCardDetails = new ArrayList<>();
		try {
			discountCardDetails = jdbcTemplate.queryForList("select * from discount_card where discount_class_id="
					+ discountId + " and disc_class_effective_seq=" + disc_class_effective_Seq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountCardDetails;
	}

	@Override
	public int saveDiscountCardRecords(DiscountCard discountCard) {
		Map<String, Object> saveDiscountCardParams = new HashMap<>();
		int status = 0;
		Integer discountClassId = discountCard.getDiscountClassId();
		Integer discClassEffectiveSeq = discountCard.getDiscClassEffectiveSeq();
		StringBuilder saveDiscountCard = new StringBuilder(
				"insert into discount_card(discount_class_id,disc_class_effective_seq,discount_card_seq,region_list,region,currency,from_qty,to_qty,discount_percent,customer_category,unit_type,discount_amount,lookup_currency,from_amt,to_amt) values(:discount_class_id,:disc_class_effective_seq,:discount_card_seq,:region_list,:region,:currency,:from_qty,:to_qty,:discount_percent,:customer_category,:unit_type,:discount_amount,:lookup_currency,:from_amt,:to_amt)");
		try {
			String maxPKId = jdbcTemplate
					.queryForObject("select MAX(discount_card_seq) from discount_card where discount_class_id="
							+ discountCard.getDiscountClassId(), String.class);
			if (maxPKId == null) {
				saveDiscountCardParams.put("discount_card_seq", 1);
				updateMru_discount_card_seq(discountClassId, discClassEffectiveSeq);
			} else {
				saveDiscountCardParams.put("discount_card_seq", Integer.parseInt(maxPKId) + 1);
				updateMru_discount_card_seq(discountClassId, discClassEffectiveSeq);
			}
			saveDiscountCardParams.put("discount_class_id", discountCard.getDiscountClassId());
			saveDiscountCardParams.put("disc_class_effective_seq", discountCard.getDiscClassEffectiveSeq());
			saveDiscountCardParams.put("region_list",
					discountCard.getRegionList().isEmpty() ? null : discountCard.getRegionList());
			saveDiscountCardParams.put("region", discountCard.getRegion().isEmpty() ? null : discountCard.getRegion());
			saveDiscountCardParams.put("currency",
					discountCard.getCurrency().isEmpty() ? null : discountCard.getCurrency());
			saveDiscountCardParams.put("from_qty", discountCard.getFromQty() == 0 ? null : discountCard.getFromQty());
			saveDiscountCardParams.put("to_qty", discountCard.getToQty() == 0 ? null : discountCard.getToQty());
			saveDiscountCardParams.put("discount_percent",
					discountCard.getDiscountPercent() == null ? null : discountCard.getDiscountPercent());
			saveDiscountCardParams.put("customer_category",
					discountCard.getCustomerCategory().isEmpty() ? null : discountCard.getCustomerCategory());
			saveDiscountCardParams.put("unit_type", discountCard.getUnitType());
			saveDiscountCardParams.put("discount_amount",
					discountCard.getDiscountAmount() == null ? null : discountCard.getDiscountAmount());
			saveDiscountCardParams.put("lookup_currency",
					discountCard.getLookupCurrency().isEmpty() ? null : discountCard.getLookupCurrency());
			saveDiscountCardParams.put("from_amt", discountCard.getFromQty() == 0 ? null : discountCard.getFromQty());
			saveDiscountCardParams.put("to_amt",
					discountCard.getToAmount() == null ? null : discountCard.getToAmount());
			status = namedParameterJdbcTemplate.update(saveDiscountCard.toString(), saveDiscountCardParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	// update mru_discount_card_seq column of disc_class_effective
	public void updateMru_discount_card_seq(Integer discountId, Integer discClassEffectiveSeq) {
		String query = "update disc_class_effective set mru_discount_card_seq =:mru_discount_card_seq where discount_class_id="
				+ discountId + " and disc_class_effective_seq=" + discClassEffectiveSeq;
		try {
			Map<String, Object> addOrderClassParams = new HashMap<>();
			String mru_discount_card_seq = jdbcTemplate.queryForObject(
					"select max(mru_discount_card_seq) from disc_class_effective where discount_class_id=" + discountId,
					String.class);
			addOrderClassParams.put("mru_discount_card_seq",
					mru_discount_card_seq != null ? Integer.valueOf(mru_discount_card_seq) + 1 : 1);
			addOrderClassParams.put("discount_class_id", discountId);
			namedParameterJdbcTemplate.update(query, addOrderClassParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int updateDiscountCardRecords(DiscountCard discountCard) {
		Map<String, Object> updateDiscountCardParams = new HashMap<>();
		int status = 0;
		StringBuilder saveDiscountCard = new StringBuilder(
				"update discount_card set region_list =:region_list,region =:region,currency =:currency,from_qty =:from_qty,to_qty =:to_qty,discount_percent =:discount_percent,customer_category =:customer_category,unit_type =:unit_type,discount_amount =:discount_amount,lookup_currency =:lookup_currency,from_amt =:from_amt,to_amt =:to_amt where discount_card_seq="
						+ discountCard.getDiscountCardSeq() + " and discount_class_id="
						+ discountCard.getDiscountClassId());
		try {
			updateDiscountCardParams.put("discount_class_id", discountCard.getDiscountClassId());
			// updateDiscountCardParams.put("disc_class_effective_seq",
			// discountCard.getDiscClassEffectiveSeq());
			updateDiscountCardParams.put("discount_card_seq", discountCard.getDiscountCardSeq());
			updateDiscountCardParams.put("region_list",
					discountCard.getRegionList().isEmpty() ? null : discountCard.getRegionList());
			updateDiscountCardParams.put("region",
					discountCard.getRegion().isEmpty() ? null : discountCard.getRegion());
			updateDiscountCardParams.put("currency",
					discountCard.getCurrency().isEmpty() ? null : discountCard.getCurrency());
			updateDiscountCardParams.put("from_qty", discountCard.getFromQty() == 0 ? null : discountCard.getFromQty());
			updateDiscountCardParams.put("to_qty", discountCard.getToQty() == 0 ? null : discountCard.getToQty());
			updateDiscountCardParams.put("discount_percent",
					discountCard.getDiscountPercent() == null ? null : discountCard.getDiscountPercent());
			updateDiscountCardParams.put("customer_category",
					discountCard.getCustomerCategory().isEmpty() ? null : discountCard.getCustomerCategory());
			updateDiscountCardParams.put("unit_type", discountCard.getUnitType());
			updateDiscountCardParams.put("discount_amount",
					discountCard.getDiscountAmount() == null ? null : discountCard.getDiscountAmount());
			updateDiscountCardParams.put("lookup_currency",
					discountCard.getLookupCurrency().isEmpty() ? null : discountCard.getLookupCurrency());
			updateDiscountCardParams.put("from_amt", discountCard.getFromQty() == 0 ? null : discountCard.getFromQty());
			updateDiscountCardParams.put("to_amt",
					discountCard.getToAmount() == null ? null : discountCard.getToAmount());
			status = namedParameterJdbcTemplate.update(saveDiscountCard.toString(), updateDiscountCardParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public void insertBatchRateCard(final List<RateClassModel> model) {

		try {
			jdbcTemplate.batchUpdate(
					"insert into ratecard (rate_class_id,rate_class_effective_seq,ratecard_seq,from_qty,region_list,region,currency,to_qty,price,charge_new,remit_new,percent_new,basic,charge_ren,remit_ren,percent_ren,lookup_currency,qty_discount_schedule,baseline_qty,unit_type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i) throws SQLException {
							RateClassModel rateCard = model.get(i);
							ps.setInt(1, rateCard.getRateClassId());
							ps.setInt(2, rateCard.getRateClassEffectiveSeq());
							int rateClassId = rateCard.getRateClassId();
							int rateClassEffectiveSeq = rateCard.getRateClassEffectiveSeq();

							int cardSeq = rateCard.getRateCardSeq();
							cardSeq = 0;
							String maxPKId = jdbcTemplate
									.queryForObject("select MAX(ratecard_seq) from ratecard where rate_class_id="
											+ rateCard.getRateClassId(), String.class);
							if (maxPKId == null) {
								cardSeq = 1;
								ps.setInt(3, cardSeq);
								updateMru_rate_card_seq(rateClassId, rateClassEffectiveSeq);
							} else {
								cardSeq = Integer.valueOf(maxPKId) + 1;
								ps.setInt(3, cardSeq);
								updateMru_rate_card_seq(rateClassId, rateClassEffectiveSeq);
							}
							// ps.setInt(3, cardSeq);
							ps.setInt(4, rateCard.getFromQty());
							ps.setString(5, rateCard.getRegionList());
							ps.setString(6, rateCard.getRegion());
							ps.setString(7, rateCard.getCurrency());
							ps.setInt(8, rateCard.getToQty());
							ps.setFloat(9, rateCard.getPrice());
							ps.setFloat(10, rateCard.getChargeNew());
							ps.setFloat(11, rateCard.getRemitNew());
							ps.setFloat(12, rateCard.getPercentNew());
							ps.setFloat(13, rateCard.getBasic());
							ps.setFloat(14, rateCard.getChargeRen());
							ps.setFloat(15, rateCard.getRemitRen());
							ps.setFloat(16, rateCard.getPercentRen());
							ps.setString(17, rateCard.getLookupCurrency());
							ps.setString(18, rateCard.getQtyDiscounSchedule());
							ps.setInt(19, rateCard.getBaselineQty());
							ps.setShort(20, rateCard.getUnitType());

						}

						@Override
						public int getBatchSize() {
							return model.size();
						}
					});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}

	@Override
	public int saveRateCardRecords(RateClassModel rateCard) {
		Map<String, Object> saveRateCardParams = new HashMap<>();
		int status = 0;
		Integer rateClassId = rateCard.getRateClassId();
		Integer rateClassEffectiveSeq = rateCard.getRateClassEffectiveSeq();
		StringBuilder saveRateCard = new StringBuilder(
				"insert into ratecard (rate_class_id,rate_class_effective_seq,ratecard_seq,from_qty,region_list,region,currency,to_qty,price,charge_new,remit_new,percent_new,basic,charge_ren,remit_ren,percent_ren,lookup_currency,qty_discount_schedule,baseline_qty,unit_type) values(:rate_class_id,:rate_class_effective_seq,:ratecard_seq,:from_qty,:region_list,:region,:currency,:to_qty,:price,:charge_new,:remit_new,:percent_new,:basic,:charge_ren,:remit_ren,:percent_ren,:lookup_currency,:qty_discount_schedule,:baseline_qty,:unit_type)");
		try {
			String maxPKId = jdbcTemplate.queryForObject(
					"select MAX(ratecard_seq) from ratecard where rate_class_id=" + rateCard.getRateClassId(),
					String.class);
			if (maxPKId == null) {
				saveRateCardParams.put("ratecard_seq", 1);
				updateMru_rate_card_seq(rateClassId, rateClassEffectiveSeq);
			} else {
				saveRateCardParams.put("ratecard_seq", Integer.parseInt(maxPKId) + 1);
				updateMru_rate_card_seq(rateClassId, rateClassEffectiveSeq);
			}
			saveRateCardParams.put("rate_class_id", rateCard.getRateClassId());
			saveRateCardParams.put("rate_class_effective_seq", rateCard.getRateClassEffectiveSeq());
			saveRateCardParams.put("from_qty", rateCard.getFromQty());
			if (("null".equals(rateCard.getRegionList())) | ("".equals(rateCard.getRegionList()))) {
				saveRateCardParams.put("region_list", null);
			} else {
				saveRateCardParams.put("region_list", rateCard.getRegionList());
			}
			if (("null".equals(rateCard.getRegion())) | ("".equals(rateCard.getRegion()))) {
				saveRateCardParams.put("region", null);
			} else {
				saveRateCardParams.put("region", rateCard.getRegion());
			}
			if (("null".equals(rateCard.getCurrency())) | ("".equals(rateCard.getCurrency()))) {
				saveRateCardParams.put("currency", null);
			} else {
				saveRateCardParams.put("currency", rateCard.getCurrency());
			}
			saveRateCardParams.put("to_qty", rateCard.getToQty());
			saveRateCardParams.put("price", rateCard.getPrice());
			saveRateCardParams.put("charge_new", rateCard.getChargeNew() == 0 ? null : rateCard.getChargeNew());
			saveRateCardParams.put("remit_new", rateCard.getRemitNew() == 0 ? null : rateCard.getRemitNew());
			saveRateCardParams.put("percent_new", rateCard.getPercentNew() == 0 ? null : rateCard.getPercentNew());
			saveRateCardParams.put("basic", rateCard.getBasic());
			saveRateCardParams.put("charge_ren", rateCard.getChargeRen() == 0 ? null : rateCard.getChargeRen());
			saveRateCardParams.put("remit_ren", rateCard.getRemitRen() == 0 ? null : rateCard.getRemitRen());
			saveRateCardParams.put("percent_ren", rateCard.getPercentRen() == 0 ? null : rateCard.getPercentRen());
			if (("null".equals(rateCard.getLookupCurrency())) | ("".equals(rateCard.getLookupCurrency()))) {
				saveRateCardParams.put("lookup_currency", null);
			} else {
				saveRateCardParams.put("lookup_currency", rateCard.getLookupCurrency());
			}
			if (("null".equals(rateCard.getQtyDiscounSchedule())) | ("".equals(rateCard.getQtyDiscounSchedule()))) {
				saveRateCardParams.put("qty_discount_schedule", null);
			} else {
				saveRateCardParams.put("qty_discount_schedule", rateCard.getQtyDiscounSchedule());
			}
			saveRateCardParams.put("baseline_qty", rateCard.getBaselineQty() == 0 ? 1 : rateCard.getBaselineQty());
			saveRateCardParams.put("unit_type", rateCard.getUnitType());
			status = namedParameterJdbcTemplate.update(saveRateCard.toString(), saveRateCardParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	// update mru_ratecard_seq column of rate_class_effective
	public void updateMru_rate_card_seq(Integer rateClassId, Integer rateClassEffectiveSeq) {
		String query = "update rate_class_effective set mru_ratecard_seq =:mru_ratecard_seq where rate_class_id="
				+ rateClassId + " and rate_class_effective_seq=" + rateClassEffectiveSeq;
		try {
			Map<String, Object> updateRateClassEffectiveParams = new HashMap<>();
			String mru_ratecard_seq = jdbcTemplate.queryForObject(
					"select max(mru_ratecard_seq) from rate_class_effective where rate_class_id=" + rateClassId,
					String.class);
			updateRateClassEffectiveParams.put("mru_ratecard_seq",
					mru_ratecard_seq != null ? Integer.valueOf(mru_ratecard_seq) + 1 : 1);
			updateRateClassEffectiveParams.put("rate_class_id", rateClassId);
			namedParameterJdbcTemplate.update(query, updateRateClassEffectiveParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int updateRateCardRecords(RateClassModel rateCard) {
		Map<String, Object> updateRateCardParams = new HashMap<>();
		int status = 0;
		StringBuilder saveDiscountCard = new StringBuilder(
				"update ratecard set from_qty=:from_qty,region_list=:region_list,region=:region,currency=:currency,to_qty=:to_qty,price=:price,charge_new=:charge_new,remit_new=:remit_new,percent_new=:percent_new,basic=:basic,charge_ren=:charge_ren,remit_ren=:remit_ren,percent_ren=:percent_ren,lookup_currency=:lookup_currency,qty_discount_schedule=:qty_discount_schedule,baseline_qty=:baseline_qty,unit_type=:unit_type where ratecard_seq="
						+ rateCard.getRateCardSeq() + " and rate_class_id=" + rateCard.getRateClassId());
		try {

			updateRateCardParams.put("rate_class_id", rateCard.getRateClassId());
			// updateRateCardParams.put("rate_class_effective_seq",
			// rateCard.getRateClassEffectiveSeq());
			updateRateCardParams.put("ratecard_seq", rateCard.getRateCardSeq());
			updateRateCardParams.put("from_qty", rateCard.getFromQty());
			updateRateCardParams.put("region_list",
					rateCard.getRegionList().isEmpty() ? null : rateCard.getRegionList());
			updateRateCardParams.put("region", rateCard.getRegion().isEmpty() ? null : rateCard.getRegion());
			updateRateCardParams.put("currency", rateCard.getCurrency().isEmpty() ? null : rateCard.getCurrency());
			updateRateCardParams.put("to_qty", rateCard.getToQty());
			updateRateCardParams.put("price", rateCard.getPrice());
			updateRateCardParams.put("charge_new", rateCard.getChargeNew() == 0 ? null : rateCard.getChargeNew());
			updateRateCardParams.put("remit_new", rateCard.getRemitNew() == 0 ? null : rateCard.getRemitNew());
			updateRateCardParams.put("percent_new", rateCard.getPercentNew() == 0 ? null : rateCard.getPercentNew());
			updateRateCardParams.put("basic", rateCard.getBasic());
			updateRateCardParams.put("charge_ren", rateCard.getChargeRen() == 0 ? null : rateCard.getChargeRen());
			updateRateCardParams.put("remit_ren", rateCard.getRemitRen() == 0 ? null : rateCard.getRemitRen());
			updateRateCardParams.put("percent_ren", rateCard.getPercentRen() == 0 ? null : rateCard.getPercentRen());
			updateRateCardParams.put("lookup_currency",
					rateCard.getLookupCurrency().isEmpty() ? null : rateCard.getLookupCurrency());
			updateRateCardParams.put("qty_discount_schedule",
					rateCard.getQtyDiscounSchedule().isEmpty() ? null : rateCard.getQtyDiscounSchedule());
			updateRateCardParams.put("baseline_qty", rateCard.getBaselineQty());
			updateRateCardParams.put("unit_type", rateCard.getUnitType());
			status = namedParameterJdbcTemplate.update(saveDiscountCard.toString(), updateRateCardParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	/* Source code table Details */
	@Override
	public List<ParentOrderClassModel> getSourceCodeDetails(Long ocId, int active, int sourceCodeType, int isDdp) {
		List<ParentOrderClassModel> SourceCodeTableData = new ArrayList<>();
		try {
			if (sourceCodeType == 6 && active == 3) {
				SourceCodeTableData = namedParameterJdbcTemplate.query(
						"select * from source_code where oc_id =" + ocId + "and is_ddp= " + isDdp,
						new SourceCodeMapper());
			} else if (sourceCodeType == 6) {
				SourceCodeTableData = namedParameterJdbcTemplate.query("select * from source_code where oc_id ='" + ocId
						+ "' and active=" + active + "and is_ddp= " + isDdp, new SourceCodeMapper());
			} else if (active == 3) {
				SourceCodeTableData = namedParameterJdbcTemplate.query("select * from source_code where oc_id ='" + ocId
						+ "' and source_code_type=" + sourceCodeType + "and is_ddp= " + isDdp, new SourceCodeMapper());
			} else {
				SourceCodeTableData = namedParameterJdbcTemplate.query(
						"select * from source_code where oc_id ='" + ocId + "' and active=" + active
								+ "and source_code_type=" + sourceCodeType + "and is_ddp= " + isDdp,
						new SourceCodeMapper());
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return SourceCodeTableData;
	}

	@Override
	public List<ParentOrderClassModel> getSourceCodeDetails(Long ocId) {
		List<ParentOrderClassModel> sourceCodeDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder("select source_code_id,agency_customer_id,"
				+ "source_format,source_code,description,state_break,generated,breakeven,offer,list,"
				+ "from_date,to_date,qty,cost,audit_qual_category,generic_agency,oc_id,active,"
				+ "newsub_rate_class_id,new_renewal_card_id,newsub_discount_class_id,audit_subscription_type_id,"
				+ "audit_qual_source_id,audit_name_title_id,audit_sales_channel_id,premium_order_code_id,source_code_type,"
				+ "mru_catalog_content_seq,currency,mru_generic_promotion_code_seq,is_ddp,shipping_price_list "
				+ "from source_code where oc_id =" + ocId);
		try {
			sourceCodeDetails = namedParameterJdbcTemplate.query(query.toString(), new SourceCodeMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeDetails;
	}

	@Override
	public List<DropdownModel> getSourceCodeTypeDetails() {
		List<Map<String, Object>> sourceCodeType = new ArrayList<>();
		List<DropdownModel> sourceCodeTypeDataList = new ArrayList<>();

		try {
			for (int i = 0; i <= 5; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("source_code_type_" + i));

				sourceCodeTypeDataList.add(model);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeTypeDataList;
	}

	/* Rate Class table Details */
	@Override
	public List<Map<String, Object>> getRateClassTableDetails(Long ocId) {
		List<Map<String, Object>> RateClassTableDetails = new ArrayList<>();
		try {
			// SELECT rate_class.* FROM rate_class WHERE (oc_id in (8,4,31) and is_package =
			// 0)

			RateClassTableDetails = jdbcTemplate.queryForList("select * from rate_class where oc_id =" + ocId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return RateClassTableDetails;
	}

	// get Rate List for orderCode on basis of oc_id

	@Override
	public List<DropdownModel> getRateList(Long ocId) {

		List<Map<String, Object>> RateListDetails = new ArrayList<>();
		List<DropdownModel> rateList = new ArrayList<>();
		try {

			// RateListDetails = jdbcTemplate.queryForList("select rate_class,* from
			// rate_class where oc_id in ((select parent_oc_id from oc where parent_oc_id is
			// not null and oc_id="+ ocId+ "),"+ocId+")");
			RateListDetails = jdbcTemplate.queryForList(
					"SELECT rate_class.rate_class_id,rate_class.rate_class,rate_class.description,rate_class.is_package FROM rate_class inner join oc o on rate_class.oc_id=o.oc_id where rate_class.oc_id = "
							+ ocId);
			for (Map<String, Object> row : RateListDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("rate_class_id").toString());
				model.setDisplay(row.get("rate_class").toString());
				model.setDescription(row.get("description") != null ? row.get("description").toString() : "");
				model.setExtra(row.get("is_package").toString());
				rateList.add(model);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateList;

	}

	/* delete rate Class Records */
	@Override
	public int deleteRateClassRecords(int rateClassId) {
		int status = 0;
		String deleteRateClassQuery = "delete FROM rate_class WHERE rate_class_id NOT IN"
				+ " (SELECT f.rate_class_id FROM rate_class_effective f) and rate_class_id=" + rateClassId;
		try {
			// if query fire successfully then status value will be 1 otherwise 0
			status = jdbcTemplate.update(deleteRateClassQuery);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	/* method to get rate Class Edit Details */
	@Override
	public List<Map<String, Object>> getRateClassDetails(int rateClassId) {
		List<Map<String, Object>> RateClassDetails = new ArrayList<>();
		try {
			if (rateClassId == 0) {
				return RateClassDetails;
			} else {
				RateClassDetails = jdbcTemplate
						.queryForList("select * from rate_class where rate_class_id =" + rateClassId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return RateClassDetails;

	}

	@Override
	public List<DropdownModel> getRegionList() {
		List<Map<String, Object>> regionList = new ArrayList<>();
		List<DropdownModel> regionDataList = new ArrayList<>();
		try {
			regionList = jdbcTemplate.queryForList("select region_list,description from region_list");
			for (Map<String, Object> RegionList : regionList) {
				DropdownModel model = new DropdownModel();
				model.setKey(RegionList.get("region_list").toString());
				model.setDisplay(RegionList.get("description") != null ? (String) RegionList.get("description") : "");
				regionDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return regionDataList;
	}

	@Override
	public List<DropdownModel> getRegion(String regionList) {
		List<Map<String, Object>> regions = new ArrayList<>();
		List<DropdownModel> regionDataList = new ArrayList<>();
		try {
			regions = jdbcTemplate
					.queryForList("select region,description from region where region_list='" + regionList + "'");
			regions.forEach(region -> {
				DropdownModel model = new DropdownModel();
				model.setKey(region.get("region").toString());
				model.setDisplay(region.get("description") != null ? (String) region.get("description") : "");
				regionDataList.add(model);
			});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return regionDataList;
	}

	@Override
	public List<DropdownModel> lookupCurrency() {
		List<Map<String, Object>> currencies = new ArrayList<>();
		List<DropdownModel> currencyList = new ArrayList<>();
		try {
			currencies = jdbcTemplate.queryForList("select currency,description,currency_symbol from currency");
			currencies.forEach(currency -> {
				DropdownModel model = new DropdownModel();
				model.setKey(currency.get("currency").toString());
				// model.setDisplay(currency.get("description")!=null?(String)currency.get("description"):null);
				// model.setDescription(currency.get("currency_symbol")!=null?(String)currency.get("currency_symbol"):null);
				model.setDisplay(currency.get("currency").toString() + ":" + currency.get("description").toString()
						+ ":" + currency.get("currency_symbol").toString());
				currencyList.add(model);
			});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return currencyList;
	}

	@Override
	public List<DropdownModel> getDiscountCardUnitType() {
		List<DropdownModel> discountCardUnitType = new ArrayList<>();
		try {
			for (int i = 0; i <= 2; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("unit_type_" + i));
				discountCardUnitType.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return discountCardUnitType;
	}

	@Override
	public List<Map<String, Object>> getEffectiveDatesTableData(int rateClassId) {
		List<Map<String, Object>> EffectiveDateTableDataDetails = new ArrayList<>();
		try {
			EffectiveDateTableDataDetails = jdbcTemplate
					.queryForList("select * from rate_class_effective where rate_class_id =" + rateClassId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return EffectiveDateTableDataDetails;
	}

	@Override
	public List<Map<String, Object>> getRateCardTableData(int rateClassId) {
		List<Map<String, Object>> rateCardTableDataDetails = new ArrayList<>();
		try {
			// select 1 from ratecard where rate_class_id = 361 and region is not null
			rateCardTableDataDetails = jdbcTemplate
					.queryForList("select * from ratecard where rate_class_id =" + rateClassId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateCardTableDataDetails;
	}

	@Override
	public List<Map<String, Object>> getRateCardTableData(int rateClassId, int rateClassEffectiveSeq) {
		List<Map<String, Object>> rateCardTableDataDetails = new ArrayList<>();
		try {
			// select 1 from ratecard where rate_class_id = 361 and region is not null
			rateCardTableDataDetails = jdbcTemplate.queryForList("select * from ratecard where rate_class_id ="
					+ rateClassId + " and rate_class_effective_seq=" + rateClassEffectiveSeq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateCardTableDataDetails;
	}

	@Override
	public List<DropdownModel> getRenewalDropDownData(Long ocId) {
		List<Map<String, Object>> renewalList = new ArrayList<>();
		List<DropdownModel> renewaDataList = new ArrayList<>();
		try {
			renewalList = jdbcTemplate.queryForList(
					"select renewal_card_id,renewal_card,description,oc_id from renewal_card where oc_id=" + ocId);
			for (Map<String, Object> RenewalList : renewalList) {
				DropdownModel model = new DropdownModel();
				model.setKey(RenewalList.get("renewal_card_id").toString());
				model.setDisplay(RenewalList.get("renewal_card").toString());
				model.setDescription(
						RenewalList.get("description") != null ? RenewalList.get("description").toString() : "");
				model.setExtra(RenewalList.get("oc_id").toString());
				renewaDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renewaDataList;
	}

	@Override
	public List<DropdownModel> getQtyDiscount() {
		List<Map<String, Object>> qtyDiscountList = new ArrayList<>();
		List<DropdownModel> qtyDiscountDataList = new ArrayList<>();
		try {
			qtyDiscountList = jdbcTemplate.queryForList(
					"select qty_discount_schedule,description,discount_amt_calc_type,mru_qty_discount_sched_dtl_seq from qty_discount_schedule");
			qtyDiscountList.forEach(qty -> {
				DropdownModel model = new DropdownModel();
				model.setKey(qty.get("qty_discount_schedule").toString());
				model.setDisplay(qty.get("description") != null ? qty.get("description").toString() : "");
				qtyDiscountDataList.add(model);
			});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return qtyDiscountDataList;
	}

	@Override
	// public List<DropdownModel> getAgencyRate()
	public List<Map<String, Object>> getAgencyRate(Integer rateClassId, Integer rateCardSeq) {
		List<Map<String, Object>> rateAgencyList = new ArrayList<>();
		// List<Map<String, Object>> rateAgencyDataList =new ArrayList<>();
		try {
			rateAgencyList = jdbcTemplate.queryForList(
					"select rate_class_id,rate_class_effective_seq,ratecard_seq,region,currency,from_qty,to_qty,charge_new,remit_new,percent_new,charge_ren,remit_ren,percent_ren from ratecard where rate_class_id="
							+ rateClassId + " and ratecard_seq=" + rateCardSeq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateAgencyList;
	}

	@Override
	public List<Map<String, Object>> getEffectiveDiscountData(int discountId) {
		List<Map<String, Object>> EffectiveDateDiscountRateDetails = new ArrayList<>();
		try {
			EffectiveDateDiscountRateDetails = jdbcTemplate
					.queryForList("select * from disc_class_effective where discount_class_id =" + discountId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return EffectiveDateDiscountRateDetails;
	}

	@Override
	public List<Map<String, Object>> getDemographicsTableData(int ocId) {
		List<Map<String, Object>> demogTableData = new ArrayList<>();
		try {
			demogTableData = jdbcTemplate.queryForList("select * from dem_form where oc_id =" + ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demogTableData;

	}

	@Override
	public int topicActiveSave(Long ocId, String topic) {
		int status = 0;
		try {

			String TopicActive = "insert into oc_topic(topic,oc_id) values(:topic,:oc_id)";
			Map<String, Object> addActiveTopicsParams = new HashMap<>();
			addActiveTopicsParams.put("topic", topic);
			addActiveTopicsParams.put("oc_id", ocId);
			status = namedParameterJdbcTemplate.update(TopicActive, addActiveTopicsParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int topicInActiveSave(Long ocId, String topic) {
		int status = 0;
		try {
			// topic = topic.toString();
			String TopicInActive = "delete from oc_topic where oc_id=" + ocId + "and topic =" + "'" + topic + "'";
			Map<String, Object> addActiveTopicsParams = new HashMap<>();
			status = jdbcTemplate.update(TopicInActive);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

//sub menu  
	private List<DashboardLeftPanelModel> getSubMenu(Long subChildOcId2, Set<Long> parentOcIdNodeCreatedList,
			Set<Long> ocIdPrinteddList, DashboardLeftPanelModel childModel, List<DashboardLeftPanelModel> childMenu,
			long totalSize, long loopCount) {

		List<DashboardLeftPanelModel> subChildMenu = new LinkedList<>();
		List<OrderClassModel> subChildList = jdbcTemplate.query(
				"select oc_id,parent_oc_id,oc,oc_type,case when oc_id = (select max(oc_id) from oc) then 'true' else 'false' end as IsActive from oc where parent_oc_id = ?",
				new Object[] { subChildOcId2 }, new OrderClassMapper());
		if (subChildList != null && subChildList.size() > 0) {
			for (OrderClassModel subChild : subChildList) {
				DashboardLeftPanelModel model = new DashboardLeftPanelModel();
				Long subChildOcId = subChild.getOcId();
				String subChildOcTitle = subChild.getOc();
				int subChildOcType = subChild.getOcType();
				String subChildIsActive = subChild.getIsActive();
				Long parentOcId = subChild.getParentOcId();

				parentOcIdNodeCreatedList.add(parentOcId);
				ocIdPrinteddList.add(subChildOcId);
				model.setId(String.valueOf(subChildOcId));
				model.setTitle(subChildOcTitle);
				model.setOcType(String.valueOf(subChildOcType));
				model.setIsActive(subChildIsActive);
				// here recursive method call based on parent oc id and returns list of oc id
				// where given parent oc id is fulfill, the lists set into model2 as node
				model.setNodes(getSubMenu(subChildOcId, parentOcIdNodeCreatedList, ocIdPrinteddList, childModel,
						childMenu, totalSize, loopCount));
				subChildMenu.add(model);
			}
		}
		return subChildMenu;
	}

//main menu
	@Override
	public List<DashboardLeftPanelModel> getleftPanelDashboardData() {
		List<OrderClassModel> elementList = new ArrayList<>();
		Set<Long> parentOcIdNodeCreatedList = new HashSet<>();
		Set<Long> ocIdPrinteddList = new HashSet<>();
		List<DashboardLeftPanelModel> rootMenu = new LinkedList<>();
		long totalSize = 0;
		long loopCount = 0;
		try {
			List<DashboardLeftPanelModel> parentMenu = new LinkedList<>();
			elementList = jdbcTemplate.query(
					"select oc_id,parent_oc_id,oc,oc_type,case when oc_id = (select max(oc_id) from oc) then 'true' else 'false' end as IsActive from oc ",
					new OrderClassMapper());
			totalSize = elementList.size();
			for (OrderClassModel element : elementList) {
				loopCount++;
				Long parentOcId = element.getParentOcId();
				DashboardLeftPanelModel parentModel = new DashboardLeftPanelModel();
				// if parent oc id is not null and parent oc id is not in
				// parentOcIdNodeCreatedList
				if (parentOcId != null && !parentOcIdNodeCreatedList.contains(parentOcId)) {
					List<DashboardLeftPanelModel> childMenu = new LinkedList<>();
					DashboardLeftPanelModel model = new DashboardLeftPanelModel();
					List<OrderClassModel> childList = jdbcTemplate.query(
							"select oc_id,parent_oc_id,oc,oc_type,case when oc_id = (select max(oc_id) from oc) then 'true' else 'false' end as IsActive from oc where oc_id = ?",
							new Object[] { parentOcId }, new OrderClassMapper());
					for (OrderClassModel childElement : childList) {
						Long childOcId = childElement.getOcId();
						Long childParentOcId = childElement.getOcId();
						String childOcTitle = childElement.getOc();
						int childOcType = childElement.getOcType();
						// this is being used for active node
						String childIsActive = childElement.getIsActive();
						if (!parentOcIdNodeCreatedList.contains(childParentOcId)) {
							// Insert childOcId into this nodeCreatedList,
							// nodeCreatedList contains unique parent oc id
							parentOcIdNodeCreatedList.add(childParentOcId);
							// set oc id and oc title of parent node
							model.setId(String.valueOf(childOcId));
							model.setTitle(childOcTitle);
							model.setOcType(String.valueOf(childOcType));
							model.setIsActive(childIsActive);
							childMenu.add(model);
							parentModel.setNodes(childMenu);
						}
						if (totalSize != loopCount) {
							// method call and returns nodes to assign model1 nodes
							childMenu = getSubMenu(parentOcId, parentOcIdNodeCreatedList, ocIdPrinteddList, parentModel,
									parentMenu, totalSize, loopCount);
						}
						model.setNodes(childMenu);
						rootMenu.add(model);
					}

				} else {
					Long ocId = element.getOcId();
					if (!ocIdPrinteddList.contains(ocId) && !parentOcIdNodeCreatedList.contains(ocId)) {
						List<OrderClassModel> ocIdIsNotParentOcIdOfAnyOcIdList = jdbcTemplate.query(
								"select parent_oc_id from oc where parent_oc_id = ?", new Object[] { ocId },
								new ParentOcIdMapper());
						// ocIdIsNotParentOcIdOfAnyOcIdList's size is 0 then else block won't be
						// executed
						if (ocIdIsNotParentOcIdOfAnyOcIdList.size() == 0) {
							// if parent oc id is null and ocId is not in both ocIdPrinteddList and
							// parentOcIdNodeCreatedList
							if (!ocIdPrinteddList.contains(ocId) && !parentOcIdNodeCreatedList.contains(ocId)) {
								String ocTitle = element.getOc();
								int ocType = element.getOcType();
								String isActive = element.getIsActive();
								ocIdPrinteddList.add(ocId);
								parentModel.setId(String.valueOf(ocId));
								parentModel.setTitle(ocTitle);
								parentModel.setOcType(String.valueOf(ocType));
								parentModel.setIsActive(isActive);
								rootMenu.add(parentModel);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(ERROR + e);
		}
		return rootMenu;
	}

	private static final class OrderClassMapper implements RowMapper<OrderClassModel> {
		@Override
		public OrderClassModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderClassModel model = new OrderClassModel();
			model.setOcId(rs.getLong("oc_id"));
			model.setOc(rs.getString("oc"));
			model.setOcType(rs.getInt("oc_type"));
			if (rs.getLong("parent_oc_id") != 0) {
				model.setParentOcId(rs.getLong("parent_oc_id"));
			} else {
				model.setParentOcId(null);
			}
			model.setIsActive(rs.getString("IsActive"));
			return model;
		}
	}

	private static final class ParentOcIdMapper implements RowMapper<OrderClassModel> {
		@Override
		public OrderClassModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderClassModel model = new OrderClassModel();
			if (rs.getLong("parent_oc_id") != 0) {
				model.setParentOcId(rs.getLong("parent_oc_id"));
			} else {
				model.setParentOcId(null);
			}

			return model;
		}
	}

	/**
	 * This method creates new record into upsell table
	 */
	@Override
	public int addUpSell(UpSellModel upSellModel) {
		int status = 0;
		StringBuilder addUpSellQuery = null;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		String sourceIdResult = null;
		addUpSellQuery = new StringBuilder("insert into upsell(");
		addUpSellQuery.append("upsell_id,oc_id,upsell_suggestion_id,calendar_campaign_id,source_code_id,");
		addUpSellQuery.append("order_code_id,package_id,sou_source_code_id,upsell_type,upsell_condition,script_text)");
		addUpSellQuery.append(" values(:upsell_id,:oc_id,:upsell_suggestion_id,:calendar_campaign_id,:source_code_id,");
		addUpSellQuery
				.append(":order_code_id,:package_id,:sou_source_code_id,:upsell_type,:upsell_condition,:script_text)");

		try {
			sourceIdResult = jdbcTemplate.queryForObject("select MAX(upsell_id) from upsell", String.class);
			if (sourceIdResult == null) {
				addSourceParams.put("upsell_id", 1);// if table upsell_id column is null then add 1 to first record
			} else {
				addSourceParams.put("upsell_id", Integer.parseInt(sourceIdResult) + 1);
			}
			addSourceParams.put("oc_id", upSellModel.getOcId());
			addSourceParams.put("upsell_suggestion_id",
					upSellModel.getUpsellSuggestionId() != 0 ? upSellModel.getUpsellSuggestionId() : null);
			addSourceParams.put("calendar_campaign_id",
					upSellModel.getCalendarCampainId() != 0 ? upSellModel.getCalendarCampainId() : null);
			addSourceParams.put("source_code_id", upSellModel.getSourceCodeId());
			addSourceParams.put("order_code_id",
					upSellModel.getOrderCodeId() != 0 ? upSellModel.getOrderCodeId() : null);
			addSourceParams.put("package_id", upSellModel.getPackageId() != 0 ? upSellModel.getPackageId() : null);
			addSourceParams.put("sou_source_code_id",
					upSellModel.getSouSourceCodeId() != 0 ? upSellModel.getSouSourceCodeId() : null);
			addSourceParams.put("upsell_type", upSellModel.getUpsellType());
			addSourceParams.put("upsell_condition", upSellModel.getUpsellCondition());
			addSourceParams.put("script_text", upSellModel.getScriptText() != "" ? upSellModel.getScriptText() : null);

			status = namedParameterJdbcTemplate.update(addUpSellQuery.toString(), addSourceParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	/**
	 * This method fetches all records from upsell table based on oc_id
	 */
	@Override
	public List<UpSellModel> getUpSellTableDetails(Integer ocId, Integer upsellId) {
		List<UpSellModel> upSellDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder("select * from upsell where oc_id=");
		// StringBuilder query = new StringBuilder("select
		// source_code,source_code.description from source_code inner join upsell on
		// upsell.source_code_id=source_code.source_code_id where source_code.oc_id=");
		query.append(ocId);
		query.append(" and upsell_id=");
		query.append(upsellId);
		try {
			// if query fire into database successfully then returns list of upsell table's
			// records otherwise null
			upSellDetails = jdbcTemplate.query(query.toString(), new UpsellMapper());
			// upSellDetails = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return upSellDetails;
	}

	@Override
	public List<Map<String, Object>> getUpSellDetails(Integer ocId, Integer upsellId) {
		List<Map<String, Object>> upSellDetails = new ArrayList<>();
		/*
		 * StringBuilder query = new
		 * StringBuilder("select order_code.order_code as order_code,order_code.description as order_code_description,source_code as source_code,source_code.description as source_code_description,upsell_suggestion.description as upsell_suggestion_description,"
		 * ); query.
		 * append(" case when upsell.upsell_type=0 then 'Upsell' else 'Crosss-Sell' end as upsell_type,"
		 * ); query.append(" case when upsell.upsell_condition=0 then 'Always'");
		 * query.append(" when upsell.upsell_condition=1 then 'Active Order'"); query.
		 * append(" when upsell.upsell_condition=2 then 'No Previous'  else 'Expired Order' end as upsell_condition,"
		 * ); query.
		 * append(" calendar_campaign.campaign as calendar_campaign_description,script_text from order_code"
		 * ); query.
		 * append(" inner join upsell on upsell.order_code_id =order_code.order_code_id"
		 * ); query.
		 * append(" inner join source_code on source_code.source_code_id=upsell.source_code_id"
		 * ); query.
		 * append(" inner join upsell_suggestion on upsell_suggestion.upsell_suggestion_id=upsell.upsell_suggestion_id"
		 * ); query.
		 * append(" inner join calendar_campaign on calendar_campaign.calendar_campaign_id=upsell.calendar_campaign_id"
		 * ); query.append(" where upsell.oc_id="); query.append(ocId);
		 * query.append(" and upsell_id="); query.append(upsellId);
		 */
		StringBuilder query = new StringBuilder(
				"select order_code.order_code_id,order_code.order_code as order_code,order_code.description as order_code_description,source_code.source_code_id,source_code as source_code,source_code.description as source_code_description,upsell_suggestion.upsell_suggestion_id as upsell_suggestion_id,");
		query.append(" upsell.upsell_type,");
		query.append(" upsell.upsell_condition as upsell_condition,calendar_campaign.calendar_campaign_id,");
		query.append(" calendar_campaign.campaign as calendar_campaign_description,script_text from order_code");
		query.append(" inner join upsell on upsell.order_code_id =order_code.order_code_id");
		query.append(" inner join source_code on source_code.source_code_id=upsell.source_code_id");
		query.append(
				" inner join upsell_suggestion on upsell_suggestion.upsell_suggestion_id=upsell.upsell_suggestion_id");
		query.append(
				" inner join calendar_campaign on calendar_campaign.calendar_campaign_id=upsell.calendar_campaign_id");
		query.append(" where upsell.oc_id=");
		query.append(ocId);
		query.append(" and upsell_id=");
		query.append(upsellId);
		try {
			upSellDetails = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upSellDetails;
	}

	/**
	 * This method fetches all records from upsell table
	 */
	@Override
	public List<UpSellModel> getUpSellTableData() {
		List<UpSellModel> upSellTableData = new ArrayList<>();

		try {
			upSellTableData = jdbcTemplate.query("select * from upsell", new UpsellMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upSellTableData;
	}

	@Override
	public List<DropdownModel> getSuggestionList() {
		List<Map<String, Object>> suggestionList = null;
		List<DropdownModel> suggestionDataList = null;
		DropdownModel model = null;
		String suggestionQuery = null;
		try {
			suggestionList = new ArrayList<>();
			suggestionDataList = new ArrayList<>();
			suggestionQuery = "select upsell_suggestion_id,description from upsell_suggestion";

			suggestionList = jdbcTemplate.queryForList(suggestionQuery);
			for (Map<String, Object> suggestion : suggestionList) {
				model = new DropdownModel();
				model.setKey(suggestion.get("upsell_suggestion_id").toString());
				// model.setDisplay(suggestion.get("upsell_suggestion_id") + "-" +
				// suggestion.get("description"));
				model.setDisplay(suggestion.get("description") != null ? (String) suggestion.get("description") : "");
				suggestionDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return suggestionDataList;
	}

	/*
	 * public List<DropdownModel> getCompaignList() { List<Map<String, Object>>
	 * compaignList = null; List<DropdownModel> compaignDataList = null; String
	 * compaignQuery = null; DropdownModel model = null;
	 * 
	 * try{ compaignList =new ArrayList<>(); compaignDataList =new ArrayList<>();
	 * compaignQuery =
	 * "select calendar_campaign_id,campaign,begin_day,begin_month,end_day,end_month from calendar_campaign"
	 * ;
	 * 
	 * compaignList = jdbcTemplate.queryForList(compaignQuery);
	 * for(Map<String,Object>compaign:compaignList){ model = new DropdownModel();
	 * model.setKey(compaign.get("calendar_campaign_id").toString());
	 * //model.setDisplay("calendar_campaign#: "+" (id: "+
	 * compaign.get("calendar_campaign_id") + ", campaign: " +
	 * compaign.get("campaign")+
	 * ", begin_day: "+compaign.get("begin_day")+", begin_month: "+compaign.get(
	 * "begin_month")+
	 * ", end_day: "+compaign.get("end_day")+", end_month: "+compaign.get(
	 * "end_month")+")"); model.setDescription(compaign.get("campaign").toString());
	 * model.setDisplay("[ Begin day: "+compaign.get("begin_day")+", Begin month:"
	 * +new
	 * PropertyUtils().getConstantValue("begin_month_"+compaign.get("begin_month"))+
	 * ", End day: "+compaign.get("end_day")+", End month:"+new
	 * PropertyUtils().getConstantValue("end_month_"+compaign.get("end_month"))+"]")
	 * ; compaignDataList.add(model); }
	 * 
	 * }catch(Exception e) {
	 * 
	 * LOGGER.error(ERROR+e); } return compaignDataList; }
	 */
	@Override
	public List<CalendarCampaignModel> getCompaignList() {
		List<CalendarCampaignModel> compaignList = new ArrayList<>();
		String compaignQuery = "select calendar_campaign_id,campaign,begin_day,begin_month,end_day,end_month from calendar_campaign";
		try {
			compaignList = jdbcTemplate.query(compaignQuery, new CalendarCompaignMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return compaignList;
	}

	@Override
	public List<DropdownModel> getUpsellType() {
		List<DropdownModel> upsellType = new ArrayList<>();
		for (int i = 0; i <= 1; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			// model.setDisplay(i+"-"+new
			// PropertyUtils().getConstantValue("upsell_type_"+i));
			model.setDisplay(new PropertyUtils().getConstantValue("upsell_type_" + i));
			upsellType.add(model);
		}
		return upsellType;
	}

	@Override
	public List<DropdownModel> getConditionList() {
		List<DropdownModel> conditionList = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			// model.setDisplay(i+"-"+new
			// PropertyUtils().getConstantValue("upsell_condition_"+i));
			model.setDisplay(new PropertyUtils().getConstantValue("upsell_condition_" + i));
			conditionList.add(model);
		}
		return conditionList;
	}

	/**
	 * This method updates records in upsell table based on upsell_id
	 */
	@Override
	public int updateUpSellRecords(UpSellModel model) {

		StringBuilder query = new StringBuilder("update upsell set ");
		query.append("upsell_suggestion_id =:upsell_suggestion_id,");
		query.append("calendar_campaign_id =:calendar_campaign_id,");
		query.append("source_code_id =:source_code_id,");
		query.append("order_code_id =:order_code_id,");
		query.append("package_id =:package_id,");
		query.append("sou_source_code_id =:sou_source_code_id,");
		query.append("upsell_type =:upsell_type,");
		query.append("upsell_condition =:upsell_condition,");
		query.append("script_text =:script_text");
		query.append(" where upsell_id=:upsell_id");
		query.append(" and oc_id =:oc_id");
		int status = 0;
		Map<String, Object> updateParams = null;
		try {
			// if query fire into database successfully then status value will return 1
			// otherwise 0
			updateParams = new LinkedHashMap<>();
			updateParams.put("upsell_id", model.getUpsellId());
			updateParams.put("oc_id", model.getOcId());
			updateParams.put("upsell_suggestion_id",
					model.getUpsellSuggestionId() != 0 ? model.getUpsellSuggestionId() : null);
			updateParams.put("calendar_campaign_id",
					model.getCalendarCampainId() != 0 ? model.getCalendarCampainId() : null);
			updateParams.put("source_code_id", model.getSourceCodeId());
			updateParams.put("order_code_id", model.getOrderCodeId() != 0 ? model.getOrderCodeId() : null);
			updateParams.put("package_id", model.getPackageId() != 0 ? model.getPackageId() : null);
			updateParams.put("sou_source_code_id", model.getSouSourceCodeId() != 0 ? model.getSouSourceCodeId() : null);
			updateParams.put("upsell_type", model.getUpsellType());
			updateParams.put("upsell_condition", model.getUpsellCondition());
			updateParams.put("script_text", model.getScriptText() != "" ? model.getScriptText() : null);
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	/**
	 * This method deletes all records from upsell table based on upsell_id
	 */
	@Override
	public int deleteUpSellRecords(int upsellId) {
		int status = 0;
		String deleteUpsellQuery = "delete from upsell where upsell_id=?";
		try {
			// if query fire successfully then status value will be 1 otherwise 0
			status = jdbcTemplate.update(deleteUpsellQuery, Integer.valueOf(upsellId));
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;
	}

	@Override
	public List<OrderCodeModel> getOrderCodeTableData(int ocId) {
		List<OrderCodeModel> orderCodeTableData = null;
		StringBuilder query = new StringBuilder(
				"SELECT order_code_id,oc_id,user_code,commodity_code,active,order_code_type,description,item_type,prepayment_req,taxable,ship_weight,issue_id,pub_rotation_id,standord,grace_qty,audit_qual_category,perpetual_order,order_code,price,newsub_rate_class_id,discount_class_id,new_renewal_card_id,term_id,audit_qual_source_id,audit_subscription_type_id,audit_sales_channel_id,audit_name_title_id,media,edition,qty,product_size,product_style,product_color,disallow_install_billing,auto_renewal,sample_copy_order,subscription_category_id,revenue_method,start_type,auto_replace,unit_type_id,excess_rate_class_id,credit_card_process,allow_on_internet,trial_type,trial_period,auto_payment,is_proforma,unit_excess,segmented_order,row_version,backstart_tb_renewals,renew_as_proforma,premium,pkg_only_item,ship_premium_percentage,min_n_items,max_n_items,no_charge,controlled,place_anyway_if_cant_auth,settle_retry_def,item_url,image_url,electronic_delivery,time_unit_options,taxonomy,fulfillment_date,product_author,from_date,to_date,subscriber_site_short_desc,subscriber_site_long_desc,isbn,reinstate_proforma_on_removal,extfree_qty_limit,charge_shipping,is_addon,premium_order_code_id,installment_plan_id,installment_billing_only FROM order_code WHERE oc_id = ");
		query.append(ocId);
		try {
			orderCodeTableData = jdbcTemplate.query(query.toString(), new OrderCodeMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderCodeTableData;
	}

	/*
	 * @Override public List<OrderCodeModel> getOrderCodeDetails(int ocId, String
	 * orderCodeType) { List<OrderCodeModel> orderCodeDetails = new ArrayList<>();
	 * StringBuilder query = new
	 * StringBuilder("SELECT order_code_id,oc_id,user_code,commodity_code,active,order_code_type,description,item_type,prepayment_req,taxable,ship_weight,issue_id,pub_rotation_id,standord,grace_qty,audit_qual_category,perpetual_order,order_code,price,newsub_rate_class_id,discount_class_id,new_renewal_card_id,term_id,audit_qual_source_id,audit_subscription_type_id,audit_sales_channel_id,audit_name_title_id,media,edition,qty,product_size,product_style,product_color,disallow_install_billing,auto_renewal,sample_copy_order,subscription_category_id,revenue_method,start_type,auto_replace,unit_type_id,excess_rate_class_id,credit_card_process,allow_on_internet,trial_type,trial_period,auto_payment,is_proforma,unit_excess,segmented_order,row_version,backstart_tb_renewals,renew_as_proforma,premium,pkg_only_item,ship_premium_percentage,min_n_items,max_n_items,no_charge,controlled,place_anyway_if_cant_auth,settle_retry_def,item_url,image_url,electronic_delivery,time_unit_options,taxonomy,fulfillment_date,product_author,from_date,to_date,subscriber_site_short_desc,subscriber_site_long_desc,isbn,reinstate_proforma_on_removal,extfree_qty_limit,charge_shipping,is_addon,premium_order_code_id,installment_plan_id,installment_billing_only FROM order_code where oc_id="
	 * ); query.append(ocId); query.append(" and order_code_type=");
	 * query.append(orderCodeType); try{ orderCodeDetails =
	 * jdbcTemplate.query(query.toString(),new OrderCodeMapper()); }catch(Exception
	 * e){ LOGGER.error(ERROR+ e); } return orderCodeDetails; }
	 */

	@Override
	public List<Map<String, Object>> getOrderCodeDetails(Long ocId, Long orderCodeId) {
		List<Map<String, Object>> orderCodeDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT order_code_id,order_code.oc_id,order_code.user_code,commodity_code.commodity_code,commodity_code.description,order_code.active,order_code.order_code_type,order_code.description,order_code.settle_retry_def,item_type,prepayment_req,taxable,ship_weight,issue.issue_id,issue.issue_date,pub_rotation.pub_rotation_id,pub_rotation.description,standord,grace_qty,audit_qual_category,perpetual_order,order_code,price,rate_class.rate_class,rate_class.description,discount_class.discount_class,discount_class.description,");
		query.append(
				" renewal_card.renewal_card,renewal_card.description,term.term,term.description as termDescription,audit_subscription_type.audit_subscription_type_id,audit_subscription_type.description,media,edition,qty,product_size,product_style,product_color,order_code.disallow_install_billing,auto_renewal,sample_copy_order,subscription_category.subscription_category_id,subscription_category.description,order_code.start_type,auto_replace,unit_type.unit_type_id,unit_type.label,unit_type.description,excess_rate_class_id,credit_card_process,allow_on_internet,trial_type,trial_period,auto_payment,is_proforma,unit_excess,segmented_order,backstart_tb_renewals,renew_as_proforma,premium,pkg_only_item,ship_premium_percentage,min_n_items,max_n_items,no_charge,controlled,place_anyway_if_cant_auth,settle_retry_def.max_retries,settle_retry_def.n_days_between_retries,item_url,settle_retry_def.description,image_url,electronic_delivery,time_unit_options,taxonomy.taxonomy,taxonomy.description,fulfillment_date,product_author,from_date,to_date,order_code.subscriber_site_short_desc,order_code.subscriber_site_long_desc,isbn,reinstate_proforma_on_removal,extfree_qty_limit,charge_shipping,is_addon,premium_order_code_id,installment_plan_id,installment_billing_only FROM order_code");
		query.append(" left join oc on oc.oc_id = order_code.oc_id");
		query.append(" left join user_code on user_code.user_code = order_code.user_code");
		query.append(" left join commodity_code on order_code.commodity_code = commodity_code.commodity_code");
		query.append(" left join issue on order_code.issue_id = issue.issue_id");
		query.append(" left join rate_class on order_code.newsub_rate_class_id = rate_class.rate_class_id");
		query.append(" left join discount_class on order_code.discount_class_id = discount_class.discount_class_id");
		query.append(" left join renewal_card on order_code.new_renewal_card_id = renewal_card.renewal_card_id ");
		query.append(" left join term on order_code.term_id = term.term_id");
		query.append(" left join unit_type on order_code.unit_type_id = unit_type.unit_type_id");
		query.append(" left join taxonomy on order_code.taxonomy = taxonomy.taxonomy");
		query.append(
				" left join subscription_category on order_code.subscription_category_id = subscription_category.subscription_category_id");
		query.append(" left join settle_retry_def on order_code.settle_retry_def = settle_retry_def.settle_retry_def");
		query.append(" left join pub_rotation on order_code.pub_rotation_id = pub_rotation.pub_rotation_id");
		query.append(
				" left join audit_subscription_type on order_code.audit_subscription_type_id = audit_subscription_type.audit_subscription_type_id");
		query.append(
				" left join audit_sales_channel on order_code.audit_sales_channel_id = audit_sales_channel.audit_sales_channel_id");
		query.append(
				" left join audit_qual_source on order_code.audit_qual_source_id = audit_qual_source.audit_qual_source_id");
		query.append(
				" left join audit_name_title on order_code.audit_name_title_id = audit_name_title.audit_name_title_id");
		query.append(" where order_code.oc_id = ");
		query.append(ocId);
		query.append(" and order_code_id=");
		query.append(orderCodeId);
		try {
			orderCodeDetails = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderCodeDetails;
	}

	@Override
	public int saveOrderCodeDetails(OrderCodeModel orderCodeModel) {
		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into order_code(order_code_id,oc_id,user_code,commodity_code,active,order_code_type,description,item_type,prepayment_req,taxable,ship_weight,issue_id,pub_rotation_id,standord,grace_qty,audit_qual_category,perpetual_order,order_code,price,newsub_rate_class_id,discount_class_id,new_renewal_card_id,term_id,audit_qual_source_id,audit_subscription_type_id,audit_sales_channel_id,audit_name_title_id,media,edition,qty,product_size,product_style,product_color,disallow_install_billing,auto_renewal,sample_copy_order,subscription_category_id,revenue_method,start_type,auto_replace,unit_type_id,excess_rate_class_id,credit_card_process,allow_on_internet,trial_type,trial_period,auto_payment,is_proforma,unit_excess,segmented_order,backstart_tb_renewals,renew_as_proforma,premium,pkg_only_item,ship_premium_percentage,min_n_items,max_n_items,mru_pkg_content_seq,mru_pkg_def_seq,mru_quick_order_content_seq,no_charge,controlled,place_anyway_if_cant_auth,settle_retry_def,item_url,image_url,electronic_delivery,time_unit_options,taxonomy,fulfillment_date,product_author,from_date,to_date,subscriber_site_short_desc,subscriber_site_long_desc,isbn,reinstate_proforma_on_removal,extfree_qty_limit,charge_shipping,is_addon,premium_order_code_id,installment_plan_id,installment_billing_only)");
		query.append(" values(:order_code_id,:oc_id,:user_code,:commodity_code,");
		query.append(
				":active,:order_code_type,:description,:item_type,:prepayment_req,:taxable,:ship_weight,:issue_id,:pub_rotation_id,");
		query.append(
				":standord,:grace_qty,:audit_qual_category,:perpetual_order,:order_code,:price,:newsub_rate_class_id,:discount_class_id,");
		query.append(
				":new_renewal_card_id,:term_id,:audit_qual_source_id,:audit_subscription_type_id,:audit_sales_channel_id,");
		query.append(
				":audit_name_title_id,:media,:edition,:qty,:product_size,:product_style,:product_color,:disallow_install_billing,:auto_renewal,");
		query.append(
				":sample_copy_order,:subscription_category_id,:revenue_method,:start_type,:auto_replace,:unit_type_id,:excess_rate_class_id,");
		query.append(
				":credit_card_process,:allow_on_internet,:trial_type,:trial_period,:auto_payment,:is_proforma,:unit_excess,:segmented_order,");
		query.append(
				":backstart_tb_renewals,:renew_as_proforma,:premium,:pkg_only_item,:ship_premium_percentage,:min_n_items,:max_n_items,");
		query.append(
				":mru_pkg_content_seq,:mru_pkg_def_seq,:mru_quick_order_content_seq,:no_charge,:controlled,:place_anyway_if_cant_auth,");
		query.append(
				":settle_retry_def,:item_url,:image_url,:electronic_delivery,:time_unit_options,:taxonomy,:fulfillment_date,:product_author,");
		query.append(
				":from_date,:to_date,:subscriber_site_short_desc,:subscriber_site_long_desc,:isbn,:reinstate_proforma_on_removal,:extfree_qty_limit,");
		query.append(
				":charge_shipping,:is_addon,:premium_order_code_id,:installment_plan_id,:installment_billing_only)");

		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			// This query fire at first time to check how many records is available in table
			/// and fetching max order_code_id and add 1 to next order_code_id record
			String maxOrderCodeId = jdbcTemplate.queryForObject("select MAX(order_code_id) from order_code",
					String.class);

			if (maxOrderCodeId == null) {
				addSourceParams.put("order_code_id", 1);// if table order_code_id column is null then add 1 to first
														// record
			} else {
				addSourceParams.put("order_code_id", Integer.parseInt(maxOrderCodeId) + 1);
			}
			addSourceParams.put("oc_id", orderCodeModel.getOcId());
			addSourceParams.put("user_code", orderCodeModel.getUserCode());
			if (("null".equals(orderCodeModel.getCommodityCode())) | ("".equals(orderCodeModel.getCommodityCode()))) {
				addSourceParams.put("commodity_code", null);
			} else {
				addSourceParams.put("commodity_code", orderCodeModel.getCommodityCode());
			}
			addSourceParams.put("active", orderCodeModel.getActive().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("order_code_type", orderCodeModel.getOrderCodeType());
			if (("null".equals(orderCodeModel.getDescription())) | ("".equals(orderCodeModel.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", orderCodeModel.getDescription());
			}
			addSourceParams.put("item_type", orderCodeModel.getItemType());
			addSourceParams.put("prepayment_req", orderCodeModel.getPrepaymentReq().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("taxable", orderCodeModel.getTaxable().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("ship_weight",
					orderCodeModel.getShipWeight() != null ? orderCodeModel.getShipWeight() : null);
			addSourceParams.put("issue_id", orderCodeModel.getIssueId() != null ? orderCodeModel.getIssueId() : null);
			addSourceParams.put("pub_rotation_id",
					orderCodeModel.getPubRotationId() != null ? orderCodeModel.getPubRotationId() : null);
			addSourceParams.put("standord", orderCodeModel.getStandord().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("grace_qty",
					orderCodeModel.getGraceQty() != null ? orderCodeModel.getGraceQty() : null);
			if (("null".equals(orderCodeModel.getAuditQualCategory()))
					| ("".equals(orderCodeModel.getAuditQualCategory()))) {
				addSourceParams.put("audit_qual_category", null);
			} else {
				addSourceParams.put("audit_qual_category", orderCodeModel.getAuditQualCategory());
			}
			addSourceParams.put("perpetual_order", orderCodeModel.getPerpetualOrder().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("order_code", orderCodeModel.getOrderCode());
			addSourceParams.put("price", orderCodeModel.getPrice() != null ? orderCodeModel.getPrice() : null);
			addSourceParams.put("newsub_rate_class_id",
					orderCodeModel.getNewsubRateClassId() != null ? orderCodeModel.getNewsubRateClassId() : null);
			addSourceParams.put("discount_class_id",
					orderCodeModel.getDiscountClassId() != null ? orderCodeModel.getDiscountClassId() : null);
			addSourceParams.put("new_renewal_card_id",
					orderCodeModel.getNewRenewalCardId() != null ? orderCodeModel.getNewRenewalCardId() : null);
			addSourceParams.put("term_id", orderCodeModel.getTermId() != null ? orderCodeModel.getTermId() : null);
			addSourceParams.put("audit_qual_source_id",
					orderCodeModel.getAuditQualSourceId() != null ? orderCodeModel.getAuditQualSourceId() : null);
			addSourceParams.put("audit_subscription_type_id",
					orderCodeModel.getAuditSubscriptionTypeId() != null ? orderCodeModel.getAuditSubscriptionTypeId()
							: null);
			addSourceParams.put("audit_sales_channel_id",
					orderCodeModel.getAuditSalesChannelId() != null ? orderCodeModel.getAuditSalesChannelId() : null);
			addSourceParams.put("audit_name_title_id",
					orderCodeModel.getAuditNameTitleId() != null ? orderCodeModel.getAuditNameTitleId() : null);
			if (("null".equals(orderCodeModel.getMedia())) | ("".equals(orderCodeModel.getMedia()))) {
				addSourceParams.put("media", null);
			} else {
				addSourceParams.put("media", orderCodeModel.getMedia());
			}
			if (("null".equals(orderCodeModel.getEdition())) | ("".equals(orderCodeModel.getEdition()))) {
				addSourceParams.put("edition", null);
			} else {
				addSourceParams.put("edition", orderCodeModel.getEdition());
			}
			addSourceParams.put("qty", orderCodeModel.getQty() != null ? orderCodeModel.getQty() : null);
			if (("null".equals(orderCodeModel.getProductSize())) | ("".equals(orderCodeModel.getProductSize()))) {
				addSourceParams.put("product_size", null);
			} else {
				addSourceParams.put("product_size", orderCodeModel.getProductSize());
			}
			if (("null".equals(orderCodeModel.getProductStyle())) | ("".equals(orderCodeModel.getProductStyle()))) {
				addSourceParams.put("product_style", null);
			} else {
				addSourceParams.put("product_style", orderCodeModel.getProductStyle());
			}
			if (("null".equals(orderCodeModel.getProductColor())) | ("".equals(orderCodeModel.getProductColor()))) {
				addSourceParams.put("product_color", null);
			} else {
				addSourceParams.put("product_color", orderCodeModel.getProductColor());
			}
			addSourceParams.put("disallow_install_billing",
					orderCodeModel.getDisallowInstallBilling().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("auto_renewal", orderCodeModel.getAutoRenewal().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("sample_copy_order",
					orderCodeModel.getSampleCopyOrder().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("subscription_category_id",
					orderCodeModel.getSubscriptionCategoryId() != null ? orderCodeModel.getSubscriptionCategoryId()
							: null);
			addSourceParams.put("revenue_method", orderCodeModel.getRevenueMethod());
			addSourceParams.put("start_type", orderCodeModel.getStartType());
			addSourceParams.put("auto_replace", orderCodeModel.getAutoReplace().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("unit_type_id",
					orderCodeModel.getUnitTypeId() != null ? orderCodeModel.getUnitTypeId() : null);
			addSourceParams.put("excess_rate_class_id",
					orderCodeModel.getExcessRateClassId() != null ? orderCodeModel.getExcessRateClassId() : null);
			addSourceParams.put("credit_card_process", orderCodeModel.getCreditCardProcess());
			addSourceParams.put("allow_on_internet",
					orderCodeModel.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("trial_type", orderCodeModel.getTrialType());
			addSourceParams.put("trial_period",
					orderCodeModel.getTrialPeriod() != null ? orderCodeModel.getTrialPeriod() : null);
			addSourceParams.put("auto_payment", orderCodeModel.getAutoPayment().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("is_proforma", orderCodeModel.getIsProforma().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("unit_excess", orderCodeModel.getUnitExcess());
			addSourceParams.put("segmented_order", orderCodeModel.getSegmentedOrder().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("backstart_tb_renewals",
					orderCodeModel.getBackstartTbRenewals().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("renew_as_proforma",
					orderCodeModel.getRenewAsProforma().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium", orderCodeModel.getPremium());
			addSourceParams.put("pkg_only_item", orderCodeModel.getPkgOnlyItem().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("ship_premium_percentage",
					orderCodeModel.getShipPremiumPercentage() != null ? orderCodeModel.getShipPremiumPercentage()
							: null);
			addSourceParams.put("min_n_items",
					orderCodeModel.getMinNitems() != null ? orderCodeModel.getMinNitems() : null);
			addSourceParams.put("max_n_items",
					orderCodeModel.getMaxNitems() != null ? orderCodeModel.getMaxNitems() : null);
			addSourceParams.put("mru_pkg_content_seq",
					orderCodeModel.getMruPkgContentSeq() != null ? orderCodeModel.getMruPkgContentSeq() : null);
			addSourceParams.put("mru_pkg_def_seq",
					orderCodeModel.getMruPkgDefSeq() != null ? orderCodeModel.getMruPkgDefSeq() : null);
			addSourceParams.put("mru_quick_order_content_seq",
					orderCodeModel.getMruQuickOrderContentSeq() != null ? orderCodeModel.getMruQuickOrderContentSeq()
							: null);
			addSourceParams.put("no_charge", orderCodeModel.getNoCharge().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("controlled", orderCodeModel.getControlled().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("place_anyway_if_cant_auth",
					orderCodeModel.getPlaceAnywayIfCantAuth().equalsIgnoreCase("true") ? 1 : 0);
			if (("null".equals(orderCodeModel.getSettleRetryDef())) | ("".equals(orderCodeModel.getSettleRetryDef()))) {
				addSourceParams.put("settle_retry_def", null);
			} else {
				addSourceParams.put("settle_retry_def", orderCodeModel.getSettleRetryDef());
			}
			if (("null".equals(orderCodeModel.getItemUrl())) | ("".equals(orderCodeModel.getItemUrl()))) {
				addSourceParams.put("item_url", null);
			} else {
				addSourceParams.put("item_url", orderCodeModel.getItemUrl());
			}
			if (("null".equals(orderCodeModel.getImageUrl())) | ("".equals(orderCodeModel.getImageUrl()))) {
				addSourceParams.put("image_url", null);
			} else {
				addSourceParams.put("image_url", orderCodeModel.getImageUrl());
			}
			addSourceParams.put("electronic_delivery",
					orderCodeModel.getElectronicDelivery().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("time_unit_options", orderCodeModel.getTimeUnitOptions());
			if (("null".equals(orderCodeModel.getTaxonomy())) | ("".equals(orderCodeModel.getTaxonomy()))) {
				addSourceParams.put("taxonomy", null);
			} else {
				addSourceParams.put("taxonomy", orderCodeModel.getTaxonomy());
			}
			if (("null".equals(orderCodeModel.getFulfillmentDate()))
					| ("".equals(orderCodeModel.getFulfillmentDate()))) {
				addSourceParams.put("fulfillment_date", null);
			} else {
				addSourceParams.put("fulfillment_date", orderCodeModel.getFulfillmentDate());
			}
			if (("null".equals(orderCodeModel.getProductAuthor())) | ("".equals(orderCodeModel.getProductAuthor()))) {
				addSourceParams.put("product_author", null);
			} else {
				addSourceParams.put("product_author", orderCodeModel.getProductAuthor());
			}
			if (("null".equals(orderCodeModel.getFromDate())) | ("".equals(orderCodeModel.getFromDate()))) {
				addSourceParams.put("from_date", null);
			} else {
				addSourceParams.put("from_date", orderCodeModel.getFromDate());
			}
			if (("null".equals(orderCodeModel.getToDate())) | ("".equals(orderCodeModel.getToDate()))) {
				addSourceParams.put("to_date", null);
			} else {
				addSourceParams.put("to_date", orderCodeModel.getToDate());
			}
			if (("null".equals(orderCodeModel.getSubscriberSiteShortDesc())
					| ("".equals(orderCodeModel.getSubscriberSiteShortDesc())))) {
				addSourceParams.put("subscriber_site_short_desc", null);
			} else {
				addSourceParams.put("subscriber_site_short_desc", orderCodeModel.getSubscriberSiteShortDesc());
			}
			if (("null".equals(orderCodeModel.getSubscriberSiteLongDesc()))
					| ("".equals(orderCodeModel.getSubscriberSiteLongDesc()))) {
				addSourceParams.put("subscriber_site_long_desc", null);
			} else {
				addSourceParams.put("subscriber_site_long_desc", orderCodeModel.getSubscriberSiteLongDesc());
			}
			if (("null".equals(orderCodeModel.getIsbn())) | ("".equals(orderCodeModel.getIsbn()))) {
				addSourceParams.put("isbn", null);
			} else {
				addSourceParams.put("isbn", orderCodeModel.getIsbn());
			}
			addSourceParams.put("reinstate_proforma_on_removal",
					orderCodeModel.getReinstateProformaOnRemoval().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("extfree_qty_limit",
					orderCodeModel.getExtfreeQtyLimit() != null ? orderCodeModel.getExtfreeQtyLimit() : null);
			addSourceParams.put("charge_shipping", orderCodeModel.getChargeShipping().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("is_addon", orderCodeModel.getIsAddon().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium_order_code_id",
					orderCodeModel.getPremiumOrderCodeId() != null ? orderCodeModel.getPremiumOrderCodeId() : null);
			addSourceParams.put("installment_plan_id",
					orderCodeModel.getInstallmentPlanId() != null ? orderCodeModel.getInstallmentPlanId() : null);
			addSourceParams.put("installment_billing_only",
					orderCodeModel.getInstallmentBillingOnly().equalsIgnoreCase("true") ? 1 : 0);


			addSourceParams.put("reinstate_proforma_on_removal", orderCodeModel.getReinstateProformaOnRemoval().equalsIgnoreCase("true")?1:0);
			addSourceParams.put("extfree_qty_limit", orderCodeModel.getExtfreeQtyLimit()!=null?orderCodeModel.getExtfreeQtyLimit():null);
			addSourceParams.put("charge_shipping", orderCodeModel.getChargeShipping().equalsIgnoreCase("true")?1:0);
			addSourceParams.put("is_addon", orderCodeModel.getIsAddon().equalsIgnoreCase("true")?1:0);
			addSourceParams.put("premium_order_code_id", orderCodeModel.getPremiumOrderCodeId()!=null?orderCodeModel.getPremiumOrderCodeId():null);
			addSourceParams.put("installment_plan_id", orderCodeModel.getInstallmentPlanId()!=null?orderCodeModel.getInstallmentPlanId():null);
			addSourceParams.put("installment_billing_only", orderCodeModel.getInstallmentBillingOnly().equalsIgnoreCase("true")?1:0);

			addSourceParams.put("reinstate_proforma_on_removal",
					orderCodeModel.getReinstateProformaOnRemoval().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("extfree_qty_limit",
					orderCodeModel.getExtfreeQtyLimit() != null ? orderCodeModel.getExtfreeQtyLimit() : null);
			addSourceParams.put("charge_shipping", orderCodeModel.getChargeShipping().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("is_addon", orderCodeModel.getIsAddon().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium_order_code_id",
					orderCodeModel.getPremiumOrderCodeId() != null ? orderCodeModel.getPremiumOrderCodeId() : null);
			addSourceParams.put("installment_plan_id",
					orderCodeModel.getInstallmentPlanId() != null ? orderCodeModel.getInstallmentPlanId() : null);
			addSourceParams.put("installment_billing_only",
					orderCodeModel.getInstallmentBillingOnly().equalsIgnoreCase("true") ? 1 : 0);
			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateOrderCodeDetails(OrderCodeModel orderCodeModel) {
		LOGGER.info("Inside updateOrderCodeRecords()");

		StringBuilder query = new StringBuilder("update order_code set ");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();

		//Map<String, Object> addSourceParams = new LinkedHashMap<>();;
		//Map<String, Object> addSourceParams = new LinkedHashMap<>();
		
		int status = 0;
		query.append("oc_id =:oc_id,user_code =:user_code,");
		query.append("commodity_code =:commodity_code,active =:active,order_code_type =:order_code_type,");
		query.append(
				"description =:description,item_type =:item_type,prepayment_req =:prepayment_req,taxable =:taxable,ship_weight =:ship_weight,");
		query.append(
				"issue_id =:issue_id,pub_rotation_id =:pub_rotation_id,standord =:standord,grace_qty =:grace_qty,audit_qual_category =:audit_qual_category,");
		query.append(
				"perpetual_order =:perpetual_order,order_code =:order_code,price =:price,newsub_rate_class_id =:newsub_rate_class_id,discount_class_id =:discount_class_id,");
		query.append(
				"new_renewal_card_id =:new_renewal_card_id,term_id =:term_id,audit_qual_source_id =:audit_qual_source_id,audit_subscription_type_id =:audit_subscription_type_id,");
		query.append(
				":audit_sales_channel_id =:audit_sales_channel_id,audit_name_title_id =:audit_name_title_id,media =:media,edition =:edition,qty =:qty,product_size =:product_size,");
		query.append(
				"product_style =:product_style,product_color =:product_color,disallow_install_billing =:disallow_install_billing,auto_renewal =:auto_renewal,");
		query.append(
				"sample_copy_order =:sample_copy_order,subscription_category_id =:subscription_category_id,revenue_method =:revenue_method,start_type =:start_type,auto_replace =:auto_replace,");
		query.append(
				"unit_type_id =:unit_type_id,excess_rate_class_id =:excess_rate_class_id,credit_card_process =:credit_card_process,allow_on_internet =:allow_on_internet,trial_type =:trial_type,");
		query.append(
				"trial_period =:trial_period,auto_payment =:auto_payment,is_proforma =:is_proforma,unit_excess =:unit_excess,segmented_order =:segmented_order,");
		query.append(
				"backstart_tb_renewals =:backstart_tb_renewals,renew_as_proforma =:renew_as_proforma,premium =:premium,pkg_only_item =:pkg_only_item,");
		query.append(
				"ship_premium_percentage =:ship_premium_percentage,min_n_items =:min_n_items,max_n_items =:max_n_items,");
		query.append(
				"mru_pkg_content_seq =:mru_pkg_content_seq,mru_pkg_def_seq =:mru_pkg_def_seq,mru_quick_order_content_seq =:mru_quick_order_content_seq,no_charge =:no_charge,controlled =:controlled,");
		query.append(
				"place_anyway_if_cant_auth =:place_anyway_if_cant_auth,settle_retry_def =:settle_retry_def,item_url =:item_url,image_url =:image_url,");
		query.append(
				"electronic_delivery =:electronic_delivery,time_unit_options =:time_unit_options,taxonomy =:taxonomy,fulfillment_date =:fulfillment_date,product_author =:product_author,");
		query.append(
				"from_date =:from_date,to_date =:to_date,subscriber_site_short_desc =:subscriber_site_short_desc,subscriber_site_long_desc =:subscriber_site_long_desc,");
		query.append(
				"isbn =:isbn,reinstate_proforma_on_removal =:reinstate_proforma_on_removal,extfree_qty_limit =:extfree_qty_limit,charge_shipping =:charge_shipping,");
		query.append(
				"is_addon =:is_addon,premium_order_code_id =:premium_order_code_id,installment_plan_id =:installment_plan_id,installment_billing_only =:installment_billing_only");
		query.append(" where order_code_id=:order_code_id");
		query.append(" and oc_id=:oc_id");
		try {
			addSourceParams.put("order_code_id", orderCodeModel.getOrderCodeId());
			addSourceParams.put("oc_id", orderCodeModel.getOcId());
			addSourceParams.put("user_code", orderCodeModel.getUserCode());
			if (("null".equals(orderCodeModel.getCommodityCode())) | ("".equals(orderCodeModel.getCommodityCode()))) {
				addSourceParams.put("commodity_code", null);
			} else {
				addSourceParams.put("commodity_code", orderCodeModel.getCommodityCode());
			}
			addSourceParams.put("active", orderCodeModel.getActive().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("order_code_type", orderCodeModel.getOrderCodeType());
			if (("null".equals(orderCodeModel.getDescription())) | ("".equals(orderCodeModel.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", orderCodeModel.getDescription());
			}
			addSourceParams.put("item_type", orderCodeModel.getItemType());
			addSourceParams.put("prepayment_req", orderCodeModel.getPrepaymentReq().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("taxable", orderCodeModel.getTaxable().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("ship_weight",
					orderCodeModel.getShipWeight() != null ? orderCodeModel.getShipWeight() : null);
			addSourceParams.put("issue_id", orderCodeModel.getIssueId() != null ? orderCodeModel.getIssueId() : null);
			addSourceParams.put("pub_rotation_id",
					orderCodeModel.getPubRotationId() != null ? orderCodeModel.getPubRotationId() : null);
			addSourceParams.put("standord", orderCodeModel.getStandord().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("grace_qty",
					orderCodeModel.getGraceQty() != null ? orderCodeModel.getGraceQty() : null);
			if (("null".equals(orderCodeModel.getAuditQualCategory()))
					| ("".equals(orderCodeModel.getAuditQualCategory()))) {
				addSourceParams.put("audit_qual_category", null);
			} else {
				addSourceParams.put("audit_qual_category", orderCodeModel.getAuditQualCategory());
			}
			addSourceParams.put("perpetual_order", orderCodeModel.getPerpetualOrder().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("order_code", orderCodeModel.getOrderCode());
			addSourceParams.put("price", orderCodeModel.getPrice() != null ? orderCodeModel.getPrice() : null);
			addSourceParams.put("newsub_rate_class_id",
					orderCodeModel.getNewsubRateClassId() != null ? orderCodeModel.getNewsubRateClassId() : null);
			addSourceParams.put("discount_class_id",
					orderCodeModel.getDiscountClassId() != null ? orderCodeModel.getDiscountClassId() : null);
			addSourceParams.put("new_renewal_card_id",
					orderCodeModel.getNewRenewalCardId() != null ? orderCodeModel.getNewRenewalCardId() : null);
			addSourceParams.put("term_id", orderCodeModel.getTermId() != null ? orderCodeModel.getTermId() : null);
			addSourceParams.put("audit_qual_source_id",
					orderCodeModel.getAuditQualSourceId() != null ? orderCodeModel.getAuditQualSourceId() : null);
			addSourceParams.put("audit_subscription_type_id",
					orderCodeModel.getAuditSubscriptionTypeId() != null ? orderCodeModel.getAuditSubscriptionTypeId()
							: null);
			addSourceParams.put("audit_sales_channel_id",
					orderCodeModel.getAuditSalesChannelId() != null ? orderCodeModel.getAuditSalesChannelId() : null);
			addSourceParams.put("audit_name_title_id",
					orderCodeModel.getAuditNameTitleId() != null ? orderCodeModel.getAuditNameTitleId() : null);
			if (("null".equals(orderCodeModel.getMedia())) | ("".equals(orderCodeModel.getMedia()))) {
				addSourceParams.put("media", null);
			} else {
				addSourceParams.put("media", orderCodeModel.getMedia());
			}
			if (("null".equals(orderCodeModel.getEdition())) | ("".equals(orderCodeModel.getEdition()))) {
				addSourceParams.put("edition", null);
			} else {
				addSourceParams.put("edition", orderCodeModel.getEdition());
			}
			addSourceParams.put("qty", orderCodeModel.getQty() != null ? orderCodeModel.getQty() : null);
			if (("null".equals(orderCodeModel.getProductSize())) | ("".equals(orderCodeModel.getProductSize()))) {
				addSourceParams.put("product_size", null);
			} else {
				addSourceParams.put("product_size", orderCodeModel.getProductSize());
			}
			if (("null".equals(orderCodeModel.getProductStyle())) | ("".equals(orderCodeModel.getProductStyle()))) {
				addSourceParams.put("product_style", null);
			} else {
				addSourceParams.put("product_style", orderCodeModel.getProductStyle());
			}
			if (("null".equals(orderCodeModel.getProductColor())) | ("".equals(orderCodeModel.getProductColor()))) {
				addSourceParams.put("product_color", null);
			} else {
				addSourceParams.put("product_color", orderCodeModel.getProductColor());
			}
			addSourceParams.put("disallow_install_billing",
					orderCodeModel.getDisallowInstallBilling().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("auto_renewal", orderCodeModel.getAutoRenewal().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("sample_copy_order",
					orderCodeModel.getSampleCopyOrder().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("subscription_category_id",
					orderCodeModel.getSubscriptionCategoryId() != null ? orderCodeModel.getSubscriptionCategoryId()
							: null);
			addSourceParams.put("revenue_method", orderCodeModel.getRevenueMethod());
			addSourceParams.put("start_type", orderCodeModel.getStartType());
			addSourceParams.put("auto_replace", orderCodeModel.getAutoReplace().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("unit_type_id",
					orderCodeModel.getUnitTypeId() != null ? orderCodeModel.getUnitTypeId() : null);
			addSourceParams.put("excess_rate_class_id",
					orderCodeModel.getExcessRateClassId() != null ? orderCodeModel.getExcessRateClassId() : null);
			addSourceParams.put("credit_card_process", orderCodeModel.getCreditCardProcess());
			addSourceParams.put("allow_on_internet",
					orderCodeModel.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("trial_type", orderCodeModel.getTrialType());
			addSourceParams.put("trial_period",
					orderCodeModel.getTrialPeriod() != null ? orderCodeModel.getTrialPeriod() : null);
			addSourceParams.put("auto_payment", orderCodeModel.getAutoPayment().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("is_proforma", orderCodeModel.getIsProforma().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("unit_excess", orderCodeModel.getUnitExcess());
			addSourceParams.put("segmented_order", orderCodeModel.getSegmentedOrder().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("backstart_tb_renewals",
					orderCodeModel.getBackstartTbRenewals().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("renew_as_proforma",
					orderCodeModel.getRenewAsProforma().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium", orderCodeModel.getPremium());
			addSourceParams.put("pkg_only_item", orderCodeModel.getPkgOnlyItem().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("ship_premium_percentage",
					orderCodeModel.getShipPremiumPercentage() != null ? orderCodeModel.getShipPremiumPercentage()
							: null);
			addSourceParams.put("min_n_items",
					orderCodeModel.getMinNitems() != null ? orderCodeModel.getMinNitems() : null);
			addSourceParams.put("max_n_items",
					orderCodeModel.getMaxNitems() != null ? orderCodeModel.getMaxNitems() : null);
			addSourceParams.put("mru_pkg_content_seq",
					orderCodeModel.getMruPkgContentSeq() != null ? orderCodeModel.getMruPkgContentSeq() : null);
			addSourceParams.put("mru_pkg_def_seq",
					orderCodeModel.getMruPkgDefSeq() != null ? orderCodeModel.getMruPkgDefSeq() : null);
			addSourceParams.put("mru_quick_order_content_seq",
					orderCodeModel.getMruQuickOrderContentSeq() != null ? orderCodeModel.getMruQuickOrderContentSeq()
							: null);
			addSourceParams.put("no_charge", orderCodeModel.getNoCharge().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("controlled", orderCodeModel.getControlled().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("place_anyway_if_cant_auth",
					orderCodeModel.getPlaceAnywayIfCantAuth().equalsIgnoreCase("true") ? 1 : 0);
			if (("null".equals(orderCodeModel.getSettleRetryDef())) | ("".equals(orderCodeModel.getSettleRetryDef()))) {
				addSourceParams.put("settle_retry_def", null);
			} else {
				addSourceParams.put("settle_retry_def", orderCodeModel.getSettleRetryDef());
			}
			if (("null".equals(orderCodeModel.getItemUrl())) | ("".equals(orderCodeModel.getItemUrl()))) {
				addSourceParams.put("item_url", null);
			} else {
				addSourceParams.put("item_url", orderCodeModel.getItemUrl());
			}
			if (("null".equals(orderCodeModel.getImageUrl())) | ("".equals(orderCodeModel.getImageUrl()))) {
				addSourceParams.put("image_url", null);
			} else {
				addSourceParams.put("image_url", orderCodeModel.getImageUrl());
			}
			addSourceParams.put("electronic_delivery",
					orderCodeModel.getElectronicDelivery().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("time_unit_options", orderCodeModel.getTimeUnitOptions());
			if (("null".equals(orderCodeModel.getTaxonomy())) | ("".equals(orderCodeModel.getTaxonomy()))) {
				addSourceParams.put("taxonomy", null);
			} else {
				addSourceParams.put("taxonomy", orderCodeModel.getTaxonomy());
			}
			if (("null".equals(orderCodeModel.getFulfillmentDate()))
					| ("".equals(orderCodeModel.getFulfillmentDate()))) {
				addSourceParams.put("fulfillment_date", null);
			} else {
				addSourceParams.put("fulfillment_date", orderCodeModel.getFulfillmentDate());
			}
			if (("null".equals(orderCodeModel.getProductAuthor())) | ("".equals(orderCodeModel.getProductAuthor()))) {
				addSourceParams.put("product_author", null);
			} else {
				addSourceParams.put("product_author", orderCodeModel.getProductAuthor());
			}
			if (("null".equals(orderCodeModel.getFromDate())) | ("".equals(orderCodeModel.getFromDate()))) {
				addSourceParams.put("from_date", null);
			} else {
				addSourceParams.put("from_date", orderCodeModel.getFromDate());
			}
			if (("null".equals(orderCodeModel.getToDate())) | ("".equals(orderCodeModel.getToDate()))) {
				addSourceParams.put("to_date", null);
			} else {
				addSourceParams.put("to_date", orderCodeModel.getToDate());
			}
			if (("null".equals(orderCodeModel.getSubscriberSiteShortDesc())
					| ("".equals(orderCodeModel.getSubscriberSiteShortDesc())))) {
				addSourceParams.put("subscriber_site_short_desc", null);
			} else {
				addSourceParams.put("subscriber_site_short_desc", orderCodeModel.getSubscriberSiteShortDesc());
			}
			if (("null".equals(orderCodeModel.getSubscriberSiteLongDesc()))
					| ("".equals(orderCodeModel.getSubscriberSiteLongDesc()))) {
				addSourceParams.put("subscriber_site_long_desc", null);
			} else {
				addSourceParams.put("subscriber_site_long_desc", orderCodeModel.getSubscriberSiteLongDesc());
			}
			if (("null".equals(orderCodeModel.getIsbn())) | ("".equals(orderCodeModel.getIsbn()))) {
				addSourceParams.put("isbn", null);
			} else {
				addSourceParams.put("isbn", orderCodeModel.getIsbn());
			}
			addSourceParams.put("reinstate_proforma_on_removal",
					orderCodeModel.getReinstateProformaOnRemoval().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("extfree_qty_limit",
					orderCodeModel.getExtfreeQtyLimit() != null ? orderCodeModel.getExtfreeQtyLimit() : null);
			addSourceParams.put("charge_shipping", orderCodeModel.getChargeShipping().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("is_addon", orderCodeModel.getIsAddon().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium_order_code_id",
					orderCodeModel.getPremiumOrderCodeId() != null ? orderCodeModel.getPremiumOrderCodeId() : null);
			addSourceParams.put("installment_plan_id",
					orderCodeModel.getInstallmentPlanId() != null ? orderCodeModel.getInstallmentPlanId() : null);
			addSourceParams.put("installment_billing_only",
					orderCodeModel.getInstallmentBillingOnly().equalsIgnoreCase("true") ? 1 : 0);
			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public String deleteOrderCodeDetails(int orderCodeId) {
		StringBuilder returnStatus = new StringBuilder();
		int status = 0;
		StringBuilder deleteOrderCodeQuery = new StringBuilder("delete order_code from order_code");
		deleteOrderCodeQuery
				.append(" left join source_code on order_code.order_code_id = source_code.premium_order_code_id");
		deleteOrderCodeQuery.append(" left join product on order_code.order_code_id = product.order_code_id");
		deleteOrderCodeQuery
				.append(" left join subscription_def on order_code.order_code_id  = subscription_def.order_code_id");
		deleteOrderCodeQuery.append(
				" left join ren_card_order_code on order_code.order_code_id = ren_card_order_code.order_code_id ");
		deleteOrderCodeQuery.append(" left join pkg_def on order_code.order_code_id = pkg_def.order_code_id");
		deleteOrderCodeQuery.append(
				" left join job_ren_offer_detail on order_code.order_code_id= job_ren_offer_detail.order_code_id ");
		deleteOrderCodeQuery.append(" left join order_item on order_code.order_code_id = order_item.order_code_id");
		deleteOrderCodeQuery.append(
				" left join promotion_hist_offer on order_code.order_code_id = promotion_hist_offer.order_code_id");
		deleteOrderCodeQuery.append(
				" left join promotion_card_offer on order_code.order_code_id= promotion_card_offer.order_code_id");
		deleteOrderCodeQuery.append(
				" left join work_promotion_offer on order_code.order_code_id= work_promotion_offer.order_code_id");
		deleteOrderCodeQuery.append(
				" left join order_code_install_plan on order_code.order_code_id = order_code_install_plan.order_code_id");
		deleteOrderCodeQuery.append(" left join upsell on order_code.order_code_id = upsell.order_code_id");
		deleteOrderCodeQuery
				.append(" left join deal_order_code on order_code.order_code_id = deal_order_code.order_code_id");
		deleteOrderCodeQuery
				.append(" left join catalog_content on order_code.order_code_id = catalog_content.order_code_id");
		deleteOrderCodeQuery
				.append(" left join generic_promotion on order_code.order_code_id = generic_promotion.order_code_id");
		deleteOrderCodeQuery.append(
				" left join order_code_dependencies on order_code.order_code_id = order_code_dependencies.order_code_id");
		deleteOrderCodeQuery.append(" left join pkg_content on order_code.order_code_id = pkg_content.order_code_id");
		deleteOrderCodeQuery.append(
				" left join quick_order_content on order_code.order_code_id = quick_order_content.order_code_id");
		deleteOrderCodeQuery
				.append(" left join sub_iss_hist_audit on order_code.order_code_id = sub_iss_hist_audit.order_code_id");
		deleteOrderCodeQuery.append(" where order_code.order_code_id = ");
		deleteOrderCodeQuery.append(orderCodeId);
		try {
			// if query fire successfully then status value will be 1 otherwise 0
			status = jdbcTemplate.update(deleteOrderCodeQuery.toString());
			returnStatus.append(status);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
		return returnStatus.toString();
	}

	@Override
	public List<DropdownModel> getInstallmentPlans() {
		List<Map<String, Object>> installmentPlans = new ArrayList<>();
		List<DropdownModel> installmentPlansList = new ArrayList<>();
		try {
			installmentPlans = jdbcTemplate.queryForList(
					"SELECT installment_plan_id,auto_setup,allow_default_usage FROM installment_plan ORDER BY installment_plan_id");
			for (Map<String, Object> plan : installmentPlans) {
				DropdownModel model = new DropdownModel();
				model.setKey(plan.get("installment_plan_id").toString());
				model.setDisplay(plan.get("auto_setup").toString());
				model.setDescription(plan.get("allow_default_usage").toString());
				installmentPlansList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return installmentPlansList;
	}

	@Override
	public List<DropdownModel> getAuditDefaults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DropdownModel> getCreditCardProcess() {
		List<DropdownModel> creditCardProcess = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("credit_card_process_" + i));
			creditCardProcess.add(model);
		}
		return creditCardProcess;
	}

	@Override
	public List<DropdownModel> getSettleRetryDef() {
		List<Map<String, Object>> settleRetryDef = new ArrayList<>();
		List<DropdownModel> settleRetryDefList = new ArrayList<>();
		try {
			settleRetryDef = jdbcTemplate.queryForList(
					"select settle_retry_def,description,max_retries,n_days_between_retries from settle_retry_def order by settle_retry_def");
			for (Map<String, Object> settleRetry : settleRetryDef) {
				DropdownModel model = new DropdownModel();
				model.setKey(settleRetry.get("settle_retry_def").toString());
				model.setDescription(
						settleRetry.get("description") != null ? settleRetry.get("description").toString() : "");
				model.setDisplay(settleRetry.get("max_retries").toString());
				model.setExtra(settleRetry.get("n_days_between_retries").toString());
				settleRetryDefList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return settleRetryDefList;
	}

	@Override
	public List<DropdownModel> getCommodityList() {
		List<DropdownModel> commodityList = new ArrayList<>();
		try {
			List<Map<String, Object>> commodities = jdbcTemplate
					.queryForList("select commodity_code,description from commodity_code ORDER BY commodity_code");
			for (Map<String, Object> commodity : commodities) {
				DropdownModel model = new DropdownModel();
				model.setKey(commodity.get("commodity_code").toString());
				model.setDisplay(commodity.get("description") != null ? commodity.get("description").toString() : "");
				commodityList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return commodityList;
	}

	@Override
	public List<Map<String, Object>> getRateClassDetails(Long ocId) {
		List<Map<String, Object>> discountRates = new ArrayList<>();
		try {
			discountRates = jdbcTemplate
					.queryForList("select rate_class,description,is_package from rate_class where oc_id=" + ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountRates;
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId) {
		List<Map<String, Object>> rateClassDetails = new ArrayList<>();
		List<DropdownModel> rateClassList = new ArrayList<>();
		// StringBuilder query = new StringBuilder("SELECT rate_class.* FROM rate_class
		// WHERE");
		StringBuilder query = new StringBuilder(
				"SELECT rate_class.rate_class_id,rate_class.rate_class,rate_class.description,o.oc,rate_class.is_package FROM rate_class inner join oc o on rate_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			appendOcId(ocId, query);
			status++;
			if (status != 0) {
				query.append(" and is_package = 0)");
				rateClassDetails = jdbcTemplate.queryForList(query.toString());
			}

			for (Map<String, Object> rate : rateClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(rate.get("rate_class_id").toString());
				model.setDisplay(rate.get("rate_class").toString());
				model.setDescription(rate.get("description") != null ? rate.get("description").toString() : "");
				model.setExtra(rate.get("is_package").toString());
				rateClassList.add(model);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateClassList;
	}

	// this recursive method finds all ocId and its parent oc id
	private void recursionForOcId(Long ocId, StringBuilder query) {

		List<OrderClassModel> subChildList = jdbcTemplate.query(
				"select oc_id,parent_oc_id,oc,oc_type,case when oc_id = (select max(oc_id) from oc) then 'true' else 'false' end as IsActive from oc where oc_id = ?",
				new Object[] { ocId }, new OrderClassMapper());
		for (OrderClassModel subChild : subChildList) {
			Long pOcId = subChild.getParentOcId();
			if (ocId != null && ocId != 0) {
				query.append("," + ocId);
			}
			if (pOcId == null) {
				query.append(")");
			}
			if (pOcId != null && pOcId != 0) {
				recursionForOcId(pOcId, query);
			}
		}
	}

// this method appends all ocId and parent oc id into query	
	public void appendOcId(Long ocId, StringBuilder query) {
		List<OrderClassModel> elementList = new ArrayList<>();
		try {
			// SELECT rate_class.* FROM rate_class WHERE (oc_id in (24,21,4) and is_package
			// = 0)
			elementList = jdbcTemplate.query(
					"select oc_id,parent_oc_id,oc,oc_type,case when oc_id = (select max(oc_id) from oc) then 'true' else 'false' end as IsActive from oc where oc_id = ?",
					new Object[] { ocId }, new OrderClassMapper());
			String rateClass = query.substring(7, 17);
			String discountClass = query.substring(7, 21);
			for (OrderClassModel element : elementList) {
				Long pOcId = element.getParentOcId();
				if (ocId != null && ocId != 0) {
					if (rateClass.equals("rate_class")) {
						query.append(" (rate_class.oc_id in (" + ocId);
					} else if (discountClass.equals("discount_class")) {
						query.append(" (discount_class.oc_id in (" + ocId);
					}

				}
				if (pOcId == null) {
					query.append(")");
				}
				if (pOcId != null && pOcId != 0) {
					recursionForOcId(pOcId, query);
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId, String rateClass) {
		List<Map<String, Object>> rateClassDetails = new ArrayList<>();
		List<DropdownModel> rateClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT rate_class.rate_class_id,rate_class.rate_class,rate_class.description,o.oc FROM rate_class inner join oc o on rate_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			if ("null".equals(rateClass) | "".equals(rateClass)) {
				appendOcId(ocId, query);
				status++;
			} else if ((!"null".equals(rateClass) && !"".equals(rateClass))) {
				query.append(" rate_class.rate_class=" + "'" + rateClass + "' and");
				appendOcId(ocId, query);
				status++;
			}
			if (status != 0) {
				query.append(" and is_package = 0)");
				rateClassDetails = jdbcTemplate.queryForList(query.toString());
			}
			for (Map<String, Object> rate : rateClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(rate.get("rate_class_id").toString());
				model.setDisplay(rate.get("rate_class").toString());
				model.setDescription(rate.get("description") != null ? rate.get("description").toString() : "");
				model.setExtra(rate.get("oc").toString());
				rateClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateClassList;
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId, String rateClass, String rateDescription) {
		List<Map<String, Object>> rateClassDetails = new ArrayList<>();
		List<DropdownModel> rateClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT rate_class.rate_class_id,rate_class.rate_class,rate_class.description,o.oc FROM rate_class inner join oc o on rate_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			if ((("null".equals(rateClass) && "".equals(rateClass))
					&& ("null".equals(rateDescription) && "".equals(rateDescription)))) {
				appendOcId(ocId, query);
				status++;
			} else if ((!"null".equals(rateClass) && !"".equals(rateClass))
					&& (!"null".equals(rateDescription) && !"".equals(rateDescription))) {
				query.append(" rate_class.rate_class=" + "'" + rateClass + "' and");
				query.append(" rate_class.description=" + "'" + rateDescription + "' and");
				appendOcId(ocId, query);
				status++;
			}
			if (status != 0) {
				query.append(" and is_package = 0)");
				rateClassDetails = jdbcTemplate.queryForList(query.toString());
			}
			for (Map<String, Object> rate : rateClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(rate.get("rate_class_id").toString());
				model.setDisplay(rate.get("rate_class").toString());
				model.setDescription(rate.get("description") != null ? rate.get("description").toString() : "");
				model.setExtra(rate.get("oc").toString());
				rateClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateClassList;
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId, Long rateClassId2) {
		List<Map<String, Object>> rateClassDetails = new ArrayList<>();
		List<DropdownModel> rateClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT rate_class.rate_class_id,rate_class.rate_class,rate_class.description,o.oc FROM rate_class inner join oc o on rate_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			Long rateClassId = rateClassId2 != null ? rateClassId2 : 0;
			if (rateClassId == 0) {
				appendOcId(ocId, query);
				status++;
			} else if (rateClassId != null && rateClassId != 0) {
				query.append(" rate_class.rate_class_id=" + rateClassId + " and ");
				appendOcId(ocId, query);
				status++;
			}
			if (status != 0) {
				query.append(" and is_package = 0)");
				rateClassDetails = jdbcTemplate.queryForList(query.toString());
			}
			for (Map<String, Object> rate : rateClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(rate.get("rate_class_id").toString());
				model.setDisplay(rate.get("rate_class").toString());
				model.setDescription(rate.get("description") != null ? rate.get("description").toString() : "");
				model.setExtra(rate.get("oc").toString());
				rateClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateClassList;
	}

	@Override
	public List<DropdownModel> getDiscountClassDetails(Long ocId) {
		List<Map<String, Object>> discountRates = new ArrayList<>();
		List<DropdownModel> discountList = new ArrayList<>();
		try {
			discountRates = jdbcTemplate.queryForList(
					"SELECT discount_class.discount_class_id,discount_class.discount_class,discount_class.description,discount_class.is_package "
							+ "_class inner join oc o on discount_class.oc_id=o.oc_id where discount_class.oc_id = "
							+ ocId);
			for (Map<String, Object> row : discountRates) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("discount_class_id").toString());
				model.setDisplay(row.get("discount_class").toString());
				model.setDescription(row.get("description") == null ? "" : (String) row.get("description"));
				model.setExtra(row.get("is_package").toString());
				discountList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountList;
	}

	// search discount class details by oc id
	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId) {
		List<Map<String, Object>> discountClassDetails = new ArrayList<>();
		List<DropdownModel> discountClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT discount_class.discount_class_id,discount_class.discount_class,discount_class.description,o.oc,discount_class.is_package FROM discount_class inner join oc o on discount_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			appendOcId(ocId, query);
			status++;
			if (status != 0) {
				query.append(" and is_package = 0)");
				discountClassDetails = jdbcTemplate.queryForList(query.toString());
			}

			for (Map<String, Object> discountRate : discountClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(discountRate.get("discount_class_id").toString());
				model.setDisplay(discountRate.get("discount_class").toString());
				model.setDescription(
						discountRate.get("description") != null ? discountRate.get("description").toString() : "");
				model.setExtra(discountRate.get("oc").toString() + "," + discountRate.get("is_package").toString());
				discountClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountClassList;
	}

	// search discount class details by oc id and discount class
	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId, String discountClass) {
		List<Map<String, Object>> rateClassDetails = new ArrayList<>();
		List<DropdownModel> discountClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT discount_class.discount_class_id,discount_class.discount_class,discount_class.description,o.oc FROM discount_class inner join oc o on discount_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			if ("null".equals(discountClass) | "".equals(discountClass)) {
				appendOcId(ocId, query);
				status++;
			} else if ((!"null".equals(discountClass) && !"".equals(discountClass))) {
				query.append(" discount_class.discount_class=" + "'" + discountClass + "' and");
				appendOcId(ocId, query);
				status++;
			}
			if (status != 0) {
				query.append(" and is_package = 0)");
				rateClassDetails = jdbcTemplate.queryForList(query.toString());
			}
			for (Map<String, Object> discountRate : rateClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(discountRate.get("discount_class_id").toString());
				model.setDisplay(discountRate.get("discount_class").toString());
				model.setDescription(
						discountRate.get("description") != null ? discountRate.get("description").toString() : "");
				model.setExtra(discountRate.get("oc").toString());
				discountClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountClassList;
	}

	// search discount class details by oc id,discount class and discount
	// description
	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId, String discountClass, String discountDescription) {
		List<Map<String, Object>> discountClassDetails = new ArrayList<>();
		List<DropdownModel> discountClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT discount_class.discount_class_id,discount_class.discount_class,discount_class.description,o.oc FROM discount_class inner join oc o on discount_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			if ((("null".equals(discountClass) && "".equals(discountClass))
					&& ("null".equals(discountDescription) && "".equals(discountDescription)))) {
				appendOcId(ocId, query);
				status++;
			} else if ((!"null".equals(discountClass) && !"".equals(discountClass))
					&& (!"null".equals(discountDescription) && !"".equals(discountDescription))) {
				query.append(" discount_class.discount_class=" + "'" + discountClass + "' and");
				query.append(" discount_class.description=" + "'" + discountDescription + "' and");
				appendOcId(ocId, query);
				status++;
			}
			if (status != 0) {
				query.append(" and is_package = 0)");
				discountClassDetails = jdbcTemplate.queryForList(query.toString());
			}
			for (Map<String, Object> discountRate : discountClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(discountRate.get("discount_class_id").toString());
				model.setDisplay(discountRate.get("discount_class").toString());
				model.setDescription(
						discountRate.get("description") != null ? discountRate.get("description").toString() : "");
				model.setExtra(discountRate.get("oc").toString());
				discountClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountClassList;
	}

	// search discount class details by oc id and discount class id
	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId, Long discountClassId2) {
		List<Map<String, Object>> discountClassDetails = new ArrayList<>();
		List<DropdownModel> discountClassList = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT discount_class.discount_class_id,discount_class.discount_class,discount_class.description,o.oc FROM discount_class inner join oc o on discount_class.oc_id=o.oc_id where");
		int status = 0;
		try {
			Long discountClassId = discountClassId2 != null ? discountClassId2 : 0;
			if (discountClassId == 0) {
				appendOcId(ocId, query);
				status++;
			} else if (discountClassId != null && discountClassId != 0) {
				query.append(" discount_class.discount_class_id=" + discountClassId + " and ");
				appendOcId(ocId, query);
				status++;
			}
			if (status != 0) {
				query.append(" and is_package = 0)");
				discountClassDetails = jdbcTemplate.queryForList(query.toString());
			}
			for (Map<String, Object> discountRate : discountClassDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(discountRate.get("discount_class_id").toString());
				model.setDisplay(discountRate.get("discount_class").toString());
				model.setDescription(
						discountRate.get("description") != null ? discountRate.get("description").toString() : "");
				model.setExtra(discountRate.get("oc").toString());
				discountClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountClassList;
	}

	@Override
	public List<DropdownModel> getTaxonomyList() {
		List<DropdownModel> taxonomyList = new ArrayList<>();
		try {
			List<Map<String, Object>> taxonomies = jdbcTemplate
					.queryForList("select taxonomy,description from taxonomy");
			for (Map<String, Object> taxonomy : taxonomies) {
				DropdownModel model = new DropdownModel();
				model.setKey(taxonomy.get("taxonomy").toString());
				model.setDisplay(taxonomy.get("description") != null ? taxonomy.get("description").toString() : "");
				taxonomyList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return taxonomyList;
	}

	@Override
	public List<Map<String, Object>> getSingleIssueList(Long ocId) {
		List<Map<String, Object>> singleIssueList = new ArrayList<>();
		try {
			singleIssueList = jdbcTemplate.queryForList(
					"select issue_id,issue_date,enumeration,volume_group_id,analyzed,frozen,inventory_id from issue where oc_id="
							+ ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return singleIssueList;
	}

	// select
	// issue_id,issue_date,enumeration,volume_group_id,analyzed,frozen,inventory_id
	// from issue where oc_id=

	@Override
	public List<DropdownModel> getPremiumList() {
		List<DropdownModel> premiumList = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("premium_" + i));
			premiumList.add(model);
		}
		return premiumList;
	}

	@Override
	public List<DropdownModel> getUnitExcess() {
		List<DropdownModel> unitExcess = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("unit_excess_" + i));
			unitExcess.add(model);
		}
		return unitExcess;
	}

	@Override
	public List<DropdownModel> getUnitTypeList() {
		List<Map<String, Object>> unitType = new ArrayList<>();
		List<DropdownModel> unitTypeList = new ArrayList<>();
		try {
			unitType = jdbcTemplate
					.queryForList("select unit_type_id,label,description from unit_type  order by unit_type_id");
			for (Map<String, Object> unit : unitType) {
				DropdownModel model = new DropdownModel();
				model.setKey(unit.get("unit_type_id").toString());
				model.setDisplay(unit.get("label") != null ? unit.get("label").toString() : "");
				model.setDescription(unit.get("description") != null ? unit.get("description").toString() : "");
				unitTypeList.add(model);
			}
		} catch (Exception e) {
		}
		return unitTypeList;
	}

	@Override
	public List<DropdownModel> getTrialTypeList() {
		List<DropdownModel> trialTypeList = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("trial_type_" + i));
			trialTypeList.add(model);
		}
		return trialTypeList;
	}

	@Override
	public List<DropdownModel> getDefaultTerm() {
		List<DropdownModel> termList = new ArrayList<>();
		try {
			List<Map<String, Object>> terms = jdbcTemplate.queryForList("select term_id,term,description from term");
			for (Map<String, Object> term : terms) {
				DropdownModel model = new DropdownModel();
				model.setKey(term.get("term_id").toString());
				model.setDisplay(term.get("term").toString());
				model.setDescription(term.get("description") != null ? term.get("description").toString() : "");
				termList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return termList;
	}

	@Override
	public List<DropdownModel> getIssue(Long ocId) {
		List<Map<String, Object>> issueList = null;

		List<DropdownModel> issueDataList = new ArrayList<>();
		try {
			issueList = jdbcTemplate.queryForList(
					"select issue_id,issue_date,enumeration,enum_volume_nbr,analyzed,volume_group_id from issue where oc_id="
							+ ocId);
			for (Map<String, Object> issue : issueList) {
				DropdownModel model = new DropdownModel();
				model.setKey(issue.get("issue_id").toString());
				model.setDisplay(issue.get("issue_date").toString());
				model.setDescription(issue.get("enumeration") != null ? issue.get("enumeration").toString() : "");
				model.setExtra(issue.get("enum_volume_nbr") != null ? issue.get("enum_volume_nbr").toString()
						: "" + "," + issue.get("analyzed").toString() + "," + issue.get("analyzed").toString());
				issueDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return issueDataList;
	}

	@Override
	public List<Map<String, Object>> getPromotionCardDetails(Long ocId) {
		List<Map<String, Object>> promoCardList = new ArrayList<>();
		try {
			promoCardList = jdbcTemplate.queryForList(
					"select promotion_card_id,oc_id,promotion_card,description from promotion_card where oc_id="
							+ ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return promoCardList;
	}

	@Override
	public List<Map<String, Object>> getPromotionCardEffortDetails(Long promoCardId) {
		List<Map<String, Object>> promoCardEffortList = new ArrayList<>();
		try {
			promoCardEffortList = jdbcTemplate.queryForList(
					"select promotion_card_id,promotion_card_from_effort,to_effort,source_code_id,mru_promotion_card_offer_seq,discount_class_id,rate_class_id from promotion_card_from_effort where promotion_card_id="
							+ promoCardId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return promoCardEffortList;
	}

	@Override
	public List<Map<String, Object>> getPromotionCardOfferDetails(Long promoCardId, Long promoCardEffortId) {
		List<Map<String, Object>> promoCardOfferList = new ArrayList<>();
		try {
			promoCardOfferList = jdbcTemplate.queryForList(
					"select promotion_card_id,promotion_card_from_effort,promotion_card_offer_seq,rate_class_id,order_code_id,product_id,subscription_def_id,description,pkg_def_id from promotion_card_offer where promotion_card_id="
							+ promoCardId + " and promotion_card_from_effort=" + promoCardEffortId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return promoCardOfferList;
	}

	@Override
	public int savePromotionCardDetails(PromotionCard promotionCard) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into promotion_card(promotion_card_id,oc_id,promotion_card,description) values(:promotion_card_id,:oc_id,:promotion_card,:description)");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();

		try {
			String maxPromotionCardId = jdbcTemplate.queryForObject("select MAX(promotion_card_id) from promotion_card",
					String.class);
			if (maxPromotionCardId == null) {
				addSourceParams.put("promotion_card_id", 1);
			} else {
				addSourceParams.put("promotion_card_id", Integer.parseInt(maxPromotionCardId) + 1);
			}
			addSourceParams.put("oc_id", promotionCard.getOcId());
			addSourceParams.put("promotion_card", promotionCard.getPromotionCard());
			if (("null".equals(promotionCard.getDescription())) | ("".equals(promotionCard.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", promotionCard.getDescription());
			}
			namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getPromotionCardId() {
		int promotionCardId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(promotion_card_id) from promotion_card",
					String.class);
			if (maxId == null) {
				promotionCardId = 0;
			} else {
				promotionCardId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return promotionCardId;
	}

	@Override
	public int updatePromotionCardDetails(PromotionCard promotionCard) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update promotion_card set promotion_card =:promotion_card,description =:description where promotion_card_id =:promotion_card_id and oc_id =:oc_id");
		Map<String, Object> updateSourceParams = new LinkedHashMap<>();

		try {
			updateSourceParams.put("promotion_card_id", promotionCard.getPromotionCardId());
			updateSourceParams.put("oc_id", promotionCard.getOcId());
			updateSourceParams.put("promotion_card", promotionCard.getPromotionCard());
			if (("null".equals(promotionCard.getDescription())) | ("".equals(promotionCard.getDescription()))) {
				updateSourceParams.put("description", null);
			} else {
				updateSourceParams.put("description", promotionCard.getDescription());
			}
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int savePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into promotion_card_from_effort(promotion_card_from_effort,promotion_card_id,to_effort,source_code_id,mru_promotion_card_offer_seq,discount_class_id,rate_class_id) values(:promotion_card_from_effort,:promotion_card_id,:to_effort,:source_code_id,:mru_promotion_card_offer_seq,:discount_class_id,:rate_class_id)");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();

		try {
			String maxPromotionCardFromEffort = jdbcTemplate.queryForObject(
					"select MAX(promotion_card_from_effort) from promotion_card_from_effort", String.class);
			if (maxPromotionCardFromEffort == null) {
				addSourceParams.put("promotion_card_from_effort", 1);
			} else {
				addSourceParams.put("promotion_card_from_effort", Integer.parseInt(maxPromotionCardFromEffort) + 1);
			}
			addSourceParams.put("promotion_card_id", promotionCardEffort.getPromotionCardId());
			addSourceParams.put("to_effort",
					promotionCardEffort.getToEffort() != 0 ? promotionCardEffort.getToEffort() : null);
			addSourceParams.put("source_code_id", promotionCardEffort.getSourceCodeId());
			addSourceParams.put("mru_promotion_card_offer_seq",
					promotionCardEffort.getMruPromotionCardOfferSeq() != 0
							? promotionCardEffort.getMruPromotionCardOfferSeq()
							: null);
			addSourceParams.put("discount_class_id",
					promotionCardEffort.getDiscountClassId() != 0 ? promotionCardEffort.getDiscountClassId() : null);
			addSourceParams.put("rate_class_id",
					promotionCardEffort.getRateClassId() != 0 ? promotionCardEffort.getRateClassId() : null);
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getPromotionCardFromEffortId() {
		int PromotionCardEffortId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject(
					"select max(promotion_card_from_effort) from promotion_card_from_effort", String.class);
			if (maxId == null) {
				PromotionCardEffortId = 0;
			} else {
				PromotionCardEffortId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return PromotionCardEffortId;
	}

	@Override
	public int getPromotionCardOfferSeq() {
		int PromotionCardOfferSeq = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(promotion_card_offer_seq) from promotion_card_offer",
					String.class);
			if (maxId == null) {
				PromotionCardOfferSeq = 0;
			} else {
				PromotionCardOfferSeq = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return PromotionCardOfferSeq;
	}

	@Override
	public int updatePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"update promotion_card_from_effort set to_effort =:to_effort,source_code_id =:source_code_id,mru_promotion_card_offer_seq =:mru_promotion_card_offer_seq,discount_class_id =:discount_class_id,rate_class_id =:rate_class_id where promotion_card_from_effort =:promotion_card_from_effort and promotion_card_id =:promotion_card_id");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			addSourceParams.put("promotion_card_from_effort", promotionCardEffort.getPromotionCardEffortId());
			addSourceParams.put("promotion_card_id", promotionCardEffort.getPromotionCardId());
			addSourceParams.put("to_effort",
					promotionCardEffort.getToEffort() != 0 ? promotionCardEffort.getToEffort() : null);
			addSourceParams.put("source_code_id", promotionCardEffort.getSourceCodeId());
			addSourceParams.put("mru_promotion_card_offer_seq",
					promotionCardEffort.getMruPromotionCardOfferSeq() != 0
							? promotionCardEffort.getMruPromotionCardOfferSeq()
							: null);
			addSourceParams.put("discount_class_id",
					promotionCardEffort.getDiscountClassId() != 0 ? promotionCardEffort.getDiscountClassId() : null);
			addSourceParams.put("rate_class_id",
					promotionCardEffort.getRateClassId() != 0 ? promotionCardEffort.getRateClassId() : null);
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int savePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer) {
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder saveQuery = new StringBuilder(
					"insert into promotion_card_offer(promotion_card_offer_seq,promotion_card_id,promotion_card_from_effort,rate_class_id,order_code_id,product_id,subscription_def_id,description,pkg_def_id) values(:promotion_card_offer_seq,:promotion_card_id,:promotion_card_from_effort,:rate_class_id,:order_code_id,:product_id,:subscription_def_id,:description,:pkg_def_id)");
			String maxPromotionCardOfferSeq = jdbcTemplate
					.queryForObject("select MAX(promotion_card_offer_seq) from promotion_card_offer", String.class);
			int promotionCardId = promotionCardOffer.getPromotionCardId();
			int promotionCardEffortId = promotionCardOffer.getPromotionCardEffortId();
			if (maxPromotionCardOfferSeq == null) {
				addSourceParams.put("promotion_card_offer_seq", 1);
				updateMruPromotionCardOfferSeqColumn(promotionCardId, promotionCardEffortId);
			} else {
				addSourceParams.put("promotion_card_offer_seq", Integer.parseInt(maxPromotionCardOfferSeq) + 1);
				updateMruPromotionCardOfferSeqColumn(promotionCardId, promotionCardEffortId);
			}
			addSourceParams.put("promotion_card_id", promotionCardOffer.getPromotionCardId());
			addSourceParams.put("promotion_card_from_effort", promotionCardOffer.getPromotionCardEffortId());
			addSourceParams.put("rate_class_id",
					promotionCardOffer.getRateClassId() != 0 ? promotionCardOffer.getRateClassId() : null);
			addSourceParams.put("order_code_id", promotionCardOffer.getOrderCodeId());
			addSourceParams.put("product_id",
					promotionCardOffer.getProductId() != 0 ? promotionCardOffer.getProductId() : null);
			addSourceParams.put("subscription_def_id",
					promotionCardOffer.getSubscriptionDefId() != 0 ? promotionCardOffer.getSubscriptionDefId() : null);
			if (("null".equals(promotionCardOffer.getDescription()))
					| ("".equals(promotionCardOffer.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", promotionCardOffer.getDescription());
			}
			addSourceParams.put("pkg_def_id",
					promotionCardOffer.getPkgDefId() != 0 ? promotionCardOffer.getPkgDefId() : null);
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	public void updateMruPromotionCardOfferSeqColumn(int promotionCardId, int promotionCardEffortId) {
		String updatePromotionCardEffort = "update promotion_card_from_effort set mru_promotion_card_offer_seq=:mru_promotion_card_offer_seq where promotion_card_id="
				+ promotionCardId + " and promotion_card_from_effort=" + promotionCardEffortId;
		try {
			Map<String, Object> addOrderClassParams = new HashMap<>();
			String promotion_card_from_effort = jdbcTemplate.queryForObject(
					"select max(mru_promotion_card_offer_seq) from promotion_card_from_effort where promotion_card_id="
							+ promotionCardId + " and promotion_card_from_effort=" + promotionCardEffortId,
					String.class);
			addOrderClassParams.put("mru_promotion_card_offer_seq",
					promotion_card_from_effort != null ? Integer.valueOf(promotion_card_from_effort) + 1 : 1);
			addOrderClassParams.put("promotion_card_id", promotionCardId);
			addOrderClassParams.put("promotion_card_from_effort", promotionCardEffortId);
			namedParameterJdbcTemplate.update(updatePromotionCardEffort, addOrderClassParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int updatePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update promotion_card_offer set promotion_card_from_effort =:promotion_card_from_effort,rate_class_id =:rate_class_id,order_code_id =:order_code_id,product_id =:product_id,subscription_def_id =:subscription_def_id,description =:description,pkg_def_id =:pkg_def_id where promotion_card_offer_seq =:promotion_card_offer_seq and promotion_card_id =:promotion_card_id");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();

		try {
			addSourceParams.put("promotion_card_offer_seq", promotionCardOffer.getPromotionCardOfferSeq());
			addSourceParams.put("promotion_card_id", promotionCardOffer.getPromotionCardId());
			addSourceParams.put("promotion_card_from_effort", promotionCardOffer.getPromotionCardEffortId());
			addSourceParams.put("rate_class_id",
					promotionCardOffer.getRateClassId() != 0 ? promotionCardOffer.getRateClassId() : null);
			addSourceParams.put("order_code_id", promotionCardOffer.getOrderCodeId());
			addSourceParams.put("product_id",
					promotionCardOffer.getProductId() != 0 ? promotionCardOffer.getProductId() : null);
			addSourceParams.put("subscription_def_id",
					promotionCardOffer.getSubscriptionDefId() != 0 ? promotionCardOffer.getSubscriptionDefId() : null);
			if (("null".equals(promotionCardOffer.getDescription()))
					| ("".equals(promotionCardOffer.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", promotionCardOffer.getDescription());
			}
			addSourceParams.put("pkg_def_id",
					promotionCardOffer.getPkgDefId() != 0 ? promotionCardOffer.getPkgDefId() : null);
			status = namedParameterJdbcTemplate.update(updateQuery.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getRateCardCopyDetails(Integer rateClassId) {
		List<Map<String, Object>> rateClassEffectiveList = new ArrayList<>();
		// List<DropdownModel> rateCardCopyList = new ArrayList<>();
		try {
			rateClassEffectiveList = jdbcTemplate.queryForList(
					"select distinct rce.rate_class_id,rce.rate_class_effective_seq,description,effective_date from rate_class_effective as rce inner join ratecard on rce.rate_class_id = ratecard.rate_class_id and rce.rate_class_effective_seq = ratecard.rate_class_effective_seq where rce.rate_class_id="
							+ rateClassId);
			/*
			 * for(Map<String,Object>rate:rateClassEffectiveList) { DropdownModel model =
			 * new DropdownModel(); model.setKey(rate.get("rate_class_id").toString());
			 * model.setDisplay(rate.get("rate_class_effective_seq").toString());
			 * model.setDescription(rate.get("description").toString());
			 * model.setExtra(rate.get("effective_date").toString());
			 * rateCardCopyList.add(model); }
			 */
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateClassEffectiveList;
	}

	@Override
	public List<Map<String, Object>> getRateCardCopyList(Integer rateClassId, Integer rateClassEffectiveSeq) {
		List<Map<String, Object>> rateCardList = new ArrayList<>();
		try {
			rateCardList = jdbcTemplate.queryForList("select * from ratecard where rate_class_id=" + rateClassId
					+ " and rate_class_effective_seq=" + rateClassEffectiveSeq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateCardList;
	}

	@Override
	public List<Map<String, Object>> getRenewalCardDetails(Long ocId) {
		List<Map<String, Object>> renewalCardList = new ArrayList<>();
		try {
			renewalCardList = jdbcTemplate.queryForList(
					"select renewal_card_id,renewal_card,oc_id,description from renewal_card where oc_id = " + ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renewalCardList;
	}

	@Override
	public List<Map<String, Object>> getRenewalCardEffortDetails(Long renewalCardId) {
		List<Map<String, Object>> renewalCardEffortList = new ArrayList<>();
		try {
			renewalCardEffortList = jdbcTemplate.queryForList(
					"select renewal_card_id,renewal_card_from_effort,to_effort,mru_ren_card_order_code_seq from renewal_card_from_effort where renewal_card_id = "
							+ renewalCardId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renewalCardEffortList;
	}

	@Override
	public List<Map<String, Object>> getRenewalCardOfferDetails(Long renewalCardId, Long renewalCardEffortId) {
		List<Map<String, Object>> renewalCardOfferList = new ArrayList<>();
		try {
			renewalCardOfferList = jdbcTemplate.queryForList(
					"select renewal_card_id,renewal_card_from_effort,ren_card_order_code_seq,description,rate_class_id,term_id,subscription_def_id,order_code_id,pkg_def_id,default_offer,discount_class_id,source_code_id from ren_card_order_code where renewal_card_id = "
							+ renewalCardId + " and renewal_card_from_effort = " + renewalCardEffortId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renewalCardOfferList;
	}

	@Override
	public int getRenewalCardId() {
		int renewalCardId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(renewal_card_id) from renewal_card", String.class);
			if (maxId == null) {
				renewalCardId = 0;
			} else {
				renewalCardId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return renewalCardId;
	}

	@Override
	public int getRenewalCardEffortId(Integer renewalCardId) {
		int renewalCardEffortId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject(
					"select max(renewal_card_from_effort) from renewal_card_from_effort where renewal_card_id="
							+ renewalCardEffortId,
					String.class);
			if (maxId == null) {
				renewalCardEffortId = 0;
			} else {
				renewalCardEffortId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return renewalCardEffortId;
	}

	@Override
	public int getRenewalCardOfferSeq(Integer renewalCardId, Integer renewalCardEffortId) {
		int renewalCardOfferSeq = 0;
		try {
			String maxId = jdbcTemplate
					.queryForObject(
							"select MAX(ren_card_order_code_seq) from ren_card_order_code where renewal_card_id = "
									+ renewalCardId + " and renewal_card_from_effort = " + renewalCardEffortId,
							String.class);
			if (maxId == null) {
				renewalCardOfferSeq = 0;
			} else {
				renewalCardOfferSeq = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}

		return renewalCardOfferSeq;
	}

	@Override
	public int saveRenewalCardDetails(RenewalCard renewalCard) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into renewal_card(renewal_card_id,renewal_card,oc_id,description) values(:renewal_card_id,:renewal_card,:oc_id,:description)");
		Map<String, Object> addSourceParams = new HashMap<>();
		try {
			String maxRenewalCardId = jdbcTemplate.queryForObject("select MAX(renewal_card_id) from renewal_card",
					String.class);
			if (maxRenewalCardId == null) {
				addSourceParams.put("renewal_card_id", 1);
			} else {
				addSourceParams.put("renewal_card_id", Integer.parseInt(maxRenewalCardId) + 1);
			}
			addSourceParams.put("renewal_card", renewalCard.getRenewalCard());
			addSourceParams.put("oc_id", renewalCard.getOcId());
			if (("null".equals(renewalCard.getDescription())) | ("".equals(renewalCard.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", renewalCard.getDescription());
			}
			namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateRenewalCardDetails(RenewalCard renewalCard) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update renewal_card set renewal_card =:renewal_card,oc_id =:oc_id,description =:description where renewal_card_id =:renewal_card_id");
		Map<String, Object> updateSourceParams = new LinkedHashMap<>();

		try {
			updateSourceParams.put("renewal_card_id", renewalCard.getRenewalCardId());
			updateSourceParams.put("renewal_card", renewalCard.getRenewalCard());
			updateSourceParams.put("oc_id", renewalCard.getOcId());
			if (("null".equals(renewalCard.getDescription())) | ("".equals(renewalCard.getDescription()))) {
				updateSourceParams.put("description", null);
			} else {
				updateSourceParams.put("description", renewalCard.getDescription());
			}
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public String saveRenewalCardEffortDetails(RenewalCard renewalCard) {
		Map<String, Object> addSourceParams = new HashMap<>();
		StringBuilder status = new StringBuilder();
		try {
			// duplicate renewal_card_from_effort is not allowed
			int isDuplicateEffortId = jdbcTemplate.queryForObject(
					"select count(renewal_card_from_effort) from renewal_card_from_effort where renewal_card_id = "
							+ renewalCard.getRenewalCardId() + " and renewal_card_from_effort = "
							+ renewalCard.getRenewalCardEffortId(),
					Integer.class);
			if (isDuplicateEffortId == 0) {
				// StringBuilder saveQuery = new StringBuilder("insert into
				// renewal_card_from_effort(renewal_card_id,renewal_card_from_effort,to_effort,mru_ren_card_order_code_seq)
				// values(:renewal_card_id,:renewal_card_from_effort,:to_effort,:mru_ren_card_order_code_seq)");
				StringBuilder saveQuery = new StringBuilder(
						"insert into renewal_card_from_effort(renewal_card_id,renewal_card_from_effort,to_effort) values(:renewal_card_id,:renewal_card_from_effort,:to_effort)");
				addSourceParams.put("renewal_card_id", renewalCard.getRenewalCardId());
				addSourceParams.put("renewal_card_from_effort", renewalCard.getRenewalCardEffortId());
				addSourceParams.put("to_effort", renewalCard.getToEffort());
				// if(renewalCard.getMruRenCardOrderCodeSeq()!= null &&
				// renewalCard.getMruRenCardOrderCodeSeq() == 0 ) {
				// addSourceParams.put("mru_ren_card_order_code_seq", null);
				// }
				namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
				status.append("renewalCardEffortSave");
			} else {
				status.append("The duplicate key value is (" + renewalCard.getRenewalCardId() + ","
						+ renewalCard.getRenewalCardEffortId() + ")");

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status.toString();
	}

	@Override
	public String updateRenewalCardEffortDetails(RenewalCard renewalCard) {
		StringBuilder status = new StringBuilder();
		try {
			// duplicate renewal_card_from_effort is not allowed
			int isDuplicateEffortId = jdbcTemplate.queryForObject(
					"select count(renewal_card_from_effort) from renewal_card_from_effort where renewal_card_id = "
							+ renewalCard.getRenewalCardId() + " and renewal_card_from_effort = "
							+ renewalCard.getRenewalCardEffortId(),
					Integer.class);
			if (isDuplicateEffortId != 0) {
				String updateQuery = "update renewal_card_from_effort set renewal_card_from_effort ="
						+ renewalCard.getRenewalCardEffortId2() + ",to_effort =" + renewalCard.getToEffort()
						+ " where renewal_card_id =" + renewalCard.getRenewalCardId()
						+ " and renewal_card_from_effort =" + renewalCard.getRenewalCardEffortId();
				jdbcTemplate.update(updateQuery);
				status.append("renewalCardEffortUpdated");
			} else {
				status.append("The duplicate key value is (" + renewalCard.getRenewalCardId() + ","
						+ renewalCard.getRenewalCardEffortId() + ")");

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status.toString();
	}

	@Override
	public int saveRenewalCardOfferDetails(RenewalCard renewalCard) {
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into ren_card_order_code(renewal_card_id,renewal_card_from_effort,ren_card_order_code_seq,description,rate_class_id,term_id,subscription_def_id,order_code_id,pkg_def_id,default_offer,discount_class_id,source_code_id) values(:renewal_card_id,:renewal_card_from_effort,:ren_card_order_code_seq,:description,:rate_class_id,:term_id,:subscription_def_id,:order_code_id,:pkg_def_id,:default_offer,:discount_class_id,:source_code_id)");
		try {
			int renewalCardId = renewalCard.getRenewalCardId();
			int renewalCardEffortId = renewalCard.getRenewalCardEffortId();
			String maxRenCardOrderCodeSeq = jdbcTemplate
					.queryForObject(
							"select MAX(ren_card_order_code_seq) from ren_card_order_code where renewal_card_id = "
									+ renewalCardId + " and renewal_card_from_effort = " + renewalCardEffortId,
							String.class);
			if (maxRenCardOrderCodeSeq == null) {
				addSourceParams.put("ren_card_order_code_seq", 1);
				updateMruRenCardOrderCodeSeqColumn(renewalCardId, renewalCardEffortId);
			} else {
				addSourceParams.put("ren_card_order_code_seq", Integer.parseInt(maxRenCardOrderCodeSeq) + 1);
				updateMruRenCardOrderCodeSeqColumn(renewalCardId, renewalCardEffortId);
			}
			addSourceParams.put("renewal_card_id", renewalCard.getRenewalCardId());
			addSourceParams.put("renewal_card_from_effort", renewalCard.getRenewalCardEffortId());
			if (("null".equals(renewalCard.getDescription())) | ("".equals(renewalCard.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", renewalCard.getDescription());
			}
			addSourceParams.put("rate_class_id",
					renewalCard.getRateClassId() != null ? renewalCard.getRateClassId() : null);
			addSourceParams.put("term_id", renewalCard.getTermId() != null ? renewalCard.getTermId() : null);
			addSourceParams.put("subscription_def_id",
					renewalCard.getSubscriptionDefId() != null ? renewalCard.getSubscriptionDefId() : null);
			addSourceParams.put("order_code_id", renewalCard.getOrderCodeId());
			addSourceParams.put("pkg_def_id", renewalCard.getPkgDefId() != null ? renewalCard.getPkgDefId() : null);
			addSourceParams.put("default_offer",
					renewalCard.getDefaultOffer() != null ? renewalCard.getDefaultOffer() : 0);
			addSourceParams.put("discount_class_id",
					renewalCard.getDiscountClassId() != null ? renewalCard.getDiscountClassId() : null);
			addSourceParams.put("source_code_id",
					renewalCard.getSourceCodeId() != null ? renewalCard.getSourceCodeId() : null);
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	// update renewal_card_from_effort set mru_ren_card_order_code_seq=? where
	// renewal_card_id=? and renewal_card_from_effort=?
	public void updateMruRenCardOrderCodeSeqColumn(int renewalCardId, int renewalCardEffortId) {
		Map<String, Object> addOrderClassParams = new HashMap<>();
		String updateRenCardOrderCodeSeq = "update renewal_card_from_effort set mru_ren_card_order_code_seq=:mru_ren_card_order_code_seq where renewal_card_id="
				+ renewalCardId + " and renewal_card_from_effort=" + renewalCardEffortId;
		try {
			String mru_ren_card_order_code_seq = jdbcTemplate.queryForObject(
					"select max(mru_ren_card_order_code_seq) from renewal_card_from_effort where renewal_card_id="
							+ renewalCardId + " and renewal_card_from_effort=" + renewalCardEffortId,
					String.class);
			addOrderClassParams.put("mru_ren_card_order_code_seq",
					mru_ren_card_order_code_seq != null ? Integer.valueOf(mru_ren_card_order_code_seq) + 1 : 1);
			addOrderClassParams.put("renewal_card_id", renewalCardId);
			addOrderClassParams.put("renewal_card_from_effort", renewalCardEffortId);
			namedParameterJdbcTemplate.update(updateRenCardOrderCodeSeq, addOrderClassParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int updateRenewalCardOfferDetails(RenewalCard renewalCard) {
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder saveQuery = new StringBuilder(
					"update ren_card_order_code set description=:description,rate_class_id=:rate_class_id,term_id=:term_id,subscription_def_id=:subscription_def_id,order_code_id=:order_code_id,pkg_def_id=:pkg_def_id,default_offer=:default_offer,discount_class_id=:discount_class_id,source_code_id=:source_code_id where renewal_card_id=:renewal_card_id and (renewal_card_from_effort=:renewal_card_from_effort and ren_card_order_code_seq=:ren_card_order_code_seq)");
			addSourceParams.put("ren_card_order_code_seq", renewalCard.getRenCardOrderCodeSeq());
			addSourceParams.put("renewal_card_id", renewalCard.getRenewalCardId());
			addSourceParams.put("renewal_card_from_effort", renewalCard.getRenewalCardEffortId());
			if (("null".equals(renewalCard.getDescription())) | ("".equals(renewalCard.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", renewalCard.getDescription());
			}
			addSourceParams.put("rate_class_id",
					renewalCard.getRateClassId() != null ? renewalCard.getRateClassId() : null);
			addSourceParams.put("term_id", renewalCard.getTermId() != null ? renewalCard.getTermId() : null);
			addSourceParams.put("subscription_def_id",
					renewalCard.getSubscriptionDefId() != null ? renewalCard.getSubscriptionDefId() : null);
			addSourceParams.put("order_code_id", renewalCard.getOrderCodeId());
			addSourceParams.put("pkg_def_id", renewalCard.getPkgDefId() != null ? renewalCard.getPkgDefId() : null);
			addSourceParams.put("default_offer",
					renewalCard.getDefaultOffer() != null ? renewalCard.getDefaultOffer() : 0);
			addSourceParams.put("discount_class_id",
					renewalCard.getDiscountClassId() != null ? renewalCard.getDiscountClassId() : null);
			addSourceParams.put("source_code_id",
					renewalCard.getSourceCodeId() != null ? renewalCard.getSourceCodeId() : null);
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<DropdownModel> getPubRotationList(Long ocId) {
		List<Map<String, Object>> pubRotationList = new ArrayList<>();
		List<DropdownModel> pubRotationDataList = new ArrayList<>();
		try {
			pubRotationList = jdbcTemplate.queryForList(
					"select pub_rotation_id,oc_id,description,on_string,on_calendar_unit,on_day from pub_rotation where oc_id = "
							+ ocId);
			for (Map<String, Object> pubRotation : pubRotationList) {
				DropdownModel model = new DropdownModel();
				model.setKey(pubRotation.get("pub_rotation_id").toString());
				model.setDisplay(pubRotation.get("oc_id").toString());
				model.setDescription(
						pubRotation.get("description").toString() != null ? pubRotation.get("description").toString()
								: "");
				model.setExtra(pubRotation.get("on_calendar_unit").toString() + ","
						+ pubRotation.get("on_string").toString() != null
								? pubRotation.get("on_string").toString()
								: "" + "," + pubRotation.get("on_day").toString() != null
										? pubRotation.get("on_day").toString()
										: "");
				pubRotationDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return pubRotationDataList;
	}

	@Override
	public List<DropdownModel> getWebDetails(Long ocId, Long orderCodeId, String shortDescription,
			String longDescription) {
		List<DropdownModel> webDetails = new ArrayList<>();
		try {
			// when ocId is not null and orderCodeId,shortDescription and longDescription is
			// null
			if (ocId != null && (orderCodeId == null && ("".equals(shortDescription) && "".equals(longDescription)))) {
				List<Map<String, Object>> details = jdbcTemplate.queryForList(
						"SELECT subscriber_site_short_desc,subscriber_site_long_desc FROM oc WHERE oc_id = " + ocId
								+ " and subscriber_site_short_desc is not null and subscriber_site_long_desc is not null");
				for (Map<String, Object> detail : details) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("subscriber_site_short_desc") != null
							? detail.get("subscriber_site_short_desc").toString()
							: "");
					model.setDescription(detail.get("subscriber_site_long_desc") != null
							? detail.get("subscriber_site_long_desc").toString()
							: "");
					webDetails.add(model);
				}
			} else if (ocId != null && orderCodeId != null) {
				List<Map<String, Object>> details = jdbcTemplate.queryForList(
						"SELECT subscriber_site_short_desc,subscriber_site_long_desc FROM order_code WHERE oc_id = "
								+ ocId + " and order_code_id = " + orderCodeId);
				for (Map<String, Object> detail : details) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("subscriber_site_short_desc") != null
							? detail.get("subscriber_site_short_desc").toString()
							: "");
					model.setDescription(detail.get("subscriber_site_long_desc") != null
							? detail.get("subscriber_site_long_desc").toString()
							: "");
					webDetails.add(model);
				}
			} else if (orderCodeId != null && !("".equals(shortDescription) | shortDescription == null)) {
				List<Map<String, Object>> details = jdbcTemplate
						.queryForList("SELECT language_code,alternate_content FROM alternate_content WHERE key_part1 = "
								+ orderCodeId + " and column_name='subscriber_site_short_desc'");
				for (Map<String, Object> detail : details) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("language_code").toString());
					model.setDescription(
							detail.get("alternate_content") != null ? detail.get("alternate_content").toString() : "");
					webDetails.add(model);
				}
			} else if (orderCodeId != null && !("".equals(longDescription) | longDescription == null)) {
				List<Map<String, Object>> details = jdbcTemplate
						.queryForList("SELECT language_code,alternate_content FROM alternate_content WHERE key_part1 = "
								+ orderCodeId + " and column_name='subscriber_site_long_desc'");
				for (Map<String, Object> detail : details) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("language_code").toString());
					model.setDescription(
							detail.get("alternate_content") != null ? detail.get("alternate_content").toString() : "");
					webDetails.add(model);
				}
			} else if (ocId != null && !("".equals(shortDescription) | shortDescription == null)) {
				List<Map<String, Object>> details = jdbcTemplate
						.queryForList("SELECT language_code,alternate_content FROM alternate_content WHERE key_part1 = "
								+ ocId + " and column_name='subscriber_site_short_desc'");
				for (Map<String, Object> detail : details) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("language_code").toString());
					model.setDescription(
							detail.get("alternate_content") != null ? detail.get("alternate_content").toString() : "");
					webDetails.add(model);
				}
			} else if (ocId != null && !("".equals(longDescription) | longDescription == null)) {
				List<Map<String, Object>> details = jdbcTemplate
						.queryForList("SELECT language_code,alternate_content FROM alternate_content WHERE key_part1 = "
								+ ocId + " and column_name='subscriber_site_long_desc'");
				for (Map<String, Object> detail : details) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("language_code").toString());
					model.setDescription(
							detail.get("alternate_content") != null ? detail.get("alternate_content").toString() : "");
					webDetails.add(model);
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return webDetails;
	}

	@Override
	public List<DropdownModel> getTranslationDetails(Long ocId, Long orderCodeId, String action) {
		List<DropdownModel> descriptionList = new ArrayList<>();
		String action2 = action.toLowerCase();
		try {
			if (ocId != null && orderCodeId != null) {
				List<Map<String, Object>> shortAndLong = jdbcTemplate.queryForList(
						"SELECT subscriber_site_short_desc,subscriber_site_long_desc FROM order_code WHERE oc_id = "
								+ ocId + " and order_code_id = " + orderCodeId);
				for (Map<String, Object> detail : shortAndLong) {
					DropdownModel model = new DropdownModel();
					model.setDisplay(detail.get("subscriber_site_short_desc") != null
							? detail.get("subscriber_site_short_desc").toString()
							: "");
					model.setDescription(detail.get("subscriber_site_long_desc") != null
							? detail.get("subscriber_site_long_desc").toString()
							: "");
					descriptionList.add(model);
				}
			} else {
				switch (action2) {
				case "description":
					List<Map<String, Object>> details = jdbcTemplate.queryForList(
							"SELECT order_code.description,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where order_code_id = "
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : details) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("description") != null ? detail.get("description").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "description_def":
					action2 = "description";
					List<Map<String, Object>> descriptionDef = jdbcTemplate.queryForList(
							"select description, language_code, alternate_content FROM subscription_def LEFT JOIN alternate_content ON subscription_def.subscription_def_id = alternate_content.key_part1 where subscription_def_id="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "'and ((table_name='subscription_def') or (table_name is null))");
					for (Map<String, Object> detail : descriptionDef) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("description") != null ? detail.get("description").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "item":
					action2 = "item_url";
					List<Map<String, Object>> item_urls = jdbcTemplate.queryForList(
							"SELECT order_code.item_url,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where alternate_content.key_part1="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : item_urls) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("item_url") != null ? detail.get("item_url").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "image":
					action2 = "image_url";
					List<Map<String, Object>> image_urls = jdbcTemplate.queryForList(
							"SELECT order_code.image_url,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where alternate_content.key_part1="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : image_urls) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("image_url") != null ? detail.get("image_url").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "media":
					List<Map<String, Object>> medias = jdbcTemplate.queryForList(
							"SELECT order_code.media,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where alternate_content.key_part1="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : medias) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("media") != null ? detail.get("media").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "media_def":
					action2 = "media";
					List<Map<String, Object>> mediaDef = jdbcTemplate.queryForList(
							"select media, language_code, alternate_content FROM subscription_def LEFT JOIN alternate_content ON subscription_def.subscription_def_id = alternate_content.key_part1 where subscription_def_id="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "'and ((table_name='subscription_def') or (table_name is null))");
					for (Map<String, Object> detail : mediaDef) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("media") != null ? detail.get("media").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "tag_line":
					List<Map<String, Object>> tagLine = jdbcTemplate.queryForList(
							"SELECT subscription_def.tag_line,language_code,alternate_content FROM subscription_def left join alternate_content on  alternate_content.key_part1 =subscription_def.subscription_def_id where subscription_def_id ="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='subscription_def') or (table_name is null))");
					for (Map<String, Object> detail : tagLine) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("tag_line") != null ? detail.get("tag_line").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "edition":
					List<Map<String, Object>> editions = jdbcTemplate.queryForList(
							"SELECT order_code.edition,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where alternate_content.key_part1="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : editions) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("edition") != null ? detail.get("edition").toString() : "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "short":
					action2 = "subscriber_site_short_desc";
					List<Map<String, Object>> shorts = jdbcTemplate.queryForList(
							"SELECT order_code.subscriber_site_short_desc,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where alternate_content.key_part1="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : shorts) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("subscriber_site_short_desc") != null
								? detail.get("subscriber_site_short_desc").toString()
								: "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				case "long":
					action = "subscriber_site_long_desc";
					List<Map<String, Object>> longs = jdbcTemplate.queryForList(
							"SELECT order_code.subscriber_site_long_desc,language_code,alternate_content FROM order_code left join alternate_content on  alternate_content.key_part1 =order_code.order_code_id where alternate_content.key_part1="
									+ orderCodeId + " and alternate_content.column_name = '" + action2
									+ "' and ((table_name='order_code') or (table_name is null))");
					for (Map<String, Object> detail : longs) {
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("subscriber_site_long_desc") != null
								? detail.get("subscriber_site_long_desc").toString()
								: "");
						model.setDescription(detail.get("language_code").toString());
						model.setExtra(
								detail.get("alternate_content") != null ? detail.get("alternate_content").toString()
										: "");
						descriptionList.add(model);
					}
					break;
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return descriptionList;
	}

	@Override
	public List<DropdownModel> getLanguageList() {
		List<DropdownModel> languageList = new ArrayList<>();
		try {
			List<Map<String, Object>> langaugeData = jdbcTemplate
					.queryForList("select language_code,description from language_code");
			for (Map<String, Object> language : langaugeData) {
				DropdownModel model = new DropdownModel();
				model.setKey(language.get("language_code").toString());
				model.setDisplay(language.get("description") != null ? language.get("description").toString() : "");
				languageList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return languageList;
	}

	@Override
	public int saveWebDetails(AlternateContent alternateContent) {
		StringBuilder query = new StringBuilder(
				"insert into alternate_content(table_name,key_part1,key_part2,key_part3,column_name,language_code,alternate_content) values(:table_name,:key_part1,:key_part2,:key_part3,:column_name,:language_code,:alternate_content)");
		int status = 0;
		Map<String, Object> addParams = new HashMap<>();
		try {
			addParams.put("table_name", alternateContent.getTableName());
			addParams.put("key_part1", alternateContent.getKeyPart1());
			addParams.put("key_part2", alternateContent.getKeyPart2() != null ? alternateContent.getKeyPart2() : 0);
			addParams.put("key_part3", alternateContent.getKeyPart3() != null ? alternateContent.getKeyPart3() : 0);
			addParams.put("column_name", alternateContent.getColumnName());
			addParams.put("language_code", alternateContent.getLanguageCode());
			if (!"".equals(alternateContent.getAlternateContent())
					&& !"null".equals(alternateContent.getAlternateContent())) {
				addParams.put("alternate_content", alternateContent.getAlternateContent());
			} else {
				addParams.put("alternate_content", null);
			}
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateWebDetails(AlternateContent alternateContent) {
		StringBuilder query = new StringBuilder(
				"update alternate_content set language_code =:language_code,alternate_content =:alternate_content");
		query.append(" where key_part1=:key_part1 and language_code=:language_code");
		int status = 0;
		Map<String, Object> addParams = new HashMap<>();
		try {
			// addParams.put("table_name", alternateContent.getTableName());
			addParams.put("key_part1", alternateContent.getKeyPart1());
			// addParams.put("key_part2",
			// alternateContent.getKeyPart2()!=null?alternateContent.getKeyPart2():0);
			// addParams.put("key_part3",
			// alternateContent.getKeyPart3()!=null?alternateContent.getKeyPart3():0);
			// addParams.put("column_name", alternateContent.getColumnName());
			addParams.put("language_code", alternateContent.getLanguageCode());
			if (!"".equals(alternateContent.getAlternateContent())
					&& !"null".equals(alternateContent.getAlternateContent())) {
				addParams.put("alternate_content", alternateContent.getAlternateContent());
			} else {
				addParams.put("alternate_content", null);
			}
			status = namedParameterJdbcTemplate.update(query.toString(), addParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getGenericPromotionDefinition(Integer ocId, Integer sourceCodeId) {
		List<Map<String, Object>> genericPromotionDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"select oc.oc_id, source_code.source_code, order_code.order_code, order_code.description, subscription_def.subscription_def, pkg_def.pkg_def, product.product");
		query.append(
				", issue.issue_date,rate_class.rate_class, discount_class.discount_class, source_code.currency,generic_promotion.generated_price,generic_promotion.item_price,");
		query.append(
				" generic_promotion.source_code_id, generic_promotion.order_code_id,generic_promotion.subscription_def_id,generic_promotion.pkg_def_id,");
		query.append(
				" generic_promotion.product_id,generic_promotion.issue_id,generic_promotion.rate_class_id,generic_promotion.discount_class_id,");
		query.append(
				" source_code.source_code as EntryCode,source_code.description as sourceCodeDescription,source_code.active,source_code.from_date,source_code.to_date");
		query.append(" from generic_promotion as generic_promotion");
		query.append(
				" left join source_code as source_code on source_code.source_code_id=generic_promotion.source_code_id");
		query.append(" left join oc as oc on oc.oc_id=generic_promotion.oc_id");
		query.append(" left join order_code as order_code on order_code.order_code_id=generic_promotion.order_code_id");
		query.append(
				" left join subscription_def as subscription_def on subscription_def.subscription_def_id=generic_promotion.subscription_def_id");
		query.append(" left join rate_class as rate_class on rate_class.rate_class_id=generic_promotion.rate_class_id");
		query.append(
				" left join discount_class as discount_class on discount_class.discount_class_id=generic_promotion.discount_class_id");
		query.append(" left join pkg_def as pkg_def on pkg_def.pkg_def_id=generic_promotion.pkg_def_id");
		query.append(" left join product as product on product.product_id=generic_promotion.product_id");
		query.append(" left join issue as issue on issue.issue_id=generic_promotion.issue_id");
		if (sourceCodeId != null) {
			query.append(" where generic_promotion.oc_id=").append(ocId);
			query.append(" and source_code.source_code_id=").append(sourceCodeId);
		} else {
			query.append(" where generic_promotion.oc_id=").append(ocId);
		}

		try {
			genericPromotionDetails = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return genericPromotionDetails;
	}

	@Override
	public List<Map<String, Object>> getGenericPromotionCode(Integer sourceCodeId) {
		List<Map<String, Object>> genericPromotionCodeDetails = new ArrayList<>();
		try {
			genericPromotionCodeDetails = jdbcTemplate.queryForList(
					"select source_code_id,generic_promotion_code_seq,promotion_code,qty_limit,qty_used from generic_promotion_code where source_code_id="
							+ sourceCodeId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return genericPromotionCodeDetails;
	}

	@Override
	public List<DropdownModel> getOrderCodeDetails(Long ocId) {
		List<DropdownModel> orderCode = new ArrayList<>();
		try {
			List<Map<String, Object>> orderCodeData = jdbcTemplate.queryForList(
					"select order_code_id,order_code,description,order_code_type from order_code where oc_id=" + ocId);
			for (Map<String, Object> order : orderCodeData) {
				DropdownModel model = new DropdownModel();
				model.setKey(order.get("order_code_id").toString());
				model.setDisplay(order.get("order_code").toString());
				model.setDescription(order.get("description") != null ? order.get("description").toString() : "");
				model.setExtra(new PropertyUtils()
						.getConstantValue("order_code_type_" + order.get("order_code_type").toString()));
				orderCode.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderCode;
	}

	@Override
	public List<DropdownModel> getAgencyDetails() {
		List<DropdownModel> agencyList = new ArrayList<>();
		try {
			List<Map<String, Object>> agencyData = jdbcTemplate
					.queryForList("select customer_id,agency_code,company from agency");
			for (Map<String, Object> agency : agencyData) {
				DropdownModel model = new DropdownModel();
				model.setKey(agency.get("customer_id").toString());
				model.setDisplay(agency.get("agency_code").toString());
				model.setDescription(agency.get("company") != null ? (String) agency.get("company") : null);

				agencyList.add(model);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return agencyList;
	}

	@Override
	public List<DropdownModel> getShippingPriceList() {
		List<DropdownModel> shippingPriceList = new ArrayList<>();
		try {
			List<Map<String, Object>> shippingPrice = jdbcTemplate
					.queryForList("select shipping_price_list,description from shipping_price_list");
			for (Map<String, Object> shipping : shippingPrice) {
				DropdownModel model = new DropdownModel();
				model.setDisplay(shipping.get("shipping_price_list").toString());
				model.setDescription(shipping.get("description").toString());
				shippingPriceList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return shippingPriceList;
	}

	@Override
	public List<DropdownModel> getSourceCodeAttributeValue() {
		List<DropdownModel> sourceCodeAttributeValue = new ArrayList<>();
		try {
			List<Map<String, Object>> sourceCodeAttribute = jdbcTemplate.queryForList(
					" select source_attribute,source_attribute_value,description from source_attribute_value");
			for (Map<String, Object> sourceCode : sourceCodeAttribute) {
				DropdownModel model = new DropdownModel();
				model.setDisplay(sourceCode.get("source_attribute").toString());
				model.setDisplay(sourceCode.get("source_attribute_value").toString());
				model.setDescription(sourceCode.get("description").toString());
				sourceCodeAttributeValue.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeAttributeValue;
	}

	@Override
	public List<Map<String, Object>> getSourceCodeDetails(Integer sourceCodeId) {
		List<Map<String, Object>> sourceCodeDetails = new ArrayList<>();
		try {
			sourceCodeDetails = jdbcTemplate.queryForList(
					"SELECT description,active,from_date,to_date,source_format,source_code,offer,premium_order_code_id,list,shipping_price_list,agency_customer_id,generic_agency FROM source_code WHERE source_code_id = "
							+ sourceCodeId + " ORDER BY source_code_id");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeDetails;
	}

	@Override
	public int deleteSourceCodeDetails(Integer sourceCodeId) {
		int Status = 0;

		try {
			String generic_promotion_code = "delete from generic_promotion_code where source_code_id = " + sourceCodeId;
			Status = jdbcTemplate.update(generic_promotion_code);
			String generic_promotion = "delete from generic_promotion where source_code_id = " + sourceCodeId;
			Status = jdbcTemplate.update(generic_promotion);
			String DiscountRates = "delete from source_code_attribute  where source_code_id = " + sourceCodeId;
			Status = jdbcTemplate.update(DiscountRates);
			String source_code_state = "delete from source_code_state where source_code_id = " + sourceCodeId;
			Status = jdbcTemplate.update(source_code_state);
			String source_code = "delete from source_code where source_code_id = " + sourceCodeId;
			Status = jdbcTemplate.update(source_code);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return Status;
	}

	@Override
	public int saveGenericPromoCodeDetails(ParentOrderClassModel genericPromotion) {
		Map<String, Object> addSourceParams = new HashMap<>();
		int status = 0;
		StringBuilder GenericPromoSaveQuery = new StringBuilder(
				"insert into generic_promotion(source_code_id,oc_id,order_code_id,item_price,generated_price,rate_class_id,discount_class_id,subscription_def_id,pkg_def_id,product_id,issue_id,mru_generic_promotion_code_seq) values(:source_code_id,:oc_id,:order_code_id,:item_price,:generated_price,:rate_class_id,:discount_class_id,:subscription_def_id,:pkg_def_id,:product_id,:issue_id,:mru_generic_promotion_code_seq)");
		// insert into source_code table
		StringBuilder sourceCodeQuery = new StringBuilder(
				"insert into source_code(source_code_id,agency_customer_id,source_format,source_code,description,state_break,generated,breakeven,")
						.append("offer,list,from_date,to_date,qty,cost,audit_qual_category,generic_agency,oc_id,active,newsub_rate_class_id,new_renewal_card_id,")
						.append("newsub_discount_class_id,audit_subscription_type_id,audit_qual_source_id,audit_name_title_id,audit_sales_channel_id,")
						.append("premium_order_code_id,source_code_type,mru_catalog_content_seq,currency,mru_generic_promotion_code_seq,is_ddp,shipping_price_list)")
						.append(" values (:source_code_id,:agency_customer_id,:source_format,:source_code,:description,:state_break,:generated,:breakeven,")
						.append(":offer,:list,:from_date,:to_date,:qty,:cost,:audit_qual_category,:generic_agency,:oc_id,:active,:newsub_rate_class_id,:new_renewal_card_id,")
						.append(":newsub_discount_class_id,:audit_subscription_type_id,:audit_qual_source_id,:audit_name_title_id,:audit_sales_channel_id,")
						.append(":premium_order_code_id,:source_code_type,:mru_catalog_content_seq,:currency,:mru_generic_promotion_code_seq,:is_ddp,:shipping_price_list)");

		StringBuilder GenericPromoCodeSaveQuery = new StringBuilder(
				" insert into generic_promotion_code(source_code_id,generic_promotion_code_seq, promotion_code,qty_limit,qty_used) values(:source_code_id,:generic_promotion_code_seq,:promotion_code,:qty_limit,:qty_used)");

		try {
			// for source_code table
			addSourceParams.clear();
			String sourceIdsresult = jdbcTemplate.queryForObject("select MAX(source_code_id) from source_code ",
					String.class);
			int sourceCodeId = Integer.parseInt(sourceIdsresult) + 1;
			addSourceParams.put("source_code_id", sourceCodeId);
			addSourceParams.put("agency_customer_id",
					genericPromotion.getAgencyCustomerId() != null ? genericPromotion.getAgencyCustomerId() : null);
			addSourceParams.put("source_format",
					genericPromotion.getSourceFormat() != null ? genericPromotion.getSourceFormat() : null);
			if (("null".equals(genericPromotion.getSourceFormat())) | ("".equals(genericPromotion.getSourceFormat()))) {
				addSourceParams.put("source_format", null);
			} else {
				addSourceParams.put("source_format", genericPromotion.getSourceFormat());
			}
			addSourceParams.put("source_code", genericPromotion.getSourceCode());
			if (("null".equals(genericPromotion.getDescription())) | ("".equals(genericPromotion.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", genericPromotion.getDescription());
			}
			addSourceParams.put("state_break",
					genericPromotion.getStateBreak() != null ? genericPromotion.getStateBreak() : 0);
			addSourceParams.put("generated",
					genericPromotion.getGenerated() != null ? genericPromotion.getGenerated() : 0);
			addSourceParams.put("breakeven",
					genericPromotion.getBreakeven() != null ? genericPromotion.getBreakeven() : null);
			if (("null".equals(genericPromotion.getOffer())) | ("".equals(genericPromotion.getOffer()))) {
				addSourceParams.put("offer", null);
			} else {
				addSourceParams.put("offer", genericPromotion.getOffer());
			}

			if (("null".equals(genericPromotion.getList())) | ("".equals(genericPromotion.getList()))) {
				addSourceParams.put("list", null);
			} else {
				addSourceParams.put("list", genericPromotion.getList());
			}

			if (("null".equals(genericPromotion.getFromDate())) | ("".equals(genericPromotion.getFromDate()))) {
				addSourceParams.put("from_date", null);
			} else {
				addSourceParams.put("from_date", genericPromotion.getFromDate());
			}

			if (("null".equals(genericPromotion.getToDate())) | ("".equals(genericPromotion.getToDate()))) {
				addSourceParams.put("to_date", null);
			} else {
				addSourceParams.put("to_date", genericPromotion.getToDate());
			}
			addSourceParams.put("qty", genericPromotion.getQty() != null ? genericPromotion.getQty() : null);
			addSourceParams.put("cost", genericPromotion.getCost());
			addSourceParams.put("audit_qual_category", genericPromotion.getAuditQualCategory());
			addSourceParams.put("generic_agency",
					genericPromotion.getGenericAgency() != null ? genericPromotion.getGenericAgency() : 0);
			addSourceParams.put("oc_id", genericPromotion.getOcId());
			addSourceParams.put("active", genericPromotion.getActive());
			addSourceParams.put("newsub_rate_class_id",
					genericPromotion.getNewsubRateClassId() != null ? genericPromotion.getNewsubRateClassId() : null);
			addSourceParams.put("new_renewal_card_id",
					genericPromotion.getNewRenewalCardId() != null ? genericPromotion.getNewRenewalCardId() : null);
			addSourceParams.put("newsub_discount_class_id",
					genericPromotion.getNewsubDiscountClassId() != null ? genericPromotion.getNewsubDiscountClassId()
							: null);
			addSourceParams.put("audit_subscription_type_id",
					genericPromotion.getAuditSubscriptionTypeId() != null
							? genericPromotion.getAuditSubscriptionTypeId()
							: null);
			addSourceParams.put("audit_qual_source_id",
					genericPromotion.getAuditQualSourceId() != null ? genericPromotion.getAuditQualSourceId() : null);
			addSourceParams.put("audit_name_title_id",
					genericPromotion.getAuditNameTitleId() != null ? genericPromotion.getAuditNameTitleId() : null);
			addSourceParams.put("audit_sales_channel_id",
					genericPromotion.getAuditSalesChannelId() != null ? genericPromotion.getAuditSalesChannelId()
							: null);
			addSourceParams.put("premium_order_code_id",
					genericPromotion.getPremiumOrderCodeId() != null ? genericPromotion.getPremiumOrderCodeId() : null);
			addSourceParams.put("source_code_type", genericPromotion.getSourceCodeType());
			addSourceParams.put("mru_catalog_content_seq",
					genericPromotion.getMruCatalogContentSeq() != null ? genericPromotion.getMruCatalogContentSeq()
							: null);
			addSourceParams.put("currency",
					genericPromotion.getCurrency() != null ? genericPromotion.getCurrency() : null);
			addSourceParams.put("mru_generic_promotion_code_seq",
					genericPromotion.getMruGenericPromotionCodeSeq() != null
							? genericPromotion.getMruGenericPromotionCodeSeq()
							: null);
			addSourceParams.put("is_ddp", genericPromotion.getIsDdp() != null ? genericPromotion.getIsDdp() : 0);
			addSourceParams.put("shipping_price_list",
					genericPromotion.getShippingPriceList() != null ? genericPromotion.getShippingPriceList() : null);

			status = namedParameterJdbcTemplate.update(sourceCodeQuery.toString(), addSourceParams);

			addSourceParams.clear();
			// for generic_promotion table
			// addSourceParams.put("source_code_id", genericPromotion.getSourceCodeId());
			addSourceParams.put("source_code_id", sourceCodeId);
			addSourceParams.put("oc_id", genericPromotion.getOcId());
			addSourceParams.put("order_code_id", genericPromotion.getOrderCodeId());
			addSourceParams.put("item_price",
					genericPromotion.getItemPrice() != null ? genericPromotion.getItemPrice() : null);
			addSourceParams.put("generated_price",
					genericPromotion.getGeneratedPrice() != null ? genericPromotion.getGeneratedPrice() : null);
			addSourceParams.put("rate_class_id",
					genericPromotion.getRateClassId() != null ? genericPromotion.getRateClassId() : null);
			addSourceParams.put("discount_class_id",
					genericPromotion.getDiscountClassId() != null ? genericPromotion.getDiscountClassId() : null);
			addSourceParams.put("subscription_def_id",
					genericPromotion.getSubscriptionDefId() != null ? genericPromotion.getSubscriptionDefId() : null);
			addSourceParams.put("pkg_def_id",
					genericPromotion.getPkgDefId() != null ? genericPromotion.getPkgDefId() : null);
			addSourceParams.put("product_id",
					genericPromotion.getProductId() != null ? genericPromotion.getProductId() : null);
			addSourceParams.put("issue_id",
					genericPromotion.getIssueId() != null ? genericPromotion.getIssueId() : null);
			addSourceParams.put("mru_generic_promotion_code_seq",
					genericPromotion.getMruGenericPromotionCodeSeq() != null
							? genericPromotion.getMruGenericPromotionCodeSeq()
							: null);
			status = namedParameterJdbcTemplate.update(GenericPromoSaveQuery.toString(), addSourceParams);
			addSourceParams.clear();
			// it inserts no of record according to source_code's mruGenericPromotionSeq
			// suppose mruGenericPromotionSeq is 3 then it will be insert record 3 times
			// into generic_promotion_code table
			String sequence = genericPromotion.getMruGenericPromotionCodeSeq() != null
					? genericPromotion.getMruGenericPromotionCodeSeq()
					: "0";
			int sequenceNo = Integer.valueOf(sequence);
			for (int i = 1; i <= sequenceNo; i++) {
				// sourceIdsresult is source_code_id
				addSourceParams.put("source_code_id", sourceCodeId);
				addSourceParams.put("generic_promotion_code_seq", i);
				// it appends source_code and sequence like source_code=bharti then
				// promotion_code=bharti-1,bharti-2.....
				StringBuilder promotionCode = new StringBuilder(genericPromotion.getSourceCode());
				promotionCode.append("-").append(i);
				addSourceParams.put("promotion_code", promotionCode);
				// Max Use as qty_limit
				addSourceParams.put("qty_limit",
						genericPromotion.getQtyLimit() != null ? genericPromotion.getQtyLimit() : 0);
				addSourceParams.put("qty_used",
						genericPromotion.getQtyUsed() != null ? genericPromotion.getQtyUsed() : 0);
				status = namedParameterJdbcTemplate.update(GenericPromoCodeSaveQuery.toString(), addSourceParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<DropdownModel> getSourceCodeStateDetails(Integer sourceCodeId) {
		List<DropdownModel> sourceCodeStatesList = new ArrayList<>();
		try {
			List<Map<String, Object>> sourceCodeStates = jdbcTemplate.queryForList(
					"select source_code_id,state,qty_mailed,cost_mailing from source_code_state where source_code_id"
							+ sourceCodeId);
			for (Map<String, Object> sourceCodeState : sourceCodeStates) {
				DropdownModel model = new DropdownModel();
				model.setKey(sourceCodeState.get("source_code_id").toString());
				model.setDisplay(sourceCodeState.get("state").toString());
				model.setDescription(
						sourceCodeState.get("qty_mailed") != null ? (String) sourceCodeState.get("qty_mailed") : null);
				model.setExtra(sourceCodeState.get("cost_mailing").toString());
				sourceCodeStatesList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeStatesList;
	}

	@Override
	public int getOrderCodeType(Integer orderType) {
		int orderCodeType = 0;
		List<Map<String, Object>> orderTypeList = new ArrayList<>();
		String query = "select distinct oc_type,case when oc_type=0 then '' when  oc_type=1 then '0' when  oc_type=2 then '2' when  oc_type=3 then '4' when  oc_type=4 then '5' when  oc_type=5 then '6' when oc_type=6 then '7' when oc_type=8 then '8' end as order_code_type from oc where oc_type = "
				+ orderType;
		try {
			orderTypeList = jdbcTemplate.queryForList(query);
			orderCodeType = Integer.valueOf(orderTypeList.get(0).get("order_code_type").toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return orderCodeType;
	}

	@Override
	public List<Map<String, Object>> getSourceCode(Integer sourceCodeId) {
		List<Map<String, Object>> sourceCode = new ArrayList<>();
		try {
			sourceCode = jdbcTemplate.queryForList(
					"SELECT source_code_id,agency_customer_id,description,active,from_date,to_date,source_format,source_code,offer,premium_order_code_id,list,shipping_price_list,generic_agency FROM source_code WHERE source_code_id = "
							+ sourceCodeId + " ORDER BY source_code_id");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCode;
	}

	@Override
	public List<DropdownModel> getSourceCodeStatusDetails() {
		List<Map<String, Object>> activeDataList = new ArrayList<>();
		List<DropdownModel> sourceCodeStatusDataList = new ArrayList<>();
		try {
			for (int i = 0; i <= 1; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("active_" + i));
				sourceCodeStatusDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeStatusDataList;
	}

	@Override
	public int saveDemForm(DemographicForms demForm) {
		Map<String, Object> saveDemFormParams = new HashMap<>();
		int status = 0;
		try {
			if (demForm.getDemFormId() == null) {
				StringBuilder saveDemFormQuery = new StringBuilder(
						"insert into dem_form (dem_form_id,dem_form,description,oc_id,active,from_date,to_date,response_required,mru_dem_form_question_seq) values(:dem_form_id,:dem_form,:description,:oc_id,:active,:from_date,:to_date,:response_required,:mru_dem_form_question_seq)");
				String maxPKId = jdbcTemplate.queryForObject("select max(dem_form_id) from dem_form", String.class);
				if (maxPKId == null) {
					saveDemFormParams.put("dem_form_id", 1);
				} else {
					saveDemFormParams.put("dem_form_id", Integer.parseInt(maxPKId) + 1);
				}
				saveDemFormParams.put("dem_form", demForm.getDemForm());
				saveDemFormParams.put("description", demForm.getDescription());
				saveDemFormParams.put("oc_id", demForm.getOcId());
				saveDemFormParams.put("active", demForm.getDemForm().equalsIgnoreCase("true") ? 1 : 0);
				if (("null".equals(demForm.getFromDate())) | ("".equals(demForm.getFromDate()))) {
					saveDemFormParams.put("from_date", null);
				} else {
					saveDemFormParams.put("from_date", demForm.getFromDate());
				}
				if (("null".equals(demForm.getToDate())) | ("".equals(demForm.getToDate()))) {
					saveDemFormParams.put("to_date", null);
				} else {
					saveDemFormParams.put("to_date", demForm.getToDate());
				}
				saveDemFormParams.put("response_required",
						demForm.getResponseRequired().equalsIgnoreCase("true") ? 1 : 0);
				saveDemFormParams.put("mru_dem_form_question_seq",
						demForm.getMruDemFormQuestionSeq() != null ? demForm.getMruDemFormQuestionSeq() : null);
				status = namedParameterJdbcTemplate.update(saveDemFormQuery.toString(), saveDemFormParams);
			} else if ((demForm.getDemFormId() != null) && (demForm.getDemFormQuestionSeq() == null)) {
				StringBuilder saveDemFormQuestionQuery = new StringBuilder(
						"insert into dem_form_question(dem_form_id,dem_form_question_seq,dem_question_id,label_q,descr_q_override,mru_dem_form_response_seq) values(:dem_form_id,:dem_form_question_seq,:dem_question_id,:label_q,:descr_q_override,:mru_dem_form_response_seq)");
				// fetching dem_form_question_seq from table to save new record into
				// dem_form_question table
				int dem_form_question_seq = getDemFormQuestionSeq(demForm.getDemFormId());
				saveDemFormParams.put("dem_form_id", demForm.getDemFormId());
				Integer mru_dem_form_question_seq = jdbcTemplate.queryForObject(
						"select mru_dem_form_question_seq from dem_form where dem_form_id = " + demForm.getDemFormId(),
						Integer.class);
				if (mru_dem_form_question_seq == null) {
					mru_dem_form_question_seq = 1;
				} else {
					mru_dem_form_question_seq = mru_dem_form_question_seq + 1;
				}
				if (dem_form_question_seq == 0) {
					saveDemFormParams.put("dem_form_question_seq", 1);
					updateMru_dem_form_question_seq(demForm.getDemFormId(), mru_dem_form_question_seq);
				} else {
					saveDemFormParams.put("dem_form_question_seq", dem_form_question_seq + 1);
					updateMru_dem_form_question_seq(demForm.getDemFormId(), mru_dem_form_question_seq);
				}
				saveDemFormParams.put("dem_question_id", demForm.getDemQuestionId());
				saveDemFormParams.put("label_q", demForm.getLabelQ());
				if (("null".equals(demForm.getDescrQOverride())) | ("".equals(demForm.getDescrQOverride()))) {
					saveDemFormParams.put("descr_q_override", null);
				} else {
					saveDemFormParams.put("descr_q_override", demForm.getDescrQOverride());
				}
				saveDemFormParams.put("mru_dem_form_response_seq",
						demForm.getMruDemFormResponseSeq() != null ? demForm.getMruDemFormResponseSeq() : null);

				status = namedParameterJdbcTemplate.update(saveDemFormQuestionQuery.toString(), saveDemFormParams);
			} else {
				StringBuilder saveDemFormQuestionQuery = new StringBuilder(
						"insert into dem_form_response(dem_form_id,dem_form_question_seq,dem_form_response_seq,dem_question_id,dem_response_seq,label_r_override,descr_r_override) values (:dem_form_id,:dem_form_question_seq,:dem_form_response_seq,:dem_question_id,:dem_response_seq,:label_r_override,:descr_r_override)");
				// fetching dem_form_response_seq from dem_form_response table to save new
				// record into dem_form_response table
				int dem_form_response_seq = getDemFormResponseSeq(demForm.getDemFormId(),
						demForm.getDemFormQuestionSeq());
				Integer mru_dem_form_question_seq = jdbcTemplate
						.queryForObject("select mru_dem_form_response_seq from dem_form_question where dem_form_id = "
								+ demForm.getDemFormId() + " and dem_form_question_seq = "
								+ demForm.getDemFormQuestionSeq(), Integer.class);
				if (mru_dem_form_question_seq == null) {
					mru_dem_form_question_seq = 1;
				} else {
					mru_dem_form_question_seq = mru_dem_form_question_seq + 1;
				}
				saveDemFormParams.put("dem_form_id", demForm.getDemFormId());
				saveDemFormParams.put("dem_form_question_seq", demForm.getDemFormQuestionSeq());
				if (dem_form_response_seq == 0) {
					saveDemFormParams.put("dem_form_response_seq", 1);
					updateMru_dem_form_response_seq(demForm.getDemFormId(), demForm.getDemFormQuestionSeq(),
							mru_dem_form_question_seq);
				} else {
					saveDemFormParams.put("dem_form_response_seq", dem_form_response_seq + 1);
					updateMru_dem_form_response_seq(demForm.getDemFormId(), demForm.getDemFormQuestionSeq(),
							mru_dem_form_question_seq);
				}
				saveDemFormParams.put("dem_question_id", demForm.getDemQuestionId());
				saveDemFormParams.put("dem_response_seq", demForm.getDemResponseSeq());
				if (("null".equals(demForm.getLabelROverride())) | ("".equals(demForm.getLabelROverride()))) {
					saveDemFormParams.put("label_r_override", null);
				} else {
					saveDemFormParams.put("label_r_override", demForm.getLabelROverride());
				}
				if (("null".equals(demForm.getDescrROverride())) | ("".equals(demForm.getDescrROverride()))) {
					saveDemFormParams.put("descr_r_override", null);
				} else {
					saveDemFormParams.put("descr_r_override", demForm.getDescrROverride());
				}
				status = namedParameterJdbcTemplate.update(saveDemFormQuestionQuery.toString(), saveDemFormParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	public void updateMru_dem_form_question_seq(Integer demFormId, Integer mru_dem_form_question_seq) {
		String updateMru_dem_form_question_seq = "update dem_form set mru_dem_form_question_seq="
				+ mru_dem_form_question_seq + " where dem_form_id=" + demFormId;
		try {
			jdbcTemplate.update(updateMru_dem_form_question_seq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	public void updateMru_dem_form_response_seq(Integer demFormId, Integer dem_form_question_seq,
			Integer mru_dem_form_response_seq) {
		String updateMru_dem_form_question_seq = "update dem_form_question set mru_dem_form_response_seq="
				+ mru_dem_form_response_seq + " where dem_form_id=" + demFormId + " and dem_form_question_seq = "
				+ dem_form_question_seq;
		try {
			jdbcTemplate.update(updateMru_dem_form_question_seq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int updateDemForm(DemographicForms demForm) {
		Map<String, Object> updateDemFormParams = new HashMap<>();
		int status = 0;
		try {
			if (demForm.getDemFormId() != null
					&& (demForm.getDemFormQuestionSeq() == null && demForm.getDemFormResponseSeq() == null)) {
				StringBuilder updateDemFormQuery = new StringBuilder(
						"update dem_form set dem_form_id =:dem_form_id,dem_form =:dem_form,description =:description,oc_id =:oc_id,active =:active,from_date =:from_date,to_date =:to_date,response_required =:response_required where dem_form_id = ")
								.append(demForm.getDemFormId());
				updateDemFormParams.put("dem_form_id", demForm.getDemFormId());
				updateDemFormParams.put("dem_form", demForm.getDemForm());
				updateDemFormParams.put("description", demForm.getDescription());
				updateDemFormParams.put("oc_id", demForm.getOcId());
				updateDemFormParams.put("active", demForm.getActive().equalsIgnoreCase("true") ? 1 : 0);
				if (("null".equals(demForm.getFromDate())) | ("".equals(demForm.getFromDate()))) {
					updateDemFormParams.put("from_date", null);
				} else {
					updateDemFormParams.put("from_date", demForm.getFromDate());
				}
				if (("null".equals(demForm.getToDate())) | ("".equals(demForm.getToDate()))) {
					updateDemFormParams.put("to_date", null);
				} else {
					updateDemFormParams.put("to_date", demForm.getToDate());
				}
				updateDemFormParams.put("response_required",
						demForm.getResponseRequired().equalsIgnoreCase("true") ? 1 : 0);
				// updateDemFormParams.put("mru_dem_form_question_seq",
				// demForm.getMruDemFormQuestionSeq()!=null?
				// demForm.getMruDemFormQuestionSeq():null);

				status = namedParameterJdbcTemplate.update(updateDemFormQuery.toString(), updateDemFormParams);
			} else if (demForm.getDemFormId() != null
					&& (demForm.getDemFormQuestionSeq() != null && demForm.getDemFormResponseSeq() == null)) {
				StringBuilder updateDemFormQuestionQuery = new StringBuilder(
						"update dem_form_question set dem_form_id =:dem_form_id,dem_form_question_seq =:dem_form_question_seq,dem_question_id =:dem_question_id,label_q =:label_q,descr_q_override =:descr_q_override where dem_form_id = ")
								.append(demForm.getDemFormId()).append(" and dem_form_question_seq = ")
								.append(demForm.getDemFormQuestionSeq());
				updateDemFormParams.put("dem_form_id", demForm.getDemFormId());
				updateDemFormParams.put("dem_form_question_seq", demForm.getDemFormQuestionSeq());
				updateDemFormParams.put("dem_question_id", demForm.getDemQuestionId());
				updateDemFormParams.put("label_q", demForm.getLabelQ());
				if (("null".equals(demForm.getDescrQOverride())) | ("".equals(demForm.getDescrQOverride()))) {
					updateDemFormParams.put("descr_q_override", null);
				} else {
					updateDemFormParams.put("descr_q_override", demForm.getDescrQOverride());
				}
				// updateDemFormParams.put("mru_dem_form_response_seq",
				// demForm.getMruDemFormResponseSeq());
				status = namedParameterJdbcTemplate.update(updateDemFormQuestionQuery.toString(), updateDemFormParams);
			} else {
				StringBuilder updateDemFormResponseQuery = new StringBuilder(
						"update dem_form_response set dem_form_id =:dem_form_id,dem_form_question_seq =:dem_form_question_seq,dem_form_response_seq =:dem_form_response_seq,dem_question_id =:dem_question_id,dem_response_seq =:dem_response_seq,label_r_override =:label_r_override,descr_r_override =:descr_r_override where dem_form_id = ")
								.append(demForm.getDemFormId()).append(" and dem_form_question_seq = ")
								.append(demForm.getDemFormQuestionSeq()).append(" and dem_form_response_seq = ")
								.append(demForm.getDemFormResponseSeq());
				updateDemFormParams.put("dem_form_id", demForm.getDemFormId());
				updateDemFormParams.put("dem_form_question_seq", demForm.getDemFormQuestionSeq());
				updateDemFormParams.put("dem_form_response_seq", demForm.getDemFormResponseSeq());
				updateDemFormParams.put("dem_question_id", demForm.getDemQuestionId());
				updateDemFormParams.put("dem_response_seq", demForm.getDemFormResponseSeq());
				if (("null".equals(demForm.getLabelROverride())) | ("".equals(demForm.getLabelROverride()))) {
					updateDemFormParams.put("label_r_override", null);
				} else {
					updateDemFormParams.put("label_r_override", demForm.getLabelROverride());
				}
				if (("null".equals(demForm.getDescrROverride())) | ("".equals(demForm.getDescrROverride()))) {
					updateDemFormParams.put("descr_r_override", null);
				} else {
					updateDemFormParams.put("descr_r_override", demForm.getDescrROverride());
				}
				status = namedParameterJdbcTemplate.update(updateDemFormResponseQuery.toString(), updateDemFormParams);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getDemFormId() {
		int demFormId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(dem_form_id) from dem_form", String.class);
			if (maxId == null) {
				demFormId = 0;
			} else {
				demFormId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demFormId;
	}

	@Override
	public int getDemFormQuestionSeq(Integer demFormId) {
		int demFormQuestionSeq = 0;
		try {
			String maxId = jdbcTemplate.queryForObject(
					"select max(dem_form_question_seq) from dem_form_question where dem_form_id=" + demFormId,
					String.class);
			if (maxId == null) {
				demFormQuestionSeq = 0;
			} else {
				demFormQuestionSeq = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return demFormQuestionSeq;
	}

	@Override
	public int getDemFormResponseSeq(Integer demFormId, Integer demFormQuestionSeq) {
		int demFormResponseSeq = 0;
		try {
			String maxId = jdbcTemplate
					.queryForObject("select max(dem_form_response_seq) from dem_form_response where dem_form_id = "
							+ demFormId + " and dem_form_question_seq = " + demFormQuestionSeq, String.class);
			if (maxId == null) {
				demFormResponseSeq = 0;
			} else {
				demFormResponseSeq = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return demFormResponseSeq;
	}

	@Override
	public String deleteDemographics(int demFormId) {
		StringBuilder returnStatus = new StringBuilder();
		int status = 0;
		StringBuilder deleteDemographicsQuery = new StringBuilder("delete dem_form from dem_form");
		deleteDemographicsQuery
				.append(" left join dem_form_question on dem_form.dem_form_id = dem_form_question.dem_form_id");
		deleteDemographicsQuery
				.append(" left join dem_form_response on dem_form.dem_form_id = dem_form_response.dem_form_id");
		deleteDemographicsQuery.append(" left join demographic on  dem_form.dem_form_id = demographic.dem_form_id");
		deleteDemographicsQuery
				.append(" left join import_format_field on dem_form.dem_form_id  = import_format_field.dem_form_id");
		deleteDemographicsQuery.append(" where dem_form.dem_form_id = ");
		deleteDemographicsQuery.append(demFormId);
		try {
			// if query fire successfully then status value will be 1 otherwise 0
			status = jdbcTemplate.update(deleteDemographicsQuery.toString());
			returnStatus.append(status);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
		return returnStatus.toString();
	}

	@Override
	public List<DropdownModel> copyDemographics(Integer demFormId, String demForm, Integer ocId, String active) {
		List<DropdownModel> filteredDemographics = new ArrayList<>();
		StringBuilder query = new StringBuilder("select dem_form_id,dem_form,description from dem_form where ");
		List<Map<String, Object>> searchedDemographicsData = new ArrayList<>();
		try {
			if (demForm.equals("") && (ocId == null && active.equalsIgnoreCase(""))) {
				query.append("(dem_form_id !=").append(demFormId).append(")");
				searchedDemographicsData = jdbcTemplate.queryForList(query.toString());

				for (Map<String, Object> filter : searchedDemographicsData) {
					DropdownModel model = new DropdownModel();
					model.setKey(filter.get("dem_form_id").toString());
					model.setDisplay(filter.get("dem_form") != null ? filter.get("dem_form").toString() : "");
					model.setDescription(filter.get("description") != null ? filter.get("description").toString() : "");
					filteredDemographics.add(model);
				}
			} else if (!demForm.equals("") && (ocId == null && active.equalsIgnoreCase(""))) {
				query.append("dem_form.dem_form='").append(demForm).append("'");
				query.append(" and (dem_form_id !=").append(demFormId).append(")");
				searchedDemographicsData = jdbcTemplate.queryForList(query.toString());
				for (Map<String, Object> filter : searchedDemographicsData) {
					DropdownModel model = new DropdownModel();
					model.setKey(filter.get("dem_form_id").toString());
					model.setDisplay(filter.get("dem_form") != null ? filter.get("dem_form").toString() : "");
					model.setDescription(filter.get("description") != null ? filter.get("description").toString() : "");
					filteredDemographics.add(model);
				}
			} else if (ocId != null && (demForm.equals("") && active.equalsIgnoreCase(""))) {
				query.append("dem_form.oc_id in (").append(ocId);
				query.append(") and (dem_form_id !=").append(demFormId).append(")");
				searchedDemographicsData = jdbcTemplate.queryForList(query.toString());
				for (Map<String, Object> filter : searchedDemographicsData) {
					DropdownModel model = new DropdownModel();
					model.setKey(filter.get("dem_form_id").toString());
					model.setDisplay(filter.get("dem_form") != null ? filter.get("dem_form").toString() : "");
					model.setDescription(filter.get("description") != null ? filter.get("description").toString() : "");
					filteredDemographics.add(model);
				}
			} else if (!active.equals("") && (demForm.equals("") && ocId == null)) {
				query.append("dem_form.active=").append(active.equalsIgnoreCase("true") ? 1 : 0);
				query.append(" and (dem_form_id !=").append(demFormId).append(")");
				searchedDemographicsData = jdbcTemplate.queryForList(query.toString());
				for (Map<String, Object> filter : searchedDemographicsData) {
					DropdownModel model = new DropdownModel();
					model.setKey(filter.get("dem_form_id").toString());
					model.setDisplay(filter.get("dem_form") != null ? filter.get("dem_form").toString() : "");
					model.setDescription(filter.get("description") != null ? filter.get("description").toString() : "");
					filteredDemographics.add(model);
				}
			} else if (!demForm.equals("") && (ocId != null && active.equals(""))) {
				query.append("dem_form.dem_form='").append(demForm).append("'");
				query.append(" and dem_form.oc_id in (").append(ocId).append(")");
				query.append(" and (dem_form_id !=").append(demFormId).append(")");
				searchedDemographicsData = jdbcTemplate.queryForList(query.toString());
				for (Map<String, Object> filter : searchedDemographicsData) {
					DropdownModel model = new DropdownModel();
					model.setKey(filter.get("dem_form_id").toString());
					model.setDisplay(filter.get("dem_form") != null ? filter.get("dem_form").toString() : "");
					model.setDescription(filter.get("description") != null ? filter.get("description").toString() : "");
					filteredDemographics.add(model);
				}
			} else { // else if( (!demForm.equals("") && ocId != 0) && !active.equals("")) {
				query.append("dem_form.dem_form='").append(demForm).append("'");
				query.append(" and dem_form.oc_id in (").append(ocId).append(")");
				query.append(" and dem_form.active=").append(active.equalsIgnoreCase("true") ? 1 : 0);
				query.append(" and (dem_form_id !=").append(demFormId).append(")");
				searchedDemographicsData = jdbcTemplate.queryForList(query.toString());
				for (Map<String, Object> filter : searchedDemographicsData) {
					DropdownModel model = new DropdownModel();
					model.setKey(filter.get("dem_form_id").toString());
					model.setDisplay(filter.get("dem_form") != null ? filter.get("dem_form").toString() : "");
					model.setDescription(filter.get("description") != null ? filter.get("description").toString() : "");
					filteredDemographics.add(model);
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return filteredDemographics;
	}

	@Override
	public List<Map<String, Object>> getProductDetails(Integer ocId) {
		List<Map<String, Object>> productDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"SELECT product.product_id,product.oc_id,product.description,product.product_size,product.product_style,product.product_color,product.price,product.taxonomy,product.inventory_id,order_code.order_code,product.allow_on_internet,product.tag_line,product.item_url,product.image_url,rate_class.rate_class,product.auxiliary_1,product.auxiliary_2,order_code2.order_code as premium FROM product left join oc on product.oc_id = oc.oc_id left join order_code on product.order_code_id = order_code.order_code_id left join rate_class on product.rate_class_id = rate_class.rate_class_id left join inventory on product.inventory_id = inventory.inventory_id left join taxonomy on product.taxonomy = taxonomy.taxonomy  left join order_code order_code2 on product.premium_order_code_id = order_code2.order_code_id WHERE product.oc_id = (select oc_id from product_class where oc_id = ")
						.append(ocId).append(") ORDER BY product_id");
		try {
			productDetails = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return productDetails;
	}

	@Override
	public List<DropdownModel> getOrderCodeDependecies(Integer orderCodeId) {
		List<Map<String, Object>> orderCodeDependeciesData = new ArrayList<>();
		List<DropdownModel> orderCodeDependecies = new ArrayList<>();
		StringBuilder query = new StringBuilder(
				"select order_code_dependencies.order_code_id,order_code_dependencies.primary_order_code_id,order_code.order_code,order_code.description from order_code");
		query.append(
				" left join order_code_dependencies on  order_code_dependencies.primary_order_code_id=order_code.order_code_id where order_code_dependencies.order_code_id = ");
		query.append(orderCodeId);
		try {
			orderCodeDependeciesData = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> dependency : orderCodeDependeciesData) {
				DropdownModel model = new DropdownModel();
				model.setKey(dependency.get("order_code_id") != null ? dependency.get("order_code_id").toString() : "");
				model.setDisplay(dependency.get("order_code") != null ? dependency.get("order_code").toString() : "");
				model.setDescription(
						dependency.get("description") != null ? dependency.get("description").toString() : "");
				model.setExtra(dependency.get("primary_order_code_id") != null
						? dependency.get("primary_order_code_id").toString()
						: "");
				orderCodeDependecies.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderCodeDependecies;
	}

	@Override
	public String saveDependencies(OrderCodeModel model) {
		Map<String, Object> addSourceParams = new HashMap<>();
		StringBuilder returnStatus = new StringBuilder();
		int status = 0;
		try {
			// insert into order_code_dependencies table
			// duplicate order_code_id & primary_order_code_id is not allowed in
			// order_code_dependencies table
			// int isDuplicateOrderCodeId = jdbcTemplate.queryForObject("select count(*)
			// from order_code_dependencies where order_code_id = "+model.getOrderCodeId()+"
			// and primary_order_code_id = "+model.getPrimaryOrderCodeId(),Integer.class);
			// if(isDuplicateOrderCodeId == 0) {
			String saveQuery = "insert into order_code_dependencies(order_code_id,primary_order_code_id) values(:order_code_id,:primary_order_code_id)";
			Integer orderCodeId = jdbcTemplate.queryForObject("select max(order_code_id) from order_code",
					Integer.class);
			// addSourceParams.put("order_code_id", model.getOrderCodeId());
			addSourceParams.put("order_code_id", orderCodeId);
			addSourceParams.put("primary_order_code_id", model.getPrimaryOrderCodeId());
			status = namedParameterJdbcTemplate.update(saveQuery, addSourceParams);
			returnStatus.append(status);
			// }else {
			// status.append("The duplicate key value is
			// ("+model.getOrderCodeId()+","+model.getPrimaryOrderCodeId()+")");
			// }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
		return returnStatus.toString();

	}

	@Override
	public String updateDependencies(OrderCodeModel model) {
		Map<String, Object> addSourceParams = new HashMap<>();
		StringBuilder returnStatus = new StringBuilder();
		int status = 0;
		try {
			// insert into order_code_dependencies table
			// duplicate order_code_id & primary_order_code_id is not allowed in
			// order_code_dependencies table
			// int isDuplicateOrderCodeId = jdbcTemplate.queryForObject("select count(*)
			// from order_code_dependencies where order_code_id = "+model.getOrderCodeId()+"
			// and primary_order_code_id = "+model.getPrimaryOrderCodeId(),Integer.class);
			// if(isDuplicateOrderCodeId != 0) {
			String saveQuery = "update order_code_dependencies set primary_order_code_id =:primary_order_code_id where order_code_id = "
					+ model.getOrderCodeId() + " and primary_order_code_id =" + model.getPrimaryOrderCodeId();
			addSourceParams.put("order_code_id", model.getOrderCodeId());
			addSourceParams.put("primary_order_code_id", model.getPrimaryOrderCodeIdNew());
			namedParameterJdbcTemplate.update(saveQuery, addSourceParams);
			// status.append("upatedDependencies");
			// }else {
			// status.append("The duplicate key value is
			// ("+model.getOrderCodeId()+","+model.getPrimaryOrderCodeId()+")");
			// }
			returnStatus.append(status);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
		return returnStatus.toString();

	}

	@Override
	public void insertBatchOrderCodeDependency(List<OrderCodeModel> model) {
		System.out.println(model);
		try {
			String query = "insert into order_code_dependencies(order_code_id,primary_order_code_id) values(?,?)";
			jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					OrderCodeModel model2 = model.get(i);
					ps.setInt(1, model2.getOrderCodeId());
					ps.setInt(2, model2.getPrimaryOrderCodeId());
				}

				@Override
				public int getBatchSize() {
					return model.size();
				}
			});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

	}

	@Override
	public int getOrderCodeId() {
		int orderCodeId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(order_code_id) from order_code", String.class);
			if (maxId == null) {
				orderCodeId = 0;
			} else {
				orderCodeId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderCodeId;
	}

	@Override
	public List<DropdownModel> getQuestionsList() {
		List<DropdownModel> questionList = new ArrayList<>();
		try {
			List<Map<String, Object>> questionData = jdbcTemplate
					.queryForList("select dem_question_id,descr_q_default from dem_question");
			for (Map<String, Object> question : questionData) {
				DropdownModel model = new DropdownModel();
				model.setKey(question.get("dem_question_id").toString());
				model.setDisplay(
						question.get("descr_q_default") != null ? question.get("descr_q_default").toString() : "");
				questionList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return questionList;
	}

	@Override
	public List<DropdownModel> getQuestionOverrideList(Integer demFormId, Integer demFormQuestionSeq) {
		List<DropdownModel> questionOverrideList = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"SELECT descr_q_override,language_code,alternate_content FROM dem_form_question ");
			query.append(" left join alternate_content on  alternate_content.key_part1 =dem_form_question.dem_form_id");
			query.append(" and  alternate_content.key_part2 =dem_form_question.dem_form_question_seq ");
			query.append(" where dem_form_id=").append(demFormId);
			query.append(" and dem_form_question_seq=").append(demFormQuestionSeq);
			query.append(" and ((table_name='dem_form_question') or (table_name is null))");
			// List<Map<String,Object>> questionOverrideData =
			// jdbcTemplate.queryForList("SELECT
			// dem_form_question.descr_q_override,alternate_content.language_code,alternate_content.alternate_content
			// FROM dem_form_question left join alternate_content on
			// dem_form_question.dem_form_id = alternate_content.key_part1 and
			// dem_form_question.dem_form_question_seq = alternate_content.key_part2 where
			// dem_form_question.dem_form_id="+demFormId+" and
			// dem_form_question.dem_form_question_seq="+demFormQuestionSeq+" and
			// alternate_content.table_name='dem_form_question'");
			List<Map<String, Object>> questionOverrideData = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> question : questionOverrideData) {
				DropdownModel model = new DropdownModel();
				model.setDisplay(
						question.get("descr_q_override") != null ? question.get("descr_q_override").toString() : "");
				model.setDescription(
						question.get("language_code") != null ? question.get("language_code").toString() : "");
				model.setExtra(
						question.get("alternate_content") != null ? question.get("alternate_content").toString() : "");
				questionOverrideList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return questionOverrideList;
	}

	@Override
	public List<DropdownModel> getResponsesList(Integer demQuestionId) {
		List<DropdownModel> responsesList = new ArrayList<>();
		try {
			List<Map<String, Object>> responsesData = jdbcTemplate
					.queryForList("select label_r_default,descr_r_default from dem_response  where dem_question_id = "
							+ demQuestionId);
			for (Map<String, Object> responses : responsesData) {
				DropdownModel model = new DropdownModel();
				model.setKey(responses.get("label_r_default").toString());
				model.setDisplay(
						responses.get("descr_r_default") != null ? responses.get("descr_r_default").toString() : "");
				responsesList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return responsesList;
	}

	@Override
	public List<DropdownModel> getResponsesOverrideList(Integer demFormId, Integer demFormQuestionSeq,
			Integer demFormResponseSeq) {
		List<DropdownModel> responsesOverrideList = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"SELECT descr_r_override,language_code,alternate_content FROM dem_form_response ");
			query.append(" left join alternate_content on");
			query.append(" alternate_content.key_part1 =dem_form_response.dem_form_id ");
			query.append(" and  alternate_content.key_part2 =dem_form_response.dem_form_question_seq ");
			query.append(" and alternate_content.key_part3 =dem_form_response.dem_form_response_seq ");
			query.append(" where dem_form_id=").append(demFormId).append(" and dem_form_question_seq=")
					.append(demFormQuestionSeq).append(" and dem_form_response_seq=").append(demFormResponseSeq);
			query.append(" and ((table_name='dem_form_response') or (table_name is null))");
			// List<Map<String,Object>> responsesOverrideData =
			// jdbcTemplate.queryForList("SELECT
			// dem_form_response.descr_r_override,alternate_content.language_code,alternate_content.alternate_content
			// FROM dem_form_response left join alternate_content on
			// dem_form_response.dem_form_id = alternate_content.key_part1 and
			// dem_form_response.dem_form_question_seq = alternate_content.key_part2 and
			// dem_form_response.dem_form_response_seq = alternate_content.key_part3 where
			// dem_form_response.dem_form_id="+demFormId+" and
			// dem_form_response.dem_form_question_seq="+demFormQuestionSeq+" and
			// dem_form_response.dem_form_response_seq="+demFormResponseSeq+" and
			// alternate_content.table_name='dem_form_response'");
			List<Map<String, Object>> responsesOverrideData = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> responses : responsesOverrideData) {
				DropdownModel model = new DropdownModel();
				model.setDisplay(
						responses.get("descr_r_override") != null ? responses.get("descr_r_override").toString() : "");
				model.setDescription(
						responses.get("language_code") != null ? responses.get("language_code").toString() : "");
				model.setExtra(
						responses.get("alternate_content") != null ? responses.get("alternate_content").toString()
								: "");
				responsesOverrideList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return responsesOverrideList;
	}

	@Override
	public List<Map<String, Object>> getDemFormResponseDetails(Integer demFormId, Integer demFormQuestionSeq) {
		List<Map<String, Object>> demoFormResponseDetails = new ArrayList<>();
		try {
			demoFormResponseDetails = jdbcTemplate.queryForList(
					"SELECT dem_form_id,dem_form_question_seq,dem_form_response_seq,dem_question_id,dem_response_seq,label_r_override,descr_r_override FROM dem_form_response WHERE dem_form_id = "
							+ demFormId + " and dem_form_question_seq = " + demFormQuestionSeq
							+ " ORDER BY dem_form_response_seq");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demoFormResponseDetails;
	}

	@Override
	public List<Map<String, Object>> getDemFormDetails(Integer demFormId) {
		List<Map<String, Object>> demoGraphicsDetails = new ArrayList<>();
		try {
			demoGraphicsDetails = jdbcTemplate.queryForList(
					"SELECT dem_form_id,dem_form,description,oc_id,active,from_date,to_date,response_required FROM dem_form WHERE dem_form_id = "
							+ demFormId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demoGraphicsDetails;
	}

	@Override
	public List<Map<String, Object>> getDemFormQuestionDetails(Integer demFormId) {
		List<Map<String, Object>> demoFormQuestionDetails = new ArrayList<>();
		try {
			demoFormQuestionDetails = jdbcTemplate.queryForList(
					"SELECT dem_form_id,dem_form_question_seq,dem_question_id,label_q,descr_q_override FROM dem_form_question WHERE dem_form_id = "
							+ demFormId + " ORDER BY dem_form_question_seq");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demoFormQuestionDetails;
	}

	@Override
	public List<Map<String, Object>> getDemFormDetails(Integer demFormId, Integer demFormQuestionSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	/* =========================SHASHI============================== */

	@Override
	public int savePubRotationDetails(PubRotation pubRotation) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into pub_rotation(pub_rotation_id,oc_id,description,on_string,on_calendar_unit,on_day) values(:pub_rotation_id,:oc_id,:description,:on_string,:on_calendar_unit,:on_day)");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			String maxPubRotationId = jdbcTemplate.queryForObject("select MAX(pub_rotation_id) from pub_rotation",
					String.class);
			if (maxPubRotationId == null) {
				addSourceParams.put("pub_rotation_id", 1);
			} else {
				addSourceParams.put("pub_rotation_id", Integer.parseInt(maxPubRotationId) + 1);
			}
			addSourceParams.put("oc_id", pubRotation.getOcId());
			if (("null".equals(pubRotation.getDescription())) | ("".equals(pubRotation.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", pubRotation.getDescription());
			}
			if (("null".equals(pubRotation.getOnString())) | ("".equals(pubRotation.getOnString()))) {
				addSourceParams.put("on_string", null);
			} else {
				addSourceParams.put("on_string", pubRotation.getOnString());
			}
			addSourceParams.put("on_calendar_unit", pubRotation.getOnCalendarUnit());
			addSourceParams.put("on_day", pubRotation.getOnDay());
			namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getPubRotationId() {
		int pubRotationId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(pub_rotation_id) from pub_rotation", String.class);
			if (maxId == null) {
				pubRotationId = 0;
			} else {
				pubRotationId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}
		return pubRotationId;
	}

	@Override
	public int updatePubRotationDetails(PubRotation pubRotation) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update pub_rotation set description =:description,on_string=:on_string,on_calendar_unit=:on_calendar_unit,on_day=:on_day where pub_rotation_id =:pub_rotation_id and oc_id=:oc_id");
		Map<String, Object> updateSourceParams = new LinkedHashMap<>();
		try {
			updateSourceParams.put("pub_rotation_id", pubRotation.getPubRotationId());
			updateSourceParams.put("oc_id", pubRotation.getOcId());
			if (("null".equals(pubRotation.getDescription())) | ("".equals(pubRotation.getDescription()))) {
				updateSourceParams.put("description", null);
			} else {
				updateSourceParams.put("description", pubRotation.getDescription());
			}
			if (("null".equals(pubRotation.getOnString())) | ("".equals(pubRotation.getOnString()))) {
				updateSourceParams.put("on_string", null);
			} else {
				updateSourceParams.put("on_string", pubRotation.getOnString());
			}
			updateSourceParams.put("on_calendar_unit", pubRotation.getOnCalendarUnit());
			updateSourceParams.put("on_day", pubRotation.getOnDay() != null ? pubRotation.getOnDay() : null);
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<PubRotation> getPubRotationDetails(Integer ocId) {
		List<PubRotation> pubRotationList = new ArrayList<>();
		try {
			// pubRotationList = jdbcTemplate.queryForList("select * from pub_rotation where
			// pub_rotation_id="+pubRotationId+" and oc_id="+ocId);
			pubRotationList = jdbcTemplate.query("select * from pub_rotation where oc_id=" + ocId,
					new PubRotationMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return pubRotationList;
	}

	@Override
	public List<DropdownModel> getOnCalendarUnit() {
		List<DropdownModel> onCalendarUnit = new ArrayList<>();
		for (int i = 0; i <= 5; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("on_calendar_unit_" + i));
			onCalendarUnit.add(model);
		}
		return onCalendarUnit;
	}

	@Override
	public int getOcId() {
		int ocId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(oc_id) from pub", String.class);
			if (maxId == null) {
				ocId = 0;
			} else {
				ocId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
		}
		return ocId;
	}

	@Override
	public int savePubDetails(Pub pub) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into pub(oc_id,n_issues,n_calendar_units,calendar_unit,on_string,on_calendar_unit,volume_caption,volume_format,volume_change_date,issue_caption,issue_format,issue_continuous,n_issues_per_volume,no_spaces_in_enumeration,suppress_enumeration) values(:oc_id,:n_issues,:n_calendar_units,:calendar_unit,:on_string,:on_calendar_unit,:volume_caption,:volume_format,:volume_change_date,:issue_caption,:issue_format,:issue_continuous,:n_issues_per_volume,:no_spaces_in_enumeration,:suppress_enumeration)");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			addSourceParams.put("oc_id", pub.getOcId());
			addSourceParams.put("n_issues", pub.getnIssues() != null ? pub.getnIssues() : null);
			addSourceParams.put("n_calendar_units", pub.getnCalendarUnits() != null ? pub.getnCalendarUnits() : null);
			addSourceParams.put("calendar_unit", pub.getCalendarUnit());
			if (("null".equals(pub.getOnString())) | ("".equals(pub.getOnString()))) {
				addSourceParams.put("on_string", null);
			} else {
				addSourceParams.put("on_string", pub.getOnString());
			}
			addSourceParams.put("on_calendar_unit", pub.getOnCalendarUnit());
			if (("null".equals(pub.getVolumeCaption())) | ("".equals(pub.getVolumeCaption()))) {
				addSourceParams.put("volume_caption", null);
			} else {
				addSourceParams.put("volume_caption", pub.getVolumeCaption());
			}
			addSourceParams.put("volume_format", pub.getVolumeFormat());
			if (("null".equals(pub.getVolumeChangeDate())) | ("".equals(pub.getVolumeChangeDate()))) {
				addSourceParams.put("volume_change_date", null);
			} else {
				addSourceParams.put("volume_change_date", pub.getVolumeChangeDate());
			}
			if (("null".equals(pub.getIssueCaption())) | ("".equals(pub.getIssueCaption()))) {
				addSourceParams.put("issue_caption", null);
			} else {
				addSourceParams.put("issue_caption", pub.getIssueCaption());
			}
			addSourceParams.put("issue_format", pub.getIssueFormat());
			addSourceParams.put("issue_continuous", pub.getIssueContinuous());
			addSourceParams.put("n_issues_per_volume",pub.getnIssuesPerVolume() != null ? pub.getnIssuesPerVolume() : null);
			addSourceParams.put("no_spaces_in_enumeration", pub.getNoSpacesInEnumeration());
			addSourceParams.put("suppress_enumeration", pub.getSuppressEnumeration());
			namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updatePubDetails(Pub pub) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(
				"update pub set n_issues=:n_issues,n_calendar_units=:n_calendar_units,calendar_unit=:calendar_unit,on_string=:on_string,on_calendar_unit=:on_calendar_unit,volume_caption=:volume_caption,volume_format=:volume_format,volume_change_date=:volume_change_date,issue_caption=:issue_caption,issue_format=:issue_format,issue_continuous=:issue_continuous,n_issues_per_volume=:n_issues_per_volume,no_spaces_in_enumeration=:no_spaces_in_enumeration,suppress_enumeration=:suppress_enumeration where oc_id=:oc_id");
		Map<String, Object> updateSourceParams = new HashMap<>();
		try {
			updateSourceParams.put("oc_id", pub.getOcId());
			updateSourceParams.put("n_issues", pub.getnIssues() != null ? pub.getnIssues() : null);
			updateSourceParams.put("n_calendar_units",pub.getnCalendarUnits() != null ? pub.getnCalendarUnits() : null);
			updateSourceParams.put("calendar_unit", pub.getCalendarUnit());
			if (("null".equals(pub.getOnString())) | ("".equals(pub.getOnString()))) {
				updateSourceParams.put("on_string", null);
			} else {
				updateSourceParams.put("on_string", pub.getOnString());
			}
			updateSourceParams.put("on_calendar_unit", pub.getOnCalendarUnit());
			if (("null".equals(pub.getVolumeCaption())) | ("".equals(pub.getVolumeCaption()))) {
				updateSourceParams.put("volume_caption", null);
			} else {
				updateSourceParams.put("volume_caption", pub.getVolumeCaption());
			}
			updateSourceParams.put("volume_format", pub.getVolumeFormat());
			if (("null".equals(pub.getVolumeChangeDate())) | ("".equals(pub.getVolumeChangeDate()))) {
				updateSourceParams.put("volume_change_date", null);
			} else {
				updateSourceParams.put("volume_change_date", pub.getVolumeChangeDate());
			}
			if (("null".equals(pub.getIssueCaption())) | ("".equals(pub.getIssueCaption()))) {
				updateSourceParams.put("issue_caption", null);
			} else {
				updateSourceParams.put("issue_caption", pub.getIssueCaption());
			}
			updateSourceParams.put("issue_format", pub.getIssueFormat());
			updateSourceParams.put("issue_continuous", pub.getIssueContinuous());
			updateSourceParams.put("n_issues_per_volume",pub.getnIssuesPerVolume() != null ? pub.getnIssuesPerVolume() : null);
			updateSourceParams.put("no_spaces_in_enumeration", pub.getNoSpacesInEnumeration());
			updateSourceParams.put("suppress_enumeration", pub.getSuppressEnumeration());
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Pub> getSelectPubDetails(Integer ocId) {
		List<Pub> pubList = new ArrayList<>();
		try {
			pubList = jdbcTemplate.query("select oc_id,n_issues,n_calendar_units,calendar_unit,on_string,on_calendar_unit,volume_caption,volume_format,volume_change_date,issue_caption,issue_format,issue_continuous,n_issues_per_volume,no_spaces_in_enumeration,suppress_enumeration from pub where oc_id="+ ocId,new pubMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return pubList;
	}

	@Override
	public List<DropdownModel> getCalenderUnit() {
		List<DropdownModel> calenderUnit = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("calendar_unit_" + i));
			calenderUnit.add(model);
		}
		return calenderUnit;
	}

	@Override
	public List<DropdownModel> getVolumeFormat() {
		List<DropdownModel> volumeFormat = new ArrayList<>();
		for (int i = 0; i <= 4; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("volume_format_" + i));
			volumeFormat.add(model);
		}
		return volumeFormat;

	}

	@Override
	public List<DropdownModel> getIssueFormat() {
		List<DropdownModel> issueFormat = new ArrayList<>();
		for (int i = 0; i <= 4; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("issue_format_" + i));
			issueFormat.add(model);
		}
		return issueFormat;

	}

	/*------------------------------------------------------------------------*/

	@Override
	public List<Map<String, Object>> getIssueDetails(Integer ocId) {
		List<Map<String, Object>> issueList = new ArrayList<>();
		try {
			issueList = jdbcTemplate.queryForList("select issue_id,oc_id,inventory_id,issue_date,enumeration,issue_close_date,volume_group_id,generate_revenue,issue_url,analyzed,frozen,enum_volume_nbr,enum_issue_nbr from issue where oc_id = "+ ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return issueList;
	}

	@Override
	public int deleteIssue(Integer issueId, Integer ocId) {
		int status = 0;
		String deleteIssue = ("delete from issue where issue_id=" + issueId + " and oc_id=" + ocId);
		try {
			 status = jdbcTemplate.update(deleteIssue);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int reOpenIssue(int ocId, int issueId) {
		Map<String, Object> reOpenIssueParams = new HashMap<>();
		int status = 0;
		try {
			StringBuilder updateQuery = new StringBuilder("update issue set issue_close_date = null where oc_id = "+ocId+" and issue_id < "+issueId);
			namedParameterJdbcTemplate.update(updateQuery.toString(), reOpenIssueParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int markCurrentIssue(int ocId, int issueId) {
		Map<String, Object> currentIssueParams = new HashMap<>();
		int status = 0;
		try {
			StringBuilder updateQuery = new StringBuilder("update issue set issue_close_date = getdate() where oc_id = "+ocId+" and issue_id < "+issueId+" and issue_close_date is null");
			namedParameterJdbcTemplate.update(updateQuery.toString(), currentIssueParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	
	@Override
	public int saveIssue(Issue issue) {
		int status = 0;
		StringBuilder saveQuery = new StringBuilder("insert into issue(issue_id,oc_id,inventory_id,user_code,issue_date,enumeration,issue_close_date,audit_galley_created,audit_galley_sorted,audit_galley_nth_done,volume_group_id,generate_revenue,update_orders,issue_url,analyzed,frozen,enum_volume_nbr,enum_issue_nbr) values(:issue_id,:oc_id,:inventory_id,:user_code,:issue_date,:enumeration,:issue_close_date,:audit_galley_created,:audit_galley_sorted,:audit_galley_nth_done,:volume_group_id,:generate_revenue,:update_orders,:issue_url,:analyzed,:frozen,:enum_volume_nbr,:enum_issue_nbr)");
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			String maxId = jdbcTemplate.queryForObject("select max(issue_id) from issue", String.class);
			if (maxId == null) {
				addSourceParams.put("issue_id", 1);
			} else {
				addSourceParams.put("issue_id", Integer.parseInt(maxId) + 1);
			}
			addSourceParams.put("oc_id", issue.getOcId());
			String maxInvId = jdbcTemplate.queryForObject("select max(inventory_id) from issue", String.class);
			if (maxInvId == null) {
				addSourceParams.put("inventory_id", 1);
			} else {
				addSourceParams.put("inventory_id", Integer.parseInt(maxInvId) + 1);
			}
			addSourceParams.put("user_code", issue.getUserCode());
			addSourceParams.put("issue_date", issue.getIssueDate());
			if (("null".equals(issue.getEnumeration())) | ("".equals(issue.getEnumeration()))) {
				addSourceParams.put("enumeration", null);
			} else {
				addSourceParams.put("enumeration", issue.getEnumeration());
			}
			addSourceParams.put("issue_close_date",issue.getIssueCloseDate() != null ? issue.getIssueCloseDate() : null);
			addSourceParams.put("audit_galley_created", 0);
			addSourceParams.put("audit_galley_sorted", 0);
			addSourceParams.put("audit_galley_nth_done", 0);
			addSourceParams.put("volume_group_id", issue.getVolumeGroupId() != null ? issue.getVolumeGroupId() : null);
			addSourceParams.put("generate_revenue", issue.getGenerateRevenue());
			addSourceParams.put("update_orders", issue.getUpdateOrders());
			addSourceParams.put("issue_url", issue.getIssueUrl());
			if (("null".equals(issue.getIssueUrl())) | ("".equals(issue.getIssueUrl()))) {
				addSourceParams.put("issue_url", null);
			} else {
				addSourceParams.put("issue_url", issue.getIssueUrl());
			}
			addSourceParams.put("analyzed", 0);
			addSourceParams.put("frozen", 0);
			addSourceParams.put("enum_volume_nbr", issue.getEnumVolumeNbr() != null ? issue.getEnumVolumeNbr() : null);
			addSourceParams.put("enum_issue_nbr", issue.getEnumIssueNbr() != null ? issue.getEnumIssueNbr() : null);
			namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getIssueId() {
		int issueId = 0;
		try {
			String max = jdbcTemplate.queryForObject("select max(issue_id) from issue", String.class);
			if (max == null) {
				issueId = 0;
			} else {
				issueId = Integer.valueOf(max);
			}
		} catch (Exception e) {
		}
		return issueId;
	}

	@Override
	public List<DropdownModel> getLocation() {
		List<Map<String, Object>> Location = new ArrayList<>();
		List<DropdownModel> locationList = new ArrayList<>();
		try {
			Location = jdbcTemplate.queryForList("select inv_location_id,location,description from inv_location");
			for (Map<String, Object> location : Location) {
				DropdownModel model = new DropdownModel();
				model.setKey(location.get("inv_location_id").toString());
				model.setDisplay(location.get("Location").toString());
				model.setDescription(location.get("description") == null ? location.get("description").toString() : "");
				locationList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return locationList;
	}

	@Override
	public List<DropdownModel> getVolumeGroup() {
		List<Map<String, Object>> VolumeGroup = new ArrayList<>();
		List<DropdownModel> volumeGroupList = new ArrayList<>();
		try {
			VolumeGroup = jdbcTemplate.queryForList("select volume_Group_Id,volume from volume_group order by volume_group_id");
			for (Map<String, Object> volumeGroup : VolumeGroup) {
				DropdownModel model = new DropdownModel();
				model.setKey(volumeGroup.get("volume_group_id").toString());
				model.setDisplay(volumeGroup.get("volume") == null ? volumeGroup.get("volume").toString() : "");
				volumeGroupList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return volumeGroupList;
	}

	@Override
	public List<DropdownModel> getInventory() {
		List<Map<String, Object>> Inventory = new ArrayList<>();
		List<DropdownModel> inventoryList = new ArrayList<>();
		try {
			Inventory = jdbcTemplate.queryForList("select inventory_id,inven_code,description from inventory");
			for (Map<String, Object> inventory : Inventory) {
				DropdownModel model = new DropdownModel();
				model.setKey(inventory.get("inventory_id").toString());
				model.setDisplay(inventory.get("inven_code").toString());
				model.setDescription(inventory.get("description") == null ? inventory.get("description").toString() : "");
				inventoryList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return inventoryList;
	}

	@Override
	public int updateIssue(Issue issue) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder("update issue set inventory_id =:inventory_id,user_code =:user_code,issue_date =:issue_date,enumeration =:enumeration,issue_close_date =:issue_close_date,audit_galley_created =:audit_galley_created,audit_galley_sorted =:audit_galley_sorted,audit_galley_nth_done =:audit_galley_nth_done,volume_group_id =:volume_group_id,generate_revenue =:generate_revenue,update_orders =:update_orders,issue_url =:issue_url,analyzed =:analyzed,frozen=:frozen,enum_volume_nbr=:enum_volume_nbr,enum_issue_nbr=:enum_issue_nbr where  issue_id =:issue_id and oc_id=:oc_id");
		Map<String, Object> updateSourceParams = new LinkedHashMap<>();
		try {
			String maxId = jdbcTemplate.queryForObject("select max(issue_id) from issue", String.class);
			if (maxId == null) {
				updateSourceParams.put("issue_id", 1);
			} else {
				updateSourceParams.put("issue_id", Integer.parseInt(maxId) + 1);
			}
			updateSourceParams.put("oc_id", issue.getOcId());
			updateSourceParams.put("inventory_id", issue.getInventoryId() != null ? issue.getInventoryId() : null);
			updateSourceParams.put("user_code", issue.getUserCode());
			updateSourceParams.put("issue_date", issue.getIssueDate());
			if (("null".equals(issue.getEnumeration())) | ("".equals(issue.getEnumeration()))) {
				updateSourceParams.put("enumeration", null);
			} else {
				updateSourceParams.put("enumeration", issue.getEnumeration());
			}
			updateSourceParams.put("issue_close_date",issue.getIssueCloseDate() != null ? issue.getIssueCloseDate() : null);
			updateSourceParams.put("audit_galley_created", issue.getAuditGalleyCreated());
			updateSourceParams.put("audit_galley_sorted", issue.getAuditGalleySorted());
			updateSourceParams.put("audit_galley_nth_done", issue.getAuditGalleyNthDone());
			updateSourceParams.put("volume_group_id",issue.getVolumeGroupId() != null ? issue.getVolumeGroupId() : null);
			updateSourceParams.put("generate_revenue", issue.getGenerateRevenue());
			updateSourceParams.put("update_orders", issue.getUpdateOrders());
			if (("null".equals(issue.getIssueUrl())) | ("".equals(issue.getIssueUrl()))) {
				updateSourceParams.put("issue_url", null);
			} else {
				updateSourceParams.put("issue_url", issue.getIssueUrl());
			}
			updateSourceParams.put("analyzed", issue.getAnalyzed());
			updateSourceParams.put("frozen", issue.getFrozen());
			updateSourceParams.put("enum_volume_nbr",issue.getEnumVolumeNbr() != null ? issue.getEnumVolumeNbr() : null);
			updateSourceParams.put("enum_issue_nbr", issue.getEnumIssueNbr() != null ? issue.getEnumIssueNbr() : null);
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int updateJobModel(JobModel jobModel) {
		int status = 0;
		StringBuilder updateQuery = new StringBuilder("update job set job_id=:job_id,process_id=:process_id,cutoff_date=:cutoff_date,drop_date=:drop_date,note=:note,n_candidate_records=:n_candidate_records,n_selected_records=:n_selected_records,start_date_time=:start_date_time,n_updated_records=:n_updated_records,description=:description,job_priority=:job_priority,queue=:queue,inv_serve_label=:inv_serve_label,has_errors=:has_errors,write_recon_dtl=:write_recon_dtl,upd_recon_tables=:upd_recon_tables,manual_review_fulfillment=:manual_review_fulfillment,status=:status,step_number=:step_number,step_name=:step_name,hold_bits=:hold_bits from job where job_id=:job_id ");
		Map<String, Object> updateSourceParams = new LinkedHashMap<>();
		try {
			updateSourceParams.put("job_id", jobModel.getJobId());
			updateSourceParams.put("process_id", jobModel.getProcessId());
			updateSourceParams.put("note", jobModel.getNote());
			if (("null".equals(jobModel.getNote())) | ("".equals(jobModel.getNote()))) {
				updateSourceParams.put("note", null);
			} else {
				updateSourceParams.put("note", jobModel.getNote());
			}
			updateSourceParams.put("start_date_time", jobModel.getStartDateTime());
			if (("null".equals(jobModel.getStartDateTime())) | ("".equals(jobModel.getStartDateTime()))) {
				updateSourceParams.put("start_date_time", null);
			} else {
				updateSourceParams.put("start_date_time", jobModel.getStartDateTime());
			}
			updateSourceParams.put("job_priority", jobModel.getJobPriority());
			updateSourceParams.put("queue", jobModel.getQueue());
			if (("null".equals(jobModel.getQueue())) | ("".equals(jobModel.getQueue()))) {
				updateSourceParams.put("queue", null);
			} else {
				updateSourceParams.put("queue", jobModel.getQueue());
			}
			updateSourceParams.put("inv_serve_label", jobModel.getInvServeLabel());
			updateSourceParams.put("has_errors", jobModel.getHasError());
			updateSourceParams.put("write_recon_dtl", jobModel.getWriteReconDtl());
			updateSourceParams.put("upd_recon_tables", jobModel.getUpdReconTables());
			updateSourceParams.put("manual_review_fulfillment", jobModel.getManualReviewFulfillment());
			updateSourceParams.put("status", jobModel.getStatus());
			updateSourceParams.put("step_number", jobModel.getStepNumber());
			updateSourceParams.put("hold_bits", jobModel.getHoldJob());
			updateSourceParams.put("incl_pkg_members", jobModel.getInclPkgMembers());
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getJobId() {
		int jobId = 0;
		try {
			String max = jdbcTemplate.queryForObject("select max(job_id) from job", String.class);
			if (max == null) {
				jobId = 0;
			} else {
				jobId = Integer.valueOf(max);
			}
		} catch (Exception e) {
		}
		return jobId;
	}

	@Override
	public List<DropdownModel> getQueue() {
		List<Map<String, Object>> Queue = new ArrayList<>();
		List<DropdownModel> queueList = new ArrayList<>();
		try {
			Queue = jdbcTemplate.queryForList("select queue,description from queue");
			for (Map<String, Object> jobQueue : Queue) {
				DropdownModel model = new DropdownModel();
				model.setKey(jobQueue.get("job_id").toString());
				model.setDisplay(jobQueue.get("queue") == null ? jobQueue.get("queue").toString() : "");
				model.setDescription(jobQueue.get("description") == null ? jobQueue.get("description").toString() : "");
				queueList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return queueList;
	}

	@Override
	public List<DropdownModel> getLogicalStart() {
		List<DropdownModel> logicalStart = new ArrayList<>();
		for (int i = 0; i <= 12; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("logical_start_" + i));
			logicalStart.add(model);
		}
		return logicalStart;
	}

	@Override
	public List<DropdownModel> getForcedExpireMonth() {
		List<DropdownModel> forcedExpireMonth = new ArrayList<>();
		for (int i = 0; i <= 12; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("forced_expire_month_" + i));
			forcedExpireMonth.add(model);
		}
		return forcedExpireMonth;
	}

	@Override
	public List<DropdownModel> getCancelPolicy() {
		List<Map<String, Object>> cancelPolicy = new ArrayList<>();
		List<DropdownModel> cancelPolicyList = new ArrayList<>();
		try {
			cancelPolicy = jdbcTemplate.queryForList("select cancel_policy_id, description, range_type, penalty from cancel_policy");
			for (Map<String, Object> cancel : cancelPolicy) {
				DropdownModel model = new DropdownModel();
				model.setKey(cancel.get("cancel_policy_id").toString());
				model.setDescription(cancel.get("description").toString());
				model.setDisplay(cancel.get("penalty").toString());
				model.setExtra(new PropertyUtils().getConstantValue("range_type_" + cancel.get("range_type").toString()));
				cancelPolicyList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return cancelPolicyList;
	}

	@Override
	public List<SubscriptionDef> getSubscriptionDef(Long ocId) {
		List<SubscriptionDef> subscriptionDefList = new ArrayList<>();
		StringBuilder query = new StringBuilder(" select subscription_def.subscription_def_id, subscription_def.subscription_def, subscription_def.pub_rotation_id, subscription_def.oc_id, subscription_def.description,  ");
		query.append(" subscription_def.media, subscription_def.edition, subscription_def.subscription_category_id, subscription_def.allow_on_internet, subscription_def.tag_line, subscription_def.issn, ");
		query.append(" subscription_def.expire_gap, subscription_def.logical_start, subscription_def.auxiliary_1, subscription_def.auxiliary_2,  ");
		query.append(" subscription_def.forced_expire_month, subscription_def.upgrade_downgrade_value, subscription_def.cancel_policy_id, subscription_def.inactive, ");
		query.append(" order_code.order_code, rate_class.rate_class, renewal_card.renewal_card, term.term, od.order_code as premium_order_code ");
		query.append(" from subscription_def  ");
		query.append(" left join order_code on subscription_def.order_code_id = order_code.order_code_id  ");
		query.append(" left join rate_class on subscription_def.rate_class_id = rate_class.rate_class_id ");
		query.append(" left join renewal_card on subscription_def.renewal_card_id = renewal_card.renewal_card_id  ");
		query.append(" left join term on subscription_def.term_id = term.term_id  ");
		query.append(" left join order_code od on od.order_code_id=subscription_def.premium_order_code_id  ");
		query.append(" where subscription_def.oc_id= "+ocId);
		try {
			subscriptionDefList = namedParameterJdbcTemplate.query(query.toString(), new SubscriptionDefMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptionDefList;
	}

	@Override
	public int saveSubscriptionDef(SubscriptionDef subscriptionDef) {
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(" insert into subscription_def(subscription_def_id, subscription_def ,term_id, pub_rotation_id, oc_id, rate_class_id, description, media, edition, renewal_card_id, order_code_id , "
				+ "subscription_category_id, allow_on_internet, tag_line, issn, expire_gap, logical_start, auxiliary_1, auxiliary_2 , forced_expire_month, upgrade_downgrade_value, cancel_policy_id, inactive, premium_order_code_id) "
				+ "values ( :subscription_def_id, :subscription_def, :term_id, :pub_rotation_id, :oc_id, :rate_class_id, :description , :media, :edition, :renewal_card_id, :order_code_id, :subscription_category_id, :allow_on_internet, "
				+ ":tag_line, :issn , :expire_gap, :logical_start, :auxiliary_1, :auxiliary_2, :forced_expire_month, :upgrade_downgrade_value, :cancel_policy_id , :inactive, :premium_order_code_id) ");
		try {
			String maxId = jdbcTemplate.queryForObject("select max(subscription_def_id) from subscription_def",String.class);
			if (maxId == null) {
				addSourceParams.put("subscription_def_id", 1);
			} else {
				addSourceParams.put("subscription_def_id", Integer.parseInt(maxId) + 1);
			}
			addSourceParams.put("subscription_def", subscriptionDef.getSubscriptionDef());
			addSourceParams.put("term_id", subscriptionDef.getTermId());
			if (("null".equals(subscriptionDef.getPubRotationId())) | "".equals(subscriptionDef.getPubRotationId())) {
				addSourceParams.put("pub_rotation_id", null);
			} else {
				addSourceParams.put("pub_rotation_id", subscriptionDef.getPubRotationId());
			}
			addSourceParams.put("oc_id", subscriptionDef.getOcId());
			if (("null".equals(subscriptionDef.getRateClassId())) | ("".equals(subscriptionDef.getRateClassId()))) {
				addSourceParams.put("rate_class_id", null);
			} else {
				addSourceParams.put("rate_class_id", subscriptionDef.getRateClassId());
			}
			if (("null".equals(subscriptionDef.getDescription())) | ("".equals(subscriptionDef.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", subscriptionDef.getDescription());
			}
			if (("null".equals(subscriptionDef.getMedia())) | ("".equals(subscriptionDef.getMedia()))) {
				addSourceParams.put("media", null);
			} else {
				addSourceParams.put("media", subscriptionDef.getMedia());
			}
			if (("null".equals(subscriptionDef.getEdition())) | ("".equals(subscriptionDef.getEdition()))) {
				addSourceParams.put("edition", null);
			} else {
				addSourceParams.put("edition", subscriptionDef.getEdition());
			}
			if (("null".equals(subscriptionDef.getRenewalCardId())) | "".equals(subscriptionDef.getRenewalCardId())) {
				addSourceParams.put("renewal_card_id", null);
			} else {
				addSourceParams.put("renewal_card_id", subscriptionDef.getRenewalCardId());
			}
			addSourceParams.put("order_code_id", subscriptionDef.getOrderCodeId());
			if (("null".equals(subscriptionDef.getSubscriptionCategoryId())) | "".equals(subscriptionDef.getSubscriptionCategoryId())) {
				addSourceParams.put("subscription_category_id", null);
			} else {
				addSourceParams.put("subscription_category_id", subscriptionDef.getSubscriptionCategoryId() == "" ? null: subscriptionDef.getSubscriptionCategoryId());
			}
			addSourceParams.put("allow_on_internet",subscriptionDef.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			if (("null".equals(subscriptionDef.getTagLine())) | ("".equals(subscriptionDef.getTagLine()))) {
				addSourceParams.put("tag_line", null);
			} else {
				addSourceParams.put("tag_line", subscriptionDef.getTagLine());
			}
			if (("null".equals(subscriptionDef.getIssn())) | ("".equals(subscriptionDef.getIssn()))) {
				addSourceParams.put("issn", null);
			} else {
				addSourceParams.put("issn", subscriptionDef.getIssn());
			}
			addSourceParams.put("expire_gap", subscriptionDef.getExpireGap());
			addSourceParams.put("logical_start", subscriptionDef.getLogicalStart());
			if (("null".equals(subscriptionDef.getAuxiliary1())) | ("".equals(subscriptionDef.getAuxiliary1()))) {
				addSourceParams.put("auxiliary_1", null);
			} else {
				addSourceParams.put("auxiliary_1", subscriptionDef.getAuxiliary1());
			}
			if (("null".equals(subscriptionDef.getAuxiliary2())) | ("".equals(subscriptionDef.getAuxiliary2()))) {
				addSourceParams.put("auxiliary_2", null);
			} else {
				addSourceParams.put("auxiliary_2", subscriptionDef.getAuxiliary2());
			}
			addSourceParams.put("forced_expire_month", subscriptionDef.getForcedExpireMonth());
			if (("null".equals(subscriptionDef.getUpgradeDowngradeValue())) | ("".equals(subscriptionDef.getUpgradeDowngradeValue()))) {
				addSourceParams.put("upgrade_downgrade_value", null);
			} else {
				addSourceParams.put("upgrade_downgrade_value", subscriptionDef.getUpgradeDowngradeValue());
			}
			if (("null".equals(subscriptionDef.getCancelPolicyId())) | ("".equals(subscriptionDef.getCancelPolicyId()))) {
				addSourceParams.put("cancel_policy_id", null);
			} else {
				addSourceParams.put("cancel_policy_id", subscriptionDef.getCancelPolicyId());
			}
			addSourceParams.put("inactive", subscriptionDef.getInactive().equalsIgnoreCase("true") ? 1 : 0);
			if (("null".equals(subscriptionDef.getPremiumOrderCodeId())) | ("".equals(subscriptionDef.getPremiumOrderCodeId()))) {
				addSourceParams.put("premium_order_code_id", null);
			} else {
				addSourceParams.put("premium_order_code_id", subscriptionDef.getPremiumOrderCodeId());
			}
			namedParameterJdbcTemplate.update(saveQuery.toString(), addSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getSubscriptionDefId() {
		int subscriptionDefId = 0;
		try {
			String max = jdbcTemplate.queryForObject("select max(subscription_def_id) from subscription_def",String.class);
			if (max == null) {
				subscriptionDefId = 0;
			} else {
				subscriptionDefId = Integer.valueOf(max);
			}
		} catch (Exception e) {
		}
		return subscriptionDefId;
	}

	@Override
	public int updateSubscriptionDef(SubscriptionDef subscriptionDef) {
		Map<String, Object> updateSourceParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder(" update subscription_def  set subscription_def_id =:subscription_def_id, subscription_def =:subscription_def, term_id =:term_id, "
				+ "pub_rotation_id =:pub_rotation_id, oc_id =:oc_id, rate_class_id =:rate_class_id, description =:description, media =:media, edition =:edition, renewal_card_id =:renewal_card_id, "
				+ "order_code_id =:order_code_id, subscription_category_id =:subscription_category_id, allow_on_internet =:allow_on_internet, tag_line =:tag_line, issn =:issn, expire_gap =:expire_gap, "
				+ "logical_start =:logical_start, auxiliary_1 =:auxiliary_1, auxiliary_2 =:auxiliary_2, forced_expire_month =:forced_expire_month, upgrade_downgrade_value =:upgrade_downgrade_value, "
				+ "cancel_policy_id =:cancel_policy_id, inactive =:inactive, premium_order_code_id =:premium_order_code_id where subscription_def_id =:subscription_def_id and oc_id =:oc_id");
		try {
			updateSourceParams.put("subscription_def_id", subscriptionDef.getSubscriptionDefId());
			updateSourceParams.put("subscription_def", subscriptionDef.getSubscriptionDef());
			updateSourceParams.put("term_id", subscriptionDef.getTermId());
			if (("null".equals(subscriptionDef.getPubRotationId())) | "".equals(subscriptionDef.getPubRotationId())) {
				updateSourceParams.put("pub_rotation_id", null);
			} else {
				updateSourceParams.put("pub_rotation_id", subscriptionDef.getPubRotationId());
			}
			updateSourceParams.put("oc_id", subscriptionDef.getOcId());
			if (("null".equals(subscriptionDef.getRateClassId())) | ("".equals(subscriptionDef.getRateClassId()))) {
				updateSourceParams.put("rate_class_id", null);
			} else {
				updateSourceParams.put("rate_class_id", subscriptionDef.getRateClassId());
			}
			if (("null".equals(subscriptionDef.getDescription())) | ("".equals(subscriptionDef.getDescription()))) {
				updateSourceParams.put("description", null);
			} else {
				updateSourceParams.put("description", subscriptionDef.getDescription());
			}
			if (("null".equals(subscriptionDef.getMedia())) | ("".equals(subscriptionDef.getMedia()))) {
				updateSourceParams.put("media", null);
			} else {
				updateSourceParams.put("media", subscriptionDef.getMedia());
			}
			if (("null".equals(subscriptionDef.getEdition())) | ("".equals(subscriptionDef.getEdition()))) {
				updateSourceParams.put("edition", null);
			} else {
				updateSourceParams.put("edition", subscriptionDef.getEdition());
			}
			updateSourceParams.put("renewal_card_id",subscriptionDef.getRenewalCardId() != null ? subscriptionDef.getRenewalCardId() : "");
			if (("null".equals(subscriptionDef.getRenewalCardId())) | "".equals(subscriptionDef.getRenewalCardId())) {
				updateSourceParams.put("renewal_card_id", null);
			} else {
				updateSourceParams.put("renewal_card_id", subscriptionDef.getRenewalCardId());
			}
			updateSourceParams.put("order_code_id", subscriptionDef.getOrderCodeId());
			if (("null".equals(subscriptionDef.getSubscriptionCategoryId())) | "".equals(subscriptionDef.getSubscriptionCategoryId())) {
				updateSourceParams.put("subscription_category_id", null);
			} else {
				updateSourceParams.put("subscription_category_id",subscriptionDef.getSubscriptionCategoryId() == "" ? null: subscriptionDef.getSubscriptionCategoryId());
			}
			updateSourceParams.put("allow_on_internet",subscriptionDef.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			if (("null".equals(subscriptionDef.getTagLine())) | ("".equals(subscriptionDef.getTagLine()))) {
				updateSourceParams.put("tag_line", null);
			} else {
				updateSourceParams.put("tag_line", subscriptionDef.getTagLine());
			}
			if (("null".equals(subscriptionDef.getIssn())) | ("".equals(subscriptionDef.getIssn()))) {
				updateSourceParams.put("issn", null);
			} else {
				updateSourceParams.put("issn", subscriptionDef.getIssn());
			}
			updateSourceParams.put("expire_gap", subscriptionDef.getExpireGap());
			updateSourceParams.put("logical_start", subscriptionDef.getLogicalStart());
			if (("null".equals(subscriptionDef.getAuxiliary1())) | ("".equals(subscriptionDef.getAuxiliary1()))) {
				updateSourceParams.put("auxiliary_1", null);
			} else {
				updateSourceParams.put("auxiliary_1", subscriptionDef.getAuxiliary1());
			}
			if (("null".equals(subscriptionDef.getAuxiliary2())) | ("".equals(subscriptionDef.getAuxiliary2()))) {
				updateSourceParams.put("auxiliary_2", null);
			} else {
				updateSourceParams.put("auxiliary_2", subscriptionDef.getAuxiliary2());
			}
			updateSourceParams.put("forced_expire_month", subscriptionDef.getForcedExpireMonth());
			if (("null".equals(subscriptionDef.getUpgradeDowngradeValue())) | ("".equals(subscriptionDef.getUpgradeDowngradeValue()))) {
				updateSourceParams.put("upgrade_downgrade_value", null);
			} else {
				updateSourceParams.put("upgrade_downgrade_value", subscriptionDef.getUpgradeDowngradeValue());
			}
			if (("null".equals(subscriptionDef.getCancelPolicyId())) | ("".equals(subscriptionDef.getCancelPolicyId()))) {
				updateSourceParams.put("cancel_policy_id", null);
			} else {
				updateSourceParams.put("cancel_policy_id", subscriptionDef.getCancelPolicyId());
			}
			updateSourceParams.put("inactive", subscriptionDef.getInactive().equalsIgnoreCase("true") ? 1 : 0);
			if (("null".equals(subscriptionDef.getPremiumOrderCodeId())) | ("".equals(subscriptionDef.getPremiumOrderCodeId()))) {
				updateSourceParams.put("premium_order_code_id", null);
			} else {
				updateSourceParams.put("premium_order_code_id", subscriptionDef.getPremiumOrderCodeId());
			}
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateSourceParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public String deleteSubscriptionDef(int subscriptionDefId) {
		StringBuilder returnStatus = new StringBuilder();
		int status = 0;
		StringBuilder deleteQuery = new StringBuilder(" delete subscription_def FROM subscription_def "
				+ "left join package_content on subscription_def.subscription_def_id = package_content.subscription_def_id "
				+ "left join ren_card_order_code on subscription_def.subscription_def_id = ren_card_order_code.subscription_def_id "
				+ "left join job_ren_offer_detail on subscription_def.subscription_def_id = job_ren_offer_detail.subscription_def_id "
				+ "left join order_item on subscription_def.subscription_def_id = order_item.subscription_def_id "
				+ "left join promotion_hist_offer on subscription_def.subscription_def_id = promotion_hist_offer.subscription_def_id "
				+ "left join promotion_card_offer on subscription_def.subscription_def_id = promotion_card_offer.subscription_def_id "
				+ "left join work_promotion_offer on subscription_def.subscription_def_id = work_promotion_offer.subscription_def_id "
				+ "left join catalog_content on subscription_def.subscription_def_id = catalog_content.subscription_def_id "
				+ "left join generic_promotion on subscription_def.subscription_def_id = generic_promotion.subscription_def_id "
				+ "left join quick_order_content on subscription_def.subscription_def_id = quick_order_content.subscription_def_id "
				+ "left join pkg_def_content on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id "
				+ "where subscription_def.subscription_def_id = "+subscriptionDefId);
		try {
			status = jdbcTemplate.update(deleteQuery.toString());
			returnStatus.append(status);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
		return returnStatus.toString();
	}

	@Override
	public List<DropdownModel> getPremiumDetails(Long ocId) {
		List<DropdownModel> Premium = new ArrayList<>();
		try {
			List<Map<String, Object>> premium = jdbcTemplate.queryForList("select order_code.order_code,order_code.description,order_code.order_code_type FROM  subscription_def inner join order_code ON subscription_def.premium_order_code_id = order_code.order_code_id where subscription_def.oc_id="+ ocId);
			for (Map<String, Object> Pre : premium) {
				DropdownModel model = new DropdownModel();
				model.setDisplay(Pre.get("order_code").toString());
				model.setDescription(Pre.get("description") != null ? Pre.get("description").toString() : "");
				model.setExtra(new PropertyUtils().getConstantValue("order_code_type_" + Pre.get("order_code_type").toString()));
				Premium.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return Premium;
	}

	@Override
	public List<DropdownModel> getState() {
		List<DropdownModel> states = new ArrayList<>();
		try {
			List<Map<String, Object>> states1 = jdbcTemplate.queryForList("select state,description,country from state");
			for (Map<String, Object> state : states1) {
				DropdownModel model = new DropdownModel();
				model.setKey(state.get("state").toString());
				model.setDescription(state.get("description") != null ? state.get("description").toString() : "");
				model.setDisplay(state.get("country") != null ? state.get("country").toString() : "");
				states.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return states;
	}

	@Override
	public List<DropdownModel> getTimeUnits() {
		List<DropdownModel> trialTypeList = new ArrayList<>();
		try {
			for (int i = 0; i <= 2; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("time_unit_options_" + i));
				trialTypeList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return trialTypeList;
	}

	@Override
	public int addPackageDefSave(PackageDefinationModel packageDefination) {
		int status = 0;
		StringBuilder addPackageQuery = null;
		Map<String, Object> addParams = new LinkedHashMap<>();
		Integer pkgId = null;
		addPackageQuery = new StringBuilder("insert into pkg_def(");
		addPackageQuery.append(
				"pkg_def_id,order_code_id,pkg_def,description,n_calendar_units,calendar_unit,active,discount_class_id ,pkg_price_method,qty_discount_schedule,rate_class_id ,revenue_percentage_option ,renewal_card_id , pkg_price,oc_id,subscriber_site_allowance_type,pkg_contents_together,multiline_discount_schedule,auxiliary_1,auxiliary_2,pkg_start_match_order_date,premium_order_code_id)");
		addPackageQuery.append(
				"values(:pkg_def_id,:order_code_id,:pkg_def,:description,:n_calendar_units,:calendar_unit,:active,:discount_class_id,:pkg_price_method,:qty_discount_schedule,:rate_class_id,:revenue_percentage_option,:renewal_card_id,:pkg_price,:oc_id,:subscriber_site_allowance_type,:pkg_contents_together,:multiline_discount_schedule,:auxiliary_1,:auxiliary_2,:pkg_start_match_order_date,:premium_order_code_id)");
		try {
			pkgId = jdbcTemplate.queryForObject("select Max(id) from mru_pkg_def_id", Integer.class);

			if (pkgId == null) {
				addParams.put("pkg_def_id", 1);
			} else {
				addParams.put("pkg_def_id", pkgId + 1);
				LOGGER.info("pkg_def_id:{}", pkgId);
			}

			addParams.put("order_code_id",
					packageDefination.getOrderCodeId() != 0 ? packageDefination.getOrderCodeId() : null);
			addParams.put("pkg_def", packageDefination.getPkgDef());
			addParams.put("description", packageDefination.getDescription());
			addParams.put("n_calendar_units", packageDefination.getnCalendarUnits());
			addParams.put("calendar_unit", packageDefination.getCalendarunit());
			addParams.put("active",
					String.valueOf(packageDefination.getActive()) != null ? packageDefination.getActive() : 0);
			addParams.put("discount_class_id",
					packageDefination.getDiscountClassId() != 0 ? packageDefination.getDiscountClassId() : null);
			addParams.put("pkg_price_method", packageDefination.getPkgPriceMethod());
			addParams.put("qty_discount_schedule", packageDefination.getQtyDiscountSchedule());
			addParams.put("rate_class_id",
					packageDefination.getRateClassId() != 0 ? packageDefination.getRateClassId() : null);
			addParams.put("revenue_percentage_option", packageDefination.getRevenuePercentageOption());
			addParams.put("renewal_card_id",
					packageDefination.getRenewalCardId() != 0 ? packageDefination.getRenewalCardId() : null);
			addParams.put("pkg_price", packageDefination.getPkgPrice());
			addParams.put("oc_id", packageDefination.getOcId() != 0 ? packageDefination.getOcId() : null);
			addParams.put("subscriber_site_allowance_type", packageDefination.getSubscriberSiteAllowanceType());
			addParams.put("pkg_contents_together",
					String.valueOf(packageDefination.getPkgContentsTogether()) != null
							? packageDefination.getPkgContentsTogether()
							: 0);
			addParams.put("multiline_discount_schedule", packageDefination.getMutiLineDiscountSchedule());
			addParams.put("auxiliary_1", packageDefination.getAuxiliary_1());
			addParams.put("auxiliary_2", packageDefination.getAuxiliary_2());
			addParams.put("pkg_start_match_order_date",
					String.valueOf(packageDefination.getPkgStartMatchOrderDate()) != null
							? packageDefination.getPkgStartMatchOrderDate()
							: 0);
			addParams.put("premium_order_code_id",
					packageDefination.getPremiumOrderCodeId() != 0 ? packageDefination.getPremiumOrderCodeId() : null);
			status = namedParameterJdbcTemplate.update(addPackageQuery.toString(), addParams);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updatePackageDef(PackageDefinationModel packageDefination, int pkgDefId) {
		StringBuilder query = new StringBuilder("update pkg_def set ");
		query.append("order_code_id =:order_code_id,");
		query.append("pkg_def=:pkg_def,");
		query.append("description=:description,");
		query.append("n_calendar_units=:n_calendar_units,");
		query.append("calendar_unit=:calendar_unit,");
		query.append("active=:active,");
		query.append("discount_class_id=:discount_class_id,");
		query.append("pkg_price_method=:pkg_price_method,");
		query.append("qty_discount_schedule=:qty_discount_schedule,");
		query.append("rate_class_id=:rate_class_id,");
		query.append("revenue_percentage_option=:revenue_percentage_option,");
		query.append("renewal_card_id=:renewal_card_id,");
		query.append("pkg_price=:pkg_price,");
		query.append("oc_id=:oc_id,");
		query.append("subscriber_site_allowance_type=:subscriber_site_allowance_type,");
		query.append("pkg_contents_together=:pkg_contents_together,");
		query.append("multiline_discount_schedule=:multiline_discount_schedule,");
		query.append("auxiliary_1=:auxiliary_1,");
		query.append("auxiliary_2=:auxiliary_2,");
		query.append("pkg_start_match_order_date=:pkg_start_match_order_date,");
		query.append("premium_order_code_id=:premium_order_code_id ");
		query.append("where pkg_def_id= ");
		query.append(pkgDefId);
		int status = 0;
		Map<String, Object> updateParams = null;
		try {
			updateParams = new LinkedHashMap<>();
			updateParams.put("pkg_def_id", packageDefination.getPkgDefId());
			updateParams.put("order_code_id",
					packageDefination.getOrderCodeId() != 0 ? packageDefination.getOrderCodeId() : null);
			updateParams.put("pkg_def", packageDefination.getPkgDef());
			updateParams.put("description", packageDefination.getDescription());
			updateParams.put("n_calendar_units", packageDefination.getnCalendarUnits());
			updateParams.put("calendar_unit", packageDefination.getCalendarunit());
			updateParams.put("active",
					String.valueOf(packageDefination.getActive()) != null ? packageDefination.getActive() : 0);
			updateParams.put("discount_class_id",
					packageDefination.getDiscountClassId() != 0 ? packageDefination.getDiscountClassId() : null);
			updateParams.put("pkg_price_method", packageDefination.getPkgPriceMethod());
			updateParams.put("qty_discount_schedule", packageDefination.getQtyDiscountSchedule());
			updateParams.put("rate_class_id",
					packageDefination.getRateClassId() != 0 ? packageDefination.getRateClassId() : null);
			updateParams.put("revenue_percentage_option", packageDefination.getRevenuePercentageOption());
			updateParams.put("renewal_card_id",
					packageDefination.getRenewalCardId() != 0 ? packageDefination.getRenewalCardId() : null);
			updateParams.put("pkg_price", packageDefination.getPkgPrice());
			updateParams.put("oc_id", packageDefination.getOcId() != 0 ? packageDefination.getOcId() : null);
			updateParams.put("subscriber_site_allowance_type", packageDefination.getSubscriberSiteAllowanceType());
			updateParams.put("pkg_contents_together",
					String.valueOf(packageDefination.getPkgContentsTogether()) != null
							? packageDefination.getPkgContentsTogether()
							: 0);
			updateParams.put("multiline_discount_schedule", packageDefination.getMutiLineDiscountSchedule());
			updateParams.put("auxiliary_1", packageDefination.getAuxiliary_1());
			updateParams.put("auxiliary_2", packageDefination.getAuxiliary_2());
			updateParams.put("pkg_start_match_order_date",
					String.valueOf(packageDefination.getPkgStartMatchOrderDate()) != null
							? packageDefination.getPkgStartMatchOrderDate()
							: 0);
			updateParams.put("premium_order_code_id",
					packageDefination.getPremiumOrderCodeId() != 0 ? packageDefination.getPremiumOrderCodeId() : null);
			status = namedParameterJdbcTemplate.update(query.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deletePackageDetails(int pkgDefId) {
		int status = 0;
		String deleteQuery = "delete from pkg_def where pkg_def_id=?";
		try {
			status = jdbcTemplate.update(deleteQuery, Integer.valueOf(pkgDefId));
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId) {
		List<Map<String, Object>> packageDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder("select pkg_def_id,order_code_id,");
		query.append("pkg_def,description,n_calendar_units,calendar_unit,active,discount_class_id ,");
		query.append("pkg_price_method,qty_discount_schedule,rate_class_id ,revenue_percentage_option ,");
		query.append("renewal_card_id , pkg_price,oc_id,subscriber_site_allowance_type,pkg_contents_together,");
		query.append(
				"multiline_discount_schedule,auxiliary_1,auxiliary_2,pkg_start_match_order_date,premium_order_code_id from pkg_def");
		query.append(" where pkg_def_id=");
		query.append(pkgDefId);
		query.append(" and oc_id=");
		query.append(ocId);
		try {
			packageDetails = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return packageDetails;
	}

	@Override
	public List<DropdownModel> getMethodList() {
		List<DropdownModel> methodList = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("pkg_price_method" + i));
			methodList.add(model);
		}
		return methodList;
	}

	@Override
	public List<DropdownModel> getCalendarUnits() {
		List<DropdownModel> calendarUnits = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("n_calendar_units" + i));
			calendarUnits.add(model);
		}
		return calendarUnits;
	}

	@Override
	public List<DropdownModel> getSubscriberSiteType() {
		List<DropdownModel> subscriberSiteType = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("subscriber_site_allowance_type" + i));
			subscriberSiteType.add(model);
		}
		return subscriberSiteType;
	}

	@Override
	public List<DropdownModel> getRevenueOption() {
		List<DropdownModel> revenueOption = new ArrayList<>();
		for (int i = 0; i <= 1; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("revenue_percentage_option" + i));
			revenueOption.add(model);
		}
		return revenueOption;
	}

	@Override
	public List<DropdownModel> getRenewalList() {
		List<Map<String, Object>> renewalList = null;
		List<DropdownModel> renewalDataList = null;
		DropdownModel model = null;
		String query = null;
		try {
			renewalList = new ArrayList<>();
			renewalDataList = new ArrayList<>();
			query = "select renewal_card,description, oc_id from renewal_card ";
			renewalList = jdbcTemplate.queryForList(query);
			for (Map<String, Object> renewal : renewalList) {
				model = new DropdownModel();
				model.setKey(renewal.get("renewal_card") != null ? (String) renewal.get("renewal_card") : "");
				model.setDisplay(renewal.get("description") != null ? (String) renewal.get("description") : "");
				model.setExtra(renewal.get("oc_id").toString());
				renewalDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return renewalDataList;
	}

	@Override
	public List<DropdownModel> getDiscountList() {
		List<Map<String, Object>> discountList = null;
		List<DropdownModel> discountDataList = null;
		DropdownModel model = null;
		String query = null;
		try {
			discountList = new ArrayList<>();
			discountDataList = new ArrayList<>();
			query = "select discount_class,description,is_package from discount_class";
			discountList = jdbcTemplate.queryForList(query);
			for (Map<String, Object> discount : discountList) {
				model = new DropdownModel();
				model.setKey(discount.get("discount_class") != null ? (String) discount.get("discount_class") : "");
				model.setDisplay(discount.get("description") != null ? (String) discount.get("description") : "");
				model.setExtra(discount.get("is_package").toString());
				discountDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return discountDataList;
	}

	@Override
	public List<DropdownModel> getRateList() {
		List<Map<String, Object>> rateList = null;
		List<DropdownModel> rateDataList = null;
		DropdownModel model = null;
		String query = null;
		try {
			rateList = new ArrayList<>();
			rateDataList = new ArrayList<>();
			query = "select rate_class,description,is_package from rate_class";
			rateList = jdbcTemplate.queryForList(query);
			for (Map<String, Object> rate : rateList) {
				model = new DropdownModel();
				model.setKey(rate.get("rate_class") != null ? (String) rate.get("rate_class") : "");
				model.setDisplay(rate.get("description") != null ? (String) rate.get("description") : "");
				model.setExtra(rate.get("is_package").toString());
				rateDataList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateDataList;
	}

	@Override
	public List<Map<String, Object>> getCheckValues(int pkgDefId) {
		List<Map<String, Object>> checkvalues = new ArrayList<>();
		try {
			checkvalues = jdbcTemplate.queryForList(
					"select active,pkg_contents_together,pkg_start_match_order_date from pkg_def where pkg_def_id="
							+ pkgDefId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return checkvalues;
	}

	@Override
	public List<Map<String, Object>> getIssueByValue(String issueDate, Integer issueId, String enumeration,
			String volume_group, String description) {
		LOGGER.info("inside getIssueBy Value();....");
		List<Map<String, Object>> details = new ArrayList<>();
		if (issueDate != null) {
			details = jdbcTemplate.queryForList(
					"select issue.issue_id,issue.issue_date,issue.enumeration,issue.oc_id,volume_group.volume as volume_group \r\n"
							+ "from volume_group inner join issue \r\n"
							+ "on issue.volume_group_id=volume_group.volume_group_id \r\n" + "where issue.issue_date="
							+ issueDate);

			return details;

		}
		if (issueId != null) {

			details = jdbcTemplate.queryForList(
					"select issue.issue_id,issue.issue_date,issue.enumeration,issue.oc_id,volume_group.volume as volume_group \r\n"
							+ "from volume_group inner join issue \r\n"
							+ "on issue.volume_group_id=volume_group.volume_group_id \r\n" + "where issue.issue_id="
							+ issueId);
			return details;
		}

		if (enumeration != null) {
			details = jdbcTemplate.queryForList(
					"select issue.issue_id,issue.issue_date,issue.enumeration,issue.oc_id,volume_group.volume as volume_group \r\n"
							+ "from volume_group inner join issue \r\n"
							+ "on issue.volume_group_id=volume_group.volume_group_id \r\n" + "where issue.enumeration="
							+ enumeration);

			return details;

		}
		if (volume_group != null) {
			details = jdbcTemplate.queryForList(
					"select issue.issue_id,issue.issue_date,issue.enumeration,issue.oc_id,volume_group.volume as volume_group \r\n"
							+ "from volume_group inner join issue \r\n"
							+ "on issue.volume_group_id=volume_group.volume_group_id \r\n" + "where issue.volume_group="
							+ volume_group);

			return details;

		}
		if (issueId != null && description != null) {
			details = jdbcTemplate.queryForList(
					"select issue.issue_id,issue.issue_date,issue.enumeration,issue.oc_id,volume_group.volume as volume_group \r\n"
							+ "from volume_group inner join issue \r\n"
							+ "on issue.volume_group_id=volume_group.volume_group_id \r\n" + "where issue.issue_id ="
							+ issueId);

			return details;

		}

		return null;

	}

	@Override
	public List<Map<String, Object>> getAddressDetails() {
		LOGGER.info("inside getAddress() method...");
		List<Map<String, Object>> details = new ArrayList<>();
		details = jdbcTemplate
				.queryForList("select address_id,address1 as street,city,state,zip as postalCode from address");
		return details;
	}

	@Override
	public List<DropdownModel> getVolumeDetails() {
		List<Map<String, Object>> VolumeGroup = new ArrayList<>();
		List<DropdownModel> volumeGroupList = new ArrayList<>();
		try {
			VolumeGroup = jdbcTemplate.queryForList("select volume from volume_group ");
			for (Map<String, Object> volumeGroup : VolumeGroup) {
				DropdownModel model = new DropdownModel();
				model.setKey(volumeGroup.get("volume").toString());

				volumeGroupList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return volumeGroupList;
	}

	@Override
	public List<Map<String, Object>> getOcIdDetails(Integer oc_id) {
		List<Map<String, Object>> ocIdList = new ArrayList<>();
		try {
			ocIdList = jdbcTemplate.queryForList("select oc_id,issue_id from issue where oc_id=" + oc_id);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return ocIdList;
	}

	@Override
	public List<Map<String, Object>> getIssueIdDetails(Integer ocId) {

		List<Map<String, Object>> issueList = new ArrayList<>();
		try {
			issueList = jdbcTemplate.queryForList("select oc_id,issue_id from issue where oc_id=" + ocId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return issueList;
	}

	@Override
	public Map<String, Object> displaySubscriptionstart(Integer ocId, Integer numOfDays, String from_date,
			String to_date, String start_date, Integer numOfIssues, Integer issue_id, String volume, String action,
			String issue_date) {
		int startType;

		System.out.println("actions Service class " + action);

		Map<String, Object> responseObject = new HashMap();
		String actionValue = action.toLowerCase();

		try {
			String issueDat;
			switch (actionValue) {

			case "backstart":
				startType = 3;
				Integer result = jdbcTemplate.queryForObject("select max(issue_id) from issue where oc_id=" + ocId,
						Integer.class);

				System.out.println("result --->" + result);

				Integer backStart = result - numOfIssues;
				List curIssue = jdbcTemplate.queryForList(
						"select issue_date,issue_close_date,volume_group_id,row_version from issue where issue_id="
								+ result);
				List backStartIssue = jdbcTemplate.queryForList(
						"select issue_date,issue_close_date,volume_group_id,row_version from issue where issue_id>="
								+ backStart);
				responseObject.put("backstartIssue", backStartIssue);
				responseObject.put("currentIssue", curIssue);
				responseObject.put("startType", startType);
				break;

			case "current":
				startType = 2;
				Integer currentIssue = jdbcTemplate
						.queryForObject("select max(issue_id) from issue where oc_id=" + ocId, Integer.class);

				List issueDat1 = jdbcTemplate.queryForList(
						"select issue_date,issue_close_date,volume_group_id,row_version from issue where issue_id="
								+ currentIssue);
				responseObject.put("startCurrentIssue", currentIssue);
				responseObject.put("fromDate", issueDat1);
				responseObject.put("startType", startType);

				break;
			case "customstart1":
				startType = 3;
				responseObject.put("from_date", from_date);
				responseObject.put("to_date", to_date);
				String volume_group = null;
				Integer issueId = null;
				String enumeration = null;
				String description = null;
				String issueDate = null;
				responseObject.put("issue_id",
						getIssueByValue(issueDate, issueId, enumeration, volume_group, description));
				responseObject.put("issue_date", issue_date);
				responseObject.put("startType", startType);
				break;

			case "volumegroup":
				startType = 2;
				List volumeDetails = jdbcTemplate.queryForList(
						"select issue.issue_id,issue.issue_date,issue.issue_close_date,volume_group.volume,volume_group.volume_group_id from volume_group inner join issue on issue.volume_group_id=volume_group.volume_group_id where oc_id="
								+ ocId);
				;
				responseObject.put("startType", startType);
				responseObject.put("volumeDetails", volumeDetails);
				break;

			case "currentvolume":
				startType = 5;
				List startDate = jdbcTemplate.queryForList(
						"select issue.issue_date,volume_group.volume from volume_group inner join issue on issue.volume_group_id=volume_group.volume_group_id where volume_group.volume=(select max(volume_group.volume) from volume_group inner join issue on issue.volume_group_id=volume_group.volume_group_id where issue.oc_id ="
								+ ocId + ")");
				System.out.println(startDate);
				List todate = jdbcTemplate.queryForList(
						"select issue.issue_close_date,volume_group.volume from volume_group inner join issue on issue.volume_group_id=volume_group.volume_group_id where volume_group.volume=(select min(volume_group.volume) from volume_group inner join issue on issue.volume_group_id=volume_group.volume_group_id where issue.oc_id ="
								+ ocId + ")");
				responseObject.put("startDate", startDate);
				responseObject.put("startType", startType);
				responseObject.put("to_date", todate);
				break;

			case "customstart2":
				startType = 4;

				responseObject.put("from_date", from_date);
				responseObject.put("to_date", to_date);
				responseObject.put("volume group", getVolumeDetails());
				responseObject.put("oc_id", getOcIdDetails(ocId));
				responseObject.put("issue_id", getIssueIdDetails(issue_id));
				responseObject.put("startType", startType);
				break;

			case "currentdate":
				startType = 0;
				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
				String strDate = dateFormat.format(date);
				System.out.println(strDate);
				Integer result3 = jdbcTemplate.queryForObject("select max(issue_id) from issue where oc_id=" + ocId,
						Integer.class);
				List fromDate = jdbcTemplate.queryForList(
						"select issue_date,issue_close_date,volume_group_id,row_version from issue where oc_Id="
								+ result3);
				System.out.println(fromDate);
				responseObject.put("startDate", strDate);
				responseObject.put("startType", startType);
				responseObject.put("fromDate", strDate);
				break;

			case "currentnumdays":
				startType = 0;
				LocalDate now = LocalDate.now();
				System.out.println(now);
				LocalDate PlusDate = now.plusDays(numOfDays);
				String currentPlusDays = PlusDate.toString().trim();
				responseObject.put("from_date", currentPlusDays);
				responseObject.put("startType", startType);

				break;

			case "customstart3":
				startType = 3;

				responseObject.put("from_date", from_date);
				responseObject.put("to_date", to_date);
				responseObject.put("start_date", start_date);
				responseObject.put("startType", startType);

				break;

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return responseObject;

	}

	@Override
	public int saveSubscriptionstart(SubscriptionStart start) {
		Map<String, Object> saveStart = new HashMap<>();
		int status = 0;
		try {

			StringBuilder saveQuery = new StringBuilder(
					"insert into start_date (oc_id,from_date,start_type,issue_id,to_date,volume_group_id,start_date) values(:oc_id,:from_date,:start_type,:issue_id,:to_date,:volume_group_id,:start_date)");

			saveStart.put("oc_id", start.getOc_id());
			saveStart.put("from_date", start.getFrom_date());
			saveStart.put("start_type", start.getStart_type());
			saveStart.put("issue_id", start.getIssue_id());
			saveStart.put("volume_group_id", start.getVolume_group_id());
			// saveStart.put("row_version", start.getRow_version());
			saveStart.put("to_date", start.getTo_date());
			saveStart.put("start_date", start.getStart_date());
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), saveStart);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public List<DropdownModel> getallPubGroup() {
		LOGGER.info("auditTrackingModel:{}");

		List<Map<String, Object>> allPubGroup = null;
		List<DropdownModel> allPubGroupList = null;
		DropdownModel model = null;
		String query = null;
		try {
			allPubGroup = new ArrayList<>();
			allPubGroupList = new ArrayList<>();
			query = "SELECT *FROM  audit_pub_group ";
			allPubGroup = jdbcTemplate.queryForList(query);
			for (Map<String, Object> pubGroup : allPubGroup) {
				model = new DropdownModel();
				model.setKey(pubGroup.get("audit_pub_group").toString());
				model.setDisplay(pubGroup.get("description").toString());
				// model.setExtra(pubGroup .get("row_version").toString());
				allPubGroupList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return allPubGroupList;

	}

	@Override
	public List<Map<String, Object>> getQualificationSourceList() {

		LOGGER.info("qualification source1");
		List<Map<String, Object>> qualificationSourceList = new ArrayList<>();
		try {
			qualificationSourceList = jdbcTemplate.queryForList("select qp,qf,nqp,nqf from  audit_qual_source");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return qualificationSourceList;
	}

	@Override
	public List<Map<String, Object>> getMailingAddressNameList() {

		LOGGER.info("mailingaddresnameList");
		List<Map<String, Object>> mailingAddressList = new ArrayList<>();
		try {
			mailingAddressList = jdbcTemplate.queryForList("select qp,qf,nqp,nqf from audit_name_title");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return mailingAddressList;
	}

	@Override
	public List<Map<String, Object>> getSalesChannelList() {
		LOGGER.info("saleschannelList");
		List<Map<String, Object>> salesChannelList = new ArrayList<>();
		try {
			salesChannelList = jdbcTemplate.queryForList("select qp,qf,nqp,nqf from audit_sales_channel");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return salesChannelList;
	}

	@Override
	public List<Map<String, Object>> getSubscriptionTypeList() {
		LOGGER.info("subscriptiontypeList");
		List<Map<String, Object>> subscriptionTypeList = new ArrayList<>();
		try {
			subscriptionTypeList = jdbcTemplate.queryForList("select qp,qf,nqp,nqf from audit_subscription_type");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptionTypeList;
	}

	@Override
	public List<DropdownModel> getGeographicalRegionList() {

		LOGGER.info("get geographicalregionlist");
		List<Map<String, Object>> geographicalregion = null;
		List<DropdownModel> geographicalregionList = null;
		DropdownModel model = null;
		String query = null;
		try {
			geographicalregion = new ArrayList<>();
			geographicalregionList = new ArrayList<>();
			query = "SELECT * FROM region_list ORDER BY region_list";
			geographicalregion = jdbcTemplate.queryForList(query);
			for (Map<String, Object> price : geographicalregion) {

				model = new DropdownModel();
				model.setKey(price.get("region_list").toString());
				model.setDisplay(price.get("description").toString());
				geographicalregionList.add(model);
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return geographicalregionList;
	}

	@Override
	public int saveAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel) {

		LOGGER.info("save audittracking details");

		int status = 1;
		try {

			Map<String, Object> addAuditPubDetails = new HashMap<String, Object>();
			String query = "insert into pub(oc_id,issn,inherited_from,converted_to,start_type,audited,qp_sub_type_required,qp_qual_source_required,qp_name_title_required,qp_sales_channel_required,"
					+ "qp_max_backstarts_on_new,qp_max_backissues_on_reinst,qp_backissues_on_reinst,qf_sub_type_required,qf_qual_source_required,qf_name_title_required,qf_sales_channel_required,qf_max_backstarts_on_new,"
					+ "qf_max_backissues_on_reinst,qf_backissues_on_reinst,nqp_sub_type_required,nqp_qual_source_required,nqp_name_title_required,nqp_sales_channel_required,nqp_max_backstarts_on_new,"
					+ "nqp_max_backissues_on_reinst,nqp_backissues_on_reinst,nqf_sub_type_required,nqf_qual_source_required,nqf_name_title_required,nqf_sales_channel_required,nqf_max_backstarts_on_new,"
					+ "nqf_max_backissues_on_reinst,nqf_backissues_on_reinst,n_issues,n_calendar_units,calendar_unit,on_string,on_calendar_unit,on_day,volume_caption,volume_format,volume_change_date,issue_caption,issue_format,"
					+ "issue_continuous,n_issues_per_volume,start_date_type_anytime,backstart_n_issues_anytime,start_date_type_volume_group,unit_audits,annual_rate,region_list,sales_channel_pub_group,name_title_pub_group,"
					+ "qual_source_pub_group,sub_type_pub_group,add_kill_report,qp,qf,nqp,nqf,duration_pub_group,price_pub_group,demog_pub_group,qp_prompt_for_backissues,qf_prompt_for_backissues,nqp_prompt_for_backissues,nqf_prompt_for_backissues,"
					+ "no_spaces_in_enumeration,accrual_time_unit,accrual_time,revenue_method,start_date_type_date_based,start_n_days_date_based,suppress_enumeration,max_qual_date_age)"

					+ "values(:oc_id,:issn,:inherited_from,:converted_to,:start_type,:audited,:qp_sub_type_required,:qp_qual_source_required,:qp_name_title_required,:qp_sales_channel_required,"
					+ ":qp_max_backstarts_on_new,:qp_max_backissues_on_reinst,:qp_backissues_on_reinst,:qf_sub_type_required,:qf_qual_source_required,:qf_name_title_required,:qf_sales_channel_required,:qf_max_backstarts_on_new,"
					+ ":qf_max_backissues_on_reinst,:qf_backissues_on_reinst,:nqp_sub_type_required,:nqp_qual_source_required,:nqp_name_title_required,:nqp_sales_channel_required,:nqp_max_backstarts_on_new,"
					+ ":nqp_max_backissues_on_reinst,:nqp_backissues_on_reinst,:nqf_sub_type_required,:nqf_qual_source_required,:nqf_name_title_required,:nqf_sales_channel_required,:nqf_max_backstarts_on_new,"
					+ ":nqf_max_backissues_on_reinst,:nqf_backissues_on_reinst,:n_issues,:n_calendar_units,:calendar_unit,:on_string,:on_calendar_unit,:on_day,:volume_caption,:volume_format,:volume_change_date,:issue_caption,:issue_format,"
					+ ":issue_continuous,:n_issues_per_volume,:start_date_type_anytime,:backstart_n_issues_anytime,:start_date_type_volume_group,:unit_audits,:annual_rate,:region_list,:sales_channel_pub_group,:name_title_pub_group,"
					+ ":qual_source_pub_group,:sub_type_pub_group,:add_kill_report,:qp,:qf,:nqp,:nqf,:duration_pub_group,:price_pub_group,:demog_pub_group,:qp_prompt_for_backissues,:qf_prompt_for_backissues,:nqp_prompt_for_backissues,:nqf_prompt_for_backissues,"
					+ ":no_spaces_in_enumeration,:accrual_time_unit,:accrual_time,:revenue_method,:start_date_type_date_based,:start_n_days_date_based,:suppress_enumeration,:max_qual_date_age)";

			addAuditPubDetails.put("oc_id", auditTrackingModel.getOcId());
			addAuditPubDetails.put("issn", auditTrackingModel.getIssn());
			addAuditPubDetails.put("inherited_from", auditTrackingModel.getInheritedFrom());
			addAuditPubDetails.put("converted_to", auditTrackingModel.getConvertedTo());
			addAuditPubDetails.put("start_type", auditTrackingModel.getStartType());
			addAuditPubDetails.put("audited", auditTrackingModel.getAudited());
			addAuditPubDetails.put("qp_sub_type_required", auditTrackingModel.getQpSubTypeRequired());
			addAuditPubDetails.put("qp_qual_source_required", auditTrackingModel.getQpQulSourceRequired());
			addAuditPubDetails.put("qp_name_title_required", auditTrackingModel.getQpNameTitleRequired());
			addAuditPubDetails.put("qp_sales_channel_required", auditTrackingModel.getQpSalesChannelRequired());
			addAuditPubDetails.put("qp_max_backstarts_on_new", auditTrackingModel.getQpMaxBackStartsOnNew());
			addAuditPubDetails.put("qp_max_backissues_on_reinst", auditTrackingModel.getQpMaxBackIssuesOnReinstant());
			addAuditPubDetails.put("qp_backissues_on_reinst", auditTrackingModel.getQpBackIssuesOnReinstant());
			addAuditPubDetails.put("qf_sub_type_required", auditTrackingModel.getQfSubTypeRequired());
			addAuditPubDetails.put("qf_qual_source_required", auditTrackingModel.getQfQualSourceRequired());
			addAuditPubDetails.put("qf_name_title_required", auditTrackingModel.getQfNameTitleRequired());
			addAuditPubDetails.put("qf_sales_channel_required", auditTrackingModel.getQfSalesChannelRequired());
			addAuditPubDetails.put("qf_max_backstarts_on_new", auditTrackingModel.getQfMaxBackStartsOnNew());
			addAuditPubDetails.put("qf_max_backissues_on_reinst", auditTrackingModel.getQfMaxBackIssuesOnReinstant());
			addAuditPubDetails.put("qf_backissues_on_reinst", auditTrackingModel.getQfBackIssuesOnReinstant());
			addAuditPubDetails.put("nqp_sub_type_required", auditTrackingModel.getNqpSubTypeRequired());
			addAuditPubDetails.put("nqp_qual_source_required", auditTrackingModel.getNqpQulSourceRequired());
			addAuditPubDetails.put("nqp_name_title_required", auditTrackingModel.getNqpNameTitleRequired());
			addAuditPubDetails.put("nqp_sales_channel_required", auditTrackingModel.getNqpSalesChannelRequired());
			addAuditPubDetails.put("nqp_max_backstarts_on_new", auditTrackingModel.getNqpMaxBackStartsOnNew());
			addAuditPubDetails.put("nqp_max_backissues_on_reinst", auditTrackingModel.getNqpMaxBackIssuesOnReinstant());
			LOGGER.info("nqpMaxBackIssuesOnReinstant:{}", auditTrackingModel.getNqpMaxBackIssuesOnReinstant());

			addAuditPubDetails.put("nqp_backissues_on_reinst", auditTrackingModel.getNqpBackIssuesOnReinstant());
			addAuditPubDetails.put("nqf_sub_type_required", auditTrackingModel.getNqfSubTypeRequired());
			addAuditPubDetails.put("nqf_qual_source_required", auditTrackingModel.getNqfQulSourceRequired());
			addAuditPubDetails.put("nqf_name_title_required", auditTrackingModel.getNqfNameTitleRequired());
			addAuditPubDetails.put("nqf_sales_channel_required", auditTrackingModel.getNqfSalesChannelRequired());
			LOGGER.info("nqfSalesChannelRequired:{}", auditTrackingModel.getNqfSalesChannelRequired());
			addAuditPubDetails.put("nqf_max_backstarts_on_new", auditTrackingModel.getNqfMaxBackStartsOnNew());
			addAuditPubDetails.put("nqf_max_backissues_on_reinst", auditTrackingModel.getNqfMaxBackIssuesOnReinstant());
			addAuditPubDetails.put("nqf_backissues_on_reinst", auditTrackingModel.getNqfBackIssuesOnReinstant());
			addAuditPubDetails.put("n_issues", auditTrackingModel.getNumOfIssues());
			addAuditPubDetails.put("n_calendar_units", auditTrackingModel.getNumCalenderUnits());
			addAuditPubDetails.put("calendar_unit", auditTrackingModel.getCalenderUnits());
			addAuditPubDetails.put("on_string", auditTrackingModel.getOnString());
			addAuditPubDetails.put("on_calendar_unit", auditTrackingModel.getOnCalenderUnit());
			addAuditPubDetails.put("on_day", auditTrackingModel.getOnDay());
			addAuditPubDetails.put("volume_caption", auditTrackingModel.getVolumeCaption());
			addAuditPubDetails.put("volume_format", auditTrackingModel.getVolumeFormat());
			addAuditPubDetails.put("volume_change_date", auditTrackingModel.getVolumeChangeDate());
			addAuditPubDetails.put("issue_caption", auditTrackingModel.getIssueCaption());
			addAuditPubDetails.put("issue_format", auditTrackingModel.getIssueFormat());
			addAuditPubDetails.put("issue_continuous", auditTrackingModel.getIssueContinuous());
			addAuditPubDetails.put("n_issues_per_volume", auditTrackingModel.getNIssuesPerVolume());
			addAuditPubDetails.put("start_date_type_anytime", auditTrackingModel.getStartDateTypeAnytime());
			addAuditPubDetails.put("backstart_n_issues_anytime", auditTrackingModel.getBackStartNIssuesAnytime());
			addAuditPubDetails.put("start_date_type_volume_group", auditTrackingModel.getStartDateTypeVolumeGroup());
			addAuditPubDetails.put("unit_audits", auditTrackingModel.getUnitAudits());
			addAuditPubDetails.put("annual_rate", auditTrackingModel.getAnnualRate());
			addAuditPubDetails.put("region_list", auditTrackingModel.getRegionList());
			addAuditPubDetails.put("sales_channel_pub_group", auditTrackingModel.getSalesChannelPubGroup());//
			addAuditPubDetails.put("name_title_pub_group", auditTrackingModel.getNameTitlePubGroup());
			addAuditPubDetails.put("qual_source_pub_group", auditTrackingModel.getQualSourcePubGroup());
			LOGGER.info("qualSourcePubGroup:{}", auditTrackingModel.getQualSourcePubGroup());
			addAuditPubDetails.put("sub_type_pub_group", auditTrackingModel.getSubTypePubGroup());
			addAuditPubDetails.put("add_kill_report", auditTrackingModel.getAddKillReport());
			addAuditPubDetails.put("qp", auditTrackingModel.isQp());
			addAuditPubDetails.put("qf", auditTrackingModel.isQf());
			addAuditPubDetails.put("nqp", auditTrackingModel.isNqp());
			addAuditPubDetails.put("nqf", auditTrackingModel.isNqf());
			addAuditPubDetails.put("duration_pub_group", auditTrackingModel.getDurationPubGroup());
			addAuditPubDetails.put("price_pub_group", auditTrackingModel.getPricePubGroup());
			addAuditPubDetails.put("demog_pub_group", auditTrackingModel.getDemoPubGroup());
			addAuditPubDetails.put("qp_prompt_for_backissues", auditTrackingModel.getQpPromptForBackIssues());
			addAuditPubDetails.put("qf_prompt_for_backissues", auditTrackingModel.getQfPromptForBackIssues());
			addAuditPubDetails.put("nqp_prompt_for_backissues", auditTrackingModel.getNqpPromptForBackIssues());
			addAuditPubDetails.put("nqf_prompt_for_backissues", auditTrackingModel.getNqfPromptForBackIssues());
			addAuditPubDetails.put("no_spaces_in_enumeration", auditTrackingModel.getNoSpacesInEnumeration());
			addAuditPubDetails.put("accrual_time_unit", auditTrackingModel.getAccuralTimeUnit());
			addAuditPubDetails.put("accrual_time", auditTrackingModel.getAccuralTime());
			addAuditPubDetails.put("revenue_method", auditTrackingModel.getRevenueMethod());
			addAuditPubDetails.put("start_date_type_date_based", auditTrackingModel.getStartDateTypeDateBased());
			addAuditPubDetails.put("start_n_days_date_based", auditTrackingModel.getStartNDaysDateBased());
			addAuditPubDetails.put("suppress_enumeration", auditTrackingModel.getSuppressEnumeration());
			addAuditPubDetails.put("max_qual_date_age", auditTrackingModel.getMaxQualDateAge());

			namedParameterJdbcTemplate.update(query, addAuditPubDetails);

		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int updateAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel) {
		LOGGER.info("oc_id:{}", auditTrackingModel.getOcId());

		int status = 0;

		try {
			LOGGER.info("Inside audittracking details");
			String query = null;

			Map<String, Object> parameters = new HashMap<String, Object>();
			LOGGER.info("update for audittracking", auditTrackingModel);
			query = "update pub set oc_id=:oc_id,issn=:issn,inherited_from=:inherited_from,converted_to=:converted_to,start_type=:start_type,audited=:audited,qp_sub_type_required=:qp_sub_type_required,qp_qual_source_required=:qp_qual_source_required,qp_name_title_required=:qp_name_title_required,qp_sales_channel_required=:qp_sales_channel_required,"
					+ "qp_max_backstarts_on_new=:qp_max_backstarts_on_new,qp_max_backissues_on_reinst=:qp_max_backissues_on_reinst,qp_backissues_on_reinst=:qp_backissues_on_reinst,qf_sub_type_required=:qf_sub_type_required,qf_qual_source_required=:qf_qual_source_required,qf_name_title_required=:qf_name_title_required,qf_sales_channel_required=:qf_sales_channel_required,qf_max_backstarts_on_new=:qf_max_backstarts_on_new,"
					+ "qf_max_backissues_on_reinst=:qf_max_backissues_on_reinst,qf_backissues_on_reinst=:qf_backissues_on_reinst,nqp_sub_type_required=:nqp_sub_type_required,nqp_qual_source_required=:nqp_qual_source_required,nqp_name_title_required=:nqp_name_title_required,nqp_sales_channel_required=:nqp_sales_channel_required,nqp_max_backstarts_on_new=:nqp_max_backstarts_on_new,"
					+ "nqp_max_backissues_on_reinst=:nqp_max_backissues_on_reinst,nqp_backissues_on_reinst=:nqp_backissues_on_reinst,nqf_sub_type_required=:nqf_sub_type_required,nqf_qual_source_required=:nqf_qual_source_required,nqf_name_title_required=:nqf_name_title_required,nqf_sales_channel_required=:nqf_sales_channel_required,nqf_max_backstarts_on_new=:nqf_max_backstarts_on_new,"
					+ "nqf_max_backissues_on_reinst=:nqf_max_backissues_on_reinst,nqf_backissues_on_reinst=:nqf_backissues_on_reinst,n_issues=:n_issues,n_calendar_units=:n_calendar_units,calendar_unit=:calendar_unit,on_string=:on_string,on_calendar_unit=:on_calendar_unit,on_day=:on_day,volume_caption=:volume_caption,volume_format=:volume_format,volume_change_date=:volume_change_date,issue_caption=:issue_caption,issue_format=:issue_format,"
					+ "issue_continuous=:issue_continuous,n_issues_per_volume=:n_issues_per_volume,start_date_type_anytime=:start_date_type_anytime,backstart_n_issues_anytime=:backstart_n_issues_anytime,start_date_type_volume_group=:start_date_type_volume_group,unit_audits=:unit_audits,region_list=:region_list,sales_channel_pub_group=:sales_channel_pub_group,name_title_pub_group=:name_title_pub_group,"
					+ "qual_source_pub_group=:qual_source_pub_group,sub_type_pub_group=:sub_type_pub_group,add_kill_report=:add_kill_report,qp=:qp,qf=:qf,nqp=:nqp,nqf=:nqf,duration_pub_group=:duration_pub_group,price_pub_group=:price_pub_group,demog_pub_group=:demog_pub_group,qp_prompt_for_backissues=:qp_prompt_for_backissues,qf_prompt_for_backissues=:qf_prompt_for_backissues,nqp_prompt_for_backissues=:nqp_prompt_for_backissues,nqf_prompt_for_backissues=:nqf_prompt_for_backissues,"
					+ "no_spaces_in_enumeration=:no_spaces_in_enumeration,accrual_time_unit=:accrual_time_unit,accrual_time=:accrual_time,revenue_method=:revenue_method,start_date_type_date_based=:start_date_type_date_based,start_n_days_date_based=:start_n_days_date_based,suppress_enumeration=:suppress_enumeration,max_qual_date_age=:max_qual_date_age where oc_id= "
					+ auditTrackingModel.getOcId();

			parameters.put("oc_id", auditTrackingModel.getOcId());
			LOGGER.info("oc_id:{}", auditTrackingModel.getOcId());
			parameters.put("issn", auditTrackingModel.getIssn());

			parameters.put("inherited_from", auditTrackingModel.getInheritedFrom());
			parameters.put("converted_to", auditTrackingModel.getConvertedTo());
			parameters.put("start_type", auditTrackingModel.getStartType());
			parameters.put("audited", auditTrackingModel.getAudited());
			parameters.put("qp_sub_type_required", auditTrackingModel.getQpSubTypeRequired());
			parameters.put("qp_qual_source_required", auditTrackingModel.getQpQulSourceRequired());
			parameters.put("qp_name_title_required", auditTrackingModel.getQpNameTitleRequired());
			parameters.put("qp_sales_channel_required", auditTrackingModel.getQpSalesChannelRequired());
			parameters.put("qp_max_backstarts_on_new", auditTrackingModel.getQpMaxBackStartsOnNew());
			parameters.put("qp_max_backissues_on_reinst", auditTrackingModel.getQpMaxBackIssuesOnReinstant());
			parameters.put("qp_backissues_on_reinst", auditTrackingModel.getQpBackIssuesOnReinstant());
			parameters.put("qf_sub_type_required", auditTrackingModel.getQfSubTypeRequired());
			parameters.put("qf_qual_source_required", auditTrackingModel.getQfQualSourceRequired());
			parameters.put("qf_name_title_required", auditTrackingModel.getQfNameTitleRequired());
			parameters.put("qf_sales_channel_required", auditTrackingModel.getQfSalesChannelRequired());
			parameters.put("qf_max_backstarts_on_new", auditTrackingModel.getQfMaxBackStartsOnNew());
			parameters.put("qf_max_backissues_on_reinst", auditTrackingModel.getQfMaxBackIssuesOnReinstant());
			parameters.put("qf_backissues_on_reinst", auditTrackingModel.getQfBackIssuesOnReinstant());
			parameters.put("nqp_sub_type_required", auditTrackingModel.getNqpSubTypeRequired());
			parameters.put("nqp_qual_source_required", auditTrackingModel.getNqpQulSourceRequired());
			parameters.put("nqp_name_title_required", auditTrackingModel.getNqpNameTitleRequired());
			parameters.put("nqp_sales_channel_required", auditTrackingModel.getNqpSalesChannelRequired());
			parameters.put("nqp_max_backstarts_on_new", auditTrackingModel.getNqpMaxBackStartsOnNew());
			LOGGER.info("nqpMaxBackStartsOnNew:{}", auditTrackingModel.getNqpMaxBackStartsOnNew());
			parameters.put("nqp_max_backissues_on_reinst", auditTrackingModel.getNqpMaxBackIssuesOnReinstant());
			parameters.put("nqp_backissues_on_reinst", auditTrackingModel.getNqpBackIssuesOnReinstant());
			parameters.put("nqf_sub_type_required", auditTrackingModel.getNqfSubTypeRequired());
			parameters.put("nqf_qual_source_required", auditTrackingModel.getNqfQulSourceRequired());
			parameters.put("nqf_name_title_required", auditTrackingModel.getNqfNameTitleRequired());
			parameters.put("nqf_sales_channel_required", auditTrackingModel.getNqfSalesChannelRequired());
			parameters.put("nqf_max_backstarts_on_new", auditTrackingModel.getNqfMaxBackStartsOnNew());
			parameters.put("nqf_max_backissues_on_reinst", auditTrackingModel.getNqfMaxBackIssuesOnReinstant());
			parameters.put("nqf_backissues_on_reinst", auditTrackingModel.getNqfBackIssuesOnReinstant());
			parameters.put("n_issues", auditTrackingModel.getNumOfIssues());
			parameters.put("n_calendar_units", auditTrackingModel.getNumCalenderUnits());
			parameters.put("calendar_unit", auditTrackingModel.getCalenderUnits());
			parameters.put("on_string", auditTrackingModel.getOnString());
			parameters.put("on_calendar_unit", auditTrackingModel.getOnCalenderUnit());
			parameters.put("on_day", auditTrackingModel.getOnDay());
			parameters.put("volume_caption", auditTrackingModel.getVolumeCaption());
			parameters.put("volume_format", auditTrackingModel.getVolumeFormat());
			parameters.put("volume_change_date", auditTrackingModel.getVolumeChangeDate());
			parameters.put("issue_caption", auditTrackingModel.getIssueCaption());
			parameters.put("issue_format", auditTrackingModel.getIssueFormat());
			parameters.put("issue_continuous", auditTrackingModel.getIssueContinuous());
			parameters.put("n_issues_per_volume", auditTrackingModel.getNIssuesPerVolume());
			parameters.put("start_date_type_anytime", auditTrackingModel.getStartDateTypeAnytime());
			parameters.put("backstart_n_issues_anytime", auditTrackingModel.getBackStartNIssuesAnytime());
			parameters.put("start_date_type_volume_group", auditTrackingModel.getStartDateTypeVolumeGroup());
			parameters.put("unit_audits", auditTrackingModel.getUnitAudits());
			LOGGER.info("unitAudits:{}", auditTrackingModel.getUnitAudits());

			parameters.put("annual_rate", auditTrackingModel.getAnnualRate());
			parameters.put("region_list", auditTrackingModel.getRegionList());
			parameters.put("sales_channel_pub_group", auditTrackingModel.getSalesChannelPubGroup());
			parameters.put("name_title_pub_group", auditTrackingModel.getNameTitlePubGroup());
			parameters.put("qual_source_pub_group", auditTrackingModel.getQualSourcePubGroup());
			LOGGER.info("qualSourcePubGroup:{}", auditTrackingModel.getQualSourcePubGroup());
			parameters.put("sub_type_pub_group", auditTrackingModel.getSubTypePubGroup());
			parameters.put("add_kill_report", auditTrackingModel.getAddKillReport());
			parameters.put("qp", auditTrackingModel.isQp());
			parameters.put("qf", auditTrackingModel.isQf());
			parameters.put("nqp", auditTrackingModel.isNqp());
			parameters.put("nqf", auditTrackingModel.isNqf());
			parameters.put("duration_pub_group", auditTrackingModel.getDurationPubGroup());
			parameters.put("price_pub_group", auditTrackingModel.getPricePubGroup());
			parameters.put("demog_pub_group", auditTrackingModel.getDemoPubGroup());
			parameters.put("qp_prompt_for_backissues", auditTrackingModel.getQpPromptForBackIssues());
			parameters.put("qf_prompt_for_backissues", auditTrackingModel.getQfPromptForBackIssues());
			parameters.put("nqp_prompt_for_backissues", auditTrackingModel.getNqpPromptForBackIssues());
			parameters.put("nqf_prompt_for_backissues", auditTrackingModel.getNqfPromptForBackIssues());
			parameters.put("no_spaces_in_enumeration", auditTrackingModel.getNoSpacesInEnumeration());
			parameters.put("accrual_time_unit", auditTrackingModel.getAccuralTimeUnit());
			parameters.put("accrual_time", auditTrackingModel.getAccuralTime());
			parameters.put("revenue_method", auditTrackingModel.getRevenueMethod());
			parameters.put("start_date_type_date_based", auditTrackingModel.getStartDateTypeDateBased());
			parameters.put("start_n_days_date_based", auditTrackingModel.getStartNDaysDateBased());
			parameters.put("suppress_enumeration", auditTrackingModel.getSuppressEnumeration());
			parameters.put("max_qual_date_age", auditTrackingModel.getMaxQualDateAge());

			status = namedParameterJdbcTemplate.update(query, parameters);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public List<Map<String, Object>> getAuditTrackingPubDetails(int ocId) {

		LOGGER.info("Inside getAuditTrackingPubDetails");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(
				"select oc_id,issn,inherited_from,converted_to,start_type,audited,qp_sub_type_required,qp_qual_source_required,qp_name_title_required,qp_sales_channel_required,"
						+ "qp_max_backstarts_on_new,qp_max_backissues_on_reinst,qp_backissues_on_reinst,qf_sub_type_required,qf_qual_source_required,qf_name_title_required,qf_sales_channel_required,qf_max_backstarts_on_new,"
						+ "qf_max_backissues_on_reinst,qf_backissues_on_reinst,nqp_sub_type_required,nqp_qual_source_required,nqp_name_title_required,nqp_sales_channel_required,nqp_max_backstarts_on_new,"
						+ "nqp_max_backissues_on_reinst,nqp_backissues_on_reinst,nqf_sub_type_required,nqf_qual_source_required,nqf_name_title_required,nqf_sales_channel_required,nqf_max_backstarts_on_new,"
						+ "nqf_max_backissues_on_reinst,nqf_backissues_on_reinst,n_issues,n_calendar_units,calendar_unit,on_string,on_calendar_unit,on_day,volume_caption,volume_format,volume_change_date,issue_caption,issue_format,"
						+ "issue_continuous,n_issues_per_volume,start_date_type_anytime,backstart_n_issues_anytime,start_date_type_volume_group,unit_audits,annual_rate,region_list,sales_channel_pub_group,name_title_pub_group,"
						+ "qual_source_pub_group,sub_type_pub_group,add_kill_report,qp,qf,nqp,nqf,duration_pub_group,price_pub_group,demog_pub_group,qp_prompt_for_backissues,qf_prompt_for_backissues,nqp_prompt_for_backissues,nqf_prompt_for_backissues,"

						+ "no_spaces_in_enumeration,accrual_time_unit,accrual_time,revenue_method,start_date_type_date_based,start_n_days_date_based,suppress_enumeration,max_qual_date_age from pub where oc_id= "
						+ ocId);

		return rows;
	}

	
	@Override
	public List<Map<String, Object>> getQuickOrderCodeDetails(Integer ocId, Integer orderCodeId) {

		LOGGER.info("Inside getQuickOrderCodeDetails");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(
				"select order_code_id,oc_id,user_code,active,description,order_code,qty,is_proforma,premium,no_charge,allow_on_internet,mru_quick_order_content_seq  from order_code where oc_id= "
						+ ocId + "and order_code_id=" + orderCodeId);

		return rows;
	}

	@Override
	public int updateQuickOrderCodeDetails(QuickOrderCodeModel quickOrderCodeModel) {

		LOGGER.info("oc_id:{}", quickOrderCodeModel.getOcId());
		int status = 0;
		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		StringBuilder query = new StringBuilder(
				"update order_code set user_code=:user_code,active=:active,description=:description,order_code=:order_code,qty=:qty,"
						+ "is_proforma=:is_proforma,premium=:premium,no_charge=:no_charge,allow_on_internet=:allow_on_internet,mru_quick_order_content_seq =:mru_quick_order_content_seq"
						+ " where oc_id= " + quickOrderCodeModel.getOcId() + " and  order_code_id= "
						+ quickOrderCodeModel.getOrderCodeId());

		try {
			LOGGER.info("Inside quick order code details");
			// String query = null;

			addSourceParams.put("order_code_id", quickOrderCodeModel.getOrderCodeId());
			addSourceParams.put("oc_id", quickOrderCodeModel.getOcId());
			addSourceParams.put("user_code", quickOrderCodeModel.getUserCode());
			addSourceParams.put("order_code", quickOrderCodeModel.getOrderCode());
           

			if (("null".equals(quickOrderCodeModel.getDescription()))
					| ("".equals(quickOrderCodeModel.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", quickOrderCodeModel.getDescription());
			}
			addSourceParams.put("qty", quickOrderCodeModel.getQty() != null ? quickOrderCodeModel.getQty() : null);
			addSourceParams.put("allow_on_internet",quickOrderCodeModel.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("is_proforma", quickOrderCodeModel.getIsproforma().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium", quickOrderCodeModel.getPremium());
			addSourceParams.put("mru_quick_order_content_seq",quickOrderCodeModel.getMruQuickOrderContentSeq() != null? quickOrderCodeModel.getMruQuickOrderContentSeq(): null);
			addSourceParams.put("no_charge", quickOrderCodeModel.getNoCharge().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("active", quickOrderCodeModel.getActive().equalsIgnoreCase("true") ? 1 : 0);
			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;

	}
						
	

	@Override
	public List<Map<String, Object>> getOrderDetails(Integer orderCodeId) {
		List<Map<String, Object>> orderDetails = new ArrayList<>();
		try {
			orderDetails = jdbcTemplate.queryForList(
					"select O.order_code,O.order_code_id,P.pkg_content_seq,O.description,P.prepayment_option,O.qty ,O.auto_renewal,P.required from order_code O inner join pkg_content P on O.order_code_id=P.order_code_id where P.order_code_id="
							+ orderCodeId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderDetails;
	}

	@Override
	public List<Map<String, Object>> getContentDetails(Integer orderCodeId) {
		List<Map<String, Object>> contentDetails = new ArrayList<>();
		try {
			contentDetails = jdbcTemplate.queryForList(
					"select order_code_id,pkg_content_seq,description,item_order_code_id,prepayment_option, qty,required from pkg_content where order_code_id="
							+ orderCodeId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return contentDetails;
	}

	@Override
	public List<DropdownModel> getPrepay() {
		List<DropdownModel> prepayOPt = new ArrayList<>();
		for (int i = 0; i <= 2; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("prepayment_option" + i));
			prepayOPt.add(model);
		}

		return prepayOPt;
	}

	@Override
	public List<Map<String, Object>> getPkgFinaldetails(Integer orderCodeId, Integer pkgContentSeq) {
		List<Map<String, Object>> pkgFinalDetails = new ArrayList<>();
		try {
			pkgFinalDetails = jdbcTemplate.queryForList(
					"select P.order_code_id,P.pkg_content_seq,P.description,P.item_order_code_id,P.prepayment_option,P.qty,P.required, O.auto_renewal,O.order_code from pkg_content P inner join order_code O on P.item_order_code_id=O.order_code_id where P.order_code_id="
							+ orderCodeId + " and P.pkg_content_seq=" + pkgContentSeq);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return pkgFinalDetails;
	}

	@Override
	public List<Map<String, Object>> getOtherData(Integer orderCodeId, Integer pkgContentSeq) {
		List<Map<String, Object>> otherData = new ArrayList<>();
		try {
			otherData = jdbcTemplate.queryForList(
					"select o.auto_renewal,p.required from order_code o join pkg_content p on o.order_code_id=p.order_code_id");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return otherData;
	}

	@Override
	public int savePkgContents(PackageContentModel packageContent) {
		Map<String, Object> savePckgContentsParams = new HashMap<>();
		int status = 0;
		try {
			if (packageContent.getOrderCodeId() == null) {

				StringBuilder savePkgContentQuery = new StringBuilder(
						"insert into pkg_content(order_code_id,pkg_content_seq,item_order_code_id,description,prepayment_option,qty,required) values(:order_code_id,:pkg_content_seq,:item_order_code_id,:description,:prepayment_option,:qty,:required)");
				String maxId = jdbcTemplate.queryForObject("select max(order_code_id) from order_code", String.class);
				if (maxId == null) {
					savePckgContentsParams.put("order_code_id", 1);
				} else {
					savePckgContentsParams.put("order_code_id", Integer.parseInt(maxId) + 1);
				}

				LOGGER.info("orderCOdeiD====>:{}", maxId);
				savePckgContentsParams.put("item_order_code_id", packageContent.getItemOrderCodeId());
				savePckgContentsParams.put("description", packageContent.getDescription());
				savePckgContentsParams.put("prepayment_option",
						String.valueOf(packageContent.getPrepaymentOpt()) != null ? packageContent.getPrepaymentOpt()
								: 0);
				savePckgContentsParams.put("qty", packageContent.getQty());
				savePckgContentsParams.put("required",
						String.valueOf(packageContent.getRequired()) != null ? packageContent.getRequired() : 0);
				String maxId1 = jdbcTemplate.queryForObject("select max(pkg_content_seq) from pkg_content",
						String.class);
				if (maxId1 == null) {
					savePckgContentsParams.put("pkg_content_seq", 1);
				} else {
					savePckgContentsParams.put("pkg_content_seq", Integer.parseInt(maxId1) + 1);
				}
				// savePckgContentsParams.put("pkg_content_seq",packageContent.getPkgContentSeq()!=null?packageContent.getPkgContentSeq():null);

				status = namedParameterJdbcTemplate.update(savePkgContentQuery.toString(), savePckgContentsParams);

			}
			
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);


		}

		return status;

	}

	@Override
	public int saveQuickOrderCodeDetails(QuickOrderCodeModel quickOrderCodeModel) {

		int status = 0;
		StringBuilder query = new StringBuilder(
				"insert into order_code(order_code_id,oc_id,user_code,description,order_code,qty,is_proforma,premium,no_charge,allow_on_internet,mru_quick_order_content_seq,active)"
						+ "values(:order_code_id,:oc_id,:user_code,:description,:order_code,:qty,:is_proforma,:premium,:no_charge,:allow_on_internet,:mru_quick_order_content_seq,:active)");

		Map<String, Object> addSourceParams = new LinkedHashMap<>();
		try {
			// This query fire at first time to check how many records is available in table
			/// and fetching max order_code_id and add 1 to next order_code_id record

			LOGGER.info("save for quickordercode", quickOrderCodeModel);
			String maxOrderCodeId = jdbcTemplate.queryForObject("select MAX(order_code_id) from order_code",
					String.class);

			if (maxOrderCodeId == null) {
				addSourceParams.put("order_code_id", 1);// if table order_code_id column is null then add 1 to first
														// record
			} else {
				addSourceParams.put("order_code_id", Integer.parseInt(maxOrderCodeId) + 1);
			}

			LOGGER.info("order_code_id:{}", maxOrderCodeId);
			addSourceParams.put("oc_id", quickOrderCodeModel.getOcId());
			addSourceParams.put("user_code", quickOrderCodeModel.getUserCode());
			if (("null".equals(quickOrderCodeModel.getDescription()))| ("".equals(quickOrderCodeModel.getDescription()))) {
				addSourceParams.put("description", null);
			} else {
				addSourceParams.put("description", quickOrderCodeModel.getDescription());
			}
			addSourceParams.put("order_code", quickOrderCodeModel.getOrderCode());
			addSourceParams.put("qty", quickOrderCodeModel.getQty() != null ? quickOrderCodeModel.getQty() : null);

			addSourceParams.put("is_proforma", quickOrderCodeModel.getIsproforma().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("premium", quickOrderCodeModel.getPremium());

			addSourceParams.put("mru_quick_order_content_seq",quickOrderCodeModel.getMruQuickOrderContentSeq() != null? quickOrderCodeModel.getMruQuickOrderContentSeq(): null);
			addSourceParams.put("no_charge", quickOrderCodeModel.getNoCharge().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("allow_on_internet",quickOrderCodeModel.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			addSourceParams.put("active", quickOrderCodeModel.getActive().equalsIgnoreCase("true") ? 1 : 0);
			// addSourceParams.put("active",quickOrderCodeModel.getActive());
			LOGGER.info("is active:{}", quickOrderCodeModel.getActive());

			status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;

	}


	@Override
	public int getPkgContentSeq(Integer orderCodeId) {
		int pkgContentSeq = 0;
		try {
			String maxId = jdbcTemplate.queryForObject(
					"select max(pkg_content_seq) from pkg_content where order_code_id=" + orderCodeId, String.class);
			if (maxId == null) {
				pkgContentSeq = 0;
			} else {
				pkgContentSeq = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return pkgContentSeq;
	}

	@Override
	public int getItemOrderCodeId(Integer orderCodeId) {
		int itemOrderCodeId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject(
					"select max(item_order_code_id) from pkg_content where order_code_id=" + orderCodeId, String.class);
			if (maxId == null) {
				itemOrderCodeId = 0;
			} else {
				itemOrderCodeId = Integer.valueOf(maxId);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return itemOrderCodeId;
	}

	public void updateMru_pkg_content_seq(Integer orderCodeId, Integer mru_pkg_content_seq) {
		String updateMru_pkg_content_seq = "update order_code set mru_pkg_content_seq=" + mru_pkg_content_seq
				+ " where order_code_id=" + orderCodeId;
		try {
			jdbcTemplate.update(updateMru_pkg_content_seq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}

	@Override
	public int updatePackageContent(PackageContentModel packageContent) {
		Map<String, Object> updateParams = new HashMap<>();
		int status = 0;
		try {
			StringBuilder updatePackageQuery = new StringBuilder(
					"update pkg_content set order_code_id=:order_code_id,pkg_content_seq=:pkg_content_seq,item_order_code_id=:item_order_code_id,description=:description,prepayment_option=:prepayment_option,qty=:qty,required=:required where order_code_id= "
							+ packageContent.getOrderCodeId() + " and pkg_content_seq="
							+ packageContent.getPkgContentSeq());
			updateParams.put("order_code_id", packageContent.getOrderCodeId());
			updateParams.put("pkg_content_seq", packageContent.getPkgContentSeq());
			updateParams.put("item_order_code_id", packageContent.getItemOrderCodeId());
			updateParams.put("qty", packageContent.getQty());
			updateParams.put("description", packageContent.getDescription());
			updateParams.put("prepayment_option",
					String.valueOf(packageContent.getPrepaymentOpt()) != null ? packageContent.getPrepaymentOpt() : 0);
			updateParams.put("required",
					String.valueOf(packageContent.getRequired()) != null ? packageContent.getRequired() : 0);
			status = namedParameterJdbcTemplate.update(updatePackageQuery.toString(), updateParams);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public int deletePackageContent(int orderCodeId) {
		int status = 0;
		String deleteQuery = "delete from pkg_content where order_code_id=?";
		try {
			status = jdbcTemplate.update(deleteQuery, Integer.valueOf(orderCodeId));
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return status;
	}

	@Override
	public int saveProductDetails(ProductModel product) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder saveQuery = new StringBuilder(
				"insert into product(product_id,oc_id,inventory_id,description,product_size,product_style,product_color,price,rate_class_id,");
		saveQuery.append(
				"product,order_code_id,allow_on_internet,tag_line,item_url,image_url,auxiliary_1,auxiliary_2,premium_order_code_id)");
		saveQuery.append(
				"values (:product_id,:oc_id,:inventory_id,:description,:product_size,:product_style,:product_color,:price,:rate_class_id,");
		saveQuery.append(
				":product,:order_code_id,:allow_on_internet,:tag_line,:item_url,:image_url,:auxiliary_1,:auxiliary_2,:premium_order_code_id)");
		try {
			String maxId = jdbcTemplate.queryForObject("select max(product_id) from product", String.class);
			if (maxId == null) {
				addParams.put("product_id", 1);
			} else {
				addParams.put("product_id", Integer.parseInt(maxId) + 1);
			}
			addParams.put("oc_id", product.getOcId());
			if ("null".equals(product.getInventoryId()) | "".equals(product.getInventoryId())) {
				addParams.put("inventory_id", null);

			} else {
				addParams.put("inventory_id", product.getInventoryId());
			}
			if ("null".equals(product.getDescription()) | "".equals(product.getDescription())) {
				addParams.put("description", null);
			} else {
				addParams.put("description",product.getDescription() );
			}
			if ("null".equals(product.getProductSize()) | "".equals(product.getProductSize())) {
				addParams.put("product_size", null);

			} else {
				addParams.put("product_size", product.getProductSize());
			}
			if ("null".equals(product.getProductStyle()) | "".equals(product.getProductStyle())) {
				addParams.put("product_style", null);
			} else {
				addParams.put("product_style", product.getProductStyle());
			}
			if ("null".equals(product.getProductColor()) | "".equals(product.getProductColor())) {
				addParams.put("product_color", null);
			} else {
				addParams.put("product_color", product.getProductColor());
			}
			addParams.put("price", product.getPrice());
			if (("null".equals(product.getRateClassId())) | "".equals(product.getRateClassId())) {
				addParams.put("rate_class_id", null);
			} else {
				addParams.put("rate_class_id", product.getRateClassId());
			}
			addParams.put("product", product.getProduct());
			addParams.put("order_code_id", product.getOrderCodeId());
			addParams.put("allow_on_internet", product.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
			if ("null".equals(product.getTagLine()) | "".equals(product.getTagLine())) {
				addParams.put("tag_line", null);
			} else {
				addParams.put("tag_line", product.getTagLine());
			}
			if ("null".equals(product.getItemUrl()) | "".equals(product.getItemUrl())) {
				addParams.put("item_url", null);
			} else {
				addParams.put("item_url", product.getItemUrl());
			}
			if ("null".equals(product.getImageUrl()) | "".equals(product.getImageUrl())) {
				addParams.put("image_url", null);
			} else {
				addParams.put("image_url", product.getImageUrl());

			}
			if ("null".equals(product.getAuxiliary_1()) | "".equals(product.getAuxiliary_1())) {
				addParams.put("auxiliary_1", null);
			} else {
				addParams.put("auxiliary_1", product.getAuxiliary_1());
			}
			if ("null".equals(product.getAuxiliary_2()) | "".equals(product.getAuxiliary_2())) {
				addParams.put("auxiliary_2", null);
			} else {
				addParams.put("auxiliary_2", product.getAuxiliary_2());
			}
			if ("null".equals(product.getPremiumOrderCodeId()) | "".equals(product.getPremiumOrderCodeId())) {
				addParams.put("premium_order_code_id", null);
			} else {
				addParams.put("premium_order_code_id", product.getPremiumOrderCodeId());
			}
			namedParameterJdbcTemplate.update(saveQuery.toString(), addParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int getProductId() {
		
		int productId = 0; 
		try { String
			  maxId=jdbcTemplate.queryForObject("select max(product_id) from product",String.class); 
		if(maxId==null) { productId=0; }else {
			  productId=Integer.parseInt(maxId); }
			  }catch(Exception e) {
			  LOGGER.error(ERROR + e); } return productId;
			}

				@Override
				public int updateDetails(ProductModel product) {
			Map<String,Object> updateSourceParams=new LinkedHashMap<>();
			int status=0;
			StringBuilder query=new StringBuilder("update product set product_id=:product_id,oc_id=:oc_id,inventory_id=:inventory_id,description=:description,");
			query.append("product_size=:product_size,product_style=:product_style,product_color=:product_color,price=:price,rate_class_id=:rate_class_id,product=:product,");
			query.append("order_code_id=:order_code_id,allow_on_internet=:allow_on_internet,tag_line=:tag_line,item_url=:item_url,image_url=:image_url,auxiliary_1=:auxiliary_1,");
			query.append("auxiliary_2=:auxiliary_2,premium_order_code_id=:premium_order_code_id");
			query.append(" where product_id=:product_id and  oc_id=:oc_id");
			try {
					updateSourceParams.put("product_id",product.getProductId());
					updateSourceParams.put("oc_id", product.getOcId());
					if ("null".equals(product.getInventoryId()) | "".equals(product.getInventoryId())) {
						updateSourceParams.put("inventory_id", null);
					} else {
						updateSourceParams.put("inventory_id", product.getInventoryId());
					}
					if ("null".equals(product.getDescription()) | "".equals(product.getDescription())) {
						updateSourceParams.put("description", null);
					} else {
						updateSourceParams.put("description",product.getDescription() );
					}
					if ("null".equals(product.getProductSize()) | "".equals(product.getProductSize())) {
						updateSourceParams.put("product_size", null);
				
					} else {
						updateSourceParams.put("product_size", product.getProductSize());
					}
					if ("null".equals(product.getProductStyle()) | "".equals(product.getProductStyle())) {
						updateSourceParams.put("product_style", null);
					} else {
						updateSourceParams.put("product_style", product.getProductStyle());
					}
					if ("null".equals(product.getProductColor()) | "".equals(product.getProductColor())) {
						updateSourceParams.put("product_color", null);
					} else {
						updateSourceParams.put("product_color", product.getProductColor());
					}
					updateSourceParams.put("price", product.getPrice());
					if (("null".equals(product.getRateClassId())) | "".equals(product.getRateClassId())) {
						updateSourceParams.put("rate_class_id", null);
					} else {
						updateSourceParams.put("rate_class_id", product.getRateClassId());
					}
					updateSourceParams.put("product", product.getProduct());
					updateSourceParams.put("order_code_id", product.getOrderCodeId());
					updateSourceParams.put("allow_on_internet", product.getAllowOnInternet().equalsIgnoreCase("true") ? 1 : 0);
					if ("null".equals(product.getTagLine()) | "".equals(product.getTagLine())) {
						updateSourceParams.put("tag_line", null);
					} else {
						updateSourceParams.put("tag_line", product.getTagLine());
					}
					if ("null".equals(product.getItemUrl()) | "".equals(product.getItemUrl())) {
						updateSourceParams.put("item_url", null);
					} else {
						updateSourceParams.put("item_url", product.getItemUrl());
					}
					if ("null".equals(product.getImageUrl()) | "".equals(product.getImageUrl())) {
						updateSourceParams.put("image_url", null);
					} else {
						updateSourceParams.put("image_url", product.getImageUrl());
				
					}
					if ("null".equals(product.getAuxiliary_1()) | "".equals(product.getAuxiliary_1())) {
						updateSourceParams.put("auxiliary_1", null);
					} else {
						updateSourceParams.put("auxiliary_1", product.getAuxiliary_1());
					}
					if ("null".equals(product.getAuxiliary_2()) | "".equals(product.getAuxiliary_2())) {
						updateSourceParams.put("auxiliary_2", null);
					} else {
						updateSourceParams.put("auxiliary_2", product.getAuxiliary_2());
					}
					if ("null".equals(product.getPremiumOrderCodeId()) | "".equals(product.getPremiumOrderCodeId())) {
						updateSourceParams.put("premium_order_code_id", null);
					} else {
						updateSourceParams.put("premium_order_code_id", product.getPremiumOrderCodeId());
					}
					namedParameterJdbcTemplate.update(query.toString(),updateSourceParams);
					status++;
				}catch(Exception e) {
					LOGGER.error(ERROR + e);
				}
		return status;
	}

				@Override
				public String deleteProductDetails(int productId) {
					StringBuilder returnStatus=new StringBuilder();
					int status=0;
					StringBuilder query=new StringBuilder("delete product from product ");
					query.append(" left join catalog_content on product.product_id=catalog_content.product_id ");
					query.append(" left join job_prod_oc on product.product_id=job_prod_oc.product_id ");
					query.append(" left join package_content on product.product_id=package_content.product_id ");
					query.append(" left join promotion_card_offer on product.product_id=promotion_card_offer.product_id ");
					query.append(" left join quick_order_content on product.product_id=quick_order_content.product_id ");
					query.append(" left join event_queue on product.product_id=event_queue.product_id ");
					query.append(" left join order_item on product.product_id=order_item.product_id ");
					query.append(" left join pkg_def_content on product.product_id=pkg_def_content.product_id ");
					query.append(" left join promotion_hist_offer on product.product_id=promotion_hist_offer.product_id ");
					query.append(" left join work_promotion_offer on product.product_id=work_promotion_offer.product_id ");
					query.append(" left join generic_promotion on product.product_id=generic_promotion.product_id ");
					query.append("where product.product_id= ");
					query.append(productId);
					try {
						status=jdbcTemplate.update(query.toString());
						returnStatus.append(status);
					}catch(Exception e) {
						LOGGER.error(ERROR + e);
						returnStatus.append(e);
					}
					return returnStatus.toString();
				}

				@Override
				public List<DropdownModel> getInventoryList() {
					List<DropdownModel> inventory=new ArrayList<>();
					try {
						List<Map<String,Object>> inventory1=jdbcTemplate.queryForList("select inventory_id,inven_code,description,active from inventory ");
						for(Map<String,Object> in:inventory1) {
							DropdownModel model=new DropdownModel();
							model.setKey(in.get("inventory_id").toString());
							model.setDisplay(in.get("inven_code").toString());
							model.setDescription(in.get("description").toString());
							model.setExtra(in.get("active").toString());
							inventory.add(model);
						}
					}catch(Exception e) {
						LOGGER.error(ERROR + e);
					}
					return inventory;
				}

				@Override
				public List<DropdownModel> getOrderList(int ocId) {
					List<DropdownModel> order=new ArrayList<>();
					try {
						List<Map<String,Object>> orderDetails=jdbcTemplate.queryForList("select order_code,description,order_code_type from order_code where oc_id="+ocId);
						for(Map<String,Object> odr:orderDetails) {
							DropdownModel model=new DropdownModel();
							model.setKey(odr.get("order_code")!=null?odr.get("order_code").toString():"");
							model.setDescription(odr.get("description")!=null?odr.get("description").toString():"");
							model.setDisplay(odr.get("order_code_type").toString());
							order.add(model);
						}
					}catch(Exception e) {
						LOGGER.error(ERROR + e);
					}
					return order;
				}

				@Override
				public List<DropdownModel> getPremiumList(int ocId) {
					List<DropdownModel> Premium = new ArrayList<>();
					try {
						List<Map<String, Object>> premium = jdbcTemplate.queryForList(
								"select order_code.order_code,order_code.description,order_code.order_code_type FROM  subscription_def left join order_code ON subscription_def.premium_order_code_id = order_code.order_code_id where subscription_def.oc_id="
										+ ocId);
						for (Map<String, Object> Pre : premium) {
							DropdownModel model = new DropdownModel();
							model.setKey(Pre.get("order_code").toString());
							model.setDescription(Pre.get("description") != null ? Pre.get("description").toString() : "");
							model.setDisplay(Pre.get("order_code_type").toString());
							Premium.add(model);
						}
					} catch (Exception e) {
						LOGGER.error(ERROR + e);
					}
					return Premium;
				}

				@Override
				public List<Map<String, Object>> getSubscriptionStart(Integer ocId) {
					List<Map<String, Object>> startDate = new ArrayList<>();
					try {
						startDate = jdbcTemplate.queryForList(
								" select oc_id,from_date,start_type,issue_id,to_date,volume_group_id,start_date from start_date where oc_id="+ocId);
						
					} catch (Exception e) {
						LOGGER.error(ERROR + e);
					}
					return startDate;
				
				}



 
	
}
