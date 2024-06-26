package com.siki.product.dto.product;

import com.siki.product.model.ProductAttributeValue;

public record ProductAttributeValueDto(
        Long id,
        String value,
        String image,
        Long attributeId
) {

    public static  ProductAttributeValueDto fromModel(ProductAttributeValue productAttributeValue) {
        return new ProductAttributeValueDto(productAttributeValue.getId(), productAttributeValue.getValue(), productAttributeValue.getImage(), productAttributeValue.getProductAttribute().getId());
    }
}
