package com.thanhhc.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.thanhhc.model.Category;
import com.thanhhc.model.User;
import com.thanhhc.service.CategoryService;
import com.thanhhc.service.UserService;
import com.thanhhc.service.impl.CategoryServiceImpl;
import com.thanhhc.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryeDeleteController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		cateService.delete(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}

}
