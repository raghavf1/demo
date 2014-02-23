package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class HorizontalRuleElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    
	/*Constructor*/
	public HorizontalRuleElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click HorizontalRuleButton on RadEditor
     * 
     * @author monica.anand
     * @return HorizontalRuleElement
     * @throws Exception
     */
    public HorizontalRuleElement clickHorizontalRuleButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON HorizontalRuleButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON HorizontalRuleButton \n METHOD: clickHorizontalRuleButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
