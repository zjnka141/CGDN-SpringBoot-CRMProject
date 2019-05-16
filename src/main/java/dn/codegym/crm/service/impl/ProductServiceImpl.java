package dn.codegym.crm.service.impl;

import dn.codegym.crm.dto.ProductDTO;
import dn.codegym.crm.entity.Product;
import dn.codegym.crm.repository.ProductRepository;
import dn.codegym.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());

        productRepository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElse(null);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());

        productRepository.save(product);
    }

    @Override
    public ProductDTO findById(String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setDeleted(product.isDeleted());

            return productDTO;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Product product = productRepository.findById(id).orElse(null);
        product.setDeleted(true);
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> findAllByDeletedIsFalse() {
        return productRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Page<Product> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return productRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Page<Product> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return productRepository.findAllByDeletedIsFalseAndNameContaining(name, pageable);
    }
}
