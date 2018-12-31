package br.agroamigos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "INDICADORES")
@JsonIgnoreProperties(value = {"userConfigList"})
public class Indicador extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_INDICADOR")
    private Integer codIndicador;

    @NotEmpty
    @Column(name = "INDICADOR")
    private String indicador;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "codIndicador", cascade = CascadeType.ALL)
    private Set<UserConfig> userConfigList = new HashSet<>();

    public Integer getCodIndicador() {
        return codIndicador;
    }

    public void setCodIndicador(Integer codIndicador) {
        this.codIndicador = codIndicador;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public Set<UserConfig> getUserConfigList() {
        return userConfigList;
    }

    public void setUserConfigList(Set<UserConfig> userConfigList) {
        this.userConfigList = userConfigList;
    }
}
