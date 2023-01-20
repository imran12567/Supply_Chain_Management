package generic.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtitlity {
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
}
