package com.thanhhc.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thanhhc.dao.impl.CartDaoImpl;
import com.thanhhc.dao.impl.CartItemDaoImpl;
import com.thanhhc.model.CartItem;
import com.thanhhc.model.User;

/**
 * Servlet implementation class PayOrder
 */
@WebServlet("/PayOrder")
public class PayOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		CartItemDaoImpl cartItemCT = new CartItemDaoImpl();
		List<CartItem> listCartUserCartItems = (List<CartItem>) httpSession.getAttribute("cart");
		User user = (User)httpSession.getAttribute("account");
		if (listCartUserCartItems.size() > 0) {
			for (CartItem cartItem : listCartUserCartItems) {
				cartItemCT.delete(cartItem.getId());
			}
		}
		
		if(user != null) {
			List<CartItem> ALLcarts = cartItemCT.getAll();
			List<CartItem> cartsOfUser = new ArrayList<CartItem>();
			for (CartItem c : ALLcarts) {
				if(c.getU_id() == user.getId()) {
					cartsOfUser.add(c);
				}
			}
			
			httpSession.setAttribute("cart", cartsOfUser);
			request.setAttribute("THANK_ORDER", "\"THANK FOR YOUR ORDER, LET SEE YOU SOON\"");
		}
		request.getRequestDispatcher("view/client/view/list-cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
