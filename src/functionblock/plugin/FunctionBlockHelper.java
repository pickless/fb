package functionblock.plugin;

import java.util.Arrays;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectEventListener;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Profile;

import static functionblock.plugin.FunctionBlockConstants.StereotypesConstants.*;

public final class FunctionBlockHelper {
	
	public static boolean createSession() {
		if (!SessionManager.getInstance().isSessionCreated()) {
			SessionManager.getInstance().createSession("Create Stereotypes");
			return true;
		} else {
			return false;
		}
	}
	
	public static void closeSession(boolean isCreatedInHere) {
		if (isCreatedInHere) {
			SessionManager.getInstance().closeSession();
		}
	}		
	
	public static void createStereotypes() {
		Application.getInstance().addProjectEventListener(new ProjectEventListener() {
			public void projectActivated(Project project) {}
			public void projectClosed(Project project) {}
			public void projectDeActivated(Project project) {}
			public void projectReplaced(Project project, Project project1) {}
			public void projectSaved(Project project, boolean flag) {}			

			public void projectOpened(Project project) {
				Boolean sessionFlag = createSession();												
				
				if (StereotypesHelper.getProfile(project, FUNCTION_BLOCK_PROFILE) == null) {
					Profile profile = project.getElementsFactory().createProfileInstance();
					profile.setName(FUNCTION_BLOCK_PROFILE);
					
					try {
						ModelElementsManager.getInstance().addElement(profile, project.getModel());
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
				Profile profile = StereotypesHelper.getProfile(project, FUNCTION_BLOCK_PROFILE);

                if (StereotypesHelper.getStereotype(project, FUNCTION_BLOCK_DIAGRAM) == null) {
                    StereotypesHelper.createStereotype(profile, FUNCTION_BLOCK_DIAGRAM, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Diagram")));
                }

                if (StereotypesHelper.getStereotype(project, ECC_DIAGRAM) == null) {
                    StereotypesHelper.createStereotype(profile, ECC_DIAGRAM, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Diagram")));
                }

                if (StereotypesHelper.getStereotype(project, SIFB_SEQUENCE_DIAGRAM) == null) {
                    StereotypesHelper.createStereotype(profile, SIFB_SEQUENCE_DIAGRAM, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Diagram")));
                }

				if (StereotypesHelper.getStereotype(project, BASIC_FUNCTION_BLOCK) == null) {
					StereotypesHelper.createStereotype(profile, BASIC_FUNCTION_BLOCK, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Class")));
				}
				
				if (StereotypesHelper.getStereotype(project, COMPOSITE_FUNCTION_BLOCK) == null) {
					StereotypesHelper.createStereotype(profile, COMPOSITE_FUNCTION_BLOCK, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Class")));					
				}

                if (StereotypesHelper.getStereotype(project, SERVICE_INTERFACE_FUNCTION_BLOCK) == null) {
                    StereotypesHelper.createStereotype(profile, SERVICE_INTERFACE_FUNCTION_BLOCK, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Class")));
                }

				if (StereotypesHelper.getStereotype(project, EVENT_IN_PORT) == null) {
					StereotypesHelper.createStereotype(profile, EVENT_IN_PORT, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Port")));
				}
			
				if (StereotypesHelper.getStereotype(project, EVENT_OUT_PORT) == null) {
					StereotypesHelper.createStereotype(profile, EVENT_OUT_PORT, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Port")));
				}
				
				if (StereotypesHelper.getStereotype(project, DATA_IN_PORT) == null) {
					StereotypesHelper.createStereotype(profile, DATA_IN_PORT, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Port")));
				}
				
				if (StereotypesHelper.getStereotype(project, DATA_OUT_PORT) == null) {
					StereotypesHelper.createStereotype(profile, DATA_OUT_PORT, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Port")));
				}
				
				if (StereotypesHelper.getStereotype(project, ECC_INITIAL_STATE) == null) {
					StereotypesHelper.createStereotype(profile, ECC_INITIAL_STATE, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "State")));									
				}
				
				if (StereotypesHelper.getStereotype(project, ECC_STATE) == null) {
					StereotypesHelper.createStereotype(profile, ECC_STATE, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "State")));					
				}
				
				if (StereotypesHelper.getStereotype(project, ECC_TRANSITION) == null) {
					StereotypesHelper.createStereotype(profile, ECC_TRANSITION, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Transition")));
				}

                if (StereotypesHelper.getStereotype(project, ECC_CONDITION) == null) {
                    StereotypesHelper.createStereotype(profile, ECC_CONDITION, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Constraint")));
                }

				if (StereotypesHelper.getStereotype(project, ALGORITHM) == null) {
					StereotypesHelper.createStereotype(profile, ALGORITHM, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "State")));
				}
				
				if (StereotypesHelper.getStereotype(project, EVENT_OUTPUT) == null) {
					StereotypesHelper.createStereotype(profile, EVENT_OUTPUT, Arrays.asList(StereotypesHelper.getMetaClassByName(project, "Comment")));
				}
				
				closeSession(sessionFlag);						
			}
		});

	}
}
