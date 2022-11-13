package com.stmanage.mapper;

import com.stmanage.api.BaseResponse;
import com.stmanage.entity.Applyactivitys;
import com.stmanage.entity.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActivityMapper {
    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where applyactivitys.state != 3 limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectApplyact(@Param("startIndex") int startIndex,
                                        @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys where applyactivitys.state != 3")
    int searchApplyactCount();

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.teamsname like CONCAT('%',#{community},'%') " +
            " and applyactivitys.state like CONCAT('%',#{value},'%') and applyactivitys.state != 3 " +
            " limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectCommunity(@Param("community") String community,
                                         @Param("value") String value,
                                         @Param("startIndex") int startIndex,
                                         @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.teamsname like CONCAT('%',#{community},'%')" +
            " and applyactivitys.state like CONCAT('%',#{value},'%') and applyactivitys.state != 3 ")
    int selectCommunityCount(@Param("community") String community,@Param("value") String value);

    @Update("update applyactivitys set state = 1 where actid = #{actid}")
    int updateState1(int actid);

    @Update("update applyactivitys set state = 2, refuse = #{refuse} where actid = #{actid}")
    int updateState2(@Param("actid") int actid,@Param("refuse") String refuse);

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where state = 1 limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectApplyact1(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys where state = 1")
    int searchApplyactCount1();

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.teamsname like CONCAT('%',#{community},'%') " +
            " and state = 1 limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectCommunity1(@Param("community") String community,
                                          @Param("startIndex") int startIndex,
                                          @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.teamsname like CONCAT('%',#{community},'%')" +
            " and state = 1")
    int selectCommunityCount1(String community);

    @Select("select users.name,users.phone,activitymembers.createtime as createtime from activitymembers " +
            " join users on activitymembers.userid = users.id where actid = #{actid}")
    List<Users> selectTakeMumber(int actid);

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.manager = #{manager} limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivityp(@Param("manager") int manager, @Param("startIndex") int startIndex,
                                         @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.manager = #{manager}")
    int searchActivitypCount(int manager);

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.manager = #{manager} and teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and applyactivitys.state like CONCAT('%',#{state},'%') limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivitypName(@Param("teamsname") String teamsname, @Param("state") String state,
                                             @Param("manager") int manager,
                                             @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where teams.manager = #{manager} and teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and applyactivitys.state like CONCAT('%',#{state},'%')")
    int selectActivitypNameCount(@Param("teamsname") String teamsname, @Param("state") String state,
                                 @Param("manager") int manager);

    @Insert("insert into applyactivitys(actname,actnumber,activitytime,details,teamid) " +
            " values(#{actname},#{actnumber},#{activitytime},#{details},#{teamid})")
    int insertActivityp(@Param("actname") String actname, @Param("actnumber") int actnumber,
                        @Param("details") String details, @Param("activitytime") String activitytime,
                        @Param("teamid") String teamid);

    @Delete("delete from applyactivitys where actid = #{actid}")
    int deleteActivityp(int actid);

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where state = 1 and teams.manager = #{manager} limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivityp1(@Param("manager") int manager,
                                          @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where state = 1 and teams.manager = #{manager}")
    int searchActivitypCount1(int manager);

    @Select("select applyactivitys.*,teams.teamsname as community,users.name as president from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where state = 1 and teams.manager = #{manager} " +
            " and teams.teamsname like CONCAT('%',#{teamsname},'%') limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivitypName1(@Param("manager") int manager, @Param("teamsname") String teamsname,
                                              @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id " +
            " join users on teams.manager = users.id where state = 1 and teams.manager = #{manager} " +
            " and teams.teamsname like CONCAT('%',#{teamsname},'%')")
    int selectActivitypNameCount1(@Param("manager") int manager, @Param("teamsname") String teamsname);

    @Update("update applyactivitys set state = 3 where actid = #{actid}")
    int updateActivitypState(int actid);

    @Select("select applyactivitys.actid,actname,teamsname,activitytime,count(activitymembers.actid) as alreadynum,actnumber,applyactivitys.details " +
            " from teammembers join applyactivitys on teammembers.teamid = applyactivitys.teamid " +
            " join teams on applyactivitys.teamid = teams.id left join activitymembers on applyactivitys.actid = activitymembers.actid " +
            " where applyactivitys.state = 1 and teammembers.userid = #{userid} GROUP BY activitymembers.actid limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivityStu(@Param("userid") int userid,
                                           @Param("startIndex") int startIndex,
                                           @Param("pageSize") int pageSize);

    @Select("select count(*) from teammembers join applyactivitys on teammembers.teamid = applyactivitys.teamid " +
            " where userid = #{userid} and state = 1")
    int searchActivityStuCount(int userid);

    @Select("select name,phone,activitymembers.createtime from activitymembers join users on activitymembers.userid = users.id where actid = #{actid}")
    List<Users> selectAlreadyMumber(int actid);

    @Select("select applyactivitys.actid,actname,teamsname,activitytime,count(activitymembers.actid) as alreadynum,actnumber,applyactivitys.details " +
            " from teammembers join applyactivitys on teammembers.teamid = applyactivitys.teamid " +
            " join teams on applyactivitys.teamid = teams.id left join activitymembers on applyactivitys.actid = activitymembers.actid " +
            " where applyactivitys.state = 1 and teammembers.userid = #{userid} and teamsname like CONCAT('%',#{teamsname},'%') " +
            " GROUP BY activitymembers.actid limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivityStuName(@Param("teamsname") String teamsname,
                                               @Param("userid") int userid,
                                               @Param("startIndex") int startIndex,
                                               @Param("pageSize") int pageSize);

    @Select("select count(*) from teammembers join applyactivitys on teammembers.teamid = applyactivitys.teamid " +
            "join teams on applyactivitys.teamid = teams.id where userid = #{userid} and state = 1 " +
            " and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectActivityStuNameCount(@Param("teamsname") String teamsname, @Param("userid") int userid);

    @Select("select count(*) from activitymembers where userid = #{userid} and actid = #{actid}")
    int selectIfActivity(@Param("actid") int actid, @Param("userid") int userid);

    @Insert("insert into activitymembers(userid,actid) values(#{userid},#{actid})")
    int insertAttend(@Param("actid") int actid, @Param("userid") int userid);

    @Select("select count(activitymembers.actid) as alreadynum,actnumber " +
            " from teammembers join applyactivitys on teammembers.teamid = applyactivitys.teamid " +
            " join teams on applyactivitys.teamid = teams.id left join activitymembers on applyactivitys.actid = activitymembers.actid " +
            " where applyactivitys.state = 1 and teammembers.userid = #{userid} and applyactivitys.actid = #{actid}")
    Applyactivitys selectActivityFull(@Param("actid") int actid, @Param("userid") int userid);

    @Select("select amid,applyactivitys.actid,actname,teamsname,activitytime,applyactivitys.details " +
            " from activitymembers join applyactivitys on activitymembers.actid = applyactivitys.actid " +
            " join teams on applyactivitys.teamid = teams.id where activitymembers.userid = #{userid}" +
            " limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivityStu1(@Param("userid") int userid,
                                            @Param("startIndex") int startIndex,
                                            @Param("pageSize") int pageSize);

    @Select("select count(*) from activitymembers join applyactivitys on activitymembers.actid = applyactivitys.actid " +
            " join teams on applyactivitys.teamid = teams.id where activitymembers.userid = #{userid}")
    int searchActivityStuCount1(int userid);

    @Select("select amid,applyactivitys.actid,actname,teamsname,activitytime,applyactivitys.details " +
            " from activitymembers join applyactivitys on activitymembers.actid = applyactivitys.actid " +
            " join teams on applyactivitys.teamid = teams.id where activitymembers.userid = #{userid}" +
            " and teamsname like CONCAT('%',#{teamsname},'%') limit #{startIndex},#{pageSize}")
    List<Applyactivitys> selectActivityStuName1(@Param("teamsname") String teamsname,
                                                @Param("userid") int userid,
                                                @Param("startIndex") int startIndex,
                                                @Param("pageSize") int pageSize);

    @Select("select count(*) from activitymembers join applyactivitys on activitymembers.actid = applyactivitys.actid " +
            " join teams on applyactivitys.teamid = teams.id where activitymembers.userid = #{userid}" +
            " and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectActivityStuNameCount1(@Param("teamsname") String teamsname, @Param("userid") int userid);

    @Select("select activitytime from activitymembers join applyactivitys on activitymembers.actid = applyactivitys.actid " +
            " where userid = #{userid} and applyactivitys.actid = #{actid}")
    Applyactivitys selectActivityTime(@Param("actid") int actid, @Param("userid") int userid);

    @Delete("delete from activitymembers where amid = #{amid}")
    int deleteAmidMem(int amid);

    @Select("select applyactivitys.actid,actname,actnumber,activitytime,applyactivitys.details,applyactivitys.teamid from applyactivitys " +
            " JOIN teams on applyactivitys.teamid = teams.id join users on teams.manager = users.id " +
            " where state = 1 and teams.manager = #{manager} and applyactivitys.actid = #{actid}")
    Applyactivitys selectActivitypOne(@Param("manager") int manager, @Param("actid") int actid);

    @Update("update applyactivitys set actname = #{actname},actnumber = #{actnumber},details=#{details},activitytime=#{activitytime}," +
            " teamid =#{teamid} where actid = #{actid}")
    int updateActivitypOne(int actid, String actname, int actnumber, String details, String activitytime, int teamid);
}
