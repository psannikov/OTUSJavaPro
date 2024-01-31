package ru.otus.pro.psannikov.reactive.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.pro.psannikov.reactive.service.dtos.ProductDetailsDto;
import ru.otus.pro.psannikov.reactive.service.services.ProductDetailsService;

@RestController
@RequestMapping("/api/v1/detailed")
@RequiredArgsConstructor
public class ProductsDetailsController {
    private final ProductDetailsService productDetailsService;

    @GetMapping("/demo")
    public Flux<ProductDetailsDto> getManySlowProducts() {
        Mono<ProductDetailsDto> p1 = productDetailsService.getProductDetailsById(1L);
        Mono<ProductDetailsDto> p2 = productDetailsService.getProductDetailsById(2L);
        Mono<ProductDetailsDto> p3 = productDetailsService.getProductDetailsById(3L);
        return p1.mergeWith(p2).mergeWith(p3);
    }
}
