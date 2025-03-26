package snowballclass.cart.application.output;

import java.util.UUID;

public interface ViewOutputPort {
    public void createMemberCart(UUID memberUUID, Long cartId);
}
