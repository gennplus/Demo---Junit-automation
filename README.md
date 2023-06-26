# cisco_tasks
Tasks for TI to Cisco.

### What has been done:
Task 1 (Remove central element from singly linked list with O(n) complexity):
- Implemented class SinglyLinkedList with Node as nested class and removeCentralElement() method.
- Implemented service functions in class SinglyLinkedList.
- Implemented tests on service methods and they are grouped in a smoke test suite.
- Implemented tests on removeCentralElement() method and they are grouped in a full test suite.

Task 2 (Print array if it has a target (integer) from the list of four elements arrays):
- Implemented findArray() method.
- Implemented parameterized positive and negative tests.

For both (for demonstration purposes):
- in the pom.xml file add ability to run tests from console using command <code>mvn test</code>.
- implemented GitHub Actions workflows, for Task 1 workflow consists of two sequential steps, smoke and full tests.
  If smoke tests are failed, the full test would not run.

### How to run tests:
Please use GitHub Actions in order to run a pipeline for test execution.

Task 1: 
Click Actions -> Run tests for Task 1 workflow -> Open dropdown Run workflow -> Click Run workflow.\
After a few moments or page refresh you should see a new workflow running.\
Inside workflow you should see a two step pipeline, first step is smoke_test, second is full_test which are running smoke and full suites respectively.\
Under the pipeline schema you can see test results.

Task 2:
Click Actions -> Run tests for Task 2 workflow -> Open dropdown Run workflow -> Click Run workflow.\
Same as task one, except pipeline schema - all tests for task 2 are in one job.

### Tools used: 
- Java
- JUnit
- Maven
- Surefire plugin
- GitHub Actions pipeline
- Third part pipeline test reporter
