package com.sim.server.game.data.db.mapper;

import com.sim.server.game.data.db.pojo.TbAbility;
import com.sim.server.game.data.db.pojo.TbAbilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAbilityMapper {
    int countByExample(TbAbilityExample example);

    int deleteByExample(TbAbilityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAbility record);

    int insertSelective(TbAbility record);

    List<TbAbility> selectByExample(TbAbilityExample example);

    TbAbility selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAbility record, @Param("example") TbAbilityExample example);

    int updateByExample(@Param("record") TbAbility record, @Param("example") TbAbilityExample example);

    int updateByPrimaryKeySelective(TbAbility record);

    int updateByPrimaryKey(TbAbility record);
}