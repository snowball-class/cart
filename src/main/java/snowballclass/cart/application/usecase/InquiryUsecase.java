package snowballclass.cart.application.usecase;

import snowballclass.cart.domain.model.vo.CartItemLesson;

public interface InquiryUsecase {
    CartItemLesson getCart(String token);
}
