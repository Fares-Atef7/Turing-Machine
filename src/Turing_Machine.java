import java.util.Scanner;

public class Turing_Machine {
    static Scanner s = new Scanner(System.in);
    int no_states, no_stringAlphabet, current_Head, Machine_Alphabet;
    char[][] Transition_table = new char[setNo_states() * (setMachine_Alphabet() + setNo_stringAlphabet())][5];
    char[] transition = new char[5];//for the store the row selected transition from Transition table(2d Array)
    char[] tape;//for user input
    char initial_state, current_state, current_symbol, next_state, next_symbol;
    String input;

    public Turing_Machine() {
        input = setInput();// call the method which take the user input
        tape = new char[input.length()];//set the length of input as A size for The tape
    }

    public String setInput() {
        System.out.print("Enter the String:");
        input = s.next();
        input = "#" + input + "#";

        return input;
    }

    public int setNo_states() {
        System.out.print("Enter Number of States:");
        no_states = s.nextInt();
        return no_states;
    }

    public int setNo_stringAlphabet() {
        System.out.print("Enter Number of Alphabets:");
        no_stringAlphabet = s.nextInt();
        return no_stringAlphabet;
    }

    public int setMachine_Alphabet() {
        System.out.print("Enter Number of Machine Alphabets:");
        Machine_Alphabet = s.nextInt();
        return Machine_Alphabet;
    }

    public char setInitial_state() {
        System.out.print("Enter The Initial State:");
        initial_state = s.next().charAt(0);
        return initial_state;
    }

    public int setCurrent_Head() {
        System.out.print("Enter The Initial head position:");
        current_Head = s.nextInt();
        return current_Head;
    }


    public void Action() {
        setInitial_state();
        //put the input into the tape array
        char[] input_char = input.toCharArray();
        for (int i = 0; i < input_char.length; i++) {
            tape[i] = input_char[i];
        }
        setCurrent_Head();
        System.out.println();
        //fill the transition function
        for (int i = 0; i < Transition_table.length; i++) {
            System.out.print("Enter the Transition by spaces between each char:");
            for (int j = 0; j < 5; j++) {
                Transition_table[i][j] = s.next().charAt(0);
            }
        }
        current_symbol = tape[current_Head];//to initialize the start symbol
        current_state = initial_state;//to initialize the start State
        //Now , Search for the two target(current symbol & current state)
        while (true) {
            for (int i = 0; i < Transition_table.length; i++) {
                if (Transition_table[i][0] == current_state && Transition_table[i][1] == current_symbol) {
                    for (int j = 0; j < 5; j++) {//when we found it copy that row (which contain current symbol&state and next symbol&state and the action to the right or left
                        transition[j] = Transition_table[i][j];
                    }
                }
            }
            next_state = transition[2];//change the next state
            current_state = next_state;//make the current state equal to the next state for continue the operation
            next_symbol = transition[3];//change the next symbol
            tape[current_Head] = next_symbol;//change the symbol which head points on it to the next symbol
            //Check for the Action will be made
            if (transition[4] == 'R') {
                next_symbol = tape[++current_Head];
                current_symbol = next_symbol;
                continue;
            } else if (transition[4] == 'L') {
                next_symbol = tape[--current_Head];
                current_symbol = next_symbol;
                continue;
            } else if (transition[4] == 'Y') {
                System.out.println("The language is Accepted");
                System.out.println(tape);
                System.out.println("The head in the " + current_Head + " index of the tape");
                System.exit(1);

            } else if (transition[4] == 'N') {
                System.out.println("The language is Rejected");
                System.exit(1);
            } else {
                System.out.println("There is some Error in the Action");
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        Turing_Machine t = new Turing_Machine();
        t.Action();
    }
}


