<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="FileUploadServlet" method="POST"
		enctype="multipart/form-data">
		Name <input type="text" name="name" value="" /><br> Age <input
			type="text" name="age" value="" /><br> Image <input type="file"
			name="fileupload" value="" /><br> <input type="submit"
			value="submit" />
	</form>

</body>
</html>