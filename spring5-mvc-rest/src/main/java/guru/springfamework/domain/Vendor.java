package guru.springfamework.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany()
    @JoinColumn(name = "vendor_id")
    private List<Product> products = new ArrayList<>();

    public Vendor() { }

//    @Builder
//    public Vendor(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    @Builder
    public Vendor(Long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }
}
