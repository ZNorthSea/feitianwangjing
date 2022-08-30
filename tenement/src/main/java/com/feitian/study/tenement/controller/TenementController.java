package com.feitian.study.tenement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feitian.study.common.result.ResponseCode;
import com.feitian.study.common.result.Result;
import com.feitian.study.tenement.entity.Tenement;
import com.feitian.study.tenement.service.TenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 小区物业系统表(Tenement)表控制层
 *
 * @author makejava
 * @since 2022-08-19 11:22:13
 */
@RestController
@RequestMapping("tenement")
@CrossOrigin
public class TenementController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TenementService tenementService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param tenement 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Tenement> page, Tenement tenement) {
        return success(this.tenementService.page(page, new QueryWrapper<>(tenement)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tenementService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tenement 实体对象
     * @return 新增结果
     */
    @PostMapping("/addInfo")
    public Result insert(@RequestBody Tenement tenement) {
        if(null != tenement){
            boolean save = tenementService.save(tenement);
            if(save){
                return new Result().message("添加成功").code(200);
            }
        }
        return new Result().code(ResponseCode.ERROR.getCode());
    }

    /**
     * 修改数据
     *
     * @param tenement 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Tenement tenement) {
        return success(this.tenementService.updateById(tenement));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R deleteBatch(@RequestParam("idList") List<Long> idList) {
        return success(this.tenementService.removeByIds(idList));
    }


}

