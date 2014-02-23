package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentsOutBoxPage extends BasePageObject {

    private UIElement txtAssignment = createElement(UIType.Xpath, "//a[contains(.,'{1}')]");
    private UIElement lnkInbox = createElement(UIType.Css, ".tableheadtabOFF>a");

    private boolean flag = false;
    public StudentsOutBoxPage(UIDriver driver) {
        super(driver);
    }

    /*
     * This method will check is assignment is displayed
     * 
     * @author soundarya
     * @param String -assignment
     * @return StudetnPage
     * @throws Exception *
     */
    public boolean isAssignementDisplayedInOutbox(String strAssignment) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK ASSIGNMENT " + strAssignment + "DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strAssignment)) {
				txtAssignment.replaceValues(strAssignment);
                flag = txtAssignment.isDisplayedAfterWaiting(waitTime);
			} else
				throw new Exception(
						"ASSIGNMENT VALUE IS BLANK \n METHOD :isAssignementDisplayedInOutbox");
		} catch (Exception e) {
            throw new Exception(
                    "CHECK ASSIGNMENT " + strAssignment + "DISPLAYED \n METHOD :isAssignementDisplayedInOutbox" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /*
     * This method will click outbox assignment
     * 
     * @author soundarya
     * @param String -Student
     * @return StudetnPage
     * @throws Exception *
     */
    public DropBoxDetailViewPage clickOutboxAssignement(String strAssignment) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ASSIGNMENT " + strAssignment + "DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strAssignment)) {
				txtAssignment.replaceValues(strAssignment);
				if (txtAssignment.isDisplayedAfterWaiting(waitTime)) {
					txtAssignment.clickAndWait(waitTime);
				} else {
					throw new Exception(
							"ERROR WHILE CLICKING ASSINGMENT IN OUTBOX \n METHOD: clickOutboxAssignement");
				}
			} else
                throw new Exception("ASSIGNMENT VALUE IS BLANK \n METHOD: clickOutboxAssignement");
		} catch (Exception e) {
            throw new Exception("CLICK ASSIGNMENT " + strAssignment + "DISPLAYED" + e
                    .getLocalizedMessage());
        }
        return new DropBoxDetailViewPage(uiDriver);
    }

    /**
     * This method will click student outbox link"
     * 
     * @author soundarya
     * @return StudentOutBoxPage
     * @throws Exception
     * **/
    public StudentsOutBoxPage clickInbox() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK STUDENT OUTBOX LINK");
			frameSwitch.switchToFrameContent();
			if (lnkInbox.isDisplayedAfterWaiting(waitTime)) {
				lnkInbox.clickAndWait(waitTime);
			} else {
                throw new Exception("ERROR WHILE CLICKING INBOX \n METHOD: clickInbox");
			}
		} catch (Exception e) {
            throw new Exception("UNABLE TO CLICK STUDENT OUTBOX LINK" + e.getLocalizedMessage());
        }
        return new StudentsOutBoxPage(uiDriver);
    }
}