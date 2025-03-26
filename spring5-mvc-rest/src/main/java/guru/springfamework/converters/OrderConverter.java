package guru.springfamework.converters;

import guru.springfamework.domain.Order;
import guru.springfamework.dto.CustomerDTO;
import guru.springfamework.dto.OrderDTO;

public abstract class OrderConverter {

    public static OrderDTO convertOrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        //
        orderDTO.setId(order.getId());
        orderDTO.setState(order.getState());
        //
        orderDTO.setCustomer(CustomerDTO.builder()
                .id(order.getCustomer().getId())
                .firstname(order.getCustomer().getFirstName())
                .lastname(order.getCustomer().getLastName())
                .build()
        );
        //
        orderDTO.setProduct_id(order.getProduct());
        return orderDTO;
    }

}
