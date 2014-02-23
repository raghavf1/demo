package com.pearson.eselenium.ls.coursehome.syllabus.student.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains Syllabus page related methods.
 * 
 * @author saurabh.jain1
 * 
 */
public class ViewSyllabusPage extends BasePageObject {

    public ViewSyllabusPage(UIDriver uidriver) {
        super(uidriver);
        logInstruction("LOG INSTRUCTION: ## ViewSyllabusPage ##");

    }

    // UIElement Declaration
    private UIElement lblCrsSylHeader = createElement(UIType.Css, ".tablehead");
    private UIElement msgProfessorName = createElement(
            UIType.Xpath,
            "html/body/table/tbody/tr[1]/td[2]/font/strong");
    private UIElement msgPageHeadding = createElement(UIType.Css, "div[class=" + "pageTitle" + "]");
    private UIElement msgCourseSyllabusTableHeadding = createElement(
            UIType.Xpath,
            "html/body/h2/div");
    private UIElement msgCourseTile = createElement(
            UIType.Xpath,
            "html/body/table/tbody/tr//td/strong[contains(text(),'{1}')]");
    private UIElement msgCourseDescriptionSimpleEditor = createElement(UIType.Xpath, "//table/tbody/tr/td/p/simpleeditor[contains(text(),'{1}')]");
    private UIElement msgCourseDescriptionRADEditor = createElement(UIType.Xpath, "//table/tbody/tr/td/p/radeditor[contains(text(),'{1}')]");
    private UIElement msgUploadFileIsSame = createElement(UIType.Xpath, "html/body/div[1]/p");
    private UIElement msgStdViewInfo = createElement(
            UIType.Xpath,
            "//table[@role='presentation']//td[font[strong[contains(.,'{1}')]]]");
    private UIElement msgInstructorName = createElement(
            UIType.Xpath,
            "//table/tbody/tr/td[2]/font/strong[contains(text(),'{1}')]");
    private UIElement lnkLink = createElement(
            UIType.Css,
            "html>body>table>tbody>tr>td>p>radeditor>a");
    private UIElement msgCheckTitle = createElement(
            UIType.Xpath,
            "//table//tr//td[1]/strong[contains(.,'{1}')]");
    private UIElement imgVisible = createElement(UIType.Css, "html>body>table>tbody>tr>td>img");
    private UIElement msgItemText = createElement(
            UIType.Xpath,
            "//td[strong[contains(text(),'{1}')]]/following-sibling::td[1]/p/radeditor/a");
    private UIElement msgItemText1 = createElement(
            UIType.Xpath,
            "//td[strong[contains(text(),'{1}')]]/following-sibling::td[1]/p/radeditor");
    // private UIElement orderno;
    private UIElement msgHrefContent = createElement(
            UIType.Xpath,
            "//a[contains(@href,'EquellaLink')]");
    private UIElement msgEditInstructorInfoEditorText = createElement(
            UIType.Xpath,
            "//table/tbody/tr/td[2]/p");

    private boolean flag = false;

    /**
     * This is for Check whether CourseSyllabus is exist or not.
     * 
     * @author saurabh.jain1
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseSyllabusExist(String nameofSyllabus) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: Verifying Course syllabus header title");
            frameSwitch.switchToFrameContent();
            lblCrsSylHeader.replaceValues(nameofSyllabus);
            uiDriver.waitToBeDisplayed(lblCrsSylHeader, waitTime);
            if (lblCrsSylHeader.isDisplayed()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("Course syllabus header not displayed" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to get the professor name
     * 
     * @author ashish.juyal
     * @return string
     * @throws Exception
     */

