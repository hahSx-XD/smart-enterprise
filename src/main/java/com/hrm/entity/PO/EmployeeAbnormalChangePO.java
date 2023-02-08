package com.hrm.entity.PO;

import lombok.Data;
import java.util.Date;

/**
 * 员工非正常变动类
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-06 10:55
 * @Version: 1.0
 */
@Data
public class EmployeeAbnormalChangePO {

    private Integer change_record_id;
    private Integer type;
    private Integer employee_id;
    private String reason;
    private String remark;
    private Date effect_time;
    private Date create_time;

}