package snowballclass.cart.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ENTITY_NOT_FOUND(404, "엔티티를 찾을 수 없습니다."),
    CART_NOT_FOUND(404, "카트가 존재하지 않습니다.")
    ;
    private final int statusCode;
    private final String message;

    ErrorCode(final int statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
