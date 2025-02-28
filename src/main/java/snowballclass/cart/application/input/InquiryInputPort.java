package snowballclass.cart.application.input;

import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
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
    public CartDto getCart(String access) {
        UUID memberUUID = inquiryOutputPort.getMemberUUID(access);
        Cart cart = inquiryOutputPort.getCart(memberUUID);
        List<Item> itemList = inquiryOutputPort.getItemList(cart);
        return new CartDto(cart, itemList.size(),itemList);
    }
}
