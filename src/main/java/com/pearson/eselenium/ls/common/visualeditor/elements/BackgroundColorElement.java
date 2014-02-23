package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class BackgroundColorElement extends BasicPieceObject {

    public BackgroundColorElement(UIElement element) {
        super(element);
    }

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /**
     * Method helps to click BackgroundColourButton on RadEditor
     * 
     * @author monica.anand
     * @return void
     * @throws Exception
     */
    public void clickBackgroundColourButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BackgroundColourButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BackgroundColourButton \n METHOD: clickBackgroundColourButton" + e
                    .getLocalizedMessage());
        }

    }

}
