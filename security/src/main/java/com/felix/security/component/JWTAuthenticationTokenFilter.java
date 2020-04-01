package com.felix.security.component;

import com.alibaba.fastjson.JSONObject;
import com.felix.common.exception.FelixException;
import com.felix.common.result.ResultEnum;
import com.felix.security.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Token");
        if (!StringUtils.isEmpty(token)){
            if (SecurityContextHolder.getContext().getAuthentication() == null){
                try {
                    String username = jwtUtils.getUserNameFromToken(token);
                    System.out.println("Request member: "+ username);
                    System.out.println("Request url: "+ request.getRequestURL());
                    System.out.println("===========Release 时考虑移除下方Log=========");
                    System.out.println("Request param: " + JSONObject.toJSONString(request.getParameterMap()));
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } catch (Exception e) {
                    throw new FelixException(ResultEnum.COMMON_FALID);
                }
            }
        }else{
            throw new FelixException(ResultEnum.COMMON_FALID);
        }
        filterChain.doFilter(request,response);
    }
}
