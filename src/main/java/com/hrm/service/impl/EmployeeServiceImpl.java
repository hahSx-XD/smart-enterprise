package com.hrm.service.impl;

import com.hrm.entity.PO.Employee;
import com.hrm.entity.PO.EmployeeAbnormalChangePO;
import com.hrm.entity.PO.EmployeeChangePO;
import com.hrm.entity.VO.EmployeeChangeVO;
import com.hrm.entity.VO.EmployeeVO;
import com.hrm.mapper.EmployeeMapper;
import com.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: Cai 🥬
 * @Date: 2022-05-05 09:51
 * @Version: 1.0
 */
@Service("employeeService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Map<Integer, Integer> queryEmployeeStatusNum() {
        Map<Integer, Integer> employeeMap = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            List<Integer> employeeList = employeeMapper.queryEmployeeByStatus(i);
            if (employeeList == null) {
                employeeMap.put(i, 0);
            } else {
                employeeMap.put(i, employeeList.size());
            }
        }
        return employeeMap;
    }

    @Override
    public Map<Integer, Integer> queryEmployeeEntryStatusNum() {
        Map<Integer, Integer> employeeMap = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            List<Integer> employeeList = employeeMapper.queryEmployeeByEntryStatus(i);
            if (employeeList == null) {
                employeeMap.put(i, 0);
            } else {
                employeeMap.put(i, employeeList.size());
            }
        }
        return employeeMap;
    }

    @Override
    public Map<Integer, Integer> queryEmployeeChangeNum() {
        String[] date = new Date().toString().split(" ");
        String month = date[1];
        String year = date[5];
        HashMap<Integer, Integer> map = new HashMap<>();
        //入职
        List<Integer> list = employeeMapper.queryEmployeeChangeByTypeAndMonth(year, month, 1);
        if (list == null) {
            map.put(1, 0);
        } else {
            map.put(1, list.size());
        }
        //待入职
        list = employeeMapper.queryEmployeeByStatus(2);
        if (list == null) {
            map.put(2, 0);
        } else {
            map.put(2, list.size());
        }
        //离职
        list = employeeMapper.queryEmployeeChangeByTypeAndMonth(year, month, 2);
        if (list == null) {
            map.put(3, 0);
        } else {
            map.put(3, list.size());
        }
        //待离职
        list = employeeMapper.queryEmployeeByStatus(3);
        if (list == null) {
            map.put(4, 0);
        } else {
            map.put(4, list.size());
        }
        //转正
        list = employeeMapper.queryEmployeeChangeByTypeAndMonth(year, month, 3);
        if (list == null) {
            map.put(5, 0);
        } else {
            map.put(5, list.size());
        }
        //调岗
        list = employeeMapper.queryEmployeeChangeByTypeAndMonth(year, month, 4);
        if (list == null) {
            map.put(6, 0);
        } else {
            map.put(6, list.size());
        }

        return map;
    }

    @Override
    public List<EmployeeVO> queryEmployeeInfoListByStatus(int status) {
        List<Employee> employees = employeeMapper.queryEmployeeInfoListByStatus(status);
        List<EmployeeVO> employeeVOS = new ArrayList<>();
        String dept_name;
        for (Employee employee : employees) {
            dept_name = null;
            if (employee.getDept_id() != null) {
                dept_name = employeeMapper.queryDeptNameByDeptId(employee.getDept_id());
            }
            employeeVOS.add(new EmployeeVO(employee, dept_name));
        }
        return employeeVOS;
    }

    @Override
    public List<EmployeeVO> queryEmployeeInfoListByEntryStatus(int entryStatus) {
        List<Employee> employees = employeeMapper.queryEmployeeInfoListByEntryStatus(entryStatus);
        List<EmployeeVO> employeeVOS = new ArrayList<>();
        String dept_name;
        for (Employee employee : employees) {
            dept_name = null;
            if (employee.getDept_id() != null) {
                dept_name = employeeMapper.queryDeptNameByDeptId(employee.getDept_id());
            }
            employeeVOS.add(new EmployeeVO(employee, dept_name));
        }
        return employeeVOS;
    }

    @Override
    public List<EmployeeVO> queryEmployeeInfoListByDept(int dept_id) {
        List<Employee> employees = employeeMapper.queryEmployeeInfoListByDept(dept_id);
        List<EmployeeVO> employeeVOS = new ArrayList<>();
        String dept_name;
        for (Employee employee : employees) {
            dept_name = null;
            if (employee.getDept_id() != null) {
                dept_name = employeeMapper.queryDeptNameByDeptId(employee.getDept_id());
            }
            employeeVOS.add(new EmployeeVO(employee, dept_name));
        }
        return employeeVOS;
    }

    @Override
    public int createInEmployee(Employee employee) {
        Date date = new Date();

        employee.setEntry_status(1);
        employee.setCreate_time(date);
        employee.setIs_del(0);

        employeeMapper.createEmployee(employee);

        EmployeeAbnormalChangePO employeeAbnormalChangePO = new EmployeeAbnormalChangePO();
        employeeAbnormalChangePO.setEmployee_id(employee.getEmployee_id());
        employeeAbnormalChangePO.setType(1);
        employeeAbnormalChangePO.setCreate_time(date);

        employeeMapper.recordEmployeeAbnormalChange(employeeAbnormalChangePO);

        return 1;
    }

    @Override
    public int createReadyEmployee(Employee employee) {
        employee.setEntry_status(2);
        employee.setCreate_time(new Date());
        employee.setIs_del(0);

        employeeMapper.createEmployee(employee);

        return 1;
    }

    @Override
    public EmployeeChangeVO queryDeptChangePageInfoByEmployeeId(int employee_id) {
        return employeeMapper.queryDeptChangePageInfoByEmployeeId(employee_id);
    }

    @Override
    public int changeDept(EmployeeChangePO employeeChangePO) {

        Employee employee = employeeMapper.queryEmployeeInfoById(employeeChangePO.getEmployee_id());
        employeeChangePO.setOld_dept(employee.getDept_id());
        employeeChangePO.setOld_post(employee.getPost());
        employeeChangePO.setOld_post_level(employee.getPost_level());
        employeeChangePO.setOld_parent_id(employee.getParent_id());
        employeeChangePO.setOld_work_address(employee.getWork_address());
        employeeChangePO.setCreate_time(new Date());

        if (employeeChangePO.getChange_type() == 1) {
            employeeMapper.employeePositive(employee.getEmployee_id());
        }

        employeeMapper.recordEmployeeChange(employeeChangePO);
        employeeMapper.changeEmployeeDept(employeeChangePO);

        return 1;
    }

    @Override
    public int deleteEmployeeById(int employee_id) {

        employeeMapper.deleteEmployeeById();

        return 1;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int employeeDimission(EmployeeAbnormalChangePO employeeAbnormalChangePO) {
        employeeAbnormalChangePO.setType(2);

        employeeMapper.recordEmployeeAbnormalChange(employeeAbnormalChangePO);
        employeeMapper.employeeDimission(employeeAbnormalChangePO.getEmployee_id());

        return 1;
    }

    @Override
    public Map<Integer, String> queryAllEmployee() {
        return employeeMapper.queryAllEmployee();
    }

}
