import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;


public class Main extends JFrame {
	
    public Main() throws IOException {
        
        initUI();
    }
    
    private void initUI() throws IOException {
        
    	Mapa I = new Mapa();
        add(I);
        setSize(800, 600);
        setResizable(true);
        
        setTitle("Catch the Pokemons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
        		Main ex = null;
				try {
					ex = new Main();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		ex.setVisible(true);
        		Mapa.printMapa();
        		
            }
        });
		


	}


}

