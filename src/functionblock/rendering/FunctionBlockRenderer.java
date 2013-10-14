package functionblock.rendering;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.shapes.*;

public class FunctionBlockRenderer extends ShapeDecorator {

	@Override
	public void draw(Graphics g, PresentationElement presentationelement) {
		// TODO Auto-generated method stub
		
		Rectangle r = presentationelement.getNotCopyBounds();
		int x0 = r.x;
		int y0 = r.y;
		int xStep = r.width / 6;
		int yStep = r.height / 4;

		int xPoints[] = { x0, x0 + 6 * xStep, x0 + 6 * xStep, x0 + 5 * xStep,
				x0 + 5 * xStep, x0 + 6 * xStep, x0 + 6 * xStep, x0, x0,
				x0 + xStep, x0 + xStep, x0 };
		int yPoints[] = { y0, y0, y0 + yStep, y0 + yStep, y0 + 2 * yStep,
				y0 + 2 * yStep, y0 + 4 * yStep, y0 + 4 * yStep, y0 + 2 * yStep,
				y0 + 2 * yStep, y0 + yStep, y0 + yStep };
		g.drawPolygon(xPoints, yPoints, 12);
		
		for (PresentationElement pe : presentationelement.getPresentationElements()) {
			if (pe instanceof ClassHeaderView) {
				ClassHeaderView classHeaderView = (ClassHeaderView) pe;
				classHeaderView.getNameLabel().shapeSpecificDraw(g);
				classHeaderView.getStereotypeLabel().shapeSpecificDraw(g);
			} else {
				if (pe instanceof PortView) {
					pe.setVisible(true);
				}
				if (pe.isVisible()) {
					pe.draw(g);
				}
			}
		}

		presentationelement.paintAdornments(g, presentationelement);
	}

}
