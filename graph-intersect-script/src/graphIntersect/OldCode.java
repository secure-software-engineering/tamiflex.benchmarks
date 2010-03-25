package graphIntersect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import probe.CallGraph;
import probe.GXLWriter;
import static graphIntersect.CLTool.*;

public class OldCode {

//	private static void generate_graphs_for(String benchmark) throws Throwable {
//		outputwriter.write("\nBenchmark: " +  benchmark + '\n');
//
//		String small = basedir + "/" + benchmark + "-" + "small" + "/CallGraph.gxl";
//		String _default = basedir + "/" + benchmark + "-" + "default" + "/CallGraph.gxl";
//		String large = basedir + "/" + benchmark + "-" + "large" + "/CallGraph.gxl";
//
//		compareTwoGraphs(small, _default, targetdir + "/" + benchmark+"-"+"small"+"-"+"default"+".gxl");
//		compareTwoGraphs(no_bench, small, targetdir + "/" + benchmark+"-"+"no_bench"+"-"+"small"+".gxl");
//		compareTwoGraphs(no_bench, _default, targetdir + "/" + benchmark+"-"+"no_bench"+"-"+"default"+".gxl");
//		compareThreeGraphs(small, _default, no_bench, targetdir + "/" + benchmark + "-total_intersection"+".gxl");
//
//		if (new File(large).exists()) {
//			compareTwoGraphs(large, _default, targetdir + "/" + benchmark+"-"+"large"+"-"+"default"+".gxl");
//			compareTwoGraphs(small, large, targetdir + "/" + benchmark+"-"+"small"+"-"+"large"+".gxl");
//			compareTwoGraphs(no_bench, large, targetdir + "/" + benchmark+"-"+"no_bench"+"-"+"large"+".gxl");
//			compareThreeGraphs(small, _default, large, targetdir + "/" + benchmark + "-total_intersection"+".gxl");
//			compareThreeGraphs(no_bench, _default, large, targetdir + "/" + benchmark + "-total_intersection"+".gxl");
//			compareThreeGraphs(small, no_bench, large, targetdir + "/" + benchmark + "-total_intersection"+".gxl");
//			compareFourGraphs(small, _default, large, no_bench, targetdir + "/" + benchmark + "-total_intersection"+".gxl");
//		}
//	}
//	
//	static void compareTwoGraphs(String firstFile, String secondFile, String outputfile) throws IOException {
//		CallGraph intersection = readCallGraph(firstFile);
//		System.out.println(firstFile + " edges: " + intersection.edges().size());
//		if (writeSummaries) outputwriter.write(firstFile + " edges: " + intersection.edges().size() + '\n');
//
//		CallGraph right_graph = readCallGraph(secondFile);
//		System.out.println(secondFile + " edges: " + right_graph.edges().size());
//		if (writeSummaries) outputwriter.write(secondFile + " edges: " + right_graph.edges().size() + '\n');
//
//		intersection.edges().retainAll(right_graph.edges());
//		int common_methods = intersection.edges().size();
//		System.out.println("Intersection: " + common_methods);
//		if (writeSummaries) outputwriter.write("Intersection: " + common_methods + '\n');
//
//		if (writeBigFiles) {
//			GXLWriter writer = new GXLWriter();
//			writer.write(intersection, new FileOutputStream(outputfile));
//
//		}
//
//
//	}
//
//	static void compareThreeGraphs(String firstFile, String secondFile, String thirdFile, String outputfile) throws IOException {
//		CallGraph intersection = readCallGraph(firstFile);
//		System.out.println(firstFile + " edges: " + intersection.edges().size());
//		if (writeSummaries) outputwriter.write(firstFile + " edges: " + intersection.edges().size() + '\n');
//
//		CallGraph second_graph = readCallGraph(secondFile);
//		System.out.println(secondFile + " edges: " + second_graph.edges().size());
//		if (writeSummaries) outputwriter.write(secondFile + " edges: " + second_graph.edges().size() + '\n');
//
//		CallGraph third_graph = readCallGraph(thirdFile);
//		System.out.println(thirdFile + " edges: " + third_graph.edges().size());
//		if (writeSummaries) outputwriter.write(thirdFile + " edges: " + third_graph.edges().size() + '\n');
//
//
//		intersection.edges().retainAll(second_graph.edges());
//		intersection.edges().retainAll(third_graph.edges());
//
//		int common_methods = intersection.edges().size();
//		System.out.println("Intersection: " +  common_methods);
//		if (writeSummaries) outputwriter.write("Intersection: " +  common_methods + '\n');
//
//		if (writeBigFiles) {
//			GXLWriter writer = new GXLWriter();
//			writer.write(intersection, new FileOutputStream(outputfile));
//
//		}
//	}
//
//	static void compareFourGraphs(String firstFile, String secondFile, String thirdFile, String fourthFile, String outputfile) throws IOException {
//		CallGraph intersection = readCallGraph(firstFile);
//		System.out.println(firstFile + " edges: " + intersection.edges().size());
//		if (writeSummaries) outputwriter.write(firstFile + " edges: " + intersection.edges().size() + '\n');
//
//		CallGraph second_graph = readCallGraph(secondFile);
//		System.out.println(secondFile + " edges: " + second_graph.edges().size());
//		if (writeSummaries) outputwriter.write(secondFile + " edges: " + second_graph.edges().size() + '\n');
//
//		CallGraph third_graph = readCallGraph(thirdFile);
//		System.out.println(thirdFile + " edges: " + third_graph.edges().size());
//		if (writeSummaries) outputwriter.write(thirdFile + " edges: " + third_graph.edges().size() + '\n');
//
//		CallGraph fourth_graph = readCallGraph(fourthFile);
//		System.out.println(fourthFile + " edges: " + fourth_graph.edges().size());
//		if (writeSummaries) outputwriter.write(fourthFile + " edges: " + fourth_graph.edges().size() + '\n');
//
//
//		intersection.edges().retainAll(second_graph.edges());
//		intersection.edges().retainAll(third_graph.edges());
//		intersection.edges().retainAll(fourth_graph.edges());
//
//		int common_methods = intersection.edges().size();
//		System.out.println("Intersection: " +  common_methods);
//		if (writeSummaries) outputwriter.write("Intersection: " +  common_methods + '\n');
//
//		if (writeBigFiles) {
//			GXLWriter writer = new GXLWriter();
//			writer.write(intersection, new FileOutputStream(outputfile));
//
//		}
//	}
}