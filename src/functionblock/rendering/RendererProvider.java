package functionblock.rendering;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.uml.symbols.AbstractSymbolDecoratorProvider;
import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.SymbolDecorator;
import com.nomagic.magicdraw.uml.symbols.paths.DependencyView;
import com.nomagic.magicdraw.uml.symbols.paths.PathDecorator;
import com.nomagic.magicdraw.uml.symbols.shapes.CommentView;
import com.nomagic.magicdraw.uml.symbols.shapes.PortView;
import com.nomagic.magicdraw.uml.symbols.shapes.ShapeDecorator;
import com.nomagic.magicdraw.uml.symbols.shapes.StateView;
import com.nomagic.magicdraw.uml.symbols.shapes.HeaderShapeView;
import com.nomagic.magicdraw.uml.symbols.shapes.PartView;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

import functionblock.diagram.ECCDiagramDescriptor;
import functionblock.diagram.FunctionBlockDiagramDescriptor;

import static functionblock.plugin.FunctionBlockLogger.*;

import static functionblock.plugin.FunctionBlockConstants.StereotypesConstants.*;

public class RendererProvider extends AbstractSymbolDecoratorProvider {
    private StringBuilder msg;

	public SymbolDecorator getSymbolDecorator(PresentationElement presentationElement) {
		Object obj = super.getSymbolDecorator(presentationElement);
		if (obj != null) {
			return ((SymbolDecorator) (obj));
		}
		
		Project project = Application.getInstance().getProject();
		Element element = presentationElement.getActualElement();

        if (presentationElement instanceof PartView) {
            obj = partRenderer;
            return ((SymbolDecorator) (obj));
        }

        if (presentationElement instanceof HeaderShapeView/*ClassView*/) {

           	if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(project, BASIC_FUNCTION_BLOCK)) || 
           			StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(project, COMPOSITE_FUNCTION_BLOCK))) {
           		obj = functionBlockRender;
           		addToCash(presentationElement, ((SymbolDecorator) (obj)));
           	}
        }
                
        if (presentationElement instanceof DependencyView) {
        	if (presentationElement.getDiagramPresentationElement().getHumanType().equals(ECCDiagramDescriptor.ECC_DIAGRAM) ||
        			presentationElement.getDiagramPresentationElement().getHumanType().equals(FunctionBlockDiagramDescriptor.FUNCTION_BLOCK_DIAGRAM) ||
        				StereotypesHelper.getStereotypes(presentationElement.getDiagramPresentationElement().getActualElement().getOwner()).contains(StereotypesHelper.getStereotype(project, COMPOSITE_FUNCTION_BLOCK))) {
        		obj = dependencyRender;
        		addToCash(presentationElement, ((SymbolDecorator) (obj)));
        	}
        }
        
        if (presentationElement instanceof PortView) {
        	obj = portRender;
        	addToCash(presentationElement, ((SymbolDecorator) (obj)));
        }
        
        if (presentationElement instanceof StateView) {
        	if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(project, ALGORITHM))) {
           		obj = algorithmRender;
           		addToCash(presentationElement, ((SymbolDecorator) (obj)));                      	
        	} else if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(project, ECC_INITIAL_STATE))) {
        		obj = initialStateRender;
        		addToCash(presentationElement, ((SymbolDecorator) (obj)));
        	}
        }
        
        if (presentationElement instanceof CommentView) {
      		if (StereotypesHelper.getStereotypes(element).contains(StereotypesHelper.getStereotype(project, EVENT_OUTPUT))) {
       			obj = eventOutputRender;
       			addToCash(presentationElement, ((SymbolDecorator) (obj)));
       		}
        }
        return ((SymbolDecorator) (obj));
	}

	private final ShapeDecorator functionBlockRender = new FunctionBlockRenderer();
    private final ShapeDecorator partRenderer = new PartRenderer();
	private final ShapeDecorator portRender = new PortRenderer();
	private final ShapeDecorator initialStateRender = new InitialStateRender();
	private final ShapeDecorator algorithmRender = new AlgorithmRender();
	private final ShapeDecorator eventOutputRender = new EventOutputRender();
	private final PathDecorator dependencyRender = new DependencyRender();
}
