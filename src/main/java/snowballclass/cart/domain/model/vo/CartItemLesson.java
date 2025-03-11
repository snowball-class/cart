package snowballclass.cart.domain.model.vo;

import snowballclass.cart.domain.Item;

import java.util.List;
import java.util.UUID;

public record CartItemLesson(
        Long id,
        UUID memberUUID,
        List<ItemLesson> itemList
) {

}
