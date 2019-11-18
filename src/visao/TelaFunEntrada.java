package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */
public class TelaFunEntrada extends JPanel {

    private final BigPaper jf;

    private final ImageIcon fundo;
    private final ImageIcon iconSelecionado;
    private ImageIcon iconMenu;
    private ImageIcon iconFechar;

    private JButton btnEntradaProd;
    private JButton btnMenu;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JButton btnFechar;

    private JComboBox jcbNome;

    private JTextField txtCPF;
    private JTextField txtNumNota;
    private JTextField txtDataEntrega;
    private JTextField txtTelefone;
    private JTextField txtTotalGerado;

    private JScrollPane jspRolagem;

    private JTable tabelaProd;

    public TelaFunEntrada(final BigPaper jf) {

        this.jf = jf;

        setLayout(null);

        fundo = new ImageIcon("src/imagens/fundoFunEntrada.png");
        iconSelecionado = new ImageIcon("src/imagens/btnSelecionado.png");
        iconMenu = new ImageIcon("src/imagens/iconMenu.png");
        iconFechar = new ImageIcon("src/imagens/btnEncerrar.png");

        //Inicialização e configurações dos botões       
        btnEntradaProd = new JButton(iconSelecionado);
        btnEntradaProd.setBounds(0, 237, 167, 47);
        btnEntradaProd.setContentAreaFilled(false);
        btnEntradaProd.setBorderPainted(false);
        btnEntradaProd.setFocusable(false);

        btnMenu = new JButton(iconMenu);
        btnMenu.setBounds(195, 84, iconMenu.getIconWidth(), iconMenu.getIconHeight());
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusable(false);

        btnConfirmar = new JButton();
        btnConfirmar.setBounds(392, 476, 100, 25);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setFocusable(false);

        btnCancelar = new JButton();
        btnCancelar.setBounds(503, 476, 100, 25);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusable(false);
        
        btnFechar = new JButton(iconFechar);
        btnFechar.setBounds(722, 23, 110, 22);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorderPainted(false);
        btnFechar.setFocusable(false);

        //Inicialização dos JComboBox
        jcbNome = new JComboBox();
        jcbNome.addItem("");
        jcbNome.setBounds(330, 192, 225, 20);
        jcbNome.setBorder(new LineBorder(Color.BLACK, 2));
        jcbNome.setFont(new Font("", Font.PLAIN, 12));
        jcbNome.setBackground(Color.WHITE);

        jcbNome.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton("▼");
                b.setContentAreaFilled(false);
                b.setBorder(new LineBorder(Color.BLACK, 1));
                return b;
            }
        });

        //Inicialização dos JTextFields      
        txtCPF = new JTextField();
        txtCPF.setBounds(641, 192, 130, 20);
        txtCPF.setBorder(new LineBorder(Color.BLACK, 2));
        txtCPF.setFont(new Font("", Font.PLAIN, 12));
        txtCPF.setCaretColor(Color.red);
        txtCPF.setEditable(true);

        txtNumNota = new JTextField();
        txtNumNota.setBounds(330, 233, 50, 20);
        txtNumNota.setBorder(new LineBorder(Color.BLACK, 2));
        txtNumNota.setFont(new Font("", Font.PLAIN, 12));
        txtNumNota.setCaretColor(Color.red);
        txtNumNota.setEditable(true);

        txtDataEntrega = new JTextField();
        txtDataEntrega.setBounds(502, 232, 65, 20);
        txtDataEntrega.setBorder(new LineBorder(Color.BLACK, 2));
        txtDataEntrega.setFont(new Font("", Font.PLAIN, 12));
        txtDataEntrega.setCaretColor(Color.red);
        txtDataEntrega.setEditable(true);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(641, 232, 130, 20);
        txtTelefone.setBorder(new LineBorder(Color.BLACK, 2));
        txtTelefone.setFont(new Font("", Font.PLAIN, 12));
        txtTelefone.setCaretColor(Color.GRAY);
        txtTelefone.setEditable(true);

        txtTotalGerado = new JTextField();
        txtTotalGerado.setBounds(753, 441, 69, 19);
        txtTotalGerado.setBorder(null);
        txtTotalGerado.setFont(new Font("", Font.PLAIN, 12));
        txtTotalGerado.setCaretColor(Color.GRAY);
        txtTotalGerado.setEditable(true);

        //Configuração do painel de rolagem
        jspRolagem = new JScrollPane();
        jspRolagem.setBounds(205, 310, 615, 110);
        jspRolagem.setBackground(Color.GRAY);
        jspRolagem.setBorder(new LineBorder(Color.BLACK, 1));

        tabelaProd = new JTable();
        tabelaProd.setBackground(Color.WHITE);
        tabelaProd.setGridColor(Color.BLACK);
        tabelaProd.setSelectionBackground(Color.GRAY);
        tabelaProd.setModel(new DefaultTableModel(
                new Object[][]{
                    {"111", "aaaaaaaaa", "1", "1", "1", "1"},
                    {"222", "aaaaaaaaa", "1", "1", "1", "1"},
                    {"333", "aaaaaaaaa", "1", "1", "1", "1"},
                    {"444", "aaaaaaaaa", "1", "1", "1", "1"},
                    {"555", "aaaaaaaaa", "1", "1", "1", "1"},
                    {"666", "aaaaaaaaa", "1", "1", "1", "1"},
                    {"777", "aaaaaaaaa", "1", "1", "1", "1"}
                },
                new String[]{
                    "Código", "Descrição", "Quantidade", "Preço de Compra", "Preço de Custo", "Preço de Venda"
                }
        ));
        jspRolagem.setViewportView(tabelaProd);

        // Adicionando os botões ao painel
        add(btnEntradaProd);
        add(btnMenu);
        add(btnConfirmar);
        add(btnCancelar);
        add(jcbNome);
        add(txtCPF);
        add(txtNumNota);
        add(txtDataEntrega);
        add(txtTelefone);
        add(jspRolagem);
        add(txtTotalGerado);
        add(btnFechar);

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaMenuFun telaFun = new TelaMenuFun(jf);
                setVisible(false);
                jf.add(telaFun);
                telaFun.requestFocus();
            }
        });

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar está operação?", "Cancelar", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {

                    txtCPF.setText("");
                    txtDataEntrega.setText("");
                    txtTelefone.setText("");
                } else {
                }
            }
        });
        
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar essa sessão?", "Encerrar", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    
                        TelaLogin telaLogin = new TelaLogin(jf);
                        setVisible(false);
                        jf.add(telaLogin);
                        telaLogin.requestFocus();
                    
                } else {
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }
}
