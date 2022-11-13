package com.stmanage.service.impl;

import com.stmanage.api.BaseApiService;
import com.stmanage.api.BaseResponse;
import com.stmanage.entity.TeamTypes;
import com.stmanage.entity.Teams;
import com.stmanage.entity.Users;
import com.stmanage.mapper.TeamsMapper;
import com.stmanage.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamsServiceImpl extends BaseApiService implements TeamsService {
    @Autowired
    private TeamsMapper teamsMapper;


    @Override
    public List<Teams> selectTeams(int pageNo,int pageSize) {
//        int pageSize = 4;
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeams(startIndex,pageSize);
    }
    @Override
    public int searchCount() {
        int count = teamsMapper.searchCount() - 1;
        return count;
    }

    @Override
    public int searchNameCount(String teamsname, String name) {
        return teamsMapper.searchNameCount(teamsname,name);
    }

    @Override
    public List<Users> selectPresident() {
        return teamsMapper.selectPresident();
    }

    @Override
    public List<TeamTypes> selectPreTypes() {
        return teamsMapper.selectPreTypes();
    }

    @Override
    public List<Teams> selectInforspName(String teamsname, int manager,int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectInforspName(teamsname,manager,startIndex,pageSize);
    }

    @Override
    public int selectInforspNameCount(String teamsname,int manager) {
        return teamsMapper.selectInforspNameCount(teamsname,manager);
    }

    @Override
    public List<Teams> selectSTName(int manager) {
        return teamsMapper.selectSTName(manager);
    }

    @Override
    public int insertTeams(String teamsname, int number, int manager, int typeid, String details) {
        return teamsMapper.insertTeams(teamsname,number,manager,typeid,details);
    }

    @Override
    public int deleteTeams(int id) {
        return teamsMapper.deleteTeams(id);
    }

    @Override
    public Teams selectTeamId(int id) {
        return teamsMapper.selectTeamId(id);
    }
    @Override
    public int editTeams(int id, String teamsname, int number, int manager, int typeid, String details) {
        return teamsMapper.editTeams(id,teamsname,number,manager,typeid,details);
    }

    @Override
    public List<Teams> selectTeamsName(String teamsname, String name,int pageNo,int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeamsName(teamsname,name,startIndex,pageSize);
    }

    @Override
    public int insertMembers(int userid, int teamid) {
        return teamsMapper.insertMembers(userid,teamid);
    }

    @Override
    public int updateApplyState(int appid) {
        return teamsMapper.updateApplyState(appid);
    }

    @Override
    public List<Teams> selectTeamStu(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeamStu(userid,startIndex,pageSize);

    }

    @Override
    public int searchTeamStuCount(int userid) {
        return teamsMapper.searchTeamStuCount(userid);
    }

    @Override
    public int applyTeamStu(int userid,int teamid) {
        int count = teamsMapper.selectApplyCount(userid,teamid);
        if(count == 0){
            return teamsMapper.applyTeamStu(userid,teamid);
        }else{
            teamsMapper.deleteApplyCount(userid,teamid);
            teamsMapper.applyTeamStu(userid,teamid);
        }
        return count;
    }

    @Override
    public List<Teams> selectAllTeam() {
        return teamsMapper.selectAllTeam();
    }

    @Override
    public List<Teams> selectTeamStuName(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeamStuName(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectTeamStuNameCount(String teamsname, int userid) {
        return teamsMapper.selectTeamStuNameCount(teamsname,userid);
    }

    @Override
    public List<Teams> selectTeamStu1(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeamStu1(userid,startIndex,pageSize);
    }

    @Override
    public int searchTeamStuCount1(int userid) {
        return teamsMapper.searchTeamStuCount1(userid);
    }

    @Override
    public int deleteApplyState1(int appid) {
        return teamsMapper.deleteApplyState1(appid);
    }

    @Override
    public List<Teams> selectTeamStuName1(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeamStuName1(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectTeamStuNameCount1(String teamsname, int userid) {
        return teamsMapper.selectTeamStuNameCount1(teamsname,userid);
    }

    @Override
    public List<Teams> selectExitTeamName(int userid) {
        return teamsMapper.selectExitTeamName(userid);
    }

    @Override
    public List<Teams> selectQuitTeam(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectQuitTeam(userid,startIndex,pageSize);
    }

    @Override
    public int searchQuitTeamCount(int userid) {
        return teamsMapper.searchQuitTeamCount(userid);
    }

    @Override
    public BaseResponse<String> quitApply(int teamid, int userid) {
        int count1 = teamsMapper.selectActivityCount(userid);
        if(count1 != 0 ){
            return setResultError("参加的活动还未结束，暂时不能申请退社团！");
        }

        int count = teamsMapper.selectQuitApplyCount(teamid,userid);

        if(count != 0){
            return setResultError("已经申请，等待社长审核！");
//            teamsMapper.deleteQuitApplyCount(teamid,userid);
//            teamsMapper.quitApply(teamid,userid);
        }
        return setResult(200,"申请成功",teamsMapper.quitApply(teamid,userid));
    }

    @Override
    public List<Teams> selectQuitTeamName(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectQuitTeamName(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectQuitTeamNameCount(String teamsname, int userid) {
        return teamsMapper.selectQuitTeamNameCount(teamsname,userid);
    }

    @Override
    public List<Teams> selectQuitTeam1(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectQuitTeam1(userid,startIndex,pageSize);
    }

    @Override
    public int searchQuitTeamCount1(int userid) {
        return teamsMapper.searchQuitTeamCount1(userid);
    }

    @Override
    public List<Teams> selectQuitTeamName1(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectQuitTeamName1(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectQuitTeamNameCount1(String teamsname, int userid) {
        return teamsMapper.selectQuitTeamNameCount1(teamsname,userid);
    }

    @Override
    public List<Teams> selectSystemNo(int userid) {
        return teamsMapper.selectSystemNo(userid);
    }

    @Override
    public List<Teams> selectSTName1(int manager) {
        return teamsMapper.selectSTName1(manager);
    }

    @Override
    public List<Teams> selectTeamsInfosp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return teamsMapper.selectTeamsInfosp(manager,startIndex,pageSize);
    }

    @Override
    public int searchTeamsInfospCount(int manager) {
        return teamsMapper.searchTeamsInfospCount(manager);
    }

    @Override
    public List<Users> selectTeamNum() {
        return teamsMapper.selectTeamNum();
    }

    @Override
    public BaseResponse<String> addUsers(int teamid, int userid) {
        Integer exist = teamsMapper.selectNumCount(teamid,userid);
        if(exist != null){
            return setResultError("该学生已是社团成员！");
        }
        return setResult(200,"添加成功",teamsMapper.addUsers(teamid,userid));
    }

}
