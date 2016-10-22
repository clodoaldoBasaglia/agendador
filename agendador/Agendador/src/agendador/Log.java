/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendador;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clodoaldo
 */
@Entity
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdlog", query = "SELECT l FROM Log l WHERE l.logPK.idlog = :idlog"),
    @NamedQuery(name = "Log.findByDataHorario", query = "SELECT l FROM Log l WHERE l.dataHorario = :dataHorario"),
    @NamedQuery(name = "Log.findByDescricao", query = "SELECT l FROM Log l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "Log.findByIdusuario", query = "SELECT l FROM Log l WHERE l.logPK.idusuario = :idusuario")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LogPK logPK;
    @Column(name = "dataHorario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHorario;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Log() {
    }

    public Log(LogPK logPK) {
        this.logPK = logPK;
    }

    public Log(int idlog, int idusuario) {
        this.logPK = new LogPK(idlog, idusuario);
    }

    public LogPK getLogPK() {
        return logPK;
    }

    public void setLogPK(LogPK logPK) {
        this.logPK = logPK;
    }

    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logPK != null ? logPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logPK == null && other.logPK != null) || (this.logPK != null && !this.logPK.equals(other.logPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendador.Log[ logPK=" + logPK + " ]";
    }
    
}
