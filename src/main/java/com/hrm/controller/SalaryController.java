package com.hrm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.entity.VO.SalaryEmployeeDetailVO;
import com.hrm.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 薪资管理控制类
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-10 10:00
 * @Version: 1.0
 */
@RequestMapping("/hrmSalary")
@Api(tags = "薪资管理")
@Controller
@CrossOrigin("*")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;
    private ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/querySalaryInfoByEmployeeStatus")
    @ApiOperation(value = "根据员工状态查询薪资信息")
    @ApiImplicitParam(name = "status", value = "员工状态 0 全部 1正式 2试用  3实习 4兼职 5劳务 6顾问 7返聘 8外包", dataType = "int", paramType = "query")
    @ResponseBody
    public String querySalaryInfoByEmployeeStatus(int status) throws JsonProcessingException {
        if (status == 0) {
            List<SalaryEmployeeDetailVO> salaryEmployeeDetailVOS = new ArrayList<>();
            for (int i = 1; i < 9; i++) {
                salaryEmployeeDetailVOS.addAll(salaryService.querySalaryInfoByEmployeeStatus(i));
            }
            return objectMapper.writeValueAsString(salaryEmployeeDetailVOS);
        }
        
        List<SalaryEmployeeDetailVO> salaryEmployeeDetailVOS = salaryService.querySalaryInfoByEmployeeStatus(status);
        return objectMapper.writeValueAsString(salaryEmployeeDetailVOS);
    }
    
    @GetMapping("/querySalaryNum")
    @ApiOperation("查询计薪人数")
    @ResponseBody
    public String querySalaryNum() throws JsonProcessingException {
        Map<Integer, Integer> map = salaryService.querySalaryNum();
        return objectMapper.writeValueAsString(map);
    }

}
