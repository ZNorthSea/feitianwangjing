package com.feitian.study.equipment.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feitian.study.common.result.ResponseCode;
import com.feitian.study.common.result.Result;
import com.feitian.study.equipment.entity.Equipment;
import com.feitian.study.equipment.mapper.EquipmentMapper;
import com.feitian.study.equipment.service.EquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("equipment")
@Slf4j
public class EquipmentController extends ApiController {

    private final String equipmentKey = "feitian:equipment:";
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Equipment> equipmentList = equipmentService.list();
        if (null != equipmentList) {
            return new Result().result(ResponseCode.SUCCESS, equipmentList);
        }
        return new Result().code(ResponseCode.SUCCESS.getCode()).message("没有查到数据");
    }

    @PostMapping("/addOne")
    public Result insert(@RequestBody Equipment equipment) {
        if (null != equipment) {
            // 保存到数据库中
            boolean save = equipmentService.save(equipment);
            if (save) {
                // 先保存在Redis中
                HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
                addRedisData(equipment);
                return new Result().message("添加成功").code(200);
            }
        }
        return new Result().code(ResponseCode.ERROR.getCode());
    }

    private Map<String, Object> getStringObjectMap(Equipment equipment) {
        Jackson2HashMapper hashMapper = new Jackson2HashMapper(objectMapper, false);
        Map<String, Object> objectMap = hashMapper.toHash(equipment);
        return objectMap;
    }

    /**
     * 根据ID删除单个用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteOne/{id}")
    @Transactional
    public Result deleteOne(@PathVariable Integer id) {
        log.info("前端传来的id:{}", id);
        // 校验id
        if (null != id && id > 0) {
            try {
                log.info("{}删除成功", id);
                boolean remove = equipmentService.removeById(id);
                int i = 1 / 0;
                if (remove) {
                    return new Result().code(ResponseCode.SUCCESS.getCode()).message("删除成功");
                }
                return new Result().code(ResponseCode.SUCCESS.getCode()).message("删除失败");
            } catch (Exception e) {
                log.error("出现异常：{}", e.getMessage());
                return new Result().message("请求错误").code(500);
            }
        }
        return new Result().message("设备不存在").code(ResponseCode.SUCCESS.getCode());
    }


    @PutMapping("/updateById")
    public Result updateById(@RequestBody Equipment equipment) {
        System.out.println("equipment = " + equipment);
        // 校验id
        if (null != equipment) {
            // 查询数据看是否存在
            boolean redisData = selectRedisData(equipment.getId());
            if (redisData) {
                String key = equipmentKey + equipment.getId();
                redisTemplate.delete(key);
                addRedisData(equipment);
                // 向数据库更新数据
                boolean updateById = equipmentService.updateById(equipment);
                if (updateById) {
                    return new Result().message("修改成功").code(200);
                }
                return new Result().message("修改失败").code(200);
            }
        }
        return new Result().message("请求错误").code(500);
    }


    /**
     * 根据ID 在redis中查找数据
     *
     * @param id
     * @return
     */
    public boolean selectRedisData(Integer id) {
        if (null != id && id > 0) {
            // 查询用户是否存在
            String key = equipmentKey + id;
            try {
                int resultId = (Integer) redisTemplate.opsForHash().get(key, "id");
                System.out.println("hasKey = " + resultId);
                if (id == resultId) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("e = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public void addRedisData(Equipment equipment) {
        Map<String, Object> objectMap = getStringObjectMap(equipment);
        String key = equipmentKey + equipment.getId();
        redisTemplate.opsForHash().putAll(key, objectMap);
        redisTemplate.expire(key, 1, TimeUnit.HOURS);
    }


}
