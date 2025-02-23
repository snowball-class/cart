package snowballclass.cart.framework.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import snowballclass.cart.framework.web.dto.output.ApiResponse;

@Tag(name="공통 API", description = "Common")
@RestController
public class CommonController {
    @Operation(summary = "서버 체크 API")
    @GetMapping("/health-check")
    public ApiResponse<String> healthCheck() {
        return ApiResponse.success("Cart Server Listening");
    }
}
