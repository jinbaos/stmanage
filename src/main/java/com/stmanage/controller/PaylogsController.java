package com.stmanage.controller;

import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Paylogs;
import com.stmanage.entity.Payment;
import com.stmanage.service.impl.PaylogsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PaylogsController {

    @Autowired
    private PaylogsServiceImpl paylogsServiceImpl;

    @RequestMapping("/selectPayLogs")
    public List<Paylogs> selectPayLogs(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPayLogs(pageNo,pageSize);
    }
    @RequestMapping("/searchPayLogsCount")
    public int searchPayLogsCount(){
        return paylogsServiceImpl.searchPayLogsCount();
    }

    @RequestMapping("/selectPaylogsName")
    public List<Paylogs> selectPaylogsName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaylogsName(teamsname,name,pageNo,pageSize);
    }
    @RequestMapping("/selectPaylogsNameCount")
    public int selectPaylogsNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        return paylogsServiceImpl.selectPaylogsNameCount(teamsname,name);
    }
    @RequestMapping("/selectPayLogs1")
    public List<Paylogs> selectPayLogs1(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPayLogs1(pageNo,pageSize);
    }
    @RequestMapping("/searchPayLogsCount1")
    public int searchPayLogsCount1(){
        return paylogsServiceImpl.searchPayLogsCount1();
    }

    @RequestMapping("/selectPaylogsName1")
    public List<Paylogs> selectPaylogsName1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaylogsName1(teamsname,pageNo,pageSize);
    }
    @RequestMapping("/selectPaylogsNameCount1")
    public int selectPaylogsNameCount1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        return paylogsServiceImpl.selectPaylogsNameCount1(teamsname);
    }
    @RequestMapping("/selectPayLogsp")
    public List<Paylogs> selectPayLogsp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPayLogsp(manager,pageNo,pageSize);
    }
    @RequestMapping("/searchPayLogspCount")
    public int searchPayLogspCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.searchPayLogspCount(manager);
    }
    @RequestMapping("/selectPaylogspName")
    public List<Paylogs> selectPaylogspName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaylogspName(teamsname,manager,pageNo,pageSize);
    }
    @RequestMapping("/selectPaylogspNameCount")
    public int selectPaylogspNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectPaylogspNameCount(teamsname,manager);
    }

    @RequestMapping("/selectPayLogsp1")
    public List<Paylogs> selectPayLogsp1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPayLogsp1(manager,pageNo,pageSize);
    }

    @RequestMapping("/searchPayLogspCount1")
    public int searchPayLogspCount1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.searchPayLogspCount1(manager);
    }
    @RequestMapping("/addPayLogsp1")
    public BaseResponse<String> addPayLogsp1(@RequestBody Map<String,Object> map){
        int teamid = Integer.parseInt(map.get("teamid").toString());
        int total = Integer.parseInt(map.get("total").toString());
        String details  = map.get("details").toString();
        return paylogsServiceImpl.addPayLogsp1(teamid,total,details);
    }
    @RequestMapping("/selectPaylogspName1")
    public List<Paylogs> selectPaylogspName1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaylogspName1(teamsname,manager,pageNo,pageSize);
    }
    @RequestMapping("/selectPaylogspNameCount1")
    public int selectPaylogspNameCount1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectPaylogspNameCount1(teamsname,manager);
    }
    @RequestMapping("/deletePayLogsp1")
    public int deletePayLogsp1(@RequestBody Map<String,Object> map){
        int payid = Integer.parseInt(map.get("payid").toString());
        return paylogsServiceImpl.deletePayLogsp1(payid);
    }

    @RequestMapping("/selectPayment")
    public List<Payment> selectPayment(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPayment(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchPaymentCount")
    public int searchPaymentCount(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return paylogsServiceImpl.searchPaymentCount(userid);
    }
    @RequestMapping("/selectPaymentName")
    public List<Payment> selectPaymentName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaymentName(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectPaymentNameCount")
    public int selectPaymentNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return paylogsServiceImpl.selectPaymentNameCount(teamsname,userid);
    }
    @RequestMapping("/insertPaylogs")
    public int insertPaylogs(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        int total = Integer.parseInt(map.get("total").toString());
        String details = map.get("details").toString();
        int tmid = Integer.parseInt(map.get("tmid").toString());
        int pmid = Integer.parseInt(map.get("pmid").toString());
        return paylogsServiceImpl.insertPaylogs(title,total,details,tmid,pmid);
    }
    @RequestMapping("/selectRecord1")
    public List<Paylogs> selectRecord1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectRecord1(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchRecordCount1")
    public int searchRecordCount1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return paylogsServiceImpl.searchRecordCount1(userid);
    }
    @RequestMapping("/selectRecordName1")
    public List<Paylogs> selectRecordName1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectRecordName1(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectRecordNameCount1")
    public int selectRecordNameCount1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return paylogsServiceImpl.selectRecordNameCount1(teamsname,userid);
    }
    @RequestMapping("/selectPaymentp")
    public List<Payment> selectPaymentp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaymentp(manager,pageNo,pageSize);
    }
    @RequestMapping("/searchPaymentpCount")
    public int searchPaymentpCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.searchPaymentpCount(manager);
    }
    @RequestMapping("/selectPaymentpName")
    public List<Payment> selectPaymentpName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaymentpName(teamsname,manager,pageNo,pageSize);
    }
    @RequestMapping("/selectPaymentpNameCount")
    public int selectPaymentpNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectPaymentpNameCount(teamsname,manager);
    }
    @RequestMapping("/insertPaymentp")
    public BaseResponse<String> insertPaymentp(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        int teamid = Integer.parseInt(map.get("teamid").toString());
        int total = Integer.parseInt(map.get("total").toString());
        String details = map.get("details").toString();
        return paylogsServiceImpl.insertPaymentp(title,teamid,total,details);
    }
    @RequestMapping("/deletePaymentp")
    public BaseResponse<String> deletePaymentp(@RequestBody Map<String,Object> map){
        int pmid = Integer.parseInt(map.get("pmid").toString());
        return paylogsServiceImpl.deletePaymentp(pmid);
    }
    @RequestMapping("/selectPaid")
    public List<Paylogs> selectPaid(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaid(manager,pageNo,pageSize);
    }
    @RequestMapping("/selectPaidCount")
    public int selectPaidCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectPaidCount(manager);
    }
    @RequestMapping("/selectPaidName")
    public List<Paylogs> selectPaidName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String title = map.get("title").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectPaidName(teamsname,title,manager,pageNo,pageSize);
    }
    @RequestMapping("/selectPaidNameCount")
    public int selectPaidNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String title = map.get("title").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectPaidNameCount(teamsname,title,manager);
    }
    @RequestMapping("/selectUnpaid")
    public List<Paylogs> selectUnpaid(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectUnpaid(manager,pageNo,pageSize);
    }
    @RequestMapping("/selectUnpaidCount")
    public int selectUnpaidCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectUnpaidCount(manager);
    }
    @RequestMapping("/selectUnpaidName")
    public List<Paylogs> selectUnpaidName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String title = map.get("title").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectUnpaidName(teamsname,title,manager,pageNo,pageSize);
    }
    @RequestMapping("/selectUnpaidNameCount")
    public int selectUnpaidNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String title = map.get("title").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return paylogsServiceImpl.selectUnpaidNameCount(teamsname,title,manager);
    }

    @RequestMapping("/selectTeamExpend")
    public List<Paylogs> selectTeamExpend(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectTeamExpend(userid,pageNo,pageSize);
    }
    @RequestMapping("/selectTeamExpendCount")
    public int selectTeamExpendCount(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return paylogsServiceImpl.selectTeamExpendCount(userid);
    }
    @RequestMapping("/selectTeamExpendName")
    public List<Paylogs> selectTeamExpendName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return paylogsServiceImpl.selectTeamExpendName(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectTeamExpendNameCount")
    public int selectTeamExpendNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return paylogsServiceImpl.selectTeamExpendNameCount(teamsname,userid);
    }
}
//BaseResponse<String>