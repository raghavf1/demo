package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class HtmlElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public HtmlElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click HtmlButton on RadEditor
     * 
     * @author monica.anand
     * @return HtmlElement
     * @throws Exception
     */
    public HtmlElement clickHtmlButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON HtmlButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON HtmlButton \n METHOD: clickHtmlButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
