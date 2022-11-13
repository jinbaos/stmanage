package com.stmanage.mapper;

import com.stmanage.entity.Notices;
import com.stmanage.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IndexMapper {
    @Select("select count(*)-1 from teams")
    int selectTeamNums();

    @Select("select count(*) from teammembers join applyactivitys on teammembers.teamid = applyactivitys.teamid " +
            " where userid = #{userid} and state = 1")
    int selectActivityNums(int userid);

    @Select("select count(*) from teammembers right join notices on teammembers.teamid = notices.teamid " +
            " where userid = #{userid} or notices.teamid = 0")
    int selectNoticeNums(int userid);

    @Select("select title,notices.createtime,notices.detail from teammembers " +
            " right join notices on teammembers.teamid = notices.teamid join teams on notices.teamid = teams.id " +
            " where teammembers.userid = #{userid} or notices.teamid = 0 order by notices.createtime desc limit 0,1")
    Notices selectNotice1(int userid);

    @Select("select title,notices.createtime,notices.detail from teammembers " +
            " right join notices on teammembers.teamid = notices.teamid join teams on notices.teamid = teams.id " +
            " where teammembers.userid = #{userid} or notices.teamid = 0 order by notices.createtime desc limit 1,1")
    Notices selectNotice2(int userid);

    @Select("select username,password,name,gender,age,phone,address from users where id = #{userid}")
    Users selectUserinfor(int userid);

    @Update("update users set username = #{username},password = #{password},name = #{name},gender = #{gender}," +
            " age = #{age},phone = #{phone},address = #{address} where id = #{id}")
    int updateUserInfo(@Param("username") String username,
                       @Param("password") String password,
                       @Param("name") String name,
                       @Param("gender") String gender,
                       @Param("age") int age,
                       @Param("phone") String phone,
                       @Param("address") String address,
                       @Param("id") int id);

    @Select("select title,notices.detail,notices.createtime from notices " +
            " join teams on notices.teamid = teams.id where teams.manager = #{manager} or notices.teamid = 0" +
            " order by notices.createtime desc limit 0,1")
    Notices selectNotices1(int manager);

    @Select("select title,notices.detail,notices.createtime from notices " +
            " join teams on notices.teamid = teams.id where teams.manager = #{manager} or notices.teamid = 0" +
            " order by notices.createtime desc limit 1,1")
    Notices selectNotices2(int manager);
}
