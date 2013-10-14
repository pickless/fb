package functionblock.action;

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import functionblock.plugin.FunctionBlockConstants;

public class DataOutPortAction extends DataPortAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6186481508763014024L;
	
	public static String DRAW_DATA_OUT_PORT_ACTION = FunctionBlockConstants.ActionsConstants.DATA_OUT_PORT_DRAW_ACTION_ID;
	public static String SIMPLE_NAME = FunctionBlockConstants.ActionsConstants.DATA_OUT_PORT_HUMAN_NAME;

	public DataOutPortAction() {
		super(DRAW_DATA_OUT_PORT_ACTION, SIMPLE_NAME);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyStereotype(Port port) {
		// TODO Auto-generated method stub
		StereotypesHelper.addStereotypeByString(port, FunctionBlockConstants.StereotypesConstants.DATA_OUT_PORT);
	}

}
