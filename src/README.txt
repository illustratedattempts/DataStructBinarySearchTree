CS 3345.004 – Data Structures and Introduction to Algorithmic Analysis S22
Thanh Vo
ttv170230

Project Submission:
Project 2

Code Environment:
Developed and Compiled in IntelliJ

Included Files:
LazyBinarySearchTree.java
Reader.java

Documentation:
    • LazyBinarySearchTree.java 
        ◦ There exists an ERROR_HOLDER String that will hold ALL of the argument based errors that methods with arguments such as insert, delete, and contains may output for inputs less than 1 or greater than 99.
        ◦ Methods insert, delete, contains, toString, height and size have accompanying methods that facilitate its operation, they are respectively the following:
            ▪ [insert] → nodeInsert
            ▪ [delete] → nodeDeletion
            ▪ [contains] → containsNode
            ▪ [toString] → preorderTraversal
            ▪ [height] → findHeight
            ▪ [size] → findSize
        ◦ In general, findMax, findMin, and the previously stated companion (accompanying) methods are all recursively implemented.
        ◦ For methods that take in argument inputs, there is the use of the keyword throws for Exception IllegalArgumentException. These methods catch that exception and change the ERROR_HOLDER String for main class’(Reader) use.
    • Reader.java
        ◦ BufferedReader and BufferedWriter are assigned both to the command line arguments (args[0] and args[1]).
        ◦ For methods with arguments such as Insert:, Delete:, and Contains: it will first check if the String ERROR_HOLDER is empty. Equivalently checking if there are known errors after the method call. Then, it will clear that String if it was non-empty.
        ◦ To be a little more stringent with matching, for commands that have arguments, they may contain the command and the colon afterwards. There is a warning that for methods that intentionally call Insert:____(not an integer) it will output IllegalArgumentException unchecked/unhandled.
        ◦ Otherwise, methods with no arguments that do not precisely match the command itself will be given an Error statement.
        ◦ Additionally, for methods that require a capital ‘T’ or ‘F’ in true or false such as those with arguments will have it first initially evaluated for their value and then written out as “True” or “False” to the output file as designated in the Project 2 instructions.

