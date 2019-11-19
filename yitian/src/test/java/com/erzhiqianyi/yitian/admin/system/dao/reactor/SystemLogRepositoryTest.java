package com.erzhiqianyi.yitian.admin.system.dao.reactor;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.dao.query.SystemLogQuery;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class SystemLogRepositoryTest {

    @Autowired
    private SystemLogRepository repository;

    @Test
    public void addSystemLog() {
        SystemLogEntity log = new SystemLogEntity();
        log.setType(LogType.LOGIN);
        log.setStatus(LogStatus.SUCCESS);
        log.setRemark("erzhiqianyi@gmail.com");
        log.setCreateAt(System.currentTimeMillis());
        log.setCreateBy(1l);
        StepVerifier.create(
                repository.addSystemLog(log)
                        .map(SystemLogEntity::getStatus)
        )
                .expectNext(log.getStatus())
                .expectComplete()
                .verify();
    }

    @Test
    public void findSystemLogByPage() {
        SystemLogQuery query = new SystemLogQuery();
        query.setSize(10);
        query.setPage(1);
        StepVerifier.create(
                repository.findSystemLogByPage(query)
                        .doOnNext(item -> {
                            assertNotNull(item.getId());
                            assertNotNull( item.getType());
                        })
                        .then(Mono.empty())
        )
                .expectNext()
                .expectComplete()
                .verify();

    }
}