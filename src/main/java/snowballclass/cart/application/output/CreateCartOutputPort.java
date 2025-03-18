package snowballclass.cart.application.output;

import snowballclass.cart.domain.Cart;

public interface CreateCartOutputPort {
    Cart create(Cart cart);
}
