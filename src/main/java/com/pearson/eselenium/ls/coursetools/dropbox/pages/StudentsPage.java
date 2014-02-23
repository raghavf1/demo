package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentsPage extends BasePageObject {

    private UIElement txtStudentName = createElement(UIType.Css, "a[title='{1}']");

    public StudentsPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## StudentsPage ##");
    }

    /*
     * This method will check student name is displayed or not.
     * 
     * @author soundarya
     * 
     * @param String -strStudent
     * 
     * @return boolean
     * 
     * @throws Exception *
     */
    public boolean isStudentNamesDisplayed(String strStudent) throws Exception {
        try {
			if (StringUtils.isNotBlank(strStudent)) {
				logInstruction("LOG INSTRUCTION: CHECK STUDENT " + strStudent
						+ "DISPLAYED");
				frameSwitch.switchToFrameContent();
				return txtStudentName.isDisplayedAfterWaiting(waitTime);
			} else
				throw new Exception(
						"STUDENT NAME IS BLANK \n: METHOD isStudentNamesDisplayed");
		} catch (Exception e) {
			throw new Exception("CHECK STUDENT " + strStudent + "DISPLAYED \n: METHOD isStudentNamesDisplayed" + e
                            .getLocalizedMessage());
        }
    }

    /*
     * This method will click student name
     * 
     * @author soundarya
     * 
     * @param String -strStudent
     * 
     * @return StudentsMailHomePage
     * 
     * @throws Exception *
     */
    public StudentsMailHomePage clickStudentName(String strStudent) throws Exception {
		try {
			if (StringUtils.isNotBlank(strStudent)) {
				logInstruction("LOG INSTRUCTION: CLICK STUDENT " + strStudent
						+ "NAME");
				frameSwitch.switchToFrameContent();
				if (txtStudentName.isDisplayedAfterWaiting(waitTime)) {
					txtStudentName.clickAndWait(waitTime);
					return new StudentsMailHomePage(uiDriver);
				} else {
					throw new Exception(
							"ERROR WHILE CLICKING STUDENT NAME \n METHOD: clickStudentName");
				}
			} else
				throw new Exception(
						"STUDENT NAME IS BLANK \n: METHOD clickStudentName");
		} catch (Exception e) {
			throw new Exception("CLICK STUDENT " + strStudent + "NAME \n: METHOD clickStudentName" + e
                            .getLocalizedMessage());
        }
    }
}