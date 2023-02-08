package com.hrm.entity.BO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 员工薪资细节展示
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-10 10:16
 * @Version: 1.0
 */
@Data
public class SalaryEmployeeDetailBO {

    private Integer employee_id;
    private String employee_name;
    private Integer actual_work_day;
    private BigDecimal need_work_day;
    private Integer year;
    private Integer month;
    private Date create_time;

    private List<SalaryItemBO> salaryItemBOS;

}
