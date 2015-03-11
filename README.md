# WebDriver
Hello world example for web driver GUI test framework based on Page Object pattern for Rozetka site

Before use, create access.xml file in the root directory of project (RozetkaTestTask folder) and fill all fields:

<access>
	<email>
		<emailLogin>test@gmail.com</emailLogin>
		<emailPass>********</emailPass>
		<emailTo>test@ukr.net</emailTo>
		<emailTo>hello@ukr.net</emailTo>
	</email>
	<database>
		<jdbcDriver>com.mysql.jdbc.Driver</jdbcDriver>
		<dbUrl>jdbc:mysql://localhost/test</dbUrl>
		<dbUser>root</dbUser>
		<dbPass>****</dbPass>
	</database>
</access>

Run build with tests via command prompt for Continuous Integration Service:

mvn install -Dmaven.test.failure.ignore=true

