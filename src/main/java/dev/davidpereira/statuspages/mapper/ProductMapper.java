package dev.davidpereira.statuspages.mapper;

import dev.davidpereira.statuspages.dto.ProductGroupPayload;
import dev.davidpereira.statuspages.model.ProductGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper extends PayloadMapper<ProductGroup, ProductGroupPayload> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

}
