package snowballclass.cart.framework.web.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.UUID;

@Getter
@Schema(description = "장바구니 품목 추가 DTO")
public class AddItemInputDto {
    @Schema(description = "장바구니 소유자 UUID", defaultValue = "bd5cf4fc-45f1-4531-ae40-7e5c3d0fc697")
    private UUID memberUUID;
    @Schema(description = "강의 ID", defaultValue = "1")
    private Long lessonId;
}
