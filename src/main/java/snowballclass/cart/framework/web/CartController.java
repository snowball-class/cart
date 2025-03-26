package snowballclass.cart.framework.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import snowballclass.cart.application.usecase.CreateCartUsecase;
import snowballclass.cart.application.usecase.InquiryUsecase;
import snowballclass.cart.application.usecase.RemoveCartUsecase;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.framework.web.dto.output.ApiResponse;

import java.util.UUID;

@Tag(name="장바구니 API", description = "Cart")
@RestController
@RequiredArgsConstructor
public class CartController {
    private final InquiryUsecase inquiryUsecase;
    private final CreateCartUsecase createCartUsecase;
    private final RemoveCartUsecase removeCartUsecase;

    @Operation(summary = "장바구니 조회")
    @GetMapping("/cart")
    public ApiResponse<Cart> get(@RequestParam Long cartId) {
        return ApiResponse.success(inquiryUsecase.getCart(cartId));
    }

    @Operation(summary = "장바구니 생성")
    @PostMapping("/cart")
    public ApiResponse<Cart> create(
            @RequestBody UUID memberUUID
    ) {
        return ApiResponse.success(createCartUsecase.create(memberUUID));
    }

    @Operation(summary = "장바구니 삭제")
    @DeleteMapping("/cart")
    public ApiResponse<Boolean> removeItem(@RequestParam Long cartId) {
        return ApiResponse.success(removeCartUsecase.remove(cartId));
    }
}
