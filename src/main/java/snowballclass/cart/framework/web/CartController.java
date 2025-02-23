package snowballclass.cart.framework.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import snowballclass.cart.application.usecase.AddItemUsecase;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;
import snowballclass.cart.framework.web.dto.output.ApiResponse;

@Tag(name="장바구니 API", description = "Cart")
@RestController
public class CartController {
    private final AddItemUsecase addItemUsecase;

    // 생성자를 통해 의존성 주입
    public CartController(AddItemUsecase addItemUsecase) {
        this.addItemUsecase = addItemUsecase;
    }

    @Operation(summary = "장바구니 상품 추가")
    @PostMapping("/cart/item")
    public ApiResponse<Boolean> addItem(@RequestBody AddItemInputDto inputDto) {
        return ApiResponse.success(addItemUsecase.addItem(inputDto));
    }
}
