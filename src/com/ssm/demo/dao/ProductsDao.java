package com.ssm.demo.dao;

import com.ssm.demo.entity.Products;

public interface ProductsDao extends BaseDao<Products> {

	public abstract int count(String sqlId);

}
