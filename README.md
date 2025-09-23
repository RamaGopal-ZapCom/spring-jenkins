# spring-jenkins
for jenkins testing purpose


@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
// Beans and configurations here
}

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppConfig.class);
    }
}

------------------------------

Jenkins and Tomcat Deployment Flow:

Start Jenkins:

Navigate to your Jenkins .war file location, for example:

C:\Jenkins_java_jar


Run the command:

java -jar jenkins.war


Login using your Jenkins credentials.

Update Tomcat Ports:

Since Jenkins uses port 8080 by default, change the Tomcat port in server.xml to avoid conflicts:

<Connector port="8081" protocol="HTTP/1.1"
connectionTimeout="20000"
redirectPort="8443"
maxParameterCount="1000" />


Configure Tomcat Users for Deployment:

Update tomcat-users.xml to allow Jenkins to deploy applications:

<role rolename="manager-script"/>
<user username="jenkins" password="Jenkins@123" roles="manager-script"/>


Start Tomcat:

Run Tomcat from the bin folder using:

startup.bat


Jenkins Build Flow:

Jenkins automatically detects the latest commit in your project repository.

It triggers the build and deploys the application to Tomcat.

Access Deployed Application:

Once deployed, you can access the application endpoints on the Tomcat port:

http://localhost:8081/spring-jenkins/welcomeMessage
http://localhost:8081/spring-jenkins/ping
http://localhost:8081/spring-jenkins/hello

