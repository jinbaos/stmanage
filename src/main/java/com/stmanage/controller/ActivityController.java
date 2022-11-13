package com.stmanage.controller;
import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Applyactivitys;
import com.stmanage.entity.Users;
import com.stmanage.service.impl.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ActivityController {
    @Autowired
    private ActivityServiceImpl activityServiceImpl;

    @RequestMapping("/selectApplyact")
    public List<Applyactivitys> selectApplyact(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectApplyact(pageNo,pageSize);
    }

    @RequestMapping("/searchApplyactCount")
    public int searchApplyactCount(){
        return activityServiceImpl.searchApplyactCount();
    }

    @RequestMapping("/selectCommunity")
    public List<Applyactivitys> selectCommunity(@RequestBody Map<String,Object> map){
        String community = map.get("community").toString();
        String value = map.get("value").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectCommunity(community,value,pageNo,pageSize);
    }

    @RequestMapping("/selectCommunityCount")
    public int selectCommunityCount(@RequestBody Map<String,Object> map){
        String community = map.get("community").toString();
        String value = map.get("value").toString();
        return activityServiceImpl.selectCommunityCount(community,value);
    }

    @RequestMapping("/updateState1")
    public int updateState1(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        return activityServiceImpl.updateState1(actid);
    }

    @RequestMapping("/updateState2")
    public int updateState2(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        String refuse = map.get("refuse").toString();
        return activityServiceImpl.updateState2(actid,refuse);
    }

    @RequestMapping("/selectApplyact1")
    public List<Applyactivitys> selectApplyact1(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectApplyact1(pageNo,pageSize);
    }

    @RequestMapping("/searchApplyactCount1")
    public int searchApplyactCount1(){

        return activityServiceImpl.searchApplyactCount1();
    }

    @RequestMapping("/selectCommunity1")
    public List<Applyactivitys> selectCommunity1(@RequestBody Map<String,Object> map){
        String community = map.get("community").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectCommunity1(community,pageNo,pageSize);
    }

    @RequestMapping("/selectCommunityCount1")
    public int selectCommunityCount1(@RequestBody Map<String,Object> map){
        String community = map.get("community").toString();
        return activityServiceImpl.selectCommunityCount1(community);
    }

    @RequestMapping("/selectTakeMumber")
    public List<Users> selectTakeMumber(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        return activityServiceImpl.selectTakeMumber(actid);
    }

    @RequestMapping("/selectActivityp")
    public List<Applyactivitys> selectActivityp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivityp(manager,pageNo,pageSize);
    }

    @RequestMapping("/searchActivitypCount")
    public int searchActivitypCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return activityServiceImpl.searchActivitypCount(manager);
    }

    @RequestMapping("/selectActivitypName")
    public List<Applyactivitys> selectActivitypName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String state = map.get("state").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivitypName(teamsname,state,manager,pageNo,pageSize);
    }

    @RequestMapping("/selectActivitypNameCount")
    public int selectActivitypNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String state = map.get("state").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return activityServiceImpl.selectActivitypNameCount(teamsname,state,manager);
    }

    @RequestMapping("/insertActivityp")
    public int insertActivityp(@RequestBody Map<String,Object> map){
        String actname = map.get("actname").toString();
        int actnumber = Integer.parseInt(map.get("actnumber").toString());
        String details = map.get("details").toString();
        String activitytime = map.get("activitytime").toString();
        String teamid = map.get("teamid").toString();
        return activityServiceImpl.insertActivityp(actname,actnumber,details,activitytime,teamid);
    }
    @RequestMapping("/deleteActivityp")
    public int deleteActivityp(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        return activityServiceImpl.deleteActivityp(actid);
    }

    @RequestMapping("/selectActivityp1")
    public List<Applyactivitys> selectActivityp1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivityp1(manager,pageNo,pageSize);
    }

    @RequestMapping("/searchActivitypCount1")
    public int searchActivitypCount1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return activityServiceImpl.searchActivitypCount1(manager);
    }

    @RequestMapping("/selectActivitypName1")
    public List<Applyactivitys> selectActivitypName1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        String teamsname = map.get("teamsname").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivitypName1(manager,teamsname,pageNo,pageSize);
    }

    @RequestMapping("/selectActivitypNameCount1")
    public int selectActivitypNameCount1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        String teamsname = map.get("teamsname").toString();
        return activityServiceImpl.selectActivitypNameCount1(manager,teamsname);
    }
    @RequestMapping("/updateActivitypState")
    public int updateActivitypState(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        return activityServiceImpl.updateActivitypState(actid);
    }
    @RequestMapping("/selectActivityStu")
    public List<Applyactivitys> selectActivityStu(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivityStu(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchActivityStuCount")
    public int searchActivityStuCount(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return activityServiceImpl.searchActivityStuCount(userid);
    }
    @RequestMapping("/selectAlreadyMumber")
    public List<Users> selectAlreadyMumber(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        return activityServiceImpl.selectAlreadyMumber(actid);
    }

    @RequestMapping("/selectActivityStuName")
    public List<Applyactivitys> selectActivityStuName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivityStuName(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectActivityStuNameCount")
    public int selectActivityStuNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return activityServiceImpl.selectActivityStuNameCount(teamsname,userid);
    }
    @RequestMapping("/insertAttend")
    public BaseResponse<String> insertAttend(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        int userid = Integer.parseInt(map.get("userid").toString());
        return activityServiceImpl.insertAttend(actid,userid);
    }
    @RequestMapping("/selectActivityStu1")
    public List<Applyactivitys> selectActivityStu1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivityStu1(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchActivityStuCount1")
    public int searchActivityStuCount1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return activityServiceImpl.searchActivityStuCount1(userid);
    }
    @RequestMapping("/selectActivityStuName1")
    public List<Applyactivitys> selectActivityStuName1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return activityServiceImpl.selectActivityStuName1(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectActivityStuNameCount1")
    public int selectActivityStuNameCount1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return activityServiceImpl.selectActivityStuNameCount1(teamsname,userid);
    }
    @RequestMapping("/deleteAmidMem")
    public BaseResponse<String> deleteAmidMem(@RequestBody Map<String,Object> map){
        int amid = Integer.parseInt(map.get("amid").toString());
        int actid = Integer.parseInt(map.get("actid").toString());
        int userid = Integer.parseInt(map.get("userid").toString());
        return activityServiceImpl.deleteAmidMem(amid,actid,userid);
    }
    @RequestMapping("/selectActivitypOne")
    public Applyactivitys selectActivitypOne(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int actid = Integer.parseInt(map.get("actid").toString());
        return activityServiceImpl.selectActivitypOne(manager,actid);
    }
    @RequestMapping("/updateActivitypOne")
    public int updateActivitypOne(@RequestBody Map<String,Object> map){
        int actid = Integer.parseInt(map.get("actid").toString());
        String actname = map.get("actname").toString();
        int actnumber = Integer.parseInt(map.get("actnumber").toString());
        String details = map.get("details").toString();
        String activitytime = map.get("activitytime").toString();
        int teamid = Integer.parseInt(map.get("teamid").toString());
        return activityServiceImpl.updateActivitypOne(actid,actname,actnumber,details,activitytime,teamid);
    }
}
