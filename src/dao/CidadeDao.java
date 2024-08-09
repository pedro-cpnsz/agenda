package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import modelo.Cidade;

public class CidadeDao {

    private Connection connection;

    public CidadeDao() {
        this.connection = ConexaoBD.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public int insert(Cidade cidade) throws SQLException {
        String sql = "insert into cidades(nome,estado,uf) values(?,?,?)";
        PreparedStatement pstm = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, cidade.getNome());
        pstm.setString(2, cidade.getEstado());
        pstm.setString(3, cidade.getUf());
        pstm.execute();

        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            int resp = rs.getInt(1);
            cidade.setId(resp);
            pstm.close();
            connection.close();

            return resp;
        }
        return -1;
    }

    public List<Cidade> listar() throws SQLException {
        String sql = "SELECT * FROM cidades;";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<Cidade> cidades = new LinkedList<>();
        while (resultSet.next()) {
            Cidade cidade = new Cidade();
            cidade.setNome(resultSet.getString(2));
            cidade.setEstado(resultSet.getString(3));
            cidade.setUf(resultSet.getString(4));
            cidades.add(cidade);
        }
        pstm.close();
        connection.close();
        return cidades;
    }

    public Cidade buscar(int id) throws SQLException {
        String sql = "SELECT * FROM cidades WHERE id = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setInt(id, id);
        ResultSet resultSet = pstm.executeQuery();
        Cidade cidade = new Cidade();
        resultSet.next();
        cidade.setId(resultSet.getInt(1));
        cidade.setNome(resultSet.getString(2));
        cidade.setEstado(resultSet.getString(3));
        cidade.setUf(resultSet.getString(4));
        pstm.close();
        connection.close();
        return cidade;
    }

    public void alterar(Cidade cidade) throws SQLException {
        String sql
                = "UPDATE cidades SET nome = ?, estado = ?, uf = ? WHERE id=?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, cidade.getNome());
        pstm.setString(2, cidade.getEstado());
        pstm.setString(3, cidade.getUf());
        pstm.setInt(4, cidade.getId());
        pstm.executeUpdate();
        pstm.close();
        connection.close();
    }

    public void delete(int id) throws SQLException {
        String sql
                = "DELETE FROM cidades WHERE id=?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
        pstm.close();
        connection.close();
    }

}
