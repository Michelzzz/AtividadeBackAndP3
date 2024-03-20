package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void create(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);

    }
}
