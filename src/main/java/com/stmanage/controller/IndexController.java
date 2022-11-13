package com.stmanage.controller;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Users;
import com.stmanage.service.impl.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class IndexController {
    @Autowired
    private IndexServiceImpl indexServiceImpl;

    @RequestMapping("/selectTeamNums")
    public int selectTeamNums(){
        return indexServiceImpl.selectTeamNums();
    }

    @RequestMapping("/selectActivityNums")
    public int selectActivityNums(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return indexServiceImpl.selectActivityNums(userid);
    }
    @RequestMapping("/selectNoticeNums")
    public int selectNoticeNums(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return indexServiceImpl.selectNoticeNums(userid);
    }
    @RequestMapping("/selectNotice1")
    public Notices selectNotice1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return indexServiceImpl.selectNotice1(userid);
    }
    @RequestMapping("/selectNotice2")
    public Notices selectNotice2(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return indexServiceImpl.selectNotice2(userid);
    }

    @RequestMapping("/selectUserinfor")
    public Users selectUserinfor(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return indexServiceImpl.selectUserinfor(userid);
    }
    @RequestMapping("/updateUserInfo")
    public int updateUserInfo(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String name = map.get("name").toString();
        String gender = map.get("gender").toString();
        int age = Integer.parseInt(map.get("age").toString());
        String phone = map.get("phone").toString();
        String address = map.get("address").toString();
        int id = Integer.parseInt(map.get("userid").toString());
        return indexServiceImpl.updateUserInfo(username,password,name,gender,age,phone,address,id);
    }
    @RequestMapping("/selectNotices1")
    public Notices selectNotices1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return indexServiceImpl.selectNotices1(manager);
    }
    @RequestMapping("/selectNotices2")
    public Notices selectNotices2(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return indexServiceImpl.selectNotices2(manager);
    }
}
