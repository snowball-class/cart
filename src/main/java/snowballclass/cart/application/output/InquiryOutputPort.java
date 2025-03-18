package snowballclass.cart.application.output;

import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
import java.util.UUID;

public interface InquiryOutputPort {
    Cart getCart(UUID memberUUID);
    Item getItem(Long itemId);
    UUID getMemberUUID(String token);
}
