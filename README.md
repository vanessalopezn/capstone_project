# Visited National Park
Perscholas Java fullstack project

The project Visited National Parks is a Spring Boot web based application which uses different full stack Java technologies such as Thymeleaf, Bootstrap and Plain Javascript for the front end, the security is handled by Spring security and the data layer implementation used is JPA data and hibernate. Spring MVC is used for the different application layers and also JUnit is used for the unit testing.

The goal for this project is that a user can register the national parks visits by selecting a corresponding national park 
for a given the dates of the visit all this states/national parks catalog information is auto generated when installing 

In order to run the project, below are the steps to perform:
   1) Clone the repo (if downloading the project from gitlab) or if the project is shared via a compressed zip file, then unzip the file and open the project in an IntelliJ IDE folder
   2) Go to MySQL Workbench and run the following command in a query window: CREATE SCHEMA visited_np
   3) Run the project file capstone_project/src/main/java/org.vlopezn.visitednationalpark/VisitedNationalParkApplication
   4) Execute the content of the following queries in MySQL Workbench, these queries correspond to the state list, national parks and 
demo script to easily run the app. 
      4.1) resources/schema/States_List_query.sql
      4.2) resources/schema/nationalPark_StateNP.sql
      4.3) resources/schema/Demo.sql
   5) Use the following credentials in the login page: vlopez@test.com/123456

Once the project runs, open a new browser and point the url to: http://localhost:8010/login and make sure you follow below steps
Create a new user and make sure after a new user is created, the web site redirects to the Login page
Log in using the newly created credentials
To add a national park visit, go to the site top menu and select National Park Menu option and then select Add visit
Select the state, pick a national park as well as the dates of the visit, after this info is selected by the user, then a visit can be added and the visit will be associated to the user
To check the newly added visit click on the Home top menu option and the new visit will be displayed there
Due to the scope of the project, there is no functionality implemented related to uploading images for a given visit, however, to verify this functionality the images can be added manually to the database and drop these images in the static/img project folder to get an idea of how the images are displayed to a specific national park visit.

