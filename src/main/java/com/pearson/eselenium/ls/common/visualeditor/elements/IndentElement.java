package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class IndentElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public IndentElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click IndentButton on RadEditor
     * 
     * @author monica.anand
     * @return IndentElement
     * @throws Exception
     */
    public IndentElement clickIndentButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON IndentButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON IndentButton \n METHOD: clickIndentButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
