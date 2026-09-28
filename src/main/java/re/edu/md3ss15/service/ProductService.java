package re.edu.md3ss15.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.edu.md3ss15.entity.Product;
import re.edu.md3ss15.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Product oldProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setSize(product.getSize());
        oldProduct.setToppings(product.getToppings());

        return productRepository.save(oldProduct);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy sản phẩm");
        }

        productRepository.deleteById(id);
    }
}