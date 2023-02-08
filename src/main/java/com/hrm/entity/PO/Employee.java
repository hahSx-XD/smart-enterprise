package com.hrm.entity.PO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * employee table
 * @Author:Cai 🥬
 * @Date: 2022-05-04 21:33
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Employee PO", description = "wk_hrm_employee Table")
public class Employee {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "员工id")
    private Integer employee_id;

    @ApiModelProperty(value = "员工姓名")
    private String employee_name;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "国家地区")
    private String country;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "证件类型 1 身份证 2 港澳通行证 3 台湾通行证 4 护照 5 其他")
    private Integer id_type;

    @ApiModelProperty(value = "证件号码")
    private String id_number;

    @ApiModelProperty(value = "性别 1 男 2 女")
    private Integer sex;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "籍贯")
    private String native_place;

    @ApiModelProperty(value = "出生日期")
    private Date date_of_birth;

    @ApiModelProperty(value = "生日类型 1 阳历 2 农历")
    private Integer birthday_type;

    @ApiModelProperty(value = "生日 示例：0323")
    private String birthday;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "户籍地址")
    private String address;

    @ApiModelProperty(value = "最高学历 1 本科 2 硕士 3 博士")
    private Integer highest_education;

    @ApiModelProperty(value = "入职时间")
    private Date entry_time;

    @ApiModelProperty(value = "试用期 0 无试用期")
    private Integer probation;

    @ApiModelProperty(value = "转正日期")
    private Date become_time;

    @ApiModelProperty(value = "工号")
    private String job_number;

    @ApiModelProperty(value = "部门ID")
    private Integer dept_id;

    @ApiModelProperty(value = "直属上级ID")
    private Integer parent_id;

    @ApiModelProperty(value = "职位")
    private String post;

    @ApiModelProperty(value = "岗位职级")
    private String post_level;

    @ApiModelProperty(value = "工作地点")
    private String work_address;

    @ApiModelProperty(value = "工作详细地址")
    private String work_detail_address;

    @ApiModelProperty(value = "工作城市")
    private String work_city;

    @ApiModelProperty("招聘渠道")
    private Integer channel_id;

    @ApiModelProperty(value = "聘用形式 1 正式 2 非正式")
    private Integer employment_forms;

    @ApiModelProperty(value = "员工状态 1正式 2试用  3实习 4兼职 5劳务 6顾问 7返聘 8外包")
    private Integer status;

    @ApiModelProperty(value = "司龄开始日期")
    private Date company_age_start_time;

    @ApiModelProperty(value = "司龄")
    private Integer company_age;

    @ApiModelProperty(value = "候选人id")
    private Integer candidate_id;

    @ApiModelProperty("入职状态 1 在职 2 待入职 3 待离职 4 离职")
    private Integer entry_status;

    @ApiModelProperty(value = "0 未删除 1 删除")
    private Integer is_del;

    @ApiModelProperty(value = "创建人id")
    private Long create_user_id;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty(value = "更新时间")
    private Date update_time;

}
