package com.smart.demo.controller.customer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

@Controller
@RequestMapping("/equip")
public class EquipController {
	@Resource
	EquipService equipService;
	@RequestMapping("/list")
	public @ResponseBody List<SimpleHbaseDOWithKeyResult<Equip>> listEquip(int projectId){
		return equipService.listEquipByProjectId(projectId);
	}
}
