package com.stmanage.mapper;

import com.stmanage.entity.TemplateId;
import com.stmanage.entity.Users;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersMapper {
    @Select("select * from Users limit #{startIndex},#{pageSize}")
    List<Users> selectUsers(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    @Update("update Users set status = #{status} where id = #{id}")
    int updateUsersStatus(@Param("status") int status,
                          @Param("id") int id);

    @Insert("Insert into Users(username,password,name,gender,age,phone,address,type) " +
            " values(#{username},#{password},#{name},#{gender},#{age},#{phone},#{address},#{type})")
    int insertUsers(@Param("username") String username,
                    @Param("password") String password,
                    @Param("name") String name,
                    @Param("gender") String gender,
                    @Param("age") int age,
                    @Param("phone") String phone,
                    @Param("address") String address,
                    @Param("type") String type);

    @Select("select * from Users where id = #{id}")
    Users selectUsersId(@Param("id") int id);


    @Update("update Users set username = #{username}, password= #{password}, name= #{name}, gender= #{gender}, age= #{age}, " +
            " phone= #{phone}, address= #{address}, type= #{type}, updateTime= #{updateTime} where id= #{id}")
    int editUsers(@Param("id") int id,
                  @Param("username") String username,
                  @Param("password") String password,
                  @Param("name") String name,
                  @Param("gender") String gender,
                  @Param("age") int age,
                  @Param("phone") String phone,
                  @Param("address") String address,
                  @Param("type") String type,
                  @Param("updateTime") String updateTime);

    @Select("select * from Users where username like CONCAT('%',#{username},'%') " +
            " and name like CONCAT('%',#{name},'%')" +
            " and phone like CONCAT('%',#{phone},'%') limit #{startIndex},#{pageSize}")
    List<Users> selectPhone(@Param("username") String username,
                            @Param("name") String name,
                            @Param("phone") String phone,
                            @Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    @Select("select count(*) as number,id,status from Users where username= #{username} and password= #{password} and type= #{type}")
    Users selectLogin(@Param("username") String username,
                      @Param("password") String password,
                      @Param("type") String type);


    int deleteUsers(List<Integer> ids);

    @Select("select count(*) from Users")
    int searchUsersCount();

    @Select("select count(*) from Users where username like CONCAT('%',#{username},'%') " +
            " and name like CONCAT('%',#{name},'%')" +
            " and phone like CONCAT('%',#{phone},'%')")
    int searchPhoneCount(@Param("username") String username,
                         @Param("name") String name,
                         @Param("phone") String phone);

    @Select("select tmid,teams.teamsname,teammembers.createtime,users.name,gender,age,phone " +
            " from teammembers join users on teammembers.userid = users.id join teams on teammembers.teamid = teams.id " +
            " where manager = #{manager} limit #{startIndex},#{pageSize}")
    List<Users> selectMumbersp(@Param("manager") int manager,
                               @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) " +
            " from teammembers join users on teammembers.userid = users.id join teams on teammembers.teamid = teams.id " +
            " where manager = #{manager}")
    int searchMumberspCount(int manager);

    @Select("select tmid,teams.teamsname,teammembers.createtime,users.name,gender,age,phone " +
            " from teammembers join users on teammembers.userid = users.id join teams on teammembers.teamid = teams.id " +
            " where manager = #{manager} and teams.id like CONCAT('%',#{id},'%') and users.name like CONCAT('%',#{name},'%') limit #{startIndex},#{pageSize}")
    List<Users> selectMumberspName(@Param("manager") int manager,@Param("id") String id,
                                   @Param("name") String name, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*)" +
            " from teammembers join users on teammembers.userid = users.id join teams on teammembers.teamid = teams.id " +
            " where manager = #{manager} and teams.id like CONCAT('%',#{id},'%') and users.name like CONCAT('%',#{name},'%')")
    int selectMumberspNameCount(@Param("manager") int manager,@Param("id") String id, @Param("name") String name);


    @Select("select appid as id,applyteams.userid,applyteams.teamid,teamsname,users.name,gender,phone,applyteams.createtime,applyteams.state " +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and (applyteams.state = 0 or applyteams.state = 1) limit #{startIndex},#{pageSize}")
    List<Users> selectHandlep(@Param("manager") int manager, @Param("startIndex") int startIndex,
                              @Param("pageSize") int pageSize);

    @Select("select count(*)" +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and (applyteams.state = 0 or applyteams.state = 1)")
    int searchHandlepCount(int manager);

    @Select("select appid as id,applyteams.userid,applyteams.teamid,teamsname,users.name,gender,phone,applyteams.createtime,applyteams.state " +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%') and users.name like CONCAT('%',#{name},'%') " +
            " and applyteams.state like CONCAT('%',#{state},'%') limit #{startIndex},#{pageSize}")
    List<Users> selectHandlepName(@Param("manager") int manager, @Param("teamsname") String teamsname,
                                  @Param("name") String name, @Param("state") String state,
                                  @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*)" +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%') and users.name like CONCAT('%',#{name},'%') " +
            " and applyteams.state like CONCAT('%',#{state},'%')")
    int selectHandlepNameCount(@Param("manager") int manager, @Param("teamsname") String teamsname,
                               @Param("name") String name, @Param("state") String state);


    @Select("select appid as id,applyteams.userid,applyteams.teamid,teamsname,users.name,gender,phone,applyteams.createtime,applyteams.exitstate as state" +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and (applyteams.exitstate = 0 or applyteams.exitstate = 1) limit #{startIndex},#{pageSize}")
    List<Users> selectQuiteamp(int manager, int startIndex, int pageSize);

    @Select("select count(*)" +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and (applyteams.exitstate = 0 or applyteams.exitstate = 1)")
    int searchQuiteampCount(int manager);

    @Select("select appid as id,applyteams.userid,applyteams.teamid,teamsname,users.name,gender,phone,applyteams.createtime,applyteams.exitstate as state " +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%') and users.name like CONCAT('%',#{name},'%') " +
            " and applyteams.exitstate like CONCAT('%',#{state},'%') limit #{startIndex},#{pageSize}")
    List<Users> selectQuiteampTitle(@Param("teamsname") String teamsname,
                                    @Param("name") String name,
                                    @Param("state") String state,
                                    @Param("manager") int manager,
                                    @Param("startIndex") int startIndex,
                                    @Param("pageSize") int pageSize);

    @Select("select count(*)" +
            " from applyteams join users on applyteams.userid = users.id join teams on applyteams.teamid = teams.id " +
            " where manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%') and users.name like CONCAT('%',#{name},'%') " +
            " and applyteams.exitstate like CONCAT('%',#{state},'%')")
    int selectQuiteampCount(@Param("teamsname") String teamsname,
                            @Param("name") String name,
                            @Param("state") String state,
                            @Param("manager") int manager);

    @Delete("delete from teammembers where userid = #{userid} and teamid = #{teamid}")
    int deleteMembers1(@Param("userid") int userid, @Param("teamid") int teamid);

    @Update("update applyteams set exitstate = 1 where appid = #{appid}")
    int updateExitstate(int appid);

    @Select("select name,type from users where id = #{id}")
    Users selectNameType(int id);

    @Select("select tmid,teamsname,teammembers.createtime,name,gender,age,phone from teams " +
            " join teammembers on teams.id = teammembers.teamid join users on teammembers.userid = users.id limit #{startIndex},#{pageSize}")
    List<Users> selectMumbers(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from teams " +
            " join teammembers on teams.id = teammembers.teamid join users on teammembers.userid = users.id")
    int searchMumbersCount();

    @Select("select tmid,teamsname,teammembers.createtime,name,gender,age,phone from teams " +
            " join teammembers on teams.id = teammembers.teamid join users on teammembers.userid = users.id " +
            " where teamsname like CONCAT('%',#{teamsname},'%') limit #{startIndex},#{pageSize}")
    List<Users> selectMumbersName(@Param("teamsname") String teamsname,
                                  @Param("startIndex") int startIndex,
                                  @Param("pageSize") int pageSize);

    @Select("select count(*) from teams join teammembers on teams.id = teammembers.teamid " +
            " join users on teammembers.userid = users.id where teamsname like CONCAT('%',#{teamsname},'%')")
    int selectMumbersNameCount(String teamsname);

    @Delete("delete from teammembers where tmid = #{tmid}")
    int deleteMumbers(int tmid);

    @Select("select userid,teamid from teammembers where tmid = #{tmid}")
    TemplateId selectId(int tmid);

    @Select("select actid from applyactivitys where teamid = #{teamid}")
    List<TemplateId> selectActid(int teamid);

    @Delete("delete from activitymembers where userid = #{userid} and actid = #{actid}")
    int deleteActNum(@Param("userid") int userid, @Param("actid") int actid);
}
