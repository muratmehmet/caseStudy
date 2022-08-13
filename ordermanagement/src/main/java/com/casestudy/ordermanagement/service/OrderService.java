package com.casestudy.ordermanagement.service;

import com.casestudy.ordermanagement.client.feign.ProductManagementClient;
import com.casestudy.ordermanagement.domain.Order;
import com.casestudy.ordermanagement.repository.OrderRepository;


import com.casestudy.ordermanagement.request.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductManagementClient productManagementClient;

    public BigDecimal order(OrderRequest request) {

        Order order = new Order();
        order.setCustomerId(request.customerId());
        order.setProductId(request.productId());
        order.setQuantity(request.quantity());
        order.setTotalPrice(productManagementClient.calculatePrice(request.productId(), request.quantity()));
        orderRepository.save(order);

        return order.getTotalPrice();
    }
}
