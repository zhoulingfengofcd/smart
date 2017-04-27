package com.smart.demo.controller.customer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.ProjectService;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	ProjectService projectService;
	@RequestMapping("/list")
	public @ResponseBody List<SimpleHbaseDOWithKeyResult<Project>> listProject(Integer userId){
		//这里有问题，不需要传ID，获得用户ID
		System.out.println("~~~~~~~~~~~进入listProject~~~~~~~~~~~~");
		List<SimpleHbaseDOWithKeyResult<Project>> list = projectService.listProjectByUserId(userId);
		System.out.println("结果："+list);
		return list;
	}
}
