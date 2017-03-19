package com.kevin.refactor.method;

import com.google.common.base.Preconditions;
import com.kevin.refactor.common.Product;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 详情 : 抽取函数，避免函数过大，提高代码可读性差
 * <p>
 * 详细 : 代码的结构就跟做事一样，可以拆分成几个步骤，对应就是代码里面的各个小方法
 *       如果系统复杂的时候，还是可以将步骤抽取出几个步骤，比如spring的初始化的refresh方法
 *       程序实现很多时候在不涉及算法的情况，都是比较容易实现，但是实现的是否优雅以及很好的可读性是一个关键
 * @author liangguanglong 17/3/19
 */
public class ExactMethod {

    /**
     * 差的写法
     */
    public void saveProductBad(List<Product> products) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(products), "商品不能为空");
        for (Product product : products) {
            Preconditions.checkArgument(product.getId() > 0, "id必须大于0");
            Preconditions.checkArgument(StringUtils.isNotBlank(product.getName()), "名字不能为空");
            Preconditions.checkArgument(product.getPrice() > 0, "价格必须大于0");
            Preconditions.checkArgument(product.getNumber() > 0, "数量必须大于0");
        }

        for (Product product : products) {
            product.setCreateTime(new Date());
            product.setOwnerId(1);
        }

        insertProduct();

        int productSum = 0;
        for (Product product : products) {
            System.out.println("本次录入商品 " + product.getName() + " " + product.getNumber() + "件");
            productSum += product.getNumber() * product.getPrice();
        }
        System.out.println("总价值 ：" + productSum);
    }

    /**
     * 好的写法
     */
    public void saveProductGood(List<Product> products) {

        checkProductArgs(products);

        fillInfo2Product(products);

        insertProduct();

        logProductInfo(products);
    }

    private void checkProductArgs(List<Product> products) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(products), "商品不能为空");
        for (Product product : products) {
            Preconditions.checkArgument(product.getId() > 0, "id必须大于0");
            Preconditions.checkArgument(StringUtils.isNotBlank(product.getName()), "名字不能为 空");
            Preconditions.checkArgument(product.getPrice() > 0, "价格必须大于0");
            Preconditions.checkArgument(product.getNumber() > 0, "数量必须大于0");
        }
    }


    private void fillInfo2Product(List<Product> products) {

        for (Product product : products) {
            product.setCreateTime(new Date());
            product.setOwnerId(2);
        }
    }

    private void logProductInfo(List<Product> products) {
        int productSum = 0;
        for (Product product : products) {
            System.out.println("本次录入商品 " + product.getName() + " " + product.getNumber() + "件");
            productSum += product.getNumber() * product.getPrice();
        }
        System.out.println("总价值 ：" + productSum);
    }

    private void insertProduct() {
        System.out.println("保存商品");
    }
}
