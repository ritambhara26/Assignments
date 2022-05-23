# Assignments

(Use Loggers to display the logs for below exercise)
1. Create a spring batch application to read data from csv and write it into DB, also do some basic validation such that it should ignore some data based on some condition for e.g.(if student mark is <45 ignore those records or employee salary is <25000 then ignore those records base on your scenarios).
2. Create a spring batch application to read data from DB and write it into csv. also do some basic validation such that it should ignore some data based on some condition.
3. Create a spring batch application to read data from xml and write it into db. also do some basic validation such that it should ignore some data based on some condition.
4. Create a spring batch application to read data from DB and write it into xml. also do some basic validation such that it should ignore some data based on some condition.
5. Create a spring batch application to read data from txt and write it into db. also do some basic validation such that it should ignore some data based on some condition. (optional)
6. Create a spring batch application to read data from DB and write it into txt. also do some basic validation such that it should ignore some data based on some condition. (optional)
7. Create a spring batch application which reads 2 csv input files say current and previous. Create a delta file (if current and previous has same data ignore those data take only the unique records from the Current file) and in processor do some validation for e.g., (student’s percentage if greater than 50% then it should be in success file and less than 50% then it should be rejected) along with the reject message. The output will be 2 csv files success and reject csv with reject reason.
8. Create a rest service which calls data base retrieve a value and send the response back as    XML and JSON. Test the same using post man.
