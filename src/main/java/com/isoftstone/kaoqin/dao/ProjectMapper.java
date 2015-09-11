package com.isoftstone.kaoqin.dao;

import com.isoftstone.kaoqin.bean.Project;
import com.isoftstone.kaoqin.bean.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int countByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int deleteByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    List<Project> selectByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    Project selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Project record);
}