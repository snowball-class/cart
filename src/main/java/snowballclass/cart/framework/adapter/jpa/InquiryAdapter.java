package snowballclass.cart.framework.adapter.jpa;

import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;

import java.util.List;
import java.util.UUID;

@Repository
public class InquiryAdapter implements InquiryOutputPort {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public InquiryAdapter(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Cart getCart(UUID memberUUID) {
        return cartRepository.findByMemberUUID(memberUUID).orElseThrow(
                () -> new RuntimeException("장바구니를 찾을 수 없습니다")
        );
    }

    @Override
    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("항목을 찾을 수 없습니다"));
    }

    @Override
    public List<Item> getItemList(Cart cart) {
        return itemRepository.findByCartAndDeletedIs(cart, false);
    }
}
