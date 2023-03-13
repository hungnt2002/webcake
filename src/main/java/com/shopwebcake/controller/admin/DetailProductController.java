package com.shopwebcake.controller.admin;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopwebcake.model.Cake;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.service.impl.CategoryService;

@WebServlet("/detail-cake")
public class DetailProductController extends HttpServlet {
    CakeService cakeService = new CakeService();
	CategoryService cateService = new CategoryService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String id =  req.getParameter("idProduct");
		// Cake cake = cakeService.get(Integer.parseInt(id));
		// req.setAttribute("cake", cake);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-product.jsp");
		dispatcher.forward(req, resp);
	}
}
