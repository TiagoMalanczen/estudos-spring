package com.example.first_spring.services;

import com.example.first_spring.database.model.repository.ProductEntity;
import com.example.first_spring.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServices {

    private static final List<ProductEntity> Produtos = new ArrayList<>();

    static {
        Produtos.add(ProductEntity.builder()
                .id(1)
                .nome("Notebook")
                .preco(new BigDecimal(5000))
                .quantidade(10)
                .build());

        Produtos.add(ProductEntity.builder()
                .id(2)
                .nome("Iphone")
                .preco(new BigDecimal(7000))
                .quantidade(10)
                .build());

        Produtos.add(ProductEntity.builder()
                .id(3)
                .nome("Mouse")
                .preco(new BigDecimal(500))
                .quantidade(10)
                .build());
    }

    public List<ProductEntity> finAll(){
        return new ArrayList<>(Produtos);
    }
    public ProductEntity createProduct(ProductDTO productDTO){

        Integer identificador = Produtos.stream()
                .mapToInt(ProductEntity::getId)
                .max()
                .orElse(0) + 1;

        ProductEntity productEntity = ProductEntity.builder()
                .id(identificador)
                .nome(productDTO.getNome())
                .preco(productDTO.getPreco())
                .quantidade(productDTO.getQuantidade())
                .build();

        Produtos.add(productEntity);
        return productEntity;
    }
    public ProductEntity atualizarProduto(ProductDTO productDTO, Integer id){

        ProductEntity productEntity = Produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado")) ;

        productEntity.setNome(productDTO.getNome());
        productEntity.setPreco(productDTO.getPreco());
        productEntity.setQuantidade(productDTO.getQuantidade());

        return productEntity;
    }
    public void deleteProduto(Integer id){
         Produtos.removeIf(p -> p.getId().equals(id));
    }
}
