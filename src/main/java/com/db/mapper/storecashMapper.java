package com.db.mapper;

import com.db.pojo.storecash;
import com.db.pojo.storecashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface storecashMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int countByExample(storecashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int deleteByExample(storecashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int insert(storecash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int insertSelective(storecash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    List<storecash> selectByExample(storecashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    storecash selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int updateByExampleSelective(@Param("record") storecash record, @Param("example") storecashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int updateByExample(@Param("record") storecash record, @Param("example") storecashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int updateByPrimaryKeySelective(storecash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storecash
     *
     * @mbggenerated Fri Dec 16 20:17:01 CST 2022
     */
    int updateByPrimaryKey(storecash record);
}