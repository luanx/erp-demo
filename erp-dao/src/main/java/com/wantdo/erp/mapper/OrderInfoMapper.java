package com.wantdo.erp.mapper;

import com.wantdo.erp.model.OrderInfo;


@MyBatisRepository
public interface OrderInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbggenerated Mon Apr 04 18:02:16 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbggenerated Mon Apr 04 18:02:16 CST 2016
     */
    int insert(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbggenerated Mon Apr 04 18:02:16 CST 2016
     */
    int insertSelective(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbggenerated Mon Apr 04 18:02:16 CST 2016
     */
    OrderInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbggenerated Mon Apr 04 18:02:16 CST 2016
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbggenerated Mon Apr 04 18:02:16 CST 2016
     */
    int updateByPrimaryKey(OrderInfo record);
}