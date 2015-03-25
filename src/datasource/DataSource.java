package datasource;

import finalproject.ThreadRunner;

import java.util.ArrayList;

/**
 
 * This is an interface of data source.
 */
public interface DataSource {
    public abstract ArrayList<ThreadRunner> getRunners();

}
