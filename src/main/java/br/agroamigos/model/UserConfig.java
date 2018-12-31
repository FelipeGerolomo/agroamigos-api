package br.agroamigos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "USER_CONFIG")
public class UserConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONFIG")
    @JsonIgnore
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User idUser;
    
    @ManyToOne(optional = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "codIndicador")
    private Indicador codIndicador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Indicador getCodIndicador() {
        return codIndicador;
    }

    public void setCodIndicador(Indicador codIndicador) {
        this.codIndicador = codIndicador;
    }
}
