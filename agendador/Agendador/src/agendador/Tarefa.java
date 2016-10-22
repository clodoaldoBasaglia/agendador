/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendador;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clodoaldo
 */
@Entity
@Table(name = "Tarefa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t"),
    @NamedQuery(name = "Tarefa.findByIdTarefa", query = "SELECT t FROM Tarefa t WHERE t.tarefaPK.idTarefa = :idTarefa"),
    @NamedQuery(name = "Tarefa.findByDescricao", query = "SELECT t FROM Tarefa t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tarefa.findByDia", query = "SELECT t FROM Tarefa t WHERE t.dia = :dia"),
    @NamedQuery(name = "Tarefa.findByHorario", query = "SELECT t FROM Tarefa t WHERE t.horario = :horario"),
    @NamedQuery(name = "Tarefa.findByLocal", query = "SELECT t FROM Tarefa t WHERE t.local = :local"),
    @NamedQuery(name = "Tarefa.findByIsOpen", query = "SELECT t FROM Tarefa t WHERE t.isOpen = :isOpen"),
    @NamedQuery(name = "Tarefa.findByIdTipodaTarefa", query = "SELECT t FROM Tarefa t WHERE t.tarefaPK.idTipodaTarefa = :idTipodaTarefa")})
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TarefaPK tarefaPK;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @Column(name = "local")
    private String local;
    @Column(name = "isOpen")
    private Integer isOpen;
    @JoinTable(name = "Tarefa_has_usuario", joinColumns = {
        @JoinColumn(name = "Tarefa_idTarefa", referencedColumnName = "idTarefa")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "idTipodaTarefa", referencedColumnName = "idTipodaTarefa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipodaTarefa tipodaTarefa;

    public Tarefa() {
    }

    public Tarefa(TarefaPK tarefaPK) {
        this.tarefaPK = tarefaPK;
    }

    public Tarefa(int idTarefa, int idTipodaTarefa) {
        this.tarefaPK = new TarefaPK(idTarefa, idTipodaTarefa);
    }

    public TarefaPK getTarefaPK() {
        return tarefaPK;
    }

    public void setTarefaPK(TarefaPK tarefaPK) {
        this.tarefaPK = tarefaPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public TipodaTarefa getTipodaTarefa() {
        return tipodaTarefa;
    }

    public void setTipodaTarefa(TipodaTarefa tipodaTarefa) {
        this.tipodaTarefa = tipodaTarefa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarefaPK != null ? tarefaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarefa)) {
            return false;
        }
        Tarefa other = (Tarefa) object;
        if ((this.tarefaPK == null && other.tarefaPK != null) || (this.tarefaPK != null && !this.tarefaPK.equals(other.tarefaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendador.Tarefa[ tarefaPK=" + tarefaPK + " ]";
    }
    
}
