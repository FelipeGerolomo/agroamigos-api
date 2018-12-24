package br.agroamigos.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "User", uniqueConstraints={@UniqueConstraint(columnNames={"EMAIL"})})
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Integer idUser;

    @NotEmpty
    @Column(name = "EMAIL")
    private String email;

    @NotEmpty
    @Column(name = "SENHA")
    private String senha;

    @NotEmpty
    @Column(name = "NOME")
    private String nome;

    @NotEmpty
    @Column(name = "UF")
    private String uf;

    @NotEmpty
    @Column(name = "CIDADE")
    private String cidade;

    @NotEmpty
    @Column(name = "TELEFONE")
    private String telefone;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
