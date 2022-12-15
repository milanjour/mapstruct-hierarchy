package org.example;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  
  private final CategoryConverter categoryConverter;

  public Optional<CategoryDto> getCategory(String categoryId, Integer expandCategoryLevels) {
    return categoryRepository.findById(categoryId)
        .map(categoryEntity -> categoryConverter.convertEntityToDto(categoryEntity,
            expandCategoryLevels));
  }

}
