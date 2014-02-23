package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class FontNameElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public FontNameElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click FontNameButton on RadEditor
     * 
     * @author monica.anand
     * @return FontNameElement
     * @throws Exception
     */
    public FontNameElement clickFontNameButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON FontNameButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON FontNameButton \n METHOD: clickFontNameButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to select FontName
     * 
     * @author monica.anand
     * @return FontNameElement
     * @throws Exception
     */
    public FontNameElement selectFontName(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT FontName");
            switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT FontName \n METHOD: selectFontName" + e.getLocalizedMessage());
        }
        return this;
    }
}
