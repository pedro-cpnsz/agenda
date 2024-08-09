package controle;

import dao.CidadeDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cidade;

public class CidadeControle implements InterfaceControle<Cidade>{
    private CidadeDao dao;

    public CidadeControle() {
        this.dao = new CidadeDao();
    }

    @Override
    public void insert(Cidade cidade) {
        try {
            dao.insert(cidade);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cidade> listar() {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Cidade buscar(int id) {
        try {
            return dao.buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void alterar(Cidade cidade) {
        try {
            dao.alterar(cidade);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(int id) {
        try {
            dao.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @Override
    public List<Cidade> listarFiltrado(String nome, String telefone, String celular, String email, String estado, String cidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
