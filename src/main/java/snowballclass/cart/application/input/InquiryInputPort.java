package snowballclass.cart.application.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.domain.Cart;

@Service
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUsecase {
    private final InquiryOutputPort inquiryOutputPort;
    @Override
    @Transactional(readOnly = true)
    public Cart getCart(Long cartId) {
        return inquiryOutputPort.getCart(cartId);
    }
}
