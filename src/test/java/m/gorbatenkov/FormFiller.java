package m.gorbatenkov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormFiller {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Mary");
        $("#lastName").setValue("Sue");
        $("#userEmail").setValue("Mary@sue.org");
        $("#gender-radio-2 + label").click();
        $("#userNumber").setValue("+70000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/Logo.png"));
        $("#currentAddress").setValue(
                "30 Aulike St.\n" +
                "Suite 105\n" +
                "Kailua, Hawaii 96734\n" +
                "Phone: (808) 266-1222\n" +
                "Fax: (808) 266-1226");
        $("#state div").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city div").click();
        $(byText("Gurgaon")).click();

    }
}
