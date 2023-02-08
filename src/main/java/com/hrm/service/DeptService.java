package com.hrm.service;

import com.hrm.entity.PO.DeptInfoPO;
import com.hrm.entity.VO.DeptInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 部门业务逻辑接口
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 19:32
 * @Version: 1.0
 */
public interface DeptService {

    List<DeptInfoPO> queryAllDept();

    DeptInfoVO queryDeptInfoById(Integer dept_id);


}
