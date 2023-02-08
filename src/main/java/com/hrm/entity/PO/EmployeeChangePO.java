package com.hrm.entity.PO;

import lombok.Data;

import java.util.Date;

/**
 * 员工正常变动类
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-06 20:29
 * @Version: 1.0
 */
@Data
public class EmployeeChangePO {
    private Integer record_id;
    private Integer employee_id;
    private Integer change_type;
    private Integer change_reason;
    private Integer old_dept;
    private Integer new_dept;
    private String old_post;
    private String new_post;
    private String old_post_level;
    private String new_post_level;
    private String old_work_address;
    private String new_work_address;
    private Integer old_parent_id;
    private Integer new_parent_id;
    private Integer probation;
    private Date effect_time;
    private Integer create_user_id;
    private Date create_time;
}
