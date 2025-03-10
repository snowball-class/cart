package snowballclass.cart.infra.member;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import snowballclass.cart.framework.web.dto.output.MemberApiResponse;

import java.util.Map;

public interface MemberService {
    @GetExchange("/member")
    MemberApiResponse<Map<String, String>> getMemberInfo(
            @RequestHeader String Authorization
    );
}
