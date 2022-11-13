package com.stmanage.service.impl;

import com.stmanage.api.BaseApiService;
import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Applyactivitys;
import com.stmanage.entity.Users;
import com.stmanage.mapper.ActivityMapper;
import com.stmanage.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl extends BaseApiService implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Applyactivitys> selectApplyact(int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectApplyact(startIndex,pageSize);
    }

    @Override
    public int searchApplyactCount() {
        return activityMapper.searchApplyactCount();
    }

    @Override
    public List<Applyactivitys> selectCommunity(String community, String value,int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectCommunity(community,value,startIndex,pageSize);
    }

    @Override
    public int selectCommunityCount(String community,String value) {
        return activityMapper.selectCommunityCount(community,value);
    }

    @Override
    public int updateState1(int actid) {
        return activityMapper.updateState1(actid);
    }

    @Override
    public int updateState2(int actid,String refuse) {
        return activityMapper.updateState2(actid,refuse);
    }

    @Override
    public List<Applyactivitys> selectApplyact1(int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectApplyact1(startIndex,pageSize);
    }

    @Override
    public int searchApplyactCount1() {
        return activityMapper.searchApplyactCount1();
    }

    @Override
    public List<Applyactivitys> selectCommunity1(String community, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectCommunity1(community,startIndex,pageSize);
    }

    @Override
    public int selectCommunityCount1(String community) {
        return activityMapper.selectCommunityCount1(community);
    }

    @Override
    public List<Users> selectTakeMumber(int actid) {
        return activityMapper.selectTakeMumber(actid);
    }

    @Override
    public List<Applyactivitys> selectActivityp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivityp(manager,startIndex,pageSize);
    }

    @Override
    public int searchActivitypCount(int manager) {
        return activityMapper.searchActivitypCount(manager);
    }

    @Override
    public List<Applyactivitys> selectActivitypName(String teamsname, String state, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivitypName(teamsname,state,manager,startIndex,pageSize);
    }

    @Override
    public int selectActivitypNameCount(String teamsname, String state, int manager) {
        return activityMapper.selectActivitypNameCount(teamsname,state,manager);
    }

    @Override
    public int insertActivityp(String actname, int actnumber, String details, String activitytime, String teamid) {
        return activityMapper.insertActivityp(actname,actnumber,details,activitytime,teamid);
    }

    @Override
    public int deleteActivityp(int actid) {
        return activityMapper.deleteActivityp(actid);
    }

    @Override
    public List<Applyactivitys> selectActivityp1(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivityp1(manager,startIndex,pageSize);
    }

    @Override
    public int searchActivitypCount1(int manager) {
        return activityMapper.searchActivitypCount1(manager);
    }

    @Override
    public List<Applyactivitys> selectActivitypName1(int manager, String teamsname, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivitypName1(manager,teamsname,startIndex,pageSize);
    }

    @Override
    public int selectActivitypNameCount1(int manager, String teamsname) {
        return activityMapper.selectActivitypNameCount1(manager,teamsname);
    }

    @Override
    public int updateActivitypState(int actid) {
        return activityMapper.updateActivitypState(actid);
    }

    @Override
    public List<Applyactivitys> selectActivityStu(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivityStu(userid,startIndex,pageSize);
    }

    @Override
    public int searchActivityStuCount(int userid) {
        return activityMapper.searchActivityStuCount(userid);
    }

    @Override
    public List<Users> selectAlreadyMumber(int actid) {
        return activityMapper.selectAlreadyMumber(actid);
    }

    @Override
    public List<Applyactivitys> selectActivityStuName(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivityStuName(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectActivityStuNameCount(String teamsname, int userid) {
        return activityMapper.selectActivityStuNameCount(teamsname,userid);
    }

    @Override
    public BaseResponse<String> insertAttend(int actid, int userid) {
        int count = activityMapper.selectIfActivity(actid,userid);
        Applyactivitys applyactivitys = activityMapper.selectActivityFull(actid,userid);
        int alreadynum = applyactivitys.getAlreadynum();
        int actnumber = applyactivitys.getActnumber();
        if (count != 0){
            return setResultError("已经参加报名，无法重新报名！");
        }
        if(alreadynum == actnumber){
            return setResultError("报名人数已满，无法再报名！");
        }
        return setResult(200,"报名成功！",activityMapper.insertAttend(actid,userid));
    }

    @Override
    public List<Applyactivitys> selectActivityStu1(int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivityStu1(userid,startIndex,pageSize);
    }

    @Override
    public int searchActivityStuCount1(int userid) {
        return activityMapper.searchActivityStuCount1(userid);
    }

    @Override
    public List<Applyactivitys> selectActivityStuName1(String teamsname, int userid, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return activityMapper.selectActivityStuName1(teamsname,userid,startIndex,pageSize);
    }

    @Override
    public int selectActivityStuNameCount1(String teamsname, int userid) {
        return activityMapper.selectActivityStuNameCount1(teamsname,userid);
    }

    @Override
    public BaseResponse<String> deleteAmidMem(int amid, int actid, int userid) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowdate = sdf.format(new java.util.Date());
        Applyactivitys applyactivitys = activityMapper.selectActivityTime(actid,userid);
        String activitytime = applyactivitys.getActivitytime();
        if(nowdate.compareTo(activitytime) > 0){
            return setResultError("活动正在进行中，无法取消！");
        }
        return setResult(200,"取消成功！",activityMapper.deleteAmidMem(amid));
    }

    @Override
    public Applyactivitys selectActivitypOne(int manager, int actid) {
        return activityMapper.selectActivitypOne(manager,actid);
    }

    @Override
    public int updateActivitypOne(int actid, String actname, int actnumber, String details, String activitytime, int teamid) {
        return activityMapper.updateActivitypOne(actid,actname,actnumber,details,activitytime,teamid);
    }
}
