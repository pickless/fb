package functionblock.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.actions.DrawShapeDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;

import functionblock.plugin.FunctionBlockConstants;

public class ECCInitialStateAction extends DrawShapeDiagramAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4910963309621012089L;
	
	public static String DRAW_ECC_INITIAL_STATE_ACTION = FunctionBlockConstants.ActionsConstants.ECC_INITIAL_STATE_DRAW_ACTION_ID;
	public static String SIMPLE_NAME = FunctionBlockConstants.ActionsConstants.ECC_INITIAL_STATE_HUMAN_NAME;

	public ECCInitialStateAction() {
		super(DRAW_ECC_INITIAL_STATE_ACTION, SIMPLE_NAME, null);
		setLargeIcon(new ImageIconProxy(getClass(), FunctionBlockConstants.ActionsConstants.ECC_INITIAL_STATE_GIF_PATH, "")); 
	}

	protected Element createElement() {
		State state = Application.getInstance().getProject().getElementsFactory().createStateInstance();
		StereotypesHelper.addStereotypeByString(state, FunctionBlockConstants.StereotypesConstants.ECC_INITIAL_STATE);
		return state;
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
}
