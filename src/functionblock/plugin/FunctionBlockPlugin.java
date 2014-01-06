package functionblock.plugin;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;
import com.nomagic.magicdraw.uml.symbols.SymbolRendererManager;

import functionblock.diagram.ECCDiagramDescriptor;
import functionblock.diagram.FunctionBlockDiagramDescriptor;
import functionblock.rendering.RendererProvider;

public class FunctionBlockPlugin extends Plugin
{
	
	/**
	 * Initializing the plugin.
	 */
	public void init()
	{
        FunctionBlockLogger.regLogger();
		SymbolRendererManager.getManager().addProvider(new RendererProvider());
		Application.getInstance().addNewDiagramType(new FunctionBlockDiagramDescriptor());
		Application.getInstance().addNewDiagramType(new ECCDiagramDescriptor());
		FunctionBlockHelper.createStereotypes();
	}
	
    /**
	 * Return true always, because this plugin does not have any close specific actions.
	 */
	public boolean close()
	{
		return true;
	}

	/**
	 * @see Plugin#isSupported()
	 */
	public boolean isSupported()
	{
		return true;
	}

}
