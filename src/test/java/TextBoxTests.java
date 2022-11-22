import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $("[userName]").setValue("Egor");
    }
}
