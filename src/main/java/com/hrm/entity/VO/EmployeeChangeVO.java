package com.hrm.entity.VO;

import com.hrm.entity.PO.Employee;
import lombok.Data;

/**
 * 员工变动信息页展示数据
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-07 19:42
 * @Version: 1.0
 */
@Data
public class EmployeeChangeVO {

    private Integer employee_id;
    private String employee_name;
    private String post_name;
    private String post_level;
    private String work_address;
    private String dept_name;
    private String parent_name;

}
