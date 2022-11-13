package com.stmanage.mapper;

import com.stmanage.entity.TeamTypes;
import com.stmanage.entity.Teams;
import com.stmanage.entity.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamsMapper {
    @Select("select teams.*,count(teammembers.teamid) as alreadynum,users.name as president,teamtypes.name as typesname from users " +
            " right join teams on users.id = teams.manager left " +
            " join teamtypes on teams.typeid = teamtypes.id left join teammembers on teams.id = teammembers.teamid" +
            " where teams.id != 0 GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectTeams(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    @Select("select count(*) from Teams")
    int searchCount();

    @Insert("insert into Teams(teamsname,number,manager,typeid,details) values(#{teamsname},#{number},#{manager},#{typeid},#{details})")
    int insertTeams(String teamsname, int number, int manager, int typeid, String details);

    @Delete("delete from Teams where id = #{id}")
    int deleteTeams(int id);

    @Select("select * from Teams where id = #{id}")
    Teams selectTeamId(int id);

    @Update("update Teams set teamsname = #{teamsname},number = #{number},manager = #{manager},typeid = #{typeid},details = #{details}" +
            " where id = #{id}")
    int editTeams(@Param("id") int id,
                    @Param("teamsname") String teamsname,
                    @Param("number") int number,
                    @Param("manager") int manager,
                    @Param("typeid") int typeid,
                    @Param("details") String details);

    @Select("select teams.*,count(teammembers.teamid) as alreadynum,users.name as president,teamtypes.name as typesname from users " +
            " right join teams on users.id = teams.manager left " +
            " join teamtypes on teams.typeid = teamtypes.id left join teammembers on teams.id = teammembers.teamid where teamsname like CONCAT('%',#{teamsname},'%') " +
            " and teamtypes.name like CONCAT('%',#{name},'%') GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectTeamsName(@Param("teamsname") String teamsname,
                                @Param("name") String name,
                                @Param("startIndex") int startIndex,
                                @Param("pageSize") int pageSize);

    @Select("select count(*) from users " +
            " right join teams on users.id = teams.manager left " +
            " join teamtypes on teams.typeid = teamtypes.id where teamsname like CONCAT('%',#{teamsname},'%') " +
            " and teamtypes.name like CONCAT('%',#{name},'%') ")
    int searchNameCount(@Param("teamsname") String teamsname,
                        @Param("name") String name);

    @Select("select id,name from Users")
    List<Users> selectPresident();

    @Select("select id,name from TeamTypes")
    List<TeamTypes> selectPreTypes();

    @Select("select id,teamsname from teams where manager = #{manager}")
    List<Teams> selectSTName(int manager);

    @Insert("insert into teammembers(userid,teamid) values(#{userid},#{teamid})")
    int insertMembers(@Param("userid") int userid, @Param("teamid") int teamid);

    @Update("update applyteams set state = 1 where appid = #{appid}")
    int updateApplyState(int appid);

    @Select("select teams.id,teams.teamsname,count(teammembers.teamid) as alreadynum,teams.number,users.phone,users.name as president,teams.details " +
            " from users right join teams on users.id = teams.manager left join teamtypes on teams.typeid = teamtypes.id " +
            " left join teammembers on teams.id = teammembers.teamid where teams.id != 0 " +
            " and teams.id not in (select teamid from teammembers where userid = #{userid}) GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectTeamStu(@Param("userid") int userid, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from teams where teams.id != 0 and id not in (select teamid from teammembers where userid = #{userid})")
    int searchTeamStuCount(int userid);

    @Insert("insert into applyteams(userid,teamid,state) values(#{userid},#{teamid},0)")
    int applyTeamStu(int userid,int teamid);

    @Select("select count(*) from applyteams where userid = #{userid} and teamid = #{teamid} and state = 0")
    int selectApplyCount(@Param("userid") int userid,@Param("teamid") int teamid);

    @Delete("delete from applyteams where userid = #{userid} and teamid = #{teamid} and state = 0")
    int deleteApplyCount(@Param("userid") int userid,@Param("teamid") int teamid);

    @Select("select id,teamsname from teams where id != 0")
    List<Teams> selectAllTeam();

    @Select("select teams.id,teams.teamsname,count(teammembers.teamid) as alreadynum,teams.number,users.phone,users.name as president,teams.details " +
            " from users right join teams on users.id = teams.manager left join teamtypes on teams.typeid = teamtypes.id " +
            " left join teammembers on teams.id = teammembers.teamid where teams.id != 0 and teams.teamsname like CONCAT('%',#{teamsname},'%')" +
            " and teams.id not in (select teamid from teammembers where userid = #{userid}) GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectTeamStuName(@Param("teamsname") String teamsname, @Param("userid") int userid,
                                  @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from teams where teamsname like CONCAT('%',#{teamsname},'%') and teams.id != 0 and id not in (select teamid from teammembers where userid = #{userid})")
    int selectTeamStuNameCount(@Param("teamsname") String teamsname, @Param("userid") int userid);

    @Select("select appid as id,teams.teamsname,users.name as president,users.phone,applyteams.state,applyteams.createtime from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and (applyteams.state = 0 or applyteams.state = 1) limit #{startIndex},#{pageSize}")
    List<Teams> selectTeamStu1(@Param("userid") int userid, @Param("startIndex") int startIndex,
                               @Param("pageSize") int pageSize);

    @Select("select count(*) from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and (applyteams.state = 0 or applyteams.state = 1)")
    int searchTeamStuCount1(int userid);

    @Delete("delete from applyteams where appid = #{appid}")
    int deleteApplyState1(int appid);

    @Select("select appid as id,teams.teamsname,users.name as president,users.phone,applyteams.state,applyteams.createtime from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and (applyteams.state = 0 or applyteams.state = 1) limit #{startIndex},#{pageSize}")
    List<Teams> selectTeamStuName1(@Param("teamsname") String teamsname, @Param("userid") int userid,
                                   @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and (applyteams.state = 0 or applyteams.state = 1)")
    int selectTeamStuNameCount1(@Param("teamsname") String teamsname, @Param("userid") int userid);

    @Select("select teams.id,teams.teamsname from teams join teammembers on teams.id = teammembers.teamid " +
            " where teammembers.userid = #{userid}")
    List<Teams> selectExitTeamName(int userid);


    @Select("select teams.id,teams.teamsname,count(teammembers.teamid) as alreadynum,teams.number,users.phone,users.name as president,teams.details " +
            " from users right join teams on users.id = teams.manager left join teamtypes on teams.typeid = teamtypes.id " +
            " left join teammembers on teams.id = teammembers.teamid where teams.id != 0 " +
            " and teams.id in (select teamid from teammembers where userid = #{userid}) GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectQuitTeam(@Param("userid") int userid, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from teams join teammembers on teams.id = teammembers.teamid " +
            " where teammembers.userid = #{userid}")
    int searchQuitTeamCount(int userid);

    @Insert("insert into applyteams(userid,teamid,exitstate) values(#{userid},#{teamid},0)")
    int quitApply(@Param("teamid") int teamid, @Param("userid") int userid);

    @Select("select count(*) from applyteams where userid = #{userid} and teamid = #{teamid} and exitstate = 0")
    int selectQuitApplyCount(@Param("teamid") int teamid, @Param("userid") int userid);

    @Delete("delete from applyteams where userid = #{userid} and teamid = #{teamid} and exitstate = 0")
    int deleteQuitApplyCount(@Param("teamid") int teamid, @Param("userid") int userid);



    @Select("select teams.id,teams.teamsname,count(teammembers.teamid) as alreadynum,teams.number,users.phone,users.name as president,teams.details " +
            " from users right join teams on users.id = teams.manager left join teamtypes on teams.typeid = teamtypes.id " +
            " left join teammembers on teams.id = teammembers.teamid where teams.id != 0 and teams.teamsname like CONCAT('%',#{teamsname},'%')" +
            " and teams.id in (select teamid from teammembers where userid = #{userid}) GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectQuitTeamName(@Param("teamsname") String teamsname, @Param("userid") int userid,
                                   @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from teams where teamsname like CONCAT('%',#{teamsname},'%') and teams.id != 0 and id in (select teamid from teammembers where userid = #{userid})")
    int selectQuitTeamNameCount(@Param("teamsname") String teamsname, @Param("userid") int userid);


    @Select("select appid as id,teams.teamsname,users.name as president,users.phone,applyteams.exitstate as state,applyteams.createtime from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and (applyteams.exitstate = 0 or applyteams.exitstate = 1) limit #{startIndex},#{pageSize}")
    List<Teams> selectQuitTeam1(@Param("userid") int userid, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and (applyteams.exitstate = 0 or applyteams.exitstate = 1)")
    int searchQuitTeamCount1(int userid);

    @Select("select appid as id,teams.teamsname,users.name as president,users.phone,applyteams.exitstate as state,applyteams.createtime from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and (applyteams.exitstate = 0 or applyteams.exitstate = 1) limit #{startIndex},#{pageSize}")
    List<Teams> selectQuitTeamName1(@Param("teamsname") String teamsname, @Param("userid") int userid,
                                    @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyteams " +
            " join teams on applyteams.teamid = teams.id join users on teams.manager = users.id " +
            " where applyteams.userid = #{userid} and teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and (applyteams.exitstate = 0 or applyteams.exitstate = 1)")
    int selectQuitTeamNameCount1(@Param("teamsname") String teamsname, @Param("userid") int userid);

    @Select("select teams.id,teams.teamsname from teams left join teammembers on teams.id = teammembers.teamid " +
            " where teammembers.userid = #{userid} or teams.id = 0")
    List<Teams> selectSystemNo(int userid);

    @Select("select id,teamsname from teams where manager = #{manager} or id = 0")
    List<Teams> selectSTName1(int manager);

    @Select("select teams.*,teams.total,count(teammembers.teamid) as alreadynum,users.name as president,teamtypes.name as typesname from users " +
            " right join teams on users.id = teams.manager left " +
            " join teamtypes on teams.typeid = teamtypes.id left join teammembers on teams.id = teammembers.teamid" +
            " where teams.id != 0 and manager = #{manager} GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectTeamsInfosp(@Param("manager") int manager, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from Teams where manager = #{manager}")
    int searchTeamsInfospCount(int manager);

    @Select("select teams.*,teams.total,count(teammembers.teamid) as alreadynum,users.name as president,teamtypes.name as typesname from users " +
            " right join teams on users.id = teams.manager left " +
            " join teamtypes on teams.typeid = teamtypes.id left join teammembers on teams.id = teammembers.teamid" +
            " where teams.id != 0 and manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%') " +
            " GROUP BY teams.id limit #{startIndex},#{pageSize}")
    List<Teams> selectInforspName(@Param("teamsname") String teamsname,
                                  @Param("manager") int manager,
                                  @Param("startIndex") int startIndex,
                                  @Param("pageSize") int pageSize);

    @Select("select count(*) from Teams where manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectInforspNameCount(@Param("teamsname") String teamsname,
                               @Param("manager") int manager);

    @Select("select count(*) from applyactivitys join activitymembers on applyactivitys.actid = activitymembers.actid " +
            " where userid = #{userid} and applyactivitys.state = 1")
    int selectActivityCount(int userid);

    @Select("select id,name from users where type = '成员'")
    List<Users> selectTeamNum();

    @Select("select 1 from teammembers where userid = #{userid} and teamid = #{teamid} limit 1")
    Integer selectNumCount(@Param("teamid") int teamid, @Param("userid") int userid);

    @Insert("insert into teammembers(userid,teamid) values(#{userid},#{teamid})")
    Integer addUsers(@Param("teamid") int teamid, @Param("userid") int userid);
}

