package com.hrm.entity.PO;

import lombok.Data;

import java.util.Date;

/**
 * 候选人面试信息表
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 16:39
 * @Version: 1.0
 */
@Data
public class CandidateInterviewPO {

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
    private Date create_id;

}
