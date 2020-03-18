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
		//�����Զ�����ز��������ù�����ֻ��Ҫ��valueֵ��
		DesiredCapabilities caps=new DesiredCapabilities();
		//���ò��Ե�web�����������ǲ���app�����
		caps.setCapability(CapabilityType.BROWSER_NAME, "");
		//���ò���ƽ̨��Android ios
		caps.setCapability("platformName", "Android");
		//���ò��Ի���id����adb devices�����ȡ
		caps.setCapability("deviceName", "192.168.67.102:5555");
		//���ò��Ի��İ�׿�汾
		caps.setCapability("platformVersion", "5.0");
		//��adb shell dumpsys window | findstr mCurrentFocus��ȡ���İ�����Activity������Ϊֵ
		caps.setCapability("appPackage", "com.android.dialer");
		caps.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		//A new session could not be created �Ľ������
		caps.setCapability("appWaitActivity", "com.android.dialer.DialtactsActivity");
		//ÿ������ʱ����session������ڶ��κ����лᱨ�����½�session
		caps.setCapability("sessionOverride", true);
		//֧����������
		caps.setCapability("unicodeKeyboard", true);
		//�������뷨ΪϵͳĬ��
		caps.setCapability("resetKeyboard", true);
		//��װʱ����apk������ǩ��������û�б�Ҫ�������е�apk����ǩ��֮���޷�����ʹ��
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
