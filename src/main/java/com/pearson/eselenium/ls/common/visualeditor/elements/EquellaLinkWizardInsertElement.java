package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.EquellaLinkWizardInsertPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class EquellaLinkWizardInsertElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public EquellaLinkWizardInsertElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click Equella Link Wizard Insert Button
     * 
     * @author soundarya
     * @return EquellaLinkWizardInsertPage
     * @throws Exception
     */
    public EquellaLinkWizardInsertPage clickEquellaLinkWizardInsertButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK Equella Link Wizard Insert Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Equella Link Wizard Insert Button \n METHOD: clickEquellaLinkWizardInsertButton" + e
                    .getLocalizedMessage());
        }
        return new EquellaLinkWizardInsertPage(uiDriver);
    }
}