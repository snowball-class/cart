package snowballclass.cart.application.input;

import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
import snowballclass.cart.domain.model.vo.CartItemLesson;
import snowballclass.cart.domain.model.vo.ItemLesson;
import snowballclass.cart.framework.web.dto.output.CartDto;

import java.util.List;
import java.util.UUID;

@Service
public class InquiryInputPort implements InquiryUsecase {
    private final InquiryOutputPort inquiryOutputPort;

    public InquiryInputPort(InquiryOutputPort inquiryOutputPort) {
        this.inquiryOutputPort = inquiryOutputPort;
    }

    @Override
    public CartItemLesson getCart(String token) {
        UUID memberUUID = inquiryOutputPort.getMemberUUID(token);
        Cart cart = inquiryOutputPort.getOrCreateCart(memberUUID);
        List<ItemLesson> itemList = inquiryOutputPort.getItemList(cart);

        return new CartItemLesson(cart.getId(), cart.getMemberUUID(), itemList);
    }
}
