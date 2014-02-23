package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentPage extends BasePageObject {

    private UIElement lnkStudentName = createElement(
            UIType.Xpath,
            "//form/table[2]//tr/th//a[contains(.,'{1}')]");

    private boolean flag = false;
    public StudentPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: StudentPage");
    }

    /*
     * This method will check student name is displayed
     * 
     * @author soundarya
     * @param String -strStudent
     * @return boolean
     * @throws Exception
     */
    public boolean isStudentNamesDisplayed(String strStudent) throws Exception {
        flag = false;
        try {
			if (StringUtils.isNotBlank(strStudent)) {
                logInstruction("LOG INSTRUCTION: CHECKING FOR STUDENT NAME: " + strStudent + "DISPLAYED");
				frameSwitch.switchToFrameContent();
				lnkStudentName.replaceValues(strStudent);
                flag = lnkStudentName.isDisplayedAfterWaiting(waitTime);
			} else
                throw new Exception("STUDENT NAME IS BLANK \n METHOD: isStudentNamesDisplayed");
		} catch (Exception e) {
			throw new Exception(
                    "CHECK STUDENT " + strStudent + "DISPLAYED \n METHOD: isStudentNamesDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /*
     * This method will click student name
     * 
     * @author soundarya
     * @param String -strStudent
     * @return StudentsMailHomePage
     * @throws Exception
     */
    public StudentsMailHomePage clickStudentName(String strStudent) throws Exception {

        try {
			if (StringUtils.isNotBlank(strStudent)) {
                logInstruction("LOG INSTRUCTION : CLICKING ON STUDENT " + strStudent + "NAME");
				frameSwitch.switchToFrameContent();
				lnkStudentName.replaceValues(strStudent);
				if (lnkStudentName.isDisplayedAfterWaiting(waitTime))
					lnkStudentName.clickAndWait(waitTime);
				else
                    logInstruction("LOG INSTRUCTION :  UNABLE TO CLICK STUDENT" + strStudent);

			} else
				throw new Exception("STUDENT NAME IS BLANK \n METHOD: clickStudentName");
        } catch (Exception e) {
            throw new Exception(
                    "CLICK STUDENT " + strStudent + "NAME \n METHOD: clickStudentName" + e
                            .getLocalizedMessage());
        }
        return new StudentsMailHomePage(uiDriver);
    }
}