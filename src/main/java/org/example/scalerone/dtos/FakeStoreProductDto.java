package org.example.scalerone.dtos;

import lombok.Getter;
import org.example.scalerone.models.Category;

@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Long price;
    private String category;
}
