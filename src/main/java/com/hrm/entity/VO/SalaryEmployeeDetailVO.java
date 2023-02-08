package com.hrm.entity.VO;

import com.hrm.entity.BO.SalaryEmployeeDetailBO;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * @Author: Cai 🥬
 * @Date: 2022-05-11 08:36
 * @Version: 1.0
 */
@Data
public class SalaryEmployeeDetailVO {

    public SalaryEmployeeDetailVO(SalaryEmployeeDetailBO salaryEmployeeDetailBO) {
        employee_id = salaryEmployeeDetailBO.getEmployee_id();
        employee_name = salaryEmployeeDetailBO.getEmployee_name();
        actual_work_day = salaryEmployeeDetailBO.getActual_work_day();
        need_work_day = salaryEmployeeDetailBO.getNeed_work_day();
        year = salaryEmployeeDetailBO.getYear();
        month = salaryEmployeeDetailBO.getMonth();

        if (salaryEmployeeDetailBO.getCreate_time() == null) {
            create_time = null;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            create_time = simpleDateFormat.format(salaryEmployeeDetailBO.getCreate_time());
        }
        
        o1 = salaryEmployeeDetailBO.getSalaryItemBOS().get(0).getMoney();
        o2 = salaryEmployeeDetailBO.getSalaryItemBOS().get(1).getMoney();
        o3 = salaryEmployeeDetailBO.getSalaryItemBOS().get(2).getMoney();
        o4 = salaryEmployeeDetailBO.getSalaryItemBOS().get(3).getMoney();
        o5 = salaryEmployeeDetailBO.getSalaryItemBOS().get(4).getMoney();
        o6 = salaryEmployeeDetailBO.getSalaryItemBOS().get(5).getMoney();
        o7 = salaryEmployeeDetailBO.getSalaryItemBOS().get(6).getMoney();
        o8 = salaryEmployeeDetailBO.getSalaryItemBOS().get(7).getMoney();
        o9 = salaryEmployeeDetailBO.getSalaryItemBOS().get(8).getMoney();
        o10 = salaryEmployeeDetailBO.getSalaryItemBOS().get(9).getMoney();
        o11 = salaryEmployeeDetailBO.getSalaryItemBOS().get(10).getMoney();
        o12 = salaryEmployeeDetailBO.getSalaryItemBOS().get(11).getMoney();
        o13 = salaryEmployeeDetailBO.getSalaryItemBOS().get(12).getMoney();
        o14 = salaryEmployeeDetailBO.getSalaryItemBOS().get(13).getMoney();
        o15 = salaryEmployeeDetailBO.getSalaryItemBOS().get(14).getMoney();
        o16 = salaryEmployeeDetailBO.getSalaryItemBOS().get(15).getMoney();
        o17 = salaryEmployeeDetailBO.getSalaryItemBOS().get(16).getMoney();
        o18 = salaryEmployeeDetailBO.getSalaryItemBOS().get(17).getMoney();
        o19 = salaryEmployeeDetailBO.getSalaryItemBOS().get(18).getMoney();
        o20 = salaryEmployeeDetailBO.getSalaryItemBOS().get(19).getMoney();
        o21 = salaryEmployeeDetailBO.getSalaryItemBOS().get(20).getMoney();
        o22 = salaryEmployeeDetailBO.getSalaryItemBOS().get(21).getMoney();
        o23 = salaryEmployeeDetailBO.getSalaryItemBOS().get(22).getMoney();
        o24 = salaryEmployeeDetailBO.getSalaryItemBOS().get(23).getMoney();
        o25 = salaryEmployeeDetailBO.getSalaryItemBOS().get(24).getMoney();
        o26 = salaryEmployeeDetailBO.getSalaryItemBOS().get(25).getMoney();
        o27 = salaryEmployeeDetailBO.getSalaryItemBOS().get(26).getMoney();
        o28 = salaryEmployeeDetailBO.getSalaryItemBOS().get(27).getMoney();
        o29 = salaryEmployeeDetailBO.getSalaryItemBOS().get(28).getMoney();
        o30 = salaryEmployeeDetailBO.getSalaryItemBOS().get(29).getMoney();
        o31 = salaryEmployeeDetailBO.getSalaryItemBOS().get(30).getMoney();
        o32 = salaryEmployeeDetailBO.getSalaryItemBOS().get(31).getMoney();
        o33 = salaryEmployeeDetailBO.getSalaryItemBOS().get(32).getMoney();
        o34 = salaryEmployeeDetailBO.getSalaryItemBOS().get(33).getMoney();
        o35 = salaryEmployeeDetailBO.getSalaryItemBOS().get(34).getMoney();
        o36 = salaryEmployeeDetailBO.getSalaryItemBOS().get(35).getMoney();
        o37 = salaryEmployeeDetailBO.getSalaryItemBOS().get(36).getMoney();
        o38 = salaryEmployeeDetailBO.getSalaryItemBOS().get(37).getMoney();
        o39 = salaryEmployeeDetailBO.getSalaryItemBOS().get(38).getMoney();
        o40 = salaryEmployeeDetailBO.getSalaryItemBOS().get(39).getMoney();
        o41 = salaryEmployeeDetailBO.getSalaryItemBOS().get(40).getMoney();
        o42 = salaryEmployeeDetailBO.getSalaryItemBOS().get(41).getMoney();

    }

    private Integer employee_id;
    private String employee_name;
    private String job_number;
    private String dept_name;
    private String post_name;
    private Integer actual_work_day;
    private BigDecimal need_work_day;
    private Integer year;
    private Integer month;
    private String create_time;
    private BigDecimal o1;
    private BigDecimal o2;
    private BigDecimal o3;
    private BigDecimal o4;
    private BigDecimal o5;
    private BigDecimal o6;
    private BigDecimal o7;
    private BigDecimal o8;
    private BigDecimal o9;
    private BigDecimal o10;
    private BigDecimal o11;
    private BigDecimal o12;
    private BigDecimal o13;
    private BigDecimal o14;
    private BigDecimal o15;
    private BigDecimal o16;
    private BigDecimal o17;
    private BigDecimal o18;
    private BigDecimal o19;
    private BigDecimal o20;
    private BigDecimal o21;
    private BigDecimal o22;
    private BigDecimal o23;
    private BigDecimal o24;
    private BigDecimal o25;
    private BigDecimal o26;
    private BigDecimal o27;
    private BigDecimal o28;
    private BigDecimal o29;
    private BigDecimal o30;
    private BigDecimal o31;
    private BigDecimal o32;
    private BigDecimal o33;
    private BigDecimal o34;
    private BigDecimal o35;
    private BigDecimal o36;
    private BigDecimal o37;
    private BigDecimal o38;
    private BigDecimal o39;
    private BigDecimal o40;
    private BigDecimal o41;
    private BigDecimal o42;
    
}
