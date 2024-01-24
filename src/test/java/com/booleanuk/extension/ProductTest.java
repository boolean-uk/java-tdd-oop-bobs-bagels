package com.booleanuk.extension;

import com.booleanuk.core.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void getPriceTest() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals(0.39, product.getPrice());

    }

    @Test
    public void getVariantTest() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals("apple", product.getVariant());
    }

    @Test
    public void getNameTest() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals("Other", product.getName());
    }

    @Test
    public void getSkuTest() {
        Product product = new Product("apple", 0.39);
        Assertions.assertEquals("OTHA", product.getSku());
    }

    @Test
    public void setPriceTest() {
        Product product = new Product("apple", 0.39);
        product.setPrice(0.49);
        Assertions.assertEquals(0.49, product.getPrice());
    }

    @Test
    public void setVariantTest() {
        Product product = new Product("Fruit","apple", 0.39);
        product.setVariant("Granny Smith");
        Assertions.assertEquals("Granny Smith", product.getVariant());
        Assertions.assertEquals("FRUG", product.getSku());
    }

    @Test
    public void setNameTest() {
        Product product = new Product("apple", 0.39);
        product.setName("Fruit");
        Assertions.assertEquals("Fruit", product.getName());
        Assertions.assertEquals("FRUA", product.getSku());
    }

    @Test
    public void setSku() {
        Product product = new Product("apple", 0.39);
        product.setSku("FRua");
        Assertions.assertEquals("FRUA", product.getSku());
    }

}
