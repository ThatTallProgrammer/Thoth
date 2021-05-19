package com.thattallprogrammer.Thoth.data.checklist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChecklistNotFoundAdvice
{
  @ResponseBody
  @ExceptionHandler(ChecklistNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String checklistNotFound(ChecklistNotFoundException ex)
  {
    return ex.getMessage();
  }
}
