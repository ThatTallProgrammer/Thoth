package com.thattallprogrammer.Thoth.data.checklist;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ChecklistModelAssembler implements RepresentationModelAssembler<Checklist, EntityModel<Checklist>>
{
  @Override
  public EntityModel<Checklist> toModel(Checklist checklist)
  {
    return EntityModel.of(
        checklist,
        linkTo(methodOn(ChecklistResource.class).one(checklist.getChecklistId())).withSelfRel(),
        linkTo(methodOn(ChecklistResource.class).all()).withRel("checklist")
    );
  }
}
