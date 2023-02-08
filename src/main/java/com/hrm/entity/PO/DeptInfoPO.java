package com.hrm.entity.PO;

import lombok.Data;

import java.util.Date;

/**
 * 所有部门信息展示
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 19:40
 * @Version: 1.0
 */
@Data
public class DeptInfoPO {

    private Integer dept_id;
    private Integer pid;
    private Integer dept_type;
    private String name;
    private String code;
    private Integer main_employee_id;
    private Integer leader_employee_id;
    private Date create_time;
    private Integer create_user_id;
    private Integer node_id;

}
