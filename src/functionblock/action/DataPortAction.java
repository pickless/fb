package functionblock.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.actions.DrawShapeDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import functionblock.plugin.FunctionBlockConstants;

public abstract class DataPortAction extends DrawShapeDiagramAction {

/**
	 * 
	 */
	private static final long serialVersionUID = -6486208574560556379L;
	
	public DataPortAction(String drawDataPortAction, String simpleName) {
		super(drawDataPortAction, simpleName, null);
		setLargeIcon(new ImageIconProxy(getClass(), FunctionBlockConstants.ActionsConstants.DATA_PORT_GIF_PATH, ""));		
	}
	
	 
	/**
	 * Creates model element
	 * 
	 * @return created model element
	 */
	protected Element createElement() {
		com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port port = Application.getInstance().getProject().getElementsFactory().createPortInstance();
		applyStereotype(port);
		return port;
	}

	/**
	 * Creates presentation element.
	 * 
	 * @return created presentation element
	 */
	protected PresentationElement createPresentationElement() {
		PresentationElement presentationElement = super.createPresentationElement();		
		return presentationElement;
	}
	
	public abstract void applyStereotype(Port port);
}
