package snowballclass.cart.application.output;

import snowballclass.cart.domain.Cart;

import java.util.UUID;

public interface InquiryOutputPort {
    Cart getCart(Long cartId);
}
