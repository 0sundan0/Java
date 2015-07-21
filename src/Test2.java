import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.NoSuchElementException;

public class Test2 {


public class SeleniumReadConfig {
	Tesst test  =new Tesst();
try{
	
	test.driver1();
	test.login();
	test.clickelementbyxpath(".//*[@id='new_user']/fieldset/button");
	test.clickelementbyxpath("html/body/header/section[2]/a[2]");
	test.getnewwindow();
	test.sendkeys(".//*[@id='-field']", "testing");
	test.getoldwindow();
	}
catch (NoSuchElementException e) {
test.logger.error("Exception" +e);
	test.getscreenshot();
}
}
}


