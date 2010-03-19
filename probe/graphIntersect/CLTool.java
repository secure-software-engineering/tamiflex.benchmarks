package graphIntersect;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import probe.CallEdge;
import probe.CallGraph;
import probe.GXLReader;


public class CLTool {

	static FileWriter outputwriter;

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		new CLTool().run(args);
	}

	public  void run(String[] args) throws Throwable {
		basedir = repodir + "/rechenknecht.cased.de";
		targetdir = repodir + "/ccComparisons";
		no_bench = "/home/jan/reflection/Agent/rechenknecht.cased.de/noBenchmark/CallGraph.gxl";
		outputwriter = new FileWriter("/home/jan/reflection/reflection-paper/Text/venns2.tex");
		
		make_venn_matrices();
		
		outputwriter.close();
	}
	
	/* Verbatim copy from CallGraphDiff */
	
	static CallGraph readCallGraph(String filename) {
		CallGraph ret;
		
		try {
			try {
				ret = new GXLReader().readCallGraph(new FileInputStream(filename));
			} catch( Exception e ) {
				System.out.println(e);
				ret = new GXLReader().readCallGraph(new GZIPInputStream(new FileInputStream(filename)));
			}
		} catch( IOException e ) {
			throw new RuntimeException( "caught IOException "+e+" on file "+filename );
		}
		return ret;
	}
	
	static final String[] benchmarks = {"avrora", "batik", "eclipse", "fop", "h2", "jython", "luindex", "lusearch", "pmd", "sunflow", "tomcat", "xalan"};
	static String repodir = "/home/jan/reflection/Agent";
	
	static String basedir;
	static String targetdir;
	static String no_bench;
	
	static public int[] per_benchmark_list;
	
	private void make_venn_matrices() throws Exception {
		for (String benchmark : benchmarks) {
				make_venn_matrix_for(benchmark);
		}
	}
	
	private void make_venn_matrix_for(String benchmark) throws Exception {
		
		boolean has_large = has_large(benchmark);
		
		per_benchmark_list = new int[17];
		
		String firstFile = basedir + "/" + benchmark + "-" + "small" + "/CallGraph.gxl";
		String secondFile = basedir + "/" + benchmark + "-" + "default" + "/CallGraph.gxl";
		String thirdFile = null;
		if (has_large) thirdFile = basedir + "/" + benchmark + "-" + "large" + "/CallGraph.gxl";
		String fourthFile = no_bench;
		
		CallGraph small = readCallGraph(firstFile);
		CallGraph _default = readCallGraph(secondFile);
		CallGraph large = null;
		if (has_large) large = readCallGraph(thirdFile);
		CallGraph no_bench = readCallGraph(fourthFile);
		CallGraph union = readCallGraph(firstFile);
		union.edges().addAll(_default.edges());
		if (has_large) union.edges().addAll(large.edges());
		union.edges().addAll(no_bench.edges());
		
		for (CallEdge edge : (Set<CallEdge>) union.edges()) {
			int small_contains = small.edges().contains(edge)? 1 : 0;
			int default_contains = _default.edges().contains(edge)? 1 : 0;
			int large_contains = 0;
			if (has_large) large_contains= large.edges().contains(edge)? 1 : 0;
			int no_bench_contains = no_bench.edges().contains(edge)? 1 : 0;
			
			int position = (no_bench_contains + 2 * small_contains + 4 * default_contains + 8 * large_contains);
			
			per_benchmark_list[position]++;
		}
		
//		writeOutTextual(benchmark);
		
		new MakeVennDiagrams(per_benchmark_list, benchmark).run();

	}

	public static boolean has_large(String benchmark) {
		return !benchmark.equalsIgnoreCase("fop") && !benchmark.equalsIgnoreCase("luindex");
	}

	void writeOutTextual(String benchmark) throws IOException {
		outputwriter.write("Edges for " + benchmark);
		
		outputwriter.write("no_bench small default large: "  + per_benchmark_list[15]  +'\n');
		outputwriter.write("________ small default large: "  + per_benchmark_list[14]  +'\n');
		outputwriter.write("no_bench _____ default large: "  + per_benchmark_list[13]  +'\n');
		outputwriter.write("________ _____ default large: "  + per_benchmark_list[12]  +'\n');
		outputwriter.write("no_bench small _______ large: "  + per_benchmark_list[11]  +'\n');
		outputwriter.write("________ small _______ large: "  + per_benchmark_list[10]  +'\n');
		outputwriter.write("no_bench _____ _______ large: "  + per_benchmark_list[9]  +'\n');
		outputwriter.write("________ _____ _______ large: "  + per_benchmark_list[8]  +'\n');
		outputwriter.write("no_bench small default _____: "  + per_benchmark_list[7]  +'\n');
		outputwriter.write("________ small default _____: "  + per_benchmark_list[6]  +'\n');
		outputwriter.write("no_bench _____ default _____: "  + per_benchmark_list[5]  +'\n');
		outputwriter.write("________ _____ default _____: "  + per_benchmark_list[4]  +'\n');
		outputwriter.write("no_bench small _______ _____: "  + per_benchmark_list[3]  +'\n');
		outputwriter.write("________ small _______ _____: "  + per_benchmark_list[2]  +'\n');
		outputwriter.write("no_bench _____ _______ _____: "  + per_benchmark_list[1]  +'\n');
		outputwriter.write("________ _____ _______ _____: "  + per_benchmark_list[0]  +'\n');
	}
}
