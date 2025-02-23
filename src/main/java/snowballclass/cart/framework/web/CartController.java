package snowballclass.cart.framework.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snowballclass.cart.application.usecase.AddItemUsecase;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;
import snowballclass.cart.framework.web.dto.output.ApiResponse;
import snowballclass.cart.framework.web.dto.output.CartDto;

import java.util.UUID;

@Tag(name="장바구니 API", description = "Cart")
@RestController
public class CartController {
    private final AddItemUsecase addItemUsecase;
    private final InquiryUsecase inquiryUsecase;

    public CartController(AddItemUsecase addItemUsecase, InquiryUsecase inquiryUsecase) {
        this.addItemUsecase = addItemUsecase;
        this.inquiryUsecase = inquiryUsecase;
    }

    @Operation(summary = "장바구니 상품 추가")
    @PostMapping("/cart/item")
    public ApiResponse<Boolean> addItem(@RequestBody AddItemInputDto inputDto) {
        return ApiResponse.success(addItemUsecase.addItem(inputDto));
    }

    @Operation(summary = "장바구니 조회")
    @GetMapping("/cart/{memberUUID}")
    public ApiResponse<CartDto> getCart(@PathVariable UUID memberUUID) {
        return ApiResponse.success(inquiryUsecase.getCart(memberUUID));
    }
}
