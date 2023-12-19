package com.kia.springbatch.config;

import com.kia.springbatch.entity.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


public class ProductProcessor implements ItemProcessor<Product,Product> {
    @Override
    public Product process(Product item) throws Exception {
        if(Long.valueOf(item.getPrice()) > 20000){
            return item;
        }
        return null;
    }
}
