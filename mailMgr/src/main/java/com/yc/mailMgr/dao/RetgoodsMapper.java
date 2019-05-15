package com.yc.mailMgr.dao;

import com.yc.mailMgr.bean.Retgoods;
import com.yc.mailMgr.bean.RetgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetgoodsMapper {
    long countByExample(RetgoodsExample example);

    int deleteByExample(RetgoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Retgoods record);

    int insertSelective(Retgoods record);

    List<Retgoods> selectByExample(RetgoodsExample example);

    Retgoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Retgoods record, @Param("example") RetgoodsExample example);

    int updateByExample(@Param("record") Retgoods record, @Param("example") RetgoodsExample example);

    int updateByPrimaryKeySelective(Retgoods record);

    int updateByPrimaryKey(Retgoods record);
}