package modelo;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.PanelEditarContato;

public class IconCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private int row;
    private String action;

//    public IconCellEditor(String action) {
//        this.action = action;
//        button = new JButton();
//        button.setOpaque(true);
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fireEditingStopped();
//                if ("edit".equals(action)) {
//                    editarContato(row);
//                } else if ("delete".equals(action)) {
//                    excluirContato(row);
//                }
//            }
//        });
//    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

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

    private void excluirContato(int rowIndex) {
        // Implementação do método excluirContato
        // Adicione sua lógica para excluir contato aqui
    }
}
