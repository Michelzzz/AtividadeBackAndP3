package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void create (Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();

    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);

    }

    public void update(Long id, Aluno aluno) {
        Optional<Aluno> alunoFromDb = findById(id);

        if (alunoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        Aluno alunoUptdated = alunoFromDb.get();

        alunoUptdated.setName(aluno.getName());
        alunoUptdated.setEmail(aluno.getEmail());

        alunoRepository.save(alunoUptdated);

    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}