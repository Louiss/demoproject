package com.lxc.study.service;

import com.lxc.study.entity.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
public class TransactionalService {

    Logger logger = Logger.getLogger("TransactionalService");

    @Resource
    public TestService testService;

    @Transactional
    public void testTx(Integer id) {
        logger.info("TX start.... " + TransactionSynchronizationManager.getCurrentTransactionName());

        TestDO test = new TestDO();
        test.setId(id);
        test.setMagicId("55555");
        test.setFirstName("5555");
        test.setLastName("5555");
        testService.update(test);

        TestDO testNew = new TestDO();
        testNew.setId(id + 1);
        testNew.setMagicId("6666");
        testNew.setFirstName("666");
        testNew.setLastName("663");
        testService.updateTxNew(testNew);


    }

}

