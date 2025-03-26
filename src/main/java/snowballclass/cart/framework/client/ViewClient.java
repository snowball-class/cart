package snowballclass.cart.framework.client;

import org.springframework.web.service.annotation.PostExchange;
import snowballclass.cart.framework.web.dto.output.ApiResponse;

import java.util.UUID;

public interface ViewClient {
    @PostExchange
    ApiResponse createMemberCart(UUID memberUUID, Long cartId);
}