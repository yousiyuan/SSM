package com.ssm.demo.service.impl;

import org.springframework.stereotype.Service;

import com.ssm.demo.entity.OrderDetails;
import com.ssm.demo.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetails> implements OrderDetailService {

	public OrderDetailServiceImpl() {
		this.setInsertSqlId("mapper.ORDERDETAILS.insertSelective");
		this.setUpdateSqlId("mapper.ORDERDETAILS.updateByPrimaryKeySelective");
		this.setQuerySqlId("mapper.ORDERDETAILS.selectByPrimaryKey");
		this.setDeleteSqlId("mapper.ORDERDETAILS.deleteByPrimaryKey");
	}

}
