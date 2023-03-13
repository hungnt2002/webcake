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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopwebcake.model.Cake;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.service.impl.CategoryService;

@WebServlet("/add-product")
public class AddProductController extends HttpServlet {
	CakeService cakeService = new CakeService();
	CategoryService cateService = new CategoryService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String id = req.getParameter("idProduct");
		// Cake cake = cakeService.get(Integer.parseInt(id));
		// req.setAttribute("cake", cake);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		String thongbao = "";
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem item : items) {
					if (!item.isFormField()) {
						String fileName = item.getName();
						File uploadDir = new File("template/client/images");
						if (!uploadDir.exists()) {
							uploadDir.mkdir();
						}
						File file = new File(uploadDir + File.separator + fileName);
						item.write(file);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else{
			req.setAttribute(thongbao, "Chưa thêm ảnh");
			return;
		}

		String nameCake = req.getParameter("name");
		String price = req.getParameter("price");
		String content = req.getParameter("content");
		String categoryId = req.getParameter("categoryId");
		String thumnail = req.getParameter("image");
		System.out.println(nameCake);
		System.out.println(content);
		System.out.println(thumnail);
		// System.out.println(Long.parseLong(price));
		Cake cake = new Cake();
		cake.setCakeName(nameCake);
		// cake.setPrice(Long.parseLong(price));
		cake.setContent(content);
		cake.setThumbnail(thumnail);
		CakeService cakeService = new CakeService();
		cakeService.insert(cake);
		req.setAttribute(thongbao, "Thêm sản phẩm thành công");
		resp.sendRedirect(req.getContextPath() + "/add-product");
	}
}
