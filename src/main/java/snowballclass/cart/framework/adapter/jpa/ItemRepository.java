package snowballclass.cart.framework.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import snowballclass.cart.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
