# CS646_Assignment2

CS 646 Android Mobile Application Development

Objectives
Use some basic UI widgets
Use Intents to call other Activities
Handling the Keyboard
Using Fragments
UI Sampler
You will be trying out a number of different UI elements. The combination of elements does not
make much sense as an app, but does give you experience with more UI elements. You do not
need different layouts for landscape and portrait views.
This assignment will have a number of different activities. The first (main) activity contains a
spinner, a button, a list fragment (the same list fragment defined in the List Activity) and an
EditText field. The spinner contains a list of activities one can select. When the user selects the
option and then clicks on the button the selected activity becomes the active activity. The contents
of the text field are sent to the next activity if it is the Keyboard activity. Use descriptive
names in the spinner for your activities. Class names are not meaningful to app users. Each
section below describes an activity that the user can go to.
Time Activity
The time activity shows a time picker. When the user selects a time, display a dialog confirming
the choice. If user confirms the choice then save the time in permanent storage. When the
user restarts the app the time picker should display the last selected time when they first go to
the time activity. When the user goes back to the first (main) activity the time should show it the
EditText field.
Keyboard Activity
This activity's view has three EditText fields. One at the top of the screen, one in the middle of
the screen and one at the bottom of the screen. The top EditText field should contain the text
sent from the first (main) activity. There is also two buttons. One labeled "Hide" and the other
labeled "Back". The "Back" button when tapped goes back to the first (main) activity. Note creating
a new version of the first activity and going to it is not the same as going back to the existing
activity. When the user taps on one of the EditText fields the soft keyboard appears.
When the user taps on the "Hide" button the soft keyboard disappears. One problem with the
soft keyboard is that it can cover up part of the screen. In this case it will hide the field on the
bottom of the screen. You activity should make sure that when the keyboard is shown the keyboard
does not hide a text field or a button.
List Activity
This activity has a list fragment and a back button. The list contains the of countries given below.
The user can select one item in the list. When they select a country they then see a list of
sports. They they can select a sport. When the user taps on the back button the app goes back
to the first (main) activity. The EditText field should contain the selected sport. If the user selects
a country and clicks the back button before selecting a sport the EditText field should contain
the selected country. If they click the back button before selecting a country the EditText
field should contain the text “None Selected”.
Country Sports
India Cricket, Chess, Badminton,
Field Hockey, Football, Tennis,
Gilli-danda, Golf
USA Baseball, Football, Hockey,
Basketball, Soccer, Golf,
Skateboarding
Mexico Football, Boxing, Baseball,
Charreria, Bullfighting,
Basque Pelota
Extra Credit
1. Enable the application icon in the action bar to take the user back to the first (main) activity.
Make sure that the app goes back to the first activity and not create a new instance of the first
activity. If the app is displaying a one of the other activities, that activity needs to be destroyed
when you go back to the first activity.
2. Add items to the Action Bar to allow the user to select which activity to go to.
