package guru.springfamework.controllers;

import guru.springfamework.converters.OrderConverter;
import guru.springfamework.domain.Order;
import guru.springfamework.dto.OrderDTO;
import guru.springfamework.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${apiPrefix}/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> listOrders() {
        List<Order> orders = this.orderService.findAll();
        List<OrderDTO> orderDTOS = orders.stream()
                .map(OrderConverter::convertOrderToOrderDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOS);
    }

}
