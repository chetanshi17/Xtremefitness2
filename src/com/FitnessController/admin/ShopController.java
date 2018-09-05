package com.FitnessController.admin;




	import java.io.IOException;
	import java.io.OutputStream;
	import java.sql.Blob;
	import java.sql.SQLException;
	import java.util.Map;

	import javax.servlet.http.HttpServletResponse;

	import com.FitnessController.admin.shopDAO;
	import com.FitnessController.admin.shopdbadmin;

	import org.apache.commons.io.IOUtils;
	import org.hibernate.Hibernate;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.MultipartFile;

	@Controller
	public class ShopController {
 
		@Autowired
		private shopDAO shopDao;
		
		@RequestMapping("/index")
		public String index(Map<String, Object> map) {
			try {
				map.put("document", new shopdbadmin());
				map.put("documentList", shopDao.list());
			}catch(Exception e) {
				e.printStackTrace();
			}

			return "shop";
		}

		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(
				@ModelAttribute("shop") shopdbadmin shopad,
				@RequestParam("file") MultipartFile file) {
			
			
			System.out.println("Name:" + shopad.getName());
			System.out.println("Desc:" + shopad.getDescription());
			System.out.println("File:" + file.getName());
			System.out.println("ContentType:" + file.getContentType());
			
			try {
				Blob blob = Hibernate.createBlob(file.getInputStream());

				shopad.setFilename(file.getOriginalFilename());
				shopad.setContent(blob);
				shopad.setContentType(file.getContentType());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				shopDao.save(shopad);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/index.html";
		}

		@RequestMapping("/download/{productId}")
		public String download(@PathVariable("productId")
				Integer documentId, HttpServletResponse response) {
			
			shopdbadmin doc = shopDao.get(productId);
			try {
				response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
				OutputStream out = response.getOutputStream();
				response.setContentType(doc.getContentType());
				IOUtils.copy(doc.getContent().getBinaryStream(), out);
				out.flush();
				out.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return null;
		}

		@RequestMapping("/remove/{documentId}")
		public String remove(@PathVariable("documentId")
				Integer documentId) {
			
			documentDao.remove(documentId);
			
			return "redirect:/index.html";
		}
	}