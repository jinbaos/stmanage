package com.stmanage.service;

import com.stmanage.entity.Users;

import java.util.List;

public interface UsersService {
    List<Users> selectUsers(int pageNo,int pageSize);

    int updateUsersStatus(int status, int id);

    int insertUsers(String username, String password, String name, String gender, int age, String phone, String address, String type);

    Users selectUsersId(int id);

    int editUsers(int id, String username, String password, String name, String gender, int age, String phone, String address, String type);

    List<Users> selectPhone(String username,String name, String phone,int pageNo,int pageSize);

    Users selectLogin(String username, String password, String type);

    int deleteUsers(List<Integer> ids);

    int searchUsersCount();

    int searchPhoneCount(String username, String name, String phone);

    List<Users> selectMumbersp(int manager, int pageNo, int pageSize);

    int searchMumberspCount(int manager);

    List<Users> selectMumberspName(int manager,String id, String name, int pageNo, int pageSize);

    int selectMumberspNameCount(int manager,String id, String name);


    List<Users> selectHandlep(int manager, int pageNo, int pageSize);

    int searchHandlepCount(int manager);

    List<Users> selectHandlepName(int manager, String teamsname, String name, String state, int pageNo, int pageSize);

    int selectHandlepNameCount(int manager, String teamsname, String name, String state);

    List<Users> selectQuiteamp(int manager, int pageNo, int pageSize);

    int searchQuiteampCount(int manager);

    List<Users> selectQuiteampTitle(String teamsname, String name, String state, int manager, int pageNo, int pageSize);

    int selectQuiteampCount(String teamsname, String name, String state, int manager);

    int deleteMembers1(int userid, int teamid, int appid);

    Users selectNameType(int id);

    List<Users> selectMumbers(int pageNo, int pageSize);

    int searchMumbersCount();

    List<Users> selectMumbersName(String teamsname, int pageNo, int pageSize);

    int selectMumbersNameCount(String teamsname);

    int deleteMumbers(int tmid);
}
