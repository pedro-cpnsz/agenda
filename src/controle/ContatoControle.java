package controle;

import dao.ContatoDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Contato;

public class ContatoControle implements InterfaceControle<Contato> {

    private ContatoDao dao;

    public ContatoControle() {
        this.dao = new ContatoDao();
    }

    @Override
    public void insert(Contato contato) {
        try {
            dao.insert(contato);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Contato> listar() {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Contato buscar(int id) {
        try {
            return dao.buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void alterar(Contato contato) {
        try {
            dao.alterar(contato);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Contato> listarFiltrado(String nome, String telefone, String celular, String email, String estado, String cidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
