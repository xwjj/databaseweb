package com.db.mapper;

import com.db.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: 个人定义的
 * @Author: xw
 * @Date: 2022/12/9 14:45
 */
@Mapper
public interface personalmapper {
    List<foodDisplay1> getAllUserByIp(@Param("ownerid") int ownerid);

    @Select("select a.img,a.name,s.quality,s.inprice,s.outprice,s.number,s.start,a.day " +
            "from storestock s,allfood a " +
            "where a.id=s.id and s.ownerid=#{id}")
    List<keeperByThis> showForKeeper(Integer id);

    @Delete("delete  from subscribe where number=0")
    void deleteUnuseful();

    @Select("select a.img,a.name,ss.outprice,ss.quality,ss.number from " +
            "storestock ss,onlineuser o,store s,allfood a " +
            "where s.ip=o.ip and ss.ownerid=s.ownerid and a.id=ss.id and a.name like concat('%',#{name},'%')" +
            "and o.username=#{username}")
    List<foodDisplay1> searchFood(@Param("name") String name, @Param("username") String username);

    @Select("select a.img,a.name,s.quality,s.outprice from storestock s,allfood a,owner o where a.id=s.id and o.id=s.ownerid and o.username=#{username}")
    List<byCash1> showForCash(String username);

    @Select("select s.`all` from owner o,storecash s where s.id=o.id and o.username=#{username}")
    Double cash(String username);

    @Update("update storecash set `all`=#{v} where id=#{id}")
    void addCash(@Param("id") Integer id, @Param("v") double v);

    @Select("select * from allfood")
    List<allfood> allFoodInfo();

    @Insert("insert into owner (username, password) values (#{username},#{password});")
    void newKeeper(@Param("username") String username,@Param("password") String password);

    @Select("select o.username,a.img,a.name,s.quality,st.outprice,s.number from" +
            " allfood a,subscribe s,onlineuser o,storestock st,store se,owner ow " +
            "where a.id=s.foodid and o.ip=se.ip and st.quality=s.quality and st.id=s.foodid and s.username=o.username " +
            "and ow.id=se.ownerid and se.ownerid=st.ownerid and st.ownerid=ow.id and ow.username=#{username}")
    List<onlineSub1> showSub(String username);

    @Select("select o.id,o.username,o.password,s.ip from owner o,store s where s.ownerid=o.id")
    List<keeperInfo> keepers();

    @Update("update owner o,store s set o.username=#{username},o.password=#{password},s.ip=#{ip} where o.id=#{id} and s.ownerid=o.id")
    void updateOwner(@Param("id") Integer id,@Param("username") String username,@Param("password") String password,@Param("ip") String ip);

    @Select("select s.id,s.ip,o.username from owner o,store s where o.id=s.ownerid")
    List<storeForCom1> stores();

    @Select("select username,password,ip,phone from onlineuser")
    List<usersForCom1> Users();
}
