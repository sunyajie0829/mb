package com.felix.mbg.mapper;

import com.felix.mbg.model.TStudent;
import com.felix.mbg.model.TStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStudentMapper {
    long countByExample(TStudentExample example);

    int deleteByExample(TStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    List<TStudent> selectByExample(TStudentExample example);

    TStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}