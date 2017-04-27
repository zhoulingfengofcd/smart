package com.smart.demo.controller.customer;

import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.hbasedo.Monitor;


@Controller
@RequestMapping("/monitor")
public class MonitorController {
	@Resource
	MonitorService monitorService;
	@RequestMapping(value="/get")
	public @ResponseBody Monitor getMonitor(Integer equipId,GregorianCalendar calendar){
		//别忘记验证传参和用户身份是否匹配
		System.out.println("equipid="+equipId+"calendar="+calendar);
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		Monitor monitor= monitorService.getMonitorByEquipIdAndCalendar(equipId,calendar);
		System.out.println("------------monitor:"+monitor);
		return monitor;
	}
	@RequestMapping(value="/list")
	public @ResponseBody List<Monitor> listMonitor(Integer equipId,GregorianCalendar startCalendar,GregorianCalendar endCalendar){
		//别忘记验证传参和用户身份是否匹配
		
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		List<Monitor> list = monitorService.listMonitorByStartAndEndOfCalendar(equipId, startCalendar, endCalendar);
		return list;
	}
}
