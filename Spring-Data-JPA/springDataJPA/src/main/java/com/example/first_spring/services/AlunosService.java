package com.example.first_spring.services;

import com.example.first_spring.database.repository.AlunoRepository;
import com.example.first_spring.dto.AlunosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final AlunoRepository alunoRepository;

    public void cadastrarAluno(AlunosDTO alunosDTO){

    }

}
