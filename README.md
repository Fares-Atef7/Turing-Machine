# Turing Machine Simulator

This is a Java implementation of a Turing Machine simulator. It allows users to define a Turing Machine by specifying states, alphabets, transition rules, and an input string. The simulator processes the input and determines whether it is accepted or rejected.

---

## Features

- Define the number of states, input alphabets, and machine alphabets.
- Input transition rules to define the Turing Machine's behavior.
- Process an input string and determine if it is accepted or rejected.
- Interactive input prompts for ease of use.

---

## Inputs Example: 
- Enter the String: 101
- Enter Number of States: 3
- Enter Number of Alphabets: 2
- Enter Number of Machine Alphabets: 2
- Enter The Initial State: q0
- Enter The Initial head position: 1
- Enter the Transition by spaces between each char: q0 1 q1 1 R
- Enter the Transition by spaces between each char: q1 0 q2 0 L
- Enter the Transition by spaces between each char: q2 # q3 # Y

## OutPut Example: 
- The language is Accepted
- #101#
- The head in the 2 index of the tape

