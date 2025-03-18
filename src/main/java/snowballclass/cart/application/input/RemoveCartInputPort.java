package snowballclass.cart.application.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snowballclass.cart.application.output.RemoveCartOutputPort;
import snowballclass.cart.application.usecase.RemoveCartUsecase;

@Service
@RequiredArgsConstructor
public class RemoveCartInputPort implements RemoveCartUsecase {
    private final RemoveCartOutputPort removeCartOutputPort;

    @Override
    @Transactional
    public Boolean remove(Long cartId) {
        return removeCartOutputPort.remove(cartId);
    }
}
