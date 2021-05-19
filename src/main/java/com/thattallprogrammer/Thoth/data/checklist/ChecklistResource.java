package com.thattallprogrammer.Thoth.data.checklist;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChecklistResource
{
  private ChecklistRepository repository;
  private ChecklistModelAssembler assembler;

  public ChecklistResource(ChecklistRepository repository, ChecklistModelAssembler assembler)
  {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/checklist")
  CollectionModel<EntityModel<Checklist>> all()
  {
    List<EntityModel<Checklist>> checklists = repository.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(checklists);
  }

  @GetMapping("/checklist/{id}")
  EntityModel<Checklist> one(@PathVariable String id)
  {
    Checklist checklist = repository.findById(id)
        .orElseThrow(() -> new ChecklistNotFoundException(id));

    return assembler.toModel(checklist);
  }

  @PutMapping("/checklist/{id}")
  ResponseEntity<?> replaceChecklist(@RequestBody Checklist newChecklist, @PathVariable String id)
  {
    newChecklist.setChecklistId(id);
    EntityModel<Checklist> entityModel = assembler.toModel(repository.save(newChecklist));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @DeleteMapping("/checklist/{id}")
  void deleteChecklist(@PathVariable String id)
  {
    repository.deleteById(id);
  }
}
