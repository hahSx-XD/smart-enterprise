package com.hrm.service;

import com.hrm.entity.BO.EliminateCandidateBO;
import com.hrm.entity.PO.CandidatePO;
import com.hrm.entity.PO.ChannelPO;
import com.hrm.entity.PO.InterviewPO;
import com.hrm.entity.VO.CandidateVO;

import java.util.List;
import java.util.Map;

/**
 * 候选人业务逻辑层
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 14:16
 * @Version: 1.0
 */
public interface CandidateService {

    Map<Integer, Integer> queryCandidateNum();

    List<CandidateVO> queryCandidateByStatus(int status);

    int createCandidate(CandidatePO candidatePO);

    int changeCandidateStatus(int candidate_id, int change_status);
    
    void eliminateCandidate(EliminateCandidateBO eliminateCandidateBO);

    int createInterview(InterviewPO interviewPO);

    List<ChannelPO> queryAllChannel();

}
