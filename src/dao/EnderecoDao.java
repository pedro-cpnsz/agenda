package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import modelo.Cidade;
import modelo.Contato;
import modelo.Endereco;

public class EnderecoDao {

    private Connection connection;

    public EnderecoDao() {
        this.connection = ConexaoBD.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void insert(Endereco endereco) throws SQLException {
        String sql = "insert into enderecos(rua,numero,cidadeid,contatoid) values(?,?,?,?)";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, endereco.getRua());
        pstm.setString(2, endereco.getNumero());
        pstm.setInt(3, endereco.getCidade().getId());
        pstm.setInt(4, endereco.getContato().getId());
        pstm.execute();
        pstm.close();
        connection.close();
    }

//    pronto, necessita teste
    public List<Endereco> listar() throws SQLException {
        String sql = "SELECT e.id, con.nome, con.telefone, con.celular, "
                + "con.email, cid.estado, cid.uf, cid.nome, e.rua, e.numero "
                + "FROM enderecos as e LEFT JOIN cidades as cid ON cid.id = e.id "
                + "LEFT JOIN contatos as con ON con.id = e.id";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<Endereco> enderecos = new LinkedList<>();
        while (resultSet.next()) {
            Endereco endereco = new Endereco();
            Cidade cidade = new Cidade();
            Contato contato = new Contato();
            endereco.setId(resultSet.getInt(1));
            contato.setNome(resultSet.getString(2));
            contato.setTelefone(resultSet.getString(3));
            contato.setCelular(resultSet.getString(4));
            contato.setEmail(resultSet.getString(5));
            cidade.setEstado(resultSet.getString(6));
            cidade.setUf(resultSet.getString(7));
            cidade.setNome(resultSet.getString(8));
            endereco.setRua(resultSet.getString(9));
            endereco.setNumero(resultSet.getString(10));

            endereco.setCidade(cidade);
            endereco.setContato(contato);
            enderecos.add(endereco);
        }
        pstm.close();
        connection.close();
        return enderecos;
    }

    public List<Endereco> listarFiltrado(String nome, String telefone, String celular, String email, String estado, String cidade) throws SQLException {
        String sql = "SELECT e.id, con.nome, con.telefone, con.celular, "
                + "con.email, cid.estado, cid.uf, cid.nome, e.rua, e.numero "
                + "FROM enderecos as e "
                + "LEFT JOIN cidades as cid ON cid.id = e.id "
                + "LEFT JOIN contatos as con ON con.id = e.id "
                + "WHERE (con.nome LIKE ? OR ? IS NULL) "
                + "AND (con.telefone LIKE ? OR ? IS NULL) "
                + "AND (con.celular LIKE ? OR ? IS NULL) "
                + "AND (con.email LIKE ? OR ? IS NULL) "
                + "AND (cid.estado LIKE ? OR ? IS NULL) "
                + "AND (cid.nome LIKE ? OR ? IS NULL)";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, nome != null ? "%" + nome + "%" : null);
        pstm.setString(2, nome);
        pstm.setString(3, telefone != null ? "%" + telefone + "%" : null);
        pstm.setString(4, telefone);
        pstm.setString(5, celular != null ? "%" + celular + "%" : null);
        pstm.setString(6, celular);
        pstm.setString(7, email != null ? "%" + email + "%" : null);
        pstm.setString(8, email);
        pstm.setString(9, estado != null ? "%" + estado + "%" : null);
        pstm.setString(10, estado);
        pstm.setString(11, cidade != null ? "%" + cidade + "%" : null);
        pstm.setString(12, cidade);
        ResultSet resultSet = pstm.executeQuery();
        List<Endereco> enderecos = new LinkedList<>();
        while (resultSet.next()) {
            Endereco endereco = new Endereco();
            Cidade cidadeObj = new Cidade();
            Contato contato = new Contato();
            endereco.setId(resultSet.getInt(1));
            contato.setNome(resultSet.getString(2));
            contato.setTelefone(resultSet.getString(3));
            contato.setCelular(resultSet.getString(4));
            contato.setEmail(resultSet.getString(5));
            cidadeObj.setEstado(resultSet.getString(6));
            cidadeObj.setUf(resultSet.getString(7));
            cidadeObj.setNome(resultSet.getString(8));
            endereco.setRua(resultSet.getString(9));
            endereco.setNumero(resultSet.getString(10));

            endereco.setCidade(cidadeObj);
            endereco.setContato(contato);
            enderecos.add(endereco);
        }
        pstm.close();
        connection.close();
        return enderecos;
    }

//    pronto, necessita teste
    public Endereco buscar(int id) throws SQLException {
        String sql = "SELECT e.rua, e.numero, cid.nome, cid.estado, cid.uf, "
                + "con.nome, con.telefone, con.celular, con.email FROM enderecos as e "
                + "LEFT JOIN cidades as cid ON cid.id = e.id "
                + "LEFT JOIN contatos as con ON con.id = e.id "
                + "WHERE id = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setInt(id, id);
        ResultSet resultSet = pstm.executeQuery();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();
        Contato contato = new Contato();
        resultSet.next();
        endereco.setRua(resultSet.getString(1));
        endereco.setNumero(resultSet.getString(2));
        cidade.setNome(resultSet.getString(3));
        cidade.setEstado(resultSet.getString(4));
        cidade.setUf(resultSet.getString(5));
        contato.setNome(resultSet.getString(6));
        contato.setTelefone(resultSet.getString(7));
        contato.setCelular(resultSet.getString(8));
        contato.setEmail(resultSet.getString(9));
        pstm.close();
        connection.close();
        return endereco;
    }

//    pronto, necessita teste
    public Endereco buscar(String campo, String valor) throws SQLException {
        String sql = "SELECT e.rua, e.numero, cid.nome, cid.estado, cid.uf, "
                + "con.nome, con.telefone, con.celular, con.email FROM enderecos as e "
                + "LEFT JOIN cidades as cid ON cid.id = e.id "
                + "LEFT JOIN contatos as con ON con.id = e.id "
                + "WHERE ? = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, campo);
        pstm.setString(2, valor);
        ResultSet resultSet = pstm.executeQuery();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();
        Contato contato = new Contato();
        resultSet.next();
        endereco.setRua(resultSet.getString(1));
        endereco.setNumero(resultSet.getString(2));
        cidade.setNome(resultSet.getString(3));
        cidade.setEstado(resultSet.getString(4));
        cidade.setUf(resultSet.getString(5));
        contato.setNome(resultSet.getString(6));
        contato.setTelefone(resultSet.getString(7));
        contato.setCelular(resultSet.getString(8));
        contato.setEmail(resultSet.getString(9));
        endereco.setCidade(cidade);
        endereco.setContato(contato);
        pstm.close();
        connection.close();
        return endereco;
    }

//    Preciso alterar o "cidadeid" e o "contatoid"?
//    Preciso de updates nas tabelas "cidades" e "contatos"?
    public void alterar(Endereco endereco) throws SQLException {
        String sql = "UPDATE enderecos SET rua = ?, numero = ?, cidadeid = ?, contatoid = ? WHERE id = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, endereco.getRua());
        pstm.setString(2, endereco.getNumero());
        pstm.setInt(3, endereco.getCidade().getId());
        pstm.setInt(4, endereco.getContato().getId());
        pstm.setInt(5, endereco.getId());
        pstm.executeUpdate();
        pstm.close();
        connection.close();
    }

//    Pronto, necessita teste
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM enderecos WHERE id = ?";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
        pstm.close();
        connection.close();
    }

}
