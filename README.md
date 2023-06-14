# assignment2-render
Assignment 2 README:
Website URL: https://two76-assignment-two.onrender.com/users/mainPage
Website and Features Description:
Simple User Database that uses a PSQL database to store values through render.

Values Stored & Displayed on the table:
UID
Name
Password
GPA
Height(cm)
Weight(kg)
Favourite Colour
Instagram Account

Table: Striped table that goes from white to grey rows with a table header that is black with white characters.

4 Buttons:
Lone Button:
Blue Add New User Button: Redirects user to a form where they can fill out the details for their new user. Located at the bottom of the table.

Three buttons in every user row corresponding to the respective user:
Yellow View User Button: Allows the user to view any added users and displays all of their information with a visualizer
that uses the user's height as the height of their unique rectangle, their weight as the width of the rectangle and their 
favourite colour as the background colour of the rectangle. It also displays the user's name in the middle of the rectangle.

Green Edit User Button: Redirects the user to a form with the current information of the user that they chose to edit already 
filled out for them to edit.

Red Remove User Button: Deletes the user from the database when pressed.

Error Checking:
UID: Not allowed to be modified or defined by user.
Name: Can be any string value.
Password: Can be any string value.
GPA: Must be a numerical value lower than 4.33 (sfu GPA maximum).
Height: Must be between 0cm and 300cm.
Weight: Must be between 0kg and 500kg.
Favourite Colour: Can be inputted as any string but was mentioned by the prof that we will only be tested with valid colours.
Instagram Account: Can be any string value.
All Inputs Not Filled Out: Results in the red error message displayed at the bottom and the user cannot submit the form until
all values are filled out on the form.

Error Message:
Red box displayed at the bottom of the form displaying the error in the inputs until it is corrected.

Pre-Added Users:
3 Users are pre-added UIDs: 28, 29, 35
