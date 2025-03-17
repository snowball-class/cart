package snowballclass.cart.framework.adapter.jpa;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.domain.Item;
import snowballclass.cart.domain.model.vo.ItemLesson;
import snowballclass.cart.domain.model.vo.LessonInfo;
import snowballclass.cart.framework.web.dto.output.LessonInfoResponse;
import snowballclass.cart.infra.lesson.LessonService;
import snowballclass.cart.infra.member.MemberService;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class InquiryAdapter implements InquiryOutputPort {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final MemberService memberService;
    private final LessonService lessonService;

    public InquiryAdapter(CartRepository cartRepository, ItemRepository itemRepository, MemberService memberService, LessonService lessonService) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.memberService = memberService;
        this.lessonService = lessonService;
    }

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
    public List<ItemLesson> getItemList(Cart cart) {
        List<Item> itemList = itemRepository.findByCartAndDeletedIs(cart, false);
        String lessonIdListString = itemList
                .stream()
                .map(item -> item.getLessonId().toString())
                .collect(Collectors.joining(","));
        if (lessonIdListString.isBlank()) {
            return List.of();
        }
        Map<Long,LessonInfo> lessonMap = lessonService.getLessonListByIdList(lessonIdListString)
                .data()
                .stream()
                .map(LessonInfo::from)
                .collect(Collectors.toMap(LessonInfo::lessonId, lesson -> lesson));
        return itemList
                .stream()
                .map(item -> new ItemLesson(item.getItemId(), item.getCart().getId(), item.getCreatedAt(), lessonMap.get(item.getLessonId()))).toList();
    }

    @Override
    public UUID getMemberUUID(String token) {
        // TODO : member service 에서 데이터 전달 필요
        // return memberService.getMemberInfo(token).data().getMemberUUID();
        return UUID.randomUUID();
    }
}
