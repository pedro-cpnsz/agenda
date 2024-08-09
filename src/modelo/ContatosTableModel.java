package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import javax.swing.ImageIcon;

public class ContatosTableModel extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "Telefone", "Celular", "Email", "Estado", "UF", "Cidade", "Rua", "Número", "Gerenciar"};
    private final List<Endereco> enderecos;

    public ContatosTableModel(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int getRowCount() {
        return enderecos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Endereco endereco = enderecos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return endereco.getId();
            case 1:
                return endereco.getContato().getNome();
            case 2:
                return endereco.getContato().getTelefone();
            case 3:
                return endereco.getContato().getCelular();
            case 4:
                return endereco.getContato().getEmail();
            case 5:
                return endereco.getCidade().getEstado();
            case 6:
                return endereco.getCidade().getUf();
            case 7:
                return endereco.getCidade().getNome();
            case 8:
                return endereco.getRua();
            case 9:
                return endereco.getNumero();
            case 10:
                return "Gerenciar";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 10) {
            return ImageIcon.class;
        }
        return super.getColumnClass(columnIndex);
    }

//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return columnIndex == 10 || columnIndex == 11;
//    }
//
//    @Override
//    public void setValueAt(Object value, int rowIndex, int columnIndex) {
//        if (columnIndex == 10 && "Editar".equals(value)) {
//            // Abrir tela de edição
//            editarContato(rowIndex);
//        } else if (columnIndex == 11 && "Excluir".equals(value)) {
//            // Exibir confirmação de exclusão
//            excluirContato(rowIndex);
//        }
//    }
//
//    private void editarContato(int rowIndex) {
//        Endereco endereco = enderecos.get(rowIndex);
//        JTabbedPane tabbedPane = getTabbedPane();
//
//        // Verifica se a aba de edição já está aberta
//        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
//            Component tabComponent = tabbedPane.getComponentAt(i);
//            if (tabComponent instanceof PanelEditarContato) {
//                PanelEditarContato panel = (PanelEditarContato) tabComponent;
//                if (panel.getEndereco().getId() == endereco.getId()) {
//                    tabbedPane.setSelectedComponent(panel);
//                    return;
//                }
//            }
//        }
//
//        // Se a aba de edição não estiver aberta, cria uma nova
//        PanelEditarContato editarContato = new PanelEditarContato(endereco);
//        tabbedPane.addTab("Editar Contato - " + endereco.getContato().getNome(), editarContato);
//        tabbedPane.setSelectedComponent(editarContato);
//
//    }
//
//    private JTabbedPane getTabbedPane() {
//        Component parent = SwingUtilities.getAncestorOfClass(JTabbedPane.class, null);
//        if (parent instanceof JTabbedPane) {
//            return (JTabbedPane) parent;
//        }
//        throw new IllegalStateException("TabbedPane não encontrado");
//    }
//
//    private void excluirContato(int rowIndex) {
//        int confirmacao = JOptionPane.showConfirmDialog(null,
//                "Tem certeza que deseja excluir este contato?",
//                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
//
//        if (confirmacao == JOptionPane.YES_OPTION) {
//            Endereco endereco = enderecos.get(rowIndex);
//            enderecoControle.delete(endereco.getId());
//            enderecos.remove(rowIndex);
//            fireTableRowsDeleted(rowIndex, rowIndex);
//        }
//    }
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

}
