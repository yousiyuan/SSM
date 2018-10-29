package com.ssm.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.demo.entity.Products;
import com.ssm.demo.service.ProductService;

@Controller
@RequestMapping(value = "/manage")
public class ManageController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/api.do", method = { RequestMethod.GET })
	public ModelAndView interfaceJsp() {
		return new ModelAndView("manage/api");
	}

	/**
	 * 列表查询
	 */
	@RequestMapping(value = "/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productList(Products condition) {
		ModelAndView modelAndView = new ModelAndView();
		List<Products> queryForList = productService.queryForList("mapper.PRODUCTS.queryProductByCondition", condition);
		int totalNum = productService.count();
		modelAndView.addObject("ResultSet", queryForList);
		modelAndView.addObject("condition", condition);
		modelAndView.addObject("totalCount", totalNum);
		modelAndView.setViewName("manage/list");// 请求转发
		// modelAndView.setViewName("redirect:/manage/index.do");//客户端跳转
		return modelAndView;
	}

	/**
	 * 添加/编辑
	 */
	@RequestMapping(value = "/edit.do", method = { RequestMethod.GET })
	public ModelAndView productEdit(Products model) {
		Integer productid = model.getProductid();
		ModelAndView modelAndView = new ModelAndView();
		Products object = null;
		if (productid != null)
			object = productService.queryForObject(productid);
		modelAndView.addObject("item", object);
		modelAndView.setViewName("manage/edit");
		return modelAndView;
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "/save.do", method = { RequestMethod.POST })
	public ModelAndView saveProduct(Products model) {
		Integer productid = model.getProductid();
		if (productid == null || productid == 0) {
			// 新增
			productService.insertObject(model);
		} else {
			// 修改
			productService.updateObject(model);
		}
		return new ModelAndView("redirect:list.do");
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete.do", method = { RequestMethod.GET })
	public ModelAndView deleteProduct(int id) {
		productService.deleteObject(id);
		return new ModelAndView("redirect:list.do");
	}

	/**
	 * 日期格式化
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

}
