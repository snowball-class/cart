package snowballclass.cart.framework.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.ViewOutputPort;
import snowballclass.cart.framework.client.ViewClient;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ViewAdapter implements ViewOutputPort {
    private final ViewClient viewClient;

    @Override
    public void createMemberCart(UUID memberUUID, Long cartId) {
        viewClient.createMemberCart(memberUUID, cartId);
    }
}
