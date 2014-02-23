package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class ParagraphStyleElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

	/*Constructor*/
	public ParagraphStyleElement(UIElement element) {
        super(element);
    }

    /**
     * Method helps to click ParagraphStyle button on RadEditor
     * 
     * @author monica.anand
     * @return ParagraphStyleElement
     * @throws Exception
     */
    public ParagraphStyleElement clickParagraphStyleButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON ParagraphStyleButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON ParagraphStyleButton \n METHOD: clickParagraphStyleButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to select ParagraphStyle
     * 
     * @author monica.anand
     * @param String
     * @return ParagraphStyleElement
     * @throws Exception
     */
    public ParagraphStyleElement selectParagraphStyle(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT ParagraphStyle");
            switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT ParagraphStyle \n METHOD: selectParagraphStyle" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
