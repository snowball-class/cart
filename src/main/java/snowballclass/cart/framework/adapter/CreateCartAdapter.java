package snowballclass.cart.framework.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.CreateCartOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.framework.adapter.jpa.CartRepository;

@Repository
@RequiredArgsConstructor
public class CreateCartAdapter implements CreateCartOutputPort {
    private final CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }
}
