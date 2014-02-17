package functionblock.rendering;

import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.shapes.PartView;
import com.nomagic.magicdraw.uml.symbols.shapes.ShapeDecorator;

import java.awt.*;

/**
 * Created by X on 14-2-17.
 */
public class PartRenderer extends ShapeDecorator {
    @Override
    public void draw(Graphics graphics, PresentationElement presentationElement) {
        PartView partView = (PartView) presentationElement;

        Rectangle r = presentationElement.getBounds();
        int x0 = r.x;
        int y0 = r.y;
        int xStep = r.width / 6;
        int yStep = r.height / 4;

        int xPoints[] = { x0, x0 + 6 * xStep, x0 + 6 * xStep, x0 + 9 * xStep / 2,
                x0 + 9 * xStep / 2, x0 + 6 * xStep, x0 + 6 * xStep, x0, x0,
                x0 + 3 * xStep / 2, x0 + 3 * xStep / 2, x0 };
        int yPoints[] = { y0, y0, y0 + yStep, y0 + yStep, y0 + 2 * yStep,
                y0 + 2 * yStep, y0 + 4 * yStep, y0 + 4 * yStep, y0 + 2 * yStep,
                y0 + 2 * yStep, y0 + yStep, y0 + yStep };
        graphics.drawPolygon(xPoints, yPoints, 12);
    }
}
