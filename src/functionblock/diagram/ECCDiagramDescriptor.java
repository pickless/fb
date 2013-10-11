package functionblock.diagram;

import java.net.URL;

import javax.swing.ImageIcon;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.DiagramContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsManager;
import com.nomagic.magicdraw.ui.ImageIconProxy;
import com.nomagic.magicdraw.ui.ResizableIconHelper;
import com.nomagic.magicdraw.ui.VectorImageIconControler;
import com.nomagic.magicdraw.ui.actions.StateDiagramContextAMConfigurator;
import com.nomagic.magicdraw.ui.actions.StateDiagramShortcutsConfigurator;
import com.nomagic.magicdraw.uml.DiagramDescriptor;
import com.nomagic.magicdraw.uml.DiagramType;
import com.nomagic.ui.ResizableIcon;
import static functionblock.plugin.FunctionBlockConstants.DiagramsConstants.*;

public class ECCDiagramDescriptor extends DiagramDescriptor {
	public static final String ECC_DIAGRAM = ECC_DIAGRAM_NAME;

	@Override
	public MDActionsManager getDiagramActions() {
		// TODO Auto-generated method stub
		// returns manager of actions used in the diagram.
		return ECCDiagramActions.ACTIONS;
	}

	@Override
	public DiagramContextAMConfigurator getDiagramContextConfigurator() {
		// TODO Auto-generated method stub
		// returns action manager configurator which configures	described diagram context menu actions(see Chapter Chapter 6, "Adding New Functionality.").
		return new StateDiagramContextAMConfigurator();
	}

	@Override
	public AMConfigurator getDiagramShortcutsConfigurator() {
		// TODO Auto-generated method stub
		// returns action manager configurator which configures	described diagram shortcuts (see Chapter Chapter 6, "Adding New Functionality.").
		return new StateDiagramShortcutsConfigurator();
	}

	@Override
	public AMConfigurator getDiagramToolbarConfigurator() {
		// TODO Auto-generated method stub
		// returns action manager configurator which configures	described diagram toolbar (see Chapter Chapter 6, "Adding New Functionality.").
		return new ECCDiagramToolbarConfigurator(getSuperType());
	}

	@Override
	public String getDiagramTypeId() {
		// TODO Auto-generated method stub
		return ECC_DIAGRAM;
	}

	@Override
	public ImageIcon getLargeIcon() {
		// TODO Auto-generated method stub
		// returns a large icon for this type of the diagram (see Chapter Chapter 6, "Adding New Functionality.").
		
		//need edit!!!!!!
		return new ImageIconProxy(new VectorImageIconControler(getClass(), ECC_DIAGRAM_LARGE_ICON_PATH, 16, VectorImageIconControler.SVG));
	}

	@Override
	public String getPluralDiagramTypeHumanName() {
		// TODO Auto-generated method stub
		return ECC_DIAGRAM_PLURAL_HUMAN_NAME;
	}

	@Override
	public ResizableIcon getSVGIcon() {
		// TODO Auto-generated method stub
		return ResizableIconHelper.createSVGIcon(getSVGIconURL());
	}
	
	private URL getSVGIconURL()
	{
		//need edit!!!!!
		return getClass().getResource(ECC_DIAGRAM_SVG_ICON_URL);
	}
	
	@Override
	public String getSingularDiagramTypeHumanName() {
		// TODO Auto-generated method stub
		return ECC_DIAGRAM_HUMAN_NAME;
	}

	@Override
	public URL getSmallIconURL() {
		// TODO Auto-generated method stub
		// returns a small icon URL for this type of the diagram (see Chapter Chapter 6, "Adding New Functionality.").
		return getSVGIconURL();
	}

	@Override
	public String getSuperType() {
		// TODO Auto-generated method stub
		return DiagramType.UML_STATECHART_DIAGRAM;
	}

	@Override
	public boolean isCreatable() {
		// TODO Auto-generated method stub
		return true;
	}

    public ActionsManager getSmartManipulatorsActions(boolean flag)
    {
//        return new ActionsManager(null);
    	return ECCDiagramActions.ACTIONS;
    }

    public ActionsManager getTargetsManipulatorsActions(boolean flag)
    {
    	return ECCDiagramActions.ACTIONS;
//        return new ActionsManager(null);
    }
}
