package com.myretail.controller.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Project: myretail-parent
 * Package: com.myretail.controller.advice
 * <p>
 * User: vthalapu
 * Date: 4/10/18
 * Time: 6:41 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{


    @ExceptionHandler(value = {IllegalArgumentException.class,IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException re, WebRequest webRequest){
        String str = "this is application specific";
        return handleExceptionInternal(re, str, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

}


//@Component
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle
//            (HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
//            throws IOException, ServletException {
//        response.sendRedirect("/my-error-page");
//    }
//}
