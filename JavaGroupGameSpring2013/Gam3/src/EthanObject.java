import java.awt.Color;
import java.awt.Graphics;


public class EthanObject extends GameObject {
	
	static int EthanObjCount = 0;
	int whichEthan = 0;
	int diameter = 30;

	public EthanObject(String typeName, int x, int y) {
		super(typeName, x, y);
		EthanObjCount++;
		whichEthan = EthanObjCount;
		// MrRoche you have to set this so the object will bounce and collide
		objW = diameter;
		objH = diameter;
		this.setNewBBox(0, 0, objW, objH);
	}
	
	public void drawObject(Graphics g){
            g.setColor(Color.GREEN);
            g.fillOval(xLoc, yLoc, diameter, diameter);
            
            //by Mr. Roche to test xLoc, yLoc
            
            //Draw the bounding box
			g.setColor(Color.RED);
			g.drawRect(xLoc+this.newBBoxX, yLoc+this.newBBoxY,this.newBBoxW, this.newBBoxH);

			//Draw the xLoc, yLoc
			g.setColor(Color.MAGENTA);
			g.fillOval(xLoc, yLoc, 5, 5);
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
}
