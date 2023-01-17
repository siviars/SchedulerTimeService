# SchedulerTimeService

This application contain a scheduler service that runs at the time(s) specified in Spring Boot configuration file.
In each scheduler run cycle data loads from the CSV file . Data will be parsed and determine action be done at the current time in Lagos, Africa. Bitmask will be representing days of the week when the action should be made. 
CSV file containing 2 columns:<br>
time - a time in the HH:MM format specifying time when the action shoud be executed<br>
bitmask - a bitmask specified in numeric format.<br>
