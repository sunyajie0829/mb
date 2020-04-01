package com.felix.sms_admin.service.serviceImpl;

import com.felix.common.result.FelixResult;
import com.felix.common.result.ResultEnum;
import com.felix.common.result.ResultUtil;
import com.felix.mbg.mapper.TStudentMapper;
import com.felix.mbg.model.TStudent;
import com.felix.mbg.model.TStudentExample;
import com.felix.security.util.JWTUtils;
import com.felix.sms_admin.domain.MemberDetials;
import com.felix.sms_admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TStudentMapper studentMapper;
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public FelixResult register(TStudent student) throws Exception{
        int count = 0;
        count = studentMapper.insertSelective(student);
        if (count > 0){
            return ResultUtil.success(ResultEnum.COMMON_SUCCESS,student);
        }else{
            return ResultUtil.failed(ResultEnum.COMMON_FALID);
        }
    }

    @Override
    public FelixResult login(TStudent student) throws Exception{
        int count = 0;
        TStudentExample example = new TStudentExample();
        example.createCriteria().andUsernameEqualTo(student.getUsername());
        TStudent tStudent = studentMapper.selectByExample(example).get(0);
        if (passwordEncoder.matches(passwordEncoder.encode(student.getPassword()),tStudent.getPassword()))
        {
            Map map = new HashMap();
            map.put("token",jwtUtils.creatToken(new MemberDetials(tStudent)));
            return ResultUtil.success(ResultEnum.COMMON_SUCCESS,map);
        } else{
            return ResultUtil.failed(ResultEnum.COMMON_FALID);
        }
    }

    @Override
    public FelixResult info(TStudent student) throws Exception {
        int count = 0;
        TStudentExample example = new TStudentExample();
        example.createCriteria().andUsernameEqualTo(student.getUsername());
        List<TStudent> studentList = studentMapper.selectByExample(example);
        if (studentList.size() > 0){
            return ResultUtil.success(ResultEnum.COMMON_SUCCESS,studentList.get(0));
        }else{
            return ResultUtil.failed(ResultEnum.COMMON_FALID);
        }
    }
}
