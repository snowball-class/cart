package snowballclass.cart.application.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snowballclass.cart.application.output.CreateCartOutputPort;
import snowballclass.cart.application.output.ViewOutputPort;
import snowballclass.cart.application.usecase.CreateCartUsecase;
import snowballclass.cart.domain.Cart;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateCartInputPort implements CreateCartUsecase {
    private final CreateCartOutputPort createCartOutputPort;
    private final ViewOutputPort viewOutputPort;

    @Override
    @Transactional
    public Cart create(UUID memberUUID) {
        Cart cart = createCartOutputPort.create(new Cart());
        viewOutputPort.createMemberCart(memberUUID, cart.getId());
        return cart;
    }
}
