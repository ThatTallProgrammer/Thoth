package com.thattallprogrammer.Thoth.data.cci;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CciResource
{
  private final CciRepository repository;
  private final CciModelAssembler assembler;

  public CciResource(CciRepository repository, CciModelAssembler assembler)
  {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/cci")
  CollectionModel<EntityModel<Cci>> all()
  {
    List<EntityModel<Cci>> ccis = repository.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(ccis);
  }

  @GetMapping("/cci/{id}")
  EntityModel<Cci> one(@PathVariable String id)
  {
    Cci cci = repository.findById(id)
        .orElseThrow(() -> new CciNotFoundException(id));

    return assembler.toModel(cci);
  }

  @PutMapping("/cci/{id}")
  ResponseEntity<?> replaceCci(@RequestBody Cci newCci, @PathVariable String id)
  {
    newCci.setCciId(id);
    EntityModel<Cci> entityModel = assembler.toModel(repository.save(newCci));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @DeleteMapping("/cci/{id}")
  void deleteCci(@PathVariable String id)
  {
    repository.deleteById(id);
  }
}
