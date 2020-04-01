package com.felix.common.exception;

import com.felix.common.result.ResultEnum;

public class FelixException extends RuntimeException {
    private Integer code;

    public FelixException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
