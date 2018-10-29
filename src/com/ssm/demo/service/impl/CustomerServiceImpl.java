package com.ssm.demo.service.impl;

import org.springframework.stereotype.Service;

import com.ssm.demo.entity.Customers;
import com.ssm.demo.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customers> implements CustomerService {

	public CustomerServiceImpl() {
		this.setInsertSqlId("mapper.CUSTOMERS.insertSelective");
		this.setUpdateSqlId("mapper.CUSTOMERS.updateByPrimaryKeySelective");
		this.setQuerySqlId("mapper.CUSTOMERS.selectByPrimaryKey");
		this.setDeleteSqlId("mapper.CUSTOMERS.deleteByPrimaryKey");
	}

}
