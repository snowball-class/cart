package snowballclass.cart.application.output;

import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

import java.util.UUID;

public interface AddItemOutputPort {
    Boolean addItem(UUID memberUUID, Long lessonId);
}
