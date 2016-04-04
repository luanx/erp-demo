package com.wantdo.erp.test.spring;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @ Date : 16/4/4
 * @ From : erp-demo
 * @ Author : luanx@wantdo.com
 */

@ActiveProfiles(Profiles.UNIT_TEST)
public class SpringContextTestCase extends AbstractJUnit4SpringContextTests {
}
