package com.db.mapper;

import com.db.pojo.onlineuser;
import com.db.pojo.onlineuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface onlineuserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int countByExample(onlineuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int deleteByExample(onlineuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int deleteByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int insert(onlineuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int insertSelective(onlineuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    List<onlineuser> selectByExample(onlineuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    onlineuser selectByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int updateByExampleSelective(@Param("record") onlineuser record, @Param("example") onlineuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int updateByExample(@Param("record") onlineuser record, @Param("example") onlineuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int updateByPrimaryKeySelective(onlineuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onlineuser
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    int updateByPrimaryKey(onlineuser record);
}