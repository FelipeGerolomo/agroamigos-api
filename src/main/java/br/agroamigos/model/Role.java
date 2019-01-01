package br.agroamigos.model;


import br.agroamigos.enums.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGRA", length = 60)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "DS_REGRA", length = 60)
    private RoleName name;

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public Role(RoleName name) {
        this.name = name;
    }


}
