package guru.springfamework.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "orders_table")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // TODO manage as enum
    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // TODO relationship
    @Column(name = "product_id")
    private Long product;

    public Order() { }

    @Builder
    public Order(Long id, String state, Customer customer) {
        this.id = id;
        this.state = state;
        this.customer = customer;
    }
}
