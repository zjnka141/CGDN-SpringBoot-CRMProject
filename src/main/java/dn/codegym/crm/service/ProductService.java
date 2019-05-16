package dn.codegym.crm.service;

import dn.codegym.crm.dto.ProductDTO;
import dn.codegym.crm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllByDeletedIsFalse(Pageable pageable);
    Page<Product> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);
    void create(ProductDTO productDTO);
    void update(ProductDTO productDTO);
    ProductDTO findById(String id);
    void delete(String id);
    Iterable<Product> findAllByDeletedIsFalse();
}
