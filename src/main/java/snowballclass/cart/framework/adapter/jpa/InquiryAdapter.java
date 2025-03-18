package snowballclass.cart.framework.adapter.jpa;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class InquiryAdapter implements InquiryOutputPort {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public Cart getOrCreateCart(UUID memberUUID) {
        return cartRepository.findByMemberUUID(memberUUID).orElseGet(
                () -> cartRepository.save(
                        new Cart(memberUUID)
                )
        );
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
    public UUID getMemberUUID(String token) {
        // TODO : member service 에서 데이터 전달 필요
        // return memberService.getMemberInfo(token).data().getMemberUUID();
        return UUID.randomUUID();
    }
}
