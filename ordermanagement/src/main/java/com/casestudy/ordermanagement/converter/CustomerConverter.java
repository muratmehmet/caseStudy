package com.casestudy.ordermanagement.converter;


import com.casestudy.ordermanagement.domain.Customer;
import com.casestudy.ordermanagement.domain.Order;
import com.casestudy.ordermanagement.dto.CustomerDto;
import com.casestudy.ordermanagement.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter implements Converter<CustomerDto, Customer> {

    @Override
    public Customer toEntity(CustomerDto var1) {
        if(var1 == null){
            return null;
        }

        Customer entity = new Customer();

        if(var1.getId() != null){
            entity.setId(var1.getId());
        }

        entity.setName(var1.getName());
        entity.setLoginName(var1.getLoginName());


        return entity;

    }

    @Override
    public CustomerDto toDto(Customer var1) {
        //I try to keep it simple

        return null;
    }

}
