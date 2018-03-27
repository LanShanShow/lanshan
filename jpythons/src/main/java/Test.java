import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class Test {
	public static void main(String[] args) {
		String file = "F:\\lanshan\\jpythons\\src\\main\\resources\\test.py";
		System.out.println("-----------------直接执行python");//
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("w=('a','b','v','e')");
		interpreter.exec("print w[2]");

		System.out.println("-----------------执行python文件+传参");

		interpreter.execfile(file);
		PyFunction pyFunction = interpreter.get("adder", PyFunction.class);

		int a = 1999;
		int b = 2008;
		PyObject pyObject = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
		System.err.println(pyObject.toString());
		System.out.println("-----------------命令行方式执行python文件+参数");
		try {
			String c = "aa", d = "bb";
			args = new String[] { "python", file, c, d };
			Process pr = Runtime.getRuntime().exec(args);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				// line = decodeUnicode(line);
				System.out.println(line);
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------命令行方式执行python文件");
		try {

			Process pr = Runtime.getRuntime().exec(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				// line = decodeUnicode(line);
				System.out.println(line);
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------java-python 互相调用-用处不多");
		String scriptFile = "file";
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("name", "Demo");
		ExePython.instance.execute("F:\\lanshan\\jpythons\\src\\main\\resources\\testName.py", properties);
		ExePython.instance.execute(scriptFile, properties);
	}
}
