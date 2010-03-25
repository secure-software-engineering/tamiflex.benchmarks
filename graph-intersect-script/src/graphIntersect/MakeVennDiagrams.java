package graphIntersect;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class MakeVennDiagrams {

	private int[] perBenchmarkList;
	private String benchmark;

	protected MakeVennDiagrams(int[] perBenchmarkList, String benchmark) {
		this.perBenchmarkList = perBenchmarkList;
		this.benchmark = benchmark;
	}

	public void run() throws IOException {
		Formatter formatter = new Formatter(new FileWriter("/home/jan/reflection/reflection-paper/Figures/venn-" + benchmark + ".tex"));
		if (CLTool.has_large(benchmark)) {
			formatter.format(TEXT_FOR_SUBFIGURE, 
					//					perBenchmarkList[1],
					//					perBenchmarkList[2],
					//					perBenchmarkList[5],
					//					perBenchmarkList[3],
					//					perBenchmarkList[10],
					//					perBenchmarkList[4],
					//					perBenchmarkList[7],
					//					perBenchmarkList[11],
					//					perBenchmarkList[8],
					//					perBenchmarkList[6],
					//					perBenchmarkList[15],
					//					perBenchmarkList[9],
					//					perBenchmarkList[14],
					//					perBenchmarkList[13],
					//					perBenchmarkList[12]);
					perBenchmarkList[8],
					perBenchmarkList[4],
					perBenchmarkList[10],
					perBenchmarkList[12],
					perBenchmarkList[5],
					perBenchmarkList[2],
					perBenchmarkList[14],
					perBenchmarkList[13],
					perBenchmarkList[1],
					perBenchmarkList[6],
					perBenchmarkList[15],
					perBenchmarkList[9],
					perBenchmarkList[7],
					perBenchmarkList[11],
					perBenchmarkList[3]);
		}
		else {
			formatter.format(THREE_ELEMENT_VENN_TEXT, 
					perBenchmarkList[4],
					perBenchmarkList[6],
					perBenchmarkList[5],
					perBenchmarkList[7],
					perBenchmarkList[2],
					perBenchmarkList[3],
					perBenchmarkList[1]);
		}
		formatter.close();
	}

	public static final String TEXT_FOR_SUBFIGURE =
		"\\begin{tikzpicture}[scale=.85]\n" + 
		"\\begin{scope} [semitransparent]\n" + 
		"\\draw[rotate=45,fill=black!70] \\VennJP;\n" + 
		"\\draw[rotate=315,fill=black!45] \\VennCSt;\n" + 
		"\n" + 
		"\\begin{scope}\n" + 
		"\\clip[rotate=45] \\VennJP;\n" + 
		"\\end{scope}\n" + 
		"\n" + 
		"\\draw[rotate=45,fill=black!25] \\VennAJ;\n" + 
		"\\draw[rotate=315,fill=black!10] \\VennCS;\n" + 
		"\n" + 
		"\\draw[rotate=45] \\VennAJ;\n" + 
		"\\draw[rotate=315] \\VennCS;\n" + 
		"\n" + 
		"\\draw[rotate=45] \\VennJP;\n" + 
		"\\draw[rotate=315] \\VennCSt;\n" + 
		"\\end{scope}	" +
		"\n" + 
		"	\\node[fill=white,shape=circle,inner sep=2pt] at (-1.5cm, 1.7cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (1.5cm, 1.7cm) {%d} ;\n" + 
		"\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (-2.0cm, 0.8cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (0cm, 1.18cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (2.0cm, 0.8cm) {%d} ;\n" + 
		"\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (-2.8cm, 0cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (-1.1cm, 0cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (1.1cm, 0cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (2.8cm, 0cm) {%d} ;\n" + 
		"\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (-1.8cm, -1.4cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (0cm, -1.2cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (1.8cm, -1.4cm) {%d} ;\n" + 
		"\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (-0.82cm,-2.05cm) {%d} ;\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (0.82cm, -2.05cm) {%d} ;\n" + 
		"\n" + 
		"\\node[fill=white,shape=circle,inner sep=2pt] at (0cm, -2.9cm) {%d} ;\n" + 
		"\n" + 
		"\\node[fill=black!10] at (3.5, -3.2) {no\\_bm} ;\n" + 
		"\\node[fill=white,inner sep=2pt] at (3.5, -3.2) {no\\_bm} ;\n" + 
		"\n" + 
		"\\node[fill=black!25] at (-3.53, -3.2) {small} ;\n" + 
		"\\node[fill=white,inner sep=2pt] at (-3.5, -3.2) {small} ;\n" + 
		"\n" + 
		"\\node[fill=black!45] at (3.5, 1.9) {default} ;\n" + 
		"\\node[fill=white,inner sep=2pt] at (3.5, 1.9) {default} ;\n" + 
		"\n" + 
		"\\node[fill=black!70] at (-3.5, 1.9) {large} ;\n" + 
		"\\node[fill=white,inner sep=2pt] at (-3.5, 1.9) {large} ;" +
		"\n" +
		"\\end{tikzpicture}" +
		"\n"
		;

	public static final String THREE_ELEMENT_VENN_TEXT = 
		"\\def\\firstcircle{(-.8,0) circle (1.5cm)}\n" + 
		"\\def\\secondcircle{(.8,0) circle (1.5cm)}\n" + 
		"\\def\\thirdcircle{(0,1.4) circle (1.5cm)}\n" + 
		"\n" + 
		"\\begin{tikzpicture}[scale=1.15]\n" + 
		"   \n" + 
		"    \\begin{scope}[fill opacity=0.5]\n" + 
		"        \\fill[black!25] \\firstcircle;\n" + 
		"        \\fill[black!10] \\secondcircle;\n" + 
		"        \\fill[black!45] \\thirdcircle;\n" + 
		"        \\draw \\firstcircle;\n" + 
		"        \\draw \\secondcircle;\n" + 
		"        \\draw \\thirdcircle;\n" + 
		"    \\end{scope}\n" + 
		"\n" + 
		"\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (0,2) {%d} ;\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (-.9,1) {%d} ;\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (.9,1) {%d} ;\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (0,.5) {%d} ;\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (-1.37,-.5) {%d} ;\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (0,-.5) {%d} ;\n" + 
		"    \\node[fill=white,shape=circle,inner sep=2pt] at (1.37,-.5) {%d} ;\n" + 
		"\n" + 
		"\n" + 
		"    \\node[fill=black!25] at (-2.8,-0.8) {small} ;\n" + 
		"    \\node[fill=white,inner sep=2pt] at (-2.8,-0.8) {small} ;\n" + 
		"\n" + 
		"    \\node[fill=black!10] at (2.8,-.8) {no\\_bm} ;\n" + 
		"    \\node[fill=white,inner sep=2pt] at (2.8,-.8) {no\\_bm} ;\n" + 
		"\n" + 
		"    \\node[fill=black!40] at (0,3.4) {default} ;\n" + 
		"    \\node[fill=white,inner sep=2pt] at (0,3.4) {default} ;" +
		"\n" + 
		"\n" + 
		"\\end{tikzpicture}\n";
}
