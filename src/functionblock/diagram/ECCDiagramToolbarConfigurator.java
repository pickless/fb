package functionblock.diagram;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.DiagramInnerToolbarConfiguration;
import com.nomagic.magicdraw.actions.MDActionsManager;
import com.nomagic.magicdraw.ui.actions.BaseDiagramToolbarConfigurator;

import functionblock.action.AlgorithmAction;
import functionblock.action.ECCInitialStateAction;
import functionblock.action.ECCStateAction;
import functionblock.action.ECCTransitionAction;
import static functionblock.plugin.FunctionBlockConstants.DiagramsConstants.*;


public class ECCDiagramToolbarConfigurator extends BaseDiagramToolbarConfigurator {

	private String superType;
	
	public ECCDiagramToolbarConfigurator(String superType)
	{
		this.superType = superType;
	}
	
	@Override
	public void configure(ActionsManager manager) {
		// TODO Auto-generated method stub
		MDActionsManager actions = ECCDiagramActions.ACTIONS;
		manager.addCategory(createSelectionStickyToolbar(actions, superType));
		manager.addCategory(createCommonToolbarConfiguration(actions, superType));

		DiagramInnerToolbarConfiguration category= new DiagramInnerToolbarConfiguration(ECC_DIAGRAM_TOOLBAR_ID, null, ECC_DIAGRAM_TOOLBAR_HUMAN_NAME, true);
		manager.addCategory(category);

		category.addAction(actions.getActionFor(ECCInitialStateAction.DRAW_ECC_INITIAL_STATE_ACTION));		
		category.addAction(actions.getActionFor(ECCStateAction.DRAW_ECC_STATE_ACTION));
		category.addAction(actions.getActionFor(ECCTransitionAction.DRAW_ECC_TRANSITION_ACTION));
		category.addAction(actions.getActionFor(AlgorithmAction.DRAW_ALGORITHM_ACTION));
		category.addAction(actions.getActionFor(ActionsID.ADD_DEPENDENCY));
	}
}
