package functionblock.rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.shapes.PortView;
import com.nomagic.magicdraw.uml.symbols.shapes.ShapeDecorator;
import com.nomagic.magicdraw.uml.symbols.shapes.StereotypesDisplayModeOwner;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

import static functionblock.plugin.FunctionBlockConstants.StereotypesConstants.*;

public class PortRenderer extends ShapeDecorator {
    
	@Override
	public void draw(Graphics g, PresentationElement presentationelement) {
		// TODO Auto-generated method stub
    	Element element = presentationelement.getActualElement();
    	if (!StereotypesHelper.getStereotypes(element).isEmpty()) {
       		if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(Application.getInstance().getProject(), EVENT_IN_PORT))) {
       			drawEventInPort(g, presentationelement);
       		} else if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(Application.getInstance().getProject(), EVENT_OUT_PORT))) {
       			drawEventOutPort(g, presentationelement);
       		} else if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(Application.getInstance().getProject(), DATA_IN_PORT))) {
       			drawDataInPort(g, presentationelement);
       		} else if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(Application.getInstance().getProject(), DATA_OUT_PORT))) {
       			drawDataOutPort(g, presentationelement);
       		}       		       		
       	} else {
       		presentationelement.shapeSpecificDraw(g);
       	}
        
        for (PresentationElement pe : presentationelement.getPresentationElements()) {
        	if (pe.isVisible()) {
        		pe.draw(g);  
        	}
        }    
        presentationelement.paintAdornments(g, presentationelement);
        
        ((PortView) presentationelement).getStereotypeLabelWrapper().setStereotypesDisplayMode(StereotypesDisplayModeOwner.STEREOTYPE_DISPLAY_MODE_TEXT_AND_ICON);        
    }

	public void drawEventInPort(Graphics g, PresentationElement presentationelement) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
				
        Rectangle FBrec = presentationelement.getParent().getBounds();
        Rectangle rec = presentationelement.getBounds();
        
        presentationelement.setLocation(FBrec.x - rec.width / 2, rec.y);
        if (out(rec.y, FBrec.y - rec.height / 2, FBrec.y + FBrec.height / 4 - rec.height / 2)) {
        	presentationelement.setLocation(FBrec.x - rec.width / 2, FBrec.y + FBrec.height / 8 - rec.height / 2);
        }
        
        rec = presentationelement.getBounds();        
        g.fillRect(rec.x, rec.y, rec.width, rec.height);        
		g.setColor(c);
	}
	
	public void drawEventOutPort(Graphics g, PresentationElement presentationelement) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
				
        Rectangle FBrec = presentationelement.getParent().getBounds();
        Rectangle rec = presentationelement.getBounds(); 
        
        presentationelement.setLocation(FBrec.x + FBrec.width - rec.width / 2, rec.y);
        if (out(rec.y, FBrec.y - rec.height / 2, FBrec.y + FBrec.height / 4 - rec.height / 2)) {
        	presentationelement.setLocation(FBrec.x + FBrec.width - rec.width / 2, FBrec.y + FBrec.height / 8 - rec.height / 2);
        }
        
        rec = presentationelement.getBounds();
        g.fillRect(rec.x, rec.y, rec.width, rec.height);     
		g.setColor(c);
	}
	
	public void drawDataInPort(Graphics g, PresentationElement presentationelement) {
		Color c = g.getColor();
		g.setColor(Color.RED);
				
        Rectangle FBrec = presentationelement.getParent().getBounds();
        Rectangle rec = presentationelement.getBounds(); 
        
        presentationelement.setLocation(FBrec.x - rec.width / 2, rec.y);
        if (out(rec.y, FBrec.y + FBrec.height / 2 - rec.height / 2, FBrec.y + FBrec.height - rec.height / 2)) {
        	presentationelement.setLocation(FBrec.x - rec.width / 2, FBrec.y + FBrec.height * 3 / 4 - rec.height / 2);
        }
        
        rec = presentationelement.getBounds();
        g.fillRect(rec.x, rec.y, rec.width, rec.height);        
		g.setColor(c);
	}
	
	public void drawDataOutPort(Graphics g, PresentationElement presentationelement) {
		Color c = g.getColor();
		g.setColor(Color.RED);
				
        Rectangle FBrec = presentationelement.getParent().getBounds();
        Rectangle rec = presentationelement.getBounds();         	
        
        presentationelement.setLocation(FBrec.x + FBrec.width - rec.width / 2, rec.y);
        if (out(rec.y, FBrec.y + FBrec.height / 2 - rec.height / 2, FBrec.y + FBrec.height - rec.height / 2)) {
        	presentationelement.setLocation(FBrec.x + FBrec.width - rec.width / 2, FBrec.y + FBrec.height * 3 / 4 - rec.height / 2);
        }
        
        rec = presentationelement.getBounds();
        g.fillRect(rec.x, rec.y, rec.width, rec.height);        
		g.setColor(c);		
	}
	
	private boolean out(double loc, double st, double ed) {
		return (loc < st || loc > ed);
	}
	
}
