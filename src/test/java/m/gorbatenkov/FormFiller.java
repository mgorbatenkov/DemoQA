package m.gorbatenkov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        $("#userNumber").setValue("7000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/Logo.png"));
        $("#currentAddress").setValue("Kailua, Hawaii 96734");
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        $("tbody tr:nth-child(1)").shouldHave(text("Mary Sue"));
        $("tbody tr:nth-child(2)").shouldHave(text("Mary@sue.org"));
        $("tbody tr:nth-child(3)").shouldHave(text("Female"));
        $("tbody tr:nth-child(4)").shouldHave(text("7000000000"));
        $("tbody tr:nth-child(5)").shouldHave(text("21 May,1984"));
        $("tbody tr:nth-child(6)").shouldHave(text("Maths"));
        $("tbody tr:nth-child(7)").shouldHave(text("Reading"));
        $("tbody tr:nth-child(8)").shouldHave(text("Logo.png"));
        $("tbody tr:nth-child(9)").shouldHave(text("Kailua, Hawaii 96734"));
        $("tbody tr:nth-child(10)").shouldHave(text("NCR Gurgaon"));





    }
}
