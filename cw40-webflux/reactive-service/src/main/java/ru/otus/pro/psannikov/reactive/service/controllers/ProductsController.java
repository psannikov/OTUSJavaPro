package ru.otus.pro.psannikov.reactive.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.pro.psannikov.reactive.service.dtos.ProductDto;
import ru.otus.pro.psannikov.reactive.service.entities.Product;
import ru.otus.pro.psannikov.reactive.service.services.ProductsService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productsService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return productsService.findById(id);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody ProductDto productDto) {
        return productsService.create(productDto);
    }
}
