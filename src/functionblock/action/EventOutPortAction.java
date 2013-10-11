package functionblock.action;

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import functionblock.plugin.FunctionBlockConstants;

public class EventOutPortAction extends EventPortAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2900036560417199709L;

	public static String DRAW_EVENT_OUT_PORT_ACTION = FunctionBlockConstants.ActionsConstants.EVENT_OUT_PORT_DRAW_ACTION_ID;
	public static String SIMPLE_NAME = FunctionBlockConstants.ActionsConstants.EVENT_OUT_PORT_HUMAN_NAME;
	
	public EventOutPortAction() {
		super(DRAW_EVENT_OUT_PORT_ACTION, SIMPLE_NAME);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyStereotype(Port port) {
		// TODO Auto-generated method stub
		StereotypesHelper.addStereotypeByString(port, FunctionBlockConstants.StereotypesConstants.EVENT_OUT_PORT);
	}

}
