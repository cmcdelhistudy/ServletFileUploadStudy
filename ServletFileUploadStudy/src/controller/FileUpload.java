package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItemStream;

/**
 * 
 * @author user
 */
public class FileUpload {

	public static boolean processFile(String path, FileItemStream item,
			String value) {
		try {
			File f = new File(path + File.separator + "images");
			if (!f.exists()) {
				f.mkdir();
			}
			File savedFile = new File(f.getAbsolutePath() + File.separator
					+ value + item.getName());

			FileOutputStream fos = new FileOutputStream(savedFile);
			InputStream is = item.openStream();
			int x = 0;
			byte[] b = new byte[1024];
			while ((x = is.read(b)) != -1) {
				fos.write(b, 0, x);
			}

			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
