package com.feitian.study.equipment;

import com.feitian.study.equipment.mapper.EquipmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class EquipmentApplicationTests {

    @Autowired
    EquipmentMapper equipmentMapper;

    @Test
    void contextLoads() {
    }


    @Test
    @Transactional
    void testDelete(){
        equipmentMapper.deleteByPrimaryKey(2);
    }
}
