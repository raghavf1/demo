package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.LinkWizardUploadImagePage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class LinkWizardInsertImageElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public LinkWizardInsertImageElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Link Wizard Insert Image Button
     * 
     * @author soundarya
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */
    public LinkWizardUploadImagePage clickLinkWizardInsertImageButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON Link Wizard Insert Image Button");
            root.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Link Wizard Insert Image Button \n METHOD: clickLinkWizardInsertImageButton" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardUploadImagePage(uiDriver);
    }
}