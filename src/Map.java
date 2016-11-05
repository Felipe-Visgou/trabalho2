import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel {

	public static int[] matrixMapa;
	public Map() throws IOException{
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
        // Desenha a interface do mapa
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
        img1 = new ImageIcon("back.png");
        ethan = img1.getImage();
        g2d.drawImage(ethan,desloc + 7, 12*desloc + 7,defaultSize-15,defaultSize-15,this);
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
        
    /*    switch(hood.getPos()){
        case "front":
            img6 = new ImageIcon("front.png");
            chapeu = img6.getImage();
            break;
        case "left":
            img6 = new ImageIcon("left.png");
            chapeu = img6.getImage();
            break;
        case "right":
            img6 = new ImageIcon("right.png");
            chapeu = img6.getImage();
            break;
        case "back":
            img6 = new ImageIcon("back.png");
            chapeu = img6.getImage();
            break;
        default: System.out.println("Posicao errada");
        }
        g2d.drawImage(chapeu, hood.getX()*18, hood.getY()*18,18,18,this);*/
  
	}
    static public void printMap(){
    	for(int i = 0; i < 12; i++){
    		for(int j = 0; j < 12;j++){
    			System.out.printf("%c",matrixMapa[i*12 + j]);
    		}
    		System.out.printf("\n");
    	}
    }
}
