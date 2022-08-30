package com.feitian.study.equipment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feitian.study.equipment.entity.Equipment;
import com.feitian.study.equipment.mapper.EquipmentMapper;
import com.feitian.study.equipment.service.EquipmentService;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {
}
