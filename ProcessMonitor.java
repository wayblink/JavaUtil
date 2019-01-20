import java.lang.management.*;
import java.util.HashMap;
import java.util.Map;

public class ProcessMonitor {

  private static ProcessMonitor instance = new ProcessMonitor();

  private OperatingSystemMXBean osMxBean;
  private ThreadMXBean threadBean;
  private MemoryMXBean memBean;
  private RuntimeMXBean runtimeBean;
  private long preTime = System.nanoTime();
  private long preUsedTime = 0;

  private ProcessMonitor() {
    osMxBean = ManagementFactory.getOperatingSystemMXBean();
    threadBean = ManagementFactory.getThreadMXBean();
    memBean = ManagementFactory.getMemoryMXBean();
    runtimeBean = ManagementFactory.getRuntimeMXBean();
  }

  public static ProcessMonitor getInstance() {
    return instance;
  }

  public double getProcessCpu() {
    long totalTime = 0;
    for (long id : threadBean.getAllThreadIds()) {
      totalTime += threadBean.getThreadCpuTime(id);
    }
    long curtime = System.nanoTime();
    long usedTime = totalTime - preUsedTime;
    long totalPassedTime = curtime - preTime;
    preTime = curtime;
    preUsedTime = totalTime;
    return (((double) usedTime) / totalPassedTime / osMxBean.getAvailableProcessors()) * 100;
  }

  public String getProcessMem() {
    Map<String, String> memoryMap = new HashMap<>();
    MemoryUsage memHeapUsage = memBean.getHeapMemoryUsage();
    MemoryUsage nonHeapUsage = memBean.getNonHeapMemoryUsage();
    memoryMap.put("heapMax", String.valueOf(memHeapUsage.getMax()));
    memoryMap.put("heapUsed", String.valueOf(memHeapUsage.getUsed()));
    memoryMap.put("nonHeapMax", String.valueOf(nonHeapUsage.getMax()));
    memoryMap.put("nonHeapUsed", String.valueOf(nonHeapUsage.getUsed()));
    return memoryMap.toString();
  }

  public String getProcessPid() {
    String name = runtimeBean.getName();
    return name.split("@")[0];
  }

  public int getProcessThreadCount() {
    return threadBean.getThreadCount();
  }

  public static class TestThread extends Thread{
    public void run(){
      while (true) {
        long bac = 1000000;
        bac = bac >> 1;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    while (true) {
      Thread.sleep(5000);
      System.out.println(ProcessMonitor.getInstance().getProcessCpu());
      System.out.println(ProcessMonitor.getInstance().getProcessMem());
      System.out.println(ProcessMonitor.getInstance().getProcessPid());
      System.out.println(ProcessMonitor.getInstance().getProcessThreadCount());
      TestThread thread = new TestThread();
      thread.start();
    }
  }
}
