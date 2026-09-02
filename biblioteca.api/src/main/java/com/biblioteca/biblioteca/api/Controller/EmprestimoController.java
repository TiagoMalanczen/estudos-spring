package com.biblioteca.biblioteca.api.Controller;


import com.biblioteca.biblioteca.api.DTOs.EmprestimoDTO;
import com.biblioteca.biblioteca.api.services.EmprestimoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/emprestimos")
@RequiredArgsConstructor
@Validated
public class EmprestimoController {

    private final EmprestimoService emprestimoService;


    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void emprestarLivro(@Valid @RequestBody EmprestimoDTO emprestimoDTO){
        emprestimoService.realizarEmprestimo(emprestimoDTO);
    }

    @PatchMapping("/{id}/devolucao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void realizarDevolucao(@PathVariable("id") Integer id) {
        emprestimoService.devolverLivro(id);
    }

}
