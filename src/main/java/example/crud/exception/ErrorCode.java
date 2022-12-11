package example.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_NULL("null이 아닌 값, 공백이 아닌 문자를 하나 이상 포함해야 합니다",400);

    private final String message;
    private final int status;
}

