package functionblock.rendering;

import java.awt.Graphics;
import java.awt.Point;

import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.paths.PathDecorator;
import com.nomagic.magicdraw.uml.symbols.paths.PathElement;

public class DependencyRender extends PathDecorator {
    public void draw(Graphics g, PathElement pathelement)
    {
        prepareForLineDrawing(g, pathelement, false);        
        Point point = drawPathEnd(pathelement, g, pathelement.getSupplierDrawPoint(), pathelement.getNextPoint(pathelement.getSupplierPoint()), true, pathelement.getSupplier().getBounds(), pathelement.getPreferredArrowLength());
        Point point1 = drawPathEnd(pathelement, g, pathelement.getClientDrawPoint(), pathelement.getPreviousPoint(pathelement.getClientPoint()), false, pathelement.getClient().getBounds(), pathelement.getPreferredArrowLength());
        prepareForLineDrawing(g, pathelement, true);
        draw(g, point, point1, pathelement);
        drawContainer(g, pathelement);
    }

    public void draw(Graphics g, PresentationElement presentationelement)
    {
        if(presentationelement instanceof PathElement)
            draw(g, (PathElement)presentationelement);
    }
}
