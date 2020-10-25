package LogGenerator;

public class Log implements iLog{
    private int level;
    private int systemId;
    private int instanceId;
    private int actionId;
    private long timestamp;

    public Log(int level, int systemId, int instanceId, int actionId, long timestamp) {
        this.level = level;
        this.systemId = systemId;
        this.instanceId = instanceId;
        this.actionId = actionId;
        this.timestamp = timestamp;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getSystemID() {
        return 0;
    }

    @Override
    public int getInstanceID() {
        return 0;
    }

    @Override
    public int getActionID() {
        return 0;
    }

    @Override
    public long getTimeStamp() {
        return 0;
    }

    @Override
    public void printLog() {
        System.out.println("----------");
        System.out.println("Log");
        System.out.println("----------");
        System.out.println("Level : " + level);
        System.out.println("System Id : " + systemId);
        System.out.println("Instance Id : " + instanceId);
        System.out.println("Action Id : " +actionId );
        System.out.println("Timestamp : " + timestamp);
        System.out.println("----------");
    }
}
