package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import modelo.Contato;

public class ContatoDao {

    private Connection connection;

    public ContatoDao() {
        this.connection = ConexaoBD.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public int insert(Contato contato) throws SQLException {
        String sql = "insert into contatos(nome,telefone,celular,email) values(?,?,?,?)";
        PreparedStatement pstm = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, contato.getNome());
        pstm.setString(2, contato.getTelefone());
        pstm.setString(3, contato.getCelular());
        pstm.setString(4, contato.getEmail());
        pstm.execute();
        
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            int resp = rs.getInt(1);
            contato.setId(resp);
            pstm.close();
            connection.close();

            return resp;
        }
        return -1;
    }

    public List<Contato> listar() throws SQLException {
        String sql = "SELECT * FROM contatos;";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<Contato> contatos = new LinkedList<>();
        while (resultSet.next()) {
            Contato contato = new Contato();
            contato.setNome(resultSet.getString(2));
            contato.setTelefone(resultSet.getString(3));
            contato.setCelular(resultSet.getString(4));
            contato.setEmail(resultSet.getString(5));
            contatos.add(contato);
        }
        pstm.close();
        connection.close();
        return contatos;
    }

    public Contato buscar(int id) throws SQLException {
        String sql = "SELECT * FROM contatos WHERE id = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setInt(id, id);
        ResultSet resultSet = pstm.executeQuery();
        Contato contato = new Contato();
        resultSet.next();
        contato.setId(resultSet.getInt(1));
        contato.setNome(resultSet.getString(2));
        contato.setTelefone(resultSet.getString(3));
        contato.setCelular(resultSet.getString(4));
        contato.setEmail(resultSet.getString(5));
        pstm.close();
        connection.close();
        return contato;
    }

    public void alterar(Contato contato) throws SQLException {
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, celular = ?, email = ? WHERE id = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, contato.getNome());
        pstm.setString(2, contato.getTelefone());
        pstm.setString(3, contato.getCelular());
        pstm.setString(4, contato.getEmail());
        pstm.setInt(5, contato.getId());
        pstm.executeUpdate();
        pstm.close();
        connection.close();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id=?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
        pstm.close();
        connection.close();
    }

}
