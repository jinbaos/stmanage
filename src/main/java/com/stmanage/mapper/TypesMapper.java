package com.stmanage.mapper;

import com.stmanage.entity.TeamTypes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository  //将数据访问层（dao层）的类识别并标注为SpringBean
public interface TypesMapper {

    @Select("select * from teamtypes limit #{startIndex},#{pageSize}")
    List<TeamTypes> selectTypes(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    @Select("select * from teamtypes where name like CONCAT('%',#{name},'%') limit #{startIndex},#{pageSize}")
    List<TeamTypes> selectTypeName(@Param("name") String name,
                                   @Param("startIndex") int startIndex,
                                   @Param("pageSize") int pageSize);

    @Insert("insert into teamtypes(name) values(#{name})")
    int insertTypes(@Param("name") String name);

    @Delete("delete from teamtypes where id = #{id}")
    int deleteTypes(int id);

    @Select("select * from teamTypes where id = #{id}")
    TeamTypes selectTypesId(int id);

    @Update("update teamTypes set name = #{name} where id = #{id}")
    int editTypes(@Param("id") int id, @Param("name") String name);

    @Select("select count(*) from teamtypes")
    int searchTypesCount();

    @Select("select count(*) from teamtypes where name like CONCAT('%',#{name},'%')")
    int selectNameCount(String name);
}
