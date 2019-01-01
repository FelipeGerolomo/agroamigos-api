package br.agroamigos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "INDICADORES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "DS_INDICADOR"
        })
})
@JsonIgnoreProperties(value = {"userConfigList"})
public class Indicador extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INDICADOR")
    private Long idIndicador;

    @NotEmpty
    @Column(name = "DS_INDICADOR", unique = true)
    private String indicador;

    @NotEmpty
    @Column(name = "DS_UNIDADE")
    private String unidade;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idIndicador", cascade = CascadeType.ALL)
    private Set<Cotacao> cotacaoList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idIndicador", cascade = CascadeType.ALL)
    private Set<UserConfig> userConfigList = new HashSet<>();

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Set<UserConfig> getUserConfigList() {
        return userConfigList;
    }

    public void setUserConfigList(Set<UserConfig> userConfigList) {
        this.userConfigList = userConfigList;
    }

    public Set<Cotacao> getCotacaoList() {
        return cotacaoList;
    }

    public void setCotacaoList(Set<Cotacao> cotacaoList) {
        this.cotacaoList = cotacaoList;
    }
}
