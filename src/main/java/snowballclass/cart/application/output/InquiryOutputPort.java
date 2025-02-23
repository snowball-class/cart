package snowballclass.cart.application.output;

import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;

import java.util.List;
import java.util.UUID;

public interface InquiryOutputPort {
    Cart getCart(UUID memberUUID);
    List<Item> getItemList(Cart cart);
}
