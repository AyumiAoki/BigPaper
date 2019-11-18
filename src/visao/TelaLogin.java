package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.DaoFuncionario;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */
public class TelaLogin extends JPanel {

    private final BigPaper jf;

    private final ImageIcon fundo;
    private final ImageIcon iconSelecionado;
    private final ImageIcon iconOpSelecionado;

    private JButton btnEntrar;
    private JButton btnFuncionario;
    private JButton btnAdm;

    private JTextField txtLogin;
    private JPasswordField txtSenha;

    private int op;
    private String nome;
    private String senha;

    private DaoFuncionario daoFun;

    public TelaLogin(final BigPaper jf) {

        this.jf = jf;

        setLayout(null);

        op = 0;
        nome = "";

        fundo = new ImageIcon("src/imagens/fundoLogin1.png");
        iconSelecionado = new ImageIcon("src/imagens/btnEntrarSelecionado.png");
        iconOpSelecionado = new ImageIcon("src/imagens/btnOpSelecionado.png");

        btnEntrar = new JButton();
        btnEntrar.setBounds(609, 396, 108, 32);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setBorderPainted(false);

        btnFuncionario = new JButton();
        btnFuncionario.setBounds(543, 368, 8, 8);
        btnFuncionario.setContentAreaFilled(false);
        btnFuncionario.setBorderPainted(false);

        btnAdm = new JButton();
        btnAdm.setBounds(675, 368, 8, 8);
        btnAdm.setContentAreaFilled(false);
        btnAdm.setBorderPainted(false);

        txtLogin = new JTextField("Usuário");
        txtLogin.setBounds(547, 266, 236, 28);
        txtLogin.setBorder(null);
        txtLogin.setFont(new Font("", Font.BOLD, 12));
        txtLogin.setCaretColor(Color.BLACK);
        txtLogin.setEditable(true);

        txtLogin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtLogin.getText().equals("Usuário")) {
                    txtLogin.setText("");
                } else {

                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        txtSenha = new JPasswordField("Senha");
        txtSenha.setBounds(547, 319, 236, 28);
        txtSenha.setBorder(null);
        txtSenha.setFont(new Font("", Font.BOLD, 12));
        txtSenha.setCaretColor(Color.BLACK);
        txtSenha.setEditable(true);
        txtSenha.setEchoChar((char) 0);

        txtSenha.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSenha.setText("");
                txtSenha.setEchoChar('•');
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
                
        add(btnEntrar);
        add(btnFuncionario);
        add(btnAdm);
        add(txtLogin);
        add(txtSenha);

        // Adicionando evento do mouse aos botões
        btnEntrar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnEntrar.setIcon(iconSelecionado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEntrar.setIcon(null);
            }
        });

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nome = txtLogin.getText();
                senha = new String(txtSenha.getPassword());

                daoFun = new DaoFuncionario();

                if (op != 0) {
                    if (!nome.equals("") && !senha.equals("")) {
                        if (op == 1) {

                            TelaMenuFun telaFun = new TelaMenuFun(jf);
                            setVisible(false);
                            jf.add(telaFun);
                            telaFun.requestFocus();

                        } else {
                            if (daoFun.buscarFuncionario(nome, senha)) {

                                TelaMenuAdm telaAdm = new TelaMenuAdm(jf);
                                setVisible(false);
                                jf.add(telaAdm);
                                telaAdm.requestFocus();

                            } else {
                                txtLogin.setText("");
                                txtSenha.setText("");
                                JOptionPane.showMessageDialog(null, "Senha ou login incorreto!");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione seu cargo!");
                }
            }
        });

        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 1;
                btnAdm.setIcon(null);
                btnFuncionario.setIcon(iconOpSelecionado);
            }
        });

        btnAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 2;
                btnFuncionario.setIcon(null);
                btnAdm.setIcon(iconOpSelecionado);
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);
    }
}
