package snowballclass.cart.application.input;

import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.application.usecase.RemoveItemUsecase;
import snowballclass.cart.domain.Item;
import snowballclass.cart.framework.adapter.jpa.ItemRepository;

@Service
public class RemoveItemInputPort implements RemoveItemUsecase {
    private final InquiryOutputPort inquiryOutputPort;
    private final ItemRepository itemRepository;

    public RemoveItemInputPort(InquiryOutputPort inquiryOutputPort, ItemRepository itemRepository) {
        this.inquiryOutputPort = inquiryOutputPort;
        this.itemRepository = itemRepository;
    }

    @Override
    public Boolean removeItem(Long itemId, String access) {
        Item item = inquiryOutputPort.getItem(itemId);
        item.remove();
        itemRepository.save(item);
        return true;
    }
}
