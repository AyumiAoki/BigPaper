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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class TelaFunProduto extends JPanel {

    private final BigPaper jf;

    private final ImageIcon fundo;
    private final ImageIcon iconSelecionado;
    private ImageIcon iconMenu;
    private ImageIcon iconInativo;
    private ImageIcon iconFechar;

    private JButton btnProduto;
    private JButton btnMenu;
    private JButton btnCadastrar;
    private JButton btnAlterar;
    private JButton btnConsultar;
    private JButton btnExcluir;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnCancelar;
    private JButton btnFechar;
    
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtMLucro;
    private JTextField txtMedida;
    
    private JComboBox jcbFornecedor;
    private JComboBox jcbMarca;

    public TelaFunProduto(final BigPaper jf) {

        this.jf = jf;

        setLayout(null);

        fundo = new ImageIcon("src/imagens/fundoFunProd.png");
        iconSelecionado = new ImageIcon("src/imagens/btnSelecionado.png");
        iconMenu = new ImageIcon("src/imagens/iconMenu.png");
        iconInativo = new ImageIcon("src/imagens/btnInativo.png");
        iconFechar = new ImageIcon("src/imagens/btnEncerrar.png");

        //Inicialização e configurações dos botões       
        btnProduto = new JButton(iconSelecionado);
        btnProduto.setBounds(0, 160, 167, 47);
        btnProduto.setContentAreaFilled(false);
        btnProduto.setBorderPainted(false);
        btnProduto.setFocusable(false);

        btnMenu = new JButton(iconMenu);
        btnMenu.setBounds(243, 96, iconMenu.getIconWidth(), iconMenu.getIconHeight());
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusable(false);

        btnCadastrar = new JButton();
        btnCadastrar.setBounds(311, 384, 100, 25);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setFocusable(false);

        btnConsultar = new JButton();
        btnConsultar.setBounds(425, 384, 100, 25);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.setBorderPainted(false);
        btnConsultar.setFocusable(false);

        btnAlterar = new JButton();
        btnAlterar.setBounds(539, 384, 100, 25);
        btnAlterar.setContentAreaFilled(false);
        btnAlterar.setBorderPainted(false);
        btnAlterar.setFocusable(false);

        btnExcluir = new JButton();
        btnExcluir.setBounds(653, 384, 100, 25);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setBorderPainted(false);
        btnExcluir.setFocusable(false);

        btnSalvar = new JButton(iconInativo);
        btnSalvar.setBounds(367, 415, 100, 25);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setBorderPainted(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setEnabled(false);

        btnLimpar = new JButton(iconInativo);
        btnLimpar.setBounds(478, 415, 100, 25);
        btnLimpar.setContentAreaFilled(false);
        btnLimpar.setBorderPainted(false);
        btnLimpar.setFocusable(false);
        btnLimpar.setEnabled(false);

        btnCancelar = new JButton(iconInativo);
        btnCancelar.setBounds(589, 415, 100, 25);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setEnabled(false);
        
        btnFechar = new JButton(iconFechar);
        btnFechar.setBounds(722, 23, 110, 22);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorderPainted(false);
        btnFechar.setFocusable(false);

        //Inicialização dos JTextFields
        txtCodigo = new JTextField();
        txtCodigo.setBounds(412, 216, 165, 20);
        txtCodigo.setBorder(new LineBorder(Color.BLACK, 2));
        txtCodigo.setFont(new Font("", Font.PLAIN, 12));
        txtCodigo.setCaretColor(Color.RED);
        txtCodigo.setEditable(true);
        
        txtNome = new JTextField();
        txtNome.setBounds(638, 216, 144, 20);
        txtNome.setBorder(new LineBorder(Color.BLACK, 2));
        txtNome.setFont(new Font("", Font.PLAIN, 12));
        txtNome.setCaretColor(Color.red);
        txtNome.setEditable(true);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(412, 256, 370, 20);
        txtDescricao.setBorder(new LineBorder(Color.BLACK, 2));
        txtDescricao.setFont(new Font("", Font.PLAIN, 12));
        txtDescricao.setCaretColor(Color.red);
        txtDescricao.setEditable(true);
        
        txtMLucro = new JTextField();
        txtMLucro.setBounds(412, 341, 158, 20);
        txtMLucro.setBorder(new LineBorder(Color.BLACK, 2));
        txtMLucro.setFont(new Font("", Font.PLAIN, 12));
        txtMLucro.setCaretColor(Color.red);
        txtMLucro.setEditable(true);

        txtMedida = new JTextField();
        txtMedida.setBounds(638, 341, 146, 20);
        txtMedida.setBorder(new LineBorder(Color.BLACK, 2));
        txtMedida.setFont(new Font("", Font.PLAIN, 12));
        txtMedida.setCaretColor(Color.red);
        txtMedida.setEditable(true);
        
        //Inicialização dos JComboBox
        jcbFornecedor = new JComboBox();
        jcbFornecedor.addItem("");
        jcbFornecedor.setBounds(412, 296, 165, 20);
        jcbFornecedor.setBorder(new LineBorder(Color.BLACK, 2));
        jcbFornecedor.setFont(new Font("", Font.PLAIN, 12));
        jcbFornecedor.setBackground(Color.WHITE);
        
        jcbFornecedor.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton("▼");
                b.setContentAreaFilled(false);
                b.setBorder(new LineBorder(Color.BLACK, 1));
                return b;
            }
        });
        
        jcbMarca = new JComboBox();
        jcbMarca.addItem("");
        jcbMarca.setBounds(638, 296, 146, 20);
        jcbMarca.setBorder(new LineBorder(Color.BLACK, 2));
        jcbMarca.setFont(new Font("", Font.PLAIN, 12));
        jcbMarca.setBackground(Color.WHITE);
        
        jcbMarca.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton("▼");
                b.setContentAreaFilled(false);
                b.setBorder(new LineBorder(Color.BLACK, 1));
                return b;
            }
        });

