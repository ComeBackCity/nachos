package nachos.threads;

import javafx.scene.layout.Priority;
import nachos.ag.BoatGrader;
import nachos.machine.*;

import java.util.Random;
import java.util.StringJoiner;

/**
 * A multi-threaded OS kernel.
 */
public class ThreadedKernel extends Kernel {
    /**
     * Allocate a new multi-threaded kernel.
     */
    public ThreadedKernel() {
        super();
    }

    /**
     * Initialize this kernel. Creates a scheduler, the first thread, and an
     * alarm, and enables interrupts. Creates a file system if necessary.
     */
    public void initialize(String[] args) {
        // set scheduler
        String schedulerName = Config.getString("ThreadedKernel.scheduler");
        scheduler = (Scheduler) Lib.constructObject(schedulerName);

        // set fileSystem
        String fileSystemName = Config.getString("ThreadedKernel.fileSystem");
        if (fileSystemName != null)
            fileSystem = (FileSystem) Lib.constructObject(fileSystemName);
        else if (Machine.stubFileSystem() != null)
            fileSystem = Machine.stubFileSystem();
        else
            fileSystem = null;

        // start threading
        new KThread(null);

        alarm = new Alarm();

        Machine.interrupt().enable();
    }

    /**
     * Test this kernel. Test the <tt>KThread</tt>, <tt>Semaphore</tt>,
     * <tt>SynchList</tt>, and <tt>ElevatorBank</tt> classes. Note that the
     * autograder never calls this method, so it is safe to put additional
     * tests here.
     */
    public void selfTest() {
        long seed;
        seed = random.nextLong();
//        seed = 6836154031344819769l;
//        seed = 6543525100317173545l;
//        seed = 4909084219636744825l;
//        seed = -1858323208807266227l; // 10, 10
//        seed = -2014348969010379264l; // 2, 2
//        seed = -108121132699258408l; // 1, 2
//        seed = 8383159614660730322l; // for Cond2 test
//        seed = -6444553281654560242l;
//        seed = -3954020395626546001l;
//        seed = -7316380266559853960l;
//        seed = -7316380266559853960l;

        random.setSeed(seed);
        System.err.printf("Random seed = %d\n", seed);
//        UniversalSchedulerTest.selfTest();
//        Lib.debug('X', String.format("Random seed = %d", seed));
//        PriorityTest.selfTest();
//        PriorityTest.selfTest3();
//        PriorityTest.selfTest4();
//          PriorityTest.selfTest5();
//        Alarm.selfTest();
//        CommunicatorTest.selfTest();
//        Boat.selfTest();
//        KThread.selfTest();
//        Semaphore.selfTest();
//        SynchList.selfTest();
//        if (Machine.bank() != null) {
//            ElevatorBank.selfTest();
//        }
    }

    /**
     * A threaded kernel does not run user programs, so this method does
     * nothing.
     */
    public void run() {
    }

    /**
     * Terminate this kernel. Never returns.
     */
    public void terminate() {
        Machine.halt();
    }

    /**
     * Globally accessible reference to the scheduler.
     */
    public static Scheduler scheduler = null;
    /**
     * Globally accessible reference to the alarm.
     */
    public static Alarm alarm = null;
    /**
     * Globally accessible reference to the file system.
     */
    public static FileSystem fileSystem = null;

    // dummy variables to make javac smarter
    private static RoundRobinScheduler dummy1 = null;
    private static PriorityScheduler dummy2 = null;
    private static LotteryScheduler dummy3 = null;
    private static Condition2 dummy4 = null;
    private static Communicator dummy5 = null;
    private static Rider dummy6 = null;
    private static ElevatorController dummy7 = null;

    public static Random random = new Random();
}
