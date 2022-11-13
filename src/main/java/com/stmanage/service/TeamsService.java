package com.stmanage.service;

import com.stmanage.api.BaseResponse;
import com.stmanage.entity.TeamTypes;
import com.stmanage.entity.Teams;
import com.stmanage.entity.Users;

import java.util.List;

public interface TeamsService {
    List<Teams> selectTeams(int pageNo,int pageSize);

    int insertTeams(String teamsname, int number, int manager, int typeid, String details);

    int deleteTeams(int id);

    Teams selectTeamId(int id);

    int editTeams(int id, String teamsname, int number, int manager, int typeid, String details);

    List<Teams> selectTeamsName(String teamsname, String name,int pageNo,int pageSize);

    int searchCount();

    int searchNameCount(String teamsname, String name);

    List<Users> selectPresident();

    List<TeamTypes> selectPreTypes();

    List<Teams> selectInforspName(String teamsname, int manager,int pageNo, int pageSize);

    int selectInforspNameCount(String teamsname,int manager);

    List<Teams> selectSTName(int manager);

    int insertMembers(int userid, int teamid);

    int updateApplyState(int appid);

    List<Teams> selectTeamStu(int userid, int pageNo, int pageSize);

    int searchTeamStuCount(int userid);

    int applyTeamStu(int userid,int teamid);

    List<Teams> selectAllTeam();

    List<Teams> selectTeamStuName(String teamsname, int userid, int pageNo, int pageSize);

    int selectTeamStuNameCount(String teamsname, int userid);

    List<Teams> selectTeamStu1(int userid, int pageNo, int pageSize);

    int searchTeamStuCount1(int userid);

    int deleteApplyState1(int appid);

    List<Teams> selectTeamStuName1(String teamsname, int userid, int pageNo, int pageSize);

    int selectTeamStuNameCount1(String teamsname, int userid);

    List<Teams> selectExitTeamName(int userid);

    List<Teams> selectQuitTeam(int userid, int pageNo, int pageSize);

    int searchQuitTeamCount(int userid);

    BaseResponse<String> quitApply(int teamid, int userid);

    List<Teams> selectQuitTeamName(String teamsname, int userid, int pageNo, int pageSize);

    int selectQuitTeamNameCount(String teamsname, int userid);

    List<Teams> selectQuitTeam1(int userid, int pageNo, int pageSize);

    int searchQuitTeamCount1(int userid);

    List<Teams> selectQuitTeamName1(String teamsname, int userid, int pageNo, int pageSize);

    int selectQuitTeamNameCount1(String teamsname, int userid);

    List<Teams> selectSystemNo(int userid);

    List<Teams> selectSTName1(int manager);

    List<Teams> selectTeamsInfosp(int manager, int pageNo, int pageSize);

    int searchTeamsInfospCount(int manager);

    List<Users> selectTeamNum();

    BaseResponse<String> addUsers(int teamid, int userid);
}
