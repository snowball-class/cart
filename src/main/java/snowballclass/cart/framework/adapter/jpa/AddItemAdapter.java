package snowballclass.cart.framework.adapter.jpa;

import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.AddItemOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

@Repository
public class AddItemAdapter implements AddItemOutputPort {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public AddItemAdapter(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Boolean addItem(AddItemInputDto inputDto) {
        Cart cart = cartRepository.findByMemberUUID(inputDto.getMemberUUID());
        Item newItem = Item.create(cart, inputDto.getLessonId());
        itemRepository.save(newItem);
        return true;
    }
}
