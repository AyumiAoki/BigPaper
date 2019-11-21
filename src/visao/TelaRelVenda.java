package visao;

import controle.BigPaper;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class TelaRelVenda extends JPanel{
    
    private final BigPaper jf;
    
    private JScrollPane jspRolagem;
    private JTable tabela;
    
    private JButton btnMenu;
    private JButton btnFechar;
    private JButton olaAdm;
    
    private JLabel lblFuncionario;
    private JLabel lblProduto;
    private JLabel lblEntrada;
    private JLabel lblSaida;
    private JLabel lblRelEstoque;
    
    private final ImageIcon iconMenu; 
    private final ImageIcon iconSelecionado;
    private final ImageIcon iconSelecionado2; 
    private final ImageIcon fundo; 
    private final ImageIcon iconFechar;
    private final ImageIcon iconOla;  

    public TelaRelVenda(final BigPaper jf) {
        
        this.jf = jf;
        
        setLayout(null);
        
        //Inicialização das imagens
        fundo = new ImageIcon("src/imagens/fundoTelas/fundoRelVenda.png");
        iconSelecionado = new ImageIcon("src/imagens/iconBotoes/btnSelecionado.png");
        iconSelecionado2 = new ImageIcon("src/imagens/iconBotoes/btnSelecionado2.png");
        iconMenu = new ImageIcon("src/imagens/iconBotoes/iconMenu.png");
        iconFechar = new ImageIcon("src/imagens/iconBotoes/btnEncerrar.png");
        iconOla = new ImageIcon("src/imagens/mensagens/olaAdm.png");
        
        //Inicialização das labels
        lblFuncionario = new JLabel(iconSelecionado);
        lblFuncionario.setBounds(0, 160, 167, 47);
        
        lblProduto = new JLabel(iconSelecionado2);
        lblProduto.setBounds(0, 207, 167, 48);
        
        lblEntrada = new JLabel(iconSelecionado);
        lblEntrada.setBounds(0, 285, 167, 47);
        
        lblSaida = new JLabel(iconSelecionado);
        lblSaida.setBounds(0, 332, 167, 47);
        
        lblRelEstoque = new JLabel(iconSelecionado);
        lblRelEstoque.setBounds(0, 409, 167, 47);

        //Inicialização e configurações dos botões 
        btnMenu = new JButton(iconMenu);
        btnMenu.setBounds(195, 81, iconMenu.getIconWidth(), iconMenu.getIconHeight());
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
        
        //Configuração do painel de rolagem e tabela
        jspRolagem = new JScrollPane();
        jspRolagem.setBounds(195, 185, 625, 230);
        jspRolagem.setBackground(Color.GRAY);
        jspRolagem.setBorder(new LineBorder(Color.BLACK, 1));

        tabela = new JTable();
        tabela.setBackground(Color.WHITE);
        tabela.setGridColor(Color.BLACK);
        tabela.setSelectionBackground(Color.GRAY);
        tabela.setModel(new DefaultTableModel(
                new Object[][]{
                    {"111", "caneta bic", "100", "1,00", "100"},
                    {"222", "lapis", "100", "1,00", "100"},
                    {"333", "borracha", "100", "1,00", "100"},
                    {"444", "caderno", "100", "1,00", "100"},
                    {"555", "regua", "100", "1,00", "100"},
                    {"666", "pasta", "100", "1,00", "100"},
                    {"777", "tesoura", "100", "1,00", "100"}
                },
                new String[]{
                    "Código", "Descrição", "Quantidade", "Preço do Produto", "Preço Total"
                }
        ));
        jspRolagem.setViewportView(tabela);
        
        add(jspRolagem);
        add(btnMenu);
        add(btnFechar);
        add(olaAdm);
        add(lblFuncionario);
        add(lblProduto);
        add(lblEntrada);
        add(lblSaida);
        add(lblRelEstoque);
        
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
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);

    }
}
