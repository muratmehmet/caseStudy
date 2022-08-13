package com.casestudy.ordermanagement.request;

public record OrderRequest(Long productId,
                           Long quantity,
                           Long customerId) {
}