    public String getProfessorName() throws Exception {
        String text = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING PROFESSOR NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgProfessorName, waitTime);
            text = msgProfessorName.getText();
        } catch (Exception e) {
            throw new Exception("unable to get the professor name" + e.getLocalizedMessage());
        }
        return text;
    }

    /**
     * This method is used to get the page heading
     * 
     * @author soundarya.B
     * @return String
     * @throws Exception
     */
    public String getPageHeadding() throws Exception {
        String pageHeadding;
        try {
            logInstruction("LOG INSTRUCTION: Verifying Course syllabus header title");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgPageHeadding, waitTime);
            pageHeadding = msgPageHeadding.getText().trim();
        } catch (Exception e) {
            throw new Exception("Course syllabus header not displayed" + e.getLocalizedMessage());
        }
        return pageHeadding;
    }

    /**
     * This method is used to get the page heading
     * 
     * @author soundarya.B
     * @return String
     * @throws Exception
     */
    public String getSyllabusTableHeadding() throws Exception {
        String tableHeadding;
        try {
            logInstruction("LOG INSTRUCTION: Verifying Course syllabus header title");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgCourseSyllabusTableHeadding, waitTime);
            tableHeadding = msgCourseSyllabusTableHeadding.getText().trim();
        } catch (Exception e) {
            throw new Exception("Course syllabus header not displayed" + e.getLocalizedMessage());
        }
        return tableHeadding;
    }

    /**
     * This method is used to check the page headding is displayed
     * 
     * @author soundarya.B
     * @return boolean
     * @throws Exception
     */
    public boolean isSyllabusItemsTitleDisplayed(String item) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: Verifying Course syllabus header title");
            frameSwitch.switchToFrameContent();
            msgCourseTile.replaceValues(item);
            uiDriver.waitToBeDisplayed(msgCourseTile, waitTime);
            flag = msgCourseTile.isDisplayed();
        } catch (Exception e) {
            throw new Exception("Course syllabus header not displayed" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check the description of an item displayed
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */
    public boolean isSyllabusItemsDescriptionDisplayed(String item) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Verifying Course syllabus descrition displayed ot not");
            frameSwitch.switchToFrameContent();
            msgCourseDescriptionSimpleEditor.replaceValues(item);
            msgCourseDescriptionRADEditor.replaceValues(item);
            if (msgCourseDescriptionSimpleEditor.isDisplayedAfterWaiting(waitTime) || msgCourseDescriptionRADEditor.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
            logInstruction("LOG INSTRUCTION: sucussfully Verifying Course syllabus descrition displayed ot not");
        } catch (Exception e) {
            throw new Exception("unable Course syllabus header not displayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check content of the Uploaded file and verify uploaded file and shown file
     * are Same or not.
     * 
     * @param Data
     *            First Line of the content of the file which you have uploaded.
     * @return {@link Boolean}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isUploadedFileIsSame(String Data) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: checking file wheather they are same or not");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgUploadFileIsSame, waitTime);
            if (msgUploadFileIsSame.getText().contains(Data))
                flag = true;
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the Data " + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to check the office and location values from the view syllabyus
     * 
     * @author ashish.juyal
     * @return string
     * @throws Exception
     */
    public boolean isLocationDisplayedFromStudentView(String Professorname, String locationval)
            throws Exception {
        String text = null;

        try {
            logInstruction("LOG INSTRUCTION: checking the location");
            frameSwitch.switchToFrameContent();
            msgStdViewInfo.replaceValues(Professorname);
            uiDriver.waitToBeDisplayed(msgStdViewInfo, waitTime);
            text = msgStdViewInfo.getText();
            System.out.println("the text os" + text);
            if (text.contains(locationval)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception("unable to get the value" + e.getLocalizedMessage());
        }
        return flag;
    }

    // /**
    // * This method helps to get the order number corresponding to the syllabus item name
    // *
    // * @author ashish.juyal
    // * @return String
    // * @throws Exception
    // */
    //
    // public String getOrderNumber(String syllabusItemName) throws Exception {
    // String orno = null;
    // try {
    // logInstruction("LOG INSTRUCTION: Getting the order no");
    // frame.switchToFrameContent();
    // orderno.replaceValues(syllabusItemName);
    // uiDriver.waitToBeDisplayed(orderno, waitTime);
    // orno = orderno.getAttribute("value");
    // } catch (Exception e) {
    // throw new Exception("unable to get the order no" + e.getLocalizedMessage());
    // }
    // return orno;
    // }

    /**
     * This method gets the instructor name from the course view
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     */

    public boolean isInstructorNameDisplayed(String nameofInstructor) throws Exception {
        String text = null;

        try {
            logInstruction("LOG INSTRUCTION: getting the name of the instructor from the course view");
            frameSwitch.switchToFrameContent();
            msgInstructorName.replaceValues(nameofInstructor);
            uiDriver.waitToBeDisplayed(msgInstructorName, waitTime);
            text = msgInstructorName.getText();
            if (text.contains(nameofInstructor)) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception("unable to get the instructor name" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This function will click on Course view Of the Prof where Link has been uploaded from Compose
     * text
     * 
     * @return {@link ViewSyllabusPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public ViewSyllabusPage clickOnLink() throws Exception {
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkLink, waitTime);
            lnkLink.click();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the Link" + e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will Check wheather title is Available in Syllabus item
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isTitlePresent(String titlename) throws Exception {

        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: checking title of the syllabus item");
            msgCheckTitle.replaceValues(titlename);
            uiDriver.waitToBeDisplayed(msgCheckTitle, waitTime);
            if (msgCheckTitle.isDisplayed())
                flag = true;
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get title" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check text of the syllabus Item in course tab Mode.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public boolean isTextPresent(String itemtitle) throws Exception {

        try {
            try {
                frameSwitch.switchToFrameContent();
                msgItemText.replaceValues(itemtitle);
                if (msgItemText.isPresent()) {
                    flag = true;
                }
            } catch (Exception e) {
                frameSwitch.switchToFrameContent();
                msgItemText1.replaceValues(itemtitle);
                if (msgItemText1.isPresent()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the text of the item" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will get the title of the syllabus Item when checked in course Mode.
     * 
     * @return String
     * @param String
     *            -itemname
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getItemTitle(String itemname) throws Exception {
        String heading = null;
        try {
            logInstruction("LOG INSTRUCTION: getting title of the item");
            frameSwitch.switchToFrameContent();

            msgCheckTitle.replaceValues(itemname);
            uiDriver.waitToBeDisplayed(msgCheckTitle, waitTime);
            heading = msgCheckTitle.getText().trim();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the title" + e.getLocalizedMessage());
        }
        return heading;
    }

    /**
     * This method will give you the text of the syllabus item ibn course mode.
     * 
     * @return String
     * @param String
     *            -itemname
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getTextofItem(String itemname) throws Exception {
        String heading = null;
        try {
            frameSwitch.switchToFrameContent();
            try {
                msgItemText.replaceValues(itemname);
                uiDriver.waitToBeDisplayed(msgItemText, waitTime);
                if (msgItemText.getText().trim() != null) {
                    heading = msgItemText.getText().trim();
                }
            } catch (Exception e) {
                msgItemText1.replaceValues(itemname);
                if (msgItemText1.getText().trim() != null) {
                    heading = msgItemText1.getText().trim();
                }
            }
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the text of the item" + e
                    .getLocalizedMessage());
        }
        return heading;
    }

    public boolean isSyllabusItemDisplayed(String item) {

        return false;
    }

    /**
     * This function will check whether Professor Image is visible/Available or not
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isProfImageVisible() throws Exception {

        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgVisible, waitTime);
            if (imgVisible.isDisplayed())
                flag = true;
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the image " + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will return Office location,proff name,phone, fax. Use contains to Assert
     * 
     * @return {@link String}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getOfficeLocation() throws Exception {
        String location = null;
        logInstruction("LOG INSTRUCTION: getting office location");
        try {
            frameSwitch.switchToFrameContent();
            List<WebElement> list = uiDriver.findElements(By.tagName("td"));
            location = list.get(1).getText().trim();
            System.out.println("Data is:" + location);
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: not able to get the office location");
        }
        return location;
    }

    /**
     * This method will return Office location,proff name,phone, fax. Use contains to Assert
     * 
     * @return {@link String}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getOfficeHours() throws Exception {
        String location = null;
        logInstruction("LOG INSTRUCTION: getting office location");
        try {
            frameSwitch.switchToFrameContent();
            List<WebElement> list = uiDriver.findElements(By.tagName("td"));
            location = list.get(1).getText().trim();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: not able to get the office hours");
        }
        return location;
    }

    /**
     * This method will return Office location,proff name,phone, fax. Use contains to Assert
     * 
     * @return {@link String}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getOfficephone() throws Exception {
        String location = null;
        logInstruction("LOG INSTRUCTION: getting office phone");
        try {
            frameSwitch.switchToFrameContent();
            List<WebElement> list = uiDriver.findElements(By.tagName("td"));
            location = list.get(1).getText().trim();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: not able to get the Phone");
        }
        return location;
    }

    /**
     * This method will return Office location,proff name,phone, fax. Use contains to Assert
     * 
     * @return {@link String}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getOfficeFax() throws Exception {
        String location = null;
        logInstruction("LOG INSTRUCTION: getting office location");
        try {
            frameSwitch.switchToFrameContent();
            List<WebElement> list = uiDriver.findElements(By.tagName("td"));
            location = list.get(1).getText().trim();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: not able to get the Fax");
        }
        return location;
    }

    /**
     * This method helps to get the Order No
     * 
     * @author ashish.juyal
     * 
     */
    public List<String> getOrderNumber() throws Exception {
        ArrayList<String> arr = new ArrayList<String>();
        try {
            logInstruction("LOG INSTRUCTION: checking the order no");
            frameSwitch.switchToFrameContent();
            List<WebElement> list = uiDriver.findElements(By.xpath("//tbody//tr//td[1]//strong"));
            int s = list.size();
            for (int i = 0; i < s; i++) {
                String itemnames = list.get(i).getText().trim();
                arr.add(itemnames);
            }
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
        return arr;
    }

    /**
     * Method helps to verify equella content
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEquellaContentDisplayed() throws Exception {

        try {
            logInstruction("verifying the equella content");
            uiDriver.waitToBeDisplayed(msgHrefContent, waitTime);
            if (msgHrefContent.isDisplayed()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("Unable to verify the equella content" + e.getLocalizedMessage());
        }

        return flag;
    }

    /**
     * Method helps to verify whether Edit Instructor Information Visual / Plain Editor Text
     * displayed or not
     * 
     * @return boolean
    
     * @throws Exception
     * @author suchi.singh
     */
    public boolean isEditInstructorInfoEditorTextPresent() throws Exception {

        try {
            logInstruction("verifying the Edit Instructor Information Visual / Plain Editor Text displayed or not");
            frameSwitch.switchToFrameContent();
         //   uiDriver.waitToBeDisplayed(msgEditInstructorInfoEditorText, waitTime);
            if (msgEditInstructorInfoEditorText.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "Edit Instructor Information Visual / Plain Editor Text is not displayed" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method is used to get the description of an item displayed
     * 
     * @param String
     *            item
     * @author suchi.singh
     * @return String
     * @throws Exception
     */
    public String getSyllabusItemsDescription(String item) throws Exception {
        String description = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING COURSE SYLLABUS DESCRITION DISPLAYED OT NOT");
            frameSwitch.switchToFrameContent();
            msgCourseDescriptionSimpleEditor.replaceValues(item);
            msgCourseDescriptionRADEditor.replaceValues(item);
          
            if (msgCourseDescriptionSimpleEditor.isDisplayedAfterWaiting(waitTime) )
            {
            	 description = msgCourseDescriptionSimpleEditor.getText();	
            }

            else
            {
            	 description = msgCourseDescriptionRADEditor.getText();	
            }
            
            

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING COURSE SYLLABUS DESCRITION DISPLAYED OT NOT." + "\n METHOD : getSyllabusItemsDescription \n" + e
                            .getLocalizedMessage());
        }
        return description;
    }

}
