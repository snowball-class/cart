package snowballclass.cart.application.input;

import org.springframework.stereotype.Service;
import snowballclass.cart.application.output.RemoveItemOutputPort;
import snowballclass.cart.application.usecase.RemoveItemUsecase;

@Service
public class RemoveItemInputPort implements RemoveItemUsecase {
    private final RemoveItemOutputPort removeItemOutputPort;

    public RemoveItemInputPort(RemoveItemOutputPort removeItemOutputPort) {
        this.removeItemOutputPort = removeItemOutputPort;
    }

    @Override
    public Boolean removeItem(Long itemId) {
        return removeItemOutputPort.remove(itemId);
    }
}
