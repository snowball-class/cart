package snowballclass.cart.application.usecase;

import snowballclass.cart.framework.web.dto.output.CartDto;

import java.util.UUID;

public interface InquiryUsecase {
    CartDto getCart(UUID memberUUID);
}
