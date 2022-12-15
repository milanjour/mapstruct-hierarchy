package org.example;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {
    CategorySubcategoriesDecorator.class,
})
public interface CategoryConverter {

  @Mappings({
      @Mapping(source = ".", target = "subCategories")
  })
  CategoryDto convertEntityToDto(CategoryEntity catalogEntity, @Context Integer levels);

}