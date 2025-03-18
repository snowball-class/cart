package snowballclass.cart.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import snowballclass.cart.application.input.CreateCartInputPort;
import snowballclass.cart.application.output.CreateCartOutputPort;
import snowballclass.cart.domain.Cart;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("카트 생성 서비스")
public class CreateCartInputPortTest {
    @Mock
    private CreateCartOutputPort createCartOutputPort;

    @InjectMocks
    private CreateCartInputPort createCartInputPort;

    @Test
    @DisplayName("카트 생성 테스트")
    void createTest() {
        // given
        given(createCartOutputPort.create(any(Cart.class))).willReturn(new Cart(1L));

        // when
        Cart result = createCartInputPort.create();

        // then
        assertNotNull(result);
        assertEquals(1,result.getId());

        // verify
        verify(createCartOutputPort, times(1)).create(any(Cart.class));
    }
}
