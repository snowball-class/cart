package snowballclass.cart.framework.adapter.jpa;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.RemoveItemOutputPort;
import snowballclass.cart.domain.Item;

import java.time.LocalDate;

@Repository
public class RemoveItemAdapter implements RemoveItemOutputPort {
    private final ItemRepository itemRepository;

    public RemoveItemAdapter(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public Boolean remove(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("강의를 찾을 수 없습니다"));
        item.setDeleted(true);
        item.setDeletedAt(LocalDate.now());
        return true;
    }
}
