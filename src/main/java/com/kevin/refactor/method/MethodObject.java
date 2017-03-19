package com.kevin.refactor.method;

import com.kevin.refactor.common.Product;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * 详情 : 当存在很多局部变量的时候，将代码抽取成函数将会变得比较有难度
 * 这个时候创建一个对象，将局部变量作为这个对象的属性，然后视原函数大小复杂度进行拆分成多个小函数
 *
 * @author liangguanglong 17/3/19
 */
public class MethodObject {

    public double orderSum(int discountRate, int orderType, Product product) {
        return new OrderCalculator(discountRate, orderType, product).compute();
    }

}

class OrderCalculator {
    private int discountRate;
    private int orderType;
    private Product product;

    OrderCalculator(int discountRate, int orderType, Product product) {
        this.discountRate = discountRate;
        this.orderType = orderType;
        this.product = product;
    }

    double compute() {
        boolean isNewProduct = product.getCreateTime().after(DateUtils.addDays(new Date(), 3));
        boolean isHotSales = orderType == 1 && isNewProduct;
        double sum;
        if (product.getNumber() > 10 && isHotSales) {
            sum = product.getPrice() * product.getNumber() * 0.8 * discountRate;
        } else {
            sum = product.getPrice() * product.getNumber() * 0.9 * discountRate;
        }
        return sum;
    }
}