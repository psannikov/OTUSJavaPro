package ru.otus.pro.psannikov.reactive.service.controllers;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
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
        Mono<Product> productMono = productsService.findById(id);
        Mono<ProductDetailsDto> productDetailsDtoMono = productDetailsService.getProductDetailsById(id);
        ProductDetailsExtendDto productWithDetailDto = new ProductDetailsExtendDto();
        return Mono.zip(productMono, productDetailsDtoMono).map(tuple -> {
            Product product = tuple.getT1();
            ProductDetailsDto details = tuple.getT2();
            productWithDetailDto.setId(product.getId());
            productWithDetailDto.setName(product.getName());
            productWithDetailDto.setDescription(details.getDescription());
            return productWithDetailDto;
        });
    }
    @GetMapping("/")
    public Flux<ProductDetailsExtendDto> getProductDetailsByIds(@RequestParam("ids") List<Long> ids) {
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
