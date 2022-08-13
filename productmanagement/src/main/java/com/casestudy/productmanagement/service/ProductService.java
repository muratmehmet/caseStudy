package com.casestudy.productmanagement.service;


import com.casestudy.productmanagement.converter.ProductConverter;
import com.casestudy.productmanagement.domain.Inventory;
import com.casestudy.productmanagement.domain.Product;
import com.casestudy.productmanagement.dto.ProductDto;
import com.casestudy.productmanagement.exception.NotFoundException;
import com.casestudy.productmanagement.repository.ProductRepository;
import com.ctc.wstx.util.StringUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;


    public void save(ProductDto productDto) {
        productRepository.save(productConverter.toEntity(productDto));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public BigDecimal calculatePrice(Long productId, Long quantity) {
        List<Product> productList = productRepository.findAllByProductIdAndQuantityGreaterThanOrderByQuantity(productId, 0L);

        //eliminate the passive inventories
        List<Product> activeProductList = productList.stream()
                .filter(product -> StringUtils.equals("ACTIVE", product.getInventory().getStatus())).collect(Collectors.toList());


        BigDecimal price = BigDecimal.ZERO;
        //option2 return calculate(activeProductList, quantity, 0, price);

        for (Product product : activeProductList) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                price.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
                productRepository.save(product);
                return price;
            } else {
                price.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
                quantity = quantity - product.getQuantity();
                product.setQuantity(0L);
                productRepository.save(product);
                if (quantity == 0) {
                    break;
                }
            }
        }
        return price;
    }

    private BigDecimal calculate(List<Product> productList, Long quantity, int i, BigDecimal price){
        Product product = productList.get(i);
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            price.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            return price;
        } else {
            price.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            quantity = quantity - product.getQuantity();
            return calculate(productList, quantity, ++i, price);
        }
    }

    public Product getById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }else {
            throw new NotFoundException("Product not found !");
        }
    }
}
