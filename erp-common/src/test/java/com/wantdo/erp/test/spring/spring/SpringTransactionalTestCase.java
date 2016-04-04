package com.wantdo.erp.test.spring.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;

/**
 * @ Date : 16/4/4
 * @ From : erp-demo
 * @ Author : luanx@wantdo.com
 */

@ActiveProfiles(Profiles.UNIT_TEST)
public abstract class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests{

    protected DataSource dataSource;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
