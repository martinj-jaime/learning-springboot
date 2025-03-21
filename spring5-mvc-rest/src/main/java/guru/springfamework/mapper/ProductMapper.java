package guru.springfamework.mapper;

import guru.springfamework.domain.Product;
import guru.springfamework.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "productId", source = "product.id")
    ProductDTO productToProductDTO(Product product);

    @Mapping(target = "id", source = "productId")
    Product productDTOToProduct(ProductDTO productDTO);

    @Mapping(target = "productId", source = "product.id")
    List<ProductDTO> productsToProductDTOs(List<Product> products);


}
