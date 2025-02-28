package snowballclass.cart.infra.member;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import snowballclass.cart.framework.web.dto.output.ApiResponse;

public interface MemberService {
    @GetExchange("/member")
    ApiResponse<String> getMemberInfo(
            @RequestHeader String access
    );
}
