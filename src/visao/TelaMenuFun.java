package visao;

import controle.BigPaper;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class TelaMenuFun extends JPanel{
    
    private final BigPaper jf;
    
    private final ImageIcon fundo;
    private ImageIcon iconSelecionado;
    private ImageIcon iconFechar;
        
    private JButton btnProduto;
    private JButton btnEntrada;
    private JButton btnSaida;
    private JButton btnRelEstoque;
    private JButton btnRelVenda;
    private JButton btnFechar;
        
    public TelaMenuFun(final BigPaper jf){
       
        this.jf = jf;
        
        setLayout(null);
        
        fundo = new ImageIcon("src/imagens/fundoTelas/fundoMenuFun.png");
        iconSelecionado = new ImageIcon("src/imagens/iconBotoes/btnSelecionado.png");
        iconFechar = new ImageIcon("src/imagens/iconBotoes/btnEncerrar.png");
        
        //Inicialização e configurações dos botões         
        btnProduto = new JButton();
        btnProduto.setBounds(0, 160, 167, 47);
        btnProduto.setContentAreaFilled(false);
        btnProduto.setBorderPainted(false);
        btnProduto.setFocusable(false);
        
        btnEntrada = new JButton();
        btnEntrada.setBounds(0, 237, 167, 47);
        btnEntrada.setContentAreaFilled(false);
        btnEntrada.setBorderPainted(false);
        btnEntrada.setFocusable(false);
        
        btnSaida = new JButton();
        btnSaida.setBounds(0, 284, 167, 47);
        btnSaida.setContentAreaFilled(false);
        btnSaida.setBorderPainted(false);
        btnSaida.setFocusable(false);
        
        btnRelEstoque = new JButton();
        btnRelEstoque.setBounds(0, 361, 167, 47);
        btnRelEstoque.setContentAreaFilled(false);
        btnRelEstoque.setBorderPainted(false);
        btnRelEstoque.setFocusable(false);
        
        btnRelVenda = new JButton();
        btnRelVenda.setBounds(0, 408, 167, 47);
        btnRelVenda.setContentAreaFilled(false);
        btnRelVenda.setBorderPainted(false);
        btnRelVenda.setFocusable(false);
        
        btnFechar = new JButton(iconFechar);
        btnFechar.setBounds(722, 23, 110, 22);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorderPainted(false);
        btnFechar.setFocusable(false);
        
        // Adicionando os botões ao painel
        add(btnProduto);
        add(btnEntrada);
        add(btnSaida);
        add(btnRelEstoque);
        add(btnRelVenda);
        add(btnFechar);
        
        // Adicionando evento do mouse aos botões
        btnProduto.addMouseListener(new MouseListener() {
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
                btnProduto.setIcon(iconSelecionado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnProduto.setIcon(null);
            }
        });
        
        btnEntrada.addMouseListener(new MouseListener() {
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
                btnEntrada.setIcon(iconSelecionado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEntrada.setIcon(null);
            }
        });
        
        btnSaida.addMouseListener(new MouseListener() {
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
                btnSaida.setIcon(iconSelecionado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSaida.setIcon(null);
            }
        });
        
        btnRelEstoque.addMouseListener(new MouseListener() {
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
                btnRelEstoque.setIcon(iconSelecionado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRelEstoque.setIcon(null);
            }
        });
        
        btnRelVenda.addMouseListener(new MouseListener() {
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
                btnRelVenda.setIcon(iconSelecionado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRelVenda.setIcon(null);
            }
        });
        
        //Adicionando evento de ação aos botões
        btnProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFunProduto telaFunProd = new TelaFunProduto(jf);
                setVisible(false);
                jf.add(telaFunProd);
                telaFunProd.requestFocus();
            }
        });
        
        btnEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFunEntrada telaFunEntrada = new TelaFunEntrada(jf);
                setVisible(false);
                jf.add(telaFunEntrada);
                telaFunEntrada.requestFocus();
            }
        });
        
        btnSaida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFunSaida telaFunSaida = new TelaFunSaida(jf);
                setVisible(false);
                jf.add(telaFunSaida);
                telaFunSaida.requestFocus();
            }
        });
        
        btnRelEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFunRelEstoque telaFunEstoque = new TelaFunRelEstoque(jf);
                setVisible(false);
                jf.add(telaFunEstoque);
                telaFunEstoque.requestFocus();
            }
        });
        
        btnRelVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaFunRelVenda telaFunVenda = new TelaFunRelVenda(jf);
                setVisible(false);
                jf.add(telaFunVenda);
                telaFunVenda.requestFocus();
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
