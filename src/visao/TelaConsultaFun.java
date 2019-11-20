package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import modelo.DaoFuncionario;
import modelo.Funcionario;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */
public class TelaConsultaFun extends JPanel {

    private final BigPaper jf;
    private TelaFuncionario telaFun;

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
    public Funcionario funSelecionado;
    
    TableColumn coluna1;
    TableColumn coluna2;
    TableColumn coluna3;

    public TelaConsultaFun(final BigPaper jf, TelaFuncionario telaFun) {

        this.jf = jf;
        this.telaFun = telaFun;

        setLayout(null);

        funSelecionado = new Funcionario();
        daoFuncionario = new DaoFuncionario();

        //telaFun = new TelaFuncionario(jf);

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
        jspRolagem.setBounds(263, 210, 502, 69);
        jspRolagem.setBackground(Color.GRAY);
        jspRolagem.setBorder(new LineBorder(Color.BLACK, 1));

        tabela = new JTable();
        tabela.setBackground(Color.WHITE);
        tabela.setSelectionBackground(Color.GRAY);
        tabela.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome", "CPF", "Usuário"
                }
        ));
        
        //Alterando a largura das 
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        coluna1 = tabela.getColumnModel().getColumn(0);
        coluna1.setPreferredWidth(200);
        
        coluna2 = tabela.getColumnModel().getColumn(1);
        coluna2.setPreferredWidth(150);
        
        coluna3 = tabela.getColumnModel().getColumn(2);
        coluna3.setPreferredWidth(150);
        
        //Centralizando o título das colunas
        JTableHeader header = tabela.getTableHeader();
        DefaultTableCellRenderer centralizado = (DefaultTableCellRenderer) header.getDefaultRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Adicionando dados na tabela
        DefaultTableModel fun = (DefaultTableModel) tabela.getModel();

        daoFuncionario = new DaoFuncionario();

        for (Funcionario f : daoFuncionario.listaFuncionario()) {

            fun.addRow(new Object[]{
                f.getNome(),
                f.getCpf(),
                f.getUsuario()

            });
        }

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

                daoFuncionario = new DaoFuncionario();

                if (tabela.getSelectedRow() != -1) {
                    funSelecionado = daoFuncionario.listaFuncionario().get(tabela.getSelectedRow());
                    telaFun.preencherJtext();
                                        
                    setVisible(false);
                    jf.add(telaFun);
                    telaFun.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum departamento selecionado!");
                }

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
