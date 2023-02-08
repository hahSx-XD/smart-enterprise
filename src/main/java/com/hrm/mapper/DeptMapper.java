package com.hrm.mapper;

import com.hrm.entity.PO.DeptInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门mapper层
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 19:39
 * @Version: 1.0
 */
@Mapper
public interface DeptMapper {

    @Select("select * from wk_hrm_dept")
    List<DeptInfoPO> queryAllDept();

    @Select("select * from wk_hrm_dept where dept_id = #{dept_id}")
    DeptInfoPO queryDeptInfoById(int dept_id);

}
