package com.thattallprogrammer.Thoth.data.checklist;

public class ChecklistNotFoundException extends RuntimeException
{
  public ChecklistNotFoundException(String id)
  {
    super("Could not find Checklist with ID " + id);
  }
}
