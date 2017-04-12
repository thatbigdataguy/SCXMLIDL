package thesis.scxmlidl.main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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

public class Test2 {
	public static void main(String[] args) throws Exception {
		
		System.out.println("test2");
		int index;

        for (index = 0; index < args.length; ++index)
        {
            System.out.println("args[" + index + "]: " + args[index]);
        }
	

	}
	
	public void generateSource(String args) throws Exception{
		
		System.out.println("test2");
		String inputFile = null;
		//if (args.length > 0)
			inputFile = args;
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
		System.out.println("Current relative path is: " + s);
		File temp = Paths.get(".").toAbsolutePath().normalize().toFile();
		System.out.println(System.getProperty("user.dir"));

		Util u = new Util();
		u.createFolder("Sajjad");
		u.createFile("myoutput.txt");
		u.createFolder("Sajjadi/sajjad");
		u.createFile("myoutputi.txt");

		// Conversions
		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		// Walk the tree created during the parse, trigger callbacks
		u.createFile("java.txt");
		walker.walk(new IdlToJava(), tree);
		System.out.println("Now C Plus Plus");
		u.createFile("C++.txt");
		walker.walk(new IdlToCplusplus(), tree);
		System.out.println(); // print a \n after translation
		System.out.println("Now Lua");
		u.createFile("Lua.txt");
		walker.walk(new IdlToLua(), tree);
		System.out.println(); // print a \n after translation
	}
}
