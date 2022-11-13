package com.stmanage.service;

import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Paylogs;
import com.stmanage.entity.Payment;

import java.util.List;

public interface PaylogsService {
    List<Paylogs> selectPayLogs(int pageNo, int pageSize);

    int searchPayLogsCount();

    List<Paylogs> selectPaylogsName(String teamsname, String name, int pageNo, int pageSize);

    int selectPaylogsNameCount(String teamsname, String name);

    List<Paylogs> selectPayLogs1(int pageNo, int pageSize);

    int searchPayLogsCount1();

    List<Paylogs> selectPaylogsName1(String teamsname, int pageNo, int pageSize);

    int selectPaylogsNameCount1(String teamsname);

    List<Paylogs> selectPayLogsp(int manager, int pageNo, int pageSize);

    int searchPayLogspCount(int manager);

    List<Paylogs> selectPaylogspName(String teamsname,int manager, int pageNo, int pageSize);

    int selectPaylogspNameCount(String teamsname, int manager);

    List<Paylogs> selectPayLogsp1(int manager, int pageNo, int pageSize);

    int searchPayLogspCount1(int manager);

    BaseResponse<String> addPayLogsp1(int teamid, int total, String details);

    List<Paylogs> selectPaylogspName1(String teamsname, int manager, int pageNo, int pageSize);

    int selectPaylogspNameCount1(String teamsname, int manager);

    int deletePayLogsp1(int payid);

    List<Payment> selectPayment(int userid, int pageNo, int pageSize);

    int searchPaymentCount(int userid);

    List<Payment> selectPaymentName(String teamsname, int userid, int pageNo, int pageSize);

    int selectPaymentNameCount(String teamsname, int userid);

    int insertPaylogs(String title,int total, String details, int tmid, int pmid);

    List<Paylogs> selectRecord1(int userid, int pageNo, int pageSize);

    int searchRecordCount1(int userid);

    List<Paylogs> selectRecordName1(String teamsname, int userid, int pageNo, int pageSize);

    int selectRecordNameCount1(String teamsname, int userid);

    List<Payment> selectPaymentp(int manager, int pageNo, int pageSize);

    int searchPaymentpCount(int manager);

    List<Payment> selectPaymentpName(String teamsname, int manager, int pageNo, int pageSize);

    int selectPaymentpNameCount(String teamsname, int manager);

    BaseResponse<String> insertPaymentp(String title, int teamid, int total, String details);

    BaseResponse<String> deletePaymentp(int pmid);

    List<Paylogs> selectPaid(int manager, int pageNo, int pageSize);

    int selectPaidCount(int manager);

    List<Paylogs> selectPaidName(String teamsname, String title,int manager, int pageNo, int pageSize);

    int selectPaidNameCount(String teamsname, String title,int manager);

    List<Paylogs> selectUnpaid(int manager, int pageNo, int pageSize);

    int selectUnpaidCount(int manager);

    List<Paylogs> selectUnpaidName(String teamsname, String title, int manager, int pageNo, int pageSize);

    int selectUnpaidNameCount(String teamsname, String title, int manager);

    List<Paylogs> selectTeamExpend(int userid, int pageNo, int pageSize);

    int selectTeamExpendCount(int userid);

    List<Paylogs> selectTeamExpendName(String teamsname, int userid, int pageNo, int pageSize);

    int selectTeamExpendNameCount(String teamsname, int userid);
}
