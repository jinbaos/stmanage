package com.stmanage.service.impl;

import com.stmanage.entity.TemplateId;
import com.stmanage.entity.Users;
import com.stmanage.mapper.UsersMapper;
import com.stmanage.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectUsers(int pageNo,int pageSize) {
        int startIndex = pageSize * (pageNo-1);
         return usersMapper.selectUsers(startIndex,pageSize);
    }

    @Override
    public int updateUsersStatus(int status, int id) {

        return usersMapper.updateUsersStatus(status,id);
    }

    @Override
    public int insertUsers(String username, String password, String name, String gender, int age, String phone, String address, String type) {
        return usersMapper.insertUsers(username,password,name,gender,age,phone,address,type);
    }

    @Override
    public Users selectUsersId(int id) {
        return usersMapper.selectUsersId(id);
    }

    @Override
    public int editUsers(int id, String username, String password, String name, String gender, int age, String phone, String address, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = sdf.format(new java.util.Date());
        return usersMapper.editUsers(id,username,password,name,gender,age,phone,address,type,updateTime);
    }

    @Override
    public List<Users> selectPhone(String username,String name,String phone,int pageNo,int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectPhone(username,name,phone,startIndex,pageSize);
    }

    @Override
    public Users selectLogin(String username, String password, String type) {
        return usersMapper.selectLogin(username,password,type);
    }

    @Override
    public int deleteUsers(List<Integer> ids) {
        return usersMapper.deleteUsers(ids);
    }

    @Override
    public int searchUsersCount() {
        return usersMapper.searchUsersCount();
    }

    @Override
    public int searchPhoneCount(String username, String name, String phone) {
        return usersMapper.searchPhoneCount(username,name,phone);
    }

    @Override
    public List<Users> selectMumbersp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectMumbersp(manager,startIndex,pageSize);
    }

    @Override
    public int searchMumberspCount(int manager) {
        return usersMapper.searchMumberspCount(manager);
    }

    @Override
    public List<Users> selectMumberspName(int manager,String id, String name, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectMumberspName(manager,id,name,startIndex,pageSize);
    }

    @Override
    public int selectMumberspNameCount(int manager,String id, String name) {
        return usersMapper.selectMumberspNameCount(manager,id,name);
    }


    @Override
    public List<Users> selectHandlep(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectHandlep(manager,startIndex,pageSize);
    }

    @Override
    public int searchHandlepCount(int manager) {
        return usersMapper.searchHandlepCount(manager);
    }

    @Override
    public List<Users> selectHandlepName(int manager, String teamsname, String name, String state, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectHandlepName(manager,teamsname,name,state,startIndex,pageSize);
    }

    @Override
    public int selectHandlepNameCount(int manager, String teamsname, String name, String state) {
        return usersMapper.selectHandlepNameCount(manager,teamsname,name,state);
    }

    @Override
    public List<Users> selectQuiteamp(int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectQuiteamp(manager,startIndex,pageSize);
    }

    @Override
    public int searchQuiteampCount(int manager) {
        return usersMapper.searchQuiteampCount(manager);
    }

    @Override
    public List<Users> selectQuiteampTitle(String teamsname, String name, String state, int manager, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectQuiteampTitle(teamsname,name,state,manager,startIndex,pageSize);
    }

    @Override
    public int selectQuiteampCount(String teamsname, String name, String state, int manager) {
        return usersMapper.selectQuiteampCount(teamsname,name,state,manager);
    }

    @Override
    public int deleteMembers1(int userid, int teamid, int appid) {
        usersMapper.updateExitstate(appid);
        return usersMapper.deleteMembers1(userid,teamid);
    }

    @Override
    public Users selectNameType(int id) {
        return usersMapper.selectNameType(id);
    }

    @Override
    public List<Users> selectMumbers(int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectMumbers(startIndex,pageSize);
    }

    @Override
    public int searchMumbersCount() {
        return usersMapper.searchMumbersCount();
    }

    @Override
    public List<Users> selectMumbersName(String teamsname, int pageNo, int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return usersMapper.selectMumbersName(teamsname,startIndex,pageSize);
    }

    @Override
    public int selectMumbersNameCount(String teamsname) {
        return usersMapper.selectMumbersNameCount(teamsname);
    }

    @Override
    public int deleteMumbers(int tmid) {
        TemplateId templateId = usersMapper.selectId(tmid);
        int userid = templateId.getUserid();
        int teamid = templateId.getTeamid();
        List<TemplateId> list = usersMapper.selectActid(teamid);
        for(int i = 0;i<list.size();i++){
            usersMapper.deleteActNum(userid,list.get(i).getActid());
        }
        return usersMapper.deleteMumbers(tmid);
    }
}
