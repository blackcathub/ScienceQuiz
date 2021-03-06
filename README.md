# Science Knowledge Quiz _[ScienceQuiz]_ 
>`PROJECT 4` for Googles Udacity Android Developement Course

4th projct for Android Developement Course is a quiz app that check the users knowledge in a topic of my choice. The app needed to have maximum of 10 questions with answer options including radio buttons, checkboxes and a free text response. There should also be a button programmed to show a popup message (Toast) with the final score and support for landscape mode.
----------------------------
* **_DESIGN IDEA_**

The main idea of my design was to develop a smooth consistent layout with separate activities for welcome screen, main quiz screen and results screen. Welcome screen should have only a few images, enter text field and a start button so the user gets the idea of what's about to start. In quiz screen I placed a welcome header and a short introductory message followed by questions. I focused on making each question appear as a separate box using Card Views to make them easy to read and understand. Each question has a corresponding image, text and 4 nicely spread answers so there's no "missclicking". Also the Action Bar was replaced with a custom one fixed on top of the screen that contains a graphic name of the app and an icon. Result screen is available after checking answers and seeing the customized score popup message. Result screen contains a copy of the users score along with corresponding answer statistics also matching the theme with it's looks. To make use of the new styling features in API21+ I also added a few features for supported devices such as: buttons and checkboxes get a tint matching my theme, clicks are smoothly animated, status bar and navigation bar also get a nice themed tint.

* **_USER EXPERIENCE_**

For a good user experience I mainly focused on performance of the quiz screen that is the biggest and most data-loaded part of the app. Question images are compressed, deep nesting is being avoided keeping the structure as flat as possible and findViewById is used sparingly. This few practises along with hardware Acceleration kept on resulted with nice and smooth scrolling eperience, fluent animations and shadows contributing the neat modern feel. Cards with questions are programmed to indicate correct answers after checking. If there was a mistake background turns to red enabling the user to quickly and easily spot what errors were made. After checking answers they cannot be changed and a button leading to results becomes available. To avoid return button taking user to unwanted places due to activity stack it was overridden on results screen to re-launch the app cleaning up the stack+variables as well as on welcome screen to immediately exit the app with code 0 and stop the process.

* **_LOGIC BEHIND THE SCENES_**

As mentioned back presses were overridden to always take the user back to the place he logically should return to. Not to complicate the code too much the only values passed between the activities are user name and final score, I used Intent Extras to do that. Most of the calculations in reference to counting users score are done after clicking CHECK button. Single choice questions are checked by analysing the correct answer field, multi-choice answers use a complete 4-answer true/false key. All radio buttons and checkboxes get clickable=false attribute after the check is done. RESULT button gets unlocked and a Toast message is shown preceded by a .cancel method run if old one is still on the screen to prevent length stacking. On result screen a simple if checker is used to set statistics image according to the score variable and a SEND button is placed to put name and score in an automatically generated email.

* **_DEMO VIDEO_**
<a href="https://www.youtube.com/watch?v=LqV_0GU0DxE">
<img src="https://img.youtube.com/vi/LqV_0GU0DxE/0.jpg" width="320" height="240">
</a>


* **_SCREENSHOTS_**

<img src="https://cloud.githubusercontent.com/assets/25821037/24006819/17e885ec-0a6d-11e7-9c26-9c59cb40c07a.jpg" align="center" height="420" > <img src="https://cloud.githubusercontent.com/assets/25821037/24006826/1cce6d06-0a6d-11e7-8d8f-47b40eb6daa2.jpg" align="center" height="420" > <img src="https://cloud.githubusercontent.com/assets/25821037/24006829/2116ca48-0a6d-11e7-86cd-bf41bc1d7643.jpg" align="center" height="420" >
<img src="https://cloud.githubusercontent.com/assets/25821037/24006837/2526e636-0a6d-11e7-97cd-455839ebde1c.jpg" align="center" width="420" >
