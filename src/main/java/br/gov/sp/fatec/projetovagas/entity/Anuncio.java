package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
}