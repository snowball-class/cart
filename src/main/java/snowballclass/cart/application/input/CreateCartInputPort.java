package snowballclass.cart.application.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snowballclass.cart.application.output.CreateCartOutputPort;
import snowballclass.cart.application.usecase.CreateCartUsecase;
import snowballclass.cart.domain.Cart;

@Service
@RequiredArgsConstructor
public class CreateCartInputPort implements CreateCartUsecase {
    private final CreateCartOutputPort createCartOutputPort;

    @Override
    @Transactional
    public Cart create() {
        return createCartOutputPort.create(new Cart());
    }
}
