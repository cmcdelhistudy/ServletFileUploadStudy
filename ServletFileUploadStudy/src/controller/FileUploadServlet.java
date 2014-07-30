package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		String value = "";

		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		if (isMultiPart) {
			out.println("Yes Multipart data");

			ServletFileUpload upload = new ServletFileUpload();
			try {
				FileItemIterator itr = upload.getItemIterator(request);
				while (itr.hasNext()) {
					FileItemStream fileItemStream = itr.next();

					if (fileItemStream.isFormField()) {
						// do field related work
						String fieldName = fileItemStream.getFieldName();
						InputStream is = fileItemStream.openStream();
						byte[] b = new byte[is.available()];
						is.read(b);
						value = new String(b);
						out.println(fieldName + " : " + value);
					} else {
						String path = getServletContext().getRealPath("/");

						if (FileUpload.processFile(path, fileItemStream, value)) {
							out.println("File Uploaded Successfully");

							// request.setAttribute("imagePath", path
							// + fileItemStream.getName());
							// RequestDispatcher gotoShowPage = request
							// .getRequestDispatcher("showPage.jsp");
							// gotoShowPage.forward(request, response);

						} else {
							out.println("File Uploading failed ");
						}

					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
			}

		} else {
			out.println("No Multipart data");
		}

		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
