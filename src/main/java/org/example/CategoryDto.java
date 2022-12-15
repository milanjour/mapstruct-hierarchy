package org.example;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;


@Jacksonized
@Builder(toBuilder = true)
@Data
@FieldNameConstants
public class CategoryDto {

  String id;

  @Builder.Default
  List<String> subCategoryIds = new ArrayList<>();

  @Builder.Default
  List<CategoryDto> subCategories = new ArrayList<>();

}
