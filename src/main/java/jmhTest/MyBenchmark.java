package jmhTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Warmup;

public class MyBenchmark {

	 	@Benchmark
	    @BenchmarkMode(Mode.Throughput)
	    @OutputTimeUnit(TimeUnit.SECONDS)
	 	@Warmup(iterations=10)
	    @Measurement(iterations=10)
	 	@Fork(value=1)
	    public void for_int_i(){
	 			ArrayList<Integer> list = new ArrayList<Integer>();
	 			for(int i=0;i<20000;i++){
	 				list.add(i);
	 			}
	 			int len = list.size();
	 			for(int i=0;i<len;i++){
	 				int value=list.get(i);
	 			}
	    }

	    @Benchmark
	    @BenchmarkMode(Mode.Throughput)
	    @OutputTimeUnit(TimeUnit.SECONDS)
	    @Warmup(iterations=10)
	    @Measurement(iterations=10)
	    @Fork(value=1)
	    public void lambdaForeach(){
		    	ArrayList<Integer> list = new ArrayList<Integer>();
	 			for(int i=0;i<20000;i++){
	 				list.add(i);
	 			}
	 			
	 			int len=0;
	 			list.forEach(v->{
	 				int value=v; 
	 				System.out.println(len);
	 			});
	    }
	    
	    
	    public static void main(String[] args) {
	    	ArrayList<Integer> list = new ArrayList<Integer>();
 			for(int i=0;i<100;i++){
 				list.add(i);
 			}
 			
 			int sum=0;
 			list.forEach((value) -> {
 				System.out.println(sum);
 			});
 			System.out.println(sum);
		}
	    
	    
}
