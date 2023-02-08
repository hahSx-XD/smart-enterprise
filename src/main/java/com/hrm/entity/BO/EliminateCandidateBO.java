package com.hrm.entity.BO;

import lombok.Data;

/**
 * 淘汰候选人BO
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-11 15:01
 * @Version: 1.0
 */
@Data
public class EliminateCandidateBO {
    private Integer candidate_id;
    private String reason;
    private String remark;
}
