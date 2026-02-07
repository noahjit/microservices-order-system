package com.noah.order_service.service;

import com.noah.order_service.dto.OrderRequest;
import com.noah.order_service.dto.Product;
import com.noah.order_service.model.Order;
import com.noah.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String productServiceUrl;

    public Order createOrder(OrderRequest orderRequest) {
        Product product = restTemplate.getForObject(productServiceUrl + "/api/products/" + orderRequest.getProductId(), Product.class);

        if (product == null)
            throw new RuntimeException("Product not found");

        if (product.getStock() < orderRequest.getQuantity())
            throw new RuntimeException("Not enough stock");

        Double totalPrice = product.getPrice() * orderRequest.getQuantity();
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CONFIRMED");
        order.setQuantity(orderRequest.getQuantity());
        order.setTotalPrice(totalPrice);
        order.setProductId(orderRequest.getProductId());

        return orderRepository.save(order);
    }

}
