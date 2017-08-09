Restaurant Booking System
===================

This is a simple restaurant table booking web application. Based on an imagined scenario when somebody woudl like to have a Table Reservation Online.

> **Note:**
> The main goal of this project was to improve my Java skills, with web technologies. 
> Please note not every functions are working at this state.
The application has a web based user interface, where the user can request the booking off tabble of his choice. The user can choose in which City, and in wich Restaurant he wants to make a Booking, and choose a Date. 
After that he gets a list with the already booked tables, to give some help with the unavailable bookings. After that user shoudl pick a table number, a time of the booking, the duration, and for how many people he wants to make a reservation. If the users request isnt collides with another reservation in the database, the user shoudl get an acknowledgement message, otherwise an error message.



##### <i class="icon-folder-open"></i> folder contents

I used gradle to separate my code into different sub projects, based on their funcions, and content

| folder    | content | tests|MVC   |
| :------- | ----: | :---: | :---: |
| restaurantBooking-api | POJO-s and Interfaces | no|  model |
| restaurantBooking-jdbc    | DAO and connector classe  | yes Junit  | - |
| restaurantBooking-main    | simply a main class with few demos    | no | - |
| restaurantBooking-service    | DAOmanager | no | 
| restaurantBooking-servlet   | Servlets | no | control |
| restaurantBooking-servlet/src/main/webapp/WEB-INF/views | .jsp files for the user interface | - | view |
| sqlSrcipts | scripts for the db in MySql | - | - |

> **Note:**
> Keep in mind that I add new functions and technologies as I improving the project, so the functional specifications changing all the time during development.

***Summary:***

Language: Sql, Java, Html, Javascript, JSP

Framework/API: JDBC, Junit, Servlets, HTML5

IDE/Tools:  Netbeans, Gradle, MySql Workbench

***Contact:***
<i class="icon-mail"></i> andras.banszki@gmail.com
