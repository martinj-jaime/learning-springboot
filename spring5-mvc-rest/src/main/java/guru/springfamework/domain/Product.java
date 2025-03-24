package guru.springfamework.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.File;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;

    @Lob
    private byte[] image;

    public Product() {}

    @Builder
    public Product(Long id, String name, Double price, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
