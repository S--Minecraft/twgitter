package twgitter.config;

import twitter4j.conf.ConfigurationBuilder;

public class Config {
	public static ConfigurationBuilder cb;

	public static void doConfig(){
		ConfigurationBuilder configbuild = new ConfigurationBuilder();
		configbuild.setDebugEnabled(true)
		.setOAuthConsumerKey("K90wYRef2WCoSEH9Jae69VC0e")
		.setOAuthConsumerSecret("mq45WQOnQ1zjpY2UPKcxoY2OBut4zAxSaSQs6jyECAFsk8aj7r")
		.setOAuthAccessToken("2410039153-ycYIlcyOsjYzmsoyqaOvrC3MmT8sXAT4fZkdYRB")
		.setOAuthAccessTokenSecret("8cU8FW6GQ5elcK67yYP5Vuv8O1GDDVci63iRUZqQwG09r");

		cb = configbuild;
	}
}
