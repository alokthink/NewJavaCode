package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.Product;

public class ProductMapper implements RowMapper<Product>{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductMapper.class);
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product productData = new Product();
		try 
		{
			productData.setProductId(rs.getInt("product_id"));
			productData.setInventoryId(rs.getString("inventory_id")!=null?rs.getString("inventory_id"):"");
			productData.setDescription(rs.getString("description"));
			productData.setOcId(rs.getString("oc_id"));
		    productData.setOrderClass(rs.getString("oc"));
			productData.setOrderCode(rs.getString("order_code"));
			productData.setPrice(rs.getString("price")!=null?rs.getString("price"):"");
			productData.setProduct(rs.getString("product")!=null?rs.getString("product"):"");
			productData.setProductColor(rs.getString("product_color")!=null?rs.getString("product_color"):"");
			productData.setProductSize(rs.getString("product_size")!=null?rs.getString("product_size"):"");
			productData.setProductStyle(rs.getString("product_style")!=null?rs.getString("product_style"):"");
			productData.setRateClassId(rs.getString("rate_class_id")!=null?rs.getString("rate_class_id"):"");			
			productData.setBundleQty(1);
			productData.setLocalAmount(rs.getDouble("price"));
			productData.setBaseAmount(rs.getDouble("price"));			
		    productData.setCurrency(rs.getString("currency"));
			productData.setExchangeRate(rs.getString("exchange_rate"));
			//Edited for 610,611,615
			productData.setOrderQty(rs.getString("qty")!=null?Integer.parseInt(rs.getString("qty")):1);
			productData.setOrderCodeId(rs.getString("order_code_id"));
		}catch(Exception e)
		{
			LOGGER.info("productData : "+e);
		}
		return productData;
	}
}
