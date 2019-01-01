package br.agroamigos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long idCotacao;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idIndicador")
    private Indicador idIndicador;

    @Column(name = "VL_PRECO")
    private Float vl_preco;

    @NotEmpty
    @Column(name = "SG_MOEDA")
    private String sg_moeda;

    public Long getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Long idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Indicador getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Indicador idIndicador) {
        this.idIndicador = idIndicador;
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
