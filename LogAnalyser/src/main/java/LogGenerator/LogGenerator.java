package LogGenerator;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class LogGenerator {
    private int amoutOfInstances;
    private int maxAmountOfLogsPerInstance;


    private final List<State> states = new ArrayList<>();
    private final State[][] table;
    private final State initialState;


    private State[] trackEachInstanceState;
    private int nextInstanceToStart = 0;



    public LogGenerator(int amoutOfInstances, int maxAmountOfLogsPerInstance) {
        states.add(initialState = new State(0, false));
        trackEachInstanceState = new State[amoutOfInstances];
        // Make the 4 states that the program can do.
        for (int index = 1; index < 4; index++) {
            if (index == 3) states.add(new State(index, true));
            else states.add(new State(index, false));
        }
        table = new State[states.size()][4];
        this.amoutOfInstances = amoutOfInstances;
        this.maxAmountOfLogsPerInstance = maxAmountOfLogsPerInstance;
    }

    public Log getNextLog () {
        Log log = new Log(100,100,100,100,100);
        if (nextInstanceToStart == amoutOfInstances) {
            System.out.println("all instances started");

        }
        //find or start a new instance
        Random rand = new Random();
        // if 1 start a new instance if 2 continue a current instance

        if (nextInstanceToStart < amoutOfInstances || nextInstanceToStart == 0) {
            int choise = rand.nextInt(2);

            if (choise == 0 || nextInstanceToStart == 0) {
                //start a new instance
                log = startNewInstance(nextInstanceToStart++);
            } else if (choise == 1) {
                // while random state is not done
                System.out.println("does this happen");
                int number = rand.nextInt(nextInstanceToStart);
                while (trackEachInstanceState[number].isFinal()) {
                    number = rand.nextInt(nextInstanceToStart);
                }
                log = nextState(number);
            }
        }
        else {
            int number = rand.nextInt(nextInstanceToStart);
            while (trackEachInstanceState[number].isFinal()) {
                number = rand.nextInt(nextInstanceToStart);
            }
            log = nextState(number);
        }

        //advance the state of that instance
        //Write a loop that finds an active or not startede instance and ask for a next state
        // should never happen, but system wants it
        return log;
    }

    // Make a method that generates a random next state for an instance
     public Log nextState(int instanceNr){
        Random rand = new Random();
        //What should we do
         // 0-74 action 1 find item
         // 75-149 action 2 edit item
         // 150 - 199 action 3 Logout
        int choise = rand.nextInt(200);
        if ( 75 >choise){
            //user wants to find an item
            trackEachInstanceState[instanceNr] = new State(1, false);
            return new Log(0,0,instanceNr,1,System.currentTimeMillis());
        }
        else if ( 150 > choise ){
            //user wants to find an item
            trackEachInstanceState[instanceNr] = new State(2, false);
            return new Log(0,0,instanceNr,2,System.currentTimeMillis());
        }
        else {
            System.out.println("this is done");
            trackEachInstanceState[instanceNr] = new State(3, true);
            return new Log(0,0,instanceNr,3,System.currentTimeMillis());
        }
     }


     public Log startNewInstance (int instanceNr){
         trackEachInstanceState[instanceNr] = new State(0, false);

         // 0 informative , 0 systemID , instanceNr , 0 actionId (login) , timestame

         return new Log(0,0,instanceNr,0,System.currentTimeMillis());
     }
}
