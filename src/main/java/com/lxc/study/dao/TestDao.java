package com.lxc.study.dao;

import com.lxc.study.entity.TestDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    TestDO getById(Integer id);

    TestDO update(TestDO testDO);

}