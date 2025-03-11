package snowballclass.cart.infra.member;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import snowballclass.cart.framework.web.dto.output.ApiResponse;
import snowballclass.cart.framework.web.dto.output.MemberInfoResponse;

import java.util.Map;

public interface MemberService {
    @GetExchange("/member")
    ApiResponse<MemberInfoResponse> getMemberInfo(
            @RequestHeader String Authorization
    );
}
