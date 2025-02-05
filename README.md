<h1>Web Application with API Integration</h1>
<h2>Project Overview</h2>
This project is a full-stack web application featuring a stock management system with a frontend built using HTML, CSS, JavaScript, and AngularJS, and a backend developed using Java Servlets with MySQL (H2 for testing purposes). The application includes dynamic product loading, interactive UI elements, and API integration.

<h3>Installation and Setup</h3>
Follow these steps to set up and run the project locally.

<h4>1. Clone the Repository</h4>
bash
Copy
Edit
git clone <repository-url>
cd myservers
<h4>2. Configure Environment Variables (For Mac Users)</h4>
Set up the CLASSPATH for the required dependencies by running:

bash
Copy
Edit
export CLASSPATH=$CLASSPATH:/Users/username/Desktop/myservers/h2/h2.jar:/Users/username/Desktop/myservers/gson/gson.jar:/Users/username/Desktop/myservers/jetty/jetty-all.jar:/Users/username/Desktop/myservers/lucene/lucene-core.jar:/Users/username/Desktop/myservers/lucene/lucene-queryparser.jar
Note: Replace username with your actual Mac username in the path.

<h4>3. Start the H2 Database Server</h4>
Navigate to the h2 directory and start the H2 database server:

bash
Copy
Edit
cd /Users/username/Desktop/myservers/h2
java -cp h2.jar org.h2.tools.Server -tcp -pg
If the server starts successfully, you should see the following output:

sql
Copy
Edit
TCP server running at tcp://localhost:9092 (only local connections)
PG server running at pg://localhost:5435 (only local connections)
<h4>4. Deploy or Create the Database</h4>
Option 1: Deploy stock.db
Copy the stock.db file into the database folder inside the h2 directory.
Option 2: Create a Fresh Database
If the database files are not present, compile and run MakeDatabase.java to generate the required database schema and seed initial data.
bash
Copy
Edit
javac MakeDatabase.java
java MakeDatabase
<h4>5. Start the Application Server</h4>
Compile and start the Jetty server by running the following commands:
bash
Copy
Edit
javac MyServer.java
java MyServer
Ensure the server runs on port 40109, as specified in the code.
<h4>6. Access the Application</h4>
Once the server is running, open Google Chrome and navigate to:
bash
Copy
Edit
http://localhost:40109/homepage.html
This will load Screen 1, dynamically displaying the stock products.
<h3>Technologies Used</h3>
<h4>Frontend</h4>
HTML
CSS
JavaScript
AngularJS
<h4>Backend</h4>
Java Servlets (Jetty Server)
MySQL (H2 for testing purposes)
<h4>Database</h4>
H2 Database (Testing)
MySQL (Production-ready)
External API
Unsplash (For fetching product images dynamically)
Tools & Libraries
Jetty Server (Lightweight Java-based web server)
Gson (For JSON parsing)
Lucene (For search functionalities in stock management)
H2 Database (For local storage and testing)


