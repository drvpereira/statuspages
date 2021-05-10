package dev.davidpereira.statuspages.controller;

import dev.davidpereira.statuspages.model.ProductGroup;
import dev.davidpereira.statuspages.payload.ProductGroupPayload;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductGroupController extends CrudController<ProductGroup, ProductGroupPayload, Long> {

}
