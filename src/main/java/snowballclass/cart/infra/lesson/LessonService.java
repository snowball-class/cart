package snowballclass.cart.infra.lesson;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import snowballclass.cart.framework.web.dto.output.ApiResponse;
import snowballclass.cart.framework.web.dto.output.LessonInfoResponse;
import snowballclass.cart.framework.web.dto.output.MemberInfoResponse;

import java.util.List;

public interface LessonService {
    @GetExchange("/lessons/bulk")
    ApiResponse<List<LessonInfoResponse>> getLessonListByIdList(
            @RequestParam String ids
    );
}
