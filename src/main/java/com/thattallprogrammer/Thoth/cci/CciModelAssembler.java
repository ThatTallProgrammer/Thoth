package com.thattallprogrammer.Thoth.cci;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CciModelAssembler implements RepresentationModelAssembler<Cci, EntityModel<Cci>>
{
  @Override
  public EntityModel<Cci> toModel(Cci cci)
  {
    return EntityModel.of(cci,
        WebMvcLinkBuilder.linkTo(methodOn(CciResource.class).one(cci.getCciId())).withSelfRel(),
        linkTo(methodOn(CciResource.class).all()).withRel("cci")
    );
  }
}
