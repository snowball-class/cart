package snowballclass.cart.domain.model.vo;

import snowballclass.cart.framework.web.dto.output.LessonInfoResponse;

public record LessonInfo(
        Long lessonId,
        String title,
        String tutor,
        Integer price,
        String thumbnailUrl
) {
    public static LessonInfo from(LessonInfoResponse lessonInfoResponse) {
        return new LessonInfo(
                lessonInfoResponse.lessonId(),
                lessonInfoResponse.title(),
                lessonInfoResponse.tutor(),
                lessonInfoResponse.price(),
                lessonInfoResponse.thumbnailUrl()
        );
    }
}
