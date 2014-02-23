package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class UnderlineElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    

	/*Constructor*/
	public UnderlineElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click UnderlineButton on RadEditor
     * 
     * @author monica.anand
     * @return UnderlineElement
     * @throws Exception
     */
    public UnderlineElement clickUnderlineButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON UnderlineButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("unable to click on UnderlineButton \n METHOD: clickUnderlineButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
