package snowballclass.cart.application.input;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.AddItemOutputPort;
import snowballclass.cart.application.output.InquiryOutputPort;
import snowballclass.cart.application.usecase.AddItemUsecase;
import snowballclass.cart.domain.Cart;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

import java.util.UUID;

@Service
public class AddItemInputPort implements AddItemUsecase {
    private final AddItemOutputPort addItemOutputPort;
    private final InquiryOutputPort inquiryOutputPort;

    public AddItemInputPort(AddItemOutputPort addItemOutputPort, InquiryOutputPort inquiryOutputPort) {
        this.addItemOutputPort = addItemOutputPort;
        this.inquiryOutputPort = inquiryOutputPort;
    }

    @Override
    @Transactional
    public Boolean addItem(AddItemInputDto inputDto, String token) {
        UUID memberUUID = inquiryOutputPort.getMemberUUID(token);
        return addItemOutputPort.addItem(memberUUID, inputDto.getLessonId());
    }
}
