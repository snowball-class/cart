package snowballclass.cart.framework.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.RemoveCartOutputPort;
import snowballclass.cart.framework.jpa.CartRepository;

@Repository
@RequiredArgsConstructor
public class RemoveCartAdapter implements RemoveCartOutputPort {
    private final CartRepository cartRepository;

    public Boolean remove(Long cartId) {
        cartRepository.deleteById(cartId);
        return true;
    }
}
