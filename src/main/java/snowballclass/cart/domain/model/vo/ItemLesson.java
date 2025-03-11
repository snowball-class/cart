package snowballclass.cart.domain.model.vo;

import java.time.LocalDate;
import java.util.List;

public record ItemLesson(
        Long itemId,
        Long cartId,
        LocalDate createdAt,
        LessonInfo lessonInfo
) {

}
