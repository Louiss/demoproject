package com.lxc.study.controller;

import com.lxc.study.entity.TestDO;
import com.lxc.study.service.TestService;
import com.lxc.study.service.TransactionalService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/demo")
public class TestController {
    Logger logger = Logger.getLogger("TestController");

    @Autowired
    private TestService testService;

    @Autowired
    private TransactionalService transactionalService;

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public TestDO get1(Integer id) {
        System.out.println("param:" + id);
        return testService.getById(id);
    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    public TestDO get2(TestDO testDO) {
        System.out.println("param:" + ReflectionToStringBuilder.toString(testDO));
        return testService.getById(testDO.getId());
    }

    @RequestMapping(value = "/get3", method = RequestMethod.GET)
    public TestDO get3(@RequestParam("id") Integer id) {
        System.out.println("param:" + id);
        TestDO testDO = testService.getById(id);
        System.out.println("result:" + ReflectionToStringBuilder.toString(testDO));
        logger.info("result:" + ReflectionToStringBuilder.toString(testDO));
        return testDO;
    }

    @RequestMapping(value = "/get4")
    public TestDO get4(TestDO testDO) {
        System.out.println("param:" + ReflectionToStringBuilder.toString(testDO));
        return testService.getById(testDO.getId());
    }

    @RequestMapping(value = "/get5/{id}", method = RequestMethod.GET)
    public TestDO get5(@PathVariable Integer id) {
        System.out.println("param:" + id);
        return testService.getById(id);
    }

    @RequestMapping(value = "/get6", method = RequestMethod.GET)
    public void get6(Integer id) {
        System.out.println("param:" + id);
        transactionalService.testTx(id);
    }


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public TestDO update(@RequestBody TestDO testDO) {
        System.out.println("param:" + ReflectionToStringBuilder.toString(testDO));
        return testService.update(testDO);

    }


}