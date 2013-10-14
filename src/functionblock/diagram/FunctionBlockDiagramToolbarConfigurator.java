package functionblock.diagram;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.DiagramInnerToolbarConfiguration;
import com.nomagic.magicdraw.actions.MDActionsManager;
import com.nomagic.magicdraw.ui.actions.BaseDiagramToolbarConfigurator;

import functionblock.action.BasicFunctionBlockAction;
import functionblock.action.CompositeFunctionBlockAction;
import functionblock.action.DataInPortAction;
import functionblock.action.DataOutPortAction;
import functionblock.action.EventInPortAction;
import functionblock.action.EventOutPortAction;

import static functionblock.plugin.FunctionBlockConstants.DiagramsConstants.*;

public class FunctionBlockDiagramToolbarConfigurator extends BaseDiagramToolbarConfigurator {

	private String superType;
	
	public FunctionBlockDiagramToolbarConfigurator(String superType)
	{
		this.superType = superType;
	}
	
	@Override
	public void configure(ActionsManager manager) {
		// TODO Auto-generated method stub
		MDActionsManager actions = FunctionBlockDiagramActions.ACTIONS;
		manager.addCategory(createSelectionStickyToolbar(actions, superType));
		manager.addCategory(createCommonToolbarConfiguration(actions, superType));

		DiagramInnerToolbarConfiguration category= new DiagramInnerToolbarConfiguration(FUNCTION_BLOCK_DIAGRAM_TOOLBAR_ID, null, FUNCTION_BLOCK_DIAGRAM_TOOLBAR_HUMAN_NAME, true);
		manager.addCategory(category);

		category.addAction(actions.getActionFor(BasicFunctionBlockAction.DRAW_BASIC_FUNCTION_BLOCK_ACTION));
		category.addAction(actions.getActionFor(CompositeFunctionBlockAction.DRAW_COMPOSITE_FUNCTION_BLOCK_ACTION));
		
		category.addAction(actions.getActionFor(ActionsID.ADD_CONNECTOR));
		category.addAction(actions.getActionFor(ActionsID.ADD_DEPENDENCY));
		
		category.addAction(actions.getActionFor(EventInPortAction.DRAW_EVENT_IN_PORT_ACTION));
		category.addAction(actions.getActionFor(EventOutPortAction.DRAW_EVENT_OUT_PORT_ACTION));
		category.addAction(actions.getActionFor(DataInPortAction.DRAW_DATA_IN_PORT_ACTION));
		category.addAction(actions.getActionFor(DataOutPortAction.DRAW_DATA_OUT_PORT_ACTION));		
	}
}
