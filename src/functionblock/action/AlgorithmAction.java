package functionblock.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.actions.DrawShapeDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Comment;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;

import functionblock.plugin.FunctionBlockConstants;

public class AlgorithmAction extends DrawShapeDiagramAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2679951760254166221L;
	public static String DRAW_ALGORITHM_ACTION = FunctionBlockConstants.ActionsConstants.ALGORITHM_DRAW_ACTION_ID;
	
	public AlgorithmAction() {
		super(DRAW_ALGORITHM_ACTION, FunctionBlockConstants.ActionsConstants.ALGORITHM_HUMAN_NAME, null);
		setLargeIcon(new ImageIconProxy(getClass(), FunctionBlockConstants.ActionsConstants.ALGORITHM_GIF_PATH, "")); 
	}

	@Override
	protected Element createElement() {
		// TODO Auto-generated method stub
		State algorithm = Application.getInstance().getProject().getElementsFactory().createStateInstance();		
		StereotypesHelper.addStereotypeByString(algorithm, FunctionBlockConstants.StereotypesConstants.ALGORITHM);		
		
		Comment eventOutput = Application.getInstance().getProject().getElementsFactory().createCommentInstance();
		StereotypesHelper.addStereotypeByString(eventOutput, FunctionBlockConstants.StereotypesConstants.EVENT_OUTPUT);
		eventOutput.setOwner(algorithm);
		
		return algorithm;
	}
	
	protected PresentationElement createPresentationElement() {		
		PresentationElement presentationElement = super.createPresentationElement();		
		return presentationElement;
		
	}
}
