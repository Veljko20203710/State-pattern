/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;


/**
 *
 * @author Veljko
 */
public class Line {
    
    private final Komponenta komponenta1;
    private final Komponenta komponenta2;
    
    public Line(Komponenta komponenta1, Komponenta komponenta2) {
        this.komponenta1=komponenta1;
        this.komponenta2=komponenta2;
    }
    
    public void paintLine(Graphics g) {
              if(komponenta2.LocationX()>komponenta1.LocationX()) {
                  g.drawLine(komponenta2.LocationX()-100, komponenta2.LocationY(),komponenta1.LocationX(), komponenta1.LocationY());
                  
                  int xPoints[] = new int[]{komponenta1.LocationX(),komponenta1.LocationX()+8,komponenta1.LocationX()+8};
                  int yPoints[] = new int[]{komponenta1.LocationY(),komponenta1.LocationY()+8,komponenta1.LocationY()-8};
                  g.fillPolygon(xPoints, yPoints, 3);
              }
              else {
                  g.drawLine(komponenta1.LocationX()-100, komponenta1.LocationY(), komponenta2.LocationX(), komponenta2.LocationY());
                  
                  int xPoints[] = new int[]{komponenta1.LocationX()-100,komponenta1.LocationX()-100-8,komponenta1.LocationX()-100-8};
                  int yPoints[] = new int[]{komponenta1.LocationY(),komponenta1.LocationY()+8,komponenta1.LocationY()-8};
                  g.fillPolygon(xPoints, yPoints, 3);
              }
        }
    
      public void paintFinalComponentLine(Graphics g) {     
          g.drawLine(komponenta2.LocationX(), komponenta2.LocationY(), komponenta1.LocationX(), komponenta1.LocationY());

          int xPoints[] = new int[]{komponenta1.LocationX(),komponenta1.LocationX()-8,komponenta1.LocationX()+8};
          int yPoints[] = new int[]{komponenta1.LocationY(),komponenta1.LocationY()-8,komponenta1.LocationY()-8};
          g.fillPolygon(xPoints, yPoints, 3);
      } 
    }
    

