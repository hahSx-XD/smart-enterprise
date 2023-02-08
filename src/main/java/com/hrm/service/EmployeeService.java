package com.hrm.service;

import com.hrm.entity.PO.Employee;
import com.hrm.entity.PO.EmployeeAbnormalChangePO;
import com.hrm.entity.PO.EmployeeChangePO;
import com.hrm.entity.VO.EmployeeChangeVO;
import com.hrm.entity.VO.EmployeeVO;

import java.util.List;
import java.util.Map;

/**
 * 员工操作
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-05 09:22
 * @Version: 1.0
 */
public interface EmployeeService {

    /**
     * 查询各状态员工数量
     *
     * @param: null
     * @Return: Map<Integer, Long>
     * @Author: Cai
     * @Date: 2022/5/5 09:28
     */
    Map<Integer, Integer> queryEmployeeStatusNum();

    /**
     * 查询各入职状态职员工数量
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai
     * @Date: 2022/5/5 15:13
     */
    Map<Integer, Integer> queryEmployeeEntryStatusNum();

    /**
     * 查询当前月员工变动情况
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/5 16:34
     */
    Map<Integer, Integer> queryEmployeeChangeNum();

    /**
     * 查询状态为status的员工信息列表
     *
     * @param status
     * @return
     */
    List<EmployeeVO> queryEmployeeInfoListByStatus(int status);

    /**
     * 根据员工入职状态查询信息列表
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/6 09:44
     */
    List<EmployeeVO> queryEmployeeInfoListByEntryStatus(int entryStatus);

    List<EmployeeVO> queryEmployeeInfoListByDept(int dept_id);

    /**
     * 新增员工记录
     *
     * @param
     * @Param:
     * @Return: a
     * @Author: Cai 🥬
     * @Date: 2022/5/6 09:44
     */
    int createInEmployee(Employee employee);

    /**
     * 新增待入职员工
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/6 14:21
     */
    int createReadyEmployee(Employee employee);

    EmployeeChangeVO queryDeptChangePageInfoByEmployeeId(int employee_id);

    /**
     * 员工岗位调动
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/6 20:17
     */
    int changeDept(EmployeeChangePO employeeChangePO);

    int deleteEmployeeById(int employee_id);

    int employeeDimission(EmployeeAbnormalChangePO employeeAbnormalChangePO);

    Map<Integer, String> queryAllEmployee();

}
