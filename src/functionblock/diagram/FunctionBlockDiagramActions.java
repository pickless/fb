package functionblock.diagram;

import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsCreator;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.ActionsProvider;
import com.nomagic.magicdraw.actions.MDActionsManager;

import functionblock.action.BasicFunctionBlockAction;
import functionblock.action.CompositeFunctionBlockAction;
import functionblock.action.DataInPortAction;
import functionblock.action.DataOutPortAction;
import functionblock.action.EventInPortAction;
import functionblock.action.EventOutPortAction;

public class FunctionBlockDiagramActions {
	public static final MDActionsManager ACTIONS = new MDActionsManager(null);
	static{
		ActionsCategory category = new ActionsCategory("", "");
		ACTIONS.addCategory(category);

		ActionsCreator creator = ActionsProvider.getInstance().getCreator();		
		creator.createCommonDiagramsActions(category);

		category.addAction(new BasicFunctionBlockAction());
		category.addAction(new CompositeFunctionBlockAction());
		
		ActionsManager compositeDiagramActions = (ActionsManager) creator.createCompositeStructureDiagramActions().clone();
		category.addAction(compositeDiagramActions.getActionFor(ActionsID.ADD_CONNECTOR));
		ActionsManager commonDiagramActions = (ActionsManager) creator.createAnyDiagramActions();		
		category.addAction(commonDiagramActions.getActionFor(ActionsID.ADD_DEPENDENCY));
		
		category.addAction(new EventInPortAction());
		category.addAction(new EventOutPortAction());
		category.addAction(new DataInPortAction());
		category.addAction(new DataOutPortAction());		
	}
}
