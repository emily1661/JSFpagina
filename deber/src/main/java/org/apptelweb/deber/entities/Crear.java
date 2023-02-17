/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apptelweb.deber.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity
@Table(name = "crear")
@NamedQueries({
    @NamedQuery(name = "Crear.findAll", query = "SELECT c FROM Crear c"),
    @NamedQuery(name = "Crear.findByIdCrear", query = "SELECT c FROM Crear c WHERE c.idCrear = :idCrear"),
    @NamedQuery(name = "Crear.findByTema", query = "SELECT c FROM Crear c WHERE c.tema = :tema"),
    @NamedQuery(name = "Crear.findByDocente", query = "SELECT c FROM Crear c WHERE c.docente = :docente")})
public class Crear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_crear")
    private Long idCrear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tema")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "docente")
    private String docente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tema")
    private List<Lista> listaList;

    public Crear() {
    }

    public Crear(Long idCrear) {
        this.idCrear = idCrear;
    }

    public Crear(Long idCrear, String tema, String docente) {
        this.idCrear = idCrear;
        this.tema = tema;
        this.docente = docente;
    }

    public Long getIdCrear() {
        return idCrear;
    }

    public void setIdCrear(Long idCrear) {
        this.idCrear = idCrear;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public List<Lista> getListaList() {
        return listaList;
    }

    public void setListaList(List<Lista> listaList) {
        this.listaList = listaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCrear != null ? idCrear.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crear)) {
            return false;
        }
        Crear other = (Crear) object;
        if ((this.idCrear == null && other.idCrear != null) || (this.idCrear != null && !this.idCrear.equals(other.idCrear))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.apptelweb.deber.Crear[ idCrear=" + idCrear + " ]";
    }
    
}
