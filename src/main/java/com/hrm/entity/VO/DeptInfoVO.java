package com.hrm.entity.VO;

import com.hrm.entity.PO.DeptInfoPO;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 展示部门信息VO
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 21:26
 * @Version: 1.0
 */
@Data
public class DeptInfoVO {

    public DeptInfoVO(DeptInfoPO deptInfoPO) {
        dept_id = deptInfoPO.getDept_id();
        dept_name = deptInfoPO.getName();

        if (deptInfoPO.getDept_type() == null) {
            dept_type = null;
        } else if (deptInfoPO.getDept_type() == 1) {
            dept_type = "公司";
        } else {
            dept_type = "部门";
        }

        code = deptInfoPO.getCode();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        create_time = simpleDateFormat.format(deptInfoPO.getCreate_time());

    }

    private Integer dept_id;
    private String dept_name;
    private String dept_type;
    private String parent_name;
    private String code;
    private String main_employee;
    private String leader_employee;
    private String create_time;

    private Integer employeeNum;

    private List<EmployeeVO> employeeVOS;

}
