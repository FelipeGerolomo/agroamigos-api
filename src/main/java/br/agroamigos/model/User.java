package br.agroamigos.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USUARIOS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "DS_EMAIL"
        })
})
public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @NotBlank
    @Column(name = "NM_USUARIO")
    private String nome;

    @NotBlank
    @Column(name = "DS_EMAIL")
    private String email;

    @NotBlank
    @Column(name = "DS_SENHA")
    private String password;

    @NotBlank
    @Column(name = "DS_UF")
    private String uf;

    @NotBlank
    @Column(name = "DS_CIDADE")
    private String cidade;

    @NotBlank
    @Column(name = "DS_TELEFONE")
    private String telefone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "id")
    private List<UserConfig> userConfigList = new ArrayList<>();

    public User() {

    }

    public User(String nome, String email, String password, String uf, String cidade, String telefone) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.uf = uf;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<UserConfig> getUserConfigList() {
        return userConfigList;
    }

    public void setUserConfigList(List<UserConfig> userConfigList) {
        this.userConfigList = userConfigList;
    }
}
