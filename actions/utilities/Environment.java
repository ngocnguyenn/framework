package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config{
	@Key("url")
	String appUrl();
	
	@Key("db.username")
	String getUsername();
	
	@Key("db.password")
	String getPassword();
}
