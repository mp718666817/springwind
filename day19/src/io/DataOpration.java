package io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOpration {

	public static void main(String[] args) throws IOException {
		File f1 = new File("a.ini");
		if (!f1.exists()) {
			f1.createNewFile();
		}
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f1));
		out.writeInt(20);
		out.writeBoolean(true);
		out.writeChar('h');
		Object object =  new Object();
	}

}
