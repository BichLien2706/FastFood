package com.thanhhc.controller;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thanhhc.model.Cart;
import com.thanhhc.model.CartItem;
import com.thanhhc.model.Product;
import com.thanhhc.model.User;
import com.thanhhc.service.ProductService;
import com.thanhhc.service.impl.ProductServiceImpl;
import com.thanhhc.dao.impl.CartDaoImpl;
import com.thanhhc.dao.impl.CartItemDaoImpl;

@WebServlet(urlPatterns = { "/member/cart/add" }) // ?pId=123
public class CartAddController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");
		String quantity= req.getParameter("quantity");
		Product product = productService.get(Integer.parseInt(pId));
		CartItem cartItem = new CartItem();
		HttpSession httpSession = req.getSession();
		User user = (User)httpSession.getAttribute("account");
		cartItem.setCat(Integer.parseInt(req.getParameter("cate")));
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);
		cartItem.setU_id(user.getId());
		//Object obj = httpSession.getAttribute("cart");
		CartItemDaoImpl insert1 = new CartItemDaoImpl();
		insert1.insert(cartItem);
		List<CartItem> ALLcarts = insert1.getAll();
		List<CartItem> cartsOfUser = new ArrayList<CartItem>();
		for (CartItem c : ALLcarts) {
			if(c.getU_id() == user.getId()) {
				cartsOfUser.add(c);
			}
		}
		
		httpSession.setAttribute("cart", cartsOfUser);
//		if (obj == null) {
////			Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
////			map.put(cartItem.getProduct().getId(), cartItem);
////			httpSession.setAttribute("cart", map);
//			Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
//            map.put(product.getId(), cartItem);
//            httpSession.setAttribute("cart", map);
//		} else {
//			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;
////
////			CartItem existedCartItem = map.get(Integer.valueOf(pId));
//			 CartItem existedCartItem = map.get(product.getId());
//
//
//			if (existedCartItem == null) {
//				map.put(product.getId(), cartItem);
//			} else {
//				existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
//			}
//
//			httpSession.setAttribute("Cart", map);
//		}
//		
//	
//		
////		  if (obj != null) { CartItem cartItem1 = new CartItem();
////		  cartItem1.setProduct(product); cartItem1.setQuantity(1);
////		  cartItem1.setUnitPrice(product.getPrice());
////		  
////		  Map<Integer, CartItem> map = new HashMap<Integer, CartItem>(); // Su dung map de luu va tim kiem nhanh hon 
////		  map.put(cartItem1.getProduct().getId(),
////		  cartItem1);
////		  
////		  httpSession.setAttribute("Cart", map);// luu vao session
////		  
////		  } else {
////		  
////		  Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj; 
////		  CartItem cartItem1 = map.get(product.getId()); // 1: Chua co san pham trong gio hang 
////		  if
////		  (cartItem1 == null) { CartItem cartItems = new CartItem();
////		  cartItems.setProduct(product); cartItems.setQuantity(1);
////		  cartItems.setUnitPrice(product.getPrice());
////		  
////		  // Su dung map de luu va tim kiem nhanh hon
////		  map.put(cartItems.getProduct().getId(), cartItems);
////		  
////		  httpSession.setAttribute("cart", map);// luu vao session 
////		  } else { // Truong hop da co roi 
////			  cartItem.setQuantity(1 + cartItem.getQuantity());
////		  
////		  httpSession.setAttribute("cart", map); }
		 
		resp.sendRedirect(req.getContextPath() + "/member/cart");
	}
}
