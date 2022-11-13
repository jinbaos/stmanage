package com.stmanage.controller;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Teams;
import com.stmanage.service.impl.NoticesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class NoticesController {
    @Autowired
    private NoticesServiceImpl noticesServiceImpl;

    @RequestMapping("/selectNotices")
    public List<Notices> selectNotices(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return noticesServiceImpl.selectNotices(pageNo,pageSize);
    }

    @RequestMapping("/searchNoticesCount")
    public int searchNoticesCount(){
        return noticesServiceImpl.searchNoticesCount();
    }

    @RequestMapping("/selectNoticesTitle")
    public List<Notices> selectNoticesTitle(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        String teamsname = map.get("teamsname").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return noticesServiceImpl.selectNoticesTitle(title,teamsname,pageNo,pageSize);
    }

    @RequestMapping("/selectNoticesCount")
    public int selectNoticesCount(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        String teamsname = map.get("teamsname").toString();
        return noticesServiceImpl.selectNoticesCount(title,teamsname);
    }
    @RequestMapping("/selectPushTeams")
    public List<Teams> selectPushTeams(){
        return noticesServiceImpl.selectPushTeams();
    }

    @RequestMapping("/insertNotices")
    public int insertNotices(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        int teamid = Integer.parseInt(map.get("teamid").toString());
        String detail = map.get("detail").toString();
        return noticesServiceImpl.insertNotices(title,teamid,detail);
    }
    @RequestMapping("/deleteNotices")
    public int deleteNotices(@RequestBody Map<String,Object> map){
        int noid = Integer.parseInt(map.get("noid").toString());
        return noticesServiceImpl.deleteNotices(noid);
    }

    @RequestMapping("/selectNoticesp")
    public List<Notices> selectNoticesp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return noticesServiceImpl.selectNoticesp(manager,pageNo,pageSize);
    }

    @RequestMapping("/searchNoticespCount")
    public int searchNoticespCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return noticesServiceImpl.searchNoticespCount(manager);
    }
    @RequestMapping("/selectNoticespTitle")
    public List<Notices> selectNoticespTitle(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String status = map.get("status").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return noticesServiceImpl.selectNoticespTitle(teamsname,status,manager,pageNo,pageSize);
    }

    @RequestMapping("/selectNoticespCount")
    public int selectNoticespCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String status = map.get("status").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return noticesServiceImpl.selectNoticespCount(teamsname,status,manager);
    }

    @RequestMapping("/insertNoticesp")
    public int insertNoticesp(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        int teamid = Integer.parseInt(map.get("teamid").toString());
        String detail = map.get("detail").toString();
        return noticesServiceImpl.insertNoticesp(title,teamid,detail);
    }

    @RequestMapping("/selectNoticestu")
    public List<Notices> selectNoticestu(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return noticesServiceImpl.selectNoticestu(userid,pageNo,pageSize);
    }

    @RequestMapping("/searchNoticestuCount")
    public int searchNoticestuCount(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return noticesServiceImpl.searchNoticestuCount(userid);
    }
    @RequestMapping("/selectNoticestuTitle")
    public List<Notices> selectNoticestuTitle(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String status = map.get("status").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return noticesServiceImpl.selectNoticestuTitle(teamsname,status,userid,pageNo,pageSize);
    }

    @RequestMapping("/selectNoticestuCount")
    public int selectNoticestuCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String status = map.get("status").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return noticesServiceImpl.selectNoticestuCount(teamsname,status,userid);
    }
}
