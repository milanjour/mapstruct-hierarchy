package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Context;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CategorySubcategoriesDecorator {

  private final CategoryService categoryService;

  public CategorySubcategoriesDecorator(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  public List<CategoryDto> mapSubCategories(CategoryEntity category,
      @Context Integer levels) {
    return getSubcategories(category.getId(), category.getSubCategoryIds(),
        levels);
  }

  List<CategoryDto> getSubcategories(String categoryId, List<String> subCategoriesIds, int level) {
    log.info("getSubcategories with categoryId: {}, rootCategoriesIds: {}, level: {}", categoryId,
        subCategoriesIds, level);
    if (level > 0) {
      return subCategoriesIds.stream()
          .map(subCategoryId -> categoryService.getCategory(subCategoryId, level - 1).get())
          .collect(Collectors.toList());
    } else {
      return Collections.emptyList();
    }

  }

}
