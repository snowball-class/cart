package snowballclass.cart.application.input;

import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.domain.Cart;

import java.util.UUID;

@Service
public class InquiryInputPort implements InquiryUsecase {
    private final InquiryOutputPort inquiryOutputPort;

    public InquiryInputPort(InquiryOutputPort inquiryOutputPort) {
        this.inquiryOutputPort = inquiryOutputPort;
    }

    @Override
    public Cart getCart(UUID memberUUID) {
        return inquiryOutputPort.getCart(memberUUID);
    }
}
