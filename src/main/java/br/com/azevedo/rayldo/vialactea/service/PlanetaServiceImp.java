package br.com.azevedo.rayldo.vialactea.service;

import br.com.azevedo.rayldo.vialactea.model.Planetas;
import br.com.azevedo.rayldo.vialactea.dao.PlanetaRepository;
import br.com.azevedo.rayldo.vialactea.util.MeuBackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PlanetaServiceImp implements PlanetaService {

    private final PlanetaRepository repository;
    //CONSTRUTOR
    @Autowired
    public PlanetaServiceImp(PlanetaRepository repositorio) {
        this.repository = repositorio;
    }

    @Override
    public Planetas incluir(Planetas planeta) {
        try {
            repository.save(planeta);
            return planeta;
        }catch (Exception e) {
            throw new MeuBackEndException("Não foi possível incluir o planeta.");
        }
    }

    @Override
    public List<Planetas> listar() {
        try{
            return (List<Planetas>) this.repository.findAll();
        }catch(Exception e) {
            throw new MeuBackEndException("Não foi possível listar os planetas");
        }
    }

    @Override
    public Planetas consultar(Integer id) {
        try {
            return this.repository.findById(id).get();
        }catch (Exception e) {
            throw new MeuBackEndException("Não foi consultar o planeta " + id + "!");
        }
    }

    @Override
    public void alterar(Planetas planeta) {
        try {
            repository.save(planeta);
        }catch (Exception e) {
            throw new MeuBackEndException("Não foi possível alterar o planeta " + planeta.getId() + "!");
        }
    }

    @Override
    public void excluir(Integer id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            throw new MeuBackEndException("Não foi possível excluir o planeta " + id + "!");
        }
    }
}
