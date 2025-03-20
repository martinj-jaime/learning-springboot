package guru.springfamework.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String state;
    private Long customer;
    private Double total;
}
