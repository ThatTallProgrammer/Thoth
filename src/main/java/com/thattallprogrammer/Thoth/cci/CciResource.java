package com.thattallprogrammer.Thoth.cci;

import com.thattallprogrammer.Thoth.cci.reference.CciReference;
import com.thattallprogrammer.Thoth.cci.reference.CciReferenceRepository;
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
  private final CciRepository cciRepository;
  private final CciReferenceRepository cciReferenceRepository;
  private final CciModelAssembler assembler;

  public CciResource(CciRepository repository, CciReferenceRepository cciReferenceRepository,
                     CciModelAssembler assembler)
  {
    this.cciRepository = repository;
    this.cciReferenceRepository = cciReferenceRepository;
    this.assembler = assembler;
  }

  private Cci save(Cci cci)
  {
    cci.getReferences().forEach(cciReferenceRepository::save);
    return cciRepository.save(cci);
  }

  @GetMapping("/cci")
  CollectionModel<EntityModel<Cci>> all()
  {
    List<EntityModel<Cci>> ccis = cciRepository.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(ccis);
  }

  @GetMapping("/cci/{id}")
  EntityModel<Cci> one(@PathVariable String id)
  {
    Cci cci = cciRepository.findById(id)
        .orElseThrow(() -> new CciNotFoundException(id));

    return assembler.toModel(cci);
  }

  @PostMapping("/cci")
  ResponseEntity<?> newCci(@RequestBody Cci cci)
  {
    EntityModel<Cci> entityModel = assembler.toModel(save(cci));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @PutMapping("/cci/{id}")
  Cci replaceCci(@RequestBody Cci newCci, @PathVariable String id)
  {
    return cciRepository.findById(id)
        .map(cci -> {
          cci.setCciId(newCci.getCciId());
          return cciRepository.save(cci);
        })
        .orElseGet(() -> {
          newCci.setCciId(id);
          return cciRepository.save(newCci);
        });
  }

  @DeleteMapping("/cci/{id}")
  void deleteCci(@PathVariable String id)
  {
    cciRepository.deleteById(id);
  }
}
