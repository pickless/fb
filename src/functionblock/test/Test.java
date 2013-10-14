package functionblock.test;

import java.io.File;

import com.nomagic.magicdraw.ui.ImageIconProxy;

public class Test {
	public static void main(String[] args) {
		System.out.println(new File("test1.txt").exists());
		System.out.println(new File("src/functionblock/icons/functionblockdiagram.svg").exists());
		System.out.println(new ImageIconProxy(Test.class, "src/functionblock/icons/functionblock.gif", "") == null);
	}

}
