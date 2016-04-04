package com.wantdo.erp.mapper;

import com.wantdo.erp.model.OrderInfo;
import com.wantdo.erp.test.spring.spring.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @ Date : 16/4/4
 * @ From : erp-demo
 * @ Author : luanx@wantdo.com
 */

@ContextConfiguration(locations = {"/spring-database.xml"})
public class OrderMapperTest extends SpringTransactionalTestCase{

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Test
    public void selectByPrimaryKey(){
        OrderInfo order = orderInfoMapper.selectByPrimaryKey(1);
        System.out.println(order.getOrderid());
    }
}
