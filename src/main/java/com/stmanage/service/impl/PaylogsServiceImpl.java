package com.stmanage.service.impl;

import com.stmanage.api.BaseApiService;
import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Paylogs;
import com.stmanage.entity.Payment;
import com.stmanage.entity.Teams;
import com.stmanage.mapper.PaylogsMapper;
import com.stmanage.service.PaylogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaylogsServiceImpl extends BaseApiService implements PaylogsService {
    @Autowired
    private PaylogsMapper paylogsMapper;

    @Override
    public List<Paylogs> selectPayLogs(int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPayLogs(startIndex,pageSize);
    }

    @Override
    public int searchPayLogsCount() {
        return paylogsMapper.searchPayLogsCount();
    }

    @Override
    public List<Paylogs> selectPaylogsName(String teamsname, String name, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaylogsName(teamsname,name,startIndex,pageSize);
    }

    @Override
    public int selectPaylogsNameCount(String teamsname, String name) {
        return paylogsMapper.selectPaylogsNameCount(teamsname,name);
    }

    @Override
    public List<Paylogs> selectPayLogs1(int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPayLogs1(startIndex,pageSize);
    }

    @Override
    public int searchPayLogsCount1() {
        return paylogsMapper.searchPayLogsCount1();
    }

    @Override
    public List<Paylogs> selectPaylogsName1(String teamsname, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaylogsName1(teamsname,startIndex,pageSize);
    }

    @Override
    public int selectPaylogsNameCount1(String teamsname) {
        return paylogsMapper.selectPaylogsNameCount1(teamsname);
    }

    @Override
    public List<Paylogs> selectPayLogsp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPayLogsp(manager,startIndex,pageSize);
    }

    @Override
    public int searchPayLogspCount(int manager) {
        return paylogsMapper.searchPayLogspCount(manager);
    }

    @Override
    public List<Paylogs> selectPaylogspName(String teamsname, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaylogspName(teamsname,manager,startIndex,pageSize);
    }

    @Override
    public int selectPaylogspNameCount(String teamsname, int manager) {
        return paylogsMapper.selectPaylogspNameCount(teamsname,manager);
    }

    @Override
    public List<Paylogs> selectPayLogsp1(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPayLogsp1(manager,startIndex,pageSize);
    }

    @Override
    public int searchPayLogspCount1(int manager) {
        return paylogsMapper.searchPayLogspCount1(manager);
    }

    @Override
    public BaseResponse<String> addPayLogsp1(int teamid, int total, String details) {
        Teams teams = paylogsMapper.selectTeamsTotal(teamid);
        int totalsum = teams.getTotal();
        if(totalsum < total){
            return setResultError("社团余额不足！");
        }
        paylogsMapper.updateTeamsTotal(teamid,total);
        return setResult(200,"登记成功！",paylogsMapper.addPayLogsp1(teamid,total,details));
    }

    @Override
    public List<Paylogs> selectPaylogspName1(String teamsname, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaylogspName1(teamsname,manager,startIndex,pageSize);
    }

    @Override
    public int selectPaylogspNameCount1(String teamsname, int manager) {
        return paylogsMapper.selectPaylogspNameCount1(teamsname,manager);
    }

    @Override
    public int deletePayLogsp1(int payid) {
        Paylogs paylogs = paylogsMapper.selectTotalTeamid(payid);
        int total = paylogs.getTotal();
        int teamid = paylogs.getTeamid();
        paylogsMapper.updateAddTeamTotal(total,teamid);
        return paylogsMapper.deletePayLogsp1(payid);
    }

    @Override
    public List<Payment> selectPayment(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPayment(userid,startIndex,pageSize);
    }

    @Override
    public int searchPaymentCount(int userid) {
        return paylogsMapper.searchPaymentCount(userid);
    }

    @Override
    public List<Payment> selectPaymentName(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaymentName(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectPaymentNameCount(String teamsname, int userid) {
        return paylogsMapper.selectPaymentNameCount(teamsname,userid);
    }

    @Override
    public int insertPaylogs(String title,int total, String details, int tmid, int pmid) {
        paylogsMapper.insertPaylogs(title,total,details,tmid,pmid);
        return paylogsMapper.updateTeamTotal(total,pmid);
    }

    @Override
    public List<Paylogs> selectRecord1(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectRecord1(userid,startIndex,pageSize);
    }

    @Override
    public int searchRecordCount1(int userid) {
        return paylogsMapper.searchRecordCount1(userid);
    }

    @Override
    public List<Paylogs> selectRecordName1(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectRecordName1(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectRecordNameCount1(String teamsname, int userid) {
        return paylogsMapper.selectRecordNameCount1(teamsname,userid);
    }

    @Override
    public List<Payment> selectPaymentp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaymentp(manager,startIndex,pageSize);
    }

    @Override
    public int searchPaymentpCount(int manager) {
        return paylogsMapper.searchPaymentpCount(manager);
    }

    @Override
    public List<Payment> selectPaymentpName(String teamsname, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaymentpName(teamsname,manager,startIndex,pageSize);
    }

    @Override
    public int selectPaymentpNameCount(String teamsname, int manager) {
        return paylogsMapper.selectPaymentpNameCount(teamsname,manager);
    }

    @Override
    public BaseResponse<String> insertPaymentp(String title, int teamid, int total, String details) {
        int count = paylogsMapper.selectTitleCount(title,teamid);
        if(count != 0){
            return setResultError("标题重复，请重新发布！");
        }
        return setResult(200,"发布成功！",paylogsMapper.insertPaymentp(title,teamid,total,details));
    }

    @Override
    public BaseResponse<String> deletePaymentp(int pmid) {
        int count = paylogsMapper.selectSearch(pmid);
        if(count != 0){
            return setResultError("已经有社员缴费，不能撤回！");
        }
        return setResult(200,"撤回成功！",paylogsMapper.deletePaymentp(pmid));
    }

    @Override
    public List<Paylogs> selectPaid(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaid(manager,startIndex,pageSize);
    }

    @Override
    public int selectPaidCount(int manager) {
        return paylogsMapper.selectPaidCount(manager);
    }

    @Override
    public List<Paylogs> selectPaidName(String teamsname, String title,int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectPaidName(teamsname,title,manager,startIndex,pageSize);
    }

    @Override
    public int selectPaidNameCount(String teamsname, String title,int manager) {
        return paylogsMapper.selectPaidNameCount(teamsname,title,manager);
    }

    @Override
    public List<Paylogs> selectUnpaid(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectUnpaid(manager,startIndex,pageSize);
    }

    @Override
    public int selectUnpaidCount(int manager) {
        return paylogsMapper.selectUnpaidCount(manager);
    }

    @Override
    public List<Paylogs> selectUnpaidName(String teamsname, String title, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectUnpaidName(teamsname,title,manager,startIndex,pageSize);
    }

    @Override
    public int selectUnpaidNameCount(String teamsname, String title, int manager) {
        return paylogsMapper.selectUnpaidNameCount(teamsname,title,manager);
    }

    @Override
    public List<Paylogs> selectTeamExpend(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectTeamExpend(userid,startIndex,pageSize);
    }

    @Override
    public int selectTeamExpendCount(int userid) {
        return paylogsMapper.selectTeamExpendCount(userid);
    }

    @Override
    public List<Paylogs> selectTeamExpendName(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return paylogsMapper.selectTeamExpendName(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectTeamExpendNameCount(String teamsname, int userid) {
        return paylogsMapper.selectTeamExpendNameCount(teamsname,userid);
    }
}
