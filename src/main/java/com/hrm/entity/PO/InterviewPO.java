package com.hrm.entity.PO;

import lombok.Data;

import java.util.Date;

/**
 * 面试表信息
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-09 16:30
 * @Version: 1.0
 */
@Data
public class InterviewPO {

    private Integer interview_id;
    private Integer candidate_id;
    private String type;
    private Integer stage_num;
    private Integer interview_employee_id;
    private String other_interview_employee_ids;
    private Date interview_time;
    private String address;
    private String remark;
    private Integer result;
    private String evaluate;
    private String cancel_reason;
    private Integer create_user_id;
    private Date create_time;
    private Date update_time;

}
