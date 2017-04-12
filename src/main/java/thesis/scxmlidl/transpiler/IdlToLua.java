package thesis.scxmlidl.transpiler;

import java.util.ArrayList;

import thesis.scxmlidl.antlr.WebIDLBaseListener;
import thesis.scxmlidl.antlr.WebIDLParser;
import thesis.scxmlidl.utils.Util;

public class IdlToLua extends WebIDLBaseListener {

	String Interfacename;
	ArrayList<String> methods = new ArrayList<String>();

	@Override
	public void enterInterface_(WebIDLParser.Interface_Context ctx) {

		// System.out.print(ctx.getChild(0)+" "+ctx.getChild(1)+" ");
		Interfacename = ctx.getChild(1).toString();
		Util u = new Util();
		u.createFile("lua/"+Interfacename + ".lua");
		System.out.print("local " + ctx.getChild(1) + " " + "=" + "{}");
	}

	@Override
	public void exitInterface_(WebIDLParser.Interface_Context ctx) {

		for (int i = 0; i < methods.size(); i++) {
			System.out.println(Interfacename + "." + methods.get(i) + " = " + " " + methods.get(i));
		}
		System.out.println("\nreturn " + ctx.getChild(1));
	}

	@Override
	public void enterInheritance(WebIDLParser.InheritanceContext ctx) {

		if (ctx.getChildCount() != 0) {
			System.out.printf("implements " + ctx.getChild(1) + " \n");
			// System.out.printf("\\u%04x", 12);
		} else {
			System.out.print("\n");
		}

	}

	@Override
	public void exitInheritance(WebIDLParser.InheritanceContext ctx) {

	}

	@Override
	public void enterAttributeRest(WebIDLParser.AttributeRestContext ctx) {
		System.out.printf("\n");

	}

	@Override
	public void exitAttributeRest(WebIDLParser.AttributeRestContext ctx) {
		// System.out.printf(";");

	}

	@Override
	public void enterAttributeName(WebIDLParser.AttributeNameContext ctx) {
		System.out.printf(" " + ctx.getText() + ";");

	}

	@Override
	public void exitAttributeName(WebIDLParser.AttributeNameContext ctx) {

	}

	@Override
	public void enterFloatType(WebIDLParser.FloatTypeContext ctx) {
		System.out.printf("" + ctx.getText());
	}

	@Override
	public void exitFloatType(WebIDLParser.FloatTypeContext ctx) {
		System.out.printf("");
	}

	@Override
	public void enterReturnType(WebIDLParser.ReturnTypeContext ctx) {
		System.out.printf("local function" + " ");
	}

	@Override
	public void exitReturnType(WebIDLParser.ReturnTypeContext ctx) {
	}

	@Override
	public void enterOptionalIdentifier(WebIDLParser.OptionalIdentifierContext ctx) {
		System.out.printf(ctx.getText() + " ");
		methods.add(ctx.getText().toString());

	}

	@Override
	public void exitOptionalIdentifier(WebIDLParser.OptionalIdentifierContext ctx) {
	}

	@Override
	public void enterOperationRest(WebIDLParser.OperationRestContext ctx) {
	}

	@Override
	public void exitOperationRest(WebIDLParser.OperationRestContext ctx) {
	}

	@Override
	public void enterArgumentName(WebIDLParser.ArgumentNameContext ctx) {
		System.out.printf(ctx.getText() + "");
	}

	@Override
	public void exitArgumentName(WebIDLParser.ArgumentNameContext ctx) {
	}

	@Override
	public void enterNonAnyType(WebIDLParser.NonAnyTypeContext ctx) {
		System.out.printf(" " + ctx.getText() + " ");
	}

	@Override
	public void exitNonAnyType(WebIDLParser.NonAnyTypeContext ctx) {
	}

	@Override
	public void enterArgumentList(WebIDLParser.ArgumentListContext ctx) {
		System.out.printf("(");
	}

	@Override
	public void exitArgumentList(WebIDLParser.ArgumentListContext ctx) {
		System.out.printf(")\n" + "end\n");
	}

	@Override
	public void enterArguments(WebIDLParser.ArgumentsContext ctx) {
		if (ctx.getChildCount() != 0) {
			System.out.printf("" + ctx.getChild(0));
		}

	}

	@Override
	public void exitArguments(WebIDLParser.ArgumentsContext ctx) {
	}

}
