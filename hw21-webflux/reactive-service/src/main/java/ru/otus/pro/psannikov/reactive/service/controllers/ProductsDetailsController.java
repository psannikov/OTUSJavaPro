package ru.otus.pro.psannikov.reactive.service.controllers;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.pro.psannikov.reactive.service.dtos.ProductDetailsDto;
import ru.otus.pro.psannikov.reactive.service.dtos.ProductDetailsExtendDto;
import ru.otus.pro.psannikov.reactive.service.dtos.ProductDto;
import ru.otus.pro.psannikov.reactive.service.entities.Product;
import ru.otus.pro.psannikov.reactive.service.services.ProductDetailsService;
import ru.otus.pro.psannikov.reactive.service.services.ProductsService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/detailed")
@RequiredArgsConstructor
public class ProductsDetailsController {
    private final ProductDetailsService productDetailsService;
    private final ProductsService productsService;
    @GetMapping("/{id}")
    public Mono<ProductDetailsExtendDto> getProductDetailsById(@PathVariable Long id) {
        ProductDetailsExtendDto productDetailsExtendDto = new ProductDetailsExtendDto();
        Mono<Product> product = productsService.findById(id);
        product.map(prod -> {
            productDetailsExtendDto.setId(prod.getId());
            productDetailsExtendDto.setName(prod.getName());
            return productDetailsExtendDto;
        }).subscribe();
        Mono<ProductDetailsDto> productDetailsById = productDetailsService.getProductDetailsById(id);
        productDetailsById.map(prod -> {
            productDetailsExtendDto.setName(prod.getDescription());
            return productDetailsExtendDto;
        }).subscribe();
        return Mono.just(productDetailsExtendDto);
    }
    @GetMapping("/list/{ids}")
    public Flux<ProductDetailsExtendDto> getProductDetailsByIds(@PathVariable List<Long> ids) {
        Flux<ProductDetailsExtendDto> productDetailsExtendDtoFlux = null;
        for(Long id : ids) {
            productDetailsExtendDtoFlux.mergeWith(getProductDetailsById(id));
        }
        return productDetailsExtendDtoFlux;
    }
    @GetMapping
    public Flux<ProductDetailsExtendDto> getAllProductsDetails() {
        Flux<ProductDetailsDto> productsDetails = null;
        Flux<Product> products = productsService.findAll();
        List<ProductDto> productList = (List<ProductDto>) products;
        Flux<ProductDetailsExtendDto> result = null;
        for (ProductDto product : productList) {
            Mono<ProductDetailsDto> productDetails = productDetailsService.getProductDetailsById(product.getId());
            productsDetails.mergeWith(productDetails);
        }
        List<ProductDetailsDto> productDetailsDtoList = (List<ProductDetailsDto>) productsDetails.collectList();
        for (ProductDto productDto : productList) {
            String description = null;
            for (ProductDetailsDto productDetailsDto : productDetailsDtoList) {
                if (productDetailsDto.getId() == productDto.getId()) {
                    description = productDetailsDto.getDescription();
                }
            }
            result.mergeWith((Publisher<? extends ProductDetailsExtendDto>) new ProductDetailsExtendDto(productDto.getId(),productDto.getName(),description));
        }
        return result;
    }

    @GetMapping("/demo")
    public Flux<ProductDetailsDto> getManySlowProducts() {
        Mono<ProductDetailsDto> p1 = productDetailsService.getProductDetailsById(1L);
        Mono<ProductDetailsDto> p2 = productDetailsService.getProductDetailsById(2L);
        Mono<ProductDetailsDto> p3 = productDetailsService.getProductDetailsById(3L);
        return p1.mergeWith(p2).mergeWith(p3);
    }
}
