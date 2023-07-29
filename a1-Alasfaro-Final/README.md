# A1 - Piraten Karpen

  * Author: Omar Al-Asfar
  * Email: alasfaro@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery (includes Fortune cards):
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To activate trace mode:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar trace`
    * `mvn -q exec:java -Dexec.args="trace"`
  * To activate random player:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar random`
  * To activate combo player:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar combo`
  * To activate random combo competition
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar random combo`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * Feature meets functionality and quality standards after being tested by stakeholders. 
   * It should also be capable of being integrated with other features without issue.

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll eight dice |  D | 01/01/23 | 01/10/23 |
| x   | F02 | end of game with three cranes | D | 01/10/23 | 01/10/23 |
| x   | F03 | Player keeping random dice at their turn and randomly re-roll until end of turn | D | 01/10/23 | 01/11/23 |
| x   | F04 | Score points by multiplying number of gold coins and diamonds by 100 | D | 01/10/23 | 01/10/23 |
| x   | F05 | Select how many games as command-line arg. (default: 42 always played)  |  D  |  01/19/23 | 01/11/23 |
| x   | F06 | Simulate two players competing with the same strategy | D | 01/19/23 | 01/21/23 |
| x   | F07 | Print win percentage of each player by end of simulation | D | 01/19/23 | 01/21/23 |
| x   | F08 | Score points by getting combinations of rolls | D | 01/25/23 | 01/27/23 |
| x   | F09 | Use command line arguments to specify strategies | D | 01/28/23 | 01/29/23 |
| x   | F10 | Draw Sea Battle Fortune card to gain or lose points depending on rolls | D | 01/28/23 | 01/29/23 |
| x   | F11 | Draw Monkey Business Fortune card to make combos with parrots and monkey faces | D | 01/28/23 | 01/29/23 |
| ... | ... | ... |

