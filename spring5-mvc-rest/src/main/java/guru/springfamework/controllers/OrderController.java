package guru.springfamework.controllers;

import guru.springfamework.domain.Order;
import guru.springfamework.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping
    public List<Order> listOrders() {
        return this.orderService.findAll();
    }

}
