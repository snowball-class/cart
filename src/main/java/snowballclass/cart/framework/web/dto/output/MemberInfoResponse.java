package snowballclass.cart.framework.web.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class MemberInfoResponse {
    private Boolean result;
    private String name;
    private String nickname;
    private String email;
    private LocalDateTime joinDate;
}
