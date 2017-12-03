# MediCloud

A CS Database Project where we try to digitize the bridge
and interactions between doctors and patients.
Android application and PHP backend on Xampp and Heliohost


DevLog----------------------------------------------------

#Update 1
xampp and phpmyadmin is used to create a dummy database
only the patient and doctor relations were made
(check the schema to verify if all ok)
and have exported the .sql file that came out of it
the schemeas are still under consideration
(notify for any changes needed)

#Update 2
database creation has been completed along with schema and
work on android frontend has begun
activities created for main login screen
methods implemented for UI interactions

#Update 3
background thread methods written to handle remote connections
SQLi login queries and PHP files written to operate & echo info
single echo sends patient info and login state as toast

#Update 3
PHP queries for registration operations added
background task updated with register task
inserts to accounts and patient relations

#Update 4
Android UI revamped to look nicer
minor tweaks to handle user input error
uploaded database to Heliohost and 
edited front end code for remote http connections

#Update 5
new android activity made for patient start screen
login php edited with JSON echo so app can receive info
patient start screen properly displays user info
dummy buttons added

#Update 6
dummy get docter button implemented
background task updated with list doctor operation
written PHP query to return a 2D array having multiple tuples
echo as JSON array and app loops through array
app should receive JSON as JSONarray but error is thrown

#Update 7
JSONarray error fixed
multiple rows received properly
loop editted to go through JSONobject gotten after JSONarray
