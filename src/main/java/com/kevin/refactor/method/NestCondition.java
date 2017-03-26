package com.kevin.refactor.method;

import com.google.common.base.Objects;
import com.kevin.refactor.common.Product;

/**
 * 详情 : 条件表达式各种嵌套，简单讲就是if/ else 里面再嵌套if else，各种嵌套
 * <p>
 * 详细 : 当我看到这个《重构》9.5章节时，讲到这点感触非常深，
 * 以前我重构过一个同事的代码，一个方法里面有9层if else，看起来非常难读，从编辑器的左端往右看，就像一个金字塔
 * 从阿里来的架构师称之为"金字塔类型"代码
 * 我理解好的代码应该是想文章句子 一行一行这样读下去，而不是外表像大于号  > 一样形状，可读性简直反人类
 *
 * @author liangguanglong 17/3/26
 */
public class NestCondition {

    /**
     * if else 各种嵌套，代码逐渐变得写得让人很难看清正常执行路径，特别是 都是成对的if else的时候
     * 从左到右看，金字塔的雏形已经显现，再继续扩张的话 会变得越加不可读
     *
     * @param product
     */
    public int multiIfElseBad(Product product) {
        int total;
        if (product.isNewProduct()) {
            total = product.getPrice() * product.getNumber();
        } else {
            if (product.getNumber() > 10) {
                total = product.getNumber() * product.getNumber() * 2;
            } else {
                if (Objects.equal(product.getName(), "apple")) {
                    total = product.getNumber() * product.getPrice() * 3;
                } else {
                    total = product.getNumber() * product.getPrice() * 4;
                }
            }
        }
        return total;
    }

    /**
     * 重构看起来很简单，但是越是简单，越是易读，代码一行行读起来舒服，不需要转转曲曲
     * 在多重if else 嵌套代码里面，我觉得消除嵌套的关键是用好 return
     * @param product
     */
    public int multiIfElseGood(Product product) {
        if (product.isNewProduct()) {
            return product.getPrice() * product.getNumber();
        }

        if (product.getNumber() > 10) {
            return product.getNumber() * product.getNumber() * 2;
        }

        if (Objects.equal(product.getName(), "apple")) {
            return product.getNumber() * product.getPrice() * 3;
        }

        return  product.getNumber() * product.getPrice() * 4;
    }
}
