package re.edu.md3ss15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.md3ss15.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}