package com.kevin.refactor.method;

import com.google.common.base.Objects;
import com.kevin.refactor.common.Product;

import java.math.BigDecimal;

/**
 * 详情 : 分解if else 判断条件表达式，代码更加可读
 *
 * @author liangguanglong 17/3/26
 */
public class IfElseDecompose {

    /**
     * if 判断条件特别长的时候，方法会变得复杂以及可读性差
     * @param product
     */
    public BigDecimal calculateOrderSumBad(Product product) {
        BigDecimal orderAccount;
        if (product.getNumber() > 10 && product.getPrice() > 100 && Objects.equal(product.getName(), "apple")) {
            orderAccount = new BigDecimal(product.getNumber() * product.getPrice() * 0.9);
        } else {
            orderAccount = new BigDecimal(product.getNumber() * product.getPrice());
        }
        return orderAccount;
    }

    /**
     * 在if 判断条件和if的程序内容非常复杂的时候，将他们各自抽取出方法来，形成几个简单的小方法，代码更加易读
     * @param product
     */
    public BigDecimal calculateOrderSumGood(Product product) {
        if (canDiscount(product)) {
            return calculateDiscountFare(product);
        }
        return  calculateNormalFare(product);
    }

    private BigDecimal calculateNormalFare(Product product) {
        return new BigDecimal(product.getNumber() * product.getPrice());
    }

    private BigDecimal calculateDiscountFare(Product product) {
        return new BigDecimal(product.getNumber() * product.getPrice() * 0.9);
    }

    private boolean canDiscount(Product product) {
        return product.getNumber() > 10 && product.getPrice() > 100 && Objects.equal(product.getName(), "apple");
    }
}
