package com.hrm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.entity.PO.DeptInfoPO;
import com.hrm.entity.VO.DeptInfoVO;
import com.hrm.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门控制类
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 19:31
 * @Version: 1.0
 */
@CrossOrigin("*")
@RequestMapping(value = "/hrmDept")
@Controller
@Slf4j
@Api(tags = "部门管理")
public class DeptController {
    
    @Autowired
    private DeptService deptService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/queryAllDept")
    @ResponseBody
    @ApiOperation(value = "查询所有部门的ID和name", httpMethod = "GET")
    public String queryAllDept() throws JsonProcessingException {
        List<DeptInfoPO> deptInfoPOS = deptService.queryAllDept();
        return objectMapper.writeValueAsString(deptInfoPOS);
    }

    @RequestMapping("/queryDeptInfoById")
    @ResponseBody
    @ApiOperation(value = "根据部门ID查询部门信息", httpMethod = "GET")
    @ApiImplicitParam(name = "dept_id", dataType = "int", required = true, value = "部门ID", paramType = "query")
    public String queryDeptInfoById(int dept_id) throws JsonProcessingException {
        DeptInfoVO deptInfoVO = deptService.queryDeptInfoById(dept_id);
        return objectMapper.writeValueAsString(deptInfoVO);
    }

}
