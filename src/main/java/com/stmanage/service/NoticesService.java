package com.stmanage.service;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Teams;

import java.util.List;

public interface NoticesService {
    List<Notices> selectNotices(int pageNo, int pageSize);

    int searchNoticesCount();

    List<Notices> selectNoticesTitle(String title, String teamsname, int pageNo, int pageSize);

    int selectNoticesCount(String title, String teamsname);

    List<Teams> selectPushTeams();

    int insertNotices(String title, int teamid, String detail);

    int deleteNotices(int noid);

    List<Notices> selectNoticesp(int manager, int pageNo, int pageSize);

    int searchNoticespCount(int manager);

    List<Notices> selectNoticespTitle(String teamsname, String status, int manager, int pageNo, int pageSize);

    int selectNoticespCount(String teamsname, String status, int manager);

    int insertNoticesp(String title, int teamid, String detail);

    List<Notices> selectNoticestu(int userid, int pageNo, int pageSize);

    int searchNoticestuCount(int userid);

    List<Notices> selectNoticestuTitle(String teamsname, String status, int userid, int pageNo, int pageSize);

    int selectNoticestuCount(String teamsname, String status, int userid);
}
