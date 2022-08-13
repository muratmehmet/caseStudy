package com.casestudy.ordermanagement.converter;


import com.casestudy.ordermanagement.domain.Order;
import com.casestudy.ordermanagement.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements Converter<OrderDto, Order> {

    @Override
    public Order toEntity(OrderDto var1) {
        if(var1 == null){
            return null;
        }

        Order entity = new Order();

        if(var1.getId() != null){
            entity.setId(var1.getId());
        }

        entity.setProductId(var1.getProductId());
        entity.setCustomerId(var1.getCustomerId());
        entity.setQuantity(var1.getQuantity());
        entity.setTotalPrice(var1.getTotalPrice());


        return entity;

    }



    @Override
    public OrderDto toDto(Order var1) {
        //I try to keep it simple
        return null;
    }
}
