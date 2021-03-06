import java.awt.Color;
import java.awt.Graphics;


public class EthanObject extends GameObject {
	
	static int EthanObjCount = 0;
	int whichEthan = 0;

	public EthanObject(String typeName, int x, int y) {
		super(typeName, x, y);
		EthanObjCount++;
		whichEthan = EthanObjCount;
		
		
	}
	
	public void drawObject(Graphics g){
            g.setColor(Color.GREEN);
            g.fillOval(xLoc, yLoc, 30, 30);
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
