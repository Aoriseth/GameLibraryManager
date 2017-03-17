class Parallel_executer extends Thread {

    //global variables
    private final int tasknumber;
    private final MainMenuController CommanderMenu;
    private final GameScanner CommanderScanner;

    //methods
    public Parallel_executer(MainMenuController Commander, int tasknumber) {
        this.tasknumber = tasknumber;
        CommanderMenu = Commander;
        CommanderScanner = null;
        Thread th = new Thread(this, "Executor" + tasknumber);
        th.start();
    }

    public Parallel_executer(GameScanner Commander, int tasknumber) {
        this.tasknumber = tasknumber;
        CommanderMenu = null;
        CommanderScanner = Commander;
        Thread th = new Thread(this, "Executor" + tasknumber);
        th.start();
    }

    public void run() {
        if (CommanderMenu != null)
            CommanderMenu.task(tasknumber);

        if (CommanderScanner != null)
            CommanderScanner.task(tasknumber);
    }
}
