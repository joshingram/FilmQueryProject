<body>
<H1>Film Query Project</H1>

<h2>Description:</h2>
<hr>
<p>This is a Java based command line program for interacting with a local SQL database. The database simulates the records of a video rental store chain with tables covering staff, customers, films, inventory, stores, etc.  Upon launch, the program asks the user if they wish to search for a film based on its ID number, conduct a keyword search or exit.  Based on the user's selection, the film or matching films will be retrieved from the database and displayed.  The user can then look for another film or exit.</p>

<h4>Stretch Goals Implemented:</h4>
<p>Goal 1:
When a film is displayed, the user can choose from a submenu whether to:<br>
a. Return to the main menu.<br>
b. View all film details - they will see all column values of the film record(s) they chose.

Goal 2:
When viewing film details, the user will see a list of all the films' categories (Family, Comedy, etc.) for the film.  This required JOINing three tables.  

Goal 3:
When viewing film details, the user will see a list of all copies of the film in inventory, with their condition.  This required creating an inventory class (in addition to the Actor and Film classes) and populating it from the database.

<h2>Lessons Learned:</h2>
<hr>
This is my first project to include a database.  I learned about making selections both directly from the unix terminal and through Java.  I also learned about SQL Injection and how to use prepared statements as a means to prevent SQL Injection.    

<h4>Technologies Used:</h4>
Java, Eclipse, git/gitHub, mySQL, MAMP, Maven, unix terminal, Atom, Zoom, Slack, and HTML 

<h4>Java Tools Used:</h4>
DatabaseAccessor, prepared statements, Connection, drivers, result sets, getters/setters, exceptions, try/catch, for each/while loops, @Overrides, array lists, Scanner, invoking methods, passing arguments to methods, implementing interfaces, constructors, imports, switch, iterator

<h4>SQL Tools Used:</h4>
SELECT, FROM, JOIN/ON, WHERE
</body>
