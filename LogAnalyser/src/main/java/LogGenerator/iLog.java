package LogGenerator;

public interface iLog {

    // 3 levels {0 = Information, 1 = Warning , 2 = Error}
    public int getLevel();

    // System id will be 0 in these examples
    public int getSystemID();

    // The number of an instance, can follow the log for a specifik instance using this number
    public int getInstanceID();

    // What action was taken
    // { 0 = Login , 1 = List items , 2 = edit item , 3 = logout }
    public int getActionID();

    // Time of the log / action
    public long getTimeStamp();

    // Print the log to console (just for testing purposes)
    public void printLog();
}
