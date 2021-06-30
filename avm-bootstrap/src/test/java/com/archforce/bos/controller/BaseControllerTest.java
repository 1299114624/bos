package com.archforce.bos.controller;

import com.archforce.AVM;
import com.archforce.bos.common.Environment;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AVM.class)
public class BaseControllerTest {
    @BeforeClass
    public static void initEnvironment() {
        Environment.setEnv();
    }

    @Test
    public void login() throws Exception {
        System.out.println("login");
    }
}
