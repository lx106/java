package test;

/**
 * @author liuxun
 * Date: 2020/3/10
 * Description:
 * jifo -flag 具体参数 具体java进程
 * jinfo -flag MetaspaceSize 999
 *
 * jinfo -flags
 *
 */
public class Test {

    /**
     * -XX:InitialHeapSize=266338304 = -Xms
     * -XX:MaxHeapSize=4253024256= -Xmx000MB
     * java -XX:+PrintFlagsInitial 查询所有JVM 初始化参数
     */
    public static void main(String[] args){

//        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        while (true){

        }
//        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);

    }

    /**
     * jinfo -flags 13244
     Attaching to process ID 13244, please wait...
     Debugger attached successfully.
     Server compiler detected.
     JVM version is 25.231-b11
     Non-default VM flags: -XX:CICompilerCount=3 -XX:InitialHeapSize=266338304 -XX:MaxHeapSize=4253024256 -XX:MaxNewSize=1417674752 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=88604672
     -XX:OldSize=177733632 -XX:+PrintGCDetails -XX:+UseCompressedClassPointers -XX:+UseCompressedOo
     ps -XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     Command line:  -XX:+PrintGCDetails -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.2.5\lib\idea_rt.jar=62049:C:\Program Files\JetBrains\IntelliJ IDEA 2017.2.5\bin -Dfile.encoding=UTF-8

     */
}
