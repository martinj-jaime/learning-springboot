package guru.springfamework.services;

import guru.springfamework.domain.Order;
import guru.springfamework.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    public List<Order> findAll() { return this.orderRepository.findAll(); }

    public Optional<Order> findById(Long id) { return this.orderRepository.findById(id); }


    public Order save(Order order) { return this.orderRepository.save(order); }
}
