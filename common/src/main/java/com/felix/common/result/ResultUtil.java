package com.felix.common.result;

public class ResultUtil {
    public static FelixResult success(ResultEnum resultEnum,Object data){
        FelixResult result = new FelixResult();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setStatus("success");
        result.setData(data);
        return result;
    }

    public static FelixResult failed(ResultEnum resultEnum){
        FelixResult result = new FelixResult();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setStatus("failed");
        result.setData(null);
        return result;
    }
}
