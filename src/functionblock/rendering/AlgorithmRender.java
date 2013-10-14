package functionblock.rendering;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.shapes.ShapeDecorator;

public class AlgorithmRender extends ShapeDecorator {

	@Override
	public void draw(Graphics g, PresentationElement presentationelement) {
		// TODO Auto-generated method stub
		Rectangle r = presentationelement.getNotCopyBounds();
		g.drawRect(r.x, r.y, r.width, r.height);
		for (PresentationElement pe : presentationelement.getPresentationElements()) {
			if (pe.isVisible()) {
				pe.draw(g);
			}			
		}		
		presentationelement.paintAdornments(g, presentationelement);
	}

}
