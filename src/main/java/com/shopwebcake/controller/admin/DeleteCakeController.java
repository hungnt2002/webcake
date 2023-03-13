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

@WebServlet("/admin/delete-cake")
public class DeleteCakeController extends HttpServlet {
    CakeService cakeService = new CakeService();
	CategoryService cateService = new CategoryService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cakeId =  req.getParameter("cakeId");
        CakeService cakeService = new CakeService();
        cakeService.delete(Integer.parseInt(cakeId));
		resp.sendRedirect(req.getContextPath() + "/admin-product-list");
	}
}
