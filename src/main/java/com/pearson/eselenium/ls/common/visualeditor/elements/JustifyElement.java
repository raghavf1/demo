package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class JustifyElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public JustifyElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click JustifyButton on RadEditor
     * 
     * @author monica.anand
     * @return JustifyElement
     * @throws Exception
     */
    public JustifyElement clickJustifyButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON JustifyButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON JustifyButton \n METHOD: clickJustifyButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
