package com.thanhhc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.thanhhc.dao.impl.UserDaoImpl;
import com.thanhhc.model.User;
import com.thanhhc.service.UserService;
import com.thanhhc.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/member/myaccount" })
public class MyAccountController extends HttpServlet {
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/myaccount.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = "";
		User user = new User();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					id = item.getString();
					user.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("email")) {
					user.setEmail(item.getString());
				} else if (item.getFieldName().equals("username")) {
					user.setUsername(item.getString());
				} else if (item.getFieldName().equals("password")) {
					user.setPassword(item.getString());
				} else if (item.getFieldName().equals("role")) {
					user.setRoleId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("dateOfBirth")) {
					String dateString = item.getString();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date dateOfBirth = sdf.parse(dateString);
					user.setDateOfBirth(dateOfBirth);
				} else if (item.getFieldName().equals("address")) {
				    user.setAddress(item.getString());
				}else if (item.getFieldName().equals("avatar")) {
				    if (item.getSize() > 0) {
				        final String dir = "E:";
				        String originalFileName = item.getName();
				        int index = originalFileName.lastIndexOf(".");
				        String ext = originalFileName.substring(index + 1);
				        String fileName = System.currentTimeMillis() + "." + ext;
				        File file = new File(dir + "\\" + fileName);
				        item.write(file);
				        
				        user.setAvatar(fileName);
				    } else {
				        user.setAvatar("null");
				    }
				}
			}
			UserDaoImpl ur = new UserDaoImpl();
			req.getSession().setAttribute("test", user.getDateOfBirth());
			ur.edit(user);
			User u = userService.get(Integer.parseInt(id));
			HttpSession session = req.getSession(true);
			 session.setAttribute("account", u);

			resp.sendRedirect(req.getContextPath() + "/member/myaccount");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/member/myaccount");
			req.getSession().setAttribute("test2", "nooooo");
		}

	}
}
