package snowballclass.cart.application.usecase;

import snowballclass.cart.domain.Cart;

import java.util.UUID;

public interface CreateCartUsecase {
    Cart create(UUID memberUUID);
}
