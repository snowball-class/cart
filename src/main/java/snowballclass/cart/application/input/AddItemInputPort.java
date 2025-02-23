package snowballclass.cart.application.input;

import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.AddItemOutputPort;
import snowballclass.cart.application.usecase.AddItemUsecase;
import snowballclass.cart.framework.web.dto.input.AddItemInputDto;

@Service
public class AddItemInputPort implements AddItemUsecase {
    private final AddItemOutputPort addItemOutputPort;

    public AddItemInputPort(AddItemOutputPort addItemOutputPort) {
        this.addItemOutputPort = addItemOutputPort;
    }

    @Override
    public Boolean addItem(AddItemInputDto inputDto) {
        return addItemOutputPort.addItem(inputDto);
    }
}
