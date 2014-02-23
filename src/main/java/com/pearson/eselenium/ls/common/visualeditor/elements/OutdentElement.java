package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class OutdentElement extends BasicPieceObject {
	
	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public OutdentElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click OutdentButton on RadEditor
     * 
     * @author monica.anand
     * @return OutdentElement
     * @throws Exception
     */
    public OutdentElement clickOutdentButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON OutdentButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON OutdentButton \n METHOD: clickOutdentButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
