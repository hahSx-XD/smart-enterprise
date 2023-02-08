package com.hrm.entity.VO;

import com.hrm.entity.PO.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.SimpleDateFormat;

/**
 * 前端员工信息展示展示
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-07 12:29
 * @Version: 1.0
 */
@Data
public class EmployeeVO {

    public EmployeeVO(Employee employee, String dept_name) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        employee_id = employee.getEmployee_id();
        employee_name = employee.getEmployee_name();
        mobile = employee.getMobile();
        if (employee.getId_type() == null) {
            id_type = null;
        } else {
            switch (employee.getId_type()) {
                case 1:
                    id_type = "居民身份证";
                    break;
                case 2:
                    id_type = "港澳通行证";
                    break;
                case 3:
                    id_type = "台湾通行证";
                    break;
                case 4:
                    id_type = "护照";
                    break;
                case 5:
                    id_type = "其他";
                    break;
                default:
                    id_type = null;
            }
        }
        id_number = employee.getId_number();
        if (employee.getSex() == null) {
            sex = null;
        } else {
            switch (employee.getSex()) {
                case 1:
                    sex = "男";
                    break;
                case 2:
                    sex = "女";
                    break;
                default:
                    sex = null;
            }
        }
        if (employee.getDate_of_birth() == null) {
            date_of_birth = null;
        } else {
            date_of_birth = simpleDateFormat.format(employee.getDate_of_birth());
        }
        age = employee.getAge();
        country = employee.getCountry();
        nation = employee.getNation();
        native_place = employee.getNative_place();
        if (employee.getHighest_education() == null) {
            highest_education = null;
        } else {
            switch (employee.getHighest_education()) {
                case 1:
                    highest_education = "本科";
                    break;
                case 2:
                    highest_education = "硕士";
                    break;
                case 3:
                    highest_education = "博士";
                    break;
                default:
                    highest_education = null;
            }
        }
        if (employee.getEntry_time() == null) {
            entry_time = null;
        } else {
            entry_time = simpleDateFormat.format(employee.getEntry_time());
        }
        job_number = employee.getJob_number();
        this.dept_name = dept_name;
        //1正式 2试用  3实习 4兼职 5劳务 6顾问 7返聘 8外包
        if (employee.getStatus() == null) {
            status = null;
        } else {
            switch (employee.getStatus()) {
                case 1:
                    status = "正式";
                    break;
                case 2:
                    status = "试用";
                    break;
                case 3:
                    status = "实习";
                    break;
                case 4:
                    status = "兼职";
                    break;
                case 5:
                    status = "劳务";
                    break;
                case 6:
                    status = "顾问";
                    break;
                case 7:
                    status = "返聘";
                    break;
                case 8:
                    status = "外包";
                    break;
                default:
                    status = null;
            }
        }
    }

    @ApiModelProperty(value = "员工id")
    private Integer employee_id;

    @ApiModelProperty(value = "员工姓名")
    private String employee_name;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "证件类型 1 身份证 2 港澳通行证 3 台湾通行证 4 护照 5 其他")
    private String id_type;

    @ApiModelProperty(value = "证件号码")
    private String id_number;

    @ApiModelProperty(value = "性别 1 男 2 女")
    private String sex;

    @ApiModelProperty(value = "出生日期")
    private String date_of_birth;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "国家地区")
    private String country;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "籍贯")
    private String native_place;

    @ApiModelProperty(value = "最高学历 1 本科 2 硕士 3 博士")
    private String highest_education;

    @ApiModelProperty(value = "入职时间")
    private String entry_time;

    @ApiModelProperty(value = "工号")
    private String job_number;

    @ApiModelProperty(value = "部门")
    private String dept_name;

    @ApiModelProperty(value = "员工状态 1正式 2试用  3实习 4兼职 5劳务 6顾问 7返聘 8外包")
    private String status;

}
