package functionblock.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.actions.DrawPathDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;

import functionblock.plugin.FunctionBlockConstants;

public class ECCTransitionAction extends DrawPathDiagramAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700073613433383076L;
	public static String DRAW_ECC_TRANSITION_ACTION = FunctionBlockConstants.ActionsConstants.ECC_TRANSITION_DRAW_ACTION_ID;
	public static String SIMPLE_NAME = FunctionBlockConstants.ActionsConstants.ECC_TRANSITION_HUMAN_NAME;

	public ECCTransitionAction() {
		super(DRAW_ECC_TRANSITION_ACTION, SIMPLE_NAME, null);
		setLargeIcon(new ImageIconProxy(getClass(), FunctionBlockConstants.ActionsConstants.ECC_TRANSITION_GIF_PATH, ""));
	}

	protected Element createElement() {
		Transition transition = Application.getInstance().getProject().getElementsFactory().createTransitionInstance();				
		StereotypesHelper.addStereotypeByString(transition, FunctionBlockConstants.StereotypesConstants.ECC_TRANSITION);		
		return transition;
	}

	/**
	 * Creates presentation element.
	 * 
	 * @return created presentation element
	 */
	protected PresentationElement createPresentationElement() {
		PresentationElement presentationElement = super.createPathElement();
		return presentationElement;
	}
}
