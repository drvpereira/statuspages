package dev.davidpereira.statuspages.mapper;

import dev.davidpereira.statuspages.model.ProductGroup;
import dev.davidpereira.statuspages.payload.ProductGroupPayload;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductGroupMapper extends PayloadMapper<ProductGroup, ProductGroupPayload> {

    ProductGroupMapper INSTANCE = Mappers.getMapper(ProductGroupMapper.class);

}
