package br.com.azevedo.rayldo.vialactea.service;

import br.com.azevedo.rayldo.vialactea.model.Planetas;

import java.util.List;

public interface PlanetaService {

    public Planetas incluir(Planetas planeta); //INCLUIR
    public List<Planetas> listar();            //LISTAR
    public Planetas consultar(Integer id);     //CONSULTAR
    public void alterar(Planetas planeta);     //ALTERAR
    public void excluir(Integer id);           //EXCLUIR
}
