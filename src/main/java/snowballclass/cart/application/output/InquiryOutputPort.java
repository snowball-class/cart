package snowballclass.cart.application.output;

import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
import snowballclass.cart.domain.model.vo.ItemLesson;

import java.util.List;
import java.util.UUID;

public interface InquiryOutputPort {
    Cart getOrCreateCart(UUID memberUUID);

    Cart getCart(UUID memberUUID);
    Item getItem(Long itemId);
    UUID getMemberUUID(String token);
    List<ItemLesson> getItemList(Cart cart);
}
