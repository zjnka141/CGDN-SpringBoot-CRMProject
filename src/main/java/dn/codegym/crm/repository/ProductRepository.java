package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByDeletedIsFalse(Pageable pageable);
    Page<Product> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);
    Iterable<Product> findAllByDeletedIsFalse();
}
