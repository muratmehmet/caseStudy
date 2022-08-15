package com.casestudy.productmanagement.repository;

import com.casestudy.productmanagement.domain.Inventory;
import com.casestudy.productmanagement.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;

    @Test
    @DisplayName("Can find the ones that have quantity greater than zero by id")
    void findAllByProductIdAndQuantityGreaterThanOrderByQuantityExist(){

        // given
        String testName = "Test Edilecek Urun";
        Inventory inventory = new Inventory().builder()
                .name("Etiler Depo")
                .city("Besiktas")
                .state("Istanbul")
                .status("ACTIVE")
                .build();

        Product product = new Product().builder()
                .productId(1L)
                .quantity(10L)
                .description("Test")
                .type("URGENT")
                .name(testName)
                .price(BigDecimal.valueOf(1000))
                .inventory(inventory)
                .build();
        underTest.save(product);

        //when
        List<Product> expected = underTest.findAllByProductIdAndQuantityGreaterThanOrderByQuantity(1L, 0L);

        //then
        assertEquals(testName, expected.get(0).getName(), "Finding products by Id that exist more than zero in the inventories");
    }

}