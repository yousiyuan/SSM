package com.ssm.demo.service.impl;

import org.springframework.stereotype.Service;

import com.ssm.demo.entity.Orders;
import com.ssm.demo.service.OrderService;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Orders> implements OrderService {

	public OrderServiceImpl() {
		this.setInsertSqlId("mapper.ORDERS.insertSelective");
		this.setUpdateSqlId("mapper.ORDERS.updateByPrimaryKeySelective");
		this.setQuerySqlId("mapper.ORDERS.selectByPrimaryKey");
		this.setDeleteSqlId("mapper.ORDERS.deleteByPrimaryKey");
	}

}
