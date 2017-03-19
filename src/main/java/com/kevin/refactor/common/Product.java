package com.kevin.refactor.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Builder;

import java.util.Date;

/**
 * 详情 : 商品
 * <p>
 * 详细 :
 *
 * @author liangguanglong 17/3/19
 */
@Builder
@Data
@AllArgsConstructor
public class Product {

    private int id;

    private String name;

    private int price;

    private int number;

    private Date createTime;

    private int ownerId;
}