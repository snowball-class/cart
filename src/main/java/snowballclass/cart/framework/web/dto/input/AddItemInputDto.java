package snowballclass.cart.framework.web.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.UUID;

@Getter
@Schema(description = "장바구니 품목 추가 DTO")
public class AddItemInputDto {
    @Schema(description = "강의 ID", defaultValue = "1")
    private Long lessonId;
}
