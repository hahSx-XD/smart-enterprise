package com.hrm.service.impl;

import com.hrm.entity.BO.CandidateBO;
import com.hrm.entity.BO.EliminateCandidateBO;
import com.hrm.entity.PO.CandidateInterviewPO;
import com.hrm.entity.PO.CandidatePO;
import com.hrm.entity.PO.ChannelPO;
import com.hrm.entity.PO.InterviewPO;
import com.hrm.entity.VO.CandidateVO;
import com.hrm.mapper.CandidateMapper;
import com.hrm.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: Cai 🥬
 * @Date: 2022-05-08 14:17
 * @Version: 1.0
 */
@Service("candidateService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public Map<Integer, Integer> queryCandidateNum() {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 1; i < 9; i++) {
            List<Integer> list = candidateMapper.queryCandidateNum(i);
            if (list == null) {
                map.put(i, 0);
            } else {
                map.put(i, list.size());
                sum += list.size();
            }
        }
        map.put(9, sum);
        return map;
    }

    @Override
    public List<CandidateVO> queryCandidateByStatus(int status) {
        List<CandidateVO> results = new ArrayList<>();

        if (status != 0) {
            List<CandidateBO> candidateBOS = candidateMapper.queryCandidateByStatus(status);
            for (CandidateBO candidateBO : candidateBOS) {
                CandidateInterviewPO candidateInterviewPO = candidateMapper.queryInterviewByCandidateId(candidateBO.getCandidate_id());
                results.add(new CandidateVO(candidateBO, candidateInterviewPO));
            }
        } else {
            for (int i = 1; i < 9; ++i) {
                List<CandidateBO> candidateBOS = candidateMapper.queryCandidateByStatus(i);
                for (CandidateBO candidateBO : candidateBOS) {
                    CandidateInterviewPO candidateInterviewPO = candidateMapper.queryInterviewByCandidateId(candidateBO.getCandidate_id());
                    results.add(new CandidateVO(candidateBO, candidateInterviewPO));
                }
            }
        }

        return results;
    }

    @Override
    public int createCandidate(CandidatePO candidatePO) {
        candidatePO.setCreate_time(new Date());
        candidatePO.setStatus(1);
        candidateMapper.createCandidate(candidatePO);
        return 1;
    }

    @Override
    public int changeCandidateStatus(int candidate_id, int status) {

        candidateMapper.changeCandidateStatus(candidate_id, status);
        if (status == 4 || status == 5 || status == 6 || status == 7) {
            candidateMapper.passInterview(candidate_id);
        } else if (status == 8) {
            candidateMapper.notpassInterview(candidate_id);
        }

        return 1;
    }
    
    @Override
    public void eliminateCandidate(EliminateCandidateBO eliminateCandidateBO) {
        changeCandidateStatus(eliminateCandidateBO.getCandidate_id(), 8);
        candidateMapper.eliminateCandidate(eliminateCandidateBO);
    }
    
    @Override
    public int createInterview(InterviewPO interviewPO) {
            interviewPO.setResult(1);
            candidateMapper.createInterview(interviewPO);
        return 1;
    }

    @Override
    public List<ChannelPO> queryAllChannel() {
        return candidateMapper.queryAllChannel();
    }
}
