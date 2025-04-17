package seltest.herukoapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import seltest.herukoapp.pages.DropDown;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DropDownTest extends InitiateSeleniumTest{

    DropDown dropDownPage;
    @BeforeEach
    public void goToPage(){
        /**
         * Testing link and header to the page
         */
        mainPage.mainPageStart();
        mainPage.goToLesson("Dropdown");

        dropDownPage = new DropDown(driver);

        String header = dropDownPage.getHeaderText();

        assertEquals("Dropdown List", header);
    }

    @ParameterizedTest()
    @CsvSource({"Please select an option, true, true",
                "Option 1, false, false",
                "Option 2, false, false"})
    public void checkInitialDropdownState(String text, boolean disabled, boolean selected){
        /**
         * Simple test for dropdown
         */
        List<WebElement> options = dropDownPage.getOptions();

        assertEquals(3, options.size(), "Wrong amount of options");
        boolean present = false;
        for (WebElement option:options){
            if (option.getText().equals(text)){
                present = true;
                assertEquals(disabled, isAttributePresent(option,"disabled"),
                        "Wrong Value for Attribute disabled.");
                assertEquals(selected,isAttributePresent(option, "selected"),
                        "Wrong Value for Attribute selected.");
            }
        }
        if(!present){
            fail("Option "+text+" not found");
        }
    }

    @Test()
    public void checkDropdownBehavour(){
        /**
         * check dropdown interaction
         */
        dropDownPage.selectByValue("1");
        assertEquals(true, isAttributePresent(dropDownPage.getOption1(), "selected"),
                "Option is not selected");
        assertEquals(false, isAttributePresent(dropDownPage.getDefaultOption(), "selected"),
                "Option stills elected");

        dropDownPage.selectByText("Option 2");
        assertEquals(true, isAttributePresent(dropDownPage.getOption2(), "selected"),
                "Option is not selected");

        dropDownPage.selectByInd(1);
        assertEquals(true, isAttributePresent(dropDownPage.getOption1(), "selected"),
                "Option is not selected");
    }

    @Test
    public void checkNegativeScnarios(){
        /**
         * Checking some restricted actions
         */
        try {
            dropDownPage.selectByInd(0);
            fail("Disabled option can be selected");
        }
        catch(UnsupportedOperationException e){
            // Do nothing
        }

        try {
            dropDownPage.selectByInd(3);
            fail("Extra option available");
        }
        catch(NoSuchElementException e){
            // Do nothing
        }
    }

    private boolean isAttributePresent(WebElement element, String attributeName){
        String result = element.getDomAttribute(attributeName);
        return result != null;
    }
}
