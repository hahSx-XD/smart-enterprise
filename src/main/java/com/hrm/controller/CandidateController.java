package com.hrm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.entity.BO.EliminateCandidateBO;
import com.hrm.entity.PO.CandidatePO;
import com.hrm.entity.PO.ChannelPO;
import com.hrm.entity.PO.InterviewPO;
import com.hrm.entity.VO.CandidateVO;
import com.hrm.service.CandidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 候选人控制类
 *
 * @Author: Cai 🥬
 * @Date: 2022-05-08 14:23
 * @Version: 1.0
 */
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/hrmCandidate")
@Api(tags = "候选人管理")
@Slf4j
public class  CandidateController {

    @Autowired
    private CandidateService candidateService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @ApiOperation(value = "查询各状态候选人数量，1 新候选人 2初选通过 3安排面试 4面试通过 5已发offer 6待入职 7已入职 8已淘汰", httpMethod = "GET")
    @RequestMapping("/queryCandidateNum")
    @ResponseBody
    public String queryCandidateNum() throws JsonProcessingException {
        Map<Integer, Integer> map = candidateService.queryCandidateNum();
        return objectMapper.writeValueAsString(map);
    }

    @ApiOperation(value = "根据状态查询候选信息列表", httpMethod = "GET")
    @ApiImplicitParam(dataType = "int", name = "status", value = "0 全部 1 新候选人 2初选通过 3安排面试 4面试通过 5已发offer 6待入职 7已入职 8已淘汰", required = true)
    @RequestMapping("/queryCandidateByStatus")
    @ResponseBody
    public String queryCandidateByStatus(int status) throws JsonProcessingException {
        List<CandidateVO> candidateVOS = candidateService.queryCandidateByStatus(status);
        return objectMapper.writeValueAsString(candidateVOS);
    }

    @ApiOperation(value = "新增候选人", httpMethod = "POST")
    @ApiImplicitParam(dataType = "json", value = "not null: candidate_name post_id")
    @ResponseBody
    @RequestMapping("/createCandidate")
    public String createCandidate(@RequestBody CandidatePO candidatePO) {
        int candidate = candidateService.createCandidate(candidatePO);
        if (candidate == 1) {
            return "新增候选人成功！";
        } else {
            return "新增候选人失败！";
        }
    }

    @ApiOperation(value = "修改候选人状态", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "candidate_id", value = "修改的候选人ID", dataType = "int", required = true),
            @ApiImplicitParam(name = "status", value = "要修改成为的状态, 1 新候选人 2初选通过 3安排面试 4面试通过 5已发offer 6待入职 7已入职", dataType = "int", required = true)
    })
    @ResponseBody
    @RequestMapping("/changeCandidateStatus")
    public String changeCandidateStatus(int candidate_id, int status) {
        int i = candidateService.changeCandidateStatus(candidate_id, status);
        if (i == 1) {
            return "修改候选人状态成功！";
        } else {
            return "修改候选人状态失败！";
        }
    }
    
    @ApiOperation(value = "淘汰候选人", httpMethod = "POST")
    @ResponseBody
    @RequestMapping("/eliminateCandidate")
    public String eliminateCandidate(@RequestBody EliminateCandidateBO eliminateCandidateBO) {
        candidateService.eliminateCandidate(eliminateCandidateBO);
        return "淘汰操作成功！";
    }

    @ApiOperation(value = "安排面试", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "not null: candidate", dataType = "json", required = true)
    })
    @ResponseBody
    @RequestMapping("/createInterview")
    public String createInterview(@RequestBody InterviewPO interviewPO) {
        int interview = candidateService.createInterview(interviewPO);
        if (interview == 1) {
            return "新增面试成功！";
        } else {
            return "新增面试失败";
        }
    }

    @RequestMapping("/queryAllChannel")
    @ApiOperation(value = "查询招聘渠道", httpMethod = "GET")
    @ResponseBody
    public String queryAllChannel() throws JsonProcessingException {
        List<ChannelPO> channelPOS = candidateService.queryAllChannel();
        return objectMapper.writeValueAsString(channelPOS);
    }

}
