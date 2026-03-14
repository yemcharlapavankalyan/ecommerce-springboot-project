package com.ecommerce.project.payload;

import java.util.List;

public class ProductResponse {

    private List<ProductDTO> content;

    // No-args constructor
    public ProductResponse() {
    }

    // All-args constructor
    public ProductResponse(List<ProductDTO> content) {
        this.content = content;
    }

    // Getter
    public List<ProductDTO> getContent() {
        return content;
    }

    // Setter
    public void setContent(List<ProductDTO> content) {
        this.content = content;
    }
}