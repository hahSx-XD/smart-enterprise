package com.hrm.service.impl;

import com.hrm.entity.PO.DeptInfoPO;
import com.hrm.entity.VO.DeptInfoVO;
import com.hrm.mapper.DeptMapper;
import com.hrm.mapper.EmployeeMapper;
import com.hrm.service.DeptService;
import com.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Cai 🥬
 * @Date: 2022-05-08 19:37
 * @Version: 1.0
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeService employeeService;

    @Override
    public List<DeptInfoPO> queryAllDept() {
        List<DeptInfoPO> deptInfoPOS = deptMapper.queryAllDept();
        return deptInfoPOS;
    }

    @Override
    public DeptInfoVO queryDeptInfoById(Integer dept_id) {
        DeptInfoPO deptInfoPO = deptMapper.queryDeptInfoById(dept_id);

        DeptInfoVO deptInfoVO = new DeptInfoVO(deptInfoPO);

        deptInfoVO.setParent_name(deptMapper.queryDeptInfoById(deptInfoPO.getPid()).getName());
        deptInfoVO.setMain_employee(employeeMapper.queryEmployeeInfoById(deptInfoPO.getMain_employee_id()).getEmployee_name());
        deptInfoVO.setLeader_employee(employeeMapper.queryEmployeeInfoById(deptInfoPO.getLeader_employee_id()).getEmployee_name());

        deptInfoVO.setEmployeeVOS(employeeService.queryEmployeeInfoListByDept(dept_id));
        deptInfoVO.setEmployeeNum(deptInfoVO.getEmployeeVOS().size());

        return deptInfoVO;
    }

}
