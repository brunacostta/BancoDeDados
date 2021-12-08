package com.bruna.atp64.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipoCliente")
public class TipoClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    @ManyToOne
    private String tipoCliente;

    @Getter @Setter
    private String descricao;
}
