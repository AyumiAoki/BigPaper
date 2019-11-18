package controle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import visao.TelaLogin;
import visao.TelaMenuAdm;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class BigPaper extends JFrame{
    
    public TelaMenuAdm telaMenuAdm;
    private TelaLogin telaLogin;
    
    private ImageIcon fundo;

    public BigPaper() {
        
        telaLogin = new TelaLogin(this);
        telaMenuAdm = new TelaMenuAdm(this);
        fundo = new ImageIcon("src/imagens/fundoMenuAdm.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Big Paper");
        setSize(fundo.getIconWidth(), fundo.getIconHeight());
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagens/logo1.png"));

        add(telaLogin);
    }

    public static void main(String[] args) {
        BigPaper bp = new BigPaper();
    }
}
