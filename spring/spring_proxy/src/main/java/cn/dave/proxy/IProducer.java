package cn.dave.proxy;

public interface IProducer {

    /**
     * 销售产品
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后服务
     * @param money
     */
    void afterService(float money);
}
