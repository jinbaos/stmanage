package com.stmanage.mapper;

import com.stmanage.entity.Paylogs;
import com.stmanage.entity.Payment;
import com.stmanage.entity.Teams;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface PaylogsMapper {
    @Select("select teams.teamsname,paylogs.title,users.name,users.gender,users.phone,paylogs.createtime,paylogs.total,paylogs.details " +
            " from paylogs join teammembers on paylogs.tmid = teammembers.tmid join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPayLogs(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teammembers on paylogs.tmid = teammembers.tmid " +
            " join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id")
    int searchPayLogsCount();

    @Select("select teams.teamsname,paylogs.title,users.name,users.gender,users.phone,paylogs.createtime,paylogs.total,paylogs.details " +
            " from paylogs join teammembers on paylogs.tmid = teammembers.tmid join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id where teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and users.name like CONCAT('%',#{name},'%') order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPaylogsName(@Param("teamsname") String teamsname,
                                    @Param("name") String name,
                                    @Param("startIndex") int startIndex,
                                    @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teammembers on paylogs.tmid = teammembers.tmid " +
            " join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id where teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and users.name like CONCAT('%',#{name},'%')")
    int selectPaylogsNameCount(@Param("teamsname") String teamsname,
                               @Param("name") String name);

    @Select("select teams.teamsname, users.name,users.gender,users.phone,paylogs.createtime,paylogs.total,paylogs.details,teams.total as remaintotal " +
            " from paylogs join teams on paylogs.teamid = teams.id join users on teams.manager = users.id" +
            " order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPayLogs1(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teams on paylogs.teamid = teams.id " +
            " join users on teams.manager = users.id")
    int searchPayLogsCount1();

    @Select("select teams.teamsname, users.name,users.gender,users.phone,paylogs.createtime,paylogs.total,paylogs.details,teams.total as remaintotal " +
            " from paylogs join teams on paylogs.teamid = teams.id join users on teams.manager = users.id" +
            " where teams.teamsname like CONCAT('%',#{teamsname},'%') order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPaylogsName1(@Param("teamsname") String teamsname,
                                     @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teams on paylogs.teamid = teams.id join users on teams.manager = users.id" +
            " where teams.teamsname like CONCAT('%',#{teamsname},'%')")
    int selectPaylogsNameCount1(String teamsname);

    @Select("select teams.teamsname,users.name,users.gender,users.phone,paylogs.createtime,paylogs.total,paylogs.details " +
            " from paylogs right join teammembers on paylogs.tmid = teammembers.tmid join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id where teams.manager = #{manager} limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPayLogsp(@Param("manager") int manager, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


    @Select("select count(*) from paylogs right join teammembers on paylogs.tmid = teammembers.tmid " +
            " join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id where teams.manager = #{manager}")
    int searchPayLogspCount(int manager);

    @Select("select teams.teamsname,users.name,users.gender,users.phone,paylogs.createtime,paylogs.total,paylogs.details " +
            " from paylogs right join teammembers on paylogs.tmid = teammembers.tmid join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id where teams.teamsname like CONCAT('%',#{teamsname},'%') and " +
            " teams.manager = #{manager} limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPaylogspName(@Param("teamsname") String teamsname,
                                     @Param("manager") int manager, @Param("startIndex") int startIndex,
                                     @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs right join teammembers on paylogs.tmid = teammembers.tmid " +
            " join users on teammembers.userid = users.id " +
            " join teams on teammembers.teamid = teams.id where teams.teamsname like CONCAT('%',#{teamsname},'%') " +
            " and teams.manager = #{manager}")
    int selectPaylogspNameCount(@Param("teamsname") String teamsname, @Param("manager") int manager);


    @Select("select payid,teams.teamsname, paylogs.createtime,paylogs.total,paylogs.details,teams.total as remaintotal " +
            " from paylogs join teams on paylogs.teamid = teams.id where teams.manager = #{manager} " +
            " order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPayLogsp1(@Param("manager") int manager, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teams on paylogs.teamid = teams.id " +
            " where teams.manager = #{manager}")
    int searchPayLogspCount1(int manager);

    @Insert("insert into paylogs(total,details,teamid) values(#{total},#{details},#{teamid})")
    int addPayLogsp1(@Param("teamid") int teamid, @Param("total") int total, @Param("details") String details);

    @Select("select payid,teams.teamsname, paylogs.createtime,paylogs.total,paylogs.details,teams.total as remaintotal " +
            " from paylogs join teams on paylogs.teamid = teams.id where teams.manager = #{manager} " +
            " and teams.teamsname like CONCAT('%',#{teamsname},'%') order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPaylogspName1(@Param("teamsname") String teamsname, @Param("manager") int manager,
                                      @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teams on paylogs.teamid = teams.id where teams.manager = #{manager} " +
            " and teams.teamsname like CONCAT('%',#{teamsname},'%')")
    int selectPaylogspNameCount1(@Param("teamsname") String teamsname, @Param("manager") int manager);

    @Delete("delete from paylogs where payid = #{payid}")
    int deletePayLogsp1(int payid);

    @Select("select pmid,tmid,title,teamsname,payment.total,payment.createtime,payment.details from teammembers " +
            " join payment on teammembers.teamid = payment.teamid join teams on payment.teamid = teams.id " +
            " where pmid not in (select pmid from paylogs join teammembers on paylogs.tmid = teammembers.tmid where userid = #{userid}) " +
            " and userid = #{userid} order by payment.createtime desc limit #{startIndex},#{pageSize}")
    List<Payment> selectPayment(@Param("userid") int userid,
                                @Param("startIndex") int startIndex,
                                @Param("pageSize") int pageSize);

    @Select("select count(*) from teammembers " +
            " join payment on teammembers.teamid = payment.teamid join teams on payment.teamid = teams.id " +
            " where pmid not in (select pmid from paylogs join teammembers on paylogs.tmid = teammembers.tmid where userid = #{userid}) " +
            " and userid = #{userid}")
    int searchPaymentCount(int userid);

    @Select("select pmid,tmid,title,teamsname,payment.total,payment.createtime,payment.details from teammembers " +
            " join payment on teammembers.teamid = payment.teamid join teams on payment.teamid = teams.id " +
            " where pmid not in (select pmid from paylogs join teammembers on paylogs.tmid = teammembers.tmid where userid = #{userid}) " +
            " and userid = #{userid} and teamsname like CONCAT('%',#{teamsname},'%') order by payment.createtime desc limit #{startIndex},#{pageSize}")
    List<Payment> selectPaymentName(@Param("teamsname") String teamsname,
                                    @Param("userid") int userid,
                                    @Param("startIndex") int startIndex,
                                    @Param("pageSize") int pageSize);

    @Select("select count(*) from teammembers " +
            " join payment on teammembers.teamid = payment.teamid join teams on payment.teamid = teams.id " +
            " where pmid not in (select pmid from paylogs join teammembers on paylogs.tmid = teammembers.tmid where userid = #{userid}) " +
            " and userid = #{userid} and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectPaymentNameCount(@Param("teamsname") String teamsname,
                               @Param("userid") int userid);

    @Insert("insert into paylogs(title,total,details,tmid,pmid) values(#{title},#{total},#{details},#{tmid},#{pmid})")
    int insertPaylogs(@Param("title") String title,
                      @Param("total") int total,
                      @Param("details") String details,
                      @Param("tmid") int tmid,
                      @Param("pmid") int pmid);

    @Select("select payid,title,teamsname,paylogs.total,paylogs.createtime,paylogs.details from paylogs " +
            " join teammembers on paylogs.tmid = teammembers.tmid join teams on teammembers.teamid = teams.id " +
            " where teammembers.userid = #{userid} order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectRecord1(@Param("userid") int userid,
                                @Param("startIndex") int startIndex,
                                @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs " +
            " join teammembers on paylogs.tmid = teammembers.tmid join teams on teammembers.teamid = teams.id " +
            " where teammembers.userid = #{userid}")
    int searchRecordCount1(int userid);

    @Select("select payid,title,teamsname,paylogs.total,paylogs.createtime,paylogs.details from paylogs " +
            " join teammembers on paylogs.tmid = teammembers.tmid join teams on teammembers.teamid = teams.id " +
            " where teammembers.userid = #{userid} and teamsname like CONCAT('%',#{teamsname},'%') " +
            " order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectRecordName1(@Param("teamsname") String teamsname,
                                    @Param("userid") int userid,
                                    @Param("startIndex") int startIndex,
                                    @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs " +
            " join teammembers on paylogs.tmid = teammembers.tmid join teams on teammembers.teamid = teams.id " +
            " where teammembers.userid = #{userid} and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectRecordNameCount1(@Param("teamsname") String teamsname,
                               @Param("userid") int userid);

    @Update("update teams set total = total + #{total} where id in (select teamid from payment where pmid = #{pmid})")
    int updateTeamTotal(@Param("total") int total, @Param("pmid") int pmid);

    @Select("select pmid,title,teamsname,payment.createtime,payment.total,payment.details from payment " +
            " join teams on payment.teamid = teams.id where manager = #{manager} order by payment.createtime desc limit #{startIndex},#{pageSize}")
    List<Payment> selectPaymentp(int manager, int startIndex, int pageSize);

    @Select("select count(*) from payment join teams on payment.teamid = teams.id where manager = #{manager}")
    int searchPaymentpCount(int manager);

    @Select("select pmid,title,teamsname,payment.createtime,payment.total,payment.details from payment " +
            " join teams on payment.teamid = teams.id where manager = #{manager} " +
            " and teamsname like CONCAT('%',#{teamsname},'%') order by payment.createtime desc limit #{startIndex},#{pageSize}")
    List<Payment> selectPaymentpName(@Param("teamsname") String teamsname,
                                     @Param("manager") int manager,
                                     @Param("startIndex") int startIndex,
                                     @Param("pageSize") int pageSize);

    @Select("select count(*) from payment join teams on payment.teamid = teams.id where manager = #{manager}" +
            " and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectPaymentpNameCount(@Param("teamsname") String teamsname,
                                @Param("manager") int manager);

    @Insert("insert into payment(title,total,details,teamid) values(#{title},#{total},#{details},#{teamid})")
    int insertPaymentp(@Param("title") String title,
                       @Param("teamid") int teamid,
                       @Param("total") int total,
                       @Param("details") String details);

    @Select("select count(*) from paylogs where pmid = #{pmid}")
    int selectSearch(int pmid);

    @Delete("delete from payment where pmid = #{pmid}")
    int deletePaymentp(int pmid);

    @Select("select payment.title,teamsname,name,gender,phone,paylogs.createtime,paylogs.total,paylogs.details " +
            " from teams join teammembers on teams.id = teammembers.teamid join users on teammembers.userid = users.id " +
            " join paylogs on teammembers.tmid = paylogs.tmid join payment on paylogs.pmid = payment.pmid " +
            " where manager = #{manager} order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPaid(@Param("manager") int manager,
                             @Param("startIndex") int startIndex,
                             @Param("pageSize") int pageSize);

    @Select("select count(*) from teams join teammembers on teams.id = teammembers.teamid " +
            " join users on teammembers.userid = users.id join paylogs on teammembers.tmid = paylogs.tmid " +
            " join payment on paylogs.pmid = payment.pmid where manager = #{manager}")
    int selectPaidCount(int manager);

    @Select("select payment.title,teamsname,name,gender,phone,paylogs.createtime,paylogs.total,paylogs.details " +
            " from teams join teammembers on teams.id = teammembers.teamid join users on teammembers.userid = users.id " +
            " join paylogs on teammembers.tmid = paylogs.tmid join payment on paylogs.pmid = payment.pmid " +
            " where manager = #{manager} and teamsname like CONCAT('%',#{teamsname},'%') " +
            " and payment.title like CONCAT('%',#{title},'%') order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectPaidName(@Param("teamsname") String teamsname,
                                 @Param("title") String title,
                                 @Param("manager") int manager,
                                 @Param("startIndex") int startIndex,
                                 @Param("pageSize") int pageSize);

    @Select("select count(*) from teams join teammembers on teams.id = teammembers.teamid " +
            " join users on teammembers.userid = users.id join paylogs on teammembers.tmid = paylogs.tmid " +
            " join payment on paylogs.pmid = payment.pmid where manager = #{manager} " +
            " and teamsname like CONCAT('%',#{teamsname},'%') and payment.title like CONCAT('%',#{title},'%')")
    int selectPaidNameCount(@Param("teamsname") String teamsname,
                            @Param("title") String title,
                            @Param("manager") int manager);

    @Select("select payment.title,teamsname,name,gender,phone,payment.total,payment.details from teams join teammembers on teams.id = teammembers.teamid " +
            " join payment on teammembers.teamid = payment.teamid join users on teammembers.userid = users.id " +
            " left join paylogs on teammembers.tmid = paylogs.tmid where manager = #{manager} " +
            " and paylogs.tmid is null and paylogs.pmid is null limit #{startIndex},#{pageSize}")
    List<Paylogs> selectUnpaid(@Param("manager") int manager,
                               @Param("startIndex") int startIndex,
                               @Param("pageSize") int pageSize);

    @Select("select count(*) from teams join teammembers on teams.id = teammembers.teamid " +
            " join payment on teammembers.teamid = payment.teamid join users on teammembers.userid = users.id " +
            " left join paylogs on teammembers.tmid = paylogs.tmid where manager = #{manager} " +
            " and paylogs.tmid is null and paylogs.pmid is null")
    int selectUnpaidCount(int manager);

    @Select("select payment.title,teamsname,name,gender,phone,payment.total,payment.details from teams join teammembers on teams.id = teammembers.teamid " +
            " join payment on teammembers.teamid = payment.teamid join users on teammembers.userid = users.id " +
            " left join paylogs on teammembers.tmid = paylogs.tmid where manager = #{manager} " +
            " and paylogs.tmid is null and paylogs.pmid is null and teamsname like CONCAT('%',#{teamsname},'%') " +
            " and payment.title like CONCAT('%',#{title},'%') limit #{startIndex},#{pageSize}")
    List<Paylogs> selectUnpaidName(@Param("teamsname") String teamsname,
                                   @Param("title") String title,
                                   @Param("manager") int manager,
                                   @Param("startIndex") int startIndex,
                                   @Param("pageSize") int pageSize);

    @Select("select count(*) from teams join teammembers on teams.id = teammembers.teamid " +
            " join payment on teammembers.teamid = payment.teamid join users on teammembers.userid = users.id " +
            " left join paylogs on teammembers.tmid = paylogs.tmid where manager = #{manager} " +
            " and paylogs.tmid is null and paylogs.pmid is null and teamsname like CONCAT('%',#{teamsname},'%') " +
            " and payment.title like CONCAT('%',#{title},'%')")
    int selectUnpaidNameCount(@Param("teamsname") String teamsname,
                              @Param("title") String title,
                              @Param("manager") int manager);

    @Select("select count(*) from payment where title = #{title} and teamid = #{teamid}")
    int selectTitleCount(@Param("title") String title, @Param("teamid") int teamid);

    @Select("select total from teams where id = #{teamid}")
    Teams selectTeamsTotal(int teamid);

    @Update("update teams set total = total - #{total} where id = #{teamid}")
    int updateTeamsTotal(@Param("teamid") int teamid, @Param("total") int total);

    @Select("select total,teamid from paylogs where payid = #{payid}")
    Paylogs selectTotalTeamid(int payid);

    @Update("update teams set total = total + #{total} where id = #{teamid}")
    int updateAddTeamTotal(@Param("total") int total, @Param("teamid") int teamid);

    @Select("select teamsname,paylogs.total,paylogs.createtime,paylogs.details from paylogs " +
            " join teammembers on paylogs.teamid = teammembers.teamid join " +
            " teams on teammembers.teamid = teams.id where teammembers.userid = #{userid} " +
            " order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectTeamExpend(@Param("userid") int userid,
                                   @Param("startIndex") int startIndex,
                                   @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs " +
            " join teammembers on paylogs.teamid = teammembers.teamid join " +
            " teams on teammembers.teamid = teams.id where teammembers.userid = #{userid}")
    int selectTeamExpendCount(int userid);

    @Select("select teamsname,paylogs.total,paylogs.createtime,paylogs.details from paylogs " +
            " join teammembers on paylogs.teamid = teammembers.teamid join " +
            " teams on teammembers.teamid = teams.id where teammembers.userid = #{userid} " +
            " and teamsname like CONCAT('%',#{teamsname},'%') order by paylogs.createtime desc limit #{startIndex},#{pageSize}")
    List<Paylogs> selectTeamExpendName(@Param("teamsname") String teamsname,
                                       @Param("userid") int userid,
                                       @Param("startIndex") int startIndex,
                                       @Param("pageSize") int pageSize);

    @Select("select count(*) from paylogs join teammembers on paylogs.teamid = teammembers.teamid join " +
            " teams on teammembers.teamid = teams.id where teammembers.userid = #{userid}" +
            " and teamsname like CONCAT('%',#{teamsname},'%')")
    int selectTeamExpendNameCount(@Param("teamsname") String teamsname, @Param("userid") int userid);
}
