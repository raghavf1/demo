package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class AlignLeftElement extends BasicPieceObject {

    public AlignLeftElement(UIElement element) {
        super(element);
    }

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /**
     * Method helps to click AlignLeftButton on RadEditor
     * 
     * @author monica.anand
     * @return void
     * @throws Exception
     */
    public void clickAlignLeftButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON AlignLeftButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON AlignLeftButton \n METHOD:clickAlignLeftButton" + e
            		.getLocalizedMessage());
        }
    }
}
