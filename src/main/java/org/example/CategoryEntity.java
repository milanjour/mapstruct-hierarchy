package org.example;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;


@Jacksonized
@Builder(toBuilder = true)
@Data
@FieldNameConstants
public class CategoryEntity {

  @Id
  @Builder.Default
  String id = UUID.randomUUID().toString();

  List<String> subCategoryIds;

}
