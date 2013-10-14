package functionblock.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.actions.DrawShapeDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import functionblock.plugin.FunctionBlockConstants;

public abstract class EventPortAction extends DrawShapeDiagramAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1699794413716579356L;
	/**
	 * 
	 */
	public EventPortAction(String drawEventPortAction, String simpleName) {
		super(drawEventPortAction, simpleName, null);
		setLargeIcon(new ImageIconProxy(getClass(), FunctionBlockConstants.ActionsConstants.EVENT_PORT_GIF_PATH, ""));
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
