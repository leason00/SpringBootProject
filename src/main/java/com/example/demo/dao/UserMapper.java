package com.example.demo.dao;

/**
 *
 * Created by Administrator on 2017/10/12.
 */


import com.example.demo.domain.UserResouce;
//import com.example.demo.tools.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface  UserMapper {
    @Insert("insert into test(name, years,password) values(#{name},#{years},#{password})")
    int add(UserResouce userResouce);

    @Update("update learn_resource set author=#{author},title=#{title},url=#{url} where id = #{id}")
    int update(UserResouce userResouce);

    @DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);


    @Select("select * from learn_resource where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(property = "author", column = "author", javaType = String.class),
            @Result(property = "title", column = "title", javaType = String.class)
    })
    UserResouce queryLearnResouceById(@Param("id") Long id);

    @SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResouceByParams")
    List<UserResouce> queryLearnResouceList(Map<String, Object> params);

    class LearnSqlBuilder {
        public String queryLearnResouceByParams(final Map<String, Object> params) {
//            StringBuffer sql =new StringBuffer();
//            sql.append("select * from learn_resource where 1=1");
//            if(!StringUtil.isNull((String)params.get("author"))){
//                sql.append(" and author like '%").append((String)params.get("author")).append("%'");
//            }
//            if(!StringUtil.isNull((String)params.get("title"))){
//                sql.append(" and title like '%").append((String)params.get("title")).append("%'");
//            }
//            System.out.println("查询sql=="+sql.toString());
//            return sql.toString();
            return "123";
        }

        //删除的方法
        public String deleteByids(@Param("ids") final String[] ids){
            StringBuffer sql =new StringBuffer();
            sql.append("DELETE FROM learn_resource WHERE id in(");
            for (int i=0;i<ids.length;i++){
                if(i==ids.length-1){
                    sql.append(ids[i]);
                }else{
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }
}
