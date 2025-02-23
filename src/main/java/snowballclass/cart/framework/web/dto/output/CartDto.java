package snowballclass.cart.framework.web.dto.output;

import lombok.Getter;
import lombok.Setter;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartDto {
    private Long cartId;
    private Integer count;
    private List<Item> itemList = new ArrayList<>();

    public CartDto(Cart cart, Integer count, List<Item> itemList) {
        this.cartId = cart.getId();
        this.count = count;
        this.itemList = itemList;
    }
}
