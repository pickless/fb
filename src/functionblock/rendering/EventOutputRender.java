package functionblock.rendering;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.shapes.CommentView;
import com.nomagic.magicdraw.uml.symbols.shapes.ShapeDecorator;
import com.nomagic.magicdraw.uml.symbols.shapes.StateView;
import com.nomagic.magicdraw.uml.symbols.shapes.TextAreaView;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

public class EventOutputRender extends ShapeDecorator {

	@Override
	public void draw(Graphics g, PresentationElement presentationelement) {
		DiagramPresentationElement diagramPresentationElement = presentationelement.getDiagramPresentationElement();
		
		StateView algorithm = null;
		Element element = presentationelement.getActualElement();
		for (PresentationElement pe : diagramPresentationElement.getPresentationElements()) {
			if (pe.getActualElement().getOwnedElement().contains(element)) {
				algorithm = (StateView) pe;
				break;
			}
		}

		handleStereotypeLabel(algorithm, (CommentView) presentationelement);
		handleBounds(algorithm, (CommentView) presentationelement);
		
		Rectangle r = presentationelement.getBounds();		
		g.drawRect(r.x, r.y, r.width, r.height);		
		
		for (PresentationElement pe : presentationelement.getPresentationElements()) {
			if (pe.isVisible()) {
				if (pe instanceof TextAreaView) {
				} else {
					pe.draw(g);
				}
			}
		}		
				
		presentationelement.paintAdornments(g, presentationelement);
	}
	
	private void handleStereotypeLabel(StateView algorithm, CommentView eventOutput) {
		TextAreaView algStereo = algorithm.getStereotypeLabel();		
		TextAreaView cmtStereo = eventOutput.getStereotypeLabel();
		Rectangle r = algStereo.getBounds();
		cmtStereo.setBounds(cmtStereo.getBounds().x, r.y, r.width, r.height);
			
		cmtStereo.setMinimumSize(algStereo.getMinimumSize().width, algStereo.getMinimumSize().height);
		cmtStereo.setPreferredSize(algStereo.getPreferredSize().width, algStereo.getPreferredSize().height);
	}
	
	private void handleBounds(StateView algorithm, CommentView eventOutput) {
		Rectangle r = algorithm.getBounds();
		eventOutput.setBounds(r.x + r.width, r.y, r.width, r.height);
		
		eventOutput.setMinimumSize(algorithm.getMinimumSize().width, algorithm.getMinimumSize().height);
		eventOutput.setPreferredSize(algorithm.getPreferredSize().width, algorithm.getPreferredSize().height);		
	}
}
