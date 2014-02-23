package com.pearson.eselenium.ls.common.plaintexteditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.MathEditorPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class MathEditorLinkElement extends BasicPieceObject {
	
	private boolean flag = false;

    public MathEditorLinkElement(UIElement element) {
        super(element);
    }

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /**
     * Method helps to click Insert An Image Link
     * 
     * @author soundarya
     * @return MathEditorPage
     * @throws Exception
     */
    public MathEditorPage clcikMathEditorLink() throws Exception {
        try {
            switchToFrame.switchToFrameContent();
            root.clickNoWait();
            logInstruction("LOG INSTRUCTION : CLICKED ON 'Math Editor' LINK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK INSERT AN IMAGE LINK \n METHOD :clcikMathEditorLink" + e
                            .getLocalizedMessage());
        }
        return new MathEditorPage(uiDriver);
    }

    /**
     * Method helps to check Math Editor Link
     * 
     * @author soundarya
     * @return boolean
     * @throws Exception
     */
    public boolean isMathEditorLinkDisplayed() throws Exception {
        flag = false;
        try {
            switchToFrame.switchToFrameContent();
            flag = root.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK MATH EDITOR LINK\n METHOD :isMathEditorLinkDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}