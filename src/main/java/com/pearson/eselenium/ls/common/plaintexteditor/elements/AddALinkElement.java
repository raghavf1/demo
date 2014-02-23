package com.pearson.eselenium.ls.common.plaintexteditor.elements;

com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.LinkWizardInsertLinkPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class AddALinkElement extends BasicPieceObject {
	
	private boolean flag = false;

    public AddALinkElement(UIElement element) {
        super(element);
    }

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /**
     * Method helps to click Add a Link
     * 
     * @author soundarya
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     */
    public LinkWizardInsertLinkPage clickAddaLink() throws Exception {
        try {
            switchToFrame.switchToFrameContent();
            root.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON 'Add a Link' LINK");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ADD A LINK \n METHOD :clickAddaLink" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }

    /**
     * Method helps to check Add a Link displayed
     * 
     * @author soundarya
     * @return boolean
     * @throws Exception
     */
    public boolean isAddLinkDisplayed() throws Exception {
        flag = false;
        try {
            switchToFrame.switchToFrameContent();
            flag = root.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK ADD A LINK DISPLAYED \n METHOD :isAddLinkDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}
