package controle;

import dao.EnderecoDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Endereco;

public class EnderecoControle implements InterfaceControle<Endereco> {

    private EnderecoDao dao;

    public EnderecoControle() {
        this.dao = new EnderecoDao();
    }

    @Override
    public void insert(Endereco endereco) {
        try {
            dao.insert(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Endereco> listar() {
        try {
            return dao.listar();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Endereco> listarFiltrado(String nome, String telefone, String celular, String email, String estado, String cidade) {
        try {
            return dao.listarFiltrado(nome, telefone, celular, email, estado, cidade);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Endereco buscar(int id) {
        try {
            return dao.buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void alterar(Endereco endereco) {
        try {
            dao.alterar(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
