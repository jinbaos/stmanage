package com.stmanage.service.impl;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Users;
import com.stmanage.mapper.IndexMapper;
import com.stmanage.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public int selectTeamNums() {
        return indexMapper.selectTeamNums();
    }

    @Override
    public int selectActivityNums(int userid) {
        return indexMapper.selectActivityNums(userid);
    }

    @Override
    public int selectNoticeNums(int userid) {
        return indexMapper.selectNoticeNums(userid);
    }

    @Override
    public Notices selectNotice1(int userid) {
        return indexMapper.selectNotice1(userid);
    }

    @Override
    public Notices selectNotice2(int userid) {
        return indexMapper.selectNotice2(userid);
    }

    @Override
    public Users selectUserinfor(int userid) {
        return indexMapper.selectUserinfor(userid);
    }

    @Override
    public int updateUserInfo(String username, String password, String name, String gender, int age, String phone, String address,int id) {
        return indexMapper.updateUserInfo(username,password,name,gender,age,phone,address,id);
    }

    @Override
    public Notices selectNotices1(int manager) {
        return indexMapper.selectNotices1(manager);
    }

    @Override
    public Notices selectNotices2(int manager) {
        return indexMapper.selectNotices2(manager);
    }
}
