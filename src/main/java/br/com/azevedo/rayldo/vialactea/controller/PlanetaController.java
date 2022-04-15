package br.com.azevedo.rayldo.vialactea.controller;
import br.com.azevedo.rayldo.vialactea.model.Planetas;
import br.com.azevedo.rayldo.vialactea.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlanetaController {

    private PlanetaService planetaService;

    @Autowired
    public void setMedicoService(PlanetaService planetaService) {
        this.planetaService = planetaService;
    }

    /**
     * METODO DE LISTAGEM DO PLANETA
     * @return lista de planetas
     */
    @GetMapping(value = "/listar-planetas")
    public List<Planetas> listar() {
        List<Planetas> list = planetaService.listar();
        return list;
    }

    /**
     * METODO DE CONSULTA POR ID
     * @param id
     * @return Planeta informado por id
     */
    @GetMapping(value = "/consultar-planeta/{id}")
    public Planetas consultar(@PathVariable Integer id){
        return planetaService.consultar(id);
    }

    /**
     * MÉTODO PARA SALVAR OU ALTERAR PLANETA NO BANCO DE DADOS
     * @param planeta que deve ser salvo
     * @return planeta salvo ou alterado no banco
     */
    @PostMapping(value = "/salvar-planeta")
    public Planetas salvar(@RequestBody Planetas planeta){
        try {
            if (planeta.getId() == null) {
                planetaService.alterar(planeta);
            } else {
                planeta = planetaService.incluir(planeta);
            }
            return planeta;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * METODO PARA EXCLUIR PLANETA
     * @param id do planeta que deve ser excluído
     */
    @DeleteMapping(value = "/excluir-usuario/{id}")
    public void excluir(@PathVariable Integer id){
        planetaService.excluir(id);
    }

}
