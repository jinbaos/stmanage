package com.stmanage.controller;

import com.stmanage.entity.Users;
import com.stmanage.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersServiceImpl usersServiceImpl;

    @RequestMapping("/selectUsers")
    @ResponseBody
    public List<Users> selectUsers(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectUsers(pageNo,pageSize);
    }

    @RequestMapping("/searchUsersCount")
    @ResponseBody
    public int searchUsersCount(){
        return usersServiceImpl.searchUsersCount();
    }

    @RequestMapping("/updateUsersStatus")
    @ResponseBody
    public int updateUsersStatus(@RequestBody Map<String,Object> map){
        int status = Integer.parseInt(map.get("status").toString());
        int id = Integer.parseInt(map.get("id").toString());
        return usersServiceImpl.updateUsersStatus(status,id);
    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public int insertUsers(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String name = map.get("name").toString();
        String gender = map.get("gender").toString();
        int age = Integer.parseInt(map.get("age").toString());
        String phone = map.get("phone").toString();
        String address = map.get("address").toString();
        String type = map.get("type").toString();
        return usersServiceImpl.insertUsers(username,password,name,gender,age,phone,address,type);
    }

    @RequestMapping("/selectUsersId")
    @ResponseBody
    public Users selectUsersId(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        return usersServiceImpl.selectUsersId(id);
    }

    @RequestMapping("/editUsers")
    @ResponseBody
    public int editUsers(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String name = map.get("name").toString();
        String gender = map.get("gender").toString();
        int age = Integer.parseInt(map.get("age").toString());
        String phone = map.get("phone").toString();
        String address = map.get("address").toString();
        String type = map.get("type").toString();
//        String editime = map.get("editime").toString();
        return usersServiceImpl.editUsers(id,username,password,name,gender,age,phone,address,type);
    }

    @RequestMapping("/selectPhone")
    @ResponseBody
    public List<Users> selectPhone(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String name = map.get("name").toString();
        String phone = map.get("phone").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectPhone(username,name,phone,pageNo,pageSize);
    }

    @RequestMapping("/selectLogin")
    @ResponseBody
    public Users selectLogin(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String type = map.get("type").toString();
        return usersServiceImpl.selectLogin(username,password,type);
    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public int deleteUsers(@RequestBody List<Integer> ids){
        //删除
        if (!ids.isEmpty()){
            return usersServiceImpl.deleteUsers(ids);
        }else {
            return 0;
        }
    }

    @RequestMapping("searchPhoneCount")
    @ResponseBody
    public int searchPhoneCount(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String name = map.get("name").toString();
        String phone = map.get("phone").toString();
        return usersServiceImpl.searchPhoneCount(username,name,phone);
    }

    @RequestMapping("/selectMumbersp")
    @ResponseBody
    public List<Users> selectMumbersp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectMumbersp(manager,pageNo,pageSize);
    }

    @RequestMapping("/searchMumberspCount")
    @ResponseBody
    public int searchMumberspCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        return usersServiceImpl.searchMumberspCount(manager);
    }

    @RequestMapping("/selectMumberspName")
    @ResponseBody
    public List<Users> selectMumberspName(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        String id = map.get("id").toString();
        String name = map.get("name").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectMumberspName(manager,id,name,pageNo,pageSize);
    }

    @RequestMapping("/selectMumberspNameCount")
    @ResponseBody
    public int selectMumberspNameCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        String id = map.get("id").toString();
        String name = map.get("name").toString();
        return usersServiceImpl.selectMumberspNameCount(manager,id,name);
    }
    @RequestMapping("/selectHandlep")
    @ResponseBody
    public List<Users> selectHandlep(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectHandlep(manager,pageNo,pageSize);
    }
    @RequestMapping("/searchHandlepCount")
    @ResponseBody
    public int searchHandlepCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        return usersServiceImpl.searchHandlepCount(manager);
    }
    @RequestMapping("/selectHandlepName")
    @ResponseBody
    public List<Users> selectHandlepName(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        String state = map.get("state").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectHandlepName(manager,teamsname,name,state,pageNo,pageSize);
    }
    @RequestMapping("/selectHandlepNameCount")
    @ResponseBody
    public int selectHandlepNameCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("id").toString());
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        String state = map.get("state").toString();
        return usersServiceImpl.selectHandlepNameCount(manager,teamsname,name,state);
    }
    @RequestMapping("/selectQuiteamp")
    @ResponseBody
    public List<Users> selectQuiteamp(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectQuiteamp(manager,pageNo,pageSize);
    }
    @RequestMapping("/searchQuiteampCount")
    @ResponseBody
    public int searchQuiteampCount(@RequestBody Map<String,Object> map){
        int manager = Integer.parseInt(map.get("manager").toString());
        return usersServiceImpl.searchQuiteampCount(manager);
    }
    @RequestMapping("/selectQuiteampTitle")
    @ResponseBody
    public List<Users> selectQuiteampTitle(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        String state = map.get("state").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectQuiteampTitle(teamsname,name,state,manager,pageNo,pageSize);
    }
    @RequestMapping("/selectQuiteampCount")
    @ResponseBody
    public int selectQuiteampCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        String name = map.get("name").toString();
        String state = map.get("state").toString();
        int manager = Integer.parseInt(map.get("manager").toString());
        return usersServiceImpl.selectQuiteampCount(teamsname,name,state,manager);
    }
    @RequestMapping("/deleteMembers1")
    @ResponseBody
    public int deleteMembers1(@RequestBody Map<String,Object> map){
        int userid = Integer.parseInt(map.get("userid").toString());
        int teamid = Integer.parseInt(map.get("teamid").toString());
        int appid = Integer.parseInt(map.get("appid").toString());
        return usersServiceImpl.deleteMembers1(userid,teamid,appid);
    }
    @RequestMapping("/selectNameType")
    @ResponseBody
    public Users selectNameType(@RequestBody Map<String,Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        return usersServiceImpl.selectNameType(id);
    }

    @RequestMapping("/selectMumbers")
    @ResponseBody
    public List<Users> selectMumbers(@RequestBody Map<String,Object> map){
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectMumbers(pageNo,pageSize);
    }
    @RequestMapping("/searchMumbersCount")
    @ResponseBody
    public int searchMumbersCount(){
        return usersServiceImpl.searchMumbersCount();
    }
    @RequestMapping("/selectMumbersName")
    @ResponseBody
    public List<Users> selectMumbersName(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        return usersServiceImpl.selectMumbersName(teamsname,pageNo,pageSize);
    }
    @RequestMapping("/selectMumbersNameCount")
    @ResponseBody
    public int selectMumbersNameCount(@RequestBody Map<String,Object> map){
        String teamsname = map.get("teamsname").toString();
        return usersServiceImpl.selectMumbersNameCount(teamsname);
    }
    @RequestMapping("/deleteMumbers")
    @ResponseBody
    public int deleteMumbers(@RequestBody Map<String,Object> map){
        int tmid = Integer.parseInt(map.get("tmid").toString());
        return usersServiceImpl.deleteMumbers(tmid);
    }
}
