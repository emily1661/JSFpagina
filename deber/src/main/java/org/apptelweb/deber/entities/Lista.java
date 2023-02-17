/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apptelweb.deber.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity
@Table(name = "lista")
@NamedQueries({
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l"),
    @NamedQuery(name = "Lista.findByIdLista", query = "SELECT l FROM Lista l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "Lista.findByDefinicion", query = "SELECT l FROM Lista l WHERE l.definicion = :definicion"),
    @NamedQuery(name = "Lista.findByConcepto", query = "SELECT l FROM Lista l WHERE l.concepto = :concepto")})
public class Lista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lista")
    private Long idLista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "definicion")
    private String definicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "concepto")
    private String concepto;
    @JoinColumn(name = "tema", referencedColumnName = "tema")
    @ManyToOne(optional = false)
    private Crear tema;

    public Lista() {
    }

    public Lista(Long idLista) {
        this.idLista = idLista;
    }

    public Lista(Long idLista, String definicion, String concepto) {
        this.idLista = idLista;
        this.definicion = definicion;
        this.concepto = concepto;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Crear getTema() {
        return tema;
    }

    public void setTema(Crear tema) {
        this.tema = tema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.apptelweb.deber.Lista[ idLista=" + idLista + " ]";
    }
    
}
