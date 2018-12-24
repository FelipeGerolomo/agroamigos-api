package br.agroamigos.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "COTACAO")
public class Cotacao extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COTACAO")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "indicador", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Indicador indicador;

    @Column(name = "VL_PRECO")
    private Float vl_preco;

    @NotEmpty
    @Column(name = "SG_MOEDA")
    private String sg_moeda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public Float getVl_preco() {
        return vl_preco;
    }

    public void setVl_preco(Float vl_preco) {
        this.vl_preco = vl_preco;
    }

    public String getSg_moeda() {
        return sg_moeda;
    }

    public void setSg_moeda(String sg_moeda) {
        this.sg_moeda = sg_moeda;
    }


}
