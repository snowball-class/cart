package snowballclass.cart.application.usecase;

import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

public interface AddItemUsecase {
    public Boolean addItem(AddItemInputDto inputDto, String token);
}
