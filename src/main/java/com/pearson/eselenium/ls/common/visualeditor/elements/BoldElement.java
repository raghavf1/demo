package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class BoldElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
   

 	public BoldElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click BoldButton on RadEditor
     * 
     * @author monica.anand
     * @return void
     * @throws Exception
     */
    public void clickBoldButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BoldButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BoldButton \n METHOD: clickBoldButton" + e
            		.getLocalizedMessage());
        }
    }
}
