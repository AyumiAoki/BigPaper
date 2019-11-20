package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import modelo.DaoFuncionario;
import modelo.Funcionario;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */
public class TelaConsultaFun extends JPanel {

    private final BigPaper jf;

    private JScrollPane jspRolagem;
    private JTable tabela;

    private JButton btnFuncionario;
    private JButton btnMenu;
    private JButton btnFechar;
    private JButton olaAdm;
    private JButton btnConfirmar;
    private JButton btnCancelar;

    private final ImageIcon iconMenu;
    private final ImageIcon iconSelecionado;
    private final ImageIcon fundo;
    private final ImageIcon iconFechar;
    private final ImageIcon iconOla;

    private DaoFuncionario daoFuncionario;
    private Funcionario funcionario;

    public TelaConsultaFun(final BigPaper jf) {

        this.jf = jf;

        setLayout(null);
        
        //Inicialização das imagens
        fundo = new ImageIcon("src/imagens/fundoTelas/fundoConsultaFun.png");
        iconSelecionado = new ImageIcon("src/imagens/iconBotoes/btnSelecionado.png");
        iconMenu = new ImageIcon("src/imagens/iconBotoes/iconMenu.png");
        iconFechar = new ImageIcon("src/imagens/iconBotoes/btnEncerrar.png");
        iconOla = new ImageIcon("src/imagens/mensagens/olaAdm.png");

        //Inicialização e configurações dos botões       
        btnFuncionario = new JButton(iconSelecionado);
        btnFuncionario.setBounds(0, 160, 167, 47);
        btnFuncionario.setContentAreaFilled(false);
        btnFuncionario.setBorderPainted(false);
        btnFuncionario.setFocusable(false);

        btnMenu = new JButton(iconMenu);
        btnMenu.setBounds(250, 95, iconMenu.getIconWidth(), iconMenu.getIconHeight());
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusable(false);

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

        btnConfirmar = new JButton();
        btnConfirmar.setBounds(406, 366, 100, 25);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setFocusable(false);

        btnCancelar = new JButton();
        btnCancelar.setBounds(517, 366, 100, 25);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusable(false);

        //Configuração do painel de rolagem e tabela
        jspRolagem = new JScrollPane();
        jspRolagem.setBounds(290, 210, 450, 80);
        jspRolagem.setBackground(Color.GRAY);
        jspRolagem.setBorder(new LineBorder(Color.BLACK, 1));

        tabela = new JTable();
        tabela.setBackground(Color.WHITE);
        tabela.setGridColor(Color.BLACK);
        tabela.setSelectionBackground(Color.GRAY);
        tabela.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome", "CPF", "Usuário"
                }
        ));

        jspRolagem.setViewportView(tabela);

        add(jspRolagem);
        add(btnFuncionario);
        add(btnMenu);
        add(btnFechar);
        add(olaAdm);
        add(btnConfirmar);
        add(btnCancelar);

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TelaMenuAdm telaMenuAdm = new TelaMenuAdm(jf);
                setVisible(false);
                jf.add(telaMenuAdm);
                telaMenuAdm.requestFocus();
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

                    TelaFuncionario telaFuncionario = new TelaFuncionario(jf);
                    setVisible(false);
                    jf.add(telaFuncionario);
                    telaFuncionario.requestFocus();
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
