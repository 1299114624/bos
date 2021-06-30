package com.archforce.bos.process;

import com.archforce.arc.facility.utils.EncryptUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SqlUtil {
    @Test
    public void testSqlUtil() {
        String ARCHFORCE_DOMAIN_URL = "jdbc:mysql://localhost:3306/domainConfigdb?useSSL=false|root|" + EncryptUtil.encodePwd("root");
        System.out.println("================");
        System.out.println(ARCHFORCE_DOMAIN_URL);
        System.out.println(EncryptUtil.encode(ARCHFORCE_DOMAIN_URL));
    }
}
