package com.stmanage.service;

import com.stmanage.entity.TeamTypes;

import java.util.List;

public interface TypesService {
    List<TeamTypes> selectTypes(int pageNo,int pageSize);

    List<TeamTypes> selectTypeName(String name,int pageNo,int pageSize);

    int insertTypes(String name);

    int deleteTypes(int id);

    TeamTypes selectTypesId(int id);

    int editTypes(int id, String name);

    int searchTypesCount();

    int selectNameCount(String name);
}
