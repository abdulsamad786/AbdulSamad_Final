package finalproject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * ThreadRunner class implements each runner.
 */
public class ThreadRunner extends Thread
{
    private final String name;
    private final int rest;
    private final int speed;
    private final ArrayList<Observer> observers = new ArrayList<Observer>();
    private final Random random = new Random();
    private int location = 0;


    /**
     * Constructor
     * @param Name the runner's name
     * @param RestPercentage the runner rests based on the percentage
     * @param RunnerSpeed the runner's speed
     */
    public ThreadRunner(String Name, int RestPercentage, int RunnerSpeed) throws Exception
    {
        if (!(0 <= RestPercentage && RestPercentage <= 100))
            throw new Exception("Rest percentage must be between 0 and 100.");

        if (RunnerSpeed < 0)
            throw new Exception("Runner speed must be positive.");

        name = Name;
        rest = RestPercentage;
        speed = RunnerSpeed;
    }


    public void run()
    {
        while( location < 1000 )
        {
            int r = random.nextInt(100);
            if (r > rest)
            {
                location += speed;
            }

            try {
                int sleep = 100;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.err.println("Something is happened in sleeping.");
            }
            notifyObservers();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addObserver( Observer observer )
    {
        observers.add(observer);
    }

    void notifyObservers()
    {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public int getLocation()
    {
        return location;
    }

    public String getRunnerName()
    {
        return name;
    }
}
