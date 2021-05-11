package dev.davidpereira.statuspages.mapper;

import dev.davidpereira.statuspages.controller.ProductController;
import dev.davidpereira.statuspages.payload.ProductPayload;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<ProductPayload, EntityModel<ProductPayload>> {

    @Override
    public EntityModel<ProductPayload> toModel(ProductPayload payload) {
        return EntityModel.of(payload,
                linkTo(methodOn(ProductController.class).getOne(payload.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getAll()).withRel("products"));
    }

}
