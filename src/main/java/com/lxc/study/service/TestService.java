package com.lxc.study.service;

import com.lxc.study.dao.TestDao;
import com.lxc.study.entity.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.logging.Logger;

@Service
public class TestService {

    Logger logger = Logger.getLogger("TestService");

    @Resource
    private DataSource dataSource;

    @Resource
    private TestDao testDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public TestDO getById(Integer id) {
        logger.info("TX start.... " + TransactionSynchronizationManager.getCurrentTransactionName());
        return testDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TestDO update(TestDO testDO) {
        logger.info("TX start.... " + TransactionSynchronizationManager.getCurrentTransactionName());
        return testDao.update(testDO);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TestDO updateTxNew(TestDO testDO) {
        logger.info("TX start.... " + TransactionSynchronizationManager.getCurrentTransactionName());
        return testDao.update(testDO);
    }

}