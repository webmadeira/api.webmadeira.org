# api.webmadeira.org

_This repository contains the code of Web Madeira's landing page API_


First, build the Project by executing the following command at the Project's root directory:<br>
`gradlew clean build`


Then run the application by executing the command (be sure that you have Java 1.8 (minimum) installed on the machine):<br>
`java -jar build/libs/web-madeira-api-v0.0.1.jar`


The api is now live at `http://localhost:8090`. <br> You can change api listening port by editing the attribute `source.port` within `application.properties` file. 


You can check api documentation at `http://localhost:8090/swagger-ui.html`
