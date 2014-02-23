package com.pearson.eselenium.ls.common.plaintexteditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.LinkWizardUploadImagePage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;


/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class InsertAnImageElement extends BasicPieceObject {
	
	private boolean flag = false;

    public InsertAnImageElement(UIElement element) {
        super(element);
    }

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /**
     * Method helps to click Insert An Image Link
     * 
     * @author soundarya
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */
    public LinkWizardUploadImagePage clcikInsertAnImageLink() throws Exception {
        try {
            switchToFrame.switchToFrameContent();
            root.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON 'Insert An Image' LINK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK INSERT AN IMAGE LINK \n METHOD :clcikInsertAnImageLink" + e
                            .getLocalizedMessage());
        }
        return new LinkWizardUploadImagePage(uiDriver);
    }

    /**
     * Method helps to check Insert An Image Link displayed
     * 
     * @author soundarya
     * @return boolean
     * @throws Exception
     */
    public boolean isInsertAnImageLinkdisplayed() throws Exception {
        flag = false;
        try {
            switchToFrame.switchToFrameContent();
            flag = root.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK INSERT AN IMAGE LINK DISPLAYED \n METHOD :isInsertAnImageLinkdisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}