package com.feitian.study.tenement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feitian.study.tenement.dao.TenementDao;
import com.feitian.study.tenement.entity.Tenement;
import com.feitian.study.tenement.service.TenementService;
import org.springframework.stereotype.Service;

/**
 * 小区物业系统表(Tenement)表服务实现类
 *
 * @author makejava
 * @since 2022-08-19 11:22:13
 */
@Service("tenementService")
public class TenementServiceImpl extends ServiceImpl<TenementDao, Tenement> implements TenementService {

}

