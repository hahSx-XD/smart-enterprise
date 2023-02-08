package com.hrm.entity.BO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 候选人信息列表展示信息
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 15:32
 * @Version: 1.0
 */
@Data
public class CandidateBO {

    @ApiModelProperty(value = "候选人id")
    private Integer candidate_id;

    @ApiModelProperty(value = "候选人名称")
    private String candidate_name;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "性别 1男 2女")
    private Integer sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "学历 1小学 2初中 3高中 4大专 5本科 6硕士 7博士")
    private Integer education;

    @ApiModelProperty(value = "毕业院校")
    private String graduate_school;

    @ApiModelProperty(value = "工作年限")
    private Integer work_time;

    @ApiModelProperty(value = "招聘渠道")
    private String channel_name;

    @ApiModelProperty(value = "职位")
    private String post_name;

    @ApiModelProperty(value = "候选人状态 1新候选人 2初选通过 3安排面试 4面试通过 5已发offer 6待入职 7已淘汰 8已入职")
    private Integer status;

    @ApiModelProperty(value = "批次id")
    private String batch_id;

    @ApiModelProperty(value = "状态更新时间")
    private Date status_update_time;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

}
