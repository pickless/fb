package functionblock.diagram;

import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsCreator;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.ActionsProvider;
import com.nomagic.magicdraw.actions.MDActionsManager;

import functionblock.action.AlgorithmAction;
import functionblock.action.ECCInitialStateAction;
import functionblock.action.ECCStateAction;
import functionblock.action.ECCTransitionAction;

public class ECCDiagramActions {
	public static final MDActionsManager ACTIONS = new MDActionsManager(null);
	static{
		ActionsCategory category = new ActionsCategory("", "");
		ACTIONS.addCategory(category);

		ActionsCreator creator = ActionsProvider.getInstance().getCreator();	
		creator.createCommonDiagramsActions(category);
		
		category.addAction(new ECCInitialStateAction());
		category.addAction(new ECCStateAction());
		category.addAction(new ECCTransitionAction());
		category.addAction(new AlgorithmAction());
		
		ActionsManager commonDiagramActions = (ActionsManager) creator.createAnyDiagramActions().clone();
		category.addAction(commonDiagramActions.getActionFor(ActionsID.ADD_DEPENDENCY));
	}
}
