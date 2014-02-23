package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class SizeElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

	/*Constructor*/
	public SizeElement(UIElement element) {
        super(element);
	}
    
    /**
     * Method helps to click SizeButton on RadEditor
     * 
     * @author monica.anand
     * @return SizeElement
     * @throws Exception
     */
    public SizeElement clickSizeButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SizeButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON SizeButton \n METHOD: clickSizeButton" + e.getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to select size
     * 
     * @author monica.anand
     * @param String
     * @return SizeElement
     * @throws Exception
     */
    public SizeElement selectSize(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT  Size");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT size \n METHOD: selectSize" + e.getLocalizedMessage());
        }
        return this;
    }
}
