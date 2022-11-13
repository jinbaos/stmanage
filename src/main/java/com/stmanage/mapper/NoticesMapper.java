package com.stmanage.mapper;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Teams;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticesMapper {
    @Select("select noid,title,notices.detail,notices.createtime,teams.teamsname as teamsname,status from notices " +
            " join teams on notices.teamid = teams.id order by notices.createtime desc" +
            " limit #{startIndex},#{pageSize}")
    List<Notices> selectNotices(int startIndex, int pageSize);

    @Select("select count(*) from notices")
    int searchNoticesCount();

    @Select("select noid,title,notices.detail,notices.createtime,teams.teamsname as teamsname,status from notices " +
            " join teams on notices.teamid = teams.id where title like CONCAT('%',#{title},'%') " +
            " and teams.teamsname like CONCAT('%',#{teamsname},'%') order by notices.createtime desc limit #{startIndex},#{pageSize}")
    List<Notices> selectNoticesTitle(@Param("title") String title,
                                     @Param("teamsname") String teamsname,
                                     @Param("startIndex") int startIndex,
                                     @Param("pageSize") int pageSize);

    @Select("select count(*) from notices " +
            " join teams on notices.teamid = teams.id where title like CONCAT('%',#{title},'%') " +
            " and teams.teamsname like CONCAT('%',#{teamsname},'%') ")
    int selectNoticesCount(@Param("title") String title, @Param("teamsname") String teamsname);

    @Select("select id,teamsname from teams")
    List<Teams> selectPushTeams();

    @Insert("insert into notices(title,teamid,detail,status) values(#{title},#{teamid},#{detail},0)")
    int insertNotices(@Param("title") String title,
                      @Param("teamid") int teamid,
                      @Param("detail") String detail);

    @Delete("delete from notices where noid = #{noid}")
    int deleteNotices(int noid);


    @Select("select noid,title,notices.detail,notices.createtime,teams.teamsname as teamsname,status from notices " +
            " join teams on notices.teamid = teams.id where teams.manager = #{manager} or notices.teamid = 0" +
            " order by notices.createtime desc limit #{startIndex},#{pageSize}")
    List<Notices> selectNoticesp(@Param("manager") int manager, @Param("startIndex") int startIndex,
                                 @Param("pageSize") int pageSize);

    @Select("select count(*) from notices " +
            " join teams on notices.teamid = teams.id where teams.manager = #{manager} or notices.teamid = 0")
    int searchNoticespCount(int manager);

    @Select("select noid,title,notices.detail,notices.createtime,teams.teamsname as teamsname,status from notices " +
            " join teams on notices.teamid = teams.id where teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and status like CONCAT('%',#{status},'%') and (teams.manager = #{manager} or notices.teamid = 0)" +
            " order by notices.createtime desc limit #{startIndex},#{pageSize}")
    List<Notices> selectNoticespTitle(@Param("teamsname") String teamsname, @Param("status") String status,
                                      @Param("manager") int manager, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from notices " +
            " join teams on notices.teamid = teams.id where teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and status like CONCAT('%',#{status},'%') and (teams.manager = #{manager} or notices.teamid = 0)")
    int selectNoticespCount(@Param("teamsname") String teamsname, @Param("status") String status,
                            @Param("manager") int manager);

    @Insert("insert into notices(title,teamid,detail,status) values(#{title},#{teamid},#{detail},1)")
    int insertNoticesp(@Param("title") String title, @Param("teamid") int teamid, @Param("detail") String detail);

    @Select("select noid,title,teamsname,notices.createtime,notices.detail,status from teammembers " +
            " right join notices on teammembers.teamid = notices.teamid join teams on notices.teamid = teams.id " +
            " where teammembers.userid = #{userid} or notices.teamid = 0 order by notices.createtime desc limit #{startIndex},#{pageSize}")
    List<Notices> selectNoticestu(@Param("userid") int userid,
                                  @Param("startIndex") int startIndex,
                                  @Param("pageSize") int pageSize);
    @Select("select count(*) from teammembers right join notices on teammembers.teamid = notices.teamid " +
            " join teams on notices.teamid = teams.id where teammembers.userid = #{userid} or notices.teamid = 0 ")
    int searchNoticestuCount(int userid);

    @Select("select noid,title,teamsname,notices.createtime,notices.detail,status from teammembers " +
            " right join notices on teammembers.teamid = notices.teamid join teams on notices.teamid = teams.id " +
            " where teamsname like CONCAT('%',#{teamsname},'%') and status like CONCAT('%',#{status},'%') " +
            " and (teammembers.userid = #{userid} or notices.teamid = 0) order by notices.createtime desc limit #{startIndex},#{pageSize}")
    List<Notices> selectNoticestuTitle(@Param("teamsname") String teamsname,
                                       @Param("status") String status,
                                       @Param("userid") int userid,
                                       @Param("startIndex") int startIndex,
                                       @Param("pageSize") int pageSize);
    @Select("select count(*) from teammembers " +
            " right join notices on teammembers.teamid = notices.teamid join teams on notices.teamid = teams.id " +
            " where teamsname like CONCAT('%',#{teamsname},'%') and status like CONCAT('%',#{status},'%') " +
            " and (teammembers.userid = #{userid} or notices.teamid = 0)")
    int selectNoticestuCount(@Param("teamsname") String teamsname,
                             @Param("status") String status,
                             @Param("userid") int userid);
}
