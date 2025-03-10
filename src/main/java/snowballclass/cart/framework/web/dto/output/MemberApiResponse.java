package snowballclass.cart.framework.web.dto.output;

import org.springframework.http.HttpStatus;

public record MemberApiResponse<T>(
        Integer status,
        String message,
        T data
) {
}