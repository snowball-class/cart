package snowballclass.cart.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import snowballclass.cart.application.input.RemoveCartInputPort;
import snowballclass.cart.application.output.RemoveCartOutputPort;
import snowballclass.cart.domain.Cart;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("카트 삭제 서비스")
public class RemoveCartInputPortTest {
    @Mock
    private RemoveCartOutputPort removeCartOutputPort;

    @InjectMocks
    private RemoveCartInputPort removeCartInputPort;

    @Test
    @DisplayName("카트 삭제 테스트")
    void removeTest() {
        // given
        Cart cart = new Cart(1L);
        given(removeCartOutputPort.remove(cart.getId())).willReturn(true);

        // when
        Boolean result = removeCartInputPort.remove(cart.getId());

        // then
        assertEquals(true,result);

        // verify
        verify(removeCartOutputPort, times(1)).remove(cart.getId());
    }
}
