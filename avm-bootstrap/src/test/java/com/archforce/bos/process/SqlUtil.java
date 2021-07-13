package com.archforce.bos.process;

import com.archforce.common.utils.EncryptUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SqlUtil {
    @Test
    public void testSqlUtil() {
        String ARCHFORCE_DOMAIN_URL = "jdbc:mysql://101.34.54.70:3306/domainconfigdb?useSSL=false&allowPublicKeyRetrieval=true|root|" + EncryptUtil.encodePwd("Archforce@123");
        System.out.println("================");
        System.out.println(ARCHFORCE_DOMAIN_URL);
        System.out.println(EncryptUtil.encode("Archforce@123"));
        System.out.println(EncryptUtil.encode(ARCHFORCE_DOMAIN_URL));
    }
}
