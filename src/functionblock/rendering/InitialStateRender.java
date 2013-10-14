package functionblock.rendering;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.shapes.ShapeDecorator;

public class InitialStateRender extends ShapeDecorator {

	@Override
	public void draw(Graphics g, PresentationElement presentationelement) {
		// TODO Auto-generated method stub
		Rectangle r = presentationelement.getNotCopyBounds();
		presentationelement.setBounds(r.x, r.y, r.height * 2, r.height);
		r = presentationelement.getBounds();
		
		g.drawRect(r.x, r.y, r.width, r.height);
		g.drawRect(r.x + r.width / 10, r.y + r.height / 5, r.width * 8 / 10, r.height * 3 / 5);
		
		presentationelement.paintAdornments(g, presentationelement);
	}

}
