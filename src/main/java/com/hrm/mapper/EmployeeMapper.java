package com.hrm.mapper;

import com.hrm.entity.PO.Employee;
import com.hrm.entity.PO.EmployeeAbnormalChangePO;
import com.hrm.entity.PO.EmployeeChangePO;
import com.hrm.entity.VO.EmployeeChangeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 员工操作mapper
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-05 09:55
 * @Version: 1.0
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 根据员工状态status查询 List<ID>
     *
     * @param: int
     * @Param:
     * @Return:
     * @Author: Cai
     * @Date: 2022/5/5 10:04
     */
    @Select("select employee_id from wk_hrm_employee where entry_status = 1 and status = #{status} and is_del = 0")
    List<Integer> queryEmployeeByStatus(int status);

    /**
     * 根据员工入职状态entry_status查询 List<ID>
     *
     * @param: int
     * @Param:
     * @Return:
     * @Author: Cai
     * @Date: 2022/5/5 14:27
     */
    @Select("select employee_id from wk_hrm_employee where entry_status = #{entry_status} and is_del = 0")
    List<Integer> queryEmployeeByEntryStatus(int entry_status);

    /**
     * 根据 月份 和 change_type 查询 List<ID>
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/5 16:54
     */
    @Select("select employee_id from wk_hrm_employee_abnormal_change_record b where DATE_FORMAT(b.change_time, '%Y') = #{year} and DATE_FORMAT(b.change_time, '%M') = #{month} and type = #{type} and is_del = 0")
    List<Integer> queryEmployeeChangeByTypeAndMonth(@Param("year") String year, @Param("month") String month, @Param("type") int type);

    /**
     * 根据员工状态查询信息列表
     * @param status
     * @return
     */
    @Select("select * from wk_hrm_employee where status = #{status} and entry_status = 1 and is_del = 0")
    List<Employee> queryEmployeeInfoListByStatus(int status);

    /**
     * 根据入职状态查询员工信息列表
     * @return
     */
    @Select("select * from wk_hrm_employee where entry_status = #{entryStatus} and is_del = 0")
    List<Employee> queryEmployeeInfoListByEntryStatus(int entryStatus);

    /**
     * 新增员工信息
     * @return
     */
    @Insert("insert into wk_hrm_employee values(#{employee_id}, #{employee_name}, #{mobile}, #{country}, #{nation}, #{id_type}, #{id_number}, #{sex}, #{email}, #{native_place}, #{date_of_birth}, #{birthday_type}, #{birthday}, #{age}, #{address}, #{highest_education}, #{entry_time}, #{probation}, #{become_time}, #{job_number}, #{dept_id}, #{parent_id}, #{post}, #{post_level}, #{work_address}, #{work_detail_address}, #{work_city}, #{channel_id}, #{employment_forms}, #{status}, #{company_age_start_time}, #{company_age}, #{candidate_id}, #{entry_status}, 0, #{create_user_id}, #{create_time}, #{update_time})")
    @SelectKey(statement = "select last_insert_id();", resultType = int.class, before = false, keyProperty = "employee_id")
    void createEmployee(Employee employee);

    /**
     * 记录员工特殊变动信息
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/6 13:42
     */
    @Insert("insert into wk_hrm_employee_abnormal_change_record values(#{change_record_id}, #{type}, #{employee_id}, #{reason}, #{remark}, #{effect_time}, now())")
    void recordEmployeeAbnormalChange(EmployeeAbnormalChangePO employeeAbnormalChangePO);

    /**
     * 记录员工正常变动信息
     * @Param:
     * @param
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/7 09:57
     */
    @Insert("insert into wk_hrm_employee_change_record values(#{record_id}, #{employee_id}, #{change_type}, #{change_reason}, #{old_dept}, #{new_dept}, #{old_post}, #{new_post}, #{old_post_level}, #{new_post_level}, #{old_work_address}, #{new_work_address}, #{old_parent_id}, #{new_parent_id}, #{probation}, #{effect_time}, #{create_user_id}, #{create_time})")
    void recordEmployeeChange(EmployeeChangePO employeeChangePO);

    /**
     * 根据部门ID查询部门名字
     * @Param:
     * @param
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/7 16:34
     */
    @Select("select name from wk_hrm_dept where dept_id = #{dept_id}")
    String queryDeptNameByDeptId(@Param("dept_id") int dept_id);

    /**
     * 查询岗位修改界面员工详细信息
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/7 21:22
     */
    @Select("select e.employee_id, e.employee_name, e.post post_name, e.post_level, e.work_address, d.name dept_name, e2.employee_name parent_name " +
            "from wk_hrm_employee e, wk_hrm_dept d, wk_hrm_employee e2 " +
            "where e.dept_id = d.dept_id and e.parent_id = e2.employee_id and e.employee_id = #{employee_id}")
    EmployeeChangeVO queryDeptChangePageInfoByEmployeeId(int employee_id);

    /**
     * 修改员工岗位信息
     * @Param:
     * @param
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/7 21:55
     */
    @Update({"<script>",
            "update wk_hrm_employee",
            "<set>",
                " update_time = now(),",
                "<if test = 'new_dept != null'>",
                    " dept_id = #{new_dept},",
                "</if>",
                "<if test = 'new_post != null'>",
                    " post = #{new_post},",
                "</if>",
                "<if test = 'new_post_level != null'>",
                    " post_level = #{new_post_level},",
                "</if>",
                "<if test = 'new_work_address != null'>",
                    " work_address = #{new_work_address},",
                "</if>",
                "<if test = 'new_parent_id != null'>",
                    " parent_id = #{new_parent_id},",
                "</if>",
                "<if test = 'create_time != null'>",
                    " update_time = #{create_time},",
                "</if>",
            "</set>",
            "where employee_id = #{employee_id}",
    "</script>"})
    void changeEmployeeDept(EmployeeChangePO employeeChangePO);

    /**
     * 转正
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/11 08:57
     */
    @Update("update wk_hrm_employee set status = 1, update_time = now() where employee_id = #{employee_id}")
    void employeePositive(int employee_id);

    /**
     * 离职
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/11 08:57
     */
    @Update("update wk_hrm_employee set entry_status = 4, update_time = now() where employee_id = #{employee_id}")
    void employeeDimission(int employee_id);

    /**
     * 根据员工ID查询员工信息
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/8 12:57
     */
    @Select("select * from wk_hrm_employee where employee_id = #{employee_id}")
    Employee queryEmployeeInfoById(int employee_id);

    /**
     * 删除员工信息
     * @Param:
     * @param
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/8 13:01
     */
    @Update("update wk_hrm_employee set is_del = 1 where employee_id = #{employee_id}")
    void deleteEmployeeById();

    /**
     * 根据员工部门查询信息列表
     * @param
     * @return
     */
    @Select("select * from wk_hrm_employee where dept_id = #{dept_id} and entry_status = 1 and is_del = 0")
    List<Employee> queryEmployeeInfoListByDept(int dept_id);

    @Select("select employee_id, employee_name from wk_hrm_employee where entry_status = 1 and is_del = 0")
    Map<Integer, String> queryAllEmployee();

}
