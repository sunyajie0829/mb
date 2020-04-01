package com.felix.sms_admin.service;

import com.felix.common.result.FelixResult;
import com.felix.mbg.model.TClass;

public interface ClazzService {
    public FelixResult add(TClass tClass) throws Exception;
    public FelixResult update(TClass tClass) throws Exception;
    public FelixResult list() throws Exception;
    public FelixResult info(TClass tClass) throws Exception;
}
