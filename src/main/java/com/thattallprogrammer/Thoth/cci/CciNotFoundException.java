package com.thattallprogrammer.Thoth.cci;

public class CciNotFoundException extends RuntimeException
{
  public CciNotFoundException(String id)
  {
    super("Could not find CCI with ID " + id);
  }
}
