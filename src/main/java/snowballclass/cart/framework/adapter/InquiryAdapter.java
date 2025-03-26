package snowballclass.cart.framework.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.framework.jpa.CartRepository;
import snowballclass.cart.global.exception.EntityNotFoundException;
import snowballclass.cart.global.exception.ErrorCode;
@Repository
@RequiredArgsConstructor
public class InquiryAdapter implements InquiryOutputPort {
    private final CartRepository cartRepository;

    @Override
    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(
                () -> new EntityNotFoundException(ErrorCode.CART_NOT_FOUND)
        );
    }
}
