package com.thanhhc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanhhc.model.Product;
import com.thanhhc.service.CategoryService;
import com.thanhhc.service.ProductService;
import com.thanhhc.service.impl.CategoryServiceImpl;
import com.thanhhc.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		List<Product> proList = productService.getAll();
		System.out.println(proList.get(0));
		req.setAttribute("proList", proList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-product.jsp");
		dispatcher.forward(req, resp);
	}

}
