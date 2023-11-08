package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.Optional;

@SpringBootTest
class ProductServiceImplMockTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveProduct() {
        // Create a product
        Product product = new Product();
        product.setIdProduct(1L);
        product.setTitle("Test Product");

        // Mock the behavior of the productRepository
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

        // Call the method to be tested
        Product retrievedProduct = productService.retrieveProduct(1L);

        Assertions.assertNotNull(retrievedProduct);
        Assertions.assertEquals("Test Product", retrievedProduct.getTitle());
    }
}