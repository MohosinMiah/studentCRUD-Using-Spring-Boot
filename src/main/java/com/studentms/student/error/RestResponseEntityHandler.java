package com.studentms.student.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.studentms.student.entity.ErrorMessage;



@ControllerAdvice
@ResponseStatus
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(DepartmentNotFountException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFountException exception, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage( HttpStatus.NOT_FOUND, exception.getMessage() );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    
}
