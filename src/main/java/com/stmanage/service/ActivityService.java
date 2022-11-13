package com.stmanage.service;

import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Applyactivitys;
import com.stmanage.entity.Users;

import java.util.List;

public interface ActivityService {
    List<Applyactivitys> selectApplyact(int pageNo, int pageSize);

    int searchApplyactCount();

    List<Applyactivitys> selectCommunity(String community, String value, int pageNo, int pageSize);

    int selectCommunityCount(String community,String value);

    int updateState1(int actid);

    int updateState2(int actid,String refuse);

    List<Applyactivitys> selectApplyact1(int pageNo, int pageSize);

    int searchApplyactCount1();

    List<Applyactivitys> selectCommunity1(String community, int pageNo, int pageSize);

    int selectCommunityCount1(String community);

    List<Users> selectTakeMumber(int actid);

    List<Applyactivitys> selectActivityp(int manager, int pageNo, int pageSize);

    int searchActivitypCount(int manager);

    List<Applyactivitys> selectActivitypName(String teamsname, String state, int manager, int pageNo, int pageSize);

    int selectActivitypNameCount(String teamsname, String state, int manager);

    int insertActivityp(String actname, int actnumber, String details, String activitytime, String teamid);

    int deleteActivityp(int actid);

    List<Applyactivitys> selectActivityp1(int manager, int pageNo, int pageSize);

    int searchActivitypCount1(int manager);

    List<Applyactivitys> selectActivitypName1(int manager, String teamsname, int pageNo, int pageSize);

    int selectActivitypNameCount1(int manager, String teamsname);

    int updateActivitypState(int actid);

    List<Applyactivitys> selectActivityStu(int userid, int pageNo, int pageSize);

    int searchActivityStuCount(int userid);

    List<Users> selectAlreadyMumber(int actid);

    List<Applyactivitys> selectActivityStuName(String teamsname, int userid, int pageNo, int pageSize);

    int selectActivityStuNameCount(String teamsname, int userid);

    BaseResponse<String> insertAttend(int actid, int userid);

    List<Applyactivitys> selectActivityStu1(int userid, int pageNo, int pageSize);

    int searchActivityStuCount1(int userid);

    List<Applyactivitys> selectActivityStuName1(String teamsname, int userid, int pageNo, int pageSize);

    int selectActivityStuNameCount1(String teamsname, int userid);

    BaseResponse<String> deleteAmidMem(int amid, int actid, int userid);

    Applyactivitys selectActivitypOne(int manager, int actid);

    int updateActivitypOne(int actid, String actname, int actnumber, String details, String activitytime, int teamid);
}
