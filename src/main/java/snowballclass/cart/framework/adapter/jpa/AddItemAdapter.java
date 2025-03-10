package snowballclass.cart.framework.adapter.jpa;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.AddItemOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

import java.util.UUID;

@Repository
public class AddItemAdapter implements AddItemOutputPort {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public AddItemAdapter(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public Boolean addItem(UUID memberUUID, Long lessonId) {
        Cart cart = cartRepository.findByMemberUUID(memberUUID).orElse(
                cartRepository.save(new Cart(memberUUID))
        );
        Item newItem = Item.create(cart, lessonId);
        itemRepository.save(newItem);
        return true;
    }
}
