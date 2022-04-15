package br.com.azevedo.rayldo.vialactea.model;

import javax.persistence.*;

@Entity
@Table(name = "planetas")
public class Planetas {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "diametro")
    private String diametro;
    @Column(name = "possuiagua")
    private String possuiAgua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPossuiAgua() {
        return possuiAgua;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public String isPossuiAgua() {
        return possuiAgua;
    }

    public void setPossuiAgua(String possuiAgua) {
        this.possuiAgua = possuiAgua;
    }

}
