package com.thattallprogrammer.Thoth.checklist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChecklistResource
{
  private ChecklistRepository repository;

  public ChecklistResource(ChecklistRepository repository)
  {
    this.repository = repository;
  }

  @GetMapping("/checklist")
  List<Checklist> all()
  {
    return repository.findAll();
  }

  @GetMapping("/checklist/{id}")
  Checklist one(@PathVariable String id)
  {
    return repository.findById(id)
        .orElseThrow(RuntimeException::new); // todo: replace with custom exception
  }
}
