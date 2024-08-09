package controle;

import java.util.List;


//contrato 
public interface InterfaceControle<T> {
    public void insert(T objeto);
    public List<T> listar();
    public List<T> listarFiltrado(String nome, String telefone, String celular, String email, String estado, String cidade);
    public T buscar(int id);
    public void alterar(T objeto);
    public void delete(int id);
}
