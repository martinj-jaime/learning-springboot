package guru.springfamework.repositories;

import guru.springfamework.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepository extends JpaRepository<Order, Long> {

}
