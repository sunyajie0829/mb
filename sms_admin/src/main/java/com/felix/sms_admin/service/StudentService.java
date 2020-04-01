package com.felix.sms_admin.service;

import com.felix.common.result.FelixResult;
import com.felix.mbg.model.TStudent;

public interface StudentService {
    public FelixResult register(TStudent student) throws Exception;
    public FelixResult login(TStudent student) throws Exception;
    public FelixResult info(TStudent student) throws Exception;
}
