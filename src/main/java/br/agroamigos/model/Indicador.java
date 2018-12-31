package br.agroamigos.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table(name = "INDICADORES")
public class Indicador extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_INDICADOR")
    private Integer codIndicador;

    @NotEmpty
    @Column(name = "INDICADOR")
    private String indicador;

    @OneToMany(mappedBy = "codIndicador")
    private List<UserConfig> userConfigList;

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

    public List<UserConfig> getUserConfigList() {
        return userConfigList;
    }

    public void setUserConfigList(List<UserConfig> userConfigList) {
        this.userConfigList = userConfigList;
    }
}
