package snowballclass.cart.application.usecase;

import snowballclass.cart.framework.web.dto.output.CartDto;

public interface InquiryUsecase {
    CartDto getCart(String access);
}
