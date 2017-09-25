package com.hdsx.hmglyh.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.MediasMapper;
import com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model.Medias;
/**
 * 
 * @author jason
 *
 */
/* @WebServlet("/up") */
public class JcFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = -87359407476316883L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JcFileUploadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("文件上传开始 ...");
		/*
		 * String savePath = this.getServletConfig().getServletContext()
		 * .getRealPath(""); savePath = savePath + "/uploads/";
		 */
		String code = request.getParameter("code");
//		String xzqh = request.getParameter("xzqh");
		String savePath1 = this.getServletContext().getInitParameter(
				"uploadPath1");
		String picUrl = this.getServletContext().getInitParameter("picUrl2");
		if (savePath1 == null)
			savePath1 = "D:\\upload\\jcimg/";
		File f1 = new File(savePath1);
		System.out.println(savePath1);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List fileList = null;
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return;
		}
		Iterator<FileItem> it = fileList.iterator();
		String name = "";
		String extName = "";
		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				name = item.getName();
				long size = item.getSize();
				String type = item.getContentType();
				System.out.println(size + " " + type);
				if (name == null || name.trim().equals("")) {
					continue;
				}
				// 扩展名格式：
				if (name.lastIndexOf(".") >= 0) {
					extName = name.substring(name.lastIndexOf("."));
				}
				File file = null;
				do {
					// 生成文件名：
					name = UUID.randomUUID().toString();
					file = new File(savePath1 + name + extName);
				} while (file.exists());
				File saveFile = new File(savePath1 + name + extName);
				try {
					item.write(saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		String id = code;

		MediasMapper mMapper = (MediasMapper) SpringContextUtil
				.getBean("mediasMapper");

		Medias media = mMapper.selectByKey(id);

		if (media != null) {
			String zpdz = media.getZpdz();
			System.out.println(savePath1 + zpdz);
			File f = new File(savePath1 + zpdz);
			if (f.exists()) {
				f.delete();
			}
			mMapper.deleteByKey(id);
		}

		Medias m = new Medias();
		m.setId(id);
		m.setZpdz(name + extName);
		int c = mMapper.insertSelective(m);
		if (c > 0) {
			System.out.println("修改照片 在数据库中修改成功");
		}

		// 直接拼字符串 写会去
		String jsonStr = "{\"rname\":\"" + name + extName + "\",\"picUrl\":\""+ picUrl + "\"}";
		response.getWriter().print(jsonStr);

	}

}
