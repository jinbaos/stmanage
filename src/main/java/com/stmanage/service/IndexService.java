package com.stmanage.service;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Users;

public interface IndexService {
    int selectTeamNums();

    int selectActivityNums(int userid);

    int selectNoticeNums(int userid);

    Notices selectNotice1(int userid);

    Notices selectNotice2(int userid);

    Users selectUserinfor(int userid);

    int updateUserInfo(String username, String password, String name, String gender, int age, String phone, String address,int id);

    Notices selectNotices1(int manager);

    Notices selectNotices2(int manager);
}
