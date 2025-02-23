package snowballclass.cart.application.output;

import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

public interface AddItemOutputPort {
    Boolean addItem(AddItemInputDto inputDto);
}
