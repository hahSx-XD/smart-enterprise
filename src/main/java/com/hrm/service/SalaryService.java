package com.hrm.service;

import com.hrm.entity.BO.SalaryEmployeeDetailBO;
import com.hrm.entity.VO.SalaryEmployeeDetailVO;

import java.util.List;
import java.util.Map;

/**
 * 薪资管理业务逻辑层
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-10 10:02
 * @Version: 1.0
 */
public interface SalaryService {

    SalaryEmployeeDetailBO queryEmployeeSalaryItemByEmployeeId(int employee_id);

    List<SalaryEmployeeDetailVO> querySalaryInfoByEmployeeStatus(int status);
    
    Map<Integer, Integer> querySalaryNum();

}
