package com.example.first_spring.controller;

import com.example.first_spring.database.model.repository.ProductEntity;
import com.example.first_spring.dto.ProductDTO;
import com.example.first_spring.services.ProdutoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final ProdutoServices produtoServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findAll(){
        return produtoServices.finAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductDTO productDTO) {
        return produtoServices.createProduct(productDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity updateProduct(@PathVariable  Integer id,
                                       @RequestBody ProductDTO productDTO){
        return produtoServices.atualizarProduto(productDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        produtoServices.deleteProduto(id);
    }

}
