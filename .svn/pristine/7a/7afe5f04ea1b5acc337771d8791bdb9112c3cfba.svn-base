package com.java1234.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.java1234.entity.Result;
import com.java1234.util.DateUtil;
import com.java1234.util.FileUtil;
import com.java1234.util.QRcodeUtil;
import com.java1234.util.ResponseUtil;



@Controller
@RequestMapping("/qrcode")
public class QRcodeController {
	/**
	 * /qrcode/create
	 * @param content
	 * @param size
	 * @param requset
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/create")
	public String getQRCode(@RequestParam(value = "content", required = false) String content,
			HttpServletRequest requset, HttpServletResponse response) throws Exception {
		// User currentUser = (User)  tv
		// SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		
		// 生成二维码QRCode图片
		BufferedImage bufImg = QRcodeUtil.qRCodeCommon(content, "jpg", QRcodeUtil.getSize(content));
		// 保存到电脑
		String fileName = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS");
		String path = requset.getSession().getServletContext().getRealPath("");
		String file_path = "/static/images/QRcode/";
		
		path = path +file_path ;
		FileUtil.makeDirs(path);
		try {
			// 把img存到服务器上面。 返回地址给对面
			ImageIO.write(bufImg, "jpg", new File(path + fileName + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(file_path+fileName + ".jpg");
		Gson gson = new Gson();
		ResponseUtil.write(response, gson.toJson(result));
		// ImageIO.write(bufImg, "jpg", response.getOutputStream());
		return null;
	}
	
}
