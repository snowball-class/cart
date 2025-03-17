package snowballclass.cart.framework.web.dto.output;

import java.time.LocalDateTime;

public record LessonInfoResponse(
        Long lessonId,
        String title,
        String tutor,
        Long categoryId,
        String categoryName,
        Integer price,
        String content1,
        String content2,
        String thumbnailUrl,
        String videoUrl,
        LocalDateTime createdAt
) {

}
