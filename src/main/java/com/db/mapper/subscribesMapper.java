package com.db.mapper;

import com.db.pojo.completeCart1;

import java.util.List;

/**
 * @Description: 查订单
 * @Author: xw
 * @Date: 2022/12/11 21:01
 */
public interface subscribesMapper {
    public List<completeCart1> allSubscribes(String username);
}
