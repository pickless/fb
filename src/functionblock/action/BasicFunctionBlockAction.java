package functionblock.action;

import javax.swing.JOptionPane;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.properties.PropertyID;
import com.nomagic.magicdraw.properties.PropertyPool;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.actions.DrawShapeDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.impl.ElementsFactory;

import functionblock.diagram.ECCDiagramDescriptor;
import functionblock.plugin.FunctionBlockConstants;
import functionblock.plugin.FunctionBlockHelper;

public class BasicFunctionBlockAction extends DrawShapeDiagramAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 278001534025412932L;
	public static String DRAW_BASIC_FUNCTION_BLOCK_ACTION = FunctionBlockConstants.ActionsConstants.BASIC_FUNCTION_BLOCK_DRAW_ACTION_ID;

	public BasicFunctionBlockAction() {
		super(DRAW_BASIC_FUNCTION_BLOCK_ACTION, FunctionBlockConstants.ActionsConstants.BASIC_FUNCTION_BLOCK_HUMAN_NAME, null);
		setLargeIcon(new ImageIconProxy(getClass(), FunctionBlockConstants.ActionsConstants.BASIC_FUNCTION_BLOCK_GIF_PATH, ""));
	}
	
	/**
	 * Creates model element
	 * 
	 * @return created model element
	 */
	protected Element createElement() {
		com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class clazz = Application.getInstance().getProject().getElementsFactory().createClassInstance();
		clazz.setActive(true);		

		StereotypesHelper.addStereotypeByString(clazz, FunctionBlockConstants.StereotypesConstants.BASIC_FUNCTION_BLOCK);
		addBasicPorts(clazz);
		addECC(clazz);
		
		return clazz;
	}

	/**
	 * Creates presentation element.
	 * 
	 * @return created presentation element
	 */
	protected PresentationElement createPresentationElement() {
		PresentationElement presentationElement = super.createPresentationElement();
        presentationElement.addProperty(PropertyPool.getBooleanProperty(PropertyID.SUPPRESS_CLASS_ATTRIBUTES, true,"ATTRIBUTES"));
        presentationElement.addProperty(PropertyPool.getBooleanProperty(PropertyID.SUPPRESS_CLASS_OPERATIONS, true, "OPERATIONS"));
		return presentationElement;
	}
	
	private void addECC(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class functionblock) {
		boolean sessionFlag = FunctionBlockHelper.createSession();
		
		try {
			StateMachine ecc = Application.getInstance().getProject().getElementsFactory().createStateMachineInstance();
			ecc.setOwner(functionblock);
			ecc.setName("ECC");
			ModelElementsManager.getInstance().createDiagram(ECCDiagramDescriptor.ECC_DIAGRAM, ecc);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "BasicFunctionBlockAction.addECC(Class) " + ex);
		}
		
		FunctionBlockHelper.closeSession(sessionFlag);
	}
	
	private void addBasicPorts(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class functionblock) {
		ElementsFactory elementsFactory = Application.getInstance().getProject().getElementsFactory();
		
		Port port1 = elementsFactory.createPortInstance();  
		Port port2 = elementsFactory.createPortInstance();				
		Port port3 = elementsFactory.createPortInstance();		
		Port port4 = elementsFactory.createPortInstance();
		
		port1.setName("Event_In");
		port2.setName("Event_Out");
		port3.setName("Data_In");
		port4.setName("Data_Out");
		
		port1.setOwner(functionblock);
		port2.setOwner(functionblock);
		port3.setOwner(functionblock);
		port4.setOwner(functionblock);
		
		StereotypesHelper.addStereotypeByString(port1, FunctionBlockConstants.StereotypesConstants.EVENT_IN_PORT);
		StereotypesHelper.addStereotypeByString(port2, FunctionBlockConstants.StereotypesConstants.EVENT_OUT_PORT);
		StereotypesHelper.addStereotypeByString(port3, FunctionBlockConstants.StereotypesConstants.DATA_IN_PORT);		
		StereotypesHelper.addStereotypeByString(port4, FunctionBlockConstants.StereotypesConstants.DATA_OUT_PORT);
	}
}
