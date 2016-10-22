/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendador;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clodoaldo
 */
@Entity
@Table(name = "TipodaTarefa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipodaTarefa.findAll", query = "SELECT t FROM TipodaTarefa t"),
    @NamedQuery(name = "TipodaTarefa.findByIdTipodaTarefa", query = "SELECT t FROM TipodaTarefa t WHERE t.idTipodaTarefa = :idTipodaTarefa"),
    @NamedQuery(name = "TipodaTarefa.findByDescricao", query = "SELECT t FROM TipodaTarefa t WHERE t.descricao = :descricao")})
public class TipodaTarefa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTipodaTarefa")
    private Integer idTipodaTarefa;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodaTarefa")
    private Collection<Tarefa> tarefaCollection;

    public TipodaTarefa() {
    }

    public TipodaTarefa(Integer idTipodaTarefa) {
        this.idTipodaTarefa = idTipodaTarefa;
    }

    public Integer getIdTipodaTarefa() {
        return idTipodaTarefa;
    }

    public void setIdTipodaTarefa(Integer idTipodaTarefa) {
        this.idTipodaTarefa = idTipodaTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Tarefa> getTarefaCollection() {
        return tarefaCollection;
    }

    public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
        this.tarefaCollection = tarefaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipodaTarefa != null ? idTipodaTarefa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipodaTarefa)) {
            return false;
        }
        TipodaTarefa other = (TipodaTarefa) object;
        if ((this.idTipodaTarefa == null && other.idTipodaTarefa != null) || (this.idTipodaTarefa != null && !this.idTipodaTarefa.equals(other.idTipodaTarefa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendador.TipodaTarefa[ idTipodaTarefa=" + idTipodaTarefa + " ]";
    }
    
}
