package snowballclass.cart.global.exception;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
