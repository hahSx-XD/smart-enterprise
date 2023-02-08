package com.hrm.entity.VO;

import com.hrm.entity.BO.CandidateBO;
import com.hrm.entity.PO.CandidateInterviewPO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 候选人信息列表展示信息
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 15:32
 * @Version: 1.0
 */
@Data
public class CandidateVO {

    public CandidateVO(CandidateBO candidateBO, CandidateInterviewPO candidateInterviewPO) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        candidate_id = candidateBO.getCandidate_id();
        candidate_name = candidateBO.getCandidate_name();
        mobile = candidateBO.getMobile();

        if (candidateBO.getSex() == 1) {
            sex = "男";
        } else if (candidateBO.getSex() == 2) {
            sex = "女";
        } else {
            sex = null;
        }

        age = candidateBO.getAge();
        email = candidateBO.getEmail();

        if (candidateBO.getEducation() == 1) {
            education = "本科";
        } else if (candidateBO.getEducation() == 2) {
            education = "硕士";
        } else if (candidateBO.getEducation() == 3) {
            education = "博士";
        } else {
            education = null;
        }

        graduate_school = candidateBO.getGraduate_school();
        work_time = candidateBO.getWork_time();
        channel_name = candidateBO.getChannel_name();
        post_name = candidateBO.getPost_name();
        status_id = candidateBO.getStatus();

        if (candidateBO.getStatus() == null) {
            status = null;
        } else {
            switch (candidateBO.getStatus()) {
                case 1:
                    status = "新候选人";
                    break;
                case 2:
                    status = "初选通过";
                    break;
                case 3:
                    status = "安排面试";
                    break;
                case 4:
                    status = "面试通过";
                    break;
                case 5:
                    status = "已发offer";
                    break;
                case 6:
                    status = "待入职";
                    break;
                case 7:
                    status = "已入职";
                    break;
                case 8:
                    status = "已淘汰";
                    break;
                default:
                    status = null;
            }
        }

        if (candidateInterviewPO == null) {
            interview_time = null;
            interview_type = null;
        } else {
            if (candidateInterviewPO.getInterview_time() == null) {
                interview_time = null;
            } else {
                interview_time = simpleDateFormat.format(candidateInterviewPO.getInterview_time());
            }
            interview_type = candidateInterviewPO.getType();
        }

        batch_id = candidateBO.getBatch_id();
        if (candidateBO.getStatus_update_time() == null) {
            status_update_time = null;
        } else {
            status_update_time = simpleDateFormat.format(candidateBO.getStatus_update_time());
        }
        if (candidateBO.getCreate_time() == null) {
            create_time = null;
        } else {
            create_time = simpleDateFormat.format(candidateBO.getCreate_time());
        }
    }

    @ApiModelProperty(value = "候选人id")
    private Integer candidate_id;

    @ApiModelProperty(value = "候选人名称")
    private String candidate_name;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "性别 1男 2女")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "学历 1本科 2硕士 3博士")
    private String education;

    @ApiModelProperty(value = "毕业院校")
    private String graduate_school;

    @ApiModelProperty(value = "工作年限")
    private Integer work_time;

    @ApiModelProperty(value = "招聘渠道")
    private String channel_name;

    @ApiModelProperty(value = "职位")
    private String post_name;

    @ApiModelProperty(value = "候选人状态 1新候选人 2初选通过 3安排面试 4面试通过 5已发offer 6待入职 7已淘汰 8已入职")
    private Integer status_id;

    @ApiModelProperty(value = "候选人状态 1新候选人 2初选通过 3安排面试 4面试通过 5已发offer 6待入职 7已淘汰 8已入职")
    private String status;

    @ApiModelProperty(value = "面试时间")
    private String interview_time;

    @ApiModelProperty(value = "面试方式")
    private String interview_type;

    @ApiModelProperty(value = "批次id")
    private String batch_id;

    @ApiModelProperty(value = "状态更新时间")
    private String status_update_time;

    @ApiModelProperty(value = "创建时间")
    private String create_time;

}
