/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author brandao
 */
@Entity
public class USUARIO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDUSUARIO;
    private String nomeUSUARIO;

    public String getNome() {
        return nomeUSUARIO;
    }

    public void setNome(String nomeUSUARIO) {
        this.nomeUSUARIO = nomeUSUARIO;
    }

    
    public Long getId() {
        return IDUSUARIO;
    }

    public void setId(Long IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDUSUARIO != null ? IDUSUARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof USUARIO)) {
            return false;
        }
        USUARIO other = (USUARIO) object;
        if ((this.IDUSUARIO == null && other.IDUSUARIO != null) || (this.IDUSUARIO != null && !this.IDUSUARIO.equals(other.IDUSUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.usuario[ IDUSUARIO=" + IDUSUARIO + " ]";
    }
    
}
