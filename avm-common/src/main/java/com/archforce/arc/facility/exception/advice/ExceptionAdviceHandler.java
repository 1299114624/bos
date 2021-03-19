package com.archforce.arc.facility.exception.advice;

import com.archforce.arc.facility.exception.ApplicationException;
import com.archforce.arc.facility.exception.BusinessException;
import com.archforce.arc.facility.exception.ErrorCodeConstant;
import com.archforce.arc.facility.log.LogUtils;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class ExceptionAdviceHandler {

    @ExceptionHandler(BusinessException.class)
    public ResBody handleServiceException(BusinessException e) {
        String path = getPath();
        LogUtils.info(ExceptionAdviceHandler.class,"系统异常","请求接口异常:{},错误编码为:{}", path, e.getErrorCode(), e);
        return ResBody.error(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(ApplicationException.class)
    public ResBody handleApplicationException(ApplicationException e) {
        String path = getPath();
        LogUtils.error(ExceptionAdviceHandler.class,"系统异常","请求接口:{},系统错误", path ,e);
        return ResBody.error(e);
    }

    @ExceptionHandler({Exception.class})
    public ResBody processException(Exception e, HttpServletResponse response) {
        String path = getPath();
        if (e instanceof ApplicationException) {
            final ApplicationException applicationException = (ApplicationException) e;
            if (ErrorCodeConstant.UNAUTHORIZED_CODE.equals(applicationException.getErrorCode())) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return ResBody.error(applicationException);
        }
        LogUtils.error(ExceptionAdviceHandler.class,"其它异常","请求接口异常:{}", path, e);
        String message = "程序错误，请联系管理员";
        return ResBody.error(new ApplicationException(message));
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResBody handleDuplicateKeyException(DuplicateKeyException e) {
        LogUtils.error(ExceptionAdviceHandler.class,"数据库中已存在该记录异常", e.getMessage(), e);
        return ResBody.error("数据库中已存在该记录");
    }

    private String getPath() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = sra.getRequest();
            return request.getRequestURI();
        } catch (Exception ex) {
            LogUtils.warn(ExceptionAdviceHandler.class, "无法获取path","",ex);
            return "";
        }
    }
}
