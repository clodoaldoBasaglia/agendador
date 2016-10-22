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
public class TarefaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTarefa")
    private int idTarefa;
    @Basic(optional = false)
    @Column(name = "idTipodaTarefa")
    private int idTipodaTarefa;

    public TarefaPK() {
    }

    public TarefaPK(int idTarefa, int idTipodaTarefa) {
        this.idTarefa = idTarefa;
        this.idTipodaTarefa = idTipodaTarefa;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public int getIdTipodaTarefa() {
        return idTipodaTarefa;
    }

    public void setIdTipodaTarefa(int idTipodaTarefa) {
        this.idTipodaTarefa = idTipodaTarefa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTarefa;
        hash += (int) idTipodaTarefa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarefaPK)) {
            return false;
        }
        TarefaPK other = (TarefaPK) object;
        if (this.idTarefa != other.idTarefa) {
            return false;
        }
        if (this.idTipodaTarefa != other.idTipodaTarefa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendador.TarefaPK[ idTarefa=" + idTarefa + ", idTipodaTarefa=" + idTipodaTarefa + " ]";
    }
    
}
