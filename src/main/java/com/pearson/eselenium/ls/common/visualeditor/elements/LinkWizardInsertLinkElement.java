package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.LinkWizardInsertLinkPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class LinkWizardInsertLinkElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public LinkWizardInsertLinkElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click Link Wizard Insert Link
     * 
     * @author soundarya
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     */
    public LinkWizardInsertLinkPage clickLinkWizardInsertLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ONLink Wizard Insert Link");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Link Wizard Insert Link \n METHOD: clickLinkWizardInsertLink" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }
}