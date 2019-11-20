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

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class TelaFunConsultaProd extends JPanel{
    
    private final BigPaper jf;
    
    private JScrollPane jspRolagem;
    private JTable tabela;
    
    private JButton btnProduto;
    private JButton btnMenu;
    private JButton btnFechar;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    
    private final ImageIcon iconMenu; 
    private final ImageIcon iconSelecionado; 
    private final ImageIcon fundo; 
    private final ImageIcon iconFechar; 

    public TelaFunConsultaProd (final BigPaper jf) {
        
        this.jf = jf;
        
        setLayout(null);
        
        //Inicialização das imagens
        fundo = new ImageIcon("src/imagens/fundoTelas/fundoFunConsulta.png");
        iconSelecionado = new ImageIcon("src/imagens/iconBotoes/btnSelecionado.png");
        iconMenu = new ImageIcon("src/imagens/iconBotoes/iconMenu.png");
        iconFechar = new ImageIcon("src/imagens/iconBotoes/btnEncerrar.png");

        //Inicialização e configurações dos botões       
        btnProduto = new JButton(iconSelecionado);
        btnProduto.setBounds(0, 160, 167, 47);
        btnProduto.setContentAreaFilled(false);
        btnProduto.setBorderPainted(false);
        btnProduto.setFocusable(false);
        
        btnMenu = new JButton(iconMenu);
        btnMenu.setBounds(220, 95, iconMenu.getIconWidth(), iconMenu.getIconHeight());
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusable(false);
        
        btnFechar = new JButton(iconFechar);
        btnFechar.setBounds(722, 23, 110, 22);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorderPainted(false);
        btnFechar.setFocusable(false);
        
        btnConfirmar = new JButton();
        btnConfirmar.setBounds(406, 431, 100, 25);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setBorder(new LineBorder(Color.red, 2));
        btnConfirmar.setFocusable(false);

        btnCancelar = new JButton();
        btnCancelar.setBounds(517, 431, 100, 25);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorder(new LineBorder(Color.red, 2));
        btnCancelar.setFocusable(false);
        
        //Configuração do painel de rolagem e tabela
        jspRolagem = new JScrollPane();
        jspRolagem.setBounds(220, 210, 590, 170);
        jspRolagem.setBackground(Color.GRAY);
        jspRolagem.setBorder(new LineBorder(Color.BLACK, 1));

        tabela = new JTable();
        tabela.setBounds(220, 210, 590, 130);
        tabela.setBackground(Color.WHITE);
        tabela.setGridColor(Color.BLACK);
        tabela.setSelectionBackground(Color.GRAY);
        tabela.setModel(new DefaultTableModel(
                new Object[][]{
                    {"111", "caneta bic", "caneta bic", "5","cm","Cecilia", "Bic"},
                    {"222", "lapis", "lapis", "5","cm","Cecilia", "Bic"},
                    {"333", "borracha", "borracha", "5","cm","Cecilia", "Bic"},
                    {"444", "caderno", "caderno", "5","cm","Cecilia", "Bic"},
                    {"555", "regua", "regua", "5","cm","Cecilia", "Tilibra"},
                    {"666", "pasta", "pasta", "5","cm","Cecilia", "Bic"},
                    {"777", "tesoura", "tesoura", "5","cm","Cecilia", "Bic"}
                },
                new String[]{
                    "Código", "Nome", "Descrição", "Margem de Lucro (%)", "Medida", "Fornecedor", "Marca"
                }
        ));
        jspRolagem.setViewportView(tabela);
        
        add(jspRolagem);
        add(btnProduto);
        add(btnMenu);
        add(btnFechar);
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
                    
                    TelaFunProduto telaProduto = new TelaFunProduto(jf);
                    setVisible(false);
                    jf.add(telaProduto);
                    telaProduto.requestFocus();
                } 
                else {
                }
            }                
        });
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        g.drawImage(fundo.getImage(), 0, 0, fundo.getIconWidth(), fundo.getIconHeight(), this);

    }
}
