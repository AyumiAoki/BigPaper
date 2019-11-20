package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modelo.DaoFuncionario;
import modelo.Funcionario;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */
public class TelaFuncionario extends JPanel {

    private final BigPaper jf;

    private final ImageIcon fundo;
    private final ImageIcon iconSelecionado;
    private ImageIcon iconMenu;
    private ImageIcon iconInativo;
    private ImageIcon iconFechar;
    private final ImageIcon iconOla;

    private JButton btnFuncionario;
    private JButton btnMenu;
    private JButton btnCadastrar;
    private JButton btnAlterar;
    private JButton btnConsultar;
    private JButton btnExcluir;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnCancelar;
    private JButton btnFechar;
    private JButton olaAdm;

    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JPasswordField txtConfSenha;

    private int selecionado;
    private String nome;
    private String cpf;
    private String usuario;
    private String senha;
    private String confSenha;

    private DaoFuncionario daoFun;
    private Funcionario funcionario;

    public TelaFuncionario(final BigPaper jf) {

        this.jf = jf;

        setLayout(null);

        selecionado = 0;
        nome = "";
        cpf = "";
        usuario = "";
        senha = "";
        confSenha = "";
        
        daoFun = new DaoFuncionario();
        funcionario = new Funcionario();
        
        fundo = new ImageIcon("src/imagens/fundoTelas/fundoFuncionario.png");
        iconSelecionado = new ImageIcon("src/imagens/iconBotoes/btnSelecionado.png");
        iconMenu = new ImageIcon("src/imagens/iconBotoes/iconMenu.png");
        iconInativo = new ImageIcon("src/imagens/iconBotoes/btnInativo.png");
        iconFechar = new ImageIcon("src/imagens/iconBotoes/btnEncerrar.png");
        iconOla = new ImageIcon("src/imagens/mensagens/olaAdm.png");

        //Inicialização e configurações dos botões       
        btnFuncionario = new JButton(iconSelecionado);
        btnFuncionario.setBounds(0, 160, 167, 47);
        btnFuncionario.setContentAreaFilled(false);
        btnFuncionario.setBorderPainted(false);
        btnFuncionario.setFocusable(false);

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

        olaAdm = new JButton(iconOla);
        olaAdm.setBounds(0, 65, 167, 65);
        olaAdm.setContentAreaFilled(false);
        olaAdm.setBorderPainted(false);
        olaAdm.setFocusable(false);

        //Inicialização dos JTextFields
        txtNome = new JTextField();
        txtNome.setBounds(445, 218, 250, 20);
        txtNome.setBorder(new LineBorder(Color.GRAY, 2));
        txtNome.setFont(new Font("", Font.PLAIN, 12));
        txtNome.setCaretColor(Color.red);
        txtNome.setEditable(false);

        txtCPF = new JTextField();
        txtCPF.setBounds(445, 248, 250, 20);
        txtCPF.setBorder(new LineBorder(Color.GRAY, 2));
        txtCPF.setFont(new Font("", Font.PLAIN, 12));
        txtCPF.setCaretColor(Color.red);
        txtCPF.setEditable(false);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(445, 278, 250, 20);
        txtUsuario.setBorder(new LineBorder(Color.GRAY, 2));
        txtUsuario.setFont(new Font("", Font.PLAIN, 12));
        txtUsuario.setCaretColor(Color.red);
        txtUsuario.setEditable(false);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(445, 308, 250, 20);
        txtSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtSenha.setFont(new Font("", Font.PLAIN, 12));
        txtSenha.setCaretColor(Color.red);
        txtSenha.setEditable(false);

        txtConfSenha = new JPasswordField();
        txtConfSenha.setBounds(445, 338, 250, 20);
        txtConfSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtConfSenha.setFont(new Font("", Font.PLAIN, 12));
        txtConfSenha.setCaretColor(Color.red);
        txtConfSenha.setEditable(false);

        // Adicionando os botões ao painel
        add(btnFuncionario);
        add(btnMenu);
        add(btnCadastrar);
        add(btnConsultar);
        add(btnAlterar);
        add(btnExcluir);
        add(btnSalvar);
        add(btnLimpar);
        add(btnCancelar);
        add(txtNome);
        add(txtCPF);
        add(txtUsuario);
        add(txtSenha);
        add(txtConfSenha);
        add(btnFechar);
        add(olaAdm);

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaMenuAdm telaMenuAdm = new TelaMenuAdm(jf);
                setVisible(false);
                jf.add(telaMenuAdm);
                telaMenuAdm.requestFocus();
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnCadastrar.setIcon(null);
                btnCadastrar.setEnabled(false);

                btnMenu.setEnabled(false);
                btnFechar.setEnabled(false);

                txtNome.requestFocus();

                camposAtivados();
                botoesDesativados();

                btnConsultar.setIcon(iconInativo);
                btnConsultar.setEnabled(false);

                btnAlterar.setIcon(iconInativo);
                btnAlterar.setEnabled(false);

                btnExcluir.setIcon(iconInativo);
                btnExcluir.setEnabled(false);

                selecionado = 1;
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnConsultar.setIcon(null);
                btnConsultar.setEnabled(false);

                camposAtivados();
                botoesDesativados();

                btnCadastrar.setIcon(iconInativo);
                btnCadastrar.setEnabled(false);

                btnAlterar.setIcon(iconInativo);
                btnAlterar.setEnabled(false);

                btnExcluir.setIcon(iconInativo);
                btnExcluir.setEnabled(false);

                TelaConsultaFun telaConsultaFun = new TelaConsultaFun(jf);
                setVisible(false);
                jf.add(telaConsultaFun);
                telaConsultaFun.requestFocus();

            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnAlterar.setIcon(null);
                btnAlterar.setEnabled(false);

                camposAtivados();
                botoesDesativados();

                btnCadastrar.setIcon(iconInativo);
                btnCadastrar.setEnabled(false);

                btnConsultar.setIcon(iconInativo);
                btnConsultar.setEnabled(false);

                btnExcluir.setIcon(iconInativo);
                btnExcluir.setEnabled(false);

                selecionado = 2;
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnExcluir.setIcon(null);
                btnExcluir.setEnabled(false);

                camposAtivados();
                botoesDesativados();

                btnCadastrar.setIcon(iconInativo);
                btnCadastrar.setEnabled(false);

                btnConsultar.setIcon(iconInativo);
                btnConsultar.setEnabled(false);

                btnAlterar.setIcon(iconInativo);
                btnAlterar.setEnabled(false);

                selecionado = 3;
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalvar.setIcon(null);

                if (selecionado == 1) {

                    nome = txtNome.getText();
                    cpf = txtCPF.getText();
                    usuario = txtUsuario.getText();
                    senha = new String(txtSenha.getPassword());
                    confSenha = new String(txtConfSenha.getPassword());

                    funcionario = new Funcionario(nome, cpf, usuario, senha);

                    daoFun = new DaoFuncionario();

                    if (senha.equals(confSenha)) {
                        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar os dados?", "Salvar", JOptionPane.YES_NO_OPTION);

                        if (resposta == JOptionPane.YES_OPTION) {

                            if (daoFun.inserirFun(funcionario)) {
                                JOptionPane.showMessageDialog(null, "Sucesso de operação");
                                camposDesativados();
                                botoesAtivados();
                                btnMenu.setEnabled(true);
                                btnFechar.setEnabled(true);
                                requestFocus();

                            } else {
                                JOptionPane.showMessageDialog(null, "Erro ao Inserir Funcionário\n ");
                            }
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
                    }
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar os campos?", "Limpar", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {

                    txtNome.setText("");
                    txtCPF.setText("");
                    txtUsuario.setText("");
                    txtSenha.setText("");
                    txtConfSenha.setText("");

                    txtNome.requestFocus();

                } else {
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar está operação?", "Cancelar", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {

                    camposDesativados();
                    botoesAtivados();
                    btnMenu.setEnabled(true);
                    btnFechar.setEnabled(true);

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

    public void camposAtivados() {

        txtNome.setBorder(new LineBorder(Color.BLACK, 2));
        txtNome.setEditable(true);
        txtNome.setText("");

        txtCPF.setBorder(new LineBorder(Color.BLACK, 2));
        txtCPF.setEditable(true);
        txtCPF.setText("");

        txtUsuario.setBorder(new LineBorder(Color.BLACK, 2));
        txtUsuario.setEditable(true);
        txtUsuario.setText("");

        txtSenha.setBorder(new LineBorder(Color.BLACK, 2));
        txtSenha.setEditable(true);
        txtSenha.setText("");

        txtConfSenha.setBorder(new LineBorder(Color.BLACK, 2));
        txtConfSenha.setEditable(true);
        txtConfSenha.setText("");

    }

    public void camposDesativados() {

        txtNome.setBorder(new LineBorder(Color.GRAY, 2));
        txtNome.setEditable(true);
        txtNome.setText("");

        txtCPF.setBorder(new LineBorder(Color.GRAY, 2));
        txtCPF.setEditable(true);
        txtCPF.setText("");

        txtUsuario.setBorder(new LineBorder(Color.GRAY, 2));
        txtUsuario.setEditable(true);
        txtUsuario.setText("");

        txtSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtSenha.setEditable(true);
        txtSenha.setText("");

        txtConfSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtConfSenha.setEditable(true);
        txtConfSenha.setText("");
    }

    public void botoesAtivados() {

        btnCadastrar.setEnabled(true);
        btnCadastrar.setIcon(null);

        btnConsultar.setEnabled(true);
        btnConsultar.setIcon(null);

        btnAlterar.setEnabled(true);
        btnAlterar.setIcon(null);

        btnExcluir.setEnabled(true);
        btnExcluir.setIcon(null);

        btnSalvar.setIcon(iconInativo);
        btnSalvar.setEnabled(false);

        btnLimpar.setIcon(iconInativo);
        btnLimpar.setEnabled(false);

        btnCancelar.setIcon(iconInativo);
        btnCancelar.setEnabled(false);
    }

    public void botoesDesativados() {

        btnSalvar.setEnabled(true);
        btnSalvar.setIcon(null);

        btnLimpar.setEnabled(true);
        btnLimpar.setIcon(null);

        btnCancelar.setEnabled(true);
        btnCancelar.setIcon(null);

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }
}