//        for (Departamento d : daoDepto.listaDepto()) {
//            jcbNome.addItem(d.getNome());
//        }
        
        //Evento do JCombobox
//        jcbFornecedor.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                daoDepto = new DaoDepto();
//                codDeptoText.setText(daoDepto.buscarCodigo(jcbNome.getSelectedItem().toString()));
//            }
//        });

        // Adicionando os botões ao painel
        add(btnProduto);
        add(btnMenu);
        add(btnCadastrar);
        add(btnConsultar);
        add(btnAlterar);
        add(btnExcluir);
        add(btnSalvar);
        add(btnLimpar);
        add(btnCancelar);
        add(txtCodigo);
        add(txtNome);
        add(txtDescricao);
        add(txtMLucro);
        add(txtMedida);
        add(jcbFornecedor);
        add(jcbMarca);
        add(btnFechar);
        
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                TelaMenuFun telaMenuFun = new TelaMenuFun(jf);
                setVisible(false);
                jf.add(telaMenuFun);
                telaMenuFun.requestFocus();
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCadastrar.setIcon(null);
                botoesAtivados();
                
                btnConsultar.setIcon(iconInativo);
                btnConsultar.setEnabled(false);
                
                btnAlterar.setIcon(iconInativo);
                btnAlterar.setEnabled(false);
                
                btnExcluir.setIcon(iconInativo);
                btnExcluir.setEnabled(false);
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConsultar.setIcon(null);
                botoesAtivados();
                btnCadastrar.setEnabled(false);
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAlterar.setIcon(null);
                botoesAtivados();
                btnCadastrar.setEnabled(false);
                btnConsultar.setEnabled(false);
                btnExcluir.setEnabled(false);
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnExcluir.setIcon(null);
                botoesAtivados();
                btnCadastrar.setEnabled(false);
                btnConsultar.setEnabled(false);
                btnAlterar.setEnabled(false);
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalvar.setIcon(null);
                botoesAtivados();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpar.setIcon(null);
                botoesAtivados();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /* public ConfirmDialogInFrame() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Confirm Dialog in Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        getContentPane().setLayout(null);
    }

    public static void main(String[] args){
        ImageIcon icon = new ImageIcon("src/images/turtle64.png");
        int input = JOptionPane.showConfirmDialog(new ConfirmDialogInFrame(), 
                "I appear as part of the frame!!", "Customized Dialog", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);

        // 0=ok, 2=cancel
        System.out.println(input);
    }*/
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar está operação?", "Cancelar", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {

                    txtNome.setText("");
                    txtDescricao.setText("");
                    txtMLucro.setText("");
                    txtMedida.setText("");
                    botoesDesativados();
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

    public void botoesAtivados() {

        btnSalvar.setEnabled(true);
        btnSalvar.setIcon(null);

        btnLimpar.setEnabled(true);
        btnLimpar.setIcon(null);

        btnCancelar.setEnabled(true);
        btnCancelar.setIcon(null);

    }

    public void botoesDesativados() {

        btnSalvar.setIcon(iconInativo);
        btnLimpar.setIcon(iconInativo);
        btnCancelar.setIcon(iconInativo);

        btnSalvar.setEnabled(false);
        btnLimpar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnConsultar.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }
}
