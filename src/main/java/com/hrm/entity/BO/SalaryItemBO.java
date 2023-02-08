package com.hrm.entity.BO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 单个员工一种薪资信息BO
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-10 10:18
 * @Version: 1.0
 */
@Data
public class SalaryItemBO {

    private Integer salary_id;
    private Integer option_code;
    private String option_name;
    private BigDecimal money;
    private Date create_time;

}
