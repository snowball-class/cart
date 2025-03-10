package snowballclass.cart.framework.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import snowballclass.cart.application.usecase.AddItemUsecase;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.application.usecase.RemoveItemUsecase;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;
import snowballclass.cart.framework.web.dto.output.ApiResponse;
import snowballclass.cart.framework.web.dto.output.CartDto;

@Tag(name="장바구니 API", description = "Cart")
@RestController
public class CartController {
    private final AddItemUsecase addItemUsecase;
    private final InquiryUsecase inquiryUsecase;
    private final RemoveItemUsecase removeItemUsecase;

    public CartController(AddItemUsecase addItemUsecase, InquiryUsecase inquiryUsecase, RemoveItemUsecase removeItemUsecase) {
        this.addItemUsecase = addItemUsecase;
        this.inquiryUsecase = inquiryUsecase;
        this.removeItemUsecase = removeItemUsecase;
    }

    @Operation(summary = "장바구니 상품 추가")
    @PostMapping("/cart/item")
    public ApiResponse<Boolean> addItem(
            @RequestBody AddItemInputDto inputDto,
            @RequestHeader String token
    ) {
        return ApiResponse.success(addItemUsecase.addItem(inputDto, token));
    }

    @Operation(summary = "장바구니 조회")
    @GetMapping("/cart")
    public ApiResponse<CartDto> getCart(
            @RequestHeader String token
    ) {
        return ApiResponse.success(inquiryUsecase.getCart(token));
    }

    @Operation(summary = "장바구니 상품 삭제")
    @DeleteMapping("/cart/{itemId}")
    public ApiResponse<Boolean> removeItem(
            @PathVariable Long itemId,
            @RequestHeader String token
    ) {
        return ApiResponse.success(removeItemUsecase.removeItem(itemId, token));
    }
}
