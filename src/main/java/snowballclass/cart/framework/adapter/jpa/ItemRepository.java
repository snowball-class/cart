package snowballclass.cart.framework.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCart(Cart cart);
    List<Item> findByCartAndDeletedIs(Cart cart, Boolean deleted);
}
