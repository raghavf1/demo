package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class StrikethroughElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public StrikethroughElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click StrikethroughButton on RadEditor
     * 
     * @author monica.anand
     * @return StrikethroughElement
     * @throws Exception
     */
    public StrikethroughElement clickStrikethroughButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON StrikethroughButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON StrikethroughButton \n METHOD: clickStrikethroughButton" + e
            		.getLocalizedMessage());
        }
        return this;

    }

}
