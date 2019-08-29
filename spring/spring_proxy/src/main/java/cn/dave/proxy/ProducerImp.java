package cn.dave.proxy;

/**
 * @program: spring_proxy
 * @description:
 * @author: dave
 * @create: 2019-07-01 22:50
 **/

public class ProducerImp implements IProducer {
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money) {
        System.out.println("售后产品，并拿到钱："+money);
    }
}
