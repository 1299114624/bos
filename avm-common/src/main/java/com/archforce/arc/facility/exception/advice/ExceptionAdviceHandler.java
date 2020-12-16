package com.archforce.arc.facility.exception.advice;

import com.archforce.arc.facility.exception.ApplicationException;
import com.archforce.arc.facility.exception.BusinessException;
import com.archforce.arc.facility.exception.ErrorConstant;
import com.archforce.arc.facility.utils.ResBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class ExceptionAdviceHandler {

    @ExceptionHandler(BusinessException.class)
    public ResBody handleServiceException(BusinessException e) {
        return ResBody.error(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResBody processException(Exception e, HttpServletResponse response) {
        if (e instanceof ApplicationException) {
            final ApplicationException applicationException = (ApplicationException) e;
            if (ErrorConstant.UNAUTHORIZED_CODE.equals(applicationException.getErrorCode())) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return ResBody.error(applicationException);
        }
        String message = "程序错误，请联系管理员";
        return ResBody.error(new ApplicationException(message));
    }
}
