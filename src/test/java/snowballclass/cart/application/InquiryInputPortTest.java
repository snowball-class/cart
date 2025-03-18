package snowballclass.cart.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import snowballclass.cart.application.input.InquiryInputPort;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.global.exception.EntityNotFoundException;
import snowballclass.cart.global.exception.ErrorCode;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("카트 조회 서비스")
public class InquiryInputPortTest {
    @Mock
    private InquiryOutputPort inquiryOutputPort;

    @InjectMocks
    private InquiryInputPort inquiryInputPort;

    @Test
    @DisplayName("카트 조회 성공 테스트")
    void getCartSuccess() {
        // given
        Long cartId = 1L;
        given(inquiryOutputPort.getCart(cartId)).willReturn(new Cart(cartId));

        // when
        Cart cart = inquiryInputPort.getCart(cartId);

        // then
        assertNotNull(cart);
        assertEquals(1L, cart.getId());

        // verify
        verify(inquiryOutputPort, times(1)).getCart(cartId);
    }

    @Test
    @DisplayName("카트 조회 실패 테스트")
    void getCartFailed() {
        // given
        Long cartId = 999999L;
        String expectedMessage = ErrorCode.CART_NOT_FOUND.getMessage();
        given(inquiryOutputPort.getCart(cartId)).willThrow(new EntityNotFoundException(ErrorCode.CART_NOT_FOUND));

        // when & then
        EntityNotFoundException exception =
            assertThrows(EntityNotFoundException.class, () -> inquiryInputPort.getCart(cartId));

        assertEquals(expectedMessage, exception.getMessage());

        // verify
        verify(inquiryOutputPort, times(1)).getCart(cartId);
    }
}
