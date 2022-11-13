package com.stmanage.controller;

import com.stmanage.entity.TeamTypes;
import com.stmanage.service.impl.TypesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController  //该类中所以SpringMVCUrl接口映射都返回的是json格式    相当于在每个方法加上@ResponseBody
@CrossOrigin  //用来处理跨域请求的注解
public class TypesController {
    @Autowired
    private TypesServiceImpl typesserviceImpl;

    @RequestMapping("/selectTypes")
    public List<TeamTypes> selectTypes(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return typesserviceImpl.selectTypes(pageNo,pageSize);
    }

    @RequestMapping("/selectTypeName")
    public List<TeamTypes> selectTypeName(@RequestBody Map<String, Object> map){
        String name = map.get("name").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return typesserviceImpl.selectTypeName(name,pageNo,pageSize);
    }

    @RequestMapping("/insertTypes")
    public int insertTypes(@RequestBody Map<String,Object> map){
        String name = map.get("name").toString();
        return typesserviceImpl.insertTypes(name);
    }

    @RequestMapping("/deleteTypes")
    public int deleteTypes(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        return typesserviceImpl.deleteTypes(id);
    }

    @RequestMapping("/selectTypesId")
    public TeamTypes selectTypesId(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        return typesserviceImpl.selectTypesId(id);
    }

    @RequestMapping("/editTypes")
    public int editTypes(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        String name = map.get("name").toString();
        return typesserviceImpl.editTypes(id,name);
    }

    @RequestMapping("/searchTypesCount")
    public int searchTypesCount(){
        return typesserviceImpl.searchTypesCount();
    }

    @RequestMapping("/selectNameCount")
    public int selectNameCount(@RequestBody Map<String,Object> map){
        String name = map.get("name").toString();
        return typesserviceImpl.selectNameCount(name);
    }
}
