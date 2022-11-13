package com.stmanage.controller;

import com.stmanage.api.BaseResponse;
import com.stmanage.entity.TeamTypes;
import com.stmanage.entity.Teams;
import com.stmanage.entity.Users;
import com.stmanage.service.impl.TeamsServiceImpl;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class TeamsController {
    @Autowired
    private TeamsServiceImpl teamsServiceImpl;

    @RequestMapping("/selectTeams")
    public List<Teams> selectTeams(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeams(pageNo,pageSize);
    }
    @RequestMapping("/searchCount")
    public int searchCount(){
        return teamsServiceImpl.searchCount();
    }

    @RequestMapping("/insertTeams")
    public int  insertTeams(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int number = Integer.parseInt(map.get("number").toString());
        int manager = Integer.parseInt(map.get("manager").toString());
        int typeid = Integer.parseInt(map.get("typeid").toString());
        String details = map.get("details").toString();
        return teamsServiceImpl.insertTeams(teamsname,number,manager,typeid,details);
    }

    @RequestMapping("/deleteTeams")
    public int deleteTeams(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        return teamsServiceImpl.deleteTeams(id);
    }

    @RequestMapping("/selectTeamId")
    public Teams selectTeamId(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        return teamsServiceImpl.selectTeamId(id);
    }

    @RequestMapping("editTeams")
    public int editTeams(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        String teamsname = map.get("teamsname").toString();
        int number = Integer.parseInt(map.get("number").toString());
        int manager = Integer.parseInt(map.get("manager").toString());
        int typeid = Integer.parseInt(map.get("typeid").toString());
        String details = map.get("details").toString();
        return teamsServiceImpl.editTeams(id,teamsname,number,manager,typeid,details);
    }

    @RequestMapping("/selectTeamsName")
    public List<Teams> selectTeamsName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeamsName(teamsname,name,pageNo,pageSize);
    }

    @RequestMapping("/searchNameCount")
    public int searchNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        return teamsServiceImpl.searchNameCount(teamsname,name);
    }
    @RequestMapping("selectPresident")
    public List<Users> selectPresident(){
        return teamsServiceImpl.selectPresident();
    }

    @RequestMapping("/selectPreTypes")
    public List<TeamTypes> selectPreTypes(){
        return teamsServiceImpl.selectPreTypes();
    }

    @RequestMapping("/selectInforspName")
    public List<Teams> selectInforspName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectInforspName(teamsname,manager,pageNo,pageSize);
    }

    @RequestMapping("/selectInforspNameCount")
    public int selectInforspNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return teamsServiceImpl.selectInforspNameCount(teamsname,manager);
    }

    @RequestMapping("/selectSTName")
    public List<Teams> selectSTName(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        return teamsServiceImpl.selectSTName(manager);
    }
    @RequestMapping("/insertMembers")
    public int insertMembers(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int teamid = Integer.parseInt(map.get("teamid").toString());
        return teamsServiceImpl.insertMembers(userid,teamid);
    }
    @RequestMapping("/updateApplyState")
    public int updateApplyState(@RequestBody Map<String,Object> map){
        int appid = Integer.parseInt(map.get("appid").toString());
        return teamsServiceImpl.updateApplyState(appid);
    }

    @RequestMapping("/selectTeamStu")
    public List<Teams> selectTeamStu(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeamStu(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchTeamStuCount")
    public int searchTeamStuCount(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.searchTeamStuCount(userid);
    }
    @RequestMapping("/applyTeamStu")
    public int applyTeamStu(@RequestBody Map<String,Object> map){
        int teamid = Integer.parseInt(map.get("teamid").toString());
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.applyTeamStu(userid,teamid);
    }
    @RequestMapping("/selectAllTeam")
    public List<Teams> selectAllTeam(){
        return teamsServiceImpl.selectAllTeam();
    }
    @RequestMapping("/selectTeamStuName")
    public List<Teams> selectTeamStuName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeamStuName(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectTeamStuNameCount")
    public int selectTeamStuNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.selectTeamStuNameCount(teamsname,userid);
    }

    @RequestMapping("/selectTeamStu1")
    public List<Teams> selectTeamStu1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeamStu1(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchTeamStuCount1")
    public int searchTeamStuCount1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.searchTeamStuCount1(userid);
    }
    @RequestMapping("/deleteApplyState1")
    public int deleteApplyState1(@RequestBody Map<String,Object> map){
        int appid = Integer.parseInt(map.get("appid").toString());
        return teamsServiceImpl.deleteApplyState1(appid);
    }

    @RequestMapping("/selectTeamStuName1")
    public List<Teams> selectTeamStuName1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeamStuName1(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectTeamStuNameCount1")
    public int selectTeamStuNameCount1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.selectTeamStuNameCount1(teamsname,userid);
    }
    @RequestMapping("/selectExitTeamName")
    public List<Teams> selectExitTeamName(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.selectExitTeamName(userid);
    }

    @RequestMapping("/selectQuitTeam")
    public List<Teams> selectQuitTeam(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectQuitTeam(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchQuitTeamCount")
    public int searchQuitTeamCount(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.searchQuitTeamCount(userid);
    }
    @RequestMapping("/quitApply")
    public BaseResponse<String> quitApply(@RequestBody Map<String,Object> map){
        int teamid = Integer.parseInt(map.get("teamid").toString());
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.quitApply(teamid,userid);
    }
    @RequestMapping("/selectQuitTeamName")
    public List<Teams> selectQuitTeamName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectQuitTeamName(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectQuitTeamNameCount")
    public int selectQuitTeamNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.selectQuitTeamNameCount(teamsname,userid);
    }
    @RequestMapping("/selectQuitTeam1")
    public List<Teams> selectQuitTeam1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectQuitTeam1(userid,pageNo,pageSize);
    }
    @RequestMapping("/searchQuitTeamCount1")
    public int searchQuitTeamCount1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.searchQuitTeamCount1(userid);
    }
    @RequestMapping("/selectQuitTeamName1")
    public List<Teams> selectQuitTeamName1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectQuitTeamName1(teamsname,userid,pageNo,pageSize);
    }
    @RequestMapping("/selectQuitTeamNameCount1")
    public int selectQuitTeamNameCount1(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.selectQuitTeamNameCount1(teamsname,userid);
    }
    @RequestMapping("/selectSystemNo")
    public List<Teams> selectSystemNo(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.selectSystemNo(userid);
    }
    @RequestMapping("/selectSTName1")
    public List<Teams> selectSTName1(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        return teamsServiceImpl.selectSTName1(manager);
    }
    @RequestMapping("/selectTeamsInfosp")
    public List<Teams> selectTeamsInfosp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return teamsServiceImpl.selectTeamsInfosp(manager,pageNo,pageSize);
    }
    @RequestMapping("/searchTeamsInfospCount")
    public int searchTeamsInfospCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return teamsServiceImpl.searchTeamsInfospCount(manager);
    }
    @RequestMapping("/selectTeamNum")
    public List<Users> selectTeamNum(){
        return teamsServiceImpl.selectTeamNum();
    }
    @RequestMapping("/addUsers")
    public BaseResponse<String> addUsers(@RequestBody Map<String,Object> map){
        int teamid = Integer.parseInt(map.get("teamid").toString());
        int userid = Integer.parseInt(map.get("userid").toString());
        return teamsServiceImpl.addUsers(teamid,userid);
    }
}
