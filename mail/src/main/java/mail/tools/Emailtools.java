package mail.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

import mail.tools.builder.Builder;

public class Emailtools {
	public static void main(String[] args) throws IOException {
		Builder.builderMail();
		send();
		System.out.println("end");
	}
	public static void send() throws IOException {
		ActiveXComponent axOutlook = new ActiveXComponent("Outlook.Application");
		Dispatch mailItem = Dispatch.call(axOutlook, "CreateItem", 0).getDispatch();
		Dispatch inspector = Dispatch.get(mailItem, "GetInspector").getDispatch();
		Dispatch recipients = Dispatch.call(mailItem, "Recipients").getDispatch();
		Dispatch.call(recipients, "Add", "Rocky.Chen@morningstar.com");//send to
		Dispatch.put(mailItem, "Subject", "我要测试!xxx");
		Dispatch.put(mailItem, "CC", "Rocky.Chen@morningstar.com");//cc
		String body = "<html><body><div style='color:red;'>This is a ssssTest !</div></body></html>";
		BufferedReader bf = new BufferedReader(new FileReader(
				new File("D:\\\\Download\\\\mailtools\\\\mail\\\\src\\\\main\\\\webapp\\\\successMail.html")));
		String html = "";
		String str = "";
		while ((str = bf.readLine()) != null) {
			html += str;
		}
		Dispatch.put(mailItem, "HTMLBody", html);
		Dispatch.call(mailItem, "Display");
		Dispatch.call(mailItem, "Send");
	}

}
