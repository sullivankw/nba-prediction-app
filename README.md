# nba-prediction-app
Leveraging some publicly available player ratings metrics, strength of schedule, and injury reports to predict nba outcomes 

In progress with limited features and not fully tested. Currently only useful to search player and team data and compare potential matchups manually. A basic use case between, for example, the Suns vs Clippers would be to query for each team's top 10 players that have a status AVAILABLE, sum up the metric of choice, ie WAR, and compare.  

Steps to use:
1. D/L the source code. You can fire it off from an IDE or package it as a jar and run
2. Load all the current data by hitting the url: http://localhost:8080/win-totals/ratings/load
3. Since no UI exists, you must search via queries at http://localhost:8080/win-totals/h2-      console. Use the below connection settings...
JDBC URL: jdbc:h2:mem:testdb
          username: sa
          password: (leave blank)
