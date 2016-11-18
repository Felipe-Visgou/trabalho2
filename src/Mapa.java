import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.jpl7.*;
import java.lang.System;

public class Mapa extends JPanel implements ActionListener {
	
	public static int[] matrixMapa;
	private Timer timer;
    private final int DELAY = 700;
    private static Map<String, Term>[] step_solution;
    private static Term local_atual;
    private static Term sentidos_atuais;
    private static Term score_atual;
    private static Term  orient_atual;
    private static Term  ammo_atual;
    private static Term  energia_atual;
    private static int wumpus_alive;
    private static Term Ouro1, Ouro2, Ouro3;
    private static int n_iteration = 0;
	private ArrayList<WannaBe> pk;
	private ArrayList<WannaBe> pu;
	private ArrayList<Enemy> ggengar;
	private ArrayList<Enemy> hhaunter;
	private ArrayList<Enemy> aalakazam;
	private ArrayList<Pit> vvortex;
	private Agent agent;
	
	public Mapa() throws IOException{
		matrixMapa = new int[12*12];
		pk = new ArrayList<WannaBe>();
		pu = new ArrayList<WannaBe>();
		ggengar = new ArrayList<Enemy>();
		hhaunter = new ArrayList<Enemy>();
		aalakazam = new ArrayList<Enemy>();
		vvortex = new ArrayList<Pit>();
		agent = new Agent();
    	FileReader inputStream = null;
    	int i,j;
        try {
            inputStream = new FileReader("instance2.txt");
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
	    timer = new Timer(DELAY, this);
	        timer.start();
        // Desenha a interface do mapa
	    initialize();
	    initializeMap();
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
        for(int i = 0; i < 20; i ++){
        	
        }
    	int n=0;
        for(WannaBe w:pk){
        	switch(n){
        	case 0:
        		if(w.in_game == 1)
        			g2d.drawImage(cyndaquil,desloc + w.x*desloc,desloc + w.y*desloc,defaultSize+20,defaultSize+20,this);
				n++;
				break;
        	case 1:
        		if(w.in_game == 1)
        			g2d.drawImage(totodile,desloc + w.x*desloc,desloc + w.y*desloc,defaultSize+20,defaultSize+20,this);
				n++;
				break;
			case 2:	
        		if(w.in_game == 1)
        			g2d.drawImage(chikorita,desloc + w.x*desloc,desloc + w.y*desloc,defaultSize+20,defaultSize+20,this);
				n++;
				break;
			default: System.out.println("Erro ao desenhar os pokemons");
        	}
        }
        for(WannaBe w: pu){
			g2d.drawImage(pokeball,desloc + w.x*desloc + 13,desloc + w.y*desloc + 13,defaultSize-22,defaultSize-22,this);
        }
        for(Enemy e: ggengar){
        	if(e.in_game == 1)
        		g2d.drawImage(gengar,desloc + e.x*desloc + 13,desloc + e.y*desloc + 13,defaultSize,defaultSize,this);
        }
        for(Enemy e: hhaunter){
			g2d.drawImage(haunter,desloc + e.x*desloc + 13,desloc + e.y*desloc + 13,defaultSize,defaultSize,this);
        }
        for(Enemy e: aalakazam){
			g2d.drawImage(alakazam,desloc + e.x*desloc + 13,desloc + e.y*desloc + 13,defaultSize,defaultSize,this);
        }
        for(Pit p: vvortex){
			g2d.drawImage(vortex,desloc + p.x*desloc + 13,desloc + p.y*desloc + 13,defaultSize-15,defaultSize-15,this);

        }
        updateKnowledge();
		g2d.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont(15.0f));
		g2d.drawString("Energy : ", 600, 40);
		g2d.drawString(agent.energy.toString(), 650, 40);
		g2d.drawString("Score : ", 600, 60);
		g2d.drawString(agent.score.toString(), 650, 60);
		g2d.drawString("Captured : ", 600, 80);
		g2d.drawString(agent.pokemonsCaptured.toString(), 670, 80);
		g2d.drawString("Ammo : ", 600, 100);
		g2d.drawString(agent.ammo.toString(), 670, 100);
	//	drawPercept(g2d);
		
        ImageIcon img6;
        ethan = null;
		g2d.drawString("Position : ", 600, 120);
		g2d.drawString(agent.x.toString(), 670, 120);
		g2d.drawString(agent.y.toString(), 685, 120);
        switch(agent.orientation){
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
		g2d.drawImage(ethan,desloc + (agent.x-1)*desloc + 7,/*desloc*/ + (12*desloc - (agent.y-1)*desloc) + 7,defaultSize-15,defaultSize-15,this);

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
		score_atual = step_solution[n_iteration].get("S");
		orient_atual =  step_solution[n_iteration].get("O");
		ammo_atual = step_solution[n_iteration].get("Am");
		//.get(0).in_game = step_solution[n_iteration].get("F1").intValue(); 
		wumpus_alive = step_solution[n_iteration].get("Wf").intValue();
		ggengar.get(0).in_game = wumpus_alive;
		Ouro1 = step_solution[n_iteration].get("Ouro1");
		Ouro2 = step_solution[n_iteration].get("Ouro2");
		Ouro3 = step_solution[n_iteration].get("Ouro3");
		for(WannaBe e: pk){
				if(((e.x+1) == Ouro1.arg(1).intValue()) && ((12- e.y) == Ouro1.arg(2).arg(1).intValue()))
					e.in_game = 0;
				if(((e.x+1) == Ouro2.arg(1).intValue()) && ((12- e.y) == Ouro2.arg(2).arg(1).intValue()))
					e.in_game = 0;
				if(((e.x+1) == Ouro3.arg(1).intValue()) && ((12-e.y) == Ouro3.arg(2).arg(1).intValue()))
					e.in_game = 0;
		}
		agent.updateAgent(score_atual.intValue(), 100, ammo_atual.intValue(),local_atual.arg(1).intValue(), local_atual.arg(2).arg(1).intValue(), orient_atual.intValue(),0);
	}
	public static void initialize(){
	    Query q1 = new Query("consult", new Term[] {new Atom("wumpus1234.pl")});
	    System.out.println("consult " + (q1.hasSolution() ? "succeeded" : "failed"));
	    Query q = new Query("schedule");
	    Map<String, Term>[] solution1 = q.allSolutions();
	    if(solution1 != null){
	    	System.out.println("great");
	    }
	    Query q2 = new Query("is_situation(T,L,O,Percept,SG,S,Am,Wf,Ouro1, Ouro2, Ouro3)");
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
	void initializeMap(){
		
        for(int i = 0 ;i < 12; i++){
        	for(int j = 0; j < 12;j++){
        		if(matrixMapa[j*12 + i] == '.') continue;
        		if(matrixMapa[j*12 + i] == 'O'){
        				pk.add(new WannaBe(i,j,1));
        		}
        		else{
        			if(matrixMapa[j*12 + i] == 'T'){
        				aalakazam.add(new Enemy(i,j,0));
        			}
        			else{
        				if(matrixMapa[j*12 + i] == 'D'){
        					ggengar.add(new Enemy(i,j,50));
        				}	
        				else{
        					if(matrixMapa[j*12 + i] == 'd'){
        						hhaunter.add(new Enemy(i,j,20));
        					}
        					else{
            					if(matrixMapa[j*12 + i] == 'U'){
            						pu.add(new WannaBe(i,j,2));
            					}
            					else{
            						if(matrixMapa[j*12 + i] == 'P'){
            							vvortex.add(new Pit(i,j));
            						}
            					}
        					}
        				}
        			}
        		}
        	}
        }
	}
}
