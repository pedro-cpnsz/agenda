//package visao;
//
//import controle.EnderecoControle;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import modelo.Endereco;
//
//public class AlterarContatoPanel extends JPanel {
//
//    private JTextField buscarNomeField;
//    private JButton buscarButton;
//
//    private JTextField nomeField;
//    private JTextField telefoneField;
//    private JTextField celularField;
//    private JTextField emailField;
//    private JTextField ruaField;
//    private JTextField numeroField;
//    private JTextField estadoField;
//    private JTextField ufField;
//    private JTextField cidadeField;
//
//    private JButton salvarButton;
//
//    private Endereco contatoAtual;
//
//    public AlterarContatoPanel() {
//        setLayout(new BorderLayout());
//
//        // Painel de busca
//        JPanel buscarPanel = new JPanel(new FlowLayout());
//        buscarPanel.add(new JLabel("Buscar Nome:"));
//        buscarNomeField = new JTextField(20);
//        buscarPanel.add(buscarNomeField);
//        buscarButton = new JButton("Buscar");
//        buscarPanel.add(buscarButton);
//
//        add(buscarPanel, BorderLayout.NORTH);
//
//        // Painel de edição
//        JPanel editarPanel = new JPanel(new GridLayout(10, 2));
//        editarPanel.add(new JLabel("Nome:"));
//        nomeField = new JTextField(20);
//        editarPanel.add(nomeField);
//
//        editarPanel.add(new JLabel("Telefone:"));
//        telefoneField = new JTextField(20);
//        editarPanel.add(telefoneField);
//
//        editarPanel.add(new JLabel("Celular:"));
//        celularField = new JTextField(20);
//        editarPanel.add(celularField);
//
//        editarPanel.add(new JLabel("Email:"));
//        emailField = new JTextField(20);
//        editarPanel.add(emailField);
//
//        editarPanel.add(new JLabel("Rua:"));
//        ruaField = new JTextField(20);
//        editarPanel.add(ruaField);
//
//        editarPanel.add(new JLabel("Número:"));
//        numeroField = new JTextField(20);
//        editarPanel.add(numeroField);
//
//        editarPanel.add(new JLabel("Estado:"));
//        estadoField = new JTextField(20);
//        editarPanel.add(estadoField);
//
//        editarPanel.add(new JLabel("UF:"));
//        ufField = new JTextField(20);
//        editarPanel.add(ufField);
//
//        editarPanel.add(new JLabel("Cidade:"));
//        cidadeField = new JTextField(20);
//        editarPanel.add(cidadeField);
//
//        salvarButton = new JButton("Salvar Alterações");
//        editarPanel.add(salvarButton);
//
//        add(editarPanel, BorderLayout.CENTER);
//
//        // Action Listeners
//        buscarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                buscarContato();
//            }
//        });
//
//        salvarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                salvarAlteracoes();
//            }
//        });
//    }
//
//    private void buscarContato() {
//        String nome = buscarNomeField.getText();
//        if (nome.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Por favor, insira um nome para buscar.");
//            return;
//        }
//
//        EnderecoControle enderecoControle = new EnderecoControle();
//        contatoAtual = enderecoControle.buscarContatoPorNome(nome);
//        if (contatoAtual == null) {
//            JOptionPane.showMessageDialog(this, "Contato não encontrado.");
//        } else {
//            nomeField.setText(contatoAtual.getContato().getNome());
//            telefoneField.setText(contatoAtual.getContato().getTelefone());
//            celularField.setText(contatoAtual.getContato().getCelular());
//            emailField.setText(contatoAtual.getContato().getEmail());
//            ruaField.setText(contatoAtual.getRua());
//            numeroField.setText(contatoAtual.getNumero());
//            estadoField.setText(contatoAtual.getCidade().getEstado());
//            ufField.setText(contatoAtual.getCidade().getUf());
//            cidadeField.setText(contatoAtual.getCidade().getNome());
//        }
//    }
//
//    private void salvarAlteracoes() {
//        if (contatoAtual == null) {
//            JOptionPane.showMessageDialog(this, "Por favor, busque um contato antes de tentar salvar alterações.");
//            return;
//        }
//
//        contatoAtual.getContato().setNome(nomeField.getText());
//        contatoAtual.getContato().setTelefone(telefoneField.getText());
//        contatoAtual.getContato().setCelular(celularField.getText());
//        contatoAtual.getContato().setEmail(emailField.getText());
//        contatoAtual.setRua(ruaField.getText());
//        contatoAtual.setNumero(numeroField.getText());
//        contatoAtual.getCidade().setEstado(estadoField.getText());
//        contatoAtual.getCidade().setUf(ufField.getText());
//        contatoAtual.getCidade().setNome(cidadeField.getText());
//
//        try {
//            EnderecoControle enderecoControle = new EnderecoControle();
//            enderecoControle.atualizarContato(contatoAtual);
//            JOptionPane.showMessageDialog(this, "Contato atualizado com sucesso.");
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "Erro ao atualizar contato: " + e.getMessage());
//        }
//    }
//}
