package com.hrm.entity.PO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工资细节款项记录表
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-10 09:37
 * @Version: 1.0
 */
@Data
public class SalaryEmployeeDetailPO {

    private Integer salary_id;
    private Integer employee_id;
    private Integer option_code;
    private BigDecimal money;
    private Integer year;
    private Integer month;
    private Date create_time;

}