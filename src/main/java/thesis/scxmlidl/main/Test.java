package thesis.scxmlidl.main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import thesis.scxmlidl.antlr.WebIDLLexer;
import thesis.scxmlidl.antlr.WebIDLParser;
import thesis.scxmlidl.transpiler.IdlToCplusplus;
import thesis.scxmlidl.transpiler.IdlToJava;
import thesis.scxmlidl.transpiler.IdlToLua;
import thesis.scxmlidl.utils.Util;

public class Test {
	public static void main(String[] args) throws Exception {
		
//		System.out.println("test");
		int index;
		
        Util u = new Util();
		final File folder = new File("webIDL");
       ArrayList<String> webIDL = u.listFilesForFolder(folder);
       for (index = 0; index < webIDL.size(); ++index)
       {
//    	   System.out.println("generate source for "+webIDL.get(index));
           generateSource(webIDL.get(index));
       }
       

	}
	
	 public static void generateSource(String webidl) throws Exception{

		String inputFile = null;
			inputFile = webidl;
		InputStream is = System.in;
		if (inputFile != null)
			is = new FileInputStream(inputFile);
		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(is);
		// create a lexer that feeds off of input CharStream
		WebIDLLexer lexer = new WebIDLLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		WebIDLParser parser = new WebIDLParser(tokens);
		ParseTree tree = parser.webIDL(); // begin parsing at webIDL rule
		// System.out.println(tree.toStringTree(parser)); // print LISP-style
		// tree
		// System.out.println(tree.getText());

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
//		System.out.println("Current relative path is: " + s);
		File temp = Paths.get(".").toAbsolutePath().normalize().toFile();
//		System.out.println(System.getProperty("user.dir"));

		Util u = new Util();
        
		u.createFolder("Generated Source");


		// Conversions
		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		// Walk the tree created during the parse, trigger callbacks

		u.createFolder("Generated Source/java");
		walker.walk(new IdlToJava(), tree);
//		System.out.println("Now C Plus Plus");
		u.createFolder("Generated Source/c++");
		walker.walk(new IdlToCplusplus(), tree);
		System.out.println(); // print a \n after translation
//		System.out.println("Now Lua");
		u.createFolder("Generated Source/lua");
		walker.walk(new IdlToLua(), tree);
//		System.out.println(); // print a \n after translation

	}
	
	
}
