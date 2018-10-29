package com.ssm.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.ssm.demo.dao.ProductsDao;
import com.ssm.demo.entity.Products;

@Repository
public class ProductsDaoImpl extends BaseDaoImpl<Products> implements ProductsDao {

	@Override
	public int count(String sqlId) {
		return sqlSession.selectOne(sqlId);
	}

}
