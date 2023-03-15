# Visited National Park
Perscholas Java fullstack project

The project Visited National Parks is a Spring Boot web based application which uses different full stack Java technologies such as Thymeleaf, Bootstrap and Plain Javascript for the front end, the security is handled by Spring security and the data layer implementation used is JPA data and hibernate. Spring MVC is used for the different application layers and also JUnit is used for the unit testing.

The goal for this project is that a user can register the national parks visits by selecting a corresponding national park for a given the dates of the visit, all this states/national parks catalog information is auto generated when installing the project and running the insert queries. The order of running these insert scripts is:
   1)resources/schema/States_List_query.sql
   2)resources/schema/nationalPark_StateNP.sql
   3)resources/schema/Demo.sql

To compile and run this project, it is required to clone the repo (if downloading it from gitlab) or if the project is shared via a compressed zip file, then unzip the file and open the project in an IntelliJ IDE folder, make sure Java version 11 is installed and simply Build + Run the project.

Once the project runs, open a new browser and point the url to: http://localhost:8010/login and make sure you follow below steps
Create a new user and make sure after a new user is created, the web site redirects to the Login page
Log in using the newly created credentials
To add a national park visit, go to the site top menu and select National Park Menu option and then select Add visit
Select the state, pick a national park as well as the dates of the visit, after this info is selected by the user, then a visit can be added and the visit will be associated to the user
To check the newly added visit click on the Home top menu option and the new visit will be displayed there
Due to the scope of the project, there is no functionality implemented related to uploading images for a given visit, however, to verify this functionality the images can be added manually to the database and drop these images in the static/img project folder to get an idea of how the images are displayed to a specific national park visit.

