/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendador;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author clodoaldo
 */
@Embeddable
public class LogPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idlog")
    private int idlog;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;

    public LogPK() {
    }

    public LogPK(int idlog, int idusuario) {
        this.idlog = idlog;
        this.idusuario = idusuario;
    }

    public int getIdlog() {
        return idlog;
    }

    public void setIdlog(int idlog) {
        this.idlog = idlog;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlog;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogPK)) {
            return false;
        }
        LogPK other = (LogPK) object;
        if (this.idlog != other.idlog) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendador.LogPK[ idlog=" + idlog + ", idusuario=" + idusuario + " ]";
    }
    
}
