import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class NewTest {
	private AppiumDriver driver;
	

@BeforeTest
	public void setup()throws Exception{
		//设置自动化相关参数（设置过程中只需要改value值）
		DesiredCapabilities caps=new DesiredCapabilities();
		//设置测试的web浏览器，如果是测试app则忽略
		caps.setCapability(CapabilityType.BROWSER_NAME, "");
		//设置测试平台是Android ios
		caps.setCapability("platformName", "Android");
		//设置测试机的id，用adb devices命令获取
		caps.setCapability("deviceName", "192.168.67.102:5555");
		//设置测试机的安卓版本
		caps.setCapability("platformVersion", "5.0");
		//将adb shell dumpsys window | findstr mCurrentFocus获取到的包名和Activity名设置为值
		caps.setCapability("appPackage", "com.android.dialer");
		caps.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		//A new session could not be created 的解决方法
		caps.setCapability("appWaitActivity", "com.android.dialer.DialtactsActivity");
		//每次启动时覆盖session，否则第二次后运行会报错不能新建session
		caps.setCapability("sessionOverride", true);
		//支持中文输入
		caps.setCapability("unicodeKeyboard", true);
		//重置输入法为系统默认
		caps.setCapability("resetKeyboard", true);
		//安装时不对apk进行重签名，设置没有必要，否则有的apk在重签名之后无法正常使用
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	}
@Test
public void plus() throws InterruptedException {
	driver.findElementByClassName("android.widget.ImageButton").click();
	driver.findElementById("com.android.dialer:id/one").click();
	driver.findElementById("com.android.dialer:id/two").click();
	driver.findElementById("com.android.dialer:id/three").click();
	driver.findElementById("com.android.dialer:id/dialpad_floating_action_button").click();
	Thread.sleep(10000);
	driver.findElementById("com.android.dialer:id/floating_end_call_action_button").click();
}

@AfterClass
public void tearDown()throws Exception{
	driver.quit();
}

}
