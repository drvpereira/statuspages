package dev.davidpereira.statuspages.controller;

import dev.davidpereira.statuspages.model.Product;
import dev.davidpereira.statuspages.payload.ProductPayload;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends CrudController<Product, ProductPayload, Long> {

}
