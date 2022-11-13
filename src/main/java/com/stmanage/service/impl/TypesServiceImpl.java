package com.stmanage.service.impl;

import com.stmanage.entity.TeamTypes;
import com.stmanage.mapper.TypesMapper;
import com.stmanage.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;

    @Override
    public List<TeamTypes> selectTypes(int pageNo,int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return typesMapper.selectTypes(startIndex,pageSize);
    }

    @Override
    public List<TeamTypes> selectTypeName(String name,int pageNo,int pageSize) {
        int startIndex = pageSize * (pageNo-1);
        return typesMapper.selectTypeName(name,startIndex,pageSize);
    }

    @Override
    public int insertTypes(String name) {
        return typesMapper.insertTypes(name);
    }

    @Override
    public int deleteTypes(int id) {
        return typesMapper.deleteTypes(id);
    }

    @Override
    public TeamTypes selectTypesId(int id) {
        return typesMapper.selectTypesId(id);
    }

    @Override
    public int editTypes(int id, String name) {
        return typesMapper.editTypes(id,name);
    }

    @Override
    public int searchTypesCount() {
        return typesMapper.searchTypesCount();
    }

    @Override
    public int selectNameCount(String name) {
        return typesMapper.selectNameCount(name);
    }
}
