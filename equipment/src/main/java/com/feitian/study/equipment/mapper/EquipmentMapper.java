package com.feitian.study.equipment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feitian.study.equipment.entity.Equipment;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMapper extends BaseMapper<Equipment> {

    void deleteByPrimaryKey(int id);

    Equipment selectByPrimaryKey();

    void insertSelective(Equipment equipment);

}
