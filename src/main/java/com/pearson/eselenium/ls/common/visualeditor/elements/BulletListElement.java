package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class BulletListElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /*Constructor*/
	public BulletListElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click BulletListButton on RadEditor
     * 
     * @author monica.anand
     * @return void
     * @throws Exception
     */
    public void clickBulletListButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BulletListButton");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BulletListButton \n METHOD: clickBulletListButton" + e
            		.getLocalizedMessage());
        }
    }
}
