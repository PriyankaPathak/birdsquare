The awesome project that is Bird Square!

BirdSquare

Development Environment Setup

For Mac:

1. Clone the project repository using git.
2. Install HomeBrew
3. Run "brew install gradle"
4. Run “brew install mysql” (Username: root, Password: empty)
5. Run "gradle”

(The default tasks are clean, setupDB , build and idea)
6. The task “gradle setupDB" will setup the birdsquare database. For now it deletes the current database and creates a new one each time we run the command.
   There is a data.csv file that has a list of birds(common-name,scientific-name,family-name,order).The data from the data.csv file is being imported to the bird table everytime setupDB is run.
7. The task “gradle build" will compile and run all tests (unit, IT and functional) and then build a WAR.
8. Run "gradle jettyRun" to deploy using jetty.


For CentOS:

1. Clone the project repository using git.
2. Run “yum install gradle"
3. Run "yum install mysql”
4. Run "gradle”
5. Run "gradle jettyRun" to deploy using jetty.

IntelliJ IDEA Setup

1.	Run "gradle idea" to create the project files
2.	Open the birdsquare.ipr file

Setting Up Jasmine

1. Run "gradle jasmineGenerate" to help you generate the SampleSpec and SampleRunnerFile
2. Run “gradle jasmineRun”



Test Coverage Report:

Used Emma to generate coverage report. It can be found under build/reports/emma/coverage.html

User Stories Can BE FOUND AT THE FOLLOWING LINK:

mingle01.thoughtworks.com/projects/birdsquare


Our Environments

* (go.birdsquare.in) 10.10.4.115 == GO
* (qa.birdsquare.in) 10.10.4.116 == QA
* (showcase.birdsquare.in) 10.10.4.117 == SHOWCASE
* (birdsquare.in, www.birdsquare.in) 10.10.4.118 == PRODUCTION


Extra Notes (Regarding pushing to repository)
Please do "gradle build" before COMMITTING to the git repository.
If the build failed, please DO NOT push your code to the repository as it can break the build in the CI server.

//
sql language;
select * from checkin
join user
on checkin.fbuid=user.id
var user.username = 'ashwin'
  and checkin.date='%2012%';
//