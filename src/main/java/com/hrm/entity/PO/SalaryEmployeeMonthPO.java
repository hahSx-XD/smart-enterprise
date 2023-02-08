package com.hrm.entity.PO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工每月工资记录
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-09 20:48
 * @Version: 1.0
 */
@Data
public class SalaryEmployeeMonthPO {

    private Integer s_emp_record_id;
    private Integer s_record_id;
    private Integer employee_id;
    private BigDecimal actual_work_day;
    private BigDecimal need_work_day;
    private Integer year;
    private Integer month;
    private Date create_time;

}
