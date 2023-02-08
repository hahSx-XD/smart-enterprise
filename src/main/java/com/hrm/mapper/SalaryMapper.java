package com.hrm.mapper;

import com.hrm.entity.BO.SalaryItemBO;
import com.hrm.entity.BO.SalaryEmployeeDetailBO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 薪资管理mapper类
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-10 10:03
 * @Version: 1.0
 */
@Mapper
public interface SalaryMapper {

    /**
     * 根据员工ID、年、月查询单项薪资信息集合
     *
     * @param
     * @Param:
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/10 10:40
     */
    @Select("select d.salary_id, d.option_code, o.name option_name, d.money, d.create_time from wk_hrm_salary_month_detail_record d, wk_hrm_salary_option o where d.option_code = o.code and d.employee_id = #{employee_id} and year = #{year} and month = #{month};")
    List<SalaryItemBO> queryItemByEidAndYearMonth(@Param("employee_id") int id, @Param("year") int year, @Param("month") int month);

    /**
     * 根据员工ID查询月薪资详细信息
     * @Param:
     * @param
     * @Return:
     * @Author: Cai 🥬
     * @Date: 2022/5/10 10:49
     */
    @Select("select e.employee_id, e.employee_name, se.actual_work_day, se.need_work_day, se.year, se.month, se.create_time from wk_hrm_salary_month_emp_record se, wk_hrm_employee e where se.employee_id = e.employee_id and se.employee_id = #{employee_id} and year = #{year} and month = #{month};")
    @Results({
            @Result(id = true, column = "employee_id", property = "employee_id"),
            @Result(column = "employee_name", property = "employee_name"),
            @Result(column = "actual_work_day", property = "actual_work_day"),
            @Result(column = "need_work_day", property = "need_work_day"),
            @Result(column = "year", property = "year"),
            @Result(column = "month", property = "month"),
            @Result(column = "create_time", property = "create_time"),
            @Result(
                    property = "salaryItemBOS",
                    column = "{employee_id = employee_id, year = year, month = month}",
                    javaType = List.class,
                    many = @Many(select = "com.hrm.mapper.SalaryMapper.queryItemByEidAndYearMonth")
            )
    })
    SalaryEmployeeDetailBO queryMonthSalaryInfoById(@Param("employee_id") int employee_id, @Param("year") int year, @Param("month") int month);
    
    @Select("select code option_code, name option_name from wk_hrm_salary_option where code = #{option_code}")
    SalaryItemBO queryNullItem(int option_code);

}
