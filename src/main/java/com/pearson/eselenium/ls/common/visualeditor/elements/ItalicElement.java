package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class ItalicElement extends BasicPieceObject {

 	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
   
	/*Constructor*/
	public ItalicElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click ItalicButton on RadEditor
     * 
     * @author monica.anand
     * @return ItalicElement
     * @throws Exception
     */
    public ItalicElement clickItalicButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON ItalicButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON ItalicButton \n METHOD: clickItalicButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
