package com.shopwebcake.controller.client;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopwebcake.model.Cake;
import com.shopwebcake.model.Cart;
import com.shopwebcake.model.Item;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.util.CurrencyPrice;

@WebServlet(urlPatterns = { "/add-to-cart" })
public class CartAddController extends HttpServlet {
	CakeService cakeService = new CakeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		CurrencyPrice currencyPrice = new CurrencyPrice();
		String isEdit = req.getParameter("isEdit");
		if (obj == null) {
			HashMap<Integer, Item> hashMapCart = new HashMap<Integer, Item>(); // Nếu giỏ hàng = null thì tạo mới một obj giỏ hàng

			String cakeId = req.getParameter("cakeId");
			String stringQuantity = req.getParameter("quantity"); // Lấy cakeId và quantity từ req

			int quantity = Integer.parseInt(stringQuantity);
			Cake cake = cakeService.get(Integer.parseInt(cakeId)); // Lấy cake từ cakeId
			cake.setCurrencyPrice(cakeService.currencyPrice(cake.getPrice())); // Định dạng tiền tệ
			Item item = new Item();
			item.setQuantity(quantity);
			item.setUnitPrice(quantity * cake.getPrice());

			// Set totalPrice
			long total = 0;
			total = total + item.getUnitPrice();
			Cart cart = new Cart();
			cart.setTotalPrice(total);
			item.setCake(cake);

			// THêm cake vào giỏ hàng
			hashMapCart.put(item.getCake().getCakeId(), item);

			httpSession.setAttribute("quantity", quantity);
			httpSession.setAttribute("cartPrice", cart);
			httpSession.setAttribute("cart", hashMapCart);

			String stringTotal = currencyPrice.curPrice(total);
			httpSession.setAttribute("total", stringTotal); // set thông tin vào session

		} else {
			HashMap<Integer, Item> hashMapCart = (HashMap<Integer, Item>) obj; // Giỏ hàng k null thì cho vào HashMap

			String cakeId = req.getParameter("cakeId");
			String stringQuantity = req.getParameter("quantity");
			System.out.println(stringQuantity);
			int quantity = Integer.parseInt(stringQuantity);
			Cake cake = cakeService.get(Integer.parseInt(cakeId));
			cake.setCurrencyPrice(cakeService.currencyPrice(cake.getPrice()));
			Item item = new Item();
			item.setQuantity(quantity);
			item.setUnitPrice(quantity * cake.getPrice());
			item.setCake(cake);

			Item existedCartItem = hashMapCart.get(Integer.valueOf(cakeId));// Lay item co key la cakeId trong hashMapCart

			// Sửa giỏ hàng
			if (isEdit.equals("true")) {

				existedCartItem.setQuantity(quantity);
				existedCartItem.setUnitPrice(item.getUnitPrice());		
				Cart cart = (Cart) httpSession.getAttribute("cartPrice");
				long totalPrice = cart.getTotalPrice();
				totalPrice = totalPrice + item.getUnitPrice();
				cart.setTotalPrice(totalPrice);
				httpSession.setAttribute("cart", hashMapCart);

				String stringTotal = currencyPrice.curPrice(totalPrice);
				httpSession.setAttribute("total", stringTotal);
				resp.sendRedirect(req.getContextPath() + "/view-cart");
				return;
			}

			// update hashMapCart
			if (existedCartItem == null) {
				hashMapCart.put(item.getCake().getCakeId(), item);
			} else {
				existedCartItem.setQuantity(existedCartItem.getQuantity() + quantity);
				existedCartItem.setUnitPrice(existedCartItem.getUnitPrice() + item.getUnitPrice());
				existedCartItem.setCurrencyPrice(currencyPrice.curPrice(existedCartItem.getUnitPrice()));
			}

			httpSession.setAttribute("cart", hashMapCart); // set hashMapCart vao session

			Cart cart = (Cart) httpSession.getAttribute("cartPrice");
			long totalPrice = cart.getTotalPrice();

			totalPrice = totalPrice + item.getUnitPrice();
			cart.setTotalPrice(totalPrice);
			httpSession.setAttribute("cart", hashMapCart);

			String stringTotal = currencyPrice.curPrice(totalPrice);
			httpSession.setAttribute("total", stringTotal);

		}

		resp.sendRedirect(req.getContextPath());
	}

}