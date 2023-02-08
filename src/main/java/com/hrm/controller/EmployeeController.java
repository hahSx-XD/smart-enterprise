package com.hrm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.entity.PO.Employee;
import com.hrm.entity.PO.EmployeeAbnormalChangePO;
import com.hrm.entity.PO.EmployeeChangePO;
import com.hrm.entity.VO.EmployeeChangeVO;
import com.hrm.entity.VO.EmployeeVO;
import com.hrm.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 员工操作
 *
 * @Author:Cai 🥬
 * @Date: 2022-05-05 09:12
 * @Version: 1.0
 */
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/hrmEmployee")
@Api(tags = "员工管理")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/queryEmployeeStatusNum")
    @ApiOperation(value = "查询各状态员工的数量(员工管理)", httpMethod = "GET")
    @ResponseBody
    public String queryEmployeeStatusNum() throws JsonProcessingException {
        Map<Integer, Integer> employeeStatusNum = employeeService.queryEmployeeStatusNum();
        return objectMapper.writeValueAsString(employeeStatusNum);
    }

    @RequestMapping("/queryEmployeeEntryStatusNum")
    @ApiOperation(value = "查询在职员工数量(工作台-人事概况-在职人员、员工管理)", httpMethod = "GET")
    @ResponseBody
    public String queryEmployeeEntryStatusNum() throws JsonProcessingException {
        Map<Integer, Integer> integerIntegerMap = employeeService.queryEmployeeEntryStatusNum();
        return objectMapper.writeValueAsString(integerIntegerMap);
    }

    @RequestMapping("/queryEmployeeChangeNum")
    @ApiOperation(value = "查询变动员工数量(工作台-人事概况-除在职人员外)", httpMethod = "GET")
    @ResponseBody
    public String queryEmployeeChangeNum() throws JsonProcessingException {
        Map<Integer, Integer> queryEmployeeChangeNum = employeeService.queryEmployeeChangeNum();
        return objectMapper.writeValueAsString(queryEmployeeChangeNum);
    }

    @RequestMapping("/queryEmployeeInfoListByStatus")
    @ApiOperation(value = "根据员工状态status查询员工信息(员工管理)", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", dataType = "int", required = true)
    })
    @ResponseBody
    public String queryEmployeeInfoListByStatus(@RequestParam("status") int status) throws JsonProcessingException {
        List<EmployeeVO> employees = employeeService.queryEmployeeInfoListByStatus(status);
        return objectMapper.writeValueAsString(employees);
    }

    @RequestMapping("/queryEmployeeInfoListByEntryStatus")
    @ApiOperation(value = "根据入职状态entryStatus查询员工信息(员工管理)", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entryStatus", dataType = "int", required = true)
    })
    @ResponseBody
    public String queryEmployeeInfoListByEntryStatus(@RequestParam("entryStatus") int entryStatus) throws JsonProcessingException {
        List<EmployeeVO> employees = employeeService.queryEmployeeInfoListByEntryStatus(entryStatus);
        return objectMapper.writeValueAsString(employees);
    }

    @RequestMapping("/createInEmployee")
    @ApiOperation(value = "新增在职员工信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "json", required = true, value = "employee_id=null, employee_name=notNull, mobile=null, country=null, nation=null, id_type=null, id_number=null, sex=null, email=null, native_place=null, date_of_birth=null, birthday_type=null, birthday=null, age=null, address=null, highest_education=null, entry_time=null, probation=null, become_time=null, job_number=null, dept_id=null, parent_id=null, post=null, post_level=null, work_address=null, work_detail_address=null, work_city=null, channel_id=null, employment_forms=null, status=null, company_age_start_time=null, company_age=null, candidate_id=null, entry_status=null, is_del=null, create_user_id=null, create_time=null, update_time=null, dept_name=null")
    })
    @ResponseBody
    public String createInEmployee(@RequestBody Employee employee) throws JsonProcessingException {
        int n = employeeService.createInEmployee(employee);
        if (n == 1) {
            return "新增成功！";
        } else {
            return "新增失败，请重试！";
        }
    }

    @RequestMapping("/createReadyEmployee")
    @ApiOperation(value = "新增待入职职员工信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "json", required = true, value = "employee_id=null, employee_name=notNull, mobile=null, country=null, nation=null, id_type=null, id_number=null, sex=null, email=null, native_place=null, date_of_birth=null, birthday_type=null, birthday=null, age=null, address=null, highest_education=null, entry_time=null, probation=null, become_time=null, job_number=null, dept_id=null, parent_id=null, post=null, post_level=null, work_address=null, work_detail_address=null, work_city=null, channel_id=null, employment_forms=null, status=null, company_age_start_time=null, company_age=null, candidate_id=null, entry_status=null, is_del=null, create_user_id=null, create_time=null, update_time=null, dept_name=null")
    })
    @ResponseBody
    public String createReadyEmployee(@RequestBody Employee employee) throws JsonProcessingException {
        int n = employeeService.createReadyEmployee(employee);
        if (n == 1) {
            return "新增成功！";
        } else {
            return "新增失败，请重试！";
        }
    }

    @RequestMapping("/queryDeptChangePageInfoByEmployeeId")
    @ApiOperation(value = "变动岗位页面展示信息", httpMethod = "GET")
    @ApiImplicitParam(name = "employee_id", dataType = "int", required = true, value = "员工ID")
    @ResponseBody
    public String queryDeptChangePageInfoByEmployeeId(int employee_id) throws JsonProcessingException {
        EmployeeChangeVO employeeChangeVO = employeeService.queryDeptChangePageInfoByEmployeeId(employee_id);
        return objectMapper.writeValueAsString(employeeChangeVO);
    }

    @RequestMapping("/changeDept")
    @ApiOperation(value = "员工岗位变动", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "岗位变动信息", dataType = "json"),
            @ApiImplicitParam(name = "employee_id", value = "员工ID", dataType = "int", required = true),
            @ApiImplicitParam(name = "change_type", value = "变动类型 1 转正，2 调岗，3 晋升，4 降级，5 转为全职"),
            @ApiImplicitParam(name = "change_reason", value = "异动原因 1 组织架构调整 2个人申请 3 工作安排 4 违规违纪 5 绩效不达标 6 个人身体原因 7 不适应当前岗位")
    })
    @ResponseBody
    public String changeDept(@RequestBody EmployeeChangePO employeeChangePO) throws JsonProcessingException {
        employeeChangePO.setCreate_time(new Date());
        int p = employeeService.changeDept(employeeChangePO);
        if (p == 1) {
            return "修改成功！";
        } else {
            return "修改失败！";
        }
    }

    @RequestMapping("/deleteEmployeeById")
    @ApiOperation(value = "删除员工", httpMethod = "GET")
    @ApiImplicitParam(name = "employee_id", value = "员工ID", dataType = "int", required = true)
    @ResponseBody
    public String deleteEmployeeById(int employee_id) {
        int i = employeeService.deleteEmployeeById(employee_id);
        if (i == 1) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    @RequestMapping("/employeeDimission")
    @ApiOperation(value = "员工离职", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employee_id", value = "离职员工ID", dataType = "int", required = true),
            @ApiImplicitParam(name = "effect_time", value = "生效时间", dataType = "date", required = true)
    })
    @ResponseBody
    public String employeeDimission(@RequestBody EmployeeAbnormalChangePO employeeAbnormalChangePO) {
        int i = employeeService.employeeDimission(employeeAbnormalChangePO);
        if (i == -1) {
            return "离职操作失败！";
        } else {
            return "离职操作成功！";
        }
    }

    @RequestMapping("/queryAllEmployee")
    @ApiOperation(value = "查询所有员工ID和name", httpMethod = "GET")
    @ResponseBody
    public String queryAllEmployee() throws JsonProcessingException {
        Map<Integer, String> integerStringMap = employeeService.queryAllEmployee();
        return objectMapper.writeValueAsString(integerStringMap);
    }

}