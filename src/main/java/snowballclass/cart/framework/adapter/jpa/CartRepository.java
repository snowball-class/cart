package snowballclass.cart.framework.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import snowballclass.cart.domain.Cart;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByMemberUUID(UUID memberUUID);
}
