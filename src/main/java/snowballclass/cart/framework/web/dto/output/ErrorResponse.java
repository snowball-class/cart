package snowballclass.cart.framework.web.dto.output;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public record ErrorResponse(
        int status,
        String message,
        List<FieldError> errors
) {
    public static ErrorResponse of(int status, String message) {
        List<FieldError> errors = new ArrayList<>();
        return new ErrorResponse(status, message, errors);
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }
    }
}
