package com.stmanage.service.impl;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Teams;
import com.stmanage.mapper.NoticesMapper;
import com.stmanage.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesServiceImpl implements NoticesService {
    @Autowired
    private NoticesMapper noticesMapper;

    @Override
    public List<Notices> selectNotices(int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return noticesMapper.selectNotices(startIndex,pageSize);
    }

    @Override
    public int searchNoticesCount() {
        return noticesMapper.searchNoticesCount();
    }

    @Override
    public List<Notices> selectNoticesTitle(String title, String teamsname, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return noticesMapper.selectNoticesTitle(title,teamsname,startIndex,pageSize);
    }

    @Override
    public int selectNoticesCount(String title, String teamsname) {
        return noticesMapper.selectNoticesCount(title,teamsname);
    }

    @Override
    public List<Teams> selectPushTeams() {
        return noticesMapper.selectPushTeams();
    }

    @Override
    public int insertNotices(String title, int teamid, String detail) {
        return noticesMapper.insertNotices(title,teamid,detail);
    }

    @Override
    public int deleteNotices(int noid) {
        return noticesMapper.deleteNotices(noid);
    }

    @Override
    public List<Notices> selectNoticesp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return noticesMapper.selectNoticesp(manager,startIndex,pageSize);
    }

    @Override
    public int searchNoticespCount(int manager) {
        return noticesMapper.searchNoticespCount(manager);
    }

    @Override
    public List<Notices> selectNoticespTitle(String teamsname, String status, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return noticesMapper.selectNoticespTitle(teamsname,status,manager,startIndex,pageSize);
    }

    @Override
    public int selectNoticespCount(String teamsname, String status, int manager) {
        return noticesMapper.selectNoticespCount(teamsname,status,manager);
    }

    @Override
    public int insertNoticesp(String title, int teamid, String detail) {
        return noticesMapper.insertNoticesp(title,teamid,detail);
    }

    @Override
    public List<Notices> selectNoticestu(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return noticesMapper.selectNoticestu(userid,startIndex,pageSize);
    }

    @Override
    public int searchNoticestuCount(int userid) {
        return noticesMapper.searchNoticestuCount(userid);
    }

    @Override
    public List<Notices> selectNoticestuTitle(String teamsname, String status, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return noticesMapper.selectNoticestuTitle(teamsname,status,userid,startIndex,pageSize);
    }

    @Override
    public int selectNoticestuCount(String teamsname, String status, int userid) {
        return noticesMapper.selectNoticestuCount(teamsname,status,userid);
    }

}
