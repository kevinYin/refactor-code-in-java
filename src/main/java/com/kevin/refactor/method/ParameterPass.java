package com.kevin.refactor.method;

import com.kevin.refactor.common.Product;
import org.junit.Test;

/**
 * 详情 :  参数传递，函数调用，对象的内部属性可以改，但对象重新赋值没有意义
 * <p>
 * 详细 : 在重构过程会遇到很多局部变量进行参数传递的情况，需要特别注意在参数传递过程的使用
 *        因为java是采用值传递的
 * @author liangguanglong 17/3/19
 */
public class ParameterPass {

    /**
     * java的函数调用时采用值传递，所以改变调用函数时，因此你只能改变的是对象的内部属性，
     * 而对参数对象重新赋值毫无意义
     */
    @Test
    public void testParameterPass() {
        Product product = new Product(1, 2, "001");
        changeAttr(product);
        System.out.println("after change price :" + product.getPrice());

        changeObject(product);
        System.out.println("after change object , price is : " + product.getPrice());
    }

    private void changeObject(Product product) {
        product = new Product(111,222,"002");
        System.out.println("price is " + product.getPrice());
    }

    private void changeAttr(Product product) {
        product.setPrice(3);
        System.out.println("price is " + product.getPrice());
    }
}
