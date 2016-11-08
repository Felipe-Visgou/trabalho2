import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.jpl7.*;
import java.lang.System;

public class Mapa extends JPanel implements ActionListener {
	
	public static java.lang.Integer score, energy, pokemons, ammo,ethanX, ethanY; 
	public static int[] matrixMapa;
	private Timer timer;
    private final int DELAY = 1000;
    private static Map<String, Term>[] step_solution;
    private static Term local_atual;
    private static Term sentidos_atuais;
    private static int n_iteration = 0;
	
	public Mapa() throws IOException{
		matrixMapa = new int[12*12];
		
    	FileReader inputStream = null;
    	int i,j;
        try {
            inputStream = new FileReader("instance.txt");
            for(i = 0; i< 12; i++){
            	for(j = 0; j < 12; j++){
            		matrixMapa[i*12 + j] = inputStream.read();
            	}
            	inputStream.read(); // Ignora CR
            	inputStream.read(); // Ignora \n
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
		 score = 0;
		 energy = 0;
		 pokemons = 0;
		 ammo = 5;
		 ethanX = 1;
		 ethanY = 1;
	    timer = new Timer(DELAY, this);
	        timer.start();
        // Desenha a interface do mapa
	    initialize();
        initBoard();
	}
    private void initBoard() {
        setFocusable(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }
    private void doDrawing(Graphics g) {

		int it = 0;
		int pok = 0;
		int desloc = 40, defaultSize = 40;
		Image extd, exte,exts,exti, id,ie,sd,se, ground;
		Image cyndaquil, totodile, chikorita, gengar, alakazam, haunter, vortex, pokeball, ethan;
		Graphics2D g2d = (Graphics2D) g;
		// canto inferior
		ImageIcon img = new ImageIcon("ie.png");
		ie = img.getImage();
		g2d.drawImage(ie,0,desloc + 12*desloc,defaultSize,defaultSize,this);
		img = new ImageIcon("id.png");
		id = img.getImage();
		g2d.drawImage(id,desloc+12*desloc,desloc + 12*desloc,defaultSize,defaultSize,this);
		img = new ImageIcon("exti.png");
		exti = img.getImage();
		for(int i = 0; i < 12; i++){
			g2d.drawImage(exti,desloc+i*desloc,desloc+desloc*12,defaultSize,defaultSize,this);
		}
		// canto superior
		img = new ImageIcon("se.png");
		se = img.getImage();
		g2d.drawImage(se,0,0,defaultSize,defaultSize,this);
		img = new ImageIcon("sd.png");
		sd = img.getImage();
		g2d.drawImage(sd,desloc+12*desloc,0,defaultSize,defaultSize,this);
		img = new ImageIcon("exts.png");
		exts = img.getImage();
		for(int i = 0; i < 12; i++){
			g2d.drawImage(exts,desloc+i*desloc,0,defaultSize,defaultSize,this);
		}
		img = new ImageIcon("extd.png");
		extd = img.getImage();
		for(int i = 0; i < 12; i++){
			g2d.drawImage(extd,desloc+12*desloc,desloc+i*desloc,defaultSize,defaultSize,this);
		}
		img = new ImageIcon("exte.png");
		exte = img.getImage();
		for(int i = 0; i < 12; i++){
			g2d.drawImage(exte,0,desloc+i*desloc,defaultSize,defaultSize,this);
		}
		img = new ImageIcon("ground.png");
		ground = img.getImage();
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12;j++){
				g2d.drawImage(ground,desloc + i*desloc,desloc+j*desloc,defaultSize,defaultSize,this);
			}
		}
        ImageIcon img1 = new ImageIcon("chikorita.png");
        chikorita = img1.getImage();
        img1 = new ImageIcon("cyndaquil.png");
        cyndaquil = img1.getImage();
        img1 = new ImageIcon("totodile.png");
        totodile = img1.getImage();
        img1 = new ImageIcon("gengar.png");
        gengar = img1.getImage();
        img1 = new ImageIcon("alakazam.png");
        alakazam = img1.getImage();
        img1 = new ImageIcon("haunter.png");
        haunter = img1.getImage();
        img1 = new ImageIcon("vortex.png");
        vortex = img1.getImage();
        img1 = new ImageIcon("extd.png");
        extd = img1.getImage();
        img1 = new ImageIcon("exte.png");
        exte = img1.getImage();
        img1 = new ImageIcon("exts.png");
        exts = img1.getImage();
        img1 = new ImageIcon("exti.png");
        exti = img1.getImage();
        img1 = new ImageIcon("id.png");
        id = img1.getImage();
        img1 = new ImageIcon("ie.png");
        ie = img1.getImage();
        img1 = new ImageIcon("sd.png");
        sd = img1.getImage();
        img1 = new ImageIcon("se.png");
        se = img1.getImage();
        img1 = new ImageIcon("pokeball.png");        
        pokeball = img1.getImage();
        for(int i = 0 ;i < 12; i++){
        	for(int j = 0; j < 12;j++){
        		if(matrixMapa[j*12 + i] == '.') continue;
        		if(matrixMapa[j*12 + i] == 'O'){
        			switch(pok){
        			case 0:
        				g2d.drawImage(cyndaquil,desloc + i*desloc,desloc + j*desloc,defaultSize+20,defaultSize+20,this);
        				pok++;
        				break;
        			case 1:
        				g2d.drawImage(totodile,desloc + i*desloc,desloc + j*desloc,defaultSize+20,defaultSize+20,this);
        				pok++;
        				break;
        			case 2:
        				g2d.drawImage(chikorita,desloc + i*desloc,desloc + j*desloc,defaultSize+20,defaultSize+20,this);
        				pok++;
        				break;
        			default: System.out.println("Erro ao desenhar os pokemons");
        			}
        		}
        		else{
        			if(matrixMapa[j*12 + i] == 'P'){
            			g2d.drawImage(vortex,desloc + i*desloc, desloc +j*desloc,defaultSize-8,defaultSize-8,this);
        			}
        			else{
        				if(matrixMapa[j*12 + i] == 'T'){
        						g2d.drawImage(alakazam,desloc + i*desloc,desloc+ j*desloc,defaultSize+10,defaultSize+10,this);
        					}
        				else{
        					if(matrixMapa[j*12 + i] == 'D')
        						g2d.drawImage(gengar,desloc + i*desloc,desloc + j*desloc,defaultSize+12,defaultSize+12,this);
        					else
        						if(matrixMapa[j*12 + i] == 'd'){
        							g2d.drawImage(haunter,desloc + i*desloc,desloc + j*desloc,defaultSize+12,defaultSize+12,this);
        						}
        						else
            						if(matrixMapa[j*12 + i] == 'U'){
            							g2d.drawImage(pokeball,desloc + i*desloc + 13,desloc + j*desloc + 13,defaultSize-22,defaultSize-22,this);
            						}
        				}
        			}
        		}
        	}
        }
        updateKnowledge();
		g2d.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont(15.0f));
		g2d.drawString("Energy : ", 600, 40);
		g2d.drawString(energy.toString(), 650, 40);
		g2d.drawString("Score : ", 600, 60);
		g2d.drawString(score.toString(), 650, 60);
		g2d.drawString("Captured : ", 600, 80);
		g2d.drawString(pokemons.toString(), 670, 80);
		g2d.drawString("Ammo : ", 600, 100);
		g2d.drawString(ammo.toString(), 670, 100);
	//	drawPercept(g2d);
		
        ImageIcon img6;
        ethan = null;
        ethanX = local_atual.arg(1).intValue();
        ethanY = local_atual.arg(2).arg(1).intValue();
		g2d.drawString("Position : ", 600, 120);
		g2d.drawString(ethanX.toString(), 670, 120);
		g2d.drawString(ethanY.toString(), 685, 120);
        switch(step_solution[n_iteration].get("O").intValue()){
        case 0:
            img6 = new ImageIcon("rightT.png");
            ethan = img6.getImage();
            break;
        case 90:
            img6 = new ImageIcon("back.png");
            ethan = img6.getImage();
            break;
        case 180:
            img6 = new ImageIcon("left.png");
            ethan = img6.getImage();
            break;
        case 270:
            img6 = new ImageIcon("front.png");
            ethan = img6.getImage();
            break;
        default: System.out.println("Posicao errada");
        }
   //     g2d.drawImage(ethan,desloc + 7, 12*desloc + 7,defaultSize-15,defaultSize-15,this);
		g2d.drawImage(ethan,desloc + (ethanX-1)*desloc + 7,/*desloc*/ + (12*desloc - (ethanY-1)*desloc) + 7,defaultSize-15,defaultSize-15,this);

	}
    void drawPercept(Graphics2D g2d){
    	int gap = 0;
    	Term nextTerm;
    	if(!sentidos_atuais.isAtom()){
    	nextTerm = sentidos_atuais.arg(1);
		g2d.drawString("Eu sinto : ",600, 120 );
			if(nextTerm.name() == "yes"){
				g2d.drawString("Fedor : ",670, 120 );
				gap+=20;
			}
			else{
				nextTerm = nextTerm.arg(2);
				if(nextTerm.arg(1).name() == "yes"){
					g2d.drawString("Brisa : ",670+gap, 120 );
					gap+=20;
				}
				else{
					nextTerm = nextTerm.arg(2);
					if(nextTerm.arg(1).name() == "yes"){
						g2d.drawString("Brilho : ",670+gap, 120 );
						gap+=20;
					}
					else{
						nextTerm = nextTerm.arg(2);
						if(nextTerm.arg(1).name() == "yes"){
							g2d.drawString("Pancada : ",670+gap, 120 );
							gap+=20;
						}
						else{
							nextTerm = nextTerm.arg(2);
							if(nextTerm.arg(1).name() == "yes"){
								g2d.drawString("Grito",670+gap, 120 );
								gap+=20;
							}
						}
					}
				}
			}
    	}
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
			repaint();
			 n_iteration++;
	}
	private void updateKnowledge() {
		if(n_iteration == step_solution.length){
			//termina o jogo
			try {
				Thread.sleep(1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		local_atual = step_solution[n_iteration].get("L");	
		sentidos_atuais = step_solution[n_iteration].get("Percept");
		
	}
	public static void initialize(){
	    Query q1 = new Query("consult", new Term[] {new Atom("wumpus12.pl")});
	    System.out.println("consult " + (q1.hasSolution() ? "succeeded" : "failed"));
	    Query q = new Query("schedule");
	    Map<String, Term>[] solution1 = q.allSolutions();
	    if(solution1 != null){
	    	System.out.println("nao deu merda no schedule");
	    }
	    Query q2 = new Query("is_situation(T,L,O,Percept,SG)");
	    step_solution = q2.allSolutions();
	    if(step_solution != null){
	    }
	}
	public static void printMapa() {
    	for(int i = 0; i < 12; i++){
    		for(int j = 0; j < 12;j++){
    			System.out.printf("%c",matrixMapa[i*12 + j]);
    		}
    		System.out.printf("\n");
    	}		
	}
}
