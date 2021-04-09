import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class GraphicsEx1 extends javax.swing.JFrame {
    private JScrollPane jsp1;
    private JTextArea jta1;
    private JPanel jpnl1;

    {
    //Set Look & Feel
    try {
    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
    } catch(Exception e) {e.printStackTrace();}
    }

    public static void main(String[] args) {
        GraphicsEx1 inst = new GraphicsEx1();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

    public GraphicsEx1() {
        super();
        initGUI();
        postInitGUI();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
        {
        jsp1 = new JScrollPane();
        getContentPane().add(jsp1);
        jsp1.setBounds(10, 32, 372, 223);
        {
        jpnl1 = new JPanel();    //<----------------
        jsp1.setViewportView(jpnl1);    //<----------------
        jpnl1.setBackground(new java.awt.Color(255,255,255));
        jpnl1.setLayout(null);
        //jpnl1.setPreferredSize(new java.awt.Dimension(359, 327));
        }
        }
        pack();
        setSize(400, 300);
    } catch (Exception e) {e.printStackTrace();}
    }

    public void postInitGUI(){
        frmGrpView gp=new frmGrpView();
        jta1=new JTextArea();
        jta1=gp;
        jta1.setBounds(0,0, 336, 197);
        jta1.setVisible(true);
        //jpnl1.setBounds(0, 0, 336, 197);
        jpnl1.add(jta1);    //<----------------
        jpnl1.revalidate();
        jsp1.revalidate();
    }
}
    //----------------------- Second Class --------------------------
class frmGrpView extends JTextArea{
    public frmGrpView() {
    super();
    setEditable(false);
}

public void paint(Graphics g){
    super.paint(g);
    g.drawRect(10, 10, 100, 100);

    }
}