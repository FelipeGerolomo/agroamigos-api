package br.agroamigos.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


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





}
