package com.hrm.mapper;

import com.hrm.entity.BO.CandidateBO;
import com.hrm.entity.BO.EliminateCandidateBO;
import com.hrm.entity.PO.CandidateInterviewPO;
import com.hrm.entity.PO.CandidatePO;
import com.hrm.entity.PO.ChannelPO;
import com.hrm.entity.PO.InterviewPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 候选人mapper层
 *
 * Author: Cai 🥬
 * Date: 2022-05-08 14:20
 * Version: 1.0
 */
@Mapper
public interface CandidateMapper {

    /**
     * 根据面试状态status查询 List<ID>
     *
     * @param status 员工状态
     * @return List<Integer> ID列表
     * Author: Cai
     * Date: 2022/5/5 10:04
     */
    @Select("select candidate_id from wk_hrm_recruit_candidate where status = #{status}")
    List<Integer> queryCandidateNum(int status);

    @Select("select c.candidate_id, c.candidate_name, c.mobile, c.sex, c.age, c.email, c.education, c.graduate_school, c.work_time, ch.value channel_name, d.name post_name, c.status, c.batch_id, c.status_update_time, c.create_time " +
            "from wk_hrm_recruit_candidate c, wk_hrm_recruit_channel ch, wk_hrm_dept d " +
            "where c.channel_id = ch.channel_id and c.post_id = d.dept_id and c.status = #{status}")
    List<CandidateBO> queryCandidateByStatus(int status);
    
    
    @Select("select * from wk_hrm_recruit_interview where candidate_id = #{candidate_id}")
    CandidateInterviewPO queryInterviewByCandidateId(int candidate_id);

    @Insert("insert into wk_hrm_recruit_candidate values(#{candidate_id}, #{candidate_name}, #{mobile}, #{sex}, #{age}, #{email}, #{post_id}, #{stage_num}, #{work_time}, #{education}, #{graduate_school}, #{latest_work_place}, #{channel_id}, #{remark}, #{status}, #{eliminate}, #{create_time}, #{create_user_id}, #{status_update_time}, #{entry_time}, #{batch_id})")
    void createCandidate(CandidatePO candidatePO);

    @Update("update wk_hrm_recruit_candidate set status = #{status}, status_update_time = now() where candidate_id = #{candidate_id}")
    void changeCandidateStatus(@Param("candidate_id") int candidate_id, @Param("status") int status);
    
    @Update("update wk_hrm_recruit_candidate set eliminate = #{reason}, remark = #{remark} where candidate_id = #{candidate_id}")
    void eliminateCandidate(EliminateCandidateBO eliminateCandidateBO);
    
    @Insert("insert into wk_hrm_recruit_interview values(#{interview_id}, #{candidate_id}, #{type}, #{stage_num}, #{interview_employee_id}, #{other_interview_employee_ids}, #{interview_time}, #{address}, #{remark}, #{result}, #{evaluate}, #{cancel_reason}, #{create_user_id}, now(), #{update_time})")
    void createInterview(InterviewPO interviewPO);

    @Update("update wk_hrm_recruit_interview set result = '2', update_time = now() where candidate_id = #{candidate_id} and result is not null")
    void passInterview(int candidate_id);

    @Update("update wk_hrm_recruit_interview set result = '3', update_time = now() where candidate_id = #{candidate_id} and result is not null")
    void notpassInterview(int candidate_id);

    @Select("select * from wk_hrm_recruit_channel where status = '1'")
    List<ChannelPO> queryAllChannel();

}
