package com.hrm.service.impl;

import com.hrm.entity.BO.SalaryEmployeeDetailBO;
import com.hrm.entity.BO.SalaryItemBO;
import com.hrm.entity.PO.Employee;
import com.hrm.entity.VO.SalaryEmployeeDetailVO;
import com.hrm.mapper.EmployeeMapper;
import com.hrm.mapper.SalaryMapper;
import com.hrm.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: Cai 🥬
 * @Date: 2022-05-10 10:47
 * @Version: 1.0
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    
    @Autowired
    private SalaryMapper salaryMapper;
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Override
    public SalaryEmployeeDetailBO queryEmployeeSalaryItemByEmployeeId(int employee_id) {
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        return salaryMapper.queryMonthSalaryInfoById(employee_id, year, month);
    }
    
    @Override
    public List<SalaryEmployeeDetailVO> querySalaryInfoByEmployeeStatus(int status) {
        
        List<SalaryEmployeeDetailVO> salaryEmployeeDetailVOS = new ArrayList<>();
        
        List<Integer> list = employeeMapper.queryEmployeeByStatus(status);
        
        for (Integer integer : list) {
            SalaryEmployeeDetailBO salaryEmployeeDetailBO = queryEmployeeSalaryItemByEmployeeId(integer);
            
            if (salaryEmployeeDetailBO == null) {
                continue;
            }
            
            Map<Integer, SalaryItemBO> map = new HashMap<>(40);
            
            for (SalaryItemBO salaryItemBO : salaryEmployeeDetailBO.getSalaryItemBOS()) {
                map.put(salaryItemBO.getOption_code(), salaryItemBO);
            }
            List<SalaryItemBO> salaryItemBOS = new ArrayList<>();
            
            for (int i = 1; i < 43; i++) {
                if (map.containsKey(i)) {
                    salaryItemBOS.add(map.get(i));
                } else {
                    SalaryItemBO salaryItemBO = salaryMapper.queryNullItem(i);
                    salaryItemBOS.add(salaryItemBO);
                }
            }
            
            salaryEmployeeDetailBO.setSalaryItemBOS(salaryItemBOS);
            SalaryEmployeeDetailVO salaryEmployeeDetailVO = new SalaryEmployeeDetailVO(salaryEmployeeDetailBO);
            
            Employee employee = employeeMapper.queryEmployeeInfoById(salaryEmployeeDetailVO.getEmployee_id());
            salaryEmployeeDetailVO.setJob_number(employee.getJob_number());
            salaryEmployeeDetailVO.setDept_name(employeeMapper.queryDeptNameByDeptId(employee.getDept_id()));
            salaryEmployeeDetailVO.setPost_name(employee.getPost());
            
            salaryEmployeeDetailVOS.add(salaryEmployeeDetailVO);
            
        }
        
        return salaryEmployeeDetailVOS;
        
    }
    
    @Override
    public Map<Integer, Integer> querySalaryNum() {
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        
        for (int i = 1; i < 9; i++) {
            
            List<Integer> list = employeeMapper.queryEmployeeByStatus(i);
            
            int num = 0;
            
            for (Integer integer : list) {
                SalaryEmployeeDetailBO salaryEmployeeDetailBO = queryEmployeeSalaryItemByEmployeeId(integer);
                
                if (salaryEmployeeDetailBO == null) {
                    continue;
                } else {
                    ++num;
                }
            }
            map.put(i, num);
            sum += num;
        }
        
        map.put(0, sum);
        return map;
    }
    
}
