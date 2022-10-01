<body style="background-color:lightblue">
<H1>Film Query Project</H1>

<h3>Description:</h3>
<hr>
<p>This is a Java based command line program for interacting with a local SQL database. The database simulates the records of a video rental store chain with tables covering staff, customers, films, inventory, stores, etc.  Upon launch, the program asks the user if they wish to search for a film based on its ID number, conduct a keyword search or exit.  Based on the user's selection, the film or matching films will be retrieved from the database and displayed.  The user can then look for another film or exit.</p>

<h4>Stretch Goals Implemented:</h4>
<p>Goal 1:
When a film is displayed, the user can choose from a submenu whether to:<br>
a. Return to the main menu.<br>
b. View all film details.<br>
If they choose to view all details, they will see all column values of the film record they chose.

Goal 2:
When viewing film details, the user will see a list of all the films' categories (Family, Comedy, etc.) for the film.  This required <span style="color:blue;">JOIN</span>ing three tables.  

Goal 3:
When viewing film details, the user will see a list of all copies of the film in inventory, with their condition.  This required creating an inventory class (in addition to the Actor and Film classes) and populating it from the database.</p>

<h3>Lessons Learned:</h3>
<hr>
This is my first project to include a database.  I learned about making <span style="color:blue;">selections</span> both directly from the terminal and through Java.  

<h4>Technologies Used:</h4>
Java, Eclipse, git/gitHub, mySQL, Mac terminal, Zoom, Slack, and HTML for this ReadME

<h4>Java Tools Used:</h4>
DatabaseAccessor, prepared statements, Connection, drivers, result sets, getters/setters, exceptions, try/catch, for/for each/while loops, @Overrides, array lists, Scanner, invoking methods, passing arguments to methods, implementing interfaces, constructors, imports, switch, iterator

<h4>SQL Tools Used:</h4>
<font color="blue">SELECT, FROM, JOIN/ON, WHERE</font>
</body>
