package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class AlignRightElement extends BasicPieceObject {

    public AlignRightElement(UIElement element) {
        super(element);
    }

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /**
     * Method helps to click AlignRightButton on RadEditor
     * 
     * @author monica.anand
     * @return void
     * @throws Exception
     */
    public void clickAlignRightButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON AlignRightButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON AlignRightButton \n METHOD: clickAlignRightButton" + e.getLocalizedMessage());
        }
        // return this;

    }

}
