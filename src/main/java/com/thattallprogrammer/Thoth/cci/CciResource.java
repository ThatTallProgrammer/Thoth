package com.thattallprogrammer.Thoth.cci;

import com.thattallprogrammer.Thoth.cci.Cci;
import com.thattallprogrammer.Thoth.cci.CciModelAssembler;
import com.thattallprogrammer.Thoth.cci.CciNotFoundException;
import com.thattallprogrammer.Thoth.cci.CciRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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

//  @PostMapping("/cci")
//  ResponseEntity<?> newCci(@RequestBody Cci cci)
//  {
//    EntityModel<Cci> entityModel = assembler.toModel(repository.save(cci));
//
//    return ResponseEntity
//        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
//        .body(entityModel);
//  }

//  @PutMapping("/cci/{id}")
//  Cci replaceCci(@RequestBody Cci newCci, @PathVariable String id)
//  {
//    return repository.findById(id)
//        .map(cci -> {
//          cci.setCciId(newCci.getCciId());
//          return repository.save(cci);
//        })
//        .orElseGet(() -> {
//          newCci.setCciId(id);
//          return repository.save(newCci);
//        });
//  }

//  @DeleteMapping("/cci/{id}")
//  void deleteCci(@PathVariable String id)
//  {
//    repository.deleteById(id);
//  }
}
