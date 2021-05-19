package com.thattallprogrammer.Thoth.data.cci;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CciNotFoundAdvice
{
  @ResponseBody
  @ExceptionHandler(CciNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String cciNotFoundMessage(CciNotFoundException ex)
  {
    return ex.getMessage();
  }
}
