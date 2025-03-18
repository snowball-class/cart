package snowballclass.cart.framework.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import snowballclass.cart.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
