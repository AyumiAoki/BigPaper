package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
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
    
    private JLabel lblProduto;
    private JLabel lblEntrada;
    private JLabel lblSaida;
    private JLabel lblRelEstoque;
    private JLabel lblRelVenda;

    private int selecionado;
    private String nome;
    private String cpf;
    private String cpfAux;
    private String usuario;
    private String senha;
    private String confSenha;

    private DaoFuncionario daoFun;
    private Funcionario funcionario;

    private TelaConsultaFun telaConsulta;
    private TelaFuncionario telaFun;
    private ValidaCPF validarCpf;
    

    public TelaFuncionario(final BigPaper jf) {

        this.jf = jf;
        telaFun = this;
        validarCpf = new ValidaCPF();

        setLayout(null);

        selecionado = 0;
        nome = "";
        cpf = "";
        cpfAux = "";
        usuario = "";
        senha = "";
        confSenha = "";

        telaConsulta = new TelaConsultaFun(jf, this);

        daoFun = new DaoFuncionario();
        funcionario = new Funcionario();

        fundo = new ImageIcon("src/imagens/fundoTelas/fundoFuncionario.png");
        iconSelecionado = new ImageIcon("src/imagens/iconBotoes/btnSelecionado.png");
        iconMenu = new ImageIcon("src/imagens/iconBotoes/iconMenu.png");
        iconInativo = new ImageIcon("src/imagens/iconBotoes/btnInativo.png");
        iconFechar = new ImageIcon("src/imagens/iconBotoes/btnEncerrar.png");
        iconOla = new ImageIcon("src/imagens/mensagens/olaAdm.png");
        
        //Inicialização das labels
        lblProduto = new JLabel(iconSelecionado);
        lblProduto.setBounds(0, 208, 167, 47);
        
        lblEntrada = new JLabel(iconSelecionado);
        lblEntrada.setBounds(0, 285, 167, 47);
        
        lblSaida = new JLabel(iconSelecionado);
        lblSaida.setBounds(0, 332, 167, 47);
        
        lblRelEstoque = new JLabel(iconSelecionado);
        lblRelEstoque.setBounds(0, 409, 167, 47);
        
        lblRelVenda = new JLabel(iconSelecionado);
        lblRelVenda.setBounds(0, 456, 167, 47);

        //Inicialização e configurações dos botões
        btnMenu = new JButton(iconMenu);
        btnMenu.setBounds(230, 96, iconMenu.getIconWidth(), iconMenu.getIconHeight());
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusable(false);

        btnCadastrar = new JButton();
        btnCadastrar.setBounds(290, 383, 100, 25);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setFocusable(false);

        qntdFuncionarios();

        btnConsultar = new JButton();
        btnConsultar.setBounds(404, 383, 100, 25);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.setBorderPainted(false);
        btnConsultar.setFocusable(false);

        btnAlterar = new JButton();
        btnAlterar.setBounds(518, 383, 100, 25);
        btnAlterar.setContentAreaFilled(false);
        btnAlterar.setBorderPainted(false);
        btnAlterar.setFocusable(false);

        btnExcluir = new JButton();
        btnExcluir.setBounds(632, 383, 100, 25);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setBorderPainted(false);
        btnExcluir.setFocusable(false);

        btnSalvar = new JButton(iconInativo);
        btnSalvar.setBounds(346, 414, 100, 25);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setBorderPainted(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setEnabled(false);

        btnLimpar = new JButton(iconInativo);
        btnLimpar.setBounds(457, 414, 100, 25);
        btnLimpar.setContentAreaFilled(false);
        btnLimpar.setBorderPainted(false);
        btnLimpar.setFocusable(false);
        btnLimpar.setEnabled(false);

        btnCancelar = new JButton(iconInativo);
        btnCancelar.setBounds(568, 414, 100, 25);
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
        txtNome.setBounds(440, 218, 250, 20);
        txtNome.setBorder(new LineBorder(Color.GRAY, 2));
        txtNome.setFont(new Font("", Font.PLAIN, 12));
        txtNome.setCaretColor(Color.red);
        txtNome.setEditable(false);

        txtCPF = new JTextField();
        txtCPF.setBounds(440, 248, 250, 20);
        txtCPF.setBorder(new LineBorder(Color.GRAY, 2));
        txtCPF.setFont(new Font("", Font.PLAIN, 12));
        txtCPF.setCaretColor(Color.red);
        txtCPF.setEditable(false);
        
        txtCPF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                validarCpf.imprimeCPF(txtCPF.getText());
            }
        });

        txtUsuario = new JTextField();
        txtUsuario.setBounds(440, 278, 250, 20);
        txtUsuario.setBorder(new LineBorder(Color.GRAY, 2));
        txtUsuario.setFont(new Font("", Font.PLAIN, 12));
        txtUsuario.setCaretColor(Color.red);
        txtUsuario.setEditable(false);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(440, 308, 250, 20);
        txtSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtSenha.setFont(new Font("", Font.PLAIN, 12));
        txtSenha.setCaretColor(Color.red);
        txtSenha.setEditable(false);

        txtConfSenha = new JPasswordField();
        txtConfSenha.setBounds(440, 338, 250, 20);
        txtConfSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtConfSenha.setFont(new Font("", Font.PLAIN, 12));
        txtConfSenha.setCaretColor(Color.red);
        txtConfSenha.setEditable(false);

        // Adicionando os botões ao painel
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
        add(lblProduto);
        add(lblEntrada);
        add(lblSaida);
        add(lblRelEstoque);
        add(lblRelVenda);

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

                btnCadastrar.setIcon(iconInativo);
                btnCadastrar.setEnabled(false);

                btnMenu.setEnabled(false);
                btnFechar.setEnabled(false);
                
                camposAtivados();
                botoesDesativados();

                btnConsultar.setIcon(iconInativo);
                btnConsultar.setEnabled(false);

                btnAlterar.setIcon(iconInativo);
                btnAlterar.setEnabled(false);

                btnExcluir.setIcon(iconInativo);
                btnExcluir.setEnabled(false);
                
                txtNome.requestFocus();

                selecionado = 1;
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnConsultar.setIcon(null);
                btnConsultar.setEnabled(true);

                btnSalvar.setIcon(iconInativo);
                btnSalvar.setEnabled(false);

                btnLimpar.setIcon(iconInativo);
                btnLimpar.setEnabled(false);

                btnCancelar.setIcon(null);
                btnCancelar.setEnabled(true);

                btnCadastrar.setIcon(iconInativo);
                btnCadastrar.setEnabled(false);

                btnAlterar.setIcon(null);
                btnAlterar.setEnabled(true);

                btnExcluir.setIcon(null);
                btnExcluir.setEnabled(true);

                telaConsulta = new TelaConsultaFun(jf, telaFun);
                setVisible(false);
                jf.add(telaConsulta);
                telaConsulta.setVisible(true);
                telaConsulta.requestFocus();

            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Selecione o funcionário que deseja alterar");

                telaConsulta = new TelaConsultaFun(jf, telaFun);
                setVisible(false);
                jf.add(telaConsulta);
                telaConsulta.setVisible(true);
                telaConsulta.requestFocus();

                selecionado = 2;
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Selecione o funcionário que deseja excluir");

                telaConsulta = new TelaConsultaFun(jf, telaFun);
                setVisible(false);
                jf.add(telaConsulta);
                telaConsulta.setVisible(true);
                telaConsulta.requestFocus();

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

                        if (validarCpf.isCPF(cpf)) {
                            
                            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente inserir este funcionário?", "Inserir", JOptionPane.YES_NO_OPTION);

                            if (resposta == JOptionPane.YES_OPTION) {

                                if (daoFun.inserirFuncionario(funcionario)) {
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
                            JOptionPane.showMessageDialog(null, "CPF inválido!");
                            txtCPF.requestFocus();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
                    }
                } else if (selecionado == 2) {

                    nome = txtNome.getText();
                    cpf = txtCPF.getText();
                    usuario = txtUsuario.getText();
                    senha = new String(txtSenha.getPassword());
                    confSenha = new String(txtConfSenha.getPassword());

                    funcionario = new Funcionario(nome, cpf, usuario, senha);

                    daoFun = new DaoFuncionario();

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar os dados deste funcionário?", "Atualizar", JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_OPTION) {

                        if (daoFun.atualizarFuncionario(funcionario, cpfAux)) {
                            JOptionPane.showMessageDialog(null, "Sucesso de operação");
                            camposDesativados();
                            botoesAtivados();
                            btnMenu.setEnabled(true);
                            btnFechar.setEnabled(true);
                            requestFocus();

                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário\n ");
                        }
                    } else {
                    }
                } else {

                    funcionario = new Funcionario(cpfAux);

                    daoFun = new DaoFuncionario();

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este funcionário?", "Excluir", JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_OPTION) {

                        if (daoFun.excluirFuncionario(funcionario)) {
                            JOptionPane.showMessageDialog(null, "Sucesso de operação");
                            camposDesativados();
                            botoesAtivados();
                            btnMenu.setEnabled(true);
                            btnFechar.setEnabled(true);
                            requestFocus();

                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário\n ");
                        }
                    } else {
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
        txtNome.setEditable(false);
        txtNome.setText("");

        txtCPF.setBorder(new LineBorder(Color.GRAY, 2));
        txtCPF.setEditable(false);
        txtCPF.setText("");

        txtUsuario.setBorder(new LineBorder(Color.GRAY, 2));
        txtUsuario.setEditable(false);
        txtUsuario.setText("");

        txtSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtSenha.setEditable(false);
        txtSenha.setText("");

        txtConfSenha.setBorder(new LineBorder(Color.GRAY, 2));
        txtConfSenha.setEditable(false);
        txtConfSenha.setText("");
    }

    public void botoesAtivados() {

        btnCadastrar.setIcon(null);
        btnCadastrar.setEnabled(true);

        btnConsultar.setIcon(null);
        btnConsultar.setEnabled(true);

        btnAlterar.setIcon(null);
        btnAlterar.setEnabled(true);

        btnExcluir.setIcon(null);
        btnExcluir.setEnabled(true);

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

    public void qntdFuncionarios() {

        daoFun = new DaoFuncionario();

        daoFun.listaFuncionario();

        if (daoFun.i == 3) {
            btnCadastrar.setIcon(iconInativo);
            btnCadastrar.setEnabled(false);
        } 
    }

    public void preencherJtext() {

        camposDesativados();

        txtNome.setText(telaConsulta.funSelecionado.getNome());
        txtCPF.setText(telaConsulta.funSelecionado.getCpf());
        txtUsuario.setText(telaConsulta.funSelecionado.getUsuario());

        cpfAux = telaConsulta.funSelecionado.getCpf();

        if (selecionado == 2) {

            btnAlterar.setIcon(null);
            btnAlterar.setEnabled(false);

            txtNome.setEditable(true);
            txtCPF.setEditable(true);
            txtUsuario.setEditable(true);

            txtNome.setBorder(new LineBorder(Color.BLACK, 2));
            txtCPF.setBorder(new LineBorder(Color.BLACK, 2));
            txtUsuario.setBorder(new LineBorder(Color.BLACK, 2));

            botoesDesativados();

            btnCadastrar.setIcon(iconInativo);
            btnCadastrar.setEnabled(false);

            btnConsultar.setIcon(iconInativo);
            btnConsultar.setEnabled(false);

            btnExcluir.setIcon(iconInativo);
            btnExcluir.setEnabled(false);

        } else if (selecionado == 3) {

            btnExcluir.setIcon(null);
            btnExcluir.setEnabled(false);

            txtNome.setEditable(false);
            txtCPF.setEditable(false);
            txtUsuario.setEditable(false);

            txtNome.setBorder(new LineBorder(Color.GRAY, 2));
            txtCPF.setBorder(new LineBorder(Color.GRAY, 2));
            txtUsuario.setBorder(new LineBorder(Color.GRAY, 2));

            botoesDesativados();

            btnCadastrar.setIcon(iconInativo);
            btnCadastrar.setEnabled(false);

            btnConsultar.setIcon(iconInativo);
            btnConsultar.setEnabled(false);

            btnAlterar.setIcon(iconInativo);
            btnAlterar.setEnabled(false);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }
}
