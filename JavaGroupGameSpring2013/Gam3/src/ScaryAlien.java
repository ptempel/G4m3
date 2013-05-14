import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class ScaryAlien extends GameObject {
	
	
	


	Image mainImage;
	Image image45;
	Image image135;
	
	boolean pictureLoaded = false;
	static int MrRocheObjCount = 0;
	int whichMrRoche=0;

	public ScaryAlien(String typeName, int x, int y) {
		super(typeName, x, y);
		//System.out.println("Hi from the top of the constructor MrRocheObject");
		
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		//System.out.println("Hi the class loader C1 is good");
		InputStream input1 = ClassLoader.getSystemResourceAsStream("scaryAlienBlue.png");
		
		MrRocheObjCount++;
		whichMrRoche=MrRocheObjCount;
		
		try{
			
			mainImage = ImageIO.read(input1);
			
			
			objW = mainImage.getWidth(null);
			objH = mainImage.getHeight(null);
			pictureLoaded = true;
			
			//this.setBBoxExtras(0, 25, objW, (int)(objH/2)+5);
			this.setNewBBox(0, 25, objW, (int)(objH/2)+5);
			
			
		} catch(IOException e){
			System.out.println("We have a problem loading images in MrRoche Object");
			e.printStackTrace();
			
		}
		
	}
	
	public void drawObject(Graphics g){
		
		if(pictureLoaded){
			
			if(getAngle() >29.0 && getAngle() < 61.0){
				g.drawImage(image45, xLoc, yLoc, objW, objH, null);
			} else {
				if(getAngle() >119.0 && getAngle() < 151.0){
					g.drawImage(image135, xLoc, yLoc, objW, objH, null);
				} else {
					g.drawImage(mainImage, xLoc, yLoc, objW, objH, null);
				}
				
			}
			
			//This Draws the Bounding Box
			g.setColor(Color.RED);
			g.drawRect(xLoc+this.newBBoxX, yLoc+this.newBBoxY,this.newBBoxW, this.newBBoxH);
			
			g.setColor(Color.WHITE);
			//g.drawString(("Mr.Roche "+whichMrRoche),  xLoc -(int)(objW/4) , yLoc+(int)(objH/2));
			g.drawString(this.getObjIDString(),  xLoc  , yLoc+(int)(objH/2));
			
			//Draw the xLoc, yLoc
			g.setColor(Color.MAGENTA);
			g.fillOval(xLoc, yLoc, 5, 5);
			
		} else {
		g.setColor(objColor);
		g.draw3DRect(xLoc-(int)(objW/2), yLoc-(int)(objH/2), objW, objH, true);
		g.setColor(Color.RED);
		g.fillOval(xLoc-2, yLoc-2, 5, 5);
		
		}
	}
	
	public double getAngle(){
		
		//double radians =  Math.atan2(dy, dx);
		double radians =  Math.atan2(-dy,dx);
		double degrees = (radians * 180)/Math.PI;
		return degrees;
	}
	
	public void setCrazyDX(){
		double dxRate = .005;
		
		changeDX(dxRate);
		if(getDX() > 0){
			if(getDX() > 100){
				dxRate*=-1;
			}
		}
		
		if(getDX() < 0){
			if(getDX() < -100){
				dxRate*=-1;
			}
		}
		
	}
	
	
	//Special CheckBounds for white area of the Mr.Roche 
public void checkBounds(int panelWidth, int panelHeight){
		
		int rightFrame = 15;
		int bottomFrame = 30;
		int MrRochePicBottom = 25;
		
		
		//Check Left
		if(getDX() < 0){
			if(getXLoc() < 0){
				setXLoc(0);
				setDX(getDX()*-1);
			}
		}
		
		//Check right
		if(getDX() > 0){
			if((getXLoc()+getObjWidth()) > panelWidth){
				setXLoc(panelWidth-getObjWidth());
				setDX(getDX()*-1);
			}
		}
		
		//Check top
		if(getDY() < 0){
			if(getYLoc() < 0){
				setYLoc(0);
				setDY(getDY()*-1);
			}
		}
		
		//Check bottom
		if(getDY() > 0){
			if(getYLoc()+(int)(getObjHeight()-MrRochePicBottom) > panelHeight-bottomFrame){
				setYLoc(panelHeight-(getObjHeight()-MrRochePicBottom)-bottomFrame);
				setDY(getDY()*-1);
			}
		}
		
	
	}
	

	

}
