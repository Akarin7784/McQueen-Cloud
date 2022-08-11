package org.mcqueen.cloud.oauth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcqueen.cloud.oauth2.service.SecurityUserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Resource
    private SecurityUserService securityUserService;

    @Test
    public void test() {
        securityUserService.list().forEach(System.out::println);
    }
}
