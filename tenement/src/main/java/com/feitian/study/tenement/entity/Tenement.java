package com.feitian.study.tenement.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 小区物业系统表(Tenement)表实体类
 */
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("serial")
@TableName("tenement")
@Data
public class Tenement extends Model<Tenement> {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //小区名称
    @TableField(value = "house_name")
    private String houseName;
    //物业名称
    @TableField(value = "name")
    private String name;
    //物业服务人数
    @TableField(value = "server_count")
    private Integer serverCount;
    //业主委员数
    @TableField(value = "owner_count")
    private Integer ownerCount;
    //是否拥有充电桩
    @TableField(value = "has_charging_pile")
    private Integer hasChargingPile;
    //创建时间
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    //更新时间
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    //0: 未删除
    // 1：已删除
    @TableLogic
    private Integer deleted;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

